package com.amazon.mediatailorsdk;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Session.android.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B9\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/amazon/mediatailorsdk/Session;", "Lcom/amazon/mediatailorsdk/SessionCommon;", "playbackUrl", "", "trackingUrl", "palNonce", "palNonceManager", "Lcom/amazon/mediatailorsdk/PalNonceManagerWrapper;", "tracker", "Lcom/amazon/mediatailorsdk/SessionTracker;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mediatailorsdk/PalNonceManagerWrapper;Lcom/amazon/mediatailorsdk/SessionTracker;)V", "onVideoClick", "", "event", "Landroid/view/MotionEvent;", "onPlayerControlClick", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Session extends SessionCommon {
    private final PalNonceManagerWrapper palNonceManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Session(String str, String str2, String str3, PalNonceManagerWrapper palNonceManagerWrapper, SessionTracker tracker) {
        super(str, str2, str3, tracker);
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.palNonceManager = palNonceManagerWrapper;
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.Session$onVideoClick$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Session.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.Session$onVideoClick$1", f = "Session.android.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, nl = {28}, s = {}, v = 2)
    static final class C05531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MotionEvent $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05531(MotionEvent motionEvent, Continuation<? super C05531> continuation) {
            super(2, continuation);
            this.$event = motionEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Session.this.new C05531(this.$event, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (Session.this.getTracker().getCurrentAd() != null) {
                    PalNonceManagerWrapper palNonceManagerWrapper = Session.this.palNonceManager;
                    AndroidPalNonceManagerWrapper androidPalNonceManagerWrapper = palNonceManagerWrapper instanceof AndroidPalNonceManagerWrapper ? (AndroidPalNonceManagerWrapper) palNonceManagerWrapper : null;
                    if (androidPalNonceManagerWrapper != null) {
                        androidPalNonceManagerWrapper.sendAdTouch(this.$event);
                    }
                }
                this.label = 1;
                if (Session.this.getTracker().onVideoClick(this) == coroutine_suspended) {
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

    public final void onVideoClick(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new C05531(event, null), 3, null);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.Session$onPlayerControlClick$1, reason: invalid class name */
    /* JADX INFO: compiled from: Session.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.Session$onPlayerControlClick$1", f = "Session.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MotionEvent $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MotionEvent motionEvent, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$event = motionEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Session.this.new AnonymousClass1(this.$event, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (Session.this.getTracker().getCurrentAd() != null) {
                PalNonceManagerWrapper palNonceManagerWrapper = Session.this.palNonceManager;
                AndroidPalNonceManagerWrapper androidPalNonceManagerWrapper = palNonceManagerWrapper instanceof AndroidPalNonceManagerWrapper ? (AndroidPalNonceManagerWrapper) palNonceManagerWrapper : null;
                if (androidPalNonceManagerWrapper != null) {
                    androidPalNonceManagerWrapper.sendAdTouch(this.$event);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void onPlayerControlClick(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new AnonymousClass1(event, null), 3, null);
    }
}
