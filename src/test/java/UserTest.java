import business.UserBL;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Listener;

@Listeners(Listener.class)
public class UserTest {

    private UserBL userBL;


    @BeforeClass
    public void setUp() {
        userBL = new UserBL();

    }
    
    @Test
    public void registerTest() {
        userBL.userRegisterTest();
    }

    @Test
    public void registerEmptyUser() {

        userBL.registerEmptyUser();
    }

    @Test
    public void loginNotExistUser() {
        userBL.userLoginWithNotExistData();
    }

    @Test
    public void loginExistUser() {
        userBL.userRegisterTest();
        userBL.userLogin();
        //userBL.userAuth();
    }
    @Test
    public void registerUserWithEmailOnly() {
        userBL.registerUserWithOnlyEmailField();
    }

    @Test
    public void registerUserWithDigitName() {
        userBL.userRegisterWithDigitsName();
    }

    @Test
    public void registerUserWithMetaSymbolName() {
        userBL.userRegisterWithMetaSymbolsName();
    }

    @Test
    public void registerUserWithNotConfirmPassword() {
        userBL.userRegisterWithNotConfirmPassword();
    }
    @Test
    public void registerUserWithInvalidPhoneNumber() {
        userBL.userRegisterWithInvalidPhoneNumber();
    }



}
