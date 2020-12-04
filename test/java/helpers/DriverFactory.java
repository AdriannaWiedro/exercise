package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;

public class DriverFactory {
    private static WebDriver driverInstance;

    public static WebDriver getDriver(DriverType driverType) throws NoSuchDriverException {
        if (driverInstance == null) {
            getSpecificDriver(driverType);
            driverInstance.manage().window().maximize();
        }
        return driverInstance;
    }

    private static void getSpecificDriver(DriverType driverType) throws NoSuchDriverException {
        ChromeOptions options = new ChromeOptions();
        switch (driverType) {

            case CHROME:
                File driverExe = new File("src//main//resources//executables//drivers//chromedriver.exe");
                ChromeDriverService driverService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(driverExe)
                        .usingAnyFreePort().build();
                driverInstance = new ChromeDriver(driverService);

                break;
            case FIREFOX:
                File firefoxExe = new File("src//main//resources//executables//drivers//geckodriver.exe");
                GeckoDriverService GeckoDriverServiceService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(firefoxExe)
                        .usingAnyFreePort().build();
                driverInstance = new FirefoxDriver(GeckoDriverServiceService);
                break;
            default:
                System.out.println("The driver does not exist!");
                throw new NoSuchDriverException();
        }
    }
}