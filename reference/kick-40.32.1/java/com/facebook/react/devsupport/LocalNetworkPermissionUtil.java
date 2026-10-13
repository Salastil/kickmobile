package com.facebook.react.devsupport;

import android.app.Activity;
import android.os.Build;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalNetworkPermissionUtil.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/react/devsupport/LocalNetworkPermissionUtil;", "", "<init>", "()V", "PERMISSION", "", "PERMISSION_REQUEST_CODE", "", "requestLocalNetworkAccessIfNeeded", "", "activity", "Landroid/app/Activity;", "onResolved", "Ljava/lang/Runnable;", "needsLocalNetworkPrompt", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LocalNetworkPermissionUtil {
    public static final LocalNetworkPermissionUtil INSTANCE = new LocalNetworkPermissionUtil();
    private static final String PERMISSION = "android.permission.ACCESS_LOCAL_NETWORK";
    private static final int PERMISSION_REQUEST_CODE = 1;

    private LocalNetworkPermissionUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void requestLocalNetworkAccessIfNeeded(Activity activity, final Runnable onResolved) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onResolved, "onResolved");
        if ((activity instanceof PermissionAwareActivity) && INSTANCE.needsLocalNetworkPrompt(activity)) {
            ((PermissionAwareActivity) activity).requestPermissions(new String[]{"android.permission.ACCESS_LOCAL_NETWORK"}, 1, new PermissionListener() { // from class: com.facebook.react.devsupport.LocalNetworkPermissionUtil$$ExternalSyntheticLambda0
                @Override // com.facebook.react.modules.core.PermissionListener
                public final boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    return LocalNetworkPermissionUtil.requestLocalNetworkAccessIfNeeded$lambda$0(onResolved, i, strArr, iArr);
                }
            });
        } else {
            onResolved.run();
        }
    }

    static final boolean requestLocalNetworkAccessIfNeeded$lambda$0(Runnable runnable, int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "<unused var>");
        Intrinsics.checkNotNullParameter(iArr, "<unused var>");
        runnable.run();
        return true;
    }

    private final boolean needsLocalNetworkPrompt(Activity activity) {
        return ReactBuildConfig.DEBUG && Build.VERSION.SDK_INT >= 37 && activity.checkSelfPermission("android.permission.ACCESS_LOCAL_NETWORK") != 0;
    }
}
