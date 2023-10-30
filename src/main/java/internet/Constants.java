package internet;

import java.time.format.DateTimeFormatter;

public class Constants {

    public static final DateTimeFormatter YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");

    public static final String BASE_URL = Config.getBaseUrl();
    public static final Boolean IS_HEADLESS = Config.getHeadless();
    public static final int TIMEOUT = Config.getTimeout();
    public static final String BROWSER = Config.getBrowser();
    public static final String BROWSER_SIZE = Config.getBrowserSize();
    public static final String BROWSER_VERSION = Config.getBrowserVersion();
    public static final String REPORTS_FOLDER_PATH = Config.getReportsFolderPath();
}
