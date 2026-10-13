package io.datazoom.sdk.ad;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.Event;
import io.datazoom.sdk.model.EventKt;
import io.datazoom.sdk.stateMachine.timeSync.model.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdEventProcessor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JR\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\t¨\u0006\u0010"}, d2 = {"Lio/datazoom/sdk/ad/AdManager;", "", "<init>", "()V", "processAdEvent", "", "adEvent", "Lio/datazoom/sdk/ad/DzAdEvent;", "sendEvent", "Lkotlin/Function1;", "Lio/datazoom/sdk/model/Event;", "adBreakFinished", "Lkotlin/Function0;", "onAdSkipped", "setState", "Lio/datazoom/sdk/stateMachine/timeSync/model/State;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AdManager {

    /* JADX INFO: compiled from: AdEventProcessor.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DzAdEventType.values().length];
            try {
                iArr[DzAdEventType.LOADED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DzAdEventType.IMPRESSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DzAdEventType.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DzAdEventType.STARTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DzAdEventType.SKIPPED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DzAdEventType.AD_BUFFERING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DzAdEventType.CLICKED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void processAdEvent(DzAdEvent adEvent, Function1<? super Event, Unit> sendEvent, Function0<Unit> adBreakFinished, Function0<Unit> onAdSkipped, Function1<? super State, Unit> setState) {
        Intrinsics.checkNotNullParameter(adEvent, "adEvent");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        Intrinsics.checkNotNullParameter(adBreakFinished, "adBreakFinished");
        Intrinsics.checkNotNullParameter(onAdSkipped, "onAdSkipped");
        Intrinsics.checkNotNullParameter(setState, "setState");
        switch (WhenMappings.$EnumSwitchMapping$0[adEvent.getType().ordinal()]) {
            case 1:
                sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.MediaLoadedAd, 0L, null, null, null, 15, null));
                break;
            case 2:
                sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.AdImpression, 0L, null, null, null, 15, null));
                break;
            case 3:
                setState.invoke(State.Ad.COMPLETED.INSTANCE);
                DzAd ad = adEvent.getAd();
                if (ad != null && DzAdKt.isLastAd(ad)) {
                    setState.invoke(State.Ad.Break.ENDED.INSTANCE);
                    adBreakFinished.invoke();
                    break;
                }
                break;
            case 4:
                setState.invoke(State.Ad.PLAYING.INSTANCE);
                break;
            case 5:
                setState.invoke(State.Ad.SKIPPED.INSTANCE);
                DzAd ad2 = adEvent.getAd();
                if (ad2 != null && DzAdKt.isLastAd(ad2)) {
                    setState.invoke(State.Ad.Break.ENDED.INSTANCE);
                    adBreakFinished.invoke();
                    break;
                }
                break;
            case 6:
                setState.invoke(State.Ad.BUFFERING.INSTANCE);
                break;
            case 7:
                sendEvent.invoke(EventKt.toAdEvent$default(Event.Type.AdClick, 0L, null, null, null, 15, null));
                break;
        }
    }
}
