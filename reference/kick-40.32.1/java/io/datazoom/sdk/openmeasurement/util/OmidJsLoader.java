package io.datazoom.sdk.openmeasurement.util;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import io.datazoom.sdk.openmeasurement.R;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OmidJsLoader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lio/datazoom/sdk/openmeasurement/util/OmidJsLoader;", "", "<init>", "()V", "getOmidJs", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OmidJsLoader {
    public static final OmidJsLoader INSTANCE = new OmidJsLoader();

    private OmidJsLoader() {
    }

    public final String getOmidJs(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(R.raw.omsdk_v1);
            try {
                InputStream inputStream = inputStreamOpenRawResource;
                byte[] bArr = new byte[inputStream.available()];
                int i = inputStream.read(bArr);
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                String str = new String(bArr, 0, i, UTF_8);
                CloseableKt.closeFinally(inputStreamOpenRawResource, null);
                return str;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpenRawResource, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new UnsupportedOperationException("Yikes, omid resource not found", e);
        }
    }
}
