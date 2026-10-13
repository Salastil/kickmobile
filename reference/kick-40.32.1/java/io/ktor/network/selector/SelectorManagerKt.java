package io.ktor.network.selector;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.spi.SelectorProvider;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectorManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a]\u0010\u000e\u001a\u00028\u0001\"\f\b\u0000\u0010\u0007*\u00060\u0005j\u0002`\u0006\"\u0004\b\u0001\u0010\b*\u00020\u00022\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\b\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "dispatcher", "Lio/ktor/network/selector/SelectorManager;", "SelectorManager", "(Lkotlin/coroutines/CoroutineContext;)Lio/ktor/network/selector/SelectorManager;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "C", "R", "Lkotlin/Function1;", "Ljava/nio/channels/spi/SelectorProvider;", "Lkotlin/ExtensionFunctionType;", "create", "setup", "buildOrClose", "(Lio/ktor/network/selector/SelectorManager;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ktor-network"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SelectorManagerKt {
    public static final SelectorManager SelectorManager(CoroutineContext dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        return new ActorSelectorManager(dispatcher);
    }

    public static /* synthetic */ SelectorManager SelectorManager$default(CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return SelectorManager(coroutineContext);
    }

    public static final <C extends Closeable, R> R buildOrClose(SelectorManager selectorManager, Function1<? super SelectorProvider, ? extends C> create, Function1<? super C, ? extends R> setup) throws IOException {
        Intrinsics.checkNotNullParameter(selectorManager, "<this>");
        Intrinsics.checkNotNullParameter(create, "create");
        Intrinsics.checkNotNullParameter(setup, "setup");
        C cInvoke = create.invoke(selectorManager.getProvider());
        try {
            return setup.invoke(cInvoke);
        } catch (Throwable th) {
            cInvoke.close();
            throw th;
        }
    }
}
