import business.ProductBL;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Listener;
import utils.SearchingProduct;

@Listeners(Listener.class)
public class ProductTest {
    private ProductBL productBL;


    @BeforeClass
    public void setUp() {
        productBL = new ProductBL();

    }

    @Test
    public void getIphoneListTest() {
        productBL.getIphoneList();
    }

    @Test
    public void addProductToCartTest() {
        productBL.addProductToCart(SearchingProduct.IPHONE_XS.getValue());

    }

    @Test
    public void deleteNotExistProduct() {
        productBL.deleteNotExistProductFromCart(Integer.parseInt(RandomStringUtils.randomNumeric(7)));
    }
}
