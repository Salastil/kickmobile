package expo.modules.kotlin.views;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEvent;
import expo.modules.kotlin.views.ComposeProps;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoComposeView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0006\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010$\u001a\u00020!*\u00020%H'¢\u0006\u0002\u0010&J\u0018\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0014J0\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020,H\u0014J\b\u00104\u001a\u00020!H\u0014J\b\u00105\u001a\u00020!H\u0002J\u0017\u00106\u001a\u00020!2\b\u00107\u001a\u0004\u0018\u00010%H\u0007¢\u0006\u0002\u0010&J>\u00106\u001a\u00020!2\b\u00107\u001a\u0004\u0018\u00010%2%\u00108\u001a!\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0000¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\n09H\u0007¢\u0006\u0002\u0010=J\u001d\u0010>\u001a\u00020!2\u0006\u00107\u001a\u00020%2\u0006\u0010?\u001a\u00020,H\u0007¢\u0006\u0002\u0010@J\u0015\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020,H\u0007¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020!H\u0002J\b\u0010C\u001a\u00020!H\u0016J \u0010D\u001a\u00020!2\u0006\u0010<\u001a\u00020E2\u0006\u0010?\u001a\u00020,2\u0006\u0010F\u001a\u00020GH\u0016J\u0012\u0010H\u001a\u00020!2\b\u0010<\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010I\u001a\u00020!2\b\u0010<\u001a\u0004\u0018\u00010EH\u0016J\u0010\u0010L\u001a\u00020!2\u0006\u0010M\u001a\u00020EH\u0016J\u0010\u0010N\u001a\u00020!2\u0006\u0010M\u001a\u00020EH\u0016J\u0010\u0010O\u001a\u00020\n2\u0006\u0010M\u001a\u00020EH\u0003J\b\u0010P\u001a\u00020!H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\u0004\u0018\u00018\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0019\u001a\"\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d0\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d\u0012\u0004\u0012\u00020!0 ¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020E0KX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lexpo/modules/kotlin/views/ExpoComposeView;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/views/ComposeProps;", "Lexpo/modules/kotlin/views/ExpoView;", "Lexpo/modules/kotlin/views/ComposeHostingView;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "withHostingView", "", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;Z)V", "props", "getProps", "()Lexpo/modules/kotlin/views/ComposeProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "setRecomposeScope", "(Landroidx/compose/runtime/RecomposeScope;)V", "hostingComposeView", "Landroidx/compose/ui/platform/ComposeView;", "globalEvent", "Lexpo/modules/kotlin/viewevent/ViewEvent;", "Lkotlin/Pair;", "", "", "", "globalEventDispatcher", "Lkotlin/Function2;", "", "getGlobalEventDispatcher", "()Lkotlin/jvm/functions/Function2;", "Content", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "shouldUseAndroidLayout", "getShouldUseAndroidLayout", "()Z", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "onLayout", "changed", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "onAttachedToWindow", "validateHostingAncestor", "Children", "composableScope", ViewProps.FILTER, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "child", "(Lexpo/modules/kotlin/views/ComposableScope;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Child", FirebaseAnalytics.Param.INDEX, "(Lexpo/modules/kotlin/views/ComposableScope;ILandroidx/compose/runtime/Composer;I)V", "(ILandroidx/compose/runtime/Composer;I)V", "addComposeView", "disposeHostedComposition", "addView", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "onViewAdded", "onViewRemoved", "transitioningChildren", "", "startViewTransition", "view", "endViewTransition", "isViewTransitioning", "onDetachedFromWindow", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ExpoComposeView<T extends ComposeProps> extends ExpoView implements ComposeHostingView {
    public static final int $stable = 8;
    private final ViewEvent<Pair<String, Map<String, Object>>> globalEvent;
    private final Function2<String, Map<String, ? extends Object>, Unit> globalEventDispatcher;
    private ComposeView hostingComposeView;
    private final T props;
    private RecomposeScope recomposeScope;
    private final boolean shouldUseAndroidLayout;
    private final Set<View> transitioningChildren;
    private final boolean withHostingView;

    static final Unit Child$lambda$0(ExpoComposeView expoComposeView, ComposableScope composableScope, int i, int i2, Composer composer, int i3) {
        expoComposeView.Child(composableScope, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit Child$lambda$1(ExpoComposeView expoComposeView, ComposableScope composableScope, int i, int i2, Composer composer, int i3) {
        expoComposeView.Child(composableScope, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit Child$lambda$3(ExpoComposeView expoComposeView, ComposableScope composableScope, int i, int i2, Composer composer, int i3) {
        expoComposeView.Child(composableScope, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit Child$lambda$4(ExpoComposeView expoComposeView, int i, int i2, Composer composer, int i3) {
        expoComposeView.Child(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit Children$lambda$1(ExpoComposeView expoComposeView, ComposableScope composableScope, int i, Composer composer, int i2) {
        expoComposeView.Children(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit Children$lambda$3(ExpoComposeView expoComposeView, ComposableScope composableScope, Function1 function1, int i, Composer composer, int i2) {
        expoComposeView.Children(composableScope, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public abstract void Content(ComposableScope composableScope, Composer composer, int i);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoComposeView(Context context, AppContext appContext, boolean z) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.withHostingView = z;
        this.globalEvent = new ViewEvent<>(ModuleDefinitionBuilderComposeExtensionKt.GLOBAL_EVENT_NAME, this, null);
        this.globalEventDispatcher = new Function2() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ExpoComposeView.globalEventDispatcher$lambda$0(this.f$0, (String) obj, (Map) obj2);
            }
        };
        this.shouldUseAndroidLayout = z;
        if (z) {
            setClipChildren(false);
            setClipToPadding(false);
            addOnAttachStateChangeListener(new OnAttachAfterDetachmentListener(new Function0() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ExpoComposeView._init_$lambda$0(this.f$0);
                }
            }, null, 2, null));
            addComposeView();
        } else {
            setVisibility(8);
            setWillNotDraw(true);
        }
        this.transitioningChildren = new LinkedHashSet();
    }

    public /* synthetic */ ExpoComposeView(Context context, AppContext appContext, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, appContext, (i & 4) != 0 ? false : z);
    }

    public T getProps() {
        return this.props;
    }

    protected final RecomposeScope getRecomposeScope() {
        return this.recomposeScope;
    }

    protected final void setRecomposeScope(RecomposeScope recomposeScope) {
        this.recomposeScope = recomposeScope;
    }

    public final Function2<String, Map<String, ? extends Object>, Unit> getGlobalEventDispatcher() {
        return this.globalEventDispatcher;
    }

    static final Unit globalEventDispatcher$lambda$0(ExpoComposeView expoComposeView, String name, Map params) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(params, "params");
        expoComposeView.globalEvent.invoke(new Pair<>(name, params));
        return Unit.INSTANCE;
    }

    @Override // expo.modules.kotlin.views.ExpoView
    public boolean getShouldUseAndroidLayout() {
        return this.shouldUseAndroidLayout;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getShouldUseAndroidLayout() && !isAttachedToWindow()) {
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (!getShouldUseAndroidLayout() || isAttachedToWindow()) {
            super.onLayout(changed, left, top, right, bottom);
            if (this.withHostingView) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt instanceof ComposeView) {
                        int paddingLeft = getPaddingLeft();
                        int paddingRight = getPaddingRight();
                        ((ComposeView) childAt).layout(paddingLeft, paddingRight, getWidth() + paddingLeft, getHeight() + paddingRight);
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.withHostingView) {
            return;
        }
        validateHostingAncestor();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void validateHostingAncestor() {
        String simpleName;
        ViewParent parent = getParent();
        if ((parent instanceof ExpoComposeView) || (parent instanceof ComposeView)) {
            return;
        }
        ViewFunctionHolder viewFunctionHolder = this instanceof ViewFunctionHolder ? (ViewFunctionHolder) this : null;
        if (viewFunctionHolder == null || (simpleName = viewFunctionHolder.getName()) == null) {
            simpleName = getClass().getSimpleName();
        }
        Intrinsics.checkNotNull(simpleName);
        MissingHostException missingHostException = new MissingHostException(simpleName);
        Log.e("ExpoComposeView", "", missingHostException);
        Logger jsLogger = getAppContext().getJsLogger();
        if (jsLogger != null) {
            String message = missingHostException.getMessage();
            if (message == null) {
                message = "Missing <Host>";
            }
            Logger.error$default(jsLogger, message, null, 2, null);
        }
    }

    public final void Children(final ComposableScope composableScope, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1482095158);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Children)142@5045L21:ExpoComposeView.kt#sri11g");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? composerStartRestartGroup.changed(composableScope) : composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1482095158, i2, -1, "expo.modules.kotlin.views.ExpoComposeView.Children (ExpoComposeView.kt:141)");
            }
            this.recomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                composerStartRestartGroup.startReplaceGroup(-832911828);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                View childAt = getChildAt(i3);
                ExpoComposeView expoComposeView = childAt instanceof ExpoComposeView ? (ExpoComposeView) childAt : null;
                if (expoComposeView == null) {
                    composerStartRestartGroup.endReplaceGroup();
                } else if (expoComposeView.getShouldUseAndroidLayout()) {
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startMovableGroup(1635707575, expoComposeView);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    composerStartRestartGroup.startReplaceGroup(1635708218);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    ComposableScope ComposableScope = composableScope == null ? ExpoComposeViewKt.ComposableScope() : composableScope;
                    composerStartRestartGroup.startReplaceGroup(1635709913);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*152@5451L9");
                    expoComposeView.Content(ComposableScope, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endMovableGroup();
                    composerStartRestartGroup.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExpoComposeView.Children$lambda$1(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void Children(final ComposableScope composableScope, final Function1<? super ExpoComposeView<?>, Boolean> filter, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1547638819);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Children)161@5637L21:ExpoComposeView.kt#sri11g");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? composerStartRestartGroup.changed(composableScope) : composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i : i;
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
                ComposerKt.traceEventStart(-1547638819, i2, -1, "expo.modules.kotlin.views.ExpoComposeView.Children (ExpoComposeView.kt:160)");
            }
            this.recomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                composerStartRestartGroup.startReplaceGroup(766049067);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                View childAt = getChildAt(i3);
                ExpoComposeView expoComposeView = childAt instanceof ExpoComposeView ? (ExpoComposeView) childAt : null;
                if (expoComposeView == null) {
                    composerStartRestartGroup.endReplaceGroup();
                } else if (expoComposeView.getShouldUseAndroidLayout()) {
                    composerStartRestartGroup.endReplaceGroup();
                } else if (filter.invoke(expoComposeView).booleanValue()) {
                    composerStartRestartGroup.startMovableGroup(-1222208566, expoComposeView);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    composerStartRestartGroup.startReplaceGroup(-1222207923);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    ComposableScope ComposableScope = composableScope == null ? ExpoComposeViewKt.ComposableScope() : composableScope;
                    composerStartRestartGroup.startReplaceGroup(-1222206228);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*173@5993L9");
                    expoComposeView.Content(ComposableScope, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endMovableGroup();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExpoComposeView.Children$lambda$3(this.f$0, composableScope, filter, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void Child(final ComposableScope composableScope, final int i, Composer composer, final int i2) {
        int i3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(composableScope, "composableScope");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2114978266);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Child)182@6139L21:ExpoComposeView.kt#sri11g");
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
        if ((i3 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2114978266, i3, -1, "expo.modules.kotlin.views.ExpoComposeView.Child (ExpoComposeView.kt:181)");
            }
            this.recomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
            View childAt = getChildAt(i);
            ExpoComposeView expoComposeView = childAt instanceof ExpoComposeView ? (ExpoComposeView) childAt : null;
            if (expoComposeView != null) {
                if (!expoComposeView.getShouldUseAndroidLayout()) {
                    composerStartRestartGroup.startMovableGroup(-974575118, expoComposeView);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    composerStartRestartGroup.startReplaceGroup(-974574535);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    composerStartRestartGroup.startReplaceGroup(-974573551);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*190@6366L9");
                    expoComposeView.Content(composableScope, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endMovableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    } else {
                        function2 = new Function2() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ExpoComposeView.Child$lambda$1(this.f$0, composableScope, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                    }
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ExpoComposeView.Child$lambda$0(this.f$0, composableScope, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        composerStartRestartGroup.skipToGroupEnd();
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExpoComposeView.Child$lambda$3(this.f$0, composableScope, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    public final void Child(final int i, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(685328065);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Child)198@6449L31:ExpoComposeView.kt#sri11g");
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
                ComposerKt.traceEventStart(685328065, i3, -1, "expo.modules.kotlin.views.ExpoComposeView.Child (ExpoComposeView.kt:197)");
            }
            Child(ExpoComposeViewKt.ComposableScope(), i, composerStartRestartGroup, (i3 << 3) & 1008);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExpoComposeView.Child$lambda$4(this.f$0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit _init_$lambda$0(ExpoComposeView expoComposeView) {
        expoComposeView.requestLayout();
        return Unit.INSTANCE;
    }

    private final void addComposeView() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        ComposeView composeView2 = composeView;
        HostingViewSaveableState.INSTANCE.assignNamespace(composeView2);
        composeView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ComponentCallbacks2 currentActivity = getAppContext().getCurrentActivity();
        if ((currentActivity instanceof LifecycleOwner) && (currentActivity instanceof SavedStateRegistryOwner)) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) currentActivity;
            ViewTreeLifecycleOwner.set(composeView2, lifecycleOwner);
            ViewTreeSavedStateRegistryOwner.set(composeView2, (SavedStateRegistryOwner) currentActivity);
            composeView.setViewCompositionStrategy(new ViewCompositionStrategy.DisposeOnLifecycleDestroyed(lifecycleOwner.getLifecycleRegistry()));
        } else {
            composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
            composeView.addOnAttachStateChangeListener(new OnAttachAfterDetachmentListener(new Function0() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ExpoComposeView.addComposeView$lambda$0$0(composeView);
                }
            }, null, 2, null));
        }
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1677560839, true, new Function2() { // from class: expo.modules.kotlin.views.ExpoComposeView$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ExpoComposeView.addComposeView$lambda$0$1(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        this.hostingComposeView = composeView;
        addView(composeView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addComposeView$lambda$0$0(ComposeView composeView) {
        composeView.disposeComposition();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addComposeView$lambda$0$1(ExpoComposeView expoComposeView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C*255@9038L9:ExpoComposeView.kt#sri11g");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1677560839, i, -1, "expo.modules.kotlin.views.ExpoComposeView.addComposeView.<anonymous>.<anonymous> (ExpoComposeView.kt:254)");
            }
            expoComposeView.Content(ExpoComposeViewKt.ComposableScope(), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // expo.modules.kotlin.views.ComposeHostingView
    public void disposeHostedComposition() {
        ComposeView composeView = this.hostingComposeView;
        if (composeView != null) {
            composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindow.INSTANCE);
            if (composeView.isAttachedToWindow()) {
                return;
            }
            composeView.disposeComposition();
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!(child instanceof ExpoComposeView) && !(child instanceof ComposeView) && !(this instanceof RNHostViewInterface)) {
            child = new ExpoComposeAndroidView(child, getAppContext());
        }
        super.addView(child, index, params);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        RecomposeScope recomposeScope = this.recomposeScope;
        if (recomposeScope != null) {
            recomposeScope.invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View child) {
        RecomposeScope recomposeScope;
        super.onViewRemoved(child);
        if ((child == null || !isViewTransitioning(child)) && (recomposeScope = this.recomposeScope) != null) {
            recomposeScope.invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.startViewTransition(view);
        if (Intrinsics.areEqual(view.getParent(), this)) {
            this.transitioningChildren.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        RecomposeScope recomposeScope;
        Intrinsics.checkNotNullParameter(view, "view");
        super.endViewTransition(view);
        if (!this.transitioningChildren.remove(view) || Intrinsics.areEqual(view.getParent(), this) || (recomposeScope = this.recomposeScope) == null) {
            return;
        }
        recomposeScope.invalidate();
    }

    private final boolean isViewTransitioning(View view) {
        return this.transitioningChildren.contains(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.transitioningChildren.clear();
    }
}
