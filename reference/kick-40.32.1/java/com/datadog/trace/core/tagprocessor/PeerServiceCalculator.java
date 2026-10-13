package com.datadog.trace.core.tagprocessor;

import com.datadog.trace.api.Config;
import com.datadog.trace.api.DDTags;
import com.datadog.trace.api.naming.NamingSchema;
import com.datadog.trace.api.naming.SpanNaming;
import com.datadog.trace.bootstrap.instrumentation.api.Tags;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class PeerServiceCalculator implements TagsPostProcessor {
    private final boolean canRemap;
    private final Map<String, String> peerServiceMapping;
    private final NamingSchema.ForPeerService peerServiceNaming;

    public PeerServiceCalculator() {
        this(SpanNaming.instance().namingSchema().peerService(), Config.get().getPeerServiceMapping());
    }

    PeerServiceCalculator(NamingSchema.ForPeerService forPeerService, Map<String, String> map) {
        this.peerServiceNaming = forPeerService;
        this.peerServiceMapping = map;
        this.canRemap = !map.isEmpty();
    }

    @Override // com.datadog.trace.core.tagprocessor.TagsPostProcessor
    public Map<String, Object> processTags(Map<String, Object> map) {
        Object obj = map.get(Tags.PEER_SERVICE);
        if (obj != null) {
            if (this.canRemap) {
                return remapPeerService(map, obj);
            }
        } else if (this.peerServiceNaming.supports()) {
            this.peerServiceNaming.tags(map);
            return remapPeerService(map, this.canRemap ? map.get(Tags.PEER_SERVICE) : null);
        }
        return map;
    }

    private Map<String, Object> remapPeerService(Map<String, Object> map, Object obj) {
        String str;
        if (obj != null && (str = this.peerServiceMapping.get(obj)) != null) {
            map.put(Tags.PEER_SERVICE, str);
            map.put(DDTags.PEER_SERVICE_REMAPPED_FROM, obj);
        }
        return map;
    }
}
