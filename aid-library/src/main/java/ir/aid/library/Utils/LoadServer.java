package ir.aid.library.Utils;

import android.app.Activity;

import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpPost;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.body.MultipartFormDataBody;

public class LoadServer {

    private static String DEVELOPER = "محمد علی ریاضتی";

    private Activity activity;
    private String[] key;
    private String[] value;
    private String url;
    private int length;

    public LoadServer(Activity activity){
        this.activity = activity;
    }

    public LoadServer setConfigUrl(String url){
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

    public LoadServer addRequest(String[] key , String[] value , int length){
        this.key = key;
        this.value = value;
        this.length = length - 1;
        return this;
    }

    private void load(final ConfigLoad configLoad){

        AsyncHttpPost post = new AsyncHttpPost(url);

        post.setTimeout(5000);

        MultipartFormDataBody body = new MultipartFormDataBody();

        requests(body);

        post.setBody(body);

        AsyncHttpClient.getDefaultInstance().executeString(post, new AsyncHttpClient.StringCallback() {
            @Override
            public void onCompleted(final Exception e, AsyncHttpResponse source, final String result) {

                if (e != null){
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            e.printStackTrace();
                            configLoad.notConnection("can not Connect to Server");
                        }
                    });
                }
                else if (!result.equals("")){
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            configLoad.success(result);
                        }
                    });
                }
                else if (result.equals("null")){
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            configLoad.nullable("request is null");
                        }
                    });
                }
            }
        });
    }

    public LoadServer getAnswer(ConfigLoad configLoad){

        load(configLoad);

        return this;
    }

    public interface ConfigLoad {

        void notConnection(String result);

        void success(String result);

        void nullable(String result);

    }

}
