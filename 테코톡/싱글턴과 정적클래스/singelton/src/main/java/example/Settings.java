package example;

import java.io.Serializable;

public class Settings implements Serializable {

    private Settings() {
    }

    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }

    /**
     * 역직렬화 대응 방안
     */
    protected Object readResolve() {
        return getInstance();
    }
}
