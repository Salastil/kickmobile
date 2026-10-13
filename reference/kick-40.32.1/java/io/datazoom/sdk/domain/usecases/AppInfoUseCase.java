package io.datazoom.sdk.domain.usecases;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.PlatformKt;
import io.datazoom.sdk.data.memory.MetaDataStore;
import io.datazoom.sdk.data.memory.MetaDataStoreExtensionsKt;
import io.datazoom.sdk.model.MetaData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppInfoUseCase.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0007H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lio/datazoom/sdk/domain/usecases/AppInfoUseCase;", "", "store", "Lio/datazoom/sdk/data/memory/MetaDataStore;", "<init>", "(Lio/datazoom/sdk/data/memory/MetaDataStore;)V", "invoke", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AppInfoUseCase {
    private final MetaDataStore store;

    public AppInfoUseCase(MetaDataStore store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    public final void invoke() {
        this.store.put(MetaDataStoreExtensionsKt.to(MetaData.Type.DZ_SDK_VERSION, PlatformKt.getPlatform().getVersion()));
    }
}
