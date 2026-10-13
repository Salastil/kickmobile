package io.datazoom.sdk.model;

import com.datadog.android.rum.internal.domain.battery.DefaultBatteryInfoProvider;
import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.network.config.model.ConfigDto;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AppConfig.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u001c\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010 R\u001c\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010 R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Lio/datazoom/sdk/model/AppConfigImp;", "Lio/datazoom/sdk/model/AppConfig;", "config", "Lio/datazoom/sdk/network/config/model/ConfigDto;", "<init>", "(Lio/datazoom/sdk/network/config/model/ConfigDto;)V", "getConfig", "()Lio/datazoom/sdk/network/config/model/ConfigDto;", "isEventEnabled", "", "name", "", "type", "isFluxEnabled", "fx", "isMetadataEnabled", "md", "customerCode", "getCustomerCode", "()Ljava/lang/String;", "connectorList", "getConnectorList", "configurationId", "getConfigurationId", "endpoints", "Lio/datazoom/sdk/network/config/model/ConfigDto$Endpoints;", "getEndpoints", "()Lio/datazoom/sdk/network/config/model/ConfigDto$Endpoints;", "contentMilestones", "", "", "getContentMilestones", "()Ljava/util/List;", "adMilestones", "getAdMilestones", "contentQv", "getContentQv", "adQv", "getAdQv", "heartbeatIntervalMs", "", "getHeartbeatIntervalMs", "()J", "appSessionInactivityMs", "getAppSessionInactivityMs", "()I", "omEnabled", "getOmEnabled", "()Z", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AppConfigImp implements AppConfig {
    private final ConfigDto config;

    public AppConfigImp(ConfigDto config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    public final ConfigDto getConfig() {
        return this.config;
    }

    @Override // io.datazoom.sdk.model.AppConfig
    public boolean isEventEnabled(String name, String type) {
        List<ConfigDto.DataPoints.Event> events;
        List<String> types;
        Intrinsics.checkNotNullParameter(name, "name");
        ConfigDto.DataPoints dataPoints = this.config.getDataPoints();
        if (dataPoints != null && (events = dataPoints.getEvents()) != null) {
            List<ConfigDto.DataPoints.Event> list = events;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (ConfigDto.DataPoints.Event event : list) {
                    if (Intrinsics.areEqual(event.getName(), name) && (types = event.getTypes()) != null) {
                        List<String> list2 = types;
                        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                            for (String str : list2) {
                                if (StringsKt.equals(str, "na", true) || StringsKt.equals(str, type, true)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // io.datazoom.sdk.model.AppConfig
    public boolean isFluxEnabled(String fx) {
        Set<String> fluxData;
        Intrinsics.checkNotNullParameter(fx, "fx");
        ConfigDto.DataPoints dataPoints = this.config.getDataPoints();
        if (dataPoints == null || (fluxData = dataPoints.getFluxData()) == null) {
            return false;
        }
        return fluxData.contains(fx);
    }

    @Override // io.datazoom.sdk.model.AppConfig
    public boolean isMetadataEnabled(String md) {
        Set<String> metadata;
        Intrinsics.checkNotNullParameter(md, "md");
        ConfigDto.DataPoints dataPoints = this.config.getDataPoints();
        if (dataPoints == null || (metadata = dataPoints.getMetadata()) == null) {
            return false;
        }
        return metadata.contains(md);
    }

    @Override // io.datazoom.sdk.model.AppConfig
    public String getCustomerCode() {
        return this.config.getCustomerCode();
    }

    @Override // io.datazoom.sdk.model.AppConfig
    public String getConnectorList() {
        return this.config.getConnectorList();
    }

    @Override // io.datazoom.sdk.model.AppConfig
    public String getConfigurationId() {
        return this.config.getConfigurationId();
    }

    @Override // io.datazoom.sdk.model.AppConfig
    public ConfigDto.Endpoints getEndpoints() {
        return this.config.getEndpoints();
    }

    @Override // io.datazoom.sdk.model.AppConfig
    public List<Integer> getContentMilestones() {
        return this.config.getContentMilestones();
    }

    @Override // io.datazoom.sdk.model.AppConfig
    public List<Integer> getAdMilestones() {
        return this.config.getAdMilestones();
    }

    @Override // io.datazoom.sdk.model.AppConfig
    public List<Integer> getContentQv() {
        return this.config.getContentQv();
    }

    @Override // io.datazoom.sdk.model.AppConfig
    public List<Integer> getAdQv() {
        return this.config.getAdQv();
    }

    @Override // io.datazoom.sdk.model.AppConfig
    public long getHeartbeatIntervalMs() {
        return this.config.getHeartbeatIntervalMs();
    }

    @Override // io.datazoom.sdk.model.AppConfig
    public int getAppSessionInactivityMs() {
        Integer appSessionTimeoutMinutes = this.config.getAppSessionTimeoutMinutes();
        if (appSessionTimeoutMinutes == null) {
            return AppSessionDefaultsKt.DEFAULT_APP_SESSION_INACTIVITY_MS;
        }
        if (appSessionTimeoutMinutes.intValue() <= 0) {
            appSessionTimeoutMinutes = null;
        }
        return appSessionTimeoutMinutes != null ? appSessionTimeoutMinutes.intValue() * DefaultBatteryInfoProvider.BATTERY_POLL_INTERVAL_MS : AppSessionDefaultsKt.DEFAULT_APP_SESSION_INACTIVITY_MS;
    }

    @Override // io.datazoom.sdk.model.AppConfig
    public boolean getOmEnabled() {
        return this.config.getOmEnabled();
    }
}
