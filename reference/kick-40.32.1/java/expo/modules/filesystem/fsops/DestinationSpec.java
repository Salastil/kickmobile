package expo.modules.filesystem.fsops;

import expo.modules.filesystem.unifiedfile.UnifiedFileInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DestinationSpec.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0010J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\f¨\u0006\u001b"}, d2 = {"Lexpo/modules/filesystem/fsops/DestinationSpec;", "", "path", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "overwrite", "", "isDirectory", "<init>", "(Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;ZZ)V", "getPath", "()Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "getOverwrite", "()Z", "resolve", "Lexpo/modules/filesystem/fsops/DestinationSink;", "source", "resolve$expo_file_system_release", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DestinationSpec {
    private final boolean isDirectory;
    private final boolean overwrite;
    private final UnifiedFileInterface path;

    public static /* synthetic */ DestinationSpec copy$default(DestinationSpec destinationSpec, UnifiedFileInterface unifiedFileInterface, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            unifiedFileInterface = destinationSpec.path;
        }
        if ((i & 2) != 0) {
            z = destinationSpec.overwrite;
        }
        if ((i & 4) != 0) {
            z2 = destinationSpec.isDirectory;
        }
        return destinationSpec.copy(unifiedFileInterface, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UnifiedFileInterface getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getOverwrite() {
        return this.overwrite;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsDirectory() {
        return this.isDirectory;
    }

    public final DestinationSpec copy(UnifiedFileInterface path, boolean overwrite, boolean isDirectory) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new DestinationSpec(path, overwrite, isDirectory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DestinationSpec)) {
            return false;
        }
        DestinationSpec destinationSpec = (DestinationSpec) other;
        return Intrinsics.areEqual(this.path, destinationSpec.path) && this.overwrite == destinationSpec.overwrite && this.isDirectory == destinationSpec.isDirectory;
    }

    public int hashCode() {
        return (((this.path.hashCode() * 31) + Boolean.hashCode(this.overwrite)) * 31) + Boolean.hashCode(this.isDirectory);
    }

    public String toString() {
        return "DestinationSpec(path=" + this.path + ", overwrite=" + this.overwrite + ", isDirectory=" + this.isDirectory + ")";
    }

    public DestinationSpec(UnifiedFileInterface path, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.overwrite = z;
        this.isDirectory = z2;
    }

    public /* synthetic */ DestinationSpec(UnifiedFileInterface unifiedFileInterface, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(unifiedFileInterface, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2);
    }

    public final UnifiedFileInterface getPath() {
        return this.path;
    }

    public final boolean getOverwrite() {
        return this.overwrite;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final DestinationSink resolve$expo_file_system_release(UnifiedFileInterface source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return this.path.getCopyMoveStrategy().prepareAsDestination$expo_file_system_release(source, this);
    }
}
