package androidx.compose.material3;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Scrim.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aO\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Scrim", "", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "alpha", "", "color", "Landroidx/compose/ui/graphics/Color;", "Scrim-yrwZFoE", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;II)V", "material3"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ScrimKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_yrwZFoE$lambda$1$0() {
        return 1.0f;
    }

    static final Unit Scrim_yrwZFoE$lambda$5(String str, Modifier modifier, Function0 function0, Function0 function1, long j, int i, int i2, Composer composer, int i3) {
        m4537ScrimyrwZFoE(str, modifier, function0, function1, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x016f  */
    /* JADX WARN: Code duplicated, block: B:103:0x018e  */
    /* JADX WARN: Code duplicated, block: B:104:0x0190  */
    /* JADX WARN: Code duplicated, block: B:106:0x0193  */
    /* JADX WARN: Code duplicated, block: B:107:0x0195  */
    /* JADX WARN: Code duplicated, block: B:110:0x019d  */
    /* JADX WARN: Code duplicated, block: B:112:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:114:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:117:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:119:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:126:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:129:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:131:0x0206  */
    /* JADX WARN: Code duplicated, block: B:133:0x021b  */
    /* JADX WARN: Code duplicated, block: B:136:0x022a  */
    /* JADX WARN: Code duplicated, block: B:138:0x022f  */
    /* JADX WARN: Code duplicated, block: B:141:0x023c  */
    /* JADX WARN: Code duplicated, block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x0066  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:45:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0081  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x008e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:79:0x0105  */
    /* JADX WARN: Code duplicated, block: B:81:0x0113  */
    /* JADX WARN: Code duplicated, block: B:84:0x0119  */
    /* JADX WARN: Code duplicated, block: B:87:0x012c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0138  */
    /* JADX WARN: Code duplicated, block: B:92:0x0145  */
    /* JADX WARN: Code duplicated, block: B:94:0x015e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0160  */
    /* JADX WARN: Code duplicated, block: B:98:0x0167  */
    /* JADX INFO: renamed from: Scrim-yrwZFoE, reason: not valid java name */
    public static final void m4537ScrimyrwZFoE(final String str, Modifier modifier, Function0<Unit> function0, Function0<Float> function1, long j, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final Function0<Unit> function2;
        int i5;
        int i6;
        int i7;
        final long color;
        boolean z;
        final Function0<Float> function3;
        Modifier.Companion companion;
        final Function0<Unit> function4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Function0<Float> function5;
        Object objRememberedValue;
        Object objRememberedValue2;
        Modifier.Companion companionSemantics;
        boolean z2;
        Object objRememberedValue3;
        int i8;
        boolean z3;
        ScrimKt$Scrim$dismissModifier$1$1 scrimKt$Scrim$dismissModifier$1$1RememberedValue;
        boolean z4;
        boolean z5;
        boolean z6;
        Object objRememberedValue4;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2078815310);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)N(contentDescription,modifier,onClick,alpha,color:c#ui.graphics.Color):Scrim.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function2 = function0;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i & 24576) == 0) {
                        color = j;
                        if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(color)) {
                            i9 = 8192;
                        } else {
                            i9 = 16384;
                        }
                        i3 |= i9;
                    } else {
                        color = j;
                    }
                    if ((i3 & 9363) != 9362) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "52@2272L2,53@2301L6,54@2342L5");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581716812, "CC(remember):Scrim.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function2 = (Function0) objRememberedValue2;
                            }
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581715880, "CC(remember):Scrim.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Float.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$1$0());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function5 = (Function0) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function5 = function1;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                color = ScrimDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            companion = modifier2;
                            function5 = function1;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2078815310, i3, -1, "androidx.compose.material3.Scrim (Scrim.kt:55)");
                        }
                        if (color != 16) {
                            composerStartRestartGroup.startReplaceGroup(-853219337);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "74@3118L81,74@3054L145");
                            if (function2 != null) {
                                composerStartRestartGroup.startReplaceGroup(-853120974);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "60@2538L35,61@2630L355");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581708267, "CC(remember):Scrim.kt#9igjgp");
                                i8 = i3 & 896;
                                if (i8 == 256) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                scrimKt$Scrim$dismissModifier$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z3 || scrimKt$Scrim$dismissModifier$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    scrimKt$Scrim$dismissModifier$1$1RememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(function2);
                                    composerStartRestartGroup.updateRememberedValue(scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, function2, (PointerInputEventHandler) scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581705003, "CC(remember):Scrim.kt#9igjgp");
                                if ((i3 & 14) == 4) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (i8 == 256) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                z6 = z5 | z4;
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (!z6 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ScrimKt.Scrim_yrwZFoE$lambda$3$0(str, function2, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) objRememberedValue4);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-852623672);
                                composerStartRestartGroup.endReplaceGroup();
                                companionSemantics = Modifier.INSTANCE;
                            }
                            Modifier modifierThen = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null).then(companionSemantics);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581689661, "CC(remember):Scrim.kt#9igjgp");
                            z2 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(color)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ScrimKt.Scrim_yrwZFoE$lambda$4$0(color, function5, (DrawScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-852426512);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function3 = function5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function3 = function1;
                        companion = modifier2;
                    }
                    function4 = function2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier3 = companion;
                        final long j2 = color;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ScrimKt.Scrim_yrwZFoE$lambda$5(str, modifier3, function4, function3, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                if ((i & 24576) == 0) {
                    color = j;
                    if ((i2 & 16) == 0) {
                        i9 = 8192;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                } else {
                    color = j;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "52@2272L2,53@2301L6,54@2342L5");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581716812, "CC(remember):Scrim.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function2 = (Function0) objRememberedValue2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581715880, "CC(remember):Scrim.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Float.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$1$0());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            color = ScrimDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581716812, "CC(remember):Scrim.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function2 = (Function0) objRememberedValue2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581715880, "CC(remember):Scrim.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Float.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$1$0());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            color = ScrimDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2078815310, i3, -1, "androidx.compose.material3.Scrim (Scrim.kt:55)");
                    }
                    if (color != 16) {
                        composerStartRestartGroup.startReplaceGroup(-853219337);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "74@3118L81,74@3054L145");
                        if (function2 != null) {
                            composerStartRestartGroup.startReplaceGroup(-853120974);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "60@2538L35,61@2630L355");
                            Modifier.Companion companion3 = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581708267, "CC(remember):Scrim.kt#9igjgp");
                            i8 = i3 & 896;
                            if (i8 == 256) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            scrimKt$Scrim$dismissModifier$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z3) {
                                scrimKt$Scrim$dismissModifier$1$1RememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(function2);
                                composerStartRestartGroup.updateRememberedValue(scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                            } else {
                                scrimKt$Scrim$dismissModifier$1$1RememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(function2);
                                composerStartRestartGroup.updateRememberedValue(scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput(companion3, function2, (PointerInputEventHandler) scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581705003, "CC(remember):Scrim.kt#9igjgp");
                            if ((i3 & 14) == 4) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (i8 == 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            z6 = z5 | z4;
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!z6) {
                                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ScrimKt.Scrim_yrwZFoE$lambda$3$0(str, function2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ScrimKt.Scrim_yrwZFoE$lambda$3$0(str, function2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput2, true, (Function1) objRememberedValue4);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-852623672);
                            composerStartRestartGroup.endReplaceGroup();
                            companionSemantics = Modifier.INSTANCE;
                        }
                        Modifier modifierThen2 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null).then(companionSemantics);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581689661, "CC(remember):Scrim.kt#9igjgp");
                        z2 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(color)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScrimKt.Scrim_yrwZFoE$lambda$4$0(color, function5, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScrimKt.Scrim_yrwZFoE$lambda$4$0(color, function5, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CanvasKt.Canvas(modifierThen2, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-852426512);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function3 = function1;
                    companion = modifier2;
                }
                function4 = function2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier4 = companion;
                    final long j3 = color;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScrimKt.Scrim_yrwZFoE$lambda$5(str, modifier4, function4, function3, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            function2 = function0;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    color = j;
                    if ((i2 & 16) == 0) {
                        i9 = 8192;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                } else {
                    color = j;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "52@2272L2,53@2301L6,54@2342L5");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581716812, "CC(remember):Scrim.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function2 = (Function0) objRememberedValue2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581715880, "CC(remember):Scrim.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Float.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$1$0());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            color = ScrimDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581716812, "CC(remember):Scrim.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function2 = (Function0) objRememberedValue2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581715880, "CC(remember):Scrim.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Float.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$1$0());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            color = ScrimDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2078815310, i3, -1, "androidx.compose.material3.Scrim (Scrim.kt:55)");
                    }
                    if (color != 16) {
                        composerStartRestartGroup.startReplaceGroup(-853219337);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "74@3118L81,74@3054L145");
                        if (function2 != null) {
                            composerStartRestartGroup.startReplaceGroup(-853120974);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "60@2538L35,61@2630L355");
                            Modifier.Companion companion4 = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581708267, "CC(remember):Scrim.kt#9igjgp");
                            i8 = i3 & 896;
                            if (i8 == 256) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            scrimKt$Scrim$dismissModifier$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z3) {
                                scrimKt$Scrim$dismissModifier$1$1RememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(function2);
                                composerStartRestartGroup.updateRememberedValue(scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                            } else {
                                scrimKt$Scrim$dismissModifier$1$1RememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(function2);
                                composerStartRestartGroup.updateRememberedValue(scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierPointerInput3 = SuspendingPointerInputFilterKt.pointerInput(companion4, function2, (PointerInputEventHandler) scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581705003, "CC(remember):Scrim.kt#9igjgp");
                            if ((i3 & 14) == 4) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (i8 == 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            z6 = z5 | z4;
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!z6) {
                                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ScrimKt.Scrim_yrwZFoE$lambda$3$0(str, function2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ScrimKt.Scrim_yrwZFoE$lambda$3$0(str, function2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput3, true, (Function1) objRememberedValue4);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-852623672);
                            composerStartRestartGroup.endReplaceGroup();
                            companionSemantics = Modifier.INSTANCE;
                        }
                        Modifier modifierThen3 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null).then(companionSemantics);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581689661, "CC(remember):Scrim.kt#9igjgp");
                        z2 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(color)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScrimKt.Scrim_yrwZFoE$lambda$4$0(color, function5, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScrimKt.Scrim_yrwZFoE$lambda$4$0(color, function5, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CanvasKt.Canvas(modifierThen3, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-852426512);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function3 = function1;
                    companion = modifier2;
                }
                function4 = function2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier5 = companion;
                    final long j4 = color;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScrimKt.Scrim_yrwZFoE$lambda$5(str, modifier5, function4, function3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            if ((i & 24576) == 0) {
                color = j;
                if ((i2 & 16) == 0) {
                    i9 = 8192;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            } else {
                color = j;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "52@2272L2,53@2301L6,54@2342L5");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581716812, "CC(remember):Scrim.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function2 = (Function0) objRememberedValue2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581715880, "CC(remember):Scrim.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$1$0());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function5 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function1;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        color = ScrimDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581716812, "CC(remember):Scrim.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function2 = (Function0) objRememberedValue2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581715880, "CC(remember):Scrim.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$1$0());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function5 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function1;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        color = ScrimDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2078815310, i3, -1, "androidx.compose.material3.Scrim (Scrim.kt:55)");
                }
                if (color != 16) {
                    composerStartRestartGroup.startReplaceGroup(-853219337);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "74@3118L81,74@3054L145");
                    if (function2 != null) {
                        composerStartRestartGroup.startReplaceGroup(-853120974);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "60@2538L35,61@2630L355");
                        Modifier.Companion companion5 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581708267, "CC(remember):Scrim.kt#9igjgp");
                        i8 = i3 & 896;
                        if (i8 == 256) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        scrimKt$Scrim$dismissModifier$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            scrimKt$Scrim$dismissModifier$1$1RememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(function2);
                            composerStartRestartGroup.updateRememberedValue(scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                        } else {
                            scrimKt$Scrim$dismissModifier$1$1RememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(function2);
                            composerStartRestartGroup.updateRememberedValue(scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierPointerInput4 = SuspendingPointerInputFilterKt.pointerInput(companion5, function2, (PointerInputEventHandler) scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581705003, "CC(remember):Scrim.kt#9igjgp");
                        if ((i3 & 14) == 4) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (i8 == 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        z6 = z5 | z4;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScrimKt.Scrim_yrwZFoE$lambda$3$0(str, function2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScrimKt.Scrim_yrwZFoE$lambda$3$0(str, function2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput4, true, (Function1) objRememberedValue4);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-852623672);
                        composerStartRestartGroup.endReplaceGroup();
                        companionSemantics = Modifier.INSTANCE;
                    }
                    Modifier modifierThen4 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null).then(companionSemantics);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581689661, "CC(remember):Scrim.kt#9igjgp");
                    z2 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(color)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScrimKt.Scrim_yrwZFoE$lambda$4$0(color, function5, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScrimKt.Scrim_yrwZFoE$lambda$4$0(color, function5, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierThen4, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-852426512);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function3 = function1;
                companion = modifier2;
            }
            function4 = function2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier6 = companion;
                final long j5 = color;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScrimKt.Scrim_yrwZFoE$lambda$5(str, modifier6, function4, function3, j5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                function2 = function0;
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    color = j;
                    if ((i2 & 16) == 0) {
                        i9 = 8192;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                } else {
                    color = j;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "52@2272L2,53@2301L6,54@2342L5");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581716812, "CC(remember):Scrim.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function2 = (Function0) objRememberedValue2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581715880, "CC(remember):Scrim.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Float.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$1$0());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            color = ScrimDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581716812, "CC(remember):Scrim.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function2 = (Function0) objRememberedValue2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581715880, "CC(remember):Scrim.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Float.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$1$0());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            color = ScrimDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2078815310, i3, -1, "androidx.compose.material3.Scrim (Scrim.kt:55)");
                    }
                    if (color != 16) {
                        composerStartRestartGroup.startReplaceGroup(-853219337);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "74@3118L81,74@3054L145");
                        if (function2 != null) {
                            composerStartRestartGroup.startReplaceGroup(-853120974);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "60@2538L35,61@2630L355");
                            Modifier.Companion companion6 = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581708267, "CC(remember):Scrim.kt#9igjgp");
                            i8 = i3 & 896;
                            if (i8 == 256) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            scrimKt$Scrim$dismissModifier$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z3) {
                                scrimKt$Scrim$dismissModifier$1$1RememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(function2);
                                composerStartRestartGroup.updateRememberedValue(scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                            } else {
                                scrimKt$Scrim$dismissModifier$1$1RememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(function2);
                                composerStartRestartGroup.updateRememberedValue(scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierPointerInput5 = SuspendingPointerInputFilterKt.pointerInput(companion6, function2, (PointerInputEventHandler) scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581705003, "CC(remember):Scrim.kt#9igjgp");
                            if ((i3 & 14) == 4) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (i8 == 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            z6 = z5 | z4;
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!z6) {
                                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ScrimKt.Scrim_yrwZFoE$lambda$3$0(str, function2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ScrimKt.Scrim_yrwZFoE$lambda$3$0(str, function2, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput5, true, (Function1) objRememberedValue4);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-852623672);
                            composerStartRestartGroup.endReplaceGroup();
                            companionSemantics = Modifier.INSTANCE;
                        }
                        Modifier modifierThen5 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null).then(companionSemantics);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581689661, "CC(remember):Scrim.kt#9igjgp");
                        z2 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(color)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScrimKt.Scrim_yrwZFoE$lambda$4$0(color, function5, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScrimKt.Scrim_yrwZFoE$lambda$4$0(color, function5, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CanvasKt.Canvas(modifierThen5, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-852426512);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function3 = function1;
                    companion = modifier2;
                }
                function4 = function2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier7 = companion;
                    final long j6 = color;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScrimKt.Scrim_yrwZFoE$lambda$5(str, modifier7, function4, function3, j6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            if ((i & 24576) == 0) {
                color = j;
                if ((i2 & 16) == 0) {
                    i9 = 8192;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            } else {
                color = j;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "52@2272L2,53@2301L6,54@2342L5");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581716812, "CC(remember):Scrim.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function2 = (Function0) objRememberedValue2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581715880, "CC(remember):Scrim.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$1$0());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function5 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function1;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        color = ScrimDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581716812, "CC(remember):Scrim.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function2 = (Function0) objRememberedValue2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581715880, "CC(remember):Scrim.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$1$0());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function5 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function1;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        color = ScrimDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2078815310, i3, -1, "androidx.compose.material3.Scrim (Scrim.kt:55)");
                }
                if (color != 16) {
                    composerStartRestartGroup.startReplaceGroup(-853219337);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "74@3118L81,74@3054L145");
                    if (function2 != null) {
                        composerStartRestartGroup.startReplaceGroup(-853120974);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "60@2538L35,61@2630L355");
                        Modifier.Companion companion7 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581708267, "CC(remember):Scrim.kt#9igjgp");
                        i8 = i3 & 896;
                        if (i8 == 256) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        scrimKt$Scrim$dismissModifier$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            scrimKt$Scrim$dismissModifier$1$1RememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(function2);
                            composerStartRestartGroup.updateRememberedValue(scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                        } else {
                            scrimKt$Scrim$dismissModifier$1$1RememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(function2);
                            composerStartRestartGroup.updateRememberedValue(scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierPointerInput6 = SuspendingPointerInputFilterKt.pointerInput(companion7, function2, (PointerInputEventHandler) scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581705003, "CC(remember):Scrim.kt#9igjgp");
                        if ((i3 & 14) == 4) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (i8 == 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        z6 = z5 | z4;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScrimKt.Scrim_yrwZFoE$lambda$3$0(str, function2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScrimKt.Scrim_yrwZFoE$lambda$3$0(str, function2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput6, true, (Function1) objRememberedValue4);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-852623672);
                        composerStartRestartGroup.endReplaceGroup();
                        companionSemantics = Modifier.INSTANCE;
                    }
                    Modifier modifierThen6 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null).then(companionSemantics);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581689661, "CC(remember):Scrim.kt#9igjgp");
                    z2 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(color)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScrimKt.Scrim_yrwZFoE$lambda$4$0(color, function5, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScrimKt.Scrim_yrwZFoE$lambda$4$0(color, function5, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierThen6, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-852426512);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function3 = function1;
                companion = modifier2;
            }
            function4 = function2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier8 = companion;
                final long j7 = color;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScrimKt.Scrim_yrwZFoE$lambda$5(str, modifier8, function4, function3, j7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        function2 = function0;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                color = j;
                if ((i2 & 16) == 0) {
                    i9 = 8192;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            } else {
                color = j;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "52@2272L2,53@2301L6,54@2342L5");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581716812, "CC(remember):Scrim.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function2 = (Function0) objRememberedValue2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581715880, "CC(remember):Scrim.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$1$0());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function5 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function1;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        color = ScrimDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581716812, "CC(remember):Scrim.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function2 = (Function0) objRememberedValue2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581715880, "CC(remember):Scrim.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$1$0());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function5 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function1;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        color = ScrimDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2078815310, i3, -1, "androidx.compose.material3.Scrim (Scrim.kt:55)");
                }
                if (color != 16) {
                    composerStartRestartGroup.startReplaceGroup(-853219337);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "74@3118L81,74@3054L145");
                    if (function2 != null) {
                        composerStartRestartGroup.startReplaceGroup(-853120974);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "60@2538L35,61@2630L355");
                        Modifier.Companion companion8 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581708267, "CC(remember):Scrim.kt#9igjgp");
                        i8 = i3 & 896;
                        if (i8 == 256) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        scrimKt$Scrim$dismissModifier$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            scrimKt$Scrim$dismissModifier$1$1RememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(function2);
                            composerStartRestartGroup.updateRememberedValue(scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                        } else {
                            scrimKt$Scrim$dismissModifier$1$1RememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(function2);
                            composerStartRestartGroup.updateRememberedValue(scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierPointerInput7 = SuspendingPointerInputFilterKt.pointerInput(companion8, function2, (PointerInputEventHandler) scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581705003, "CC(remember):Scrim.kt#9igjgp");
                        if ((i3 & 14) == 4) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (i8 == 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        z6 = z5 | z4;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScrimKt.Scrim_yrwZFoE$lambda$3$0(str, function2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScrimKt.Scrim_yrwZFoE$lambda$3$0(str, function2, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput7, true, (Function1) objRememberedValue4);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-852623672);
                        composerStartRestartGroup.endReplaceGroup();
                        companionSemantics = Modifier.INSTANCE;
                    }
                    Modifier modifierThen7 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null).then(companionSemantics);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581689661, "CC(remember):Scrim.kt#9igjgp");
                    z2 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(color)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScrimKt.Scrim_yrwZFoE$lambda$4$0(color, function5, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScrimKt.Scrim_yrwZFoE$lambda$4$0(color, function5, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierThen7, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-852426512);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function3 = function1;
                companion = modifier2;
            }
            function4 = function2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier9 = companion;
                final long j8 = color;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScrimKt.Scrim_yrwZFoE$lambda$5(str, modifier9, function4, function3, j8, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        if ((i & 24576) == 0) {
            color = j;
            if ((i2 & 16) == 0) {
                i9 = 8192;
            } else {
                i9 = 8192;
            }
            i3 |= i9;
        } else {
            color = j;
        }
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "52@2272L2,53@2301L6,54@2342L5");
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581716812, "CC(remember):Scrim.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function2 = (Function0) objRememberedValue2;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581715880, "CC(remember):Scrim.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$1$0());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function5 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function5 = function1;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    color = ScrimDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581716812, "CC(remember):Scrim.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function2 = (Function0) objRememberedValue2;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581715880, "CC(remember):Scrim.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$1$0());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function5 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function5 = function1;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    color = ScrimDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2078815310, i3, -1, "androidx.compose.material3.Scrim (Scrim.kt:55)");
            }
            if (color != 16) {
                composerStartRestartGroup.startReplaceGroup(-853219337);
                ComposerKt.sourceInformation(composerStartRestartGroup, "74@3118L81,74@3054L145");
                if (function2 != null) {
                    composerStartRestartGroup.startReplaceGroup(-853120974);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "60@2538L35,61@2630L355");
                    Modifier.Companion companion9 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581708267, "CC(remember):Scrim.kt#9igjgp");
                    i8 = i3 & 896;
                    if (i8 == 256) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    scrimKt$Scrim$dismissModifier$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        scrimKt$Scrim$dismissModifier$1$1RememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(function2);
                        composerStartRestartGroup.updateRememberedValue(scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                    } else {
                        scrimKt$Scrim$dismissModifier$1$1RememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(function2);
                        composerStartRestartGroup.updateRememberedValue(scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierPointerInput8 = SuspendingPointerInputFilterKt.pointerInput(companion9, function2, (PointerInputEventHandler) scrimKt$Scrim$dismissModifier$1$1RememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581705003, "CC(remember):Scrim.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (i8 == 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z6 = z5 | z4;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScrimKt.Scrim_yrwZFoE$lambda$3$0(str, function2, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScrimKt.Scrim_yrwZFoE$lambda$3$0(str, function2, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput8, true, (Function1) objRememberedValue4);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-852623672);
                    composerStartRestartGroup.endReplaceGroup();
                    companionSemantics = Modifier.INSTANCE;
                }
                Modifier modifierThen8 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null).then(companionSemantics);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -581689661, "CC(remember):Scrim.kt#9igjgp");
                z2 = ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(color)) || (i3 & 24576) == 16384) | ((i3 & 7168) == 2048);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ScrimKt.Scrim_yrwZFoE$lambda$4$0(color, function5, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ScrimKt.Scrim_yrwZFoE$lambda$4$0(color, function5, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierThen8, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-852426512);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function3 = function1;
            companion = modifier2;
        }
        function4 = function2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier10 = companion;
            final long j9 = color;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScrimKt.Scrim_yrwZFoE$lambda$5(str, modifier10, function4, function3, j9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_yrwZFoE$lambda$3$0(String str, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, 1.0f);
        if (str != null) {
            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        }
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ScrimKt.Scrim_yrwZFoE$lambda$3$0$0(function0));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Scrim_yrwZFoE$lambda$3$0$0(Function0 function0) {
        function0.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_yrwZFoE$lambda$4$0(long j, Function0 function0, DrawScope drawScope) {
        DrawScope.m7906drawRectnJ9OG0$default(drawScope, j, 0L, 0L, RangesKt.coerceIn(((Number) function0.invoke()).floatValue(), 0.0f, 1.0f), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }
}
