package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* JADX INFO: compiled from: DefaultRequest.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0006\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a8\u0010\u0006\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\b\b\u0002\u0010\t\u001a\u00020\b2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\n\"\u0018\u0010\r\u001a\u00060\u000bj\u0002`\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "defaultRequest", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "", "replace", "(Lio/ktor/client/HttpClientConfig;ZLkotlin/jvm/functions/Function1;)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DefaultRequestKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.DefaultRequest");

    public static final void defaultRequest(HttpClientConfig<?> httpClientConfig, final Function1<? super DefaultRequest.DefaultRequestBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        httpClientConfig.install(DefaultRequest.Plugin, new Function1() { // from class: io.ktor.client.plugins.DefaultRequestKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DefaultRequestKt.defaultRequest$lambda$0(block, (DefaultRequest.DefaultRequestBuilder) obj);
            }
        });
    }

    static final Unit defaultRequest$lambda$0(Function1 function1, DefaultRequest.DefaultRequestBuilder install) {
        Intrinsics.checkNotNullParameter(install, "$this$install");
        function1.invoke(install);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void defaultRequest$default(HttpClientConfig httpClientConfig, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        defaultRequest(httpClientConfig, z, function1);
    }

    public static final void defaultRequest(HttpClientConfig<?> httpClientConfig, boolean z, final Function1<? super DefaultRequest.DefaultRequestBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!z) {
            httpClientConfig.install(DefaultRequest.Plugin, new Function1() { // from class: io.ktor.client.plugins.DefaultRequestKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DefaultRequestKt.defaultRequest$lambda$1(block, (DefaultRequest.DefaultRequestBuilder) obj);
                }
            });
        } else {
            httpClientConfig.installOrReplace(DefaultRequest.Plugin, new Function1() { // from class: io.ktor.client.plugins.DefaultRequestKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DefaultRequestKt.defaultRequest$lambda$2(block, (DefaultRequest.DefaultRequestBuilder) obj);
                }
            });
        }
    }

    static final Unit defaultRequest$lambda$1(Function1 function1, DefaultRequest.DefaultRequestBuilder install) {
        Intrinsics.checkNotNullParameter(install, "$this$install");
        function1.invoke(install);
        return Unit.INSTANCE;
    }

    static final Unit defaultRequest$lambda$2(Function1 function1, DefaultRequest.DefaultRequestBuilder installOrReplace) {
        Intrinsics.checkNotNullParameter(installOrReplace, "$this$installOrReplace");
        function1.invoke(installOrReplace);
        return Unit.INSTANCE;
    }
}
