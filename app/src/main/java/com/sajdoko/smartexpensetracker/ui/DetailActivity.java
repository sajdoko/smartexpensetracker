package com.sajdoko.smartexpensetracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sajdoko.smartexpensetracker.R;
import com.sajdoko.smartexpensetracker.data.DatabaseHelper;
import com.sajdoko.smartexpensetracker.data.Transaction;

public class DetailActivity extends AppCompatActivity {

    private EditText editAmount, editDate, editCategory, editNote;
    private DatabaseHelper db;
    private int transactionId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new DatabaseHelper(this);

        editAmount = findViewById(R.id.edit_detail_amount);
        editDate = findViewById(R.id.edit_detail_date);
        editCategory = findViewById(R.id.edit_detail_category);
        editNote = findViewById(R.id.edit_detail_note);

        if (getIntent() != null && getIntent().hasExtra("TRANSACTION_ID")) {
            transactionId = getIntent().getIntExtra("TRANSACTION_ID", -1);
            // (Optional) You’d query the database for this transaction ID to prefill the fields
            // or you can pass all details via extras.
        }
    }

    public void updateTransaction(View view) {
        if (transactionId == -1) return;

        double amount = Double.parseDouble(editAmount.getText().toString());
        String date = editDate.getText().toString();
        String category = editCategory.getText().toString();
        String note = editNote.getText().toString();

        Transaction t = new Transaction(transactionId, amount, date, category, note);
        db.updateTransaction(t);
        Toast.makeText(this, "Updated!", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void deleteTransaction(View view) {
        if (transactionId == -1) return;

        db.deleteTransaction(transactionId);
        Toast.makeText(this, "Deleted!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
