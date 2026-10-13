package expo.modules.medialibrary.next.permissions;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.interfaces.permissions.PermissionsStatus;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.medialibrary.next.permissions.enums.AccessPrivileges;
import expo.modules.medialibrary.next.permissions.enums.GranularPermission;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaLibraryPermissionPromiseWrapper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lexpo/modules/medialibrary/next/permissions/MediaLibraryPermissionPromiseWrapper;", "Lexpo/modules/kotlin/Promise;", "granularPermissions", "", "Lexpo/modules/medialibrary/next/permissions/enums/GranularPermission;", BaseJavaModule.METHOD_TYPE_PROMISE, "contextHolder", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "<init>", "(Ljava/util/List;Lexpo/modules/kotlin/Promise;Ljava/lang/ref/WeakReference;)V", "resolve", "", "value", "", "reject", "code", "", "message", "cause", "", "addOnlySelectedInfoToPermissionsBundle", "Landroid/os/Bundle;", "permissionsBundle", "Companion", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MediaLibraryPermissionPromiseWrapper implements Promise {
    public static final String ACCESS_PRIVILEGES_PERMISSION_KEY = "accessPrivileges";
    private final WeakReference<Context> contextHolder;
    private final List<GranularPermission> granularPermissions;
    private final Promise promise;

    /* JADX WARN: Multi-variable type inference failed */
    public MediaLibraryPermissionPromiseWrapper(List<? extends GranularPermission> granularPermissions, Promise promise, WeakReference<Context> contextHolder) {
        Intrinsics.checkNotNullParameter(granularPermissions, "granularPermissions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(contextHolder, "contextHolder");
        this.granularPermissions = granularPermissions;
        this.promise = promise;
        this.contextHolder = contextHolder;
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(CodedException codedException) {
        super.reject(codedException);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve() {
        super.resolve();
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(double d) {
        super.resolve(d);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(float f) {
        super.resolve(f);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(int i) {
        super.resolve(i);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(String str) {
        super.resolve(str);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Collection<? extends Object> collection) {
        super.resolve(collection);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Map<String, ? extends Object> map) {
        super.resolve(map);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(boolean z) {
        super.resolve(z);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Object value) {
        boolean z = value instanceof Bundle;
        Promise promise = this.promise;
        if (!z) {
            promise.resolve(value);
        } else {
            promise.resolve(addOnlySelectedInfoToPermissionsBundle((Bundle) value, this.granularPermissions));
        }
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(String code, String message, Throwable cause) {
        this.promise.reject(code, message, cause);
    }

    private final Bundle addOnlySelectedInfoToPermissionsBundle(Bundle permissionsBundle, List<? extends GranularPermission> granularPermissions) {
        AccessPrivileges accessPrivileges;
        Context context = this.contextHolder.get();
        if (context == null) {
            return permissionsBundle;
        }
        boolean z = permissionsBundle.getBoolean(PermissionsResponse.GRANTED_KEY);
        if (Build.VERSION.SDK_INT < 34) {
            if (z) {
                accessPrivileges = AccessPrivileges.ALL;
            } else {
                accessPrivileges = AccessPrivileges.NONE;
            }
            permissionsBundle.putString("accessPrivileges", accessPrivileges.getValue());
            return permissionsBundle;
        }
        if (z) {
            permissionsBundle.putString("accessPrivileges", AccessPrivileges.ALL.getValue());
            return permissionsBundle;
        }
        boolean zContains = granularPermissions.contains(GranularPermission.AUDIO);
        boolean z2 = ContextCompat.checkSelfPermission(context, "android.permission.READ_MEDIA_AUDIO") == 0;
        boolean z3 = ContextCompat.checkSelfPermission(context, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == 0;
        if ((!zContains || z2) && z3) {
            permissionsBundle.putBoolean(PermissionsResponse.GRANTED_KEY, true);
            permissionsBundle.putBoolean(PermissionsResponse.CAN_ASK_AGAIN_KEY, true);
            permissionsBundle.putString("status", PermissionsStatus.GRANTED.getStatus());
            permissionsBundle.putString("accessPrivileges", AccessPrivileges.LIMITED.getValue());
            return permissionsBundle;
        }
        permissionsBundle.putString("accessPrivileges", AccessPrivileges.NONE.getValue());
        return permissionsBundle;
    }
}
