package com.datadog.android.rum.resource;

import android.content.Context;
import android.content.res.Resources;
import com.datadog.android.Datadog;
import com.datadog.android.api.SdkCore;
import com.datadog.android.internal.utils.NumberExtKt;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u001e\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"getAssetAsRumResource", "Ljava/io/InputStream;", "Landroid/content/Context;", "fileName", "", "accessMode", "", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "getRawResAsRumResource", "id", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContextExtKt {
    public static /* synthetic */ InputStream getAssetAsRumResource$default(Context context, String str, int i, SdkCore sdkCore, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        if ((i2 & 4) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        return getAssetAsRumResource(context, str, i, sdkCore);
    }

    public static final InputStream getAssetAsRumResource(Context context, String fileName, int i, SdkCore sdkCore) throws IOException {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        InputStream inputStreamOpen = context.getAssets().open(fileName, i);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "assets.open(fileName, accessMode)");
        return new RumResourceInputStream(inputStreamOpen, "assets://" + fileName, sdkCore);
    }

    public static /* synthetic */ InputStream getRawResAsRumResource$default(Context context, int i, SdkCore sdkCore, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        return getRawResAsRumResource(context, i, sdkCore);
    }

    public static final InputStream getRawResAsRumResource(Context context, int i, SdkCore sdkCore) {
        String resName;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        try {
            resName = context.getResources().getResourceName(i);
        } catch (Resources.NotFoundException unused) {
            resName = "res/0x" + NumberExtKt.toHexString(i);
        }
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "resources.openRawResource(id)");
        Intrinsics.checkNotNullExpressionValue(resName, "resName");
        return new RumResourceInputStream(inputStreamOpenRawResource, resName, sdkCore);
    }
}
