package com.example.dell.employeedatabase.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dell.employeedatabase.utils.Constants;

public class TableClass extends SQLiteOpenHelper {

    Context context;
    String query="Create table IF NOT EXISTS "+ Constants.EMPLOYEE_TABLE+" ("+ Constants.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Constants.EMPLOYEE_NAME+ " TEXT, " + Constants.EMPLOYEE_AGE+ " TEXT, " +Constants.EMPLOYEE_ID+ " TEXT);";

    public TableClass(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    context.deleteDatabase(Constants.DATABASE_NAME);
    onCreate(db);
    }
}
