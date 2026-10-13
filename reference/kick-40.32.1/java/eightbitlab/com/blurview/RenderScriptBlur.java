package eightbitlab.com.blurview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;

/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public class RenderScriptBlur implements BlurAlgorithm {
    private final ScriptIntrinsicBlur blurScript;
    private Allocation outAllocation;
    private final RenderScript renderScript;
    private final Paint paint = new Paint(2);
    private int lastBitmapWidth = -1;
    private int lastBitmapHeight = -1;

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public boolean canModifyBitmap() {
        return true;
    }

    public RenderScriptBlur(Context context) {
        RenderScript renderScriptCreate = RenderScript.create(context);
        this.renderScript = renderScriptCreate;
        this.blurScript = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
    }

    private boolean canReuseAllocation(Bitmap bitmap) {
        return bitmap.getHeight() == this.lastBitmapHeight && bitmap.getWidth() == this.lastBitmapWidth;
    }

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public Bitmap blur(Bitmap bitmap, float f) {
        try {
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(this.renderScript, bitmap);
            if (!canReuseAllocation(bitmap)) {
                Allocation allocation = this.outAllocation;
                if (allocation != null) {
                    allocation.destroy();
                }
                this.outAllocation = Allocation.createTyped(this.renderScript, allocationCreateFromBitmap.getType());
                this.lastBitmapWidth = bitmap.getWidth();
                this.lastBitmapHeight = bitmap.getHeight();
            }
            this.blurScript.setRadius(Math.min(f, 25.0f));
            this.blurScript.setInput(allocationCreateFromBitmap);
            this.blurScript.forEach(this.outAllocation);
            this.outAllocation.copyTo(bitmap);
            allocationCreateFromBitmap.destroy();
            return bitmap;
        } catch (Exception e) {
            Log.e("BlurView", "RenderScript blur failed. Rendering unblurred snapshot", e);
            return bitmap;
        }
    }

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public final void destroy() {
        this.blurScript.destroy();
        this.renderScript.destroy();
        Allocation allocation = this.outAllocation;
        if (allocation != null) {
            allocation.destroy();
        }
    }

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public Bitmap.Config getSupportedBitmapConfig() {
        return Bitmap.Config.ARGB_8888;
    }

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public void render(Canvas canvas, Bitmap bitmap) {
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.paint);
    }
}
