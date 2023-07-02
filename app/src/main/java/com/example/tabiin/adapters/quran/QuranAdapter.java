package com.example.tabiin.adapters.quran;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
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

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

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
        public boolean isPlay;
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
            isPlay = false;

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
        MaterialCardView card = holder.materialCardView;
        MediaPlayer mediaPlayer = new MediaPlayer();
        boolean isPlay = false;
        /*num.setText(Integer.toString(position));
        arabicViewVerse.setText(arabicViewVerse.getText());
        tvesre.setText(translateViewVerse.getText()); */
        TextView heading = holder.heading;
        TextView headingArabic = holder.headingArabic;
        heading.setVisibility(View.GONE);
        headingArabic.setVisibility(View.GONE);

        if (position == 0){

            num.setVisibility(View.GONE);
            play.setVisibility(View.GONE);
            //card.setVisibility(View.GONE);
            //sura.getVerses().get(0).setAudioLink("");
            heading.setVisibility(View.VISIBLE);
            heading.setText(sura.getTranslatedName());
            headingArabic.setVisibility(View.VISIBLE);
            headingArabic.setText(sura.getName().replaceAll("[1234567890]", ""));
            verseView.setText(sura.getForeword());
            tvesre.setText(sura.getTranslatedForeword());


        } else if (position == 1){

            num.setVisibility(View.GONE);
            play.setVisibility(View.GONE);
            card.setVisibility(View.GONE);
            //sura.getVerses().get(0).setAudioLink("");
            heading.setVisibility(View.GONE);
            //heading.setText(sura.getTranslatedName());
            headingArabic.setVisibility(View.GONE);
            //headingArabic.setText(sura.getName().replaceAll("[1234567890]", ""));
            //verseView.setText(sura.getForeword());
            //tvesre.setText(sura.getTranslatedForeword());
        } else {
            //Verse verse = new Verse();
            num.setVisibility(View.VISIBLE);
            card.setVisibility(View.VISIBLE);
            play.setVisibility(View.VISIBLE);
            heading.setVisibility(View.GONE);
            headingArabic.setVisibility(View.GONE);
            ViewGroup.MarginLayoutParams layoutParams =
                    (ViewGroup.MarginLayoutParams) cardView.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            cardView.requestLayout();
            Verse arabicViewVerse = sura.getVerses().get(holder.getBindingAdapterPosition()-1);
            Verse translateViewVerse = sura.getTranslatedVerses().get(holder.getBindingAdapterPosition()-1);
            //Verse audiolink = sura.getAudioLinks().get(holder.getBindingAdapterPosition());
            num.setText(Integer.toString(holder.getBindingAdapterPosition()-1));
            //num.setText(position);
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
            Snackbar.make(v, (String.valueOf(sura.getVerses().get(Integer.parseInt(holder.num.getText().toString())).getAudioLink())), Snackbar.LENGTH_LONG).show();
            int countClick = 1;
            AtomicBoolean isPlayMedia = new AtomicBoolean(true);
            play.setImageResource(R.drawable.pause);
            if (Objects.equals(sura.getName(), "Дуа после прочтения Корана")) {
                Context context = v.getContext();
                startSound("mp3/dua.mp3", context);
            } else {
                try {
                    //mediaPlayer.reset();
                    //mediaPlayer.pause();
                    mediaPlayer.setDataSource(String.valueOf(sura.getVerses().get(Integer.parseInt(holder.num.getText().toString())).getAudioLink()));
                    mediaPlayer.prepareAsync();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


                mediaPlayer.setOnPreparedListener(mp -> {
                    if (isPlayMedia.get() && (countClick % 2 != 0)) {
                        mediaPlayer.start();
                        play.setImageResource(R.drawable.pause);
                    }
                    else {
                        isPlayMedia.set(false);
                        play.setImageResource(R.drawable.play);
                        //mediaPlayer.pause();
                        //mediaPlayer.setLooping(true);
                        if (mp.isPlaying()) {
                            mediaPlayer.pause();
                            mediaPlayer.stop();
                        }
                        /*
                        try {
                            mediaPlayer.prepare();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                         */
                    }
                });
            }

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

    private void startSound(String filename, Context c) {
        AssetFileDescriptor afd = null;
        try {
            afd = c.getResources().getAssets().openFd(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MediaPlayer player = new MediaPlayer();
        try {
            assert afd != null;
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.start();
    }
}

