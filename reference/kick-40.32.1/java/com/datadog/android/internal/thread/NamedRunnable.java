package com.datadog.android.internal.thread;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NamedExecutionUnit.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/internal/thread/NamedRunnable;", "Lcom/datadog/android/internal/thread/NamedExecutionUnit;", "Ljava/lang/Runnable;", "name", "", "runnable", "(Ljava/lang/String;Ljava/lang/Runnable;)V", "getName", "()Ljava/lang/String;", "run", "", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NamedRunnable implements NamedExecutionUnit, Runnable {
    private final String name;
    private final Runnable runnable;

    @Override // java.lang.Runnable
    public void run() {
        this.runnable.run();
    }

    public NamedRunnable(String name, Runnable runnable) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.runnable = runnable;
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
