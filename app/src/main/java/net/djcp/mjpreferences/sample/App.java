package net.djcp.mjpreferences.sample;

import android.app.Application;
import net.djcp.mjpreferences.Preferences;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new Preferences.Builder()
                .setContext(this)
                .setPreferencesName("mjPreferences-Sample")
                .build();
    }
}
