package io.github.expo.modules.v2.types;

import io.github.expo.modules.v2.converters.BooleanArrayConverter;
import io.github.expo.modules.v2.converters.BooleanConverter;
import io.github.expo.modules.v2.converters.ByteArrayConverter;
import io.github.expo.modules.v2.converters.DoubleArrayConverter;
import io.github.expo.modules.v2.converters.DoubleConverter;
import io.github.expo.modules.v2.converters.FloatArrayConverter;
import io.github.expo.modules.v2.converters.FloatConverter;
import io.github.expo.modules.v2.converters.IntArrayConverter;
import io.github.expo.modules.v2.converters.IntConverter;
import io.github.expo.modules.v2.converters.LongArrayConverter;
import io.github.expo.modules.v2.converters.LongConverter;
import io.github.expo.modules.v2.converters.TypeConverter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypeDescriptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0010\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017J\b\u0010\u0006\u001a\u00020\u0007H&R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\u0018\u0019¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor;", "", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "getConverter", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "toString", "", "Primitive", "Int", "Bool", "Long", "Float", "Double", "ObjectLike", "PrimitiveArray", "BooleanArray", "IntArray", "LongArray", "FloatArray", "DoubleArray", "ByteArray", "Simple", "Parametrized", "Lio/github/expo/modules/v2/types/TypeDescriptor$ObjectLike;", "Lio/github/expo/modules/v2/types/TypeDescriptor$Primitive;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface TypeDescriptor {

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\u0003\u0002\u0003\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$ObjectLike;", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "Lio/github/expo/modules/v2/types/TypeDescriptor$Parametrized;", "Lio/github/expo/modules/v2/types/TypeDescriptor$PrimitiveArray;", "Lio/github/expo/modules/v2/types/TypeDescriptor$Simple;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ObjectLike extends TypeDescriptor {
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0005\u0006\u0007\b\t\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$Primitive;", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "cppType", "Lio/github/expo/modules/v2/types/CppType;", "getCppType-z4oZP-Q", "()I", "Lio/github/expo/modules/v2/types/TypeDescriptor$Bool;", "Lio/github/expo/modules/v2/types/TypeDescriptor$Double;", "Lio/github/expo/modules/v2/types/TypeDescriptor$Float;", "Lio/github/expo/modules/v2/types/TypeDescriptor$Int;", "Lio/github/expo/modules/v2/types/TypeDescriptor$Long;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Primitive extends TypeDescriptor {
        /* JADX INFO: renamed from: getCppType-z4oZP-Q */
        int mo12463getCppTypez4oZPQ();
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$PrimitiveArray;", "Lio/github/expo/modules/v2/types/TypeDescriptor$ObjectLike;", "cppType", "Lio/github/expo/modules/v2/types/CppType;", "getCppType-z4oZP-Q", "()I", "isNullable", "", "()Z", "Lio/github/expo/modules/v2/types/TypeDescriptor$BooleanArray;", "Lio/github/expo/modules/v2/types/TypeDescriptor$ByteArray;", "Lio/github/expo/modules/v2/types/TypeDescriptor$DoubleArray;", "Lio/github/expo/modules/v2/types/TypeDescriptor$FloatArray;", "Lio/github/expo/modules/v2/types/TypeDescriptor$IntArray;", "Lio/github/expo/modules/v2/types/TypeDescriptor$LongArray;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface PrimitiveArray extends ObjectLike {
        /* JADX INFO: renamed from: getCppType-z4oZP-Q */
        int mo12464getCppTypez4oZPQ();

        /* JADX INFO: renamed from: isNullable */
        boolean getIsNullable();
    }

    TypeConverter<?> getConverter();

    String toString();

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$Int;", "Lio/github/expo/modules/v2/types/TypeDescriptor$Primitive;", "<init>", "()V", "cppType", "Lio/github/expo/modules/v2/types/CppType;", "getCppType-z4oZP-Q", "()I", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "getConverter", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "toString", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Int implements Primitive {
        public static final Int INSTANCE = new Int();
        private static final TypeConverter<Integer> converter = new IntConverter();

        private Int() {
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.Primitive
        /* JADX INFO: renamed from: getCppType-z4oZP-Q */
        public int mo12463getCppTypez4oZPQ() {
            return CppType.INSTANCE.m12433getINTz4oZPQ();
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public TypeConverter<Integer> getConverter() {
            return converter;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public String toString() {
            return CppType.m12417toStringimpl(mo12463getCppTypez4oZPQ());
        }
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$Bool;", "Lio/github/expo/modules/v2/types/TypeDescriptor$Primitive;", "<init>", "()V", "cppType", "Lio/github/expo/modules/v2/types/CppType;", "getCppType-z4oZP-Q", "()I", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "getConverter", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "toString", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Bool implements Primitive {
        public static final Bool INSTANCE = new Bool();
        private static final TypeConverter<Boolean> converter = new BooleanConverter();

        private Bool() {
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.Primitive
        /* JADX INFO: renamed from: getCppType-z4oZP-Q, reason: not valid java name */
        public int mo12463getCppTypez4oZPQ() {
            return CppType.INSTANCE.m12421getBOOLEANz4oZPQ();
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public TypeConverter<Boolean> getConverter() {
            return converter;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public String toString() {
            return CppType.m12417toStringimpl(mo12463getCppTypez4oZPQ());
        }
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$Long;", "Lio/github/expo/modules/v2/types/TypeDescriptor$Primitive;", "<init>", "()V", "cppType", "Lio/github/expo/modules/v2/types/CppType;", "getCppType-z4oZP-Q", "()I", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "getConverter", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "toString", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Long implements Primitive {
        public static final Long INSTANCE = new Long();
        private static final TypeConverter<java.lang.Long> converter = new LongConverter();

        private Long() {
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.Primitive
        /* JADX INFO: renamed from: getCppType-z4oZP-Q */
        public int mo12463getCppTypez4oZPQ() {
            return CppType.INSTANCE.m12438getLONGz4oZPQ();
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public TypeConverter<java.lang.Long> getConverter() {
            return converter;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public String toString() {
            return CppType.m12417toStringimpl(mo12463getCppTypez4oZPQ());
        }
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$Float;", "Lio/github/expo/modules/v2/types/TypeDescriptor$Primitive;", "<init>", "()V", "cppType", "Lio/github/expo/modules/v2/types/CppType;", "getCppType-z4oZP-Q", "()I", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "getConverter", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "toString", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Float implements Primitive {
        public static final Float INSTANCE = new Float();
        private static final TypeConverter<java.lang.Float> converter = new FloatConverter();

        private Float() {
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.Primitive
        /* JADX INFO: renamed from: getCppType-z4oZP-Q */
        public int mo12463getCppTypez4oZPQ() {
            return CppType.INSTANCE.m12431getFLOATz4oZPQ();
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public TypeConverter<java.lang.Float> getConverter() {
            return converter;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public String toString() {
            return CppType.m12417toStringimpl(mo12463getCppTypez4oZPQ());
        }
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$Double;", "Lio/github/expo/modules/v2/types/TypeDescriptor$Primitive;", "<init>", "()V", "cppType", "Lio/github/expo/modules/v2/types/CppType;", "getCppType-z4oZP-Q", "()I", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "getConverter", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "toString", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Double implements Primitive {
        public static final Double INSTANCE = new Double();
        private static final TypeConverter<java.lang.Double> converter = new DoubleConverter();

        private Double() {
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.Primitive
        /* JADX INFO: renamed from: getCppType-z4oZP-Q */
        public int mo12463getCppTypez4oZPQ() {
            return CppType.INSTANCE.m12429getDOUBLEz4oZPQ();
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public TypeConverter<java.lang.Double> getConverter() {
            return converter;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public String toString() {
            return CppType.m12417toStringimpl(mo12463getCppTypez4oZPQ());
        }
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$BooleanArray;", "Lio/github/expo/modules/v2/types/TypeDescriptor$PrimitiveArray;", "isNullable", "", "<init>", "(Z)V", "()Z", "cppType", "Lio/github/expo/modules/v2/types/CppType;", "getCppType-z4oZP-Q", "()I", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "getConverter", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "toString", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class BooleanArray implements PrimitiveArray {
        private final TypeConverter<boolean[]> converter = new BooleanArrayConverter(getIsNullable());
        private final boolean isNullable;

        public BooleanArray(boolean z) {
            this.isNullable = z;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.PrimitiveArray
        /* JADX INFO: renamed from: isNullable, reason: from getter */
        public boolean getIsNullable() {
            return this.isNullable;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.PrimitiveArray
        /* JADX INFO: renamed from: getCppType-z4oZP-Q, reason: not valid java name */
        public int mo12464getCppTypez4oZPQ() {
            return CppType.INSTANCE.m12422getBOOLEAN_ARRAYz4oZPQ();
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public TypeConverter<boolean[]> getConverter() {
            return this.converter;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public String toString() {
            return TypeDescriptorKt.nullableSuffix(CppType.m12417toStringimpl(mo12464getCppTypez4oZPQ()), getIsNullable());
        }
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$IntArray;", "Lio/github/expo/modules/v2/types/TypeDescriptor$PrimitiveArray;", "isNullable", "", "<init>", "(Z)V", "()Z", "cppType", "Lio/github/expo/modules/v2/types/CppType;", "getCppType-z4oZP-Q", "()I", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "getConverter", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "toString", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class IntArray implements PrimitiveArray {
        private final TypeConverter<int[]> converter = new IntArrayConverter(getIsNullable());
        private final boolean isNullable;

        public IntArray(boolean z) {
            this.isNullable = z;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.PrimitiveArray
        /* JADX INFO: renamed from: isNullable, reason: from getter */
        public boolean getIsNullable() {
            return this.isNullable;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.PrimitiveArray
        /* JADX INFO: renamed from: getCppType-z4oZP-Q */
        public int mo12464getCppTypez4oZPQ() {
            return CppType.INSTANCE.m12434getINT_ARRAYz4oZPQ();
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public TypeConverter<int[]> getConverter() {
            return this.converter;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public String toString() {
            return TypeDescriptorKt.nullableSuffix(CppType.m12417toStringimpl(mo12464getCppTypez4oZPQ()), getIsNullable());
        }
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$LongArray;", "Lio/github/expo/modules/v2/types/TypeDescriptor$PrimitiveArray;", "isNullable", "", "<init>", "(Z)V", "()Z", "cppType", "Lio/github/expo/modules/v2/types/CppType;", "getCppType-z4oZP-Q", "()I", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "getConverter", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "toString", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class LongArray implements PrimitiveArray {
        private final TypeConverter<long[]> converter = new LongArrayConverter(getIsNullable());
        private final boolean isNullable;

        public LongArray(boolean z) {
            this.isNullable = z;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.PrimitiveArray
        /* JADX INFO: renamed from: isNullable, reason: from getter */
        public boolean getIsNullable() {
            return this.isNullable;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.PrimitiveArray
        /* JADX INFO: renamed from: getCppType-z4oZP-Q */
        public int mo12464getCppTypez4oZPQ() {
            return CppType.INSTANCE.m12439getLONG_ARRAYz4oZPQ();
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public TypeConverter<long[]> getConverter() {
            return this.converter;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public String toString() {
            return TypeDescriptorKt.nullableSuffix(CppType.m12417toStringimpl(mo12464getCppTypez4oZPQ()), getIsNullable());
        }
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$FloatArray;", "Lio/github/expo/modules/v2/types/TypeDescriptor$PrimitiveArray;", "isNullable", "", "<init>", "(Z)V", "()Z", "cppType", "Lio/github/expo/modules/v2/types/CppType;", "getCppType-z4oZP-Q", "()I", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "getConverter", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "toString", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class FloatArray implements PrimitiveArray {
        private final TypeConverter<float[]> converter = new FloatArrayConverter(getIsNullable());
        private final boolean isNullable;

        public FloatArray(boolean z) {
            this.isNullable = z;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.PrimitiveArray
        /* JADX INFO: renamed from: isNullable, reason: from getter */
        public boolean getIsNullable() {
            return this.isNullable;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.PrimitiveArray
        /* JADX INFO: renamed from: getCppType-z4oZP-Q */
        public int mo12464getCppTypez4oZPQ() {
            return CppType.INSTANCE.m12432getFLOAT_ARRAYz4oZPQ();
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public TypeConverter<float[]> getConverter() {
            return this.converter;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public String toString() {
            return TypeDescriptorKt.nullableSuffix(CppType.m12417toStringimpl(mo12464getCppTypez4oZPQ()), getIsNullable());
        }
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$DoubleArray;", "Lio/github/expo/modules/v2/types/TypeDescriptor$PrimitiveArray;", "isNullable", "", "<init>", "(Z)V", "()Z", "cppType", "Lio/github/expo/modules/v2/types/CppType;", "getCppType-z4oZP-Q", "()I", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "getConverter", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "toString", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class DoubleArray implements PrimitiveArray {
        private final TypeConverter<double[]> converter = new DoubleArrayConverter(getIsNullable());
        private final boolean isNullable;

        public DoubleArray(boolean z) {
            this.isNullable = z;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.PrimitiveArray
        /* JADX INFO: renamed from: isNullable, reason: from getter */
        public boolean getIsNullable() {
            return this.isNullable;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.PrimitiveArray
        /* JADX INFO: renamed from: getCppType-z4oZP-Q */
        public int mo12464getCppTypez4oZPQ() {
            return CppType.INSTANCE.m12430getDOUBLE_ARRAYz4oZPQ();
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public TypeConverter<double[]> getConverter() {
            return this.converter;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public String toString() {
            return TypeDescriptorKt.nullableSuffix(CppType.m12417toStringimpl(mo12464getCppTypez4oZPQ()), getIsNullable());
        }
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$ByteArray;", "Lio/github/expo/modules/v2/types/TypeDescriptor$PrimitiveArray;", "isNullable", "", "<init>", "(Z)V", "()Z", "cppType", "Lio/github/expo/modules/v2/types/CppType;", "getCppType-z4oZP-Q", "()I", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "getConverter", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "toString", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ByteArray implements PrimitiveArray {
        private final TypeConverter<byte[]> converter = new ByteArrayConverter(getIsNullable());
        private final boolean isNullable;

        public ByteArray(boolean z) {
            this.isNullable = z;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.PrimitiveArray
        /* JADX INFO: renamed from: isNullable, reason: from getter */
        public boolean getIsNullable() {
            return this.isNullable;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor.PrimitiveArray
        /* JADX INFO: renamed from: getCppType-z4oZP-Q */
        public int mo12464getCppTypez4oZPQ() {
            return CppType.INSTANCE.m12428getBYTE_ARRAYz4oZPQ();
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public TypeConverter<byte[]> getConverter() {
            return this.converter;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public String toString() {
            return TypeDescriptorKt.nullableSuffix(CppType.m12417toStringimpl(mo12464getCppTypez4oZPQ()), getIsNullable());
        }
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\r\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0086\u0002J\t\u0010\u0014\u001a\u00020\u0005H\u0086\u0002R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u001f\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$Simple;", "Lio/github/expo/modules/v2/types/TypeDescriptor$ObjectLike;", "javaClass", "Ljava/lang/Class;", "isNullable", "", "<init>", "(Ljava/lang/Class;Z)V", "getJavaClass", "()Ljava/lang/Class;", "()Z", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "getConverter", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "converter$delegate", "Lkotlin/Lazy;", "toString", "", "component1", "component2", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Simple implements ObjectLike {

        /* JADX INFO: renamed from: converter$delegate, reason: from kotlin metadata */
        private final Lazy converter;
        private final boolean isNullable;
        private final Class<?> javaClass;

        public Simple(Class<?> javaClass, boolean z) {
            Intrinsics.checkNotNullParameter(javaClass, "javaClass");
            this.javaClass = javaClass;
            this.isNullable = z;
            this.converter = LazyKt.lazy(new Function0() { // from class: io.github.expo.modules.v2.types.TypeDescriptor$Simple$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TypeConverterRegistry.INSTANCE.converter(this.f$0);
                }
            });
        }

        public final Class<?> getJavaClass() {
            return this.javaClass;
        }

        public final boolean isNullable() {
            return this.isNullable;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public TypeConverter<?> getConverter() {
            return (TypeConverter) this.converter.getValue();
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public String toString() {
            String simpleName = this.javaClass.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            return TypeDescriptorKt.nullableSuffix(simpleName, this.isNullable);
        }

        public final Class<?> component1() {
            return this.javaClass;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsNullable() {
            return this.isNullable;
        }
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\r\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0086\u0002J\t\u0010\u0019\u001a\u00020\u0005H\u0086\u0002J\u0016\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007H\u0086\u0002¢\u0006\u0002\u0010\u000eR\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u001b\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lio/github/expo/modules/v2/types/TypeDescriptor$Parametrized;", "Lio/github/expo/modules/v2/types/TypeDescriptor$ObjectLike;", "javaClass", "Ljava/lang/Class;", "isNullable", "", "params", "", "<init>", "(Ljava/lang/Class;Z[Lio/github/expo/modules/v2/types/TypeDescriptor$ObjectLike;)V", "getJavaClass", "()Ljava/lang/Class;", "()Z", "getParams", "()[Lio/github/expo/modules/v2/types/TypeDescriptor$ObjectLike;", "[Lio/github/expo/modules/v2/types/TypeDescriptor$ObjectLike;", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "getConverter", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "converter$delegate", "Lkotlin/Lazy;", "toString", "", "component1", "component2", "component3", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Parametrized implements ObjectLike {

        /* JADX INFO: renamed from: converter$delegate, reason: from kotlin metadata */
        private final Lazy converter;
        private final boolean isNullable;
        private final Class<?> javaClass;
        private final ObjectLike[] params;

        public Parametrized(Class<?> javaClass, boolean z, ObjectLike[] params) {
            Intrinsics.checkNotNullParameter(javaClass, "javaClass");
            Intrinsics.checkNotNullParameter(params, "params");
            this.javaClass = javaClass;
            this.isNullable = z;
            this.params = params;
            this.converter = LazyKt.lazy(new Function0() { // from class: io.github.expo.modules.v2.types.TypeDescriptor$Parametrized$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TypeConverterRegistry.INSTANCE.converter(this.f$0);
                }
            });
        }

        public final Class<?> getJavaClass() {
            return this.javaClass;
        }

        public final boolean isNullable() {
            return this.isNullable;
        }

        public final ObjectLike[] getParams() {
            return this.params;
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public TypeConverter<?> getConverter() {
            return (TypeConverter) this.converter.getValue();
        }

        @Override // io.github.expo.modules.v2.types.TypeDescriptor
        public String toString() {
            return this.javaClass.getSimpleName() + TypeDescriptorKt.nullableSuffix(ArraysKt.joinToString$default(this.params, ", ", "<", ">", 0, (CharSequence) null, (Function1) null, 56, (Object) null), this.isNullable);
        }

        public final Class<?> component1() {
            return this.javaClass;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsNullable() {
            return this.isNullable;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ObjectLike[] getParams() {
            return this.params;
        }
    }
}
