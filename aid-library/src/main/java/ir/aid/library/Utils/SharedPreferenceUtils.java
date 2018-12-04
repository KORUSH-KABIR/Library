package ir.aid.library.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtils {

    private static String DEVELOPER = "محمد علی ریاضتی";

    private static SharedPreferences preference(Context context, String spFileName) {
        return context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
    }

    public static String readString(Context context, String spFileName, String key, String alternative) {
        return preference(context, spFileName).getString(key, alternative);
    }

    public static float readFloat(Context context, String spFileName, String key, float alternative) {
        return preference(context, spFileName).getFloat(key, alternative);
    }

    public static long readLong(Context context, String spFileName, String key, long alternative) {
        return preference(context, spFileName).getLong(key, alternative);
    }

    public static int readInteger(Context context, String spFileName, String key, int alternative) {
        return preference(context, spFileName).getInt(key, alternative);
    }

    public static boolean readBoolean(Context context, String spFileName, String key, boolean alternative) {
        return preference(context, spFileName).getBoolean(key, alternative);
    }

    public static void writeString(Context context, String spFileName, String key, String str) {
        SharedPreferences.Editor editor = preference(context, spFileName).edit();
        editor.putString(key, str);
        editor.apply();
    }

    public static void writeFloat(Context context, String spFileName, String key, float flt) {
        SharedPreferences.Editor editor = preference(context, spFileName).edit();
        editor.putFloat(key , flt);
        editor.apply();
    }

    public static void writeLong(Context context, String spFileName, String key, long lng) {
        SharedPreferences.Editor editor = preference(context, spFileName).edit();
        editor.putLong(key,lng);
        editor.apply();
    }

    public static void writeInteger(Context context, String spFileName, String key, int integer) {
        SharedPreferences.Editor editor = preference(context, spFileName).edit();
        editor.putInt(key, integer);
        editor.apply();
    }

    public static void writeBoolean(Context context, String spFileName, String key, boolean bln) {
        SharedPreferences.Editor editor = preference(context, spFileName).edit();
        editor.putBoolean(key, bln);
        editor.apply();
    }

}
