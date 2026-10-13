package com.facebook.fresco.vito.options;

import android.graphics.Bitmap;
import android.os.Build;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: BitmapConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/facebook/fresco/vito/options/BitmapConfig;", "", "<init>", "(Ljava/lang/String;I)V", "ARGB_8888", "RGBA_1010102", "HARDWARE", "toAndroidBitmapConfig", "Landroid/graphics/Bitmap$Config;", "options_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum BitmapConfig {
    ARGB_8888,
    RGBA_1010102,
    HARDWARE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: compiled from: BitmapConfig.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BitmapConfig.values().length];
            try {
                iArr[BitmapConfig.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BitmapConfig.RGBA_1010102.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BitmapConfig.HARDWARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<BitmapConfig> getEntries() {
        return $ENTRIES;
    }

    public final Bitmap.Config toAndroidBitmapConfig() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return Bitmap.Config.ARGB_8888;
        }
        if (i == 2) {
            if (Build.VERSION.SDK_INT >= 33) {
                return Bitmap.Config.RGBA_1010102;
            }
            return Bitmap.Config.ARGB_8888;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return Bitmap.Config.HARDWARE;
        }
        return Bitmap.Config.ARGB_8888;
    }
}
