package com.sajdoko.smartexpensetracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;

import com.sajdoko.smartexpensetracker.R;
import com.sajdoko.smartexpensetracker.data.DatabaseHelper;
import com.sajdoko.smartexpensetracker.data.Transaction;

public class AddTransactionActivity extends AppCompatActivity {

    private EditText editAmount, editDate, editNote;
    private Spinner spinnerCategory;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new DatabaseHelper(this);

        editAmount = findViewById(R.id.edit_amount);
        editDate = findViewById(R.id.edit_date);
        editNote = findViewById(R.id.edit_note);
        spinnerCategory = findViewById(R.id.spinner_category);

        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle date picker dialog

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_settings) {
            // Handle settings action
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void saveTransaction(View view) {
        String amountStr = editAmount.getText().toString().trim();
        String dateStr = editDate.getText().toString().trim();
        String categoryStr = spinnerCategory.getSelectedItem().toString();
        String noteStr = editNote.getText().toString().trim();

        if (amountStr.isEmpty() || dateStr.isEmpty()) {
            Toast.makeText(this, "Please enter amount and date", Toast.LENGTH_SHORT).show();
            return;
        }

        double amount = Double.parseDouble(amountStr);
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDate(dateStr);
        transaction.setCategory(categoryStr);
        transaction.setNote(noteStr);

        db.addTransaction(transaction);
        Toast.makeText(this, "Transaction saved!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
