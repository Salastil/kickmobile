package io.datazoom.sdk.data.memory;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.AppConfig;
import io.datazoom.sdk.model.AppConfigImp;
import io.datazoom.sdk.network.config.model.ConfigDto;
import kotlin.Metadata;

/* JADX INFO: compiled from: ConfigStore.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"toAppConfig", "Lio/datazoom/sdk/model/AppConfig;", "Lio/datazoom/sdk/network/config/model/ConfigDto;", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ConfigStoreKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final AppConfig toAppConfig(ConfigDto configDto) {
        return new AppConfigImp(configDto);
    }
}
