package com.tester.execute;

import org.apache.http.client.methods.HttpPost;

public class SetHeader {
    public static HttpPost setHeader(HttpPost post){

        post.setHeader("Content-Type","application/json");
        post.setHeader("Connection","keep-alive");
        post.setHeader("Accept","*/*");
        return post;
    }
}
