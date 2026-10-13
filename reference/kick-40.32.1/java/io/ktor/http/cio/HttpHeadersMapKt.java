package io.ktor.http.cio;

import io.ktor.utils.io.pool.DefaultPool;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpHeadersMap.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\"\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b\"\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000b\"\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000b\"\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000b\"\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000b\"\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000b\"\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000b\"\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000b\"\u0014\u0010\u0017\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000b\"\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u000b\"\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\"\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001c¨\u0006\u001f"}, d2 = {"Lio/ktor/http/cio/HttpHeadersMap;", "", "indent", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "", "dumpTo", "(Lio/ktor/http/cio/HttpHeadersMap;Ljava/lang/String;Ljava/lang/Appendable;)V", "", "EXPECTED_HEADERS_QTY", "I", "HEADER_SIZE", "HEADER_ARRAY_POOL_SIZE", "HEADER_ARRAY_SIZE", "EMPTY_INDEX", "", "RESIZE_THRESHOLD", "D", "OFFSET_NAME_HASH", "OFFSET_HEADER_NAME_START", "OFFSET_HEADER_NAME_END", "OFFSET_HEADER_VALUE_START", "OFFSET_HEADER_VALUE_END", "OFFSET_NEXT_HEADER", "Lio/ktor/utils/io/pool/DefaultPool;", "", "IntArrayPool", "Lio/ktor/utils/io/pool/DefaultPool;", "Lio/ktor/http/cio/HeadersData;", "HeadersDataPool", "ktor-http-cio"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpHeadersMapKt {
    private static final int EMPTY_INDEX = -1;
    private static final int EXPECTED_HEADERS_QTY = 128;
    private static final int HEADER_ARRAY_POOL_SIZE = 1000;
    private static final int HEADER_ARRAY_SIZE = 768;
    private static final int HEADER_SIZE = 6;
    private static final int OFFSET_HEADER_NAME_END = 2;
    private static final int OFFSET_HEADER_NAME_START = 1;
    private static final int OFFSET_HEADER_VALUE_END = 4;
    private static final int OFFSET_HEADER_VALUE_START = 3;
    private static final int OFFSET_NAME_HASH = 0;
    private static final int OFFSET_NEXT_HEADER = 5;
    private static final double RESIZE_THRESHOLD = 0.75d;
    private static final DefaultPool<int[]> IntArrayPool = new DefaultPool<int[]>() { // from class: io.ktor.http.cio.HttpHeadersMapKt$IntArrayPool$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.ktor.utils.io.pool.DefaultPool
        public int[] produceInstance() {
            int[] iArr = new int[768];
            for (int i = 0; i < 768; i++) {
                iArr[i] = -1;
            }
            return iArr;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.ktor.utils.io.pool.DefaultPool
        public int[] clearInstance(int[] instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            ArraysKt.fill$default(instance, -1, 0, 0, 6, (Object) null);
            return (int[]) super.clearInstance(instance);
        }
    };
    private static final DefaultPool<HeadersData> HeadersDataPool = new DefaultPool<HeadersData>() { // from class: io.ktor.http.cio.HttpHeadersMapKt$HeadersDataPool$1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.utils.io.pool.DefaultPool
        public HeadersData produceInstance() {
            return new HeadersData();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.ktor.utils.io.pool.DefaultPool
        public HeadersData clearInstance(HeadersData instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            instance.release();
            return (HeadersData) super.clearInstance(instance);
        }
    };

    public static final void dumpTo(HttpHeadersMap httpHeadersMap, String indent, Appendable out) throws IOException {
        Intrinsics.checkNotNullParameter(httpHeadersMap, "<this>");
        Intrinsics.checkNotNullParameter(indent, "indent");
        Intrinsics.checkNotNullParameter(out, "out");
        Iterator<Integer> it = httpHeadersMap.offsets().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            out.append(indent);
            out.append(httpHeadersMap.nameAtOffset(iIntValue));
            out.append(" => ");
            out.append(httpHeadersMap.valueAtOffset(iIntValue));
            out.append("\n");
        }
    }
}
