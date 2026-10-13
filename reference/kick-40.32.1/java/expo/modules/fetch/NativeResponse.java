package expo.modules.fetch;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import expo.modules.core.logging.LoggerUtilsKt;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.sharedobjects.SharedObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;

/* JADX INFO: compiled from: NativeResponse.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010+\u001a\u00020,H\u0016J\u0006\u0010-\u001a\u00020,J\b\u0010.\u001a\u0004\u0018\u00010/J\u0006\u00100\u001a\u00020,J\u0006\u00101\u001a\u00020,J(\u00102\u001a\u00020,2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000e042\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020,0\u0016J\u0018\u00106\u001a\u00020,2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010;\u001a\u00020,2\u0006\u00107\u001a\u0002082\u0006\u0010<\u001a\u00020=H\u0016J!\u0010>\u001a\u00020\u00172\u0012\u0010?\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0@\"\u00020\u000eH\u0002¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020\u00192\u0006\u0010<\u001a\u00020=H\u0002J\u0016\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020EH\u0082@¢\u0006\u0002\u0010FR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8B@BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u00180\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\r\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR.\u0010\u001f\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e2\u000e\u0010\r\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006H"}, d2 = {"Lexpo/modules/fetch/NativeResponse;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "Lokhttp3/Callback;", "appContext", "Lexpo/modules/kotlin/AppContext;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lexpo/modules/kotlin/AppContext;Lkotlinx/coroutines/CoroutineScope;)V", "sink", "Lexpo/modules/fetch/ResponseSink;", "getSink", "()Lexpo/modules/fetch/ResponseSink;", "value", "Lexpo/modules/fetch/ResponseState;", "state", "getState", "()Lexpo/modules/fetch/ResponseState;", "setState", "(Lexpo/modules/fetch/ResponseState;)V", "stateChangeOnceListeners", "", "Lkotlin/Function1;", "", "Lexpo/modules/fetch/StateChangeListener;", "Lexpo/modules/fetch/NativeResponseInit;", "responseInit", "getResponseInit", "()Lexpo/modules/fetch/NativeResponseInit;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "getError", "()Ljava/lang/Exception;", "redirectMode", "Lexpo/modules/fetch/NativeRequestRedirect;", "getRedirectMode", "()Lexpo/modules/fetch/NativeRequestRedirect;", "setRedirectMode", "(Lexpo/modules/fetch/NativeRequestRedirect;)V", "bodyUsed", "getBodyUsed", "()Z", "deallocate", "", "onStarted", "startStreaming", "", "cancelStreaming", "emitRequestCanceled", "waitForStates", "states", "", "callback", "onFailure", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "isInvalidState", "validStates", "", "([Lexpo/modules/fetch/ResponseState;)Z", "createResponseInit", "pumpResponseBodyStream", "stream", "Lokio/BufferedSource;", "(Lokio/BufferedSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "expo_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NativeResponse extends SharedObject implements Callback {
    private static final String TAG = "NativeResponse";
    private final CoroutineScope coroutineScope;
    private Exception error;
    private NativeRequestRedirect redirectMode;
    private NativeResponseInit responseInit;
    private final ResponseSink sink;
    private ResponseState state;
    private final List<Function1<ResponseState, Boolean>> stateChangeOnceListeners;

    /* JADX INFO: renamed from: expo.modules.fetch.NativeResponse$pumpResponseBodyStream$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NativeResponse.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.fetch.NativeResponse", f = "NativeResponse.kt", i = {0}, l = {197}, m = "pumpResponseBodyStream", n = {"stream"}, nl = {203}, s = {"L$0"}, v = 2)
    static final class C08161 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08161(Continuation<? super C08161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NativeResponse.this.pumpResponseBodyStream(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeResponse(AppContext appContext, CoroutineScope coroutineScope) {
        super(appContext);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
        this.sink = new ResponseSink();
        this.state = ResponseState.INITIALIZED;
        this.stateChangeOnceListeners = new ArrayList();
    }

    public final ResponseSink getSink() {
        return this.sink;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResponseState getState() {
        ResponseState responseState;
        synchronized (this) {
            responseState = this.state;
        }
        return responseState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setState(ResponseState responseState) {
        synchronized (this) {
            this.state = responseState;
            Unit unit = Unit.INSTANCE;
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new NativeResponse$state$3(this, responseState, null), 3, null);
    }

    public final NativeResponseInit getResponseInit() {
        return this.responseInit;
    }

    public final Exception getError() {
        return this.error;
    }

    public final NativeRequestRedirect getRedirectMode() {
        return this.redirectMode;
    }

    public final void setRedirectMode(NativeRequestRedirect nativeRequestRedirect) {
        this.redirectMode = nativeRequestRedirect;
    }

    public final boolean getBodyUsed() {
        return this.sink.getBodyUsed();
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public void deallocate() {
        this.sink.finalize(false);
        super.deallocate();
    }

    public final void onStarted() {
        if (isInvalidState(ResponseState.INITIALIZED)) {
            return;
        }
        setState(ResponseState.STARTED);
    }

    public final byte[] startStreaming() {
        if (isInvalidState(ResponseState.RESPONSE_RECEIVED, ResponseState.BODY_COMPLETED)) {
            return null;
        }
        if (getState() == ResponseState.RESPONSE_RECEIVED) {
            setState(ResponseState.BODY_STREAMING_STARTED);
            emit("didReceiveResponseData", this.sink.finalize(false).array());
        } else if (getState() == ResponseState.BODY_COMPLETED) {
            return this.sink.finalize(false).array();
        }
        return null;
    }

    public final void cancelStreaming() {
        if (isInvalidState(ResponseState.BODY_STREAMING_STARTED)) {
            return;
        }
        setState(ResponseState.BODY_STREAMING_CANCELED);
    }

    public final void emitRequestCanceled() {
        FetchRequestCanceledException fetchRequestCanceledException = new FetchRequestCanceledException();
        this.error = fetchRequestCanceledException;
        if (getState() == ResponseState.BODY_STREAMING_STARTED) {
            emit("didFailWithError", LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(fetchRequestCanceledException));
        }
        setState(ResponseState.ERROR_RECEIVED);
    }

    public final void waitForStates(final List<? extends ResponseState> states, final Function1<? super ResponseState, Unit> callback) {
        Intrinsics.checkNotNullParameter(states, "states");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (states.contains(getState())) {
            callback.invoke(getState());
        } else {
            this.stateChangeOnceListeners.add(new Function1() { // from class: expo.modules.fetch.NativeResponse$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(NativeResponse.waitForStates$lambda$0(states, callback, (ResponseState) obj));
                }
            });
        }
    }

    static final boolean waitForStates$lambda$0(List list, Function1 function1, ResponseState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        if (!list.contains(newState)) {
            return false;
        }
        function1.invoke(newState);
        return true;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        if (Intrinsics.areEqual(e.getMessage(), "Canceled") || isInvalidState(ResponseState.STARTED, ResponseState.RESPONSE_RECEIVED, ResponseState.BODY_STREAMING_STARTED, ResponseState.BODY_STREAMING_CANCELED)) {
            return;
        }
        if (getState() == ResponseState.BODY_STREAMING_STARTED) {
            emit("didFailWithError", LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(e));
        }
        this.error = e;
        setState(ResponseState.ERROR_RECEIVED);
        emit("readyForJSFinalization");
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.isRedirect() && this.redirectMode == NativeRequestRedirect.ERROR) {
            response.close();
            FetchRedirectException fetchRedirectException = new FetchRedirectException();
            this.error = fetchRedirectException;
            if (getState() == ResponseState.BODY_STREAMING_STARTED) {
                emit("didFailWithError", LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(fetchRedirectException));
            }
            setState(ResponseState.ERROR_RECEIVED);
            emit("readyForJSFinalization");
            return;
        }
        this.responseInit = createResponseInit(response);
        setState(ResponseState.RESPONSE_RECEIVED);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(response, this, null), 3, null);
    }

    /* JADX INFO: renamed from: expo.modules.fetch.NativeResponse$onResponse$1, reason: invalid class name */
    /* JADX INFO: compiled from: NativeResponse.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.fetch.NativeResponse$onResponse$1", f = "NativeResponse.kt", i = {0, 1, 2}, l = {146, 150, 150}, m = "invokeSuspend", n = {"stream", "stream", "stream"}, nl = {150, 153, WebmConstants.MkvEbmlElement.BLOCK_DURATION}, s = {"L$0", "L$0", "L$0"}, v = 2)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Response $response;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ NativeResponse this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Response response, NativeResponse nativeResponse, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$response = response;
            this.this$0 = nativeResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$response, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0084, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r9, r3, r2) == r0) goto L34;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v5, types: [kotlin.jvm.functions.Function2] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 215
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.fetch.NativeResponse.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: expo.modules.fetch.NativeResponse$onResponse$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: NativeResponse.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "expo.modules.fetch.NativeResponse$onResponse$1$1", f = "NativeResponse.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class C01561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Response $response;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01561(Response response, Continuation<? super C01561> continuation) {
                super(2, continuation);
                this.$response = response;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01561(this.$response, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$response.close();
                return Unit.INSTANCE;
            }
        }
    }

    private final boolean isInvalidState(ResponseState... validStates) {
        if (ArraysKt.contains(validStates, getState())) {
            return false;
        }
        String strJoinToString$default = ArraysKt.joinToString$default(validStates, WebViewLogEventConsumer.DDTAGS_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: expo.modules.fetch.NativeResponse$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NativeResponse.isInvalidState$lambda$0((ResponseState) obj);
            }
        }, 30, (Object) null);
        Log.w(TAG, "Invalid state - currentState[" + getState().getIntValue() + "] validStates[" + strJoinToString$default + "]");
        return true;
    }

    static final CharSequence isInvalidState$lambda$0(ResponseState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return String.valueOf(it.getIntValue());
    }

    private final NativeResponseInit createResponseInit(Response response) {
        int iCode = response.code();
        String strMessage = response.message();
        Headers headers = response.headers();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(headers, 10));
        for (Pair<? extends String, ? extends String> pair : headers) {
            arrayList.add(TuplesKt.to(pair.getFirst(), pair.getSecond()));
        }
        return new NativeResponseInit(arrayList, iCode, strMessage, response.request().url().getUrl(), response.isRedirect());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x0053 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0058 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:25:0x0059 A[Catch: IOException -> 0x002e, TryCatch #0 {IOException -> 0x002e, blocks: (B:12:0x002a, B:22:0x0054, B:25:0x0059, B:28:0x0071, B:30:0x0079, B:19:0x003b, B:31:0x007f, B:33:0x0087), top: B:41:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0079 A[Catch: IOException -> 0x002e, TryCatch #0 {IOException -> 0x002e, blocks: (B:12:0x002a, B:22:0x0054, B:25:0x0059, B:28:0x0071, B:30:0x0079, B:19:0x003b, B:31:0x007f, B:33:0x0087), top: B:41:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:31:0x007f A[Catch: IOException -> 0x002e, TryCatch #0 {IOException -> 0x002e, blocks: (B:12:0x002a, B:22:0x0054, B:25:0x0059, B:28:0x0071, B:30:0x0079, B:19:0x003b, B:31:0x007f, B:33:0x0087), top: B:41:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0087 A[Catch: IOException -> 0x002e, TRY_LEAVE, TryCatch #0 {IOException -> 0x002e, blocks: (B:12:0x002a, B:22:0x0054, B:25:0x0059, B:28:0x0071, B:30:0x0079, B:19:0x003b, B:31:0x007f, B:33:0x0087), top: B:41:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0051 -> B:22:0x0054). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object pumpResponseBodyStream(okio.BufferedSource r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof expo.modules.fetch.NativeResponse.C08161
            if (r0 == 0) goto L14
            r0 = r8
            expo.modules.fetch.NativeResponse$pumpResponseBodyStream$1 r0 = (expo.modules.fetch.NativeResponse.C08161) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            expo.modules.fetch.NativeResponse$pumpResponseBodyStream$1 r0 = new expo.modules.fetch.NativeResponse$pumpResponseBodyStream$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r7 = r0.L$0
            okio.BufferedSource r7 = (okio.BufferedSource) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.io.IOException -> L2e
            goto L54
        L2e:
            r7 = move-exception
            goto L8d
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.ResultKt.throwOnFailure(r8)
        L3b:
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.io.IOException -> L2e
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8     // Catch: java.io.IOException -> L2e
            expo.modules.fetch.NativeResponse$pumpResponseBodyStream$data$1 r2 = new expo.modules.fetch.NativeResponse$pumpResponseBodyStream$data$1     // Catch: java.io.IOException -> L2e
            r4 = 0
            r2.<init>(r7, r4)     // Catch: java.io.IOException -> L2e
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch: java.io.IOException -> L2e
            r0.L$0 = r7     // Catch: java.io.IOException -> L2e
            r0.label = r3     // Catch: java.io.IOException -> L2e
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)     // Catch: java.io.IOException -> L2e
            if (r8 != r1) goto L54
            return r1
        L54:
            byte[] r8 = (byte[]) r8     // Catch: java.io.IOException -> L2e
            if (r8 != 0) goto L59
            goto Laa
        L59:
            r2 = 3
            expo.modules.fetch.ResponseState[] r2 = new expo.modules.fetch.ResponseState[r2]     // Catch: java.io.IOException -> L2e
            expo.modules.fetch.ResponseState r4 = expo.modules.fetch.ResponseState.RESPONSE_RECEIVED     // Catch: java.io.IOException -> L2e
            r5 = 0
            r2[r5] = r4     // Catch: java.io.IOException -> L2e
            expo.modules.fetch.ResponseState r4 = expo.modules.fetch.ResponseState.BODY_STREAMING_STARTED     // Catch: java.io.IOException -> L2e
            r2[r3] = r4     // Catch: java.io.IOException -> L2e
            expo.modules.fetch.ResponseState r4 = expo.modules.fetch.ResponseState.BODY_STREAMING_CANCELED     // Catch: java.io.IOException -> L2e
            r5 = 2
            r2[r5] = r4     // Catch: java.io.IOException -> L2e
            boolean r2 = r6.isInvalidState(r2)     // Catch: java.io.IOException -> L2e
            if (r2 == 0) goto L71
            goto Laa
        L71:
            expo.modules.fetch.ResponseState r2 = r6.getState()     // Catch: java.io.IOException -> L2e
            expo.modules.fetch.ResponseState r4 = expo.modules.fetch.ResponseState.RESPONSE_RECEIVED     // Catch: java.io.IOException -> L2e
            if (r2 != r4) goto L7f
            expo.modules.fetch.ResponseSink r2 = r6.sink     // Catch: java.io.IOException -> L2e
            r2.appendBufferBody$expo_release(r8)     // Catch: java.io.IOException -> L2e
            goto L3b
        L7f:
            expo.modules.fetch.ResponseState r2 = r6.getState()     // Catch: java.io.IOException -> L2e
            expo.modules.fetch.ResponseState r4 = expo.modules.fetch.ResponseState.BODY_STREAMING_STARTED     // Catch: java.io.IOException -> L2e
            if (r2 != r4) goto Laa
            java.lang.String r2 = "didReceiveResponseData"
            r6.emit(r2, r8)     // Catch: java.io.IOException -> L2e
            goto L3b
        L8d:
            r8 = r7
            java.lang.Exception r8 = (java.lang.Exception) r8
            r6.error = r8
            expo.modules.fetch.ResponseState r8 = r6.getState()
            expo.modules.fetch.ResponseState r0 = expo.modules.fetch.ResponseState.BODY_STREAMING_STARTED
            if (r8 != r0) goto La5
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.String r7 = expo.modules.core.logging.LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(r7)
            java.lang.String r8 = "didFailWithError"
            r6.emit(r8, r7)
        La5:
            expo.modules.fetch.ResponseState r7 = expo.modules.fetch.ResponseState.ERROR_RECEIVED
            r6.setState(r7)
        Laa:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.fetch.NativeResponse.pumpResponseBodyStream(okio.BufferedSource, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
