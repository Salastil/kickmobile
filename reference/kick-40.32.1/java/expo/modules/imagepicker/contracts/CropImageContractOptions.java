package expo.modules.imagepicker.contracts;

import android.graphics.Bitmap;
import expo.modules.imagepicker.ImagePickerOptions;
import java.io.File;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CropImageContract.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lexpo/modules/imagepicker/contracts/CropImageContractOptions;", "Ljava/io/Serializable;", "sourceUri", "", "options", "Lexpo/modules/imagepicker/ImagePickerOptions;", "outputFile", "Ljava/io/File;", "compressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "<init>", "(Ljava/lang/String;Lexpo/modules/imagepicker/ImagePickerOptions;Ljava/io/File;Landroid/graphics/Bitmap$CompressFormat;)V", "getSourceUri", "()Ljava/lang/String;", "getOptions", "()Lexpo/modules/imagepicker/ImagePickerOptions;", "getOutputFile", "()Ljava/io/File;", "getCompressFormat", "()Landroid/graphics/Bitmap$CompressFormat;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "expo-image-picker_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CropImageContractOptions implements Serializable {
    private final Bitmap.CompressFormat compressFormat;
    private final ImagePickerOptions options;
    private final File outputFile;
    private final String sourceUri;

    public static /* synthetic */ CropImageContractOptions copy$default(CropImageContractOptions cropImageContractOptions, String str, ImagePickerOptions imagePickerOptions, File file, Bitmap.CompressFormat compressFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cropImageContractOptions.sourceUri;
        }
        if ((i & 2) != 0) {
            imagePickerOptions = cropImageContractOptions.options;
        }
        if ((i & 4) != 0) {
            file = cropImageContractOptions.outputFile;
        }
        if ((i & 8) != 0) {
            compressFormat = cropImageContractOptions.compressFormat;
        }
        return cropImageContractOptions.copy(str, imagePickerOptions, file, compressFormat);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSourceUri() {
        return this.sourceUri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ImagePickerOptions getOptions() {
        return this.options;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final File getOutputFile() {
        return this.outputFile;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Bitmap.CompressFormat getCompressFormat() {
        return this.compressFormat;
    }

    public final CropImageContractOptions copy(String sourceUri, ImagePickerOptions options, File outputFile, Bitmap.CompressFormat compressFormat) {
        Intrinsics.checkNotNullParameter(sourceUri, "sourceUri");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        Intrinsics.checkNotNullParameter(compressFormat, "compressFormat");
        return new CropImageContractOptions(sourceUri, options, outputFile, compressFormat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CropImageContractOptions)) {
            return false;
        }
        CropImageContractOptions cropImageContractOptions = (CropImageContractOptions) other;
        return Intrinsics.areEqual(this.sourceUri, cropImageContractOptions.sourceUri) && Intrinsics.areEqual(this.options, cropImageContractOptions.options) && Intrinsics.areEqual(this.outputFile, cropImageContractOptions.outputFile) && this.compressFormat == cropImageContractOptions.compressFormat;
    }

    public int hashCode() {
        return (((((this.sourceUri.hashCode() * 31) + this.options.hashCode()) * 31) + this.outputFile.hashCode()) * 31) + this.compressFormat.hashCode();
    }

    public String toString() {
        return "CropImageContractOptions(sourceUri=" + this.sourceUri + ", options=" + this.options + ", outputFile=" + this.outputFile + ", compressFormat=" + this.compressFormat + ")";
    }

    public CropImageContractOptions(String sourceUri, ImagePickerOptions options, File outputFile, Bitmap.CompressFormat compressFormat) {
        Intrinsics.checkNotNullParameter(sourceUri, "sourceUri");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        Intrinsics.checkNotNullParameter(compressFormat, "compressFormat");
        this.sourceUri = sourceUri;
        this.options = options;
        this.outputFile = outputFile;
        this.compressFormat = compressFormat;
    }

    public final String getSourceUri() {
        return this.sourceUri;
    }

    public final ImagePickerOptions getOptions() {
        return this.options;
    }

    public final File getOutputFile() {
        return this.outputFile;
    }

    public final Bitmap.CompressFormat getCompressFormat() {
        return this.compressFormat;
    }
}
