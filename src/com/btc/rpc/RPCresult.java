package com.btc.rpc;

public class RPCresult {
private int code;
private String msg;
private String data;
public int getCode(){
    return code;
}
public void setCode(int code){
    this.code=code;
}
public String getMsg(){
    return msg;
}
public void setMsg(String msg){
    this.msg=msg;
}
public String getData(String jsonStr){
    return data;
}
public void setData(String data){
    this.data=data;
}
}
