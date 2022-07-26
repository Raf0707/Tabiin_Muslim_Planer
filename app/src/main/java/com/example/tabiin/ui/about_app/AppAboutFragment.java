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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAppAboutBinding.inflate(inflater, container, false);

        binding.appVersionBtn.setText(getString(R.string.version) + ": " + BuildConfig.VERSION_NAME + " ( " + BuildConfig.VERSION_CODE + " ) ");
        binding.appVersionBtn.setOnLongClickListener(view -> {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("getContext()", "Tabiin: " + getString(R.string.version) + ": " + BuildConfig.VERSION_NAME + " ( " + BuildConfig.VERSION_CODE + " ) ");
            clipboardManager.setPrimaryClip(clipData);
            Snackbar.make(getView(), "text copied", Snackbar.LENGTH_LONG).show();
            return true;
        });

        binding.sourceCodeBtn.setOnLongClickListener(view -> {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("getContext()", "https://github.com/Raf0707/Tabiin_Muslim_Planer");
            clipboardManager.setPrimaryClip(clipData);
            Snackbar.make(getView(), "link to source copied", Snackbar.LENGTH_LONG).show();
            return true;
        });

        binding.rafailBtn.setOnLongClickListener(view -> {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("getContext()", "https://github.com/Raf0707");
            clipboardManager.setPrimaryClip(clipData);
            Snackbar.make(getView(), "link to Rafail Kikmatulin's GitHub profile copied", Snackbar.LENGTH_LONG).show();
            return true;
        });

        binding.ibragimBtn.setOnLongClickListener(view -> {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("getContext()", "https://github.com/IbremMiner837");
            clipboardManager.setPrimaryClip(clipData);
            Snackbar.make(getView(), "link to Ibragim Magaltsov's GitHub profile copied", Snackbar.LENGTH_LONG).show();
            return true;
        });

        binding.danilaBtn.setOnLongClickListener(view -> {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("getContext()", "https://github.com/DanilaDevx21x");
            clipboardManager.setPrimaryClip(clipData);
            Snackbar.make(getView(), "link to Danila Vorobyov's GitHub profile copied", Snackbar.LENGTH_LONG).show();
            return true;
        });

        binding.mailIbremBtn.setOnLongClickListener(view -> {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("getContext()", "ibremminer837.dev@gmail.com");
            clipboardManager.setPrimaryClip(clipData);
            Snackbar.make(getView(), "Ibrabim Magaltsov's email copied", Snackbar.LENGTH_LONG).show();
            return true;
        });

        binding.mailDanilaBtn.setOnLongClickListener(view -> {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("getContext()", "rswayfarersx@gmail.com");
            clipboardManager.setPrimaryClip(clipData);
            Snackbar.make(getView(), "Danila Vorobyov's email copied", Snackbar.LENGTH_LONG).show();
            return true;
        });

        binding.mailRafBtn.setOnLongClickListener(view -> {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("getContext()", "raf_android-dev@mail.ru");
            clipboardManager.setPrimaryClip(clipData);
            Snackbar.make(getView(), "Rafail Kikmatulin's email copied", Snackbar.LENGTH_LONG).show();
            return true;
        });

        binding.vkGroupBtn.setOnLongClickListener(view -> {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("getContext()", "https://vk.com/club213851453");
            clipboardManager.setPrimaryClip(clipData);
            Snackbar.make(getView(), "VK-Group's Tabiin link copied", Snackbar.LENGTH_LONG).show();
            return true;
        });

        binding.appVersionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCount += 1;
                if (clickCount == 8) {
                    changeFragment(getActivity(), new DeveloperParamsFragment(), R.id.kontainerFragment, null);
                    
                }
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

        binding.mailIbremBtn.setOnClickListener(v -> {
            final Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{getString(R.string.mail_ibrem)});
            //emailIntent.putExtra(Intent.EXTRA_SUBJECT, R.string.feedback);
            emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.version) + ": " + BuildConfig.VERSION_NAME + " ( " + BuildConfig.VERSION_CODE + " ) ");

            emailIntent.setType("plain/text");
            // setType("message/rfc822")

            try {
                startActivity(Intent.createChooser(emailIntent, "Send email using..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getActivity(),
                        "No email clients installed.", Toast.LENGTH_SHORT).show();
            }
        });

        binding.mailDanilaBtn.setOnClickListener(v -> {
            final Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{getString(R.string.mail_danila)});
            //emailIntent.putExtra(Intent.EXTRA_SUBJECT, R.string.feedback);
            emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.version) + ": " + BuildConfig.VERSION_NAME + " ( " + BuildConfig.VERSION_CODE + " ) ");

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