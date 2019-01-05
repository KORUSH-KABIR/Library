package ir.aid.library.Frameworks.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import ir.aid.library.R;

public class FlasherImageView extends AppCompatImageView {

    private int fimDefaultColor;
    private int fimFirstColor;
    private int fimSecondColor;
    private int fimTimeChangeColor;
    private boolean fimStartAutoChange;
    private boolean stateColor;
    private Handler handler;
    private AutoChanger autoChanger;

    public FlasherImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context , AttributeSet attrs) {

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs , R.styleable.FIV, 0,0);

        fimDefaultColor = typedArray.getColor(R.styleable.FIV_fimDefaultColor,0);
        fimFirstColor = typedArray.getColor(R.styleable.FIV_fimFirstColor,0);
        fimSecondColor = typedArray.getColor(R.styleable.FIV_fimSecondColor,0);
        fimTimeChangeColor = typedArray.getColor(R.styleable.FIV_fimTimeChangeColor,0);
        fimStartAutoChange = typedArray.getBoolean(R.styleable.FIV_fimStartAutoChange,false);
        typedArray.recycle();

        handler = new Handler();
        autoChanger = new AutoChanger(this);

        initFirstCalled(this);

        if(fimStartAutoChange){
            start();
        }
    }

    private void initFirstCalled(FlasherImageView flasherImageView){
        flasherImageView.setColorFilter(fimDefaultColor);
    }

    public void autoChange(boolean auto){
        fimStartAutoChange = auto;
    }

    public void start(){
        if(fimStartAutoChange){
            handler.post(autoChanger);
        }
    }

    public void stop(){
        handler.removeCallbacks(autoChanger);
        initFirstCalled(this);
    }

    private class AutoChanger implements Runnable {

        private FlasherImageView flasherImageView;

        AutoChanger(FlasherImageView flasherImageView) {
            this.flasherImageView = flasherImageView;
        }

        @Override
        public void run() {

            if(stateColor){
                flasherImageView.setColorFilter(fimSecondColor);
                stateColor = false;
            }
            else {
                flasherImageView.setColorFilter(fimFirstColor);
                stateColor = true;
            }

            handler.postDelayed(this , fimTimeChangeColor);
        }
    }
}
