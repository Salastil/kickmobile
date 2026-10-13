package expo.modules.blur;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import eightbitlab.com.blurview.BlurTarget;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ExpoView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoBlurTargetView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u001c\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020\u0011H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\"\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010#\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010$\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0011H\u0014J0\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0011H\u0014J\u0012\u0010/\u001a\u0002002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u00061"}, d2 = {"Lexpo/modules/blur/ExpoBlurTargetView;", "Lexpo/modules/kotlin/views/ExpoView;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "blurTargetView", "Leightbitlab/com/blurview/BlurTarget;", "getBlurTargetView$expo_blur_release", "()Leightbitlab/com/blurview/BlurTarget;", "addView", "", "child", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "", "params", "Landroid/view/ViewGroup$LayoutParams;", ViewProps.WIDTH, ViewProps.HEIGHT, "updateViewLayout", "view", "removeView", "removeViewAt", "removeViews", ViewProps.START, "count", "removeViewsInLayout", "removeAllViews", "removeAllViewsInLayout", "getChildCount", "getChildAt", "indexOfChild", "startViewTransition", "endViewTransition", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "toHostLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "expo-blur_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpoBlurTargetView extends ExpoView {
    private final BlurTarget blurTargetView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoBlurTargetView(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        UIManagerCompatibleBlurTarget uIManagerCompatibleBlurTarget = new UIManagerCompatibleBlurTarget(appContext, context);
        this.blurTargetView = uIManagerCompatibleBlurTarget;
        super.addView(uIManagerCompatibleBlurTarget, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: renamed from: getBlurTargetView$expo_blur_release, reason: from getter */
    public final BlurTarget getBlurTargetView() {
        return this.blurTargetView;
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        BlurTarget blurTarget = this.blurTargetView;
        if (child == blurTarget) {
            super.addView(child);
        } else {
            blurTarget.addView(child);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        BlurTarget blurTarget = this.blurTargetView;
        if (child == blurTarget) {
            super.addView(child, index);
        } else {
            blurTarget.addView(child, index);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View child, ViewGroup.LayoutParams params) {
        BlurTarget blurTarget = this.blurTargetView;
        if (child == blurTarget) {
            super.addView(child, toHostLayoutParams(params));
        } else {
            blurTarget.addView(child, params);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        BlurTarget blurTarget = this.blurTargetView;
        if (child == blurTarget) {
            super.addView(child, index, toHostLayoutParams(params));
        } else {
            blurTarget.addView(child, index, params);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int width, int height) {
        BlurTarget blurTarget = this.blurTargetView;
        if (child == blurTarget) {
            super.addView(child, width, height);
        } else {
            blurTarget.addView(child, width, height);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void updateViewLayout(View view, ViewGroup.LayoutParams params) {
        BlurTarget blurTarget = this.blurTargetView;
        if (view == blurTarget) {
            super.updateViewLayout(view, toHostLayoutParams(params));
        } else {
            blurTarget.updateViewLayout(view, params);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        BlurTarget blurTarget = this.blurTargetView;
        if (view == blurTarget) {
            super.removeView(view);
        } else {
            blurTarget.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int index) {
        this.blurTargetView.removeViewAt(index);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int start, int count) {
        this.blurTargetView.removeViews(start, count);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int start, int count) {
        this.blurTargetView.removeViewsInLayout(start, count);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        this.blurTargetView.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        this.blurTargetView.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        return this.blurTargetView.getChildCount();
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int index) {
        return this.blurTargetView.getChildAt(index);
    }

    @Override // android.view.ViewGroup
    public int indexOfChild(View child) {
        BlurTarget blurTarget = this.blurTargetView;
        if (child == blurTarget) {
            return super.indexOfChild(child);
        }
        return blurTarget.indexOfChild(child);
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        BlurTarget blurTarget = this.blurTargetView;
        if (view == blurTarget) {
            super.startViewTransition(view);
        } else {
            blurTarget.startViewTransition(view);
        }
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        BlurTarget blurTarget = this.blurTargetView;
        if (view == blurTarget) {
            super.endViewTransition(view);
        } else {
            blurTarget.endViewTransition(view);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(size, size2);
        this.blurTargetView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.blurTargetView.layout(0, 0, right - left, bottom - top);
    }

    private final LinearLayout.LayoutParams toHostLayoutParams(ViewGroup.LayoutParams params) {
        if (params == null) {
            return new LinearLayout.LayoutParams(-1, -1);
        }
        return params instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) params : new LinearLayout.LayoutParams(params);
    }
}
