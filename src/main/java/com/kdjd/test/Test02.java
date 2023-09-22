package com.kdjd.test;

import com.google.gson.Gson;

public class Test02 {

    public static void main(String[] args) {
        String str = "{\n" +
                "\t\"appNo\": \"BK-USER\",\n" +
                "\t\"version\": \"4.0.1\",\n" +
                "\t\"downloadUrl\": \"/uploadPath/upload/2021/09/10/d82935dc715ca8bc8e5a6551e949ccb5.apk\"\n" +
                "}";
        Gson gson = new Gson();
        TAppVersion a = gson.fromJson(str, TAppVersion.class);
        TAppVersion b = gson.fromJson(str, TAppVersion.class);
        rename(a, false);
        rename(b, true);

    }

    private static void rename(TAppVersion appVersion, boolean isCurrent) {
        String source = appVersion.getDownloadUrl();

        String prefix = source.substring(0, source.lastIndexOf("/") + 1);
        String suffix = source.substring(source.lastIndexOf("."));
        String appName = appVersion.getAppNo();
        if (!isCurrent) {
            appName += "." + appVersion.getVersion();
        }
        String target = prefix + appName + suffix;

//        String res = minioUploadUtils.renameObject(source, target);
        appVersion.setDownloadUrl(target);
//        tAppVersionMapper.updateTAppVersion(appVersion);
        System.out.println(appVersion.toString());

    }

    static class TAppVersion {
        String appNo;
        String version;
        String downloadUrl;

        public String getAppNo() {
            return appNo;
        }

        public void setAppNo(String appNo) {
            this.appNo = appNo;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getDownloadUrl() {
            return downloadUrl;
        }

        public void setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
        }

        @Override
        public String toString() {
            return "TAppVersion{" +
                    "appNo='" + appNo + '\'' +
                    ", version='" + version + '\'' +
                    ", downloadUrl='" + downloadUrl + '\'' +
                    '}';
        }
    }
}
