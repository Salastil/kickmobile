package com.datadog.trace.api.naming.v1;

import com.datadog.trace.api.DDTags;
import com.datadog.trace.api.naming.NamingSchema;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.datadog.trace.bootstrap.instrumentation.api.Tags;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class PeerServiceNamingV1 implements NamingSchema.ForPeerService {
    private final Map<String, String> overridesByComponent;
    private static final Map<Object, String[]> SPECIFIC_PRECURSORS_BY_COMPONENT = initPrecursorsByComponent();
    private static final String[] DEFAULT_PRECURSORS = {"db.instance", Tags.PEER_HOSTNAME};

    @Override // com.datadog.trace.api.naming.NamingSchema.ForPeerService
    public boolean supports() {
        return true;
    }

    private static Map<Object, String[]> initPrecursorsByComponent() {
        HashMap map = new HashMap(7);
        map.put("java-kafka", new String[]{InstrumentationTags.KAFKA_BOOTSTRAP_SERVERS});
        map.put("hazelcast-sdk", new String[]{"hazelcast.instance", Tags.PEER_HOSTNAME});
        map.put("couchbase-client", new String[]{InstrumentationTags.COUCHBASE_SEED_NODES, "net.peer.name", Tags.PEER_HOSTNAME});
        map.put("java-cassandra", new String[]{InstrumentationTags.CASSANDRA_CONTACT_POINTS, Tags.PEER_HOSTNAME});
        String[] strArr = {Tags.RPC_SERVICE, Tags.PEER_HOSTNAME};
        map.put("grpc-client", strArr);
        map.put("armeria-grpc-client", strArr);
        map.put("rmi-client", strArr);
        map.put("java-aws-sdk", new String[0]);
        return map;
    }

    public PeerServiceNamingV1(Map<String, String> map) {
        this.overridesByComponent = map;
    }

    private void resolve(Map<String, Object> map) {
        Object obj = map.get(Tags.COMPONENT);
        String string = obj == null ? null : obj.toString();
        String str = this.overridesByComponent.get(string);
        if (str != null) {
            set(map, str, "_component_override");
        } else {
            if (resolveBy(map, SPECIFIC_PRECURSORS_BY_COMPONENT.get(string))) {
                return;
            }
            resolveBy(map, DEFAULT_PRECURSORS);
        }
    }

    private boolean resolveBy(Map<String, Object> map, String[] strArr) {
        int i = 0;
        if (strArr == null) {
            return false;
        }
        int length = strArr.length;
        String str = null;
        Object obj = null;
        while (i < length) {
            String str2 = strArr[i];
            Object obj2 = map.get(str2);
            if (obj2 != null) {
                str = str2;
                obj = obj2;
                break;
            }
            i++;
            obj = obj2;
        }
        set(map, obj, str);
        return true;
    }

    private void set(Map<String, Object> map, Object obj, String str) {
        if (obj != null) {
            map.put(Tags.PEER_SERVICE, obj);
            map.put(DDTags.PEER_SERVICE_SOURCE, str);
        }
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForPeerService
    public Map<String, Object> tags(Map<String, Object> map) {
        Object obj = map.get("span.kind");
        if (!"client".equals(obj) && !"producer".equals(obj)) {
            return map;
        }
        resolve(map);
        return map;
    }
}
