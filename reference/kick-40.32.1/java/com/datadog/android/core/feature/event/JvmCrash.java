package com.datadog.android.core.feature.event;

import com.datadog.android.rum.internal.RumFeature;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JvmCrash.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0001\u0001\u0011¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/core/feature/event/JvmCrash;", "", "()V", "message", "", "getMessage", "()Ljava/lang/String;", "threads", "", "Lcom/datadog/android/core/feature/event/ThreadDump;", "getThreads", "()Ljava/util/List;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "getThrowable", "()Ljava/lang/Throwable;", "Rum", "Lcom/datadog/android/core/feature/event/JvmCrash$Rum;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class JvmCrash {
    public /* synthetic */ JvmCrash(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getMessage();

    public abstract List<ThreadDump> getThreads();

    public abstract Throwable getThrowable();

    private JvmCrash() {
    }

    /* JADX INFO: compiled from: JvmCrash.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/core/feature/event/JvmCrash$Rum;", "Lcom/datadog/android/core/feature/event/JvmCrash;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "message", "", "threads", "", "Lcom/datadog/android/core/feature/event/ThreadDump;", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/util/List;)V", "getMessage", "()Ljava/lang/String;", "getThreads", "()Ljava/util/List;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Rum extends JvmCrash {
        private final String message;
        private final List<ThreadDump> threads;
        private final Throwable throwable;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Rum copy$default(Rum rum, Throwable th, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                th = rum.throwable;
            }
            if ((i & 2) != 0) {
                str = rum.message;
            }
            if ((i & 4) != 0) {
                list = rum.threads;
            }
            return rum.copy(th, str, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Throwable getThrowable() {
            return this.throwable;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final List<ThreadDump> component3() {
            return this.threads;
        }

        public final Rum copy(Throwable throwable, String message, List<ThreadDump> threads) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(threads, "threads");
            return new Rum(throwable, message, threads);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Rum)) {
                return false;
            }
            Rum rum = (Rum) other;
            return Intrinsics.areEqual(this.throwable, rum.throwable) && Intrinsics.areEqual(this.message, rum.message) && Intrinsics.areEqual(this.threads, rum.threads);
        }

        public int hashCode() {
            return (((this.throwable.hashCode() * 31) + this.message.hashCode()) * 31) + this.threads.hashCode();
        }

        public String toString() {
            return "Rum(throwable=" + this.throwable + ", message=" + this.message + ", threads=" + this.threads + ")";
        }

        @Override // com.datadog.android.core.feature.event.JvmCrash
        public Throwable getThrowable() {
            return this.throwable;
        }

        @Override // com.datadog.android.core.feature.event.JvmCrash
        public String getMessage() {
            return this.message;
        }

        @Override // com.datadog.android.core.feature.event.JvmCrash
        public List<ThreadDump> getThreads() {
            return this.threads;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Rum(Throwable throwable, String message, List<ThreadDump> threads) {
            super(null);
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(threads, "threads");
            this.throwable = throwable;
            this.message = message;
            this.threads = threads;
        }
    }
}
