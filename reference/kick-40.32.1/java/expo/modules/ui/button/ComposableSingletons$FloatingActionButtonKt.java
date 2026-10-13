package expo.modules.ui.button;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$FloatingActionButtonKt {
    public static final ComposableSingletons$FloatingActionButtonKt INSTANCE = new ComposableSingletons$FloatingActionButtonKt();
    private static Function2<Composer, Integer, Unit> lambda$2023503970 = ComposableLambdaKt.composableLambdaInstance(2023503970, false, new Function2() { // from class: expo.modules.ui.button.ComposableSingletons$FloatingActionButtonKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$FloatingActionButtonKt.lambda_2023503970$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$84818774 = ComposableLambdaKt.composableLambdaInstance(84818774, false, new Function2() { // from class: expo.modules.ui.button.ComposableSingletons$FloatingActionButtonKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$FloatingActionButtonKt.lambda_84818774$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$2023503970$expo_ui_release() {
        return lambda$2023503970;
    }

    public final Function2<Composer, Integer, Unit> getLambda$84818774$expo_ui_release() {
        return lambda$84818774;
    }

    static final Unit lambda_2023503970$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:FloatingActionButton.kt#kazlex");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2023503970, i, -1, "expo.modules.ui.button.ComposableSingletons$FloatingActionButtonKt.lambda$2023503970.<anonymous> (FloatingActionButton.kt:51)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_84818774$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:FloatingActionButton.kt#kazlex");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(84818774, i, -1, "expo.modules.ui.button.ComposableSingletons$FloatingActionButtonKt.lambda$84818774.<anonymous> (FloatingActionButton.kt:76)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
