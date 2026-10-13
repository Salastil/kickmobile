package io.github.expo.modules.v2.errors;

import com.datadog.android.rum.internal.RumFeature;
import io.github.expo.modules.v2.JavaScriptThrowable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThrowableHelper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lio/github/expo/modules/v2/errors/ThrowableHelper;", "", "<init>", "()V", "codeOf", "", RumFeature.EVENT_THROWABLE_PROPERTY, "", "messageOf", "describe", "", "(Ljava/lang/Throwable;)[Ljava/lang/String;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ThrowableHelper {
    public static final ThrowableHelper INSTANCE = new ThrowableHelper();

    private ThrowableHelper() {
    }

    public final String codeOf(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (throwable instanceof JavaScriptThrowable) {
            return ((JavaScriptThrowable) throwable).getCode();
        }
        String name = throwable.getClass().getName();
        Intrinsics.checkNotNull(name);
        return name;
    }

    public final String messageOf(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        String message = throwable.getMessage();
        return message == null ? throwable.toString() : message;
    }

    @JvmStatic
    public static final String[] describe(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        ThrowableHelper throwableHelper = INSTANCE;
        return new String[]{throwableHelper.codeOf(throwable), throwableHelper.messageOf(throwable), ExceptionsKt.stackTraceToString(throwable)};
    }
}
