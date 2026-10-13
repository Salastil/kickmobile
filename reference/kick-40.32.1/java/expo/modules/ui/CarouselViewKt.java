package expo.modules.ui;

import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.carousel.CarouselDefaults;
import androidx.compose.material3.carousel.CarouselItemScope;
import androidx.compose.material3.carousel.CarouselKt;
import androidx.compose.material3.carousel.CarouselState;
import androidx.compose.material3.carousel.CarouselStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CarouselView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0019\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"HorizontalCenteredHeroCarouselContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/HorizontalCenteredHeroCarouselProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/HorizontalCenteredHeroCarouselProps;Landroidx/compose/runtime/Composer;I)V", "HorizontalMultiBrowseCarouselContent", "Lexpo/modules/ui/HorizontalMultiBrowseCarouselProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/HorizontalMultiBrowseCarouselProps;Landroidx/compose/runtime/Composer;I)V", "HorizontalUncontainedCarouselContent", "Lexpo/modules/ui/HorizontalUncontainedCarouselProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/HorizontalUncontainedCarouselProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CarouselViewKt {

    /* JADX INFO: compiled from: CarouselView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FlingBehaviorType.values().length];
            try {
                iArr[FlingBehaviorType.SINGLE_ADVANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlingBehaviorType.NO_SNAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final Unit HorizontalCenteredHeroCarouselContent$lambda$3(FunctionalComposableScope functionalComposableScope, HorizontalCenteredHeroCarouselProps horizontalCenteredHeroCarouselProps, int i, Composer composer, int i2) {
        HorizontalCenteredHeroCarouselContent(functionalComposableScope, horizontalCenteredHeroCarouselProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit HorizontalMultiBrowseCarouselContent$lambda$7(FunctionalComposableScope functionalComposableScope, HorizontalMultiBrowseCarouselProps horizontalMultiBrowseCarouselProps, int i, Composer composer, int i2) {
        HorizontalMultiBrowseCarouselContent(functionalComposableScope, horizontalMultiBrowseCarouselProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit HorizontalUncontainedCarouselContent$lambda$11(FunctionalComposableScope functionalComposableScope, HorizontalUncontainedCarouselProps horizontalUncontainedCarouselProps, int i, Composer composer, int i2) {
        HorizontalUncontainedCarouselContent(functionalComposableScope, horizontalUncontainedCarouselProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void HorizontalCenteredHeroCarouselContent(final FunctionalComposableScope functionalComposableScope, final HorizontalCenteredHeroCarouselProps props, Composer composer, final int i) {
        int i2;
        TargetedFlingBehavior targetedFlingBehaviorSingleAdvanceFlingBehavior;
        CarouselState carouselState;
        float fM5270getMinSmallItemSizeD9Ej5fM;
        float fM5269getMaxSmallItemSizeD9Ej5fM;
        float fM10188getUnspecifiedD9Ej5fM;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(687070273);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalCenteredHeroCarouselContent)N(props)40@1718L13,40@1693L38,51@2337L83,59@2749L74,49@2246L577:CarouselView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(687070273, i2, -1, "expo.modules.ui.HorizontalCenteredHeroCarouselContent (CarouselView.kt:38)");
            }
            PaddingValues paddingValues = PaddingValuesExtensionKt.toPaddingValues(props.getContentPadding());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1150422418, "CC(remember):CarouselView.kt#9igjgp");
            boolean z = (i2 & 14) == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(functionalComposableScope));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.CarouselViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(functionalComposableScope.getView().getChildCount());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CarouselState carouselStateRememberCarouselState = CarouselStateKt.rememberCarouselState(0, (Function0) objRememberedValue, composerStartRestartGroup, 6, 0);
            FlingBehaviorType flingBehavior = props.getFlingBehavior();
            if (flingBehavior == null) {
                flingBehavior = FlingBehaviorType.SINGLE_ADVANCE;
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[flingBehavior.ordinal()];
            if (i3 == 1) {
                composerStartRestartGroup.startReplaceGroup(-1150416590);
                ComposerKt.sourceInformation(composerStartRestartGroup, "42@1899L49");
                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselStateRememberCarouselState, null, composerStartRestartGroup, CarouselState.$stable | (CarouselDefaults.$stable << 6), 2);
                carouselState = carouselStateRememberCarouselState;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (i3 != 2) {
                    composerStartRestartGroup.startReplaceGroup(-1150420296);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(-1150413418);
                ComposerKt.sourceInformation(composerStartRestartGroup, "43@1999L21");
                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, CarouselDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
                carouselState = carouselStateRememberCarouselState;
            }
            Float minSmallItemWidth = props.getMinSmallItemWidth();
            if (minSmallItemWidth == null) {
                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
            } else {
                fM5270getMinSmallItemSizeD9Ej5fM = Dp.m10168constructorimpl(minSmallItemWidth.floatValue());
            }
            float f = fM5270getMinSmallItemSizeD9Ej5fM;
            Float maxSmallItemWidth = props.getMaxSmallItemWidth();
            if (maxSmallItemWidth == null) {
                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
            } else {
                fM5269getMaxSmallItemSizeD9Ej5fM = Dp.m10168constructorimpl(maxSmallItemWidth.floatValue());
            }
            float fM10182unboximpl = ((Dp) RangesKt.coerceAtLeast(Dp.m10166boximpl(fM5269getMaxSmallItemSizeD9Ej5fM), Dp.m10166boximpl(f))).m10182unboximpl();
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            Float maxItemWidth = props.getMaxItemWidth();
            if (maxItemWidth == null) {
                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
            } else {
                fM10188getUnspecifiedD9Ej5fM = Dp.m10168constructorimpl(maxItemWidth.floatValue());
            }
            float f2 = fM10188getUnspecifiedD9Ej5fM;
            Float itemSpacing = props.getItemSpacing();
            float fM10168constructorimpl = Dp.m10168constructorimpl(itemSpacing != null ? itemSpacing.floatValue() : 0.0f);
            Boolean userScrollEnabled = props.getUserScrollEnabled();
            CarouselKt.m5277HorizontalCenteredHeroCarouselp2lB3Bg(carouselState, modifierApplyModifiers, f2, fM10168constructorimpl, targetedFlingBehaviorSingleAdvanceFlingBehavior, userScrollEnabled != null ? userScrollEnabled.booleanValue() : true, f, fM10182unboximpl, paddingValues, ComposableLambdaKt.rememberComposableLambda(2138721725, true, new Function4() { // from class: expo.modules.ui.CarouselViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return CarouselViewKt.HorizontalCenteredHeroCarouselContent$lambda$2(functionalComposableScope, (CarouselItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368 | CarouselState.$stable, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.CarouselViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CarouselViewKt.HorizontalCenteredHeroCarouselContent$lambda$3(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit HorizontalCenteredHeroCarouselContent$lambda$2(FunctionalComposableScope functionalComposableScope, CarouselItemScope HorizontalCenteredHeroCarousel, int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(HorizontalCenteredHeroCarousel, "$this$HorizontalCenteredHeroCarousel");
        ComposerKt.sourceInformation(composer, "CN(itemIndex)60@2768L51:CarouselView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2138721725, i2, -1, "expo.modules.ui.HorizontalCenteredHeroCarouselContent.<anonymous> (CarouselView.kt:60)");
        }
        functionalComposableScope.Child(new CarouselItemComposableScope(HorizontalCenteredHeroCarousel), i, composer, (i2 & 112) | (FunctionalComposableScope.$stable << 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void HorizontalMultiBrowseCarouselContent(final FunctionalComposableScope functionalComposableScope, final HorizontalMultiBrowseCarouselProps props, Composer composer, final int i) {
        int i2;
        TargetedFlingBehavior targetedFlingBehaviorSingleAdvanceFlingBehavior;
        CarouselState carouselState;
        float fM5270getMinSmallItemSizeD9Ej5fM;
        float fM5269getMaxSmallItemSizeD9Ej5fM;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(1850455875);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalMultiBrowseCarouselContent)N(props)80@3542L13,80@3517L38,92@4214L83,99@4565L74,89@4070L569:CarouselView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1850455875, i2, -1, "expo.modules.ui.HorizontalMultiBrowseCarouselContent (CarouselView.kt:78)");
            }
            PaddingValues paddingValues = PaddingValuesExtensionKt.toPaddingValues(props.getContentPadding());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 171644080, "CC(remember):CarouselView.kt#9igjgp");
            boolean z = (i2 & 14) == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(functionalComposableScope));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.CarouselViewKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(functionalComposableScope.getView().getChildCount());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CarouselState carouselStateRememberCarouselState = CarouselStateKt.rememberCarouselState(0, (Function0) objRememberedValue, composerStartRestartGroup, 6, 0);
            FlingBehaviorType flingBehavior = props.getFlingBehavior();
            if (flingBehavior == null) {
                flingBehavior = FlingBehaviorType.SINGLE_ADVANCE;
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[flingBehavior.ordinal()];
            if (i3 == 1) {
                composerStartRestartGroup.startReplaceGroup(171649908);
                ComposerKt.sourceInformation(composerStartRestartGroup, "82@3723L49");
                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselStateRememberCarouselState, null, composerStartRestartGroup, CarouselState.$stable | (CarouselDefaults.$stable << 6), 2);
                carouselState = carouselStateRememberCarouselState;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (i3 != 2) {
                    composerStartRestartGroup.startReplaceGroup(171646202);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(171653080);
                ComposerKt.sourceInformation(composerStartRestartGroup, "83@3823L21");
                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, CarouselDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
                carouselState = carouselStateRememberCarouselState;
            }
            Float minSmallItemWidth = props.getMinSmallItemWidth();
            if (minSmallItemWidth == null) {
                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
            } else {
                fM5270getMinSmallItemSizeD9Ej5fM = Dp.m10168constructorimpl(minSmallItemWidth.floatValue());
            }
            float f = fM5270getMinSmallItemSizeD9Ej5fM;
            Float maxSmallItemWidth = props.getMaxSmallItemWidth();
            if (maxSmallItemWidth == null) {
                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
            } else {
                fM5269getMaxSmallItemSizeD9Ej5fM = Dp.m10168constructorimpl(maxSmallItemWidth.floatValue());
            }
            float fM10182unboximpl = ((Dp) RangesKt.coerceAtLeast(Dp.m10166boximpl(fM5269getMaxSmallItemSizeD9Ej5fM), Dp.m10166boximpl(f))).m10182unboximpl();
            float fM10168constructorimpl = Dp.m10168constructorimpl(props.getPreferredItemWidth());
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            Float itemSpacing = props.getItemSpacing();
            float fM10168constructorimpl2 = Dp.m10168constructorimpl(itemSpacing != null ? itemSpacing.floatValue() : 0.0f);
            Boolean userScrollEnabled = props.getUserScrollEnabled();
            CarouselKt.m5278HorizontalMultiBrowseCarousel3tcCNu0(carouselState, fM10168constructorimpl, modifierApplyModifiers, fM10168constructorimpl2, targetedFlingBehaviorSingleAdvanceFlingBehavior, userScrollEnabled != null ? userScrollEnabled.booleanValue() : true, f, fM10182unboximpl, paddingValues, ComposableLambdaKt.rememberComposableLambda(1104852090, true, new Function4() { // from class: expo.modules.ui.CarouselViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return CarouselViewKt.HorizontalMultiBrowseCarouselContent$lambda$6(functionalComposableScope, (CarouselItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368 | CarouselState.$stable, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.CarouselViewKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CarouselViewKt.HorizontalMultiBrowseCarouselContent$lambda$7(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit HorizontalMultiBrowseCarouselContent$lambda$6(FunctionalComposableScope functionalComposableScope, CarouselItemScope HorizontalMultiBrowseCarousel, int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(HorizontalMultiBrowseCarousel, "$this$HorizontalMultiBrowseCarousel");
        ComposerKt.sourceInformation(composer, "CN(itemIndex)100@4584L51:CarouselView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1104852090, i2, -1, "expo.modules.ui.HorizontalMultiBrowseCarouselContent.<anonymous> (CarouselView.kt:100)");
        }
        functionalComposableScope.Child(new CarouselItemComposableScope(HorizontalMultiBrowseCarousel), i, composer, (i2 & 112) | (FunctionalComposableScope.$stable << 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void HorizontalUncontainedCarouselContent(final FunctionalComposableScope functionalComposableScope, final HorizontalUncontainedCarouselProps props, Composer composer, final int i) {
        int i2;
        TargetedFlingBehavior targetedFlingBehaviorSingleAdvanceFlingBehavior;
        CarouselState carouselState;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1386204957);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalUncontainedCarouselContent)N(props)118@5269L13,118@5244L38,128@5787L83,133@6052L74,125@5661L465:CarouselView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1386204957, i2, -1, "expo.modules.ui.HorizontalUncontainedCarouselContent (CarouselView.kt:116)");
            }
            PaddingValues paddingValues = PaddingValuesExtensionKt.toPaddingValues(props.getContentPadding());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -703093168, "CC(remember):CarouselView.kt#9igjgp");
            boolean z = (i2 & 14) == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(functionalComposableScope));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.CarouselViewKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(functionalComposableScope.getView().getChildCount());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CarouselState carouselStateRememberCarouselState = CarouselStateKt.rememberCarouselState(0, (Function0) objRememberedValue, composerStartRestartGroup, 6, 0);
            FlingBehaviorType flingBehavior = props.getFlingBehavior();
            if (flingBehavior == null) {
                flingBehavior = FlingBehaviorType.NO_SNAP;
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[flingBehavior.ordinal()];
            if (i3 == 1) {
                composerStartRestartGroup.startReplaceGroup(-703084716);
                ComposerKt.sourceInformation(composerStartRestartGroup, "121@5532L49");
                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselStateRememberCarouselState, null, composerStartRestartGroup, CarouselState.$stable | (CarouselDefaults.$stable << 6), 2);
                carouselState = carouselStateRememberCarouselState;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (i3 != 2) {
                    composerStartRestartGroup.startReplaceGroup(-703088205);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(-703081544);
                ComposerKt.sourceInformation(composerStartRestartGroup, "122@5632L21");
                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, CarouselDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
                carouselState = carouselStateRememberCarouselState;
            }
            float fM10168constructorimpl = Dp.m10168constructorimpl(props.getItemWidth());
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            Float itemSpacing = props.getItemSpacing();
            float fM10168constructorimpl2 = Dp.m10168constructorimpl(itemSpacing != null ? itemSpacing.floatValue() : 0.0f);
            Boolean userScrollEnabled = props.getUserScrollEnabled();
            CarouselKt.m5279HorizontalUncontainedCarouselVUP9l70(carouselState, fM10168constructorimpl, modifierApplyModifiers, fM10168constructorimpl2, targetedFlingBehaviorSingleAdvanceFlingBehavior, userScrollEnabled != null ? userScrollEnabled.booleanValue() : true, paddingValues, ComposableLambdaKt.rememberComposableLambda(690856115, true, new Function4() { // from class: expo.modules.ui.CarouselViewKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return CarouselViewKt.HorizontalUncontainedCarouselContent$lambda$10(functionalComposableScope, (CarouselItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912 | CarouselState.$stable, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.CarouselViewKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CarouselViewKt.HorizontalUncontainedCarouselContent$lambda$11(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit HorizontalUncontainedCarouselContent$lambda$10(FunctionalComposableScope functionalComposableScope, CarouselItemScope HorizontalUncontainedCarousel, int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(HorizontalUncontainedCarousel, "$this$HorizontalUncontainedCarousel");
        ComposerKt.sourceInformation(composer, "CN(itemIndex)134@6071L51:CarouselView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(690856115, i2, -1, "expo.modules.ui.HorizontalUncontainedCarouselContent.<anonymous> (CarouselView.kt:134)");
        }
        functionalComposableScope.Child(new CarouselItemComposableScope(HorizontalUncontainedCarousel), i, composer, (i2 & 112) | (FunctionalComposableScope.$stable << 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
