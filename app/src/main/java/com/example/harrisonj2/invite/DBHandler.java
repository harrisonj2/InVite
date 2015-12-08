package com.example.harrisonj2.invite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by harrisonj2 on 12/8/2015.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "inVite.db";
    private static final String TABLE_HOST = "host";
    private static final String TABLE_MEETING = "meeting";

    private static final String COLUMN_HOSTID = "host_id";
    private static final String COLUMN_HOSTEMAIL = "email";

    private static final String COLUMN_MEETINGID = "meeting_id";
    private static final String COLUMN_MEETINGNAME = "name";
    private static final String COLUMN_MEETINGDESCRIPTION = "description";
    private static final String COLUMN_MEETINGLOCATION = "location";
    private static final String COLUMN_MEETINGDATE = "date";
    private static final String COLUMN_MEETINGTIME = "time";

    public DBHandler(Context context, SQLiteDatabase.CursorFactory factory){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_HOST + "(" +
                COLUMN_HOSTID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_HOSTEMAIL + " TEXT " +
                ");";

        String query2 = "CREATE TABLE " + TABLE_MEETING + "(" +
                COLUMN_MEETINGID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MEETINGNAME + " TEXT, " +
                COLUMN_MEETINGDESCRIPTION + " TEXT, " +
                COLUMN_MEETINGLOCATION + " TEXT, " +
                COLUMN_MEETINGDATE + " TEXT, " +
                COLUMN_MEETINGTIME + " TEXT, " +
                COLUMN_HOSTID + " INTEGER " +
                ");";

        db.execSQL(query);
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_HOST + ";");
        db.execSQL("DROP TABLE IF EXIST " + TABLE_MEETING + ";");
        onCreate(db);
    }
}
