package expo.modules.haptics;

import android.app.Activity;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import com.facebook.react.ReactRootView$$ExternalSyntheticApiModelOutline0;
import expo.modules.haptics.arguments.HapticType;
import expo.modules.haptics.arguments.HapticsTypesKt;
import expo.modules.haptics.arguments.ImpactStyle;
import expo.modules.haptics.arguments.NotificationType;
import expo.modules.haptics.arguments.VibrationType;
import io.github.expo.modules.v2.Module;
import io.github.expo.modules.v2.args.Trampoline;
import io.github.expo.modules.v2.args.TrampolineArguments;
import io.github.expo.modules.v2.async.Promise;
import io.github.expo.modules.v2.modules.ModuleBuilder;
import io.github.expo.modules.v2.react.ReactContextExtensionsKt;
import io.github.expo.modules.v2.types.AnyType;
import io.github.expo.modules.v2.types.TypeDescriptor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: HapticsModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0087@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0087@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\tH\u0087@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0014H\u0087@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lexpo/modules/haptics/HapticsModule;", "Lio/github/expo/modules/v2/Module;", "<init>", "()V", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "notificationAsync", "", "type", "Lexpo/modules/haptics/arguments/NotificationType;", "(Lexpo/modules/haptics/arguments/NotificationType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impactAsync", "style", "Lexpo/modules/haptics/arguments/ImpactStyle;", "(Lexpo/modules/haptics/arguments/ImpactStyle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectionAsync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performHapticsAsync", "Lexpo/modules/haptics/arguments/HapticType;", "(Lexpo/modules/haptics/arguments/HapticType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vibrate", "Lexpo/modules/haptics/arguments/VibrationType;", "(Lexpo/modules/haptics/arguments/VibrationType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-haptics_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HapticsModule extends Module {
    private static final TypeDescriptor type$0 = new TypeDescriptor.Simple(NotificationType.class, false);
    private static final TypeDescriptor type$1 = new TypeDescriptor.Simple(Unit.class, false);
    private static final TypeDescriptor type$2 = new TypeDescriptor.Simple(ImpactStyle.class, false);
    private static final TypeDescriptor type$3 = new TypeDescriptor.Simple(HapticType.class, false);

    @Override // io.github.expo.modules.v2.Module
    public final String define$ExpoModulesV2(ModuleBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.function("notificationAsync", new AnyType[]{new AnyType(new TypeDescriptor.Simple(NotificationType.class, false), true)}, new AnyType(new TypeDescriptor.Simple(Unit.class, false), false), "notificationAsync__trampoline$ExpoModulesV2", true);
        builder.function("impactAsync", new AnyType[]{new AnyType(new TypeDescriptor.Simple(ImpactStyle.class, false), true)}, new AnyType(new TypeDescriptor.Simple(Unit.class, false), false), "impactAsync__trampoline$ExpoModulesV2", true);
        builder.function("selectionAsync", new AnyType[0], new AnyType(new TypeDescriptor.Simple(Unit.class, false), false), "selectionAsync__trampoline$ExpoModulesV2", true);
        builder.function("performHapticsAsync", new AnyType[]{new AnyType(new TypeDescriptor.Simple(HapticType.class, false), true)}, new AnyType(new TypeDescriptor.Simple(Unit.class, false), false), "performHapticsAsync__trampoline$ExpoModulesV2", true);
        return "ExpoHaptics";
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    public final void impactAsync__trampoline$ExpoModulesV2(int i, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        TrampolineArguments trampolineArgumentsArguments = Trampoline.arguments(i);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            objectRef.element = trampolineArgumentsArguments.next(type$2);
            trampolineArgumentsArguments.finish();
            promise.launch(type$1, false, new HapticsModule$impactAsync__trampoline$ExpoModulesV2$1(this, objectRef, null));
        } catch (Throwable th) {
            trampolineArgumentsArguments.finish();
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    public final void notificationAsync__trampoline$ExpoModulesV2(int i, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        TrampolineArguments trampolineArgumentsArguments = Trampoline.arguments(i);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            objectRef.element = trampolineArgumentsArguments.next(type$0);
            trampolineArgumentsArguments.finish();
            promise.launch(type$1, false, new HapticsModule$notificationAsync__trampoline$ExpoModulesV2$1(this, objectRef, null));
        } catch (Throwable th) {
            trampolineArgumentsArguments.finish();
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    public final void performHapticsAsync__trampoline$ExpoModulesV2(int i, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        TrampolineArguments trampolineArgumentsArguments = Trampoline.arguments(i);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            objectRef.element = trampolineArgumentsArguments.next(type$3);
            trampolineArgumentsArguments.finish();
            promise.launch(type$1, false, new HapticsModule$performHapticsAsync__trampoline$ExpoModulesV2$1(this, objectRef, null));
        } catch (Throwable th) {
            trampolineArgumentsArguments.finish();
            throw th;
        }
    }

    public final void selectionAsync__trampoline$ExpoModulesV2(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.launch(type$1, false, new HapticsModule$selectionAsync__trampoline$ExpoModulesV2$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Vibrator getVibrator() {
        if (Build.VERSION.SDK_INT >= 31) {
            Object systemService = ReactContextExtensionsKt.getAndroidContext(this).getSystemService("vibrator_manager");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.VibratorManager");
            Vibrator defaultVibrator = ReactRootView$$ExternalSyntheticApiModelOutline0.m11395m(systemService).getDefaultVibrator();
            Intrinsics.checkNotNull(defaultVibrator);
            return defaultVibrator;
        }
        Object systemService2 = ReactContextExtensionsKt.getAndroidContext(this).getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.Vibrator");
        return (Vibrator) systemService2;
    }

    public final Object notificationAsync(NotificationType notificationType, Continuation<? super Unit> continuation) {
        Object objVibrate = vibrate(notificationType.getVibration(), continuation);
        return objVibrate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objVibrate : Unit.INSTANCE;
    }

    public final Object impactAsync(ImpactStyle impactStyle, Continuation<? super Unit> continuation) {
        Object objVibrate = vibrate(impactStyle.getVibration(), continuation);
        return objVibrate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objVibrate : Unit.INSTANCE;
    }

    public final Object selectionAsync(Continuation<? super Unit> continuation) {
        Object objVibrate = vibrate(HapticsTypesKt.getSelectionType(), continuation);
        return objVibrate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objVibrate : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: expo.modules.haptics.HapticsModule$performHapticsAsync$2, reason: invalid class name */
    /* JADX INFO: compiled from: HapticsModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.haptics.HapticsModule$performHapticsAsync$2", f = "HapticsModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HapticType $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(HapticType hapticType, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$type = hapticType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HapticsModule.this.new AnonymousClass2(this.$type, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            View viewFindViewById;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Activity currentActivity = ReactContextExtensionsKt.getCurrentActivity(HapticsModule.this);
            if (currentActivity != null && (viewFindViewById = currentActivity.findViewById(android.R.id.content)) != null) {
                Boxing.boxBoolean(viewFindViewById.performHapticFeedback(HapticType.toHapticFeedbackType$default(this.$type, 0, 1, null)));
            }
            return Unit.INSTANCE;
        }
    }

    public final Object performHapticsAsync(HapticType hapticType, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(hapticType, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: expo.modules.haptics.HapticsModule$vibrate$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HapticsModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.haptics.HapticsModule$vibrate$2", f = "HapticsModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08172 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ VibrationType $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08172(VibrationType vibrationType, Continuation<? super C08172> continuation) {
            super(2, continuation);
            this.$type = vibrationType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HapticsModule.this.new C08172(this.$type, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08172) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int i = Build.VERSION.SDK_INT;
            HapticsModule hapticsModule = HapticsModule.this;
            if (i >= 26) {
                hapticsModule.getVibrator().vibrate(VibrationEffect.createWaveform(this.$type.getTimings(), this.$type.getAmplitudes(), -1));
            } else {
                hapticsModule.getVibrator().vibrate(this.$type.getOldSDKPattern(), -1);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object vibrate(VibrationType vibrationType, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C08172(vibrationType, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
