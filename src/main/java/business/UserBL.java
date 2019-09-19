package business;

import assertions.BaseAssert;
import assertions.ErrorAssertions;
import assertions.ErrorListAssertions;
import assertions.UserAssertions;
import builders.UserModelsBuilder;
import clients.UserClients;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.FailListModel;
import models.FailModel;
import models.usermodels.UserAfterRegisterModel;
import models.usermodels.UserModels;
import utils.ErrorMessage;
import utils.StatusCodes;

public class UserBL {
    private UserClients userClient = new UserClients();
    private String authToken;
    private UserModels userForAuth;


    private UserAfterRegisterModel succesUserAfter;
    private FailModel badInputUser;
    private FailListModel notExistUser;

    private UserAssertions userAssertions;
    private ErrorAssertions errorAssertions;
    private ErrorListAssertions errorListAssertions;

    private UserModels testUser;
    private Response response;
    private String pass;
    private String em;


    @Step("Register new user with valid data")
    public void userRegisterTest() {

        testUser = UserModelsBuilder.createModel();
        em = testUser.getEmail();
        pass = testUser.getPassword();

        response = userClient.registerNewUser(testUser);
        succesUserAfter = response.getBody().as(UserAfterRegisterModel.class);
        userAssertions = new UserAssertions(succesUserAfter);
        BaseAssert.baseAssert(response, StatusCodes.statusCode.OK.getValue());

        userAssertions
                .hasName(testUser.getName())
                .hasEmail(testUser.getEmail())
                .hasPhone(testUser.getPhone())
                .hasSucces(true)
                .hasCode(StatusCodes.statusCode.OK.getValue());

    }


    @Step("Login user with valid data")
    public void userLogin() {
        testUser = UserModelsBuilder.createValidLoginModel(em, pass);
        response = userClient.login(testUser);
        succesUserAfter = response.getBody().as(UserAfterRegisterModel.class);
        userAssertions = new UserAssertions(succesUserAfter);
        userAssertions
                .hasSucces(true)
                .hasCode(StatusCodes.statusCode.OK.getValue())
                .assertAll();
        userAuth(response, testUser);
    }


    @Step("User Authorization")
    private void userAuth(Response responseLogin, UserModels userForAuth) {
        authToken = responseLogin.getCookie("token");
        Response responseONE = userClient.auth(authToken);

        System.out.println(responseONE.prettyPeek().toString());
        succesUserAfter = responseONE.getBody().as(UserAfterRegisterModel.class);
        userAssertions = new UserAssertions(succesUserAfter);
        userAssertions
                .hasName(userForAuth.getName())
                .hasEmail(userForAuth.getName())
                .hasPhone(userForAuth.getPhone())
                .assertAll();

    }


    //negative

    @Step("Register empty user, negative test")
    public void registerEmptyUser() {
        testUser = UserModelsBuilder.createEmptyModel();
        response = userClient.registerNewUser(testUser);
        notExistUser = response.getBody().as(FailListModel.class);
        BaseAssert.baseAssert(response, StatusCodes.statusCode.OK.getValue());
        errorListAssertions = new ErrorListAssertions(notExistUser);
        errorListAssertions
                .hasNotExistErrorMessage(ErrorMessage.NAME_FIELD.getValue())
                .hasNotExistErrorMessage(ErrorMessage.EMAIL_FIELD.getValue())
                .hasNotExistErrorMessage(ErrorMessage.PHONE_FIELD.getValue())
                .hasNotExistErrorMessage(ErrorMessage.PASSWORD_FIELD.getValue())
                .hasNotExistErrorMessage(ErrorMessage.CONFIRM_PASSWORD_FIELD.getValue())
                .hasSucces(false)
                .hasCode(StatusCodes.statusCode.INVALID_INPUT.getValue())
                .assertAll();
    }//!!!!


