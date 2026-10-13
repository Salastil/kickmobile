package io.datazoom.sdk.model;

import com.facebook.hermes.intl.Constants;
import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Media.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lio/datazoom/sdk/model/Media;", "", "title", "", "secondaryTitle", ImagesContract.URL, "closeCaptionLang", "mimeType", "assetId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getSecondaryTitle", "getUrl", "getCloseCaptionLang", "getMimeType", "getAssetId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Media {
    private final String assetId;
    private final String closeCaptionLang;
    private final String mimeType;
    private final String secondaryTitle;
    private final String title;
    private final String url;

    public static /* synthetic */ Media copy$default(Media media, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = media.title;
        }
        if ((i & 2) != 0) {
            str2 = media.secondaryTitle;
        }
        if ((i & 4) != 0) {
            str3 = media.url;
        }
        if ((i & 8) != 0) {
            str4 = media.closeCaptionLang;
        }
        if ((i & 16) != 0) {
            str5 = media.mimeType;
        }
        if ((i & 32) != 0) {
            str6 = media.assetId;
        }
        String str7 = str5;
        String str8 = str6;
        return media.copy(str, str2, str3, str4, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSecondaryTitle() {
        return this.secondaryTitle;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCloseCaptionLang() {
        return this.closeCaptionLang;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAssetId() {
        return this.assetId;
    }

    public final Media copy(String title, String secondaryTitle, String url, String closeCaptionLang, String mimeType, String assetId) {
        return new Media(title, secondaryTitle, url, closeCaptionLang, mimeType, assetId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Media)) {
            return false;
        }
        Media media = (Media) other;
        return Intrinsics.areEqual(this.title, media.title) && Intrinsics.areEqual(this.secondaryTitle, media.secondaryTitle) && Intrinsics.areEqual(this.url, media.url) && Intrinsics.areEqual(this.closeCaptionLang, media.closeCaptionLang) && Intrinsics.areEqual(this.mimeType, media.mimeType) && Intrinsics.areEqual(this.assetId, media.assetId);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.secondaryTitle;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.url;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.closeCaptionLang;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.mimeType;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.assetId;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "Media(title=" + this.title + ", secondaryTitle=" + this.secondaryTitle + ", url=" + this.url + ", closeCaptionLang=" + this.closeCaptionLang + ", mimeType=" + this.mimeType + ", assetId=" + this.assetId + ")";
    }

    public Media(String str, String str2, String str3, String str4, String str5, String str6) {
        this.title = str;
        this.secondaryTitle = str2;
        this.url = str3;
        this.closeCaptionLang = str4;
        this.mimeType = str5;
        this.assetId = str6;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSecondaryTitle() {
        return this.secondaryTitle;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getCloseCaptionLang() {
        return this.closeCaptionLang;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getAssetId() {
        return this.assetId;
    }
}
