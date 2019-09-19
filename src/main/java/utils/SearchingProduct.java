package utils;

import lombok.Getter;


@Getter
public enum SearchingProduct {
    IPHONE_XS("Apple iPhone Xs Max 512Gb Silver (MT572)"),
    IPHONE_8("Apple iPhone 8 256Gb Gold (MQ7E2)");

    private String value;

    SearchingProduct(String value) {
        this.value = value;
    }

}

