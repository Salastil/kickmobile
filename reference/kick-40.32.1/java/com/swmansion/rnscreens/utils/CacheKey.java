package com.swmansion.rnscreens.utils;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: ScreenDummyLayoutHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/swmansion/rnscreens/utils/CacheKey;", "", ViewProps.FONT_SIZE, "", "isTitleEmpty", "", "applyTopInset", "<init>", "(IZZ)V", "getFontSize", "()I", "()Z", "getApplyTopInset", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
final /* data */ class CacheKey {
    private final boolean applyTopInset;
    private final int fontSize;
    private final boolean isTitleEmpty;

    public static /* synthetic */ CacheKey copy$default(CacheKey cacheKey, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cacheKey.fontSize;
        }
        if ((i2 & 2) != 0) {
            z = cacheKey.isTitleEmpty;
        }
        if ((i2 & 4) != 0) {
            z2 = cacheKey.applyTopInset;
        }
        return cacheKey.copy(i, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFontSize() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsTitleEmpty() {
        return this.isTitleEmpty;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getApplyTopInset() {
        return this.applyTopInset;
    }

    public final CacheKey copy(int fontSize, boolean isTitleEmpty, boolean applyTopInset) {
        return new CacheKey(fontSize, isTitleEmpty, applyTopInset);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheKey)) {
            return false;
        }
        CacheKey cacheKey = (CacheKey) other;
        return this.fontSize == cacheKey.fontSize && this.isTitleEmpty == cacheKey.isTitleEmpty && this.applyTopInset == cacheKey.applyTopInset;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.fontSize) * 31) + Boolean.hashCode(this.isTitleEmpty)) * 31) + Boolean.hashCode(this.applyTopInset);
    }

    public String toString() {
        return "CacheKey(fontSize=" + this.fontSize + ", isTitleEmpty=" + this.isTitleEmpty + ", applyTopInset=" + this.applyTopInset + ")";
    }

    public CacheKey(int i, boolean z, boolean z2) {
        this.fontSize = i;
        this.isTitleEmpty = z;
        this.applyTopInset = z2;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final boolean isTitleEmpty() {
        return this.isTitleEmpty;
    }

    public final boolean getApplyTopInset() {
        return this.applyTopInset;
    }
}