    @Step("Register user which contains only email field")
    public void registerUserWithOnlyEmailField() {
        testUser = UserModelsBuilder.createUserWithEmail();
        response = userClient.registerNewUser(testUser);
        notExistUser = response.getBody().as(FailListModel.class);
        BaseAssert.baseAssert(response, StatusCodes.statusCode.OK.getValue());
        errorListAssertions = new ErrorListAssertions(notExistUser);
        errorListAssertions

                .hasNotExistErrorMessage(ErrorMessage.NAME_FIELD.getValue())
                .hasNotExistErrorMessage(ErrorMessage.PHONE_FIELD.getValue())
                .hasNotExistErrorMessage(ErrorMessage.PASSWORD_FIELD.getValue())
                .hasNotExistErrorMessage(ErrorMessage.CONFIRM_PASSWORD_FIELD.getValue())
                .hasSucces(false)
                .hasCode(StatusCodes.statusCode.INVALID_INPUT.getValue())
                .assertAll();

    }


    @Step("Try to Login user with not registered data")
    public void userLoginWithNotExistData() {
        testUser = UserModelsBuilder.createInvalidLoginModels();
        response = userClient.login(testUser);
        badInputUser = response.getBody().as(FailModel.class);
        errorAssertions = new ErrorAssertions(badInputUser);
        errorAssertions
                .hasBadInputErrorMessage(ErrorMessage.INVALID_PASSWORD.getValue())
                .hasSucces(false)
                .hasCode(StatusCodes.statusCode.INVALID_INPUT.getValue())
                .assertAll();
    }


    @Step("Register user with digits name")
    public void userRegisterWithDigitsName() {
        testUser = UserModelsBuilder.createUserWithDigitsName();
        response = userClient.registerNewUser(testUser);
        badInputUser = response.getBody().as(FailModel.class);
        errorAssertions = new ErrorAssertions(badInputUser);
        errorAssertions
                .hasBadInputErrorMessage(ErrorMessage.INVALID_NAME.getValue())
                .hasSucces(false)
                .hasCode(StatusCodes.statusCode.INVALID_INPUT.getValue())
                .assertAll();
    }


    @Step("Register user with meta symbols name")
    public void userRegisterWithMetaSymbolsName() {
        testUser = UserModelsBuilder.createUserWithMetaSymbolsName();
        response = userClient.registerNewUser(testUser);
        badInputUser = response.getBody().as(FailModel.class);
        errorAssertions = new ErrorAssertions(badInputUser);
        errorAssertions
                .hasBadInputErrorMessage(ErrorMessage.INVALID_NAME.getValue())
                .hasSucces(false)
                .hasCode(StatusCodes.statusCode.INVALID_INPUT.getValue())
                .assertAll();
    }


    @Step("Register user with not confirm password/negative")
    public void userRegisterWithNotConfirmPassword() {
        testUser = UserModelsBuilder.createUserWithNotconfirPassword();
        response = userClient.registerNewUser(testUser);
        notExistUser = response.getBody().as(FailListModel.class);
        errorListAssertions = new ErrorListAssertions(notExistUser);
        errorListAssertions
                .hasNotExistErrorMessage(ErrorMessage.CONFIRM_PASSWORD_ERROR.getValue())
                .hasSucces(false)
                .hasCode(StatusCodes.statusCode.INVALID_INPUT.getValue())
                .assertAll();
    }


    @Step("Register user with invalid phone number")
    public void userRegisterWithInvalidPhoneNumber() {
        testUser = UserModelsBuilder.createUserWithInvalidPhoneNumber();
        response = userClient.registerNewUser(testUser);
        notExistUser = response.getBody().as(FailListModel.class);
        errorListAssertions = new ErrorListAssertions(notExistUser);
        errorListAssertions
                .hasNotExistErrorMessage(ErrorMessage.INVALID_PHONE_NUMBER_ERROR.getValue())
                .hasSucces(false)
                .hasCode(StatusCodes.statusCode.INVALID_INPUT.getValue())
                .assertAll();
    }


}
