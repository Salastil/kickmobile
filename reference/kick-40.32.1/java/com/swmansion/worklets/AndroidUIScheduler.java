package com.swmansion.worklets;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidUIScheduler.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\r\u001a\u00020\u0007H\u0082 J\b\u0010\u000e\u001a\u00020\u000fH\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u0086 J\t\u0010\u0012\u001a\u00020\u0011H\u0086 J\b\u0010\u0013\u001a\u00020\u0011H\u0003J\u0006\u0010\u0014\u001a\u00020\u0011R\u0010\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/swmansion/worklets/AndroidUIScheduler;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "mContext", "mActive", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mUIThreadRunnable", "Ljava/lang/Runnable;", "initHybrid", "isOnUIThread", "", "triggerUI", "", "invalidate", "scheduleTriggerOnUI", "deactivate", "react-native-worklets_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AndroidUIScheduler {
    private final AtomicBoolean mActive;
    private final ReactApplicationContext mContext;
    private final HybridData mHybridData;
    private final Runnable mUIThreadRunnable;

    private final native HybridData initHybrid();

    public final native void invalidate();

    public final native void triggerUI();

    public AndroidUIScheduler(ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mHybridData = initHybrid();
        this.mContext = context;
        this.mActive = new AtomicBoolean(true);
        this.mUIThreadRunnable = new Runnable() { // from class: com.swmansion.worklets.AndroidUIScheduler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AndroidUIScheduler.mUIThreadRunnable$lambda$0(this.f$0);
            }
        };
    }

    static final void mUIThreadRunnable$lambda$0(AndroidUIScheduler androidUIScheduler) {
        synchronized (androidUIScheduler.mActive) {
            if (androidUIScheduler.mActive.get()) {
                androidUIScheduler.triggerUI();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final boolean isOnUIThread() {
        return UiThreadUtil.isOnUiThread();
    }

    private final void scheduleTriggerOnUI() {
        UiThreadUtil.runOnUiThread(new GuardedRunnable(this.mContext.getExceptionHandler()) { // from class: com.swmansion.worklets.AndroidUIScheduler.scheduleTriggerOnUI.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(jSExceptionHandler);
                Intrinsics.checkNotNull(jSExceptionHandler);
            }

            @Override // com.facebook.react.bridge.GuardedRunnable
            public void runGuarded() {
                AndroidUIScheduler.this.mUIThreadRunnable.run();
            }
        });
    }

    public final void deactivate() {
        synchronized (this.mActive) {
            this.mActive.set(false);
            invalidate();
            Unit unit = Unit.INSTANCE;
        }
    }
}
