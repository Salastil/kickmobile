package com.amazon.mediatailorsdk;

import androidx.appcompat.app.AppCompatDelegate;
import com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.notifications.service.NotificationsService;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: Session.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B/\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0015\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0011J\u001f\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00162\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0016J\u000e\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u0011J\u0006\u0010#\u001a\u00020\u0011JJ\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&2:\u0010'\u001a6\u0012\u0013\u0012\u00110&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110+¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00110(j\u0002`,JJ\u0010-\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&2:\u0010'\u001a6\u0012\u0013\u0012\u00110&¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110+¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00110(j\u0002`,J\u000e\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020\u00112\u0006\u0010/\u001a\u000200J/\u00102\u001a\u00020\u00112'\u00103\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020605¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001104J9\u00108\u001a\u00020\u00112'\u00103\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020905¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0011042\b\b\u0002\u0010:\u001a\u00020;J\u0006\u0010<\u001a\u00020\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006="}, d2 = {"Lcom/amazon/mediatailorsdk/SessionCommon;", "", "playbackUrl", "", "trackingUrl", "palNonce", "tracker", "Lcom/amazon/mediatailorsdk/SessionTracker;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mediatailorsdk/SessionTracker;)V", "getPlaybackUrl", "()Ljava/lang/String;", "getTrackingUrl", "getPalNonce", "getTracker$MediaTailor_release", "()Lcom/amazon/mediatailorsdk/SessionTracker;", "updateAdTrackingInfo", "", "data", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse;", "startUpdatingAdTrackingInfo", "requestInterval", "", "(Ljava/lang/Double;)V", "stopUpdatingAdTrackingInfo", "onPlayheadUpdate", "playhead", "programDateTime", "(DLjava/lang/Double;)V", "onPlaybackRateUpdate", "rate", "onPlaybackEvent", "playbackEvent", "Lcom/amazon/mediatailorsdk/PlaybackEvent;", "onAdClickthrough", "onAdSkip", "addUiEventListener", "event", "Lcom/amazon/mediatailorsdk/SessionUiEvent;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcom/amazon/mediatailorsdk/SessionUiEventData;", "Lcom/amazon/mediatailorsdk/SessionUiEventListener;", "removeUiEventListener", "addAdObserver", "adObserver", "Lcom/amazon/mediatailorsdk/AdObserver;", "removeAdObserver", "getAllAds", NotificationsService.RECEIVER_KEY, "Lkotlin/Function1;", "", "Lcom/amazon/mediatailorsdk/AdData;", "ads", "getAllNonLinearAds", "Lcom/amazon/mediatailorsdk/NonLinearAdsData;", "includeOffTimelineAds", "", "destroy", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class SessionCommon {
    private final String palNonce;
    private final String playbackUrl;
    private final SessionTracker tracker;
    private final String trackingUrl;

    public final void destroy() {
    }

    public SessionCommon(String str, String str2, String str3, SessionTracker tracker) {
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.playbackUrl = str;
        this.trackingUrl = str2;
        this.palNonce = str3;
        this.tracker = tracker;
    }

    public final String getPlaybackUrl() {
        return this.playbackUrl;
    }

    public final String getTrackingUrl() {
        return this.trackingUrl;
    }

    public final String getPalNonce() {
        return this.palNonce;
    }

    /* JADX INFO: renamed from: getTracker$MediaTailor_release, reason: from getter */
    public final SessionTracker getTracker() {
        return this.tracker;
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionCommon$updateAdTrackingInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Session.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionCommon$updateAdTrackingInfo$1", f = "Session.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, nl = {50}, s = {}, v = 2)
    static final class C05621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AdTrackingResponse $data;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05621(AdTrackingResponse adTrackingResponse, Continuation<? super C05621> continuation) {
            super(2, continuation);
            this.$data = adTrackingResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionCommon.this.new C05621(this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SessionCommon.this.getTracker().updateAdTrackingInfo(this.$data, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void updateAdTrackingInfo(AdTrackingResponse data) {
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new C05621(data, null), 3, null);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionCommon$startUpdatingAdTrackingInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Session.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionCommon$startUpdatingAdTrackingInfo$1", f = "Session.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, nl = {63}, s = {}, v = 2)
    static final class C05601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Double $requestInterval;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05601(Double d, Continuation<? super C05601> continuation) {
            super(2, continuation);
            this.$requestInterval = d;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionCommon.this.new C05601(this.$requestInterval, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SessionCommon.this.getTracker().startUpdatingAdTrackingInfo(this.$requestInterval, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void startUpdatingAdTrackingInfo(Double requestInterval) {
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new C05601(requestInterval, null), 3, null);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionCommon$stopUpdatingAdTrackingInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Session.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionCommon$stopUpdatingAdTrackingInfo$1", f = "Session.kt", i = {}, l = {EACTags.MESSAGE_REFERENCE}, m = "invokeSuspend", n = {}, nl = {72}, s = {}, v = 2)
    static final class C05611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05611(Continuation<? super C05611> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionCommon.this.new C05611(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SessionCommon.this.getTracker().stopUpdatingAdTrackingInfo(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void stopUpdatingAdTrackingInfo() {
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new C05611(null), 3, null);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionCommon$onPlayheadUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Session.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionCommon$onPlayheadUpdate$1", f = "Session.kt", i = {}, l = {JpegTranscoderUtils.DEFAULT_JPEG_QUALITY}, m = "invokeSuspend", n = {}, nl = {86}, s = {}, v = 2)
    static final class C05591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ double $playhead;
        final /* synthetic */ Double $programDateTime;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05591(double d, Double d2, Continuation<? super C05591> continuation) {
            super(2, continuation);
            this.$playhead = d;
            this.$programDateTime = d2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionCommon.this.new C05591(this.$playhead, this.$programDateTime, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SessionCommon.this.getTracker().onPlayheadUpdate(this.$playhead, this.$programDateTime, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void onPlayheadUpdate$default(SessionCommon sessionCommon, double d, Double d2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPlayheadUpdate");
        }
        if ((i & 2) != 0) {
            d2 = null;
        }
        sessionCommon.onPlayheadUpdate(d, d2);
    }

    public final void onPlayheadUpdate(double playhead, Double programDateTime) {
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new C05591(playhead, programDateTime, null), 3, null);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionCommon$onPlaybackRateUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Session.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionCommon$onPlaybackRateUpdate$1", f = "Session.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, nl = {98}, s = {}, v = 2)
    static final class C05581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ double $rate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05581(double d, Continuation<? super C05581> continuation) {
            super(2, continuation);
            this.$rate = d;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionCommon.this.new C05581(this.$rate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SessionCommon.this.getTracker().onPlaybackRateUpdate(this.$rate, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void onPlaybackRateUpdate(double rate) {
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new C05581(rate, null), 3, null);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionCommon$onPlaybackEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Session.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionCommon$onPlaybackEvent$1", f = "Session.kt", i = {}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m = "invokeSuspend", n = {}, nl = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, s = {}, v = 2)
    static final class C05571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlaybackEvent $playbackEvent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05571(PlaybackEvent playbackEvent, Continuation<? super C05571> continuation) {
            super(2, continuation);
            this.$playbackEvent = playbackEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionCommon.this.new C05571(this.$playbackEvent, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SessionCommon.this.getTracker().onPlaybackEvent(this.$playbackEvent, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void onPlaybackEvent(PlaybackEvent playbackEvent) {
        Intrinsics.checkNotNullParameter(playbackEvent, "playbackEvent");
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new C05571(playbackEvent, null), 3, null);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionCommon$onAdClickthrough$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Session.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionCommon$onAdClickthrough$1", f = "Session.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, nl = {118}, s = {}, v = 2)
    static final class C05551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05551(Continuation<? super C05551> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionCommon.this.new C05551(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SessionCommon.this.getTracker().onAdClickthrough(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void onAdClickthrough() {
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new C05551(null), 3, null);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionCommon$onAdSkip$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Session.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionCommon$onAdSkip$1", f = "Session.kt", i = {}, l = {WebSocketProtocol.PAYLOAD_SHORT}, m = "invokeSuspend", n = {}, nl = {127}, s = {}, v = 2)
    static final class C05561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05561(Continuation<? super C05561> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionCommon.this.new C05561(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SessionCommon.this.getTracker().onAdSkip(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void onAdSkip() {
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new C05561(null), 3, null);
    }

    public final void addUiEventListener(SessionUiEvent event, Function2<? super SessionUiEvent, ? super SessionUiEventData, Unit> listener) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.tracker.addUiEventListener(event, listener);
    }

    public final void removeUiEventListener(SessionUiEvent event, Function2<? super SessionUiEvent, ? super SessionUiEventData, Unit> listener) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.tracker.removeUiEventListener(event, listener);
    }

    public final void addAdObserver(AdObserver adObserver) {
        Intrinsics.checkNotNullParameter(adObserver, "adObserver");
        this.tracker.addAdObserver(adObserver);
    }

    public final void removeAdObserver(AdObserver adObserver) {
        Intrinsics.checkNotNullParameter(adObserver, "adObserver");
        this.tracker.removeAdObserver(adObserver);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionCommon$getAllAds$1, reason: invalid class name */
    /* JADX INFO: compiled from: Session.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionCommon$getAllAds$1", f = "Session.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, nl = {170}, s = {}, v = 2)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<List<AdData>, Unit> $receiver;
        Object L$0;
        int label;
        final /* synthetic */ SessionCommon this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super List<AdData>, Unit> function1, SessionCommon sessionCommon, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$receiver = function1;
            this.this$0 = sessionCommon;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$receiver, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Function1 function1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<List<AdData>, Unit> function2 = this.$receiver;
                this.L$0 = function2;
                this.label = 1;
                Object allAds = this.this$0.getTracker().getAllAds(this);
                if (allAds == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = allAds;
                function1 = function2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function1 = (Function1) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            function1.invoke(obj);
            return Unit.INSTANCE;
        }
    }

    public final void getAllAds(Function1<? super List<AdData>, Unit> receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new AnonymousClass1(receiver, this, null), 3, null);
    }

    public static /* synthetic */ void getAllNonLinearAds$default(SessionCommon sessionCommon, Function1 function1, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllNonLinearAds");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        sessionCommon.getAllNonLinearAds(function1, z);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.SessionCommon$getAllNonLinearAds$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Session.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.SessionCommon$getAllNonLinearAds$1", f = "Session.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, nl = {185}, s = {}, v = 2)
    static final class C05541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $includeOffTimelineAds;
        final /* synthetic */ Function1<List<NonLinearAdsData>, Unit> $receiver;
        Object L$0;
        int label;
        final /* synthetic */ SessionCommon this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C05541(Function1<? super List<NonLinearAdsData>, Unit> function1, SessionCommon sessionCommon, boolean z, Continuation<? super C05541> continuation) {
            super(2, continuation);
            this.$receiver = function1;
            this.this$0 = sessionCommon;
            this.$includeOffTimelineAds = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05541(this.$receiver, this.this$0, this.$includeOffTimelineAds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Function1 function1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<List<NonLinearAdsData>, Unit> function2 = this.$receiver;
                this.L$0 = function2;
                this.label = 1;
                Object allNonLinearAds = this.this$0.getTracker().getAllNonLinearAds(this.$includeOffTimelineAds, this);
                if (allNonLinearAds == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = allNonLinearAds;
                function1 = function2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function1 = (Function1) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            function1.invoke(obj);
            return Unit.INSTANCE;
        }
    }

    public final void getAllNonLinearAds(Function1<? super List<NonLinearAdsData>, Unit> receiver, boolean includeOffTimelineAds) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new C05541(receiver, this, includeOffTimelineAds, null), 3, null);
    }
}
