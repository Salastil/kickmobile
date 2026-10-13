package expo.modules.ui;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import expo.modules.kotlin.views.ComposableScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UIComposableScope.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0017\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"rowScope", "Landroidx/compose/foundation/layout/RowScope;", "Lexpo/modules/kotlin/views/ComposableScope;", "getRowScope", "(Lexpo/modules/kotlin/views/ComposableScope;)Landroidx/compose/foundation/layout/RowScope;", "columnScope", "Landroidx/compose/foundation/layout/ColumnScope;", "getColumnScope", "(Lexpo/modules/kotlin/views/ComposableScope;)Landroidx/compose/foundation/layout/ColumnScope;", "boxScope", "Landroidx/compose/foundation/layout/BoxScope;", "getBoxScope", "(Lexpo/modules/kotlin/views/ComposableScope;)Landroidx/compose/foundation/layout/BoxScope;", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection", "(Lexpo/modules/kotlin/views/ComposableScope;)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UIComposableScopeKt {
    public static final RowScope getRowScope(ComposableScope composableScope) {
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        UIComposableScope uIComposableScope = composableScope instanceof UIComposableScope ? (UIComposableScope) composableScope : null;
        if (uIComposableScope != null) {
            return uIComposableScope.getRowScope();
        }
        return null;
    }

    public static final ColumnScope getColumnScope(ComposableScope composableScope) {
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        UIComposableScope uIComposableScope = composableScope instanceof UIComposableScope ? (UIComposableScope) composableScope : null;
        if (uIComposableScope != null) {
            return uIComposableScope.getColumnScope();
        }
        return null;
    }

    public static final BoxScope getBoxScope(ComposableScope composableScope) {
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        UIComposableScope uIComposableScope = composableScope instanceof UIComposableScope ? (UIComposableScope) composableScope : null;
        if (uIComposableScope != null) {
            return uIComposableScope.getBoxScope();
        }
        return null;
    }

    public static final NestedScrollConnection getNestedScrollConnection(ComposableScope composableScope) {
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        UIComposableScope uIComposableScope = composableScope instanceof UIComposableScope ? (UIComposableScope) composableScope : null;
        if (uIComposableScope != null) {
            return uIComposableScope.getNestedScrollConnection();
        }
        return null;
    }
}
