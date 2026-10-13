package io.ktor.client.plugins;

import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.slf4j.Logger;

/* JADX INFO: compiled from: SaveBody.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0003\"\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007\"\u001f\u0010\u000f\u001a\u00060\tj\u0002`\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00108\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\"&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00108\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u0012\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u0019\u0010\u0014\"\u0015\u0010\u001d\u001a\u00020\u001c*\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "", "skipSaveBody", "(Lio/ktor/client/request/HttpRequestBuilder;)V", "skipSavingBody", "Lio/ktor/util/AttributeKey;", "SKIP_SAVE_BODY", "Lio/ktor/util/AttributeKey;", "RESPONSE_BODY_SAVED", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER$delegate", "Lkotlin/Lazy;", "getLOGGER", "()Lorg/slf4j/Logger;", "LOGGER", "Lio/ktor/client/plugins/api/ClientPlugin;", "SaveBody", "Lio/ktor/client/plugins/api/ClientPlugin;", "getSaveBody", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getSaveBody$annotations", "()V", "Lio/ktor/client/plugins/SaveBodyPluginConfig;", "SaveBodyPlugin", "getSaveBodyPlugin", "getSaveBodyPlugin$annotations", "Lio/ktor/client/statement/HttpResponse;", "", "isSaved", "(Lio/ktor/client/statement/HttpResponse;)Z", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DoubleReceivePluginKt {
    private static final Lazy LOGGER$delegate;
    private static final AttributeKey<Unit> RESPONSE_BODY_SAVED;
    private static final AttributeKey<Unit> SKIP_SAVE_BODY;
    private static final ClientPlugin<Unit> SaveBody;
    private static final ClientPlugin<SaveBodyPluginConfig> SaveBodyPlugin;

    public static /* synthetic */ void getSaveBody$annotations() {
    }

    @Deprecated(message = Messages.PLUGIN_DEPRECATED_MESSAGE)
    public static /* synthetic */ void getSaveBodyPlugin$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Logger getLOGGER() {
        return (Logger) LOGGER$delegate.getValue();
    }

    public static final ClientPlugin<Unit> getSaveBody() {
        return SaveBody;
    }

    static final Unit SaveBody$lambda$0(ClientPluginBuilder createClientPlugin) {
        Intrinsics.checkNotNullParameter(createClientPlugin, "$this$createClientPlugin");
        createClientPlugin.getClient().getReceivePipeline().intercept(HttpReceivePipeline.INSTANCE.getBefore(), new DoubleReceivePluginKt$SaveBody$1$1(null));
        return Unit.INSTANCE;
    }

    public static final void skipSaveBody(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        httpRequestBuilder.getAttributes().put(SKIP_SAVE_BODY, Unit.INSTANCE);
    }

    public static final ClientPlugin<SaveBodyPluginConfig> getSaveBodyPlugin() {
        return SaveBodyPlugin;
    }

    static final Unit SaveBodyPlugin$lambda$0(ClientPluginBuilder createClientPlugin) {
        Intrinsics.checkNotNullParameter(createClientPlugin, "$this$createClientPlugin");
        if (((SaveBodyPluginConfig) createClientPlugin.getPluginConfig()).getDisabled()) {
            getLOGGER().warn(Messages.SAVE_BODY_DISABLED_MESSAGE);
        } else {
            getLOGGER().warn(Messages.SAVE_BODY_ENABLED_MESSAGE);
        }
        return Unit.INSTANCE;
    }

    public static final boolean isSaved(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        return httpResponse.getCall().getAttributes().contains(RESPONSE_BODY_SAVED);
    }

    @Deprecated(message = Messages.SKIP_SAVING_BODY_MESSAGE)
    public static final void skipSavingBody(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        getLOGGER().warn(Messages.SKIP_SAVING_BODY_MESSAGE);
    }

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Unit.class);
        KType kTypeTypeOf2 = null;
        try {
            kTypeTypeOf = Reflection.typeOf(Unit.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        SKIP_SAVE_BODY = new AttributeKey<>("SkipSaveBody", new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Unit.class);
        try {
            kTypeTypeOf2 = Reflection.typeOf(Unit.class);
        } catch (Throwable unused2) {
        }
        RESPONSE_BODY_SAVED = new AttributeKey<>("ResponseBodySaved", new TypeInfo(orCreateKotlinClass2, kTypeTypeOf2));
        LOGGER$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.client.plugins.DoubleReceivePluginKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.SaveBody");
            }
        });
        SaveBody = CreatePluginUtilsKt.createClientPlugin("SaveBody", new Function1() { // from class: io.ktor.client.plugins.DoubleReceivePluginKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DoubleReceivePluginKt.SaveBody$lambda$0((ClientPluginBuilder) obj);
            }
        });
        SaveBodyPlugin = CreatePluginUtilsKt.createClientPlugin("DoubleReceivePlugin", DoubleReceivePluginKt$SaveBodyPlugin$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.DoubleReceivePluginKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DoubleReceivePluginKt.SaveBodyPlugin$lambda$0((ClientPluginBuilder) obj);
            }
        });
    }
}
