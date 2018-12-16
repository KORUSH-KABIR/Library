package ir.aid.library.pFrameworks.pHelper;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import ir.aid.library.R;

public class DialogHelper {

    private static String DEVELOPER = "محمد علی ریاضتی";

    public static final int MODE_1ST = 1;
    public static final int MODE_2ND = 2;
    private final Context context;
    private MaterialDialog.Builder mBuilder;
    private MaterialDialog mDialog;
    private LinearLayout mRootLayout , m1 , m2;
    private RelativeLayout mBackgroundIcon , mBackgroundIconHighlight;
    private ImageView mIcon;
    private TextView mTitle , mTextMessages;
    private Button mRight , mLeft , mCenter;

    public DialogHelper(Context context){
        this.context = context;
        mBuilder = new MaterialDialog.Builder(context);
        mBuilder.customView(R.layout.dialog, false);
        mDialog = mBuilder.build();
        init();
    }

    private void init(){

        mRootLayout = (LinearLayout) mDialog.findViewById(R.id.mRootLayout);
        m1          = (LinearLayout) mDialog.findViewById(R.id.m1);
        m2          = (LinearLayout) mDialog.findViewById(R.id.m2);

        mBackgroundIconHighlight = (RelativeLayout) mDialog.findViewById(R.id.mBackgroundIconHighlight);
        mBackgroundIcon          = (RelativeLayout) mDialog.findViewById(R.id.mBackgroundIcon);

        mTitle        = (TextView) mDialog.findViewById(R.id.mTitle);
        mTextMessages = (TextView) mDialog.findViewById(R.id.mTextMessages);

        mRight  = (Button) mDialog.findViewById(R.id.mRight);
        mLeft   = (Button) mDialog.findViewById(R.id.mLeft);
        mCenter = (Button) mDialog.findViewById(R.id.mCenter);

        mIcon = (ImageView) mDialog.findViewById(R.id.mIcon);

    }

    public DialogHelper setDialogBackgroundColor(@ColorInt int color){
        mRootLayout.setBackgroundColor(color);
        return this;
    }

    public DialogHelper setImageBackgroundDrawable(@DrawableRes int background){
        mBackgroundIcon.setBackground(context.getResources().getDrawable(background));
        return this;
    }

    public DialogHelper setImageBackgroundColor(@ColorInt int color){
        mBackgroundIcon.setBackgroundColor(color);
        return this;
    }

    public DialogHelper setImageDrawable(@DrawableRes int image){
        mIcon.setImageDrawable(context.getResources().getDrawable(image));
        return this;
    }

    public DialogHelper setTitleText(String title){
        mTitle.setText(title);
        return this;
    }

    public DialogHelper setMessageText(String message){
        mTextMessages.setText(message);
        return this;
    }

    public DialogHelper setModeButton(int mode){
        if(mode == DialogHelper.MODE_1ST){
            m2.setVisibility(View.GONE);
            m1.setVisibility(View.VISIBLE);
        }
        else if(mode == DialogHelper.MODE_2ND){
            m1.setVisibility(View.GONE);
            m2.setVisibility(View.VISIBLE);
        }
        return this;
    }

    public DialogHelper setButtonRight(String text , View.OnClickListener listener){
        mRight.setText(text);
        mRight.setOnClickListener(listener);
        return this;
    }

    public DialogHelper setButtonLeft(String text , View.OnClickListener listener){
        mLeft.setText(text);
        mLeft.setOnClickListener(listener);
        return this;
    }

    public DialogHelper setButtonCenter(String text , View.OnClickListener listener){
        mCenter.setText(text);
        mCenter.setOnClickListener(listener);
        return this;
    }

    public DialogHelper setSelectorButtonRight(@DrawableRes int selector){
        mRight.setBackground(context.getResources().getDrawable(selector));
        return this;
    }

    public DialogHelper setBackgroundButtonRightColor(@ColorInt int color){
        mRight.setBackgroundColor(color);
        return this;
    }

    public DialogHelper setSelectorButtonLeft(@DrawableRes int selector){
        mLeft.setBackground(context.getResources().getDrawable(selector));
        return this;
    }

    public DialogHelper setBackgroundButtonLeftColor(@ColorInt int color){
        mRight.setBackgroundColor(color);
        return this;
    }

    public DialogHelper setSelectorButtonCenter(@DrawableRes int selector){
        mCenter.setBackground(context.getResources().getDrawable(selector));
        return this;
    }

    public DialogHelper setBackgroundButtonCenterColor(@ColorInt int color){
        mRight.setBackgroundColor(color);
        return this;
    }

    public DialogHelper setHighlightShow(boolean show){
        if(show){
            mBackgroundIconHighlight.setVisibility(View.VISIBLE);
        }
        else {
            mBackgroundIconHighlight.setVisibility(View.GONE);
        }
        return this;
    }

    public DialogHelper autoCancel(boolean auto){
        mBuilder.cancelable(auto);
        return this;
    }

    public DialogHelper setCanceledOnTouchOutside(boolean canceled){
        mBuilder.canceledOnTouchOutside(canceled);
        return this;
    }

    public DialogHelper autoDismiss(boolean auto){
        mBuilder.autoDismiss(auto);
        return this;
    }

    public DialogHelper dismiss(){
        mDialog.dismiss();
        return this;
    }

    public DialogHelper show(){
        mDialog.getWindow().setBackgroundDrawable(context.getResources().getDrawable(R.drawable.dialog_background));
        mDialog.show();
        return this;
    }

}