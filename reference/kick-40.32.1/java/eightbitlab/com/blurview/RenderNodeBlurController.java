package eightbitlab.com.blurview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ViewTreeObserver;
import androidx.compose.foundation.PreferKeepClearNode$$ExternalSyntheticApiModelOutline0;

/* JADX INFO: loaded from: classes9.dex */
public class RenderNodeBlurController implements BlurController {
    private final boolean applyNoise;
    private final BlurView blurView;
    private Bitmap cachedBitmap;
    private final ViewTreeObserver.OnPreDrawListener drawListener;
    private RenderScriptBlur fallbackBlur;
    private Drawable frameClearDrawable;
    private int overlayColor;
    private final float scaleFactor;
    private final BlurTarget target;
    private final int[] targetLocation = new int[2];
    private final int[] blurViewLocation = new int[2];
    private final RenderNode blurNode = PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m("BlurView node");
    private float blurRadius = 1.0f;
    private boolean enabled = true;

    @Override // eightbitlab.com.blurview.BlurController
    public void updateBlurViewSize() {
    }

    /* JADX INFO: renamed from: lambda$new$0$eightbitlab-com-blurview-RenderNodeBlurController, reason: not valid java name */
    /* synthetic */ boolean m11911lambda$new$0$eightbitlabcomblurviewRenderNodeBlurController() {
        saveOnScreenLocation();
        updateRenderNodeProperties();
        return true;
    }

