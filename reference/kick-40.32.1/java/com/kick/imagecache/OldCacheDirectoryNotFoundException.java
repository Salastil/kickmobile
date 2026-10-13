package com.kick.imagecache;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* JADX INFO: compiled from: KickImageCacheModule.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/kick/imagecache/OldCacheDirectoryNotFoundException;", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "()V", "kick-image-cache_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class OldCacheDirectoryNotFoundException extends CodedException {
    public OldCacheDirectoryNotFoundException() {
        super("OLD_CACHE_DIRECTORY_NOT_FOUND", "OLD_CACHE_DIRECTORY_NOT_FOUND", null);
    }
}
