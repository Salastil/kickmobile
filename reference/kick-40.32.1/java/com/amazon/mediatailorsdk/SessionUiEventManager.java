package com.amazon.mediatailorsdk;

import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: SessionUiEventManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u0016\u0010\"\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u000bH\u0016J \u0010%\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010'\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010)\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020*H\u0016JJ\u0010,\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00112:\u0010-\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0010j\u0002`\u0018JJ\u0010.\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00112:\u0010-\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0010j\u0002`\u0018R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u009c\u0002\u0010\f\u001a\u008f\u0002\u0012\u0004\u0012\u00020\u000e\u0012|\u0012z\u00128\u00126\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0010j\u0002`\u00180\u000fj<\u00128\u00126\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0010j\u0002`\u0018`\u00190\rj\u0086\u0001\u0012\u0004\u0012\u00020\u000e\u0012|\u0012z\u00128\u00126\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0010j\u0002`\u00180\u000fj<\u00128\u00126\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0010j\u0002`\u0018`\u0019`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/amazon/mediatailorsdk/SessionUiEventManager;", "Lcom/amazon/mediatailorsdk/AdObserver;", "<init>", "()V", "adObject", "Lcom/amazon/mediatailorsdk/AdObject;", "nonLinearAdsObject", "Lcom/amazon/mediatailorsdk/NonLinearAdsObject;", "skipOffset", "", "canSkip", "", "allUiEventListeners", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lkotlin/Function2;", "Lcom/amazon/mediatailorsdk/SessionUiEvent;", "Lkotlin/ParameterName;", "name", "event", "Lcom/amazon/mediatailorsdk/SessionUiEventData;", "data", "", "Lcom/amazon/mediatailorsdk/SessionUiEventListener;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "adObjectFromAdData", "adData", "Lcom/amazon/mediatailorsdk/AdData;", "adElapsedTime", "playhead", "adCountdownFromAdData", "Lcom/amazon/mediatailorsdk/AdCountdown;", "dispatchEvent", "onTrackingInfoResponse", "failed", "onAdStart", "onAdEnd", "onAdProgress", "onAdClick", "onNonLinearAdsStart", "Lcom/amazon/mediatailorsdk/NonLinearAdsData;", "onNonLinearAdsEnd", "addEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeEventListener", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SessionUiEventManager extends AdObserver {
    private AdObject adObject;
    private boolean canSkip;
    private NonLinearAdsObject nonLinearAdsObject;
    private double skipOffset = -1.0d;
    private final HashMap<String, ArrayList<Function2<SessionUiEvent, SessionUiEventData, Unit>>> allUiEventListeners = new HashMap<>();

    private final AdObject adObjectFromAdData(AdData adData, double adElapsedTime, double playhead) {
        return new AdObject(adData, adData.getVideoClickThrough(), Double.valueOf((playhead + adData.getDuration()) - adElapsedTime));
    }

    private final AdCountdown adCountdownFromAdData(AdData adData, double adElapsedTime) {
        double duration = adData.getDuration() - adElapsedTime;
        Double dValueOf = (adData.getAvailDuration() == null || adData.getInAvailStartOffset() == null) ? null : Double.valueOf((adData.getAvailDuration().doubleValue() - adData.getInAvailStartOffset().doubleValue()) - adElapsedTime);
        double d = this.skipOffset;
        return new AdCountdown(duration, dValueOf, d >= 0.0d ? Double.valueOf(Math.max(0.0d, d - adElapsedTime)) : null);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionUiEventManager$dispatchEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionUiEventManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionUiEventManager$dispatchEvent$1", f = "SessionUiEventManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C05771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SessionUiEventData $data;
        final /* synthetic */ SessionUiEvent $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05771(SessionUiEvent sessionUiEvent, SessionUiEventData sessionUiEventData, Continuation<? super C05771> continuation) {
            super(2, continuation);
            this.$event = sessionUiEvent;
            this.$data = sessionUiEventData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionUiEventManager.this.new C05771(this.$event, this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (SessionUiEventManager.this.allUiEventListeners.containsKey(this.$event.getKey()) && (arrayList = (ArrayList) SessionUiEventManager.this.allUiEventListeners.get(this.$event.getKey())) != null) {
                    SessionUiEvent sessionUiEvent = this.$event;
                    SessionUiEventData sessionUiEventData = this.$data;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((Function2) it.next()).invoke(sessionUiEvent, sessionUiEventData);
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void dispatchEvent(SessionUiEvent event, SessionUiEventData data) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), Dispatchers.getMain().getImmediate(), null, new C05771(event, data, null), 2, null);
    }

    @Override // com.amazon.mediatailorsdk.AdObserver
    public void onTrackingInfoResponse(boolean failed) {
        dispatchEvent(SessionUiEvent.AD_TRACKING_INFO_RESPONSE, new SessionUiEventData(null, null, null, null, null, null, Boolean.valueOf(failed), 63, null));
    }

    @Override // com.amazon.mediatailorsdk.AdObserver
    public void onAdStart(AdData adData, double adElapsedTime, double playhead) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        this.adObject = adObjectFromAdData(adData, adElapsedTime, playhead);
        this.skipOffset = adData.getSkipOffset();
        this.canSkip = false;
        dispatchEvent(SessionUiEvent.AD_START, new SessionUiEventData(this.adObject, null, Double.valueOf(adElapsedTime), adCountdownFromAdData(adData, adElapsedTime), null, null, null, 112, null));
    }

    @Override // com.amazon.mediatailorsdk.AdObserver
    public void onAdEnd(AdData adData) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        dispatchEvent(SessionUiEvent.AD_END, new SessionUiEventData(this.adObject, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null));
        this.adObject = null;
    }

    @Override // com.amazon.mediatailorsdk.AdObserver
    public void onAdProgress(AdData adData, double adElapsedTime, double playhead) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        dispatchEvent(SessionUiEvent.AD_PROGRESS, new SessionUiEventData(this.adObject, null, Double.valueOf(adElapsedTime), adCountdownFromAdData(adData, adElapsedTime), null, null, null, 112, null));
        if (this.canSkip) {
            return;
        }
        double d = this.skipOffset;
        if (d < 0.0d || adElapsedTime < d) {
            return;
        }
        this.canSkip = true;
        dispatchEvent(SessionUiEvent.AD_CAN_SKIP, new SessionUiEventData(this.adObject, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null));
    }

    @Override // com.amazon.mediatailorsdk.AdObserver
    public void onAdClick(AdData adData) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        SessionUiEvent sessionUiEvent = SessionUiEvent.AD_CLICK;
        AdObject adObject = this.adObject;
        dispatchEvent(sessionUiEvent, new SessionUiEventData(adObject, null, null, null, adObject != null ? adObject.getAdClickthroughUrl() : null, null, null, MediaError.DetailedErrorCode.SOURCE_BUFFER_FAILURE, null));
    }

    @Override // com.amazon.mediatailorsdk.AdObserver
    public void onNonLinearAdsStart(NonLinearAdsData adData, double adElapsedTime, double playhead) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        this.nonLinearAdsObject = new NonLinearAdsObject(adData);
        dispatchEvent(SessionUiEvent.NONLINEAR_AD_START, new SessionUiEventData(null, this.nonLinearAdsObject, Double.valueOf(adElapsedTime), null, null, null, null, TimeseriesConfiguration.DEFAULT_BUFFER_SIZE, null));
    }

    @Override // com.amazon.mediatailorsdk.AdObserver
    public void onNonLinearAdsEnd(NonLinearAdsData adData) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        dispatchEvent(SessionUiEvent.NONLINEAR_AD_END, new SessionUiEventData(null, this.nonLinearAdsObject, null, null, null, null, null, 124, null));
        this.nonLinearAdsObject = null;
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionUiEventManager$addEventListener$1, reason: invalid class name */
    /* JADX INFO: compiled from: SessionUiEventManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionUiEventManager$addEventListener$1", f = "SessionUiEventManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SessionUiEvent $event;
        final /* synthetic */ Function2<SessionUiEvent, SessionUiEventData, Unit> $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(SessionUiEvent sessionUiEvent, Function2<? super SessionUiEvent, ? super SessionUiEventData, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$event = sessionUiEvent;
            this.$listener = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionUiEventManager.this.new AnonymousClass1(this.$event, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                boolean zContainsKey = SessionUiEventManager.this.allUiEventListeners.containsKey(this.$event.getKey());
                SessionUiEventManager sessionUiEventManager = SessionUiEventManager.this;
                if (zContainsKey) {
                    Object obj2 = sessionUiEventManager.allUiEventListeners.get(this.$event.getKey());
                    Intrinsics.checkNotNull(obj2);
                    ArrayList arrayList = (ArrayList) obj2;
                    if (arrayList.indexOf(this.$listener) < 0) {
                        arrayList.add(this.$listener);
                    }
                } else {
                    sessionUiEventManager.allUiEventListeners.put(this.$event.getKey(), CollectionsKt.arrayListOf(this.$listener));
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void addEventListener(SessionUiEvent event, Function2<? super SessionUiEvent, ? super SessionUiEventData, Unit> listener) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(listener, "listener");
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), Dispatchers.getMain(), null, new AnonymousClass1(event, listener, null), 2, null);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionUiEventManager$removeEventListener$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionUiEventManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionUiEventManager$removeEventListener$1", f = "SessionUiEventManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C05781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SessionUiEvent $event;
        final /* synthetic */ Function2<SessionUiEvent, SessionUiEventData, Unit> $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C05781(SessionUiEvent sessionUiEvent, Function2<? super SessionUiEvent, ? super SessionUiEventData, Unit> function2, Continuation<? super C05781> continuation) {
            super(2, continuation);
            this.$event = sessionUiEvent;
            this.$listener = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionUiEventManager.this.new C05781(this.$event, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (SessionUiEventManager.this.allUiEventListeners.containsKey(this.$event.getKey())) {
                    Object obj2 = SessionUiEventManager.this.allUiEventListeners.get(this.$event.getKey());
                    Intrinsics.checkNotNull(obj2);
                    ArrayList arrayList = (ArrayList) obj2;
                    int iIndexOf = arrayList.indexOf(this.$listener);
                    if (iIndexOf >= 0) {
                        arrayList.remove(iIndexOf);
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void removeEventListener(SessionUiEvent event, Function2<? super SessionUiEvent, ? super SessionUiEventData, Unit> listener) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(listener, "listener");
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), Dispatchers.getMain(), null, new C05781(event, listener, null), 2, null);
    }
}
