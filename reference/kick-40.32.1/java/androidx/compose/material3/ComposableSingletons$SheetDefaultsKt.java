package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SheetDefaults.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class ComposableSingletons$SheetDefaultsKt {
    public static final ComposableSingletons$SheetDefaultsKt INSTANCE = new ComposableSingletons$SheetDefaultsKt();
    private static Function2<Composer, Integer, Unit> lambda$1335949740 = ComposableLambdaKt.composableLambdaInstance(1335949740, false, new Function2() { // from class: androidx.compose.material3.ComposableSingletons$SheetDefaultsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SheetDefaultsKt.lambda_1335949740$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-2061828736, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f29lambda$2061828736 = ComposableLambdaKt.composableLambdaInstance(-2061828736, false, new Function2() { // from class: androidx.compose.material3.ComposableSingletons$SheetDefaultsKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SheetDefaultsKt.lambda__2061828736$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-2061828736$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3749getLambda$2061828736$material3() {
        return f29lambda$2061828736;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1335949740$material3() {
        return lambda$1335949740;
    }

    static final Unit lambda_1335949740$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C151@7458L12:SheetDefaults.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1335949740, i, -1, "androidx.compose.material3.ComposableSingletons$SheetDefaultsKt.lambda$1335949740.<anonymous> (SheetDefaults.kt:151)");
            }
            BottomSheetDefaults.INSTANCE.m3509DragHandlelgZ2HuY(null, 0.0f, 0.0f, null, 0L, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__2061828736$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C227@10534L12:SheetDefaults.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2061828736, i, -1, "androidx.compose.material3.ComposableSingletons$SheetDefaultsKt.lambda$-2061828736.<anonymous> (SheetDefaults.kt:227)");
            }
            BottomSheetDefaults.INSTANCE.m3509DragHandlelgZ2HuY(null, 0.0f, 0.0f, null, 0L, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
