package expo.modules.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.BottomSheetDefaults;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.DialogWindowProvider;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ModalBottomSheetView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0003¢\u0006\u0002\u0010\u0006\u001aQ\u0010\u0007\u001a\u00020\u0004*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"isAcceptingText", "", "Landroid/app/Activity;", "ForwardKeyEventsToActivity", "", "activity", "(Landroid/app/Activity;Landroidx/compose/runtime/Composer;I)V", "ModalBottomSheetContent", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/ModalBottomSheetViewProps;", WebViewTracking.SESSION_REPLAY_MASK_ALL_TOUCH_PRIVACY, "Lexpo/modules/kotlin/views/AsyncFunctionHandle;", "expand", "partialExpand", "onDismissRequest", "Lkotlin/Function0;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/ModalBottomSheetViewProps;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ModalBottomSheetViewKt {
    static final Unit ForwardKeyEventsToActivity$lambda$0(Activity activity, int i, Composer composer, int i2) {
        ForwardKeyEventsToActivity(activity, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ForwardKeyEventsToActivity$lambda$5(Activity activity, int i, Composer composer, int i2) {
        ForwardKeyEventsToActivity(activity, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheetContent$lambda$17(FunctionalComposableScope functionalComposableScope, ModalBottomSheetViewProps modalBottomSheetViewProps, AsyncFunctionHandle asyncFunctionHandle, AsyncFunctionHandle asyncFunctionHandle2, AsyncFunctionHandle asyncFunctionHandle3, Function0 function0, int i, Composer composer, int i2) {
        ModalBottomSheetContent(functionalComposableScope, modalBottomSheetViewProps, asyncFunctionHandle, asyncFunctionHandle2, asyncFunctionHandle3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final boolean isAcceptingText(Activity activity) {
        Object systemService = activity.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        return inputMethodManager != null && inputMethodManager.isAcceptingText();
    }

    private static final void ForwardKeyEventsToActivity(final Activity activity, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Window window;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1779639711);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ForwardKeyEventsToActivity)N(activity)77@3476L7,82@3643L366,82@3608L401:ModalBottomSheetView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(activity) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1779639711, i2, -1, "expo.modules.ui.ForwardKeyEventsToActivity (ModalBottomSheetView.kt:76)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewParent parent = ((View) objConsume).getParent();
            DialogWindowProvider dialogWindowProvider = parent instanceof DialogWindowProvider ? (DialogWindowProvider) parent : null;
            Window.Callback callback = (dialogWindowProvider == null || (window = dialogWindowProvider.getWindow()) == null) ? null : window.getCallback();
            final Dialog dialog = callback instanceof Dialog ? (Dialog) callback : null;
            if (dialog == null || activity == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: expo.modules.ui.ModalBottomSheetViewKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetViewKt.ForwardKeyEventsToActivity$lambda$0(activity, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -836769553, "CC(remember):ModalBottomSheetView.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(dialog) | composerStartRestartGroup.changedInstance(activity);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: expo.modules.ui.ModalBottomSheetViewKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetViewKt.ForwardKeyEventsToActivity$lambda$4$lambda$3(dialog, activity, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(dialog, activity, (Function1) objRememberedValue, composerStartRestartGroup, (i2 << 3) & 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: expo.modules.ui.ModalBottomSheetViewKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetViewKt.ForwardKeyEventsToActivity$lambda$5(activity, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    static final DisposableEffectResult ForwardKeyEventsToActivity$lambda$4$lambda$3(final Dialog dialog, final Activity activity, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: expo.modules.ui.ModalBottomSheetViewKt$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return ModalBottomSheetViewKt.ForwardKeyEventsToActivity$lambda$4$lambda$3$lambda$1(activity, dialogInterface, i, keyEvent);
            }
        });
        return new DisposableEffectResult() { // from class: expo.modules.ui.ModalBottomSheetViewKt$ForwardKeyEventsToActivity$lambda$4$lambda$3$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                dialog.setOnKeyListener(null);
            }
        };
    }

    static final boolean ForwardKeyEventsToActivity$lambda$4$lambda$3$lambda$1(Activity activity, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return (keyEvent.getAction() != 1 || i == 4 || i == 111 || isAcceptingText(activity) || !activity.onKeyUp(i, keyEvent)) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:156:0x0497  */
    /* JADX WARN: Code duplicated, block: B:159:0x04b2  */
    public static final void ModalBottomSheetContent(final FunctionalComposableScope functionalComposableScope, final ModalBottomSheetViewProps props, final AsyncFunctionHandle<Unit> hide, final AsyncFunctionHandle<Unit> expand, final AsyncFunctionHandle<Unit> partialExpand, final Function0<Unit> onDismissRequest, Composer composer, final int i) {
        int i2;
        Function2<Composer, Integer, Unit> function2;
        long jM7348unboximpl;
        long jM7348unboximpl2;
        long jM7348unboximpl3;
        Function2<Composer, Integer, Unit> function3;
        ComposableLambda composableLambdaM12111getLambda$45248658$expo_ui_release;
        boolean zChangedInstance;
        ModalBottomSheetViewKt$ModalBottomSheetContent$6$1 modalBottomSheetViewKt$ModalBottomSheetContent$6$1RememberedValue;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(hide, "hide");
        Intrinsics.checkNotNullParameter(expand, "expand");
        Intrinsics.checkNotNullParameter(partialExpand, "partialExpand");
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer composerStartRestartGroup = composer.startRestartGroup(1485510983);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalBottomSheetContent)N(props,hide,expand,partialExpand,onDismissRequest)104@4286L58,105@4359L24,107@4399L309,107@4392L316,118@4726L313,118@4719L320,129@5064L327,129@5057L334,176@7091L83,177@7179L128,156@6322L985,182@7332L326,182@7311L347:ModalBottomSheetView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? composerStartRestartGroup.changed(hide) : composerStartRestartGroup.changedInstance(hide) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(expand) : composerStartRestartGroup.changedInstance(expand) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= (32768 & i) == 0 ? composerStartRestartGroup.changed(partialExpand) : composerStartRestartGroup.changedInstance(partialExpand) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismissRequest) ? 131072 : 65536;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1485510983, i3, -1, "expo.modules.ui.ModalBottomSheetContent (ModalBottomSheetView.kt:103)");
            }
            SheetState sheetStateRememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(props.getSkipPartiallyExpanded(), null, composerStartRestartGroup, 0, 2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1646925052, "CC(remember):ModalBottomSheetView.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState);
            ModalBottomSheetViewKt$ModalBottomSheetContent$1$1 modalBottomSheetViewKt$ModalBottomSheetContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || modalBottomSheetViewKt$ModalBottomSheetContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                modalBottomSheetViewKt$ModalBottomSheetContent$1$1RememberedValue = new ModalBottomSheetViewKt$ModalBottomSheetContent$1$1(coroutineScope, sheetStateRememberModalBottomSheetState, null);
                composerStartRestartGroup.updateRememberedValue(modalBottomSheetViewKt$ModalBottomSheetContent$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i4 = (i3 << 6) & 896;
            int i5 = AsyncFunctionHandle.$stable | ((i3 >> 6) & 14) | (FunctionalComposableScope.$stable << 6) | i4;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2099440920, "CC(handle)384@13416L29,385@13473L279,385@13450L302:ExpoComposeView.kt#sri11g");
            final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState((Function2) modalBottomSheetViewKt$ModalBottomSheetContent$1$1RememberedValue, composerStartRestartGroup, (i5 >> 3) & 14);
            String name = hide.getName();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1071897393, "CC(remember):ExpoComposeView.kt#9igjgp");
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(functionalComposableScope) | ((((i5 & 14) ^ 6) > 4 && composerStartRestartGroup.changed(hide)) || (i5 & 6) == 4) | composerStartRestartGroup.changed(stateRememberUpdatedState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.ModalBottomSheetViewKt$ModalBottomSheetContent$$inlined$handle$1

                    /* JADX INFO: renamed from: expo.modules.ui.ModalBottomSheetViewKt$ModalBottomSheetContent$$inlined$handle$1$1, reason: invalid class name */
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
                        functionalComposableScope.getView().getFunctionHandlers().put(hide.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                        final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                        final AsyncFunctionHandle asyncFunctionHandle = hide;
                        return new DisposableEffectResult() { // from class: expo.modules.ui.ModalBottomSheetViewKt$ModalBottomSheetContent$$inlined$handle$1.2
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1646935520, "CC(remember):ModalBottomSheetView.kt#9igjgp");
            boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState);
            ModalBottomSheetViewKt$ModalBottomSheetContent$2$1 modalBottomSheetViewKt$ModalBottomSheetContent$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance4 || modalBottomSheetViewKt$ModalBottomSheetContent$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                modalBottomSheetViewKt$ModalBottomSheetContent$2$1RememberedValue = new ModalBottomSheetViewKt$ModalBottomSheetContent$2$1(coroutineScope, sheetStateRememberModalBottomSheetState, null);
                composerStartRestartGroup.updateRememberedValue(modalBottomSheetViewKt$ModalBottomSheetContent$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i6 = AsyncFunctionHandle.$stable | ((i3 >> 9) & 14) | (FunctionalComposableScope.$stable << 6) | i4;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2099440920, "CC(handle)384@13416L29,385@13473L279,385@13450L302:ExpoComposeView.kt#sri11g");
            final State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState((Function2) modalBottomSheetViewKt$ModalBottomSheetContent$2$1RememberedValue, composerStartRestartGroup, (i6 >> 3) & 14);
            String name2 = expand.getName();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1071897393, "CC(remember):ExpoComposeView.kt#9igjgp");
            boolean zChangedInstance5 = ((((i6 & 14) ^ 6) > 4 && composerStartRestartGroup.changed(expand)) || (i6 & 6) == 4) | composerStartRestartGroup.changedInstance(functionalComposableScope) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.ModalBottomSheetViewKt$ModalBottomSheetContent$$inlined$handle$2

                    /* JADX INFO: renamed from: expo.modules.ui.ModalBottomSheetViewKt$ModalBottomSheetContent$$inlined$handle$2$1, reason: invalid class name */
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
                        functionalComposableScope.getView().getFunctionHandlers().put(expand.getName(), new AnonymousClass1(stateRememberUpdatedState2, null));
                        final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                        final AsyncFunctionHandle asyncFunctionHandle = expand;
                        return new DisposableEffectResult() { // from class: expo.modules.ui.ModalBottomSheetViewKt$ModalBottomSheetContent$$inlined$handle$2.2
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
            EffectsKt.DisposableEffect(name2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1646946350, "CC(remember):ModalBottomSheetView.kt#9igjgp");
            boolean zChangedInstance6 = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState);
            ModalBottomSheetViewKt$ModalBottomSheetContent$3$1 modalBottomSheetViewKt$ModalBottomSheetContent$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance6 || modalBottomSheetViewKt$ModalBottomSheetContent$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                function2 = null;
                modalBottomSheetViewKt$ModalBottomSheetContent$3$1RememberedValue = new ModalBottomSheetViewKt$ModalBottomSheetContent$3$1(coroutineScope, sheetStateRememberModalBottomSheetState, null);
                composerStartRestartGroup.updateRememberedValue(modalBottomSheetViewKt$ModalBottomSheetContent$3$1RememberedValue);
            } else {
                function2 = null;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i7 = AsyncFunctionHandle.$stable | ((i3 >> 12) & 14) | (FunctionalComposableScope.$stable << 6) | i4;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2099440920, "CC(handle)384@13416L29,385@13473L279,385@13450L302:ExpoComposeView.kt#sri11g");
            final State stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState((Function2) modalBottomSheetViewKt$ModalBottomSheetContent$3$1RememberedValue, composerStartRestartGroup, (i7 >> 3) & 14);
            String name3 = partialExpand.getName();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1071897393, "CC(remember):ExpoComposeView.kt#9igjgp");
            boolean zChangedInstance7 = ((((i7 & 14) ^ 6) > 4 && composerStartRestartGroup.changed(partialExpand)) || (i7 & 6) == 4) | composerStartRestartGroup.changedInstance(functionalComposableScope) | composerStartRestartGroup.changed(stateRememberUpdatedState3);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance7 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.ModalBottomSheetViewKt$ModalBottomSheetContent$$inlined$handle$3

                    /* JADX INFO: renamed from: expo.modules.ui.ModalBottomSheetViewKt$ModalBottomSheetContent$$inlined$handle$3$1, reason: invalid class name */
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
                        functionalComposableScope.getView().getFunctionHandlers().put(partialExpand.getName(), new AnonymousClass1(stateRememberUpdatedState3, null));
                        final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                        final AsyncFunctionHandle asyncFunctionHandle = partialExpand;
                        return new DisposableEffectResult() { // from class: expo.modules.ui.ModalBottomSheetViewKt$ModalBottomSheetContent$$inlined$handle$3.2
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
            EffectsKt.DisposableEffect(name3, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getContainerColor());
            if (composeOrNull == null) {
                composerStartRestartGroup.startReplaceGroup(1646959413);
                ComposerKt.sourceInformation(composerStartRestartGroup, "140@5482L14");
                jM7348unboximpl = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1646957615);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            }
            Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getContentColor());
            if (composeOrNull2 != null) {
                composerStartRestartGroup.startReplaceGroup(1646973191);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl2 = composeOrNull2.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(1646976477);
                ComposerKt.sourceInformation(composerStartRestartGroup, "146@5959L11");
                jM7348unboximpl2 = ColorSchemeKt.m3711contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable), jM7348unboximpl);
                if (jM7348unboximpl2 == 16) {
                    if (ColorKt.m7390luminance8_81llA(jM7348unboximpl) > 0.5f) {
                        jM7348unboximpl2 = Color.INSTANCE.m7364getBlack0d7_KjU();
                    } else {
                        jM7348unboximpl2 = Color.INSTANCE.m7375getWhite0d7_KjU();
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            Color composeOrNull3 = UtilsKt.getComposeOrNull(props.getScrimColor());
            if (composeOrNull3 == null) {
                composerStartRestartGroup.startReplaceGroup(1646983761);
                ComposerKt.sourceInformation(composerStartRestartGroup, "153@6243L10");
                jM7348unboximpl3 = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1646982087);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl3 = composeOrNull3.m7348unboximpl();
            }
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "dragHandle");
            boolean sheetGesturesEnabled = props.getSheetGesturesEnabled();
            if (slotViewFindChildSlotView != null) {
                composerStartRestartGroup.startReplaceGroup(-482706719);
                ComposerKt.sourceInformation(composerStartRestartGroup, "165@6658L72");
                composableLambdaM12111getLambda$45248658$expo_ui_release = ComposableLambdaKt.rememberComposableLambda(-133165947, true, new Function2() { // from class: expo.modules.ui.ModalBottomSheetViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetViewKt.ModalBottomSheetContent$lambda$12(slotViewFindChildSlotView, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (props.getShowDragHandle()) {
                    composerStartRestartGroup.startReplaceGroup(-482587803);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaM12111getLambda$45248658$expo_ui_release = ComposableSingletons$ModalBottomSheetViewKt.INSTANCE.m12111getLambda$45248658$expo_ui_release();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-482520906);
                    composerStartRestartGroup.endReplaceGroup();
                    function3 = function2;
                }
                long j = jM7348unboximpl2;
                ModalBottomSheetKt.m4353ModalBottomSheetYbuCTN8(onDismissRequest, ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3), sheetStateRememberModalBottomSheetState, 0.0f, sheetGesturesEnabled, null, jM7348unboximpl, j, 0.0f, jM7348unboximpl3, function3, null, new ModalBottomSheetProperties(props.getProperties().getShouldDismissOnBackPress(), props.getProperties().getShouldDismissOnClickOutside()), ComposableLambdaKt.rememberComposableLambda(328642597, true, new Function3() { // from class: expo.modules.ui.ModalBottomSheetViewKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ModalBottomSheetViewKt.ModalBottomSheetContent$lambda$15(functionalComposableScope, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 >> 15) & 14, 3072, 2344);
                composerStartRestartGroup = composerStartRestartGroup;
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1647018925, "CC(remember):ModalBottomSheetView.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(props) | composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState);
                modalBottomSheetViewKt$ModalBottomSheetContent$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || modalBottomSheetViewKt$ModalBottomSheetContent$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    modalBottomSheetViewKt$ModalBottomSheetContent$6$1RememberedValue = new ModalBottomSheetViewKt$ModalBottomSheetContent$6$1(props, sheetStateRememberModalBottomSheetState, null);
                    composerStartRestartGroup.updateRememberedValue(modalBottomSheetViewKt$ModalBottomSheetContent$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetViewKt$ModalBottomSheetContent$6$1RememberedValue, composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            function3 = composableLambdaM12111getLambda$45248658$expo_ui_release;
            long j2 = jM7348unboximpl2;
            ModalBottomSheetKt.m4353ModalBottomSheetYbuCTN8(onDismissRequest, ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3), sheetStateRememberModalBottomSheetState, 0.0f, sheetGesturesEnabled, null, jM7348unboximpl, j2, 0.0f, jM7348unboximpl3, function3, null, new ModalBottomSheetProperties(props.getProperties().getShouldDismissOnBackPress(), props.getProperties().getShouldDismissOnClickOutside()), ComposableLambdaKt.rememberComposableLambda(328642597, true, new Function3() { // from class: expo.modules.ui.ModalBottomSheetViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ModalBottomSheetViewKt.ModalBottomSheetContent$lambda$15(functionalComposableScope, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 >> 15) & 14, 3072, 2344);
            composerStartRestartGroup = composerStartRestartGroup;
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1647018925, "CC(remember):ModalBottomSheetView.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(props) | composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState);
            modalBottomSheetViewKt$ModalBottomSheetContent$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                modalBottomSheetViewKt$ModalBottomSheetContent$6$1RememberedValue = new ModalBottomSheetViewKt$ModalBottomSheetContent$6$1(props, sheetStateRememberModalBottomSheetState, null);
                composerStartRestartGroup.updateRememberedValue(modalBottomSheetViewKt$ModalBottomSheetContent$6$1RememberedValue);
            } else {
                modalBottomSheetViewKt$ModalBottomSheetContent$6$1RememberedValue = new ModalBottomSheetViewKt$ModalBottomSheetContent$6$1(props, sheetStateRememberModalBottomSheetState, null);
                composerStartRestartGroup.updateRememberedValue(modalBottomSheetViewKt$ModalBottomSheetContent$6$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetViewKt$ModalBottomSheetContent$6$1RememberedValue, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ModalBottomSheetViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetViewKt.ModalBottomSheetContent$lambda$17(functionalComposableScope, props, hide, expand, partialExpand, onDismissRequest, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ModalBottomSheetContent$lambda$12(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ModalBottomSheetView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-133165947, i, -1, "expo.modules.ui.ModalBottomSheetContent.<anonymous> (ModalBottomSheetView.kt:165)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(876544811);
            ComposerKt.sourceInformation(composer, "*165@6715L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheetContent$lambda$15(FunctionalComposableScope functionalComposableScope, ColumnScope ModalBottomSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation(composer, "C178@7185L54,179@7283L19,179@7244L59:ModalBottomSheetView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(328642597, i, -1, "expo.modules.ui.ModalBottomSheetContent.<anonymous> (ModalBottomSheetView.kt:178)");
            }
            ForwardKeyEventsToActivity(functionalComposableScope.getAppContext().getCurrentActivity(), composer, 0);
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            ComposerKt.sourceInformationMarkerStart(composer, -2002040840, "CC(remember):ModalBottomSheetView.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.ModalBottomSheetViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(ModalBottomSheetViewKt.ModalBottomSheetContent$lambda$15$lambda$14$lambda$13((ExpoComposeView) obj));
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

    static final boolean ModalBottomSheetContent$lambda$15$lambda$14$lambda$13(ExpoComposeView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !SlotViewKt.isSlotView(it);
    }
}
