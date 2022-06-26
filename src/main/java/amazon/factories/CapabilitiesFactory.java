package amazon.factories;

import amazon.choices.Browser;
import amazon.config.EnvFactory;
import com.typesafe.config.Config;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.time.Duration;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;

import static java.lang.Boolean.parseBoolean;

public class CapabilitiesFactory {
    private static Config config = EnvFactory.getInstance().getConfig();

    private static final boolean HEADLESS = parseBoolean(config.getString("HEADLESS"));
    private static final boolean ACCEPT_INSECURE_CERTIFICATES = parseBoolean(config.getString("ACCEPT_INSECURE_CERTIFICATES"));
    private static final String SELENIUM_LOG_LEVEL = config.getString("SELENIUM_LOG_LEVEL");
    private static final String DOWNLOADS_DIR = config.getString("DOWNLOADS_DIR");
    /*
        Defining IMPLICIT_WAIT.
        This will help reduce flakiness when page load is extremely fast.
        Specially done for headless execution.
     */
    private static final Long IMPLICIT_WAIT = Long.valueOf(5);

    public static Capabilities getCapabilities(Browser browser) {
        switch (browser) {
            case CHROME:
                return getChromeOptions();
            case FIREFOX:
                return getFirefoxOptions();
            case OPERA:
                return getOperaOptions();
            case EDGE:
                return getEdgeOptions();
            default:
                throw new IllegalStateException(String.format("%s is not a valid browser choice. Pick your browser from %s.", browser, java.util.Arrays.asList(browser.values())));
        }
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(ACCEPT_INSECURE_CERTIFICATES);
        chromeOptions.setHeadless(HEADLESS);
        chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems and a must-have step to run tests in docker pipeline or docker selenium grid
        chromeOptions.addArguments("--no-sandbox"); // overcome limited resource problems and a should-have step to run tests in docker pipeline or docker selenium grid
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--enable-javascript");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(IMPLICIT_WAIT));

        Map<String, Object> prefs = new Hashtable<String, Object>();
        prefs.put("plugins.always_open_pdf_externally", true);
        prefs.put("download.default_directory", String.format("%s\\%s", System.getProperty("user.dir"), DOWNLOADS_DIR));
        prefs.put("profile.default_content_settings.cookies", 2);
        chromeOptions.setExperimentalOption("prefs", prefs);

        // To get error console logs
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.parse(SELENIUM_LOG_LEVEL));
        chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(ACCEPT_INSECURE_CERTIFICATES);
        firefoxOptions.setHeadless(HEADLESS);
        firefoxOptions.setImplicitWaitTimeout(Duration.ofSeconds(IMPLICIT_WAIT));
        return firefoxOptions;
    }

    public static OperaOptions getOperaOptions() {
        OperaOptions operaOptions = new OperaOptions();
        operaOptions.setImplicitWaitTimeout(Duration.ofSeconds(IMPLICIT_WAIT));
        return operaOptions;
    }

    public static EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions =  new EdgeOptions();
        edgeOptions.setImplicitWaitTimeout(Duration.ofSeconds(IMPLICIT_WAIT));
        return edgeOptions;
    }
}
