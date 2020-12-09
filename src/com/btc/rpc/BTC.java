package com.btc.rpc;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class BTC {
    private static final String RPCUSER = "user";
    private static final String RPCASSWORD = "pwd";
    private static final String RPCURL = "http://127.0.0.1:8332";
    public static void main(String[] args){
        JSONObject rpcJson=new JSONObject();
        rpcJson.put("id",System.currentTimeMillis());
        rpcJson.put("jsonrpc","2.0");
        rpcJson.put("method",BTCmethod.getGetbestblockhash());
        String json = rpcJson.toJSONString();
        System.out.println("请求的数据为"+json);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(RPCURL);
        try {
        String authStr = RPCUSER+":"+RPCASSWORD;
        String authBase64 = RPCutils.base64Str(authStr);
        post.addHeader("Authorization", "Basic " + authBase64);
        post.addHeader("Encoding", "UTF-8");
        post.addHeader("Content-Type", "application/json");
            StringEntity entity = new StringEntity(json);
            post.setEntity(entity);
            System.out.println(1);
            System.out.println(post);
            HttpResponse response = client.execute(post);
            System.out.println(2);
            int code =response.getStatusLine().getStatusCode();
            if (code==200){
                System.out.println("恭喜rpc成功");
                String result = EntityUtils.toString(response.getEntity());
                System.out.println(result);
            }else{
                System.out.println("失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
