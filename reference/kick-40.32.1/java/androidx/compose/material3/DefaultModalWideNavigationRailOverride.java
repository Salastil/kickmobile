package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
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
import androidx.compose.runtime.MovableContentKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010\u000b\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/DefaultModalWideNavigationRailOverride;", "Landroidx/compose/material3/ModalWideNavigationRailOverride;", "<init>", "()V", "ModalWideNavigationRail", "", "Landroidx/compose/material3/ModalWideNavigationRailOverrideScope;", "(Landroidx/compose/material3/ModalWideNavigationRailOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3", "isCollapsed", "", "modalExpanded", "alpha", ""}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultModalWideNavigationRailOverride implements ModalWideNavigationRailOverride {
    public static final int $stable = 0;
    public static final DefaultModalWideNavigationRailOverride INSTANCE = new DefaultModalWideNavigationRailOverride();

    static final Unit ModalWideNavigationRail$lambda$18(DefaultModalWideNavigationRailOverride defaultModalWideNavigationRailOverride, ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope, int i, Composer composer, int i2) {
        defaultModalWideNavigationRailOverride.ModalWideNavigationRail(modalWideNavigationRailOverrideScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private DefaultModalWideNavigationRailOverride() {
    }

    @Override // androidx.compose.material3.ModalWideNavigationRailOverride
    public void ModalWideNavigationRail(ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final Function2<Composer, Integer, Unit> content;
        String str;
        int i3;
        int i4;
        final ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope2 = modalWideNavigationRailOverrideScope;
        Composer composerStartRestartGroup = composer.startRestartGroup(1751235721);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalWideNavigationRail)660@32856L14,662@32908L132,669@33337L7,666@33084L275,671@33396L60,672@33495L62,673@33578L24,674@33646L189,682@33892L138,711@34963L48:WideNavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(modalWideNavigationRailOverrideScope2) : composerStartRestartGroup.changedInstance(modalWideNavigationRailOverrideScope2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1751235721, i2, -1, "androidx.compose.material3.DefaultModalWideNavigationRailOverride.ModalWideNavigationRail (WideNavigationRail.kt:653)");
            }
            if (modalWideNavigationRailOverrideScope2.getShouldHideOnCollapse()) {
                composerStartRestartGroup.startReplaceGroup(95756914);
                composerStartRestartGroup.endReplaceGroup();
                content = modalWideNavigationRailOverrideScope2.getContent();
            } else {
                composerStartRestartGroup.startReplaceGroup(95801802);
                ComposerKt.sourceInformation(composerStartRestartGroup, "657@32654L47");
                Function2<Composer, Integer, Unit> content2 = modalWideNavigationRailOverrideScope2.getContent();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689646280, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(content2);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = MovableContentKt.movableContentOf(modalWideNavigationRailOverrideScope2.getContent());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                content = (Function2) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            }
            FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            WideNavigationRailState state = modalWideNavigationRailOverrideScope2.getState();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689638067, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(state);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new ModalWideNavigationRailState(modalWideNavigationRailOverrideScope2.getState(), finiteAnimationSpecValue);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final ModalWideNavigationRailState modalWideNavigationRailState = (ModalWideNavigationRailState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(!WideNavigationRailStateKt.isExpanded(modalWideNavigationRailOverrideScope2.getState().getTargetValue()) ? 0.0f : 1.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerStart(composer2, -689622523, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue3 = composer2.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$2$0(stateAnimateFloatAsState));
                    }
                });
                composer2.updateRememberedValue(objRememberedValue3);
            }
            final State state2 = (State) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, -689619353, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue4 = composer2.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$4$0(stateAnimateFloatAsState));
                    }
                });
                composer2.updateRememberedValue(objRememberedValue4);
            }
            final State state3 = (State) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue5 = composer2.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                composer2.updateRememberedValue(objRememberedValue5);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, -689614394, "CC(remember):WideNavigationRail.kt#9igjgp");
            int i5 = i2 & 14;
            boolean zChangedInstance = composer2.changedInstance(coroutineScope) | (i5 == 4 || ((i2 & 8) != 0 && composer2.changedInstance(modalWideNavigationRailOverrideScope2))) | composer2.changedInstance(modalWideNavigationRailState);
            Object objRememberedValue6 = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$6$0(coroutineScope, modalWideNavigationRailOverrideScope2, modalWideNavigationRailState);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue6);
            }
            final Function0 function0 = (Function0) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, -689606573, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChangedInstance2 = (i5 == 4 || ((i2 & 8) != 0 && composer2.changedInstance(modalWideNavigationRailOverrideScope2))) | composer2.changedInstance(modalWideNavigationRailState);
            DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$modalAnimateToDismiss$1$1 defaultModalWideNavigationRailOverride$ModalWideNavigationRail$modalAnimateToDismiss$1$1RememberedValue = composer2.rememberedValue();
            if (zChangedInstance2 || defaultModalWideNavigationRailOverride$ModalWideNavigationRail$modalAnimateToDismiss$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                defaultModalWideNavigationRailOverride$ModalWideNavigationRail$modalAnimateToDismiss$1$1RememberedValue = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$modalAnimateToDismiss$1$1(modalWideNavigationRailOverrideScope2, modalWideNavigationRailState, null);
                composer2.updateRememberedValue(defaultModalWideNavigationRailOverride$ModalWideNavigationRail$modalAnimateToDismiss$1$1RememberedValue);
            }
            final Function1 function1 = (Function1) defaultModalWideNavigationRailOverride$ModalWideNavigationRail$modalAnimateToDismiss$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (modalWideNavigationRailOverrideScope2.getShouldHideOnCollapse()) {
                str = "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp";
                i3 = 683736516;
                i4 = 773894976;
                composer2.startReplaceGroup(98067065);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(97297304);
                ComposerKt.sourceInformation(composer2, "701@34638L276,691@34239L690");
                Modifier modifier = modalWideNavigationRailOverrideScope2.getModifier();
                WideNavigationRailColors colors = modalWideNavigationRailOverrideScope2.getColors();
                Shape collapsedShape = modalWideNavigationRailOverrideScope2.getCollapsedShape();
                Function2<Composer, Integer, Unit> header = modalWideNavigationRailOverrideScope2.getHeader();
                WindowInsets windowInsets = modalWideNavigationRailOverrideScope2.getWindowInsets();
                Arrangement.Vertical arrangement = modalWideNavigationRailOverrideScope2.getArrangement();
                PaddingValues contentPadding = modalWideNavigationRailOverrideScope2.getContentPadding();
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(876889277, true, new Function2() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$8(content, state2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54);
                i3 = 683736516;
                i4 = 773894976;
                str = "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp";
                WideNavigationRailKt.WideNavigationRailLayout(modifier, false, false, colors, collapsedShape, header, windowInsets, arrangement, contentPadding, composableLambdaRememberComposableLambda, composer2, 805306800);
                composer2 = composer2;
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(composer2, -689572391, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue7 = composer2.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = ChannelKt.Channel$default(-1, null, null, 6, null);
                composer2.updateRememberedValue(objRememberedValue7);
            }
            final Channel channel = (Channel) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (modalWideNavigationRailOverrideScope2.getShouldHideOnCollapse()) {
                composer2.startReplaceGroup(98187190);
                ComposerKt.sourceInformation(composer2, "713@35084L403,713@35060L427");
                ComposerKt.sourceInformationMarkerStart(composer2, -689568164, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean zChangedInstance3 = composer2.changedInstance(channel) | composer2.changedInstance(modalWideNavigationRailState);
                DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$2$1 defaultModalWideNavigationRailOverride$ModalWideNavigationRail$2$1RememberedValue = composer2.rememberedValue();
                if (zChangedInstance3 || defaultModalWideNavigationRailOverride$ModalWideNavigationRail$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    defaultModalWideNavigationRailOverride$ModalWideNavigationRail$2$1RememberedValue = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$2$1(channel, modalWideNavigationRailState, null);
                    composer2.updateRememberedValue(defaultModalWideNavigationRailOverride$ModalWideNavigationRail$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(channel, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) defaultModalWideNavigationRailOverride$ModalWideNavigationRail$2$1RememberedValue, composer2, 0);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(98620601);
                composer2.endReplaceGroup();
            }
            if (ModalWideNavigationRail$lambda$3(state2)) {
                composer2.startReplaceGroup(102104505);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(98806353);
                ComposerKt.sourceInformation(composer2, "729@35603L24,730@35669L42,731@35750L38,733@35813L49,733@35802L60,737@35991L37,738@36065L110,741@36221L93,745@36389L2610,735@35876L3123");
                ComposerKt.sourceInformationMarkerStart(composer2, i4, str);
                ComposerKt.sourceInformationMarkerStart(composer2, i3, "CC(remember):Effects.kt#9igjgp");
                Object objRememberedValue8 = composer2.rememberedValue();
                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                    composer2.updateRememberedValue(objRememberedValue8);
                }
                final CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue8;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -689549805, "CC(remember):WideNavigationRail.kt#9igjgp");
                Object objRememberedValue9 = composer2.rememberedValue();
                if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue9 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                    composer2.updateRememberedValue(objRememberedValue9);
                }
                final Animatable animatable = (Animatable) objRememberedValue9;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -689547217, "CC(remember):WideNavigationRail.kt#9igjgp");
                Object objRememberedValue10 = composer2.rememberedValue();
                if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue10 = new RailPredictiveBackState();
                    composer2.updateRememberedValue(objRememberedValue10);
                }
                final RailPredictiveBackState railPredictiveBackState = (RailPredictiveBackState) objRememberedValue10;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -689545190, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean zChangedInstance4 = composer2.changedInstance(channel) | (i5 == 4 || ((i2 & 8) != 0 && composer2.changedInstance(modalWideNavigationRailOverrideScope2)));
                Object objRememberedValue11 = composer2.rememberedValue();
                if (zChangedInstance4 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue11 = new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$13$0(channel, modalWideNavigationRailOverrideScope2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue11);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                boolean z = false;
                EffectsKt.SideEffect((Function0) objRememberedValue11, composer2, 0);
                ModalWideNavigationRailProperties expandedProperties = modalWideNavigationRailOverrideScope2.getExpandedProperties();
                ComposerKt.sourceInformationMarkerStart(composer2, -689539506, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean zChangedInstance5 = composer2.changedInstance(coroutineScope2);
                if (i5 == 4 || ((i2 & 8) != 0 && composer2.changedInstance(modalWideNavigationRailOverrideScope2))) {
                    z = true;
                }
                boolean z2 = zChangedInstance5 | z;
                Object objRememberedValue12 = composer2.rememberedValue();
                if (z2 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue12 = new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$14$0(coroutineScope2, modalWideNavigationRailOverrideScope2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue12);
                }
                Function0 function2 = (Function0) objRememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -689537065, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean zChangedInstance6 = composer2.changedInstance(coroutineScope2) | composer2.changedInstance(animatable);
                Object objRememberedValue13 = composer2.rememberedValue();
                if (zChangedInstance6 || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue13 = new Function1() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$15$0(coroutineScope2, animatable, ((Float) obj).floatValue());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue13);
                }
                Function1 function3 = (Function1) objRememberedValue13;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -689532090, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean zChangedInstance7 = composer2.changedInstance(coroutineScope2) | composer2.changedInstance(animatable);
                Object objRememberedValue14 = composer2.rememberedValue();
                if (zChangedInstance7 || objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue14 = new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$16$0(coroutineScope2, animatable);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue14);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                final Function2<Composer, Integer, Unit> function4 = content;
                WideNavigationRail_androidKt.ModalWideNavigationRailDialog(function2, expandedProperties, function3, (Function0) objRememberedValue14, railPredictiveBackState, ComposableLambdaKt.rememberComposableLambda(1345045690, true, new Function2() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$17(coroutineScope2, modalWideNavigationRailOverrideScope2, modalWideNavigationRailState, function0, animatable, railPredictiveBackState, function1, function4, state3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), composer2, 221184);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            modalWideNavigationRailOverrideScope2 = modalWideNavigationRailOverrideScope2;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$18(this.f$0, modalWideNavigationRailOverrideScope2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalWideNavigationRail$lambda$2$0(State state) {
        return ((Number) state.getValue()).floatValue() == 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalWideNavigationRail$lambda$4$0(State state) {
        return ((Number) state.getValue()).floatValue() >= 0.3f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRail$lambda$6$0(CoroutineScope coroutineScope, ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope, ModalWideNavigationRailState modalWideNavigationRailState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1$1(modalWideNavigationRailOverrideScope, modalWideNavigationRailState, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit ModalWideNavigationRail$lambda$8(Function2 function2, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:WideNavigationRail.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(876889277, i, -1, "androidx.compose.material3.DefaultModalWideNavigationRailOverride.ModalWideNavigationRail.<anonymous> (WideNavigationRail.kt:704)");
            }
            if (ModalWideNavigationRail$lambda$3(state)) {
                composer.startReplaceGroup(1417550308);
                ComposerKt.sourceInformation(composer, "705@34857L17");
                function2.invoke(composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1417612773);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRail$lambda$13$0(Channel channel, ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope) {
        channel.mo12563trySendJP2dKIU(Boolean.valueOf(WideNavigationRailStateKt.isExpanded(modalWideNavigationRailOverrideScope.getState().getTargetValue())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRail$lambda$14$0(CoroutineScope coroutineScope, ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$4$1$1(modalWideNavigationRailOverrideScope, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRail$lambda$15$0(CoroutineScope coroutineScope, Animatable animatable, float f) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$5$1$1(animatable, f, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRail$lambda$16$0(CoroutineScope coroutineScope, Animatable animatable) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$6$1$1(animatable, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit ModalWideNavigationRail$lambda$17(final CoroutineScope coroutineScope, final ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope, ModalWideNavigationRailState modalWideNavigationRailState, Function0 function0, Animatable animatable, RailPredictiveBackState railPredictiveBackState, Function1 function1, Function2 function2, State state, Composer composer, int i) {
        boolean zModalWideNavigationRail$lambda$5;
        ComposerKt.sourceInformation(composer, "C748@36514L319,746@36407L2578:WideNavigationRail.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1345045690, i, -1, "androidx.compose.material3.DefaultModalWideNavigationRailOverride.ModalWideNavigationRail.<anonymous> (WideNavigationRail.kt:746)");
            }
            Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null));
            ComposerKt.sourceInformationMarkerStart(composer, -196243687, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(modalWideNavigationRailOverrideScope);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$7$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                        return m3873invokeZmokQxo(keyEvent.m8496unboximpl());
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$7$1$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: WideNavigationRail.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$7$1$1$1", f = "WideNavigationRail.kt", i = {}, l = {751}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ ModalWideNavigationRailOverrideScope $this_ModalWideNavigationRail;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$this_ModalWideNavigationRail = modalWideNavigationRailOverrideScope;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$this_ModalWideNavigationRail, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$this_ModalWideNavigationRail.getState().collapse(this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                    public final Boolean m3873invokeZmokQxo(android.view.KeyEvent keyEvent) {
                        if (KeyEventType.m8500equalsimpl0(KeyEvent_androidKt.m8508getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m8505getKeyUpCS__XNY()) && Key.m8187equalsimpl0(KeyEvent_androidKt.m8507getKeyZmokQxo(keyEvent), Key.INSTANCE.m8277getEscapeEK5gGoQ())) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(modalWideNavigationRailOverrideScope, null), 3, null);
                            return true;
                        }
                        return false;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(modifierImePadding, (Function1) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierOnKeyEvent);
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
            ComposerKt.sourceInformationMarkerStart(composer, 238614338, "C767@37470L7,764@37196L308,770@37577L28,772@37691L9,769@37525L254,786@38467L201,775@37800L1167:WideNavigationRail.kt#uh7d8r");
            if (modalWideNavigationRailOverrideScope.getShouldHideOnCollapse()) {
                zModalWideNavigationRail$lambda$5 = modalWideNavigationRailState.getTargetValue() != WideNavigationRailValue.Collapsed;
            } else {
                zModalWideNavigationRail$lambda$5 = ModalWideNavigationRail$lambda$5(state);
            }
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(zModalWideNavigationRail$lambda$5 ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6), 0.0f, null, null, composer, 0, 28);
            Strings.Companion companion = Strings.INSTANCE;
            String strM5501getString2EP1pXo = Strings_androidKt.m5501getString2EP1pXo(Strings.m5417constructorimpl(R.string.m3c_wide_navigation_rail_close_rail), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 423363293, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChanged = composer.changed(stateAnimateFloatAsState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$17$1$0(stateAnimateFloatAsState));
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ScrimKt.m4537ScrimyrwZFoE(strM5501getString2EP1pXo, null, function0, (Function0) objRememberedValue2, modalWideNavigationRailOverrideScope.getColors().getModalScrimColor(), composer, 0, 2);
            WideNavigationRailKt.m5250ModalWideNavigationRailContent_zuBKE(modalWideNavigationRailOverrideScope.getShouldHideOnCollapse() || ModalWideNavigationRail$lambda$5(state), modalWideNavigationRailOverrideScope.getShouldHideOnCollapse(), animatable, railPredictiveBackState, function1, modalWideNavigationRailOverrideScope.getModifier(), modalWideNavigationRailState, modalWideNavigationRailOverrideScope.getColors(), modalWideNavigationRailOverrideScope.getExpandedShape(), WideNavigationRailKt.ExpandedRailMaxWidth, ComposableLambdaKt.rememberComposableLambda(208840989, true, new Function2() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$17$1$2(modalWideNavigationRailOverrideScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), modalWideNavigationRailOverrideScope.getWindowInsets(), modalWideNavigationRailOverrideScope.getShouldHideOnCollapse(), modalWideNavigationRailOverrideScope.getArrangement(), modalWideNavigationRailOverrideScope.getContentPadding(), function2, composer, (Animatable.$stable << 6) | 805309440, 6);
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
    public static final Unit ModalWideNavigationRail$lambda$17$1$2(ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C787@38497L145:WideNavigationRail.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(208840989, i, -1, "androidx.compose.material3.DefaultModalWideNavigationRailOverride.ModalWideNavigationRail.<anonymous>.<anonymous>.<anonymous> (WideNavigationRail.kt:787)");
            }
            Modifier modifierM2354paddingqDBjuR0$default = PaddingKt.m2354paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, modalWideNavigationRailOverrideScope.getExpandedHeaderTopPadding(), 0.0f, 0.0f, 13, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2354paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1627808976, "C:WideNavigationRail.kt#uh7d8r");
            Function2<Composer, Integer, Unit> header = modalWideNavigationRailOverrideScope.getHeader();
            if (header == null) {
                composer.startReplaceGroup(-1627801290);
            } else {
                composer.startReplaceGroup(-2130719701);
                ComposerKt.sourceInformation(composer, "788@38604L8");
                header.invoke(composer, 0);
            }
            composer.endReplaceGroup();
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
    public static final float ModalWideNavigationRail$lambda$17$1$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final boolean ModalWideNavigationRail$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean ModalWideNavigationRail$lambda$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
