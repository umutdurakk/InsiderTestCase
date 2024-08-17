package insider.umutd.page;

import insider.umutd.methods.BaseMethods;

public class JobPage extends BaseMethods {

    public void checkJobPage(){
        switchToSecondTab();
        waitForElementToBeVisible("jobTitleInJobPage");
        isSavedValueEqualExpectedValue("jobTitleInJobPage","selectedJobsPositionTitle");
        isSavedValueEqualExpectedValue("jobDepartmentInJobPage","selectedJobsPositionDepartment");
        isSavedValueEqualExpectedValue("jobLocationInJobPage","selectedJobsPositionLocation");

    }
}
