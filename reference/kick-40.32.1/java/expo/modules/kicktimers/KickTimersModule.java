package expo.modules.kicktimers;

import androidx.tracing.Trace;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeKt;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import io.github.expo.pika.IntrospectionOfKt;
import io.github.expo.pika.IsIntrospectableKt;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.TypeDescriptorOfKt;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
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
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: KickTimersModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lexpo/modules/kicktimers/KickTimersModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "intervals", "", "", "Lkotlinx/coroutines/Job;", "getIntervals", "()Ljava/util/Map;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "kick-timers_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KickTimersModule extends Module {
    private final Map<String, Job> intervals = new LinkedHashMap();

    public final Map<String, Job> getIntervals() {
        return this.intervals;
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError;
        PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError2;
        KickTimersModule kickTimersModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (kickTimersModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(kickTimersModule);
            moduleDefinitionBuilder.Name("KickTimers");
            moduleDefinitionBuilder.Events("onInterval");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError), new Function0<KType>() { // from class: expo.modules.kicktimers.KickTimersModule$definition$lambda$0$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType2 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2), new Function0<KType>() { // from class: expo.modules.kicktimers.KickTimersModule$definition$lambda$0$$inlined$Function$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Integer.TYPE);
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
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
                }
                anyType2 = new AnyType(typeDescriptor2, converters);
            }
            anyTypeArr[1] = anyType2;
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(Boolean.class);
            if (returnType == null) {
                JSTypeConverter<?> directConverter = ReturnTypeKt.getDirectConverter(Boolean.class);
                if (directConverter == null) {
                    Intrinsics.reifiedOperationMarker(6, "R");
                    boolean zThrowNonReifiedIsIntrospectableError = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
                    if (zThrowNonReifiedIsIntrospectableError) {
                        Intrinsics.reifiedOperationMarker(6, "R");
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError2 = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
                        PIntrospectionData<Object> pIntrospectionData = pIntrospectionDataThrowNonReifiedIntrospectionOfError2;
                    } else {
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError2 = null;
                    }
                    directConverter = ReturnTypeKt.getIndirectConverter(Boolean.class, pIntrospectionDataThrowNonReifiedIntrospectionOfError2);
                }
                ReturnType returnType2 = new ReturnType(directConverter);
                returnTypeProvider.getTypes().put(Boolean.class, returnType2);
                returnType = returnType2;
            }
            SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("setInterval", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kicktimers.KickTimersModule$definition$lambda$0$$inlined$Function$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Job job;
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    int iIntValue = ((Number) objArr[1]).intValue();
                    String str = (String) obj;
                    if (this.this$0.getIntervals().containsKey(str) && (job = this.this$0.getIntervals().get(str)) != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    this.this$0.getIntervals().put(str, BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new KickTimersModule$definition$1$1$1(iIntValue, this.this$0, str, null), 3, null));
                    Job job2 = this.this$0.getIntervals().get(str);
                    if (job2 != null) {
                        return Boolean.valueOf(job2.start());
                    }
                    return null;
                }
            });
            moduleDefinitionBuilder2.getSyncFunctions().put("setInterval", syncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            TypeConverterProvider converters2 = moduleDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[1];
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType3 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3), new Function0<KType>() { // from class: expo.modules.kicktimers.KickTimersModule$definition$lambda$0$$inlined$Function$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType3 = new AnyType(typeDescriptor3, converters2);
            }
            anyTypeArr2[0] = anyType3;
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType3 = returnTypeProvider2.getTypes().get(Unit.class);
            if (returnType3 == null) {
                JSTypeConverter<?> directConverter2 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter2 == null) {
                    Intrinsics.reifiedOperationMarker(6, "R");
                    boolean zThrowNonReifiedIsIntrospectableError2 = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
                    if (zThrowNonReifiedIsIntrospectableError2) {
                        Intrinsics.reifiedOperationMarker(6, "R");
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
                        PIntrospectionData<Object> pIntrospectionData2 = pIntrospectionDataThrowNonReifiedIntrospectionOfError;
                    } else {
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError = null;
                    }
                    directConverter2 = ReturnTypeKt.getIndirectConverter(Unit.class, pIntrospectionDataThrowNonReifiedIntrospectionOfError);
                }
                ReturnType returnType4 = new ReturnType(directConverter2);
                returnTypeProvider2.getTypes().put(Unit.class, returnType4);
                returnType3 = returnType4;
            }
            SyncFunctionComponent syncFunctionComponent2 = new SyncFunctionComponent("clearInterval", anyTypeArr2, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.kicktimers.KickTimersModule$definition$lambda$0$$inlined$Function$5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    String str = (String) objArr[0];
                    if (this.this$0.getIntervals().containsKey(str)) {
                        Job job = this.this$0.getIntervals().get(str);
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        this.this$0.getIntervals().remove(str);
                    }
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder3.getSyncFunctions().put("clearInterval", syncFunctionComponent2);
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th4) {
            Trace.endSection();
            throw th4;
        }
    }
}
