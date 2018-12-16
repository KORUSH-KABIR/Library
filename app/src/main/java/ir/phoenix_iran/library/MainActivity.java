package ir.phoenix_iran.library;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ir.aid.library.pFrameworks.pHelper.DialogHelper;
import ir.aid.library.pFrameworks.pUtils.ToastUtils;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDialog();

    }

    private void createDialog(){

        DialogHelper dialog = new DialogHelper(this)
                .setDialogBackgroundColor(getResources().getColor(R.color.c6))
                .setTitleText("title")
                .setMessageText("message")
                .autoCancel(true)
                .autoDismiss(true)
                .setCanceledOnTouchOutside(true);
        dialog.show();

        ToastUtils.makeDefaultToast("ali" , ToastUtils.TIME_LONG);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
