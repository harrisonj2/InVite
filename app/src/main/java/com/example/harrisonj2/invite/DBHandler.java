package com.example.harrisonj2.invite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    private Host[] hostData;
    private Meeting[] meetingData;

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

    public void addHost(String email){
        ContentValues value = new ContentValues();
        value.put(COLUMN_HOSTEMAIL, email);

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_HOST, null, value);
        db.close();
    }

    public void addMeeting(String name, String description, String location,
                           String date, String time, int hostID){
        ContentValues value = new ContentValues();
        value.put(COLUMN_MEETINGNAME, name);
        value.put(COLUMN_MEETINGDESCRIPTION, description);
        value.put(COLUMN_MEETINGLOCATION, location);
        value.put(COLUMN_MEETINGDATE, date);
        value.put(COLUMN_MEETINGTIME, time);
        value.put(COLUMN_HOSTID, hostID);

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_MEETING, null, value);
        db.close();
    }

    public Host[] getHost(){
        SQLiteDatabase db = getWritableDatabase();
        String query = " SELECT * FROM " + TABLE_HOST + ";";
        Cursor c = db.rawQuery(query, null);
        int numHost = c.getCount();

        if(numHost >= 1){
            hostData = new Host[numHost];

            int i = 0;
            c.moveToFirst();

            while (!c.isAfterLast()){
                hostData[i] = new Host(c.getString(c.getColumnIndex("email")));

                c.moveToNext();
                i++;
            }
        }

        db.close();
        return hostData;
    }

    public Meeting[] getMeeting(){
        SQLiteDatabase db = getWritableDatabase();
        String query = " SELECT * FROM " + TABLE_MEETING + ";";
        Cursor c = db.rawQuery(query, null);
        int numMeeting = c.getCount();

        if(numMeeting >= 1){
            meetingData = new Meeting[numMeeting];

            int i = 0;
            c.moveToFirst();

            while (!c.isAfterLast()){
                meetingData[i] = new Meeting(c.getInt(c.getColumnIndex("host_id")),
                        c.getString(c.getColumnIndex("name")),
                        c.getString(c.getColumnIndex("description")),
                        c.getString(c.getColumnIndex("location")),
                        c.getString(c.getColumnIndex("date")),
                        c.getString(c.getColumnIndex("time")));

                c.moveToNext();
                i++;
            }
        }

        db.close();
        return meetingData;
    }
}
