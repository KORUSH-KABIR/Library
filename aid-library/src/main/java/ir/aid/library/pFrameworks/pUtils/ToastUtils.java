package ir.aid.library.pFrameworks.pUtils;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;
import ir.aid.library.R;
import ir.aid.library.pInterfaces.DurationToast;
import ir.aid.library.pInterfaces.ToastMode;

public class ToastUtils {

    private static String DEVELOPER = "محمد علی ریاضتی";

    public static final int TIME_LONG  = 1;
    public static final int TIME_SHORT = 0;
    public static final int CIRCLE_MODE  = 1;
    public static final int NORMAL_MODE = 0;
    private static AppCompatActivity activity;
    private RelativeLayout rootLayout;
    private int pic;
    private int mode = 3;
    private int duration;
    private LayoutInflater layoutInflater;

    public ToastUtils(AppCompatActivity activity){
        this.activity = activity;
        init();
    }

    private void init(){

        layoutInflater = LayoutInflater.from(activity);
        rootLayout = (RelativeLayout)layoutInflater
                .inflate(R.layout.toast_layout, (RelativeLayout)activity.findViewById(R.id.root_layout));

        CircleImageView picture     = rootLayout.findViewById(R.id.picture);
        ImageView       pictureImg  = rootLayout.findViewById(R.id.pictureImg);
        TextView        description = rootLayout.findViewById(R.id.description);
        TextView        title       = rootLayout.findViewById(R.id.title);

    }

    public ToastUtils setPicture(@DrawableRes int pic){
        this.pic = pic;
        return this;
    }

    public ToastUtils setPictureMode(@ToastMode int mode){
        this.mode = mode;
        return this;
    }

    public ToastUtils setDuration(@DurationToast int duration){
        this.duration = duration;
        return this;
    }

    public void showToast(){

//        if(pic <= 0){
//            picture.setVisibility(View.GONE);
//        }
//
//        if(mode < 2){
//            if(mode == NORMAL_MODE){
//                pictureImg.setVisibility(View.VISIBLE);
//                picture.setVisibility(View.GONE);
//                pictureImg.setImageDrawable(activity.getResources().getDrawable(pic));
//            }
//            else if(mode == CIRCLE_MODE){
//                picture.setVisibility(View.VISIBLE);
//                pictureImg.setVisibility(View.GONE);
//                picture.setImageDrawable(activity.getResources().getDrawable(pic));
//            }
//        }
//        else if(mode == 3) {
//            pictureImg.setVisibility(View.VISIBLE);
//            pictureImg.setImageDrawable(activity.getResources().getDrawable(pic));
//        }
//
//        Toast toast = new Toast(activity);
//        toast.setDuration(duration);
//        toast.setView(rootLayout);
//        View view = toast.getView();
//        view.setBackgroundResource(android.R.drawable.toast_frame);
//        toast.show();
    }

    public static void makeDefaultToast(String text , @DurationToast int duration) {

        LayoutInflater inflate = (LayoutInflater)
                activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflate != null;
        View v = inflate.inflate(com.android.internal.R.layout.transient_notification, null);
        TextView tv = v.findViewById(com.android.internal.R.id.message);
        tv.setText(text);

        Toast result = new Toast(activity);
        result.setView(v);
        result.setDuration(duration);
        result.show();

    }

    public static void makeToastUtils(String title , String description , @ToastMode int mode , @DurationToast int duration) {

        LayoutInflater inflate = (LayoutInflater)
                activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflate != null;
        View view = inflate.inflate(R.layout.toast_layout, null);

        CircleImageView mPicture     = view.findViewById(R.id.picture);
        ImageView       mPictureImg  = view.findViewById(R.id.pictureImg);
        TextView        mDescription = view.findViewById(R.id.description);
        TextView        mTitle       = view.findViewById(R.id.title);

        mTitle.setText(title);
        mDescription.setText(description);

        Toast result = new Toast(activity);
        result.setView(view);
        result.setDuration(duration);
        result.show();
    }

}
