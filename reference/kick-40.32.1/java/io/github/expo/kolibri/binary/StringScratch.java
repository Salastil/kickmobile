package io.github.expo.kolibri.binary;

import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: StringScratch.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/github/expo/kolibri/binary/StringScratch;", "", "<init>", "()V", "bytes", "", "chars", "", ContentDisposition.Parameters.Size, "", "nextCapacity", "runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StringScratch {
    private byte[] bytes = new byte[128];
    private char[] chars = new char[128];

    public final byte[] bytes(int size) {
        if (this.bytes.length < size) {
            this.bytes = new byte[nextCapacity(size)];
        }
        return this.bytes;
    }

    public final char[] chars(int size) {
        if (this.chars.length < size) {
            this.chars = new char[nextCapacity(size)];
        }
        return this.chars;
    }

    private final int nextCapacity(int size) {
        return RangesKt.coerceAtMost(Integer.highestOneBit(size - 1) << 1, 4096);
    }
}
