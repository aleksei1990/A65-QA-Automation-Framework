import org.testng.annotations.DataProvider;

public class DataPorviderCredentials {

    @DataProvider(name = "IncorrectLoginData")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"invalid@testpro.io", "invalidPassword"},
                {"aleksei.koksharov@testpro.io", "invalidPassword"},
                {"invalid@testpro.io", "ak1234!@#$"},
                {"aleksei.koksharov@testpro.io", ""},
                {"", "ak1234!@#$"},
        };
    }
    }
