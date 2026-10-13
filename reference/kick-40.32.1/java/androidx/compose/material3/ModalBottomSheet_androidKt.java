package androidx.compose.material3;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ModalBottomSheet.android.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aF\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\tH\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0000\u001a\u0013\u0010\u000f\u001a\u00020\r*\u00020\u0005H\u0000¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012²\u0006\u0015\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\tX\u008a\u0084\u0002"}, d2 = {"ModalBottomSheetDialog", "", "onDismissRequest", "Lkotlin/Function0;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Landroidx/compose/runtime/Composable;", "ModalBottomSheetDialog-sW7UJKQ", "(Lkotlin/jvm/functions/Function0;JLandroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "isFlagSecureEnabled", "", "Landroid/view/View;", "isDark", "isDark-8_81llA", "(J)Z", "material3", "currentContent"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ModalBottomSheet_androidKt {
    static final Unit ModalBottomSheetDialog_sW7UJKQ$lambda$6(Function0 function0, long j, ModalBottomSheetProperties modalBottomSheetProperties, Function2 function2, int i, int i2, Composer composer, int i3) {
        m4357ModalBottomSheetDialogsW7UJKQ(function0, j, modalBottomSheetProperties, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0231  */
    /* JADX WARN: Code duplicated, block: B:107:0x0239  */
    /* JADX WARN: Code duplicated, block: B:110:0x025d  */
    /* JADX WARN: Code duplicated, block: B:112:0x0264  */
    /* JADX WARN: Code duplicated, block: B:115:0x0271  */
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x0070  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:47:0x0089  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:71:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:74:0x0161  */
    /* JADX WARN: Code duplicated, block: B:77:0x018d  */
    /* JADX WARN: Code duplicated, block: B:81:0x019b  */
    /* JADX WARN: Code duplicated, block: B:84:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:86:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:89:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:90:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:93:0x0205  */
    /* JADX WARN: Code duplicated, block: B:94:0x0207  */
    /* JADX WARN: Code duplicated, block: B:97:0x0211  */
    /* JADX WARN: Code duplicated, block: B:99:0x0217  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: ModalBottomSheetDialog-sW7UJKQ, reason: not valid java name */
    public static final void m4357ModalBottomSheetDialogsW7UJKQ(Function0<Unit> function0, long j, ModalBottomSheetProperties modalBottomSheetProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function1;
        int i3;
        long jM3712contentColorForek8zF_U;
        ModalBottomSheetProperties modalBottomSheetProperties2;
        boolean z;
        boolean z2;
        Function0<Unit> function3;
        final long j2;
        final ModalBottomSheetProperties modalBottomSheetProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<Unit> function4;
        ModalBottomSheetProperties modalBottomSheetProperties4;
        long j3;
        Object objRememberedValue;
        View view;
        Density density;
        final LayoutDirection layoutDirection;
        CompositionContext compositionContextRememberCompositionContext;
        final State stateRememberUpdatedState;
        Object objRememberedValue2;
        UUID uuid;
        boolean zChanged;
        Object obj;
        final ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper;
        boolean zChangedInstance;
        Object objRememberedValue3;
        boolean z3;
        boolean z4;
        boolean zChanged2;
        Object objRememberedValue4;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-85756322);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalBottomSheetDialog)N(onDismissRequest,contentColor:c#ui.graphics.Color,properties,content)230@10376L7,231@10415L7,232@10470L7,233@10500L28,234@10555L29,235@10621L21,235@10604L38,237@10668L515,254@11214L129,254@11189L154,263@11360L224,263@11349L235:ModalBottomSheet.android.kt#uh7d8r");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            function1 = function0;
        } else if ((i & 6) == 0) {
            function1 = function0;
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            function1 = function0;
            i3 = i;
        }
        if ((i & 48) == 0) {
            jM3712contentColorForek8zF_U = j;
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(jM3712contentColorForek8zF_U)) ? 32 : 16;
        } else {
            jM3712contentColorForek8zF_U = j;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 384) == 0) {
                modalBottomSheetProperties2 = modalBottomSheetProperties;
                i3 |= composerStartRestartGroup.changed(modalBottomSheetProperties2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i4 = 2048;
                } else {
                    i4 = 1024;
                }
                i3 |= i4;
            }
            z = true;
            if ((i3 & 1171) != 1170) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "290@12265L2,292@12331L14,290@12295L51");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -807380064, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function4 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function4 = function1;
                    }
                    if ((i2 & 2) != 0) {
                        jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), composerStartRestartGroup, 0);
                        i3 &= -113;
                    }
                    if (i6 != 0) {
                        function3 = function4;
                        modalBottomSheetProperties4 = new ModalBottomSheetProperties(false, false, 3, null);
                        j3 = jM3712contentColorForek8zF_U;
                    } else {
                        function3 = function4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-85756322, i3, -1, "androidx.compose.material3.ModalBottomSheetDialog (ModalBottomSheet.android.kt:229)");
                    }
                    ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localView);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    view = (View) objConsume;
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume2;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    layoutDirection = (LayoutDirection) objConsume3;
                    compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i3 >> 9) & 14);
                    Object[] objArr = new Object[0];
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -807432653, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return UUID.randomUUID();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue2, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -807430655, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(view) | composerStartRestartGroup.changed(density);
                    Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper2 = new ModalBottomSheetDialogWrapper(function3, modalBottomSheetProperties4, j3, view, layoutDirection, density, uuid, null);
                        modalBottomSheetDialogWrapper2.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1379699857, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$3$0$0(stateRememberUpdatedState, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        composerStartRestartGroup.updateRememberedValue(modalBottomSheetDialogWrapper2);
                        obj = modalBottomSheetDialogWrapper2;
                    } else {
                        obj = objRememberedValue5;
                    }
                    modalBottomSheetDialogWrapper = (ModalBottomSheetDialogWrapper) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -807413569, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(modalBottomSheetDialogWrapper);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$4$0(modalBottomSheetDialogWrapper, (DisposableEffectScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.DisposableEffect(modalBottomSheetDialogWrapper, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -807408802, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(modalBottomSheetDialogWrapper);
                    if ((i3 & 14) == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    boolean z5 = zChangedInstance2 | z3;
                    if ((i3 & 896) == 256) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z6 = z5 | z4;
                    if ((((i3 & 112) ^ 48) > 32 || !composerStartRestartGroup.changed(j3)) && (i3 & 48) != 32) {
                    }
                    zChanged2 = z6 | z | composerStartRestartGroup.changed(layoutDirection.ordinal());
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        final long j4 = j3;
                        final ModalBottomSheetProperties modalBottomSheetProperties5 = modalBottomSheetProperties4;
                        final Function0<Unit> function5 = function3;
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$5$0(modalBottomSheetDialogWrapper, function5, modalBottomSheetProperties5, j4, layoutDirection);
                            }
                        };
                        function3 = function5;
                        modalBottomSheetProperties4 = modalBottomSheetProperties5;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue4, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j2 = j3;
                    modalBottomSheetProperties3 = modalBottomSheetProperties4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    function3 = function1;
                }
                j3 = jM3712contentColorForek8zF_U;
                modalBottomSheetProperties4 = modalBottomSheetProperties2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-85756322, i3, -1, "androidx.compose.material3.ModalBottomSheetDialog (ModalBottomSheet.android.kt:229)");
                }
                ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localView2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume4;
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume5;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                layoutDirection = (LayoutDirection) objConsume6;
                compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i3 >> 9) & 14);
                Object[] objArr2 = new Object[0];
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -807432653, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return UUID.randomUUID();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr2, (Function0) objRememberedValue2, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -807430655, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(view) | composerStartRestartGroup.changed(density);
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper3 = new ModalBottomSheetDialogWrapper(function3, modalBottomSheetProperties4, j3, view, layoutDirection, density, uuid, null);
                    modalBottomSheetDialogWrapper3.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1379699857, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$3$0$0(stateRememberUpdatedState, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    composerStartRestartGroup.updateRememberedValue(modalBottomSheetDialogWrapper3);
                    obj = modalBottomSheetDialogWrapper3;
                } else {
                    ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper4 = new ModalBottomSheetDialogWrapper(function3, modalBottomSheetProperties4, j3, view, layoutDirection, density, uuid, null);
                    modalBottomSheetDialogWrapper4.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1379699857, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$3$0$0(stateRememberUpdatedState, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    composerStartRestartGroup.updateRememberedValue(modalBottomSheetDialogWrapper4);
                    obj = modalBottomSheetDialogWrapper4;
                }
                modalBottomSheetDialogWrapper = (ModalBottomSheetDialogWrapper) obj;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -807413569, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(modalBottomSheetDialogWrapper);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$4$0(modalBottomSheetDialogWrapper, (DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$4$0(modalBottomSheetDialogWrapper, (DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(modalBottomSheetDialogWrapper, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -807408802, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(modalBottomSheetDialogWrapper);
                if ((i3 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z7 = zChangedInstance3 | z3;
                if ((i3 & 896) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z8 = z7 | z4;
                z = ((i3 & 112) ^ 48) > 32 ? false : false;
                zChanged2 = z8 | z | composerStartRestartGroup.changed(layoutDirection.ordinal());
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    final long j5 = j3;
                    final ModalBottomSheetProperties modalBottomSheetProperties6 = modalBottomSheetProperties4;
                    final Function0 function6 = function3;
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$5$0(modalBottomSheetDialogWrapper, function6, modalBottomSheetProperties6, j5, layoutDirection);
                        }
                    };
                    function3 = function6;
                    modalBottomSheetProperties4 = modalBottomSheetProperties6;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    final long j6 = j3;
                    final ModalBottomSheetProperties modalBottomSheetProperties7 = modalBottomSheetProperties4;
                    final Function0 function7 = function3;
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$5$0(modalBottomSheetDialogWrapper, function7, modalBottomSheetProperties7, j6, layoutDirection);
                        }
                    };
                    function3 = function7;
                    modalBottomSheetProperties4 = modalBottomSheetProperties7;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue4, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = j3;
                modalBottomSheetProperties3 = modalBottomSheetProperties4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function3 = function1;
                j2 = jM3712contentColorForek8zF_U;
                modalBottomSheetProperties3 = modalBottomSheetProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function0<Unit> function8 = function3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$6(function8, j2, modalBottomSheetProperties3, function2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modalBottomSheetProperties2 = modalBottomSheetProperties;
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        }
        z = true;
        if ((i3 & 1171) != 1170) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "290@12265L2,292@12331L14,290@12295L51");
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -807380064, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function4 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function4 = function1;
                }
                if ((i2 & 2) != 0) {
                    jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), composerStartRestartGroup, 0);
                    i3 &= -113;
                }
                if (i6 != 0) {
                    function3 = function4;
                    modalBottomSheetProperties4 = new ModalBottomSheetProperties(false, false, 3, null);
                    j3 = jM3712contentColorForek8zF_U;
                } else {
                    function3 = function4;
                    j3 = jM3712contentColorForek8zF_U;
                    modalBottomSheetProperties4 = modalBottomSheetProperties2;
                }
            } else {
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -807380064, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function4 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function4 = function1;
                }
                if ((i2 & 2) != 0) {
                    jM3712contentColorForek8zF_U = ColorSchemeKt.m3712contentColorForek8zF_U(BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), composerStartRestartGroup, 0);
                    i3 &= -113;
                }
                if (i6 != 0) {
                    function3 = function4;
                    modalBottomSheetProperties4 = new ModalBottomSheetProperties(false, false, 3, null);
                    j3 = jM3712contentColorForek8zF_U;
                } else {
                    function3 = function4;
                    j3 = jM3712contentColorForek8zF_U;
                    modalBottomSheetProperties4 = modalBottomSheetProperties2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-85756322, i3, -1, "androidx.compose.material3.ModalBottomSheetDialog (ModalBottomSheet.android.kt:229)");
            }
            ProvidableCompositionLocal<View> localView3 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume7 = composerStartRestartGroup.consume(localView3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            view = (View) objConsume7;
            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume8 = composerStartRestartGroup.consume(localDensity3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume8;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume9 = composerStartRestartGroup.consume(localLayoutDirection3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            layoutDirection = (LayoutDirection) objConsume9;
            compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i3 >> 9) & 14);
            Object[] objArr3 = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -807432653, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return UUID.randomUUID();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr3, (Function0) objRememberedValue2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -807430655, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(view) | composerStartRestartGroup.changed(density);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper5 = new ModalBottomSheetDialogWrapper(function3, modalBottomSheetProperties4, j3, view, layoutDirection, density, uuid, null);
                modalBottomSheetDialogWrapper5.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1379699857, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$3$0$0(stateRememberUpdatedState, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }));
                composerStartRestartGroup.updateRememberedValue(modalBottomSheetDialogWrapper5);
                obj = modalBottomSheetDialogWrapper5;
            } else {
                ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper6 = new ModalBottomSheetDialogWrapper(function3, modalBottomSheetProperties4, j3, view, layoutDirection, density, uuid, null);
                modalBottomSheetDialogWrapper6.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1379699857, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$3$0$0(stateRememberUpdatedState, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }));
                composerStartRestartGroup.updateRememberedValue(modalBottomSheetDialogWrapper6);
                obj = modalBottomSheetDialogWrapper6;
            }
            modalBottomSheetDialogWrapper = (ModalBottomSheetDialogWrapper) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -807413569, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(modalBottomSheetDialogWrapper);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$4$0(modalBottomSheetDialogWrapper, (DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$4$0(modalBottomSheetDialogWrapper, (DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(modalBottomSheetDialogWrapper, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -807408802, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(modalBottomSheetDialogWrapper);
            if ((i3 & 14) == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z9 = zChangedInstance4 | z3;
            if ((i3 & 896) == 256) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z10 = z9 | z4;
            if (((i3 & 112) ^ 48) > 32) {
            }
            zChanged2 = z10 | z | composerStartRestartGroup.changed(layoutDirection.ordinal());
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                final long j7 = j3;
                final ModalBottomSheetProperties modalBottomSheetProperties8 = modalBottomSheetProperties4;
                final Function0 function9 = function3;
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$5$0(modalBottomSheetDialogWrapper, function9, modalBottomSheetProperties8, j7, layoutDirection);
                    }
                };
                function3 = function9;
                modalBottomSheetProperties4 = modalBottomSheetProperties8;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                final long j8 = j3;
                final ModalBottomSheetProperties modalBottomSheetProperties9 = modalBottomSheetProperties4;
                final Function0 function10 = function3;
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$5$0(modalBottomSheetDialogWrapper, function10, modalBottomSheetProperties9, j8, layoutDirection);
                    }
                };
                function3 = function10;
                modalBottomSheetProperties4 = modalBottomSheetProperties9;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue4, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j2 = j3;
            modalBottomSheetProperties3 = modalBottomSheetProperties4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function3 = function1;
            j2 = jM3712contentColorForek8zF_U;
            modalBottomSheetProperties3 = modalBottomSheetProperties2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0 function11 = function3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$6(function11, j2, modalBottomSheetProperties3, function2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetDialog_sW7UJKQ$lambda$3$0$0(State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C249@11099L12,249@11076L57:ModalBottomSheet.android.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1379699857, i, -1, "androidx.compose.material3.ModalBottomSheetDialog.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:249)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1253330307, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$3$0$0$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1287690172, "C249@11115L16:ModalBottomSheet.android.kt#uh7d8r");
            ModalBottomSheetDialog_sW7UJKQ$lambda$1(state).invoke(composer, 0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetDialog_sW7UJKQ$lambda$3$0$0$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.dialog(semanticsPropertyReceiver);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ModalBottomSheetDialog_sW7UJKQ$lambda$4$0(final ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper, DisposableEffectScope disposableEffectScope) {
        modalBottomSheetDialogWrapper.show();
        return new DisposableEffectResult() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetDialog_sW7UJKQ$lambda$4$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                modalBottomSheetDialogWrapper.dismiss();
                modalBottomSheetDialogWrapper.disposeComposition();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetDialog_sW7UJKQ$lambda$5$0(ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper, Function0 function0, ModalBottomSheetProperties modalBottomSheetProperties, long j, LayoutDirection layoutDirection) {
        modalBottomSheetDialogWrapper.m4348updateParameters9LQNqLg(function0, modalBottomSheetProperties, j, layoutDirection);
        return Unit.INSTANCE;
    }

    public static final boolean isFlagSecureEnabled(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }

    /* JADX INFO: renamed from: isDark-8_81llA, reason: not valid java name */
    public static final boolean m4358isDark8_81llA(long j) {
        return !Color.m7339equalsimpl0(j, Color.INSTANCE.m7373getTransparent0d7_KjU()) && ((double) ColorKt.m7390luminance8_81llA(j)) <= 0.5d;
    }

    private static final Function2<Composer, Integer, Unit> ModalBottomSheetDialog_sW7UJKQ$lambda$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
