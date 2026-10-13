package expo.modules.updates;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ImagesContract;
import io.ktor.sse.ServerSentEventKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.java_websocket.WebSocketImpl;

/* JADX INFO: compiled from: UpdatesConfiguration.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0082\b¢\u0006\u0002\u0010\u0006\u001a4\u0010\u0007\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082\b¢\u0006\u0002\u0010\t\u001a\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002\u001a\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0002¨\u0006\u0013"}, d2 = {"getMetadataValue", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/content/Context;", "key", "", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;", "readValueCheckingType", "", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Object;", "getDefaultPortForScheme", "", "scheme", "getNormalizedUrlOrigin", ImagesContract.URL, "Landroid/net/Uri;", "maybeGetDefaultScopeKey", UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY, UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY, "expo-updates_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UpdatesConfigurationKt {
    private static final /* synthetic */ <T> T getMetadataValue(Context context, String str) {
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        if (!bundle.containsKey(str)) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            CharSequence string = bundle.getString(str);
            Intrinsics.reifiedOperationMarker(1, "T?");
            return (T) string;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            Object objValueOf = Boolean.valueOf(bundle.getBoolean(str));
            Intrinsics.reifiedOperationMarker(1, "T?");
            return (T) objValueOf;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            Object objValueOf2 = Integer.valueOf(bundle.getInt(str));
            Intrinsics.reifiedOperationMarker(1, "T?");
            return (T) objValueOf2;
        }
        T t = (T) bundle.get(str);
        Intrinsics.reifiedOperationMarker(1, "T?");
        return t;
    }

    private static final /* synthetic */ <T> T readValueCheckingType(Map<String, ? extends Object> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        T t = (T) map.get(str);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (t instanceof Object) {
            return t;
        }
        Intrinsics.checkNotNull(t);
        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + t.getClass().getSimpleName() + " provided for key " + str);
    }

    private static final int getDefaultPortForScheme(String str) {
        if (str == null) {
            return -1;
        }
        switch (str.hashCode()) {
            case 3804:
                return str.equals("ws") ? 80 : -1;
            case 101730:
                return !str.equals("ftp") ? -1 : 21;
            case 118039:
                if (str.equals("wss")) {
                    return WebSocketImpl.DEFAULT_WSS_PORT;
                }
                return -1;
            case 3213448:
                return !str.equals("http") ? -1 : 80;
            case 99617003:
                if (str.equals("https")) {
                    return WebSocketImpl.DEFAULT_WSS_PORT;
                }
                return -1;
            default:
                return -1;
        }
    }

    public static final String getNormalizedUrlOrigin(Uri url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String scheme = url.getScheme();
        int port = url.getPort();
        if (port == getDefaultPortForScheme(scheme)) {
            port = -1;
        }
        if (port > -1) {
            return scheme + "://" + url.getHost() + ServerSentEventKt.COLON + port;
        }
        return scheme + "://" + url.getHost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String maybeGetDefaultScopeKey(String str, Uri uri) {
        return str == null ? getNormalizedUrlOrigin(uri) : str;
    }
}
