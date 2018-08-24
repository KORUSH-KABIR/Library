package ir.phoenix_iran.library;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ir.aid.library.Utils.DialogUtils;
import ir.aid.library.Utils.SharedPreferenceUtils;
import ir.aid.library.Utils.ToastUtils;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createToast();

        createSharedPreferences();

        TextView txt = (TextView) findViewById(R.id.txt);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialog();
            }
        });
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

    private void createDialog(){

        DialogUtils dialog = new DialogUtils(this)
                .setDialogBackgroundColor(getResources().getColor(R.color.colorAccent))
                .setImageBackgroundDrawable(R.drawable.dialog_background)
                .setImageBackgroundColor(getResources().getColor(R.color.colorAccent))
                .setImageDrawable(R.drawable.dialog_icon)
                .setTitleText("title")
                .setMessageText("message")
                .setModeButton(DialogUtils.MODE_2ND) // 2 Button
                .setButtonRight("right", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setButtonLeft("left", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setSelectorButtonRight(R.drawable.dialog_selector_button)
                .setBackgroundButtonRightColor(getResources().getColor(R.color.colorAccent))
                .setSelectorButtonLeft(R.drawable.dialog_selector_button)
                .setBackgroundButtonLeftColor(getResources().getColor(R.color.colorAccent))
                .setHighlightShow(true)
                .autoCancel(true)
                .autoDismiss(true)
                .setCanceledOnTouchOutside(true);

        dialog.show();

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
