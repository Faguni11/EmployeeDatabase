package com.example.dell.employeedatabase.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dell.employeedatabase.utils.Constants;

public class DBHelper {
    private SQLiteDatabase db;
    private final Context context;
    private final TableClass tableClass;
    private static DBHelper db_Helper;

    private DBHelper(Context context){
        this.context=context;
        tableClass=new TableClass(context, Constants.DATABASE_NAME,null,Constants.DB_VERSION);
    }
    public static DBHelper getInstance(Context context){
        if(db_Helper==null){
            db_Helper=new DBHelper(context);
            db_Helper.open();
        }
        return db_Helper;
    }
    public void open() {
        try {
            db = tableClass.getWritableDatabase();
        }catch (Exception e){
            e.printStackTrace();
            db=tableClass.getReadableDatabase();
        }
    }
    public void close(){
        if(db.isOpen()){
            db.close();
        }
    }
    public long insertContentValues(String tableName, ContentValues cv){
        long id=0;
        try{
            db.beginTransaction();
            id=db.insert(tableName,null,cv);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }
        return id;
    }

    public int getFullContent(String tabName,String where){
        int rowCount=0;
        Cursor c=db.query(false,tabName,null,where,null,null,null,null,null);
        try{
            c.moveToFirst();
            rowCount=c.getCount();


        }finally {
            c.close();
        }
return rowCount;
    }

}
