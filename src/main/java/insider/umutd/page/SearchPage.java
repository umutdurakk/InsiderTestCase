package insider.umutd.page;

import insider.umutd.methods.BaseMethods;

public class SearchPage extends BaseMethods {


    public void filterJobDetails() {
        waitForElementToBeVisible("checkSearchPageisOpen");
        clickElement("locationFilterBox");
        clickElement("selectIstanbulLocation");
        waitBySecond(1);
        clickElement("departmentFilterBox");
        clickElement("selectQualityAssuranceDepartment");

    }

    public void checkPresenceOfTheJobsList() {
        scrollToElementToBeVisible("sectionCarrerListTitle");
        checkForElement("sectionOfThePositionArea", "Browse Open Positions section not visible");
        checkForElement("sectionCarrerListTitle", "Browse Open Positions section not visible");
    }

    public void checkAllJobsDetailContains() {
        checkIsTextContainsList("jobsPositionTitles", "Quality Assurance");
        //Here I save the job details in a hashmap because I use it to compare on the last page,
        // and I do this for the last job in the backlog because
        // the size of the backlog can change at any time
        saveValueLastJob("jobsPositionTitles");
        checkIsTextContainsList("jobsPositionDepartment", "Quality Assurance");
        saveValueLastJob("jobsPositionDepartment");
        checkIsTextContainsList("jobsPositionLocation", "Istanbul, Turkey");
        saveValueLastJob("jobsPositionLocation");
        waitBySecond(1);
    }

    public void clickViewRoleBtn() {
        hoverOverElementWithSelectedSize("viewRoleButton");
        clickElementWithSelectedSize("viewRoleButton");
        logger.info("Seçilen Job ekranına gidiliyor");


    }
}
