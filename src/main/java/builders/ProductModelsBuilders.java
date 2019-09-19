package builders;

import models.productmodels.SomeModel;
import models.productmodels.productsearchmodels.ProductsItem;

public class ProductModelsBuilders {

    public static SomeModel createProductForAddingToCart(ProductsItem rezult) {
        return SomeModel.builder()
                .price_type("ecommerce")
                .id(rezult.getIdd())
                .build();
    }

    public static SomeModel createProductForAddingQuantityToCart(String count) {
        return SomeModel.builder()
                .countOfProduct(count)
                .build();
    }
}
