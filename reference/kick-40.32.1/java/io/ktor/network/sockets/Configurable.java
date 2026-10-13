package io.ktor.network.sockets;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.network.sockets.Configurable;
import io.ktor.network.sockets.SocketOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000*\u0016\b\u0000\u0010\u0001 \u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004J(\u0010\t\u001a\u00028\u00002\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\u00028\u00018&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lio/ktor/network/sockets/Configurable;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/network/sockets/SocketOptions;", "Options", "", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "configure", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/network/sockets/Configurable;", "getOptions", "()Lio/ktor/network/sockets/SocketOptions;", "setOptions", "(Lio/ktor/network/sockets/SocketOptions;)V", "options", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface Configurable<T extends Configurable<? extends T, Options>, Options extends SocketOptions> {
    Options getOptions();

    void setOptions(Options options);

    /* JADX INFO: compiled from: Builders.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T extends Configurable<? extends T, Options>, Options extends SocketOptions> T configure(Configurable<? extends T, Options> configurable, Function1<? super Options, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return (T) Configurable.super.configure(block);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    default T configure(Function1<? super Options, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SocketOptions socketOptionsCopy$ktor_network = getOptions().copy$ktor_network();
        Intrinsics.checkNotNull(socketOptionsCopy$ktor_network, "null cannot be cast to non-null type Options of io.ktor.network.sockets.Configurable");
        block.invoke(socketOptionsCopy$ktor_network);
        setOptions(socketOptionsCopy$ktor_network);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of io.ktor.network.sockets.Configurable");
        return this;
    }
}
