package com.amazon.mediatailorsdk;

import kotlin.Metadata;

/* JADX INFO: compiled from: SessionUiEventManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/amazon/mediatailorsdk/AdCountdown;", "", "toAdEnd", "", "toAvailEnd", "toSkipThreshold", "<init>", "(DLjava/lang/Double;Ljava/lang/Double;)V", "getToAdEnd", "()D", "getToAvailEnd", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getToSkipThreshold", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AdCountdown {
    private final double toAdEnd;
    private final Double toAvailEnd;
    private final Double toSkipThreshold;

    public AdCountdown(double d, Double d2, Double d3) {
        this.toAdEnd = d;
        this.toAvailEnd = d2;
        this.toSkipThreshold = d3;
    }

    public final double getToAdEnd() {
        return this.toAdEnd;
    }

    public final Double getToAvailEnd() {
        return this.toAvailEnd;
    }

    public final Double getToSkipThreshold() {
        return this.toSkipThreshold;
    }
}
