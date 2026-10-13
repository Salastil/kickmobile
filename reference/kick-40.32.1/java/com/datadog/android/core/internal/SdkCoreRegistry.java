package com.datadog.android.core.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkCoreRegistry.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\r\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\bJ\u0014\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/core/internal/SdkCoreRegistry;", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "instances", "", "", "Lcom/datadog/android/api/SdkCore;", "clear", "", "getInstance", "name", "register", "sdkCore", "unregister", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SdkCoreRegistry {
    public static final String DEFAULT_INSTANCE_NAME = "_dd.sdk_core.default";
    private final Map<String, SdkCore> instances;
    private final InternalLogger internalLogger;

    public SdkCoreRegistry(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
        this.instances = new LinkedHashMap();
    }

    public final void register(final String name, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        if (name == null) {
            name = DEFAULT_INSTANCE_NAME;
        }
        if (this.instances.containsKey(name)) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.SdkCoreRegistry.register.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "An SdkCode with name " + name + " has already been registered.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            this.instances.put(name, sdkCore);
        }
    }

    public static /* synthetic */ SdkCore unregister$default(SdkCoreRegistry sdkCoreRegistry, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return sdkCoreRegistry.unregister(str);
    }

    public final SdkCore unregister(String name) {
        if (name == null) {
            name = DEFAULT_INSTANCE_NAME;
        }
        return this.instances.remove(name);
    }

    public static /* synthetic */ SdkCore getInstance$default(SdkCoreRegistry sdkCoreRegistry, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return sdkCoreRegistry.getInstance(str);
    }

    public final SdkCore getInstance(String name) {
        if (name == null) {
            name = DEFAULT_INSTANCE_NAME;
        }
        return this.instances.get(name);
    }

    public final void clear() {
        this.instances.clear();
    }
}
