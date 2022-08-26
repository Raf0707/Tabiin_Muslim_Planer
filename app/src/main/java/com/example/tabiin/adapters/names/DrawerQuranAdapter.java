package com.example.tabiin.adapters.names;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabiin.R;
import com.example.tabiin.adapters.quran.QuranAdapter;
import com.example.tabiin.objects.quran.QuranItemContent;
import com.example.tabiin.objects.sures.Sura;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class DrawerQuranAdapter extends RecyclerView.Adapter<DrawerNamesAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<String> heads;

    public DrawerQuranAdapter(LayoutInflater inflater, List<String> heads) {
        this.inflater = inflater;
        this.heads = heads;
    }

    @NonNull
    @Override
    public DrawerNamesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.listitem, parent, false);
        return new DrawerNamesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrawerNamesAdapter.ViewHolder holder, int position) {
        String head = heads.get(position);
        TextView txt = holder.nameView1;
        txt.setText(head);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new GsonBuilder().create();
                InputStream inputStream = null;
                try {
                    inputStream = holder.nameView1.getContext().getAssets().open(String.format("Quran and Tafsir (.json)/%d.json", holder.getBindingAdapterPosition()));
                    String jsonString = new Scanner(inputStream).useDelimiter("\\A").next();
                    Sura sura = gson.fromJson(jsonString, Sura.class);
                    RecyclerView recyclerView = holder.nameView1.findViewById(R.id.quranContent);
                    recyclerView.setAdapter(new QuranAdapter(sura));
                    recyclerView.setHasFixedSize(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return heads.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView1;

        ViewHolder(View view) {
            super(view);
            nameView1 = view.findViewById(R.id.name);
        }
    }
}
