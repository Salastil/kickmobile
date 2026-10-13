package expo.modules.ui;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyItemsView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0011\u0010\u0015\u001a\u00020\u0011*\u00020\u0016H\u0017¢\u0006\u0002\u0010\u0017R\u0014\u0010\t\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lexpo/modules/ui/LazyItemsPoolView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/ui/LazyItemsPoolProps;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "props", "getProps", "()Lexpo/modules/ui/LazyItemsPoolProps;", "slotCount", "Landroidx/compose/runtime/MutableIntState;", "getSlotCount$expo_ui_release", "()Landroidx/compose/runtime/MutableIntState;", "onViewAdded", "", "child", "Landroid/view/View;", "onViewRemoved", "Content", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LazyItemsPoolView extends ExpoComposeView<LazyItemsPoolProps> {
    public static final int $stable = ExpoComposeView.$stable;
    private final LazyItemsPoolProps props;
    private final MutableIntState slotCount;

    static final Unit Content$lambda$0(LazyItemsPoolView lazyItemsPoolView, ComposableScope composableScope, int i, Composer composer, int i2) {
        lazyItemsPoolView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyItemsPoolView(Context context, AppContext appContext) {
        super(context, appContext, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.props = new LazyItemsPoolProps();
        this.slotCount = SnapshotIntStateKt.mutableIntStateOf(0);
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public LazyItemsPoolProps getProps() {
        return this.props;
    }

    /* JADX INFO: renamed from: getSlotCount$expo_ui_release, reason: from getter */
    public final MutableIntState getSlotCount() {
        return this.slotCount;
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView, android.view.ViewGroup
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        this.slotCount.setIntValue(getChildCount());
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView, android.view.ViewGroup
    public void onViewRemoved(View child) {
        super.onViewRemoved(child);
        this.slotCount.setIntValue(getChildCount());
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(final ComposableScope composableScope, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(1135709665);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content):LazyItemsView.kt#v15e7d");
        int i2 = i & 1;
        if (composerStartRestartGroup.shouldExecute(i2 != 0, i2)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1135709665, i, -1, "expo.modules.ui.LazyItemsPoolView.Content (LazyItemsView.kt:107)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.LazyItemsPoolView$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LazyItemsPoolView.Content$lambda$0(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
