package com.facebook.fresco.vito.source;

import android.net.Uri;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: UriImageSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\bH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/source/UriImageSource;", "Lcom/facebook/fresco/vito/source/ImageSource;", "imageUri", "Landroid/net/Uri;", "getImageUri", "()Landroid/net/Uri;", "extras", "", "", "", "getExtras", "()Ljava/util/Map;", "getClassNameString", "source_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface UriImageSource extends ImageSource {
    Map<String, Object> getExtras();

    Uri getImageUri();

    /* JADX INFO: compiled from: UriImageSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String getClassNameString(UriImageSource uriImageSource) {
            return UriImageSource.super.getClassNameString();
        }
    }

    @Override // com.facebook.fresco.vito.source.ImageSource
    default String getClassNameString() {
        return "UriImageSource";
    }
}
