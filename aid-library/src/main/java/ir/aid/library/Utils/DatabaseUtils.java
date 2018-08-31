package ir.aid.library.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseUtils {

    private final Context context;
    private SQLiteDatabase mDatabase ;
    public static final int INT      = 0;
    public static final int DECIMAL  = 1;
    public static final int VARCHAR  = 2;
    public static final int FLOAT    = 3;
    public static final int DOUBLE   = 4;
    public static final int TEXT     = 5;
    public static final int DATE     = 6;
    public static final int TIME     = 7;
    public static final int DATETIME = 8;
    public static final int BOOLEAN  = 9;
    private String[] mode = {
            "INT",
            "DECIMAL",
            "VARCHAR",
            "FLOAT",
            "DOUBLE",
            "TEXT",
            "DATE",
            "TIME",
            "DATETIME",
            "BOOLEAN"
    };

    public DatabaseUtils(Context context){
        this.context = context;
    }

    public DatabaseUtils createDatabase(String dbName , Event event){

        String name = dbName + ".db";

        try{
            mDatabase = context.openOrCreateDatabase(name, Context.MODE_PRIVATE,null);
            event.success();
        }catch(Exception e){
            event.error(e.toString());
        }

        return this;
    }

    public DatabaseUtils add(String dbName , String tableName , int i , Event event){

        String name = dbName + ".db";

        try{

            for(int loop = 0; loop > i; loop++){
                mDatabase = context.openOrCreateDatabase(name, Context.MODE_PRIVATE,null);
                mDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + tableName +
                        " (id INTEGER PRIMARY KEY," +
                        " name " + mode[i] +" , number TEXT); "
                );
                mDatabase.close();
            }

            event.success();
        }catch(Exception e){
            event.error(e.toString());
        }

        return this;
    }

    public interface Event{
        void success();
        void error(String log);
    }


}