    public RenderNodeBlurController(BlurView blurView, BlurTarget blurTarget, int i, float f, boolean z) {
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: eightbitlab.com.blurview.RenderNodeBlurController$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return this.f$0.m11911lambda$new$0$eightbitlabcomblurviewRenderNodeBlurController();
            }
        };
        this.drawListener = onPreDrawListener;
        this.blurView = blurView;
        this.overlayColor = i;
        this.target = blurTarget;
        this.scaleFactor = f;
        this.applyNoise = z;
        blurView.setWillNotDraw(false);
        blurView.getViewTreeObserver().addOnPreDrawListener(onPreDrawListener);
    }

    @Override // eightbitlab.com.blurview.BlurController
    public boolean draw(Canvas canvas) {
        if (!this.enabled) {
            return true;
        }
        saveOnScreenLocation();
        if (canvas.isHardwareAccelerated()) {
            hardwarePath(canvas);
        } else {
            softwarePath(canvas);
        }
        return true;
    }

    private void hardwarePath(Canvas canvas) {
        this.blurNode.setPosition(0, 0, this.target.getWidth(), this.target.getHeight());
        updateRenderNodeProperties();
        drawSnapshot();
        canvas.drawRenderNode(this.blurNode);
        if (this.applyNoise) {
            Noise.apply(canvas, this.blurView.getContext(), this.blurView.getWidth(), this.blurView.getHeight());
        }
        int i = this.overlayColor;
        if (i != 0) {
            canvas.drawColor(i);
        }
    }

    private void updateRenderNodeProperties() {
        float f = -getLeft();
        float f2 = -getTop();
        this.blurNode.setPivotX((this.blurView.getWidth() / 2.0f) - f);
        this.blurNode.setPivotY((this.blurView.getHeight() / 2.0f) - f2);
        this.blurNode.setTranslationX(f);
        this.blurNode.setTranslationY(f2);
    }

    private void drawSnapshot() {
        RecordingCanvas recordingCanvasBeginRecording = this.blurNode.beginRecording();
        Drawable drawable = this.frameClearDrawable;
        if (drawable != null) {
            drawable.draw(recordingCanvasBeginRecording);
        }
        recordingCanvasBeginRecording.drawRenderNode(this.target.renderNode);
        applyBlur();
        this.blurNode.endRecording();
    }

    private void softwarePath(Canvas canvas) {
        SizeScaler sizeScaler = new SizeScaler(this.scaleFactor);
        SizeScaler.Size size = new SizeScaler.Size(this.blurView.getWidth(), this.blurView.getHeight());
        SizeScaler.Size sizeScale = sizeScaler.scale(size);
        Bitmap bitmap = this.cachedBitmap;
        if (bitmap == null || bitmap.getWidth() != sizeScale.width || this.cachedBitmap.getHeight() != sizeScale.height) {
            this.cachedBitmap = Bitmap.createBitmap(sizeScale.width, sizeScale.height, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas2 = new Canvas(this.cachedBitmap);
        canvas2.save();
        setupCanvasMatrix(canvas2, size, sizeScale);
        Drawable drawable = this.frameClearDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        try {
            this.target.draw(canvas2);
        } catch (Exception e) {
            Log.e("BlurView", "Error during snapshot capturing", e);
        }
        canvas2.restore();
        if (this.fallbackBlur == null) {
            this.fallbackBlur = new RenderScriptBlur(this.blurView.getContext());
        }
        this.fallbackBlur.blur(this.cachedBitmap, this.blurRadius);
        canvas.save();
        canvas.scale(size.width / sizeScale.width, size.height / sizeScale.height);
        this.fallbackBlur.render(canvas, this.cachedBitmap);
        canvas.restore();
        if (this.applyNoise) {
            Noise.apply(canvas, this.blurView.getContext(), this.blurView.getWidth(), this.blurView.getHeight());
        }
        int i = this.overlayColor;
        if (i != 0) {
            canvas.drawColor(i);
        }
    }

    private void setupCanvasMatrix(Canvas canvas, SizeScaler.Size size, SizeScaler.Size size2) {
        float f = size.height / size2.height;
        float f2 = size.width / size2.width;
        canvas.translate((-getLeft()) / f2, (-getTop()) / f);
        canvas.scale(1.0f / f2, 1.0f / f);
    }

    private int getTop() {
        return this.blurViewLocation[1] - this.targetLocation[1];
    }

    private int getLeft() {
        return this.blurViewLocation[0] - this.targetLocation[0];
    }

    @Override // eightbitlab.com.blurview.BlurController
    public void destroy() {
        this.blurNode.discardDisplayList();
        RenderScriptBlur renderScriptBlur = this.fallbackBlur;
        if (renderScriptBlur != null) {
            renderScriptBlur.destroy();
            this.fallbackBlur = null;
        }
    }

    @Override // eightbitlab.com.blurview.BlurViewFacade
    public BlurViewFacade setBlurEnabled(boolean z) {
        this.enabled = z;
        this.blurView.invalidate();
        return this;
    }

    @Override // eightbitlab.com.blurview.BlurViewFacade
    public BlurViewFacade setBlurAutoUpdate(boolean z) {
        this.blurView.getViewTreeObserver().removeOnPreDrawListener(this.drawListener);
        if (z) {
            this.blurView.getViewTreeObserver().addOnPreDrawListener(this.drawListener);
        }
        return this;
    }

    @Override // eightbitlab.com.blurview.BlurViewFacade
    public BlurViewFacade setFrameClearDrawable(Drawable drawable) {
        this.frameClearDrawable = drawable;
        return this;
    }

    @Override // eightbitlab.com.blurview.BlurViewFacade
    public BlurViewFacade setBlurRadius(float f) {
        this.blurRadius = f;
        applyBlur();
        return this;
    }

    private void applyBlur() {
        float f = this.blurRadius * this.scaleFactor;
        this.blurNode.setRenderEffect(RenderEffect.createBlurEffect(f, f, Shader.TileMode.CLAMP));
    }

    @Override // eightbitlab.com.blurview.BlurViewFacade
    public BlurViewFacade setOverlayColor(int i) {
        if (this.overlayColor != i) {
            this.overlayColor = i;
            this.blurView.invalidate();
        }
        return this;
    }

    void updateRotation(float f) {
        this.blurNode.setRotationZ(-f);
    }

    public void updateScaleX(float f) {
        this.blurNode.setScaleX(1.0f / f);
    }

    public void updateScaleY(float f) {
        this.blurNode.setScaleY(1.0f / f);
    }

    private void saveOnScreenLocation() {
        this.target.getLocationOnScreen(this.targetLocation);
        this.blurView.getLocationOnScreen(this.blurViewLocation);
    }
}
