package eightbitlab.com.blurview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import com.eightbitlab.blurview.R;

/* JADX INFO: loaded from: classes6.dex */
class Noise {
    private static Paint noisePaint;

    Noise() {
    }

    static void apply(Canvas canvas, Context context, int i, int i2) {
        initPaint(context);
        canvas.drawRect(0.0f, 0.0f, i, i2, noisePaint);
    }

    private static void initPaint(Context context) {
        if (noisePaint == null) {
            Bitmap noiseBitmap = getNoiseBitmap(context);
            Paint paint = new Paint();
            noisePaint = paint;
            paint.setAntiAlias(true);
            noisePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            noisePaint.setShader(new BitmapShader(noiseBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
        }
    }

    private static Bitmap getNoiseBitmap(Context context) {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.blue_noise);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAlpha(38);
        canvas.drawBitmap(bitmapDecodeResource, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }
}
