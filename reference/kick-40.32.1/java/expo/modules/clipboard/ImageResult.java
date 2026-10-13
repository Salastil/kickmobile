package expo.modules.clipboard;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.facebook.react.uimanager.ViewProps;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClipboardImage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lexpo/modules/clipboard/ImageResult;", "", "base64Image", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "<init>", "(Ljava/lang/String;II)V", "getBase64Image", "()Ljava/lang/String;", "getWidth", "()I", "getHeight", "toBundle", "Landroid/os/Bundle;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "expo-clipboard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ImageResult {
    private final String base64Image;
    private final int height;
    private final int width;

    public static /* synthetic */ ImageResult copy$default(ImageResult imageResult, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = imageResult.base64Image;
        }
        if ((i3 & 2) != 0) {
            i = imageResult.width;
        }
        if ((i3 & 4) != 0) {
            i2 = imageResult.height;
        }
        return imageResult.copy(str, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBase64Image() {
        return this.base64Image;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final ImageResult copy(String base64Image, int width, int height) {
        Intrinsics.checkNotNullParameter(base64Image, "base64Image");
        return new ImageResult(base64Image, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageResult)) {
            return false;
        }
        ImageResult imageResult = (ImageResult) other;
        return Intrinsics.areEqual(this.base64Image, imageResult.base64Image) && this.width == imageResult.width && this.height == imageResult.height;
    }

    public int hashCode() {
        return (((this.base64Image.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "ImageResult(base64Image=" + this.base64Image + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public ImageResult(String base64Image, int i, int i2) {
        Intrinsics.checkNotNullParameter(base64Image, "base64Image");
        this.base64Image = base64Image;
        this.width = i;
        this.height = i2;
    }

    public final String getBase64Image() {
        return this.base64Image;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Bundle toBundle() {
        return BundleKt.bundleOf(TuplesKt.to("data", this.base64Image), TuplesKt.to(ContentDisposition.Parameters.Size, BundleKt.bundleOf(TuplesKt.to(ViewProps.WIDTH, Integer.valueOf(this.width)), TuplesKt.to(ViewProps.HEIGHT, Integer.valueOf(this.height)))));
    }
}
