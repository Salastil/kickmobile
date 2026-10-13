package com.datadog.android.internal.thread;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NamedExecutionUnit.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00018\u00008\u0000H\u0096\u0001¢\u0006\u0002\u0010\fR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/datadog/android/internal/thread/NamedCallable;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/datadog/android/internal/thread/NamedExecutionUnit;", "Ljava/util/concurrent/Callable;", "name", "", "callable", "(Ljava/lang/String;Ljava/util/concurrent/Callable;)V", "getName", "()Ljava/lang/String;", NotificationCompat.CATEGORY_CALL, "kotlin.jvm.PlatformType", "()Ljava/lang/Object;", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NamedCallable<V> implements NamedExecutionUnit, Callable<V> {
    private final Callable<V> callable;
    private final String name;

    @Override // java.util.concurrent.Callable
    public V call() {
        return this.callable.call();
    }

    public NamedCallable(String name, Callable<V> callable) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(callable, "callable");
        this.callable = callable;
        String strReplace = NamedExecutionUnitKt.SanitizedRegex.replace(name, "_");
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = strReplace.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        this.name = lowerCase;
    }

    @Override // com.datadog.android.internal.thread.NamedExecutionUnit
    public String getName() {
        return this.name;
    }
}
