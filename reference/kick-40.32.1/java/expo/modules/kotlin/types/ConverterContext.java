package expo.modules.kotlin.types;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.UIManagerHelper;
import expo.modules.kotlin.Utils;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.runtime.Runtime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConverterContext.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J!\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0017¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/types/ConverterContext;", "", "applicationContext", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "runtime", "Lexpo/modules/kotlin/runtime/Runtime;", "getRuntime", "()Lexpo/modules/kotlin/runtime/Runtime;", "findView", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "viewTag", "", "(I)Landroid/view/View;", "assertMainThread", "", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ConverterContext {
    Context getApplicationContext();

    Runtime getRuntime();

    /* JADX INFO: compiled from: ConverterContext.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T extends View> T findView(ConverterContext converterContext, int i) {
            return (T) ConverterContext.super.findView(i);
        }

        @Deprecated
        public static void assertMainThread(ConverterContext converterContext) {
            ConverterContext.super.assertMainThread();
        }
    }

    default <T extends View> T findView(int viewTag) throws Exceptions.RuntimeLost {
        Runtime runtime = getRuntime();
        if (runtime == null) {
            throw new Exceptions.RuntimeLost();
        }
        ReactApplicationContext reactContext = runtime.getReactContext();
        if (reactContext == null) {
            return null;
        }
        UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactContext, viewTag);
        T t = uIManagerForReactTag != null ? (T) uIManagerForReactTag.resolveView(viewTag) : null;
        if (t instanceof View) {
            return t;
        }
        return null;
    }

    default void assertMainThread() {
        Utils utils = Utils.INSTANCE;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return;
        }
        String name = Thread.currentThread().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String name2 = Looper.getMainLooper().getThread().getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        throw new Exceptions.IncorrectThreadException(name, name2);
    }
}
