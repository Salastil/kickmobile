package expo.modules.ui;

import android.content.Context;
import android.view.View;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.ui.convertibles.ArrangementKt;
import expo.modules.ui.convertibles.HorizontalAlignment;
import expo.modules.ui.convertibles.VerticalArrangementCustom;
import expo.modules.ui.convertibles.VerticalArrangementDefault;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyColumnView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0011\u0010\u0013\u001a\u00020\u000f*\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0015R\u0014\u0010\t\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lexpo/modules/ui/LazyColumnView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/ui/LazyColumnProps;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "props", "getProps", "()Lexpo/modules/ui/LazyColumnProps;", "composableChildCount", "Landroidx/compose/runtime/MutableIntState;", "onViewAdded", "", "child", "Landroid/view/View;", "onViewRemoved", "Content", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LazyColumnView extends ExpoComposeView<LazyColumnProps> {
    public static final int $stable = ExpoComposeView.$stable;
    private final MutableIntState composableChildCount;
    private final LazyColumnProps props;

    static final Unit Content$lambda$5(LazyColumnView lazyColumnView, ComposableScope composableScope, int i, Composer composer, int i2) {
        lazyColumnView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyColumnView(Context context, AppContext appContext) {
        super(context, appContext, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.props = new LazyColumnProps(null, null, null, null, 15, null);
        this.composableChildCount = SnapshotIntStateKt.mutableIntStateOf(0);
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public LazyColumnProps getProps() {
        return this.props;
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView, android.view.ViewGroup
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        this.composableChildCount.setIntValue(getChildCount());
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView, android.view.ViewGroup
    public void onViewRemoved(View child) {
        super.onViewRemoved(child);
        this.composableChildCount.setIntValue(getChildCount());
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(final ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        Arrangement.Vertical top;
        Alignment.Horizontal start;
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(360525237);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)63@2342L21,71@2670L86,81@3145L436,70@2624L957:LazyColumnView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(this) : composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        int i3 = i2;
        boolean z = true;
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(360525237, i3, -1, "expo.modules.ui.LazyColumnView.Content (LazyColumnView.kt:62)");
            }
            setRecomposeScope(ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0));
            Either<VerticalArrangementDefault, VerticalArrangementCustom> value = getProps().getVerticalArrangement().getValue();
            if (value == null || (top = ArrangementKt.m12133toComposeArrangement(value)) == null) {
                top = Arrangement.INSTANCE.getTop();
            }
            Arrangement.Vertical vertical = top;
            HorizontalAlignment value2 = getProps().getHorizontalAlignment().getValue();
            if (value2 == null || (start = value2.toComposeAlignment()) == null) {
                start = Alignment.INSTANCE.getStart();
            }
            Alignment.Horizontal horizontal = start;
            ContentPadding value3 = getProps().getContentPadding().getValue();
            Modifier modifierLazyRecycledItemsCrossAxis = LazyItemsViewKt.lazyRecycledItemsCrossAxis(ModifierRegistry.INSTANCE.applyModifiers(getProps().getModifiers().getValue(), getAppContext(), composableScope, getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | ((i3 << 6) & 896)), this, true);
            PaddingValues paddingValuesM2346PaddingValuesa9UjIt4 = PaddingKt.m2346PaddingValuesa9UjIt4(Dp.m10168constructorimpl(value3 != null ? value3.getStart() : 0), Dp.m10168constructorimpl(value3 != null ? value3.getTop() : 0), Dp.m10168constructorimpl(value3 != null ? value3.getEnd() : 0), Dp.m10168constructorimpl(value3 != null ? value3.getBottom() : 0));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1427569655, "CC(remember):LazyColumnView.kt#9igjgp");
            if ((i3 & 112) != 32 && ((i3 & 64) == 0 || !composerStartRestartGroup.changedInstance(this))) {
                z = false;
            }
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(composableScope) | z;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.LazyColumnView$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LazyColumnView.Content$lambda$4$lambda$3(this.f$0, composableScope, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LazyDslKt.LazyColumn(modifierLazyRecycledItemsCrossAxis, null, paddingValuesM2346PaddingValuesa9UjIt4, false, vertical, horizontal, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, 458);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.LazyColumnView$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LazyColumnView.Content$lambda$5(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit Content$lambda$4$lambda$3(LazyColumnView lazyColumnView, final ComposableScope composableScope, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        int intValue = lazyColumnView.composableChildCount.getIntValue();
        int i = 0;
        while (i < intValue) {
            View childAt = lazyColumnView.getChildAt(i);
            final ExpoComposeView expoComposeView = childAt instanceof ExpoComposeView ? (ExpoComposeView) childAt : null;
            if (expoComposeView == null) {
                lazyListScope = LazyColumn;
            } else if (expoComposeView instanceof LazyItemsView) {
                LazyItemsViewKt.lazyRecycledItems(LazyColumn, (LazyItemsView) expoComposeView, composableScope, true);
                lazyListScope = LazyColumn;
            } else {
                lazyListScope = LazyColumn;
                LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-419189588, true, new Function3() { // from class: expo.modules.ui.LazyColumnView$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return LazyColumnView.Content$lambda$4$lambda$3$lambda$2(composableScope, expoComposeView, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }), 3, null);
            }
            i++;
            LazyColumn = lazyListScope;
        }
        return Unit.INSTANCE;
    }

    static final Unit Content$lambda$4$lambda$3$lambda$2(ComposableScope composableScope, ExpoComposeView expoComposeView, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C:LazyColumnView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-419189588, i, -1, "expo.modules.ui.LazyColumnView.Content.<anonymous>.<anonymous>.<anonymous> (LazyColumnView.kt:90)");
            }
            composer.startReplaceGroup(885733247);
            ComposerKt.sourceInformation(composer, "*92@3522L9");
            expoComposeView.Content(composableScope, composer, ExpoComposeView.$stable << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
