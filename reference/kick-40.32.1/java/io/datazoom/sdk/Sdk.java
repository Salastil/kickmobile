package io.datazoom.sdk;

import com.facebook.hermes.intl.Constants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: Sdk.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H&J\b\u0010\u0012\u001a\u00020\rH&J$\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\r2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0016H&J\u001c\u0010\u0017\u001a\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0016H&J\b\u0010\u0019\u001a\u00020\u0003H&J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0016H&J\b\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u0003H&R\u0012\u0010\u001e\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0\"X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006&À\u0006\u0003"}, d2 = {"Lio/datazoom/sdk/Sdk;", "", "init", "", "config", "Lio/datazoom/sdk/Config;", "createBaseContext", "Lio/datazoom/sdk/BaseContext;", "createContext", "Lio/datazoom/sdk/DzAdapter;", "adapter", "removeContext", "id", "", "removeBaseContext", "playerContexts", "", "getBaseContexts", "getSessionId", "generateEvent", "name", "payload", "", "setMetadata", "metadata", "clearMetadata", "getMetadata", "isInitialized", "", "clear", "version", "getVersion", "()Ljava/lang/String;", "sdkEvents", "Lkotlinx/coroutines/flow/SharedFlow;", "Lio/datazoom/sdk/SdkEvent;", "getSdkEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface Sdk {
    void clear();

    void clearMetadata();

    BaseContext createBaseContext();

    DzAdapter createContext(DzAdapter adapter);

    void generateEvent(String name, Map<String, ? extends Object> payload);

    List<BaseContext> getBaseContexts();

    Map<String, Object> getMetadata();

    SharedFlow<SdkEvent<?>> getSdkEvents();

    String getSessionId();

    String getVersion();

    void init(Config config);

    boolean isInitialized();

    List<DzAdapter> playerContexts();

    void removeBaseContext(String id);

    void removeContext(DzAdapter adapter);

    void removeContext(String id);

    void setMetadata(Map<String, ? extends Object> metadata);
}
