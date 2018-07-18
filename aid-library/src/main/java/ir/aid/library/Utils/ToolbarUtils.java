package ir.aid.library.Utils;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class ToolbarUtils {

    private static String DEVELOPER = "محمد علی ریاضتی";

    private final Activity activity;
    private int[] features;
    private boolean noTitleBar;
    private boolean noActionBar;
    private boolean fullscreen;
    private int layoutId;
    private String title;
    private String SubTitle;
    private Boolean home;
    private int homeIcon;
    private int style;

    public ToolbarUtils(Activity activity){
        this.activity = activity;
    }

    public ToolbarUtils requestFeatures(int... features){

        this.features = features;

        for (int feature: this.features){
            this.activity.getWindow().requestFeature(feature);
        }

        return this;
    }

    public ToolbarUtils noTitleBar(Boolean b){

        this.noTitleBar = b;

        if (noTitleBar == true){
            activity.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        else {
            ////////////
        }

        return this;
    }

    public ToolbarUtils noActionBar(Boolean b){

        this.noActionBar = b;

        if (noActionBar == true){
            activity.getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            {
                ActionBar actionBar = activity.getActionBar();
                if (actionBar != null) {
                    actionBar.hide();
                }
            }

            if (activity instanceof AppCompatActivity) {
                AppCompatActivity casted = (AppCompatActivity) activity;
                android.support.v7.app.ActionBar actionBar = casted.getSupportActionBar();
                if (actionBar != null) {
                    actionBar.hide();
                }
            }
        }
        else {
            /////////////
        }

        return this;
    }

    public ToolbarUtils FullScreen(Boolean b){

        this.fullscreen = b;

        if (fullscreen){
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        return this;
    }

    public ToolbarUtils Theme(@StyleRes int styleResID){

        this.style = styleResID;

        activity.setTheme(style);

        return this;
    }

    public ToolbarUtils Title(String t){

        this.title = t;

        if (title != null) {
            activity.setTitle(title);
        }

        return this;
    }

    public ToolbarUtils SubTitle(String s){

        this.SubTitle = s;

        if (SubTitle != null) {

            activity.getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            {
                ActionBar actionBar = activity.getActionBar();
                if (actionBar != null) {
                    activity.getActionBar().setSubtitle(SubTitle);                    }
            }

            if (activity instanceof AppCompatActivity) {
                AppCompatActivity casted = (AppCompatActivity) activity;
                android.support.v7.app.ActionBar actionBar = casted.getSupportActionBar();
                if (actionBar != null) {
                    ((AppCompatActivity) activity).getSupportActionBar().setSubtitle(SubTitle);
                }
            }
        }
        else {
            /////////////////
        }

        return this;
    }

    public ToolbarUtils ButtonHome(Boolean b){

        this.home = b;

        if (home != null){

            try{
                activity.getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
                {
                    ActionBar actionBar = activity.getActionBar();
                    if (actionBar != null) {
                        activity.getActionBar().setDisplayHomeAsUpEnabled(true);
                    }
                }
            }
            catch (Exception e){
                if (activity instanceof AppCompatActivity) {
                    AppCompatActivity casted = (AppCompatActivity) activity;
                    android.support.v7.app.ActionBar actionBar = casted.getSupportActionBar();
                    if (actionBar != null) {
                        ((AppCompatActivity) activity).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    }
                }
            }
        }
        else {
            /////////////////
        }

        return this;
    }

    public ToolbarUtils HomeIcon(@DrawableRes int icon){

        this.homeIcon = icon;

        try{
            activity.getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            {
                ActionBar actionBar = activity.getActionBar();
                if (actionBar != null) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                        activity.getActionBar().setHomeAsUpIndicator(homeIcon);
                    }
                }
            }
        }
        catch (Exception e){
            if (activity instanceof AppCompatActivity) {
                AppCompatActivity casted = (AppCompatActivity) activity;
                android.support.v7.app.ActionBar actionBar = casted.getSupportActionBar();
                if (actionBar != null) {
                    ((AppCompatActivity) activity).getSupportActionBar().setHomeAsUpIndicator(homeIcon);
                }
            }
        }

        return this;
    }

    public ToolbarUtils setLayoutView(@LayoutRes int layoutResID){

        this.layoutId = layoutResID;

        activity.setContentView(layoutId);

        return this;
    }

}
