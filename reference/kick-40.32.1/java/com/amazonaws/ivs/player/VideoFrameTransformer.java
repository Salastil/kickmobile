package com.amazonaws.ivs.player;

import android.graphics.SurfaceTexture;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import com.facebook.react.uimanager.ViewProps;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
final class VideoFrameTransformer implements SurfaceTexture.OnFrameAvailableListener, Releasable, Experimental {
    private static final String TAG = "VideoFrameTransformer";
    private final Consumer<Object> analyticsCallback;
    private EGLManager eglManager;
    private final Consumer<RuntimeException> errorCallback;
    private HardwareInfo info;
    private final AtomicBoolean paused;
    private final Performance.Monitor performanceMonitor;
    private long presentationTimestampPlug;
    private ExecutorService renderExecutor;
    private Handler renderHandler;
    private SurfaceTexture surfaceTexture;
    private GLManager.Texture textureExternal;
    private GLManager.Shader textureExternalShader;
    private final AtomicBoolean wantsFrame;
    private Surface inputSurface = null;
    private EGLManager.IVSSurface outputRenderSurface = null;
    private EGLSurface offscreenSurface = null;
    private Future<DecodedImageBuffer> sampleInFlight = null;
    private final LinkedList<DecodedImageBuffer> samplesToBeRendered = new LinkedList<>();
    private long FrameIndex = 0;

    @Override // com.amazonaws.ivs.player.Experimental
    public Experiments.Experiment getDescription() {
        return Experiments.Experiment.ANDROID_GPU;
    }

    VideoFrameTransformer(Consumer<RuntimeException> consumer, Consumer<Object> consumer2) {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        this.paused = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean();
        this.wantsFrame = atomicBoolean2;
        this.presentationTimestampPlug = -1L;
        this.errorCallback = consumer;
        this.analyticsCallback = consumer2;
        this.performanceMonitor = new Performance.Monitor();
        atomicBoolean.set(true);
        atomicBoolean2.set(false);
    }

