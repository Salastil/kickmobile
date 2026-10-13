package io.datazoom.sdk.openmeasurement;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SessionPayload.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmSessionPayload;", "", "ad", "Lio/datazoom/sdk/openmeasurement/OmAdData;", "adView", "Landroid/view/View;", "contentUrl", "", "vendor", "Lio/datazoom/sdk/openmeasurement/OmVendor;", "<init>", "(Lio/datazoom/sdk/openmeasurement/OmAdData;Landroid/view/View;Ljava/lang/String;Lio/datazoom/sdk/openmeasurement/OmVendor;)V", "getAd", "()Lio/datazoom/sdk/openmeasurement/OmAdData;", "getAdView", "()Landroid/view/View;", "getContentUrl", "()Ljava/lang/String;", "getVendor", "()Lio/datazoom/sdk/openmeasurement/OmVendor;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class OmSessionPayload {
    private final OmAdData ad;
    private final View adView;
    private final String contentUrl;
    private final OmVendor vendor;

    public static /* synthetic */ OmSessionPayload copy$default(OmSessionPayload omSessionPayload, OmAdData omAdData, View view, String str, OmVendor omVendor, int i, Object obj) {
        if ((i & 1) != 0) {
            omAdData = omSessionPayload.ad;
        }
        if ((i & 2) != 0) {
            view = omSessionPayload.adView;
        }
        if ((i & 4) != 0) {
            str = omSessionPayload.contentUrl;
        }
        if ((i & 8) != 0) {
            omVendor = omSessionPayload.vendor;
        }
        return omSessionPayload.copy(omAdData, view, str, omVendor);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final OmAdData getAd() {
        return this.ad;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final View getAdView() {
        return this.adView;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContentUrl() {
        return this.contentUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final OmVendor getVendor() {
        return this.vendor;
    }

    public final OmSessionPayload copy(OmAdData ad, View adView, String contentUrl, OmVendor vendor) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return new OmSessionPayload(ad, adView, contentUrl, vendor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OmSessionPayload)) {
            return false;
        }
        OmSessionPayload omSessionPayload = (OmSessionPayload) other;
        return Intrinsics.areEqual(this.ad, omSessionPayload.ad) && Intrinsics.areEqual(this.adView, omSessionPayload.adView) && Intrinsics.areEqual(this.contentUrl, omSessionPayload.contentUrl) && Intrinsics.areEqual(this.vendor, omSessionPayload.vendor);
    }

    public int hashCode() {
        return (((((this.ad.hashCode() * 31) + this.adView.hashCode()) * 31) + this.contentUrl.hashCode()) * 31) + this.vendor.hashCode();
    }

    public String toString() {
        return "OmSessionPayload(ad=" + this.ad + ", adView=" + this.adView + ", contentUrl=" + this.contentUrl + ", vendor=" + this.vendor + ')';
    }

    public OmSessionPayload(OmAdData ad, View adView, String contentUrl, OmVendor vendor) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        this.ad = ad;
        this.adView = adView;
        this.contentUrl = contentUrl;
        this.vendor = vendor;
    }

    public final OmAdData getAd() {
        return this.ad;
    }

    public final View getAdView() {
        return this.adView;
    }

    public final String getContentUrl() {
        return this.contentUrl;
    }

    public final OmVendor getVendor() {
        return this.vendor;
    }
}
