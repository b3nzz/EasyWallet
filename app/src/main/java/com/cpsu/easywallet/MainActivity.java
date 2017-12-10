package com.cpsu.easywallet;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Button;
import java.util.ArrayList;
import com.cpsu.easywallet.Wallet;

public class MainActivity extends AppCompatActivity {
    private DBclass dbc;
    private SQLiteDatabase db;
    private ListView list;
    private ArrayList<Wallet> walletList;
    private String typeExpense = "expense";
    private String typeIncome = "income";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbc = new DBclass(getApplicationContext());
        db = dbc.getWritableDatabase();

        walletList = new ArrayList<Wallet>();
        
        queryDataFromDB();

        mainAdapter m = new mainAdapter(this, R.layout.item, walletList);
        list = (ListView) findViewById(R.id.wallet_listview);
        list.setAdapter(m);

        Button expenseButton = (Button) findViewById(R.id.expenseBtn);
        Button incomeButton = (Button) findViewById(R.id.incomeBtn);

        expenseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Input_Activity.class);
                intent.putExtra("type", typeExpense);
                startActivity(intent);
            }
        });


        incomeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Input_Activity.class);
                intent.putExtra("type", typeIncome);
                startActivity(intent);
            }
        });
    }


    private void queryDataFromDB() {

        String selectQuery = "SELECT " +
                DBclass.COL_ID + "," +
                DBclass.COL_TITLE + "," +
                DBclass.COL_TYPE + "," +
                DBclass.COL_AMOUNT +
                " FROM " + DBclass.TABLE_NAME;

        Cursor cursor = db.rawQuery(selectQuery, null);

        while(cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex(DBclass.COL_TITLE));
            String type = cursor.getString(cursor.getColumnIndex(DBclass.COL_TYPE));
            int amount = Integer.parseInt( cursor.getString(cursor.getColumnIndex(DBclass.COL_AMOUNT)));
            Long _id = cursor.getLong(cursor.getColumnIndex(DBclass.COL_ID));
            Wallet wall = new Wallet(title,  type, amount, _id);
            this.walletList.add(wall);
        }

    }
}
