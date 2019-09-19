package utils;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    NAME_FIELD("Поле name обязательно для заполнения."),
    EMAIL_FIELD("Поле email обязательно для заполнения."),
    PHONE_FIELD("Поле phone обязательно для заполнения."),
    PASSWORD_FIELD("Поле password обязательно для заполнения."),
    CONFIRM_PASSWORD_FIELD("Поле confirm password обязательно для заполнения."),
    QUANTITY_ALPHA_ERROR("Поле qty должно быть целым числом."),
    QUANTITY_DIGIT_ERROR("Поле qty должно быть не менее 1."),
    DELETE_PRODUCT_FROM_CART_ERROR("Product in basket not found"),
    INVALID_PHONE_NUMBER_ERROR("Поле phone должно быть корректным номером телефона."),
    CONFIRM_PASSWORD_ERROR("Значение confirm password должно совпадать с password."),
    INVALID_NAME("Invalid name"),
    INVALID_PASSWORD("Invalid password");
    private String value;

    ErrorMessage(String value) {
        this.value = value;
    }

}

