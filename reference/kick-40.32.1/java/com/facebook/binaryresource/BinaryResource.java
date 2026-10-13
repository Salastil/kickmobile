package com.facebook.binaryresource;

import io.ktor.http.ContentDisposition;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BinaryResource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/facebook/binaryresource/BinaryResource;", "", "openStream", "Ljava/io/InputStream;", "read", "", ContentDisposition.Parameters.Size, "", "getExtra", "", "key", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface BinaryResource {
    default String getExtra(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    InputStream openStream() throws IOException;

    byte[] read() throws IOException;

    long size();

    /* JADX INFO: compiled from: BinaryResource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String getExtra(BinaryResource binaryResource, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return BinaryResource.super.getExtra(key);
        }
    }
}
