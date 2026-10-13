package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.preparation.loadframe.FpsCompressorInfo;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimationLoaderFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoaderFactory;", "", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "maxFpsRender", "", "bufferLengthMilliseconds", "enableBufferFrameLoaderFix", "", "frameLoaderListener", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoaderListener;", "enableSingleFrameRendering", "<init>", "(Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;IIZLcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoaderListener;Z)V", "createBufferLoader", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoader;", "cacheKey", "", "bitmapFrameRenderer", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameRenderer;", "animationInformation", "Lcom/facebook/fresco/animation/backend/AnimationInformation;", "Companion", "animated-drawable_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FrameLoaderFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConcurrentHashMap<String, UnusedFrameLoader> UNUSED_FRAME_LOADERS = new ConcurrentHashMap<>();
    private final int bufferLengthMilliseconds;
    private final boolean enableBufferFrameLoaderFix;
    private final boolean enableSingleFrameRendering;
    private final FrameLoaderListener frameLoaderListener;
    private final int maxFpsRender;
    private final PlatformBitmapFactory platformBitmapFactory;

    public FrameLoaderFactory(PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z, FrameLoaderListener frameLoaderListener, boolean z2) {
        Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        this.platformBitmapFactory = platformBitmapFactory;
        this.maxFpsRender = i;
        this.bufferLengthMilliseconds = i2;
        this.enableBufferFrameLoaderFix = z;
        this.frameLoaderListener = frameLoaderListener;
        this.enableSingleFrameRendering = z2;
    }

    public /* synthetic */ FrameLoaderFactory(PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z, FrameLoaderListener frameLoaderListener, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(platformBitmapFactory, i, i2, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? null : frameLoaderListener, (i3 & 32) != 0 ? false : z2);
    }

    public final FrameLoader createBufferLoader(String cacheKey, BitmapFrameRenderer bitmapFrameRenderer, AnimationInformation animationInformation) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(bitmapFrameRenderer, "bitmapFrameRenderer");
        Intrinsics.checkNotNullParameter(animationInformation, "animationInformation");
        ConcurrentHashMap<String, UnusedFrameLoader> concurrentHashMap = UNUSED_FRAME_LOADERS;
        synchronized (concurrentHashMap) {
            UnusedFrameLoader unusedFrameLoader = concurrentHashMap.get(cacheKey);
            if (unusedFrameLoader != null) {
                concurrentHashMap.remove(cacheKey);
                return unusedFrameLoader.getFrameLoader();
            }
            Unit unit = Unit.INSTANCE;
            return new BufferFrameLoader(this.platformBitmapFactory, bitmapFrameRenderer, new FpsCompressorInfo(this.maxFpsRender), animationInformation, this.bufferLengthMilliseconds, this.enableBufferFrameLoaderFix, this.frameLoaderListener, this.enableSingleFrameRendering);
        }
    }

    /* JADX INFO: compiled from: AnimationLoaderFactory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoaderFactory$Companion;", "", "<init>", "()V", "UNUSED_FRAME_LOADERS", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/UnusedFrameLoader;", "saveUnusedFrame", "", "cacheKey", "frameLoader", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoader;", "clearUnusedUntil", "until", "Ljava/util/Date;", "animated-drawable_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void saveUnusedFrame(String cacheKey, FrameLoader frameLoader) {
            Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
            Intrinsics.checkNotNullParameter(frameLoader, "frameLoader");
            FrameLoaderFactory.UNUSED_FRAME_LOADERS.put(cacheKey, new UnusedFrameLoader(frameLoader, new Date()));
        }

        public final void clearUnusedUntil(Date until) {
            Intrinsics.checkNotNullParameter(until, "until");
            synchronized (FrameLoaderFactory.UNUSED_FRAME_LOADERS) {
                ConcurrentHashMap concurrentHashMap = FrameLoaderFactory.UNUSED_FRAME_LOADERS;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : concurrentHashMap.entrySet()) {
                    if (((UnusedFrameLoader) entry.getValue()).getInsertedTime().compareTo(until) < 0) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    ((UnusedFrameLoader) entry2.getValue()).getFrameLoader().clear();
                    FrameLoaderFactory.UNUSED_FRAME_LOADERS.remove(entry2.getKey());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
