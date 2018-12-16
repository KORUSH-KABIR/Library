package ir.aid.library.pFrameworks.pUtils;

import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

import ir.aid.library.pInterfaces.LanguageMode;

public class LanguageUtils {

    public static final String ENGLISH = "en";
    public static final String PERSIAN = "fa";

    public static void changeLanguage(Resources res , @LanguageMode String lng){

        Configuration config = new Configuration(res.getConfiguration());

        switch (lng){
            case ENGLISH:
                config.locale = new Locale("en");
                break;

            case PERSIAN:
                config.locale = new Locale("fa");
                break;

            default:
                config.locale = new Locale("fa");
                break;
        }
        res.updateConfiguration(config,res.getDisplayMetrics());
    }
}