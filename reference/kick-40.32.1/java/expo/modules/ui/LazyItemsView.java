package expo.modules.ui;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: LazyItemsView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\r\u0010!\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\"J\u0011\u0010#\u001a\u00020\u001d*\u00020$H\u0017¢\u0006\u0002\u0010%R\u0014\u0010\t\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lexpo/modules/ui/LazyItemsView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/ui/LazyItemsProps;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "props", "getProps", "()Lexpo/modules/ui/LazyItemsProps;", "onWindowChange", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/ui/WindowChangeEvent;", "getOnWindowChange", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onWindowChange$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "pool", "Landroidx/compose/runtime/MutableState;", "Lexpo/modules/ui/LazyItemsPoolView;", "getPool$expo_ui_release", "()Landroidx/compose/runtime/MutableState;", "window", "Lexpo/modules/ui/LazyItemsWindow;", "getWindow$expo_ui_release", "()Lexpo/modules/ui/LazyItemsWindow;", "onViewAdded", "", "child", "Landroid/view/View;", "onViewRemoved", "cancelPendingWindowChange", "cancelPendingWindowChange$expo_ui_release", "Content", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LazyItemsView extends ExpoComposeView<LazyItemsProps> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LazyItemsView.class, "onWindowChange", "getOnWindowChange()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    public static final int $stable = 8;

    /* JADX INFO: renamed from: onWindowChange$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onWindowChange;
    private final MutableState<LazyItemsPoolView> pool;
    private final LazyItemsProps props;
    private final LazyItemsWindow window;

    static final Unit Content$lambda$1(LazyItemsView lazyItemsView, ComposableScope composableScope, int i, Composer composer, int i2) {
        lazyItemsView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyItemsView(Context context, AppContext appContext) {
        super(context, appContext, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.props = new LazyItemsProps(null, null, null, 7, null);
        this.onWindowChange = new ViewEventDelegate(this, null);
        this.pool = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.window = new LazyItemsWindow(new Function3() { // from class: expo.modules.ui.LazyItemsView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return LazyItemsView.window$lambda$0(this.f$0, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
            }
        });
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public LazyItemsProps getProps() {
        return this.props;
    }

    private final ViewEventCallback<WindowChangeEvent> getOnWindowChange() {
        return this.onWindowChange.getValue(this, $$delegatedProperties[0]);
    }

    public final MutableState<LazyItemsPoolView> getPool$expo_ui_release() {
        return this.pool;
    }

    /* JADX INFO: renamed from: getWindow$expo_ui_release, reason: from getter */
    public final LazyItemsWindow getWindow() {
        return this.window;
    }

    static final Unit window$lambda$0(LazyItemsView lazyItemsView, int i, int i2, int i3) {
        lazyItemsView.getOnWindowChange().invoke(new WindowChangeEvent(i, i2, i3));
        return Unit.INSTANCE;
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView, android.view.ViewGroup
    public void onViewAdded(View child) {
        View childAt;
        super.onViewAdded(child);
        MutableState<LazyItemsPoolView> mutableState = this.pool;
        LazyItemsView lazyItemsView = this;
        int childCount = lazyItemsView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            childAt = lazyItemsView.getChildAt(i);
            if (childAt instanceof LazyItemsPoolView) {
                mutableState.setValue((LazyItemsPoolView) childAt);
            }
        }
        childAt = null;
        mutableState.setValue((LazyItemsPoolView) childAt);
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView, android.view.ViewGroup
    public void onViewRemoved(View child) {
        View childAt;
        super.onViewRemoved(child);
        MutableState<LazyItemsPoolView> mutableState = this.pool;
        LazyItemsView lazyItemsView = this;
        int childCount = lazyItemsView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            childAt = lazyItemsView.getChildAt(i);
            if (childAt instanceof LazyItemsPoolView) {
                mutableState.setValue((LazyItemsPoolView) childAt);
            }
        }
        childAt = null;
        mutableState.setValue((LazyItemsPoolView) childAt);
    }

    public final void cancelPendingWindowChange$expo_ui_release() {
        this.window.cancel();
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(final ComposableScope composableScope, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-854656219);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content):LazyItemsView.kt#v15e7d");
        int i2 = i & 1;
        if (composerStartRestartGroup.shouldExecute(i2 != 0, i2)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-854656219, i, -1, "expo.modules.ui.LazyItemsView.Content (LazyItemsView.kt:80)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.LazyItemsView$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LazyItemsView.Content$lambda$1(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
