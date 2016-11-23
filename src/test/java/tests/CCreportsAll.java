package tests;

import browserTests.TestBase;
import org.testng.annotations.Test;

import static steps.CCreportSteps.*;


/**
 * Created by abarabas on 11/16/16.
 */
public class CCreportsAll extends TestBase {

    @Test(parameters = {"buildNumber"})
    public static void ccReportGenerateBilling(String buildNumber) {

        String teamName = "Billing";

        navigateToMainPage();
        login();
        choseControlCenter();
        clickOnReporting();
        clickOnFilterSession();
        selectBuildNumberAs(buildNumber);
        selectTeamByName(teamName);
        clickOnApplyListSettings();
        selectAllTestSets();
        clickOnGenerateReportButton();
        saveSummaryTable(teamName);
    }

    @Test(parameters = {"buildNumber"})
    public void ccReportGeneratePlatform(String buildNumber) {

        String teamName = "Platform";

        navigateToMainPage();
        login();
        choseControlCenter();
        clickOnReporting();
        clickOnFilterSession();
        selectBuildNumberAs(buildNumber);
        selectTeamByName(teamName);
        clickOnApplyListSettings();
        selectAllTestSets();
        clickOnGenerateReportButton();
        saveSummaryTable(teamName);
    }

    @Test(parameters = {"buildNumber"})
    public void ccReportGenerateProvisioning(String buildNumber) {

        String teamName = "Provisioning";

        navigateToMainPage();
        login();
        choseControlCenter();
        clickOnReporting();
        clickOnFilterSession();
        selectBuildNumberAs(buildNumber);
        selectTeamByName(teamName);
        clickOnApplyListSettings();
        selectAllTestSets();
        clickOnGenerateReportButton();
        saveSummaryTable(teamName);
    }

    @Test(parameters = {"buildNumber"})
    public void ccReportGenerateCW(String buildNumber) {

        String teamName = "Custom Work";

        navigateToMainPage();
        login();
        choseControlCenter();
        clickOnReporting();
        clickOnFilterSession();
        selectBuildNumberAs(buildNumber);
        selectTeamByName(teamName);
        clickOnApplyListSettings();
        selectAllTestSets();
        clickOnGenerateReportButton();
        saveSummaryTable(teamName);
    }

    @Test(parameters = {"buildNumber"})
    public void ccReportGenerateEOD(String buildNumber) {

        String teamName = "EOD";

        navigateToMainPage();
        login();
        choseControlCenter();
        clickOnReporting();
        clickOnFilterSession();
        selectBuildNumberAs(buildNumber);
        selectTeamByName(teamName);
        clickOnApplyListSettings();
        selectAllTestSets();
        clickOnGenerateReportButton();
        saveSummaryTable(teamName);
    }

    @Test(parameters = {"buildNumber"})
    public void ccReportGenerateWirelessQA(String buildNumber) {

        String teamName = "Wireless QA";

        navigateToMainPage();
        login();
        choseControlCenter();
        clickOnReporting();
        clickOnFilterSession();
        selectBuildNumberAs(buildNumber);
        selectTeamByName(teamName);
        clickOnApplyListSettings();
        selectAllTestSets();
        clickOnGenerateReportButton();
        saveSummaryTable(teamName);
    }


}
