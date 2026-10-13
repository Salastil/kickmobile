package io.ktor.websocket;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: WebSocketChannelsConfig.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/Channel$Factory;", "Lio/ktor/websocket/ChannelConfig;", "config", "Lkotlinx/coroutines/channels/Channel;", Constants.MessagePayloadKeys.FROM, "(Lkotlinx/coroutines/channels/Channel$Factory;Lio/ktor/websocket/ChannelConfig;)Lkotlinx/coroutines/channels/Channel;", "ktor-websockets"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class WebSocketChannelsConfigKt {
    public static final <T> Channel<T> from(Channel.Companion companion, ChannelConfig config) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        if (config.getCapacity() == Integer.MAX_VALUE) {
            return ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        }
        if (config.getOnOverflow() == ChannelOverflow.SUSPEND) {
            return ChannelKt.Channel$default(config.getCapacity(), BufferOverflow.SUSPEND, null, 4, null);
        }
        if (config.getOnOverflow() == ChannelOverflow.CLOSE) {
            return new BoundedChannel(config.getCapacity(), null, 2, null);
        }
        throw new IllegalStateException("Unsupported channel config.".toString());
    }
}
