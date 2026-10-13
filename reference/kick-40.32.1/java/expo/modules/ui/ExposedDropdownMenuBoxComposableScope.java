package expo.modules.ui;

import androidx.compose.material3.ExposedDropdownMenuBoxScope;
import expo.modules.kotlin.views.ComposableScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExposedDropdownMenuBoxComposableScope.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lexpo/modules/ui/ExposedDropdownMenuBoxComposableScope;", "Lexpo/modules/kotlin/views/ComposableScope;", "exposedDropdownMenuBoxScope", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "<init>", "(Landroidx/compose/material3/ExposedDropdownMenuBoxScope;)V", "getExposedDropdownMenuBoxScope", "()Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ExposedDropdownMenuBoxComposableScope implements ComposableScope {
    public static final int $stable = ExposedDropdownMenuBoxScope.$stable;
    private final ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope;

    public static /* synthetic */ ExposedDropdownMenuBoxComposableScope copy$default(ExposedDropdownMenuBoxComposableScope exposedDropdownMenuBoxComposableScope, ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, int i, Object obj) {
        if ((i & 1) != 0) {
            exposedDropdownMenuBoxScope = exposedDropdownMenuBoxComposableScope.exposedDropdownMenuBoxScope;
        }
        return exposedDropdownMenuBoxComposableScope.copy(exposedDropdownMenuBoxScope);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ExposedDropdownMenuBoxScope getExposedDropdownMenuBoxScope() {
        return this.exposedDropdownMenuBoxScope;
    }

    public final ExposedDropdownMenuBoxComposableScope copy(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope) {
        Intrinsics.checkNotNullParameter(exposedDropdownMenuBoxScope, "exposedDropdownMenuBoxScope");
        return new ExposedDropdownMenuBoxComposableScope(exposedDropdownMenuBoxScope);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ExposedDropdownMenuBoxComposableScope) && Intrinsics.areEqual(this.exposedDropdownMenuBoxScope, ((ExposedDropdownMenuBoxComposableScope) other).exposedDropdownMenuBoxScope);
    }

    public int hashCode() {
        return this.exposedDropdownMenuBoxScope.hashCode();
    }

    public String toString() {
        return "ExposedDropdownMenuBoxComposableScope(exposedDropdownMenuBoxScope=" + this.exposedDropdownMenuBoxScope + ")";
    }

    public ExposedDropdownMenuBoxComposableScope(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope) {
        Intrinsics.checkNotNullParameter(exposedDropdownMenuBoxScope, "exposedDropdownMenuBoxScope");
        this.exposedDropdownMenuBoxScope = exposedDropdownMenuBoxScope;
    }

    public final ExposedDropdownMenuBoxScope getExposedDropdownMenuBoxScope() {
        return this.exposedDropdownMenuBoxScope;
    }
}
