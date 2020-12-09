package com.btc.rpc;

public class BTCmethod {
    private static final String getbestblockhash = "getbestblockhash";
    private static final String getblockcount = "getblockcount";
    private static final String getblock = "getblock";
    private static final String params = null;

    public static void main(String[] args) {
    }
    public static String getGetbestblockhash(){
        return getbestblockhash;
    }
    public static String getGetblockcount(){
        return getblockcount;
    }
    public static String getGetblock(String method,String params){
        return params;
    }
}
