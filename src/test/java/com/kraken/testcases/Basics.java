package com.kraken.testcases;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RedirectSpecification;
import okhttp3.Protocol;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.protocol.HttpContext;

import java.net.ProtocolFamily;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Create by Amit on 9/23/20
 */
public class Basics {


    public static void main(String[] args) {
//        JsonPath jsonPath ;

        RestAssured.baseURI="https://www.kraken.com";
//        RestAssured.baseURI="https://www.google.com/";
//        RestAssured.baseURI="https://www.jpmorgan.com/";


        String response = given().relaxedHTTPSValidation()
//                .when().log().all().get("/prices")
                .when().log().all().get("/")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println("response = " + response);
    }
}
