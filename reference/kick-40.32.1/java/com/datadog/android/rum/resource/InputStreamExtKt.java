package com.datadog.android.rum.resource;

import com.datadog.android.Datadog;
import com.datadog.android.api.SdkCore;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InputStreamExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"asRumResource", "Ljava/io/InputStream;", ImagesContract.URL, "", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InputStreamExtKt {
    public static /* synthetic */ InputStream asRumResource$default(InputStream inputStream, String str, SdkCore sdkCore, int i, Object obj) {
        if ((i & 2) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        return asRumResource(inputStream, str, sdkCore);
    }

    public static final InputStream asRumResource(InputStream inputStream, String url, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        return new RumResourceInputStream(inputStream, url, sdkCore);
    }
}
