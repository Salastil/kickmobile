package io.datazoom.sdk.ad;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DzAdEvent.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/ad/DzAdEvent;", "", "type", "Lio/datazoom/sdk/ad/DzAdEventType;", "ad", "Lio/datazoom/sdk/ad/DzAd;", "<init>", "(Lio/datazoom/sdk/ad/DzAdEventType;Lio/datazoom/sdk/ad/DzAd;)V", "getType", "()Lio/datazoom/sdk/ad/DzAdEventType;", "getAd", "()Lio/datazoom/sdk/ad/DzAd;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DzAdEvent {
    private final DzAd ad;
    private final DzAdEventType type;

    public DzAdEvent(DzAdEventType type, DzAd dzAd) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.ad = dzAd;
    }

    public final DzAd getAd() {
        return this.ad;
    }

    public final DzAdEventType getType() {
        return this.type;
    }
}
