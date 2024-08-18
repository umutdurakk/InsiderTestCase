package insider.umutd.page;

import insider.umutd.methods.BaseMethods;

public class HomePage extends BaseMethods {

    public void checkHomePage() {
        waitForElementToBeVisible("insiderLogo");
        clickElement("AcceptCookies");
        checkForElement("insiderLogo", "insider logo not visible, Homepage not open");
        checkForElement("exploreInsiderTitle", "explore Insider Title not visible, Homepage not open");
        checkForElement("companyDropdownBtn", "company menu button not visible.");
    }

    public void selectCareerDropDownButton() {
        clickElement("companyDropdownBtn");
        checkForElement("careerDropdownBtn", "Carrer dropdown button not visible.");
        clickElement("careerDropdownBtn");
        logger.info("Going to Carrer page");


    }

}
