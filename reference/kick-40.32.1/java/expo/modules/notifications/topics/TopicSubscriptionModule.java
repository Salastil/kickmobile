package expo.modules.notifications.topics;

import androidx.tracing.Trace;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import io.github.expo.pika.PTypeDescriptorRegistry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: TopicSubscriptionModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lexpo/modules/notifications/topics/TopicSubscriptionModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TopicSubscriptionModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        TopicSubscriptionModule topicSubscriptionModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (topicSubscriptionModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(topicSubscriptionModule);
            moduleDefinitionBuilder.Name("ExpoTopicSubscriptionModule");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr = new AnyType[1];
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            Object obj = null;
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.notifications.topics.TopicSubscriptionModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$1
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
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("subscribeToTopicAsync", anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.topics.TopicSubscriptionModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    final String str = (String) objArr[0];
                    FirebaseMessaging.getInstance().subscribeToTopic(str).addOnCompleteListener(new OnCompleteListener() { // from class: expo.modules.notifications.topics.TopicSubscriptionModule$definition$1$1$1
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public final void onComplete(Task<Void> task) {
                            String message;
                            Intrinsics.checkNotNullParameter(task, "task");
                            if (task.isSuccessful()) {
                                promise.resolve((Object) null);
                                return;
                            }
                            Exception exception = task.getException();
                            Promise promise2 = promise;
                            String str2 = str;
                            if (exception == null || (message = exception.getMessage()) == null) {
                                message = "unknown";
                            }
                            promise2.reject("E_TOPIC_SUBSCRIBE_FAILED", "Subscribing to the topic '" + str2 + "' failed: " + message, exception);
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder2.getAsyncFunctions().put("subscribeToTopicAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            TypeConverterProvider converters2 = moduleDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[1];
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.notifications.topics.TopicSubscriptionModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
                }
                if (!Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                    obj = objM12684constructorimpl2;
                }
                TypeDescriptor typeDescriptor2 = (TypeDescriptor) obj;
                if (typeDescriptor2 == null) {
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType2 = new AnyType(typeDescriptor2, converters2);
            }
            anyTypeArr2[0] = anyType2;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("unsubscribeFromTopicAsync", anyTypeArr2, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.topics.TopicSubscriptionModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$4
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    final String str = (String) objArr[0];
                    FirebaseMessaging.getInstance().unsubscribeFromTopic(str).addOnCompleteListener(new OnCompleteListener() { // from class: expo.modules.notifications.topics.TopicSubscriptionModule$definition$1$2$1
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public final void onComplete(Task<Void> task) {
                            String message;
                            Intrinsics.checkNotNullParameter(task, "task");
                            if (task.isSuccessful()) {
                                promise.resolve((Object) null);
                                return;
                            }
                            Exception exception = task.getException();
                            Promise promise2 = promise;
                            String str2 = str;
                            if (exception == null || (message = exception.getMessage()) == null) {
                                message = "unknown";
                            }
                            promise2.reject("E_TOPIC_UNSUBSCRIBE_FAILED", "Unsubscribing from the topic '" + str2 + "' failed: " + message, exception);
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder3.getAsyncFunctions().put("unsubscribeFromTopicAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th3) {
            Trace.endSection();
            throw th3;
        }
    }
}
