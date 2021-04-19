package com.company.models;

public class Transaction {

    static int Tid = 1;
    public int id;
    public String date;
    public float amount;
    public String type;
    public String note;

    public Transaction(String date, float amount, String type, String note) {
        this.id = Tid++;
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Transaction[ " +
                "id = '" + id +'\'' +
                ", date = '" + date + '\'' +
                ", amount = " + amount +
                ", type = '" + type + '\'' +
                ", note = '" + note + '\'' +
                "]\n";
    }
}
