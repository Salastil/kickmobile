package io.datazoom.sdk.utils;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.ad.DzAdSessionMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdapterCallbackListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lio/datazoom/sdk/utils/AdapterCallbackListener;", "", "onPlaybackUpdate", "", "playHeadMs", "", "livePlayHeadMs", "", "(JLjava/lang/Double;)V", "onAdPlaybackEvents", "event", "Lio/datazoom/sdk/utils/DzPlaybackEvent;", "onAdInitialise", "adSessionMetadata", "Lio/datazoom/sdk/ad/DzAdSessionMetadata;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface AdapterCallbackListener {
    default void onAdInitialise(DzAdSessionMetadata adSessionMetadata) {
        Intrinsics.checkNotNullParameter(adSessionMetadata, "adSessionMetadata");
    }

    void onAdPlaybackEvents(DzPlaybackEvent event);

    void onPlaybackUpdate(long playHeadMs, Double livePlayHeadMs);

    /* JADX INFO: compiled from: AdapterCallbackListener.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onAdInitialise(AdapterCallbackListener adapterCallbackListener, DzAdSessionMetadata adSessionMetadata) {
            Intrinsics.checkNotNullParameter(adSessionMetadata, "adSessionMetadata");
            AdapterCallbackListener.super.onAdInitialise(adSessionMetadata);
        }
    }
}
