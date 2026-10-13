package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: compiled from: SystemProperties.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"useK1Implementation", "", "getUseK1Implementation", "()Z", "loadMetadataDirectly", "getLoadMetadataDirectly", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SystemPropertiesKt {
    private static final boolean loadMetadataDirectly;
    private static final boolean useK1Implementation;

    static {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(System.getProperty("kotlin.reflect.jvm.useK1Implementation"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        String str = (String) objM12684constructorimpl;
        useK1Implementation = str != null && Boolean.parseBoolean(str);
        try {
            Result.Companion companion3 = Result.INSTANCE;
            objM12684constructorimpl2 = Result.m12684constructorimpl(System.getProperty("kotlin.reflect.jvm.loadMetadataDirectly"));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
        }
        String str2 = (String) (Result.m12690isFailureimpl(objM12684constructorimpl2) ? null : objM12684constructorimpl2);
        loadMetadataDirectly = str2 != null && Boolean.parseBoolean(str2);
    }

    public static final boolean getUseK1Implementation() {
        return useK1Implementation;
    }

    public static final boolean getLoadMetadataDirectly() {
        return loadMetadataDirectly;
    }
}
