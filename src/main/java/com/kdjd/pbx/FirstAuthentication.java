//package com.kdjd.pbx;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.web.client.RestTemplate;
//
//public class FirstAuthentication {
//
//    public static void main(String[] args) {
//        String url = "https://221.12.174.76:10000/papi/v1/authentication";
//
//        RestTemplate template = new RestTemplate();
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Agent-Expire", "180");
//        httpHeaders.add("Agent-User", "pbxapi");
//
//        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
//
//        String response = template.postForObject(url, httpEntity, String.class);
//        System.out.println(response);
//
//    }
//}
