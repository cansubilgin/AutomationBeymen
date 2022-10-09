package cases;

import com.cb.automation.base.TestInitialize;
import org.testng.annotations.Test;

public class TestCase extends TestInitialize {

    @Test
    public void scenario2ChooseDoNotAcceptAgreementAndVerifyPage() {
        homePage().goToWidget();
        searchPage().readcsvAndChooseProduct();
        String[] getPrice=productPage().addBasket();
        basketPage().verifyBasket(getPrice[0]);
        basketPage().addCount();
        basketPage().deleteProduct();

    }

}
