package expo.modules.ui;

import androidx.compose.material3.BottomSheetDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ModalBottomSheetView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ModalBottomSheetViewKt {
    public static final ComposableSingletons$ModalBottomSheetViewKt INSTANCE = new ComposableSingletons$ModalBottomSheetViewKt();

    /* JADX INFO: renamed from: lambda$-45248658, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f86lambda$45248658 = ComposableLambdaKt.composableLambdaInstance(-45248658, false, new Function2() { // from class: expo.modules.ui.ComposableSingletons$ModalBottomSheetViewKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ModalBottomSheetViewKt.lambda__45248658$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-45248658$expo_ui_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12111getLambda$45248658$expo_ui_release() {
        return f86lambda$45248658;
    }

    static final Unit lambda__45248658$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C168@6801L12:ModalBottomSheetView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-45248658, i, -1, "expo.modules.ui.ComposableSingletons$ModalBottomSheetViewKt.lambda$-45248658.<anonymous> (ModalBottomSheetView.kt:168)");
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
