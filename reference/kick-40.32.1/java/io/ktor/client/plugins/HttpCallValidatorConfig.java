package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpCallValidator.kt */
/* JADX INFO: loaded from: classes9.dex */
@KtorDsl
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\r\u001a\u00020\n25\u0010\f\u001a1\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u000b¢\u0006\u0004\b\r\u0010\u000eJ[\u0010\r\u001a\u00020\n2J\u0010\f\u001aF\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fj\u0002`\u0012H\u0007¢\u0006\u0004\b\r\u0010\u0013JY\u0010\u0014\u001a\u00020\n2J\u0010\f\u001aF\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fj\u0002`\u0012¢\u0006\u0004\b\u0014\u0010\u0013JD\u0010\u0018\u001a\u00020\n25\u0010\f\u001a1\b\u0001\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u0017¢\u0006\u0004\b\u0018\u0010\u000eRO\u0010\u001a\u001a7\u00123\u00121\b\u0001\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u00170\u00198\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00198\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\"\u0010\"\u001a\u00020!8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006("}, d2 = {"Lio/ktor/client/plugins/HttpCallValidatorConfig;", "", "<init>", "()V", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/client/plugins/CallExceptionHandler;", "block", "handleResponseException", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequest;", "request", "Lio/ktor/client/plugins/CallRequestExceptionHandler;", "(Lkotlin/jvm/functions/Function3;)V", "handleResponseExceptionWithRequest", "Lio/ktor/client/statement/HttpResponse;", "response", "Lio/ktor/client/plugins/ResponseValidator;", "validateResponse", "", "responseValidators", "Ljava/util/List;", "getResponseValidators$ktor_client_core", "()Ljava/util/List;", "Lio/ktor/client/plugins/HandlerWrapper;", "responseExceptionHandlers", "getResponseExceptionHandlers$ktor_client_core", "", "expectSuccess", "Z", "getExpectSuccess$ktor_client_core", "()Z", "setExpectSuccess$ktor_client_core", "(Z)V", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HttpCallValidatorConfig {
    private final List<Function2<HttpResponse, Continuation<? super Unit>, Object>> responseValidators = new ArrayList();
    private final List<HandlerWrapper> responseExceptionHandlers = new ArrayList();
    private boolean expectSuccess = true;

    public final List<Function2<HttpResponse, Continuation<? super Unit>, Object>> getResponseValidators$ktor_client_core() {
        return this.responseValidators;
    }

    public final List<HandlerWrapper> getResponseExceptionHandlers$ktor_client_core() {
        return this.responseExceptionHandlers;
    }

    /* JADX INFO: renamed from: getExpectSuccess$ktor_client_core, reason: from getter */
    public final boolean getExpectSuccess() {
        return this.expectSuccess;
    }

    public final void setExpectSuccess$ktor_client_core(boolean z) {
        this.expectSuccess = z;
    }

    public final void handleResponseException(Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.responseExceptionHandlers.add(new ExceptionHandlerWrapper(block));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use handleResponseExceptionWithRequest or handleResponseException(CallExceptionHandler) instead", replaceWith = @ReplaceWith(expression = "handleResponseExceptionWithRequest(block)", imports = {}))
    public final void handleResponseException(Function3<? super Throwable, ? super HttpRequest, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.responseExceptionHandlers.add(new RequestExceptionHandlerWrapper(block));
    }

    public final void handleResponseExceptionWithRequest(Function3<? super Throwable, ? super HttpRequest, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.responseExceptionHandlers.add(new RequestExceptionHandlerWrapper(block));
    }

    public final void validateResponse(Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.responseValidators.add(block);
    }
}
