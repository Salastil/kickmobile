package com.amazon.mediatailorsdk;

import com.amazon.mediatailorsdk.logs.LogLevel;
import com.amazon.mediatailorsdk.logs.Logger_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: MediaTailor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072>\u0010\b\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\tj\u0002`\u0010J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, d2 = {"Lcom/amazon/mediatailorsdk/MediaTailorCommon;", "", "<init>", "()V", "createSession", "", "config", "Lcom/amazon/mediatailorsdk/SessionConfiguration;", "callback", "Lkotlin/Function2;", "Lcom/amazon/mediatailorsdk/Session;", "Lkotlin/ParameterName;", "name", "session", "Lcom/amazon/mediatailorsdk/SessionError;", "error", "Lcom/amazon/mediatailorsdk/CreateSessionCallback;", "setLogLevel", "logLevel", "Lcom/amazon/mediatailorsdk/logs/LogLevel;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class MediaTailorCommon {
    protected MediaTailorCommon() {
    }

    public final void createSession(final SessionConfiguration config, final Function2<? super Session, ? super SessionError, Unit> callback) {
        String palNonceString;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PalNonceRequestParams palNonceRequestParams = config.getPalNonceRequestParams();
        final String str = "createSession: ";
        final Function2 function2 = new Function2() { // from class: com.amazon.mediatailorsdk.MediaTailorCommon$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MediaTailorCommon.createSession$lambda$0(str, callback, (Session) obj, (String) obj2);
            }
        };
        final Function2 function3 = new Function2() { // from class: com.amazon.mediatailorsdk.MediaTailorCommon$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MediaTailorCommon.createSession$lambda$1(str, callback, (Integer) obj, (String) obj2);
            }
        };
        String trackingUrl = config.getTrackingUrl();
        if ((trackingUrl != null && !StringsKt.isBlank(trackingUrl)) || (((palNonceString = config.getPalNonceString()) != null && !StringsKt.isBlank(palNonceString)) || palNonceRequestParams == null)) {
            BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new AnonymousClass1(config, function2, function3, null), 3, null);
        } else {
            PAL_androidKt.palRequestNonceManager(palNonceRequestParams, new Function3() { // from class: com.amazon.mediatailorsdk.MediaTailorCommon$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MediaTailorCommon.createSession$lambda$2(str, config, function2, function3, (String) obj, (PalNonceManagerWrapper) obj2, (String) obj3);
                }
            });
        }
    }

    static final Job createSession$lambda$0(String str, Function2 function2, Session session, String message) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(message, "message");
        Logger_androidKt.getLogger().d(str + message);
        return BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), Dispatchers.getMain(), null, new MediaTailorCommon$createSession$reportSuccess$1$1(function2, session, null), 2, null);
    }

    static final Job createSession$lambda$1(String str, Function2 function2, Integer num, String str2) {
        SessionError sessionError = new SessionError(num, str2);
        Logger_androidKt.getLogger().e(str + "(" + num + ") " + str2);
        return BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), Dispatchers.getMain(), null, new MediaTailorCommon$createSession$reportError$1$1(function2, sessionError, null), 2, null);
    }

    /* JADX INFO: renamed from: com.amazon.mediatailorsdk.MediaTailorCommon$createSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: MediaTailor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.amazon.mediatailorsdk.MediaTailorCommon$createSession$1", f = "MediaTailor.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, nl = {57}, s = {}, v = 2)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SessionConfiguration $config;
        final /* synthetic */ Function2<Integer, String, Job> $reportError;
        final /* synthetic */ Function2<Session, String, Job> $reportSuccess;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(SessionConfiguration sessionConfiguration, Function2<? super Session, ? super String, ? extends Job> function2, Function2<? super Integer, ? super String, ? extends Job> function3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$config = sessionConfiguration;
            this.$reportSuccess = function2;
            this.$reportError = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$config, this.$reportSuccess, this.$reportError, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SessionConfiguration sessionConfiguration = this.$config;
                this.label = 1;
                if (SessionKt.initSession(sessionConfiguration, sessionConfiguration.getPalNonceString(), null, this.$reportSuccess, this.$reportError, this) == coroutine_suspended) {
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

    static final Unit createSession$lambda$2(String str, SessionConfiguration sessionConfiguration, Function2 function2, Function2 function3, String str2, PalNonceManagerWrapper palNonceManagerWrapper, String str3) {
        if (palNonceManagerWrapper != null) {
            Logger_androidKt.getLogger().d(str + "NonceManager received");
        } else {
            Logger_androidKt.getLogger().w(str + "Nonce request rejected, " + str3);
        }
        BuildersKt__Builders_commonKt.launch$default(MediaTailorKt.getThreading().getCoroutineScope(), null, null, new MediaTailorCommon$createSession$2$1(sessionConfiguration, str2, palNonceManagerWrapper, function2, function3, null), 3, null);
        return Unit.INSTANCE;
    }

    public final void setLogLevel(LogLevel logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Logger_androidKt.getLogger().setLevel(logLevel);
    }
}
