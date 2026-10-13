package expo.modules.updates.reloadscreen;

import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReloadScreenConfiguration.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lexpo/modules/updates/reloadscreen/SpinnerConfiguration;", "", "enabled", "", "color", "", ContentDisposition.Parameters.Size, "Lexpo/modules/updates/reloadscreen/SpinnerSize;", "<init>", "(ZILexpo/modules/updates/reloadscreen/SpinnerSize;)V", "getEnabled", "()Z", "getColor", "()I", "getSize", "()Lexpo/modules/updates/reloadscreen/SpinnerSize;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SpinnerConfiguration {
    private final int color;
    private final boolean enabled;
    private final SpinnerSize size;

    public static /* synthetic */ SpinnerConfiguration copy$default(SpinnerConfiguration spinnerConfiguration, boolean z, int i, SpinnerSize spinnerSize, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = spinnerConfiguration.enabled;
        }
        if ((i2 & 2) != 0) {
            i = spinnerConfiguration.color;
        }
        if ((i2 & 4) != 0) {
            spinnerSize = spinnerConfiguration.size;
        }
        return spinnerConfiguration.copy(z, i, spinnerSize);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SpinnerSize getSize() {
        return this.size;
    }

    public final SpinnerConfiguration copy(boolean enabled, int color, SpinnerSize size) {
        Intrinsics.checkNotNullParameter(size, "size");
        return new SpinnerConfiguration(enabled, color, size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpinnerConfiguration)) {
            return false;
        }
        SpinnerConfiguration spinnerConfiguration = (SpinnerConfiguration) other;
        return this.enabled == spinnerConfiguration.enabled && this.color == spinnerConfiguration.color && this.size == spinnerConfiguration.size;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.enabled) * 31) + Integer.hashCode(this.color)) * 31) + this.size.hashCode();
    }

    public String toString() {
        return "SpinnerConfiguration(enabled=" + this.enabled + ", color=" + this.color + ", size=" + this.size + ")";
    }

    public SpinnerConfiguration(boolean z, int i, SpinnerSize size) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.enabled = z;
        this.color = i;
        this.size = size;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getColor() {
        return this.color;
    }

    public final SpinnerSize getSize() {
        return this.size;
    }
}
