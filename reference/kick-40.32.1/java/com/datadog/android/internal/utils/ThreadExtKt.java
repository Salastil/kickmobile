package com.datadog.android.internal.utils;

import android.os.Build;
import com.mux.stats.sdk.core.events.playback.WaitingEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThreadExt.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t¨\u0006\n"}, d2 = {"asString", "", "Ljava/lang/Thread$State;", "loggableStackTrace", "", "Ljava/lang/StackTraceElement;", "([Ljava/lang/StackTraceElement;)Ljava/lang/String;", "safeGetThreadId", "", "Ljava/lang/Thread;", "dd-sdk-android-internal_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ThreadExtKt {

    /* JADX INFO: compiled from: ThreadExt.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Thread.State.values().length];
            try {
                iArr[Thread.State.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Thread.State.BLOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Thread.State.RUNNABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Thread.State.TERMINATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Thread.State.TIMED_WAITING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Thread.State.WAITING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final long safeGetThreadId(Thread thread) {
        Intrinsics.checkNotNullParameter(thread, "<this>");
        if (Build.VERSION.SDK_INT >= 36) {
            return thread.threadId();
        }
        return thread.getId();
    }

    public static final String asString(Thread.State state) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                return "new";
            case 2:
                return "blocked";
            case 3:
                return "runnable";
            case 4:
                return "terminated";
            case 5:
                return "timed_waiting";
            case 6:
                return WaitingEvent.TYPE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final String loggableStackTrace(StackTraceElement[] stackTraceElementArr) {
        Intrinsics.checkNotNullParameter(stackTraceElementArr, "<this>");
        return ArraysKt.joinToString$default(stackTraceElementArr, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<StackTraceElement, CharSequence>() { // from class: com.datadog.android.internal.utils.ThreadExtKt.loggableStackTrace.1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(StackTraceElement it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return "at " + it;
            }
        }, 30, (Object) null);
    }
}
