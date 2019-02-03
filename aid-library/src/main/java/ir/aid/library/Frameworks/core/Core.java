package ir.aid.library.Frameworks.core;

import android.app.Application;

import ir.aid.library.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Core extends Application {

    public void setupFont(String fontName){

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(fontName)
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
