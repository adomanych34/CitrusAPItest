package builders;

import models.usermodels.UserModels;
import org.apache.commons.lang3.RandomStringUtils;

public class UserModelsBuilder {
    private static String password = createPassword();



    public static UserModels createModel() {
        return UserModels.builder()
                .email(createEmail().toLowerCase())
                .name(createName())
                .phone(createPhoneNumber())
                .password(password)
                .confirm_password(password)
                .build();
    }

    public static UserModels createEmptyModel() {
        return new UserModels();
    }
    public static UserModels createUserWithEmail() {
        return  UserModels.builder()
                .email(createEmail())
                .build();
    }

    public static UserModels createUserWithDigitsName() {
        return UserModels.builder()
                .email(createEmail().toLowerCase())
                .name(createInalidDigitsName())
                .phone(createPhoneNumber())
                .password(password)
                .confirm_password(password)
                .build();
    }
    public static UserModels createUserWithMetaSymbolsName() {
        return UserModels.builder()
                .email(createEmail().toLowerCase())
                .name(createInalidMetaSymbolsName())
                .phone(createPhoneNumber())
                .password(password)
                .confirm_password(password)
                .build();
    }

    public static UserModels createUserWithNotconfirPassword() {
        return UserModels.builder()
                .email(createEmail().toLowerCase())
                .name(createInalidMetaSymbolsName())
                .phone(createPhoneNumber())
                .password(password)
                .confirm_password(password.toUpperCase())
                .build();
    }

    public static UserModels createUserWithInvalidPhoneNumber() {
        return UserModels.builder()
                .email(createEmail().toLowerCase())
                .name(createInalidMetaSymbolsName())
                .phone(createInvalidPhoneNumber())
                .password(password)
                .confirm_password(password)
                .build();
    }

    public static UserModels createValidLoginModel(String email, String password) {
        return UserModels.builder()
                .email(email)
                .password(password)
                .build();
    }

    public static UserModels createInvalidLoginModels() {
        return UserModels.builder()
                .email(createEmail())
                .password(password)
                .build();
    }


    private static String createEmail() {
        return RandomStringUtils.randomAlphabetic(6)
                + "@"
                + RandomStringUtils.randomAlphabetic(4)
                + "."
                + RandomStringUtils.randomAlphabetic(3);
    }

    private static String createName() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    private static String createPhoneNumber() {
        return "380" + RandomStringUtils.randomNumeric(9);
    }

    private static String createPassword() {
        return RandomStringUtils.randomAlphabetic(8);
    }
    private static String createInalidDigitsName(){
        return RandomStringUtils.randomNumeric(6);
    }
    private static String createInalidMetaSymbolsName(){
        return "{}{__+)+_+";
    }
    private static String createInvalidPhoneNumber() {
        return RandomStringUtils.randomNumeric(5);
    }
}
