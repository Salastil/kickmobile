package expo.modules.ui;

import androidx.compose.material3.ExposedDropdownMenuBoxScope;
import expo.modules.kotlin.views.ComposableScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExposedDropdownMenuBoxComposableScope.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"exposedDropdownMenuBoxScope", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Lexpo/modules/kotlin/views/ComposableScope;", "getExposedDropdownMenuBoxScope$annotations", "(Lexpo/modules/kotlin/views/ComposableScope;)V", "getExposedDropdownMenuBoxScope", "(Lexpo/modules/kotlin/views/ComposableScope;)Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ExposedDropdownMenuBoxComposableScopeKt {
    public static /* synthetic */ void getExposedDropdownMenuBoxScope$annotations(ComposableScope composableScope) {
    }

    public static final ExposedDropdownMenuBoxScope getExposedDropdownMenuBoxScope(ComposableScope composableScope) {
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        ExposedDropdownMenuBoxComposableScope exposedDropdownMenuBoxComposableScope = composableScope instanceof ExposedDropdownMenuBoxComposableScope ? (ExposedDropdownMenuBoxComposableScope) composableScope : null;
        if (exposedDropdownMenuBoxComposableScope != null) {
            return exposedDropdownMenuBoxComposableScope.getExposedDropdownMenuBoxScope();
        }
        return null;
    }
}
