package com.datadog.trace.core.tagprocessor;

import com.datadog.trace.api.Config;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class TagsPostProcessorFactory {
    private static boolean addBaseService = true;

    private static class Lazy {
        private static TagsPostProcessor instance = create();

        private Lazy() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static TagsPostProcessor create() {
            ArrayList arrayList = new ArrayList(TagsPostProcessorFactory.addBaseService ? 3 : 2);
            arrayList.add(new PeerServiceCalculator());
            if (TagsPostProcessorFactory.addBaseService) {
                arrayList.add(new BaseServiceAdder(Config.get().getServiceName()));
            }
            arrayList.add(new QueryObfuscator(Config.get().getObfuscationQueryRegexp()));
            return new PostProcessorChain((TagsPostProcessor[]) arrayList.toArray((TagsPostProcessor[]) arrayList.toArray(new TagsPostProcessor[0])));
        }
    }

    public static TagsPostProcessor instance() {
        return Lazy.instance;
    }

    public static void withAddBaseService(boolean z) {
        addBaseService = z;
        Lazy.instance = Lazy.create();
    }

    public static void reset() {
        withAddBaseService(true);
        Lazy.instance = Lazy.create();
    }
}
