package expo.modules.ui.textfield;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasicTextField.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\f\u001a\u00020\r*\u00020\u000eH\u0017¢\u0006\u0002\u0010\u000fR\u0014\u0010\t\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lexpo/modules/ui/textfield/InnerTextFieldView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/ui/textfield/InnerTextFieldProps;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "props", "getProps", "()Lexpo/modules/ui/textfield/InnerTextFieldProps;", "Content", "", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InnerTextFieldView extends ExpoComposeView<InnerTextFieldProps> {
    public static final int $stable = ExpoComposeView.$stable;
    private final InnerTextFieldProps props;

    static final Unit Content$lambda$0(InnerTextFieldView innerTextFieldView, ComposableScope composableScope, int i, Composer composer, int i2) {
        innerTextFieldView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTextFieldView(Context context, AppContext appContext) {
        super(context, appContext, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.props = new InnerTextFieldProps();
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public InnerTextFieldProps getProps() {
        return this.props;
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(final ComposableScope composableScope, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1348114183);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)53@2138L7:BasicTextField.kt#2yem3u");
        int i2 = i & 1;
        if (!composerStartRestartGroup.shouldExecute(i2 != 0, i2)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1348114183, i, -1, "expo.modules.ui.textfield.InnerTextFieldView.Content (BasicTextField.kt:52)");
            }
            ProvidableCompositionLocal<Function2<Composer, Integer, Unit>> localInnerTextField = BasicTextFieldKt.getLocalInnerTextField();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localInnerTextField);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function2 function2 = (Function2) objConsume;
            if (function2 == null) {
                composerStartRestartGroup.startReplaceGroup(569646688);
            } else {
                composerStartRestartGroup.startReplaceGroup(1542396353);
                ComposerKt.sourceInformation(composerStartRestartGroup, "53@2147L8");
                function2.invoke(composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.textfield.InnerTextFieldView$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InnerTextFieldView.Content$lambda$0(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
