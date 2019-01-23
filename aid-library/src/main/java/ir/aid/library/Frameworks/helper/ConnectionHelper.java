package ir.aid.library.Frameworks.helper;

import android.support.annotation.NonNull;

import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpPost;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.body.MultipartFormDataBody;

import java.io.File;

import ir.aid.library.Interfaces.OnGetResponse;

/*
  this class is responsible for sending values to the server and
  receiving the response with Async.
 */
public class ConnectionHelper {

    private static final String DEVELOPER = "محمد علی ریاضتی";

    private String configUrl;              // url php connection
    private int timeOut;                  // time out request
    private MultipartFormDataBody body = new MultipartFormDataBody();

    /**
     * can be accessed from the outside.
     * @param configUrl url php connection.
     * @param timeOut time out connection.
     */
    public ConnectionHelper(@NonNull String configUrl , int timeOut){
        this.timeOut = timeOut;
        this.configUrl = configUrl;
    }

    /**
     * can be accessed from the outside.
     * @param key string key for sending to the server.
     * @param value string value for sending to the server.
     * @return class
     */
    public ConnectionHelper addStringRequest(String key , String value){
        body.addStringPart(key , value);
        return this;
    }

    /**
     * can be accessed from the outside.
     * @param key string key for sending to the server.
     * @param path string path file for sending to the server.
     * @return class
     */
    public ConnectionHelper addFileRequest(String key , String path){
        body.addFilePart(key , new File(path));
        return this;
    }

    /**
     * can not be accessed from the outside.
     * sending request to the server.
     * @param onGetResponse interface for get callback.
     */
    private void load(final OnGetResponse onGetResponse) {

        AsyncHttpPost post = new AsyncHttpPost(configUrl);

        post.setTimeout(timeOut);

        post.setBody(body);

        AsyncHttpClient.getDefaultInstance().executeString(post, new AsyncHttpClient.StringCallback() {
            @Override
            public void onCompleted(Exception e, AsyncHttpResponse source, String result) {

                if (e != null){
                    e.printStackTrace();
                    onGetResponse.notConnectToServer();
                }
                else if (result.equals("null")){
                    onGetResponse.onNullResponse(); //result is Null
                }
                else if (!result.equals("")){
                    onGetResponse.onSuccessResponse(result); //result is JSON callback
                }
            }
        });
    }

    /**
     * can be accessed from the outside.
     * @param onGetResponse interface callback.
     * @return class.
     */
    public ConnectionHelper getResponse(final OnGetResponse onGetResponse){

        new Thread(new Runnable() {
            @Override
            public void run() {
                load(onGetResponse);
            }
        }).start();
        return this;
    }

}
