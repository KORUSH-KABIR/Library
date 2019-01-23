package ir.phoenix_iran.library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ir.aid.library.Frameworks.utils.SharedPreferenceUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create();

    }

    private void create(){

        SharedPreferenceUtils utils = new SharedPreferenceUtils(this);
        utils.writeString("name" , "mohammad");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
