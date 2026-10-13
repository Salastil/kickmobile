package io.github.expo.modules.v2.records;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecordSchemaData.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lio/github/expo/modules/v2/records/RecordSchemaData;", "", "name", "", "jniDescriptor", "bufferSafe", "", "fieldNames", "", "fieldTypes", "", "fieldOptional", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z[Ljava/lang/String;[I[Z)V", "[Ljava/lang/String;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecordSchemaData {
    public final boolean bufferSafe;
    public final String[] fieldNames;
    public final boolean[] fieldOptional;
    public final int[] fieldTypes;
    public final String jniDescriptor;
    public final String name;

    public RecordSchemaData(String name, String jniDescriptor, boolean z, String[] fieldNames, int[] fieldTypes, boolean[] fieldOptional) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(jniDescriptor, "jniDescriptor");
        Intrinsics.checkNotNullParameter(fieldNames, "fieldNames");
        Intrinsics.checkNotNullParameter(fieldTypes, "fieldTypes");
        Intrinsics.checkNotNullParameter(fieldOptional, "fieldOptional");
        this.name = name;
        this.jniDescriptor = jniDescriptor;
        this.bufferSafe = z;
        this.fieldNames = fieldNames;
        this.fieldTypes = fieldTypes;
        this.fieldOptional = fieldOptional;
    }
}
