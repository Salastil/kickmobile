package expo.modules.kotlin.modules;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.exception.MissingTypeConverter;
import expo.modules.kotlin.types.NullableTypeConverter;
import expo.modules.kotlin.types.TypeConverter;
import expo.modules.kotlin.types.TypeConverterComponent;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.RawTypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor$params$1$1;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.TypeDescriptorOfKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ModuleConvertersBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0006\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u00012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000fH\u0086\bJ_\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0006\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u0001\"\n\b\u0001\u0010\u0010\u0018\u0001*\u00020\u00012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f2#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u0011H\u0010¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u0002H\r0\u0012H\u0086\bø\u0001\u0000J\u0006\u0010\u0016\u001a\u00020\u0017R.\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"Lexpo/modules/kotlin/modules/ModuleConvertersBuilder;", "", "<init>", "()V", "convertersComponent", "", "Lexpo/modules/kotlin/types/TypeConverterComponent;", "getConvertersComponent$annotations", "getConvertersComponent", "()Ljava/util/List;", "setConvertersComponent", "(Ljava/util/List;)V", "TypeConverter", ExifInterface.GPS_DIRECTION_TRUE, "classifier", "Lkotlin/reflect/KClass;", "P0", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "p0", "buildTypeConverterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ModuleConvertersBuilder {
    public static final int $stable = 8;
    private List<TypeConverterComponent<?>> convertersComponent = new ArrayList();

    public static /* synthetic */ void getConvertersComponent$annotations() {
    }

    public final List<TypeConverterComponent<?>> getConvertersComponent() {
        return this.convertersComponent;
    }

    public final void setConvertersComponent(List<TypeConverterComponent<?>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.convertersComponent = list;
    }

    public static /* synthetic */ TypeConverterComponent TypeConverter$default(ModuleConvertersBuilder moduleConvertersBuilder, KClass classifier, int i, Object obj) {
        Object objM12684constructorimpl;
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            classifier = Reflection.getOrCreateKotlinClass(Object.class);
        }
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
            RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
            Intrinsics.needClassReification();
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ModuleConvertersBuilder$TypeConverter$$inlined$typeDescriptorOf$1.INSTANCE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
        }
        TypeConverterComponent<?> typeConverterComponent = new TypeConverterComponent<>(typeDescriptor);
        moduleConvertersBuilder.getConvertersComponent().add(typeConverterComponent);
        return typeConverterComponent;
    }

    public static /* synthetic */ TypeConverterComponent TypeConverter$default(ModuleConvertersBuilder moduleConvertersBuilder, KClass classifier, Function1 body, int i, Object obj) {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            classifier = Reflection.getOrCreateKotlinClass(Object.class);
        }
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(body, "body");
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
            RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
            Intrinsics.needClassReification();
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ModuleConvertersBuilder$TypeConverter$$inlined$TypeConverter$1.INSTANCE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
        }
        TypeConverterComponent<?> typeConverterComponent = new TypeConverterComponent<>(typeDescriptor);
        moduleConvertersBuilder.getConvertersComponent().add(typeConverterComponent);
        Map<TypeDescriptor, Function1<Object, ?>> converters = typeConverterComponent.getDesireTypeConverter().getValue().getConverters();
        try {
            Result.Companion companion3 = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(6, "P0");
            PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
            RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
            Intrinsics.needClassReification();
            Intrinsics.needClassReification();
            objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ModuleConvertersBuilder$TypeConverter$$inlined$apply$lambda$1.INSTANCE));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
            objM12684constructorimpl2 = null;
        }
        TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
        if (typeDescriptor2 == null) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
        }
        converters.put(typeDescriptor2, new ModuleConvertersBuilder$TypeConverter$lambda$0$$inlined$from$2(body));
        return typeConverterComponent;
    }

    public final TypeConverterProvider buildTypeConverterProvider() {
        List<TypeConverterComponent<?>> list = this.convertersComponent;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair<TypeDescriptor, TypeConverter<?>> pairBuild = ((TypeConverterComponent) it.next()).build();
            if (pairBuild != null) {
                arrayList.add(pairBuild);
            }
        }
        final ArrayList arrayList2 = arrayList;
        return new TypeConverterProvider() { // from class: expo.modules.kotlin.modules.ModuleConvertersBuilder.buildTypeConverterProvider.1
            @Override // expo.modules.kotlin.types.TypeConverterProvider
            public TypeConverter<?> obtainTypeConverter(TypeDescriptor typeDescriptor) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
                TypeConverter<?> typeConverterFindNonNullableTypeConverter = findNonNullableTypeConverter(typeDescriptor);
                if (typeConverterFindNonNullableTypeConverter != null) {
                    return typeDescriptor.getTypeInfo().isNullable() ? new NullableTypeConverter(typeConverterFindNonNullableTypeConverter) : typeConverterFindNonNullableTypeConverter;
                }
                throw new MissingTypeConverter(typeDescriptor);
            }

            private final TypeConverter<?> findNonNullableTypeConverter(TypeDescriptor typeDescriptor) {
                Object next;
                ArrayList arrayListEmptyList;
                ArrayList arrayListEmptyList2;
                Iterator<T> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    TypeDescriptor typeDescriptor2 = (TypeDescriptor) ((Pair) next).component1();
                    if (Intrinsics.areEqual(typeDescriptor2.getTypeInfo().getJClass(), typeDescriptor.getTypeInfo().getJClass())) {
                        RawTypeDescriptor typeInfo = typeDescriptor2.getTypeInfo();
                        int i = 0;
                        if (typeInfo instanceof RawTypeDescriptor.Simple) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        } else if (typeInfo instanceof RawTypeDescriptor.Parameterized) {
                            List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) typeDescriptor2.getTypeInfo()).getParams();
                            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
                            int i2 = 0;
                            for (Object obj : params) {
                                int i3 = i2 + 1;
                                if (i2 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                arrayList3.add(new TypeDescriptor((RawTypeDescriptor) obj, new TypeDescriptor$params$1$1(typeDescriptor2, i2)));
                                i2 = i3;
                            }
                            arrayListEmptyList = arrayList3;
                        } else {
                            if (!Intrinsics.areEqual(typeInfo, RawTypeDescriptor.Star.INSTANCE)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        RawTypeDescriptor typeInfo2 = typeDescriptor.getTypeInfo();
                        if (typeInfo2 instanceof RawTypeDescriptor.Simple) {
                            arrayListEmptyList2 = CollectionsKt.emptyList();
                        } else if (typeInfo2 instanceof RawTypeDescriptor.Parameterized) {
                            List<RawTypeDescriptor> params2 = ((RawTypeDescriptor.Parameterized) typeDescriptor.getTypeInfo()).getParams();
                            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(params2, 10));
                            for (Object obj2 : params2) {
                                int i4 = i + 1;
                                if (i < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                arrayList4.add(new TypeDescriptor((RawTypeDescriptor) obj2, new TypeDescriptor$params$1$1(typeDescriptor, i)));
                                i = i4;
                            }
                            arrayListEmptyList2 = arrayList4;
                        } else {
                            if (!Intrinsics.areEqual(typeInfo2, RawTypeDescriptor.Star.INSTANCE)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            arrayListEmptyList2 = CollectionsKt.emptyList();
                        }
                        if (Intrinsics.areEqual(arrayListEmptyList, arrayListEmptyList2)) {
                            break;
                        }
                    }
                }
                Pair pair = (Pair) next;
                if (pair != null) {
                    return (TypeConverter) pair.getSecond();
                }
                return null;
            }
        };
    }

    public final /* synthetic */ <T> TypeConverterComponent<T> TypeConverter(KClass<T> classifier) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
            RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
            Intrinsics.needClassReification();
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ModuleConvertersBuilder$TypeConverter$$inlined$typeDescriptorOf$1.INSTANCE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
        }
        TypeConverterComponent<T> typeConverterComponent = new TypeConverterComponent<>(typeDescriptor);
        getConvertersComponent().add(typeConverterComponent);
        return typeConverterComponent;
    }

    public final /* synthetic */ <T, P0> TypeConverterComponent<T> TypeConverter(KClass<T> classifier, Function1<? super P0, ? extends T> body) {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(body, "body");
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
            RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
            Intrinsics.needClassReification();
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, ModuleConvertersBuilder$TypeConverter$$inlined$TypeConverter$1.INSTANCE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
        }
        TypeConverterComponent<T> typeConverterComponent = new TypeConverterComponent<>(typeDescriptor);
        getConvertersComponent().add(typeConverterComponent);
        Map<TypeDescriptor, Function1<Object, T>> converters = typeConverterComponent.getDesireTypeConverter().getValue().getConverters();
        try {
            Result.Companion companion3 = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(6, "P0");
            PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
            RawTypeDescriptor rawTypeDescriptor2 = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2);
            Intrinsics.needClassReification();
            Intrinsics.needClassReification();
            objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor2, ModuleConvertersBuilder$TypeConverter$$inlined$apply$lambda$1.INSTANCE));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
            objM12684constructorimpl2 = null;
        }
        TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
        if (typeDescriptor2 == null) {
            Intrinsics.reifiedOperationMarker(6, "P0");
            typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(null);
        }
        converters.put(typeDescriptor2, new ModuleConvertersBuilder$TypeConverter$lambda$0$$inlined$from$2(body));
        return typeConverterComponent;
    }
}
