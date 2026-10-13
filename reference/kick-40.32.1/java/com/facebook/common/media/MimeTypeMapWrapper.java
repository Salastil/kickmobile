package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import androidx.media3.common.MimeTypes;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MimeTypeMapWrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\bH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/common/media/MimeTypeMapWrapper;", "", "<init>", "()V", "mimeTypeMap", "Landroid/webkit/MimeTypeMap;", "mimeTypeToExtensionMap", "", "", "extensionToMimeTypeMap", "getExtensionFromMimeType", "mimeType", "getMimeTypeFromExtension", "extension", "hasExtension", "", "hasMimeType", "fbcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MimeTypeMapWrapper {
    public static final MimeTypeMapWrapper INSTANCE = new MimeTypeMapWrapper();
    private static final Map<String, String> extensionToMimeTypeMap;
    private static final MimeTypeMap mimeTypeMap;
    private static final Map<String, String> mimeTypeToExtensionMap;

    private MimeTypeMapWrapper() {
    }

    static {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        Intrinsics.checkNotNullExpressionValue(singleton, "getSingleton(...)");
        mimeTypeMap = singleton;
        Map<String, String> mapOf = ImmutableMap.of(MimeTypes.IMAGE_HEIF, "heif", MimeTypes.IMAGE_HEIC, "heic");
        Intrinsics.checkNotNullExpressionValue(mapOf, "of(...)");
        mimeTypeToExtensionMap = mapOf;
        Map<String, String> mapOf2 = ImmutableMap.of("heif", MimeTypes.IMAGE_HEIF, "heic", MimeTypes.IMAGE_HEIC);
        Intrinsics.checkNotNullExpressionValue(mapOf2, "of(...)");
        extensionToMimeTypeMap = mapOf2;
    }

    @JvmStatic
    public static final String getExtensionFromMimeType(String mimeType) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        String str = mimeTypeToExtensionMap.get(mimeType);
        return str != null ? str : mimeTypeMap.getExtensionFromMimeType(mimeType);
    }

    @JvmStatic
    public static final String getMimeTypeFromExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        String str = extensionToMimeTypeMap.get(extension);
        return str != null ? str : mimeTypeMap.getMimeTypeFromExtension(extension);
    }

    @JvmStatic
    public static final boolean hasExtension(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return extensionToMimeTypeMap.containsKey(extension) || mimeTypeMap.hasExtension(extension);
    }

    @JvmStatic
    public static final boolean hasMimeType(String mimeType) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return mimeTypeToExtensionMap.containsKey(mimeType) || mimeTypeMap.hasMimeType(mimeType);
    }
}
