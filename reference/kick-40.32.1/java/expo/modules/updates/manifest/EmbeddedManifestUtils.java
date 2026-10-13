package expo.modules.updates.manifest;

import android.content.Context;
import android.util.Log;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.updates.UpdatesConfiguration;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: compiled from: EmbeddedManifestUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/updates/manifest/EmbeddedManifestUtils;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "MANIFEST_FILENAME", "sEmbeddedUpdate", "Lexpo/modules/updates/manifest/EmbeddedUpdate;", "getEmbeddedUpdate", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "getOriginalEmbeddedUpdate", "getCachedEmbeddedUpdate", "loadEmbeddedUpdate", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EmbeddedManifestUtils {
    private static final String MANIFEST_FILENAME = "app.manifest";
    private static EmbeddedUpdate sEmbeddedUpdate;
    public static final EmbeddedManifestUtils INSTANCE = new EmbeddedManifestUtils();
    private static final String TAG = "EmbeddedManifestUtils";

    private EmbeddedManifestUtils() {
    }

    public final EmbeddedUpdate getEmbeddedUpdate(Context context, UpdatesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (configuration.getHasEmbeddedUpdate()) {
            return getCachedEmbeddedUpdate(context, configuration);
        }
        return null;
    }

    public final EmbeddedUpdate getOriginalEmbeddedUpdate(Context context, UpdatesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (configuration.getOriginalHasEmbeddedUpdate()) {
            return getCachedEmbeddedUpdate(context, configuration);
        }
        return null;
    }

    private final EmbeddedUpdate getCachedEmbeddedUpdate(Context context, UpdatesConfiguration configuration) {
        EmbeddedUpdate embeddedUpdate = sEmbeddedUpdate;
        if (embeddedUpdate != null) {
            return embeddedUpdate;
        }
        EmbeddedUpdate embeddedUpdateLoadEmbeddedUpdate = loadEmbeddedUpdate(context, configuration);
        sEmbeddedUpdate = embeddedUpdateLoadEmbeddedUpdate;
        return embeddedUpdateLoadEmbeddedUpdate;
    }

    private final EmbeddedUpdate loadEmbeddedUpdate(Context context, UpdatesConfiguration configuration) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(MANIFEST_FILENAME);
            try {
                InputStream inputStream = inputStreamOpen;
                Intrinsics.checkNotNull(inputStream);
                Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    String text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    JSONObject jSONObject = new JSONObject(text);
                    jSONObject.put("isVerified", true);
                    EmbeddedUpdate embeddedUpdate = UpdateFactory.INSTANCE.getEmbeddedUpdate(jSONObject, configuration);
                    CloseableKt.closeFinally(inputStreamOpen, null);
                    return embeddedUpdate;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStreamOpen, th3);
                    throw th4;
                }
            }
        } catch (Exception e) {
            Exception exc = e;
            Log.e(TAG, "Could not read embedded manifest", exc);
            throw new AssertionError("The embedded manifest is invalid or could not be read. Make sure you have configured expo-updates correctly in android/app/build.gradle.", exc);
        }
    }
}
