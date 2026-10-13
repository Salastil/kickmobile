package expo.modules.kotlin.jni;

import com.facebook.soloader.SoLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WorkletsSoLoader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nR\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u000b"}, d2 = {"Lexpo/modules/kotlin/jni/WorkletsSoLoader;", "", "<init>", "()V", "isAvailable", "", "()Z", "isAvailable$delegate", "Lkotlin/Lazy;", "loadIfPresent", "", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WorkletsSoLoader {
    public static final WorkletsSoLoader INSTANCE = new WorkletsSoLoader();

    /* JADX INFO: renamed from: isAvailable$delegate, reason: from kotlin metadata */
    private static final Lazy isAvailable = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.jni.WorkletsSoLoader$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(WorkletsSoLoader.isAvailable_delegate$lambda$0());
        }
    });
    public static final int $stable = 8;

    private WorkletsSoLoader() {
    }

    public final boolean isAvailable() {
        return ((Boolean) isAvailable.getValue()).booleanValue();
    }

    static final boolean isAvailable_delegate$lambda$0() {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(Boolean.valueOf(SoLoader.loadLibrary("expo-modules-worklets")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m12691isSuccessimpl(objM12684constructorimpl);
    }

    public final void loadIfPresent() {
        isAvailable();
    }
}
