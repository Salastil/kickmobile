package expo.modules.blur;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.firebase.analytics.FirebaseAnalytics;
import eightbitlab.com.blurview.BlurTarget;
import eightbitlab.com.blurview.BlurView;
import expo.modules.blur.enums.BlurMethod;
import expo.modules.blur.enums.TintStyle;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ExpoView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoBlurView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001fJ\u0015\u0010'\u001a\u00020%2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u000bJ\u000e\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\tJ\u000e\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\u000bJ\u0006\u0010/\u001a\u00020%J\b\u00100\u001a\u00020%H\u0014J(\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u0016H\u0014J\u0010\u00106\u001a\u00020%2\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020%H\u0002J\u0018\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020!2\u0006\u0010*\u001a\u00020\u000bH\u0002J\u0010\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020!H\u0002J\b\u0010?\u001a\u00020%H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lexpo/modules/blur/ExpoBlurView;", "Lexpo/modules/kotlin/views/ExpoView;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "blurMethod", "Lexpo/modules/blur/enums/BlurMethod;", "blurReduction", "", "blurRadius", "tint", "Lexpo/modules/blur/enums/TintStyle;", "getTint$expo_blur_release", "()Lexpo/modules/blur/enums/TintStyle;", "setTint$expo_blur_release", "(Lexpo/modules/blur/enums/TintStyle;)V", "blurConfiguration", "Lexpo/modules/blur/BlurViewConfiguration;", "blurTargetId", "", "Ljava/lang/Integer;", "blurTarget", "Lexpo/modules/blur/ExpoBlurTargetView;", "clippingPath", "Landroid/graphics/Path;", "clippingRect", "Landroid/graphics/RectF;", "borderRadii", "", "needsClippingPathUpdate", "", "blurView", "Leightbitlab/com/blurview/BlurView;", "setBorderRadii", "", "radii", "setBlurTargetId", "(Ljava/lang/Integer;)V", "setBlurRadius", "radius", "setBlurMethod", FirebaseAnalytics.Param.METHOD, "applyBlurReduction", "reductionFactor", "applyTint", "onAttachedToWindow", "onSizeChanged", "w", "h", "oldw", "oldh", "draw", "canvas", "Landroid/graphics/Canvas;", "configureBlurView", "applyCurrentBlurSettings", "applyBlurViewRadiusCompat", "useBlur", "applyBlurViewOverlayColorCompat", "useBlurView", "updateClippingPathIfNeeded", "expo-blur_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpoBlurView extends ExpoView {
    private BlurViewConfiguration blurConfiguration;
    private BlurMethod blurMethod;
    private float blurRadius;
    private float blurReduction;
    private ExpoBlurTargetView blurTarget;
    private Integer blurTargetId;
    private final BlurView blurView;
    private float[] borderRadii;
    private final Path clippingPath;
    private final RectF clippingRect;
    private boolean needsClippingPathUpdate;
    private TintStyle tint;

    /* JADX INFO: compiled from: ExpoBlurView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlurMethod.values().length];
            try {
                iArr[BlurMethod.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BlurMethod.DIMEZIS_BLUR_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BlurMethod.DIMEZIS_BLUR_VIEW_SDK_31_PLUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoBlurView(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.blurMethod = BlurMethod.NONE;
        this.blurReduction = 4.0f;
        this.blurRadius = 50.0f;
        this.tint = TintStyle.DEFAULT;
        this.blurConfiguration = BlurViewConfiguration.NONE;
        this.clippingPath = new Path();
        this.clippingRect = new RectF();
        this.borderRadii = new float[8];
        this.needsClippingPathUpdate = true;
        BlurView blurView = new BlurView(context);
        blurView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        addView(blurView);
        this.blurView = blurView;
    }

    /* JADX INFO: renamed from: getTint$expo_blur_release, reason: from getter */
    public final TintStyle getTint() {
        return this.tint;
    }

    public final void setTint$expo_blur_release(TintStyle tintStyle) {
        Intrinsics.checkNotNullParameter(tintStyle, "<set-?>");
        this.tint = tintStyle;
    }

    public final void setBorderRadii(float[] radii) {
        Intrinsics.checkNotNullParameter(radii, "radii");
        float[] fArr = new float[8];
        int i = 0;
        while (i < 8) {
            fArr[i] = TypedValue.applyDimension(1, (i < 0 || i >= radii.length) ? 0.0f : radii[i], getContext().getResources().getDisplayMetrics());
            i++;
        }
        this.borderRadii = fArr;
        this.needsClippingPathUpdate = true;
        invalidate();
    }

    public final void setBlurTargetId(Integer blurTargetId) throws BlurViewConfigurationException {
        if (Intrinsics.areEqual(blurTargetId, this.blurTargetId)) {
            return;
        }
        if (blurTargetId == null) {
            this.blurTarget = null;
        } else {
            this.blurTarget = (ExpoBlurTargetView) getAppContext().findView(blurTargetId.intValue());
        }
        this.blurTargetId = blurTargetId;
        configureBlurView();
    }

    public final void setBlurRadius(float radius) {
        this.blurRadius = radius;
        if (this.blurConfiguration == BlurViewConfiguration.UNCONFIGURED) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.blurMethod.ordinal()];
        if (i == 1) {
            applyBlurViewRadiusCompat(false, radius);
        } else if (i == 2) {
            applyBlurViewRadiusCompat(true, radius);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            applyBlurViewRadiusCompat(Build.VERSION.SDK_INT >= 31, radius);
        }
    }

    public final void setBlurMethod(BlurMethod method) throws BlurViewConfigurationException {
        Intrinsics.checkNotNullParameter(method, "method");
        this.blurMethod = method;
        if (method != BlurMethod.NONE && this.blurConfiguration != BlurViewConfiguration.DIMEZIS) {
            configureBlurView();
            applyTint();
            setBlurRadius(this.blurRadius);
        }
        if (this.blurTarget == null) {
            method = BlurMethod.NONE;
        }
        if (this.blurConfiguration == BlurViewConfiguration.UNCONFIGURED) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[method.ordinal()];
        if (i == 1) {
            this.blurView.setBlurEnabled(false);
        } else if (i == 2) {
            this.blurView.setBlurEnabled(true);
            setBackgroundColor(0);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            boolean z = Build.VERSION.SDK_INT >= 31;
            this.blurView.setBlurEnabled(z);
            if (z) {
                setBackgroundColor(0);
            }
        }
        setBlurRadius(this.blurRadius);
    }

    public final void applyBlurReduction(float reductionFactor) {
        this.blurReduction = reductionFactor;
        setBlurRadius(this.blurRadius);
    }

    public final void applyTint() {
        if (this.blurConfiguration == BlurViewConfiguration.UNCONFIGURED) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.blurMethod.ordinal()];
        if (i == 1) {
            applyBlurViewOverlayColorCompat(false);
        } else if (i == 2) {
            applyBlurViewOverlayColorCompat(true);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            applyBlurViewOverlayColorCompat(Build.VERSION.SDK_INT >= 31);
        }
        this.blurView.invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() throws BlurViewConfigurationException {
        super.onAttachedToWindow();
        if (this.blurConfiguration == BlurViewConfiguration.UNCONFIGURED) {
            configureBlurView();
            applyCurrentBlurSettings();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.needsClippingPathUpdate = true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        for (float f : this.borderRadii) {
            if (f > 0.0f) {
                updateClippingPathIfNeeded();
                int iSave = canvas.save();
                canvas.clipPath(this.clippingPath);
                super.draw(canvas);
                canvas.restoreToCount(iSave);
                return;
            }
        }
        super.draw(canvas);
    }

    private final void configureBlurView() throws BlurViewConfigurationException {
        View decorView;
        BlurTarget blurTargetView;
        if (this.blurTarget == null || this.blurMethod == BlurMethod.NONE) {
            this.blurView.setBlurEnabled(false);
            this.blurConfiguration = BlurViewConfiguration.NONE;
            return;
        }
        Window window = getAppContext().getThrowingActivity().getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            throw new BlurViewConfigurationException("Failed to find a decor view associated with the blur view");
        }
        ExpoBlurTargetView expoBlurTargetView = this.blurTarget;
        if (expoBlurTargetView == null || (blurTargetView = expoBlurTargetView.getBlurTargetView()) == null) {
            throw new BlurViewConfigurationException("The BlurView targeting blur target with id: " + this.blurTargetId + " couldn't find the target");
        }
        this.blurView.setupWith(blurTargetView).setFrameClearDrawable(decorView.getBackground()).setBlurRadius(this.blurRadius / this.blurReduction);
        this.blurConfiguration = BlurViewConfiguration.DIMEZIS;
    }

    private final void applyCurrentBlurSettings() throws BlurViewConfigurationException {
        setBlurRadius(this.blurRadius);
        setBlurMethod(this.blurMethod);
        applyTint();
    }

    private final void applyBlurViewRadiusCompat(boolean useBlur, float radius) {
        if (useBlur && this.blurTarget != null) {
            this.blurView.setBlurEnabled(!(radius == 0.0f));
            if (radius > 0.0f) {
                this.blurView.setBlurRadius(radius / this.blurReduction);
                this.blurView.invalidate();
                return;
            }
            return;
        }
        setBackgroundColor(this.tint.toBlurEffect(radius));
    }

    private final void applyBlurViewOverlayColorCompat(boolean useBlurView) {
        if (useBlurView && this.blurTarget != null) {
            this.blurView.setOverlayColor(this.tint.toBlurEffect(this.blurRadius));
        } else {
            setBackgroundColor(this.tint.toBlurEffect(this.blurRadius));
        }
    }

    private final void updateClippingPathIfNeeded() {
        if (this.needsClippingPathUpdate) {
            this.clippingRect.set(0.0f, 0.0f, getWidth(), getHeight());
            this.clippingPath.reset();
            this.clippingPath.addRoundRect(this.clippingRect, this.borderRadii, Path.Direction.CW);
            this.needsClippingPathUpdate = false;
        }
    }
}
