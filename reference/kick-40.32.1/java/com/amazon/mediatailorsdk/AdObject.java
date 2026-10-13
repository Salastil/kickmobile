package com.amazon.mediatailorsdk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SessionUiEventManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/amazon/mediatailorsdk/AdObject;", "", "adData", "Lcom/amazon/mediatailorsdk/AdData;", "adClickthroughUrl", "", "targetPlayheadForAdSkip", "", "<init>", "(Lcom/amazon/mediatailorsdk/AdData;Ljava/lang/String;Ljava/lang/Double;)V", "getAdData", "()Lcom/amazon/mediatailorsdk/AdData;", "getAdClickthroughUrl", "()Ljava/lang/String;", "getTargetPlayheadForAdSkip", "()Ljava/lang/Double;", "Ljava/lang/Double;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AdObject {
    private final String adClickthroughUrl;
    private final AdData adData;
    private final Double targetPlayheadForAdSkip;

    public AdObject(AdData adData, String str, Double d) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        this.adData = adData;
        this.adClickthroughUrl = str;
        this.targetPlayheadForAdSkip = d;
    }

    public final AdData getAdData() {
        return this.adData;
    }

    public final String getAdClickthroughUrl() {
        return this.adClickthroughUrl;
    }

    public final Double getTargetPlayheadForAdSkip() {
        return this.targetPlayheadForAdSkip;
    }
}
