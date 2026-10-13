package com.datadog.android.flags.internal;

import com.datadog.android.flags.FlagsStateListener;
import com.datadog.android.flags.StateObservable;
import com.datadog.android.flags.model.FlagsClientState;
import com.datadog.android.internal.utils.DDCoreSubscription;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlagsStateManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/flags/internal/FlagsStateManager;", "Lcom/datadog/android/flags/StateObservable;", FirebaseAnalytics.Param.SUBSCRIPTION, "Lcom/datadog/android/internal/utils/DDCoreSubscription;", "Lcom/datadog/android/flags/FlagsStateListener;", "(Lcom/datadog/android/internal/utils/DDCoreSubscription;)V", "currentState", "Lcom/datadog/android/flags/model/FlagsClientState;", "stateLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getCurrentState", "removeListener", "updateState", "newState", "updateState$dd_sdk_android_flags_release", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlagsStateManager implements StateObservable {
    private FlagsClientState currentState;
    private final ReentrantReadWriteLock stateLock;
    private final DDCoreSubscription<FlagsStateListener> subscription;

    public FlagsStateManager(DDCoreSubscription<FlagsStateListener> subscription) {
        Intrinsics.checkNotNullParameter(subscription, "subscription");
        this.subscription = subscription;
        this.stateLock = new ReentrantReadWriteLock(true);
        this.currentState = FlagsClientState.NotReady.INSTANCE;
    }

    @Override // com.datadog.android.flags.StateObservable
    public FlagsClientState getCurrentState() {
        ReentrantReadWriteLock.ReadLock lock = this.stateLock.readLock();
        lock.lock();
        try {
            return this.currentState;
        } finally {
            lock.unlock();
        }
    }

    public final void updateState$dd_sdk_android_flags_release(final FlagsClientState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        ReentrantReadWriteLock reentrantReadWriteLock = this.stateLock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            this.currentState = newState;
            this.subscription.notifyListeners(new Function1<FlagsStateListener, Unit>() { // from class: com.datadog.android.flags.internal.FlagsStateManager$updateState$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FlagsStateListener flagsStateListener) {
                    invoke2(flagsStateListener);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FlagsStateListener notifyListeners) {
                    Intrinsics.checkNotNullParameter(notifyListeners, "$this$notifyListeners");
                    notifyListeners.onStateChanged(newState);
                }
            });
            Unit unit = Unit.INSTANCE;
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
        } finally {
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    @Override // com.datadog.android.flags.StateObservable
    public void addListener(FlagsStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantReadWriteLock.ReadLock lock = this.stateLock.readLock();
        lock.lock();
        try {
            listener.onStateChanged(this.currentState);
            this.subscription.addListener(listener);
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    @Override // com.datadog.android.flags.StateObservable
    public void removeListener(FlagsStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantReadWriteLock.ReadLock lock = this.stateLock.readLock();
        lock.lock();
        try {
            this.subscription.removeListener(listener);
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }
}
