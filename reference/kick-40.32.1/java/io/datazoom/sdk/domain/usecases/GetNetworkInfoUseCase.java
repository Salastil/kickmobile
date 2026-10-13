package io.datazoom.sdk.domain.usecases;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.NetworkInfo_androidKt;
import io.datazoom.sdk.data.memory.MetaDataStore;
import io.datazoom.sdk.data.memory.MetaDataStoreExtensionsKt;
import io.datazoom.sdk.model.MetaData;
import io.datazoom.sdk.model.NetworkInfo;
import io.datazoom.sdk.utils.PrimitiveExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetNetworkInfoUseCase.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lio/datazoom/sdk/domain/usecases/GetNetworkInfoUseCase;", "", "storage", "Lio/datazoom/sdk/data/memory/MetaDataStore;", "<init>", "(Lio/datazoom/sdk/data/memory/MetaDataStore;)V", "info", "Lio/datazoom/sdk/model/NetworkInfo;", "invoke", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GetNetworkInfoUseCase {
    private final NetworkInfo info;
    private final MetaDataStore storage;

    public GetNetworkInfoUseCase(MetaDataStore storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        this.storage = storage;
        this.info = NetworkInfo_androidKt.getNetworkInfo();
    }

    public final void invoke() {
        this.storage.put(MetaDataStoreExtensionsKt.to(MetaData.Type.MOBILE_CONNECTION, Boolean.valueOf(PrimitiveExtensionsKt.orFalse(Boolean.valueOf(this.info.isMobileConnection())))));
        this.storage.put(MetaDataStoreExtensionsKt.to(MetaData.Type.USER_AGENT, this.info.getUserAgent()));
    }
}
