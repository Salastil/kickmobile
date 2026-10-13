package io.github.expo.modules.v2.records;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecordSchema.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/github/expo/modules/v2/records/RecordSchema;", "", "name", "", "bufferSafe", "", "fields", "", "Lio/github/expo/modules/v2/records/RecordField;", "<init>", "(Ljava/lang/String;Z[Lio/github/expo/modules/v2/records/RecordField;)V", "getName", "()Ljava/lang/String;", "getBufferSafe", "()Z", "", "getFields", "()Ljava/util/List;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecordSchema {
    private final boolean bufferSafe;
    private final List<RecordField> fields;
    private final String name;

    public RecordSchema(String name, boolean z, RecordField... fields) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fields, "fields");
        this.name = name;
        this.bufferSafe = z;
        this.fields = ArraysKt.toList(fields);
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getBufferSafe() {
        return this.bufferSafe;
    }

    public final List<RecordField> getFields() {
        return this.fields;
    }
}
