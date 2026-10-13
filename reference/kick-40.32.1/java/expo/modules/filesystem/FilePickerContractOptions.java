package expo.modules.filesystem;

import android.net.Uri;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilePickerContract.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lexpo/modules/filesystem/FilePickerContractOptions;", "Ljava/io/Serializable;", "initialUri", "Landroid/net/Uri;", "mimeTypes", "", "", "multipleFiles", "", "pickerType", "Lexpo/modules/filesystem/PickerType;", "<init>", "(Landroid/net/Uri;Ljava/util/List;ZLexpo/modules/filesystem/PickerType;)V", "getInitialUri", "()Landroid/net/Uri;", "getMimeTypes", "()Ljava/util/List;", "getMultipleFiles", "()Z", "getPickerType", "()Lexpo/modules/filesystem/PickerType;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FilePickerContractOptions implements Serializable {
    private final Uri initialUri;
    private final List<String> mimeTypes;
    private final boolean multipleFiles;
    private final PickerType pickerType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilePickerContractOptions copy$default(FilePickerContractOptions filePickerContractOptions, Uri uri, List list, boolean z, PickerType pickerType, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = filePickerContractOptions.initialUri;
        }
        if ((i & 2) != 0) {
            list = filePickerContractOptions.mimeTypes;
        }
        if ((i & 4) != 0) {
            z = filePickerContractOptions.multipleFiles;
        }
        if ((i & 8) != 0) {
            pickerType = filePickerContractOptions.pickerType;
        }
        return filePickerContractOptions.copy(uri, list, z, pickerType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getInitialUri() {
        return this.initialUri;
    }

    public final List<String> component2() {
        return this.mimeTypes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getMultipleFiles() {
        return this.multipleFiles;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PickerType getPickerType() {
        return this.pickerType;
    }

    public final FilePickerContractOptions copy(Uri initialUri, List<String> mimeTypes, boolean multipleFiles, PickerType pickerType) {
        Intrinsics.checkNotNullParameter(mimeTypes, "mimeTypes");
        Intrinsics.checkNotNullParameter(pickerType, "pickerType");
        return new FilePickerContractOptions(initialUri, mimeTypes, multipleFiles, pickerType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilePickerContractOptions)) {
            return false;
        }
        FilePickerContractOptions filePickerContractOptions = (FilePickerContractOptions) other;
        return Intrinsics.areEqual(this.initialUri, filePickerContractOptions.initialUri) && Intrinsics.areEqual(this.mimeTypes, filePickerContractOptions.mimeTypes) && this.multipleFiles == filePickerContractOptions.multipleFiles && this.pickerType == filePickerContractOptions.pickerType;
    }

    public int hashCode() {
        Uri uri = this.initialUri;
        return ((((((uri == null ? 0 : uri.hashCode()) * 31) + this.mimeTypes.hashCode()) * 31) + Boolean.hashCode(this.multipleFiles)) * 31) + this.pickerType.hashCode();
    }

    public String toString() {
        return "FilePickerContractOptions(initialUri=" + this.initialUri + ", mimeTypes=" + this.mimeTypes + ", multipleFiles=" + this.multipleFiles + ", pickerType=" + this.pickerType + ")";
    }

    public FilePickerContractOptions(Uri uri, List<String> mimeTypes, boolean z, PickerType pickerType) {
        Intrinsics.checkNotNullParameter(mimeTypes, "mimeTypes");
        Intrinsics.checkNotNullParameter(pickerType, "pickerType");
        this.initialUri = uri;
        this.mimeTypes = mimeTypes;
        this.multipleFiles = z;
        this.pickerType = pickerType;
    }

    public /* synthetic */ FilePickerContractOptions(Uri uri, List list, boolean z, PickerType pickerType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, list, z, (i & 8) != 0 ? PickerType.FILE : pickerType);
    }

    public final Uri getInitialUri() {
        return this.initialUri;
    }

    public final List<String> getMimeTypes() {
        return this.mimeTypes;
    }

    public final boolean getMultipleFiles() {
        return this.multipleFiles;
    }

    public final PickerType getPickerType() {
        return this.pickerType;
    }
}
