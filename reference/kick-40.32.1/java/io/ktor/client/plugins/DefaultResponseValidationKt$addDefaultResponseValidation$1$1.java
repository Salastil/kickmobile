package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.utils.io.charsets.MalformedInputException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: DefaultResponseValidation.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "response", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1", f = "DefaultResponseValidation.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {42, 48}, m = "invokeSuspend", n = {"response", "originCall", "expectSuccess", "statusCode", "response", "originCall", "exceptionCall", "exceptionResponse", "expectSuccess", "statusCode"}, s = {"L$0", "L$1", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0"}, v = 1)
final class DefaultResponseValidationKt$addDefaultResponseValidation$1$1 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;

    DefaultResponseValidationKt$addDefaultResponseValidation$1$1(Continuation<? super DefaultResponseValidationKt$addDefaultResponseValidation$1$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultResponseValidationKt$addDefaultResponseValidation$1$1 defaultResponseValidationKt$addDefaultResponseValidation$1$1 = new DefaultResponseValidationKt$addDefaultResponseValidation$1$1(continuation);
        defaultResponseValidationKt$addDefaultResponseValidation$1$1.L$0 = obj;
        return defaultResponseValidationKt$addDefaultResponseValidation$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        return ((DefaultResponseValidationKt$addDefaultResponseValidation$1$1) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0100  */
    /* JADX WARN: Code duplicated, block: B:41:0x0104 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:44:0x010f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x0111  */
    /* JADX WARN: Code duplicated, block: B:48:0x011d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean zBooleanValue;
        HttpClientCall call;
        int i;
        HttpClientCall httpClientCall;
        HttpResponse response;
        int i2;
        HttpResponse httpResponse;
        String str;
        ServerResponseException responseException;
        HttpResponse httpResponse2 = (HttpResponse) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                zBooleanValue = ((Boolean) httpResponse2.getCall().getAttributes().get(HttpCallValidatorKt.getExpectSuccessAttributeKey())).booleanValue();
                if (!zBooleanValue) {
                    DefaultResponseValidationKt.LOGGER.trace("Skipping default response validation for " + httpResponse2.getCall().getRequest().getUrl());
                    return Unit.INSTANCE;
                }
                int value = httpResponse2.getStatus().getValue();
                call = httpResponse2.getCall();
                if (value < 300 || call.getAttributes().contains(DefaultResponseValidationKt.ValidateMark)) {
                    return Unit.INSTANCE;
                }
                this.L$0 = httpResponse2;
                this.L$1 = SpillingKt.nullOutSpilledVariable(call);
                this.Z$0 = zBooleanValue;
                this.I$0 = value;
                this.label = 1;
                Object objSave = SavedCallKt.save(call, this);
                if (objSave != coroutine_suspended) {
                    i = value;
                    obj = objSave;
                }
                return coroutine_suspended;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = this.I$0;
                httpResponse = (HttpResponse) this.L$3;
                try {
                    ResultKt.throwOnFailure(obj);
                    str = (String) obj;
                } catch (MalformedInputException unused) {
                    str = "<body failed decoding>";
                }
                if (300 > i2 && i2 < 400) {
                    responseException = new RedirectResponseException(httpResponse, str);
                } else if (400 > i2 && i2 < 500) {
                    responseException = new ClientRequestException(httpResponse, str);
                } else if (500 > i2 && i2 < 600) {
                    responseException = new ServerResponseException(httpResponse, str);
                } else {
                    responseException = new ResponseException(httpResponse, str);
                }
                DefaultResponseValidationKt.LOGGER.trace("Default response validation for " + httpResponse2.getCall().getRequest().getUrl() + " failed with " + responseException);
                throw responseException;
            }
            i = this.I$0;
            zBooleanValue = this.Z$0;
            call = (HttpClientCall) this.L$1;
            ResultKt.throwOnFailure(obj);
            this.L$0 = httpResponse2;
            this.L$1 = SpillingKt.nullOutSpilledVariable(call);
            this.L$2 = SpillingKt.nullOutSpilledVariable(httpClientCall);
            this.L$3 = response;
            this.Z$0 = zBooleanValue;
            this.I$0 = i;
            this.label = 2;
            obj = HttpResponseKt.bodyAsText$default(response, null, this, 1, null);
            if (obj != coroutine_suspended) {
                i2 = i;
                httpResponse = response;
                str = (String) obj;
                if (300 > i2) {
                    if (400 > i2) {
                        if (500 > i2) {
                            responseException = new ResponseException(httpResponse, str);
                        } else {
                            responseException = new ResponseException(httpResponse, str);
                        }
                    } else if (500 > i2) {
                        responseException = new ResponseException(httpResponse, str);
                    } else {
                        responseException = new ResponseException(httpResponse, str);
                    }
                } else if (400 > i2) {
                    if (500 > i2) {
                        responseException = new ResponseException(httpResponse, str);
                    } else {
                        responseException = new ResponseException(httpResponse, str);
                    }
                } else if (500 > i2) {
                    responseException = new ResponseException(httpResponse, str);
                } else {
                    responseException = new ResponseException(httpResponse, str);
                }
                DefaultResponseValidationKt.LOGGER.trace("Default response validation for " + httpResponse2.getCall().getRequest().getUrl() + " failed with " + responseException);
                throw responseException;
            }
            return coroutine_suspended;
        } catch (MalformedInputException unused2) {
            i2 = i;
            httpResponse = response;
            str = "<body failed decoding>";
        }
        httpClientCall = (HttpClientCall) obj;
        httpClientCall.getAttributes().put(DefaultResponseValidationKt.ValidateMark, Unit.INSTANCE);
        response = httpClientCall.getResponse();
    }
}
