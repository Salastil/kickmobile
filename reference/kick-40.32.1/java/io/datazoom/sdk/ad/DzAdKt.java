package io.datazoom.sdk.ad;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DzAd.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"isLastAd", "", "Lio/datazoom/sdk/ad/DzAd;", "(Lio/datazoom/sdk/ad/DzAd;)Z", "isFirstAd", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DzAdKt {
    public static final boolean isLastAd(DzAd dzAd) {
        Intrinsics.checkNotNullParameter(dzAd, "<this>");
        return dzAd.getAdPosition() == dzAd.getTotalAds();
    }

    public static final boolean isFirstAd(DzAd dzAd) {
        Intrinsics.checkNotNullParameter(dzAd, "<this>");
        return dzAd.getAdPosition() == 1;
    }
}
