package ru.netology;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    void postmanEcho() {
       given()
            .baseUri("https://postman-echo.com")
            .contentType ("text/plain; charset=utf-8")
            .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
            .queryParam("key1", "value1")

        .when()
             .post("/post")

        .then()
//            .log().all()
            .statusCode(200)
            .body("data", equalTo("some data"))
            .body("args.key1", equalTo("value2"))
            .body("headers.content-type", equalTo("text/plain; charset=utf-8"))
        ;
    }
}
