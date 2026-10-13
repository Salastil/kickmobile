package com.useinsider.insider;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.PaintDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class f5 {
    static float a(Context context, float f) {
        try {
            return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return 0.0f;
        }
    }

    static boolean b(Activity activity) {
        ViewGroup viewGroup;
        View viewFindViewWithTag;
        if (activity == null || (viewFindViewWithTag = (viewGroup = (ViewGroup) activity.getWindow().getDecorView()).findViewWithTag("insider_terms_view")) == null) {
            return false;
        }
        viewGroup.removeView(viewFindViewWithTag);
        return true;
    }

    static void a(Activity activity) {
        if (activity != null) {
            try {
                if (activity.getCurrentFocus() != null) {
                    ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    static float a(float f, View view, String str, float f2) {
        float f3 = (f * f2) / 100.0f;
        try {
            if (!str.equals("")) {
                PaintDrawable paintDrawable = new PaintDrawable(str.equals("clear") ? 0 : Color.parseColor(str));
                paintDrawable.setCornerRadius(f3);
                view.setBackground(paintDrawable);
            }
            return f3;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return f3;
        }
    }
}
