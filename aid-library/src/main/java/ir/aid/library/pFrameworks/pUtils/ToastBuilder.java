package ir.aid.library.pFrameworks.pUtils;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;
import ir.aid.library.R;
import ir.aid.library.pInterfaces.DurationToast;
import ir.aid.library.pInterfaces.ToastMode;

public class ToastBuilder {

    private static String DEVELOPER = "محمد علی ریاضتی";

    public static final int TIME_LONG  = 1;
    public static final int TIME_SHORT = 0;
    public static final int CIRCLE_MODE = 1;
    public static final int NORMAL_MODE = 0;

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

    public static class defaultToast {

        public static void build(Context context , String text , @DurationToast int duration){

            LayoutInflater inflate = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflate != null;
            View v = inflate.inflate(com.android.internal.R.layout.transient_notification, null);
            TextView tv = v.findViewById(com.android.internal.R.id.message);
            tv.setText(text);

            Toast result = new Toast(context);
            result.setView(v);
            result.setDuration(duration);
            result.show();
        }
    }

    public static class ToastUtils {

        //private static CardView mCardView;
        private static CircleImageView mPictureCircle;
        private static ImageView mPictureNormal;
        private static TextView mDescription;
        private static TextView mTitle;

        public static void build(Context context , String title , String description , @DrawableRes int icon , @ToastMode int mode , @DurationToast int duration){

            LayoutInflater inflate = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflate != null;
            View view = inflate.inflate(R.layout.toast_layout, null);

            mPictureCircle = view.findViewById(R.id.mCircleImageView);
            mPictureNormal = view.findViewById(R.id.mImageView);
            mDescription   = view.findViewById(R.id.mDescription);
            CardView mCardView      = view.findViewById(R.id.mCardView);
            mTitle         = view.findViewById(R.id.mTitle);

            setMode(mode);

            mTitle.setText(title);
            mDescription.setText(description);
            mPictureCircle.setImageDrawable(context.getResources().getDrawable(icon));
            mPictureNormal.setImageDrawable(context.getResources().getDrawable(icon));

            Toast result = new Toast(context);
            result.setView(view);
            result.setDuration(duration);
            result.show();
        }

        private static void setMode(int mode){
            switch(mode){
                case NORMAL_MODE:
                    mPictureNormal.setVisibility(View.VISIBLE);
                    mPictureCircle.setVisibility(View.GONE);
                    break;
                case CIRCLE_MODE:
                    mPictureNormal.setVisibility(View.GONE);
                    mPictureCircle.setVisibility(View.VISIBLE);
                    break;
                default:
                    mPictureNormal.setVisibility(View.VISIBLE);
                    mPictureCircle.setVisibility(View.GONE);
                    break;
            }
        }
    }

    public static class CustomToast {

        public static void build(Context context , @LayoutRes int layout , @DurationToast int duration){

            LayoutInflater inflate = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            assert inflate != null;
            View view = inflate.inflate(layout, null);

            Toast result = new Toast(context);
            result.setView(view);
            result.setDuration(duration);
            result.show();
        }
    }

}
