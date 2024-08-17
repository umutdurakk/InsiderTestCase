package insider.umutd.tests;

import insider.umutd.driver.BaseTest;
import insider.umutd.page.CareerPage;
import insider.umutd.page.HomePage;
import insider.umutd.page.JobPage;
import insider.umutd.page.SearchPage;
import org.junit.Test;

public class InsederWebAutomationTest extends BaseTest {

    @Test
    public void webAutomationTest(){
        HomePage homePage = new HomePage();
        CareerPage careerPage = new CareerPage();
        SearchPage searchPage = new SearchPage();
        JobPage jobPage = new JobPage();

        homePage.selectCareerDropDownButton();
        careerPage.checkCareerPage();
        careerPage.gotoSearchJobPage();
        searchPage.filterJobDetails();
        searchPage.checkJobsPanels();
        searchPage.clickViewRoleBtn();
        jobPage.checkJobPage();

    }
}
