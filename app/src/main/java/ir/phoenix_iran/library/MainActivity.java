package ir.phoenix_iran.library;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ir.aid.library.R.layout.activity_main);

        createToast();

        createSharedPreferences();

    }

   private void createToast(){

       new ToastUtils(this)
               .setDuration(ToastUtils.TIME_LONG)
               .setPicture(android.R.drawable.btn_star_big_on)
               .setTitle("بدون مود")
               .setDescription("انجام شد.")
               .showToast();

       new ToastUtils(this)
               .setDuration(ToastUtils.TIME_LONG)
               .setPictureMode(ToastUtils.CIRCLE_MODE)
               .setPicture(android.R.drawable.btn_star_big_on)
               .setTitle("مود دایره")
               .setDescription("انجام شد.")
               .showToast();

       new ToastUtils(this)
               .setDuration(ToastUtils.TIME_LONG)
               .setPictureMode(ToastUtils.NORMAL_MODE)
               .setPicture(android.R.drawable.btn_star_big_on)
               .setTitle("مود نرمال")
               .setDescription("انجام شد.")
               .showToast();
   }

   private void createSharedPreferences(){

       SharedPreferenceUtils.writeString(MainActivity.this,
               "File Shared Preference",
               "value SP",
               "Text Saved"
       );

       String s = SharedPreferenceUtils.readString(MainActivity.this,
               "File Shared Preference",
               "value SP",
               "Alternative"
       );

       Toast.makeText(this, "txt: (" + s + ")", Toast.LENGTH_SHORT).show();
   }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
