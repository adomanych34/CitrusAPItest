package assertions;

import models.productmodels.productincartmodel.ProductInCartModel;
import org.testng.asserts.SoftAssert;

public class ProductInCartAssertions extends AbstractAssertions {

    private ProductInCartModel productInCartModel;
    private SoftAssert softAssert = new SoftAssert();

    public ProductInCartAssertions(ProductInCartModel productInCartModel) {
        super(productInCartModel);
        this.productInCartModel = productInCartModel;
    }

    public  ProductInCartAssertions hasName(String expected) {
        softAssert.assertEquals(productInCartModel.getData().getProducts().get(0).getName(), expected);
        return this;
    }

    public ProductInCartAssertions hasId(String expected) {
        softAssert.assertEquals(productInCartModel.getData().getProducts().get(0).getId(), expected);
        return this;
    }

    public ProductInCartAssertions hasQantity(int expected) {
        softAssert.assertEquals(productInCartModel.getData().getQuantity(), expected);
        return this;
    }
    public ProductInCartAssertions hasTotalPrice(int expected) {
        softAssert.assertEquals(productInCartModel.getData().getTotalPrice(), expected);
        return this;
    }

}
