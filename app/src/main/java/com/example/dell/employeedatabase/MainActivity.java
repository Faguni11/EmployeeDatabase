package com.example.dell.employeedatabase;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.dell.employeedatabase.database.DBHelper;
import com.example.dell.employeedatabase.utils.Constants;

public class MainActivity extends AppCompatActivity {


    String [] employee_name={
            "faguni manchanda",
            "garvita kalra",
            "gunjan panda",
            "gaurav seth",
            "abc xyz"};

    String [] employee_age={
            "ghj hj",
            "rt hjk",
            "rtyu vbnm",
            "cvbn cvbn",
            "cvbn vbnm"};

    String [] employee_id={
            "12345IPP",
            "12349LK",
            "12385PL",
            "19303OP",
            "987654OI"};

    DBHelper db_helper;
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    db_helper=DBHelper.getInstance(this);
    int count=db_helper.getFullContent(Constants.EMPLOYEE_TABLE,null);
    if(count==0){
insertEmpData();
        Toast.makeText(this,"DATA INSERTED FOR "+db_helper.getFullContent(Constants.EMPLOYEE_TABLE,null),Toast.LENGTH_SHORT).show();

    }
    else{
        Toast.makeText(this,"DATA PRESENT FOR "+db_helper.getFullContent(Constants.EMPLOYEE_TABLE,null),Toast.LENGTH_SHORT).show();
    }
    }
    private void insertEmpData(){
        for(int i=0;i<employee_name.length;i++){
            ContentValues cv=new ContentValues();
            cv.put(Constants.EMPLOYEE_ID,employee_id[i]);
            cv.put(Constants.EMPLOYEE_NAME,employee_name[i]);
            cv.put(Constants.EMPLOYEE_AGE,employee_age[i]);

            db_helper.insertContentValues(Constants.EMPLOYEE_TABLE,cv);
        }
    }
}
