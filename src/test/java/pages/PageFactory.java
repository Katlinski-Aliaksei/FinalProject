package pages;


public class PageFactory {

    public static <T extends BaseSitePage> T createPage(Class<T> pageClass) {

        if (pageClass.equals(LoginPage.class)){
            return (T) new LoginPage();
        }

        if (pageClass.equals(SummaryPage.class)) {
            return(T)  new SummaryPage();
        }
        if (pageClass.equals(GridPage.class)){
            return (T) new GridPage();
        }
        if (pageClass.equals(HistogramPage.class)){
            return (T) new HistogramPage();
        }
        if (pageClass.equals(ScatterplotPage.class)){
            return (T) new ScatterplotPage();
        }
        if (pageClass.equals(ReportsPage.class)){
            return (T) new ReportsPage();
        }

        throw new IllegalArgumentException("Page with specified type is not supported by PageFactory");
    }
}

