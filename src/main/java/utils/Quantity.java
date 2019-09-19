package utils;

import lombok.Getter;

    @Getter
    public enum Quantity {
        VALID_QUANTITY("3"),
        NEGATIVE_NUMBER("-2"),
        ZERO_QUANTITY("0"),
        DIGIT_NUMBER("d");

        private String value;

        Quantity(String value) {
            this.value = value;
        }

    }

