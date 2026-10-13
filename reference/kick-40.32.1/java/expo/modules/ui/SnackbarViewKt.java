package expo.modules.ui;

import android.graphics.Color;
import android.view.View;
import androidx.compose.material3.SnackbarData;
import androidx.compose.material3.SnackbarDefaults;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SnackbarKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.AsyncFunctionHandle;
import expo.modules.kotlin.views.ComposeFunctionHolder;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SnackbarView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"SnackbarHostContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/SnackbarHostProps;", "showSnackbar", "Lexpo/modules/kotlin/views/AsyncFunctionHandle;", "Lexpo/modules/ui/SnackbarShowOptions;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/SnackbarHostProps;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SnackbarViewKt {
    static final Unit SnackbarHostContent$lambda$4(FunctionalComposableScope functionalComposableScope, SnackbarHostProps snackbarHostProps, AsyncFunctionHandle asyncFunctionHandle, int i, Composer composer, int i2) {
        SnackbarHostContent(functionalComposableScope, snackbarHostProps, asyncFunctionHandle, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SnackbarHostContent(final FunctionalComposableScope functionalComposableScope, final SnackbarHostProps props, final AsyncFunctionHandle<SnackbarShowOptions> showSnackbar, Composer composer, final int i) {
        int i2;
        Composer composer2;
        View childAt;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(showSnackbar, "showSnackbar");
        Composer composerStartRestartGroup = composer.startRestartGroup(-68077194);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SnackbarHostContent)N(props,showSnackbar)75@2789L32,76@2836L24,79@2943L1098,79@2936L1105,113@4118L83,114@4206L855,111@4045L1016:SnackbarView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? composerStartRestartGroup.changed(showSnackbar) : composerStartRestartGroup.changedInstance(showSnackbar) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-68077194, i2, -1, "expo.modules.ui.SnackbarHostContent (SnackbarView.kt:74)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -997668522, "CC(remember):SnackbarView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposeFunctionHolder<?> view = functionalComposableScope.getView();
            int childCount = view.getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    childAt = null;
                    break;
                }
                childAt = view.getChildAt(i3);
                if (childAt instanceof SnackbarView) {
                    break;
                } else {
                    i3++;
                }
            }
            final SnackbarView snackbarView = (SnackbarView) childAt;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -997662528, "CC(remember):SnackbarView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope);
            SnackbarViewKt$SnackbarHostContent$1$1 snackbarViewKt$SnackbarHostContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || snackbarViewKt$SnackbarHostContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                snackbarViewKt$SnackbarHostContent$1$1RememberedValue = new SnackbarViewKt$SnackbarHostContent$1$1(coroutineScope, snackbarHostState, null);
                composerStartRestartGroup.updateRememberedValue(snackbarViewKt$SnackbarHostContent$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i4 = ((i2 << 6) & 896) | AsyncFunctionHandle.$stable | ((i2 >> 6) & 14) | (FunctionalComposableScope.$stable << 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2099440920, "CC(handle)384@13416L29,385@13473L279,385@13450L302:ExpoComposeView.kt#sri11g");
            final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState((Function2) snackbarViewKt$SnackbarHostContent$1$1RememberedValue, composerStartRestartGroup, (i4 >> 3) & 14);
            String name = showSnackbar.getName();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1071897393, "CC(remember):ExpoComposeView.kt#9igjgp");
            boolean zChangedInstance2 = ((((i4 & 14) ^ 6) > 4 && composerStartRestartGroup.changed(showSnackbar)) || (i4 & 6) == 4) | composerStartRestartGroup.changedInstance(functionalComposableScope) | composerStartRestartGroup.changed(stateRememberUpdatedState);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.SnackbarViewKt$SnackbarHostContent$$inlined$handle$1

                    /* JADX INFO: renamed from: expo.modules.ui.SnackbarViewKt$SnackbarHostContent$$inlined$handle$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: ExpoComposeView.kt */
                    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$1$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$1", f = "ExpoComposeView.kt", i = {0, 0}, l = {394}, m = "invokeSuspend", n = {"args", "arg"}, s = {"L$0", "L$1"})
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                        final /* synthetic */ State $currentHandler;
                        /* synthetic */ Object L$0;
                        Object L$1;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(State state, Continuation continuation) {
                            super(2, continuation);
                            this.$currentHandler = state;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                            anonymousClass1.L$0 = obj;
                            return anonymousClass1;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                            return invoke2(objArr, (Continuation<Object>) continuation);
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                            return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object obj2;
                            Object[] objArr = (Object[]) this.L$0;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i != 0) {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return obj;
                            }
                            ResultKt.throwOnFailure(obj);
                            if (objArr.length == 0) {
                                obj2 = Unit.INSTANCE;
                            } else {
                                obj2 = objArr[0];
                            }
                            Function2 function2 = (Function2) this.$currentHandler.getValue();
                            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                            this.label = 1;
                            Object objInvoke = function2.invoke(obj2, this);
                            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        functionalComposableScope.getView().getFunctionHandlers().put(showSnackbar.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                        final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                        final AsyncFunctionHandle asyncFunctionHandle = showSnackbar;
                        return new DisposableEffectResult() { // from class: expo.modules.ui.SnackbarViewKt$SnackbarHostContent$$inlined$handle$1.2
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle.getName());
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(name, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SnackbarHostKt.SnackbarHost(snackbarHostState, ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3), ComposableLambdaKt.rememberComposableLambda(1575602563, true, new Function3() { // from class: expo.modules.ui.SnackbarViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SnackbarViewKt.SnackbarHostContent$lambda$3(snackbarView, functionalComposableScope, (SnackbarData) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SnackbarViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarViewKt.SnackbarHostContent$lambda$4(functionalComposableScope, props, showSnackbar, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SnackbarHostContent$lambda$3(SnackbarView snackbarView, FunctionalComposableScope functionalComposableScope, SnackbarData data, Composer composer, int i) {
        int i2;
        Modifier.Companion companionApplyModifiers;
        long jM7348unboximpl;
        long jM7348unboximpl2;
        long jM7348unboximpl3;
        long jM7348unboximpl4;
        SnackbarViewProps props;
        MutableState<Color> dismissActionContentColor;
        SnackbarViewProps props2;
        MutableState<Color> actionContentColor;
        SnackbarViewProps props3;
        MutableState<Color> contentColor;
        SnackbarViewProps props4;
        MutableState<Color> containerColor;
        SnackbarViewProps props5;
        MutableState<Boolean> actionOnNewLine;
        Intrinsics.checkNotNullParameter(data, "data");
        ComposerKt.sourceInformation(composer, "CN(data)115@4220L837:SnackbarView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(data) ? 4 : 2);
        } else {
            i2 = i;
        }
        boolean zBooleanValue = false;
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1575602563, i2, -1, "expo.modules.ui.SnackbarHostContent.<anonymous> (SnackbarView.kt:115)");
            }
            Color value = null;
            if (snackbarView == null) {
                composer.startReplaceGroup(-921536261);
                composer.endReplaceGroup();
                companionApplyModifiers = null;
            } else {
                composer.startReplaceGroup(-921536260);
                ComposerKt.sourceInformation(composer, "*118@4321L92");
                companionApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(snackbarView.getProps().getModifiers().getValue(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composer, AppContext.$stable << 3);
                composer.endReplaceGroup();
            }
            if (companionApplyModifiers == null) {
                companionApplyModifiers = Modifier.INSTANCE;
            }
            if (snackbarView != null && (props5 = snackbarView.getProps()) != null && (actionOnNewLine = props5.getActionOnNewLine()) != null) {
                zBooleanValue = actionOnNewLine.getValue().booleanValue();
            }
            boolean z = zBooleanValue;
            androidx.compose.ui.graphics.Color composeOrNull = UtilsKt.getComposeOrNull((snackbarView == null || (props4 = snackbarView.getProps()) == null || (containerColor = props4.getContainerColor()) == null) ? null : containerColor.getValue());
            if (composeOrNull == null) {
                composer.startReplaceGroup(-1969378648);
                ComposerKt.sourceInformation(composer, "121@4637L5");
                jM7348unboximpl = SnackbarDefaults.INSTANCE.getColor(composer, SnackbarDefaults.$stable);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1969381097);
                composer.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            }
            long j = jM7348unboximpl;
            androidx.compose.ui.graphics.Color composeOrNull2 = UtilsKt.getComposeOrNull((snackbarView == null || (props3 = snackbarView.getProps()) == null || (contentColor = props3.getContentColor()) == null) ? null : contentColor.getValue());
            if (composeOrNull2 == null) {
                composer.startReplaceGroup(-1969375281);
                ComposerKt.sourceInformation(composer, "122@4742L12");
                jM7348unboximpl2 = SnackbarDefaults.INSTANCE.getContentColor(composer, SnackbarDefaults.$stable);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1969377668);
                composer.endReplaceGroup();
                jM7348unboximpl2 = composeOrNull2.m7348unboximpl();
            }
            androidx.compose.ui.graphics.Color composeOrNull3 = UtilsKt.getComposeOrNull((snackbarView == null || (props2 = snackbarView.getProps()) == null || (actionContentColor = props2.getActionContentColor()) == null) ? null : actionContentColor.getValue());
            if (composeOrNull3 != null) {
                composer.startReplaceGroup(-1969373872);
                composer.endReplaceGroup();
                jM7348unboximpl3 = composeOrNull3.m7348unboximpl();
            } else {
                composer.startReplaceGroup(-1969371051);
                ComposerKt.sourceInformation(composer, "124@4874L18");
                jM7348unboximpl3 = SnackbarDefaults.INSTANCE.getActionContentColor(composer, SnackbarDefaults.$stable);
                composer.endReplaceGroup();
            }
            if (snackbarView != null && (props = snackbarView.getProps()) != null && (dismissActionContentColor = props.getDismissActionContentColor()) != null) {
                value = dismissActionContentColor.getValue();
            }
            androidx.compose.ui.graphics.Color composeOrNull4 = UtilsKt.getComposeOrNull(value);
            if (composeOrNull4 != null) {
                composer.startReplaceGroup(-1969369218);
                composer.endReplaceGroup();
                jM7348unboximpl4 = composeOrNull4.m7348unboximpl();
            } else {
                composer.startReplaceGroup(-1969366180);
                ComposerKt.sourceInformation(composer, "126@5026L25");
                jM7348unboximpl4 = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composer, SnackbarDefaults.$stable);
                composer.endReplaceGroup();
            }
            SnackbarKt.m4739SnackbarsDKtq54(data, companionApplyModifiers, z, null, j, jM7348unboximpl2, 0L, jM7348unboximpl3, jM7348unboximpl4, composer, i2 & 14, 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
