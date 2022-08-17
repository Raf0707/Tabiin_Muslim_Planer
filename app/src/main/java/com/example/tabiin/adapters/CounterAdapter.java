package com.example.tabiin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabiin.R;
import com.example.tabiin.database.Employee;
import com.example.tabiin.database.Items;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class CounterAdapter extends RecyclerView.Adapter<CounterAdapter.CounterViewHolder> {

    private Context context;
    private List<Items> itemsList;
    private HandleItemClick clickListener;

    public CounterAdapter(Context context, HandleItemClick clickListener) {
        this.context = context;
        this.clickListener = clickListener;
    }

    public void setItemsList(List<Employee> employees) {
        this.itemsList = itemsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CounterAdapter.CounterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.counter_item_element, parent, false);
        return new CounterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CounterAdapter.CounterViewHolder holder, int position) {
        holder.itemName.setText(this.itemsList.get(position).itemName);

        holder.itemView.setOnClickListener(view -> {
            clickListener.itemClick(itemsList.get(position));
        });

        holder.delItem.setOnClickListener(view -> {
            clickListener.removeItem(itemsList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        if (itemsList == null || itemsList.size() == 0) {
            return 0;
        } else {
            return itemsList.size();
        }
    }

    public class CounterViewHolder extends RecyclerView.ViewHolder {
        private TextView itemName;
        private MaterialButton delItem;
        public CounterViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemId);
            delItem = itemView.findViewById(R.id.deleteFromItemsDataBaseCounterElement);

        }
    }

    public interface HandleItemClick {
        void itemClick(Items items);
        void removeItem(Items items);
    }

}
