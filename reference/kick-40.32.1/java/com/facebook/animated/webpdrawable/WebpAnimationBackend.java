package com.facebook.animated.webpdrawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.animated.webp.WebPFrame;
import com.facebook.animated.webp.WebPImage;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebpAnimationBackend.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0013H\u0016J\b\u0010$\u001a\u00020\u0013H\u0016J\b\u0010%\u001a\u00020\u0015H\u0016J\u0012\u0010&\u001a\u00020\u00152\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0018\u0010)\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0013H\u0002J\b\u0010*\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/facebook/animated/webpdrawable/WebpAnimationBackend;", "Lcom/facebook/fresco/animation/backend/AnimationBackend;", "webPImage", "Lcom/facebook/animated/webp/WebPImage;", "<init>", "(Lcom/facebook/animated/webp/WebPImage;)V", "renderDstRect", "Landroid/graphics/Rect;", "renderSrcRect", "bounds", "tempBitmap", "Landroid/graphics/Bitmap;", "drawFrame", "", "parent", "Landroid/graphics/drawable/Drawable;", "canvas", "Landroid/graphics/Canvas;", "frameNumber", "", "setAlpha", "", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setBounds", "getIntrinsicWidth", "getIntrinsicHeight", "getSizeInBytes", "clear", "getFrameCount", "getFrameDurationMs", "getLoopDurationMs", ViewProps.WIDTH, ViewProps.HEIGHT, "getLoopCount", "preloadAnimation", "setAnimationListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/fresco/animation/backend/AnimationBackend$Listener;", "prepareTempBitmapForThisSize", "clearTempBitmap", "Companion", "animated-webp_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WebpAnimationBackend implements AnimationBackend {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Rect bounds;
    private final Rect renderDstRect;
    private final Rect renderSrcRect;
    private Bitmap tempBitmap;
    private final WebPImage webPImage;

    public /* synthetic */ WebpAnimationBackend(WebPImage webPImage, DefaultConstructorMarker defaultConstructorMarker) {
        this(webPImage);
    }

    @JvmStatic
    public static final WebpAnimationBackend create(String str) throws IOException {
        return INSTANCE.create(str);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        return 0;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void preloadAnimation() {
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(int alpha) {
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAnimationListener(AnimationBackend.Listener listener) {
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(ColorFilter colorFilter) {
    }

    private WebpAnimationBackend(WebPImage webPImage) {
        this.webPImage = webPImage;
        this.renderDstRect = new Rect();
        this.renderSrcRect = new Rect();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable parent, Canvas canvas, int frameNumber) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        WebPFrame frame = this.webPImage.getFrame(frameNumber);
        Intrinsics.checkNotNullExpressionValue(frame, "getFrame(...)");
        Rect rect = this.bounds;
        Intrinsics.checkNotNull(rect);
        double dWidth = ((double) rect.width()) / ((double) parent.getIntrinsicWidth());
        Rect rect2 = this.bounds;
        Intrinsics.checkNotNull(rect2);
        double dHeight = ((double) rect2.height()) / ((double) parent.getIntrinsicHeight());
        int iRound = (int) Math.round(((double) frame.getFrameWidth()) * dWidth);
        int iRound2 = (int) Math.round(((double) frame.getFrameHeight()) * dHeight);
        int xOffset = (int) (((double) frame.getXOffset()) * dWidth);
        int yOffset = (int) (((double) frame.getYOffset()) * dHeight);
        synchronized (this) {
            Rect rect3 = this.bounds;
            Intrinsics.checkNotNull(rect3);
            int iWidth = rect3.width();
            Rect rect4 = this.bounds;
            Intrinsics.checkNotNull(rect4);
            int iHeight = rect4.height();
            prepareTempBitmapForThisSize(iWidth, iHeight);
            Bitmap bitmap = this.tempBitmap;
            if (bitmap == null) {
                return false;
            }
            Intrinsics.checkNotNull(bitmap);
            frame.renderFrame(iRound, iRound2, bitmap);
            this.renderSrcRect.set(0, 0, iWidth, iHeight);
            this.renderDstRect.set(xOffset, yOffset, iWidth + xOffset, iHeight + yOffset);
            Bitmap bitmap2 = this.tempBitmap;
            Intrinsics.checkNotNull(bitmap2);
            canvas.drawBitmap(bitmap2, this.renderSrcRect, this.renderDstRect, (Paint) null);
            Unit unit = Unit.INSTANCE;
            return true;
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public synchronized void setBounds(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        this.bounds = bounds;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    /* JADX INFO: renamed from: getIntrinsicWidth */
    public int getBitmapWidth() {
        return this.webPImage.getWidth();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    /* JADX INFO: renamed from: getIntrinsicHeight */
    public int getBitmapHeight() {
        return this.webPImage.getHeight();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        this.webPImage.dispose();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        return this.webPImage.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int frameNumber) {
        return this.webPImage.get_frameDurations()[frameNumber];
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopDurationMs() {
        return this.webPImage.get_duration();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int width() {
        return this.webPImage.getWidth();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int height() {
        return this.webPImage.getHeight();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        return this.webPImage.get_loopCount();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0019 A[Catch: all -> 0x0033, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000e, B:9:0x0019, B:10:0x001c, B:12:0x0020, B:13:0x0028), top: B:19:0x0001 }] */
    private final synchronized void prepareTempBitmapForThisSize(int width, int height) {
        Bitmap bitmap = this.tempBitmap;
        if (bitmap != null) {
            Intrinsics.checkNotNull(bitmap);
            if (bitmap.getWidth() >= width) {
                Bitmap bitmap2 = this.tempBitmap;
                Intrinsics.checkNotNull(bitmap2);
                if (bitmap2.getHeight() < height) {
                    clearTempBitmap();
                }
            } else {
                clearTempBitmap();
            }
        }
        if (this.tempBitmap == null) {
            this.tempBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        }
        Bitmap bitmap3 = this.tempBitmap;
        Intrinsics.checkNotNull(bitmap3);
        bitmap3.eraseColor(0);
    }

    private final synchronized void clearTempBitmap() {
        Bitmap bitmap = this.tempBitmap;
        if (bitmap != null) {
            Intrinsics.checkNotNull(bitmap);
            bitmap.recycle();
            this.tempBitmap = null;
        }
    }

    /* JADX INFO: compiled from: WebpAnimationBackend.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/facebook/animated/webpdrawable/WebpAnimationBackend$Companion;", "", "<init>", "()V", "create", "Lcom/facebook/animated/webpdrawable/WebpAnimationBackend;", "filePath", "", "closeSilently", "", "closeable", "Ljava/io/Closeable;", "animated-webp_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final WebpAnimationBackend create(String filePath) throws Throwable {
            BufferedInputStream bufferedInputStream = null;
            Object[] objArr = 0;
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(filePath));
                try {
                    bufferedInputStream2.mark(Integer.MAX_VALUE);
                    byte[] bArr = new byte[bufferedInputStream2.available()];
                    bufferedInputStream2.read(bArr);
                    WebPImage webPImageCreateFromByteArray = WebPImage.createFromByteArray(bArr, null);
                    Intrinsics.checkNotNullExpressionValue(webPImageCreateFromByteArray, "createFromByteArray(...)");
                    bufferedInputStream2.reset();
                    WebpAnimationBackend webpAnimationBackend = new WebpAnimationBackend(webPImageCreateFromByteArray, objArr == true ? 1 : 0);
                    closeSilently(bufferedInputStream2);
                    return webpAnimationBackend;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    closeSilently(bufferedInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        private final void closeSilently(Closeable closeable) {
            if (closeable == null) {
                return;
            }
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
