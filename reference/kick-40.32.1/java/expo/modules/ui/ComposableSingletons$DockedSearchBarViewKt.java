package expo.modules.ui;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DockedSearchBarView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$DockedSearchBarViewKt {
    public static final ComposableSingletons$DockedSearchBarViewKt INSTANCE = new ComposableSingletons$DockedSearchBarViewKt();
    private static Function3<ColumnScope, Composer, Integer, Unit> lambda$304213221 = ComposableLambdaKt.composableLambdaInstance(304213221, false, new Function3() { // from class: expo.modules.ui.ComposableSingletons$DockedSearchBarViewKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DockedSearchBarViewKt.lambda_304213221$lambda$0((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<ColumnScope, Composer, Integer, Unit> getLambda$304213221$expo_ui_release() {
        return lambda$304213221;
    }

    static final Unit lambda_304213221$lambda$0(ColumnScope DockedSearchBar, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DockedSearchBar, "$this$DockedSearchBar");
        ComposerKt.sourceInformation(composer, "C:DockedSearchBarView.kt#v15e7d");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(304213221, i, -1, "expo.modules.ui.ComposableSingletons$DockedSearchBarViewKt.lambda$304213221.<anonymous> (DockedSearchBarView.kt:52)");
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
