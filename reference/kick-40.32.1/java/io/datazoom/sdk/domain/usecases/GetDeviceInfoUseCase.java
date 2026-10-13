package io.datazoom.sdk.domain.usecases;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.DeviceInfo_androidKt;
import io.datazoom.sdk.data.memory.MetaDataStore;
import io.datazoom.sdk.data.memory.MetaDataStoreExtensionsKt;
import io.datazoom.sdk.model.DeviceInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetDeviceInfoUseCase.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/datazoom/sdk/domain/usecases/GetDeviceInfoUseCase;", "", "metaDataStore", "Lio/datazoom/sdk/data/memory/MetaDataStore;", "<init>", "(Lio/datazoom/sdk/data/memory/MetaDataStore;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetDeviceInfoUseCase {
    private final MetaDataStore metaDataStore;

    /* JADX INFO: renamed from: io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetDeviceInfoUseCase.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCase", f = "GetDeviceInfoUseCase.kt", i = {}, l = {13}, m = "invoke", n = {}, nl = {14}, s = {}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetDeviceInfoUseCase.this.invoke(this);
        }
    }

    public GetDeviceInfoUseCase(MetaDataStore metaDataStore) {
        Intrinsics.checkNotNullParameter(metaDataStore, "metaDataStore");
        this.metaDataStore = metaDataStore;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(Continuation<? super Unit> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        MetaDataStore metaDataStore;
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
            metaDataStore = this.metaDataStore;
            anonymousClass1.L$0 = metaDataStore;
            anonymousClass1.label = 1;
            deviceInfo = DeviceInfo_androidKt.getDeviceInfo(anonymousClass1);
            if (deviceInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            metaDataStore = (MetaDataStore) anonymousClass1.L$0;
            ResultKt.throwOnFailure(deviceInfo);
        }
        MetaDataStoreExtensionsKt.device(metaDataStore, (DeviceInfo) deviceInfo);
        return Unit.INSTANCE;
    }
}
