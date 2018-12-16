package ir.aid.library.pFrameworks.pUtils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtils {

    private static String DEVELOPER = "محمد علی ریاضتی";

    private Context context;

    public SharedPreferenceUtils(Context context) {
        this.context = context;
    }

    private SharedPreferences preference(String spFileName) {
        return context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
    }

    public String readString(String spFileName, String key, String alternative) {
        return preference(spFileName).getString(key, alternative);
    }

    public float readFloat(String spFileName, String key, float alternative) {
        return preference(spFileName).getFloat(key, alternative);
    }

    public long readLong(String spFileName, String key, long alternative) {
        return preference(spFileName).getLong(key, alternative);
    }

    public int readInteger(String spFileName, String key, int alternative) {
        return preference(spFileName).getInt(key, alternative);
    }

    public boolean readBoolean(String spFileName, String key, boolean alternative) {
        return preference(spFileName).getBoolean(key, alternative);
    }

    public void writeString(String spFileName, String key, String str) {
        SharedPreferences.Editor editor = preference(spFileName).edit();
        editor.putString(key, str);
        editor.apply();
    }

    public void writeFloat(String spFileName, String key, float flt) {
        SharedPreferences.Editor editor = preference(spFileName).edit();
        editor.putFloat(key , flt);
        editor.apply();
    }

    public void writeLong(String spFileName, String key, long lng) {
        SharedPreferences.Editor editor = preference(spFileName).edit();
        editor.putLong(key,lng);
        editor.apply();
    }

    public void writeInteger(String spFileName, String key, int integer) {
        SharedPreferences.Editor editor = preference(spFileName).edit();
        editor.putInt(key, integer);
        editor.apply();
    }

    public void writeBoolean(String spFileName, String key, boolean bln) {
        SharedPreferences.Editor editor = preference(spFileName).edit();
        editor.putBoolean(key, bln);
        editor.apply();
    }

}
