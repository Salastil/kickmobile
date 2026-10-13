package androidx.webkit;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface WebViewStartUpResult {
    List<BlockingStartUpLocation> getBlockingStartUpLocations();

    Long getMaxTimePerTaskInUiThreadMillis();

    Long getTotalTimeInUiThreadMillis();
}
