package com.sajdoko.smartexpensetracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.sajdoko.smartexpensetracker.R;
import com.sajdoko.smartexpensetracker.adapters.TransactionAdapter;
import com.sajdoko.smartexpensetracker.data.DatabaseHelper;
import com.sajdoko.smartexpensetracker.data.Transaction;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TransactionAdapter adapter;
    private DatabaseHelper db;
    private TextView totalExpensesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new DatabaseHelper(this);

        totalExpensesTextView = findViewById(R.id.text_total_expenses);
        recyclerView = findViewById(R.id.recycler_transactions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadTransactions();
    }

    private void loadTransactions() {
        List<Transaction> transactions = db.getAllTransactions();
        adapter = new TransactionAdapter(transactions, this);
        recyclerView.setAdapter(adapter);

        // Calculate total
        double total = 0.0;
        for (Transaction t : transactions) {
            total += t.getAmount();
        }
        totalExpensesTextView.setText(String.format("$%.2f", total));
    }

    // Called from a FAB button (or a normal button) to go to AddTransactionActivity
    public void goToAddTransaction(View view) {
        startActivity(new Intent(this, AddTransactionActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh data after returning from AddTransaction or Detail
        loadTransactions();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_home) {
            // Handle Home action
            return true;
        } else if (id == R.id.menu_transactions) {
            // Handle Transactions action
            return true;
        } else if (id == R.id.menu_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        } else if (id == R.id.menu_filter) {
            // open filter UI
            showFilterDialog();
            return true;
        } else if (id == R.id.menu_sort) {
            // open sort UI or just sort directly
            showSortOptions();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showFilterDialog() {
        // Implement filter dialog logic here
    }

    private void showSortOptions() {
        // Implement sort options logic here
    }

}
