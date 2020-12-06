package elements;

import static com.codeborne.selenide.Selenide.$x;

public class MainMenu {
    private String ITEM_PATTERN = "//div[contains(@class,'app-title') and contains(text(), '%s')]";


    public void clickOnItem(String itemName) {
        $x(String.format(ITEM_PATTERN, itemName)).click();
    }
}



//div[@class="ml-1 modes"]
//div[contains(@class,'app-title') and contains(text(), 'Summary')]