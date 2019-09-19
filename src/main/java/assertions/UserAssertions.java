package assertions;

import models.usermodels.EmailsItem;
import models.usermodels.PhonesItem;
import models.usermodels.UserAfterRegisterModel;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;

public class UserAssertions extends AbstractAssertions {
    private UserAfterRegisterModel actual;
    private SoftAssert softAssert = new SoftAssert();

    private boolean flag = true;

    public UserAssertions(UserAfterRegisterModel actual) {
        super(actual);
        this.actual = actual;
    }

    public UserAssertions hasEmail(String expected) {
        flag = false;
        Iterator<EmailsItem> iterator = actual.getData().getEmails().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getEmail().equals(expected)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new AssertionError("email should be equals "
                    + "[" + expected + "]" + "but this one not found");
        }
        return this;
    }

    public UserAssertions hasName(String expected) {
        softAssert.assertEquals(actual.getData().getName(), expected);
        return this;
    }

    public UserAssertions hasPhone(String expected) {
        flag = false;
        Iterator<PhonesItem> iterator = actual.getData().getPhones().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPhone().equals(expected)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new AssertionError("email should be equals "
                    + "[" + expected + "]" + "but this one not found");
        }
        return this;
    }

}
