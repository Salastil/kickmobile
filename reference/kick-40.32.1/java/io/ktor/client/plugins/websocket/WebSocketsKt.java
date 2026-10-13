package io.ktor.client.plugins.websocket;

import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.WebSocketExtension;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import org.slf4j.Logger;

/* JADX INFO: compiled from: WebSockets.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"$\u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004\"&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00008\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u001e\u0010\r\u001a\u00060\u000bj\u0002`\f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/util/AttributeKey;", "", "Lio/ktor/websocket/WebSocketExtension;", "REQUEST_EXTENSIONS_KEY", "Lio/ktor/util/AttributeKey;", "Lio/ktor/client/plugins/websocket/WebSockets;", "WEBSOCKETS_KEY", "getWEBSOCKETS_KEY", "()Lio/ktor/util/AttributeKey;", "getWEBSOCKETS_KEY$annotations", "()V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "getLOGGER", "()Lorg/slf4j/Logger;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class WebSocketsKt {
    private static final Logger LOGGER;
    private static final AttributeKey<List<WebSocketExtension<?>>> REQUEST_EXTENSIONS_KEY;
    private static final AttributeKey<WebSockets> WEBSOCKETS_KEY;

    public static /* synthetic */ void getWEBSOCKETS_KEY$annotations() {
    }

    public static final AttributeKey<WebSockets> getWEBSOCKETS_KEY() {
        return WEBSOCKETS_KEY;
    }

    public static final Logger getLOGGER() {
        return LOGGER;
    }

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(List.class);
        KType kTypeTypeOf2 = null;
        try {
            kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(WebSocketExtension.class, KTypeProjection.INSTANCE.getSTAR())));
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        REQUEST_EXTENSIONS_KEY = new AttributeKey<>("Websocket extensions", new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(WebSockets.class);
        try {
            kTypeTypeOf2 = Reflection.typeOf(WebSockets.class);
        } catch (Throwable unused2) {
        }
        WEBSOCKETS_KEY = new AttributeKey<>("Websocket plugin config", new TypeInfo(orCreateKotlinClass2, kTypeTypeOf2));
        LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.websocket.WebSockets");
    }
}
