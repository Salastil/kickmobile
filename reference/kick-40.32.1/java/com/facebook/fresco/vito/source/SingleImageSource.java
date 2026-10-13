package com.facebook.fresco.vito.source;

import android.net.Uri;
import kotlin.Metadata;

/* JADX INFO: compiled from: SingleImageSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/source/SingleImageSource;", "Lcom/facebook/fresco/vito/source/UriImageSource;", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "getStringExtra", "", "key", "getClassNameString", "source_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SingleImageSource extends UriImageSource {
    String getStringExtra(String key);

    Uri getUri();

    /* JADX INFO: compiled from: SingleImageSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String getClassNameString(SingleImageSource singleImageSource) {
            return SingleImageSource.super.getClassNameString();
        }
    }

    @Override // com.facebook.fresco.vito.source.UriImageSource, com.facebook.fresco.vito.source.ImageSource
    default String getClassNameString() {
        return "SingleImageSource";
    }
}
