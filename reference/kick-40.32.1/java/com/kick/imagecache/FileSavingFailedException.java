package com.kick.imagecache;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KickImageCacheModule.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/kick/imagecache/FileSavingFailedException;", "Lexpo/modules/kotlin/exception/CodedException;", "path", "", "<init>", "(Ljava/lang/String;)V", "kick-image-cache_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class FileSavingFailedException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSavingFailedException(String path) {
        super("FILE_SAVING_FAILED", "Could not save file at path: " + path, null);
        Intrinsics.checkNotNullParameter(path, "path");
    }
}
