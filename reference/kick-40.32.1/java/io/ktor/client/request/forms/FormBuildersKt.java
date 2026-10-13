package io.ktor.client.request.forms;

import com.google.android.gms.common.internal.ImagesContract;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.Parameters;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.PartData;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: formBuilders.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\u000b\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086H¢\u0006\u0004\b\u000b\u0010\f\u001aK\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086@¢\u0006\u0004\b\u000b\u0010\u000f\u001a=\u0010\u0013\u001a\u00020\n*\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086H¢\u0006\u0004\b\u0013\u0010\u0014\u001aE\u0010\u0013\u001a\u00020\n*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086H¢\u0006\u0004\b\u0013\u0010\u0015\u001aC\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086H¢\u0006\u0004\b\u0017\u0010\f\u001aK\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086@¢\u0006\u0004\b\u0017\u0010\u000f\u001a=\u0010\u0018\u001a\u00020\u0016*\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0019\b\u0006\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086H¢\u0006\u0004\b\u0018\u0010\u0014\u001aE\u0010\u0018\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0019\b\u0006\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086H¢\u0006\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, d2 = {"Lio/ktor/client/HttpClient;", "Lio/ktor/http/Parameters;", "formParameters", "", "encodeInQuery", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lio/ktor/client/statement/HttpResponse;", "submitForm", "(Lio/ktor/client/HttpClient;Lio/ktor/http/Parameters;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", ImagesContract.URL, "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lio/ktor/http/Parameters;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lio/ktor/http/content/PartData;", "formData", "submitFormWithBinaryData", "(Lio/ktor/client/HttpClient;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpStatement;", "prepareForm", "prepareFormWithBinaryData", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FormBuildersKt {
    public static /* synthetic */ Object submitForm$default(HttpClient httpClient, Parameters parameters, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            parameters = Parameters.INSTANCE.getEmpty();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.forms.FormBuildersKt.submitForm.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            FormDataContent formDataContent = new FormDataContent(parameters);
            KType kTypeTypeOf = null;
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable unused) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
            }
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static /* synthetic */ Object submitForm$default(HttpClient httpClient, String str, Parameters parameters, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            parameters = Parameters.INSTANCE.getEmpty();
        }
        Parameters parameters2 = parameters;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.forms.FormBuildersKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return FormBuildersKt.submitForm$lambda$1((HttpRequestBuilder) obj2);
                }
            };
        }
        return submitForm(httpClient, str, parameters2, z2, function1, continuation);
    }

    static final Unit submitForm$lambda$1(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object submitFormWithBinaryData$default(HttpClient httpClient, List list, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.forms.FormBuildersKt.submitFormWithBinaryData.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kTypeTypeOf = null;
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kTypeTypeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable unused) {
            }
            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static /* synthetic */ Object submitFormWithBinaryData$default(HttpClient httpClient, String str, List list, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.forms.FormBuildersKt.submitFormWithBinaryData.5
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kTypeTypeOf = null;
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kTypeTypeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable unused) {
            }
            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static /* synthetic */ Object prepareForm$default(HttpClient httpClient, Parameters parameters, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            parameters = Parameters.INSTANCE.getEmpty();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.forms.FormBuildersKt.prepareForm.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            FormDataContent formDataContent = new FormDataContent(parameters);
            KType kTypeTypeOf = null;
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable unused) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
            }
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareForm$default(HttpClient httpClient, String str, Parameters parameters, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            parameters = Parameters.INSTANCE.getEmpty();
        }
        Parameters parameters2 = parameters;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.forms.FormBuildersKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return FormBuildersKt.prepareForm$lambda$1((HttpRequestBuilder) obj2);
                }
            };
        }
        return prepareForm(httpClient, str, parameters2, z2, function1, continuation);
    }

    static final Unit prepareForm$lambda$1(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object prepareFormWithBinaryData$default(HttpClient httpClient, List list, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.forms.FormBuildersKt.prepareFormWithBinaryData.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kTypeTypeOf = null;
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kTypeTypeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable unused) {
            }
            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareFormWithBinaryData$default(HttpClient httpClient, String str, List list, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.forms.FormBuildersKt.prepareFormWithBinaryData.5
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kTypeTypeOf = null;
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kTypeTypeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable unused) {
            }
            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object submitForm(HttpClient httpClient, Parameters parameters, boolean z, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            FormDataContent formDataContent = new FormDataContent(parameters);
            KType kTypeTypeOf = null;
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable unused) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
            }
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object submitForm$$forInline(HttpClient httpClient, Parameters parameters, boolean z, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            FormDataContent formDataContent = new FormDataContent(parameters);
            KType kTypeTypeOf = null;
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable unused) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
            }
        }
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Object submitForm(HttpClient httpClient, String str, Parameters parameters, boolean z, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            FormDataContent formDataContent = new FormDataContent(parameters);
            KType kTypeTypeOf = null;
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable unused) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
            }
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Object submitFormWithBinaryData(HttpClient httpClient, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kTypeTypeOf = null;
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kTypeTypeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable unused) {
            }
            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object submitFormWithBinaryData$$forInline(HttpClient httpClient, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kTypeTypeOf = null;
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kTypeTypeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable unused) {
            }
            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        }
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Object submitFormWithBinaryData(HttpClient httpClient, String str, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kTypeTypeOf = null;
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kTypeTypeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable unused) {
            }
            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object submitFormWithBinaryData$$forInline(HttpClient httpClient, String str, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kTypeTypeOf = null;
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kTypeTypeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable unused) {
            }
            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        Unit unit2 = Unit.INSTANCE;
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Object prepareForm(HttpClient httpClient, Parameters parameters, boolean z, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            FormDataContent formDataContent = new FormDataContent(parameters);
            KType kTypeTypeOf = null;
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable unused) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
            }
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareForm$$forInline(HttpClient httpClient, Parameters parameters, boolean z, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            FormDataContent formDataContent = new FormDataContent(parameters);
            KType kTypeTypeOf = null;
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable unused) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
            }
        }
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareForm(HttpClient httpClient, String str, Parameters parameters, boolean z, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Get);
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Post);
            FormDataContent formDataContent = new FormDataContent(parameters);
            KType kTypeTypeOf = null;
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FormDataContent.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(FormDataContent.class);
                } catch (Throwable unused) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
            }
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareFormWithBinaryData(HttpClient httpClient, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kTypeTypeOf = null;
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kTypeTypeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable unused) {
            }
            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareFormWithBinaryData$$forInline(HttpClient httpClient, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kTypeTypeOf = null;
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kTypeTypeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable unused) {
            }
            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        }
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareFormWithBinaryData(HttpClient httpClient, String str, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kTypeTypeOf = null;
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kTypeTypeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable unused) {
            }
            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareFormWithBinaryData$$forInline(HttpClient httpClient, String str, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Post);
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, null, null, 6, null);
        KType kTypeTypeOf = null;
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType(null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
            try {
                kTypeTypeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            } catch (Throwable unused) {
            }
            httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        Unit unit = Unit.INSTANCE;
        Unit unit2 = Unit.INSTANCE;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }
}
