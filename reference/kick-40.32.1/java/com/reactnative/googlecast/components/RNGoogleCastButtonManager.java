package com.reactnative.googlecast.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.mediarouter.R;
import androidx.mediarouter.app.MediaRouteButton;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
@ReactModule(name = RNGoogleCastButtonManager.REACT_CLASS)
public class RNGoogleCastButtonManager extends SimpleViewManager<MediaRouteButton> {
    public static final String REACT_CLASS = "RNGoogleCastButton";
    protected static List<MediaRouteButton> currentInstances = new ArrayList();
    private Integer mColor = null;

    public static MediaRouteButton getCurrent() {
        if (currentInstances.size() == 0) {
            return null;
        }
        List<MediaRouteButton> list = currentInstances;
        return list.get(list.size() - 1);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MediaRouteButton createViewInstance(ThemedReactContext themedReactContext) {
        ColorableMediaRouteButton colorableMediaRouteButton = new ColorableMediaRouteButton(themedReactContext);
        TypedArray typedArrayObtainStyledAttributes = new ContextThemeWrapper(themedReactContext, R.style.Theme_MediaRouter).obtainStyledAttributes(null, R.styleable.MediaRouteButton, R.attr.mediaRouteButtonStyle, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.MediaRouteButton_externalRouteEnabledDrawable);
        typedArrayObtainStyledAttributes.recycle();
        colorableMediaRouteButton.setRemoteIndicatorDrawable(drawable);
        try {
            CastContext.getSharedInstance(themedReactContext);
            CastButtonFactory.setUpMediaRouteButton(themedReactContext, colorableMediaRouteButton);
        } catch (Exception unused) {
        }
        return colorableMediaRouteButton;
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public void setTintColor(ColorableMediaRouteButton colorableMediaRouteButton, Integer num) {
        if (num == null) {
            return;
        }
        colorableMediaRouteButton.applyTint(num);
        this.mColor = num;
    }

    private class ColorableMediaRouteButton extends MediaRouteButton {
        protected Drawable mRemoteIndicatorDrawable;

        public ColorableMediaRouteButton(Context context) {
            super(context);
        }

        public ColorableMediaRouteButton(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public ColorableMediaRouteButton(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        @Override // androidx.mediarouter.app.MediaRouteButton
        public void setRemoteIndicatorDrawable(Drawable drawable) {
            this.mRemoteIndicatorDrawable = drawable;
            super.setRemoteIndicatorDrawable(drawable);
            if (RNGoogleCastButtonManager.this.mColor != null) {
                applyTint(RNGoogleCastButtonManager.this.mColor);
            }
        }

        public void applyTint(Integer num) {
            Drawable drawable = this.mRemoteIndicatorDrawable;
            if (drawable == null) {
                return;
            }
            DrawableCompat.setTint(DrawableCompat.wrap(drawable), num.intValue());
        }

        @Override // androidx.mediarouter.app.MediaRouteButton, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            RNGoogleCastButtonManager.currentInstances.remove(this);
        }

        @Override // androidx.mediarouter.app.MediaRouteButton, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            RNGoogleCastButtonManager.currentInstances.add(this);
        }
    }
}
