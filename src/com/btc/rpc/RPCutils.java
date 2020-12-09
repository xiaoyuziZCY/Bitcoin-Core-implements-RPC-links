package com.btc.rpc;

import com.alibaba.fastjson.JSONObject;
import com.btc.rpc.RPCresult;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.Set;

public class RPCutils {
    public static String prepareJSON(String method,Object... params){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id",System.currentTimeMillis());
        jsonObject.put("jsonrpc","2.0");
        jsonObject.put("method",method);
        if (params !=null){
            jsonObject.put("params",params);
        }
        return jsonObject.toJSONString();
    }
    public static RPCresult dopost(String url, Map<String,String>headers, String body){
        DefaultHttpClient client =new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        if (!headers.isEmpty()){
            Set<String> keys = headers.keySet();
            for (String key : keys){
                String value = headers.get(key);
                post.addHeader(key,value);
            }
        }
        try {
            StringEntity entity = new StringEntity(body);
            post.setEntity(entity);
            HttpResponse response = client.execute(post);
            int code = response.getStatusLine().getStatusCode();
            RPCresult result = new RPCresult();
            if (code == HttpStatus.SC_OK){
                result.setCode(code);
                result.setMsg("请求成功");
                String jsonStr = EntityUtils.toString(response.getEntity());
                result.getData(jsonStr);
            }else {
                result.setCode(code);
                result.setMsg("请求失败");
                result.setData(null);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String base64Str(String msg){
        return Base64.getEncoder().encodeToString(msg.getBytes(StandardCharsets.UTF_8));
    }
}
