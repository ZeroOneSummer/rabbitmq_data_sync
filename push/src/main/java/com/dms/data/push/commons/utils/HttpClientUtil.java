package com.dms.data.push.commons.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {  
  
    public static String doGet(String url, Map<String, String> param, Integer overtime) {
  
        // 创建Httpclient对象  

        String resultString = "";  
        CloseableHttpResponse response = null;  
        try(CloseableHttpClient httpclient = HttpClients.createDefault()) {
            // 创建uri  
            URIBuilder builder = new URIBuilder(url);  
            if (param != null) {
                for (String key : param.keySet()) {  
                    builder.addParameter(key, param.get(key));  
                }  
            }  
            URI uri = builder.build();  
  
            // 创建http GET请求  
            HttpGet httpGet = new HttpGet(uri);
            httpGet.setHeader("X-Requested-With","XMLHttpRequest");
            if(null != overtime){
                RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(overtime).build();//设置请求和传输超时时间
                httpGet.setConfig(requestConfig);
            }
            // 执行请求  
            response = httpclient.execute(httpGet);  
            // 判断返回状态是否为200  
            if (response.getStatusLine().getStatusCode() == 200) {  
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        return resultString;  
    }




    public static String doGet(String url) {  
        return doGet(url, null,null);
    }

    public static String doGet(String url,Integer overtime){
        return doGet(url,null,overtime);
    }

    public static String doGet(String url,Map<String, String> param){
        return doGet(url,param,null);
    }

    public static String doPost(String url, Map<String, String> param,Integer overtime) {
        // 创建Httpclient对象  

        CloseableHttpResponse response = null;  
        String resultString = "";  
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建Http Post请求  
            HttpPost httpPost = new HttpPost(url);
            if(null != overtime){
//                RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(overtime).build();//设置请求和传输超时时间
                RequestConfig requestConfig = RequestConfig.custom()
                        .setConnectTimeout(overtime)
                        .setConnectionRequestTimeout(overtime)
                        .setSocketTimeout(overtime).build();
                httpPost.setConfig(requestConfig);
            }
            // 创建参数列表  
            if (param != null) {  
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {  
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }  
                // 模拟表单  
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");  
                httpPost.setEntity(entity);  
            }  
            // 执行http请求  
            response = httpClient.execute(httpPost);  
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        return resultString;
    }  
  
    public static String doPost(String url,Map<String, String> param) {
        return doPost(url, param,null);
    }
    public static String doPost(String url,Integer overtime) {
        return doPost(url, null,overtime);
    }

    public static String doPost(String url) {
        return doPost(url, null,null);
    }
      
    public static String doPostJson(String url, String json) {  
        // 创建Httpclient对象  

        CloseableHttpResponse response = null;  
        String resultString = "";  
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建Http Post请求  
            HttpPost httpPost = new HttpPost(url);  
            // 创建请求内容  
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);  
            // 执行http请求  
            response = httpClient.execute(httpPost);  
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {  
            e.printStackTrace();  
        }
  
        return resultString;  
    }

    public static String doPostJson(String url, String json,Integer overtime) throws IOException {
        // 创建Httpclient对象

        CloseableHttpResponse response = null;
        String resultString = "";
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            if(null != overtime){
//                RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(overtime).build();//设置请求和传输超时时间
                RequestConfig requestConfig = RequestConfig.custom()
                        .setConnectTimeout(overtime)
                        .setConnectionRequestTimeout(overtime)
                        .setSocketTimeout(overtime).build();
                httpPost.setConfig(requestConfig);
            }

            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            throw e;
        }

        return resultString;
    }
    
    public static void main(String[] args) {


//        String url="http://localhost:8084/UserLevel/verifyUserLevel/sendCoupon";
//        Map<String,String> param=new HashMap<>();
//        param.put("loginCode","13213213131");
//        param.put("targetLevelCode","1000004");
//        String result=HttpClientUtil.doPost(url,param,3000);

//        System.out.println(result);
//        Long time  = System.currentTimeMillis();
//        JSONObject json = new JSONObject();
//        json.put("logincode", "4D480BE9F7ED7D2C76B345E930BD16B5");
//        json.put("serialcode", "924936");
//        json.put("sign", Openssl.sgin(JSONObject.toJSONString(json)));
//		String result=doPostJson("http://120.77.46.4:19400/user_org_move",json.toJSONString());
//		JSONObject jsonObject=JSONObject.parseObject(result);
//		int code=jsonObject.getInteger("error_code");
//        System.out.println(jsonObject.get("error_text"));
//        System.err.println(System.currentTimeMillis()-time);
    }
}  


