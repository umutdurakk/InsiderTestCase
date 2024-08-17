package insider.umutd.page;

import insider.umutd.methods.BaseMethods;
import org.junit.Assert;

public class HomePage extends BaseMethods {

    public void selectCareerDropDownButton(){
        waitForElementToBeVisible("insiderLogo");
        clickElement("AcceptCookies");
        checkForElement("insiderLogo","insider logo not visible, Homepage not open");
        checkForElement("exploreInsiderTitle","explore Insider Title not visible, Homepage not open");
        checkForElement("companyDropdownBtn","company menu button not visible.");
        clickElement("companyDropdownBtn");
        checkForElement("careerDropdownBtn","Carrer dropdown button not visible.");
        clickElement("careerDropdownBtn");
        logger.info("Going to Carrer page");


    }

}
