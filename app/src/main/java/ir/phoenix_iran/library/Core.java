package ir.phoenix_iran.library;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Core extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Font();
    }

    private void Font(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("iran_sans.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

}
