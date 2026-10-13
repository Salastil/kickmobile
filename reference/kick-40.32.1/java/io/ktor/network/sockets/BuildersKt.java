package io.ktor.network.sockets;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.network.selector.SelectorManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\u0007\u001a\u00028\u0000\"\u0012\b\u0000\u0010\u0006*\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0005*\u00028\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/network/sockets/SocketBuilder;", "aSocket", "(Lio/ktor/network/selector/SelectorManager;)Lio/ktor/network/sockets/SocketBuilder;", "Lio/ktor/network/sockets/Configurable;", ExifInterface.GPS_DIRECTION_TRUE, "tcpNoDelay", "(Lio/ktor/network/sockets/Configurable;)Lio/ktor/network/sockets/Configurable;", "ktor-network"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BuildersKt {
    public static final SocketBuilder aSocket(SelectorManager selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new SocketBuilder(selector, SocketOptions.INSTANCE.create$ktor_network());
    }

    @Deprecated(message = "noDelay is true by default", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    public static final <T extends Configurable<? extends T, ?>> T tcpNoDelay(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        return (T) t.configure(new Function1() { // from class: io.ktor.network.sockets.BuildersKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BuildersKt.tcpNoDelay$lambda$0((SocketOptions) obj);
            }
        });
    }

    static final Unit tcpNoDelay$lambda$0(SocketOptions configure) {
        Intrinsics.checkNotNullParameter(configure, "$this$configure");
        if (configure instanceof SocketOptions.TCPClientSocketOptions) {
            ((SocketOptions.TCPClientSocketOptions) configure).setNoDelay(true);
        }
        return Unit.INSTANCE;
    }
}
