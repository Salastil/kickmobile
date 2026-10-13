package expo.modules.updates.manifest;

import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResponseHeaderData.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lexpo/modules/updates/manifest/ResponsePartInfo;", "", "responseHeaderData", "Lexpo/modules/updates/manifest/ResponseHeaderData;", "responsePartHeaderData", "Lexpo/modules/updates/manifest/ResponsePartHeaderData;", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "", "<init>", "(Lexpo/modules/updates/manifest/ResponseHeaderData;Lexpo/modules/updates/manifest/ResponsePartHeaderData;Ljava/lang/String;)V", "getResponseHeaderData", "()Lexpo/modules/updates/manifest/ResponseHeaderData;", "getResponsePartHeaderData", "()Lexpo/modules/updates/manifest/ResponsePartHeaderData;", "getBody", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ResponsePartInfo {
    private final String body;
    private final ResponseHeaderData responseHeaderData;
    private final ResponsePartHeaderData responsePartHeaderData;

    public static /* synthetic */ ResponsePartInfo copy$default(ResponsePartInfo responsePartInfo, ResponseHeaderData responseHeaderData, ResponsePartHeaderData responsePartHeaderData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            responseHeaderData = responsePartInfo.responseHeaderData;
        }
        if ((i & 2) != 0) {
            responsePartHeaderData = responsePartInfo.responsePartHeaderData;
        }
        if ((i & 4) != 0) {
            str = responsePartInfo.body;
        }
        return responsePartInfo.copy(responseHeaderData, responsePartHeaderData, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ResponseHeaderData getResponseHeaderData() {
        return this.responseHeaderData;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ResponsePartHeaderData getResponsePartHeaderData() {
        return this.responsePartHeaderData;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    public final ResponsePartInfo copy(ResponseHeaderData responseHeaderData, ResponsePartHeaderData responsePartHeaderData, String body) {
        Intrinsics.checkNotNullParameter(responseHeaderData, "responseHeaderData");
        Intrinsics.checkNotNullParameter(responsePartHeaderData, "responsePartHeaderData");
        Intrinsics.checkNotNullParameter(body, "body");
        return new ResponsePartInfo(responseHeaderData, responsePartHeaderData, body);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponsePartInfo)) {
            return false;
        }
        ResponsePartInfo responsePartInfo = (ResponsePartInfo) other;
        return Intrinsics.areEqual(this.responseHeaderData, responsePartInfo.responseHeaderData) && Intrinsics.areEqual(this.responsePartHeaderData, responsePartInfo.responsePartHeaderData) && Intrinsics.areEqual(this.body, responsePartInfo.body);
    }

    public int hashCode() {
        return (((this.responseHeaderData.hashCode() * 31) + this.responsePartHeaderData.hashCode()) * 31) + this.body.hashCode();
    }

    public String toString() {
        return "ResponsePartInfo(responseHeaderData=" + this.responseHeaderData + ", responsePartHeaderData=" + this.responsePartHeaderData + ", body=" + this.body + ")";
    }

    public ResponsePartInfo(ResponseHeaderData responseHeaderData, ResponsePartHeaderData responsePartHeaderData, String body) {
        Intrinsics.checkNotNullParameter(responseHeaderData, "responseHeaderData");
        Intrinsics.checkNotNullParameter(responsePartHeaderData, "responsePartHeaderData");
        Intrinsics.checkNotNullParameter(body, "body");
        this.responseHeaderData = responseHeaderData;
        this.responsePartHeaderData = responsePartHeaderData;
        this.body = body;
    }

    public final ResponseHeaderData getResponseHeaderData() {
        return this.responseHeaderData;
    }

    public final ResponsePartHeaderData getResponsePartHeaderData() {
        return this.responsePartHeaderData;
    }

    public final String getBody() {
        return this.body;
    }
}
