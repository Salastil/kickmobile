package com.amazon.mediatailorsdk;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: AdData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/amazon/mediatailorsdk/AdDataCommon;", "", ViewProps.START, "", "startDate", "duration", "<init>", "(DDD)V", "getStart", "()D", "getDuration", "value", "getStartDate", "setStartDate$MediaTailor_release", "(D)V", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class AdDataCommon {
    private final double duration;
    private final double start;
    private double startDate;

    public AdDataCommon(double d, double d2, double d3) {
        this.start = d;
        this.duration = d3;
        this.startDate = d2;
    }

    public final double getStart() {
        return this.start;
    }

    public final double getDuration() {
        return this.duration;
    }

    public final double getStartDate() {
        return this.startDate;
    }

    public final void setStartDate$MediaTailor_release(double d) {
        this.startDate = d;
    }
}
