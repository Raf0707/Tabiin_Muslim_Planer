package com.example.tabiin.adapters.counter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabiin.R;
import com.example.tabiin.database.CounterItems;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class CounterAdapter extends RecyclerView.Adapter<CounterAdapter.CounterViewHolder> {

    private Context context;
    private List<CounterItems> counterItemsList;
    private HandleItemClick clickListener;

    public CounterAdapter(Context context, HandleItemClick clickListener) {
        this.context = context;
        this.clickListener = clickListener;
    }

    public void setItemsList(List<CounterItems> counterItems) {
        this.counterItemsList = counterItemsList;
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
        holder.itemName.setText(this.counterItemsList.get(position).itemName);

        holder.itemView.setOnClickListener(view -> {
            clickListener.itemClick(counterItemsList.get(position));
        });

        holder.delItem.setOnClickListener(view -> {
            clickListener.removeItem(counterItemsList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        if (counterItemsList == null || counterItemsList.size() == 0) {
            return 0;
        } else {
            return counterItemsList.size();
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
        void itemClick(CounterItems counterItems);
        void removeItem(CounterItems counterItems);
    }

}
