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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\f\u001a\u00020\r*\u00020\u000eH\u0017¢\u0006\u0002\u0010\u000fR\u0014\u0010\t\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lexpo/modules/ui/textfield/PlaceholderView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/ui/textfield/PlaceholderProps;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "props", "getProps", "()Lexpo/modules/ui/textfield/PlaceholderProps;", "Content", "", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaceholderView extends ExpoComposeView<PlaceholderProps> {
    public static final int $stable = ExpoComposeView.$stable;
    private final PlaceholderProps props;

    static final Unit Content$lambda$0(PlaceholderView placeholderView, ComposableScope composableScope, int i, Composer composer, int i2) {
        placeholderView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaceholderView(Context context, AppContext appContext) {
        super(context, appContext, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.props = new PlaceholderProps();
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public PlaceholderProps getProps() {
        return this.props;
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(final ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(17038963);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)80@2834L7:BasicTextField.kt#2yem3u");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(this) : composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(17038963, i2, -1, "expo.modules.ui.textfield.PlaceholderView.Content (BasicTextField.kt:79)");
            }
            ProvidableCompositionLocal<Boolean> localTextFieldIsEmpty = BasicTextFieldKt.getLocalTextFieldIsEmpty();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localTextFieldIsEmpty);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (!((Boolean) objConsume).booleanValue()) {
                composerStartRestartGroup.startReplaceGroup(798877807);
            } else {
                composerStartRestartGroup.startReplaceGroup(801699923);
                ComposerKt.sourceInformation(composerStartRestartGroup, "81@2851L14");
                Children(composableScope, composerStartRestartGroup, (i2 & 14) | (ExpoComposeView.$stable << 3) | (i2 & 112));
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.textfield.PlaceholderView$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlaceholderView.Content$lambda$0(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
