package com.google.ads.interactivemedia.pal;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public interface PlatformSignalCollector {
    Task<Map<String, String>> collectSignals(Context context, ExecutorService executorService);
}
