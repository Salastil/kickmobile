package com.kick.imagecache;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* JADX INFO: compiled from: KickImageCacheModule.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/kick/imagecache/BadServerResponseException;", "Lexpo/modules/kotlin/exception/CodedException;", "statusCode", "", "<init>", "(I)V", "kick-image-cache_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class BadServerResponseException extends CodedException {
    public BadServerResponseException(int i) {
        super("BAD_SERVER_RESPONSE", "Bad server response, status code: " + i, null);
    }
}
