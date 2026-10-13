package com.amazon.mediatailorsdk;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: SessionTracker.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/amazon/mediatailorsdk/AdInfo;", "", ViewProps.START, "", "duration", "", "<init>", "(DLjava/lang/String;)V", "getStart", "()D", "getDuration", "()Ljava/lang/String;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class AdInfo {
    private final String duration;
    private final double start;

    public AdInfo(double d, String str) {
        this.start = d;
        this.duration = str;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final double getStart() {
        return this.start;
    }
}
