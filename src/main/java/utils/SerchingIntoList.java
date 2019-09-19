package utils;

import models.FailListModel;
import models.FailModel;
import models.productmodels.productsearchmodels.ProductModels;
import models.productmodels.productsearchmodels.ProductsItem;
import models.usermodels.ErrorsItem;

public class SerchingIntoList {


    public static void messageSearching(FailModel failModel, String expected) {
        String rezult = null;
        for (String current : failModel.getErrors()) {
            if (current.equals(expected)) {
                rezult = current;
                break;
            }
        }
        if (rezult == null) {
            throw new AssertionError("email should be equals "
                    + "[" + expected + "]" + "but this one not found");
        }
    }

    public static void messageIntoListSearching(FailListModel failModel, String message) {

        ErrorsItem rezult = null;
        for (ErrorsItem current : failModel.getErrors()) {
            if (current.getMessages().get(0).equals(message)) {
                rezult = current;
                break;
            }
        }
        if (rezult == null) {
            throw new AssertionError("email should be equals "
                    + "[" + message + "] " + "but this one not found");
        }

    }

    public static ProductsItem searchProduct(ProductModels productModels, String name) {
        ProductsItem rezult = null;
        for (ProductsItem current : productModels.getData().getProducts()) {
            if (current.getName().equals(name)) {
                rezult = current;
                break;
            }
        }
        if (rezult == null) {
            throw new RuntimeException("Product isn't exist");
        }
        return rezult;
    }
}
