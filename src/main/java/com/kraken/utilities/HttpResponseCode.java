package com.kraken.utilities;

import io.restassured.RestAssured;

/**
 * Create by Amit on 11/23/20
 */
public class HttpResponseCode {

    public int httpResponseCodeViaGet(String url) {

        RestAssured.useRelaxedHTTPSValidation();
        return RestAssured.get(url).getStatusCode();

    }

    public int httpResponseCodeViaPost(String url) {

        return RestAssured.post(url).statusCode();

    }

    public static void main(String args[]) {

//        int code = new HttpResponseCode().httpResponseCodeViaGet("http://www.google.com");
        int code = new HttpResponseCode().httpResponseCodeViaGet("https://www.kraken.com/");
        System.out.println("Code = "+ code);
    }
}
