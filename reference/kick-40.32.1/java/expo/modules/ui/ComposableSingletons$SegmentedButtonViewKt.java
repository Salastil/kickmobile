package expo.modules.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SegmentedButtonView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SegmentedButtonViewKt {
    public static final ComposableSingletons$SegmentedButtonViewKt INSTANCE = new ComposableSingletons$SegmentedButtonViewKt();
    private static Function2<Composer, Integer, Unit> lambda$1431986096 = ComposableLambdaKt.composableLambdaInstance(1431986096, false, new Function2() { // from class: expo.modules.ui.ComposableSingletons$SegmentedButtonViewKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SegmentedButtonViewKt.lambda_1431986096$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1431986096$expo_ui_release() {
        return lambda$1431986096;
    }

    static final Unit lambda_1431986096$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:SegmentedButtonView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1431986096, i, -1, "expo.modules.ui.ComposableSingletons$SegmentedButtonViewKt.lambda$1431986096.<anonymous> (SegmentedButtonView.kt:80)");
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
