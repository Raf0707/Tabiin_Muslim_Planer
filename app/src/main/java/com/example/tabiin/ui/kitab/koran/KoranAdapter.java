package com.example.tabiin.ui.kitab.koran;

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

import java.util.List;

public class KoranAdapter extends RecyclerView.Adapter<KoranAdapter.ViewHolder> {
    private Sura sura;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView num;
        public TextView verse;
        public TextView translatedVerse;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            verse = itemView.findViewById(R.id.textView);
            translatedVerse = itemView.findViewById(R.id.textView2);
            num = itemView.findViewById(R.id.textView3);

        }
    }
    @NonNull
    @Override
    public KoranAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.koran_card_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull KoranAdapter.ViewHolder holder, int position) {
        Verse verse = sura.getVerses().get(position);
        Verse verse2 = sura.getTranslatedVerses().get(position);
        TextView verse1 = holder.verse;
        TextView num = holder.num;
        TextView tvesre = holder.translatedVerse;
        num.setText(Integer.toString(position));
        verse.setText(verse.getText());
        tvesre.setText(verse2.getText());
    }

    @Override
    public int getItemCount() {
        return sura.getVerses().size();
    }

    public KoranAdapter(Sura suras) {
        this.sura = suras;
    }
}
