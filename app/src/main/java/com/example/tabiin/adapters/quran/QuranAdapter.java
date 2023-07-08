package com.example.tabiin.adapters.quran;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
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

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class QuranAdapter extends RecyclerView.Adapter<QuranAdapter.ViewHolder> {
    private Sura sura;
    private int number;
    private MediaPlayer mediaPlayer;
    private int currentPlayingPosition = -1;
    private boolean isPlaying = false;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView num;
        public TextView arabicVerse;
        public TextView translatedVerse;
        public TextView heading;
        public TextView headingArabic;
        public MaterialCardView materialCardView;
        public ImageButton play;
        public ArrayList<Verse> verses;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            arabicVerse = itemView.findViewById(R.id.arabicViewVerse);
            translatedVerse = itemView.findViewById(R.id.translateViewVerse);
            num = itemView.findViewById(R.id.numVerse);
            materialCardView = itemView.findViewById(R.id.card);
            heading = itemView.findViewById(R.id.heading);
            headingArabic = itemView.findViewById(R.id.headingArabic);
            play = itemView.findViewById(R.id.play_verse);
            verses = sura.getVerses();
        }
    }

    @NonNull
    @Override
    public QuranAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.quran_card_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuranAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MaterialCardView cardView = holder.materialCardView;
        TextView verseView = holder.arabicVerse;
        TextView num = holder.num;
        TextView tvesre = holder.translatedVerse;
        ImageButton play = holder.play;
        MaterialCardView card = holder.materialCardView;
        ArrayList<Verse> verses = holder.verses;

        holder.heading.setVisibility(View.GONE);
        holder.headingArabic.setVisibility(View.GONE);

        if (position == 0) {
            num.setVisibility(View.GONE);
            play.setVisibility(View.GONE);
            holder.heading.setVisibility(View.VISIBLE);
            holder.heading.setText(sura.getTranslatedName());
            holder.headingArabic.setVisibility(View.VISIBLE);
            holder.headingArabic.setText(sura.getName().replaceAll("[1234567890]", ""));
            verseView.setText(sura.getForeword());
            tvesre.setText(sura.getTranslatedForeword());
        } else if (position == 1) {
            num.setVisibility(View.GONE);
            play.setVisibility(View.GONE);
            card.setVisibility(View.GONE);
            holder.heading.setVisibility(View.GONE);
            holder.headingArabic.setVisibility(View.GONE);
        } else {
            num.setVisibility(View.VISIBLE);
            card.setVisibility(View.VISIBLE);
            play.setVisibility(View.VISIBLE);
            holder.heading.setVisibility(View.GONE);
            holder.headingArabic.setVisibility(View.GONE);
            ViewGroup.MarginLayoutParams layoutParams =
                    (ViewGroup.MarginLayoutParams) cardView.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            cardView.requestLayout();
            Verse arabicViewVerse = verses.get(position - 1);
            Verse translateViewVerse = sura.getTranslatedVerses().get(position - 1);
            num.setText(Integer.toString(position - 1));
            verseView.setText(arabicViewVerse.getText());
            tvesre.setText(translateViewVerse.getText());
        }

        cardView.setOnClickListener(v -> {
            if (position == 0) {
                ClipboardManager clipboard = (ClipboardManager)
                        v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("", verseView.getText().toString() + "\n"
                        + tvesre.getText().toString() + "\n" + "Коран, " + sura.getTranslatedName() + ", предисловие к тафсиру");
                clipboard.setPrimaryClip(clip);

                Snackbar.make(v, "Коран, " + sura.getTranslatedName() +  ", предисловие к тафсиру"
                                + " скопировано в буфер обмена", Snackbar.LENGTH_SHORT)
                        .show();
            } else {
                ClipboardManager clipboard = (ClipboardManager)
                        v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("", verseView.getText().toString() + "\n"
                        + tvesre.getText().toString() + "\n" + "Коран, " + sura.getTranslatedName() + ", аят " + holder.num.getText().toString());
                clipboard.setPrimaryClip(clip);

                Snackbar.make(v, "Коран, " + sura.getTranslatedName() +  ", аят " + holder.num.getText().toString()
                                + " скопирован в буфер обмена", Snackbar.LENGTH_SHORT)
                        .show();
            }
        });

        play.setOnClickListener(v -> {
            if (currentPlayingPosition == position) {
                stopAudio();
                currentPlayingPosition = -1;
                isPlaying = false;
            } else {
                stopAudio();
                currentPlayingPosition = position;
                isPlaying = true;
                playAudio(verses.get(position - 1).getAudioLink());
            }
            notifyDataSetChanged();
        });

        if (currentPlayingPosition == position && isPlaying) {
            play.setImageResource(R.drawable.pause);
        } else {
            play.setImageResource(R.drawable.play);
        }
    }

    @Override
    public int getItemCount() {
        return sura.getVerses().size() + 1;
    }

    public QuranAdapter(Sura suras, int number) {
        this.sura = suras;
        this.number = number;
        mediaPlayer = new MediaPlayer();
    }

    private void playAudio(String audioLink) {
        try {
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(audioLink);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(mp -> {
                mp.start();
                isPlaying = true;
            });
            mediaPlayer.setOnCompletionListener(mp -> {
                stopAudio();
                currentPlayingPosition = -1;
                isPlaying = false;
                notifyDataSetChanged();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopAudio() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.reset();
        isPlaying = false;
    }

    private void releaseMediaPlayer() {
        mediaPlayer.release();
        mediaPlayer = null;
    }
}