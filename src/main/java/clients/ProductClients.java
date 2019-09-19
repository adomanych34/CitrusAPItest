package clients;

import io.restassured.response.Response;
import models.productmodels.SomeModel;

import static io.restassured.RestAssured.given;
import static utils.RestPath.*;

public class ProductClients extends BaseSetUp {



    public Response getIphoneList() {
        return given(createRequestForProuctSearch())
                .body("{}")
                .get(IPHONE_PATH);
    }

    public Response addProductInCart(SomeModel productsItem) {
        return given(createRequest())
                .body(productsItem)
                .post(ADD_TO_CART_PATH);
    }

    public Response deleteProductFromCart(int basket_id) {
        return given(createRequest())
                .delete(DELETE_FROM_CART_PATH + basket_id);
    }

    public Response addQuantityOfProductToCart(SomeModel model, int basket_id) {
        return given(createRequest())
                .body(model)
                .patch(DELETE_FROM_CART_PATH + basket_id);
    }


}
