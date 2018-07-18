package ir.aid.library.Utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

public class DialogUtils {

    private static String DEVELOPER = "محمد علی ریاضتی";

    private final Activity context;
    private View v;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private int background;
    private String buttonP;
    private String buttonNG;
    private String buttonNE;

    public DialogUtils(Activity context){
        this.context = context;
        createDialog(crateDialogBuilder());
    }

    private Activity getContext(){
        return context;
    }

    private AlertDialog createDialog(AlertDialog.Builder builder){
        dialog = builder.create();
        return dialog;
    }

    private AlertDialog.Builder crateDialogBuilder(){
        builder = new AlertDialog.Builder(getContext());
        return builder ;
    }

    private LayoutInflater createInflater(){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        return inflater;
    }

    private View addLayout(@LayoutRes int layout){
        v = createInflater().inflate(layout, null);
        return v;
    }

    public DialogUtils setLayout(@LayoutRes int layout){
        builder.setView(addLayout(layout));
        return this;
    }

    public DialogUtils setBackground(@DrawableRes int background){
        this.background = background;
        return this;
    }

    public DialogUtils setTitle(String title){
        if (!title.equals("")){
            builder.setTitle(title);
        }
        return this;
    }

    @SuppressLint("ResourceType")
    public DialogUtils setIcon(@DrawableRes int icon){
        if (icon > 0){
            builder.setIcon(icon);
        }
        return this;
    }

    public DialogUtils setMessage(String message){
        if (!message.equals("")){
            builder.setMessage(message);
        }
        return this;
    }

    public DialogUtils setItems(String[] array, DialogInterface.OnClickListener listener){
        builder.setItems(array,listener);
        return this;
    }

    public DialogUtils autoCancel(boolean autoCancel){
        builder.setCancelable(autoCancel);
        return this;
    }

    public DialogUtils positiveButton(String button){
        this.buttonP = button;
        return this;
    }

    public DialogUtils negativeButton(String button){
        this.buttonNG = button;
        return this;
    }

    public DialogUtils neutralButton(String button){
        this.buttonNE = button;
        return this;
    }

    public DialogUtils setOnClickPositiveListener(DialogInterface.OnClickListener listener){
        if (!buttonP.equals("")){
            builder.setPositiveButton(buttonP,listener);
        }
        return this;
    }

    public DialogUtils setOnClickNegativeListener(DialogInterface.OnClickListener listener){
        if (!buttonNG.equals("")){
            builder.setPositiveButton(buttonNG,listener);
        }
        return this;
    }

    public DialogUtils setOnClickNeutralListener(DialogInterface.OnClickListener listener){
        if (!buttonNE.equals("")){
            builder.setPositiveButton(buttonNE,listener);
        }
        return this;
    }

    public DialogUtils viewListener(View view , int id , View.OnClickListener listener){
        view = (View) v.findViewById(id);
        view.setOnClickListener(listener);
        return this;
    }

    public DialogUtils show(){
        dialog = builder.create();
        if (background > 0 ){
            dialog.getWindow()
                    .setBackgroundDrawable(getContext()
                            .getResources()
                            .getDrawable(background));
        }
        dialog.show();
        return this;
    }
}