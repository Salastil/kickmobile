package com.datadog.android.core.internal.persistence.tlvformat;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TLVBlockType.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlockType;", "", "rawValue", "Lkotlin/UShort;", "(Ljava/lang/String;IS)V", "getRawValue-Mh2AYeg", "()S", ExifInterface.LATITUDE_SOUTH, "VERSION_CODE", "DATA", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum TLVBlockType {
    VERSION_CODE(0),
    DATA(1);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<UShort, TLVBlockType> map;
    private final short rawValue;

    TLVBlockType(short s) {
        this.rawValue = s;
    }

    /* JADX INFO: renamed from: getRawValue-Mh2AYeg, reason: not valid java name and from getter */
    public final short getRawValue() {
        return this.rawValue;
    }

    static {
        TLVBlockType[] tLVBlockTypeArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(tLVBlockTypeArrValues.length), 16));
        for (TLVBlockType tLVBlockType : tLVBlockTypeArrValues) {
            linkedHashMap.put(UShort.m12968boximpl(tLVBlockType.rawValue), tLVBlockType);
        }
        map = linkedHashMap;
    }

    /* JADX INFO: compiled from: TLVBlockType.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlockType$Companion;", "", "()V", "map", "", "Lkotlin/UShort;", "Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlockType;", "fromValue", "value", "fromValue-xj2QHRw", "(S)Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlockType;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: fromValue-xj2QHRw, reason: not valid java name */
        public final TLVBlockType m11147fromValuexj2QHRw(short value) {
            return (TLVBlockType) TLVBlockType.map.get(UShort.m12968boximpl(value));
        }
    }
}
