package com.example.demouserloginapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "User.db";
    public static final String TABLE_NAME = "DemoUser_details";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "AGE";
    public static final String COL_5 = "CONTACT";
    public static final String COL_6 = "POSTAL_ADD";
    public static final String COL_7 = "JOB_DETAIL";
    public static final String COL_8 = "QUALIFICATION";

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT,SURNAME TEXT,AGE INTEGER,CONTACT NUMBER,POSTAL_ADD TEXT," +
                "JOB_DETAIL TEXT, QUALIFICATION TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String surname, String age, String contact, String postal_add, String job_detail, String qual) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_1, Id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, age);
        contentValues.put(COL_5, contact);
        contentValues.put(COL_6, postal_add);
        contentValues.put(COL_7, job_detail);
        contentValues.put(COL_8, qual);

        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public void updateCourse(String Name, String Surname, String Age, String Phone, String Address, String job, String Qual, int id) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(COL_2, Name);
        values.put(COL_3, Surname);
        values.put(COL_4, Age);
        values.put(COL_5, Phone);
        values.put(COL_6, Address);
        values.put(COL_7, job);
        values.put(COL_8, Qual);
        values.put(COL_1, id);

        db.update(TABLE_NAME, values, "id=?", new String[]{ String.valueOf(id) });
        db.close();
    }


    //Delete records
    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }

    public ArrayList<User> ReadData() {
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<User> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new User(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4),
                        cursorCourses.getString(5),
                        cursorCourses.getString(6),
                        cursorCourses.getString(7)/*,
                        cursorCourses.getString(8)*/
                ));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        cursorCourses.close();
        return courseModalArrayList;
    }

}
