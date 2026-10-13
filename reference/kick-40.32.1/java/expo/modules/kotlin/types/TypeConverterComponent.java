package expo.modules.kotlin.types;

import com.google.firebase.messaging.Constants;
import expo.modules.kotlin.types.descriptors.RawTypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.TypeDescriptorOfKt;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: TypeConverterCollection.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006JC\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\n\b\u0001\u0010\u000f\u0018\u0001*\u00020\u00022#\b\u0004\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\bø\u0001\u0000J\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0018\u00010\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"Lexpo/modules/kotlin/types/TypeConverterComponent;", "Type", "", "desireType", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "<init>", "(Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;)V", "getDesireType", "()Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "desireTypeConverter", "Lkotlin/Lazy;", "Lexpo/modules/kotlin/types/TypeConverterCollection;", "getDesireTypeConverter", "()Lkotlin/Lazy;", Constants.MessagePayloadKeys.FROM, "P0", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "p0", "build", "Lkotlin/Pair;", "Lexpo/modules/kotlin/types/TypeConverter;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TypeConverterComponent<Type> {
    public static final int $stable = 8;
    private final TypeDescriptor desireType;
    private final Lazy<TypeConverterCollection<Type>> desireTypeConverter;

    public TypeConverterComponent(TypeDescriptor desireType) {
        Intrinsics.checkNotNullParameter(desireType, "desireType");
        this.desireType = desireType;
        this.desireTypeConverter = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.types.TypeConverterComponent$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TypeConverterComponent.desireTypeConverter$lambda$0(this.f$0);
            }
        });
    }

    public final TypeDescriptor getDesireType() {
        return this.desireType;
    }

    static final TypeConverterCollection desireTypeConverter$lambda$0(TypeConverterComponent typeConverterComponent) {
        return new TypeConverterCollection(typeConverterComponent.desireType);
    }

    public final Lazy<TypeConverterCollection<Type>> getDesireTypeConverter() {
        return this.desireTypeConverter;
    }

    public final /* synthetic */ <P0> TypeConverterComponent<Type> from(Function1<? super P0, ? extends Type> body) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(body, "body");
        Map<TypeDescriptor, Function1<Object, Type>> converters = getDesireTypeConverter().getValue().getConverters();
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(6, "P0");
            PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
            RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
            Intrinsics.needClassReification();
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, new Function0<KType>() { // from class: expo.modules.kotlin.types.TypeConverterComponent$from$$inlined$from$1
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
        converters.put(typeDescriptor, new TypeConverterCollection.AnonymousClass1(body));
        return this;
    }

    public final Pair<TypeDescriptor, TypeConverter<?>> build() {
        if (!this.desireTypeConverter.isInitialized()) {
            return null;
        }
        TypeConverterCollection typeConverterCollection = new TypeConverterCollection(this.desireType);
        typeConverterCollection.setConverters(this.desireTypeConverter.getValue().getConverters());
        return TuplesKt.to(this.desireType, typeConverterCollection);
    }
}
