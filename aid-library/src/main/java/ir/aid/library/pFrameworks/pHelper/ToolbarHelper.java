package ir.aid.library.pFrameworks.pHelper;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import my.top.student.pFramework.pUtils.FrameworkException;

public class ToolbarHelper {

    private static String DEVELOPER = "محمد علی ریاضتی";

    private final Activity activity;

    public ToolbarHelper(Activity activity) {
        this.activity = activity;
    }

    public ToolbarHelper requestFeatures(int... features) {
        for(int feature : features){
            this.activity.getWindow().requestFeature(feature);
        }
        return this;
    }

    public ToolbarHelper noTitleBar(Boolean bln) {
        if(bln){
            activity.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        return this;
    }

    public ToolbarHelper noActionBar(Boolean bln) {

        if(bln){
            activity.getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            {
                ActionBar actionBar = activity.getActionBar();
                if(actionBar != null){
                    actionBar.hide();
                }
            }

            if(activity instanceof AppCompatActivity){
                AppCompatActivity casted = (AppCompatActivity) activity;
                android.support.v7.app.ActionBar actionBar = casted.getSupportActionBar();
                if(actionBar != null){
                    actionBar.hide();
                }
            }
        }
        return this;
    }

    public ToolbarHelper FullScreen(Boolean bln) {
        if(bln){
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        return this;
    }

    public ToolbarHelper Theme(@StyleRes int styleResID) {
        activity.setTheme(styleResID);
        return this;
    }

    public ToolbarHelper Title(String title) throws FrameworkException {
        if(title != null){
            activity.setTitle(title);
        }
        else {
            throw new FrameworkException("title is null");
        }
        return this;
    }

    public ToolbarHelper SubTitle(String subTitle) throws FrameworkException {
        if(subTitle != null){
            activity.getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            {
                ActionBar actionBar = activity.getActionBar();
                if(actionBar != null){
                    activity.getActionBar().setSubtitle(subTitle);
                }
            }
            if(activity instanceof AppCompatActivity){
                AppCompatActivity casted = (AppCompatActivity) activity;
                android.support.v7.app.ActionBar actionBar = casted.getSupportActionBar();
                if(actionBar != null){
                    ((AppCompatActivity) activity).getSupportActionBar().setSubtitle(subTitle);
                }
            }
        }else{
            throw new FrameworkException("subTitle is null");
        }
        return this;
    }

    public ToolbarHelper ButtonHome(Boolean home) throws FrameworkException {

        if(home != null){
            try{
                activity.getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
                {
                    ActionBar actionBar = activity.getActionBar();
                    if(actionBar != null){
                        activity.getActionBar().setDisplayHomeAsUpEnabled(true);
                    }
                }
            }catch(Exception e){
                if(activity instanceof AppCompatActivity){
                    AppCompatActivity casted = (AppCompatActivity) activity;
                    android.support.v7.app.ActionBar actionBar = casted.getSupportActionBar();
                    if(actionBar != null){
                        ((AppCompatActivity) activity).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    }
                }
            }
        }else{
            throw new FrameworkException("home shower boolean is null");
        }
        return this;
    }

    public ToolbarHelper HomeIcon(@DrawableRes int homeIcon) {
        try{
            activity.getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            {
                ActionBar actionBar = activity.getActionBar();
                if(actionBar != null){
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2){
                        activity.getActionBar().setHomeAsUpIndicator(homeIcon);
                    }
                }
            }
        }catch(Exception e){
            if(activity instanceof AppCompatActivity){
                AppCompatActivity casted = (AppCompatActivity) activity;
                android.support.v7.app.ActionBar actionBar = casted.getSupportActionBar();
                if(actionBar != null){
                    ((AppCompatActivity) activity).getSupportActionBar().setHomeAsUpIndicator(homeIcon);
                }
            }
        }
        return this;
    }

    public ToolbarHelper setLayoutView(@LayoutRes int layoutResID) {
        activity.setContentView(layoutResID);
        return this;
    }

}
