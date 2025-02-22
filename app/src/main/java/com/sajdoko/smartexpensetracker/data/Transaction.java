package com.sajdoko.smartexpensetracker.data;

public class Transaction {
    private int id;           // primary key
    private double amount;
    private String date;      // or store as a long/timestamp
    private String category;
    private String note;      // optional note about this transaction

    public Transaction() {
        // Empty constructor for convenience
    }

    public Transaction(int id, double amount, String date, String category, String note) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.note = note;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}
