package io.datazoom.sdk.device;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.DeviceInfo_androidKt;
import io.datazoom.sdk.model.DeviceInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Device.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/datazoom/sdk/device/Device;", "", "<init>", "()V", "randomId", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Device {
    public static final Device INSTANCE = new Device();

    /* JADX INFO: renamed from: io.datazoom.sdk.device.Device$randomId$1, reason: invalid class name */
    /* JADX INFO: compiled from: Device.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.device.Device", f = "Device.kt", i = {}, l = {6}, m = "randomId", n = {}, nl = {-1}, s = {}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Device.this.randomId(this);
        }
    }

    private Device() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object randomId(Continuation<? super String> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object deviceInfo = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(deviceInfo);
            anonymousClass1.label = 1;
            deviceInfo = DeviceInfo_androidKt.getDeviceInfo(anonymousClass1);
            if (deviceInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(deviceInfo);
        }
        return ((DeviceInfo) deviceInfo).getId();
    }
}
