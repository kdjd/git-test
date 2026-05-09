package com.kdjd.poi;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Excel {

    private static final Logger LOGGER = LoggerFactory.getLogger(Excel.class);

    public static void main(String[] args) {

        try {
            // 指定excel文件，创建缓存输入流
            BufferedInputStream inputStream = new BufferedInputStream(Files.newInputStream(Paths.get("D:\\Document\\cdkj\\安置帮教\\安帮行政区划.xlsx")));
            // 直接传入输入流即可，此时excel就已经解析了
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            // 选择要处理的sheet名称
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            String prefix = "insert into t_office_area(shengcode, dishicode, quxiancode, jiedaocode, shengname," +
                    " dishiname, quxianname, jiedaoname) values (";
            String suffix = ");";
            // 迭代遍历sheet剩余的每一行
            int rows = sheet.getPhysicalNumberOfRows();
            List<String> values = new ArrayList<>();
            for (int rowNum = 0; rowNum < rows; rowNum++) {
                if (rowNum > 0) {
                    XSSFRow row = sheet.getRow(rowNum);
                    String a0 = getCellValue(row, 0);
                    String a1 = getCellValue(row, 1);
                    String a2 = getCellValue(row, 2);
                    String a3 = getCellValue(row, 3);
                    String a4 = getCellValue(row, 4);
                    String a5 = getCellValue(row, 5);
                    String a6 = getCellValue(row, 6);
                    String a7 = getCellValue(row, 7);
                    List<String> list = new ArrayList<String>() {{
                        add(a0);
                        add(a1);
                        add(a2);
                        add(a3);
                        add(a4);
                        add(a5);
                        add(a6);
                        add(a7);
                    }};
                    String join = StringUtils.join(list, "','");

                    values.add("'" + join + "'");

                    if (values.size() == 5000) {
                        String sql = prefix + StringUtils.join(values, "),(") + suffix;
                        System.out.println(sql);
                        values = new ArrayList<>();
                    }
                }
            }
            if (CollectionUtils.isNotEmpty(values)) {
                String sql = prefix + StringUtils.join(values, "),(") + suffix;
                System.out.println(sql);
            }

            workbook.close();
            inputStream.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getCellValue(XSSFRow row, int idx) {
        XSSFCell cell = row.getCell(idx);
        if (cell == null) {
            return "";
        } else {
            return cell.getStringCellValue();
        }
    }

}
