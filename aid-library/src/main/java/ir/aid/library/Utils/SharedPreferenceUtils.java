package ir.aid.library.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtils {

    private static String DEVELOPER = "محمد علی ریاضتی";

    private static SharedPreferences preference(Context context, String spFileName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        return sharedPreferences;
    }

    public static String readString(Context context, String spFileName, String key, String alternative) {
        final String str = preference(context, spFileName).getString(key, alternative);
        return str;
    }

    public static int readInteger(Context context, String spFileName, String key, int alternative) {
        final int integer = preference(context, spFileName).getInt(key, alternative);
        return integer;
    }

    public static boolean readBoolean(Context context, String spFileName, String key, boolean alternative) {
        final boolean bln = preference(context, spFileName).getBoolean(key, alternative);
        return bln;
    }

    public static void writeString(Context context, String spFileName, String key, String text) {
        SharedPreferences.Editor editor = preference(context, spFileName).edit();
        editor.putString(key, text);
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
