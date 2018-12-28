package ir.phoenix_iran.library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

        IntroDesignHelper intro = new IntroDesignHelper(this , R.id.viewPager);
        intro.setItemsMode(R.layout.intro_model , 3);

        intro.showIntroDesign();


        ToastBuilder.ToastUtils.build(this , "title" , "description" , R.drawable.pic_profile , ToastBuilder.NORMAL_MODE , ToastBuilder.TIME_LONG);
        ToastBuilder.CustomToast.build(this , R.layout.toast_layout_test , ToastBuilder.TIME_LONG);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
