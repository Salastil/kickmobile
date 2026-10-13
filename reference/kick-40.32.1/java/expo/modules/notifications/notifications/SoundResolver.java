package expo.modules.notifications.notifications;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.util.UriUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: SoundResolver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lexpo/modules/notifications/notifications/SoundResolver;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "resolve", "Landroid/net/Uri;", "filename", "", "resourceExists", "", "filenameToBasename", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SoundResolver {
    private final Context context;

    public SoundResolver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Uri resolve(String filename) {
        String str = filename;
        if (str == null || str.length() == 0) {
            return null;
        }
        String packageName = this.context.getPackageName();
        String strFilenameToBasename = filenameToBasename(filename);
        if (this.context.getResources().getIdentifier(strFilenameToBasename, "raw", packageName) != 0) {
            return new Uri.Builder().scheme(UriUtil.QUALIFIED_RESOURCE_SCHEME).authority(packageName).appendPath("raw").appendPath(strFilenameToBasename).build();
        }
        return Settings.System.DEFAULT_NOTIFICATION_URI;
    }

    public final boolean resourceExists(String filename) {
        String str = filename;
        if (str != null && str.length() != 0) {
            String packageName = this.context.getPackageName();
            if (this.context.getResources().getIdentifier(filenameToBasename(filename), "raw", packageName) != 0) {
                return true;
            }
        }
        return false;
    }

    private final String filenameToBasename(String filename) {
        String str = filename;
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) ".", false, 2, (Object) null)) {
            return filename;
        }
        String strSubstring = filename.substring(0, StringsKt.lastIndexOf$default((CharSequence) str, FilenameUtils.EXTENSION_SEPARATOR, 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }
}
