package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.preparation.loadframe.AnimationLoaderExecutor;
import com.facebook.fresco.animation.bitmap.preparation.loadframe.FpsCompressorInfo;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BufferFrameLoader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0002>?BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J \u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0017J\u0018\u0010+\u001a\u00020'2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0003J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\u000bH\u0003J&\u0010.\u001a\u00020/2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\f\u00100\u001a\b\u0012\u0004\u0012\u00020/01H\u0017J\u0010\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020\u000bH\u0016J\b\u00104\u001a\u00020/H\u0016J\u0018\u00105\u001a\u00020/2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0002J*\u00106\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\b\b\u0002\u00107\u001a\u00020\u000bH\u0003J.\u00108\u001a\u00020/2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0002J\u0012\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010-\u001a\u00020\u000bH\u0002J\u0012\u00104\u001a\u00020/*\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J \u0010<\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010=\u001a\u00020\u0019H\u0002J\f\u00103\u001a\u00020\u000b*\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/BufferFrameLoader;", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoader;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "bitmapFrameRenderer", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameRenderer;", "fpsCompressor", "Lcom/facebook/fresco/animation/bitmap/preparation/loadframe/FpsCompressorInfo;", "animationInformation", "Lcom/facebook/fresco/animation/backend/AnimationInformation;", "bufferLengthMilliseconds", "", "enableBufferFrameLoaderFix", "", "frameLoaderListener", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoaderListener;", "enableSingleFrameRendering", "<init>", "(Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;Lcom/facebook/fresco/animation/bitmap/BitmapFrameRenderer;Lcom/facebook/fresco/animation/bitmap/preparation/loadframe/FpsCompressorInfo;Lcom/facebook/fresco/animation/backend/AnimationInformation;IZLcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoaderListener;Z)V", "getAnimationInformation", "()Lcom/facebook/fresco/animation/backend/AnimationInformation;", "bufferSize", "isSingleFrame", "singleFrameRef", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "bufferFramesHash", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/BufferFrameLoader$BufferFrame;", "thresholdFrame", "isFetching", "frameSequence", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/CircularList;", "lastRenderedFrameNumber", "compressionFrameMap", "", "renderableFrameIndexes", "", "getFrame", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameResult;", "frameNumber", ViewProps.WIDTH, ViewProps.HEIGHT, "getSingleFrame", "findNearestToRender", "targetFrame", "prepareFrames", "", "onAnimationLoaded", "Lkotlin/Function0;", "compressToFps", "fps", "clear", "loadNextFrames", "extractDemandedFrame", "count", "obtainFrame", "targetBitmap", "findNearestFrame", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/AnimationBitmapFrame;", "set", "src", "BufferFrame", "Companion", "animated-drawable_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BufferFrameLoader implements FrameLoader {
    private static final float THRESHOLD_PERCENTAGE = 0.5f;
    private final AnimationInformation animationInformation;
    private final BitmapFrameRenderer bitmapFrameRenderer;
    private final ConcurrentHashMap<Integer, BufferFrame> bufferFramesHash;
    private final int bufferLengthMilliseconds;
    private final int bufferSize;
    private volatile Map<Integer, Integer> compressionFrameMap;
    private final boolean enableBufferFrameLoaderFix;
    private final boolean enableSingleFrameRendering;
    private final FpsCompressorInfo fpsCompressor;
    private final FrameLoaderListener frameLoaderListener;
    private final CircularList frameSequence;
    private volatile boolean isFetching;
    private final boolean isSingleFrame;
    private int lastRenderedFrameNumber;
    private final PlatformBitmapFactory platformBitmapFactory;
    private volatile Set<Integer> renderableFrameIndexes;
    private volatile CloseableReference<Bitmap> singleFrameRef;
    private volatile int thresholdFrame;

    public BufferFrameLoader(PlatformBitmapFactory platformBitmapFactory, BitmapFrameRenderer bitmapFrameRenderer, FpsCompressorInfo fpsCompressor, AnimationInformation animationInformation, int i, boolean z, FrameLoaderListener frameLoaderListener, boolean z2) {
        Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        Intrinsics.checkNotNullParameter(bitmapFrameRenderer, "bitmapFrameRenderer");
        Intrinsics.checkNotNullParameter(fpsCompressor, "fpsCompressor");
        Intrinsics.checkNotNullParameter(animationInformation, "animationInformation");
        this.platformBitmapFactory = platformBitmapFactory;
        this.bitmapFrameRenderer = bitmapFrameRenderer;
        this.fpsCompressor = fpsCompressor;
        this.animationInformation = animationInformation;
        this.bufferLengthMilliseconds = i;
        this.enableBufferFrameLoaderFix = z;
        this.frameLoaderListener = frameLoaderListener;
        this.enableSingleFrameRendering = z2;
        int iCoerceAtLeast = RangesKt.coerceAtLeast((fps(getAnimationInformation()) * i) / 1000, 1);
        this.bufferSize = iCoerceAtLeast;
        this.isSingleFrame = z2 && getAnimationInformation().getFrameCount() == 1;
        this.bufferFramesHash = new ConcurrentHashMap<>();
        this.frameSequence = new CircularList(getAnimationInformation().getFrameCount());
        this.lastRenderedFrameNumber = -1;
        this.compressionFrameMap = MapsKt.emptyMap();
        this.renderableFrameIndexes = SetsKt.emptySet();
        compressToFps(fps(getAnimationInformation()));
        this.thresholdFrame = (int) (iCoerceAtLeast * 0.5f);
    }

    public /* synthetic */ BufferFrameLoader(PlatformBitmapFactory platformBitmapFactory, BitmapFrameRenderer bitmapFrameRenderer, FpsCompressorInfo fpsCompressorInfo, AnimationInformation animationInformation, int i, boolean z, FrameLoaderListener frameLoaderListener, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(platformBitmapFactory, bitmapFrameRenderer, fpsCompressorInfo, animationInformation, i, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? null : frameLoaderListener, (i2 & 128) != 0 ? false : z2);
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public void onStop() {
        super.onStop();
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public AnimationInformation getAnimationInformation() {
        return this.animationInformation;
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public FrameResult getFrame(int frameNumber, int width, int height) {
        if (this.isSingleFrame) {
            return getSingleFrame(width, height);
        }
        Integer num = this.compressionFrameMap.get(Integer.valueOf(frameNumber));
        if (this.enableBufferFrameLoaderFix && (width == 0 || height == 0)) {
            FrameLoaderListener frameLoaderListener = this.frameLoaderListener;
            if (frameLoaderListener != null) {
                frameLoaderListener.onZeroFrameDimensions("BufferFrameLoader.getFrame", frameNumber, width, height);
            }
            return findNearestToRender(frameNumber);
        }
        if (num == null) {
            return findNearestToRender(frameNumber);
        }
        this.lastRenderedFrameNumber = num.intValue();
        BufferFrame bufferFrame = this.bufferFramesHash.get(num);
        if (bufferFrame == null || !bufferFrame.isFrameAvailable()) {
            bufferFrame = null;
        }
        if (bufferFrame != null) {
            if (this.frameSequence.isTargetAhead(this.thresholdFrame, num.intValue(), this.bufferSize)) {
                loadNextFrames(width, height);
            }
            return new FrameResult(bufferFrame.getBitmapRef().mo11277clone(), FrameResult.FrameType.SUCCESS);
        }
        loadNextFrames(width, height);
        return findNearestToRender(num.intValue());
    }

    private final FrameResult getSingleFrame(int width, int height) {
        CloseableReference<Bitmap> closeableReferenceCloneOrNull;
        FrameLoaderListener frameLoaderListener = this.frameLoaderListener;
        if (frameLoaderListener != null) {
            frameLoaderListener.onSingleFrameRender("BufferFrameLoader.getSingleFrame", width, height);
        }
        CloseableReference<Bitmap> closeableReference = this.singleFrameRef;
        if (closeableReference != null && (closeableReferenceCloneOrNull = closeableReference.cloneOrNull()) != null) {
            return new FrameResult(closeableReferenceCloneOrNull, FrameResult.FrameType.SUCCESS);
        }
        if (width == 0 || height == 0) {
            return new FrameResult(null, FrameResult.FrameType.MISSING);
        }
        CloseableReference<Bitmap> closeableReferenceCreateBitmap = this.platformBitmapFactory.createBitmap(width, height);
        Intrinsics.checkNotNullExpressionValue(closeableReferenceCreateBitmap, "createBitmap(...)");
        BitmapFrameRenderer bitmapFrameRenderer = this.bitmapFrameRenderer;
        Bitmap bitmap = closeableReferenceCreateBitmap.get();
        Intrinsics.checkNotNullExpressionValue(bitmap, "get(...)");
        bitmapFrameRenderer.renderFrame(0, bitmap);
        this.singleFrameRef = closeableReferenceCreateBitmap;
        return new FrameResult(closeableReferenceCreateBitmap.mo11277clone(), FrameResult.FrameType.SUCCESS);
    }

    private final FrameResult findNearestToRender(int targetFrame) {
        AnimationBitmapFrame animationBitmapFrameFindNearestFrame = findNearestFrame(targetFrame);
        if (animationBitmapFrameFindNearestFrame != null) {
            CloseableReference<Bitmap> closeableReferenceMo11277clone = animationBitmapFrameFindNearestFrame.getBitmap().mo11277clone();
            Intrinsics.checkNotNullExpressionValue(closeableReferenceMo11277clone, "clone(...)");
            this.lastRenderedFrameNumber = animationBitmapFrameFindNearestFrame.getFrameNumber();
            return new FrameResult(closeableReferenceMo11277clone, FrameResult.FrameType.NEAREST);
        }
        return new FrameResult(null, FrameResult.FrameType.MISSING);
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public void prepareFrames(int width, int height, Function0<Unit> onAnimationLoaded) {
        Intrinsics.checkNotNullParameter(onAnimationLoaded, "onAnimationLoaded");
        if (this.isSingleFrame) {
            onAnimationLoaded.invoke();
        } else {
            loadNextFrames(width, height);
            onAnimationLoaded.invoke();
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public void compressToFps(int fps) {
        this.compressionFrameMap = this.fpsCompressor.calculateReducedIndexes(getAnimationInformation().getLoopDurationMs() * RangesKt.coerceAtLeast(getAnimationInformation().getLoopCount(), 1), getAnimationInformation().getFrameCount(), RangesKt.coerceAtMost(fps, fps(getAnimationInformation())));
        this.renderableFrameIndexes = CollectionsKt.toSet(this.compressionFrameMap.values());
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public void clear() {
        CloseableReference.closeSafely(this.singleFrameRef);
        this.singleFrameRef = null;
        Collection<BufferFrame> collectionValues = this.bufferFramesHash.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((BufferFrame) it.next()).release();
        }
        this.bufferFramesHash.clear();
        this.lastRenderedFrameNumber = -1;
    }

    private final void loadNextFrames(final int width, final int height) {
        if ((this.enableBufferFrameLoaderFix && (width == 0 || height == 0)) || this.isFetching) {
            FrameLoaderListener frameLoaderListener = this.frameLoaderListener;
            if (frameLoaderListener != null) {
                frameLoaderListener.onZeroFrameDimensions("BufferFrameLoader.loadNextFrames", RangesKt.coerceAtLeast(this.lastRenderedFrameNumber, 0), width, height);
                return;
            }
            return;
        }
        this.isFetching = true;
        AnimationLoaderExecutor.INSTANCE.execute(new Runnable() { // from class: com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BufferFrameLoader.loadNextFrames$lambda$3(this.f$0, width, height);
            }
        });
    }

    static final void loadNextFrames$lambda$3(BufferFrameLoader bufferFrameLoader, int i, int i2) {
        while (true) {
            BufferFrameLoader bufferFrameLoader2 = bufferFrameLoader;
            int i3 = i;
            int i4 = i2;
            if (extractDemandedFrame$default(bufferFrameLoader2, RangesKt.coerceAtLeast(bufferFrameLoader.lastRenderedFrameNumber, 0), i3, i4, 0, 8, null)) {
                bufferFrameLoader2.isFetching = false;
                return;
            } else {
                bufferFrameLoader = bufferFrameLoader2;
                i = i3;
                i2 = i4;
            }
        }
    }

    static /* synthetic */ boolean extractDemandedFrame$default(BufferFrameLoader bufferFrameLoader, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        return bufferFrameLoader.extractDemandedFrame(i, i2, i3, i4);
    }

    private final boolean extractDemandedFrame(int targetFrame, int width, int height, int count) {
        int iIntValue;
        CloseableReference<Bitmap> bitmapRef;
        List<Integer> listSublist = this.frameSequence.sublist(targetFrame, this.bufferSize);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSublist) {
            if (this.renderableFrameIndexes.contains(Integer.valueOf(((Number) obj).intValue()))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = arrayList2;
        Set set = CollectionsKt.toSet(arrayList3);
        Set<Integer> setKeySet = this.bufferFramesHash.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        ArrayDeque arrayDeque = new ArrayDeque(SetsKt.minus((Set) setKeySet, (Iterable) set));
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            int iIntValue2 = ((Number) it.next()).intValue();
            if (this.bufferFramesHash.get(Integer.valueOf(iIntValue2)) == null) {
                int i = this.lastRenderedFrameNumber;
                if (i != -1 && !set.contains(Integer.valueOf(i))) {
                    return false;
                }
                Integer num = (Integer) arrayDeque.pollFirst();
                int iIntValue3 = num != null ? num.intValue() : -1;
                BufferFrame bufferFrame = this.bufferFramesHash.get(Integer.valueOf(iIntValue3));
                CloseableReference<Bitmap> closeableReferenceCloneOrNull = (bufferFrame == null || (bitmapRef = bufferFrame.getBitmapRef()) == null) ? null : bitmapRef.cloneOrNull();
                if (closeableReferenceCloneOrNull == null) {
                    CloseableReference<Bitmap> closeableReferenceCreateBitmap = this.platformBitmapFactory.createBitmap(width, height);
                    Intrinsics.checkNotNullExpressionValue(closeableReferenceCreateBitmap, "createBitmap(...)");
                    bufferFrame = new BufferFrame(closeableReferenceCreateBitmap);
                    closeableReferenceCloneOrNull = bufferFrame.getBitmapRef().mo11277clone();
                    Intrinsics.checkNotNullExpressionValue(closeableReferenceCloneOrNull, "clone(...)");
                }
                bufferFrame.setUpdatingFrame(true);
                CloseableReference<Bitmap> closeableReference = closeableReferenceCloneOrNull;
                try {
                    obtainFrame(closeableReference, iIntValue2, width, height);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(closeableReference, null);
                    this.bufferFramesHash.remove(Integer.valueOf(iIntValue3));
                    bufferFrame.setUpdatingFrame(false);
                    this.bufferFramesHash.put(Integer.valueOf(iIntValue2), bufferFrame);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(closeableReference, th);
                        throw th2;
                    }
                }
            }
        }
        if (arrayList2.isEmpty()) {
            iIntValue = (int) (this.bufferSize * 0.5f);
        } else {
            int size = arrayList2.size();
            iIntValue = ((Number) arrayList2.get(RangesKt.coerceIn((int) (size * 0.5f), 0, size - 1))).intValue();
        }
        this.thresholdFrame = iIntValue;
        return true;
    }

    private final void obtainFrame(CloseableReference<Bitmap> targetBitmap, int targetFrame, int width, int height) {
        CloseableReference<Bitmap> bitmap;
        CloseableReference<Bitmap> closeableReferenceCloneOrNull;
        AnimationBitmapFrame animationBitmapFrameFindNearestFrame = findNearestFrame(targetFrame);
        if (animationBitmapFrameFindNearestFrame != null && (bitmap = animationBitmapFrameFindNearestFrame.getBitmap()) != null && (closeableReferenceCloneOrNull = bitmap.cloneOrNull()) != null) {
            CloseableReference<Bitmap> closeableReference = closeableReferenceCloneOrNull;
            try {
                CloseableReference<Bitmap> closeableReference2 = closeableReference;
                int frameNumber = animationBitmapFrameFindNearestFrame.getFrameNumber();
                if (frameNumber < targetFrame) {
                    Bitmap bitmap2 = closeableReference2.get();
                    Intrinsics.checkNotNullExpressionValue(bitmap2, "get(...)");
                    set(targetBitmap, bitmap2);
                    Iterator<Integer> it = new IntRange(frameNumber + 1, targetFrame).iterator();
                    while (it.hasNext()) {
                        int iNextInt = ((IntIterator) it).nextInt();
                        BitmapFrameRenderer bitmapFrameRenderer = this.bitmapFrameRenderer;
                        Bitmap bitmap3 = targetBitmap.get();
                        Intrinsics.checkNotNullExpressionValue(bitmap3, "get(...)");
                        bitmapFrameRenderer.renderFrame(iNextInt, bitmap3);
                    }
                    CloseableKt.closeFinally(closeableReference, null);
                    return;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(closeableReference, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(closeableReference, th);
                    throw th2;
                }
            }
        }
        clear(targetBitmap);
        Iterator<Integer> it2 = new IntRange(0, targetFrame).iterator();
        while (it2.hasNext()) {
            int iNextInt2 = ((IntIterator) it2).nextInt();
            BitmapFrameRenderer bitmapFrameRenderer2 = this.bitmapFrameRenderer;
            Bitmap bitmap4 = targetBitmap.get();
            Intrinsics.checkNotNullExpressionValue(bitmap4, "get(...)");
            bitmapFrameRenderer2.renderFrame(iNextInt2, bitmap4);
        }
    }

    private final AnimationBitmapFrame findNearestFrame(int targetFrame) {
        AnimationBitmapFrame animationBitmapFrame;
        Iterator<Integer> it = new IntRange(0, this.frameSequence.getSize()).iterator();
        do {
            animationBitmapFrame = null;
            if (!it.hasNext()) {
                break;
            }
            int position = this.frameSequence.getPosition(targetFrame - ((IntIterator) it).nextInt());
            BufferFrame bufferFrame = this.bufferFramesHash.get(Integer.valueOf(position));
            if (bufferFrame != null) {
                if (!bufferFrame.isFrameAvailable()) {
                    bufferFrame = null;
                }
                if (bufferFrame != null) {
                    animationBitmapFrame = new AnimationBitmapFrame(position, bufferFrame.getBitmapRef());
                }
            }
        } while (animationBitmapFrame == null);
        return animationBitmapFrame;
    }

    private final void clear(CloseableReference<Bitmap> closeableReference) {
        if (closeableReference.isValid()) {
            new Canvas(closeableReference.get()).drawColor(0, PorterDuff.Mode.CLEAR);
        }
    }

    private final CloseableReference<Bitmap> set(CloseableReference<Bitmap> closeableReference, Bitmap bitmap) {
        if (closeableReference.isValid() && !Intrinsics.areEqual(closeableReference.get(), bitmap)) {
            Canvas canvas = new Canvas(closeableReference.get());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
        return closeableReference;
    }

    private final int fps(AnimationInformation animationInformation) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (int) RangesKt.coerceAtLeast(1000 / ((long) (animationInformation.getLoopDurationMs() / animationInformation.getFrameCount())), 1L);
    }

    /* JADX INFO: compiled from: BufferFrameLoader.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/BufferFrameLoader$BufferFrame;", "", "bitmapRef", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "<init>", "(Lcom/facebook/common/references/CloseableReference;)V", "getBitmapRef", "()Lcom/facebook/common/references/CloseableReference;", "isUpdatingFrame", "", "()Z", "setUpdatingFrame", "(Z)V", "isFrameAvailable", "release", "", "animated-drawable_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class BufferFrame {
        private final CloseableReference<Bitmap> bitmapRef;
        private boolean isUpdatingFrame;

        public BufferFrame(CloseableReference<Bitmap> bitmapRef) {
            Intrinsics.checkNotNullParameter(bitmapRef, "bitmapRef");
            this.bitmapRef = bitmapRef;
        }

        public final CloseableReference<Bitmap> getBitmapRef() {
            return this.bitmapRef;
        }

        /* JADX INFO: renamed from: isUpdatingFrame, reason: from getter */
        public final boolean getIsUpdatingFrame() {
            return this.isUpdatingFrame;
        }

        public final void setUpdatingFrame(boolean z) {
            this.isUpdatingFrame = z;
        }

        public final boolean isFrameAvailable() {
            return !this.isUpdatingFrame && this.bitmapRef.isValid();
        }

        public final void release() {
            CloseableReference.closeSafely(this.bitmapRef);
        }
    }
}
