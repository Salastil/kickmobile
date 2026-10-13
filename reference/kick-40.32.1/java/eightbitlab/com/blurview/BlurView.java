package eightbitlab.com.blurview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import com.eightbitlab.blurview.R;

/* JADX INFO: loaded from: classes9.dex */
public class BlurView extends FrameLayout {
    private boolean blurAutoUpdate;
    BlurController blurController;
    private int overlayColor;

    public BlurView(Context context) {
        super(context);
        this.blurController = new NoOpController();
        this.blurAutoUpdate = true;
        init(null, 0);
    }

    public BlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blurController = new NoOpController();
        this.blurAutoUpdate = true;
        init(attributeSet, 0);
    }

    public BlurView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.blurController = new NoOpController();
        this.blurAutoUpdate = true;
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BlurView, i, 0);
        this.overlayColor = typedArrayObtainStyledAttributes.getColor(R.styleable.BlurView_blurOverlayColor, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.blurController.draw(canvas)) {
            super.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.blurController.updateBlurViewSize();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.blurController.setBlurAutoUpdate(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            Log.e("BlurView", "BlurView can't be used in not hardware-accelerated window!");
        } else {
            this.blurController.setBlurAutoUpdate(this.blurAutoUpdate);
        }
    }

    public BlurViewFacade setupWith(BlurTarget blurTarget, BlurAlgorithm blurAlgorithm, float f, boolean z) {
        this.blurController.destroy();
        if (BlurTarget.canUseHardwareRendering) {
            this.blurController = new RenderNodeBlurController(this, blurTarget, this.overlayColor, f, z);
        } else {
            this.blurController = new PreDrawBlurController(this, blurTarget, this.overlayColor, blurAlgorithm, f, z);
        }
        return this.blurController;
    }

    public BlurViewFacade setupWith(BlurTarget blurTarget, float f, boolean z) {
        return setupWith(blurTarget, BlurTarget.canUseHardwareRendering ? null : new RenderScriptBlur(getContext()), f, z);
    }

    public BlurViewFacade setupWith(BlurTarget blurTarget) {
        return setupWith(blurTarget, 4.0f, true);
    }

    public BlurViewFacade setBlurRadius(float f) {
        return this.blurController.setBlurRadius(f);
    }

    public BlurViewFacade setOverlayColor(int i) {
        this.overlayColor = i;
        return this.blurController.setOverlayColor(i);
    }

    public BlurViewFacade setBlurAutoUpdate(boolean z) {
        this.blurAutoUpdate = z;
        return this.blurController.setBlurAutoUpdate(z);
    }

    public BlurViewFacade setBlurEnabled(boolean z) {
        return this.blurController.setBlurEnabled(z);
    }

    @Override // android.view.View
    public void setRotation(float f) {
        super.setRotation(f);
        notifyRotationChanged(f);
    }

    public void notifyRotationChanged(float f) {
        if (usingRenderNode()) {
            ((RenderNodeBlurController) this.blurController).updateRotation(f);
        }
    }

    public void notifyScaleXChanged(float f) {
        if (usingRenderNode()) {
            ((RenderNodeBlurController) this.blurController).updateScaleX(f);
        }
    }

    public void notifyScaleYChanged(float f) {
        if (usingRenderNode()) {
            ((RenderNodeBlurController) this.blurController).updateScaleY(f);
        }
    }

    private boolean usingRenderNode() {
        return this.blurController instanceof RenderNodeBlurController;
    }
}
