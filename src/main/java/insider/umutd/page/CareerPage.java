package insider.umutd.page;

import insider.umutd.methods.BaseMethods;

public class CareerPage extends BaseMethods {

    public void checkCareerPage() {
        scrollToElementToBeVisible("loadMoreBtn");
        javascriptclicker("loadMoreBtn");
        waitBySecond(2);
        checkForElement("teamsSection", "teams section not visible");
        scrollToElementToBeVisible("locationsTitle");
        checkForElement("locationsSection", "location section not visible");
        scrollToElementToBeVisible("lifeatInsiderTitle");
        checkForElement("lifeatInsiderSection", "life at Insider section not visible");

    }

    public void gotoSearchJobPage() {
        gotoURL("https://useinsider.com/careers/quality-assurance/");
        clickElement("seeAllJobsBtn");
        logger.info("Going to Carrer Open Position screen");

    }
}
