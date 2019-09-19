package clients;


import io.restassured.response.Response;
import models.usermodels.UserModels;

import static io.restassured.RestAssured.given;
import static utils.RestPath.*;

public class UserClients extends BaseSetUp {

    public Response registerNewUser(UserModels testUser) {
        return given(createRequest())
                .body(testUser)
                .post(REGISTER_PATH);
    }

    public Response login(UserModels testData) {
        return given(createRequest())
                .body(testData)
                .post(LOGIN_PATH);
    }

    public Response auth(String token) {
        return given(createRequest())
                .header("Authorization", "Bearer " + token)
                .get(USER_PATH);
    }


}
