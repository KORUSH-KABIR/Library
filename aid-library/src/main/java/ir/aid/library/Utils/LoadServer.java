package ir.aid.library.Utils;

import android.app.Activity;

import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpPost;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.body.MultipartFormDataBody;

import java.io.File;

public class LoadServer {

    private static String DEVELOPER = "محمد علی ریاضتی";

    private Activity activity;
    private String url;
    private String[] keyS;
    private String[] valueS;
    private int lengthS;
    private String[] keyF;
    private String[] valueF;
    private int lengthF;

    public LoadServer(Activity activity){
        this.activity = activity;
    }

    public LoadServer setConfigUrl(String url){
        if (!url.equals("")) {
            this.url = url;
        }
        return this;
    }

    private void requestsString(MultipartFormDataBody body){
        for (int position = 0; position <= lengthS; position++) {
            body.addStringPart(keyS[position], valueS[position]);
        }
    }

    private void requestsFile(MultipartFormDataBody body){
        for (int position = 0; position <= lengthF; position++) {
            body.addFilePart(keyF[position], new File(valueF[position]));
        }
    }

    public LoadServer addStringRequest(String[] key , String[] value , int length){
        this.keyS = key;
        this.valueS = value;
        this.lengthS = length - 1;
        return this;
    }

    public LoadServer addFileRequest(String[] key , String[] value , int length){
        this.keyF = key;
        this.valueF = value;
        this.lengthF = length - 1;
        return this;
    }

    private void load(final ConfigLoad configLoad){

        AsyncHttpPost post = new AsyncHttpPost(url);

        post.setTimeout(5000);

        MultipartFormDataBody body = new MultipartFormDataBody();

        if(!keyF[0].equals("")){
            requestsString(body);
            requestsFile(body);
        }
        else {
            requestsString(body);
        }

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
