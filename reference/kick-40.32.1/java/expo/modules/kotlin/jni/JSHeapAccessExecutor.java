package expo.modules.kotlin.jni;

import kotlin.Metadata;

/* JADX INFO: compiled from: JSHeapAccessExecutor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\t\u001a\u00020\bH'¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/jni/JSHeapAccessExecutor;", "", "runOnQueue", "", "runnable", "Ljava/lang/Runnable;", "onCancellation", "runOnQueueSync", "", "invalidate", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface JSHeapAccessExecutor {
    void invalidate();

    boolean runOnQueue(Runnable runnable, Runnable onCancellation);

    void runOnQueueSync(Runnable runnable) throws Throwable;
}
