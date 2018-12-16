package ir.phoenix_iran.library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ir.aid.library.pFrameworks.pHelper.DialogHelper;
import ir.aid.library.pFrameworks.pUtils.ToastBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDialog();

    }

    private void createDialog(){

        new DialogHelper(this)
                .setTitleText("title")
                .setMessageText("message")
                .autoCancel(true)
                .autoDismiss(true)
                .setDialogBackgroundShape(R.drawable.dialog_background)
                .setCanceledOnTouchOutside(true).show();

        ToastBuilder.ToastUtils.build(this , "title" , "description" , R.drawable.pic_profile , ToastBuilder.NORMAL_MODE , ToastBuilder.TIME_LONG);
        ToastBuilder.CustomToast.build(this , R.layout.toast_layout_test , ToastBuilder.TIME_LONG);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
