package ir.aid.library.pFrameworks.pWidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import ir.aid.library.R;

public class CustomImageView extends AppCompatImageView {

    private int cimDefaultColor;
    private int cimFirstColor;
    private int cimSecondColor;
    private int cimTimeChangeColor;
    private boolean cimStartAutoChange;
    private boolean stateColor;
    private Handler handler;
    private AutoChanger autoChanger;

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context , AttributeSet attrs) {

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs , R.styleable.CustomImageView , 0,0);

        cimDefaultColor    = typedArray.getColor(R.styleable.CustomImageView_cimDefaultColor,0);
        cimFirstColor      = typedArray.getColor(R.styleable.CustomImageView_cimFirstColor,0);
        cimSecondColor     = typedArray.getColor(R.styleable.CustomImageView_cimSecondColor,0);
        cimTimeChangeColor = typedArray.getColor(R.styleable.CustomImageView_cimTimeChangeColor,0);
        cimStartAutoChange = typedArray.getBoolean(R.styleable.CustomImageView_cimStartAutoChange ,false);
        typedArray.recycle();

        handler = new Handler();
        autoChanger = new AutoChanger(this);

        initFirstCalled(this);

        if(cimStartAutoChange){
            start();
        }
    }

    private void initFirstCalled(CustomImageView customImageView){
        customImageView.setColorFilter(cimDefaultColor);
    }

    public void autoChange(boolean auto){
        cimStartAutoChange = auto;
    }

    public void start(){
        if(cimStartAutoChange){
            handler.post(autoChanger);
        }
    }

    public void stop(){
        handler.removeCallbacks(autoChanger);
        initFirstCalled(this);
    }

    private class AutoChanger implements Runnable {

        private CustomImageView customImageView;

        AutoChanger(CustomImageView customImageView) {
            this.customImageView = customImageView;
        }

        @Override
        public void run() {

            if(stateColor){
                customImageView.setColorFilter(cimSecondColor);
                stateColor = false;
            }
            else {
                customImageView.setColorFilter(cimFirstColor);
                stateColor = true;
            }

            handler.postDelayed(this , cimTimeChangeColor);
        }
    }
}
