package com.datadog.android.flags;

import com.datadog.android.flags.model.FlagsClientState;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* JADX INFO: compiled from: StateObservable.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/datadog/android/flags/StateObservable;", "", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/datadog/android/flags/FlagsStateListener;", "getCurrentState", "Lcom/datadog/android/flags/model/FlagsClientState;", "removeListener", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface StateObservable {
    void addListener(FlagsStateListener listener);

    FlagsClientState getCurrentState();

    void removeListener(FlagsStateListener listener);
}
