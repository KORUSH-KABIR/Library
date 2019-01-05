package ir.aid.library.pFrameworks.pHelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutionException;

import ir.aid.library.R;

public class PhotoHelper {

    private static final String DEVELOPER = "محمد علی ریاضتی";

    private static String APP_DIR;
    private final Context context;

    public PhotoHelper(Context context) {
        this.context = context;
        String SD_CARD = Environment.getExternalStorageDirectory().getAbsolutePath();
        APP_DIR = SD_CARD + "/Android/data/" + context.getPackageName() + "/files";
    }

    public PhotoHelper(Context context , String path) {
        this.context = context;
        APP_DIR = path;
    }

    public String getAppDir() {
        return APP_DIR;
    }

    public void downloadFromUrlWithPicasso(String url , ImageView imageView){
        Picasso.with(context)
                .load(url)
                .placeholder(android.R.drawable.stat_sys_download)
                .error(R.drawable.pic_profile)
                .into(imageView);
    }

    public void downloadFromUrlWithGlide(String url , ImageView imageView){
        Glide.with(context)
                .load(url)
                .placeholder(android.R.drawable.stat_sys_download)
                .error(R.drawable.pic_profile)
                .into(imageView);
    }

    public void setPhotoFromFilesWithPicasso(String path , ImageView imageView){
        File file = new File(path);
        Uri uri = Uri.fromFile(file);
        Picasso.with(context)
                .load(uri)
                .placeholder(android.R.drawable.stat_sys_download)
                .error(R.drawable.pic_profile)
                .into(imageView);
    }

    public void setPhotoFromFilesWithGlide(String path , ImageView imageView){
        File file = new File(path);
        Uri uri = Uri.fromFile(file);
        Glide.with(context)
                .load(uri)
                .placeholder(android.R.drawable.stat_sys_download)
                .error(R.drawable.pic_profile)
                .into(imageView);
    }

    public void savePhotoFromUrlToAppDir(final String path , final String url , final String fileName){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Bitmap cache = Glide.with(context)
                            .load(url)
                            .asBitmap()
                            .into(280 , 280)
                            .get();
                    File file = new File(path , "/" + fileName);
                    OutputStream outputStream = new FileOutputStream(file);
                    cache.compress(Bitmap.CompressFormat.JPEG,70,outputStream);
                    outputStream.flush();
                    outputStream.close();
                }catch(InterruptedException | ExecutionException | IOException e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public void setGifToImageView(Uri uri , ImageView imageView){
        Glide.with(context)
                .load(uri)
                .asGif()
                .placeholder(android.R.drawable.stat_sys_download)
                .error(R.drawable.pic_profile)
                .into(imageView);
    }

    public void setGifToImageView(String url , ImageView imageView){
        Glide.with(context)
                .load(url)
                .asGif()
                .placeholder(android.R.drawable.stat_sys_download)
                .error(R.drawable.pic_profile)
                .into(imageView);
    }

    public void setGifToImageView(File file , ImageView imageView){
        Glide.with(context)
                .load(file)
                .asGif()
                .placeholder(android.R.drawable.stat_sys_download)
                .error(R.drawable.pic_profile)
                .into(imageView);
    }
}
