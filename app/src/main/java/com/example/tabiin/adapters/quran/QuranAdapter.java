package com.example.tabiin.adapters.quran;

import static android.provider.Settings.System.getString;
import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabiin.R;
import com.example.tabiin.objects.sures.Sura;
import com.example.tabiin.objects.sures.Verse;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;

public class QuranAdapter extends RecyclerView.Adapter<QuranAdapter.ViewHolder> {
    private Sura sura;
    private int number;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView num;
        public TextView arabicVerse;
        public TextView translatedVerse;
        public TextView heading;
        public TextView headingArabic;
        public MaterialCardView materialCardView;
        public ImageButton play;
        public MediaPlayer mediaPlayer;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            arabicVerse = itemView.findViewById(R.id.arabicViewVerse); // аят на арабском
            translatedVerse = itemView.findViewById(R.id.translateViewVerse); // аят на русском
            num = itemView.findViewById(R.id.numVerse); // номер аята
            materialCardView = itemView.findViewById(R.id.card);
            heading = itemView.findViewById(R.id.heading);
            headingArabic = itemView.findViewById(R.id.headingArabic);
            play = itemView.findViewById(R.id.play_verse);
            mediaPlayer = new MediaPlayer();

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
        /*Verse arabicViewVerse = sura.getVerses().get(position);
        Verse translateViewVerse = sura.getTranslatedVerses().get(position); */
        MaterialCardView cardView = holder.materialCardView;
        TextView verseView = holder.arabicVerse;
        TextView num = holder.num;
        TextView tvesre = holder.translatedVerse;
        ImageButton play = holder.play;
        MediaPlayer mediaPlayer = new MediaPlayer();
        /*num.setText(Integer.toString(position));
        arabicViewVerse.setText(arabicViewVerse.getText());
        tvesre.setText(translateViewVerse.getText()); */
        TextView heading = holder.heading;
        TextView headingArabic = holder.headingArabic;
        heading.setVisibility(View.GONE);
        headingArabic.setVisibility(View.GONE);

        if (position == 0){
            num.setVisibility(View.GONE);
            heading.setVisibility(View.VISIBLE);
            heading.setText(sura.getTranslatedName());
            headingArabic.setVisibility(View.VISIBLE);
            headingArabic.setText(sura.getName().replaceAll("[1234567890]", ""));
            verseView.setText(sura.getForeword());
            tvesre.setText(sura.getTranslatedForeword());
        }
        else {
            num.setVisibility(View.VISIBLE);
            heading.setVisibility(View.GONE);
            headingArabic.setVisibility(View.GONE);
            ViewGroup.MarginLayoutParams layoutParams =
                    (ViewGroup.MarginLayoutParams) cardView.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            cardView.requestLayout();
            Verse arabicViewVerse = sura.getVerses().get(holder.getBindingAdapterPosition() - 1);
            Verse translateViewVerse = sura.getTranslatedVerses().get(holder.getBindingAdapterPosition() - 1);
            num.setText(Integer.toString(holder.getBindingAdapterPosition()));
            verseView.setText(arabicViewVerse.getText());
            tvesre.setText(translateViewVerse.getText());
        }


        cardView.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager)
                    v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("", verseView.getText().toString() + "\n"
                    + tvesre.getText().toString() + "\n" + "Коран, сура " + number + " (" + sura.getTranslatedName() + "), аят " + holder.num.getText().toString());
            clipboard.setPrimaryClip(clip);

            Snackbar.make(v, "Коран, " + number + ", аят " + holder.num.getText().toString()
                                    + " скопирован в буфер обмена",
                            Snackbar.LENGTH_SHORT)
                    .show();
        });

        play.setOnClickListener(v -> {
            try {
                mediaPlayer.setDataSource(String.valueOf(sura.getVerses().get(Integer.parseInt(holder.num.getText().toString())).getAudioLink()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            mediaPlayer.prepareAsync();

            mediaPlayer.setOnPreparedListener(mp -> mediaPlayer.start());
        });



    }

    @Override
    public int getItemCount() {
        return sura.getVerses().size() + 1;
    }

    public QuranAdapter(Sura suras, int number) {
        this.sura = suras;
        this.number = number;
    }
}

