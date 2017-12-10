package com.cpsu.easywallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.ContentValues;
import android.widget.ImageView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;


import com.cpsu.easywallet.DBclass;

public class Input_Activity extends AppCompatActivity {
    private EditText amount_input, title_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_layout);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");

        ImageView img = (ImageView) findViewById(R.id.imageview);
        Button submit = (Button) findViewById(R.id.expenseBtn);

        amount_input = (EditText) findViewById(R.id.amount_input);
        title_input = (EditText) findViewById(R.id.title_input);

        if(type.contains("income")){
            img.setImageResource(R.drawable.ic_income);
            getSupportActionBar().setTitle("บันทึกรายรับ");
            submit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(title_input.getText().toString().contains("") ||
                            Integer.parseInt(amount_input.getText().toString()) < 1
                            ){

                    }else{
                        saveDataToDB(amount_input, title_input,"income");
                        finish();
                    }

                }
            });

        }else{
            img.setImageResource(R.drawable.ic_expense);
            getSupportActionBar().setTitle("บันทึกรายจ่าย");
            submit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(title_input.getText().toString().contains("") ||
                            Integer.parseInt(amount_input.getText().toString()) < 1
                            ){

                    }else{
                        saveDataToDB(amount_input, title_input,"expense");
                        finish();
                    }

                }
            });
        }


    }

    private void saveDataToDB(EditText amount_input, EditText title_input, String type) {
        int amount = Integer.parseInt(amount_input.getText().toString());
        String title = title_input.getText().toString();

        ContentValues cv = new ContentValues();
        cv.put(DBclass.COL_TITLE, title);
        cv.put(DBclass.COL_AMOUNT, amount);
        cv.put(DBclass.COL_TYPE, type);

        DBclass dbHelper = new DBclass(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long result = db.insert(dbHelper.TABLE_NAME, null, cv);
    }
}
