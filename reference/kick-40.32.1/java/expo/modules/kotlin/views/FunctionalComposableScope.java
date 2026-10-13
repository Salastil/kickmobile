package expo.modules.kotlin.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: ExpoComposeView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u001dJ>\u0010\u001c\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052%\u0010\u001e\u001a!\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH\u0007¢\u0006\u0002\u0010%JM\u0010&\u001a\b\u0012\u0004\u0012\u0002H(0'\"\u0006\b\u0000\u0010(\u0018\u000121\b\n\u0010)\u001a+\u0012\u0013\u0012\u0011H(¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020+\u0018\u00010\u001fj\n\u0012\u0004\u0012\u0002H(\u0018\u0001`,H\u0086\bø\u0001\u0000JK\u0010-\u001a\u00020\u0014\"\u0006\b\u0000\u0010.\u0018\u0001*\b\u0012\u0004\u0012\u0002H.0/2&\b\b\u00100\u001a \b\u0001\u0012\u0004\u0012\u0002H.\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000101\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0087\bø\u0001\u0000¢\u0006\u0002\u00102J_\u0010-\u001a\u00020\u0014\"\u0006\b\u0000\u0010.\u0018\u0001\"\u0006\b\u0001\u00103\u0018\u0001*\u000e\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H3042,\b\b\u00100\u001a&\b\u0001\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H3\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000101\u0012\u0006\u0012\u0004\u0018\u00010\u000105H\u0087\bø\u0001\u0000¢\u0006\u0002\u00106Js\u0010-\u001a\u00020\u0014\"\u0006\b\u0000\u0010.\u0018\u0001\"\u0006\b\u0001\u00103\u0018\u0001\"\u0006\b\u0002\u00107\u0018\u0001*\u0014\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H70822\b\b\u00100\u001a,\b\u0001\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H7\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000101\u0012\u0006\u0012\u0004\u0018\u00010\u000109H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010:J\u0087\u0001\u0010-\u001a\u00020\u0014\"\u0006\b\u0000\u0010.\u0018\u0001\"\u0006\b\u0001\u00103\u0018\u0001\"\u0006\b\u0002\u00107\u0018\u0001\"\u0006\b\u0003\u0010;\u0018\u0001*\u001a\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H;0<28\b\b\u00100\u001a2\b\u0001\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H;\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000101\u0012\u0006\u0012\u0004\u0018\u00010\u00010=H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010>J\u009b\u0001\u0010-\u001a\u00020\u0014\"\u0006\b\u0000\u0010.\u0018\u0001\"\u0006\b\u0001\u00103\u0018\u0001\"\u0006\b\u0002\u00107\u0018\u0001\"\u0006\b\u0003\u0010;\u0018\u0001\"\u0006\b\u0004\u0010?\u0018\u0001* \u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u0002H?0@2>\b\b\u00100\u001a8\b\u0001\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u0002H?\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000101\u0012\u0006\u0012\u0004\u0018\u00010\u00010AH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010BJ¯\u0001\u0010-\u001a\u00020\u0014\"\u0006\b\u0000\u0010.\u0018\u0001\"\u0006\b\u0001\u00103\u0018\u0001\"\u0006\b\u0002\u00107\u0018\u0001\"\u0006\b\u0003\u0010;\u0018\u0001\"\u0006\b\u0004\u0010?\u0018\u0001\"\u0006\b\u0005\u0010C\u0018\u0001*&\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u0002H?\u0012\u0004\u0012\u0002HC0D2D\b\b\u00100\u001a>\b\u0001\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u0002H?\u0012\u0004\u0012\u0002HC\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000101\u0012\u0006\u0012\u0004\u0018\u00010\u00010EH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010FJÃ\u0001\u0010-\u001a\u00020\u0014\"\u0006\b\u0000\u0010.\u0018\u0001\"\u0006\b\u0001\u00103\u0018\u0001\"\u0006\b\u0002\u00107\u0018\u0001\"\u0006\b\u0003\u0010;\u0018\u0001\"\u0006\b\u0004\u0010?\u0018\u0001\"\u0006\b\u0005\u0010C\u0018\u0001\"\u0006\b\u0006\u0010G\u0018\u0001*,\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u0002H?\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u0002HG0H2J\b\b\u00100\u001aD\b\u0001\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u0002H?\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u0002HG\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000101\u0012\u0006\u0012\u0004\u0018\u00010\u00010IH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010JJ&\u0010K\u001a\u00020\u0014\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0L2\u0006\u0010M\u001a\u0002H(H\u0086\u0002¢\u0006\u0002\u0010NR\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR1\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013\u0012\u0004\u0012\u00020\u00140\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006O"}, d2 = {"Lexpo/modules/kotlin/views/FunctionalComposableScope;", "", "view", "Lexpo/modules/kotlin/views/ComposeFunctionHolder;", "composableScope", "Lexpo/modules/kotlin/views/ComposableScope;", "<init>", "(Lexpo/modules/kotlin/views/ComposeFunctionHolder;Lexpo/modules/kotlin/views/ComposableScope;)V", "getView", "()Lexpo/modules/kotlin/views/ComposeFunctionHolder;", "getComposableScope", "()Lexpo/modules/kotlin/views/ComposableScope;", "appContext", "Lexpo/modules/kotlin/AppContext;", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "globalEventDispatcher", "Lkotlin/Function2;", "", "", "", "getGlobalEventDispatcher", "()Lkotlin/jvm/functions/Function2;", "Child", FirebaseAnalytics.Param.INDEX, "", "(Lexpo/modules/kotlin/views/ComposableScope;ILandroidx/compose/runtime/Composer;I)V", "(ILandroidx/compose/runtime/Composer;I)V", "Children", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", ViewProps.FILTER, "Lkotlin/Function1;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lkotlin/ParameterName;", "name", "child", "", "(Lexpo/modules/kotlin/views/ComposableScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "EventDispatcher", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "coalescingKey", "event", "", "Lexpo/modules/kotlin/viewevent/CoalescingKey;", "handle", "P0", "Lexpo/modules/kotlin/views/AsyncFunctionHandle;", "handler", "Lkotlin/coroutines/Continuation;", "(Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "P1", "Lexpo/modules/kotlin/views/AsyncFunctionHandle2;", "Lkotlin/Function3;", "(Lexpo/modules/kotlin/views/AsyncFunctionHandle2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "P2", "Lexpo/modules/kotlin/views/AsyncFunctionHandle3;", "Lkotlin/Function4;", "(Lexpo/modules/kotlin/views/AsyncFunctionHandle3;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "P3", "Lexpo/modules/kotlin/views/AsyncFunctionHandle4;", "Lkotlin/Function5;", "(Lexpo/modules/kotlin/views/AsyncFunctionHandle4;Lkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;I)V", "P4", "Lexpo/modules/kotlin/views/AsyncFunctionHandle5;", "Lkotlin/Function6;", "(Lexpo/modules/kotlin/views/AsyncFunctionHandle5;Lkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;I)V", "P5", "Lexpo/modules/kotlin/views/AsyncFunctionHandle6;", "Lkotlin/Function7;", "(Lexpo/modules/kotlin/views/AsyncFunctionHandle6;Lkotlin/jvm/functions/Function7;Landroidx/compose/runtime/Composer;I)V", "P6", "Lexpo/modules/kotlin/views/AsyncFunctionHandle7;", "Lkotlin/Function8;", "(Lexpo/modules/kotlin/views/AsyncFunctionHandle7;Lkotlin/jvm/functions/Function8;Landroidx/compose/runtime/Composer;I)V", "invoke", "Lexpo/modules/kotlin/views/EventHandle;", "payload", "(Lexpo/modules/kotlin/views/EventHandle;Ljava/lang/Object;)V", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FunctionalComposableScope {
    public static final int $stable = 8;
    private final AppContext appContext;
    private final ComposableScope composableScope;
    private final Function2<String, Map<String, ? extends Object>, Unit> globalEventDispatcher;
    private final ComposeFunctionHolder<?> view;

    static final Unit Child$lambda$0(FunctionalComposableScope functionalComposableScope, ComposableScope composableScope, int i, int i2, Composer composer, int i3) {
        functionalComposableScope.Child(composableScope, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit Child$lambda$1(FunctionalComposableScope functionalComposableScope, int i, int i2, Composer composer, int i3) {
        functionalComposableScope.Child(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit Children$lambda$0(FunctionalComposableScope functionalComposableScope, ComposableScope composableScope, int i, Composer composer, int i2) {
        functionalComposableScope.Children(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit Children$lambda$1(FunctionalComposableScope functionalComposableScope, ComposableScope composableScope, Function1 function1, int i, Composer composer, int i2) {
        functionalComposableScope.Children(composableScope, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public FunctionalComposableScope(ComposeFunctionHolder<?> view, ComposableScope composableScope) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(composableScope, "composableScope");
        this.view = view;
        this.composableScope = composableScope;
        this.appContext = view.getAppContext();
        this.globalEventDispatcher = view.getGlobalEventDispatcher();
    }

    public final ComposeFunctionHolder<?> getView() {
        return this.view;
    }

    public final ComposableScope getComposableScope() {
        return this.composableScope;
    }

    public final AppContext getAppContext() {
        return this.appContext;
    }

    public final Function2<String, Map<String, ? extends Object>, Unit> getGlobalEventDispatcher() {
        return this.globalEventDispatcher;
    }

    public final void Child(final ComposableScope composableScope, final int i, Composer composer, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(composableScope, "composableScope");
        Composer composerStartRestartGroup = composer.startRestartGroup(1968519269);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Child)348@12210L29:ExpoComposeView.kt#sri11g");
        if ((i2 & 6) == 0) {
            i3 = ((i2 & 8) == 0 ? composerStartRestartGroup.changed(composableScope) : composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1968519269, i3, -1, "expo.modules.kotlin.views.FunctionalComposableScope.Child (ExpoComposeView.kt:347)");
            }
            this.view.Child(composableScope, i, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FunctionalComposableScope.Child$lambda$0(this.f$0, composableScope, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void Child(final int i, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-977487040);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Child)353@12294L12:ExpoComposeView.kt#sri11g");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-977487040, i3, -1, "expo.modules.kotlin.views.FunctionalComposableScope.Child (ExpoComposeView.kt:352)");
            }
            this.view.Child(i, composerStartRestartGroup, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FunctionalComposableScope.Child$lambda$1(this.f$0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void Children(final ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(724828937);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Children)358@12387L25:ExpoComposeView.kt#sri11g");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(composableScope) : composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(724828937, i2, -1, "expo.modules.kotlin.views.FunctionalComposableScope.Children (ExpoComposeView.kt:357)");
            }
            this.view.Children(composableScope, composerStartRestartGroup, i2 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FunctionalComposableScope.Children$lambda$0(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void Children(final ComposableScope composableScope, final Function1<? super ExpoComposeView<?>, Boolean> filter, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(filter, "filter");
        Composer composerStartRestartGroup = composer.startRestartGroup(693283164);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Children)363@12541L33:ExpoComposeView.kt#sri11g");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(composableScope) : composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(filter) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(693283164, i2, -1, "expo.modules.kotlin.views.FunctionalComposableScope.Children (ExpoComposeView.kt:362)");
            }
            this.view.Children(composableScope, filter, composerStartRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FunctionalComposableScope.Children$lambda$1(this.f$0, composableScope, filter, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static /* synthetic */ ViewEventDelegate EventDispatcher$default(FunctionalComposableScope functionalComposableScope, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return new ViewEventDelegate(functionalComposableScope.getView(), function1);
    }

    public final /* synthetic */ <T> ViewEventDelegate<T> EventDispatcher(Function1<? super T, Short> coalescingKey) {
        return new ViewEventDelegate<>(getView(), coalescingKey);
    }

    public final /* synthetic */ <P0> void handle(final AsyncFunctionHandle<P0> asyncFunctionHandle, Function2<? super P0, ? super Continuation<Object>, ? extends Object> handler, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(asyncFunctionHandle, "<this>");
        Intrinsics.checkNotNullParameter(handler, "handler");
        ComposerKt.sourceInformationMarkerStart(composer, 2099440920, "CC(handle)384@13416L29,385@13473L279,385@13450L302:ExpoComposeView.kt#sri11g");
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(handler, composer, (i >> 3) & 14);
        String name = asyncFunctionHandle.getName();
        ComposerKt.sourceInformationMarkerStart(composer, -1071899217, "CC(remember):ExpoComposeView.kt#9igjgp");
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changed(asyncFunctionHandle)) || (i & 6) == 4) | composer.changedInstance(this) | composer.changed(stateRememberUpdatedState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1

                /* JADX INFO: renamed from: expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: ExpoComposeView.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "args", ""}, k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
                @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$1", f = "ExpoComposeView.kt", i = {0, 0}, l = {394}, m = "invokeSuspend", n = {"args", "arg"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                    final /* synthetic */ State<Function2<P0, Continuation<Object>, Object>> $currentHandler;
                    /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(State<? extends Function2<? super P0, ? super Continuation<Object>, ? extends Object>> state, Continuation<? super AnonymousClass1> continuation) {
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
                    this.this$0.getView().getFunctionHandlers().put(asyncFunctionHandle.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                    final FunctionalComposableScope functionalComposableScope = this.this$0;
                    final AsyncFunctionHandle<P0> asyncFunctionHandle2 = asyncFunctionHandle;
                    return new DisposableEffectResult() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            functionalComposableScope.getView().getFunctionHandlers().remove(asyncFunctionHandle2.getName());
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(name, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public final /* synthetic */ <P0, P1> void handle(final AsyncFunctionHandle2<P0, P1> asyncFunctionHandle2, Function3<? super P0, ? super P1, ? super Continuation<Object>, ? extends Object> handler, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(asyncFunctionHandle2, "<this>");
        Intrinsics.checkNotNullParameter(handler, "handler");
        ComposerKt.sourceInformationMarkerStart(composer, 1741791073, "CC(handle)402@13953L29,403@14010L239,403@13987L262:ExpoComposeView.kt#sri11g");
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(handler, composer, (i >> 3) & 14);
        String name = asyncFunctionHandle2.getName();
        ComposerKt.sourceInformationMarkerStart(composer, -1176017872, "CC(remember):ExpoComposeView.kt#9igjgp");
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changed(asyncFunctionHandle2)) || (i & 6) == 4) | composer.changedInstance(this) | composer.changed(stateRememberUpdatedState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$handle$2$1

                /* JADX INFO: renamed from: expo.modules.kotlin.views.FunctionalComposableScope$handle$2$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: ExpoComposeView.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "args", ""}, k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
                @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$2$1$1", f = "ExpoComposeView.kt", i = {0, 0, 0}, l = {409}, m = "invokeSuspend", n = {"args", "p0", "p1"}, nl = {-1}, s = {"L$0", "L$1", "L$2"}, v = 2)
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                    final /* synthetic */ State<Function3<P0, P1, Continuation<Object>, Object>> $currentHandler;
                    /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(State<? extends Function3<? super P0, ? super P1, ? super Continuation<Object>, ? extends Object>> state, Continuation<? super AnonymousClass1> continuation) {
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
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Function3 function3 = (Function3) this.$currentHandler.getValue();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
                        this.label = 1;
                        Object objInvoke = function3.invoke(obj2, obj3, this);
                        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    this.this$0.getView().getFunctionHandlers().put(asyncFunctionHandle2.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                    final FunctionalComposableScope functionalComposableScope = this.this$0;
                    final AsyncFunctionHandle2<P0, P1> asyncFunctionHandle3 = asyncFunctionHandle2;
                    return new DisposableEffectResult() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$handle$2$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            functionalComposableScope.getView().getFunctionHandlers().remove(asyncFunctionHandle3.getName());
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(name, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public final /* synthetic */ <P0, P1, P2> void handle(final AsyncFunctionHandle3<P0, P1, P2> asyncFunctionHandle3, Function4<? super P0, ? super P1, ? super P2, ? super Continuation<Object>, ? extends Object> handler, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(asyncFunctionHandle3, "<this>");
        Intrinsics.checkNotNullParameter(handler, "handler");
        ComposerKt.sourceInformationMarkerStart(composer, -586264289, "CC(handle)417@14470L29,418@14527L276,418@14504L299:ExpoComposeView.kt#sri11g");
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(handler, composer, (i >> 3) & 14);
        String name = asyncFunctionHandle3.getName();
        ComposerKt.sourceInformationMarkerStart(composer, -759258861, "CC(remember):ExpoComposeView.kt#9igjgp");
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changed(asyncFunctionHandle3)) || (i & 6) == 4) | composer.changedInstance(this) | composer.changed(stateRememberUpdatedState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$handle$3$1

                /* JADX INFO: renamed from: expo.modules.kotlin.views.FunctionalComposableScope$handle$3$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: ExpoComposeView.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "args", ""}, k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
                @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$3$1$1", f = "ExpoComposeView.kt", i = {0, 0, 0, 0}, l = {TypedValues.Cycle.TYPE_WAVE_PHASE}, m = "invokeSuspend", n = {"args", "p0", "p1", "p2"}, nl = {-1}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                    final /* synthetic */ State<Function4<P0, P1, P2, Continuation<Object>, Object>> $currentHandler;
                    /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(State<? extends Function4<? super P0, ? super P1, ? super P2, ? super Continuation<Object>, ? extends Object>> state, Continuation<? super AnonymousClass1> continuation) {
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
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        Function4 function4 = (Function4) this.$currentHandler.getValue();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(obj4);
                        this.label = 1;
                        Object objInvoke = function4.invoke(obj2, obj3, obj4, this);
                        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    this.this$0.getView().getFunctionHandlers().put(asyncFunctionHandle3.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                    final FunctionalComposableScope functionalComposableScope = this.this$0;
                    final AsyncFunctionHandle3<P0, P1, P2> asyncFunctionHandle4 = asyncFunctionHandle3;
                    return new DisposableEffectResult() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$handle$3$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            functionalComposableScope.getView().getFunctionHandlers().remove(asyncFunctionHandle4.getName());
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(name, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public final /* synthetic */ <P0, P1, P2, P3> void handle(final AsyncFunctionHandle4<P0, P1, P2, P3> asyncFunctionHandle4, Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Continuation<Object>, ? extends Object> handler, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(asyncFunctionHandle4, "<this>");
        Intrinsics.checkNotNullParameter(handler, "handler");
        ComposerKt.sourceInformationMarkerStart(composer, 1380647645, "CC(handle)433@15044L29,434@15101L313,434@15078L336:ExpoComposeView.kt#sri11g");
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(handler, composer, (i >> 3) & 14);
        String name = asyncFunctionHandle4.getName();
        ComposerKt.sourceInformationMarkerStart(composer, -342499850, "CC(remember):ExpoComposeView.kt#9igjgp");
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changed(asyncFunctionHandle4)) || (i & 6) == 4) | composer.changedInstance(this) | composer.changed(stateRememberUpdatedState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$handle$4$1

                /* JADX INFO: renamed from: expo.modules.kotlin.views.FunctionalComposableScope$handle$4$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: ExpoComposeView.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "args", ""}, k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
                @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$4$1$1", f = "ExpoComposeView.kt", i = {0, 0, 0, 0, 0}, l = {442}, m = "invokeSuspend", n = {"args", "p0", "p1", "p2", "p3"}, nl = {-1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                    final /* synthetic */ State<Function5<P0, P1, P2, P3, Continuation<Object>, Object>> $currentHandler;
                    /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(State<? extends Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Continuation<Object>, ? extends Object>> state, Continuation<? super AnonymousClass1> continuation) {
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
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        Object obj5 = objArr[3];
                        Function5 function5 = (Function5) this.$currentHandler.getValue();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(obj4);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(obj5);
                        this.label = 1;
                        Object objInvoke = function5.invoke(obj2, obj3, obj4, obj5, this);
                        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    this.this$0.getView().getFunctionHandlers().put(asyncFunctionHandle4.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                    final FunctionalComposableScope functionalComposableScope = this.this$0;
                    final AsyncFunctionHandle4<P0, P1, P2, P3> asyncFunctionHandle5 = asyncFunctionHandle4;
                    return new DisposableEffectResult() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$handle$4$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            functionalComposableScope.getView().getFunctionHandlers().remove(asyncFunctionHandle5.getName());
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(name, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4> void handle(final AsyncFunctionHandle5<P0, P1, P2, P3, P4> asyncFunctionHandle5, Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Continuation<Object>, ? extends Object> handler, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(asyncFunctionHandle5, "<this>");
        Intrinsics.checkNotNullParameter(handler, "handler");
        ComposerKt.sourceInformationMarkerStart(composer, -947407717, "CC(handle)450@15675L29,451@15732L350,451@15709L373:ExpoComposeView.kt#sri11g");
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(handler, composer, (i >> 3) & 14);
        String name = asyncFunctionHandle5.getName();
        ComposerKt.sourceInformationMarkerStart(composer, 74259161, "CC(remember):ExpoComposeView.kt#9igjgp");
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changed(asyncFunctionHandle5)) || (i & 6) == 4) | composer.changedInstance(this) | composer.changed(stateRememberUpdatedState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$handle$5$1

                /* JADX INFO: renamed from: expo.modules.kotlin.views.FunctionalComposableScope$handle$5$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: ExpoComposeView.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "args", ""}, k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
                @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$5$1$1", f = "ExpoComposeView.kt", i = {0, 0, 0, 0, 0, 0}, l = {460}, m = "invokeSuspend", n = {"args", "p0", "p1", "p2", "p3", "p4"}, nl = {-1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                    final /* synthetic */ State<Function6<P0, P1, P2, P3, P4, Continuation<Object>, Object>> $currentHandler;
                    /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(State<? extends Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Continuation<Object>, ? extends Object>> state, Continuation<? super AnonymousClass1> continuation) {
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
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        Object obj5 = objArr[3];
                        Object obj6 = objArr[4];
                        Function6 function6 = (Function6) this.$currentHandler.getValue();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(obj4);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(obj5);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(obj6);
                        this.label = 1;
                        Object objInvoke = function6.invoke(obj2, obj3, obj4, obj5, obj6, this);
                        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    this.this$0.getView().getFunctionHandlers().put(asyncFunctionHandle5.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                    final FunctionalComposableScope functionalComposableScope = this.this$0;
                    final AsyncFunctionHandle5<P0, P1, P2, P3, P4> asyncFunctionHandle6 = asyncFunctionHandle5;
                    return new DisposableEffectResult() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$handle$5$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            functionalComposableScope.getView().getFunctionHandlers().remove(asyncFunctionHandle6.getName());
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(name, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4, P5> void handle(final AsyncFunctionHandle6<P0, P1, P2, P3, P4, P5> asyncFunctionHandle6, Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Continuation<Object>, ? extends Object> handler, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(asyncFunctionHandle6, "<this>");
        Intrinsics.checkNotNullParameter(handler, "handler");
        ComposerKt.sourceInformationMarkerStart(composer, 1019504217, "CC(handle)468@16363L29,469@16420L387,469@16397L410:ExpoComposeView.kt#sri11g");
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(handler, composer, (i >> 3) & 14);
        String name = asyncFunctionHandle6.getName();
        ComposerKt.sourceInformationMarkerStart(composer, 491018172, "CC(remember):ExpoComposeView.kt#9igjgp");
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changed(asyncFunctionHandle6)) || (i & 6) == 4) | composer.changedInstance(this) | composer.changed(stateRememberUpdatedState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$handle$6$1

                /* JADX INFO: renamed from: expo.modules.kotlin.views.FunctionalComposableScope$handle$6$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: ExpoComposeView.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "args", ""}, k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
                @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$6$1$1", f = "ExpoComposeView.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {479}, m = "invokeSuspend", n = {"args", "p0", "p1", "p2", "p3", "p4", "p5"}, nl = {-1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                    final /* synthetic */ State<Function7<P0, P1, P2, P3, P4, P5, Continuation<Object>, Object>> $currentHandler;
                    /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(State<? extends Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Continuation<Object>, ? extends Object>> state, Continuation<? super AnonymousClass1> continuation) {
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
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        Object obj5 = objArr[3];
                        Object obj6 = objArr[4];
                        Object obj7 = objArr[5];
                        Function7 function7 = (Function7) this.$currentHandler.getValue();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(obj4);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(obj5);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(obj6);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(obj7);
                        this.label = 1;
                        Object objInvoke = function7.invoke(obj2, obj3, obj4, obj5, obj6, obj7, this);
                        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    this.this$0.getView().getFunctionHandlers().put(asyncFunctionHandle6.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                    final FunctionalComposableScope functionalComposableScope = this.this$0;
                    final AsyncFunctionHandle6<P0, P1, P2, P3, P4, P5> asyncFunctionHandle7 = asyncFunctionHandle6;
                    return new DisposableEffectResult() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$handle$6$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            functionalComposableScope.getView().getFunctionHandlers().remove(asyncFunctionHandle7.getName());
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(name, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4, P5, P6> void handle(final AsyncFunctionHandle7<P0, P1, P2, P3, P4, P5, P6> asyncFunctionHandle7, Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Continuation<Object>, ? extends Object> handler, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(asyncFunctionHandle7, "<this>");
        Intrinsics.checkNotNullParameter(handler, "handler");
        ComposerKt.sourceInformationMarkerStart(composer, -1308551145, "CC(handle)487@17108L29,488@17165L424,488@17142L447:ExpoComposeView.kt#sri11g");
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(handler, composer, (i >> 3) & 14);
        String name = asyncFunctionHandle7.getName();
        ComposerKt.sourceInformationMarkerStart(composer, 907777183, "CC(remember):ExpoComposeView.kt#9igjgp");
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changed(asyncFunctionHandle7)) || (i & 6) == 4) | composer.changedInstance(this) | composer.changed(stateRememberUpdatedState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$handle$7$1

                /* JADX INFO: renamed from: expo.modules.kotlin.views.FunctionalComposableScope$handle$7$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: ExpoComposeView.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "args", ""}, k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
                @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$7$1$1", f = "ExpoComposeView.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {499}, m = "invokeSuspend", n = {"args", "p0", "p1", "p2", "p3", "p4", "p5", "p6"}, nl = {-1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                    final /* synthetic */ State<Function8<P0, P1, P2, P3, P4, P5, P6, Continuation<Object>, Object>> $currentHandler;
                    /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(State<? extends Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Continuation<Object>, ? extends Object>> state, Continuation<? super AnonymousClass1> continuation) {
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
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        Object obj5 = objArr[3];
                        Object obj6 = objArr[4];
                        Object obj7 = objArr[5];
                        Object obj8 = objArr[6];
                        Function8 function8 = (Function8) this.$currentHandler.getValue();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(obj4);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(obj5);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(obj6);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(obj7);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(obj8);
                        this.label = 1;
                        Object objInvoke = function8.invoke(obj2, obj3, obj4, obj5, obj6, obj7, obj8, this);
                        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    this.this$0.getView().getFunctionHandlers().put(asyncFunctionHandle7.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                    final FunctionalComposableScope functionalComposableScope = this.this$0;
                    final AsyncFunctionHandle7<P0, P1, P2, P3, P4, P5, P6> asyncFunctionHandle8 = asyncFunctionHandle7;
                    return new DisposableEffectResult() { // from class: expo.modules.kotlin.views.FunctionalComposableScope$handle$7$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            functionalComposableScope.getView().getFunctionHandlers().remove(asyncFunctionHandle8.getName());
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(name, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public final <T> void invoke(EventHandle<T> eventHandle, T t) {
        Intrinsics.checkNotNullParameter(eventHandle, "<this>");
        this.view.getOrCreateEventCallback(eventHandle.getName(), eventHandle.getCoalescingKey()).invoke(t);
    }
}
