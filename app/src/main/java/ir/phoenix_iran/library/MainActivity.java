package ir.phoenix_iran.library;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ir.aid.library.pFrameworks.pHelper.DialogHelper;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void createDialog(){

        DialogHelper dialog = new DialogHelper(this)
                .setDialogBackgroundColor(getResources().getColor(R.color.c6))
                .setImageBackgroundColor(getResources().getColor(R.color.colorAccent))
                .setImageDrawable(R.drawable.dialog_icon)
                .setTitleText("title")
                .setMessageText("message")
                .setModeButton(DialogHelper.MODE_2ND) // 2 Button
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
                .setSelectorButtonLeft(R.drawable.dialog_selector_button)
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
