package androidx.compose.foundation.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: FlexBox.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a@\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0087\b¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0001¢\u0006\u0002\u0010\u0010\u001aF\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00122\u001d\u0010\u0019\u001a\u0019\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001a¢\u0006\u0002\b\nH\u0082\b\u001ae\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001c\u001a\u00020\u00122\u001d\u0010\u0019\u001a\u0019\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001a¢\u0006\u0002\b\n2\u001d\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001a¢\u0006\u0002\b\nH\u0082\b\u001aR\u0010\"\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\u0012\u0012\u0004\u0012\u0002H#0$j\b\u0012\u0004\u0012\u0002H#`%2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00010\u0007H\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0003\u001aR\u0010)\u001a\u00020\u0012\"\u0004\b\u0000\u0010#*\u0012\u0012\u0004\u0012\u0002H#0$j\b\u0012\u0004\u0012\u0002H#`%2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00120\u0007H\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0003\"\u0014\u0010\u001e\u001a\u00020\u001fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006+"}, d2 = {"FlexBox", "", "modifier", "Landroidx/compose/ui/Modifier;", "config", "Landroidx/compose/foundation/layout/FlexBoxConfig;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlexBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/FlexBoxConfig;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "flexMultiContentMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "flexBoxConfigState", "Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "intrinsicMainAxisSize", "", "flexBoxConfig", "Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "crossAxisAvailable", "mainAxisSize", "Lkotlin/Function2;", "intrinsicCrossAxisSize", "mainAxisAvailable", "crossAxisSize", "DefaultDensity", "Landroidx/compose/ui/unit/Density;", "getDefaultDensity", "()Landroidx/compose/ui/unit/Density;", "fastForEachUntil", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fromIndex", "toIndex", "action", "fastSumBy", "selector", "foundation-layout"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class FlexBoxKt {
    private static final Density DefaultDensity = new Density() { // from class: androidx.compose.foundation.layout.FlexBoxKt$DefaultDensity$1
        private final float density = 1.0f;
        private final float fontScale = 1.0f;

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.density;
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.fontScale;
        }
    };

    public static final void FlexBox(Modifier modifier, FlexBoxConfig flexBoxConfig, Function3<? super FlexBoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2044607503, "CC(FlexBox)N(modifier,config,content)138@7604L28,142@7752L65,139@7637L187:FlexBox.kt#2w3rfo");
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            flexBoxConfig = FlexBoxConfig.INSTANCE;
        }
        int i3 = i >> 3;
        MeasurePolicy measurePolicyFlexMultiContentMeasurePolicy = flexMultiContentMeasurePolicy(SnapshotStateKt.rememberUpdatedState(flexBoxConfig, composer, i3 & 14), composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
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
        Updater.m6446setimpl(composerM6438constructorimpl, measurePolicyFlexMultiContentMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m6446setimpl(composerM6438constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m6446setimpl(composerM6438constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m6444reconcileimpl(composerM6438constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m6446setimpl(composerM6438constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, -1802593205, "C141@7715L9:FlexBox.kt#2w3rfo");
        function3.invoke(FlexBoxScopeInstance.INSTANCE, composer, Integer.valueOf((i3 & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final MeasurePolicy flexMultiContentMeasurePolicy(State<? extends FlexBoxConfig> state, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 958632450, "C(flexMultiContentMeasurePolicy)N(flexBoxConfigState)157@8149L106:FlexBox.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(958632450, i, -1, "androidx.compose.foundation.layout.flexMultiContentMeasurePolicy (FlexBox.kt:156)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2122786732, "CC(remember):FlexBox.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(state)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new FlexBoxMeasurePolicy(state);
            composer.updateRememberedValue(objRememberedValue);
        }
        FlexBoxMeasurePolicy flexBoxMeasurePolicy = (FlexBoxMeasurePolicy) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return flexBoxMeasurePolicy;
    }

    private static final int intrinsicMainAxisSize(ResolvedFlexBoxConfig resolvedFlexBoxConfig, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        if (list.isEmpty()) {
            return 0;
        }
        int iMainAxisGap = resolvedFlexBoxConfig.mainAxisGap();
        int iM2381getWrap7ziDAWk$foundation_layout = resolvedFlexBoxConfig.getWrap();
        FlexWrap.Companion companion = FlexWrap.INSTANCE;
        if (!FlexWrap.m2186equalsimpl0(iM2381getWrap7ziDAWk$foundation_layout, FlexWrap.m2184constructorimpl(1))) {
            int iM2381getWrap7ziDAWk$foundation_layout2 = resolvedFlexBoxConfig.getWrap();
            FlexWrap.Companion companion2 = FlexWrap.INSTANCE;
            if (!FlexWrap.m2186equalsimpl0(iM2381getWrap7ziDAWk$foundation_layout2, FlexWrap.m2184constructorimpl(2))) {
                int size = list.size();
                int iIntValue = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    iIntValue += function2.invoke(list.get(i2), Integer.valueOf(i)).intValue();
                }
                return iIntValue + (RangesKt.coerceAtLeast(list.size() - 1, 0) * iMainAxisGap);
            }
        }
        int size2 = list.size();
        int iMax = 0;
        for (int i3 = 0; i3 < size2; i3++) {
            iMax = Math.max(iMax, function2.invoke(list.get(i3), Integer.valueOf(i)).intValue());
        }
        return iMax;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0063  */
    /* JADX WARN: Code duplicated, block: B:15:0x006f  */
    private static final int intrinsicCrossAxisSize(ResolvedFlexBoxConfig resolvedFlexBoxConfig, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function3) {
        if (list.isEmpty()) {
            return 0;
        }
        int iMainAxisGap = resolvedFlexBoxConfig.mainAxisGap();
        int iCrossAxisGap = resolvedFlexBoxConfig.crossAxisGap();
        int size = list.size();
        int i2 = 0;
        int iMax = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i4);
            int iIntValue = function2.invoke(intrinsicMeasurable, Integer.MAX_VALUE).intValue();
            int iIntValue2 = function3.invoke(intrinsicMeasurable, Integer.valueOf(iIntValue)).intValue();
            int iM2381getWrap7ziDAWk$foundation_layout = resolvedFlexBoxConfig.getWrap();
            FlexWrap.Companion companion = FlexWrap.INSTANCE;
            if (!FlexWrap.m2186equalsimpl0(iM2381getWrap7ziDAWk$foundation_layout, FlexWrap.m2184constructorimpl(1))) {
                int iM2381getWrap7ziDAWk$foundation_layout2 = resolvedFlexBoxConfig.getWrap();
                FlexWrap.Companion companion2 = FlexWrap.INSTANCE;
                if (!FlexWrap.m2186equalsimpl0(iM2381getWrap7ziDAWk$foundation_layout2, FlexWrap.m2184constructorimpl(2))) {
                    i3 += iIntValue + iMainAxisGap;
                    iMax = Math.max(iMax, iIntValue2);
                } else if (i3 != 0 || i3 + iIntValue <= i) {
                    i3 += iIntValue + iMainAxisGap;
                    iMax = Math.max(iMax, iIntValue2);
                } else {
                    i2 += iMax + iCrossAxisGap;
                    iMax = iIntValue2;
                    i3 = iIntValue + iMainAxisGap;
                }
            } else if (i3 != 0) {
                i3 += iIntValue + iMainAxisGap;
                iMax = Math.max(iMax, iIntValue2);
            } else {
                i3 += iIntValue + iMainAxisGap;
                iMax = Math.max(iMax, iIntValue2);
            }
        }
        return i2 + iMax;
    }

    public static final Density getDefaultDensity() {
        return DefaultDensity;
    }

    private static final <T> void fastForEachUntil(ArrayList<T> arrayList, int i, int i2, Function1<? super T, Unit> function1) {
        if (i < 0 || i > arrayList.size()) {
            throw new IndexOutOfBoundsException("fromIndex (" + i + ") is out of bounds [0, " + arrayList.size() + AbstractJsonLexerKt.END_LIST);
        }
        if (i2 >= 0 && i2 <= arrayList.size()) {
            while (i < i2) {
                function1.invoke(arrayList.get(i));
                i++;
            }
        } else {
            throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is out of bounds [0, " + arrayList.size() + AbstractJsonLexerKt.END_LIST);
        }
    }

    private static final <T> int fastSumBy(ArrayList<T> arrayList, int i, int i2, Function1<? super T, Integer> function1) {
        if (i < 0 || i > arrayList.size()) {
            throw new IndexOutOfBoundsException("fromIndex (" + i + ") is out of bounds [0, " + arrayList.size() + AbstractJsonLexerKt.END_LIST);
        }
        if (i2 >= 0 && i2 <= arrayList.size()) {
            int iIntValue = 0;
            while (i < i2) {
                iIntValue += function1.invoke(arrayList.get(i)).intValue();
                i++;
            }
            return iIntValue;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is out of bounds [0, " + arrayList.size() + AbstractJsonLexerKt.END_LIST);
    }
}
