package net.djcp.mjpreferences;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;

import java.util.Set;

public final class Preferences {

    private static SharedPreferences mPreferences;

    public Preferences(Context context, String preferencesName) {
        mPreferences = context.getSharedPreferences(preferencesName, ContextWrapper.MODE_PRIVATE);
    }

    private static void apply(final SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static SharedPreferences getPreferences() {
        return mPreferences;
    }

    public static boolean getBoolean(final String key, final  boolean defValue) {
        return getPreferences().getBoolean(key, defValue);
    }

    public static float getFloat(final String key, final  float defValue) {
        return getPreferences().getFloat(key, defValue);
    }

    public static float getFloat(final String key) {
        return getPreferences().getFloat(key, 0);
    }

    public static int getInt(final String key, final  int defValue) {
        return getPreferences().getInt(key, defValue);
    }

    public static int getInt(final String key) {
        return getPreferences().getInt(key, 0);
    }

    public static long getLong(final String key, final  long defValue) {
        return getPreferences().getLong(key, defValue);
    }

    public static long getLong(final String key) {
        return getPreferences().getLong(key, 0);
    }

    public static String getString(final String key, final  String defValue) {
        return getPreferences().getString(key, defValue);
    }

    public static String getString(final String key) {
        return getPreferences().getString(key, "");
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static Set<String> getStringSet(final String key, final  Set<String> defValue) {
        return getPreferences().getStringSet(key, defValue);
    }

    public static void putBoolean(final String key, final boolean value) {
        final SharedPreferences.Editor editor = getPreferences().edit();
        editor.putBoolean(key, value);
        apply(editor);
    }

    public static void putFloat(final String key, final float value) {
        final SharedPreferences.Editor editor = getPreferences().edit();
        editor.putFloat(key, value);
        apply(editor);
    }

    public static void putInt(final String key, final int value) {
        final SharedPreferences.Editor editor = getPreferences().edit();
        editor.putInt(key, value);
        apply(editor);
    }

    public static void putLong(final String key, final long value) {
        final SharedPreferences.Editor editor = getPreferences().edit();
        editor.putLong(key, value);
        apply(editor);
    }

    public static void putString(final String key, final String value) {
        final SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(key, value);
        apply(editor);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void putStringSet(final String key, final Set<String> value) {
        final SharedPreferences.Editor editor = getPreferences().edit();
        editor.putStringSet(key, value);
        apply(editor);
    }

    public final static class Builder {

        private Context mContext;
        private String mPreferencesName;

        public Builder setPreferencesName(final String preferencesName) {
            mPreferencesName = preferencesName;
            if (TextUtils.isEmpty(mPreferencesName)) {
                mPreferencesName = mContext.getPackageName();
            }
            return this;
        }

        public Builder setContext(final Context context) {
            mContext = context;
            return this;
        }

        public Preferences build() {
            if (mContext == null) {
                throw new NullPointerException("Context not set, please set context before building the Preferences instance.");
            }
            Preferences prefManager = new Preferences(mContext, mPreferencesName);
            return prefManager;
        }
    }
}
