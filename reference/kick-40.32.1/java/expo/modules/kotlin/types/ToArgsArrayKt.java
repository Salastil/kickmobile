package expo.modules.kotlin.types;

import expo.modules.kotlin.types.descriptors.RawTypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.TypeDescriptorOfKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: toArgsArray.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u001a8\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086\b¢\u0006\u0002\u0010\b\u001aP\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086\b¢\u0006\u0002\u0010\u000b\u001ah\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086\b¢\u0006\u0002\u0010\u000e\u001a\u0080\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086\b¢\u0006\u0002\u0010\u0011\u001a\u0098\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086\b¢\u0006\u0002\u0010\u0014\u001a°\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00052\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086\b¢\u0006\u0002\u0010\u0017\u001aÈ\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00052\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00052\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086\b¢\u0006\u0002\u0010\u001a\u001aà\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u0001\"\u0006\b\u0007\u0010\u001b\u0018\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00052\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00052\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00052\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086\b¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"toArgsArray", "", "Lexpo/modules/kotlin/types/AnyType;", "P0", "p0", "Ljava/lang/Class;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "(Ljava/lang/Class;Lexpo/modules/kotlin/types/TypeConverterProvider;)[Lexpo/modules/kotlin/types/AnyType;", "P1", "p1", "(Ljava/lang/Class;Ljava/lang/Class;Lexpo/modules/kotlin/types/TypeConverterProvider;)[Lexpo/modules/kotlin/types/AnyType;", "P2", "p2", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Lexpo/modules/kotlin/types/TypeConverterProvider;)[Lexpo/modules/kotlin/types/AnyType;", "P3", "p3", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Lexpo/modules/kotlin/types/TypeConverterProvider;)[Lexpo/modules/kotlin/types/AnyType;", "P4", "p4", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Lexpo/modules/kotlin/types/TypeConverterProvider;)[Lexpo/modules/kotlin/types/AnyType;", "P5", "p5", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Lexpo/modules/kotlin/types/TypeConverterProvider;)[Lexpo/modules/kotlin/types/AnyType;", "P6", "p6", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Lexpo/modules/kotlin/types/TypeConverterProvider;)[Lexpo/modules/kotlin/types/AnyType;", "P7", "p7", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Lexpo/modules/kotlin/types/TypeConverterProvider;)[Lexpo/modules/kotlin/types/AnyType;", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ToArgsArrayKt {
    public static /* synthetic */ AnyType[] toArgsArray$default(Class p0, TypeConverterProvider typeConverterProvider, int i, Object obj) {
        Object objM12684constructorimpl;
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            p0 = Object.class;
        }
        if ((i & 2) != 0) {
            typeConverterProvider = null;
        }
        Intrinsics.checkNotNullParameter(p0, "p0");
        AnyType[] anyTypeArr = new AnyType[1];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$36.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, typeConverterProvider);
        }
        anyTypeArr[0] = anyType;
        return anyTypeArr;
    }

    public static final /* synthetic */ <P0> AnyType[] toArgsArray(Class<P0> p0, TypeConverterProvider typeConverterProvider) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(p0, "p0");
        AnyType[] anyTypeArr = new AnyType[1];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$36.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, typeConverterProvider);
        }
        anyTypeArr[0] = anyType;
        return anyTypeArr;
    }

    public static /* synthetic */ AnyType[] toArgsArray$default(Class p0, Class p1, TypeConverterProvider typeConverterProvider, int i, Object obj) {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            p0 = Object.class;
        }
        if ((i & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P1");
            p1 = Object.class;
        }
        if ((i & 4) != 0) {
            typeConverterProvider = null;
        }
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        AnyType[] anyTypeArr = new AnyType[2];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$1.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, typeConverterProvider);
        }
        anyTypeArr[0] = anyType;
        AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
        if (anyType2 == null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P1");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                Intrinsics.needClassReification();
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$2.INSTANCE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                objM12684constructorimpl2 = null;
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
            if (typeDescriptor2 == null) {
                Intrinsics.reifiedOperationMarker(6, "P1");
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType2 = new AnyType(typeDescriptor2, typeConverterProvider);
        }
        anyTypeArr[1] = anyType2;
        return anyTypeArr;
    }

    public static final /* synthetic */ <P0, P1> AnyType[] toArgsArray(Class<P0> p0, Class<P1> p1, TypeConverterProvider typeConverterProvider) {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        AnyType[] anyTypeArr = new AnyType[2];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$1.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, typeConverterProvider);
        }
        anyTypeArr[0] = anyType;
        AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
        if (anyType2 == null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P1");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                Intrinsics.needClassReification();
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$2.INSTANCE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                objM12684constructorimpl2 = null;
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
            if (typeDescriptor2 == null) {
                Intrinsics.reifiedOperationMarker(6, "P1");
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType2 = new AnyType(typeDescriptor2, typeConverterProvider);
        }
        anyTypeArr[1] = anyType2;
        return anyTypeArr;
    }

    public static /* synthetic */ AnyType[] toArgsArray$default(Class p0, Class p1, Class p2, TypeConverterProvider typeConverterProvider, int i, Object obj) {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            p0 = Object.class;
        }
        if ((i & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P1");
            p1 = Object.class;
        }
        if ((i & 4) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P2");
            p2 = Object.class;
        }
        if ((i & 8) != 0) {
            typeConverterProvider = null;
        }
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        AnyType[] anyTypeArr = new AnyType[3];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$3.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, typeConverterProvider);
        }
        anyTypeArr[0] = anyType;
        AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
        if (anyType2 == null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P1");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                Intrinsics.needClassReification();
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$4.INSTANCE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                objM12684constructorimpl2 = null;
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
            if (typeDescriptor2 == null) {
                Intrinsics.reifiedOperationMarker(6, "P1");
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType2 = new AnyType(typeDescriptor2, typeConverterProvider);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType3 == null) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P2");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor3 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                Intrinsics.needClassReification();
                objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$5.INSTANCE));
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                objM12684constructorimpl3 = null;
            }
            TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
            if (typeDescriptor3 == null) {
                Intrinsics.reifiedOperationMarker(6, "P2");
                typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType3 = new AnyType(typeDescriptor3, typeConverterProvider);
        }
        anyTypeArr[2] = anyType3;
        return anyTypeArr;
    }

    public static final /* synthetic */ <P0, P1, P2> AnyType[] toArgsArray(Class<P0> p0, Class<P1> p1, Class<P2> p2, TypeConverterProvider typeConverterProvider) {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        AnyType[] anyTypeArr = new AnyType[3];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$3.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, typeConverterProvider);
        }
        anyTypeArr[0] = anyType;
        AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
        if (anyType2 == null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P1");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                Intrinsics.needClassReification();
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$4.INSTANCE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                objM12684constructorimpl2 = null;
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
            if (typeDescriptor2 == null) {
                Intrinsics.reifiedOperationMarker(6, "P1");
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType2 = new AnyType(typeDescriptor2, typeConverterProvider);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType3 == null) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P2");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor3 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                Intrinsics.needClassReification();
                objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$5.INSTANCE));
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                objM12684constructorimpl3 = null;
            }
            TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
            if (typeDescriptor3 == null) {
                Intrinsics.reifiedOperationMarker(6, "P2");
                typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType3 = new AnyType(typeDescriptor3, typeConverterProvider);
        }
        anyTypeArr[2] = anyType3;
        return anyTypeArr;
    }

    public static /* synthetic */ AnyType[] toArgsArray$default(Class p0, Class p1, Class p2, Class p3, TypeConverterProvider typeConverterProvider, int i, Object obj) {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            p0 = Object.class;
        }
        if ((i & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P1");
            p1 = Object.class;
        }
        if ((i & 4) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P2");
            p2 = Object.class;
        }
        if ((i & 8) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P3");
            p3 = Object.class;
        }
        if ((i & 16) != 0) {
            typeConverterProvider = null;
        }
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(p3, "p3");
        AnyType[] anyTypeArr = new AnyType[4];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$6.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, typeConverterProvider);
        }
        anyTypeArr[0] = anyType;
        AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
        if (anyType2 == null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P1");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                Intrinsics.needClassReification();
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$7.INSTANCE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                objM12684constructorimpl2 = null;
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
            if (typeDescriptor2 == null) {
                Intrinsics.reifiedOperationMarker(6, "P1");
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType2 = new AnyType(typeDescriptor2, typeConverterProvider);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType3 == null) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P2");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor3 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                Intrinsics.needClassReification();
                objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$8.INSTANCE));
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                objM12684constructorimpl3 = null;
            }
            TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
            if (typeDescriptor3 == null) {
                Intrinsics.reifiedOperationMarker(6, "P2");
                typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType3 = new AnyType(typeDescriptor3, typeConverterProvider);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeCache anyTypeCache4 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeCache4.getTypesMap().get(new Pair(orCreateKotlinClass4, false));
        if (anyType4 == null) {
            try {
                Result.Companion companion7 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P3");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor4 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4);
                Intrinsics.needClassReification();
                objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor4, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$9.INSTANCE));
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                objM12684constructorimpl4 = null;
            }
            TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
            if (typeDescriptor4 == null) {
                Intrinsics.reifiedOperationMarker(6, "P3");
                typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType4 = new AnyType(typeDescriptor4, typeConverterProvider);
        }
        anyTypeArr[3] = anyType4;
        return anyTypeArr;
    }

    public static final /* synthetic */ <P0, P1, P2, P3> AnyType[] toArgsArray(Class<P0> p0, Class<P1> p1, Class<P2> p2, Class<P3> p3, TypeConverterProvider typeConverterProvider) {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(p3, "p3");
        AnyType[] anyTypeArr = new AnyType[4];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$6.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, typeConverterProvider);
        }
        anyTypeArr[0] = anyType;
        AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
        if (anyType2 == null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P1");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                Intrinsics.needClassReification();
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$7.INSTANCE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                objM12684constructorimpl2 = null;
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
            if (typeDescriptor2 == null) {
                Intrinsics.reifiedOperationMarker(6, "P1");
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType2 = new AnyType(typeDescriptor2, typeConverterProvider);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType3 == null) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P2");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor3 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                Intrinsics.needClassReification();
                objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$8.INSTANCE));
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                objM12684constructorimpl3 = null;
            }
            TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
            if (typeDescriptor3 == null) {
                Intrinsics.reifiedOperationMarker(6, "P2");
                typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType3 = new AnyType(typeDescriptor3, typeConverterProvider);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeCache anyTypeCache4 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeCache4.getTypesMap().get(new Pair(orCreateKotlinClass4, false));
        if (anyType4 == null) {
            try {
                Result.Companion companion7 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P3");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor4 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4);
                Intrinsics.needClassReification();
                objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor4, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$9.INSTANCE));
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                objM12684constructorimpl4 = null;
            }
            TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
            if (typeDescriptor4 == null) {
                Intrinsics.reifiedOperationMarker(6, "P3");
                typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType4 = new AnyType(typeDescriptor4, typeConverterProvider);
        }
        anyTypeArr[3] = anyType4;
        return anyTypeArr;
    }

    public static /* synthetic */ AnyType[] toArgsArray$default(Class p0, Class p1, Class p2, Class p3, Class p4, TypeConverterProvider typeConverterProvider, int i, Object obj) {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            p0 = Object.class;
        }
        if ((i & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P1");
            p1 = Object.class;
        }
        if ((i & 4) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P2");
            p2 = Object.class;
        }
        if ((i & 8) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P3");
            p3 = Object.class;
        }
        if ((i & 16) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P4");
            p4 = Object.class;
        }
        if ((i & 32) != 0) {
            typeConverterProvider = null;
        }
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(p3, "p3");
        Intrinsics.checkNotNullParameter(p4, "p4");
        AnyType[] anyTypeArr = new AnyType[5];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$10.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, typeConverterProvider);
        }
        anyTypeArr[0] = anyType;
        AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
        if (anyType2 == null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P1");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                Intrinsics.needClassReification();
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$11.INSTANCE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                objM12684constructorimpl2 = null;
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
            if (typeDescriptor2 == null) {
                Intrinsics.reifiedOperationMarker(6, "P1");
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType2 = new AnyType(typeDescriptor2, typeConverterProvider);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType3 == null) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P2");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor3 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                Intrinsics.needClassReification();
                objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$12.INSTANCE));
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                objM12684constructorimpl3 = null;
            }
            TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
            if (typeDescriptor3 == null) {
                Intrinsics.reifiedOperationMarker(6, "P2");
                typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType3 = new AnyType(typeDescriptor3, typeConverterProvider);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeCache anyTypeCache4 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeCache4.getTypesMap().get(new Pair(orCreateKotlinClass4, false));
        if (anyType4 == null) {
            try {
                Result.Companion companion7 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P3");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor4 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4);
                Intrinsics.needClassReification();
                objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor4, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$13.INSTANCE));
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                objM12684constructorimpl4 = null;
            }
            TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
            if (typeDescriptor4 == null) {
                Intrinsics.reifiedOperationMarker(6, "P3");
                typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType4 = new AnyType(typeDescriptor4, typeConverterProvider);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeCache anyTypeCache5 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeCache5.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType5 == null) {
            try {
                Result.Companion companion9 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P4");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError5 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor5 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError5);
                Intrinsics.needClassReification();
                objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor5, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$14.INSTANCE));
            } catch (Throwable th5) {
                Result.Companion companion10 = Result.INSTANCE;
                objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                objM12684constructorimpl5 = null;
            }
            TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
            if (typeDescriptor5 == null) {
                Intrinsics.reifiedOperationMarker(6, "P4");
                typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType5 = new AnyType(typeDescriptor5, typeConverterProvider);
        }
        anyTypeArr[4] = anyType5;
        return anyTypeArr;
    }

    public static final /* synthetic */ <P0, P1, P2, P3, P4> AnyType[] toArgsArray(Class<P0> p0, Class<P1> p1, Class<P2> p2, Class<P3> p3, Class<P4> p4, TypeConverterProvider typeConverterProvider) {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(p3, "p3");
        Intrinsics.checkNotNullParameter(p4, "p4");
        AnyType[] anyTypeArr = new AnyType[5];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$10.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, typeConverterProvider);
        }
        anyTypeArr[0] = anyType;
        AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
        if (anyType2 == null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P1");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                Intrinsics.needClassReification();
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$11.INSTANCE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                objM12684constructorimpl2 = null;
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
            if (typeDescriptor2 == null) {
                Intrinsics.reifiedOperationMarker(6, "P1");
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType2 = new AnyType(typeDescriptor2, typeConverterProvider);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType3 == null) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P2");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor3 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                Intrinsics.needClassReification();
                objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$12.INSTANCE));
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                objM12684constructorimpl3 = null;
            }
            TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
            if (typeDescriptor3 == null) {
                Intrinsics.reifiedOperationMarker(6, "P2");
                typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType3 = new AnyType(typeDescriptor3, typeConverterProvider);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeCache anyTypeCache4 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeCache4.getTypesMap().get(new Pair(orCreateKotlinClass4, false));
        if (anyType4 == null) {
            try {
                Result.Companion companion7 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P3");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor4 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4);
                Intrinsics.needClassReification();
                objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor4, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$13.INSTANCE));
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                objM12684constructorimpl4 = null;
            }
            TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
            if (typeDescriptor4 == null) {
                Intrinsics.reifiedOperationMarker(6, "P3");
                typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType4 = new AnyType(typeDescriptor4, typeConverterProvider);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeCache anyTypeCache5 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeCache5.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType5 == null) {
            try {
                Result.Companion companion9 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P4");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError5 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor5 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError5);
                Intrinsics.needClassReification();
                objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor5, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$14.INSTANCE));
            } catch (Throwable th5) {
                Result.Companion companion10 = Result.INSTANCE;
                objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                objM12684constructorimpl5 = null;
            }
            TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
            if (typeDescriptor5 == null) {
                Intrinsics.reifiedOperationMarker(6, "P4");
                typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType5 = new AnyType(typeDescriptor5, typeConverterProvider);
        }
        anyTypeArr[4] = anyType5;
        return anyTypeArr;
    }

    public static /* synthetic */ AnyType[] toArgsArray$default(Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, TypeConverterProvider typeConverterProvider, int i, Object obj) {
        Class p0;
        Class p1;
        Class p2;
        Class p3;
        Class p4;
        Class p5;
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            p0 = Object.class;
        } else {
            p0 = cls;
        }
        if ((i & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P1");
            p1 = Object.class;
        } else {
            p1 = cls2;
        }
        if ((i & 4) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P2");
            p2 = Object.class;
        } else {
            p2 = cls3;
        }
        if ((i & 8) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P3");
            p3 = Object.class;
        } else {
            p3 = cls4;
        }
        if ((i & 16) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P4");
            p4 = Object.class;
        } else {
            p4 = cls5;
        }
        if ((i & 32) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P5");
            p5 = Object.class;
        } else {
            p5 = cls6;
        }
        TypeConverterProvider typeConverterProvider2 = (i & 64) != 0 ? null : typeConverterProvider;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(p3, "p3");
        Intrinsics.checkNotNullParameter(p4, "p4");
        Intrinsics.checkNotNullParameter(p5, "p5");
        AnyType[] anyTypeArr = new AnyType[6];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$15.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, typeConverterProvider2);
        }
        anyTypeArr[0] = anyType;
        AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
        if (anyType2 == null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P1");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                Intrinsics.needClassReification();
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$16.INSTANCE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                objM12684constructorimpl2 = null;
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
            if (typeDescriptor2 == null) {
                Intrinsics.reifiedOperationMarker(6, "P1");
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType2 = new AnyType(typeDescriptor2, typeConverterProvider2);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType3 == null) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P2");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor3 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                Intrinsics.needClassReification();
                objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$17.INSTANCE));
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                objM12684constructorimpl3 = null;
            }
            TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
            if (typeDescriptor3 == null) {
                Intrinsics.reifiedOperationMarker(6, "P2");
                typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType3 = new AnyType(typeDescriptor3, typeConverterProvider2);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeCache anyTypeCache4 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeCache4.getTypesMap().get(new Pair(orCreateKotlinClass4, false));
        if (anyType4 == null) {
            try {
                Result.Companion companion7 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P3");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor4 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4);
                Intrinsics.needClassReification();
                objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor4, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$18.INSTANCE));
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                objM12684constructorimpl4 = null;
            }
            TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
            if (typeDescriptor4 == null) {
                Intrinsics.reifiedOperationMarker(6, "P3");
                typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType4 = new AnyType(typeDescriptor4, typeConverterProvider2);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeCache anyTypeCache5 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeCache5.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType5 == null) {
            try {
                Result.Companion companion9 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P4");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError5 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor5 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError5);
                Intrinsics.needClassReification();
                objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor5, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$19.INSTANCE));
            } catch (Throwable th5) {
                Result.Companion companion10 = Result.INSTANCE;
                objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                objM12684constructorimpl5 = null;
            }
            TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
            if (typeDescriptor5 == null) {
                Intrinsics.reifiedOperationMarker(6, "P4");
                typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType5 = new AnyType(typeDescriptor5, typeConverterProvider2);
        }
        anyTypeArr[4] = anyType5;
        AnyTypeCache anyTypeCache6 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeCache6.getTypesMap().get(new Pair(orCreateKotlinClass6, false));
        if (anyType6 == null) {
            try {
                Result.Companion companion11 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P5");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError6 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor6 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError6);
                Intrinsics.needClassReification();
                objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor6, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$20.INSTANCE));
            } catch (Throwable th6) {
                Result.Companion companion12 = Result.INSTANCE;
                objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                objM12684constructorimpl6 = null;
            }
            TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
            if (typeDescriptor6 == null) {
                Intrinsics.reifiedOperationMarker(6, "P5");
                typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType6 = new AnyType(typeDescriptor6, typeConverterProvider2);
        }
        anyTypeArr[5] = anyType6;
        return anyTypeArr;
    }

    public static final /* synthetic */ <P0, P1, P2, P3, P4, P5> AnyType[] toArgsArray(Class<P0> p0, Class<P1> p1, Class<P2> p2, Class<P3> p3, Class<P4> p4, Class<P5> p5, TypeConverterProvider typeConverterProvider) {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(p3, "p3");
        Intrinsics.checkNotNullParameter(p4, "p4");
        Intrinsics.checkNotNullParameter(p5, "p5");
        AnyType[] anyTypeArr = new AnyType[6];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$15.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, typeConverterProvider);
        }
        anyTypeArr[0] = anyType;
        AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
        if (anyType2 == null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P1");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                Intrinsics.needClassReification();
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$16.INSTANCE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                objM12684constructorimpl2 = null;
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
            if (typeDescriptor2 == null) {
                Intrinsics.reifiedOperationMarker(6, "P1");
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType2 = new AnyType(typeDescriptor2, typeConverterProvider);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType3 == null) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P2");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor3 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                Intrinsics.needClassReification();
                objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$17.INSTANCE));
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                objM12684constructorimpl3 = null;
            }
            TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
            if (typeDescriptor3 == null) {
                Intrinsics.reifiedOperationMarker(6, "P2");
                typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType3 = new AnyType(typeDescriptor3, typeConverterProvider);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeCache anyTypeCache4 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeCache4.getTypesMap().get(new Pair(orCreateKotlinClass4, false));
        if (anyType4 == null) {
            try {
                Result.Companion companion7 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P3");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor4 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4);
                Intrinsics.needClassReification();
                objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor4, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$18.INSTANCE));
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                objM12684constructorimpl4 = null;
            }
            TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
            if (typeDescriptor4 == null) {
                Intrinsics.reifiedOperationMarker(6, "P3");
                typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType4 = new AnyType(typeDescriptor4, typeConverterProvider);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeCache anyTypeCache5 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeCache5.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType5 == null) {
            try {
                Result.Companion companion9 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P4");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError5 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor5 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError5);
                Intrinsics.needClassReification();
                objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor5, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$19.INSTANCE));
            } catch (Throwable th5) {
                Result.Companion companion10 = Result.INSTANCE;
                objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                objM12684constructorimpl5 = null;
            }
            TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
            if (typeDescriptor5 == null) {
                Intrinsics.reifiedOperationMarker(6, "P4");
                typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType5 = new AnyType(typeDescriptor5, typeConverterProvider);
        }
        anyTypeArr[4] = anyType5;
        AnyTypeCache anyTypeCache6 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeCache6.getTypesMap().get(new Pair(orCreateKotlinClass6, false));
        if (anyType6 == null) {
            try {
                Result.Companion companion11 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P5");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError6 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor6 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError6);
                Intrinsics.needClassReification();
                objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor6, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$20.INSTANCE));
            } catch (Throwable th6) {
                Result.Companion companion12 = Result.INSTANCE;
                objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                objM12684constructorimpl6 = null;
            }
            TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
            if (typeDescriptor6 == null) {
                Intrinsics.reifiedOperationMarker(6, "P5");
                typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType6 = new AnyType(typeDescriptor6, typeConverterProvider);
        }
        anyTypeArr[5] = anyType6;
        return anyTypeArr;
    }

    public static /* synthetic */ AnyType[] toArgsArray$default(Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, TypeConverterProvider typeConverterProvider, int i, Object obj) {
        Class p0;
        Class p1;
        Class p2;
        Class p3;
        Class p4;
        Class p5;
        Class p6;
        Object objM12684constructorimpl;
        TypeConverterProvider typeConverterProvider2;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            p0 = Object.class;
        } else {
            p0 = cls;
        }
        if ((i & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P1");
            p1 = Object.class;
        } else {
            p1 = cls2;
        }
        if ((i & 4) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P2");
            p2 = Object.class;
        } else {
            p2 = cls3;
        }
        if ((i & 8) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P3");
            p3 = Object.class;
        } else {
            p3 = cls4;
        }
        if ((i & 16) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P4");
            p4 = Object.class;
        } else {
            p4 = cls5;
        }
        if ((i & 32) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P5");
            p5 = Object.class;
        } else {
            p5 = cls6;
        }
        if ((i & 64) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P6");
            p6 = Object.class;
        } else {
            p6 = cls7;
        }
        TypeConverterProvider typeConverterProvider3 = (i & 128) != 0 ? null : typeConverterProvider;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(p3, "p3");
        Intrinsics.checkNotNullParameter(p4, "p4");
        Intrinsics.checkNotNullParameter(p5, "p5");
        Intrinsics.checkNotNullParameter(p6, "p6");
        AnyType[] anyTypeArr = new AnyType[7];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType != null) {
            typeConverterProvider2 = typeConverterProvider3;
        } else {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$21.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            typeConverterProvider2 = typeConverterProvider3;
            anyType = new AnyType(typeDescriptor, typeConverterProvider2);
        }
        anyTypeArr[0] = anyType;
        AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
        if (anyType2 == null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P1");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                Intrinsics.needClassReification();
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$22.INSTANCE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                objM12684constructorimpl2 = null;
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
            if (typeDescriptor2 == null) {
                Intrinsics.reifiedOperationMarker(6, "P1");
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType2 = new AnyType(typeDescriptor2, typeConverterProvider2);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType3 == null) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P2");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor3 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                Intrinsics.needClassReification();
                objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$23.INSTANCE));
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                objM12684constructorimpl3 = null;
            }
            TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
            if (typeDescriptor3 == null) {
                Intrinsics.reifiedOperationMarker(6, "P2");
                typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType3 = new AnyType(typeDescriptor3, typeConverterProvider2);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeCache anyTypeCache4 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeCache4.getTypesMap().get(new Pair(orCreateKotlinClass4, false));
        if (anyType4 == null) {
            try {
                Result.Companion companion7 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P3");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor4 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4);
                Intrinsics.needClassReification();
                objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor4, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$24.INSTANCE));
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                objM12684constructorimpl4 = null;
            }
            TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
            if (typeDescriptor4 == null) {
                Intrinsics.reifiedOperationMarker(6, "P3");
                typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType4 = new AnyType(typeDescriptor4, typeConverterProvider2);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeCache anyTypeCache5 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeCache5.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType5 == null) {
            try {
                Result.Companion companion9 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P4");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError5 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor5 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError5);
                Intrinsics.needClassReification();
                objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor5, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$25.INSTANCE));
            } catch (Throwable th5) {
                Result.Companion companion10 = Result.INSTANCE;
                objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                objM12684constructorimpl5 = null;
            }
            TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
            if (typeDescriptor5 == null) {
                Intrinsics.reifiedOperationMarker(6, "P4");
                typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType5 = new AnyType(typeDescriptor5, typeConverterProvider2);
        }
        anyTypeArr[4] = anyType5;
        AnyTypeCache anyTypeCache6 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeCache6.getTypesMap().get(new Pair(orCreateKotlinClass6, false));
        if (anyType6 == null) {
            try {
                Result.Companion companion11 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P5");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError6 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor6 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError6);
                Intrinsics.needClassReification();
                objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor6, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$26.INSTANCE));
            } catch (Throwable th6) {
                Result.Companion companion12 = Result.INSTANCE;
                objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                objM12684constructorimpl6 = null;
            }
            TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
            if (typeDescriptor6 == null) {
                Intrinsics.reifiedOperationMarker(6, "P5");
                typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType6 = new AnyType(typeDescriptor6, typeConverterProvider2);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeCache anyTypeCache7 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeCache7.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType7 == null) {
            try {
                Result.Companion companion13 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P6");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError7 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor7 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError7);
                Intrinsics.needClassReification();
                objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor7, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$27.INSTANCE));
            } catch (Throwable th7) {
                Result.Companion companion14 = Result.INSTANCE;
                objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl7)) {
                objM12684constructorimpl7 = null;
            }
            TypeDescriptor typeDescriptor7 = (TypeDescriptor) objM12684constructorimpl7;
            if (typeDescriptor7 == null) {
                Intrinsics.reifiedOperationMarker(6, "P6");
                typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType7 = new AnyType(typeDescriptor7, typeConverterProvider2);
        }
        anyTypeArr[6] = anyType7;
        return anyTypeArr;
    }

    public static final /* synthetic */ <P0, P1, P2, P3, P4, P5, P6> AnyType[] toArgsArray(Class<P0> p0, Class<P1> p1, Class<P2> p2, Class<P3> p3, Class<P4> p4, Class<P5> p5, Class<P6> p6, TypeConverterProvider typeConverterProvider) {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(p3, "p3");
        Intrinsics.checkNotNullParameter(p4, "p4");
        Intrinsics.checkNotNullParameter(p5, "p5");
        Intrinsics.checkNotNullParameter(p6, "p6");
        AnyType[] anyTypeArr = new AnyType[7];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$21.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, typeConverterProvider);
        }
        anyTypeArr[0] = anyType;
        AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
        if (anyType2 == null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P1");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                Intrinsics.needClassReification();
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$22.INSTANCE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                objM12684constructorimpl2 = null;
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
            if (typeDescriptor2 == null) {
                Intrinsics.reifiedOperationMarker(6, "P1");
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType2 = new AnyType(typeDescriptor2, typeConverterProvider);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType3 == null) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P2");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor3 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                Intrinsics.needClassReification();
                objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$23.INSTANCE));
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                objM12684constructorimpl3 = null;
            }
            TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
            if (typeDescriptor3 == null) {
                Intrinsics.reifiedOperationMarker(6, "P2");
                typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType3 = new AnyType(typeDescriptor3, typeConverterProvider);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeCache anyTypeCache4 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeCache4.getTypesMap().get(new Pair(orCreateKotlinClass4, false));
        if (anyType4 == null) {
            try {
                Result.Companion companion7 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P3");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor4 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4);
                Intrinsics.needClassReification();
                objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor4, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$24.INSTANCE));
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                objM12684constructorimpl4 = null;
            }
            TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
            if (typeDescriptor4 == null) {
                Intrinsics.reifiedOperationMarker(6, "P3");
                typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType4 = new AnyType(typeDescriptor4, typeConverterProvider);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeCache anyTypeCache5 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeCache5.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType5 == null) {
            try {
                Result.Companion companion9 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P4");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError5 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor5 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError5);
                Intrinsics.needClassReification();
                objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor5, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$25.INSTANCE));
            } catch (Throwable th5) {
                Result.Companion companion10 = Result.INSTANCE;
                objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                objM12684constructorimpl5 = null;
            }
            TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
            if (typeDescriptor5 == null) {
                Intrinsics.reifiedOperationMarker(6, "P4");
                typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType5 = new AnyType(typeDescriptor5, typeConverterProvider);
        }
        anyTypeArr[4] = anyType5;
        AnyTypeCache anyTypeCache6 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeCache6.getTypesMap().get(new Pair(orCreateKotlinClass6, false));
        if (anyType6 == null) {
            try {
                Result.Companion companion11 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P5");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError6 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor6 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError6);
                Intrinsics.needClassReification();
                objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor6, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$26.INSTANCE));
            } catch (Throwable th6) {
                Result.Companion companion12 = Result.INSTANCE;
                objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                objM12684constructorimpl6 = null;
            }
            TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
            if (typeDescriptor6 == null) {
                Intrinsics.reifiedOperationMarker(6, "P5");
                typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType6 = new AnyType(typeDescriptor6, typeConverterProvider);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeCache anyTypeCache7 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeCache7.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType7 == null) {
            try {
                Result.Companion companion13 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P6");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError7 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor7 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError7);
                Intrinsics.needClassReification();
                objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor7, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$27.INSTANCE));
            } catch (Throwable th7) {
                Result.Companion companion14 = Result.INSTANCE;
                objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl7)) {
                objM12684constructorimpl7 = null;
            }
            TypeDescriptor typeDescriptor7 = (TypeDescriptor) objM12684constructorimpl7;
            if (typeDescriptor7 == null) {
                Intrinsics.reifiedOperationMarker(6, "P6");
                typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType7 = new AnyType(typeDescriptor7, typeConverterProvider);
        }
        anyTypeArr[6] = anyType7;
        return anyTypeArr;
    }

    public static /* synthetic */ AnyType[] toArgsArray$default(Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Class cls8, TypeConverterProvider typeConverterProvider, int i, Object obj) {
        Class p0;
        Class p1;
        Class p2;
        Class p3;
        Class p4;
        Class p5;
        Class p6;
        Class p7;
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        Object objM12684constructorimpl8;
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P0");
            p0 = Object.class;
        } else {
            p0 = cls;
        }
        if ((i & 2) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P1");
            p1 = Object.class;
        } else {
            p1 = cls2;
        }
        if ((i & 4) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P2");
            p2 = Object.class;
        } else {
            p2 = cls3;
        }
        if ((i & 8) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P3");
            p3 = Object.class;
        } else {
            p3 = cls4;
        }
        if ((i & 16) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P4");
            p4 = Object.class;
        } else {
            p4 = cls5;
        }
        if ((i & 32) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P5");
            p5 = Object.class;
        } else {
            p5 = cls6;
        }
        if ((i & 64) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P6");
            p6 = Object.class;
        } else {
            p6 = cls7;
        }
        if ((i & 128) != 0) {
            Intrinsics.reifiedOperationMarker(4, "P7");
            p7 = Object.class;
        } else {
            p7 = cls8;
        }
        TypeConverterProvider typeConverterProvider2 = (i & 256) != 0 ? null : typeConverterProvider;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(p3, "p3");
        Intrinsics.checkNotNullParameter(p4, "p4");
        Intrinsics.checkNotNullParameter(p5, "p5");
        Intrinsics.checkNotNullParameter(p6, "p6");
        Intrinsics.checkNotNullParameter(p7, "p7");
        AnyType[] anyTypeArr = new AnyType[8];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$28.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, typeConverterProvider2);
        }
        anyTypeArr[0] = anyType;
        AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
        if (anyType2 == null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P1");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                Intrinsics.needClassReification();
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$29.INSTANCE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                objM12684constructorimpl2 = null;
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
            if (typeDescriptor2 == null) {
                Intrinsics.reifiedOperationMarker(6, "P1");
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType2 = new AnyType(typeDescriptor2, typeConverterProvider2);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType3 == null) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P2");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor3 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                Intrinsics.needClassReification();
                objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$30.INSTANCE));
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                objM12684constructorimpl3 = null;
            }
            TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
            if (typeDescriptor3 == null) {
                Intrinsics.reifiedOperationMarker(6, "P2");
                typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType3 = new AnyType(typeDescriptor3, typeConverterProvider2);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeCache anyTypeCache4 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeCache4.getTypesMap().get(new Pair(orCreateKotlinClass4, false));
        if (anyType4 == null) {
            try {
                Result.Companion companion7 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P3");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor4 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4);
                Intrinsics.needClassReification();
                objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor4, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$31.INSTANCE));
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                objM12684constructorimpl4 = null;
            }
            TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
            if (typeDescriptor4 == null) {
                Intrinsics.reifiedOperationMarker(6, "P3");
                typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType4 = new AnyType(typeDescriptor4, typeConverterProvider2);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeCache anyTypeCache5 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeCache5.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType5 == null) {
            try {
                Result.Companion companion9 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P4");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError5 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor5 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError5);
                Intrinsics.needClassReification();
                objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor5, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$32.INSTANCE));
            } catch (Throwable th5) {
                Result.Companion companion10 = Result.INSTANCE;
                objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                objM12684constructorimpl5 = null;
            }
            TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
            if (typeDescriptor5 == null) {
                Intrinsics.reifiedOperationMarker(6, "P4");
                typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType5 = new AnyType(typeDescriptor5, typeConverterProvider2);
        }
        anyTypeArr[4] = anyType5;
        AnyTypeCache anyTypeCache6 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeCache6.getTypesMap().get(new Pair(orCreateKotlinClass6, false));
        if (anyType6 == null) {
            try {
                Result.Companion companion11 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P5");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError6 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor6 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError6);
                Intrinsics.needClassReification();
                objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor6, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$33.INSTANCE));
            } catch (Throwable th6) {
                Result.Companion companion12 = Result.INSTANCE;
                objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                objM12684constructorimpl6 = null;
            }
            TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
            if (typeDescriptor6 == null) {
                Intrinsics.reifiedOperationMarker(6, "P5");
                typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType6 = new AnyType(typeDescriptor6, typeConverterProvider2);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeCache anyTypeCache7 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeCache7.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType7 == null) {
            try {
                Result.Companion companion13 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P6");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError7 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor7 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError7);
                Intrinsics.needClassReification();
                objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor7, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$34.INSTANCE));
            } catch (Throwable th7) {
                Result.Companion companion14 = Result.INSTANCE;
                objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl7)) {
                objM12684constructorimpl7 = null;
            }
            TypeDescriptor typeDescriptor7 = (TypeDescriptor) objM12684constructorimpl7;
            if (typeDescriptor7 == null) {
                Intrinsics.reifiedOperationMarker(6, "P6");
                typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType7 = new AnyType(typeDescriptor7, typeConverterProvider2);
        }
        anyTypeArr[6] = anyType7;
        AnyTypeCache anyTypeCache8 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType anyType8 = anyTypeCache8.getTypesMap().get(new Pair(orCreateKotlinClass8, false));
        if (anyType8 == null) {
            try {
                Result.Companion companion15 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P7");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError8 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor8 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError8);
                Intrinsics.needClassReification();
                objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor8, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$35.INSTANCE));
            } catch (Throwable th8) {
                Result.Companion companion16 = Result.INSTANCE;
                objM12684constructorimpl8 = Result.m12684constructorimpl(ResultKt.createFailure(th8));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl8)) {
                objM12684constructorimpl8 = null;
            }
            TypeDescriptor typeDescriptor8 = (TypeDescriptor) objM12684constructorimpl8;
            if (typeDescriptor8 == null) {
                Intrinsics.reifiedOperationMarker(6, "P7");
                typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType8 = new AnyType(typeDescriptor8, typeConverterProvider2);
        }
        anyTypeArr[7] = anyType8;
        return anyTypeArr;
    }

    public static final /* synthetic */ <P0, P1, P2, P3, P4, P5, P6, P7> AnyType[] toArgsArray(Class<P0> p0, Class<P1> p1, Class<P2> p2, Class<P3> p3, Class<P4> p4, Class<P5> p5, Class<P6> p6, Class<P7> p7, TypeConverterProvider typeConverterProvider) {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        Object objM12684constructorimpl8;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p2, "p2");
        Intrinsics.checkNotNullParameter(p3, "p3");
        Intrinsics.checkNotNullParameter(p4, "p4");
        Intrinsics.checkNotNullParameter(p5, "p5");
        Intrinsics.checkNotNullParameter(p6, "p6");
        Intrinsics.checkNotNullParameter(p7, "p7");
        AnyType[] anyTypeArr = new AnyType[8];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P0");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$28.INSTANCE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, "P0");
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, typeConverterProvider);
        }
        anyTypeArr[0] = anyType;
        AnyTypeCache anyTypeCache2 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeCache2.getTypesMap().get(new Pair(orCreateKotlinClass2, false));
        if (anyType2 == null) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P1");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
                Intrinsics.needClassReification();
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$29.INSTANCE));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                objM12684constructorimpl2 = null;
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
            if (typeDescriptor2 == null) {
                Intrinsics.reifiedOperationMarker(6, "P1");
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType2 = new AnyType(typeDescriptor2, typeConverterProvider);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeCache anyTypeCache3 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeCache3.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType3 == null) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P2");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor3 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3);
                Intrinsics.needClassReification();
                objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor3, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$30.INSTANCE));
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                objM12684constructorimpl3 = null;
            }
            TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
            if (typeDescriptor3 == null) {
                Intrinsics.reifiedOperationMarker(6, "P2");
                typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType3 = new AnyType(typeDescriptor3, typeConverterProvider);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeCache anyTypeCache4 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeCache4.getTypesMap().get(new Pair(orCreateKotlinClass4, false));
        if (anyType4 == null) {
            try {
                Result.Companion companion7 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P3");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor4 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4);
                Intrinsics.needClassReification();
                objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor4, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$31.INSTANCE));
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                objM12684constructorimpl4 = null;
            }
            TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
            if (typeDescriptor4 == null) {
                Intrinsics.reifiedOperationMarker(6, "P3");
                typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType4 = new AnyType(typeDescriptor4, typeConverterProvider);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeCache anyTypeCache5 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeCache5.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType5 == null) {
            try {
                Result.Companion companion9 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P4");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError5 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor5 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError5);
                Intrinsics.needClassReification();
                objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor5, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$32.INSTANCE));
            } catch (Throwable th5) {
                Result.Companion companion10 = Result.INSTANCE;
                objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                objM12684constructorimpl5 = null;
            }
            TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
            if (typeDescriptor5 == null) {
                Intrinsics.reifiedOperationMarker(6, "P4");
                typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType5 = new AnyType(typeDescriptor5, typeConverterProvider);
        }
        anyTypeArr[4] = anyType5;
        AnyTypeCache anyTypeCache6 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeCache6.getTypesMap().get(new Pair(orCreateKotlinClass6, false));
        if (anyType6 == null) {
            try {
                Result.Companion companion11 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P5");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError6 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor6 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError6);
                Intrinsics.needClassReification();
                objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor6, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$33.INSTANCE));
            } catch (Throwable th6) {
                Result.Companion companion12 = Result.INSTANCE;
                objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                objM12684constructorimpl6 = null;
            }
            TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
            if (typeDescriptor6 == null) {
                Intrinsics.reifiedOperationMarker(6, "P5");
                typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType6 = new AnyType(typeDescriptor6, typeConverterProvider);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeCache anyTypeCache7 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeCache7.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType7 == null) {
            try {
                Result.Companion companion13 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P6");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError7 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor7 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError7);
                Intrinsics.needClassReification();
                objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor7, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$34.INSTANCE));
            } catch (Throwable th7) {
                Result.Companion companion14 = Result.INSTANCE;
                objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl7)) {
                objM12684constructorimpl7 = null;
            }
            TypeDescriptor typeDescriptor7 = (TypeDescriptor) objM12684constructorimpl7;
            if (typeDescriptor7 == null) {
                Intrinsics.reifiedOperationMarker(6, "P6");
                typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType7 = new AnyType(typeDescriptor7, typeConverterProvider);
        }
        anyTypeArr[6] = anyType7;
        AnyTypeCache anyTypeCache8 = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType anyType8 = anyTypeCache8.getTypesMap().get(new Pair(orCreateKotlinClass8, false));
        if (anyType8 == null) {
            try {
                Result.Companion companion15 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, "P7");
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError8 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor8 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError8);
                Intrinsics.needClassReification();
                objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor8, ToArgsArrayKt$toArgsArray$$inlined$toAnyType$35.INSTANCE));
            } catch (Throwable th8) {
                Result.Companion companion16 = Result.INSTANCE;
                objM12684constructorimpl8 = Result.m12684constructorimpl(ResultKt.createFailure(th8));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl8)) {
                objM12684constructorimpl8 = null;
            }
            TypeDescriptor typeDescriptor8 = (TypeDescriptor) objM12684constructorimpl8;
            if (typeDescriptor8 == null) {
                Intrinsics.reifiedOperationMarker(6, "P7");
                typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType8 = new AnyType(typeDescriptor8, typeConverterProvider);
        }
        anyTypeArr[7] = anyType8;
        return anyTypeArr;
    }
}
