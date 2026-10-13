package expo.modules.imagepicker;

import android.content.res.Resources;
import android.util.TypedValue;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoCropImageUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0010\u0006\u001a\u00060\u0007R\u00020\b2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lexpo/modules/imagepicker/ExpoCropImageUtils;", "", "<init>", "()V", "getThemeColor", "", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "attr", "(Landroid/content/res/Resources$Theme;I)Ljava/lang/Integer;", "getColorResource", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "colorResId", "(Landroid/content/res/Resources;I)Ljava/lang/Integer;", "expo-image-picker_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpoCropImageUtils {
    public static final ExpoCropImageUtils INSTANCE = new ExpoCropImageUtils();

    private ExpoCropImageUtils() {
    }

    public final Integer getThemeColor(Resources.Theme theme, int attr) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(theme, "theme");
        try {
            Result.Companion companion = Result.INSTANCE;
            ExpoCropImageUtils expoCropImageUtils = this;
            TypedValue typedValue = new TypedValue();
            objM12684constructorimpl = Result.m12684constructorimpl(theme.resolveAttribute(attr, typedValue, true) ? Integer.valueOf(typedValue.data) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        return (Integer) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
    }

    public final Integer getColorResource(Resources resources, int colorResId) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(resources, "resources");
        try {
            Result.Companion companion = Result.INSTANCE;
            ExpoCropImageUtils expoCropImageUtils = this;
            objM12684constructorimpl = Result.m12684constructorimpl(Integer.valueOf(resources.getColor(colorResId, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        return (Integer) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
    }
}
