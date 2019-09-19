import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static io.restassured.RestAssured.given;

public class Main {
    public static void main(String[] args) {
        ByteArrayOutputStream context = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(context, true);
        RequestSpecification request = new RequestSpecBuilder()
                .setBaseUri("https://me.citrus.ua")
                .addFilter(new RequestLoggingFilter(LogDetail.ALL, false, printStream))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL, false, printStream))
                .setContentType(ContentType.JSON)
                .build();

        Response response = given(request)
                .headers("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpYXQiOjE1NjgzODAwMDUsImV4cCI6MTU5OTkxNjAwNSwiaWQiOjYwNTg1NTcsInVzZXJuYW1lIjoidXdpYnBiQGtsZmIuYm5wIiwiYXV0aG9yaXphdGlvblR5cGUiOiJkZWZhdWx0In0.X-dywQHOOgieq9U04YJ4ii_aCZqS_kkbhfj6r6SIAb7XbcBVKwGWkaCBjCHU5ko_J5dI5bnosXCAvF_zsE2ehtgVy_ySAaHYVg3-uISEqIPh2nazWrN5dA69crSR2wg9Kk_9LeAcsNxBIeI8vKkK8LbBg63t1l43q4o6S4TuigBDTNMgcdnhxfSEi2nOnD1ikcJODZxokEDRy8jA-d_Wm7PysXNPUahbOK0YXbj6egqL6wAkPBzUyD9zud81tqQpVToILeWTC7uPRWL--wktHjCcfaASNMHxnH55_dwMhcfwdcBQD3iyCRMlQdV3Gy-O3BO1wo2cXBaWazFIVUJKtlrsEcaOEqsKAH20L2k-U5Ktv8Ovh5WQfuCdtOxOqkPLLvU9On53-SkG_3QlnZ8B3n9DF-Ab5jegAB22bjG5xo1Cv-E16DdfPhohEVe_cqKBuKQnmoL6HTM4ZvMdFyElFHmySwwxZtEmOTjcq9Wj_iI5d61QH-Oz47H187Ridyo2zOap8KhiURs6s_9oj3rYU5Qru50bwzgqxZhDYqm9Pt010TpYH4u4ftQT8DuYACbVHLLR_okpXLgdH9krTWlXdN-9OJXDMYdiD0C8Jk7KSyTjdqgW5w5ZbRMriVhSnvWkqOUhMyVTDas3IA0ULwyeDEPBGd3AwsAqqX9XV6poewY")
                .get("/api/users/profile");

        System.out.println(response.print());
    }

}
