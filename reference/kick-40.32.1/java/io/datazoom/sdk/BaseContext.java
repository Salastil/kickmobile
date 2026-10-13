package io.datazoom.sdk;

import com.facebook.hermes.intl.Constants;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: BaseContext.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tH&J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tH&J\b\u0010\u000b\u001a\u00020\u0007H&J$\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tH&J\b\u0010\u000f\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lio/datazoom/sdk/BaseContext;", "", "id", "", "getId", "()Ljava/lang/String;", "setMetadata", "", "metadata", "", "getMetadata", "clearMetadata", "generateEvent", "name", "payload", "onDestroy", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface BaseContext {
    void clearMetadata();

    void generateEvent(String name, Map<String, ? extends Object> payload);

    String getId();

    /* JADX INFO: renamed from: getMetadata */
    Map<String, Object> mo12145getMetadata();

    void onDestroy();

    void setMetadata(Map<String, ? extends Object> metadata);
}
