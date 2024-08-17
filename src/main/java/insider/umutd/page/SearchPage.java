package insider.umutd.page;

import insider.umutd.driver.BaseTest;
import insider.umutd.methods.BaseMethods;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class SearchPage extends BaseMethods {


    public void filterJobDetails(){
        waitForElementToBeVisible("checkSearchPageisOpen");
        clickElement("locationFilterBox");
        clickElement("selectIstanbulLocation");
        waitBySecond(1);
        clickElement("departmentFilterBox");
        clickElement("selectQualityAssuranceDepartment");

    }

    public void checkJobsPanels(){
        scrollToElementToBeVisible("sectionOfThePositionAreaTitle");
        checkForElement("sectionOfThePositionArea","Browse Open Positions  section not visible");
        checkIsTextContainsList("jobsPositionTitles","Quality Assurance");
        saveValue("selectedJobsPositionTitle");
        checkIsTextContainsList("jobsPositionDepartment","Quality Assurance");
        saveValue("selectedJobsPositionDepartment");
        checkIsTextContainsList("jobsPositionLocation","Istanbul, Turkey");
        saveValue("selectedJobsPositionLocation");
        waitBySecond(1);
    }

    public void clickViewRoleBtn(){
        hoverOverElement("viewRoleButton");
        clickElement("viewRoleButton");
        logger.info("Seçilen Job ekranına gidiliyor");


    }
}
