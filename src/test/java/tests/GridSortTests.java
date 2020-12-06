package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.GridPage;
import pages.LoginPage;
import pages.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.Selenide.sleep;

public class GridSortTests {
    private static LoginPage loginPage;
    private static GridPage gridPage;

    @BeforeAll
    public static void sighIn() {

        loginPage = PageFactory.createPage(LoginPage.class);
        loginPage.openLoginPage();
        gridPage=PageFactory.createPage(GridPage.class);
        gridPage.openGridPage();
    }
    @Test
    public void checkColumnsVisibilityTest() {

        gridPage.openCloseFilterMenu();
        gridPage.clickIdFilter();
        sleep(2000);
        Assertions.assertFalse(gridPage.checkVisibleIdColumnHeader());
        gridPage.clickIdFilter();
        sleep(2000);
        Assertions.assertTrue(gridPage.checkVisibleIdColumnHeader());
        gridPage.openCloseFilterMenu();

        gridPage.openClosrToolPanelMenu();
        gridPage.clickIdCheckbox();
        sleep(2000);
        Assertions.assertFalse(gridPage.checkVisibleIdColumnHeader());
        gridPage.clickIdCheckbox();
        sleep(2000);
        Assertions.assertTrue(gridPage.checkVisibleIdColumnHeader());
        gridPage.openClosrToolPanelMenu();

        gridPage.openIdHeaderCellMenu();
        gridPage.clickAgTab3();
        gridPage.clickIdCheckboxColsList();
        sleep(2000);
        Assertions.assertFalse(gridPage.checkVisibleIdColumnHeader());
        gridPage.clickIdCheckboxColsList();
        sleep(2000);
        Assertions.assertTrue(gridPage.checkVisibleIdColumnHeader());
        gridPage.clickAgTab3();

    }

    @Test
    public void checkTypeSortTest(){

        gridPage.setFilterForSort();
        gridPage.clickTypeColumnHeaderName();
        sleep(2000);

        List<SelenideElement> typeValueUpList = gridPage.setTypeValueUpDownList();
        String type2="A";
        String type1;

        for (int i = 0; i < typeValueUpList.size() - 1; i++) {
            type1 = gridPage.getTypeValue(i);

            int compare = type1.compareTo(type2);

            Assertions.assertTrue(compare>=0);
            type2=type1;
        }
        Assertions.assertTrue(gridPage.checkSortTypeButton());

        gridPage.clickTypeColumnHeaderName();
        sleep(2000);

        List<SelenideElement> typeValueDownList = gridPage.setTypeValueUpDownList();
        type2="Z";
        for(int i=typeValueDownList.size()-2;i>=0;i--){
            type1 = gridPage.getTypeValue(i);
            int compare = type1.compareTo(type2);

            Assertions.assertTrue(compare<=0);
            type2=type1;
        }
        gridPage.clickTypeColumnHeaderName();
        Assertions.assertFalse(gridPage.checkSortTypeButton());

        gridPage.setFilterForSort();
    }


    @Test
    public void checkStartTimeSortTest() throws ParseException {

        gridPage.setFilterForSort();
        gridPage.clickStartTimeHeaderName();
        sleep(2000);

        List<SelenideElement> startTimeValueUpList = gridPage.setStartTimeUpDownList();
        long time1 = 0;
        long time2 = 0;
        for (int i = 0; i < startTimeValueUpList.size() - 1; i++) {
            String string_date = gridPage.getStartTimeValue(i);
            SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

            try {
                Date d = f.parse(string_date);
                time1 = d.getTime();

            } catch (ParseException e) {
                e.printStackTrace();
            }
            Assertions.assertTrue(time1 >= time2);
            time2 = time1;
        }

        gridPage.clickStartTimeHeaderName();
        sleep(2000);
        List<SelenideElement> startTimeValueDownList = gridPage.setStartTimeUpDownList();
        time2 = 0;
        for (int i = startTimeValueDownList.size() - 2; i >= 0; i--) {
            String string_date = gridPage.getStartTimeValue(i);
            SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            try {
                Date d = f.parse(string_date);
                time2 = d.getTime();

            } catch (ParseException e) {
                e.printStackTrace();
            }
            Assertions.assertTrue(time2 >= time1);
            time1 = time2;
        }
        gridPage.clickStartTimeHeaderName();
        Assertions.assertFalse(gridPage.checkSortStartTimeButton());
        gridPage.setFilterForSort();

    }


    @Test
    public void avgUpDownSortTest() {
        gridPage.setFilterForSort();
        gridPage.clickAvgFillPriceHeaderName();
        sleep(3000);
        List<SelenideElement> avgValueUpList = gridPage.setAvgUpDownList();
        double avg1 = 0.0;
        double avg2 = 0.0;
        for (int i = 0; i < avgValueUpList.size() - 1; i++) {
            String b = gridPage.getAvgValue(i);
            avg2 = Double.parseDouble(b);
            Assertions.assertTrue(avg2 >= avg1);
            avg1 = avg2;

            Assertions.assertTrue(gridPage.checkSortAvgButton());
        }

        gridPage.clickAvgFillPriceHeaderName();
        sleep(3000);
        List<SelenideElement> avgValueDownList =gridPage.setAvgUpDownList();
        avg2 = 0;
        for (int i = avgValueDownList.size() - 2; i >= 0; i--) {
            String a = gridPage.getAvgValue(i);
            avg1 = Double.parseDouble(a);
            Assertions.assertTrue(avg1 >= avg2);
            avg2 = avg1;
        }
        gridPage.clickAvgFillPriceHeaderName();
        Assertions.assertFalse(gridPage.checkSortAvgButton());
        gridPage.setFilterForSort();
    }


    @Test
    public void numExecSortTest() {
        gridPage.setFilterForSort();
        gridPage.clickNumOfExecutionHeaderName();
        sleep(3000);

        List<SelenideElement> numOfExecutionsValueUpList = gridPage.setNumOfExecUpDownList();

        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < numOfExecutionsValueUpList.size() - 1; i++) {
            String b = gridPage.getNumOfExecValue(i);
            num2 = Integer.parseInt(b);
            Assertions.assertTrue(num2 >= num1);
            num1 = num2;
        }

        Assertions.assertTrue(gridPage.checkSortNumOfExecButton());

        gridPage.clickNumOfExecutionHeaderName();
        sleep(3000);
        List<SelenideElement> numOfExecutionsValueDownList =gridPage.setNumOfExecUpDownList();
        num2 = 0;
        for (int i = numOfExecutionsValueUpList.size() - 2; i >= 0; i--) {
            String a = gridPage.getNumOfExecValue(i);
            num1 = Integer.parseInt(a);

            Assertions.assertTrue(num1 >= num2);
            num2 = num1;
        }
        gridPage.clickNumOfExecutionHeaderName();
        Assertions.assertFalse(gridPage.checkSortNumOfExecButton());

        gridPage.setFilterForSort();

    }
    @AfterAll
    public static void sighOut() {

        loginPage.sighOut();
    }



}
