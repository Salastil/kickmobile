package com.datadog.android.core.internal.logger;

import android.util.Log;
import com.datadog.android.rum.internal.RumFeature;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogcatLogHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\b\u0010\u0016\u001a\u00020\u0003H\u0002R/\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/core/internal/logger/LogcatLogHandler;", "", "tag", "", "predicate", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.LEVEL, "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getPredicate$dd_sdk_android_core_release", "()Lkotlin/jvm/functions/Function1;", "getTag$dd_sdk_android_core_release", "()Ljava/lang/String;", "canLog", "log", "", "message", RumFeature.EVENT_THROWABLE_PROPERTY, "", "resolveTag", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LogcatLogHandler {
    private static final int MAX_TAG_LENGTH = 23;
    private final Function1<Integer, Boolean> predicate;
    private final String tag;

    /* JADX WARN: Multi-variable type inference failed */
    public LogcatLogHandler(String tag, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        this.tag = tag;
        this.predicate = predicate;
    }

    /* JADX INFO: renamed from: getTag$dd_sdk_android_core_release, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    public /* synthetic */ LogcatLogHandler(String str, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new Function1<Integer, Boolean>() { // from class: com.datadog.android.core.internal.logger.LogcatLogHandler.1
            public final Boolean invoke(int i2) {
                return true;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                return invoke(num.intValue());
            }
        } : anonymousClass1);
    }

    public final Function1<Integer, Boolean> getPredicate$dd_sdk_android_core_release() {
        return this.predicate;
    }

    public final boolean canLog(int level) {
        return this.predicate.invoke(Integer.valueOf(level)).booleanValue();
    }

    public final void log(int level, String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.predicate.invoke(Integer.valueOf(level)).booleanValue()) {
            String strResolveTag = resolveTag();
            Log.println(level, strResolveTag, message);
            if (throwable != null) {
                Log.println(level, strResolveTag, Log.getStackTraceString(throwable));
            }
        }
    }

    private final String resolveTag() {
        this.tag.length();
        return this.tag;
    }
}
