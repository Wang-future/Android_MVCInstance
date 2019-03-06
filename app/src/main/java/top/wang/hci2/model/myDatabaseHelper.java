package top.wang.hci2.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_USERS = "create table users("
            + "id integer primary key,"
            + "name text,"
            + "coins integer,"
            + "stars integer,"
            + "sex integer)";
    public static final String CREATE_CALENDAR = "create table calendar("
            + "id integer,"
            + "date integer,"
            + "time integer,"
            + "cnt integer,"
            + "primary key(id,date,time))";
    private Context mContext;

    public myDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    public void initData() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("id",1);
        values.put("name","boy");
        values.put("coins",10);
        values.put("stars",12);
        values.put("sex",1);
        db.insert("users",null,values);

        values.clear();
        values.put("id",1);
        values.put("date",1);
        values.put("time",1);
        values.put("cnt",3);
        db.insert("calendar",null,values);

        values.clear();
        values.put("id",1);
        values.put("date",1);
        values.put("time",2);
        values.put("cnt",4);
        db.insert("calendar",null,values);

        values.clear();
        values.put("id",1);
        values.put("date",2);
        values.put("time",1);
        values.put("cnt",2);
        db.insert("calendar",null,values);

        values.clear();
        values.put("id",1);
        values.put("date",2);
        values.put("time",2);
        values.put("cnt",3);
        db.insert("calendar",null,values);
        ////////////////////////////////////////////////////////////////////for boy
        values.put("id",2);
        values.put("name","girl");
        values.put("coins",3);
        values.put("stars",9);
        values.put("sex",2);
        db.insert("users",null,values);

        values.clear();
        values.put("id",2);
        values.put("date",1);
        values.put("time",1);
        values.put("cnt",1);
        db.insert("calendar",null,values);

        values.clear();
        values.put("id",1);
        values.put("date",1);
        values.put("time",2);
        values.put("cnt",2);
        db.insert("calendar",null,values);

        values.clear();
        values.put("id",2);
        values.put("date",2);
        values.put("time",1);
        values.put("cnt",3);
        db.insert("calendar",null,values);

        values.clear();
        values.put("id",2);
        values.put("date",2);
        values.put("time",2);
        values.put("cnt",3);
        db.insert("calendar",null,values);
        //for girl
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USERS);
        db.execSQL(CREATE_CALENDAR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists calendar");
        onCreate(db);
    }
}
