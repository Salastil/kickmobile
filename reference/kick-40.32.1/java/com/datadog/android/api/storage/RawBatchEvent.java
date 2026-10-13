package com.datadog.android.api.storage;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RawBatchEvent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/api/storage/RawBatchEvent;", "", "data", "", "metadata", "([B[B)V", "getData", "()[B", "getMetadata", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RawBatchEvent {
    private static final Companion Companion = new Companion(null);
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private final byte[] data;
    private final byte[] metadata;

    public static /* synthetic */ RawBatchEvent copy$default(RawBatchEvent rawBatchEvent, byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = rawBatchEvent.data;
        }
        if ((i & 2) != 0) {
            bArr2 = rawBatchEvent.metadata;
        }
        return rawBatchEvent.copy(bArr, bArr2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final byte[] getMetadata() {
        return this.metadata;
    }

    public final RawBatchEvent copy(byte[] data, byte[] metadata) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return new RawBatchEvent(data, metadata);
    }

    public String toString() {
        return "RawBatchEvent(data=" + Arrays.toString(this.data) + ", metadata=" + Arrays.toString(this.metadata) + ")";
    }

    public RawBatchEvent(byte[] data, byte[] metadata) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.data = data;
        this.metadata = metadata;
    }

    public final byte[] getData() {
        return this.data;
    }

    public /* synthetic */ RawBatchEvent(byte[] bArr, byte[] bArr2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i & 2) != 0 ? EMPTY_BYTE_ARRAY : bArr2);
    }

    public final byte[] getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.datadog.android.api.storage.RawBatchEvent");
        RawBatchEvent rawBatchEvent = (RawBatchEvent) other;
        return Arrays.equals(this.data, rawBatchEvent.data) && Arrays.equals(this.metadata, rawBatchEvent.metadata);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.data) * 31) + Arrays.hashCode(this.metadata);
    }

    /* JADX INFO: compiled from: RawBatchEvent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/api/storage/RawBatchEvent$Companion;", "", "()V", "EMPTY_BYTE_ARRAY", "", "getEMPTY_BYTE_ARRAY", "()[B", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final byte[] getEMPTY_BYTE_ARRAY() {
            return RawBatchEvent.EMPTY_BYTE_ARRAY;
        }
    }
}
