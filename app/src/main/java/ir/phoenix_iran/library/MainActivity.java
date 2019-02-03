package ir.phoenix_iran.library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ir.aid.library.Frameworks.helper.ConnectionHelper;
import ir.aid.library.Interfaces.OnGetResponse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create();

        new ConnectionHelper("" , 15000)
                .addStringRequest("" , "")
                .addHeaderRequest("" , "")
                .setHeaderRequest("" , "")
                .getStringResponse(new OnGetResponse() {
                    @Override
                    public void notConnectToServer() {

                    }

                    @Override
                    public void onSuccessResponse(String result) {

                    }

                    @Override
                    public void onNullResponse() {

                    }
                });

    }

    private void create(){


    }

}
