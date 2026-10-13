package io.ktor.client.plugins.logging;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: compiled from: HttpClientCallLogger.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0018\u0010\u0016\u001a\u00060\u0014j\u0002`\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00060\u0014j\u0002`\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001b¨\u0006\u001d"}, d2 = {"Lio/ktor/client/plugins/logging/HttpClientCallLogger;", "", "Lio/ktor/client/plugins/logging/Logger;", "logger", "<init>", "(Lio/ktor/client/plugins/logging/Logger;)V", "", "message", "", "logRequest", "(Ljava/lang/String;)V", "logResponseHeader", "logResponseException", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logResponseBody", "closeRequestLog", "()V", "closeResponseLog", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/plugins/logging/Logger;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "requestLog", "Ljava/lang/StringBuilder;", "responseLog", "Lkotlinx/coroutines/CompletableJob;", "requestLoggedMonitor", "Lkotlinx/coroutines/CompletableJob;", "responseHeaderMonitor", "ktor-client-logging"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HttpClientCallLogger {
    private static final /* synthetic */ AtomicIntegerFieldUpdater requestLogged$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientCallLogger.class, "requestLogged");
    private static final /* synthetic */ AtomicIntegerFieldUpdater responseLogged$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientCallLogger.class, "responseLogged");
    private final Logger logger;
    private final StringBuilder requestLog;
    private volatile /* synthetic */ int requestLogged;
    private final CompletableJob requestLoggedMonitor;
    private final CompletableJob responseHeaderMonitor;
    private final StringBuilder responseLog;
    private volatile /* synthetic */ int responseLogged;

    /* JADX INFO: renamed from: io.ktor.client.plugins.logging.HttpClientCallLogger$closeResponseLog$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpClientCallLogger.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.logging.HttpClientCallLogger", f = "HttpClientCallLogger.kt", i = {}, l = {54}, m = "closeResponseLog", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpClientCallLogger.this.closeResponseLog(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseBody$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpClientCallLogger.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.logging.HttpClientCallLogger", f = "HttpClientCallLogger.kt", i = {0}, l = {34}, m = "logResponseBody", n = {"message"}, s = {"L$0"}, v = 1)
    static final class C09751 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09751(Continuation<? super C09751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpClientCallLogger.this.logResponseBody(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseException$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpClientCallLogger.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.logging.HttpClientCallLogger", f = "HttpClientCallLogger.kt", i = {0}, l = {29}, m = "logResponseException", n = {"message"}, s = {"L$0"}, v = 1)
    static final class C09761 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09761(Continuation<? super C09761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpClientCallLogger.this.logResponseException(null, this);
        }
    }

    public HttpClientCallLogger(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.requestLog = new StringBuilder();
        this.responseLog = new StringBuilder();
        this.requestLoggedMonitor = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.responseHeaderMonitor = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.requestLogged = 0;
        this.responseLogged = 0;
    }

    public final void logRequest(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        StringBuilder sb = this.requestLog;
        sb.append(StringsKt.trim((CharSequence) message).toString());
        sb.append('\n');
    }

    public final void logResponseHeader(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        StringBuilder sb = this.responseLog;
        sb.append(StringsKt.trim((CharSequence) message).toString());
        sb.append('\n');
        this.responseHeaderMonitor.complete();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object logResponseException(String str, Continuation<? super Unit> continuation) {
        C09761 c09761;
        if (continuation instanceof C09761) {
            c09761 = (C09761) continuation;
            if ((c09761.label & Integer.MIN_VALUE) != 0) {
                c09761.label -= Integer.MIN_VALUE;
            } else {
                c09761 = new C09761(continuation);
            }
        } else {
            c09761 = new C09761(continuation);
        }
        Object obj = c09761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09761.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CompletableJob completableJob = this.requestLoggedMonitor;
            c09761.L$0 = str;
            c09761.label = 1;
            if (completableJob.join(c09761) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c09761.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.logger.log(StringsKt.trim((CharSequence) str).toString());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object logResponseBody(String str, Continuation<? super Unit> continuation) {
        C09751 c09751;
        if (continuation instanceof C09751) {
            c09751 = (C09751) continuation;
            if ((c09751.label & Integer.MIN_VALUE) != 0) {
                c09751.label -= Integer.MIN_VALUE;
            } else {
                c09751 = new C09751(continuation);
            }
        } else {
            c09751 = new C09751(continuation);
        }
        Object obj = c09751.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09751.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CompletableJob completableJob = this.responseHeaderMonitor;
            c09751.L$0 = str;
            c09751.label = 1;
            if (completableJob.join(c09751) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c09751.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.responseLog.append(str);
        return Unit.INSTANCE;
    }

    public final void closeRequestLog() {
        if (requestLogged$FU.compareAndSet(this, 0, 1)) {
            try {
                String string = StringsKt.trim(this.requestLog).toString();
                if (string.length() > 0) {
                    this.logger.log(string);
                }
            } finally {
                this.requestLoggedMonitor.complete();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object closeResponseLog(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!responseLogged$FU.compareAndSet(this, 0, 1)) {
                return Unit.INSTANCE;
            }
            CompletableJob completableJob = this.requestLoggedMonitor;
            anonymousClass1.label = 1;
            if (completableJob.join(anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String string = StringsKt.trim(this.responseLog).toString();
        if (string.length() > 0) {
            this.logger.log(string);
        }
        return Unit.INSTANCE;
    }
}
