package ir.aid.library.pFrameworks.pHelper;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;

import com.afollestad.materialdialogs.MaterialDialog;

public class DialogHelper {

    private static String DEVELOPER = "محمد علی ریاضتی";

    private final Context context;
    private MaterialDialog.Builder mBuilder;

    public DialogHelper(Context context){
        this.context = context;
        mBuilder = new MaterialDialog.Builder(context);
    }

    private MaterialDialog.Builder getBuilder(){
        return mBuilder;
    }

    private MaterialDialog getDialog(){
        return getBuilder().build();
    }

    public DialogHelper setCustomView(@LayoutRes int layout , boolean scrollable){
        getBuilder().customView(layout , scrollable);
        return this;
    }

    public DialogHelper setDialogBackgroundColor(@ColorInt int color){
        mBuilder.backgroundColor(color);
        return this;
    }

    public DialogHelper setDialogBackgroundShape(@DrawableRes int shapeBackground){
        getDialog().getWindow().setBackgroundDrawable(context.getResources().getDrawable(shapeBackground));
        return this;
    }

    public DialogHelper setTitleText(String title){
        mBuilder.title(title);
        return this;
    }

    public DialogHelper setMessageText(String message){
        mBuilder.content(message);
        return this;
    }

    public DialogHelper autoCancel(boolean bln){
        mBuilder.cancelable(bln);
        return this;
    }

    public DialogHelper setCanceledOnTouchOutside(boolean bln){
        mBuilder.canceledOnTouchOutside(bln);
        return this;
    }

    public DialogHelper autoDismiss(boolean bln){
        mBuilder.autoDismiss(bln);
        return this;
    }

    public DialogHelper dismiss(){
        getDialog().dismiss();
        return this;
    }

    public DialogHelper show(){
        getDialog().show();
        return this;
    }

}