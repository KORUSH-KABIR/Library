package ir.phoenix_iran.library;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

import ir.aid.library.pFrameworks.pHelper.IntroDesignHelper;
import ir.aid.library.pFrameworks.pUtils.ToastBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create();

    }

    private void create(){

        final IntroDesignHelper intro = new IntroDesignHelper(this , R.id.viewPager)
                .setItemsMode(R.layout.intro_model , 3);

        intro.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                View view = intro.getView();

                Random cR7 = new Random();

                view.setBackgroundColor(Color.argb(255 , cR7.nextInt(256) , cR7.nextInt(256) , cR7.nextInt(256)));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        intro.showIntroDesign();

        ToastBuilder.ToastUtils.build(this , "title" , "description" , R.drawable.pic_profile , ToastBuilder.NORMAL_MODE , ToastBuilder.TIME_LONG);
        ToastBuilder.CustomToast.build(this , R.layout.toast_layout_test , ToastBuilder.TIME_LONG);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
