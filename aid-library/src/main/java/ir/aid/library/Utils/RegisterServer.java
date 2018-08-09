package ir.aid.library.Utils;

import android.app.Activity;

import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpPost;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.body.MultipartFormDataBody;

public class RegisterServer {

    private static String DEVELOPER = "محمد علی ریاضتی";

    private Activity activity;
    private String[] key;
    private String[] value;
    private String url;
    private int length;

    public RegisterServer(Activity activity){
        this.activity = activity;
    }

    public RegisterServer setConfigUrl(String url){
        if (!url.equals("")) {
            this.url = url;
        }
        return this;
    }

    private void requests(MultipartFormDataBody body){
        for (int position = 0; position <= length; position++) {
            body.addStringPart(key[position], value[position]);
        }
    }

    public RegisterServer addRequest(String[] key , String[] value , int length){
        this.key = key;
        this.value = value;
        this.length = length - 1;
        return this;
    }

    private void register (final ConfigRegister configRegister){

        AsyncHttpPost post = new AsyncHttpPost(url);

        post.setTimeout(5000);

        MultipartFormDataBody body = new MultipartFormDataBody();

        requests(body);

        post.setBody(body);

        AsyncHttpClient.getDefaultInstance().executeString(post, new AsyncHttpClient.StringCallback() {
            @Override
            public void onCompleted(final Exception e, AsyncHttpResponse source, String result) {

                if (e != null){

                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            e.printStackTrace();
                            configRegister.notConnection("can not Connect to Server");
                        }
                    });
                    t.start();
                }
                else if (result.equals("old")){

                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            configRegister.haveThisAccount("Already have this username");
                        }
                    });
                    t.start();
                }
                else if (result.equals("ok")){

                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            configRegister.success("registering... success!");
                        }
                    });
                    t.start();
                }
                else if (result.equals("no")){
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            configRegister.error("registering... failed!");
                        }
                    });
                    t.start();
                }
                else if (result.equals("null")){
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            configRegister.nullable("failed!");
                        }
                    });
                    t.start();
                }
            }
        });
    }

    public RegisterServer getAnswer(final ConfigRegister configRegister){

        new Thread(new Runnable() {
            @Override
            public void run() {
                register(configRegister);
            }
        }).start();

        return this;
    }

    public interface ConfigRegister {

        void notConnection(String result);

        void haveThisAccount(String result);

        void success(String result);

        void error(String result);

        void nullable(String result);

    }

}
