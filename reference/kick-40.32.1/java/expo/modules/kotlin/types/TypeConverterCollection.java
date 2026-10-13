package expo.modules.kotlin.types;

import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.Dynamic;
import com.google.firebase.messaging.Constants;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.MissingTypeConverter;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.types.descriptors.RawTypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.TypeDescriptorOfKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: TypeConverterCollection.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J?\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0006\b\u0001\u0010\u0014\u0018\u00012#\b\u0004\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u0011H\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00028\u00000\fH\u0086\bø\u0001\u0000J%\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR>\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00028\u00000\f0\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, d2 = {"Lexpo/modules/kotlin/types/TypeConverterCollection;", "Type", "", "Lexpo/modules/kotlin/types/NonNullableTypeConverter;", "type", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "<init>", "(Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;)V", "getType", "()Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "converters", "", "Lkotlin/Function1;", "getConverters$annotations", "()V", "getConverters", "()Ljava/util/Map;", "setConverters", "(Ljava/util/Map;)V", Constants.MessagePayloadKeys.FROM, "P0", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lkotlin/ParameterName;", "name", "p0", "convertNonNullable", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "", "(Ljava/lang/Object;Lexpo/modules/kotlin/types/ConverterContext;Z)Ljava/lang/Object;", "isTrivial", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TypeConverterCollection<Type> extends NonNullableTypeConverter<Type> {
    public static final int $stable = 8;
    private Map<TypeDescriptor, Function1<Object, Type>> converters;
    private final TypeDescriptor type;

    public static /* synthetic */ void getConverters$annotations() {
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public TypeConverterCollection(TypeDescriptor type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.converters = new LinkedHashMap();
    }

    public final TypeDescriptor getType() {
        return this.type;
    }

    public final Map<TypeDescriptor, Function1<Object, Type>> getConverters() {
        return this.converters;
    }

    public final void setConverters(Map<TypeDescriptor, Function1<Object, Type>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.converters = map;
    }

    public final /* synthetic */ <P0> TypeConverterCollection<Type> from(Function1<? super P0, ? extends Type> body) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(body, "body");
        Map<TypeDescriptor, Function1<Object, Type>> converters = getConverters();
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(6, "P0");
            PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
            RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
            Intrinsics.needClassReification();
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, new Function0<KType>() { // from class: expo.modules.kotlin.types.TypeConverterCollection$from$$inlined$typeDescriptorOf$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
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
            Intrinsics.reifiedOperationMarker(6, "P0");
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
        }
        converters.put(typeDescriptor, new AnonymousClass1(body));
        return this;
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.types.TypeConverterCollection$from$1, reason: invalid class name */
    /* JADX INFO: compiled from: TypeConverterCollection.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass1 implements Function1<Object, Type> {
        final /* synthetic */ Function1<P0, Type> $body;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super P0, ? extends Type> function1) {
            this.$body = function1;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function1
        public final Type invoke(Object obj) {
            return this.$body.invoke((P0) obj);
        }
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter
    public Type convertNonNullable(Object value, ConverterContext context, boolean forceConversion) throws MissingTypeConverter {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        Map<TypeDescriptor, Function1<Object, Type>> map = this.converters;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<TypeDescriptor, Function1<Object, Type>> entry : map.entrySet()) {
            arrayList.add(TuplesKt.to(entry.getKey(), entry.getValue()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (ClassExtensionsKt.toBoxedIfPrimitive(((TypeDescriptor) ((Pair) obj).component1()).getTypeInfo().getJClass()).isInstance(value)) {
                arrayList2.add(obj);
            }
        }
        ArrayList<Pair> arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            if (value instanceof Dynamic) {
                return convertNonNullable(new ExpoDynamic((Dynamic) value), context, forceConversion);
            }
            throw new MissingTypeConverter(this.type);
        }
        if (arrayList3.size() > 1) {
            ArrayList arrayList4 = new ArrayList();
            for (Pair pair : arrayList3) {
                try {
                    return (Type) ((Function1) pair.component2()).invoke(TypeConverterProviderImpl.INSTANCE.obtainTypeConverter((TypeDescriptor) pair.component1()).convert(value, context, true));
                } catch (Exception e) {
                    Exception exc = e;
                    if (exc instanceof CodedException) {
                        unexpectedException = (CodedException) exc;
                    } else if (exc instanceof expo.modules.core.errors.CodedException) {
                        expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) exc;
                        unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
                    } else {
                        unexpectedException = new UnexpectedException(exc);
                    }
                    arrayList4.add(unexpectedException);
                }
            }
            throw new TypeCastException("Cannot cast '" + value + "' to '" + this.type + "'. Tried: " + CollectionsKt.joinToString$default(arrayList3, null, null, null, 0, null, new Function1() { // from class: expo.modules.kotlin.types.TypeConverterCollection$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TypeConverterCollection.convertNonNullable$lambda$2((Pair) obj2);
                }
            }, 31, null) + ". Errors: " + CollectionsKt.joinToString$default(arrayList4, null, null, null, 0, null, new Function1() { // from class: expo.modules.kotlin.types.TypeConverterCollection$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TypeConverterCollection.convertNonNullable$lambda$3((CodedException) obj2);
                }
            }, 31, null));
        }
        Pair pair2 = (Pair) CollectionsKt.first((List) arrayList3);
        TypeDescriptor typeDescriptor = (TypeDescriptor) pair2.component1();
        Function1 function1 = (Function1) pair2.component2();
        TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(typeDescriptor);
        if (typeConverterObtainTypeConverter.isTrivial() && !forceConversion) {
            return (Type) function1.invoke(value);
        }
        return (Type) function1.invoke(typeConverterObtainTypeConverter.convert(value, context, forceConversion));
    }

    static final CharSequence convertNonNullable$lambda$2(Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ((TypeDescriptor) it.getFirst()).toString();
    }

    static final CharSequence convertNonNullable$lambda$3(CodedException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String message = it.getMessage();
        return message != null ? message : "";
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    /* JADX INFO: renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        ExpectedType.Companion companion = ExpectedType.INSTANCE;
        Set<TypeDescriptor> setKeySet = this.converters.keySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
        Iterator<T> it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList.add(ExpectedType.INSTANCE.fromTypeDescriptor((TypeDescriptor) it.next()));
        }
        ExpectedType[] expectedTypeArr = (ExpectedType[]) arrayList.toArray(new ExpectedType[0]);
        return companion.merge((ExpectedType[]) Arrays.copyOf(expectedTypeArr, expectedTypeArr.length));
    }
}
