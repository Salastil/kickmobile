package expo.modules.kotlin.traits;

import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import expo.modules.kotlin.sharedobjects.SharedRef;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.RawTypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.TypeDescriptorOfKt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: SavableTrait.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
public final class SavableTrait$Companion$create$1 implements Function1<AppContext, ObjectDefinitionData> {
    public static final SavableTrait$Companion$create$1 INSTANCE = new SavableTrait$Companion$create$1();

    @Override // kotlin.jvm.functions.Function1
    public final ObjectDefinitionData invoke(AppContext appContext) {
        Object objM12684constructorimpl;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Object objM12684constructorimpl2;
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        SavableTrait.Companion companion = SavableTrait.INSTANCE;
        final WeakReference weakReferenceWeak = UtilsKt.weak(appContext);
        ObjectDefinitionBuilder objectDefinitionBuilder = new ObjectDefinitionBuilder(null, 1, null);
        TypeConverterProvider converters = objectDefinitionBuilder.getConverters();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        AnyType[] anyTypeArr = new AnyType[2];
        AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            try {
                Result.Companion companion2 = Result.INSTANCE;
                Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
                Intrinsics.needClassReification();
                objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, new Function0<KType>() { // from class: expo.modules.kotlin.traits.SavableTrait$Companion$create$1$invoke$$inlined$createImplementation$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                        return null;
                    }
                }));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                objM12684constructorimpl2 = null;
            }
            TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl2;
            if (typeDescriptor == null) {
                Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
            }
            anyType = new AnyType(typeDescriptor, converters);
        }
        anyTypeArr[0] = anyType;
        AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SavableTrait.Companion.SavableBitmapOptions.class), false));
        if (anyType2 == null) {
            try {
                Result.Companion companion4 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SavableTrait.Companion.SavableBitmapOptions.class, false, SavableTrait.Companion.SavableBitmapOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.kotlin.traits.SavableTrait$Companion$create$1$invoke$$inlined$createImplementation$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(SavableTrait.Companion.SavableBitmapOptions.class);
                    }
                }));
            } catch (Throwable th2) {
                Result.Companion companion5 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th2));
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
            if (typeDescriptor2 == null) {
                typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SavableTrait.Companion.SavableBitmapOptions.class));
            }
            anyType2 = new AnyType(typeDescriptor2, converters);
        }
        anyTypeArr[1] = anyType2;
        Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.kotlin.traits.SavableTrait$Companion$create$1$invoke$$inlined$createImplementation$3
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object[] objArr) throws IOException, Exceptions.AppContextLost {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Object obj = objArr[0];
                Object obj2 = objArr[1];
                AppContext appContext2 = (AppContext) weakReferenceWeak.get();
                if (appContext2 == null) {
                    throw new Exceptions.AppContextLost();
                }
                File file = new File(appContext2.getCacheDirectory(), UUID.randomUUID().toString());
                file.createNewFile();
                SharedRef sharedRef = (SharedRef) obj;
                sharedRef.getAppContext();
                ((Bitmap) sharedRef.getRef()).compress(Bitmap.CompressFormat.PNG, ((SavableTrait.Companion.SavableBitmapOptions) obj2).getCompression(), new FileOutputStream(file));
                return Unit.INSTANCE;
            }
        };
        if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
            if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                        if (Intrinsics.areEqual(Unit.class, String.class)) {
                            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("saveAsync", anyTypeArr, function1);
                        } else {
                            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("saveAsync", anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("saveAsync", anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("saveAsync", anyTypeArr, function1);
                }
            } else {
                untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("saveAsync", anyTypeArr, function1);
            }
        } else {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("saveAsync", anyTypeArr, function1);
        }
        objectDefinitionBuilder.getAsyncFunctions().put("saveAsync", untypedAsyncFunctionComponent);
        return objectDefinitionBuilder.buildObject();
    }
}
