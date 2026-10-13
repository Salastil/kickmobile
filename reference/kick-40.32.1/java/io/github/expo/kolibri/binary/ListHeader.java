package io.github.expo.kolibri.binary;

import kotlin.Metadata;

/* JADX INFO: compiled from: BinaryBuffer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lio/github/expo/kolibri/binary/ListHeader;", "", "count", "", "elementTag", "<init>", "(II)V", "getCount", "()I", "getElementTag", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ListHeader {
    private final int count;
    private final int elementTag;

    public static /* synthetic */ ListHeader copy$default(ListHeader listHeader, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = listHeader.count;
        }
        if ((i3 & 2) != 0) {
            i2 = listHeader.elementTag;
        }
        return listHeader.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getElementTag() {
        return this.elementTag;
    }

    public final ListHeader copy(int count, int elementTag) {
        return new ListHeader(count, elementTag);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListHeader)) {
            return false;
        }
        ListHeader listHeader = (ListHeader) other;
        return this.count == listHeader.count && this.elementTag == listHeader.elementTag;
    }

    public int hashCode() {
        return (Integer.hashCode(this.count) * 31) + Integer.hashCode(this.elementTag);
    }

    public String toString() {
        return "ListHeader(count=" + this.count + ", elementTag=" + this.elementTag + ")";
    }

    public ListHeader(int i, int i2) {
        this.count = i;
        this.elementTag = i2;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getElementTag() {
        return this.elementTag;
    }
}
