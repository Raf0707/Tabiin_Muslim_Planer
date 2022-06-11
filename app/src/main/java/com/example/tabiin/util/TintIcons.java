package com.example.tabiin.util;

import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.widget.*;

import androidx.core.content.*;
import androidx.core.graphics.drawable.*;

public class TintIcons {

    public static Drawable tintIcon(Drawable icon, ColorStateList colorStateList) {
        if(icon!=null) {
            icon = DrawableCompat.wrap(icon).mutate();
            DrawableCompat.setTintList(icon, colorStateList);
            DrawableCompat.setTintMode(icon, PorterDuff.Mode.SRC_IN);
        }
        return icon;
    }

    public static void tintImageView(ImageView imageView, int colorStateListResId) {
        ColorStateList list = ContextCompat.getColorStateList(imageView.getContext(), colorStateListResId);
        if (list != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                imageView.setImageTintList(list);
            } else {
                imageView.setImageDrawable(tintIcon(imageView.getDrawable(), list));
            }
        }
    }
}