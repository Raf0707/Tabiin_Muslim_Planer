package com.example.tabiin.ui.about_app;

import static com.example.tabiin.util.UtilFragment.changeFragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tabiin.BuildConfig;
import com.example.tabiin.R;

import com.example.tabiin.databinding.*;
import com.example.tabiin.developer_params.DeveloperParamsFragment;
import com.example.tabiin.ui.kitab.GeneralKitabihilFragment;
import com.example.tabiin.util.CustomTabUtil;
import com.example.tabiin.util.OnSwipeTouchListener;

import com.google.android.material.snackbar.Snackbar;


public class AppAboutFragment extends Fragment {
    private FragmentAppAboutBinding binding;
    private int clickCount = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void addOnClick(View view, String text, ClipData clipData) {
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        clipboardManager.setPrimaryClip(clipData);
        Snackbar.make(getView(), text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAppAboutBinding.inflate(inflater, container, false);

        binding.appVersionBtn.setText(getString(R.string.version) + ": " + BuildConfig.VERSION_NAME + " ( " + BuildConfig.VERSION_CODE + " ) ");

        binding.appVersionBtn.setOnLongClickListener(view -> {
            addOnClick(view, "version copied", ClipData.newPlainText("getContext()", "Tabiin: " + getString(R.string.version) + ": " + BuildConfig.VERSION_NAME + " ( " + BuildConfig.VERSION_CODE + " ) "));
            return true;
        });

        binding.sourceCodeBtn.setOnLongClickListener(view -> {
            addOnClick(view, "link to source copied", ClipData.newPlainText("getContext()", "https://github.com/Raf0707/Tabiin_Muslim_Planer"));
            return true;
        });

        binding.rafailBtn.setOnLongClickListener(view -> {
            addOnClick(view, "link to Rafail Kikmatulin's GitHub profile copied", ClipData.newPlainText("getContext()", "https://github.com/Raf0707"));
            return true;
        });

        binding.ibragimBtn.setOnLongClickListener(view -> {
            addOnClick(view, "link to Ibragim Magaltsov's GitHub profile copied", ClipData.newPlainText("getContext()", "https://github.com/IbremMiner837"));
            return true;
        });

        binding.danilaBtn.setOnLongClickListener(view -> {
            addOnClick(view, "link to Danila Vorobyov's GitHub profile copied", ClipData.newPlainText("getContext()", "https://github.com/DanilaDevx21x"));
            return true;
        });

        binding.mailRafBtn.setOnLongClickListener(view -> {
            addOnClick(view, "Rafail Kikmatulin's email copied", ClipData.newPlainText("getContext()", "raf_android-dev@mail.ru"));
            return true;
        });

        binding.vkGroupBtn.setOnLongClickListener(view -> {
            addOnClick(view, "VK-Group's Tabiin link copied", ClipData.newPlainText("getContext()", "https://vk.com/club213851453"));
            return true;
        });

        binding.appVersionBtn.setOnClickListener(view -> {
            clickCount += 1;
            if (clickCount == 8) {
                changeFragment(getActivity(), new DeveloperParamsFragment(), R.id.kontainerFragment, null);

            }
        });

        binding.sourceCodeBtn.setOnClickListener(v -> new CustomTabUtil().OpenCustomTab(getActivity(), getString(R.string.source_code_url), R.color.purple_300));
        binding.ibragimBtn.setOnClickListener(v -> new CustomTabUtil().OpenCustomTab(getActivity(), getString(R.string.ibragim_url), R.color.purple_300));
        binding.rafailBtn.setOnClickListener(v -> new CustomTabUtil().OpenCustomTab(getActivity(), getString(R.string.rafail_url), R.color.purple_300));
        binding.danilaBtn.setOnClickListener(v -> new CustomTabUtil().OpenCustomTab(getActivity(), getString(R.string.danila_url), R.color.purple_300));

        binding.mailRafBtn.setOnClickListener(v -> {
            final Intent emailIntent = new Intent(Intent.ACTION_SEND); //TO, Uri.fromParts("mailto:", "abc@gmail.com", null));
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{getString(R.string.mail_raf)});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, R.string.app_name);
            emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.app_name) + "; " + getString(R.string.version) + ": " + BuildConfig.VERSION_NAME + " ( " + BuildConfig.VERSION_CODE + " ) ");

            emailIntent.setType("plain/text");
            // setType("message/rfc822")

            try {
                startActivity(Intent.createChooser(emailIntent, "Send email using..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getActivity(),
                        "No email clients installed.", Toast.LENGTH_SHORT).show();
            }
        });

        binding.vkGroupBtn.setOnClickListener(v -> new CustomTabUtil().OpenCustomTab(getActivity(), getString(R.string.tabiin_rtx), R.color.purple_300));
        binding.otherAppsBtn.setOnClickListener(view1 -> {
            final String appPackageName = getContext().getPackageName();
            /*
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:JVMFrog")));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.GOOGLE_PLAY))));
            }

             */
        });

        return binding.getRoot();

    }
}