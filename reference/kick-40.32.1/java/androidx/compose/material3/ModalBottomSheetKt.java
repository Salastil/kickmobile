package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\u001aË\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a-\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u000b2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000b0\u001aH\u0007¢\u0006\u0002\u0010#¨\u0006$²\u0006\n\u0010%\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020'X\u008a\u0084\u0002"}, d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "sheetGesturesEnabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-YbuCTN8", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FZLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3", "isScrimVisible", "scrimAlpha", ""}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ModalBottomSheetKt {
    static final Unit ModalBottomSheet_YbuCTN8$lambda$5(Function0 function0, Modifier modifier, SheetState sheetState, float f, boolean z, Shape shape, long j, long j2, float f2, long j3, Function2 function2, Function2 function3, ModalBottomSheetProperties modalBottomSheetProperties, Function3 function4, int i, int i2, int i3, Composer composer, int i4) {
        m4353ModalBottomSheetYbuCTN8(function0, modifier, sheetState, f, z, shape, j, j2, f2, j3, function2, function3, modalBottomSheetProperties, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberModalBottomSheetState$lambda$0$0(SheetValue sheetValue) {
        return true;
    }

    static final WindowInsets ModalBottomSheet_YbuCTN8$lambda$0(Composer composer, int i) {
        composer.startReplaceGroup(-511854661);
        ComposerKt.sourceInformation(composer, "C104@5508L17:ModalBottomSheet.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511854661, i, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.kt:104)");
        }
        WindowInsets modalWindowInsets = BottomSheetDefaults.INSTANCE.getModalWindowInsets(composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modalWindowInsets;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x012c  */
    /* JADX WARN: Code duplicated, block: B:104:0x0130  */
    /* JADX WARN: Code duplicated, block: B:107:0x0136  */
    /* JADX WARN: Code duplicated, block: B:108:0x013f  */
    /* JADX WARN: Code duplicated, block: B:110:0x0143  */
    /* JADX WARN: Code duplicated, block: B:112:0x014d  */
    /* JADX WARN: Code duplicated, block: B:113:0x0150  */
    /* JADX WARN: Code duplicated, block: B:115:0x0155  */
    /* JADX WARN: Code duplicated, block: B:118:0x015f  */
    /* JADX WARN: Code duplicated, block: B:120:0x0163  */
    /* JADX WARN: Code duplicated, block: B:123:0x016e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:126:0x0175  */
    /* JADX WARN: Code duplicated, block: B:129:0x017d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0182  */
    /* JADX WARN: Code duplicated, block: B:132:0x0188  */
    /* JADX WARN: Code duplicated, block: B:134:0x0190  */
    /* JADX WARN: Code duplicated, block: B:135:0x0193  */
    /* JADX WARN: Code duplicated, block: B:140:0x019e  */
    /* JADX WARN: Code duplicated, block: B:142:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:144:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:147:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:151:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:154:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:156:0x01db  */
    /* JADX WARN: Code duplicated, block: B:178:0x0225 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:179:0x0227  */
    /* JADX WARN: Code duplicated, block: B:182:0x0230  */
    /* JADX WARN: Code duplicated, block: B:184:0x023b  */
    /* JADX WARN: Code duplicated, block: B:185:0x0242  */
    /* JADX WARN: Code duplicated, block: B:187:0x0246  */
    /* JADX WARN: Code duplicated, block: B:190:0x024b  */
    /* JADX WARN: Code duplicated, block: B:193:0x025a  */
    /* JADX WARN: Code duplicated, block: B:196:0x0269  */
    /* JADX WARN: Code duplicated, block: B:197:0x0276  */
    /* JADX WARN: Code duplicated, block: B:199:0x027a  */
    /* JADX WARN: Code duplicated, block: B:200:0x0280  */
    /* JADX WARN: Code duplicated, block: B:203:0x0286  */
    /* JADX WARN: Code duplicated, block: B:204:0x0291  */
    /* JADX WARN: Code duplicated, block: B:206:0x0295  */
    /* JADX WARN: Code duplicated, block: B:207:0x029c  */
    /* JADX WARN: Code duplicated, block: B:210:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:211:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:214:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:215:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:219:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:222:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:225:0x0324  */
    /* JADX WARN: Code duplicated, block: B:229:0x032e  */
    /* JADX WARN: Code duplicated, block: B:231:0x0334 A[PHI: r39
      0x0334: PHI (r39v5 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, ? extends androidx.compose.foundation.layout.WindowInsets>) = 
      (r39v2 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, ? extends androidx.compose.foundation.layout.WindowInsets>)
      (r39v6 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, ? extends androidx.compose.foundation.layout.WindowInsets>)
     binds: [B:230:0x0332, B:228:0x032b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:232:0x0336  */
    /* JADX WARN: Code duplicated, block: B:235:0x0343  */
    /* JADX WARN: Code duplicated, block: B:236:0x0345  */
    /* JADX WARN: Code duplicated, block: B:239:0x0350  */
    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    /* JADX WARN: Code duplicated, block: B:242:0x035b  */
    /* JADX WARN: Code duplicated, block: B:246:0x0374  */
    /* JADX WARN: Code duplicated, block: B:250:0x037e  */
    /* JADX WARN: Code duplicated, block: B:252:0x0384 A[PHI: r41
      0x0384: PHI (r41v3 java.lang.String) = (r41v1 java.lang.String), (r41v4 java.lang.String) binds: [B:251:0x0382, B:249:0x037b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:253:0x0386  */
    /* JADX WARN: Code duplicated, block: B:256:0x0390  */
    /* JADX WARN: Code duplicated, block: B:257:0x0392  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:260:0x039a  */
    /* JADX WARN: Code duplicated, block: B:262:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:265:0x040b  */
    /* JADX WARN: Code duplicated, block: B:267:0x0424  */
    /* JADX WARN: Code duplicated, block: B:269:0x042a  */
    /* JADX WARN: Code duplicated, block: B:275:0x0437  */
    /* JADX WARN: Code duplicated, block: B:277:0x043f  */
    /* JADX WARN: Code duplicated, block: B:279:0x045b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0052  */
    /* JADX WARN: Code duplicated, block: B:282:0x046a  */
    /* JADX WARN: Code duplicated, block: B:284:0x047e  */
    /* JADX WARN: Code duplicated, block: B:287:0x049a  */
    /* JADX WARN: Code duplicated, block: B:289:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x0083  */
    /* JADX WARN: Code duplicated, block: B:46:0x0086  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0092  */
    /* JADX WARN: Code duplicated, block: B:51:0x0095  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00be  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:76:0x00de  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:80:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:88:0x0104  */
    /* JADX WARN: Code duplicated, block: B:90:0x010a  */
    /* JADX WARN: Code duplicated, block: B:92:0x0110  */
    /* JADX WARN: Code duplicated, block: B:93:0x0113  */
    /* JADX WARN: Code duplicated, block: B:97:0x011d  */
    /* JADX WARN: Code duplicated, block: B:99:0x0123  */
    /* JADX INFO: renamed from: ModalBottomSheet-YbuCTN8, reason: not valid java name */
    public static final void m4353ModalBottomSheetYbuCTN8(final Function0<Unit> function0, Modifier modifier, SheetState sheetState, float f, boolean z, Shape shape, long j, long j2, float f2, long j3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, ? extends WindowInsets> function3, ModalBottomSheetProperties modalBottomSheetProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        final SheetState sheetStateRememberModalBottomSheetState;
        int i5;
        int i6;
        int i7;
        boolean z2;
        int i8;
        Shape expandedShape;
        long containerColor;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z3;
        Composer composer2;
        final float f3;
        long j4;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function6;
        final ModalBottomSheetProperties modalBottomSheetProperties2;
        final long j5;
        final boolean z4;
        final Shape shape2;
        final SheetState sheetState2;
        final long j6;
        final float f4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float fM3513getSheetMaxWidthD9Ej5fM;
        long jM3712contentColorForek8zF_U;
        final float fM10168constructorimpl;
        long scrimColor;
        Function2<? super Composer, ? super Integer, Unit> lambda$1121996006$material3;
        Function2<? super Composer, ? super Integer, ? extends WindowInsets> function7;
        int i20;
        ModalBottomSheetProperties modalBottomSheetProperties3;
        float f5;
        final boolean z5;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        long j7;
        Object objRememberedValue;
        final CoroutineScope coroutineScope;
        int i21;
        Function2<? super Composer, ? super Integer, ? extends WindowInsets> function9;
        boolean z6;
        int i22;
        boolean z7;
        boolean z8;
        Object objRememberedValue2;
        float f6;
        String str;
        boolean z9;
        boolean z10;
        boolean z11;
        Object objRememberedValue3;
        String str2;
        int i23;
        final SheetState sheetState3;
        boolean z12;
        ModalBottomSheetKt$ModalBottomSheet$3$1 modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue;
        int i24;
        int i25;
        int i26;
        int i27;
        Composer composerStartRestartGroup = composer.startRestartGroup(1904798512);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalBottomSheet)N(onDismissRequest,modifier,sheetState,sheetMaxWidth:c#ui.unit.Dp,sheetGesturesEnabled,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,scrimColor:c#ui.graphics.Color,dragHandle,contentWindowInsets,properties,content)108@5673L24,109@5737L304,121@6081L602,136@6833L1605,132@6689L1749:ModalBottomSheet.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i28 = i3 & 2;
        if (i28 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i3 & 4) == 0) {
                    sheetStateRememberModalBottomSheetState = sheetState;
                    int i29 = composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState) ? 256 : 128;
                    i4 |= i29;
                } else {
                    sheetStateRememberModalBottomSheetState = sheetState;
                }
                i4 |= i29;
            } else {
                sheetStateRememberModalBottomSheetState = sheetState;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 16;
                if (i7 != 0) {
                    if ((i & 24576) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i4 |= i8;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        expandedShape = shape;
                        if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(expandedShape)) {
                            i27 = 65536;
                        } else {
                            i27 = 131072;
                        }
                        i4 |= i27;
                    } else {
                        expandedShape = shape;
                    }
                    if ((i & 1572864) == 0) {
                        containerColor = j;
                        if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(containerColor)) {
                            i26 = 524288;
                        } else {
                            i26 = 1048576;
                        }
                        i4 |= i26;
                    } else {
                        containerColor = j;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i3 & 128) == 0) {
                            i25 = i4;
                            int i30 = composerStartRestartGroup.changed(j2) ? 8388608 : 4194304;
                            i9 = i25 | i30;
                        } else {
                            i25 = i4;
                        }
                        i9 = i25 | i30;
                    } else {
                        i9 = i4;
                    }
                    i10 = i3 & 256;
                    if (i10 != 0) {
                        i9 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i11 = 67108864;
                        } else {
                            i11 = GroupFlagsKt.HasAuxSlotFlag;
                        }
                        i9 |= i11;
                    }
                    if ((i & 805306368) != 0) {
                        if ((i3 & 512) == 0 || !composerStartRestartGroup.changed(j3)) {
                            i24 = 268435456;
                        } else {
                            i24 = 536870912;
                        }
                        i9 |= i24;
                    }
                    i12 = i3 & 1024;
                    if (i12 != 0) {
                        i13 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i14 = 4;
                        } else {
                            i14 = 2;
                        }
                        i13 = i2 | i14;
                    } else {
                        i13 = i2;
                    }
                    if ((i2 & 48) != 0) {
                        i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
                    }
                    i15 = i13;
                    i16 = i3 & 4096;
                    if (i16 != 0) {
                        i17 = i15;
                        if ((i2 & 384) == 0) {
                            if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                                i18 = 256;
                            } else {
                                i18 = 128;
                            }
                            i17 |= i18;
                        }
                        if ((i2 & 3072) != 0) {
                            i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                        }
                        i19 = i17;
                        if ((i9 & 306783379) == 306783378 || (i19 & 1171) != 1170) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i28 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 4) != 0) {
                                    i9 &= -897;
                                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                                }
                                if (i5 != 0) {
                                    fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                                } else {
                                    fM3513getSheetMaxWidthD9Ej5fM = f;
                                }
                                if (i7 != 0) {
                                    z2 = true;
                                }
                                if ((i3 & 32) != 0) {
                                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                    i9 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i9 &= -3670017;
                                }
                                if ((i3 & 128) != 0) {
                                    jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                    i9 &= -29360129;
                                } else {
                                    jM3712contentColorForek8zF_U = j2;
                                }
                                if (i10 != 0) {
                                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                                } else {
                                    fM10168constructorimpl = f2;
                                }
                                if ((i3 & 512) != 0) {
                                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                    i9 &= -1879048193;
                                } else {
                                    scrimColor = j3;
                                }
                                if (i12 != 0) {
                                    lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                                } else {
                                    lambda$1121996006$material3 = function2;
                                }
                                if ((i3 & 2048) != 0) {
                                    function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    };
                                    i19 &= -113;
                                } else {
                                    function7 = function3;
                                }
                                i20 = i19;
                                if (i16 != 0) {
                                    modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                    i19 = i20;
                                } else {
                                    modalBottomSheetProperties3 = modalBottomSheetProperties;
                                }
                                long j8 = containerColor;
                                f5 = fM3513getSheetMaxWidthD9Ej5fM;
                                z5 = z2;
                                function8 = lambda$1121996006$material3;
                                j7 = j8;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i9 &= -897;
                                }
                                if ((i3 & 32) != 0) {
                                    i9 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    i9 &= -3670017;
                                }
                                if ((i3 & 128) != 0) {
                                    i9 &= -29360129;
                                }
                                if ((i3 & 512) != 0) {
                                    i9 &= -1879048193;
                                }
                                if ((i3 & 2048) != 0) {
                                    i19 &= -113;
                                }
                                jM3712contentColorForek8zF_U = j2;
                                fM10168constructorimpl = f2;
                                scrimColor = j3;
                                function7 = function3;
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                                i9 = i9;
                                j7 = containerColor;
                                z5 = z2;
                                f5 = f;
                                function8 = function2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            coroutineScope = (CoroutineScope) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i31 = i19;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            i21 = (i9 & 896) ^ 384;
                            final ModalBottomSheetProperties modalBottomSheetProperties4 = modalBottomSheetProperties3;
                            if (i21 > 256 || !composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) {
                                function9 = function7;
                                if ((i9 & 384) != 256) {
                                    z6 = false;
                                }
                                boolean zChangedInstance = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                                i22 = i9 & 14;
                                if (i22 == 4) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                z8 = zChangedInstance | z7;
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (z8) {
                                    f6 = f5;
                                } else {
                                    f6 = f5;
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    }
                                    final Function0 function1 = (Function0) objRememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                                    if (i21 > 256 || !composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) {
                                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                        if ((i9 & 384) != 256) {
                                            z9 = false;
                                        }
                                        boolean zChangedInstance2 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                                        if (i22 == 4) {
                                            z10 = true;
                                        } else {
                                            z10 = false;
                                        }
                                        z11 = zChangedInstance2 | z10;
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (!z11 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                        }
                                        Function0 function10 = (Function0) objRememberedValue3;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        final float f7 = f6;
                                        str2 = str;
                                        i23 = i9;
                                        final Modifier modifier3 = modifier2;
                                        final long j9 = scrimColor;
                                        final Shape shape3 = expandedShape;
                                        sheetState3 = sheetStateRememberModalBottomSheetState;
                                        final long j10 = j7;
                                        final long j11 = jM3712contentColorForek8zF_U;
                                        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function11 = function9;
                                        Function2 function12 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj, Object obj2) {
                                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties4, function1, j9, modifier3, function0, f7, z5, function8, function11, shape3, j10, j11, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                                            }
                                        };
                                        composer2 = composerStartRestartGroup;
                                        z12 = true;
                                        ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function10, j11, modalBottomSheetProperties4, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function12, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i31 & 896), 0);
                                        if (sheetState3.getHasExpandedState()) {
                                            composer2.startReplaceGroup(748177042);
                                            ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                                            ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                                            if ((i21 > 256 || !composer2.changed(sheetState3)) && (i23 & 384) != 256) {
                                            }
                                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                                            if (!z12 || modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composer2);
                                            EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                                            composer2.endReplaceGroup();
                                        } else {
                                            composer2.startReplaceGroup(748238546);
                                            composer2.endReplaceGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier2 = modifier3;
                                        shape2 = shape3;
                                        sheetState2 = sheetState3;
                                        f3 = f7;
                                        z4 = z5;
                                        j5 = j10;
                                        function5 = function8;
                                        j6 = j11;
                                        modalBottomSheetProperties2 = modalBottomSheetProperties4;
                                        function6 = function11;
                                        f4 = fM10168constructorimpl;
                                        j4 = j9;
                                    } else {
                                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                    }
                                    z9 = true;
                                    boolean zChangedInstance3 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                                    if (i22 == 4) {
                                        z10 = true;
                                    } else {
                                        z10 = false;
                                    }
                                    z11 = zChangedInstance3 | z10;
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (!z11) {
                                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    } else {
                                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    Function0 function13 = (Function0) objRememberedValue3;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    final float f8 = f6;
                                    str2 = str;
                                    i23 = i9;
                                    final Modifier modifier4 = modifier2;
                                    final long j12 = scrimColor;
                                    final Shape shape4 = expandedShape;
                                    sheetState3 = sheetStateRememberModalBottomSheetState;
                                    final long j13 = j7;
                                    final long j14 = jM3712contentColorForek8zF_U;
                                    final Function2 function14 = function9;
                                    Function2 function15 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties4, function1, j12, modifier4, function0, f8, z5, function8, function14, shape4, j13, j14, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    };
                                    composer2 = composerStartRestartGroup;
                                    z12 = true;
                                    ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function13, j14, modalBottomSheetProperties4, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function15, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i31 & 896), 0);
                                    if (sheetState3.getHasExpandedState()) {
                                        composer2.startReplaceGroup(748177042);
                                        ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                                        ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                                        z12 = i21 > 256 ? false : false;
                                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                                        if (!z12) {
                                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                        } else {
                                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                                        composer2.endReplaceGroup();
                                    } else {
                                        composer2.startReplaceGroup(748238546);
                                        composer2.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier4;
                                    shape2 = shape4;
                                    sheetState2 = sheetState3;
                                    f3 = f8;
                                    z4 = z5;
                                    j5 = j13;
                                    function5 = function8;
                                    j6 = j14;
                                    modalBottomSheetProperties2 = modalBottomSheetProperties4;
                                    function6 = function14;
                                    f4 = fM10168constructorimpl;
                                    j4 = j12;
                                }
                                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                final Function0 function16 = (Function0) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                                if (i21 > 256) {
                                    str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                    if ((i9 & 384) != 256) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                } else {
                                    str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                    if ((i9 & 384) != 256) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                }
                                boolean zChangedInstance4 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                                if (i22 == 4) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                z11 = zChangedInstance4 | z10;
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!z11) {
                                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                } else {
                                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                Function0 function17 = (Function0) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                final float f9 = f6;
                                str2 = str;
                                i23 = i9;
                                final Modifier modifier5 = modifier2;
                                final long j15 = scrimColor;
                                final Shape shape5 = expandedShape;
                                sheetState3 = sheetStateRememberModalBottomSheetState;
                                final long j16 = j7;
                                final long j17 = jM3712contentColorForek8zF_U;
                                final Function2 function18 = function9;
                                Function2 function19 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties4, function16, j15, modifier5, function0, f9, z5, function8, function18, shape5, j16, j17, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                composer2 = composerStartRestartGroup;
                                z12 = true;
                                ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function17, j17, modalBottomSheetProperties4, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function19, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i31 & 896), 0);
                                if (sheetState3.getHasExpandedState()) {
                                    composer2.startReplaceGroup(748177042);
                                    ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                                    ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                                    if (i21 > 256) {
                                    }
                                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                                    if (!z12) {
                                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                        composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                    } else {
                                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                        composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                                    composer2.endReplaceGroup();
                                } else {
                                    composer2.startReplaceGroup(748238546);
                                    composer2.endReplaceGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier5;
                                shape2 = shape5;
                                sheetState2 = sheetState3;
                                f3 = f9;
                                z4 = z5;
                                j5 = j16;
                                function5 = function8;
                                j6 = j17;
                                modalBottomSheetProperties2 = modalBottomSheetProperties4;
                                function6 = function18;
                                f4 = fM10168constructorimpl;
                                j4 = j15;
                            } else {
                                function9 = function7;
                            }
                            z6 = true;
                            boolean zChangedInstance5 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                            i22 = i9 & 14;
                            if (i22 == 4) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            z8 = zChangedInstance5 | z7;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z8) {
                                f6 = f5;
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                }
                                final Function0 function110 = (Function0) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                                if (i21 > 256) {
                                    str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                    if ((i9 & 384) != 256) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                } else {
                                    str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                    if ((i9 & 384) != 256) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                }
                                boolean zChangedInstance6 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                                if (i22 == 4) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                z11 = zChangedInstance6 | z10;
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!z11) {
                                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                } else {
                                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                Function0 function111 = (Function0) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                final float f10 = f6;
                                str2 = str;
                                i23 = i9;
                                final Modifier modifier6 = modifier2;
                                final long j18 = scrimColor;
                                final Shape shape6 = expandedShape;
                                sheetState3 = sheetStateRememberModalBottomSheetState;
                                final long j19 = j7;
                                final long j110 = jM3712contentColorForek8zF_U;
                                final Function2 function112 = function9;
                                Function2 function113 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties4, function110, j18, modifier6, function0, f10, z5, function8, function112, shape6, j19, j110, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                composer2 = composerStartRestartGroup;
                                z12 = true;
                                ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function111, j110, modalBottomSheetProperties4, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function113, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i31 & 896), 0);
                                if (sheetState3.getHasExpandedState()) {
                                    composer2.startReplaceGroup(748177042);
                                    ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                                    ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                                    if (i21 > 256) {
                                    }
                                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                                    if (!z12) {
                                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                        composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                    } else {
                                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                        composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                                    composer2.endReplaceGroup();
                                } else {
                                    composer2.startReplaceGroup(748238546);
                                    composer2.endReplaceGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier6;
                                shape2 = shape6;
                                sheetState2 = sheetState3;
                                f3 = f10;
                                z4 = z5;
                                j5 = j19;
                                function5 = function8;
                                j6 = j110;
                                modalBottomSheetProperties2 = modalBottomSheetProperties4;
                                function6 = function112;
                                f4 = fM10168constructorimpl;
                                j4 = j18;
                            } else {
                                f6 = f5;
                            }
                            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            final Function0 function114 = (Function0) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            if (i21 > 256) {
                                str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                if ((i9 & 384) != 256) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                            } else {
                                str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                if ((i9 & 384) != 256) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                            }
                            boolean zChangedInstance7 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                            if (i22 == 4) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            z11 = zChangedInstance7 | z10;
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z11) {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            Function0 function115 = (Function0) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float f11 = f6;
                            str2 = str;
                            i23 = i9;
                            final Modifier modifier7 = modifier2;
                            final long j111 = scrimColor;
                            final Shape shape7 = expandedShape;
                            sheetState3 = sheetStateRememberModalBottomSheetState;
                            final long j112 = j7;
                            final long j113 = jM3712contentColorForek8zF_U;
                            final Function2 function116 = function9;
                            Function2 function117 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties4, function114, j111, modifier7, function0, f11, z5, function8, function116, shape7, j112, j113, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            composer2 = composerStartRestartGroup;
                            z12 = true;
                            ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function115, j113, modalBottomSheetProperties4, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function117, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i31 & 896), 0);
                            if (sheetState3.getHasExpandedState()) {
                                composer2.startReplaceGroup(748177042);
                                ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                                ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                                if (i21 > 256) {
                                }
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                                if (!z12) {
                                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                    composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                } else {
                                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                    composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                                composer2.endReplaceGroup();
                            } else {
                                composer2.startReplaceGroup(748238546);
                                composer2.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier7;
                            shape2 = shape7;
                            sheetState2 = sheetState3;
                            f3 = f11;
                            z4 = z5;
                            j5 = j112;
                            function5 = function8;
                            j6 = j113;
                            modalBottomSheetProperties2 = modalBottomSheetProperties4;
                            function6 = function116;
                            f4 = fM10168constructorimpl;
                            j4 = j111;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            f3 = f;
                            j4 = j3;
                            function5 = function2;
                            function6 = function3;
                            modalBottomSheetProperties2 = modalBottomSheetProperties;
                            j5 = containerColor;
                            z4 = z2;
                            shape2 = expandedShape;
                            sheetState2 = sheetStateRememberModalBottomSheetState;
                            j6 = j2;
                            f4 = f2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final long j20 = j4;
                            final Modifier modifier8 = modifier2;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier8, sheetState2, f3, z4, shape2, j5, j6, f4, j20, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i17 = i15 | 384;
                    if ((i2 & 3072) != 0) {
                        i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                    }
                    i19 = i17;
                    if ((i9 & 306783379) == 306783378) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
                        if ((i & 1) != 0) {
                            if (i28 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM3513getSheetMaxWidthD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i9 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3712contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            } else {
                                fM10168constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                i19 = i20;
                            } else {
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            long j21 = containerColor;
                            f5 = fM3513getSheetMaxWidthD9Ej5fM;
                            z5 = z2;
                            function8 = lambda$1121996006$material3;
                            j7 = j21;
                        } else {
                            if (i28 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM3513getSheetMaxWidthD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i9 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3712contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            } else {
                                fM10168constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                i19 = i20;
                            } else {
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            long j22 = containerColor;
                            f5 = fM3513getSheetMaxWidthD9Ej5fM;
                            z5 = z2;
                            function8 = lambda$1121996006$material3;
                            j7 = j22;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i32 = i19;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        i21 = (i9 & 896) ^ 384;
                        final ModalBottomSheetProperties modalBottomSheetProperties5 = modalBottomSheetProperties3;
                        if (i21 > 256) {
                            function9 = function7;
                            if ((i9 & 384) != 256) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                        } else {
                            function9 = function7;
                            if ((i9 & 384) != 256) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                        }
                        boolean zChangedInstance8 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                        i22 = i9 & 14;
                        if (i22 == 4) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z8 = zChangedInstance8 | z7;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z8) {
                            f6 = f5;
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            }
                            final Function0 function118 = (Function0) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            if (i21 > 256) {
                                str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                if ((i9 & 384) != 256) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                            } else {
                                str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                if ((i9 & 384) != 256) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                            }
                            boolean zChangedInstance9 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                            if (i22 == 4) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            z11 = zChangedInstance9 | z10;
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z11) {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            Function0 function119 = (Function0) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float f12 = f6;
                            str2 = str;
                            i23 = i9;
                            final Modifier modifier9 = modifier2;
                            final long j114 = scrimColor;
                            final Shape shape8 = expandedShape;
                            sheetState3 = sheetStateRememberModalBottomSheetState;
                            final long j115 = j7;
                            final long j116 = jM3712contentColorForek8zF_U;
                            final Function2 function1110 = function9;
                            Function2 function1111 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties5, function118, j114, modifier9, function0, f12, z5, function8, function1110, shape8, j115, j116, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            composer2 = composerStartRestartGroup;
                            z12 = true;
                            ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function119, j116, modalBottomSheetProperties5, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function1111, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i32 & 896), 0);
                            if (sheetState3.getHasExpandedState()) {
                                composer2.startReplaceGroup(748177042);
                                ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                                ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                                if (i21 > 256) {
                                }
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                                if (!z12) {
                                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                    composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                } else {
                                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                    composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                                composer2.endReplaceGroup();
                            } else {
                                composer2.startReplaceGroup(748238546);
                                composer2.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier9;
                            shape2 = shape8;
                            sheetState2 = sheetState3;
                            f3 = f12;
                            z4 = z5;
                            j5 = j115;
                            function5 = function8;
                            j6 = j116;
                            modalBottomSheetProperties2 = modalBottomSheetProperties5;
                            function6 = function1110;
                            f4 = fM10168constructorimpl;
                            j4 = j114;
                        } else {
                            f6 = f5;
                        }
                        objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        final Function0 function1112 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i21 > 256) {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        } else {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        }
                        boolean zChangedInstance10 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                        if (i22 == 4) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z11 = zChangedInstance10 | z10;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z11) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function1113 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float f13 = f6;
                        str2 = str;
                        i23 = i9;
                        final Modifier modifier10 = modifier2;
                        final long j117 = scrimColor;
                        final Shape shape9 = expandedShape;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        final long j118 = j7;
                        final long j119 = jM3712contentColorForek8zF_U;
                        final Function2 function1114 = function9;
                        Function2 function1115 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties5, function1112, j117, modifier10, function0, f13, z5, function8, function1114, shape9, j118, j119, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        composer2 = composerStartRestartGroup;
                        z12 = true;
                        ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function1113, j119, modalBottomSheetProperties5, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function1115, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i32 & 896), 0);
                        if (sheetState3.getHasExpandedState()) {
                            composer2.startReplaceGroup(748177042);
                            ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                            ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                            if (i21 > 256) {
                            }
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                            if (!z12) {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            } else {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(748238546);
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier10;
                        shape2 = shape9;
                        sheetState2 = sheetState3;
                        f3 = f13;
                        z4 = z5;
                        j5 = j118;
                        function5 = function8;
                        j6 = j119;
                        modalBottomSheetProperties2 = modalBottomSheetProperties5;
                        function6 = function1114;
                        f4 = fM10168constructorimpl;
                        j4 = j117;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        f3 = f;
                        j4 = j3;
                        function5 = function2;
                        function6 = function3;
                        modalBottomSheetProperties2 = modalBottomSheetProperties;
                        j5 = containerColor;
                        z4 = z2;
                        shape2 = expandedShape;
                        sheetState2 = sheetStateRememberModalBottomSheetState;
                        j6 = j2;
                        f4 = f2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final long j23 = j4;
                        final Modifier modifier11 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier11, sheetState2, f3, z4, shape2, j5, j6, f4, j23, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 24576;
                z2 = z;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    expandedShape = shape;
                    if ((i3 & 32) == 0) {
                        i27 = 65536;
                    } else {
                        i27 = 65536;
                    }
                    i4 |= i27;
                } else {
                    expandedShape = shape;
                }
                if ((i & 1572864) == 0) {
                    containerColor = j;
                    if ((i3 & 64) == 0) {
                        i26 = 524288;
                    } else {
                        i26 = 524288;
                    }
                    i4 |= i26;
                } else {
                    containerColor = j;
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        i25 = i4;
                        if (composerStartRestartGroup.changed(j2)) {
                        }
                        i9 = i25 | i30;
                    } else {
                        i25 = i4;
                    }
                    i9 = i25 | i30;
                } else {
                    i9 = i4;
                }
                i10 = i3 & 256;
                if (i10 != 0) {
                    i9 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i11 = 67108864;
                    } else {
                        i11 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i9 |= i11;
                }
                if ((i & 805306368) != 0) {
                    if ((i3 & 512) == 0) {
                        i24 = 268435456;
                    } else {
                        i24 = 268435456;
                    }
                    i9 |= i24;
                }
                i12 = i3 & 1024;
                if (i12 != 0) {
                    i13 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i14 = 4;
                    } else {
                        i14 = 2;
                    }
                    i13 = i2 | i14;
                } else {
                    i13 = i2;
                }
                if ((i2 & 48) != 0) {
                    i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
                }
                i15 = i13;
                i16 = i3 & 4096;
                if (i16 != 0) {
                    i17 = i15;
                    if ((i2 & 384) == 0) {
                        if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                            i18 = 256;
                        } else {
                            i18 = 128;
                        }
                        i17 |= i18;
                    }
                    if ((i2 & 3072) != 0) {
                        i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                    }
                    i19 = i17;
                    if ((i9 & 306783379) == 306783378) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
                        if ((i & 1) != 0) {
                            if (i28 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM3513getSheetMaxWidthD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i9 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3712contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            } else {
                                fM10168constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                i19 = i20;
                            } else {
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            long j24 = containerColor;
                            f5 = fM3513getSheetMaxWidthD9Ej5fM;
                            z5 = z2;
                            function8 = lambda$1121996006$material3;
                            j7 = j24;
                        } else {
                            if (i28 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM3513getSheetMaxWidthD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i9 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3712contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            } else {
                                fM10168constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                i19 = i20;
                            } else {
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            long j25 = containerColor;
                            f5 = fM3513getSheetMaxWidthD9Ej5fM;
                            z5 = z2;
                            function8 = lambda$1121996006$material3;
                            j7 = j25;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i33 = i19;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        i21 = (i9 & 896) ^ 384;
                        final ModalBottomSheetProperties modalBottomSheetProperties6 = modalBottomSheetProperties3;
                        if (i21 > 256) {
                            function9 = function7;
                            if ((i9 & 384) != 256) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                        } else {
                            function9 = function7;
                            if ((i9 & 384) != 256) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                        }
                        boolean zChangedInstance11 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                        i22 = i9 & 14;
                        if (i22 == 4) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z8 = zChangedInstance11 | z7;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z8) {
                            f6 = f5;
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            }
                            final Function0 function1116 = (Function0) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            if (i21 > 256) {
                                str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                if ((i9 & 384) != 256) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                            } else {
                                str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                if ((i9 & 384) != 256) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                            }
                            boolean zChangedInstance12 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                            if (i22 == 4) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            z11 = zChangedInstance12 | z10;
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z11) {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            Function0 function1117 = (Function0) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float f14 = f6;
                            str2 = str;
                            i23 = i9;
                            final Modifier modifier12 = modifier2;
                            final long j1110 = scrimColor;
                            final Shape shape10 = expandedShape;
                            sheetState3 = sheetStateRememberModalBottomSheetState;
                            final long j1111 = j7;
                            final long j1112 = jM3712contentColorForek8zF_U;
                            final Function2 function1118 = function9;
                            Function2 function1119 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties6, function1116, j1110, modifier12, function0, f14, z5, function8, function1118, shape10, j1111, j1112, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            composer2 = composerStartRestartGroup;
                            z12 = true;
                            ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function1117, j1112, modalBottomSheetProperties6, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function1119, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i33 & 896), 0);
                            if (sheetState3.getHasExpandedState()) {
                                composer2.startReplaceGroup(748177042);
                                ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                                ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                                if (i21 > 256) {
                                }
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                                if (!z12) {
                                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                    composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                } else {
                                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                    composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                                composer2.endReplaceGroup();
                            } else {
                                composer2.startReplaceGroup(748238546);
                                composer2.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier12;
                            shape2 = shape10;
                            sheetState2 = sheetState3;
                            f3 = f14;
                            z4 = z5;
                            j5 = j1111;
                            function5 = function8;
                            j6 = j1112;
                            modalBottomSheetProperties2 = modalBottomSheetProperties6;
                            function6 = function1118;
                            f4 = fM10168constructorimpl;
                            j4 = j1110;
                        } else {
                            f6 = f5;
                        }
                        objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        final Function0 function11110 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i21 > 256) {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        } else {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        }
                        boolean zChangedInstance13 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                        if (i22 == 4) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z11 = zChangedInstance13 | z10;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z11) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function11111 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float f15 = f6;
                        str2 = str;
                        i23 = i9;
                        final Modifier modifier13 = modifier2;
                        final long j1113 = scrimColor;
                        final Shape shape11 = expandedShape;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        final long j1114 = j7;
                        final long j1115 = jM3712contentColorForek8zF_U;
                        final Function2 function11112 = function9;
                        Function2 function11113 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties6, function11110, j1113, modifier13, function0, f15, z5, function8, function11112, shape11, j1114, j1115, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        composer2 = composerStartRestartGroup;
                        z12 = true;
                        ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function11111, j1115, modalBottomSheetProperties6, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function11113, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i33 & 896), 0);
                        if (sheetState3.getHasExpandedState()) {
                            composer2.startReplaceGroup(748177042);
                            ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                            ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                            if (i21 > 256) {
                            }
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                            if (!z12) {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            } else {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(748238546);
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier13;
                        shape2 = shape11;
                        sheetState2 = sheetState3;
                        f3 = f15;
                        z4 = z5;
                        j5 = j1114;
                        function5 = function8;
                        j6 = j1115;
                        modalBottomSheetProperties2 = modalBottomSheetProperties6;
                        function6 = function11112;
                        f4 = fM10168constructorimpl;
                        j4 = j1113;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        f3 = f;
                        j4 = j3;
                        function5 = function2;
                        function6 = function3;
                        modalBottomSheetProperties2 = modalBottomSheetProperties;
                        j5 = containerColor;
                        z4 = z2;
                        shape2 = expandedShape;
                        sheetState2 = sheetStateRememberModalBottomSheetState;
                        j6 = j2;
                        f4 = f2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final long j26 = j4;
                        final Modifier modifier14 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier14, sheetState2, f3, z4, shape2, j5, j6, f4, j26, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i17 = i15 | 384;
                if ((i2 & 3072) != 0) {
                    i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                }
                i19 = i17;
                if ((i9 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
                    if ((i & 1) != 0) {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM3513getSheetMaxWidthD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i9 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3712contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        } else {
                            fM10168constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            i19 = i20;
                        } else {
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        long j27 = containerColor;
                        f5 = fM3513getSheetMaxWidthD9Ej5fM;
                        z5 = z2;
                        function8 = lambda$1121996006$material3;
                        j7 = j27;
                    } else {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM3513getSheetMaxWidthD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i9 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3712contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        } else {
                            fM10168constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            i19 = i20;
                        } else {
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        long j28 = containerColor;
                        f5 = fM3513getSheetMaxWidthD9Ej5fM;
                        z5 = z2;
                        function8 = lambda$1121996006$material3;
                        j7 = j28;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i34 = i19;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    i21 = (i9 & 896) ^ 384;
                    final ModalBottomSheetProperties modalBottomSheetProperties7 = modalBottomSheetProperties3;
                    if (i21 > 256) {
                        function9 = function7;
                        if ((i9 & 384) != 256) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                    } else {
                        function9 = function7;
                        if ((i9 & 384) != 256) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                    }
                    boolean zChangedInstance14 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                    i22 = i9 & 14;
                    if (i22 == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = zChangedInstance14 | z7;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z8) {
                        f6 = f5;
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        }
                        final Function0 function11114 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i21 > 256) {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        } else {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        }
                        boolean zChangedInstance15 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                        if (i22 == 4) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z11 = zChangedInstance15 | z10;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z11) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function11115 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float f16 = f6;
                        str2 = str;
                        i23 = i9;
                        final Modifier modifier15 = modifier2;
                        final long j1116 = scrimColor;
                        final Shape shape12 = expandedShape;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        final long j1117 = j7;
                        final long j1118 = jM3712contentColorForek8zF_U;
                        final Function2 function11116 = function9;
                        Function2 function11117 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties7, function11114, j1116, modifier15, function0, f16, z5, function8, function11116, shape12, j1117, j1118, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        composer2 = composerStartRestartGroup;
                        z12 = true;
                        ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function11115, j1118, modalBottomSheetProperties7, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function11117, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i34 & 896), 0);
                        if (sheetState3.getHasExpandedState()) {
                            composer2.startReplaceGroup(748177042);
                            ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                            ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                            if (i21 > 256) {
                            }
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                            if (!z12) {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            } else {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(748238546);
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier15;
                        shape2 = shape12;
                        sheetState2 = sheetState3;
                        f3 = f16;
                        z4 = z5;
                        j5 = j1117;
                        function5 = function8;
                        j6 = j1118;
                        modalBottomSheetProperties2 = modalBottomSheetProperties7;
                        function6 = function11116;
                        f4 = fM10168constructorimpl;
                        j4 = j1116;
                    } else {
                        f6 = f5;
                    }
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    final Function0 function11118 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i21 > 256) {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    } else {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    }
                    boolean zChangedInstance16 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if (i22 == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = zChangedInstance16 | z10;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function11119 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f17 = f6;
                    str2 = str;
                    i23 = i9;
                    final Modifier modifier16 = modifier2;
                    final long j1119 = scrimColor;
                    final Shape shape13 = expandedShape;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    final long j11110 = j7;
                    final long j11111 = jM3712contentColorForek8zF_U;
                    final Function2 function111110 = function9;
                    Function2 function111111 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties7, function11118, j1119, modifier16, function0, f17, z5, function8, function111110, shape13, j11110, j11111, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    composer2 = composerStartRestartGroup;
                    z12 = true;
                    ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function11119, j11111, modalBottomSheetProperties7, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function111111, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i34 & 896), 0);
                    if (sheetState3.getHasExpandedState()) {
                        composer2.startReplaceGroup(748177042);
                        ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                        ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                        if (i21 > 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                        if (!z12) {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(748238546);
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier16;
                    shape2 = shape13;
                    sheetState2 = sheetState3;
                    f3 = f17;
                    z4 = z5;
                    j5 = j11110;
                    function5 = function8;
                    j6 = j11111;
                    modalBottomSheetProperties2 = modalBottomSheetProperties7;
                    function6 = function111110;
                    f4 = fM10168constructorimpl;
                    j4 = j1119;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    f3 = f;
                    j4 = j3;
                    function5 = function2;
                    function6 = function3;
                    modalBottomSheetProperties2 = modalBottomSheetProperties;
                    j5 = containerColor;
                    z4 = z2;
                    shape2 = expandedShape;
                    sheetState2 = sheetStateRememberModalBottomSheetState;
                    j6 = j2;
                    f4 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final long j29 = j4;
                    final Modifier modifier17 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier17, sheetState2, f3, z4, shape2, j5, j6, f4, j29, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    expandedShape = shape;
                    if ((i3 & 32) == 0) {
                        i27 = 65536;
                    } else {
                        i27 = 65536;
                    }
                    i4 |= i27;
                } else {
                    expandedShape = shape;
                }
                if ((i & 1572864) == 0) {
                    containerColor = j;
                    if ((i3 & 64) == 0) {
                        i26 = 524288;
                    } else {
                        i26 = 524288;
                    }
                    i4 |= i26;
                } else {
                    containerColor = j;
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        i25 = i4;
                        if (composerStartRestartGroup.changed(j2)) {
                        }
                        i9 = i25 | i30;
                    } else {
                        i25 = i4;
                    }
                    i9 = i25 | i30;
                } else {
                    i9 = i4;
                }
                i10 = i3 & 256;
                if (i10 != 0) {
                    i9 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i11 = 67108864;
                    } else {
                        i11 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i9 |= i11;
                }
                if ((i & 805306368) != 0) {
                    if ((i3 & 512) == 0) {
                        i24 = 268435456;
                    } else {
                        i24 = 268435456;
                    }
                    i9 |= i24;
                }
                i12 = i3 & 1024;
                if (i12 != 0) {
                    i13 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i14 = 4;
                    } else {
                        i14 = 2;
                    }
                    i13 = i2 | i14;
                } else {
                    i13 = i2;
                }
                if ((i2 & 48) != 0) {
                    i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
                }
                i15 = i13;
                i16 = i3 & 4096;
                if (i16 != 0) {
                    i17 = i15;
                    if ((i2 & 384) == 0) {
                        if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                            i18 = 256;
                        } else {
                            i18 = 128;
                        }
                        i17 |= i18;
                    }
                    if ((i2 & 3072) != 0) {
                        i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                    }
                    i19 = i17;
                    if ((i9 & 306783379) == 306783378) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
                        if ((i & 1) != 0) {
                            if (i28 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM3513getSheetMaxWidthD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i9 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3712contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            } else {
                                fM10168constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                i19 = i20;
                            } else {
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            long j210 = containerColor;
                            f5 = fM3513getSheetMaxWidthD9Ej5fM;
                            z5 = z2;
                            function8 = lambda$1121996006$material3;
                            j7 = j210;
                        } else {
                            if (i28 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM3513getSheetMaxWidthD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i9 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3712contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            } else {
                                fM10168constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                i19 = i20;
                            } else {
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            long j211 = containerColor;
                            f5 = fM3513getSheetMaxWidthD9Ej5fM;
                            z5 = z2;
                            function8 = lambda$1121996006$material3;
                            j7 = j211;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i35 = i19;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        i21 = (i9 & 896) ^ 384;
                        final ModalBottomSheetProperties modalBottomSheetProperties8 = modalBottomSheetProperties3;
                        if (i21 > 256) {
                            function9 = function7;
                            if ((i9 & 384) != 256) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                        } else {
                            function9 = function7;
                            if ((i9 & 384) != 256) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                        }
                        boolean zChangedInstance17 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                        i22 = i9 & 14;
                        if (i22 == 4) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z8 = zChangedInstance17 | z7;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z8) {
                            f6 = f5;
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            }
                            final Function0 function111112 = (Function0) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            if (i21 > 256) {
                                str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                if ((i9 & 384) != 256) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                            } else {
                                str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                if ((i9 & 384) != 256) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                            }
                            boolean zChangedInstance18 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                            if (i22 == 4) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            z11 = zChangedInstance18 | z10;
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z11) {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            Function0 function111113 = (Function0) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float f18 = f6;
                            str2 = str;
                            i23 = i9;
                            final Modifier modifier18 = modifier2;
                            final long j11112 = scrimColor;
                            final Shape shape14 = expandedShape;
                            sheetState3 = sheetStateRememberModalBottomSheetState;
                            final long j11113 = j7;
                            final long j11114 = jM3712contentColorForek8zF_U;
                            final Function2 function111114 = function9;
                            Function2 function111115 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties8, function111112, j11112, modifier18, function0, f18, z5, function8, function111114, shape14, j11113, j11114, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            composer2 = composerStartRestartGroup;
                            z12 = true;
                            ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function111113, j11114, modalBottomSheetProperties8, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function111115, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i35 & 896), 0);
                            if (sheetState3.getHasExpandedState()) {
                                composer2.startReplaceGroup(748177042);
                                ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                                ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                                if (i21 > 256) {
                                }
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                                if (!z12) {
                                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                    composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                } else {
                                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                    composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                                composer2.endReplaceGroup();
                            } else {
                                composer2.startReplaceGroup(748238546);
                                composer2.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier18;
                            shape2 = shape14;
                            sheetState2 = sheetState3;
                            f3 = f18;
                            z4 = z5;
                            j5 = j11113;
                            function5 = function8;
                            j6 = j11114;
                            modalBottomSheetProperties2 = modalBottomSheetProperties8;
                            function6 = function111114;
                            f4 = fM10168constructorimpl;
                            j4 = j11112;
                        } else {
                            f6 = f5;
                        }
                        objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        final Function0 function111116 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i21 > 256) {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        } else {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        }
                        boolean zChangedInstance19 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                        if (i22 == 4) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z11 = zChangedInstance19 | z10;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z11) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function111117 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float f19 = f6;
                        str2 = str;
                        i23 = i9;
                        final Modifier modifier19 = modifier2;
                        final long j11115 = scrimColor;
                        final Shape shape15 = expandedShape;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        final long j11116 = j7;
                        final long j11117 = jM3712contentColorForek8zF_U;
                        final Function2 function111118 = function9;
                        Function2 function111119 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties8, function111116, j11115, modifier19, function0, f19, z5, function8, function111118, shape15, j11116, j11117, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        composer2 = composerStartRestartGroup;
                        z12 = true;
                        ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function111117, j11117, modalBottomSheetProperties8, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function111119, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i35 & 896), 0);
                        if (sheetState3.getHasExpandedState()) {
                            composer2.startReplaceGroup(748177042);
                            ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                            ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                            if (i21 > 256) {
                            }
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                            if (!z12) {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            } else {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(748238546);
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier19;
                        shape2 = shape15;
                        sheetState2 = sheetState3;
                        f3 = f19;
                        z4 = z5;
                        j5 = j11116;
                        function5 = function8;
                        j6 = j11117;
                        modalBottomSheetProperties2 = modalBottomSheetProperties8;
                        function6 = function111118;
                        f4 = fM10168constructorimpl;
                        j4 = j11115;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        f3 = f;
                        j4 = j3;
                        function5 = function2;
                        function6 = function3;
                        modalBottomSheetProperties2 = modalBottomSheetProperties;
                        j5 = containerColor;
                        z4 = z2;
                        shape2 = expandedShape;
                        sheetState2 = sheetStateRememberModalBottomSheetState;
                        j6 = j2;
                        f4 = f2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final long j212 = j4;
                        final Modifier modifier110 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier110, sheetState2, f3, z4, shape2, j5, j6, f4, j212, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i17 = i15 | 384;
                if ((i2 & 3072) != 0) {
                    i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                }
                i19 = i17;
                if ((i9 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
                    if ((i & 1) != 0) {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM3513getSheetMaxWidthD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i9 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3712contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        } else {
                            fM10168constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            i19 = i20;
                        } else {
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        long j213 = containerColor;
                        f5 = fM3513getSheetMaxWidthD9Ej5fM;
                        z5 = z2;
                        function8 = lambda$1121996006$material3;
                        j7 = j213;
                    } else {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM3513getSheetMaxWidthD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i9 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3712contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        } else {
                            fM10168constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            i19 = i20;
                        } else {
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        long j214 = containerColor;
                        f5 = fM3513getSheetMaxWidthD9Ej5fM;
                        z5 = z2;
                        function8 = lambda$1121996006$material3;
                        j7 = j214;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i36 = i19;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    i21 = (i9 & 896) ^ 384;
                    final ModalBottomSheetProperties modalBottomSheetProperties9 = modalBottomSheetProperties3;
                    if (i21 > 256) {
                        function9 = function7;
                        if ((i9 & 384) != 256) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                    } else {
                        function9 = function7;
                        if ((i9 & 384) != 256) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                    }
                    boolean zChangedInstance110 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                    i22 = i9 & 14;
                    if (i22 == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = zChangedInstance110 | z7;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z8) {
                        f6 = f5;
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        }
                        final Function0 function1111110 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i21 > 256) {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        } else {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        }
                        boolean zChangedInstance111 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                        if (i22 == 4) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z11 = zChangedInstance111 | z10;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z11) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function1111111 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float f110 = f6;
                        str2 = str;
                        i23 = i9;
                        final Modifier modifier111 = modifier2;
                        final long j11118 = scrimColor;
                        final Shape shape16 = expandedShape;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        final long j11119 = j7;
                        final long j111110 = jM3712contentColorForek8zF_U;
                        final Function2 function1111112 = function9;
                        Function2 function1111113 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties9, function1111110, j11118, modifier111, function0, f110, z5, function8, function1111112, shape16, j11119, j111110, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        composer2 = composerStartRestartGroup;
                        z12 = true;
                        ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function1111111, j111110, modalBottomSheetProperties9, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function1111113, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i36 & 896), 0);
                        if (sheetState3.getHasExpandedState()) {
                            composer2.startReplaceGroup(748177042);
                            ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                            ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                            if (i21 > 256) {
                            }
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                            if (!z12) {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            } else {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(748238546);
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier111;
                        shape2 = shape16;
                        sheetState2 = sheetState3;
                        f3 = f110;
                        z4 = z5;
                        j5 = j11119;
                        function5 = function8;
                        j6 = j111110;
                        modalBottomSheetProperties2 = modalBottomSheetProperties9;
                        function6 = function1111112;
                        f4 = fM10168constructorimpl;
                        j4 = j11118;
                    } else {
                        f6 = f5;
                    }
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    final Function0 function1111114 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i21 > 256) {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    } else {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    }
                    boolean zChangedInstance112 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if (i22 == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = zChangedInstance112 | z10;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function1111115 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f111 = f6;
                    str2 = str;
                    i23 = i9;
                    final Modifier modifier112 = modifier2;
                    final long j111111 = scrimColor;
                    final Shape shape17 = expandedShape;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    final long j111112 = j7;
                    final long j111113 = jM3712contentColorForek8zF_U;
                    final Function2 function1111116 = function9;
                    Function2 function1111117 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties9, function1111114, j111111, modifier112, function0, f111, z5, function8, function1111116, shape17, j111112, j111113, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    composer2 = composerStartRestartGroup;
                    z12 = true;
                    ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function1111115, j111113, modalBottomSheetProperties9, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function1111117, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i36 & 896), 0);
                    if (sheetState3.getHasExpandedState()) {
                        composer2.startReplaceGroup(748177042);
                        ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                        ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                        if (i21 > 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                        if (!z12) {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(748238546);
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier112;
                    shape2 = shape17;
                    sheetState2 = sheetState3;
                    f3 = f111;
                    z4 = z5;
                    j5 = j111112;
                    function5 = function8;
                    j6 = j111113;
                    modalBottomSheetProperties2 = modalBottomSheetProperties9;
                    function6 = function1111116;
                    f4 = fM10168constructorimpl;
                    j4 = j111111;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    f3 = f;
                    j4 = j3;
                    function5 = function2;
                    function6 = function3;
                    modalBottomSheetProperties2 = modalBottomSheetProperties;
                    j5 = containerColor;
                    z4 = z2;
                    shape2 = expandedShape;
                    sheetState2 = sheetStateRememberModalBottomSheetState;
                    j6 = j2;
                    f4 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final long j215 = j4;
                    final Modifier modifier113 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier113, sheetState2, f3, z4, shape2, j5, j6, f4, j215, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            z2 = z;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                expandedShape = shape;
                if ((i3 & 32) == 0) {
                    i27 = 65536;
                } else {
                    i27 = 65536;
                }
                i4 |= i27;
            } else {
                expandedShape = shape;
            }
            if ((i & 1572864) == 0) {
                containerColor = j;
                if ((i3 & 64) == 0) {
                    i26 = 524288;
                } else {
                    i26 = 524288;
                }
                i4 |= i26;
            } else {
                containerColor = j;
            }
            if ((i & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    i25 = i4;
                    if (composerStartRestartGroup.changed(j2)) {
                    }
                    i9 = i25 | i30;
                } else {
                    i25 = i4;
                }
                i9 = i25 | i30;
            } else {
                i9 = i4;
            }
            i10 = i3 & 256;
            if (i10 != 0) {
                i9 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i11 = 67108864;
                } else {
                    i11 = GroupFlagsKt.HasAuxSlotFlag;
                }
                i9 |= i11;
            }
            if ((i & 805306368) != 0) {
                if ((i3 & 512) == 0) {
                    i24 = 268435456;
                } else {
                    i24 = 268435456;
                }
                i9 |= i24;
            }
            i12 = i3 & 1024;
            if (i12 != 0) {
                i13 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i14 = 4;
                } else {
                    i14 = 2;
                }
                i13 = i2 | i14;
            } else {
                i13 = i2;
            }
            if ((i2 & 48) != 0) {
                i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
            }
            i15 = i13;
            i16 = i3 & 4096;
            if (i16 != 0) {
                i17 = i15;
                if ((i2 & 384) == 0) {
                    if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                        i18 = 256;
                    } else {
                        i18 = 128;
                    }
                    i17 |= i18;
                }
                if ((i2 & 3072) != 0) {
                    i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                }
                i19 = i17;
                if ((i9 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
                    if ((i & 1) != 0) {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM3513getSheetMaxWidthD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i9 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3712contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        } else {
                            fM10168constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            i19 = i20;
                        } else {
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        long j216 = containerColor;
                        f5 = fM3513getSheetMaxWidthD9Ej5fM;
                        z5 = z2;
                        function8 = lambda$1121996006$material3;
                        j7 = j216;
                    } else {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM3513getSheetMaxWidthD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i9 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3712contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        } else {
                            fM10168constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            i19 = i20;
                        } else {
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        long j217 = containerColor;
                        f5 = fM3513getSheetMaxWidthD9Ej5fM;
                        z5 = z2;
                        function8 = lambda$1121996006$material3;
                        j7 = j217;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i37 = i19;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    i21 = (i9 & 896) ^ 384;
                    final ModalBottomSheetProperties modalBottomSheetProperties10 = modalBottomSheetProperties3;
                    if (i21 > 256) {
                        function9 = function7;
                        if ((i9 & 384) != 256) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                    } else {
                        function9 = function7;
                        if ((i9 & 384) != 256) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                    }
                    boolean zChangedInstance113 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                    i22 = i9 & 14;
                    if (i22 == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = zChangedInstance113 | z7;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z8) {
                        f6 = f5;
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        }
                        final Function0 function1111118 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i21 > 256) {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        } else {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        }
                        boolean zChangedInstance114 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                        if (i22 == 4) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z11 = zChangedInstance114 | z10;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z11) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function1111119 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float f112 = f6;
                        str2 = str;
                        i23 = i9;
                        final Modifier modifier114 = modifier2;
                        final long j111114 = scrimColor;
                        final Shape shape18 = expandedShape;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        final long j111115 = j7;
                        final long j111116 = jM3712contentColorForek8zF_U;
                        final Function2 function11111110 = function9;
                        Function2 function11111111 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties10, function1111118, j111114, modifier114, function0, f112, z5, function8, function11111110, shape18, j111115, j111116, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        composer2 = composerStartRestartGroup;
                        z12 = true;
                        ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function1111119, j111116, modalBottomSheetProperties10, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function11111111, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i37 & 896), 0);
                        if (sheetState3.getHasExpandedState()) {
                            composer2.startReplaceGroup(748177042);
                            ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                            ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                            if (i21 > 256) {
                            }
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                            if (!z12) {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            } else {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(748238546);
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier114;
                        shape2 = shape18;
                        sheetState2 = sheetState3;
                        f3 = f112;
                        z4 = z5;
                        j5 = j111115;
                        function5 = function8;
                        j6 = j111116;
                        modalBottomSheetProperties2 = modalBottomSheetProperties10;
                        function6 = function11111110;
                        f4 = fM10168constructorimpl;
                        j4 = j111114;
                    } else {
                        f6 = f5;
                    }
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    final Function0 function11111112 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i21 > 256) {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    } else {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    }
                    boolean zChangedInstance115 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if (i22 == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = zChangedInstance115 | z10;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function11111113 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f113 = f6;
                    str2 = str;
                    i23 = i9;
                    final Modifier modifier115 = modifier2;
                    final long j111117 = scrimColor;
                    final Shape shape19 = expandedShape;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    final long j111118 = j7;
                    final long j111119 = jM3712contentColorForek8zF_U;
                    final Function2 function11111114 = function9;
                    Function2 function11111115 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties10, function11111112, j111117, modifier115, function0, f113, z5, function8, function11111114, shape19, j111118, j111119, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    composer2 = composerStartRestartGroup;
                    z12 = true;
                    ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function11111113, j111119, modalBottomSheetProperties10, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function11111115, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i37 & 896), 0);
                    if (sheetState3.getHasExpandedState()) {
                        composer2.startReplaceGroup(748177042);
                        ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                        ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                        if (i21 > 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                        if (!z12) {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(748238546);
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier115;
                    shape2 = shape19;
                    sheetState2 = sheetState3;
                    f3 = f113;
                    z4 = z5;
                    j5 = j111118;
                    function5 = function8;
                    j6 = j111119;
                    modalBottomSheetProperties2 = modalBottomSheetProperties10;
                    function6 = function11111114;
                    f4 = fM10168constructorimpl;
                    j4 = j111117;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    f3 = f;
                    j4 = j3;
                    function5 = function2;
                    function6 = function3;
                    modalBottomSheetProperties2 = modalBottomSheetProperties;
                    j5 = containerColor;
                    z4 = z2;
                    shape2 = expandedShape;
                    sheetState2 = sheetStateRememberModalBottomSheetState;
                    j6 = j2;
                    f4 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final long j218 = j4;
                    final Modifier modifier116 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier116, sheetState2, f3, z4, shape2, j5, j6, f4, j218, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i17 = i15 | 384;
            if ((i2 & 3072) != 0) {
                i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
            }
            i19 = i17;
            if ((i9 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
                if ((i & 1) != 0) {
                    if (i28 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM3513getSheetMaxWidthD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i9 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3712contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    } else {
                        fM10168constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        i19 = i20;
                    } else {
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    long j219 = containerColor;
                    f5 = fM3513getSheetMaxWidthD9Ej5fM;
                    z5 = z2;
                    function8 = lambda$1121996006$material3;
                    j7 = j219;
                } else {
                    if (i28 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM3513getSheetMaxWidthD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i9 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3712contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    } else {
                        fM10168constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        i19 = i20;
                    } else {
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    long j2110 = containerColor;
                    f5 = fM3513getSheetMaxWidthD9Ej5fM;
                    z5 = z2;
                    function8 = lambda$1121996006$material3;
                    j7 = j2110;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i38 = i19;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
                i21 = (i9 & 896) ^ 384;
                final ModalBottomSheetProperties modalBottomSheetProperties11 = modalBottomSheetProperties3;
                if (i21 > 256) {
                    function9 = function7;
                    if ((i9 & 384) != 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                } else {
                    function9 = function7;
                    if ((i9 & 384) != 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                }
                boolean zChangedInstance116 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                i22 = i9 & 14;
                if (i22 == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = zChangedInstance116 | z7;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z8) {
                    f6 = f5;
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    final Function0 function11111116 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i21 > 256) {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    } else {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    }
                    boolean zChangedInstance117 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if (i22 == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = zChangedInstance117 | z10;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function11111117 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f114 = f6;
                    str2 = str;
                    i23 = i9;
                    final Modifier modifier117 = modifier2;
                    final long j1111110 = scrimColor;
                    final Shape shape110 = expandedShape;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    final long j1111111 = j7;
                    final long j1111112 = jM3712contentColorForek8zF_U;
                    final Function2 function11111118 = function9;
                    Function2 function11111119 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties11, function11111116, j1111110, modifier117, function0, f114, z5, function8, function11111118, shape110, j1111111, j1111112, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    composer2 = composerStartRestartGroup;
                    z12 = true;
                    ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function11111117, j1111112, modalBottomSheetProperties11, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function11111119, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i38 & 896), 0);
                    if (sheetState3.getHasExpandedState()) {
                        composer2.startReplaceGroup(748177042);
                        ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                        ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                        if (i21 > 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                        if (!z12) {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(748238546);
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier117;
                    shape2 = shape110;
                    sheetState2 = sheetState3;
                    f3 = f114;
                    z4 = z5;
                    j5 = j1111111;
                    function5 = function8;
                    j6 = j1111112;
                    modalBottomSheetProperties2 = modalBottomSheetProperties11;
                    function6 = function11111118;
                    f4 = fM10168constructorimpl;
                    j4 = j1111110;
                } else {
                    f6 = f5;
                }
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                final Function0 function111111110 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                if (i21 > 256) {
                    str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                    if ((i9 & 384) != 256) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                } else {
                    str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                    if ((i9 & 384) != 256) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                }
                boolean zChangedInstance118 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                if (i22 == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = zChangedInstance118 | z10;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z11) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function111111111 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float f115 = f6;
                str2 = str;
                i23 = i9;
                final Modifier modifier118 = modifier2;
                final long j1111113 = scrimColor;
                final Shape shape111 = expandedShape;
                sheetState3 = sheetStateRememberModalBottomSheetState;
                final long j1111114 = j7;
                final long j1111115 = jM3712contentColorForek8zF_U;
                final Function2 function111111112 = function9;
                Function2 function111111113 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties11, function111111110, j1111113, modifier118, function0, f115, z5, function8, function111111112, shape111, j1111114, j1111115, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                composer2 = composerStartRestartGroup;
                z12 = true;
                ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function111111111, j1111115, modalBottomSheetProperties11, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function111111113, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i38 & 896), 0);
                if (sheetState3.getHasExpandedState()) {
                    composer2.startReplaceGroup(748177042);
                    ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                    ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                    if (i21 > 256) {
                    }
                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                    if (!z12) {
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                        composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                    } else {
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                        composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(748238546);
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier118;
                shape2 = shape111;
                sheetState2 = sheetState3;
                f3 = f115;
                z4 = z5;
                j5 = j1111114;
                function5 = function8;
                j6 = j1111115;
                modalBottomSheetProperties2 = modalBottomSheetProperties11;
                function6 = function111111112;
                f4 = fM10168constructorimpl;
                j4 = j1111113;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                f3 = f;
                j4 = j3;
                function5 = function2;
                function6 = function3;
                modalBottomSheetProperties2 = modalBottomSheetProperties;
                j5 = containerColor;
                z4 = z2;
                shape2 = expandedShape;
                sheetState2 = sheetStateRememberModalBottomSheetState;
                j6 = j2;
                f4 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final long j2111 = j4;
                final Modifier modifier119 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier119, sheetState2, f3, z4, shape2, j5, j6, f4, j2111, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i3 & 4) == 0) {
                sheetStateRememberModalBottomSheetState = sheetState;
                if (composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) {
                }
                i4 |= i29;
            } else {
                sheetStateRememberModalBottomSheetState = sheetState;
            }
            i4 |= i29;
        } else {
            sheetStateRememberModalBottomSheetState = sheetState;
        }
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    expandedShape = shape;
                    if ((i3 & 32) == 0) {
                        i27 = 65536;
                    } else {
                        i27 = 65536;
                    }
                    i4 |= i27;
                } else {
                    expandedShape = shape;
                }
                if ((i & 1572864) == 0) {
                    containerColor = j;
                    if ((i3 & 64) == 0) {
                        i26 = 524288;
                    } else {
                        i26 = 524288;
                    }
                    i4 |= i26;
                } else {
                    containerColor = j;
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        i25 = i4;
                        if (composerStartRestartGroup.changed(j2)) {
                        }
                        i9 = i25 | i30;
                    } else {
                        i25 = i4;
                    }
                    i9 = i25 | i30;
                } else {
                    i9 = i4;
                }
                i10 = i3 & 256;
                if (i10 != 0) {
                    i9 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i11 = 67108864;
                    } else {
                        i11 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i9 |= i11;
                }
                if ((i & 805306368) != 0) {
                    if ((i3 & 512) == 0) {
                        i24 = 268435456;
                    } else {
                        i24 = 268435456;
                    }
                    i9 |= i24;
                }
                i12 = i3 & 1024;
                if (i12 != 0) {
                    i13 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i14 = 4;
                    } else {
                        i14 = 2;
                    }
                    i13 = i2 | i14;
                } else {
                    i13 = i2;
                }
                if ((i2 & 48) != 0) {
                    i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
                }
                i15 = i13;
                i16 = i3 & 4096;
                if (i16 != 0) {
                    i17 = i15;
                    if ((i2 & 384) == 0) {
                        if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                            i18 = 256;
                        } else {
                            i18 = 128;
                        }
                        i17 |= i18;
                    }
                    if ((i2 & 3072) != 0) {
                        i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                    }
                    i19 = i17;
                    if ((i9 & 306783379) == 306783378) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
                        if ((i & 1) != 0) {
                            if (i28 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM3513getSheetMaxWidthD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i9 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3712contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            } else {
                                fM10168constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                i19 = i20;
                            } else {
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            long j2112 = containerColor;
                            f5 = fM3513getSheetMaxWidthD9Ej5fM;
                            z5 = z2;
                            function8 = lambda$1121996006$material3;
                            j7 = j2112;
                        } else {
                            if (i28 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM3513getSheetMaxWidthD9Ej5fM = f;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i9 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3712contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            } else {
                                fM10168constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                i19 = i20;
                            } else {
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            long j2113 = containerColor;
                            f5 = fM3513getSheetMaxWidthD9Ej5fM;
                            z5 = z2;
                            function8 = lambda$1121996006$material3;
                            j7 = j2113;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i39 = i19;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        i21 = (i9 & 896) ^ 384;
                        final ModalBottomSheetProperties modalBottomSheetProperties12 = modalBottomSheetProperties3;
                        if (i21 > 256) {
                            function9 = function7;
                            if ((i9 & 384) != 256) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                        } else {
                            function9 = function7;
                            if ((i9 & 384) != 256) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                        }
                        boolean zChangedInstance119 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                        i22 = i9 & 14;
                        if (i22 == 4) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z8 = zChangedInstance119 | z7;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z8) {
                            f6 = f5;
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            }
                            final Function0 function111111114 = (Function0) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            if (i21 > 256) {
                                str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                if ((i9 & 384) != 256) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                            } else {
                                str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                                if ((i9 & 384) != 256) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                            }
                            boolean zChangedInstance1110 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                            if (i22 == 4) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            z11 = zChangedInstance1110 | z10;
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z11) {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            Function0 function111111115 = (Function0) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float f116 = f6;
                            str2 = str;
                            i23 = i9;
                            final Modifier modifier1110 = modifier2;
                            final long j1111116 = scrimColor;
                            final Shape shape112 = expandedShape;
                            sheetState3 = sheetStateRememberModalBottomSheetState;
                            final long j1111117 = j7;
                            final long j1111118 = jM3712contentColorForek8zF_U;
                            final Function2 function111111116 = function9;
                            Function2 function111111117 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties12, function111111114, j1111116, modifier1110, function0, f116, z5, function8, function111111116, shape112, j1111117, j1111118, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            composer2 = composerStartRestartGroup;
                            z12 = true;
                            ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function111111115, j1111118, modalBottomSheetProperties12, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function111111117, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i39 & 896), 0);
                            if (sheetState3.getHasExpandedState()) {
                                composer2.startReplaceGroup(748177042);
                                ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                                ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                                if (i21 > 256) {
                                }
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                                if (!z12) {
                                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                    composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                } else {
                                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                    composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                                composer2.endReplaceGroup();
                            } else {
                                composer2.startReplaceGroup(748238546);
                                composer2.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier1110;
                            shape2 = shape112;
                            sheetState2 = sheetState3;
                            f3 = f116;
                            z4 = z5;
                            j5 = j1111117;
                            function5 = function8;
                            j6 = j1111118;
                            modalBottomSheetProperties2 = modalBottomSheetProperties12;
                            function6 = function111111116;
                            f4 = fM10168constructorimpl;
                            j4 = j1111116;
                        } else {
                            f6 = f5;
                        }
                        objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        final Function0 function111111118 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i21 > 256) {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        } else {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        }
                        boolean zChangedInstance1111 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                        if (i22 == 4) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z11 = zChangedInstance1111 | z10;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z11) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function111111119 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float f117 = f6;
                        str2 = str;
                        i23 = i9;
                        final Modifier modifier1111 = modifier2;
                        final long j1111119 = scrimColor;
                        final Shape shape113 = expandedShape;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        final long j11111110 = j7;
                        final long j11111111 = jM3712contentColorForek8zF_U;
                        final Function2 function1111111110 = function9;
                        Function2 function1111111111 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties12, function111111118, j1111119, modifier1111, function0, f117, z5, function8, function1111111110, shape113, j11111110, j11111111, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        composer2 = composerStartRestartGroup;
                        z12 = true;
                        ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function111111119, j11111111, modalBottomSheetProperties12, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function1111111111, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i39 & 896), 0);
                        if (sheetState3.getHasExpandedState()) {
                            composer2.startReplaceGroup(748177042);
                            ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                            ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                            if (i21 > 256) {
                            }
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                            if (!z12) {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            } else {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(748238546);
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier1111;
                        shape2 = shape113;
                        sheetState2 = sheetState3;
                        f3 = f117;
                        z4 = z5;
                        j5 = j11111110;
                        function5 = function8;
                        j6 = j11111111;
                        modalBottomSheetProperties2 = modalBottomSheetProperties12;
                        function6 = function1111111110;
                        f4 = fM10168constructorimpl;
                        j4 = j1111119;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        f3 = f;
                        j4 = j3;
                        function5 = function2;
                        function6 = function3;
                        modalBottomSheetProperties2 = modalBottomSheetProperties;
                        j5 = containerColor;
                        z4 = z2;
                        shape2 = expandedShape;
                        sheetState2 = sheetStateRememberModalBottomSheetState;
                        j6 = j2;
                        f4 = f2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final long j2114 = j4;
                        final Modifier modifier1112 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier1112, sheetState2, f3, z4, shape2, j5, j6, f4, j2114, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i17 = i15 | 384;
                if ((i2 & 3072) != 0) {
                    i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                }
                i19 = i17;
                if ((i9 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
                    if ((i & 1) != 0) {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM3513getSheetMaxWidthD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i9 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3712contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        } else {
                            fM10168constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            i19 = i20;
                        } else {
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        long j2115 = containerColor;
                        f5 = fM3513getSheetMaxWidthD9Ej5fM;
                        z5 = z2;
                        function8 = lambda$1121996006$material3;
                        j7 = j2115;
                    } else {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM3513getSheetMaxWidthD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i9 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3712contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        } else {
                            fM10168constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            i19 = i20;
                        } else {
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        long j2116 = containerColor;
                        f5 = fM3513getSheetMaxWidthD9Ej5fM;
                        z5 = z2;
                        function8 = lambda$1121996006$material3;
                        j7 = j2116;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i310 = i19;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    i21 = (i9 & 896) ^ 384;
                    final ModalBottomSheetProperties modalBottomSheetProperties13 = modalBottomSheetProperties3;
                    if (i21 > 256) {
                        function9 = function7;
                        if ((i9 & 384) != 256) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                    } else {
                        function9 = function7;
                        if ((i9 & 384) != 256) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                    }
                    boolean zChangedInstance1112 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                    i22 = i9 & 14;
                    if (i22 == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = zChangedInstance1112 | z7;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z8) {
                        f6 = f5;
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        }
                        final Function0 function1111111112 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i21 > 256) {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        } else {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        }
                        boolean zChangedInstance1113 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                        if (i22 == 4) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z11 = zChangedInstance1113 | z10;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z11) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function1111111113 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float f118 = f6;
                        str2 = str;
                        i23 = i9;
                        final Modifier modifier1113 = modifier2;
                        final long j11111112 = scrimColor;
                        final Shape shape114 = expandedShape;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        final long j11111113 = j7;
                        final long j11111114 = jM3712contentColorForek8zF_U;
                        final Function2 function1111111114 = function9;
                        Function2 function1111111115 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties13, function1111111112, j11111112, modifier1113, function0, f118, z5, function8, function1111111114, shape114, j11111113, j11111114, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        composer2 = composerStartRestartGroup;
                        z12 = true;
                        ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function1111111113, j11111114, modalBottomSheetProperties13, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function1111111115, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i310 & 896), 0);
                        if (sheetState3.getHasExpandedState()) {
                            composer2.startReplaceGroup(748177042);
                            ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                            ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                            if (i21 > 256) {
                            }
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                            if (!z12) {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            } else {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(748238546);
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier1113;
                        shape2 = shape114;
                        sheetState2 = sheetState3;
                        f3 = f118;
                        z4 = z5;
                        j5 = j11111113;
                        function5 = function8;
                        j6 = j11111114;
                        modalBottomSheetProperties2 = modalBottomSheetProperties13;
                        function6 = function1111111114;
                        f4 = fM10168constructorimpl;
                        j4 = j11111112;
                    } else {
                        f6 = f5;
                    }
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    final Function0 function1111111116 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i21 > 256) {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    } else {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    }
                    boolean zChangedInstance1114 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if (i22 == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = zChangedInstance1114 | z10;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function1111111117 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f119 = f6;
                    str2 = str;
                    i23 = i9;
                    final Modifier modifier1114 = modifier2;
                    final long j11111115 = scrimColor;
                    final Shape shape115 = expandedShape;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    final long j11111116 = j7;
                    final long j11111117 = jM3712contentColorForek8zF_U;
                    final Function2 function1111111118 = function9;
                    Function2 function1111111119 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties13, function1111111116, j11111115, modifier1114, function0, f119, z5, function8, function1111111118, shape115, j11111116, j11111117, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    composer2 = composerStartRestartGroup;
                    z12 = true;
                    ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function1111111117, j11111117, modalBottomSheetProperties13, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function1111111119, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i310 & 896), 0);
                    if (sheetState3.getHasExpandedState()) {
                        composer2.startReplaceGroup(748177042);
                        ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                        ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                        if (i21 > 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                        if (!z12) {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(748238546);
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier1114;
                    shape2 = shape115;
                    sheetState2 = sheetState3;
                    f3 = f119;
                    z4 = z5;
                    j5 = j11111116;
                    function5 = function8;
                    j6 = j11111117;
                    modalBottomSheetProperties2 = modalBottomSheetProperties13;
                    function6 = function1111111118;
                    f4 = fM10168constructorimpl;
                    j4 = j11111115;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    f3 = f;
                    j4 = j3;
                    function5 = function2;
                    function6 = function3;
                    modalBottomSheetProperties2 = modalBottomSheetProperties;
                    j5 = containerColor;
                    z4 = z2;
                    shape2 = expandedShape;
                    sheetState2 = sheetStateRememberModalBottomSheetState;
                    j6 = j2;
                    f4 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final long j2117 = j4;
                    final Modifier modifier1115 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier1115, sheetState2, f3, z4, shape2, j5, j6, f4, j2117, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            z2 = z;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                expandedShape = shape;
                if ((i3 & 32) == 0) {
                    i27 = 65536;
                } else {
                    i27 = 65536;
                }
                i4 |= i27;
            } else {
                expandedShape = shape;
            }
            if ((i & 1572864) == 0) {
                containerColor = j;
                if ((i3 & 64) == 0) {
                    i26 = 524288;
                } else {
                    i26 = 524288;
                }
                i4 |= i26;
            } else {
                containerColor = j;
            }
            if ((i & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    i25 = i4;
                    if (composerStartRestartGroup.changed(j2)) {
                    }
                    i9 = i25 | i30;
                } else {
                    i25 = i4;
                }
                i9 = i25 | i30;
            } else {
                i9 = i4;
            }
            i10 = i3 & 256;
            if (i10 != 0) {
                i9 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i11 = 67108864;
                } else {
                    i11 = GroupFlagsKt.HasAuxSlotFlag;
                }
                i9 |= i11;
            }
            if ((i & 805306368) != 0) {
                if ((i3 & 512) == 0) {
                    i24 = 268435456;
                } else {
                    i24 = 268435456;
                }
                i9 |= i24;
            }
            i12 = i3 & 1024;
            if (i12 != 0) {
                i13 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i14 = 4;
                } else {
                    i14 = 2;
                }
                i13 = i2 | i14;
            } else {
                i13 = i2;
            }
            if ((i2 & 48) != 0) {
                i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
            }
            i15 = i13;
            i16 = i3 & 4096;
            if (i16 != 0) {
                i17 = i15;
                if ((i2 & 384) == 0) {
                    if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                        i18 = 256;
                    } else {
                        i18 = 128;
                    }
                    i17 |= i18;
                }
                if ((i2 & 3072) != 0) {
                    i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                }
                i19 = i17;
                if ((i9 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
                    if ((i & 1) != 0) {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM3513getSheetMaxWidthD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i9 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3712contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        } else {
                            fM10168constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            i19 = i20;
                        } else {
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        long j2118 = containerColor;
                        f5 = fM3513getSheetMaxWidthD9Ej5fM;
                        z5 = z2;
                        function8 = lambda$1121996006$material3;
                        j7 = j2118;
                    } else {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM3513getSheetMaxWidthD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i9 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3712contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        } else {
                            fM10168constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            i19 = i20;
                        } else {
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        long j2119 = containerColor;
                        f5 = fM3513getSheetMaxWidthD9Ej5fM;
                        z5 = z2;
                        function8 = lambda$1121996006$material3;
                        j7 = j2119;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i311 = i19;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    i21 = (i9 & 896) ^ 384;
                    final ModalBottomSheetProperties modalBottomSheetProperties14 = modalBottomSheetProperties3;
                    if (i21 > 256) {
                        function9 = function7;
                        if ((i9 & 384) != 256) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                    } else {
                        function9 = function7;
                        if ((i9 & 384) != 256) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                    }
                    boolean zChangedInstance1115 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                    i22 = i9 & 14;
                    if (i22 == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = zChangedInstance1115 | z7;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z8) {
                        f6 = f5;
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        }
                        final Function0 function11111111110 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i21 > 256) {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        } else {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        }
                        boolean zChangedInstance1116 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                        if (i22 == 4) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z11 = zChangedInstance1116 | z10;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z11) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function11111111111 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float f1110 = f6;
                        str2 = str;
                        i23 = i9;
                        final Modifier modifier1116 = modifier2;
                        final long j11111118 = scrimColor;
                        final Shape shape116 = expandedShape;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        final long j11111119 = j7;
                        final long j111111110 = jM3712contentColorForek8zF_U;
                        final Function2 function11111111112 = function9;
                        Function2 function11111111113 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties14, function11111111110, j11111118, modifier1116, function0, f1110, z5, function8, function11111111112, shape116, j11111119, j111111110, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        composer2 = composerStartRestartGroup;
                        z12 = true;
                        ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function11111111111, j111111110, modalBottomSheetProperties14, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function11111111113, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i311 & 896), 0);
                        if (sheetState3.getHasExpandedState()) {
                            composer2.startReplaceGroup(748177042);
                            ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                            ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                            if (i21 > 256) {
                            }
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                            if (!z12) {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            } else {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(748238546);
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier1116;
                        shape2 = shape116;
                        sheetState2 = sheetState3;
                        f3 = f1110;
                        z4 = z5;
                        j5 = j11111119;
                        function5 = function8;
                        j6 = j111111110;
                        modalBottomSheetProperties2 = modalBottomSheetProperties14;
                        function6 = function11111111112;
                        f4 = fM10168constructorimpl;
                        j4 = j11111118;
                    } else {
                        f6 = f5;
                    }
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    final Function0 function11111111114 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i21 > 256) {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    } else {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    }
                    boolean zChangedInstance1117 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if (i22 == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = zChangedInstance1117 | z10;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function11111111115 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f1111 = f6;
                    str2 = str;
                    i23 = i9;
                    final Modifier modifier1117 = modifier2;
                    final long j111111111 = scrimColor;
                    final Shape shape117 = expandedShape;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    final long j111111112 = j7;
                    final long j111111113 = jM3712contentColorForek8zF_U;
                    final Function2 function11111111116 = function9;
                    Function2 function11111111117 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties14, function11111111114, j111111111, modifier1117, function0, f1111, z5, function8, function11111111116, shape117, j111111112, j111111113, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    composer2 = composerStartRestartGroup;
                    z12 = true;
                    ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function11111111115, j111111113, modalBottomSheetProperties14, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function11111111117, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i311 & 896), 0);
                    if (sheetState3.getHasExpandedState()) {
                        composer2.startReplaceGroup(748177042);
                        ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                        ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                        if (i21 > 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                        if (!z12) {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(748238546);
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier1117;
                    shape2 = shape117;
                    sheetState2 = sheetState3;
                    f3 = f1111;
                    z4 = z5;
                    j5 = j111111112;
                    function5 = function8;
                    j6 = j111111113;
                    modalBottomSheetProperties2 = modalBottomSheetProperties14;
                    function6 = function11111111116;
                    f4 = fM10168constructorimpl;
                    j4 = j111111111;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    f3 = f;
                    j4 = j3;
                    function5 = function2;
                    function6 = function3;
                    modalBottomSheetProperties2 = modalBottomSheetProperties;
                    j5 = containerColor;
                    z4 = z2;
                    shape2 = expandedShape;
                    sheetState2 = sheetStateRememberModalBottomSheetState;
                    j6 = j2;
                    f4 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final long j21110 = j4;
                    final Modifier modifier1118 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier1118, sheetState2, f3, z4, shape2, j5, j6, f4, j21110, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i17 = i15 | 384;
            if ((i2 & 3072) != 0) {
                i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
            }
            i19 = i17;
            if ((i9 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
                if ((i & 1) != 0) {
                    if (i28 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM3513getSheetMaxWidthD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i9 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3712contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    } else {
                        fM10168constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        i19 = i20;
                    } else {
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    long j21111 = containerColor;
                    f5 = fM3513getSheetMaxWidthD9Ej5fM;
                    z5 = z2;
                    function8 = lambda$1121996006$material3;
                    j7 = j21111;
                } else {
                    if (i28 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM3513getSheetMaxWidthD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i9 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3712contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    } else {
                        fM10168constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        i19 = i20;
                    } else {
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    long j21112 = containerColor;
                    f5 = fM3513getSheetMaxWidthD9Ej5fM;
                    z5 = z2;
                    function8 = lambda$1121996006$material3;
                    j7 = j21112;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i312 = i19;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
                i21 = (i9 & 896) ^ 384;
                final ModalBottomSheetProperties modalBottomSheetProperties15 = modalBottomSheetProperties3;
                if (i21 > 256) {
                    function9 = function7;
                    if ((i9 & 384) != 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                } else {
                    function9 = function7;
                    if ((i9 & 384) != 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                }
                boolean zChangedInstance1118 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                i22 = i9 & 14;
                if (i22 == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = zChangedInstance1118 | z7;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z8) {
                    f6 = f5;
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    final Function0 function11111111118 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i21 > 256) {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    } else {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    }
                    boolean zChangedInstance1119 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if (i22 == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = zChangedInstance1119 | z10;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function11111111119 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f1112 = f6;
                    str2 = str;
                    i23 = i9;
                    final Modifier modifier1119 = modifier2;
                    final long j111111114 = scrimColor;
                    final Shape shape118 = expandedShape;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    final long j111111115 = j7;
                    final long j111111116 = jM3712contentColorForek8zF_U;
                    final Function2 function111111111110 = function9;
                    Function2 function111111111111 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties15, function11111111118, j111111114, modifier1119, function0, f1112, z5, function8, function111111111110, shape118, j111111115, j111111116, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    composer2 = composerStartRestartGroup;
                    z12 = true;
                    ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function11111111119, j111111116, modalBottomSheetProperties15, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function111111111111, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i312 & 896), 0);
                    if (sheetState3.getHasExpandedState()) {
                        composer2.startReplaceGroup(748177042);
                        ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                        ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                        if (i21 > 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                        if (!z12) {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(748238546);
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier1119;
                    shape2 = shape118;
                    sheetState2 = sheetState3;
                    f3 = f1112;
                    z4 = z5;
                    j5 = j111111115;
                    function5 = function8;
                    j6 = j111111116;
                    modalBottomSheetProperties2 = modalBottomSheetProperties15;
                    function6 = function111111111110;
                    f4 = fM10168constructorimpl;
                    j4 = j111111114;
                } else {
                    f6 = f5;
                }
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                final Function0 function111111111112 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                if (i21 > 256) {
                    str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                    if ((i9 & 384) != 256) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                } else {
                    str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                    if ((i9 & 384) != 256) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                }
                boolean zChangedInstance11110 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                if (i22 == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = zChangedInstance11110 | z10;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z11) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function111111111113 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float f1113 = f6;
                str2 = str;
                i23 = i9;
                final Modifier modifier11110 = modifier2;
                final long j111111117 = scrimColor;
                final Shape shape119 = expandedShape;
                sheetState3 = sheetStateRememberModalBottomSheetState;
                final long j111111118 = j7;
                final long j111111119 = jM3712contentColorForek8zF_U;
                final Function2 function111111111114 = function9;
                Function2 function111111111115 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties15, function111111111112, j111111117, modifier11110, function0, f1113, z5, function8, function111111111114, shape119, j111111118, j111111119, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                composer2 = composerStartRestartGroup;
                z12 = true;
                ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function111111111113, j111111119, modalBottomSheetProperties15, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function111111111115, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i312 & 896), 0);
                if (sheetState3.getHasExpandedState()) {
                    composer2.startReplaceGroup(748177042);
                    ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                    ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                    if (i21 > 256) {
                    }
                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                    if (!z12) {
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                        composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                    } else {
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                        composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(748238546);
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier11110;
                shape2 = shape119;
                sheetState2 = sheetState3;
                f3 = f1113;
                z4 = z5;
                j5 = j111111118;
                function5 = function8;
                j6 = j111111119;
                modalBottomSheetProperties2 = modalBottomSheetProperties15;
                function6 = function111111111114;
                f4 = fM10168constructorimpl;
                j4 = j111111117;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                f3 = f;
                j4 = j3;
                function5 = function2;
                function6 = function3;
                modalBottomSheetProperties2 = modalBottomSheetProperties;
                j5 = containerColor;
                z4 = z2;
                shape2 = expandedShape;
                sheetState2 = sheetStateRememberModalBottomSheetState;
                j6 = j2;
                f4 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final long j21113 = j4;
                final Modifier modifier11111 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier11111, sheetState2, f3, z4, shape2, j5, j6, f4, j21113, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        i7 = i3 & 16;
        if (i7 != 0) {
            if ((i & 24576) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                expandedShape = shape;
                if ((i3 & 32) == 0) {
                    i27 = 65536;
                } else {
                    i27 = 65536;
                }
                i4 |= i27;
            } else {
                expandedShape = shape;
            }
            if ((i & 1572864) == 0) {
                containerColor = j;
                if ((i3 & 64) == 0) {
                    i26 = 524288;
                } else {
                    i26 = 524288;
                }
                i4 |= i26;
            } else {
                containerColor = j;
            }
            if ((i & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    i25 = i4;
                    if (composerStartRestartGroup.changed(j2)) {
                    }
                    i9 = i25 | i30;
                } else {
                    i25 = i4;
                }
                i9 = i25 | i30;
            } else {
                i9 = i4;
            }
            i10 = i3 & 256;
            if (i10 != 0) {
                i9 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i11 = 67108864;
                } else {
                    i11 = GroupFlagsKt.HasAuxSlotFlag;
                }
                i9 |= i11;
            }
            if ((i & 805306368) != 0) {
                if ((i3 & 512) == 0) {
                    i24 = 268435456;
                } else {
                    i24 = 268435456;
                }
                i9 |= i24;
            }
            i12 = i3 & 1024;
            if (i12 != 0) {
                i13 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i14 = 4;
                } else {
                    i14 = 2;
                }
                i13 = i2 | i14;
            } else {
                i13 = i2;
            }
            if ((i2 & 48) != 0) {
                i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
            }
            i15 = i13;
            i16 = i3 & 4096;
            if (i16 != 0) {
                i17 = i15;
                if ((i2 & 384) == 0) {
                    if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                        i18 = 256;
                    } else {
                        i18 = 128;
                    }
                    i17 |= i18;
                }
                if ((i2 & 3072) != 0) {
                    i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                }
                i19 = i17;
                if ((i9 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
                    if ((i & 1) != 0) {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM3513getSheetMaxWidthD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i9 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3712contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        } else {
                            fM10168constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            i19 = i20;
                        } else {
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        long j21114 = containerColor;
                        f5 = fM3513getSheetMaxWidthD9Ej5fM;
                        z5 = z2;
                        function8 = lambda$1121996006$material3;
                        j7 = j21114;
                    } else {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM3513getSheetMaxWidthD9Ej5fM = f;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i9 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3712contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        } else {
                            fM10168constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            i19 = i20;
                        } else {
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        long j21115 = containerColor;
                        f5 = fM3513getSheetMaxWidthD9Ej5fM;
                        z5 = z2;
                        function8 = lambda$1121996006$material3;
                        j7 = j21115;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i313 = i19;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    i21 = (i9 & 896) ^ 384;
                    final ModalBottomSheetProperties modalBottomSheetProperties16 = modalBottomSheetProperties3;
                    if (i21 > 256) {
                        function9 = function7;
                        if ((i9 & 384) != 256) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                    } else {
                        function9 = function7;
                        if ((i9 & 384) != 256) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                    }
                    boolean zChangedInstance11111 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                    i22 = i9 & 14;
                    if (i22 == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = zChangedInstance11111 | z7;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z8) {
                        f6 = f5;
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        }
                        final Function0 function111111111116 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i21 > 256) {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        } else {
                            str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                            if ((i9 & 384) != 256) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        }
                        boolean zChangedInstance11112 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                        if (i22 == 4) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z11 = zChangedInstance11112 | z10;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z11) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function111111111117 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float f1114 = f6;
                        str2 = str;
                        i23 = i9;
                        final Modifier modifier11112 = modifier2;
                        final long j1111111110 = scrimColor;
                        final Shape shape1110 = expandedShape;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        final long j1111111111 = j7;
                        final long j1111111112 = jM3712contentColorForek8zF_U;
                        final Function2 function111111111118 = function9;
                        Function2 function111111111119 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties16, function111111111116, j1111111110, modifier11112, function0, f1114, z5, function8, function111111111118, shape1110, j1111111111, j1111111112, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        composer2 = composerStartRestartGroup;
                        z12 = true;
                        ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function111111111117, j1111111112, modalBottomSheetProperties16, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function111111111119, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i313 & 896), 0);
                        if (sheetState3.getHasExpandedState()) {
                            composer2.startReplaceGroup(748177042);
                            ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                            ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                            if (i21 > 256) {
                            }
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                            if (!z12) {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            } else {
                                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                                composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(748238546);
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier11112;
                        shape2 = shape1110;
                        sheetState2 = sheetState3;
                        f3 = f1114;
                        z4 = z5;
                        j5 = j1111111111;
                        function5 = function8;
                        j6 = j1111111112;
                        modalBottomSheetProperties2 = modalBottomSheetProperties16;
                        function6 = function111111111118;
                        f4 = fM10168constructorimpl;
                        j4 = j1111111110;
                    } else {
                        f6 = f5;
                    }
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    final Function0 function1111111111110 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i21 > 256) {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    } else {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    }
                    boolean zChangedInstance11113 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if (i22 == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = zChangedInstance11113 | z10;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function1111111111111 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f1115 = f6;
                    str2 = str;
                    i23 = i9;
                    final Modifier modifier11113 = modifier2;
                    final long j1111111113 = scrimColor;
                    final Shape shape1111 = expandedShape;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    final long j1111111114 = j7;
                    final long j1111111115 = jM3712contentColorForek8zF_U;
                    final Function2 function1111111111112 = function9;
                    Function2 function1111111111113 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties16, function1111111111110, j1111111113, modifier11113, function0, f1115, z5, function8, function1111111111112, shape1111, j1111111114, j1111111115, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    composer2 = composerStartRestartGroup;
                    z12 = true;
                    ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function1111111111111, j1111111115, modalBottomSheetProperties16, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function1111111111113, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i313 & 896), 0);
                    if (sheetState3.getHasExpandedState()) {
                        composer2.startReplaceGroup(748177042);
                        ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                        ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                        if (i21 > 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                        if (!z12) {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(748238546);
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier11113;
                    shape2 = shape1111;
                    sheetState2 = sheetState3;
                    f3 = f1115;
                    z4 = z5;
                    j5 = j1111111114;
                    function5 = function8;
                    j6 = j1111111115;
                    modalBottomSheetProperties2 = modalBottomSheetProperties16;
                    function6 = function1111111111112;
                    f4 = fM10168constructorimpl;
                    j4 = j1111111113;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    f3 = f;
                    j4 = j3;
                    function5 = function2;
                    function6 = function3;
                    modalBottomSheetProperties2 = modalBottomSheetProperties;
                    j5 = containerColor;
                    z4 = z2;
                    shape2 = expandedShape;
                    sheetState2 = sheetStateRememberModalBottomSheetState;
                    j6 = j2;
                    f4 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final long j21116 = j4;
                    final Modifier modifier11114 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier11114, sheetState2, f3, z4, shape2, j5, j6, f4, j21116, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i17 = i15 | 384;
            if ((i2 & 3072) != 0) {
                i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
            }
            i19 = i17;
            if ((i9 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
                if ((i & 1) != 0) {
                    if (i28 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM3513getSheetMaxWidthD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i9 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3712contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    } else {
                        fM10168constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        i19 = i20;
                    } else {
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    long j21117 = containerColor;
                    f5 = fM3513getSheetMaxWidthD9Ej5fM;
                    z5 = z2;
                    function8 = lambda$1121996006$material3;
                    j7 = j21117;
                } else {
                    if (i28 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM3513getSheetMaxWidthD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i9 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3712contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    } else {
                        fM10168constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        i19 = i20;
                    } else {
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    long j21118 = containerColor;
                    f5 = fM3513getSheetMaxWidthD9Ej5fM;
                    z5 = z2;
                    function8 = lambda$1121996006$material3;
                    j7 = j21118;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i314 = i19;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
                i21 = (i9 & 896) ^ 384;
                final ModalBottomSheetProperties modalBottomSheetProperties17 = modalBottomSheetProperties3;
                if (i21 > 256) {
                    function9 = function7;
                    if ((i9 & 384) != 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                } else {
                    function9 = function7;
                    if ((i9 & 384) != 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                }
                boolean zChangedInstance11114 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                i22 = i9 & 14;
                if (i22 == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = zChangedInstance11114 | z7;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z8) {
                    f6 = f5;
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    final Function0 function1111111111114 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i21 > 256) {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    } else {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    }
                    boolean zChangedInstance11115 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if (i22 == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = zChangedInstance11115 | z10;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function1111111111115 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f1116 = f6;
                    str2 = str;
                    i23 = i9;
                    final Modifier modifier11115 = modifier2;
                    final long j1111111116 = scrimColor;
                    final Shape shape1112 = expandedShape;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    final long j1111111117 = j7;
                    final long j1111111118 = jM3712contentColorForek8zF_U;
                    final Function2 function1111111111116 = function9;
                    Function2 function1111111111117 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties17, function1111111111114, j1111111116, modifier11115, function0, f1116, z5, function8, function1111111111116, shape1112, j1111111117, j1111111118, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    composer2 = composerStartRestartGroup;
                    z12 = true;
                    ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function1111111111115, j1111111118, modalBottomSheetProperties17, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function1111111111117, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i314 & 896), 0);
                    if (sheetState3.getHasExpandedState()) {
                        composer2.startReplaceGroup(748177042);
                        ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                        ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                        if (i21 > 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                        if (!z12) {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(748238546);
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier11115;
                    shape2 = shape1112;
                    sheetState2 = sheetState3;
                    f3 = f1116;
                    z4 = z5;
                    j5 = j1111111117;
                    function5 = function8;
                    j6 = j1111111118;
                    modalBottomSheetProperties2 = modalBottomSheetProperties17;
                    function6 = function1111111111116;
                    f4 = fM10168constructorimpl;
                    j4 = j1111111116;
                } else {
                    f6 = f5;
                }
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                final Function0 function1111111111118 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                if (i21 > 256) {
                    str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                    if ((i9 & 384) != 256) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                } else {
                    str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                    if ((i9 & 384) != 256) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                }
                boolean zChangedInstance11116 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                if (i22 == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = zChangedInstance11116 | z10;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z11) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function1111111111119 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float f1117 = f6;
                str2 = str;
                i23 = i9;
                final Modifier modifier11116 = modifier2;
                final long j1111111119 = scrimColor;
                final Shape shape1113 = expandedShape;
                sheetState3 = sheetStateRememberModalBottomSheetState;
                final long j11111111110 = j7;
                final long j11111111111 = jM3712contentColorForek8zF_U;
                final Function2 function11111111111110 = function9;
                Function2 function11111111111111 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties17, function1111111111118, j1111111119, modifier11116, function0, f1117, z5, function8, function11111111111110, shape1113, j11111111110, j11111111111, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                composer2 = composerStartRestartGroup;
                z12 = true;
                ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function1111111111119, j11111111111, modalBottomSheetProperties17, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function11111111111111, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i314 & 896), 0);
                if (sheetState3.getHasExpandedState()) {
                    composer2.startReplaceGroup(748177042);
                    ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                    ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                    if (i21 > 256) {
                    }
                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                    if (!z12) {
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                        composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                    } else {
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                        composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(748238546);
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier11116;
                shape2 = shape1113;
                sheetState2 = sheetState3;
                f3 = f1117;
                z4 = z5;
                j5 = j11111111110;
                function5 = function8;
                j6 = j11111111111;
                modalBottomSheetProperties2 = modalBottomSheetProperties17;
                function6 = function11111111111110;
                f4 = fM10168constructorimpl;
                j4 = j1111111119;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                f3 = f;
                j4 = j3;
                function5 = function2;
                function6 = function3;
                modalBottomSheetProperties2 = modalBottomSheetProperties;
                j5 = containerColor;
                z4 = z2;
                shape2 = expandedShape;
                sheetState2 = sheetStateRememberModalBottomSheetState;
                j6 = j2;
                f4 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final long j21119 = j4;
                final Modifier modifier11117 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier11117, sheetState2, f3, z4, shape2, j5, j6, f4, j21119, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        z2 = z;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            expandedShape = shape;
            if ((i3 & 32) == 0) {
                i27 = 65536;
            } else {
                i27 = 65536;
            }
            i4 |= i27;
        } else {
            expandedShape = shape;
        }
        if ((i & 1572864) == 0) {
            containerColor = j;
            if ((i3 & 64) == 0) {
                i26 = 524288;
            } else {
                i26 = 524288;
            }
            i4 |= i26;
        } else {
            containerColor = j;
        }
        if ((i & 12582912) == 0) {
            if ((i3 & 128) == 0) {
                i25 = i4;
                if (composerStartRestartGroup.changed(j2)) {
                }
                i9 = i25 | i30;
            } else {
                i25 = i4;
            }
            i9 = i25 | i30;
        } else {
            i9 = i4;
        }
        i10 = i3 & 256;
        if (i10 != 0) {
            i9 |= 100663296;
        } else if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(f2)) {
                i11 = 67108864;
            } else {
                i11 = GroupFlagsKt.HasAuxSlotFlag;
            }
            i9 |= i11;
        }
        if ((i & 805306368) != 0) {
            if ((i3 & 512) == 0) {
                i24 = 268435456;
            } else {
                i24 = 268435456;
            }
            i9 |= i24;
        }
        i12 = i3 & 1024;
        if (i12 != 0) {
            i13 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i13 = i2 | i14;
        } else {
            i13 = i2;
        }
        if ((i2 & 48) != 0) {
            i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
        }
        i15 = i13;
        i16 = i3 & 4096;
        if (i16 != 0) {
            i17 = i15;
            if ((i2 & 384) == 0) {
                if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                    i18 = 256;
                } else {
                    i18 = 128;
                }
                i17 |= i18;
            }
            if ((i2 & 3072) != 0) {
                i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
            }
            i19 = i17;
            if ((i9 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
                if ((i & 1) != 0) {
                    if (i28 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM3513getSheetMaxWidthD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i9 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3712contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    } else {
                        fM10168constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        i19 = i20;
                    } else {
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    long j211110 = containerColor;
                    f5 = fM3513getSheetMaxWidthD9Ej5fM;
                    z5 = z2;
                    function8 = lambda$1121996006$material3;
                    j7 = j211110;
                } else {
                    if (i28 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM3513getSheetMaxWidthD9Ej5fM = f;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i9 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3712contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    } else {
                        fM10168constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        i19 = i20;
                    } else {
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    long j211111 = containerColor;
                    f5 = fM3513getSheetMaxWidthD9Ej5fM;
                    z5 = z2;
                    function8 = lambda$1121996006$material3;
                    j7 = j211111;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i315 = i19;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
                i21 = (i9 & 896) ^ 384;
                final ModalBottomSheetProperties modalBottomSheetProperties18 = modalBottomSheetProperties3;
                if (i21 > 256) {
                    function9 = function7;
                    if ((i9 & 384) != 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                } else {
                    function9 = function7;
                    if ((i9 & 384) != 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                }
                boolean zChangedInstance11117 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
                i22 = i9 & 14;
                if (i22 == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = zChangedInstance11117 | z7;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z8) {
                    f6 = f5;
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    final Function0 function11111111111112 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i21 > 256) {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    } else {
                        str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                        if ((i9 & 384) != 256) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    }
                    boolean zChangedInstance11118 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if (i22 == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = zChangedInstance11118 | z10;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function11111111111113 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f1118 = f6;
                    str2 = str;
                    i23 = i9;
                    final Modifier modifier11118 = modifier2;
                    final long j11111111112 = scrimColor;
                    final Shape shape1114 = expandedShape;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    final long j11111111113 = j7;
                    final long j11111111114 = jM3712contentColorForek8zF_U;
                    final Function2 function11111111111114 = function9;
                    Function2 function11111111111115 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties18, function11111111111112, j11111111112, modifier11118, function0, f1118, z5, function8, function11111111111114, shape1114, j11111111113, j11111111114, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    composer2 = composerStartRestartGroup;
                    z12 = true;
                    ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function11111111111113, j11111111114, modalBottomSheetProperties18, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function11111111111115, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i315 & 896), 0);
                    if (sheetState3.getHasExpandedState()) {
                        composer2.startReplaceGroup(748177042);
                        ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                        ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                        if (i21 > 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                        if (!z12) {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                            composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(748238546);
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier11118;
                    shape2 = shape1114;
                    sheetState2 = sheetState3;
                    f3 = f1118;
                    z4 = z5;
                    j5 = j11111111113;
                    function5 = function8;
                    j6 = j11111111114;
                    modalBottomSheetProperties2 = modalBottomSheetProperties18;
                    function6 = function11111111111114;
                    f4 = fM10168constructorimpl;
                    j4 = j11111111112;
                } else {
                    f6 = f5;
                }
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                final Function0 function11111111111116 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                if (i21 > 256) {
                    str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                    if ((i9 & 384) != 256) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                } else {
                    str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                    if ((i9 & 384) != 256) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                }
                boolean zChangedInstance11119 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                if (i22 == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = zChangedInstance11119 | z10;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z11) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function11111111111117 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float f1119 = f6;
                str2 = str;
                i23 = i9;
                final Modifier modifier11119 = modifier2;
                final long j11111111115 = scrimColor;
                final Shape shape1115 = expandedShape;
                sheetState3 = sheetStateRememberModalBottomSheetState;
                final long j11111111116 = j7;
                final long j11111111117 = jM3712contentColorForek8zF_U;
                final Function2 function11111111111118 = function9;
                Function2 function11111111111119 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties18, function11111111111116, j11111111115, modifier11119, function0, f1119, z5, function8, function11111111111118, shape1115, j11111111116, j11111111117, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                composer2 = composerStartRestartGroup;
                z12 = true;
                ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function11111111111117, j11111111117, modalBottomSheetProperties18, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function11111111111119, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i315 & 896), 0);
                if (sheetState3.getHasExpandedState()) {
                    composer2.startReplaceGroup(748177042);
                    ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                    ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                    if (i21 > 256) {
                    }
                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                    if (!z12) {
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                        composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                    } else {
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                        composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(748238546);
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier11119;
                shape2 = shape1115;
                sheetState2 = sheetState3;
                f3 = f1119;
                z4 = z5;
                j5 = j11111111116;
                function5 = function8;
                j6 = j11111111117;
                modalBottomSheetProperties2 = modalBottomSheetProperties18;
                function6 = function11111111111118;
                f4 = fM10168constructorimpl;
                j4 = j11111111115;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                f3 = f;
                j4 = j3;
                function5 = function2;
                function6 = function3;
                modalBottomSheetProperties2 = modalBottomSheetProperties;
                j5 = containerColor;
                z4 = z2;
                shape2 = expandedShape;
                sheetState2 = sheetStateRememberModalBottomSheetState;
                j6 = j2;
                f4 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final long j211112 = j4;
                final Modifier modifier111110 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier111110, sheetState2, f3, z4, shape2, j5, j6, f4, j211112, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i17 = i15 | 384;
        if ((i2 & 3072) != 0) {
            i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
        }
        i19 = i17;
        if ((i9 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "95@4948L31,98@5121L13,99@5184L14,100@5226L31,102@5334L10");
            if ((i & 1) != 0) {
                if (i28 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i3 & 4) != 0) {
                    i9 &= -897;
                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                }
                if (i5 != 0) {
                    fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                } else {
                    fM3513getSheetMaxWidthD9Ej5fM = f;
                }
                if (i7 != 0) {
                    z2 = true;
                }
                if ((i3 & 32) != 0) {
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i9 &= -458753;
                }
                if ((i3 & 64) != 0) {
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i9 &= -3670017;
                }
                if ((i3 & 128) != 0) {
                    jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                    i9 &= -29360129;
                } else {
                    jM3712contentColorForek8zF_U = j2;
                }
                if (i10 != 0) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                } else {
                    fM10168constructorimpl = f2;
                }
                if ((i3 & 512) != 0) {
                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i9 &= -1879048193;
                } else {
                    scrimColor = j3;
                }
                if (i12 != 0) {
                    lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                } else {
                    lambda$1121996006$material3 = function2;
                }
                if ((i3 & 2048) != 0) {
                    function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    i19 &= -113;
                } else {
                    function7 = function3;
                }
                i20 = i19;
                if (i16 != 0) {
                    modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                    i19 = i20;
                } else {
                    modalBottomSheetProperties3 = modalBottomSheetProperties;
                }
                long j211113 = containerColor;
                f5 = fM3513getSheetMaxWidthD9Ej5fM;
                z5 = z2;
                function8 = lambda$1121996006$material3;
                j7 = j211113;
            } else {
                if (i28 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i3 & 4) != 0) {
                    i9 &= -897;
                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                }
                if (i5 != 0) {
                    fM3513getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m3513getSheetMaxWidthD9Ej5fM();
                } else {
                    fM3513getSheetMaxWidthD9Ej5fM = f;
                }
                if (i7 != 0) {
                    z2 = true;
                }
                if ((i3 & 32) != 0) {
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i9 &= -458753;
                }
                if ((i3 & 64) != 0) {
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i9 &= -3670017;
                }
                if ((i3 & 128) != 0) {
                    jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                    i9 &= -29360129;
                } else {
                    jM3712contentColorForek8zF_U = j2;
                }
                if (i10 != 0) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                } else {
                    fM10168constructorimpl = f2;
                }
                if ((i3 & 512) != 0) {
                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i9 &= -1879048193;
                } else {
                    scrimColor = j3;
                }
                if (i12 != 0) {
                    lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                } else {
                    lambda$1121996006$material3 = function2;
                }
                if ((i3 & 2048) != 0) {
                    function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    i19 &= -113;
                } else {
                    function7 = function3;
                }
                i20 = i19;
                if (i16 != 0) {
                    modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                    i19 = i20;
                } else {
                    modalBottomSheetProperties3 = modalBottomSheetProperties;
                }
                long j211114 = containerColor;
                f5 = fM3513getSheetMaxWidthD9Ej5fM;
                z5 = z2;
                function8 = lambda$1121996006$material3;
                j7 = j211114;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1904798512, i9, i19, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:107)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i316 = i19;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855331328, "CC(remember):ModalBottomSheet.kt#9igjgp");
            i21 = (i9 & 896) ^ 384;
            final ModalBottomSheetProperties modalBottomSheetProperties19 = modalBottomSheetProperties3;
            if (i21 > 256) {
                function9 = function7;
                if ((i9 & 384) != 256) {
                    z6 = true;
                } else {
                    z6 = false;
                }
            } else {
                function9 = function7;
                if ((i9 & 384) != 256) {
                    z6 = true;
                } else {
                    z6 = false;
                }
            }
            boolean zChangedInstance111110 = z6 | composerStartRestartGroup.changedInstance(coroutineScope);
            i22 = i9 & 14;
            if (i22 == 4) {
                z7 = true;
            } else {
                z7 = false;
            }
            z8 = zChangedInstance111110 | z7;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z8) {
                f6 = f5;
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                final Function0 function111111111111110 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
                if (i21 > 256) {
                    str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                    if ((i9 & 384) != 256) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                } else {
                    str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                    if ((i9 & 384) != 256) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                }
                boolean zChangedInstance111111 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
                if (i22 == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = zChangedInstance111111 | z10;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z11) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function111111111111111 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float f11110 = f6;
                str2 = str;
                i23 = i9;
                final Modifier modifier111111 = modifier2;
                final long j11111111118 = scrimColor;
                final Shape shape1116 = expandedShape;
                sheetState3 = sheetStateRememberModalBottomSheetState;
                final long j11111111119 = j7;
                final long j111111111110 = jM3712contentColorForek8zF_U;
                final Function2 function111111111111112 = function9;
                Function2 function111111111111113 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties19, function111111111111110, j11111111118, modifier111111, function0, f11110, z5, function8, function111111111111112, shape1116, j11111111119, j111111111110, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                composer2 = composerStartRestartGroup;
                z12 = true;
                ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function111111111111111, j111111111110, modalBottomSheetProperties19, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function111111111111113, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i316 & 896), 0);
                if (sheetState3.getHasExpandedState()) {
                    composer2.startReplaceGroup(748177042);
                    ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                    ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                    if (i21 > 256) {
                    }
                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                    if (!z12) {
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                        composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                    } else {
                        modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                        composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(748238546);
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier111111;
                shape2 = shape1116;
                sheetState2 = sheetState3;
                f3 = f11110;
                z4 = z5;
                j5 = j11111111119;
                function5 = function8;
                j6 = j111111111110;
                modalBottomSheetProperties2 = modalBottomSheetProperties19;
                function6 = function111111111111112;
                f4 = fM10168constructorimpl;
                j4 = j11111111118;
            } else {
                f6 = f5;
            }
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            final Function0 function111111111111114 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855342634, "CC(remember):ModalBottomSheet.kt#9igjgp");
            if (i21 > 256) {
                str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                if ((i9 & 384) != 256) {
                    z9 = true;
                } else {
                    z9 = false;
                }
            } else {
                str = "CC(remember):ModalBottomSheet.kt#9igjgp";
                if ((i9 & 384) != 256) {
                    z9 = true;
                } else {
                    z9 = false;
                }
            }
            boolean zChangedInstance111112 = z9 | composerStartRestartGroup.changedInstance(coroutineScope);
            if (i22 == 4) {
                z10 = true;
            } else {
                z10 = false;
            }
            z11 = zChangedInstance111112 | z10;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z11) {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetStateRememberModalBottomSheetState, coroutineScope, function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function0 function111111111111115 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float f11111 = f6;
            str2 = str;
            i23 = i9;
            final Modifier modifier111112 = modifier2;
            final long j111111111111 = scrimColor;
            final Shape shape1117 = expandedShape;
            sheetState3 = sheetStateRememberModalBottomSheetState;
            final long j111111111112 = j7;
            final long j111111111113 = jM3712contentColorForek8zF_U;
            final Function2 function111111111111116 = function9;
            Function2 function111111111111117 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3(sheetState3, modalBottomSheetProperties19, function111111111111114, j111111111111, modifier111112, function0, f11111, z5, function8, function111111111111116, shape1117, j111111111112, j111111111113, fM10168constructorimpl, function4, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            composer2 = composerStartRestartGroup;
            z12 = true;
            ModalBottomSheet_androidKt.m4357ModalBottomSheetDialogsW7UJKQ(function111111111111115, j111111111113, modalBottomSheetProperties19, ComposableLambdaKt.rememberComposableLambda(-1328793519, true, function111111111111117, composer2, 54), composer2, ((i23 >> 18) & 112) | 3072 | (i316 & 896), 0);
            if (sheetState3.getHasExpandedState()) {
                composer2.startReplaceGroup(748177042);
                ComposerKt.sourceInformation(composer2, "172@8513L21,172@8486L48");
                ComposerKt.sourceInformationMarkerStart(composer2, 855419877, str2);
                if (i21 > 256) {
                }
                modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = composer2.rememberedValue();
                if (!z12) {
                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                    composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                } else {
                    modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$3$1(sheetState3, null);
                    composer2.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$3$1RememberedValue, composer2, (i23 >> 6) & 14);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(748238546);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier111112;
            shape2 = shape1117;
            sheetState2 = sheetState3;
            f3 = f11111;
            z4 = z5;
            j5 = j111111111112;
            function5 = function8;
            j6 = j111111111113;
            modalBottomSheetProperties2 = modalBottomSheetProperties19;
            function6 = function111111111111116;
            f4 = fM10168constructorimpl;
            j4 = j111111111111;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            f3 = f;
            j4 = j3;
            function5 = function2;
            function6 = function3;
            modalBottomSheetProperties2 = modalBottomSheetProperties;
            j5 = containerColor;
            z4 = z2;
            shape2 = expandedShape;
            sheetState2 = sheetStateRememberModalBottomSheetState;
            j6 = j2;
            f4 = f2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final long j211115 = j4;
            final Modifier modifier111113 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(function0, modifier111113, sheetState2, f3, z4, shape2, j5, j6, f4, j211115, function5, function6, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$1$0(final SheetState sheetState, CoroutineScope coroutineScope, final Function0 function0) {
        if (sheetState.getConfirmValueChange$material3().invoke(SheetValue.Hidden).booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$animateToDismiss$1$1$1(sheetState, null), 3, null).invokeOnCompletion(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0$0(sheetState, function0, (Throwable) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$1$0$0(SheetState sheetState, Function0 function0, Throwable th) {
        if (!sheetState.isVisible()) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$2$0(SheetState sheetState, CoroutineScope coroutineScope, final Function0 function0) {
        if (sheetState.getCurrentValue() != SheetValue.Expanded || !sheetState.getHasPartiallyExpandedState()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$settleToDismiss$1$1$2(sheetState, null), 3, null).invokeOnCompletion(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0$0(function0, (Throwable) obj);
                }
            });
        } else {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$settleToDismiss$1$1$1(sheetState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$2$0$0(Function0 function0, Throwable th) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$3(final SheetState sheetState, ModalBottomSheetProperties modalBottomSheetProperties, Function0 function0, long j, Modifier modifier, Function0 function1, float f, boolean z, Function2 function2, Function2 function3, Shape shape, long j2, long j3, float f2, Function3 function4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C137@6904L27,137@6843L1589:ModalBottomSheet.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1328793519, i, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.kt:137)");
            }
            Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null));
            ComposerKt.sourceInformationMarkerStart(composer, -1365282548, "CC(remember):ModalBottomSheet.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierImePadding, false, (Function1) objRememberedValue, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierSemantics$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -2014499467, "C138@6971L54,139@7069L92,145@7368L7,143@7208L237,149@7502L29,151@7655L14,148@7458L262,154@7733L689:ModalBottomSheet.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(composer, -203531839, "CC(remember):ModalBottomSheet.kt#9igjgp");
            boolean zChanged = composer.changed(sheetState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new SheetWindowInsets(sheetState);
                composer.updateRememberedValue(objRememberedValue2);
            }
            SheetWindowInsets sheetWindowInsets = (SheetWindowInsets) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -203528665, "CC(remember):ModalBottomSheet.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3$1$1$0(sheetState));
                    }
                });
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(ModalBottomSheet_YbuCTN8$lambda$3$1$2((State) objRememberedValue3) ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6), 0.0f, "ScrimAlphaAnimation", null, composer, 3072, 20);
            Strings.Companion companion = Strings.INSTANCE;
            String strM5501getString2EP1pXo = Strings_androidKt.m5501getString2EP1pXo(Strings.m5417constructorimpl(androidx.compose.ui.R.string.close_sheet), composer, 0);
            Function0 function5 = modalBottomSheetProperties.getShouldDismissOnClickOutside() ? function0 : null;
            ComposerKt.sourceInformationMarkerStart(composer, -203509991, "CC(remember):ModalBottomSheet.kt#9igjgp");
            boolean zChanged2 = composer.changed(stateAnimateFloatAsState);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$3$1$3(stateAnimateFloatAsState));
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ScrimKt.m4537ScrimyrwZFoE(strM5501getString2EP1pXo, null, function5, (Function0) objRememberedValue4, j, composer, 0, 2);
            SheetDefaultsKt.m4645BottomSheetjyqLk6I(WindowInsetsPaddingKt.consumeWindowInsets(boxScopeInstance.align(modifier, Alignment.INSTANCE.getTopCenter()), sheetWindowInsets), sheetState, function1, f, z, modalBottomSheetProperties.getShouldDismissOnBackPress(), function2, function3, shape, j2, j3, f2, 0.0f, function4, composer, 0, 0, 4096);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$3$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalBottomSheet_YbuCTN8$lambda$3$1$1$0(SheetState sheetState) {
        return sheetState.getTargetValue() != SheetValue.Hidden;
    }

    public static final SheetState rememberModalBottomSheetState(boolean z, Function1<? super SheetValue, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -778250030, "C(rememberModalBottomSheetState)N(skipPartiallyExpanded,confirmValueChange)215@10072L8,217@10090L160:ModalBottomSheet.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -573965190, "CC(remember):ModalBottomSheet.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(ModalBottomSheetKt.rememberModalBottomSheetState$lambda$0$0((SheetValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        Function1<? super SheetValue, Boolean> function2 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-778250030, i, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.kt:217)");
        }
        SheetState sheetStateM4647rememberSheetStateAGcomas = SheetDefaultsKt.m4647rememberSheetStateAGcomas(z2, function2, SheetValue.Hidden, false, 0.0f, 0.0f, composer, (i & 14) | 384 | (i & 112), 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sheetStateM4647rememberSheetStateAGcomas;
    }

    private static final boolean ModalBottomSheet_YbuCTN8$lambda$3$1$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ModalBottomSheet_YbuCTN8$lambda$3$1$3(State<Float> state) {
        return state.getValue().floatValue();
    }
}
