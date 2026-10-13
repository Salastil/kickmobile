package expo.modules.kotlin.types;

import android.net.Uri;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.JavaScriptValue;
import expo.modules.kotlin.typedarray.BigInt64Array;
import expo.modules.kotlin.typedarray.BigUint64Array;
import expo.modules.kotlin.typedarray.Float32Array;
import expo.modules.kotlin.typedarray.Float64Array;
import expo.modules.kotlin.typedarray.Int16Array;
import expo.modules.kotlin.typedarray.Int32Array;
import expo.modules.kotlin.typedarray.Int8Array;
import expo.modules.kotlin.typedarray.TypedArray;
import expo.modules.kotlin.typedarray.Uint16Array;
import expo.modules.kotlin.typedarray.Uint32Array;
import expo.modules.kotlin.typedarray.Uint8Array;
import expo.modules.kotlin.typedarray.Uint8ClampedArray;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: AnyTypeCache.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R<\u0010\u0004\u001a\"\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0004\u0012\u00020\t0\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lexpo/modules/kotlin/types/AnyTypeCache;", "", "<init>", "()V", "typesMap", "", "Lkotlin/Pair;", "Lkotlin/reflect/KClass;", "", "Lexpo/modules/kotlin/types/AnyType;", "getTypesMap$annotations", "getTypesMap", "()Ljava/util/Map;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AnyTypeCache {
    public static final int $stable;
    public static final AnyTypeCache INSTANCE = new AnyTypeCache();
    private static final Map<Pair<KClass<? extends Object>, Boolean>, AnyType> typesMap;

    public static /* synthetic */ void getTypesMap$annotations() {
    }

    private AnyTypeCache() {
    }

    public final Map<Pair<KClass<? extends Object>, Boolean>, AnyType> getTypesMap() {
        return typesMap;
    }

    static {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        Object objM12684constructorimpl8;
        Object objM12684constructorimpl9;
        Object objM12684constructorimpl10;
        Object objM12684constructorimpl11;
        int i;
        Object objM12684constructorimpl12;
        Object objM12684constructorimpl13;
        Object objM12684constructorimpl14;
        Object objM12684constructorimpl15;
        Object objM12684constructorimpl16;
        Object objM12684constructorimpl17;
        Object objM12684constructorimpl18;
        Object objM12684constructorimpl19;
        Object objM12684constructorimpl20;
        Object objM12684constructorimpl21;
        Object objM12684constructorimpl22;
        Object objM12684constructorimpl23;
        Object objM12684constructorimpl24;
        Object objM12684constructorimpl25;
        Object objM12684constructorimpl26;
        Object objM12684constructorimpl27;
        Object objM12684constructorimpl28;
        Object objM12684constructorimpl29;
        Object objM12684constructorimpl30;
        Object objM12684constructorimpl31;
        Object objM12684constructorimpl32;
        Object objM12684constructorimpl33;
        Object objM12684constructorimpl34;
        Object objM12684constructorimpl35;
        Object objM12684constructorimpl36;
        Object objM12684constructorimpl37;
        Object objM12684constructorimpl38;
        Object objM12684constructorimpl39;
        Object objM12684constructorimpl40;
        Object objM12684constructorimpl41;
        Object objM12684constructorimpl42;
        Object objM12684constructorimpl43;
        Object objM12684constructorimpl44;
        Object objM12684constructorimpl45;
        Object objM12684constructorimpl46;
        Object objM12684constructorimpl47;
        Object objM12684constructorimpl48;
        Object objM12684constructorimpl49;
        Object objM12684constructorimpl50;
        Object objM12684constructorimpl51;
        Object objM12684constructorimpl52;
        Object objM12684constructorimpl53;
        Object objM12684constructorimpl54;
        Object objM12684constructorimpl55;
        Object objM12684constructorimpl56;
        Object objM12684constructorimpl57;
        Object objM12684constructorimpl58;
        Object objM12684constructorimpl59;
        Object objM12684constructorimpl60;
        Object objM12684constructorimpl61;
        Object objM12684constructorimpl62;
        Object objM12684constructorimpl63;
        Object objM12684constructorimpl64;
        Object objM12684constructorimpl65;
        Object objM12684constructorimpl66;
        Object objM12684constructorimpl67;
        Object objM12684constructorimpl68;
        Object objM12684constructorimpl69;
        Object objM12684constructorimpl70;
        Pair[] pairArr = new Pair[70];
        Pair pair = TuplesKt.to(Reflection.getOrCreateKotlinClass(Integer.TYPE), false);
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
        }
        pairArr[0] = TuplesKt.to(pair, new AnyType(typeDescriptor, null, 2, null));
        Pair pair2 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Float.TYPE), false);
        try {
            Result.Companion companion3 = Result.INSTANCE;
            objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.FLOAT), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Float.TYPE);
                }
            }));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
            objM12684constructorimpl2 = null;
        }
        TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
        if (typeDescriptor2 == null) {
            typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Float.TYPE));
        }
        pairArr[1] = TuplesKt.to(pair2, new AnyType(typeDescriptor2, null, 2, null));
        Pair pair3 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Double.TYPE), false);
        try {
            Result.Companion companion5 = Result.INSTANCE;
            objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.DOUBLE), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Double.TYPE);
                }
            }));
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.INSTANCE;
            objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
            objM12684constructorimpl3 = null;
        }
        TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
        if (typeDescriptor3 == null) {
            typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Double.TYPE));
        }
        pairArr[2] = TuplesKt.to(pair3, new AnyType(typeDescriptor3, null, 2, null));
        Pair pair4 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Long.TYPE), false);
        try {
            Result.Companion companion7 = Result.INSTANCE;
            objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.LONG), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Long.TYPE);
                }
            }));
        } catch (Throwable th4) {
            Result.Companion companion8 = Result.INSTANCE;
            objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
            objM12684constructorimpl4 = null;
        }
        TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
        if (typeDescriptor4 == null) {
            typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Long.TYPE));
        }
        pairArr[3] = TuplesKt.to(pair4, new AnyType(typeDescriptor4, null, 2, null));
        Pair pair5 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Boolean.TYPE), false);
        try {
            Result.Companion companion9 = Result.INSTANCE;
            objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            }));
        } catch (Throwable th5) {
            Result.Companion companion10 = Result.INSTANCE;
            objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
            objM12684constructorimpl5 = null;
        }
        TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
        if (typeDescriptor5 == null) {
            typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Boolean.TYPE));
        }
        pairArr[4] = TuplesKt.to(pair5, new AnyType(typeDescriptor5, null, 2, null));
        Pair pair6 = TuplesKt.to(Reflection.getOrCreateKotlinClass(String.class), false);
        try {
            Result.Companion companion11 = Result.INSTANCE;
            objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }));
        } catch (Throwable th6) {
            Result.Companion companion12 = Result.INSTANCE;
            objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
            objM12684constructorimpl6 = null;
        }
        TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
        if (typeDescriptor6 == null) {
            typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
        }
        pairArr[5] = TuplesKt.to(pair6, new AnyType(typeDescriptor6, null, 2, null));
        Pair pair7 = TuplesKt.to(Reflection.getOrCreateKotlinClass(byte[].class), false);
        try {
            Result.Companion companion13 = Result.INSTANCE;
            objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(byte[].class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(byte[].class);
                }
            }));
        } catch (Throwable th7) {
            Result.Companion companion14 = Result.INSTANCE;
            objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl7)) {
            objM12684constructorimpl7 = null;
        }
        TypeDescriptor typeDescriptor7 = (TypeDescriptor) objM12684constructorimpl7;
        if (typeDescriptor7 == null) {
            typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(byte[].class));
        }
        pairArr[6] = TuplesKt.to(pair7, new AnyType(typeDescriptor7, null, 2, null));
        Pair pair8 = TuplesKt.to(Reflection.getOrCreateKotlinClass(long[].class), false);
        try {
            Result.Companion companion15 = Result.INSTANCE;
            objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(long[].class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(long[].class);
                }
            }));
        } catch (Throwable th8) {
            Result.Companion companion16 = Result.INSTANCE;
            objM12684constructorimpl8 = Result.m12684constructorimpl(ResultKt.createFailure(th8));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl8)) {
            objM12684constructorimpl8 = null;
        }
        TypeDescriptor typeDescriptor8 = (TypeDescriptor) objM12684constructorimpl8;
        if (typeDescriptor8 == null) {
            typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(long[].class));
        }
        pairArr[7] = TuplesKt.to(pair8, new AnyType(typeDescriptor8, null, 2, null));
        Pair pair9 = TuplesKt.to(Reflection.getOrCreateKotlinClass(int[].class), false);
        try {
            Result.Companion companion17 = Result.INSTANCE;
            objM12684constructorimpl9 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(int[].class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(int[].class);
                }
            }));
        } catch (Throwable th9) {
            Result.Companion companion18 = Result.INSTANCE;
            objM12684constructorimpl9 = Result.m12684constructorimpl(ResultKt.createFailure(th9));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl9)) {
            objM12684constructorimpl9 = null;
        }
        TypeDescriptor typeDescriptor9 = (TypeDescriptor) objM12684constructorimpl9;
        if (typeDescriptor9 == null) {
            typeDescriptor9 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(int[].class));
        }
        pairArr[8] = TuplesKt.to(pair9, new AnyType(typeDescriptor9, null, 2, null));
        Pair pair10 = TuplesKt.to(Reflection.getOrCreateKotlinClass(boolean[].class), false);
        try {
            Result.Companion companion19 = Result.INSTANCE;
            objM12684constructorimpl10 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(boolean[].class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(boolean[].class);
                }
            }));
        } catch (Throwable th10) {
            Result.Companion companion20 = Result.INSTANCE;
            objM12684constructorimpl10 = Result.m12684constructorimpl(ResultKt.createFailure(th10));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl10)) {
            objM12684constructorimpl10 = null;
        }
        TypeDescriptor typeDescriptor10 = (TypeDescriptor) objM12684constructorimpl10;
        if (typeDescriptor10 == null) {
            typeDescriptor10 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(boolean[].class));
        }
        pairArr[9] = TuplesKt.to(pair10, new AnyType(typeDescriptor10, null, 2, null));
        Pair pair11 = TuplesKt.to(Reflection.getOrCreateKotlinClass(float[].class), false);
        try {
            Result.Companion companion21 = Result.INSTANCE;
            objM12684constructorimpl11 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(float[].class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(float[].class);
                }
            }));
        } catch (Throwable th11) {
            Result.Companion companion22 = Result.INSTANCE;
            objM12684constructorimpl11 = Result.m12684constructorimpl(ResultKt.createFailure(th11));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl11)) {
            objM12684constructorimpl11 = null;
        }
        TypeDescriptor typeDescriptor11 = (TypeDescriptor) objM12684constructorimpl11;
        if (typeDescriptor11 == null) {
            typeDescriptor11 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(float[].class));
        }
        pairArr[10] = TuplesKt.to(pair11, new AnyType(typeDescriptor11, null, 2, null));
        Pair pair12 = TuplesKt.to(Reflection.getOrCreateKotlinClass(double[].class), false);
        try {
            Result.Companion companion23 = Result.INSTANCE;
            i = 8;
            try {
                objM12684constructorimpl12 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(double[].class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$12
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(double[].class);
                    }
                }));
            } catch (Throwable th12) {
                th = th12;
                Result.Companion companion24 = Result.INSTANCE;
                objM12684constructorimpl12 = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
        } catch (Throwable th13) {
            th = th13;
            i = 8;
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl12)) {
            objM12684constructorimpl12 = null;
        }
        TypeDescriptor typeDescriptor12 = (TypeDescriptor) objM12684constructorimpl12;
        if (typeDescriptor12 == null) {
            typeDescriptor12 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(double[].class));
        }
        pairArr[11] = TuplesKt.to(pair12, new AnyType(typeDescriptor12, null, 2, null));
        Pair pair13 = TuplesKt.to(Reflection.getOrCreateKotlinClass(JavaScriptValue.class), false);
        try {
            Result.Companion companion25 = Result.INSTANCE;
            objM12684constructorimpl13 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(JavaScriptValue.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(JavaScriptValue.class);
                }
            }));
        } catch (Throwable th14) {
            Result.Companion companion26 = Result.INSTANCE;
            objM12684constructorimpl13 = Result.m12684constructorimpl(ResultKt.createFailure(th14));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl13)) {
            objM12684constructorimpl13 = null;
        }
        TypeDescriptor typeDescriptor13 = (TypeDescriptor) objM12684constructorimpl13;
        if (typeDescriptor13 == null) {
            typeDescriptor13 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(JavaScriptValue.class));
        }
        pairArr[12] = TuplesKt.to(pair13, new AnyType(typeDescriptor13, null, 2, null));
        Pair pair14 = TuplesKt.to(Reflection.getOrCreateKotlinClass(JavaScriptObject.class), false);
        try {
            Result.Companion companion27 = Result.INSTANCE;
            objM12684constructorimpl14 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(JavaScriptObject.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(JavaScriptObject.class);
                }
            }));
        } catch (Throwable th15) {
            Result.Companion companion28 = Result.INSTANCE;
            objM12684constructorimpl14 = Result.m12684constructorimpl(ResultKt.createFailure(th15));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl14)) {
            objM12684constructorimpl14 = null;
        }
        TypeDescriptor typeDescriptor14 = (TypeDescriptor) objM12684constructorimpl14;
        if (typeDescriptor14 == null) {
            typeDescriptor14 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(JavaScriptObject.class));
        }
        pairArr[13] = TuplesKt.to(pair14, new AnyType(typeDescriptor14, null, 2, null));
        Pair pair15 = TuplesKt.to(Reflection.getOrCreateKotlinClass(TypedArray.class), false);
        try {
            Result.Companion companion29 = Result.INSTANCE;
            objM12684constructorimpl15 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(TypedArray.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(TypedArray.class);
                }
            }));
        } catch (Throwable th16) {
            Result.Companion companion30 = Result.INSTANCE;
            objM12684constructorimpl15 = Result.m12684constructorimpl(ResultKt.createFailure(th16));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl15)) {
            objM12684constructorimpl15 = null;
        }
        TypeDescriptor typeDescriptor15 = (TypeDescriptor) objM12684constructorimpl15;
        if (typeDescriptor15 == null) {
            typeDescriptor15 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(TypedArray.class));
        }
        pairArr[14] = TuplesKt.to(pair15, new AnyType(typeDescriptor15, null, 2, null));
        Pair pair16 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Int8Array.class), false);
        try {
            Result.Companion companion31 = Result.INSTANCE;
            objM12684constructorimpl16 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Int8Array.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Int8Array.class);
                }
            }));
        } catch (Throwable th17) {
            Result.Companion companion32 = Result.INSTANCE;
            objM12684constructorimpl16 = Result.m12684constructorimpl(ResultKt.createFailure(th17));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl16)) {
            objM12684constructorimpl16 = null;
        }
        TypeDescriptor typeDescriptor16 = (TypeDescriptor) objM12684constructorimpl16;
        if (typeDescriptor16 == null) {
            typeDescriptor16 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Int8Array.class));
        }
        pairArr[15] = TuplesKt.to(pair16, new AnyType(typeDescriptor16, null, 2, null));
        Pair pair17 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Int16Array.class), false);
        try {
            Result.Companion companion33 = Result.INSTANCE;
            objM12684constructorimpl17 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Int16Array.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Int16Array.class);
                }
            }));
        } catch (Throwable th18) {
            Result.Companion companion34 = Result.INSTANCE;
            objM12684constructorimpl17 = Result.m12684constructorimpl(ResultKt.createFailure(th18));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl17)) {
            objM12684constructorimpl17 = null;
        }
        TypeDescriptor typeDescriptor17 = (TypeDescriptor) objM12684constructorimpl17;
        if (typeDescriptor17 == null) {
            typeDescriptor17 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Int16Array.class));
        }
        pairArr[16] = TuplesKt.to(pair17, new AnyType(typeDescriptor17, null, 2, null));
        Pair pair18 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Int32Array.class), false);
        try {
            Result.Companion companion35 = Result.INSTANCE;
            objM12684constructorimpl18 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Int32Array.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Int32Array.class);
                }
            }));
        } catch (Throwable th19) {
            Result.Companion companion36 = Result.INSTANCE;
            objM12684constructorimpl18 = Result.m12684constructorimpl(ResultKt.createFailure(th19));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl18)) {
            objM12684constructorimpl18 = null;
        }
        TypeDescriptor typeDescriptor18 = (TypeDescriptor) objM12684constructorimpl18;
        if (typeDescriptor18 == null) {
            typeDescriptor18 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Int32Array.class));
        }
        pairArr[17] = TuplesKt.to(pair18, new AnyType(typeDescriptor18, null, 2, null));
        Pair pair19 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint8Array.class), false);
        try {
            Result.Companion companion37 = Result.INSTANCE;
            objM12684constructorimpl19 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uint8Array.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Uint8Array.class);
                }
            }));
        } catch (Throwable th20) {
            Result.Companion companion38 = Result.INSTANCE;
            objM12684constructorimpl19 = Result.m12684constructorimpl(ResultKt.createFailure(th20));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl19)) {
            objM12684constructorimpl19 = null;
        }
        TypeDescriptor typeDescriptor19 = (TypeDescriptor) objM12684constructorimpl19;
        if (typeDescriptor19 == null) {
            typeDescriptor19 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Uint8Array.class));
        }
        pairArr[18] = TuplesKt.to(pair19, new AnyType(typeDescriptor19, null, 2, null));
        Pair pair20 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint8ClampedArray.class), false);
        try {
            Result.Companion companion39 = Result.INSTANCE;
            objM12684constructorimpl20 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uint8ClampedArray.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Uint8ClampedArray.class);
                }
            }));
        } catch (Throwable th21) {
            Result.Companion companion40 = Result.INSTANCE;
            objM12684constructorimpl20 = Result.m12684constructorimpl(ResultKt.createFailure(th21));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl20)) {
            objM12684constructorimpl20 = null;
        }
        TypeDescriptor typeDescriptor20 = (TypeDescriptor) objM12684constructorimpl20;
        if (typeDescriptor20 == null) {
            typeDescriptor20 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Uint8ClampedArray.class));
        }
        pairArr[19] = TuplesKt.to(pair20, new AnyType(typeDescriptor20, null, 2, null));
        Pair pair21 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint16Array.class), false);
        try {
            Result.Companion companion41 = Result.INSTANCE;
            objM12684constructorimpl21 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uint16Array.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Uint16Array.class);
                }
            }));
        } catch (Throwable th22) {
            Result.Companion companion42 = Result.INSTANCE;
            objM12684constructorimpl21 = Result.m12684constructorimpl(ResultKt.createFailure(th22));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl21)) {
            objM12684constructorimpl21 = null;
        }
        TypeDescriptor typeDescriptor21 = (TypeDescriptor) objM12684constructorimpl21;
        if (typeDescriptor21 == null) {
            typeDescriptor21 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Uint16Array.class));
        }
        pairArr[20] = TuplesKt.to(pair21, new AnyType(typeDescriptor21, null, 2, null));
        Pair pair22 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint32Array.class), false);
        try {
            Result.Companion companion43 = Result.INSTANCE;
            objM12684constructorimpl22 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uint32Array.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Uint32Array.class);
                }
            }));
        } catch (Throwable th23) {
            Result.Companion companion44 = Result.INSTANCE;
            objM12684constructorimpl22 = Result.m12684constructorimpl(ResultKt.createFailure(th23));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl22)) {
            objM12684constructorimpl22 = null;
        }
        TypeDescriptor typeDescriptor22 = (TypeDescriptor) objM12684constructorimpl22;
        if (typeDescriptor22 == null) {
            typeDescriptor22 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Uint32Array.class));
        }
        pairArr[21] = TuplesKt.to(pair22, new AnyType(typeDescriptor22, null, 2, null));
        Pair pair23 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Float32Array.class), false);
        try {
            Result.Companion companion45 = Result.INSTANCE;
            objM12684constructorimpl23 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Float32Array.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Float32Array.class);
                }
            }));
        } catch (Throwable th24) {
            Result.Companion companion46 = Result.INSTANCE;
            objM12684constructorimpl23 = Result.m12684constructorimpl(ResultKt.createFailure(th24));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl23)) {
            objM12684constructorimpl23 = null;
        }
        TypeDescriptor typeDescriptor23 = (TypeDescriptor) objM12684constructorimpl23;
        if (typeDescriptor23 == null) {
            typeDescriptor23 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Float32Array.class));
        }
        pairArr[22] = TuplesKt.to(pair23, new AnyType(typeDescriptor23, null, 2, null));
        Pair pair24 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Float64Array.class), false);
        try {
            Result.Companion companion47 = Result.INSTANCE;
            objM12684constructorimpl24 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Float64Array.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Float64Array.class);
                }
            }));
        } catch (Throwable th25) {
            Result.Companion companion48 = Result.INSTANCE;
            objM12684constructorimpl24 = Result.m12684constructorimpl(ResultKt.createFailure(th25));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl24)) {
            objM12684constructorimpl24 = null;
        }
        TypeDescriptor typeDescriptor24 = (TypeDescriptor) objM12684constructorimpl24;
        if (typeDescriptor24 == null) {
            typeDescriptor24 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Float64Array.class));
        }
        pairArr[23] = TuplesKt.to(pair24, new AnyType(typeDescriptor24, null, 2, null));
        Pair pair25 = TuplesKt.to(Reflection.getOrCreateKotlinClass(BigInt64Array.class), false);
        try {
            Result.Companion companion49 = Result.INSTANCE;
            objM12684constructorimpl25 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(BigInt64Array.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$25
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(BigInt64Array.class);
                }
            }));
        } catch (Throwable th26) {
            Result.Companion companion50 = Result.INSTANCE;
            objM12684constructorimpl25 = Result.m12684constructorimpl(ResultKt.createFailure(th26));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl25)) {
            objM12684constructorimpl25 = null;
        }
        TypeDescriptor typeDescriptor25 = (TypeDescriptor) objM12684constructorimpl25;
        if (typeDescriptor25 == null) {
            typeDescriptor25 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(BigInt64Array.class));
        }
        pairArr[24] = TuplesKt.to(pair25, new AnyType(typeDescriptor25, null, 2, null));
        Pair pair26 = TuplesKt.to(Reflection.getOrCreateKotlinClass(BigUint64Array.class), false);
        try {
            Result.Companion companion51 = Result.INSTANCE;
            objM12684constructorimpl26 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(BigUint64Array.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$26
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(BigUint64Array.class);
                }
            }));
        } catch (Throwable th27) {
            Result.Companion companion52 = Result.INSTANCE;
            objM12684constructorimpl26 = Result.m12684constructorimpl(ResultKt.createFailure(th27));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl26)) {
            objM12684constructorimpl26 = null;
        }
        TypeDescriptor typeDescriptor26 = (TypeDescriptor) objM12684constructorimpl26;
        if (typeDescriptor26 == null) {
            typeDescriptor26 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(BigUint64Array.class));
        }
        pairArr[25] = TuplesKt.to(pair26, new AnyType(typeDescriptor26, null, 2, null));
        Pair pair27 = TuplesKt.to(Reflection.getOrCreateKotlinClass(ReadableArray.class), false);
        try {
            Result.Companion companion53 = Result.INSTANCE;
            objM12684constructorimpl27 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ReadableArray.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$27
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArray.class);
                }
            }));
        } catch (Throwable th28) {
            Result.Companion companion54 = Result.INSTANCE;
            objM12684constructorimpl27 = Result.m12684constructorimpl(ResultKt.createFailure(th28));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl27)) {
            objM12684constructorimpl27 = null;
        }
        TypeDescriptor typeDescriptor27 = (TypeDescriptor) objM12684constructorimpl27;
        if (typeDescriptor27 == null) {
            typeDescriptor27 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ReadableArray.class));
        }
        pairArr[26] = TuplesKt.to(pair27, new AnyType(typeDescriptor27, null, 2, null));
        Pair pair28 = TuplesKt.to(Reflection.getOrCreateKotlinClass(ReadableMap.class), false);
        try {
            Result.Companion companion55 = Result.INSTANCE;
            objM12684constructorimpl28 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ReadableMap.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$28
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableMap.class);
                }
            }));
        } catch (Throwable th29) {
            Result.Companion companion56 = Result.INSTANCE;
            objM12684constructorimpl28 = Result.m12684constructorimpl(ResultKt.createFailure(th29));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl28)) {
            objM12684constructorimpl28 = null;
        }
        TypeDescriptor typeDescriptor28 = (TypeDescriptor) objM12684constructorimpl28;
        if (typeDescriptor28 == null) {
            typeDescriptor28 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ReadableMap.class));
        }
        pairArr[27] = TuplesKt.to(pair28, new AnyType(typeDescriptor28, null, 2, null));
        Pair pair29 = TuplesKt.to(Reflection.getOrCreateKotlinClass(URL.class), false);
        try {
            Result.Companion companion57 = Result.INSTANCE;
            objM12684constructorimpl29 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(URL.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$29
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(URL.class);
                }
            }));
        } catch (Throwable th30) {
            Result.Companion companion58 = Result.INSTANCE;
            objM12684constructorimpl29 = Result.m12684constructorimpl(ResultKt.createFailure(th30));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl29)) {
            objM12684constructorimpl29 = null;
        }
        TypeDescriptor typeDescriptor29 = (TypeDescriptor) objM12684constructorimpl29;
        if (typeDescriptor29 == null) {
            typeDescriptor29 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(URL.class));
        }
        pairArr[28] = TuplesKt.to(pair29, new AnyType(typeDescriptor29, null, 2, null));
        Pair pair30 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Uri.class), false);
        try {
            Result.Companion companion59 = Result.INSTANCE;
            objM12684constructorimpl30 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Uri.class);
                }
            }));
        } catch (Throwable th31) {
            Result.Companion companion60 = Result.INSTANCE;
            objM12684constructorimpl30 = Result.m12684constructorimpl(ResultKt.createFailure(th31));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl30)) {
            objM12684constructorimpl30 = null;
        }
        TypeDescriptor typeDescriptor30 = (TypeDescriptor) objM12684constructorimpl30;
        if (typeDescriptor30 == null) {
            typeDescriptor30 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Uri.class));
        }
        pairArr[29] = TuplesKt.to(pair30, new AnyType(typeDescriptor30, null, 2, null));
        Pair pair31 = TuplesKt.to(Reflection.getOrCreateKotlinClass(URI.class), false);
        try {
            Result.Companion companion61 = Result.INSTANCE;
            objM12684constructorimpl31 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(URI.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$31
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(URI.class);
                }
            }));
        } catch (Throwable th32) {
            Result.Companion companion62 = Result.INSTANCE;
            objM12684constructorimpl31 = Result.m12684constructorimpl(ResultKt.createFailure(th32));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl31)) {
            objM12684constructorimpl31 = null;
        }
        TypeDescriptor typeDescriptor31 = (TypeDescriptor) objM12684constructorimpl31;
        if (typeDescriptor31 == null) {
            typeDescriptor31 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(URI.class));
        }
        pairArr[30] = TuplesKt.to(pair31, new AnyType(typeDescriptor31, null, 2, null));
        Pair pair32 = TuplesKt.to(Reflection.getOrCreateKotlinClass(File.class), false);
        try {
            Result.Companion companion63 = Result.INSTANCE;
            objM12684constructorimpl32 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(File.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$32
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(File.class);
                }
            }));
        } catch (Throwable th33) {
            Result.Companion companion64 = Result.INSTANCE;
            objM12684constructorimpl32 = Result.m12684constructorimpl(ResultKt.createFailure(th33));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl32)) {
            objM12684constructorimpl32 = null;
        }
        TypeDescriptor typeDescriptor32 = (TypeDescriptor) objM12684constructorimpl32;
        if (typeDescriptor32 == null) {
            typeDescriptor32 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(File.class));
        }
        pairArr[31] = TuplesKt.to(pair32, new AnyType(typeDescriptor32, null, 2, null));
        Pair pair33 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Object.class), false);
        try {
            Result.Companion companion65 = Result.INSTANCE;
            objM12684constructorimpl33 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Object.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$33
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Object.class);
                }
            }));
        } catch (Throwable th34) {
            Result.Companion companion66 = Result.INSTANCE;
            objM12684constructorimpl33 = Result.m12684constructorimpl(ResultKt.createFailure(th34));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl33)) {
            objM12684constructorimpl33 = null;
        }
        TypeDescriptor typeDescriptor33 = (TypeDescriptor) objM12684constructorimpl33;
        if (typeDescriptor33 == null) {
            typeDescriptor33 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Object.class));
        }
        pairArr[32] = TuplesKt.to(pair33, new AnyType(typeDescriptor33, null, 2, null));
        Pair pair34 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Unit.class), false);
        try {
            Result.Companion companion67 = Result.INSTANCE;
            objM12684constructorimpl34 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Unit.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$34
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Unit.class);
                }
            }));
        } catch (Throwable th35) {
            Result.Companion companion68 = Result.INSTANCE;
            objM12684constructorimpl34 = Result.m12684constructorimpl(ResultKt.createFailure(th35));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl34)) {
            objM12684constructorimpl34 = null;
        }
        TypeDescriptor typeDescriptor34 = (TypeDescriptor) objM12684constructorimpl34;
        if (typeDescriptor34 == null) {
            typeDescriptor34 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Unit.class));
        }
        pairArr[33] = TuplesKt.to(pair34, new AnyType(typeDescriptor34, null, 2, null));
        Pair pair35 = TuplesKt.to(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false);
        try {
            Result.Companion companion69 = Result.INSTANCE;
            objM12684constructorimpl35 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ReadableArguments.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$35
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }));
        } catch (Throwable th36) {
            Result.Companion companion70 = Result.INSTANCE;
            objM12684constructorimpl35 = Result.m12684constructorimpl(ResultKt.createFailure(th36));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl35)) {
            objM12684constructorimpl35 = null;
        }
        TypeDescriptor typeDescriptor35 = (TypeDescriptor) objM12684constructorimpl35;
        if (typeDescriptor35 == null) {
            typeDescriptor35 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ReadableArguments.class));
        }
        pairArr[34] = TuplesKt.to(pair35, new AnyType(typeDescriptor35, null, 2, null));
        Pair pair36 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Integer.TYPE), true);
        try {
            Result.Companion companion71 = Result.INSTANCE;
            objM12684constructorimpl36 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT_NULLABLE), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Integer.class);
                }
            }));
        } catch (Throwable th37) {
            Result.Companion companion72 = Result.INSTANCE;
            objM12684constructorimpl36 = Result.m12684constructorimpl(ResultKt.createFailure(th37));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl36)) {
            objM12684constructorimpl36 = null;
        }
        TypeDescriptor typeDescriptor36 = (TypeDescriptor) objM12684constructorimpl36;
        if (typeDescriptor36 == null) {
            typeDescriptor36 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Integer.class));
        }
        pairArr[35] = TuplesKt.to(pair36, new AnyType(typeDescriptor36, null, 2, null));
        Pair pair37 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Float.TYPE), true);
        try {
            Result.Companion companion73 = Result.INSTANCE;
            objM12684constructorimpl37 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.FLOAT_NULLABLE), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$37
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Float.class);
                }
            }));
        } catch (Throwable th38) {
            Result.Companion companion74 = Result.INSTANCE;
            objM12684constructorimpl37 = Result.m12684constructorimpl(ResultKt.createFailure(th38));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl37)) {
            objM12684constructorimpl37 = null;
        }
        TypeDescriptor typeDescriptor37 = (TypeDescriptor) objM12684constructorimpl37;
        if (typeDescriptor37 == null) {
            typeDescriptor37 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Float.class));
        }
        pairArr[36] = TuplesKt.to(pair37, new AnyType(typeDescriptor37, null, 2, null));
        Pair pair38 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Double.TYPE), true);
        try {
            Result.Companion companion75 = Result.INSTANCE;
            objM12684constructorimpl38 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.DOUBLE_NULLABLE), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$38
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Double.class);
                }
            }));
        } catch (Throwable th39) {
            Result.Companion companion76 = Result.INSTANCE;
            objM12684constructorimpl38 = Result.m12684constructorimpl(ResultKt.createFailure(th39));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl38)) {
            objM12684constructorimpl38 = null;
        }
        TypeDescriptor typeDescriptor38 = (TypeDescriptor) objM12684constructorimpl38;
        if (typeDescriptor38 == null) {
            typeDescriptor38 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Double.class));
        }
        pairArr[37] = TuplesKt.to(pair38, new AnyType(typeDescriptor38, null, 2, null));
        Pair pair39 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Long.TYPE), true);
        try {
            Result.Companion companion77 = Result.INSTANCE;
            objM12684constructorimpl39 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.LONG_NULLABLE), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$39
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Long.class);
                }
            }));
        } catch (Throwable th40) {
            Result.Companion companion78 = Result.INSTANCE;
            objM12684constructorimpl39 = Result.m12684constructorimpl(ResultKt.createFailure(th40));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl39)) {
            objM12684constructorimpl39 = null;
        }
        TypeDescriptor typeDescriptor39 = (TypeDescriptor) objM12684constructorimpl39;
        if (typeDescriptor39 == null) {
            typeDescriptor39 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Long.class));
        }
        pairArr[38] = TuplesKt.to(pair39, new AnyType(typeDescriptor39, null, 2, null));
        Pair pair40 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Boolean.TYPE), true);
        try {
            Result.Companion companion79 = Result.INSTANCE;
            objM12684constructorimpl40 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN_NULLABLE), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$40
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Boolean.class);
                }
            }));
        } catch (Throwable th41) {
            Result.Companion companion80 = Result.INSTANCE;
            objM12684constructorimpl40 = Result.m12684constructorimpl(ResultKt.createFailure(th41));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl40)) {
            objM12684constructorimpl40 = null;
        }
        TypeDescriptor typeDescriptor40 = (TypeDescriptor) objM12684constructorimpl40;
        if (typeDescriptor40 == null) {
            typeDescriptor40 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
        }
        pairArr[39] = TuplesKt.to(pair40, new AnyType(typeDescriptor40, null, 2, null));
        Pair pair41 = TuplesKt.to(Reflection.getOrCreateKotlinClass(String.class), true);
        try {
            Result.Companion companion81 = Result.INSTANCE;
            objM12684constructorimpl41 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$41
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            }));
        } catch (Throwable th42) {
            Result.Companion companion82 = Result.INSTANCE;
            objM12684constructorimpl41 = Result.m12684constructorimpl(ResultKt.createFailure(th42));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl41)) {
            objM12684constructorimpl41 = null;
        }
        TypeDescriptor typeDescriptor41 = (TypeDescriptor) objM12684constructorimpl41;
        if (typeDescriptor41 == null) {
            typeDescriptor41 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
        }
        pairArr[40] = TuplesKt.to(pair41, new AnyType(typeDescriptor41, null, 2, null));
        Pair pair42 = TuplesKt.to(Reflection.getOrCreateKotlinClass(byte[].class), true);
        try {
            Result.Companion companion83 = Result.INSTANCE;
            objM12684constructorimpl42 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(byte[].class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$42
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(byte[].class);
                }
            }));
        } catch (Throwable th43) {
            Result.Companion companion84 = Result.INSTANCE;
            objM12684constructorimpl42 = Result.m12684constructorimpl(ResultKt.createFailure(th43));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl42)) {
            objM12684constructorimpl42 = null;
        }
        TypeDescriptor typeDescriptor42 = (TypeDescriptor) objM12684constructorimpl42;
        if (typeDescriptor42 == null) {
            typeDescriptor42 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(byte[].class));
        }
        pairArr[41] = TuplesKt.to(pair42, new AnyType(typeDescriptor42, null, 2, null));
        Pair pair43 = TuplesKt.to(Reflection.getOrCreateKotlinClass(long[].class), true);
        try {
            Result.Companion companion85 = Result.INSTANCE;
            objM12684constructorimpl43 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(long[].class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$43
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(long[].class);
                }
            }));
        } catch (Throwable th44) {
            Result.Companion companion86 = Result.INSTANCE;
            objM12684constructorimpl43 = Result.m12684constructorimpl(ResultKt.createFailure(th44));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl43)) {
            objM12684constructorimpl43 = null;
        }
        TypeDescriptor typeDescriptor43 = (TypeDescriptor) objM12684constructorimpl43;
        if (typeDescriptor43 == null) {
            typeDescriptor43 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(long[].class));
        }
        pairArr[42] = TuplesKt.to(pair43, new AnyType(typeDescriptor43, null, 2, null));
        Pair pair44 = TuplesKt.to(Reflection.getOrCreateKotlinClass(int[].class), true);
        try {
            Result.Companion companion87 = Result.INSTANCE;
            objM12684constructorimpl44 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(int[].class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$44
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(int[].class);
                }
            }));
        } catch (Throwable th45) {
            Result.Companion companion88 = Result.INSTANCE;
            objM12684constructorimpl44 = Result.m12684constructorimpl(ResultKt.createFailure(th45));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl44)) {
            objM12684constructorimpl44 = null;
        }
        TypeDescriptor typeDescriptor44 = (TypeDescriptor) objM12684constructorimpl44;
        if (typeDescriptor44 == null) {
            typeDescriptor44 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(int[].class));
        }
        pairArr[43] = TuplesKt.to(pair44, new AnyType(typeDescriptor44, null, 2, null));
        Pair pair45 = TuplesKt.to(Reflection.getOrCreateKotlinClass(boolean[].class), true);
        try {
            Result.Companion companion89 = Result.INSTANCE;
            objM12684constructorimpl45 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(boolean[].class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$45
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(boolean[].class);
                }
            }));
        } catch (Throwable th46) {
            Result.Companion companion90 = Result.INSTANCE;
            objM12684constructorimpl45 = Result.m12684constructorimpl(ResultKt.createFailure(th46));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl45)) {
            objM12684constructorimpl45 = null;
        }
        TypeDescriptor typeDescriptor45 = (TypeDescriptor) objM12684constructorimpl45;
        if (typeDescriptor45 == null) {
            typeDescriptor45 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(boolean[].class));
        }
        pairArr[44] = TuplesKt.to(pair45, new AnyType(typeDescriptor45, null, 2, null));
        Pair pair46 = TuplesKt.to(Reflection.getOrCreateKotlinClass(float[].class), true);
        try {
            Result.Companion companion91 = Result.INSTANCE;
            objM12684constructorimpl46 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(float[].class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$46
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(float[].class);
                }
            }));
        } catch (Throwable th47) {
            Result.Companion companion92 = Result.INSTANCE;
            objM12684constructorimpl46 = Result.m12684constructorimpl(ResultKt.createFailure(th47));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl46)) {
            objM12684constructorimpl46 = null;
        }
        TypeDescriptor typeDescriptor46 = (TypeDescriptor) objM12684constructorimpl46;
        if (typeDescriptor46 == null) {
            typeDescriptor46 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(float[].class));
        }
        pairArr[45] = TuplesKt.to(pair46, new AnyType(typeDescriptor46, null, 2, null));
        Pair pair47 = TuplesKt.to(Reflection.getOrCreateKotlinClass(double[].class), true);
        try {
            Result.Companion companion93 = Result.INSTANCE;
            objM12684constructorimpl47 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(double[].class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$47
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(double[].class);
                }
            }));
        } catch (Throwable th48) {
            Result.Companion companion94 = Result.INSTANCE;
            objM12684constructorimpl47 = Result.m12684constructorimpl(ResultKt.createFailure(th48));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl47)) {
            objM12684constructorimpl47 = null;
        }
        TypeDescriptor typeDescriptor47 = (TypeDescriptor) objM12684constructorimpl47;
        if (typeDescriptor47 == null) {
            typeDescriptor47 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(double[].class));
        }
        pairArr[46] = TuplesKt.to(pair47, new AnyType(typeDescriptor47, null, 2, null));
        Pair pair48 = TuplesKt.to(Reflection.getOrCreateKotlinClass(JavaScriptValue.class), true);
        try {
            Result.Companion companion95 = Result.INSTANCE;
            objM12684constructorimpl48 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(JavaScriptValue.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$48
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(JavaScriptValue.class);
                }
            }));
        } catch (Throwable th49) {
            Result.Companion companion96 = Result.INSTANCE;
            objM12684constructorimpl48 = Result.m12684constructorimpl(ResultKt.createFailure(th49));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl48)) {
            objM12684constructorimpl48 = null;
        }
        TypeDescriptor typeDescriptor48 = (TypeDescriptor) objM12684constructorimpl48;
        if (typeDescriptor48 == null) {
            typeDescriptor48 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(JavaScriptValue.class));
        }
        pairArr[47] = TuplesKt.to(pair48, new AnyType(typeDescriptor48, null, 2, null));
        Pair pair49 = TuplesKt.to(Reflection.getOrCreateKotlinClass(JavaScriptObject.class), true);
        try {
            Result.Companion companion97 = Result.INSTANCE;
            objM12684constructorimpl49 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(JavaScriptObject.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$49
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(JavaScriptObject.class);
                }
            }));
        } catch (Throwable th50) {
            Result.Companion companion98 = Result.INSTANCE;
            objM12684constructorimpl49 = Result.m12684constructorimpl(ResultKt.createFailure(th50));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl49)) {
            objM12684constructorimpl49 = null;
        }
        TypeDescriptor typeDescriptor49 = (TypeDescriptor) objM12684constructorimpl49;
        if (typeDescriptor49 == null) {
            typeDescriptor49 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(JavaScriptObject.class));
        }
        pairArr[48] = TuplesKt.to(pair49, new AnyType(typeDescriptor49, null, 2, null));
        Pair pair50 = TuplesKt.to(Reflection.getOrCreateKotlinClass(TypedArray.class), true);
        try {
            Result.Companion companion99 = Result.INSTANCE;
            objM12684constructorimpl50 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(TypedArray.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$50
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(TypedArray.class);
                }
            }));
        } catch (Throwable th51) {
            Result.Companion companion100 = Result.INSTANCE;
            objM12684constructorimpl50 = Result.m12684constructorimpl(ResultKt.createFailure(th51));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl50)) {
            objM12684constructorimpl50 = null;
        }
        TypeDescriptor typeDescriptor50 = (TypeDescriptor) objM12684constructorimpl50;
        if (typeDescriptor50 == null) {
            typeDescriptor50 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(TypedArray.class));
        }
        pairArr[49] = TuplesKt.to(pair50, new AnyType(typeDescriptor50, null, 2, null));
        Pair pair51 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Int8Array.class), true);
        try {
            Result.Companion companion101 = Result.INSTANCE;
            objM12684constructorimpl51 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Int8Array.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$51
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Int8Array.class);
                }
            }));
        } catch (Throwable th52) {
            Result.Companion companion102 = Result.INSTANCE;
            objM12684constructorimpl51 = Result.m12684constructorimpl(ResultKt.createFailure(th52));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl51)) {
            objM12684constructorimpl51 = null;
        }
        TypeDescriptor typeDescriptor51 = (TypeDescriptor) objM12684constructorimpl51;
        if (typeDescriptor51 == null) {
            typeDescriptor51 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Int8Array.class));
        }
        pairArr[50] = TuplesKt.to(pair51, new AnyType(typeDescriptor51, null, 2, null));
        Pair pair52 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Int16Array.class), true);
        try {
            Result.Companion companion103 = Result.INSTANCE;
            objM12684constructorimpl52 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Int16Array.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$52
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Int16Array.class);
                }
            }));
        } catch (Throwable th53) {
            Result.Companion companion104 = Result.INSTANCE;
            objM12684constructorimpl52 = Result.m12684constructorimpl(ResultKt.createFailure(th53));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl52)) {
            objM12684constructorimpl52 = null;
        }
        TypeDescriptor typeDescriptor52 = (TypeDescriptor) objM12684constructorimpl52;
        if (typeDescriptor52 == null) {
            typeDescriptor52 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Int16Array.class));
        }
        pairArr[51] = TuplesKt.to(pair52, new AnyType(typeDescriptor52, null, 2, null));
        Pair pair53 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Int32Array.class), true);
        try {
            Result.Companion companion105 = Result.INSTANCE;
            objM12684constructorimpl53 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Int32Array.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$53
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Int32Array.class);
                }
            }));
        } catch (Throwable th54) {
            Result.Companion companion106 = Result.INSTANCE;
            objM12684constructorimpl53 = Result.m12684constructorimpl(ResultKt.createFailure(th54));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl53)) {
            objM12684constructorimpl53 = null;
        }
        TypeDescriptor typeDescriptor53 = (TypeDescriptor) objM12684constructorimpl53;
        if (typeDescriptor53 == null) {
            typeDescriptor53 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Int32Array.class));
        }
        pairArr[52] = TuplesKt.to(pair53, new AnyType(typeDescriptor53, null, 2, null));
        Pair pair54 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint8Array.class), true);
        try {
            Result.Companion companion107 = Result.INSTANCE;
            objM12684constructorimpl54 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uint8Array.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$54
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Uint8Array.class);
                }
            }));
        } catch (Throwable th55) {
            Result.Companion companion108 = Result.INSTANCE;
            objM12684constructorimpl54 = Result.m12684constructorimpl(ResultKt.createFailure(th55));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl54)) {
            objM12684constructorimpl54 = null;
        }
        TypeDescriptor typeDescriptor54 = (TypeDescriptor) objM12684constructorimpl54;
        if (typeDescriptor54 == null) {
            typeDescriptor54 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Uint8Array.class));
        }
        pairArr[53] = TuplesKt.to(pair54, new AnyType(typeDescriptor54, null, 2, null));
        Pair pair55 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint8ClampedArray.class), true);
        try {
            Result.Companion companion109 = Result.INSTANCE;
            objM12684constructorimpl55 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uint8ClampedArray.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$55
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Uint8ClampedArray.class);
                }
            }));
        } catch (Throwable th56) {
            Result.Companion companion110 = Result.INSTANCE;
            objM12684constructorimpl55 = Result.m12684constructorimpl(ResultKt.createFailure(th56));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl55)) {
            objM12684constructorimpl55 = null;
        }
        TypeDescriptor typeDescriptor55 = (TypeDescriptor) objM12684constructorimpl55;
        if (typeDescriptor55 == null) {
            typeDescriptor55 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Uint8ClampedArray.class));
        }
        pairArr[54] = TuplesKt.to(pair55, new AnyType(typeDescriptor55, null, 2, null));
        Pair pair56 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint16Array.class), true);
        try {
            Result.Companion companion111 = Result.INSTANCE;
            objM12684constructorimpl56 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uint16Array.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$56
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Uint16Array.class);
                }
            }));
        } catch (Throwable th57) {
            Result.Companion companion112 = Result.INSTANCE;
            objM12684constructorimpl56 = Result.m12684constructorimpl(ResultKt.createFailure(th57));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl56)) {
            objM12684constructorimpl56 = null;
        }
        TypeDescriptor typeDescriptor56 = (TypeDescriptor) objM12684constructorimpl56;
        if (typeDescriptor56 == null) {
            typeDescriptor56 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Uint16Array.class));
        }
        pairArr[55] = TuplesKt.to(pair56, new AnyType(typeDescriptor56, null, 2, null));
        Pair pair57 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Uint32Array.class), true);
        try {
            Result.Companion companion113 = Result.INSTANCE;
            objM12684constructorimpl57 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uint32Array.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$57
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Uint32Array.class);
                }
            }));
        } catch (Throwable th58) {
            Result.Companion companion114 = Result.INSTANCE;
            objM12684constructorimpl57 = Result.m12684constructorimpl(ResultKt.createFailure(th58));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl57)) {
            objM12684constructorimpl57 = null;
        }
        TypeDescriptor typeDescriptor57 = (TypeDescriptor) objM12684constructorimpl57;
        if (typeDescriptor57 == null) {
            typeDescriptor57 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Uint32Array.class));
        }
        pairArr[56] = TuplesKt.to(pair57, new AnyType(typeDescriptor57, null, 2, null));
        Pair pair58 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Float32Array.class), true);
        try {
            Result.Companion companion115 = Result.INSTANCE;
            objM12684constructorimpl58 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Float32Array.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$58
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Float32Array.class);
                }
            }));
        } catch (Throwable th59) {
            Result.Companion companion116 = Result.INSTANCE;
            objM12684constructorimpl58 = Result.m12684constructorimpl(ResultKt.createFailure(th59));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl58)) {
            objM12684constructorimpl58 = null;
        }
        TypeDescriptor typeDescriptor58 = (TypeDescriptor) objM12684constructorimpl58;
        if (typeDescriptor58 == null) {
            typeDescriptor58 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Float32Array.class));
        }
        pairArr[57] = TuplesKt.to(pair58, new AnyType(typeDescriptor58, null, 2, null));
        Pair pair59 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Float64Array.class), true);
        try {
            Result.Companion companion117 = Result.INSTANCE;
            objM12684constructorimpl59 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Float64Array.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$59
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Float64Array.class);
                }
            }));
        } catch (Throwable th60) {
            Result.Companion companion118 = Result.INSTANCE;
            objM12684constructorimpl59 = Result.m12684constructorimpl(ResultKt.createFailure(th60));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl59)) {
            objM12684constructorimpl59 = null;
        }
        TypeDescriptor typeDescriptor59 = (TypeDescriptor) objM12684constructorimpl59;
        if (typeDescriptor59 == null) {
            typeDescriptor59 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Float64Array.class));
        }
        pairArr[58] = TuplesKt.to(pair59, new AnyType(typeDescriptor59, null, 2, null));
        Pair pair60 = TuplesKt.to(Reflection.getOrCreateKotlinClass(BigInt64Array.class), true);
        try {
            Result.Companion companion119 = Result.INSTANCE;
            objM12684constructorimpl60 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(BigInt64Array.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$60
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(BigInt64Array.class);
                }
            }));
        } catch (Throwable th61) {
            Result.Companion companion120 = Result.INSTANCE;
            objM12684constructorimpl60 = Result.m12684constructorimpl(ResultKt.createFailure(th61));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl60)) {
            objM12684constructorimpl60 = null;
        }
        TypeDescriptor typeDescriptor60 = (TypeDescriptor) objM12684constructorimpl60;
        if (typeDescriptor60 == null) {
            typeDescriptor60 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(BigInt64Array.class));
        }
        pairArr[59] = TuplesKt.to(pair60, new AnyType(typeDescriptor60, null, 2, null));
        Pair pair61 = TuplesKt.to(Reflection.getOrCreateKotlinClass(BigUint64Array.class), true);
        try {
            Result.Companion companion121 = Result.INSTANCE;
            objM12684constructorimpl61 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(BigUint64Array.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$61
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(BigUint64Array.class);
                }
            }));
        } catch (Throwable th62) {
            Result.Companion companion122 = Result.INSTANCE;
            objM12684constructorimpl61 = Result.m12684constructorimpl(ResultKt.createFailure(th62));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl61)) {
            objM12684constructorimpl61 = null;
        }
        TypeDescriptor typeDescriptor61 = (TypeDescriptor) objM12684constructorimpl61;
        if (typeDescriptor61 == null) {
            typeDescriptor61 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(BigUint64Array.class));
        }
        pairArr[60] = TuplesKt.to(pair61, new AnyType(typeDescriptor61, null, 2, null));
        Pair pair62 = TuplesKt.to(Reflection.getOrCreateKotlinClass(ReadableArray.class), true);
        try {
            Result.Companion companion123 = Result.INSTANCE;
            objM12684constructorimpl62 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ReadableArray.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$62
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(ReadableArray.class);
                }
            }));
        } catch (Throwable th63) {
            Result.Companion companion124 = Result.INSTANCE;
            objM12684constructorimpl62 = Result.m12684constructorimpl(ResultKt.createFailure(th63));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl62)) {
            objM12684constructorimpl62 = null;
        }
        TypeDescriptor typeDescriptor62 = (TypeDescriptor) objM12684constructorimpl62;
        if (typeDescriptor62 == null) {
            typeDescriptor62 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(ReadableArray.class));
        }
        pairArr[61] = TuplesKt.to(pair62, new AnyType(typeDescriptor62, null, 2, null));
        Pair pair63 = TuplesKt.to(Reflection.getOrCreateKotlinClass(ReadableMap.class), true);
        try {
            Result.Companion companion125 = Result.INSTANCE;
            objM12684constructorimpl63 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ReadableMap.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$63
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(ReadableMap.class);
                }
            }));
        } catch (Throwable th64) {
            Result.Companion companion126 = Result.INSTANCE;
            objM12684constructorimpl63 = Result.m12684constructorimpl(ResultKt.createFailure(th64));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl63)) {
            objM12684constructorimpl63 = null;
        }
        TypeDescriptor typeDescriptor63 = (TypeDescriptor) objM12684constructorimpl63;
        if (typeDescriptor63 == null) {
            typeDescriptor63 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(ReadableMap.class));
        }
        pairArr[62] = TuplesKt.to(pair63, new AnyType(typeDescriptor63, null, 2, null));
        Pair pair64 = TuplesKt.to(Reflection.getOrCreateKotlinClass(URL.class), true);
        try {
            Result.Companion companion127 = Result.INSTANCE;
            objM12684constructorimpl64 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(URL.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$64
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(URL.class);
                }
            }));
        } catch (Throwable th65) {
            Result.Companion companion128 = Result.INSTANCE;
            objM12684constructorimpl64 = Result.m12684constructorimpl(ResultKt.createFailure(th65));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl64)) {
            objM12684constructorimpl64 = null;
        }
        TypeDescriptor typeDescriptor64 = (TypeDescriptor) objM12684constructorimpl64;
        if (typeDescriptor64 == null) {
            typeDescriptor64 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(URL.class));
        }
        pairArr[63] = TuplesKt.to(pair64, new AnyType(typeDescriptor64, null, 2, null));
        Pair pair65 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Uri.class), true);
        try {
            Result.Companion companion129 = Result.INSTANCE;
            objM12684constructorimpl65 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$65
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Uri.class);
                }
            }));
        } catch (Throwable th66) {
            Result.Companion companion130 = Result.INSTANCE;
            objM12684constructorimpl65 = Result.m12684constructorimpl(ResultKt.createFailure(th66));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl65)) {
            objM12684constructorimpl65 = null;
        }
        TypeDescriptor typeDescriptor65 = (TypeDescriptor) objM12684constructorimpl65;
        if (typeDescriptor65 == null) {
            typeDescriptor65 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Uri.class));
        }
        pairArr[64] = TuplesKt.to(pair65, new AnyType(typeDescriptor65, null, 2, null));
        Pair pair66 = TuplesKt.to(Reflection.getOrCreateKotlinClass(URI.class), true);
        try {
            Result.Companion companion131 = Result.INSTANCE;
            objM12684constructorimpl66 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(URI.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$66
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(URI.class);
                }
            }));
        } catch (Throwable th67) {
            Result.Companion companion132 = Result.INSTANCE;
            objM12684constructorimpl66 = Result.m12684constructorimpl(ResultKt.createFailure(th67));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl66)) {
            objM12684constructorimpl66 = null;
        }
        TypeDescriptor typeDescriptor66 = (TypeDescriptor) objM12684constructorimpl66;
        if (typeDescriptor66 == null) {
            typeDescriptor66 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(URI.class));
        }
        pairArr[65] = TuplesKt.to(pair66, new AnyType(typeDescriptor66, null, 2, null));
        Pair pair67 = TuplesKt.to(Reflection.getOrCreateKotlinClass(File.class), true);
        try {
            Result.Companion companion133 = Result.INSTANCE;
            objM12684constructorimpl67 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(File.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$67
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(File.class);
                }
            }));
        } catch (Throwable th68) {
            Result.Companion companion134 = Result.INSTANCE;
            objM12684constructorimpl67 = Result.m12684constructorimpl(ResultKt.createFailure(th68));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl67)) {
            objM12684constructorimpl67 = null;
        }
        TypeDescriptor typeDescriptor67 = (TypeDescriptor) objM12684constructorimpl67;
        if (typeDescriptor67 == null) {
            typeDescriptor67 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(File.class));
        }
        pairArr[66] = TuplesKt.to(pair67, new AnyType(typeDescriptor67, null, 2, null));
        Pair pair68 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Object.class), true);
        try {
            Result.Companion companion135 = Result.INSTANCE;
            objM12684constructorimpl68 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Object.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$68
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Object.class);
                }
            }));
        } catch (Throwable th69) {
            Result.Companion companion136 = Result.INSTANCE;
            objM12684constructorimpl68 = Result.m12684constructorimpl(ResultKt.createFailure(th69));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl68)) {
            objM12684constructorimpl68 = null;
        }
        TypeDescriptor typeDescriptor68 = (TypeDescriptor) objM12684constructorimpl68;
        if (typeDescriptor68 == null) {
            typeDescriptor68 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Object.class));
        }
        pairArr[67] = TuplesKt.to(pair68, new AnyType(typeDescriptor68, null, 2, null));
        Pair pair69 = TuplesKt.to(Reflection.getOrCreateKotlinClass(Unit.class), true);
        try {
            Result.Companion companion137 = Result.INSTANCE;
            objM12684constructorimpl69 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Unit.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$69
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Unit.class);
                }
            }));
        } catch (Throwable th70) {
            Result.Companion companion138 = Result.INSTANCE;
            objM12684constructorimpl69 = Result.m12684constructorimpl(ResultKt.createFailure(th70));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl69)) {
            objM12684constructorimpl69 = null;
        }
        TypeDescriptor typeDescriptor69 = (TypeDescriptor) objM12684constructorimpl69;
        if (typeDescriptor69 == null) {
            typeDescriptor69 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Unit.class));
        }
        pairArr[68] = TuplesKt.to(pair69, new AnyType(typeDescriptor69, null, 2, null));
        Pair pair70 = TuplesKt.to(Reflection.getOrCreateKotlinClass(ReadableArguments.class), true);
        try {
            Result.Companion companion139 = Result.INSTANCE;
            objM12684constructorimpl70 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ReadableArguments.class, true, null)), new Function0<KType>() { // from class: expo.modules.kotlin.types.AnyTypeCache$special$$inlined$typeDescriptorOf$70
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(ReadableArguments.class);
                }
            }));
        } catch (Throwable th71) {
            Result.Companion companion140 = Result.INSTANCE;
            objM12684constructorimpl70 = Result.m12684constructorimpl(ResultKt.createFailure(th71));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl70)) {
            objM12684constructorimpl70 = null;
        }
        TypeDescriptor typeDescriptor70 = (TypeDescriptor) objM12684constructorimpl70;
        if (typeDescriptor70 == null) {
            typeDescriptor70 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(ReadableArguments.class));
        }
        pairArr[69] = TuplesKt.to(pair70, new AnyType(typeDescriptor70, null, 2, null));
        typesMap = MapsKt.mapOf(pairArr);
        $stable = i;
    }
}