    boolean init(final EGLManager eGLManager, HardwareInfo hardwareInfo) {
        Performance.Trackable trackableTime = this.performanceMonitor.time("init");
        try {
            HandlerThread handlerThread = new HandlerThread("RenderOrchestrator", -4);
            handlerThread.start();
            this.renderHandler = new Handler(handlerThread.getLooper());
            this.eglManager = eGLManager;
            this.info = hardwareInfo;
            this.renderExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda6
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return VideoFrameTransformer.lambda$init$0(runnable);
                }
            });
            boolean zBooleanValue = ((Boolean) eGLManager.createEGLOffscreenSurface().fold(new Function() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda7
                @Override // com.amazonaws.ivs.player.Function
                public final Object apply(Object obj) {
                    return this.f$0.m11094lambda$init$1$comamazonawsivsplayerVideoFrameTransformer((EGLException) obj);
                }
            }, new Function() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda8
                @Override // com.amazonaws.ivs.player.Function
                public final Object apply(Object obj) {
                    return this.f$0.m11097lambda$init$5$comamazonawsivsplayerVideoFrameTransformer(eGLManager, (EGLSurface) obj);
                }
            })).booleanValue();
            if (trackableTime != null) {
                trackableTime.close();
            }
            if (zBooleanValue) {
                this.inputSurface = createInputSurface();
                Consumer<Object> consumer = this.analyticsCallback;
                if (consumer != null) {
                    consumer.accept(GPUAnalyticsEvent.createInitEvent(hardwareInfo, this.performanceMonitor.getSnapshot("init")));
                }
            }
            return zBooleanValue;
        } catch (Throwable th) {
            if (trackableTime != null) {
                try {
                    trackableTime.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    static /* synthetic */ Thread lambda$init$0(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("RenderExecutor");
        thread.setPriority(10);
        return thread;
    }

    /* JADX INFO: renamed from: lambda$init$1$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ Boolean m11094lambda$init$1$comamazonawsivsplayerVideoFrameTransformer(EGLException eGLException) {
        this.errorCallback.accept(eGLException);
        return false;
    }

    /* JADX INFO: renamed from: lambda$init$5$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ Boolean m11097lambda$init$5$comamazonawsivsplayerVideoFrameTransformer(EGLManager eGLManager, EGLSurface eGLSurface) {
        this.offscreenSurface = eGLSurface;
        return (Boolean) ((Result) eGLManager.currentCall(new Supplier() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda17
            @Override // com.amazonaws.ivs.player.Supplier
            public final Object get() {
                return GLManager.createShader(36197);
            }
        }, this.offscreenSurface)).fold(new Function() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda18
            @Override // com.amazonaws.ivs.player.Function
            public final Object apply(Object obj) {
                return this.f$0.m11095lambda$init$3$comamazonawsivsplayerVideoFrameTransformer((GLException) obj);
            }
        }, new Function() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda19
            @Override // com.amazonaws.ivs.player.Function
            public final Object apply(Object obj) {
                return this.f$0.m11096lambda$init$4$comamazonawsivsplayerVideoFrameTransformer((GLManager.Shader) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$init$3$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ Boolean m11095lambda$init$3$comamazonawsivsplayerVideoFrameTransformer(GLException gLException) {
        this.errorCallback.accept(gLException);
        return false;
    }

    /* JADX INFO: renamed from: lambda$init$4$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ Boolean m11096lambda$init$4$comamazonawsivsplayerVideoFrameTransformer(GLManager.Shader shader) {
        this.textureExternalShader = shader;
        return true;
    }

    public Surface getInputSurface() {
        return this.inputSurface;
    }

    private Surface createInputSurface() {
        Performance.Trackable trackableTime = this.performanceMonitor.time("createInputSurface");
        try {
            Surface surface = (Surface) ((Result) this.eglManager.currentCall(new Supplier() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda10
                @Override // com.amazonaws.ivs.player.Supplier
                public final Object get() {
                    return GLManager.createTexture(36197);
                }
            }, this.offscreenSurface)).fold(new Function() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda13
                @Override // com.amazonaws.ivs.player.Function
                public final Object apply(Object obj) {
                    return this.f$0.m11092x21c0f937((GLException) obj);
                }
            }, new Function() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda14
                @Override // com.amazonaws.ivs.player.Function
                public final Object apply(Object obj) {
                    return this.f$0.m11093x5b8b9b16((GLManager.Texture) obj);
                }
            });
            if (trackableTime != null) {
                trackableTime.close();
            }
            return surface;
        } catch (Throwable th) {
            if (trackableTime != null) {
                try {
                    trackableTime.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: lambda$createInputSurface$7$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ Surface m11092x21c0f937(GLException gLException) {
        this.errorCallback.accept(gLException);
        return null;
    }

    /* JADX INFO: renamed from: lambda$createInputSurface$8$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ Surface m11093x5b8b9b16(GLManager.Texture texture) {
        this.textureExternal = texture;
        SurfaceTexture surfaceTexture = new SurfaceTexture(texture.id);
        this.surfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this, this.renderHandler);
        return new Surface(this.surfaceTexture);
    }

    boolean setOutputSurface(Surface surface) {
        EGLManager.IVSSurface iVSSurface = this.outputRenderSurface;
        if (iVSSurface != null) {
            iVSSurface.release();
            this.outputRenderSurface = null;
        }
        if (surface == null) {
            pause();
            return true;
        }
        return ((Boolean) this.eglManager.createIVSSurface(surface).fold(new Function() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda20
            @Override // com.amazonaws.ivs.player.Function
            public final Object apply(Object obj) {
                return this.f$0.m11108x4457328a((EGLException) obj);
            }
        }, new Function() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda1
            @Override // com.amazonaws.ivs.player.Function
            public final Object apply(Object obj) {
                return this.f$0.m11107x8897de4a((EGLManager.IVSSurface) obj);
            }
        })).booleanValue();
    }

    /* JADX INFO: renamed from: lambda$setOutputSurface$9$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ Boolean m11108x4457328a(EGLException eGLException) {
        Log.e(TAG, "createIVSSurface Exception " + eGLException);
        this.errorCallback.accept(eGLException);
        return false;
    }

    /* JADX INFO: renamed from: lambda$setOutputSurface$10$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ Boolean m11107x8897de4a(EGLManager.IVSSurface iVSSurface) {
        this.outputRenderSurface = iVSSurface;
        play();
        return true;
    }

    void submitVideoSample(final DecodedImageBuffer decodedImageBuffer) {
        this.renderHandler.post(new Runnable() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11109xe89768b2(decodedImageBuffer);
            }
        });
    }

    void onFrameRendered(int i, int i2, final long j) {
        if (this.paused.get()) {
            return;
        }
        this.wantsFrame.set(true);
        this.eglManager.currentCall(new Runnable() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11101xc61914a7(j);
            }
        }, this.outputRenderSurface.eglSurface);
        long j2 = this.FrameIndex + 1;
        this.FrameIndex = j2;
        if (j2 >= 1800) {
            this.analyticsCallback.accept(GPUAnalyticsEvent.createStatusEvent(this.info, this.performanceMonitor.getSnapshot("capture"), this.performanceMonitor.getSnapshot(ViewProps.TRANSFORM), this.performanceMonitor.getSnapshot("render")));
            this.FrameIndex = 0L;
            this.performanceMonitor.reset("capture");
            this.performanceMonitor.reset(ViewProps.TRANSFORM);
            this.performanceMonitor.reset("render");
        }
        m11109xe89768b2(null);
    }

    /* JADX INFO: renamed from: lambda$onFrameRendered$12$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ void m11101xc61914a7(long j) {
        Performance.Trackable trackableTime = this.performanceMonitor.time("render");
        try {
            GLES20.glViewport(0, 0, this.outputRenderSurface.width(), this.outputRenderSurface.height());
            GLException gLExceptionDraw = this.textureExternalShader.draw(this.textureExternal);
            if (gLExceptionDraw != null) {
                Log.e(TAG, "Exception " + gLExceptionDraw);
                this.errorCallback.accept(gLExceptionDraw);
            }
            EGLManager.IVSSurface iVSSurface = this.outputRenderSurface;
            if (iVSSurface != null) {
                iVSSurface.setPresentationTimestamp(j * 1000);
                if (!(!this.paused.get() ? this.outputRenderSurface.swapBuffers() : true)) {
                    this.errorCallback.accept(new EGLException("EGLSwapBuffers fail", 0));
                }
            }
            if (trackableTime != null) {
                trackableTime.close();
            }
        } catch (Throwable th) {
            if (trackableTime != null) {
                try {
                    trackableTime.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    synchronized void pause() {
        this.paused.set(true);
    }

    synchronized void play() {
        if (this.outputRenderSurface != null && this.paused.compareAndSet(true, false)) {
            this.wantsFrame.set(true);
        }
    }

    synchronized long bufferDurationUs() {
        if (this.samplesToBeRendered.isEmpty()) {
            return 0L;
        }
        return this.samplesToBeRendered.getLast().info.presentationTimeUs - this.samplesToBeRendered.getFirst().info.presentationTimeUs;
    }

    void flush() {
        removeUpTo(Long.MAX_VALUE);
        this.wantsFrame.set(true);
        Future<DecodedImageBuffer> future = this.sampleInFlight;
        if (future != null && !future.isCancelled() && !this.sampleInFlight.isDone()) {
            try {
                this.sampleInFlight.get();
            } catch (Exception unused) {
            }
            this.sampleInFlight = null;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.renderExecutor.submit(new AudioDecoder$$ExternalSyntheticLambda2(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused2) {
        }
    }

    synchronized void removeUpTo(long j) {
        if (j <= 0) {
            return;
        }
        int i = 0;
        while (i < this.samplesToBeRendered.size()) {
            if (this.samplesToBeRendered.get(i).info.presentationTimeUs < j) {
                this.samplesToBeRendered.get(i).release();
                this.samplesToBeRendered.remove(i);
            } else {
                i++;
            }
        }
        this.renderExecutor.submit(new Runnable() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11104xbb6e5976();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$removeUpTo$14$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ void m11104xbb6e5976() {
        this.eglManager.currentCall(new Runnable() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11103x81a3b797();
            }
        }, this.offscreenSurface);
    }

    /* JADX INFO: renamed from: lambda$removeUpTo$13$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ void m11103x81a3b797() {
        this.surfaceTexture.updateTexImage();
    }

    synchronized void setPresentationTimestampPlug(long j) {
        this.presentationTimestampPlug = j;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(final SurfaceTexture surfaceTexture) {
        final boolean z = this.samplesToBeRendered.isEmpty() && this.sampleInFlight == null;
        try {
            this.renderExecutor.submit(new Runnable() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m11100x3adbc594(surfaceTexture, z);
                }
            });
        } catch (RejectedExecutionException e) {
            Log.e(TAG, "Exception " + e);
        }
        m11109xe89768b2(null);
    }

    /* JADX INFO: renamed from: lambda$onFrameAvailable$17$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ void m11100x3adbc594(final SurfaceTexture surfaceTexture, boolean z) {
        this.eglManager.currentCall(new Runnable() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11098xc74681d6(surfaceTexture);
            }
        }, this.outputRenderSurface.eglSurface);
        if (z) {
            onFrameRendered(this.textureExternal.id, this.textureExternal.targetType, this.textureExternal.presentationTimestamp);
        } else {
            this.renderExecutor.submit(new Runnable() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m11099x11123b5();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onFrameAvailable$15$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ void m11098xc74681d6(SurfaceTexture surfaceTexture) {
        Performance.Trackable trackableTime = this.performanceMonitor.time("capture");
        try {
            surfaceTexture.updateTexImage();
            surfaceTexture.getTransformMatrix(this.textureExternal.transform);
            this.textureExternal.setPresentationTimestamp(surfaceTexture.getTimestamp());
            if (trackableTime != null) {
                trackableTime.close();
            }
        } catch (Throwable th) {
            if (trackableTime != null) {
                try {
                    trackableTime.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: lambda$onFrameAvailable$16$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ void m11099x11123b5() {
        onFrameRendered(this.textureExternal.id, this.textureExternal.targetType, this.textureExternal.presentationTimestamp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: renderNextSample, reason: merged with bridge method [inline-methods] */
    public synchronized void m11109xe89768b2(DecodedImageBuffer decodedImageBuffer) {
        if (decodedImageBuffer != null) {
            if (decodedImageBuffer.info.isEndOfStream) {
                Log.d(TAG, "renderNextSample has EOS");
            }
            this.samplesToBeRendered.add(decodedImageBuffer);
        }
        if (this.paused.get()) {
            removeUpTo(this.presentationTimestampPlug);
            return;
        }
        if (!this.samplesToBeRendered.isEmpty() && ((this.presentationTimestampPlug < 0 || ((DecodedImageBuffer) Objects.requireNonNull(this.samplesToBeRendered.peek())).info.presentationTimeUs <= this.presentationTimestampPlug) && this.wantsFrame.compareAndSet(true, false))) {
            final DecodedImageBuffer decodedImageBufferRemove = this.samplesToBeRendered.remove();
            if (decodedImageBufferRemove.info.isEndOfStream) {
                Log.d(TAG, "renderNextSample about to render EOS");
            }
            this.sampleInFlight = this.renderExecutor.submit(new Callable() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.m11106x581ee46a(decodedImageBufferRemove);
                }
            });
        } else {
            Future<DecodedImageBuffer> future = this.sampleInFlight;
            if (future != null && (future.isDone() || this.sampleInFlight.isCancelled())) {
                this.sampleInFlight = null;
                this.wantsFrame.set(true);
            }
        }
    }

    /* JADX INFO: renamed from: lambda$renderNextSample$19$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ DecodedImageBuffer m11106x581ee46a(final DecodedImageBuffer decodedImageBuffer) throws Exception {
        this.eglManager.currentCall(new Runnable() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11105x1e54428b(decodedImageBuffer);
            }
        }, this.outputRenderSurface.eglSurface);
        decodedImageBuffer.release();
        return decodedImageBuffer;
    }

    /* JADX INFO: renamed from: lambda$renderNextSample$18$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ void m11105x1e54428b(DecodedImageBuffer decodedImageBuffer) {
        try {
            if (decodedImageBuffer.render()) {
                return;
            }
            this.wantsFrame.set(true);
        } catch (Exception e) {
            this.wantsFrame.set(true);
            Log.e(TAG, "Sample.render failed: " + e);
        }
    }

    @Override // com.amazonaws.ivs.player.Releasable
    public void release() {
        flush();
        this.wantsFrame.set(false);
        this.renderExecutor.shutdown();
        try {
            this.renderExecutor.awaitTermination(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            this.errorCallback.accept(new RuntimeException(e.getMessage()));
        }
        this.eglManager.currentCall(new Runnable() { // from class: com.amazonaws.ivs.player.VideoFrameTransformer$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11102lambda$release$20$comamazonawsivsplayerVideoFrameTransformer();
            }
        }, this.offscreenSurface);
        EGLManager.IVSSurface iVSSurface = this.outputRenderSurface;
        if (iVSSurface != null) {
            iVSSurface.release();
        }
        this.eglManager.releaseSurface(this.offscreenSurface);
        this.renderHandler.getLooper().quitSafely();
    }

    /* JADX INFO: renamed from: lambda$release$20$com-amazonaws-ivs-player-VideoFrameTransformer, reason: not valid java name */
    /* synthetic */ void m11102lambda$release$20$comamazonawsivsplayerVideoFrameTransformer() {
        this.samplesToBeRendered.clear();
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        GLManager.Texture texture = this.textureExternal;
        if (texture != null) {
            texture.release();
        }
        GLManager.Shader shader = this.textureExternalShader;
        if (shader != null) {
            shader.release();
        }
        EGLManager.IVSSurface iVSSurface = this.outputRenderSurface;
        if (iVSSurface != null) {
            iVSSurface.swapBuffers();
        }
    }
}
