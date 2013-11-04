package com.example.myserials;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by abataloff on 14.08.13.
 */
public class DB
{
    public static final String DB_NAME = "MySerials";
    public static final int DB_VERSION = 1;

    public static final String SERIALS_TABLE = "serials";
    public static final String SERIALS_COLUMN_ID = "_id";
    public static final String SERIALS_COLUMN_TITLE = "title";
    public static final String SERIALS_TABLE_CREATE = "create table "
            + SERIALS_TABLE + "(" + SERIALS_COLUMN_ID
            + " integer primary key, " + SERIALS_TABLE + " text" + ");";

    private final Context mCtx;

    private DBHelper mDBHelper;
    private SQLiteDatabase mDB;

    public DB(Context ctx) {
        mCtx = ctx;
    }

    // открываем подключение
    public void open() {
        mDBHelper = new DBHelper(mCtx, DB_NAME, null, DB_VERSION);
        mDB = mDBHelper.getWritableDatabase();
    }

    // закрываем подключение
    public void close() {
        if (mDBHelper != null)
            mDBHelper.close();
    }

    public Cursor getSerialData(long serialID) {
        return mDB.query(SERIALS_TABLE, null, SERIALS_COLUMN_TITLE + " = "
                + serialID, null, null, null, null);
    }

    public Cursor getSerialsData() {
        return mDB.query(SERIALS_TABLE, null, null, null, null, null, null);
    }

    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            ContentValues cv = new ContentValues();

            String[] companies = new String[] { "First Serial", "Second Serial", "Third Serial" };

            db.execSQL(SERIALS_TABLE_CREATE);
            for (int i = 0; i < companies.length; i++) {
                cv.put(SERIALS_COLUMN_ID, i + 1);
                cv.put(SERIALS_COLUMN_TITLE, companies[i]);
                db.insert(SERIALS_TABLE, null, cv);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

}