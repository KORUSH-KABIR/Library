package ir.aid.library.Utils;

import android.app.Activity;

import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpPost;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.body.MultipartFormDataBody;

public class LoginServer {

    private static String DEVELOPER = "محمد علی ریاضتی";

    private Activity activity;
    private String[] key;
    private String[] value;
    private String url;
    private int length;

    public LoginServer(Activity activity){
        this.activity = activity;
    }

    public LoginServer setConfigUrl(String url){
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

    public LoginServer addRequest(String[] key , String[] value , int length){
        this.key = key;
        this.value = value;
        this.length = length - 1;
        return this;
    }

    private void login (final ConfigLogin configLogin){

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
                            configLogin.notConnection("can not Connect to Server");
                        }
                    });
                    t.start();
                }
                else if (result.equals("ban")){
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            configLogin.banningOrders("banned Account");
                        }
                    });
                    t.start();
                }
                else if (result.equals("yes")){
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            configLogin.success("have Account");
                        }
                    });
                    t.start();
                }
                else if (result.equals("no")){
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            configLogin.notFound("have not Account");
                        }
                    });
                    t.start();
                }
                else if (result.equals("null")){
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            configLogin.nullable("request is null");
                        }
                    });
                    t.start();
                }
            }
        });
    }

    public LoginServer getAnswer(final ConfigLogin configLogin){

        new Thread(new Runnable() {
            @Override
            public void run() {

                login(configLogin);
            }
        }).start();

        return this;
    }

    public interface ConfigLogin {

        void notConnection(String result);

        void success(String result);

        void banningOrders(String result);

        void notFound(String result);

        void nullable(String result);

    }

}
