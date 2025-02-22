package com.sajdoko.smartexpensetracker.adapters;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sajdoko.smartexpensetracker.R;
import com.sajdoko.smartexpensetracker.data.Transaction;

public class TransactionViewHolder extends RecyclerView.ViewHolder {
    private TextView textDate, textAmount, textCategory;

    public TransactionViewHolder(View itemView) {
        super(itemView);
        textDate = itemView.findViewById(R.id.text_item_date);
        textAmount = itemView.findViewById(R.id.text_item_amount);
        textCategory = itemView.findViewById(R.id.text_item_category);
    }

    public void bind(Transaction transaction) {
        textDate.setText(transaction.getDate());
        textAmount.setText(String.valueOf(transaction.getAmount()));
        textCategory.setText(transaction.getCategory());
    }
}
