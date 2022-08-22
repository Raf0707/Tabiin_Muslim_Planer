package com.example.tabiin.adapters.names;

import static java.lang.String.format;

import android.content.*;
import android.view.*;
import android.widget.*;

import androidx.recyclerview.widget.*;

import com.example.tabiin.R;
import com.example.tabiin.objects.names.DrawerNamesContent;

import java.util.*;

public class DrawerNamesAdapter extends RecyclerView.Adapter<DrawerNamesAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<DrawerNamesContent> namesDrawer;

    public DrawerNamesAdapter(Context context, List<DrawerNamesContent> namesDrawer) {
        this.namesDrawer = namesDrawer;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public DrawerNamesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.drawer_names_item, parent, false);
        return new DrawerNamesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DrawerNamesAdapter.ViewHolder holder, int position) {
        DrawerNamesContent newName = namesDrawer.get(position);

        holder.nameView1.setText(format("%s", newName.getNameDrawer()));

        holder.nameView1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
    }

    @Override
    public int getItemCount() {
        return namesDrawer.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView1;
        ViewHolder(View view){
            super(view);
            nameView1 = view.findViewById(R.id.itemDrawerNames);
        }
    }

}