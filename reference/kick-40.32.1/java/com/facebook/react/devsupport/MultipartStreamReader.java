package com.facebook.react.devsupport;

import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.DeprecatedUpgrade;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: MultipartStreamReader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001d\u001e\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J8\u0010\u0019\u001a\u00020\u00132\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/react/devsupport/MultipartStreamReader;", "", "source", "Lokio/BufferedSource;", "boundary", "", "<init>", "(Lokio/BufferedSource;Ljava/lang/String;)V", "lastProgressEvent", "", "readAllParts", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/react/devsupport/MultipartStreamReader$ChunkListener;", "parseHeaders", "", "data", "Lokio/Buffer;", "emitChunk", "", "content", "chunkLength", "done", "drainFully", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "emitProgress", "headers", "contentLength", "isFinal", "ChunkListener", "FixedLengthSource", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MultipartStreamReader {
    private static final String CRLF = "\r\n";
    private final String boundary;
    private long lastProgressEvent;
    private final BufferedSource source;

    /* JADX INFO: compiled from: MultipartStreamReader.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J,\u0010\u000b\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/devsupport/MultipartStreamReader$ChunkListener;", "", "onChunkComplete", "", "headers", "", "", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lokio/BufferedSource;", "isLastChunk", "", "onChunkProgress", "loaded", "", "total", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ChunkListener {
        void onChunkComplete(Map<String, String> headers, BufferedSource body, boolean isLastChunk) throws IOException;

        void onChunkProgress(Map<String, String> headers, long loaded, long total) throws IOException;
    }

    public MultipartStreamReader(BufferedSource source, String boundary) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        this.source = source;
        this.boundary = boundary;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e7 A[SYNTHETIC] */
    public final boolean readAllParts(ChunkListener listener) throws IOException {
        boolean z;
        Buffer buffer;
        Map<String, String> map;
        long j;
        long j2;
        boolean z2;
        Map<String, String> map2;
        MultipartStreamReader multipartStreamReader = this;
        listener = listener;
        Intrinsics.checkNotNullParameter(listener, "listener");
        ByteString byteStringM14491deprecated_encodeUtf8 = ByteString.INSTANCE.m14491deprecated_encodeUtf8("\r\n--" + multipartStreamReader.boundary + "\r\n");
        ByteString byteStringM14491deprecated_encodeUtf9 = ByteString.INSTANCE.m14491deprecated_encodeUtf8("\r\n--" + multipartStreamReader.boundary + "--\r\n");
        ByteString byteStringM14491deprecated_encodeUtf10 = ByteString.INSTANCE.m14491deprecated_encodeUtf8("\r\n\r\n");
        Buffer buffer2 = new Buffer();
        long jM14487deprecated_size = -1L;
        Map<String, String> headers = null;
        long jM14487deprecated_size2 = 0;
        long j3 = 0;
        while (true) {
            long jMax = (long) Math.max(jM14487deprecated_size2 - ((long) byteStringM14491deprecated_encodeUtf9.m14487deprecated_size()), j3);
            long jIndexOf = buffer2.indexOf(byteStringM14491deprecated_encodeUtf8, jMax);
            if (jIndexOf == -1) {
                jIndexOf = buffer2.indexOf(byteStringM14491deprecated_encodeUtf9, jMax);
                z = true;
            } else {
                z = false;
            }
            if (jIndexOf == -1) {
                long size = buffer2.getSize();
                if (headers == null) {
                    long jIndexOf2 = buffer2.indexOf(byteStringM14491deprecated_encodeUtf10, jMax);
                    if (jIndexOf2 >= 0) {
                        Buffer buffer3 = new Buffer();
                        long j4 = j3;
                        Buffer buffer4 = buffer2;
                        buffer4.copyTo(buffer3, jMax, jIndexOf2 - jMax);
                        buffer = buffer4;
                        headers = multipartStreamReader.parseHeaders(buffer3);
                        jM14487deprecated_size = jIndexOf2 + ((long) byteStringM14491deprecated_encodeUtf10.m14487deprecated_size());
                        j = j4;
                        byteStringM14491deprecated_encodeUtf8 = byteStringM14491deprecated_encodeUtf8;
                        byteStringM14491deprecated_encodeUtf9 = byteStringM14491deprecated_encodeUtf9;
                        j2 = 0;
                    } else {
                        long j5 = j3;
                        buffer = buffer2;
                        j = j5;
                        map = headers;
                        j2 = 0;
                    }
                    if (multipartStreamReader.source.read(buffer, 16384L) <= j2) {
                        return false;
                    }
                    buffer2 = buffer;
                    byteStringM14491deprecated_encodeUtf8 = byteStringM14491deprecated_encodeUtf8;
                    byteStringM14491deprecated_encodeUtf9 = byteStringM14491deprecated_encodeUtf9;
                    j3 = j;
                    jM14487deprecated_size2 = size;
                } else {
                    long j6 = j3;
                    buffer = buffer2;
                    map = headers;
                    j = j6;
                    multipartStreamReader = this;
                    j2 = 0;
                    multipartStreamReader.emitProgress(map, Math.max(0L, buffer.getSize() - jM14487deprecated_size), false, listener);
                }
                headers = map;
                if (multipartStreamReader.source.read(buffer, 16384L) <= j2) {
                    return false;
                }
                buffer2 = buffer;
                byteStringM14491deprecated_encodeUtf8 = byteStringM14491deprecated_encodeUtf8;
                byteStringM14491deprecated_encodeUtf9 = byteStringM14491deprecated_encodeUtf9;
                j3 = j;
                jM14487deprecated_size2 = size;
            } else {
                long j7 = j3;
                Buffer buffer5 = buffer2;
                Map<String, String> map3 = headers;
                ByteString byteString = byteStringM14491deprecated_encodeUtf8;
                ByteString byteString2 = byteStringM14491deprecated_encodeUtf9;
                long j8 = jIndexOf - j7;
                if (j7 > 0) {
                    if (map3 != null && jM14487deprecated_size >= 0) {
                        multipartStreamReader.emitProgress(map3, Math.max(0L, jIndexOf - jM14487deprecated_size), true, listener);
                    }
                    buffer5.skip(j7);
                    buffer2 = buffer5;
                    z2 = z;
                    emitChunk(buffer2, j8, z2, listener);
                    jM14487deprecated_size = -1;
                    map2 = null;
                } else {
                    z2 = z;
                    map2 = map3;
                    buffer2 = buffer5;
                    buffer2.skip(jIndexOf);
                }
                if (z2) {
                    return true;
                }
                multipartStreamReader = this;
                jM14487deprecated_size2 = byteString.m14487deprecated_size();
                byteStringM14491deprecated_encodeUtf8 = byteString;
                headers = map2;
                byteStringM14491deprecated_encodeUtf9 = byteString2;
                j3 = jM14487deprecated_size2;
            }
        }
    }

    private final Map<String, String> parseHeaders(Buffer data) {
        List listEmptyList;
        TreeMap treeMap = new TreeMap(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        List<String> listSplit = new Regex("\r\n").split(data.readUtf8(), 0);
        if (!listSplit.isEmpty()) {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                    break;
                }
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
            break;
        }
        for (String str : (String[]) listEmptyList.toArray(new String[0])) {
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, ServerSentEventKt.COLON, 0, false, 6, (Object) null);
            if (iIndexOf$default != -1) {
                String strSubstring = str.substring(0, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String str2 = strSubstring;
                int length = str2.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                String string = str2.subSequence(i, length + 1).toString();
                String strSubstring2 = str.substring(iIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                String str3 = strSubstring2;
                int length2 = str3.length() - 1;
                int i2 = 0;
                boolean z3 = false;
                while (i2 <= length2) {
                    boolean z4 = Intrinsics.compare((int) str3.charAt(!z3 ? i2 : length2), 32) <= 0;
                    if (z3) {
                        if (!z4) {
                            break;
                        }
                        length2--;
                    } else if (z4) {
                        i2++;
                    } else {
                        z3 = true;
                    }
                }
                treeMap.put(string, str3.subSequence(i2, length2 + 1).toString());
            }
        }
        return treeMap;
    }

    private final void emitChunk(Buffer content, long chunkLength, boolean done, ChunkListener listener) throws IOException {
        ByteString byteStringM14491deprecated_encodeUtf8 = ByteString.INSTANCE.m14491deprecated_encodeUtf8("\r\n\r\n");
        long jIndexOf = content.indexOf(byteStringM14491deprecated_encodeUtf8, 0L);
        if (jIndexOf == -1 || jIndexOf >= chunkLength) {
            BufferedSource bufferedSourceBuffer = DeprecatedUpgrade.getOkio().buffer(new FixedLengthSource(content, chunkLength));
            try {
                listener.onChunkComplete(MapsKt.emptyMap(), bufferedSourceBuffer, done);
                return;
            } finally {
                drainFully(bufferedSourceBuffer);
            }
        }
        Buffer buffer = new Buffer();
        content.read(buffer, jIndexOf);
        content.skip(byteStringM14491deprecated_encodeUtf8.m14487deprecated_size());
        Map<String, String> headers = parseHeaders(buffer);
        BufferedSource bufferedSourceBuffer2 = DeprecatedUpgrade.getOkio().buffer(new FixedLengthSource(content, (chunkLength - jIndexOf) - ((long) byteStringM14491deprecated_encodeUtf8.m14487deprecated_size())));
        try {
            listener.onChunkComplete(headers, bufferedSourceBuffer2, done);
        } finally {
            drainFully(bufferedSourceBuffer2);
        }
    }

    private final void drainFully(BufferedSource body) {
        Buffer buffer = new Buffer();
        while (body.read(buffer, 8192L) != -1) {
            try {
                buffer.clear();
            } catch (IOException unused) {
                return;
            }
        }
    }

    /* JADX INFO: compiled from: MultipartStreamReader.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/react/devsupport/MultipartStreamReader$FixedLengthSource;", "Lokio/Source;", "upstream", "Lokio/Buffer;", "remaining", "", "<init>", "(Lokio/Buffer;J)V", "read", "sink", "byteCount", InstrumentationTags.TIMEOUT, "Lokio/Timeout;", "close", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class FixedLengthSource implements Source {
        private long remaining;
        private final Buffer upstream;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public FixedLengthSource(Buffer upstream, long j) {
            Intrinsics.checkNotNullParameter(upstream, "upstream");
            this.upstream = upstream;
            this.remaining = j;
        }

        @Override // okio.Source
        public long read(Buffer sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (byteCount == 0) {
                return 0L;
            }
            long j = this.remaining;
            if (j == 0) {
                return -1L;
            }
            long j2 = this.upstream.read(sink, Math.min(byteCount, j));
            if (j2 == -1) {
                return -1L;
            }
            this.remaining -= j2;
            return j2;
        }

        @Override // okio.Source
        /* JADX INFO: renamed from: timeout */
        public Timeout getTimeout() {
            return Timeout.NONE;
        }
    }

    private final void emitProgress(Map<String, String> headers, long contentLength, boolean isFinal, ChunkListener listener) throws IOException {
        if (listener == null || headers == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastProgressEvent > 16 || isFinal) {
            this.lastProgressEvent = jCurrentTimeMillis;
            listener.onChunkProgress(headers, contentLength, Long.parseLong(headers.getOrDefault("Content-Length", "0")));
        }
    }
}
