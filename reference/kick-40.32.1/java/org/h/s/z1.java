package org.h.s;

import com.facebook.common.callercontext.ContextChain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u001a\b\u0000\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0010\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015\"\u0004\b\u0003\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\t\u0010\u001aR*\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u001c\u0010\u0004\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u0003\u0010\u001aR$\u0010&\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b\u0003\u0010%R$\u0010)\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b\u0010\u0010%R$\u0010,\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\"\u001a\u0004\b+\u0010$\"\u0004\b\t\u0010%¨\u0006-"}, d2 = {"Lorg/h/s/z1;", "", "", "a", "Ljava/lang/String;", "getAndroidPriority", "()Ljava/lang/String;", "androidPriority", "", "b", "Z", "getWasBackgrounded", "()Z", "d", "(Z)V", "wasBackgrounded", "c", "getNetworkDisrupted", "networkDisrupted", "", "I", "()I", "(I)V", "mobileSdkRetries", "e", "getInitMethod", "(Ljava/lang/String;)V", "initMethod", "f", "getInterrogationStatus", "getInterrogationStatus$annotations", "()V", "interrogationStatus", "g", "Ljava/lang/Integer;", "getDownstreamMbSpeed", "()Ljava/lang/Integer;", "(Ljava/lang/Integer;)V", "downstreamMbSpeed", "h", "getUpstreamMbSpeed", "upstreamMbSpeed", ContextChain.TAG_INFRA, "getSignalStrength", "signalStrength", "sdk_release"}, k = 1, mv = {1, 9, 0})
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @SerializedName("androidPriority")
    private final String androidPriority;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @SerializedName("wasBackgrounded")
    private boolean wasBackgrounded;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @SerializedName("networkDisrupted")
    private boolean networkDisrupted;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @SerializedName("mobileSdkRetries")
    private int mobileSdkRetries;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @SerializedName("initMethod")
    private String initMethod;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @SerializedName("interrogationStatus")
    private String interrogationStatus;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @SerializedName("downstreamMbSpeed")
    private Integer downstreamMbSpeed;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @SerializedName("upstreamMbSpeed")
    private Integer upstreamMbSpeed;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @SerializedName("signalStrength")
    private Integer signalStrength;

    public z1(int i, String androidPriority, String initMethod, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(androidPriority, "androidPriority");
        Intrinsics.checkNotNullParameter(initMethod, "initMethod");
        this.androidPriority = androidPriority;
        this.wasBackgrounded = z;
        this.networkDisrupted = z2;
        this.mobileSdkRetries = i;
        this.initMethod = initMethod;
        this.interrogationStatus = "expirationOfToken";
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getMobileSdkRetries() {
        return this.mobileSdkRetries;
    }

    public final void b() {
        Intrinsics.checkNotNullParameter("getInstance", "<set-?>");
        this.initMethod = "getInstance";
    }

    public final void c() {
        this.networkDisrupted = true;
    }

    public final void d() {
        this.wasBackgrounded = true;
    }

    public final void a(int i) {
        this.mobileSdkRetries = i;
    }

    public final void b(Integer num) {
        this.signalStrength = num;
    }

    public final void c(Integer num) {
        this.upstreamMbSpeed = num;
    }

    public final void a(String str) {
        this.interrogationStatus = str;
    }

    public final void a(Integer num) {
        this.downstreamMbSpeed = num;
    }

    public /* synthetic */ z1(String str) {
        this(0, str, "", false, false);
    }
}
