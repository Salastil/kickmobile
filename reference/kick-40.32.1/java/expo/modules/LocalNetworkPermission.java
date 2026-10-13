package expo.modules;

import android.app.Activity;
import android.os.Build;
import com.facebook.react.common.build.ReactBuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalNetworkPermission.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lexpo/modules/LocalNetworkPermission;", "", "<init>", "()V", "PERMISSION", "", "REQUEST_CODE", "", "FIRST_ENFORCED_SDK", "shouldRequest", "", "activity", "Landroid/app/Activity;", "expo_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LocalNetworkPermission {
    private static final int FIRST_ENFORCED_SDK = 37;
    public static final LocalNetworkPermission INSTANCE = new LocalNetworkPermission();
    public static final String PERMISSION = "android.permission.ACCESS_LOCAL_NETWORK";
    public static final int REQUEST_CODE = 19534;

    private LocalNetworkPermission() {
    }

    public final boolean shouldRequest(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return ReactBuildConfig.DEBUG && Build.VERSION.SDK_INT >= 37 && activity.checkSelfPermission(PERMISSION) != 0;
    }
}
