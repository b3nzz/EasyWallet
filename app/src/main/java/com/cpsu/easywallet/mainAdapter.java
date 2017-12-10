package com.cpsu.easywallet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class mainAdapter extends ArrayAdapter<Wallet> {
    private Context context;
    private int itemLayoutID;
    private ArrayList<Wallet> wallet;

    public mainAdapter(Context context, int itemLayoutID, ArrayList<Wallet> wallet) {
        super(context,itemLayoutID, wallet);

        this.itemLayoutID = itemLayoutID;
        this.wallet = wallet;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View item = inflater.inflate(itemLayoutID, parent, false);

        TextView title = (TextView) item.findViewById(R.id.itemTitle);
        TextView amount = (TextView) item.findViewById(R.id.itemAmount);
        ImageView imgss = (ImageView) item.findViewById(R.id.itemImage);

        Wallet wallets = wallet.get(position);
        title.setText(wallets.getTitle());
        amount.setText(wallets.getAmount());

        if(wallets.getType().contains("income")){
            imgss.setImageResource(R.drawable.ic_income);
        }else{
            imgss.setImageResource(R.drawable.ic_expense);
        }

        return item;
    }
}
