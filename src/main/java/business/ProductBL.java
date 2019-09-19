package business;

import assertions.AbstractAssertions;
import assertions.ErrorAssertions;
import assertions.ErrorListAssertions;
import assertions.ProductInCartAssertions;
import builders.ProductModelsBuilders;
import clients.ProductClients;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import models.FailListModel;
import models.FailModel;
import models.productmodels.SomeModel;
import models.productmodels.productincartmodel.ProductInCartModel;
import models.productmodels.productsearchmodels.ProductModels;
import utils.ErrorMessage;
import utils.StatusCodes;

import static utils.Quantity.*;
import static utils.SerchingIntoList.searchProduct;

public class ProductBL {
    private ProductModels productModel;
    private ProductInCartModel productInCartModel;
    private FailModel failModel;
    private FailListModel failListModel;
    private Response response;
    private ProductClients productClients = new ProductClients();
    private AbstractAssertions assertions;
    private ProductInCartAssertions productInCartAssertions;
    private ErrorAssertions errorAssertions;
    private ErrorListAssertions errorListAssertions;


    @Story("User should get all Iphone after searching request")
    @Step("Get all iphone on first page")
    public void getIphoneList() {
        response = productClients.getIphoneList();
        productModel = response.getBody().as(ProductModels.class);
        assertions = new AbstractAssertions(productModel);
        assertions
                .hasSucces(true)
                .hasCode(200)
                .assertAll();
    }
    @Story("User can add each product to shopping cart")
    @Step("add some product to cart")
    public void addProductToCart(String name) {

        productModel = productClients.getIphoneList().getBody().as(ProductModels.class);
        SomeModel productForCart = ProductModelsBuilders.createProductForAddingToCart(searchProduct(productModel, name));
        response = productClients.addProductInCart(productForCart);
        productInCartModel = response.getBody().as(ProductInCartModel.class);
        productInCartAssertions = new ProductInCartAssertions(productInCartModel);
        productInCartAssertions
                .hasId(productForCart.getId())
                .hasName(name)
                .hasSucces(true)
                .hasCode(StatusCodes.statusCode.OK.getValue())
                .assertAll();

        addValidCountToProductInCart(productInCartModel.getData().getTotalPrice(), productInCartModel.getData().getProducts().get(0).getProductInBasketId());
        addLetterQuantity(productInCartModel.getData().getProducts().get(0).getProductInBasketId());
        addZeroQuantity(productInCartModel.getData().getProducts().get(0).getProductInBasketId());
        addNegativeQuantity(productInCartModel.getData().getProducts().get(0).getProductInBasketId());

        deleteProductFromCart(productInCartModel.getData().getProducts().get(0).getProductInBasketId());
    }

    @Story("User can delete each product from shopping cart")
    @Step("delete some product from cart")
    private void deleteProductFromCart(int basket_Id) {
        response = productClients.deleteProductFromCart(basket_Id);
        productInCartModel = response.getBody().as(ProductInCartModel.class);
        productInCartAssertions = new ProductInCartAssertions(productInCartModel);
        productInCartAssertions
                .hasQantity(0)
                .hasTotalPrice(0)
                .hasSucces(true)
                .hasCode(StatusCodes.statusCode.OK.getValue());

    }
    @Story("User can add count of product in shopping cart and price should be changed correct")
    @Step("add valid count of product to shopping cart")
    private void addValidCountToProductInCart(int totalPrice, int basket_id) {
        SomeModel quantityModel = ProductModelsBuilders.createProductForAddingQuantityToCart(VALID_QUANTITY.getValue());
        response = productClients.addQuantityOfProductToCart(quantityModel, basket_id);
        productInCartModel = response.getBody().as(ProductInCartModel.class);
        productInCartAssertions = new ProductInCartAssertions(productInCartModel);
        productInCartAssertions
                .hasQantity(Integer.parseInt(VALID_QUANTITY.getValue()))
                .hasTotalPrice(totalPrice * Integer.parseInt(VALID_QUANTITY.getValue()))
                .hasSucces(true)
                .hasCode(StatusCodes.statusCode.OK.getValue());
    }






    //negative
    @Story("User can not delete product with not present into shopping cart")
    @Step("delete not exist product from cart")
    public void deleteNotExistProductFromCart(int basket_Id) {
        response = productClients.deleteProductFromCart(basket_Id);
        failModel = response.getBody().as(FailModel.class);
        errorAssertions = new ErrorAssertions(failModel);
        errorAssertions
                .hasBadInputErrorMessage(ErrorMessage.DELETE_PRODUCT_FROM_CART_ERROR.getValue())
                .hasSucces(false)
                .hasCode(StatusCodes.statusCode.OBJECT_NOT_FOUND.getValue());

    }
    @Story("User can not add  negative or zero count of product in shopping cart")
    @Step("add negative count of product to shopping cart")
    private void addNegativeQuantity(int basket_Id) {
        SomeModel quantityModel = ProductModelsBuilders.createProductForAddingQuantityToCart(NEGATIVE_NUMBER.getValue());
        response = productClients.addQuantityOfProductToCart(quantityModel, basket_Id);
        failListModel = response.getBody().as(FailListModel.class);
        errorListAssertions = new ErrorListAssertions(failListModel);
        errorListAssertions
                .hasNotExistErrorMessage(ErrorMessage.QUANTITY_DIGIT_ERROR.getValue())
                .hasSucces(false)
                .hasCode(StatusCodes.statusCode.INVALID_INPUT.getValue());

    }
    @Story("User can not add  negative or zero count of product in shopping cart")
    @Step("add zero count of product to shopping cart")
    private void addZeroQuantity(int basket_Id) {
        SomeModel quantityModel = ProductModelsBuilders.createProductForAddingQuantityToCart(ZERO_QUANTITY.getValue());
        response = productClients.addQuantityOfProductToCart(quantityModel, basket_Id);
        failListModel = response.getBody().as(FailListModel.class);
        errorListAssertions = new ErrorListAssertions(failListModel);
        errorListAssertions
                .hasNotExistErrorMessage(ErrorMessage.QUANTITY_DIGIT_ERROR.getValue())
                .hasSucces(false)
                .hasCode(StatusCodes.statusCode.INVALID_INPUT.getValue());

    }
    @Story("User can not add count of product which contains letter in shopping cart")
    @Step("add count of product which contains letter to shopping cart")
    private void addLetterQuantity(int basket_Id) {
        SomeModel quantityModel = ProductModelsBuilders.createProductForAddingQuantityToCart(DIGIT_NUMBER.getValue());
        response = productClients.addQuantityOfProductToCart(quantityModel, basket_Id);
        failListModel = response.getBody().as(FailListModel.class);
        errorListAssertions = new ErrorListAssertions(failListModel);
        errorListAssertions
                .hasNotExistErrorMessage(ErrorMessage.QUANTITY_ALPHA_ERROR.getValue())
                .hasSucces(false)
                .hasCode(StatusCodes.statusCode.INVALID_INPUT.getValue());

    }

}
