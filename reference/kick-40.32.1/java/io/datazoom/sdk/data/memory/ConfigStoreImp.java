package io.datazoom.sdk.data.memory;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.logs.Logger_androidKt;
import io.datazoom.sdk.model.AppConfig;
import io.datazoom.sdk.network.config.model.ConfigDto;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: ConfigStore.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lio/datazoom/sdk/data/memory/ConfigStoreImp;", "Lio/datazoom/sdk/data/memory/ConfigStore;", "<init>", "()V", "configs", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "Lio/datazoom/sdk/network/config/model/ConfigDto;", "_configDtoState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/datazoom/sdk/model/AppConfig;", "configDtoState", "Lkotlinx/coroutines/flow/SharedFlow;", "getConfigDtoState", "()Lkotlinx/coroutines/flow/SharedFlow;", "save", "", "configId", "Lio/datazoom/sdk/data/memory/ConfigId;", "configDto", "get", "clear", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ConfigStoreImp implements ConfigStore {
    private final MutableSharedFlow<AppConfig> _configDtoState;
    private final SharedFlow<AppConfig> configDtoState;
    private final MutableStateFlow<Map<String, ConfigDto>> configs = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());

    public ConfigStoreImp() {
        MutableSharedFlow<AppConfig> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this._configDtoState = mutableSharedFlowMutableSharedFlow$default;
        this.configDtoState = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    @Override // io.datazoom.sdk.data.memory.ConfigStore
    public SharedFlow<AppConfig> getConfigDtoState() {
        return this.configDtoState;
    }

    @Override // io.datazoom.sdk.data.memory.ConfigStore
    public boolean save(ConfigId configId, ConfigDto configDto) {
        Map<String, ConfigDto> value;
        Map<String, ConfigDto> mutableMap;
        Intrinsics.checkNotNullParameter(configId, "configId");
        Intrinsics.checkNotNullParameter(configDto, "configDto");
        MutableStateFlow<Map<String, ConfigDto>> mutableStateFlow = this.configs;
        do {
            value = mutableStateFlow.getValue();
            mutableMap = MapsKt.toMutableMap(value);
            mutableMap.put(configId.getValue(), configDto);
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
        return this._configDtoState.tryEmit(ConfigStoreKt.toAppConfig(configDto));
    }

    @Override // io.datazoom.sdk.data.memory.ConfigStore
    public AppConfig get(ConfigId configId) {
        AppConfig appConfig;
        Intrinsics.checkNotNullParameter(configId, "configId");
        ConfigDto configDto = this.configs.getValue().get(configId.getValue());
        if (configDto != null && (appConfig = ConfigStoreKt.toAppConfig(configDto)) != null) {
            return appConfig;
        }
        Logger_androidKt.getLogger().w("Config not found, system wont work properly");
        return null;
    }

    @Override // io.datazoom.sdk.data.memory.ConfigStore
    public void clear() {
        MutableStateFlow<Map<String, ConfigDto>> mutableStateFlow = this.configs;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), MapsKt.emptyMap())) {
        }
    }
}
