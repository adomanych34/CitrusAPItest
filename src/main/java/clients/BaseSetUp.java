package clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utils.Listener.contextPrint;
import static utils.RestPath.BASE_PRODUCT_SEATCH_PATH;


public class BaseSetUp {

    public RequestSpecification createRequest() {

        return new RequestSpecBuilder()
                .setBaseUri("https://my.citrus.ua")
                .addFilter(new RequestLoggingFilter(LogDetail.ALL, false, contextPrint))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL, false, contextPrint))
                .setContentType(ContentType.JSON)
                .build();
    }

    public RequestSpecification createRequestForProuctSearch() {

        return new RequestSpecBuilder()
                .setBaseUri(BASE_PRODUCT_SEATCH_PATH)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL, false, contextPrint))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL, false, contextPrint))
                .setContentType(ContentType.JSON)
                .build();
    }

}
