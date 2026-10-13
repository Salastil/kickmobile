package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import expo.modules.kotlin.exception.MissingTypeConverter;
import expo.modules.kotlin.types.ConverterContext;
import expo.modules.kotlin.types.JSTypeConverterProvider;
import expo.modules.kotlin.types.TypeConverter;
import expo.modules.kotlin.types.TypeConverterProviderImpl;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: JavaScriptFunction.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0003B\u0011\b\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J2\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0082 ¢\u0006\u0002\u0010\u0019J:\u0010\u0012\u001a\u00028\u00002\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0016\"\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\u0002¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0004J\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lexpo/modules/kotlin/jni/JavaScriptFunction;", "ReturnType", "", "Lexpo/modules/kotlin/jni/Destructible;", "mHybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "returnType", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "getReturnType$annotations", "()V", "getReturnType", "()Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "setReturnType", "(Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;)V", "isValid", "", "invoke", "thisValue", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "args", "", "expectedReturnType", "Lexpo/modules/kotlin/jni/ExpectedType;", "(Lexpo/modules/kotlin/jni/JavaScriptObject;[Ljava/lang/Object;Lexpo/modules/kotlin/jni/ExpectedType;)Ljava/lang/Object;", "converterContext", "Lexpo/modules/kotlin/types/ConverterContext;", "([Ljava/lang/Object;Lexpo/modules/kotlin/jni/JavaScriptObject;Lexpo/modules/kotlin/types/ConverterContext;)Ljava/lang/Object;", "finalize", "", "getHybridDataForJNIDeallocator", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JavaScriptFunction<ReturnType> implements Destructible {
    public static final int $stable = 8;
    private final HybridData mHybridData;
    private TypeDescriptor returnType;

    public static /* synthetic */ void getReturnType$annotations() {
    }

    private final native Object invoke(JavaScriptObject thisValue, Object[] args, ExpectedType expectedReturnType);

    private JavaScriptFunction(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public final TypeDescriptor getReturnType() {
        return this.returnType;
    }

    public final void setReturnType(TypeDescriptor typeDescriptor) {
        this.returnType = typeDescriptor;
    }

    public final boolean isValid() {
        return this.mHybridData.isValid();
    }

    public static /* synthetic */ Object invoke$default(JavaScriptFunction javaScriptFunction, Object[] objArr, JavaScriptObject javaScriptObject, ConverterContext converterContext, int i, Object obj) {
        if ((i & 2) != 0) {
            javaScriptObject = null;
        }
        return javaScriptFunction.invoke(objArr, javaScriptObject, converterContext);
    }

    protected final void finalize() throws Throwable {
        this.mHybridData.resetNative();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    /* JADX INFO: renamed from: getHybridDataForJNIDeallocator, reason: from getter */
    public HybridData getMHybridData() {
        return this.mHybridData;
    }

    public final ReturnType invoke(Object[] args, JavaScriptObject thisValue, ConverterContext converterContext) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(converterContext, "converterContext");
        ArrayList arrayList = new ArrayList(args.length);
        for (Object obj : args) {
            arrayList.add(JSTypeConverterProvider.convertToJSValue$default(JSTypeConverterProvider.INSTANCE, obj, null, false, 6, null));
        }
        Object[] array = arrayList.toArray(new Object[0]);
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        TypeDescriptor typeDescriptor = this.returnType;
        if (typeDescriptor == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Unit.class, false, null)), new Function0<KType>() { // from class: expo.modules.kotlin.jni.JavaScriptFunction$invoke$$inlined$typeDescriptorOf$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Unit.class);
                    }
                }));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            TypeDescriptor typeDescriptor2 = (TypeDescriptor) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
            typeDescriptor = typeDescriptor2 != null ? typeDescriptor2 : TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Unit.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        return (ReturnType) typeConverterObtainTypeConverter.convert(invoke(thisValue, array, typeConverterObtainTypeConverter.get$cppRequireType()), converterContext, false);
    }
}
