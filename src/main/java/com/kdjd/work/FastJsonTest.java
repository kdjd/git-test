package com.kdjd.work;

import com.alibaba.fastjson.JSON;

import java.util.Date;

public class FastJsonTest {

    public static void main(String[] args) {
        //String origin = "{\"rows\":[{\"allowPosition\":null,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":null,\"cdzh\":null,\"correction_num\":-35,\"createTime\":\"2022-04-29 12:52:03\",\"csrq\":\"1975-09-03\",\"dPk\":0,\"departureStatus\":null,\"deptName\":\"湖北省司法厅\",\"deptPk\":100,\"dname\":null,\"existTotal\":7,\"focusman\":0,\"gdjzdmx\":\"\",\"hjszdmx\":\"\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":null,\"jgjb\":\"4\",\"jjzdh\":null,\"jlrq\":null,\"jtzm\":\"\",\"jzlb\":\"02\",\"larq\":null,\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"13666666666\",\"orgPk\":1,\"pjrq\":null,\"pjszh\":null,\"pkId\":21387,\"positionStatus\":null,\"security_num\":0,\"spjgmc\":null,\"sqjzjdjg\":null,\"sqjzjsrq\":\"2022-06-30\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2022-04-29\",\"sqjzrybh\":\"test0002\",\"sqjzryjsrq\":\"2022-04-30\",\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":null,\"xm\":\"唐老鸭\",\"xscf\":null,\"yqtxqx\":\"\",\"zjhm\":\"330922197509034015\",\"zp\":\"/dnCd/cdkj/user/profile/uploadPath/upload/2022/04/29/8d0569b6f06602fbc957c82144ea41ab.jpeg\"},{\"allowPosition\":0,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":null,\"cdzh\":null,\"correction_num\":300,\"createTime\":\"2022-04-28 11:56:06\",\"csrq\":\"1999-04-25\",\"dPk\":0,\"departureStatus\":null,\"deptName\":\"宜昌市司法局/秭归县司法局/秭归县屈原司法所\",\"deptPk\":338,\"dname\":null,\"existTotal\":5,\"focusman\":null,\"gdjzdmx\":\"\",\"hjszdmx\":\"\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":null,\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":null,\"jtzm\":\"背叛国家罪\",\"jzlb\":\"02\",\"larq\":null,\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"13750721528\",\"orgPk\":35,\"pjrq\":null,\"pjszh\":null,\"pkId\":21383,\"positionStatus\":0,\"security_num\":0,\"spjgmc\":null,\"sqjzjdjg\":null,\"sqjzjsrq\":\"2023-05-31\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2022-04-01\",\"sqjzrybh\":\"T43100011\",\"sqjzryjsrq\":\"2022-05-18\",\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":null,\"xm\":\"余阳\",\"xscf\":null,\"yqtxqx\":\"\",\"zjhm\":\"320722198605284577\",\"zp\":\"/dnCd/cdkj/archive/profile/uploadPath/upload/2022/04/26/debbc740410f3c2cef8b7d8ceb2526b7.jpeg\"},{\"allowPosition\":0,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":null,\"cdzh\":null,\"correction_num\":0,\"createTime\":\"2022-04-24 14:46:42\",\"csrq\":\"2006-11-02\",\"dPk\":0,\"departureStatus\":null,\"deptName\":\"宜昌市司法局\",\"deptPk\":336,\"dname\":null,\"existTotal\":5,\"focusman\":null,\"gdjzdmx\":\"\",\"hjszdmx\":\"\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":null,\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":null,\"jtzm\":null,\"jzlb\":null,\"larq\":null,\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"13666666325\",\"orgPk\":34,\"pjrq\":null,\"pjszh\":null,\"pkId\":21377,\"positionStatus\":0,\"security_num\":0,\"spjgmc\":null,\"sqjzjdjg\":null,\"sqjzjsrq\":null,\"sqjzjsrqFmt\":null,\"sqjzksrq\":null,\"sqjzrybh\":\"3213213213\",\"sqjzryjsrq\":null,\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":null,\"xm\":\"唐糖\",\"xscf\":null,\"yqtxqx\":null,\"zjhm\":\"330922196208043511\",\"zp\":\"/dnCd/cdkj/archive/profile/uploadPath/upload/2022/04/26/debbc740410f3c2cef8b7d8ceb2526b7.jpeg\"},{\"allowPosition\":0,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":\"\",\"cdzh\":\"\",\"correction_num\":300,\"createTime\":\"2022-04-20 17:18:56\",\"csrq\":\"2004-02-15\",\"dPk\":0,\"departureStatus\":1,\"deptName\":\"武汉市司法局\",\"deptPk\":101,\"dname\":null,\"existTotal\":8,\"focusman\":0,\"gdjzdmx\":\"北京北京市西城区广安门外街道\",\"hjszdmx\":\"北京北京市西城区广安门外街道\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":\"\",\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":null,\"jtzm\":\"叛逃罪\",\"jzlb\":\"02\",\"larq\":null,\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"15068139912\",\"orgPk\":1,\"pjrq\":\"2022-04-20\",\"pjszh\":\"53\",\"pkId\":21375,\"positionStatus\":0,\"security_num\":0,\"spjgmc\":\"初审机关\",\"sqjzjdjg\":\"决定机关\",\"sqjzjsrq\":\"2023-05-31\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2022-04-20\",\"sqjzrybh\":\"12365447\",\"sqjzryjsrq\":null,\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":\"天津洒肃执子第22号\",\"xm\":\"糖果\",\"xscf\":\"\",\"yqtxqx\":\"\",\"zjhm\":\"330903198509153618\",\"zp\":\"/dnCd/cdkj/archive/profile/2022/04/21/79C7C97214CFBE8370941D1E24ECB83D.png\"},{\"allowPosition\":null,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":\"\",\"cdzh\":\"\",\"correction_num\":-104,\"createTime\":\"2022-04-07 16:59:47\",\"csrq\":null,\"dPk\":0,\"departureStatus\":null,\"deptName\":\"湖北省司法厅\",\"deptPk\":100,\"dname\":null,\"existTotal\":6,\"focusman\":0,\"gdjzdmx\":\"\",\"hjszdmx\":\"\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":\"\",\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":null,\"jtzm\":\"背叛国家罪\",\"jzlb\":\"02\",\"larq\":null,\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"15835138761\",\"orgPk\":1,\"pjrq\":\"2022-04-15\",\"pjszh\":\"6632\",\"pkId\":21372,\"positionStatus\":null,\"security_num\":0,\"spjgmc\":\"永清县人民法院\",\"sqjzjdjg\":\"永清县人民法院\",\"sqjzjsrq\":\"2022-04-22\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2022-04-07\",\"sqjzrybh\":\"00811\",\"sqjzryjsrq\":\"2022-05-19\",\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":\"623232\",\"xm\":\"王宁weww\",\"xscf\":\"\",\"yqtxqx\":\"\",\"zjhm\":\"14010719950812391X\",\"zp\":null},{\"allowPosition\":null,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":null,\"cdzh\":null,\"correction_num\":0,\"createTime\":\"2022-04-07 15:20:52\",\"csrq\":null,\"dPk\":null,\"departureStatus\":null,\"deptName\":\"湖北省司法厅\",\"deptPk\":100,\"dname\":null,\"existTotal\":2,\"focusman\":null,\"gdjzdmx\":\"\",\"hjszdmx\":\"\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":null,\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":null,\"jtzm\":null,\"jzlb\":null,\"larq\":null,\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"15068139913\",\"orgPk\":0,\"pjrq\":null,\"pjszh\":null,\"pkId\":21370,\"positionStatus\":null,\"security_num\":0,\"spjgmc\":null,\"sqjzjdjg\":null,\"sqjzjsrq\":null,\"sqjzjsrqFmt\":null,\"sqjzksrq\":null,\"sqjzrybh\":\"test0006\",\"sqjzryjsrq\":null,\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":null,\"xm\":\"影子5\",\"xscf\":null,\"yqtxqx\":null,\"zjhm\":\"341225198005046352\",\"zp\":\"null\"},{\"allowPosition\":null,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":null,\"cdzh\":null,\"correction_num\":0,\"createTime\":\"2022-04-07 14:18:17\",\"csrq\":null,\"dPk\":null,\"departureStatus\":null,\"deptName\":\"湖北省司法厅\",\"deptPk\":100,\"dname\":null,\"existTotal\":1,\"focusman\":null,\"gdjzdmx\":\"\",\"hjszdmx\":\"\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":null,\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":null,\"jtzm\":null,\"jzlb\":null,\"larq\":null,\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"15068139913\",\"orgPk\":0,\"pjrq\":null,\"pjszh\":null,\"pkId\":21368,\"positionStatus\":null,\"security_num\":0,\"spjgmc\":null,\"sqjzjdjg\":null,\"sqjzjsrq\":null,\"sqjzjsrqFmt\":null,\"sqjzksrq\":null,\"sqjzrybh\":\"test0005\",\"sqjzryjsrq\":null,\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":null,\"xm\":\"米奇5\",\"xscf\":null,\"yqtxqx\":null,\"zjhm\":\"410526199712256841\",\"zp\":null},{\"allowPosition\":null,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":null,\"cdzh\":null,\"correction_num\":0,\"createTime\":\"2022-04-07 14:13:34\",\"csrq\":null,\"dPk\":null,\"departureStatus\":null,\"deptName\":\"湖北省司法厅\",\"deptPk\":100,\"dname\":null,\"existTotal\":1,\"focusman\":null,\"gdjzdmx\":\"\",\"hjszdmx\":\"\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":null,\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":null,\"jtzm\":null,\"jzlb\":null,\"larq\":null,\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"15068139913\",\"orgPk\":0,\"pjrq\":null,\"pjszh\":null,\"pkId\":21367,\"positionStatus\":null,\"security_num\":0,\"spjgmc\":null,\"sqjzjdjg\":null,\"sqjzjsrq\":null,\"sqjzjsrqFmt\":null,\"sqjzksrq\":null,\"sqjzrybh\":\"test0005\",\"sqjzryjsrq\":null,\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":null,\"xm\":\"影子\",\"xscf\":null,\"yqtxqx\":null,\"zjhm\":\"33092120010707301X\",\"zp\":\"null\"},{\"allowPosition\":0,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":\"\",\"cdzh\":\"\",\"correction_num\":-126,\"createTime\":\"2022-03-21 17:32:54\",\"csrq\":\"1998-03-07\",\"dPk\":0,\"departureStatus\":null,\"deptName\":\"湖北省司法厅\",\"deptPk\":100,\"dname\":null,\"existTotal\":5,\"focusman\":0,\"gdjzdmx\":\"\",\"hjszdmx\":\"\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":\"\",\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":null,\"jtzm\":\"徇私枉法罪\",\"jzlb\":\"99\",\"larq\":null,\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"19521683186\",\"orgPk\":1,\"pjrq\":\"2022-03-21\",\"pjszh\":\"5555\",\"pkId\":21347,\"positionStatus\":0,\"security_num\":0,\"spjgmc\":\"杭州市人民检察院\",\"sqjzjdjg\":\"杭州\",\"sqjzjsrq\":\"2022-03-31\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2022-03-21\",\"sqjzrybh\":\"125\",\"sqjzryjsrq\":null,\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":\"2220\",\"xm\":\"厉万诺\",\"xscf\":\"\",\"yqtxqx\":\"\",\"zjhm\":\"320102199803078498\",\"zp\":\"\"},{\"allowPosition\":1,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":\"\",\"cdzh\":\"\",\"correction_num\":-75,\"createTime\":\"2022-03-21 16:34:59\",\"csrq\":\"1983-04-04\",\"dPk\":0,\"departureStatus\":1,\"deptName\":\"武汉市司法局/武汉市青山区司法局/红卫路司法所\",\"deptPk\":211,\"dname\":null,\"existTotal\":7,\"focusman\":null,\"gdjzdmx\":\"河北省石家庄市长安区南村镇1号\",\"hjszdmx\":\"天津天津市河东区\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":\"\",\"jgjb\":\"0\",\"jjzdh\":null,\"jlrq\":\"2022-05-01\",\"jtzm\":\"组织考试作弊罪\",\"jzlb\":\"04\",\"larq\":\"2022-04-30 00:00:00.0\",\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"18738697981\",\"orgPk\":1,\"pjrq\":\"2022-05-13\",\"pjszh\":\"sdf\",\"pkId\":21345,\"positionStatus\":0,\"security_num\":0,\"spjgmc\":\"永清县人民法院\",\"sqjzjdjg\":\"永清县人民法院\",\"sqjzjsrq\":\"2022-05-21\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2022-03-11\",\"sqjzrybh\":\"1015\",\"sqjzryjsrq\":\"2022-05-19\",\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":\"sdf\",\"xm\":\"杨光军\",\"xscf\":\"\",\"yqtxqx\":\"二个月\",\"zjhm\":\"53212819830404471X\",\"zp\":\"/dnCd/cdkj/user/profile/uploadPath/upload/2022/04/29/4b35365cd7790ff7fc90199a1c4f2310.jpeg\"},{\"allowPosition\":0,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":\"\",\"cdzh\":\"\",\"correction_num\":-96,\"createTime\":\"2022-03-21 15:48:03\",\"csrq\":\"1996-03-18\",\"dPk\":0,\"departureStatus\":1,\"deptName\":\"湖北省司法厅\",\"deptPk\":100,\"dname\":null,\"existTotal\":6,\"focusman\":0,\"gdjzdmx\":\"浙江省杭州市余杭区良渚街道洋帆中心\",\"hjszdmx\":\"安徽省黄山市黟县宏村镇朱村\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":\"\",\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":null,\"jtzm\":\"过失决水罪\",\"jzlb\":\"02\",\"larq\":null,\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"15245267892\",\"orgPk\":1,\"pjrq\":\"2022-03-21\",\"pjszh\":\"5555\",\"pkId\":21344,\"positionStatus\":0,\"security_num\":0,\"spjgmc\":\"嘉兴市中级人民法院\",\"sqjzjdjg\":\"杭州市人民法院\",\"sqjzjsrq\":\"2022-04-30\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2022-03-21\",\"sqjzrybh\":\"D013\",\"sqjzryjsrq\":null,\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":\"2220\",\"xm\":\"戴暮正\",\"xscf\":\"\",\"yqtxqx\":\"\",\"zjhm\":\"341023199603186233\",\"zp\":\"/dnCd/cdkj/archive/profile/uploadPath/upload/2022/03/21/1fccf8b21784817d64461fe44c7ef69d.jpg\"},{\"allowPosition\":0,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":\"杭州市人民法院\",\"cdzh\":\"2221\",\"correction_num\":-126,\"createTime\":\"2022-03-18 17:32:08\",\"csrq\":\"1996-03-18\",\"dPk\":128478,\"departureStatus\":null,\"deptName\":\"滨江区司法局/长河司法所\",\"deptPk\":363,\"dname\":\"杭州市\",\"existTotal\":4,\"focusman\":0,\"gdjzdmx\":\"安徽省黄山市黟县宏村镇朱村\",\"hjszdmx\":\"浙江省杭州市钱塘区下沙街道松乔街458号元成恒盛公寓\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":\"\",\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":\"2022-03-01\",\"jtzm\":\"破坏交通工具罪\",\"jzlb\":\"01\",\"larq\":\"2022-03-01 00:00:00.0\",\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"18655962806\",\"orgPk\":36,\"pjrq\":\"2022-03-04\",\"pjszh\":\"5555\",\"pkId\":21343,\"positionStatus\":0,\"security_num\":0,\"spjgmc\":\"杭州市人民检察院\",\"sqjzjdjg\":\"杭州市人民法院\",\"sqjzjsrq\":\"2022-03-31\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2022-03-01\",\"sqjzrybh\":\"DY0318\",\"sqjzryjsrq\":\"2022-03-14\",\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":\"2220\",\"xm\":\"戴勇\",\"xscf\":\"\",\"yqtxqx\":\"二个月\",\"zjhm\":\"33092219790104551X\",\"zp\":\"/dnCd/cdkj/archive/profile/2022/03/18/C69C4156ADA11271F0651EF1B40BDB23.jpg\"},{\"allowPosition\":1,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":\"\",\"cdzh\":\"\",\"correction_num\":149,\"createTime\":\"2022-03-15 14:30:57\",\"csrq\":\"1988-02-12\",\"dPk\":0,\"departureStatus\":null,\"deptName\":\"武汉市司法局/江汉区司法局/万松街司法所\",\"deptPk\":210,\"dname\":null,\"existTotal\":8,\"focusman\":0,\"gdjzdmx\":\"甘肃省天水市秦安县云山镇云水镇1902号\",\"hjszdmx\":\"甘肃省天水市秦安县云山镇云水镇1902号\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":\"\",\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":\"2020-02-29\",\"jtzm\":\"非法制造、出售非法制造的用于骗取出口退税、抵押税款发票罪\",\"jzlb\":\"01\",\"larq\":\"2020-02-29 00:00:00.0\",\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"18668209409\",\"orgPk\":1,\"pjrq\":\"2020-02-29\",\"pjszh\":\"HZ-P2020022901\",\"pkId\":21339,\"positionStatus\":0,\"security_num\":0,\"spjgmc\":\"杭州市人民检察院\",\"sqjzjdjg\":\"杭州市人民法院\",\"sqjzjsrq\":\"2022-12-31\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2020-03-01\",\"sqjzrybh\":\"J2020031501\",\"sqjzryjsrq\":\"2022-07-01\",\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":1,\"wslxjbh\":\"HZ-Z2020022901\",\"xm\":\"王冬平\",\"xscf\":\"\",\"yqtxqx\":\"二年十个月\",\"zjhm\":\"620503198802125357\",\"zp\":\"/dnCd/cdkj/archive/profile/2022/03/15/8878A2FE79BB31507C0BAC4EDE09D399.jpg\"},{\"allowPosition\":0,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":\"\",\"cdzh\":\"\",\"correction_num\":-91,\"createTime\":\"2022-03-14 20:07:32\",\"csrq\":\"1989-03-11\",\"dPk\":0,\"departureStatus\":null,\"deptName\":\"武汉市司法局/江汉区司法局/万松街司法所\",\"deptPk\":210,\"dname\":null,\"existTotal\":8,\"focusman\":0,\"gdjzdmx\":\"上海上海市黄浦区外滩街道外滩18号\",\"hjszdmx\":\"上海上海市黄浦区外滩街道外滩18号\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":\"\",\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":\"2021-02-28\",\"jtzm\":\"间谍罪\",\"jzlb\":\"02\",\"larq\":\"2021-02-28 00:00:00.0\",\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"18668209407\",\"orgPk\":1,\"pjrq\":\"2021-02-28\",\"pjszh\":\"HZ-PJ2021022801\",\"pkId\":21337,\"positionStatus\":0,\"security_num\":0,\"spjgmc\":\"杭州市人民法院\",\"sqjzjdjg\":\"杭州市人民法院\",\"sqjzjsrq\":\"2022-05-05\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2021-03-01\",\"sqjzrybh\":\"J2021030101\",\"sqjzryjsrq\":\"2022-03-01\",\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":\"HZ-TZ2021022801\",\"xm\":\"骆宾王\",\"xscf\":\"\",\"yqtxqx\":\"一年二个月\",\"zjhm\":\"411502198903119407\",\"zp\":\"/dnCd/cdkj/archive/profile/2022/03/14/57737361D527CA84A22C4328DE70A3C1.jpg\"},{\"allowPosition\":0,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":\"\",\"cdzh\":\"\",\"correction_num\":58,\"createTime\":\"2022-03-14 19:57:28\",\"csrq\":\"1988-01-01\",\"dPk\":0,\"departureStatus\":null,\"deptName\":\"武汉市司法局/江汉区司法局/万松街司法所\",\"deptPk\":210,\"dname\":null,\"existTotal\":5,\"focusman\":0,\"gdjzdmx\":\"江苏省南京市玄武区孝陵卫街道洋帆中心1号楼16楼\",\"hjszdmx\":\"江苏省南京市玄武区孝陵卫街道洋帆中心1号楼16楼\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":\"\",\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":\"2021-07-31\",\"jtzm\":\"贪污罪\",\"jzlb\":\"02\",\"larq\":\"2021-07-31 00:00:00.0\",\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"18668209406\",\"orgPk\":1,\"pjrq\":\"2021-07-31\",\"pjszh\":\"HZ-PJ2021073101\",\"pkId\":21336,\"positionStatus\":0,\"security_num\":0,\"spjgmc\":\"杭州市人民法院\",\"sqjzjdjg\":\"杭州市人民法院\",\"sqjzjsrq\":\"2022-10-01\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2021-08-01\",\"sqjzrybh\":\"J2021080101\",\"sqjzryjsrq\":\"2021-08-11\",\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":\"HZ-TZ2021073101\",\"xm\":\"卢照邻\",\"xscf\":\"\",\"yqtxqx\":\"一年二个月\",\"zjhm\":\"411502198801019406\",\"zp\":\"/dnCd/cdkj/archive/profile/2022/03/14/D735B8BB911F27661D0E864F961A59A5.jpg\"},{\"allowPosition\":1,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":\"杭州市人民法院\",\"cdzh\":\"\",\"correction_num\":209,\"createTime\":\"2022-03-14 19:24:44\",\"csrq\":\"1991-01-01\",\"dPk\":0,\"departureStatus\":null,\"deptName\":\"武汉市司法局/江汉区司法局/万松街司法所\",\"deptPk\":210,\"dname\":null,\"existTotal\":9,\"focusman\":0,\"gdjzdmx\":\"浙江省杭州市余杭区良渚街道金昌路2800号洋帆中心1号楼16楼\",\"hjszdmx\":\"浙江省杭州市余杭区良渚街道金昌路2800号洋帆中心1号楼16楼\",\"isgoout\":null,\"itemTotal\":15,\"jdpzdbjg\":\"\",\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":\"2022-02-28\",\"jtzm\":\"窝藏、转移、隐瞒毒品、毒赃罪\",\"jzlb\":\"02\",\"larq\":\"2022-02-28 00:00:00.0\",\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"18668209401\",\"orgPk\":1,\"pjrq\":\"2022-02-28\",\"pjszh\":\"HZ-PJ2022022801\",\"pkId\":21334,\"positionStatus\":0,\"security_num\":0,\"spjgmc\":\"杭州市人民法院\",\"sqjzjdjg\":\"杭州市人民法院\",\"sqjzjsrq\":\"2023-03-01\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2022-02-01\",\"sqjzrybh\":\"J2022031401\",\"sqjzryjsrq\":\"2022-03-01\",\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":\"HZ-TZ2022022801\",\"xm\":\"王勃\",\"xscf\":\"\",\"yqtxqx\":\"一年一个月\",\"zjhm\":\"411502199101019401\",\"zp\":\"/dnCd/cdkj/archive/profile/2022/03/14/6E7A1957921E91794A07BC8F21154385.jpg\"},{\"allowPosition\":0,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":\"\",\"cdzh\":\"\",\"correction_num\":1000,\"createTime\":\"2022-03-10 16:12:30\",\"csrq\":\"2002-03-01\",\"dPk\":0,\"departureStatus\":null,\"deptName\":\"湖北省司法厅\",\"deptPk\":100,\"dname\":null,\"existTotal\":5,\"focusman\":0,\"gdjzdmx\":\"\",\"hjszdmx\":\"\",\"isgoout\":0,\"itemTotal\":15,\"jdpzdbjg\":\"\",\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":null,\"jtzm\":\"煽动分裂国家罪\",\"jzlb\":\"03\",\"larq\":null,\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"13100005555\",\"orgPk\":1,\"pjrq\":\"2022-03-01\",\"pjszh\":\"（2021）浙1024刑初136号\",\"pkId\":21333,\"positionStatus\":0,\"security_num\":0,\"spjgmc\":\"永清县人民法院\",\"sqjzjdjg\":\"永清县人民法院\",\"sqjzjsrq\":\"2025-04-30\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2022-03-01\",\"sqjzrybh\":\"测试1\",\"sqjzryjsrq\":null,\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":\"（2021）浙1024刑执字第136号\",\"xm\":\"测试\",\"xscf\":\"\",\"yqtxqx\":\"\",\"zjhm\":\"w123456\",\"zp\":null},{\"allowPosition\":1,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":null,\"cdzh\":null,\"correction_num\":317,\"createTime\":\"2022-03-09 16:03:20\",\"csrq\":\"2008-01-05\",\"dPk\":0,\"departureStatus\":null,\"deptName\":\"武汉市司法局/江汉区司法局/前进街司法所\",\"deptPk\":207,\"dname\":null,\"existTotal\":4,\"focusman\":null,\"gdjzdmx\":\"江苏省南京市玄武区红山街道红山街道6号\",\"hjszdmx\":\"福建省福州市鼓楼区安泰街道永定门外街道5号\",\"isgoout\":0,\"itemTotal\":15,\"jdpzdbjg\":null,\"jgjb\":\"4\",\"jjzdh\":null,\"jlrq\":null,\"jtzm\":\"妨害公务罪\",\"jzlb\":\"04\",\"larq\":null,\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"15068139917\",\"orgPk\":1,\"pjrq\":null,\"pjszh\":null,\"pkId\":21330,\"positionStatus\":0,\"security_num\":0,\"spjgmc\":null,\"sqjzjdjg\":null,\"sqjzjsrq\":\"2023-06-17\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2021-12-12\",\"sqjzrybh\":\"8541269852\",\"sqjzryjsrq\":\"2022-01-14\",\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":1,\"wslxjbh\":null,\"xm\":\"小七\",\"xscf\":null,\"yqtxqx\":\"\",\"zjhm\":\"413526200801055421\",\"zp\":null},{\"allowPosition\":0,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":null,\"cdzh\":null,\"correction_num\":56,\"createTime\":\"2022-03-09 15:35:00\",\"csrq\":\"2009-02-05\",\"dPk\":0,\"departureStatus\":null,\"deptName\":\"滨江区司法局/长河司法所\",\"deptPk\":363,\"dname\":null,\"existTotal\":1,\"focusman\":null,\"gdjzdmx\":\"\",\"hjszdmx\":\"\",\"isgoout\":0,\"itemTotal\":15,\"jdpzdbjg\":null,\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":null,\"jtzm\":\"破坏交通工具罪\",\"jzlb\":\"04\",\"larq\":null,\"leave_num\":0,\"leave_sum\":0,\"mobilePhone\":\"15068139916\",\"orgPk\":36,\"pjrq\":null,\"pjszh\":null,\"pkId\":21329,\"positionStatus\":0,\"security_num\":0,\"spjgmc\":null,\"sqjzjdjg\":null,\"sqjzjsrq\":\"2022-09-29\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2022-06-01\",\"sqjzrybh\":\"1245787979\",\"sqjzryjsrq\":\"2022-06-08\",\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":null,\"xm\":\"影子1\",\"xscf\":null,\"yqtxqx\":\"\",\"zjhm\":\"413528200902051258\",\"zp\":\"\"},{\"allowPosition\":0,\"bjjsrq\":null,\"bjjsrqFmt\":null,\"cdjdjg\":\"\",\"cdzh\":\"\",\"correction_num\":269,\"createTime\":\"2022-03-02 11:48:34\",\"csrq\":\"1984-05-28\",\"dPk\":0,\"departureStatus\":null,\"deptName\":\"滨江区司法局/长河司法所\",\"deptPk\":363,\"dname\":null,\"existTotal\":4,\"focusman\":0,\"gdjzdmx\":\"浙江省杭州市余杭区良渚街道金昌路2800号洋帆中心\",\"hjszdmx\":\"浙江省杭州市余杭区良渚街道金昌路2800号洋帆中心16楼\",\"isgoout\":0,\"itemTotal\":15,\"jdpzdbjg\":\"\",\"jgjb\":\"3\",\"jjzdh\":null,\"jlrq\":null,\"jtzm\":\"背叛国家罪\",\"jzlb\":\"02\",\"larq\":null,\"leave_num\":1,\"leave_sum\":-91,\"mobilePhone\":\"13211111111\",\"orgPk\":36,\"pjrq\":\"2022-03-11\",\"pjszh\":\"111\",\"pkId\":21327,\"positionStatus\":0,\"security_num\":0,\"spjgmc\":\"永清县人民法院\",\"sqjzjdjg\":\"决定机关\",\"sqjzjsrq\":\"2023-04-30\",\"sqjzjsrqFmt\":null,\"sqjzksrq\":\"2021-12-01\",\"sqjzrybh\":\"2022030201\",\"sqjzryjsrq\":null,\"terminationType\":0,\"videoCnt\":0,\"vstatus\":0,\"vstatusName\":\"执行中\",\"warn_num\":0,\"wslxjbh\":\"1111\",\"xm\":\"22次\",\"xscf\":\"\",\"yqtxqx\":\"一个月\",\"zjhm\":\"421089198405289856\",\"zp\":\"/dnCd/cdkj/archive/profile/2022/03/02/008B2776B9D2D5FBBD398236B94AAA14.jpg\"}],\"total\":66}";
        //Object parse = JSON.parse(origin);
        //System.out.println(new Date());
    }
}