package io.github.expo.modules.v2.records;

import io.github.expo.modules.v2.types.TypeDescriptor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecordSchema.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0018"}, d2 = {"Lio/github/expo/modules/v2/records/RecordField;", "", "name", "", "type", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "isOptional", "", "<init>", "(Ljava/lang/String;Lio/github/expo/modules/v2/types/TypeDescriptor;Z)V", "getName", "()Ljava/lang/String;", "getType", "()Lio/github/expo/modules/v2/types/TypeDescriptor;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RecordField {
    private final boolean isOptional;
    private final String name;
    private final TypeDescriptor type;

    public static /* synthetic */ RecordField copy$default(RecordField recordField, String str, TypeDescriptor typeDescriptor, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recordField.name;
        }
        if ((i & 2) != 0) {
            typeDescriptor = recordField.type;
        }
        if ((i & 4) != 0) {
            z = recordField.isOptional;
        }
        return recordField.copy(str, typeDescriptor, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TypeDescriptor getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsOptional() {
        return this.isOptional;
    }

    public final RecordField copy(String name, TypeDescriptor type, boolean isOptional) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        return new RecordField(name, type, isOptional);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecordField)) {
            return false;
        }
        RecordField recordField = (RecordField) other;
        return Intrinsics.areEqual(this.name, recordField.name) && Intrinsics.areEqual(this.type, recordField.type) && this.isOptional == recordField.isOptional;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.isOptional);
    }

    public String toString() {
        return "RecordField(name=" + this.name + ", type=" + this.type + ", isOptional=" + this.isOptional + ")";
    }

    public RecordField(String name, TypeDescriptor type, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.name = name;
        this.type = type;
        this.isOptional = z;
    }

    public /* synthetic */ RecordField(String str, TypeDescriptor typeDescriptor, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, typeDescriptor, (i & 4) != 0 ? false : z);
    }

    public final String getName() {
        return this.name;
    }

    public final TypeDescriptor getType() {
        return this.type;
    }

    public final boolean isOptional() {
        return this.isOptional;
    }
}
