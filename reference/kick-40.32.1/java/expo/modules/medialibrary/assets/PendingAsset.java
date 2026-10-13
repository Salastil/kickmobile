package expo.modules.medialibrary.assets;

import android.os.Bundle;
import com.facebook.common.util.UriUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AssetUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0082\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lexpo/modules/medialibrary/assets/PendingAsset;", "", UriUtil.LOCAL_ASSET_SCHEME, "Landroid/os/Bundle;", "path", "", "mediaType", "", "cursorWidth", "cursorHeight", "cursorOrientation", "missingDimensions", "", "<init>", "(Landroid/os/Bundle;Ljava/lang/String;IIIIZ)V", "getAsset", "()Landroid/os/Bundle;", "getPath", "()Ljava/lang/String;", "getMediaType", "()I", "getCursorWidth", "getCursorHeight", "getCursorOrientation", "getMissingDimensions", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
final /* data */ class PendingAsset {
    private final Bundle asset;
    private final int cursorHeight;
    private final int cursorOrientation;
    private final int cursorWidth;
    private final int mediaType;
    private final boolean missingDimensions;
    private final String path;

    public static /* synthetic */ PendingAsset copy$default(PendingAsset pendingAsset, Bundle bundle, String str, int i, int i2, int i3, int i4, boolean z, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            bundle = pendingAsset.asset;
        }
        if ((i5 & 2) != 0) {
            str = pendingAsset.path;
        }
        if ((i5 & 4) != 0) {
            i = pendingAsset.mediaType;
        }
        if ((i5 & 8) != 0) {
            i2 = pendingAsset.cursorWidth;
        }
        if ((i5 & 16) != 0) {
            i3 = pendingAsset.cursorHeight;
        }
        if ((i5 & 32) != 0) {
            i4 = pendingAsset.cursorOrientation;
        }
        if ((i5 & 64) != 0) {
            z = pendingAsset.missingDimensions;
        }
        int i6 = i4;
        boolean z2 = z;
        int i7 = i3;
        int i8 = i;
        return pendingAsset.copy(bundle, str, i8, i2, i7, i6, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Bundle getAsset() {
        return this.asset;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMediaType() {
        return this.mediaType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCursorWidth() {
        return this.cursorWidth;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getCursorHeight() {
        return this.cursorHeight;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getCursorOrientation() {
        return this.cursorOrientation;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getMissingDimensions() {
        return this.missingDimensions;
    }

    public final PendingAsset copy(Bundle asset, String path, int mediaType, int cursorWidth, int cursorHeight, int cursorOrientation, boolean missingDimensions) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(path, "path");
        return new PendingAsset(asset, path, mediaType, cursorWidth, cursorHeight, cursorOrientation, missingDimensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingAsset)) {
            return false;
        }
        PendingAsset pendingAsset = (PendingAsset) other;
        return Intrinsics.areEqual(this.asset, pendingAsset.asset) && Intrinsics.areEqual(this.path, pendingAsset.path) && this.mediaType == pendingAsset.mediaType && this.cursorWidth == pendingAsset.cursorWidth && this.cursorHeight == pendingAsset.cursorHeight && this.cursorOrientation == pendingAsset.cursorOrientation && this.missingDimensions == pendingAsset.missingDimensions;
    }

    public int hashCode() {
        return (((((((((((this.asset.hashCode() * 31) + this.path.hashCode()) * 31) + Integer.hashCode(this.mediaType)) * 31) + Integer.hashCode(this.cursorWidth)) * 31) + Integer.hashCode(this.cursorHeight)) * 31) + Integer.hashCode(this.cursorOrientation)) * 31) + Boolean.hashCode(this.missingDimensions);
    }

    public String toString() {
        return "PendingAsset(asset=" + this.asset + ", path=" + this.path + ", mediaType=" + this.mediaType + ", cursorWidth=" + this.cursorWidth + ", cursorHeight=" + this.cursorHeight + ", cursorOrientation=" + this.cursorOrientation + ", missingDimensions=" + this.missingDimensions + ")";
    }

    public PendingAsset(Bundle asset, String path, int i, int i2, int i3, int i4, boolean z) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(path, "path");
        this.asset = asset;
        this.path = path;
        this.mediaType = i;
        this.cursorWidth = i2;
        this.cursorHeight = i3;
        this.cursorOrientation = i4;
        this.missingDimensions = z;
    }

    public final Bundle getAsset() {
        return this.asset;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getMediaType() {
        return this.mediaType;
    }

    public final int getCursorWidth() {
        return this.cursorWidth;
    }

    public final int getCursorHeight() {
        return this.cursorHeight;
    }

    public final int getCursorOrientation() {
        return this.cursorOrientation;
    }

    public final boolean getMissingDimensions() {
        return this.missingDimensions;
    }
}
