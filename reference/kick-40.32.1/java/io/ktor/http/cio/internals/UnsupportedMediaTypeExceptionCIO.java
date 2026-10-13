package io.ktor.http.cio.internals;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Errors.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/http/cio/internals/UnsupportedMediaTypeExceptionCIO;", "Ljava/io/IOException;", "Lkotlinx/io/IOException;", "", "message", "<init>", "(Ljava/lang/String;)V", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UnsupportedMediaTypeExceptionCIO extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsupportedMediaTypeExceptionCIO(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
