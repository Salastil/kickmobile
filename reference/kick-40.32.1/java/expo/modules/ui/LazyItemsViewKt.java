package expo.modules.ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyItemsView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\r"}, d2 = {"lazyRecycledItems", "", "Landroidx/compose/foundation/lazy/LazyListScope;", "view", "Lexpo/modules/ui/LazyItemsView;", PermissionsResponse.SCOPE_KEY, "Lexpo/modules/kotlin/views/ComposableScope;", "isVertical", "", "lazyRecycledItemsCrossAxis", "Landroidx/compose/ui/Modifier;", "list", "Landroid/view/ViewGroup;", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LazyItemsViewKt {
    public static final void lazyRecycledItems(LazyListScope lazyListScope, final LazyItemsView view, final ComposableScope scope, final boolean z) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(scope, "scope");
        final List<String> value = view.getProps().getItemKeys().getValue();
        final int iIntValue = view.getProps().getRevision().getValue().intValue();
        final double dDoubleValue = view.getProps().getEstimatedItemSize().getValue().doubleValue();
        if (value.isEmpty()) {
            return;
        }
        final LazyItemsWindow window = view.getWindow();
        LazyListScope.items$default(lazyListScope, value.size(), new Function1() { // from class: expo.modules.ui.LazyItemsViewKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return value.get(((Integer) obj).intValue());
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(1931068337, true, new Function4() { // from class: expo.modules.ui.LazyItemsViewKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return LazyItemsViewKt.lazyRecycledItems$lambda$12(value, iIntValue, window, view, z, dDoubleValue, scope, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 4, null);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00f8  */
    static final Unit lazyRecycledItems$lambda$12(final List list, final int i, final LazyItemsWindow lazyItemsWindow, LazyItemsView lazyItemsView, final boolean z, double d, ComposableScope composableScope, LazyItemScope items, final int i2, Composer composer, int i3) {
        int i4;
        Object obj;
        final String str;
        final Object obj2;
        LazyItemsSlotView lazyItemsSlotView;
        final LazyItemsSlotView lazyItemsSlotView2;
        Modifier modifierM2422width3ABfNKs;
        MutableIntState slotCount;
        Intrinsics.checkNotNullParameter(items, "$this$items");
        ComposerKt.sourceInformation(composer, "CN(index)151@5041L44,152@5114L119,152@5090L143,171@5732L7,176@5905L255,175@5860L674:LazyItemsView.kt#v15e7d");
        if ((i3 & 48) == 0) {
            i4 = i3 | (composer.changed(i2) ? 32 : 16);
        } else {
            i4 = i3;
        }
        if (!composer.shouldExecute((i4 & 145) != 144, i4 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1931068337, i4, -1, "expo.modules.ui.lazyRecycledItems.<anonymous> (LazyItemsView.kt:150)");
            }
            String str2 = (String) list.get(i2);
            ComposerKt.sourceInformationMarkerStart(composer, 330801853, "CC(remember):LazyItemsView.kt#9igjgp");
            int i5 = i4 & 112;
            boolean zChanged = composer.changed(str2) | (i5 == 32) | composer.changed(i);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Object();
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 330804264, "CC(remember):LazyItemsView.kt#9igjgp");
            boolean zChangedInstance = (i5 == 32) | composer.changedInstance(lazyItemsWindow) | composer.changed(str2) | composer.changedInstance(objRememberedValue) | composer.changed(i) | composer.changedInstance(list);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                str = str2;
                obj2 = objRememberedValue;
                obj = new Function1() { // from class: expo.modules.ui.LazyItemsViewKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return LazyItemsViewKt.lazyRecycledItems$lambda$12$lambda$4$lambda$3(lazyItemsWindow, str, i2, obj2, i, list, (DisposableEffectScope) obj3);
                    }
                };
                composer.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue2;
                str = str2;
                obj2 = objRememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.DisposableEffect(obj2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) obj, composer, 0);
            LazyItemsPoolView value = lazyItemsView.getPool$expo_ui_release().getValue();
            int intValue = (value == null || (slotCount = value.getSlotCount()) == null) ? 0 : slotCount.getIntValue();
            if (value == null || intValue <= 0) {
                lazyItemsSlotView = null;
            } else {
                View childAt = value.getChildAt(i2 % intValue);
                if (childAt instanceof LazyItemsSlotView) {
                    lazyItemsSlotView = (LazyItemsSlotView) childAt;
                } else {
                    lazyItemsSlotView = null;
                }
            }
            if (lazyItemsSlotView == null || !Intrinsics.areEqual(lazyItemsSlotView.getProps().getItemKey().getValue(), str) || lazyItemsSlotView.getProps().getIndex().getValue().intValue() != i2 || lazyItemsSlotView.getProps().getRevision().getValue().intValue() != i) {
                lazyItemsSlotView = null;
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) objConsume;
            float fMo1731toDpu2uoSUM = density.mo1731toDpu2uoSUM(lazyItemsWindow.size(str, density.mo1728roundToPx0680j_4(Dp.m10168constructorimpl((float) d))));
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 330829712, "CC(remember):LazyItemsView.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(lazyItemsSlotView) | composer.changedInstance(lazyItemsWindow) | composer.changed(str) | composer.changed(z) | composer.changed(i);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                final String str3 = str;
                lazyItemsSlotView2 = lazyItemsSlotView;
                Object obj3 = new Function1() { // from class: expo.modules.ui.LazyItemsViewKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        return LazyItemsViewKt.lazyRecycledItems$lambda$12$lambda$8$lambda$7(lazyItemsSlotView2, lazyItemsWindow, str3, z, i, (IntSize) obj4);
                    }
                };
                composer.updateRememberedValue(obj3);
                objRememberedValue3 = obj3;
            } else {
                lazyItemsSlotView2 = lazyItemsSlotView;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(companion, (Function1) objRememberedValue3);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierOnSizeChanged);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6438constructorimpl = Updater.m6438constructorimpl(composer);
            Updater.m6446setimpl(composerM6438constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6446setimpl(composerM6438constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6446setimpl(composerM6438constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6444reconcileimpl(composerM6438constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6446setimpl(composerM6438constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1440714231, "C:LazyItemsView.kt#v15e7d");
            if (lazyItemsSlotView2 != null) {
                composer.startReplaceGroup(1440727250);
                ComposerKt.sourceInformation(composer, "");
                composer.startReplaceGroup(-507713220);
                ComposerKt.sourceInformation(composer, "*193@6258L9");
                lazyItemsSlotView2.Content(composableScope, composer, ExpoComposeView.$stable << 3);
                composer.endReplaceGroup();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1440837238);
                ComposerKt.sourceInformation(composer, "197@6313L207");
                if (z) {
                    modifierM2422width3ABfNKs = SizeKt.m2403height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), fMo1731toDpu2uoSUM);
                } else {
                    modifierM2422width3ABfNKs = SizeKt.m2422width3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), fMo1731toDpu2uoSUM);
                }
                SpacerKt.Spacer(modifierM2422width3ABfNKs, composer, 0);
                composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final DisposableEffectResult lazyRecycledItems$lambda$12$lambda$4$lambda$3(final LazyItemsWindow lazyItemsWindow, final String str, int i, final Object obj, int i2, List list, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        lazyItemsWindow.appear(str, i, obj, i2, list);
        return new DisposableEffectResult() { // from class: expo.modules.ui.LazyItemsViewKt$lazyRecycledItems$lambda$12$lambda$4$lambda$3$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                lazyItemsWindow.disappear(str, obj);
            }
        };
    }

    static final Unit lazyRecycledItems$lambda$12$lambda$8$lambda$7(LazyItemsSlotView lazyItemsSlotView, LazyItemsWindow lazyItemsWindow, String str, boolean z, int i, IntSize intSize) {
        long jM10343unboximpl;
        if (lazyItemsSlotView != null) {
            if (z) {
                jM10343unboximpl = intSize.m10343unboximpl() & 4294967295L;
            } else {
                jM10343unboximpl = intSize.m10343unboximpl() >> 32;
            }
            lazyItemsWindow.measure(str, (int) jM10343unboximpl, i);
        }
        return Unit.INSTANCE;
    }

    public static final Modifier lazyRecycledItemsCrossAxis(Modifier modifier, final ViewGroup list, final boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(list, "list");
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: expo.modules.ui.LazyItemsViewKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return LazyItemsViewKt.lazyRecycledItemsCrossAxis$lambda$14(z, list, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    static final MeasureResult lazyRecycledItemsCrossAxis$lambda$14(boolean z, ViewGroup viewGroup, MeasureScope layout, Measurable measurable, Constraints constraints) {
        int iM10120getMaxHeightimpl;
        LazyItemsWindow window;
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (z) {
            iM10120getMaxHeightimpl = Constraints.m10121getMaxWidthimpl(constraints.getValue());
        } else {
            iM10120getMaxHeightimpl = Constraints.m10120getMaxHeightimpl(constraints.getValue());
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            LazyItemsView lazyItemsView = childAt instanceof LazyItemsView ? (LazyItemsView) childAt : null;
            if (lazyItemsView != null && (window = lazyItemsView.getWindow()) != null) {
                window.updateCrossAxisSize(iM10120getMaxHeightimpl);
            }
        }
        final Placeable placeableMo8808measureBRTryo0 = measurable.mo8808measureBRTryo0(constraints.getValue());
        return MeasureScope.layout$default(layout, placeableMo8808measureBRTryo0.getWidth(), placeableMo8808measureBRTryo0.getHeight(), null, new Function1() { // from class: expo.modules.ui.LazyItemsViewKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyItemsViewKt.lazyRecycledItemsCrossAxis$lambda$14$lambda$13(placeableMo8808measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit lazyRecycledItemsCrossAxis$lambda$14$lambda$13(Placeable placeable, Placeable.PlacementScope layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Placeable.PlacementScope.place$default(layout, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
