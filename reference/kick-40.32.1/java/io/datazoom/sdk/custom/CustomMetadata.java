package io.datazoom.sdk.custom;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.Event;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: CustomMetadata.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H&J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lio/datazoom/sdk/custom/CustomMetadata;", "", "setCustomMetadata", "", "metadata", "", "", "getCustomMetadata", "clearCustomMetadata", "customEvent", "Lio/datazoom/sdk/model/Event;", "name", "payload", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface CustomMetadata {
    void clearCustomMetadata();

    Event customEvent(String name, Map<String, ? extends Object> payload);

    Map<String, Object> getCustomMetadata();

    void setCustomMetadata(Map<String, ? extends Object> metadata);
}
