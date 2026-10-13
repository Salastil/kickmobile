package expo.modules.ui;

import android.view.View;
import androidx.compose.material3.RichTooltipColors;
import androidx.compose.material3.TooltipDefaults;
import androidx.compose.material3.TooltipKt;
import androidx.compose.material3.TooltipScope;
import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.window.PopupPositionProvider;
import com.datadog.android.webview.WebViewTracking;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.AsyncFunctionHandle;
import expo.modules.kotlin.views.ExpoComposeView;
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

/* JADX INFO: compiled from: TooltipView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"TooltipBoxContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/TooltipBoxViewProps;", WebViewTracking.SESSION_REPLAY_MASK_NONE_TOUCH_PRIVACY, "Lexpo/modules/kotlin/views/AsyncFunctionHandle;", "dismiss", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/TooltipBoxViewProps;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TooltipViewKt {
    static final Unit TooltipBoxContent$lambda$17(FunctionalComposableScope functionalComposableScope, TooltipBoxViewProps tooltipBoxViewProps, AsyncFunctionHandle asyncFunctionHandle, AsyncFunctionHandle asyncFunctionHandle2, int i, Composer composer, int i2) {
        TooltipBoxContent(functionalComposableScope, tooltipBoxViewProps, asyncFunctionHandle, asyncFunctionHandle2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void TooltipBoxContent(final FunctionalComposableScope functionalComposableScope, final TooltipBoxViewProps props, final AsyncFunctionHandle<Unit> show, final AsyncFunctionHandle<Unit> dismiss, Composer composer, final int i) {
        int i2;
        PlainTooltipView plainTooltipView;
        TooltipViewKt$TooltipBoxContent$2$1 tooltipViewKt$TooltipBoxContent$2$1;
        final PlainTooltipView plainTooltipView2;
        final RichTooltipView richTooltipView;
        PopupPositionProvider popupPositionProviderM5156rememberPlainTooltipPositionProviderkHDZbjc;
        View childAt;
        View childAt2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(show, "show");
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1780036079);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TooltipBoxContent)N(props,show,dismiss)86@2933L55,87@3003L24,89@3043L304,89@3036L311,100@3366L307,100@3359L314,165@6290L83,129@4415L1815,166@6378L69,124@4243L2204:TooltipView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? composerStartRestartGroup.changed(show) : composerStartRestartGroup.changedInstance(show) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(dismiss) : composerStartRestartGroup.changedInstance(dismiss) ? 2048 : 1024;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1780036079, i3, -1, "expo.modules.ui.TooltipBoxContent (TooltipView.kt:85)");
            }
            TooltipState tooltipStateRememberTooltipState = TooltipKt.rememberTooltipState(false, props.isPersistent(), null, composerStartRestartGroup, 0, 5);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1217678271, "CC(remember):TooltipView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(tooltipStateRememberTooltipState);
            TooltipViewKt$TooltipBoxContent$1$1 tooltipViewKt$TooltipBoxContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || tooltipViewKt$TooltipBoxContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                tooltipViewKt$TooltipBoxContent$1$1RememberedValue = new TooltipViewKt$TooltipBoxContent$1$1(coroutineScope, tooltipStateRememberTooltipState, null);
                composerStartRestartGroup.updateRememberedValue(tooltipViewKt$TooltipBoxContent$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i4 = (i3 << 6) & 896;
            int i5 = AsyncFunctionHandle.$stable | ((i3 >> 6) & 14) | (FunctionalComposableScope.$stable << 6) | i4;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2099440920, "CC(handle)384@13416L29,385@13473L279,385@13450L302:ExpoComposeView.kt#sri11g");
            final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState((Function2) tooltipViewKt$TooltipBoxContent$1$1RememberedValue, composerStartRestartGroup, (i5 >> 3) & 14);
            String name = show.getName();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1071897393, "CC(remember):ExpoComposeView.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(functionalComposableScope) | ((((i5 & 14) ^ 6) > 4 && composerStartRestartGroup.changed(show)) || (i5 & 6) == 4) | composerStartRestartGroup.changed(stateRememberUpdatedState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.TooltipViewKt$TooltipBoxContent$$inlined$handle$1

                    /* JADX INFO: renamed from: expo.modules.ui.TooltipViewKt$TooltipBoxContent$$inlined$handle$1$1, reason: invalid class name */
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
                        functionalComposableScope.getView().getFunctionHandlers().put(show.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                        final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                        final AsyncFunctionHandle asyncFunctionHandle = show;
                        return new DisposableEffectResult() { // from class: expo.modules.ui.TooltipViewKt$TooltipBoxContent$$inlined$handle$1.2
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle.getName());
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(name, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1217667932, "CC(remember):TooltipView.kt#9igjgp");
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(tooltipStateRememberTooltipState);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                plainTooltipView = null;
                tooltipViewKt$TooltipBoxContent$2$1 = new TooltipViewKt$TooltipBoxContent$2$1(coroutineScope, tooltipStateRememberTooltipState, null);
                composerStartRestartGroup.updateRememberedValue(tooltipViewKt$TooltipBoxContent$2$1);
            } else {
                tooltipViewKt$TooltipBoxContent$2$1 = objRememberedValue3;
                plainTooltipView = null;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i6 = AsyncFunctionHandle.$stable | ((i3 >> 9) & 14) | (FunctionalComposableScope.$stable << 6) | i4;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2099440920, "CC(handle)384@13416L29,385@13473L279,385@13450L302:ExpoComposeView.kt#sri11g");
            final State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState((Function2) tooltipViewKt$TooltipBoxContent$2$1, composerStartRestartGroup, (i6 >> 3) & 14);
            String name2 = dismiss.getName();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1071897393, "CC(remember):ExpoComposeView.kt#9igjgp");
            boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(functionalComposableScope) | ((((i6 & 14) ^ 6) > 4 && composerStartRestartGroup.changed(dismiss)) || (i6 & 6) == 4) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.TooltipViewKt$TooltipBoxContent$$inlined$handle$2

                    /* JADX INFO: renamed from: expo.modules.ui.TooltipViewKt$TooltipBoxContent$$inlined$handle$2$1, reason: invalid class name */
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
                        functionalComposableScope.getView().getFunctionHandlers().put(dismiss.getName(), new AnonymousClass1(stateRememberUpdatedState2, null));
                        final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                        final AsyncFunctionHandle asyncFunctionHandle = dismiss;
                        return new DisposableEffectResult() { // from class: expo.modules.ui.TooltipViewKt$TooltipBoxContent$$inlined$handle$2.2
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle.getName());
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean zBooleanValue = false;
            EffectsKt.DisposableEffect(name2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "tooltip");
            if (slotViewFindChildSlotView != null) {
                SlotView slotView = slotViewFindChildSlotView;
                int childCount = slotView.getChildCount();
                int i7 = 0;
                while (true) {
                    if (i7 >= childCount) {
                        childAt2 = plainTooltipView;
                        break;
                    }
                    childAt2 = slotView.getChildAt(i7);
                    if (childAt2 instanceof PlainTooltipView) {
                        break;
                    } else {
                        i7++;
                    }
                }
                plainTooltipView2 = (PlainTooltipView) childAt2;
            } else {
                plainTooltipView2 = plainTooltipView;
            }
            if (slotViewFindChildSlotView != null) {
                SlotView slotView2 = slotViewFindChildSlotView;
                int childCount2 = slotView2.getChildCount();
                int i8 = 0;
                while (true) {
                    if (i8 >= childCount2) {
                        childAt = plainTooltipView;
                        break;
                    }
                    childAt = slotView2.getChildAt(i8);
                    if (childAt instanceof RichTooltipView) {
                        break;
                    } else {
                        i8++;
                    }
                }
                richTooltipView = (RichTooltipView) childAt;
            } else {
                richTooltipView = plainTooltipView;
            }
            final SlotView slotViewFindChildSlotView2 = richTooltipView != 0 ? SlotViewKt.findChildSlotView(richTooltipView, "action") : plainTooltipView;
            Boolean hasAction = props.getHasAction();
            if (hasAction != null) {
                zBooleanValue = hasAction.booleanValue();
            } else if (slotViewFindChildSlotView2 != 0) {
                zBooleanValue = true;
            }
            if (richTooltipView != 0) {
                composerStartRestartGroup.startReplaceGroup(907726290);
                ComposerKt.sourceInformation(composerStartRestartGroup, "119@4128L37");
                popupPositionProviderM5156rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m5157rememberRichTooltipPositionProviderkHDZbjc(0.0f, composerStartRestartGroup, TooltipDefaults.$stable << 3, 1);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(907794769);
                ComposerKt.sourceInformation(composerStartRestartGroup, "121@4197L38");
                popupPositionProviderM5156rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m5156rememberPlainTooltipPositionProviderkHDZbjc(0.0f, composerStartRestartGroup, TooltipDefaults.$stable << 3, 1);
                composerStartRestartGroup.endReplaceGroup();
            }
            TooltipKt.TooltipBox(popupPositionProviderM5156rememberPlainTooltipPositionProviderkHDZbjc, ComposableLambdaKt.rememberComposableLambda(908765500, true, new Function3() { // from class: expo.modules.ui.TooltipViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TooltipViewKt.TooltipBoxContent$lambda$13(plainTooltipView2, functionalComposableScope, richTooltipView, slotViewFindChildSlotView2, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), tooltipStateRememberTooltipState, ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3), null, props.getFocusable(), props.getEnableUserInput(), zBooleanValue, ComposableLambdaKt.rememberComposableLambda(-1361303212, true, new Function2() { // from class: expo.modules.ui.TooltipViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TooltipViewKt.TooltipBoxContent$lambda$16(functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 16);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.TooltipViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TooltipViewKt.TooltipBoxContent$lambda$17(functionalComposableScope, props, show, dismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit TooltipBoxContent$lambda$13(final PlainTooltipView plainTooltipView, FunctionalComposableScope functionalComposableScope, RichTooltipView richTooltipView, final SlotView slotView, TooltipScope TooltipBox, Composer composer, int i) {
        ComposableLambda composableLambda;
        long jM7348unboximpl;
        long jM7348unboximpl2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(TooltipBox, "$this$TooltipBox");
        ComposerKt.sourceInformation(composer2, "C:TooltipView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(908765500, i, -1, "expo.modules.ui.TooltipBoxContent.<anonymous> (TooltipView.kt:130)");
        }
        if (plainTooltipView != null) {
            composer2.startReplaceGroup(1854198777);
            ComposerKt.sourceInformation(composer2, "136@4797L106,137@4914L88,131@4463L539");
            Color composeOrNull = UtilsKt.getComposeOrNull(plainTooltipView.getProps().getContainerColor().getValue());
            if (composeOrNull != null) {
                composer2.startReplaceGroup(1445287375);
                composer2.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            } else {
                composer2.startReplaceGroup(1445290134);
                ComposerKt.sourceInformation(composer2, "133@4593L26");
                jM7348unboximpl = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(composer2, TooltipDefaults.$stable);
                composer2.endReplaceGroup();
            }
            long j = jM7348unboximpl;
            Color composeOrNull2 = UtilsKt.getComposeOrNull(plainTooltipView.getProps().getContentColor().getValue());
            if (composeOrNull2 != null) {
                composer2.startReplaceGroup(1445291915);
                composer2.endReplaceGroup();
                jM7348unboximpl2 = composeOrNull2.m7348unboximpl();
            } else {
                composer2.startReplaceGroup(1445294612);
                ComposerKt.sourceInformation(composer2, "135@4733L24");
                jM7348unboximpl2 = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(composer2, TooltipDefaults.$stable);
                composer2.endReplaceGroup();
            }
            TooltipKt.m5163PlainTooltipgv3ox5I(TooltipBox, ModifierRegistry.INSTANCE.applyModifiers(plainTooltipView.getProps().getModifiers().getValue(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composer2, AppContext.$stable << 3), null, 0.0f, null, jM7348unboximpl2, j, 0.0f, 0.0f, ComposableLambdaKt.rememberComposableLambda(-2026718075, true, new Function2() { // from class: expo.modules.ui.TooltipViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TooltipViewKt.TooltipBoxContent$lambda$13$lambda$7(plainTooltipView, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer, (i & 14) | 805306368, 206);
            composer.endReplaceGroup();
        } else {
            if (richTooltipView != null) {
                composer2.startReplaceGroup(1854805323);
                ComposerKt.sourceInformation(composer2, "143@5233L19,148@5436L576,158@6052L105,159@6168L48,145@5262L954");
                RichTooltipView richTooltipView2 = richTooltipView;
                final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(richTooltipView2, "title");
                final SlotView slotViewFindChildSlotView2 = SlotViewKt.findChildSlotView(richTooltipView2, "text");
                RichTooltipColors richTooltipColors = TooltipDefaults.INSTANCE.richTooltipColors(composer2, TooltipDefaults.$stable);
                ComposableLambda composableLambdaRememberComposableLambda = null;
                if (slotViewFindChildSlotView == null) {
                    composer2.startReplaceGroup(1855030506);
                    composer2.endReplaceGroup();
                    composableLambda = null;
                } else {
                    composer2.startReplaceGroup(1855030507);
                    ComposerKt.sourceInformation(composer2, "*146@5314L19");
                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(2082284507, true, new Function2() { // from class: expo.modules.ui.TooltipViewKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TooltipViewKt.TooltipBoxContent$lambda$13$lambda$9$lambda$8(slotViewFindChildSlotView, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54);
                    composer2.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda2;
                }
                if (slotView == null) {
                    composer2.startReplaceGroup(1855093994);
                } else {
                    composer2.startReplaceGroup(1855093995);
                    ComposerKt.sourceInformation(composer2, "*147@5378L19");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1384285428, true, new Function2() { // from class: expo.modules.ui.TooltipViewKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TooltipViewKt.TooltipBoxContent$lambda$13$lambda$11$lambda$10(slotView, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54);
                }
                composer2.endReplaceGroup();
                ComposableLambda composableLambda2 = composableLambdaRememberComposableLambda;
                TooltipDefaults tooltipDefaults = TooltipDefaults.INSTANCE;
                Color composeOrNull3 = UtilsKt.getComposeOrNull(richTooltipView.getProps().getContainerColor().getValue());
                long jM7348unboximpl3 = composeOrNull3 != null ? composeOrNull3.m7348unboximpl() : richTooltipColors.getContainerColor();
                Color composeOrNull4 = UtilsKt.getComposeOrNull(richTooltipView.getProps().getContentColor().getValue());
                long jM7348unboximpl4 = composeOrNull4 != null ? composeOrNull4.m7348unboximpl() : richTooltipColors.getContentColor();
                Color composeOrNull5 = UtilsKt.getComposeOrNull(richTooltipView.getProps().getTitleContentColor().getValue());
                long jM7348unboximpl5 = composeOrNull5 != null ? composeOrNull5.m7348unboximpl() : richTooltipColors.getTitleContentColor();
                Color composeOrNull6 = UtilsKt.getComposeOrNull(richTooltipView.getProps().getActionContentColor().getValue());
                TooltipKt.m5164RichTooltipEkvW5A0(TooltipBox, ModifierRegistry.INSTANCE.applyModifiers(richTooltipView.getProps().getModifiers().getValue(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composer, AppContext.$stable << 3), composableLambda, composableLambda2, null, 0.0f, null, tooltipDefaults.m5160richTooltipColorsro_MJ88(jM7348unboximpl3, jM7348unboximpl4, jM7348unboximpl5, composeOrNull6 != null ? composeOrNull6.m7348unboximpl() : richTooltipColors.getActionContentColor(), composer2, TooltipDefaults.$stable << 12, 0), 0.0f, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1996255501, true, new Function2() { // from class: expo.modules.ui.TooltipViewKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TooltipViewKt.TooltipBoxContent$lambda$13$lambda$12(slotViewFindChildSlotView2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, i & 14, 6, 440);
                composer2 = composer;
            } else {
                composer2.startReplaceGroup(1849763142);
            }
            composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit TooltipBoxContent$lambda$13$lambda$7(PlainTooltipView plainTooltipView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:TooltipView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2026718075, i, -1, "expo.modules.ui.TooltipBoxContent.<anonymous>.<anonymous> (TooltipView.kt:138)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(-2055883671);
            ComposerKt.sourceInformation(composer, "*138@4979L9");
            plainTooltipView.Content(uIComposableScope, composer, ExpoComposeView.$stable << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit TooltipBoxContent$lambda$13$lambda$9$lambda$8(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C146@5319L12:TooltipView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2082284507, i, -1, "expo.modules.ui.TooltipBoxContent.<anonymous>.<anonymous>.<anonymous> (TooltipView.kt:146)");
            }
            SlotViewKt.renderSlot(slotView, composer, ViewEventDelegate.$stable | ExpoComposeView.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit TooltipBoxContent$lambda$13$lambda$11$lambda$10(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C147@5383L12:TooltipView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1384285428, i, -1, "expo.modules.ui.TooltipBoxContent.<anonymous>.<anonymous>.<anonymous> (TooltipView.kt:147)");
            }
            SlotViewKt.renderSlot(slotView, composer, ViewEventDelegate.$stable | ExpoComposeView.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit TooltipBoxContent$lambda$13$lambda$12(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:TooltipView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1996255501, i, -1, "expo.modules.ui.TooltipBoxContent.<anonymous>.<anonymous> (TooltipView.kt:160)");
            }
            if (slotView == null) {
                composer.startReplaceGroup(1964543586);
            } else {
                composer.startReplaceGroup(1448845695);
                ComposerKt.sourceInformation(composer, "160@6194L12");
                SlotViewKt.renderSlot(slotView, composer, ViewEventDelegate.$stable | ExpoComposeView.$stable);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit TooltipBoxContent$lambda$16(FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C167@6423L19,167@6384L59:TooltipView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1361303212, i, -1, "expo.modules.ui.TooltipBoxContent.<anonymous> (TooltipView.kt:167)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1752640007, "CC(remember):TooltipView.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.TooltipViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(TooltipViewKt.TooltipBoxContent$lambda$16$lambda$15$lambda$14((ExpoComposeView) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            functionalComposableScope.Children(uIComposableScope, (Function1) objRememberedValue, composer, (FunctionalComposableScope.$stable << 6) | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final boolean TooltipBoxContent$lambda$16$lambda$15$lambda$14(ExpoComposeView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !SlotViewKt.isSlotView(it);
    }
}
