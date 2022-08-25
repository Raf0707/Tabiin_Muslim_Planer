package com.example.tabiin.adapters.quran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabiin.R;
import com.example.tabiin.objects.sures.Sura;
import com.example.tabiin.objects.sures.Verse;

public class QuranAdapter extends RecyclerView.Adapter<QuranAdapter.ViewHolder> {
    private Sura sura;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView num;
        public TextView arabicVerse;
        public TextView translatedVerse;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            arabicVerse = itemView.findViewById(R.id.arabicViewVerse); // аят на арабском
            translatedVerse = itemView.findViewById(R.id.translateViewVerse); // аят на русском
            num = itemView.findViewById(R.id.numVerse); // номер аята

        }
    }

    @NonNull
    @Override
    public QuranAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.quran_card_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull QuranAdapter.ViewHolder holder, int position) {
        Verse arabicViewVerse = sura.getVerses().get(position);
        Verse translateViewVerse = sura.getTranslatedVerses().get(position);
        TextView verseView = holder.arabicVerse;
        TextView num = holder.num;
        TextView tvesre = holder.translatedVerse;
        num.setText(Integer.toString(position));
        arabicViewVerse.setText(arabicViewVerse.getText());
        tvesre.setText(translateViewVerse.getText());
    }

    @Override
    public int getItemCount() {
        return sura.getVerses().size();
    }

    public QuranAdapter(Sura suras) {
        this.sura = suras;
    }
}

