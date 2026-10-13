package expo.modules.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ChipView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ChipViewKt {
    public static final ComposableSingletons$ChipViewKt INSTANCE = new ComposableSingletons$ChipViewKt();
    private static Function2<Composer, Integer, Unit> lambda$778385937 = ComposableLambdaKt.composableLambdaInstance(778385937, false, new Function2() { // from class: expo.modules.ui.ComposableSingletons$ChipViewKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ChipViewKt.lambda_778385937$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1073824393, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f69lambda$1073824393 = ComposableLambdaKt.composableLambdaInstance(-1073824393, false, new Function2() { // from class: expo.modules.ui.ComposableSingletons$ChipViewKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ChipViewKt.lambda__1073824393$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$289642877 = ComposableLambdaKt.composableLambdaInstance(289642877, false, new Function2() { // from class: expo.modules.ui.ComposableSingletons$ChipViewKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ChipViewKt.lambda_289642877$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1542534682 = ComposableLambdaKt.composableLambdaInstance(1542534682, false, new Function2() { // from class: expo.modules.ui.ComposableSingletons$ChipViewKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ChipViewKt.lambda_1542534682$lambda$3((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1073824393$expo_ui_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12094getLambda$1073824393$expo_ui_release() {
        return f69lambda$1073824393;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1542534682$expo_ui_release() {
        return lambda$1542534682;
    }

    public final Function2<Composer, Integer, Unit> getLambda$289642877$expo_ui_release() {
        return lambda$289642877;
    }

    public final Function2<Composer, Integer, Unit> getLambda$778385937$expo_ui_release() {
        return lambda$778385937;
    }

    static final Unit lambda_778385937$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ChipView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(778385937, i, -1, "expo.modules.ui.ComposableSingletons$ChipViewKt.lambda$778385937.<anonymous> (ChipView.kt:146)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__1073824393$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ChipView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1073824393, i, -1, "expo.modules.ui.ComposableSingletons$ChipViewKt.lambda$-1073824393.<anonymous> (ChipView.kt:208)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_289642877$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ChipView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(289642877, i, -1, "expo.modules.ui.ComposableSingletons$ChipViewKt.lambda$289642877.<anonymous> (ChipView.kt:271)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_1542534682$lambda$3(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ChipView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1542534682, i, -1, "expo.modules.ui.ComposableSingletons$ChipViewKt.lambda$1542534682.<anonymous> (ChipView.kt:328)");
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
