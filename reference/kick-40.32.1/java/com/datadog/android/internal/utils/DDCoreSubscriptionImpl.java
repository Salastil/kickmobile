package com.datadog.android.internal.utils;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DDCoreSubscription.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ!\u0010\u000f\u001a\u00020\f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u0011¢\u0006\u0002\b\u0012H\u0016J\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/internal/utils/DDCoreSubscriptionImpl;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/datadog/android/internal/utils/DDCoreSubscription;", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "listenersCount", "", "getListenersCount", "()I", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Ljava/lang/Object;)V", "notifyListeners", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "removeListener", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DDCoreSubscriptionImpl<T> implements DDCoreSubscription<T> {
    private final CopyOnWriteArraySet<T> listeners = new CopyOnWriteArraySet<>();

    @Override // com.datadog.android.internal.utils.DDCoreSubscription
    public void addListener(T listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    @Override // com.datadog.android.internal.utils.DDCoreSubscription
    public void removeListener(T listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    @Override // com.datadog.android.internal.utils.DDCoreSubscription
    public void notifyListeners(Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        for (T it : this.listeners) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            block.invoke(it);
        }
    }

    @Override // com.datadog.android.internal.utils.DDCoreSubscription
    public int getListenersCount() {
        return this.listeners.size();
    }
}
