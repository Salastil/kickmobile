package io.datazoom.sdk.data.memory;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.AppConfig;
import io.datazoom.sdk.network.config.model.ConfigDto;
import kotlin.Metadata;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: ConfigStore.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\u000fH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lio/datazoom/sdk/data/memory/ConfigStore;", "", "configDtoState", "Lkotlinx/coroutines/flow/SharedFlow;", "Lio/datazoom/sdk/model/AppConfig;", "getConfigDtoState", "()Lkotlinx/coroutines/flow/SharedFlow;", "save", "", "configId", "Lio/datazoom/sdk/data/memory/ConfigId;", "configDto", "Lio/datazoom/sdk/network/config/model/ConfigDto;", "get", "clear", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ConfigStore {
    void clear();

    AppConfig get(ConfigId configId);

    SharedFlow<AppConfig> getConfigDtoState();

    boolean save(ConfigId configId, ConfigDto configDto);

    /* JADX INFO: compiled from: ConfigStore.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ AppConfig get$default(ConfigStore configStore, ConfigId configId, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }
        if ((i & 1) != 0) {
            configId = ConfigId.Main.INSTANCE;
        }
        return configStore.get(configId);
    }
}
