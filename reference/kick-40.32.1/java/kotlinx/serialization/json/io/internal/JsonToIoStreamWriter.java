package kotlinx.serialization.json.io.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Sink;
import kotlinx.io.Utf8Kt;
import kotlinx.serialization.json.internal.InternalJsonWriter;
import kotlinx.serialization.json.internal.StringOpsKt;

/* JADX INFO: compiled from: IoJsonStreams.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/serialization/json/io/internal/JsonToIoStreamWriter;", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "sink", "Lkotlinx/io/Sink;", "<init>", "(Lkotlinx/io/Sink;)V", "writeLong", "", "value", "", "writeChar", "char", "", "write", "text", "", "writeQuoted", "release", "kotlinx-serialization-json-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JsonToIoStreamWriter implements InternalJsonWriter {
    private final Sink sink;

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void release() {
    }

    public JsonToIoStreamWriter(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeLong(long value) {
        write(String.valueOf(value));
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeChar(char c) {
        Utf8Kt.writeCodePointValue(this.sink, c);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void write(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Utf8Kt.writeString$default(this.sink, text, 0, 0, 6, (Object) null);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeQuoted(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Utf8Kt.writeCodePointValue(this.sink, 34);
        InternalJsonWriter.Companion companion = InternalJsonWriter.INSTANCE;
        int length = text.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = text.charAt(i2);
            if (cCharAt < StringOpsKt.getESCAPE_STRINGS().length && StringOpsKt.getESCAPE_STRINGS()[cCharAt] != null) {
                Utf8Kt.writeString(this.sink, text, i, i2);
                String str = StringOpsKt.getESCAPE_STRINGS()[cCharAt];
                Intrinsics.checkNotNull(str);
                Utf8Kt.writeString(this.sink, str, 0, str.length());
                i = i2 + 1;
            }
        }
        Utf8Kt.writeString(this.sink, text, i, text.length());
        Utf8Kt.writeCodePointValue(this.sink, 34);
    }
}
