package com.datadog.android.core.internal.persistence;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Batch.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/core/internal/persistence/Batch;", "", "id", "", "data", "", "(Ljava/lang/String;[B)V", "getData", "()[B", "getId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Batch {
    private final byte[] data;
    private final String id;

    public static /* synthetic */ Batch copy$default(Batch batch, String str, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = batch.id;
        }
        if ((i & 2) != 0) {
            bArr = batch.data;
        }
        return batch.copy(str, bArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    public final Batch copy(String id, byte[] data) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(data, "data");
        return new Batch(id, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Batch)) {
            return false;
        }
        Batch batch = (Batch) other;
        return Intrinsics.areEqual(this.id, batch.id) && Intrinsics.areEqual(this.data, batch.data);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + Arrays.hashCode(this.data);
    }

    public String toString() {
        return "Batch(id=" + this.id + ", data=" + Arrays.toString(this.data) + ")";
    }

    public Batch(String id, byte[] data) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(data, "data");
        this.id = id;
        this.data = data;
    }

    public final String getId() {
        return this.id;
    }

    public final byte[] getData() {
        return this.data;
    }
}
