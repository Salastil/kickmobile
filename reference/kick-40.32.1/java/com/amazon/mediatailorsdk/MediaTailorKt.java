package com.amazon.mediatailorsdk;

import com.amazon.mediatailorsdk.network.NetworkClient;
import com.amazon.mediatailorsdk.threading.ThreadingScope;
import com.amazon.mediatailorsdk.threading.ThreadingScopeImp;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MediaTailor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0006\u001a\u00020\u00078@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\b\u0010\t*r\u0010\u000b\"6\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\f26\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\f¨\u0006\u0014"}, d2 = {"threading", "Lcom/amazon/mediatailorsdk/threading/ThreadingScope;", "getThreading", "()Lcom/amazon/mediatailorsdk/threading/ThreadingScope;", "threading$delegate", "Lkotlin/Lazy;", "network", "Lcom/amazon/mediatailorsdk/network/NetworkClient;", "getNetwork", "()Lcom/amazon/mediatailorsdk/network/NetworkClient;", "network$delegate", "CreateSessionCallback", "Lkotlin/Function2;", "Lcom/amazon/mediatailorsdk/Session;", "Lkotlin/ParameterName;", "name", "session", "Lcom/amazon/mediatailorsdk/SessionError;", "error", "", "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MediaTailorKt {
    private static final Lazy threading$delegate = LazyKt.lazy(new Function0() { // from class: com.amazon.mediatailorsdk.MediaTailorKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MediaTailorKt.threading_delegate$lambda$0();
        }
    });
    private static final Lazy network$delegate = LazyKt.lazy(new Function0() { // from class: com.amazon.mediatailorsdk.MediaTailorKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MediaTailorKt.network_delegate$lambda$0();
        }
    });

    public static final ThreadingScope getThreading() {
        return (ThreadingScope) threading$delegate.getValue();
    }

    static final ThreadingScopeImp threading_delegate$lambda$0() {
        return new ThreadingScopeImp();
    }

    public static final NetworkClient getNetwork() {
        return (NetworkClient) network$delegate.getValue();
    }

    static final NetworkClient network_delegate$lambda$0() {
        return new NetworkClient();
    }
}
