package ir.aid.library.Utils;

import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class LanguageUtils {

    private static String DEVELOPER = "محمد علی ریاضتی";

    public void changeLanguage(Resources res , String lng){

        Configuration config;
        config = new Configuration(res.getConfiguration());

        switch (lng){
            case "en":
                config.locale = new Locale("en");
                break;

            case "fa":
                config.locale = new Locale("fa");
                break;

            default:
                config.locale = new Locale("fa");
                break;
        }

        res.updateConfiguration(config,res.getDisplayMetrics());
    }
}
