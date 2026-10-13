package com.facebook.imagepipeline.cache;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimilarImageLookup.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/facebook/imagepipeline/cache/SimilarImageResult;", "", "cacheKeyString", "", "groupKey", ViewProps.WIDTH, "", ViewProps.HEIGHT, "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getCacheKeyString", "()Ljava/lang/String;", "getGroupKey", "getWidth", "()I", "getHeight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SimilarImageResult {
    private final String cacheKeyString;
    private final String groupKey;
    private final int height;
    private final int width;

    public static /* synthetic */ SimilarImageResult copy$default(SimilarImageResult similarImageResult, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = similarImageResult.cacheKeyString;
        }
        if ((i3 & 2) != 0) {
            str2 = similarImageResult.groupKey;
        }
        if ((i3 & 4) != 0) {
            i = similarImageResult.width;
        }
        if ((i3 & 8) != 0) {
            i2 = similarImageResult.height;
        }
        return similarImageResult.copy(str, str2, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCacheKeyString() {
        return this.cacheKeyString;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGroupKey() {
        return this.groupKey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final SimilarImageResult copy(String cacheKeyString, String groupKey, int width, int height) {
        Intrinsics.checkNotNullParameter(cacheKeyString, "cacheKeyString");
        return new SimilarImageResult(cacheKeyString, groupKey, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SimilarImageResult)) {
            return false;
        }
        SimilarImageResult similarImageResult = (SimilarImageResult) other;
        return Intrinsics.areEqual(this.cacheKeyString, similarImageResult.cacheKeyString) && Intrinsics.areEqual(this.groupKey, similarImageResult.groupKey) && this.width == similarImageResult.width && this.height == similarImageResult.height;
    }

    public int hashCode() {
        int iHashCode = this.cacheKeyString.hashCode() * 31;
        String str = this.groupKey;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "SimilarImageResult(cacheKeyString=" + this.cacheKeyString + ", groupKey=" + this.groupKey + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public SimilarImageResult(String cacheKeyString, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(cacheKeyString, "cacheKeyString");
        this.cacheKeyString = cacheKeyString;
        this.groupKey = str;
        this.width = i;
        this.height = i2;
    }

    public final String getCacheKeyString() {
        return this.cacheKeyString;
    }

    public final String getGroupKey() {
        return this.groupKey;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }
}
