package io.datazoom.sdk.openmeasurement;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SessionPayload.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmAdVerification;", "", "vendor", "", "javaScriptResource", "verificationParameters", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVendor", "()Ljava/lang/String;", "getJavaScriptResource", "getVerificationParameters", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class OmAdVerification {
    private final String javaScriptResource;
    private final String vendor;
    private final String verificationParameters;

    public static /* synthetic */ OmAdVerification copy$default(OmAdVerification omAdVerification, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = omAdVerification.vendor;
        }
        if ((i & 2) != 0) {
            str2 = omAdVerification.javaScriptResource;
        }
        if ((i & 4) != 0) {
            str3 = omAdVerification.verificationParameters;
        }
        return omAdVerification.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVendor() {
        return this.vendor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getJavaScriptResource() {
        return this.javaScriptResource;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVerificationParameters() {
        return this.verificationParameters;
    }

    public final OmAdVerification copy(String vendor, String javaScriptResource, String verificationParameters) {
        return new OmAdVerification(vendor, javaScriptResource, verificationParameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OmAdVerification)) {
            return false;
        }
        OmAdVerification omAdVerification = (OmAdVerification) other;
        return Intrinsics.areEqual(this.vendor, omAdVerification.vendor) && Intrinsics.areEqual(this.javaScriptResource, omAdVerification.javaScriptResource) && Intrinsics.areEqual(this.verificationParameters, omAdVerification.verificationParameters);
    }

    public int hashCode() {
        String str = this.vendor;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.javaScriptResource;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.verificationParameters;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "OmAdVerification(vendor=" + this.vendor + ", javaScriptResource=" + this.javaScriptResource + ", verificationParameters=" + this.verificationParameters + ')';
    }

    public OmAdVerification(String str, String str2, String str3) {
        this.vendor = str;
        this.javaScriptResource = str2;
        this.verificationParameters = str3;
    }

    public final String getVendor() {
        return this.vendor;
    }

    public final String getJavaScriptResource() {
        return this.javaScriptResource;
    }

    public final String getVerificationParameters() {
        return this.verificationParameters;
    }
}
