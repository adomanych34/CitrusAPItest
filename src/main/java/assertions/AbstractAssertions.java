package assertions;

import models.BaseModels;
import org.testng.asserts.SoftAssert;

public class AbstractAssertions {
    private BaseModels baseModel;

    private SoftAssert softAssert;

    public AbstractAssertions(BaseModels actual) {
        this.baseModel = actual;
        softAssert = new SoftAssert();
    }


    public AbstractAssertions hasSucces(boolean expected) {

        softAssert.assertEquals(baseModel.isSuccess(), expected);
        return this;
    }

    public AbstractAssertions hasCode(int expected) {
        softAssert.assertEquals(baseModel.getCode(), expected);
        return this;
    }

    public void assertAll() {
        softAssert.assertAll();
    }


}
