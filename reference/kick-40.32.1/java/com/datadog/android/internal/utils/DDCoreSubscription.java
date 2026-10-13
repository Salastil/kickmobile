package com.datadog.android.internal.utils;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DDCoreSubscription.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u0010*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0010J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\r¢\u0006\u0002\b\u000eH&J\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nR\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/internal/utils/DDCoreSubscription;", ExifInterface.GPS_DIRECTION_TRUE, "", "listenersCount", "", "getListenersCount", "()I", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Ljava/lang/Object;)V", "notifyListeners", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "removeListener", "Companion", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DDCoreSubscription<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void addListener(T listener);

    int getListenersCount();

    void notifyListeners(Function1<? super T, Unit> block);

    void removeListener(T listener);

    /* JADX INFO: compiled from: DDCoreSubscription.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u0001¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/internal/utils/DDCoreSubscription$Companion;", "", "()V", "create", "Lcom/datadog/android/internal/utils/DDCoreSubscription;", ExifInterface.GPS_DIRECTION_TRUE, "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final <T> DDCoreSubscription<T> create() {
            return new DDCoreSubscriptionImpl();
        }
    }
}
