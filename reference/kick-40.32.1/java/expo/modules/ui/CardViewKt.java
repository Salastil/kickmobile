package expo.modules.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0019\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"CardContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/CardProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/CardProps;Landroidx/compose/runtime/Composer;I)V", "ElevatedCardContent", "Lexpo/modules/ui/ElevatedCardProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/ElevatedCardProps;Landroidx/compose/runtime/Composer;I)V", "OutlinedCardContent", "Lexpo/modules/ui/OutlinedCardProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/OutlinedCardProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CardViewKt {
    static final Unit CardContent$lambda$1(FunctionalComposableScope functionalComposableScope, CardProps cardProps, int i, Composer composer, int i2) {
        CardContent(functionalComposableScope, cardProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ElevatedCardContent$lambda$3(FunctionalComposableScope functionalComposableScope, ElevatedCardProps elevatedCardProps, int i, Composer composer, int i2) {
        ElevatedCardContent(functionalComposableScope, elevatedCardProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit OutlinedCardContent$lambda$5(FunctionalComposableScope functionalComposableScope, OutlinedCardProps outlinedCardProps, int i, Composer composer, int i2) {
        OutlinedCardContent(functionalComposableScope, outlinedCardProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void CardContent(final FunctionalComposableScope functionalComposableScope, final CardProps props, Composer composer, final int i) {
        int i2;
        CardElevation cardElevationM3590cardElevationaqJV_2Y;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1121341611);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CardContent)N(props)42@1301L83,44@1416L12,45@1457L202,69@2192L79,74@2275L125:CardView.kt#v15e7d");
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
                ComposerKt.traceEventStart(-1121341611, i2, -1, "expo.modules.ui.CardContent (CardView.kt:41)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            androidx.compose.material3.CardColors cardColors = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, CardDefaults.$stable);
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColors().getContainerColor());
            long jM7348unboximpl = composeOrNull != null ? composeOrNull.m7348unboximpl() : cardColors.getContainerColor();
            Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getColors().getContentColor());
            androidx.compose.material3.CardColors cardColorsM3589cardColorsro_MJ88 = cardDefaults.m3589cardColorsro_MJ88(jM7348unboximpl, composeOrNull2 != null ? composeOrNull2.m7348unboximpl() : cardColors.getContentColor(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
            if (props.getElevation() != null) {
                composerStartRestartGroup.startReplaceGroup(368208194);
                ComposerKt.sourceInformation(composerStartRestartGroup, "53@1727L52");
                cardElevationM3590cardElevationaqJV_2Y = CardDefaults.INSTANCE.m3590cardElevationaqJV_2Y(Dp.m10168constructorimpl(props.getElevation().floatValue()), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, CardDefaults.$stable << 18, 62);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(368287399);
                ComposerKt.sourceInformation(composerStartRestartGroup, "55@1808L15");
                cardElevationM3590cardElevationaqJV_2Y = CardDefaults.INSTANCE.m3590cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, CardDefaults.$stable << 18, 63);
                composerStartRestartGroup.endReplaceGroup();
            }
            CardElevation cardElevation = cardElevationM3590cardElevationaqJV_2Y;
            BorderStroke borderStrokeM1584BorderStrokecXLIe8U = null;
            if (props.getBorder() != null) {
                composerStartRestartGroup.startReplaceGroup(368374261);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                Color composeOrNull3 = UtilsKt.getComposeOrNull(props.getBorder().getColor());
                if (composeOrNull3 != null) {
                    composerStartRestartGroup.startReplaceGroup(368453807);
                    composerStartRestartGroup.endReplaceGroup();
                    borderStrokeM1584BorderStrokecXLIe8U = BorderStrokeKt.m1584BorderStrokecXLIe8U(Dp.m10168constructorimpl(props.getBorder().getWidth()), composeOrNull3.m7348unboximpl());
                } else {
                    composerStartRestartGroup.startReplaceGroup(368522131);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "63@2081L20");
                    BorderStroke borderStroke = new BorderStroke(Dp.m10168constructorimpl(props.getBorder().getWidth()), CardDefaults.INSTANCE.outlinedCardBorder(false, composerStartRestartGroup, CardDefaults.$stable << 3, 1).getBrush(), null);
                    composerStartRestartGroup.endReplaceGroup();
                    borderStrokeM1584BorderStrokecXLIe8U = borderStroke;
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(368618975);
                composerStartRestartGroup.endReplaceGroup();
            }
            CardKt.Card(modifierApplyModifiers, null, cardColorsM3589cardColorsro_MJ88, cardElevation, borderStrokeM1584BorderStrokecXLIe8U, ComposableLambdaKt.rememberComposableLambda(1403231718, true, new Function3() { // from class: expo.modules.ui.CardViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CardViewKt.CardContent$lambda$0(functionalComposableScope, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 2);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.CardViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardViewKt.CardContent$lambda$1(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit CardContent$lambda$0(FunctionalComposableScope functionalComposableScope, ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        ComposerKt.sourceInformation(composer, "C71@2252L15:CardView.kt#v15e7d");
        if ((i & 6) == 0) {
            i |= composer.changed(columnScope) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1403231718, i, -1, "expo.modules.ui.CardContent.<anonymous> (CardView.kt:70)");
            }
            functionalComposableScope.Children(new UIComposableScope(null, columnScope, null, null, 13, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void ElevatedCardContent(final FunctionalComposableScope functionalComposableScope, final ElevatedCardProps props, Composer composer, final int i) {
        int i2;
        CardElevation cardElevationM3592elevatedCardElevationaqJV_2Y;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-124412095);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ElevatedCardContent)N(props)96@2754L83,98@2869L20,99@2918L210,112@3366L79,117@3449L112:CardView.kt#v15e7d");
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
                ComposerKt.traceEventStart(-124412095, i2, -1, "expo.modules.ui.ElevatedCardContent (CardView.kt:95)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            androidx.compose.material3.CardColors cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, CardDefaults.$stable);
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColors().getContainerColor());
            long jM7348unboximpl = composeOrNull != null ? composeOrNull.m7348unboximpl() : cardColorsElevatedCardColors.getContainerColor();
            Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getColors().getContentColor());
            androidx.compose.material3.CardColors cardColorsM3591elevatedCardColorsro_MJ88 = cardDefaults.m3591elevatedCardColorsro_MJ88(jM7348unboximpl, composeOrNull2 != null ? composeOrNull2.m7348unboximpl() : cardColorsElevatedCardColors.getContentColor(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
            if (props.getElevation() != null) {
                composerStartRestartGroup.startReplaceGroup(196599502);
                ComposerKt.sourceInformation(composerStartRestartGroup, "107@3196L60");
                cardElevationM3592elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m3592elevatedCardElevationaqJV_2Y(Dp.m10168constructorimpl(props.getElevation().floatValue()), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, CardDefaults.$stable << 18, 62);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(196686643);
                ComposerKt.sourceInformation(composerStartRestartGroup, "109@3285L23");
                cardElevationM3592elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m3592elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, CardDefaults.$stable << 18, 63);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            CardKt.ElevatedCard(modifierApplyModifiers, null, cardColorsM3591elevatedCardColorsro_MJ88, cardElevationM3592elevatedCardElevationaqJV_2Y, ComposableLambdaKt.rememberComposableLambda(430590930, true, new Function3() { // from class: expo.modules.ui.CardViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CardViewKt.ElevatedCardContent$lambda$2(functionalComposableScope, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 24576, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.CardViewKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardViewKt.ElevatedCardContent$lambda$3(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ElevatedCardContent$lambda$2(FunctionalComposableScope functionalComposableScope, ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        ComposerKt.sourceInformation(composer, "C114@3426L15:CardView.kt#v15e7d");
        if ((i & 6) == 0) {
            i |= composer.changed(columnScope) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(430590930, i, -1, "expo.modules.ui.ElevatedCardContent.<anonymous> (CardView.kt:113)");
            }
            functionalComposableScope.Children(new UIComposableScope(null, columnScope, null, null, 13, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void OutlinedCardContent(final FunctionalComposableScope functionalComposableScope, final OutlinedCardProps props, Composer composer, final int i) {
        int i2;
        CardElevation cardElevationM3594outlinedCardElevationaqJV_2Y;
        BorderStroke borderStrokeOutlinedCardBorder;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(137511889);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedCardContent)N(props)139@3949L83,141@4064L20,142@4113L210,166@4901L79,171@4984L133:CardView.kt#v15e7d");
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
                ComposerKt.traceEventStart(137511889, i2, -1, "expo.modules.ui.OutlinedCardContent (CardView.kt:138)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            androidx.compose.material3.CardColors cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, CardDefaults.$stable);
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColors().getContainerColor());
            long jM7348unboximpl = composeOrNull != null ? composeOrNull.m7348unboximpl() : cardColorsOutlinedCardColors.getContainerColor();
            Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getColors().getContentColor());
            androidx.compose.material3.CardColors cardColorsM3593outlinedCardColorsro_MJ88 = cardDefaults.m3593outlinedCardColorsro_MJ88(jM7348unboximpl, composeOrNull2 != null ? composeOrNull2.m7348unboximpl() : cardColorsOutlinedCardColors.getContentColor(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
            if (props.getElevation() != null) {
                composerStartRestartGroup.startReplaceGroup(-781569986);
                ComposerKt.sourceInformation(composerStartRestartGroup, "150@4391L60");
                cardElevationM3594outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m3594outlinedCardElevationaqJV_2Y(Dp.m10168constructorimpl(props.getElevation().floatValue()), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, CardDefaults.$stable << 18, 62);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-781482845);
                ComposerKt.sourceInformation(composerStartRestartGroup, "152@4480L23");
                cardElevationM3594outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m3594outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, CardDefaults.$stable << 18, 63);
                composerStartRestartGroup.endReplaceGroup();
            }
            CardElevation cardElevation = cardElevationM3594outlinedCardElevationaqJV_2Y;
            if (props.getBorder() != null) {
                composerStartRestartGroup.startReplaceGroup(-781388295);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                Color composeOrNull3 = UtilsKt.getComposeOrNull(props.getBorder().getColor());
                if (composeOrNull3 != null) {
                    composerStartRestartGroup.startReplaceGroup(-781308749);
                    composerStartRestartGroup.endReplaceGroup();
                    borderStrokeOutlinedCardBorder = BorderStrokeKt.m1584BorderStrokecXLIe8U(Dp.m10168constructorimpl(props.getBorder().getWidth()), composeOrNull3.m7348unboximpl());
                } else {
                    composerStartRestartGroup.startReplaceGroup(-781240425);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "160@4761L20");
                    BorderStroke borderStroke = new BorderStroke(Dp.m10168constructorimpl(props.getBorder().getWidth()), CardDefaults.INSTANCE.outlinedCardBorder(false, composerStartRestartGroup, CardDefaults.$stable << 3, 1).getBrush(), null);
                    composerStartRestartGroup.endReplaceGroup();
                    borderStrokeOutlinedCardBorder = borderStroke;
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-781142682);
                ComposerKt.sourceInformation(composerStartRestartGroup, "163@4823L20");
                borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(false, composerStartRestartGroup, CardDefaults.$stable << 3, 1);
                composerStartRestartGroup.endReplaceGroup();
            }
            CardKt.OutlinedCard(modifierApplyModifiers, null, cardColorsM3593outlinedCardColorsro_MJ88, cardElevation, borderStrokeOutlinedCardBorder, ComposableLambdaKt.rememberComposableLambda(692514914, true, new Function3() { // from class: expo.modules.ui.CardViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CardViewKt.OutlinedCardContent$lambda$4(functionalComposableScope, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 2);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.CardViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardViewKt.OutlinedCardContent$lambda$5(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit OutlinedCardContent$lambda$4(FunctionalComposableScope functionalComposableScope, ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        ComposerKt.sourceInformation(composer, "C168@4961L15:CardView.kt#v15e7d");
        if ((i & 6) == 0) {
            i |= composer.changed(columnScope) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(692514914, i, -1, "expo.modules.ui.OutlinedCardContent.<anonymous> (CardView.kt:167)");
            }
            functionalComposableScope.Children(new UIComposableScope(null, columnScope, null, null, 13, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
