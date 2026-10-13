package com.facebook.react.views.scroll;

import com.facebook.common.logging.FLog;
import com.facebook.react.common.build.ReactBuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: VirtualViewContainerStateExperimental.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"ENABLE_DEBUG_LOGS", "", "debugLog", "", "subtag", "", "block", "Lkotlin/Function0;", "ReactAndroid"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VirtualViewContainerStateExperimentalKt {
    private static final boolean ENABLE_DEBUG_LOGS;

    static {
        boolean z = ReactBuildConfig.DEBUG;
        ENABLE_DEBUG_LOGS = false;
    }

    static /* synthetic */ void debugLog$default(String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0<String>() { // from class: com.facebook.react.views.scroll.VirtualViewContainerStateExperimentalKt.debugLog.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "";
                }
            };
        }
        if (ENABLE_DEBUG_LOGS) {
            FLog.d("VirtualViewContainerStateExperimental:" + str, (String) function0.invoke());
        }
    }

    private static final void debugLog(String str, Function0<String> function0) {
        if (ENABLE_DEBUG_LOGS) {
            FLog.d("VirtualViewContainerStateExperimental:" + str, function0.invoke());
        }
    }
}
