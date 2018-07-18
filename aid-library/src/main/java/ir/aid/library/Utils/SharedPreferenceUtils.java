package ir.aid.library.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtils {

    private static String DEVELOPER = "محمد علی ریاضتی";

    private static SharedPreferences preference(Activity activity , String name){
        SharedPreferences sharedPreferences = activity.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sharedPreferences;
    }

    public static String readString(Activity activity , String name , String value , String alternative){
        final String str = preference(activity,name).getString(value , alternative);
        return str;
    }

    public static int readInteger(Activity activity , String name , String value , int alternative){
        final int i = preference(activity,name).getInt(value , alternative);
        return i;
    }

    public static boolean readBoolean(Activity activity , String name , String value , boolean alternative){
        final boolean b = preference(activity,name).getBoolean(value , alternative);
        return b;
    }

    public static void writeString(Activity activity , String name , String value , String text){
        SharedPreferences.Editor editor = preference(activity,name).edit();
        editor.putString(value,text);
        editor.apply();
    }

    public static void writeInteger(Activity activity , String name , String value , int i){
        SharedPreferences.Editor editor = preference(activity,name).edit();
        editor.putInt(value,i);
        editor.apply();
    }

    public static void writeBoolean(Activity activity , String name , String value , boolean bln){
        SharedPreferences.Editor editor = preference(activity,name).edit();
        editor.putBoolean(value,bln);
        editor.apply();
    }

}
