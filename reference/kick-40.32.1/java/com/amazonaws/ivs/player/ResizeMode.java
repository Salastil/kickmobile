package com.amazonaws.ivs.player;

import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ResizeMode {
    private static final /* synthetic */ ResizeMode[] $VALUES = $values();
    public static final ResizeMode FILL;
    public static final ResizeMode FIT;
    public static final ResizeMode ZOOM;

    protected abstract Size scaleTo(int i, int i2, int i3, int i4);

    private static /* synthetic */ ResizeMode[] $values() {
        return new ResizeMode[]{FIT, FILL, ZOOM};
    }

    private ResizeMode(String str, int i) {
        super(str, i);
    }

    public static ResizeMode valueOf(String str) {
        return (ResizeMode) Enum.valueOf(ResizeMode.class, str);
    }

    public static ResizeMode[] values() {
        return (ResizeMode[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: com.amazonaws.ivs.player.ResizeMode$1, reason: invalid class name */
    final enum AnonymousClass1 extends ResizeMode {
        private AnonymousClass1(String str, int i) {
            super(str, i);
        }

        @Override // com.amazonaws.ivs.player.ResizeMode
        protected Size scaleTo(int i, int i2, int i3, int i4) {
            float f = i4 / i3;
            float f2 = i2;
            float f3 = i * f;
            if (f2 > f3) {
                return new Size(i, (int) f3);
            }
            return new Size((int) (f2 / f), i2);
        }
    }

    static {
        FIT = new AnonymousClass1("FIT", 0);
        FILL = new AnonymousClass2("FILL", 1);
        ZOOM = new AnonymousClass3("ZOOM", 2);
    }

    /* JADX INFO: renamed from: com.amazonaws.ivs.player.ResizeMode$2, reason: invalid class name */
    final enum AnonymousClass2 extends ResizeMode {
        private AnonymousClass2(String str, int i) {
            super(str, i);
        }

        @Override // com.amazonaws.ivs.player.ResizeMode
        protected Size scaleTo(int i, int i2, int i3, int i4) {
            float f = i4 / i3;
            float f2 = i2;
            float f3 = i * f;
            if (f2 < f3) {
                return new Size(i, (int) f3);
            }
            return new Size((int) (f2 / f), i2);
        }
    }

    /* JADX INFO: renamed from: com.amazonaws.ivs.player.ResizeMode$3, reason: invalid class name */
    final enum AnonymousClass3 extends ResizeMode {
        private AnonymousClass3(String str, int i) {
            super(str, i);
        }

        @Override // com.amazonaws.ivs.player.ResizeMode
        protected Size scaleTo(int i, int i2, int i3, int i4) {
            return new Size(i, i2);
        }
    }

    void setLayoutParams(SurfaceView surfaceView, int i, int i2) {
        if (surfaceView == null || i <= 0 || i2 <= 0) {
            return;
        }
        View view = (View) surfaceView.getParent();
        if (view == null) {
            view = surfaceView;
        }
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return;
        }
        Size sizeScaleTo = scaleTo(view.getWidth(), view.getHeight(), i, i2);
        ViewGroup.LayoutParams layoutParams = surfaceView.getLayoutParams();
        layoutParams.width = sizeScaleTo.width;
        layoutParams.height = sizeScaleTo.height;
        surfaceView.setLayoutParams(layoutParams);
    }
}
