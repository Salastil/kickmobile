package io.datazoom.sdk.model;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.network.config.model.ConfigDto;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: AppConfig.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001aR\u001a\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001aR\u0012\u0010!\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0012\u0010%\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0012\u0010(\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006+À\u0006\u0003"}, d2 = {"Lio/datazoom/sdk/model/AppConfig;", "", "isEventEnabled", "", "name", "", "type", "isFluxEnabled", "fx", "isMetadataEnabled", "md", "customerCode", "getCustomerCode", "()Ljava/lang/String;", "connectorList", "getConnectorList", "configurationId", "getConfigurationId", "endpoints", "Lio/datazoom/sdk/network/config/model/ConfigDto$Endpoints;", "getEndpoints", "()Lio/datazoom/sdk/network/config/model/ConfigDto$Endpoints;", "contentMilestones", "", "", "getContentMilestones", "()Ljava/util/List;", "adMilestones", "getAdMilestones", "contentQv", "getContentQv", "adQv", "getAdQv", "heartbeatIntervalMs", "", "getHeartbeatIntervalMs", "()J", "appSessionInactivityMs", "getAppSessionInactivityMs", "()I", "omEnabled", "getOmEnabled", "()Z", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface AppConfig {
    List<Integer> getAdMilestones();

    List<Integer> getAdQv();

    int getAppSessionInactivityMs();

    String getConfigurationId();

    String getConnectorList();

    List<Integer> getContentMilestones();

    List<Integer> getContentQv();

    String getCustomerCode();

    ConfigDto.Endpoints getEndpoints();

    long getHeartbeatIntervalMs();

    boolean getOmEnabled();

    boolean isEventEnabled(String name, String type);

    boolean isFluxEnabled(String fx);

    boolean isMetadataEnabled(String md);
}
