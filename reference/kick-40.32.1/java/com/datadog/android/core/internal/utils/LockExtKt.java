package com.datadog.android.core.internal.utils;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import io.ktor.sse.ServerSentEventKt;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LockExt.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0000\u001a/\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\f0\nH\u0000¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"safeTryWithLock", "", "Ljava/util/concurrent/locks/Lock;", "time", "", "unit", "Ljava/util/concurrent/TimeUnit;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "block", "Lkotlin/Function0;", "safeWithLock", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/util/concurrent/locks/Lock;Lcom/datadog/android/api/InternalLogger;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dd-sdk-android-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LockExtKt {
    public static final void safeTryWithLock(final Lock lock, final long j, final TimeUnit unit, InternalLogger internalLogger, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(lock, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            if (!lock.tryLock(j, unit)) {
                InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.utils.LockExtKt.safeTryWithLock.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Couldn't acquire " + lock.getClass().getSimpleName() + " due to timeout (" + j + ServerSentEventKt.SPACE + unit + "), aborting operation.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return;
            }
            try {
                block.invoke();
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.utils.LockExtKt$safeTryWithLock$locked$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Couldn't acquire " + lock.getClass().getSimpleName() + " due to the exception thrown, aborting operation.";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
    }

    public static final <T> T safeWithLock(final Lock lock, InternalLogger internalLogger, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(lock, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            lock.lock();
            try {
                return block.invoke();
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.utils.LockExtKt.safeWithLock.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Couldn't acquire " + lock.getClass().getSimpleName() + " lock due to the exception thrown, aborting operation.";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }
}
