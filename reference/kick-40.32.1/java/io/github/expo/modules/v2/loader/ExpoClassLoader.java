package io.github.expo.modules.v2.loader;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoClassLoader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007¨\u0006\b"}, d2 = {"Lio/github/expo/modules/v2/loader/ExpoClassLoader;", "", "<init>", "()V", "loadAndInitializeClass", "", "clazz", "Ljava/lang/Class;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpoClassLoader {
    public static final ExpoClassLoader INSTANCE = new ExpoClassLoader();

    private ExpoClassLoader() {
    }

    public final boolean loadAndInitializeClass(Class<?> clazz) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            Result.Companion companion = Result.INSTANCE;
            ExpoClassLoader expoClassLoader = this;
            objM12684constructorimpl = Result.m12684constructorimpl(Class.forName(clazz.getName(), true, clazz.getClassLoader()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m12687exceptionOrNullimpl(objM12684constructorimpl) == null;
    }
}
