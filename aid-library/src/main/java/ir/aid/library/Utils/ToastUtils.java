package ir.aid.library.Utils;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntRange;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;
import ir.aid.library.R;

public class ToastUtils {

    private static String DEVELOPER = "محمد علی ریاضتی";

    public static final int TIME_LONG  = 1;
    public static final int TIME_SHORT = 0;
    public static final int CIRCLE_MODE  = 1;
    public static final int NORMAL_MODE = 0;
    private final Activity context;
    private RelativeLayout rootLayout;
    private CircleImageView picture;
    private ImageView pictureImg;
    private TextView description;
    private TextView title;
    private String text;
    private String desc;
    private int pic;
    private int mode = 3;
    private int duration;
    private LayoutInflater layoutInflater;

    public ToastUtils(Activity context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        rootLayout = (RelativeLayout)layoutInflater
                .inflate(R.layout.toast_layout, (RelativeLayout)context.findViewById(R.id.root_layout));

        picture = (CircleImageView) rootLayout.findViewById(R.id.picture);
        pictureImg = (ImageView) rootLayout.findViewById(R.id.pictureImg);
        description    = (TextView) rootLayout.findViewById(R.id.description);
        title          = (TextView) rootLayout.findViewById(R.id.title);
    }

    public ToastUtils setPicture(@DrawableRes int pic){
        this.pic = pic;
        return this;
    }

    public ToastUtils setPictureMode(@IntRange int mode){
        this.mode = mode;
        return this;
    }

    public ToastUtils setTitle(String text){
        this.text = text;
        title.setText(text);
        return this;
    }

    public ToastUtils setDescription(String desc){
        this.desc = desc;
        description.setText(desc);
        return this;
    }

    public ToastUtils setDuration(@IntRange int duration){
        this.duration = duration;
        return this;
    }

    public void showToast(){

        if(pic <= 0){
            picture.setVisibility(View.GONE);
        }

        if(mode < 2){
            if(mode == NORMAL_MODE){
                pictureImg.setVisibility(View.VISIBLE);
                picture.setVisibility(View.GONE);
                pictureImg.setImageDrawable(context.getResources().getDrawable(pic));
            }
            else if(mode == CIRCLE_MODE){
                picture.setVisibility(View.VISIBLE);
                pictureImg.setVisibility(View.GONE);
                picture.setImageDrawable(context.getResources().getDrawable(pic));
            }
        }
        else if(mode == 3) {
            pictureImg.setVisibility(View.VISIBLE);
            pictureImg.setImageDrawable(context.getResources().getDrawable(pic));
        }

        Toast toast = new Toast(context);
        toast.setDuration(duration);
        toast.setView(rootLayout);
        View view = toast.getView();
        view.setBackgroundResource(android.R.drawable.toast_frame);
        toast.show();
    }

}
