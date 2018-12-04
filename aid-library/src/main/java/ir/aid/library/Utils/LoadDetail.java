package ir.aid.library.Utils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpPost;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.body.MultipartFormDataBody;

import java.io.File;

import ir.aid.library.Interface.ConfigLoad;

/*
  this class is responsible for sending values to the server and
  receiving the response with Async.
 */
public class LoadDetail {

    private String configUrl;              // url php connection
    private int timeOut;                  // time out request
    private MultipartFormDataBody body = new MultipartFormDataBody();

    /**
     * can be accessed from the outside.
     * @param configUrl url php connection.
     * @param timeOut time out connection.
     */
    public LoadDetail(@NonNull String configUrl , int timeOut){
        this.timeOut = timeOut;
        this.configUrl = configUrl;
    }

    /**
     * can be accessed from the outside.
     * @param key string key for sending to the server.
     * @param value string value for sending to the server.
     * @return class
     */
    public LoadDetail addStringRequest(String key , String value){
        body.addStringPart(key , value);
        return this;
    }

    /**
     * can be accessed from the outside.
     * @param key string key for sending to the server.
     * @param path string path file for sending to the server.
     * @return class
     */
    public LoadDetail addFileRequest(String key , String path){
        body.addFilePart(key , new File(path));
        return this;
    }

    /**
     * can not be accessed from the outside.
     * sending request to the server.
     * @param configLoad interface for get callback.
     */
    private void load(final ConfigLoad configLoad){

        AsyncHttpPost post = new AsyncHttpPost(configUrl);

        post.setTimeout(timeOut);

        post.setBody(body);

        AsyncHttpClient.getDefaultInstance().executeString(post, new AsyncHttpClient.StringCallback() {
            @Override
            public void onCompleted(final Exception e, AsyncHttpResponse source, final String result) {

                if (e != null){
                    e.printStackTrace();
                    configLoad.notConnection("can not Connect to Server");
                }
                else if (!result.equals("")){
                    configLoad.success(result); //result is JSON callback
                }
            }
        });
    }

    /**
     * can be accessed from the outside.
     * @param configLoad interface callback.
     * @return class.
     */
    public LoadDetail getResult(final ConfigLoad configLoad){

        Thread load = new Thread(new Runnable() {
            @Override
            public void run() {
                load(configLoad);
            }
        });
        Log.i("CentralCore" , load.getName());
        load.start();
        return this;
    }

}
