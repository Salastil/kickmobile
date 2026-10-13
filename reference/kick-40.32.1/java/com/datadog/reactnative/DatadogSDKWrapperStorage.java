package com.datadog.reactnative;

import com.datadog.android.core.InternalSdkCore;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogSDKWrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0007R&\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/datadog/reactnative/DatadogSDKWrapperStorage;", "", "<init>", "()V", "onInitializedListeners", "", "Lkotlin/Function1;", "Lcom/datadog/android/core/InternalSdkCore;", "", "getOnInitializedListeners$datadog_mobile_react_native_release", "()Ljava/util/List;", "core", "addOnInitializedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "notifyOnInitializedListeners", "ddCore", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DatadogSDKWrapperStorage {
    private static InternalSdkCore core;
    public static final DatadogSDKWrapperStorage INSTANCE = new DatadogSDKWrapperStorage();
    private static final List<Function1<InternalSdkCore, Unit>> onInitializedListeners = new ArrayList();

    private DatadogSDKWrapperStorage() {
    }

    public final List<Function1<InternalSdkCore, Unit>> getOnInitializedListeners$datadog_mobile_react_native_release() {
        return onInitializedListeners;
    }

    public final void addOnInitializedListener(Function1<? super InternalSdkCore, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        onInitializedListeners.add(listener);
    }

    public final void notifyOnInitializedListeners(InternalSdkCore ddCore) {
        Intrinsics.checkNotNullParameter(ddCore, "ddCore");
        Iterator<Function1<InternalSdkCore, Unit>> it = onInitializedListeners.iterator();
        while (it.hasNext()) {
            it.next().invoke(ddCore);
        }
    }
}
