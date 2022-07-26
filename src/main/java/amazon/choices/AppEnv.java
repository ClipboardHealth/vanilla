package amazon.choices;

import org.apache.xpath.operations.String;

import java.util.HashMap;
import java.util.Map;

public enum AppEnv {
    DEVELOP("app.env.develop"),
    STAGING("app.env.staging");

    public final String label;

    AppEnv(String label) {

        this.label = label;
    }

    private static final Map<String, AppEnv> BY_LABEL = new HashMap<>();

    static {
        for (AppEnv appEnv : values()) {
            BY_LABEL.put(appEnv.label, appEnv);
        }
    }

    // To get enum name from a label (choice specified in application.conf)
    public static AppEnv parse(java.lang.String label) {
        if (BY_LABEL.get(label) == null) {
            throw new IllegalStateException(String.format("%s is not a valid app env choice. Pick your app env from %s." +
                    "Check the value of 'APP_ENV' property in amazon.choices.conf; Or in CI, if running from continuous integration.", label, BY_LABEL.keySet()));
        } else {
            return BY_LABEL.get(label);
        }
    }
}
