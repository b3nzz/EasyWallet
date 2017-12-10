package com.cpsu.easywallet;

public class Wallet {
    private String title;
    private String type;
    private int amount;
    private Long _id;

    Wallet(String title , String type, int amount, Long _id){
        this._id = _id;
        this.amount = amount;
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }
}
