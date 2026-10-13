package expo.modules.kotlin.edgeToEdge;

import android.app.Activity;
import android.util.Log;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: compiled from: EdgeToEdgePackage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0004"}, d2 = {"updateEdgeToEdgeFeatureFlag", "", "activity", "Landroid/app/Activity;", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class EdgeToEdgePackageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateEdgeToEdgeFeatureFlag(Activity activity) {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Method declaredMethod = Class.forName("com.facebook.react.views.view.WindowUtilKt").getDeclaredMethod("updateEdgeToEdgeFeatureFlag", Activity.class);
            declaredMethod.setAccessible(true);
            objM12684constructorimpl = Result.m12684constructorimpl(declaredMethod.invoke(null, activity));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Log.e("EdgeToEdgePackage", "Failed to invoke 'updateEdgeToEdgeFeatureFlag' on com.facebook.react.views.view.WindowUtilKt", thM12687exceptionOrNullimpl);
        }
    }
}
