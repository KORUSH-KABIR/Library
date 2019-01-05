package ir.aid.library.pFrameworks.pUtils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceUtils {

    private static final String DEVELOPER = "محمد علی ریاضتی";

    private Context context;

    public SharedPreferenceUtils(Context context) {
        this.context = context;
    }

    private SharedPreferences preference() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String readString(String key, String alternative) {
        return preference().getString(key, alternative);
    }

    public float readFloat(String key, float alternative) {
        return preference().getFloat(key, alternative);
    }

    public long readLong(String key, long alternative) {
        return preference().getLong(key, alternative);
    }

    public int readInteger(String key, int alternative) {
        return preference().getInt(key, alternative);
    }

    public boolean readBoolean(String key, boolean alternative) {
        return preference().getBoolean(key, alternative);
    }

    public void writeString(String key, String str) {
        SharedPreferences.Editor editor = preference().edit();
        editor.putString(key, str);
        editor.apply();
    }

    public void writeFloat(String key, float flt) {
        SharedPreferences.Editor editor = preference().edit();
        editor.putFloat(key , flt);
        editor.apply();
    }

    public void writeLong(String key, long lng) {
        SharedPreferences.Editor editor = preference().edit();
        editor.putLong(key,lng);
        editor.apply();
    }

    public void writeInteger(String key, int integer) {
        SharedPreferences.Editor editor = preference().edit();
        editor.putInt(key, integer);
        editor.apply();
    }

    public void writeBoolean(String key, boolean bln) {
        SharedPreferences.Editor editor = preference().edit();
        editor.putBoolean(key, bln);
        editor.apply();
    }

}
