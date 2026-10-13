package expo.modules.ui.graphics;

import android.content.Context;
import android.net.Uri;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageSource.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"resolveUri", "", "Lexpo/modules/ui/graphics/ImageSource;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImageSourceKt {
    public static final String resolveUri(ImageSource imageSource, Context context) {
        Intrinsics.checkNotNullParameter(imageSource, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (Uri.parse(imageSource.getUri()).getScheme() == null) {
                Uri resourceUri = ResourceIdHelper.INSTANCE.getResourceUri(context, imageSource.getUri());
                if (resourceUri != null) {
                    return resourceUri.toString();
                }
                return null;
            }
            return imageSource.getUri();
        } catch (Exception unused) {
            Uri resourceUri2 = ResourceIdHelper.INSTANCE.getResourceUri(context, imageSource.getUri());
            if (resourceUri2 != null) {
                return resourceUri2.toString();
            }
            return null;
        }
    }
}
