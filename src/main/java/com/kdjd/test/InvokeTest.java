package com.kdjd.test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class InvokeTest {

    // 测试对象数量
    private static final int TEST_COUNT = 40000;

    public static void main(String[] args) {
        testDirectSet();
        testReflectionSet();
    }

    /**
     * 测试直接设置属性值
     */
    private static void testDirectSet() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < TEST_COUNT; i++) {
            TestObject obj = new TestObject();
            obj.setName("TestName" + i);
            obj.setValue(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("直接设置属性耗时: " + (endTime - startTime) + "ms");
    }

    /**
     * 测试使用反射设置属性值
     */
    private static void testReflectionSet() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < TEST_COUNT; i++) {
            TestObject obj = new TestObject();
            Map<String, Object> properties = new HashMap<>();
            properties.put("name", "TestName" + i);
            properties.put("value", i);
            setProperties(obj, properties);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("反射设置属性耗时: " + (endTime - startTime) + "ms");
    }

    /**
     * 使用反射设置对象属性
     *
     * @param obj        目标对象
     * @param properties 属性映射
     */
    private static <T> void setProperties(T obj, Map<String, Object> properties) {
        if (obj == null || properties == null || properties.isEmpty()) {
            return;
        }

        Class<?> clazz = obj.getClass();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String fieldName = entry.getKey();
            Object value = entry.getValue();

            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(obj, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试用的简单POJO类
     */
    static class TestObject {
        private String name;
        private int value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
