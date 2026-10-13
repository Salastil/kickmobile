package com.amazonaws.ivs.player;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;

/* JADX INFO: loaded from: classes5.dex */
class EGLManager implements Releasable {
    private long initTime;
    private EGLConfig mEGLConfig;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;

    static /* synthetic */ EGLDisplay lambda$createDisplay$10(EGLDisplay eGLDisplay) {
        return eGLDisplay;
    }

    static Result<EGLException, EGLManager> create() {
        return create(null);
    }

    static Result<EGLException, EGLManager> create(final EGLContext eGLContext) {
        final long jNanoTime = System.nanoTime();
        Result resultFlatMap = createDisplay().flatMap(new Function() { // from class: com.amazonaws.ivs.player.EGLManager$$ExternalSyntheticLambda9
            @Override // com.amazonaws.ivs.player.Function
            public final Object apply(Object obj) {
                EGLDisplay eGLDisplay = (EGLDisplay) obj;
                return EGLManager.createConfig(eGLDisplay, 3).flatMap(new Function() { // from class: com.amazonaws.ivs.player.EGLManager$$ExternalSyntheticLambda11
                    @Override // com.amazonaws.ivs.player.Function
                    public final Object apply(Object obj2) {
                        EGLDisplay eGLDisplay2 = eGLDisplay;
                        EGLConfig eGLConfig = (EGLConfig) obj2;
                        return EGLManager.createContext(eGLDisplay2, eGLConfig, eGLContext, 3).flatMap(new Function() { // from class: com.amazonaws.ivs.player.EGLManager$$ExternalSyntheticLambda2
                            @Override // com.amazonaws.ivs.player.Function
                            public final Object apply(Object obj3) {
                                return EGLManager.lambda$create$0(eGLDisplay2, eGLConfig, j, (EGLContext) obj3);
                            }
                        });
                    }
                });
            }
        });
        return resultFlatMap.isOk() ? resultFlatMap : createDisplay().flatMap(new Function() { // from class: com.amazonaws.ivs.player.EGLManager$$ExternalSyntheticLambda10
            @Override // com.amazonaws.ivs.player.Function
            public final Object apply(Object obj) {
                EGLDisplay eGLDisplay = (EGLDisplay) obj;
                return EGLManager.createConfig(eGLDisplay, 2).flatMap(new Function() { // from class: com.amazonaws.ivs.player.EGLManager$$ExternalSyntheticLambda8
                    @Override // com.amazonaws.ivs.player.Function
                    public final Object apply(Object obj2) {
                        EGLDisplay eGLDisplay2 = eGLDisplay;
                        EGLConfig eGLConfig = (EGLConfig) obj2;
                        return EGLManager.createContext(eGLDisplay2, eGLConfig, eGLContext, 2).flatMap(new Function() { // from class: com.amazonaws.ivs.player.EGLManager$$ExternalSyntheticLambda3
                            @Override // com.amazonaws.ivs.player.Function
                            public final Object apply(Object obj3) {
                                return EGLManager.lambda$create$3(j, eGLDisplay2, eGLConfig, (EGLContext) obj3);
                            }
                        });
                    }
                });
            }
        });
    }

    static /* synthetic */ Result lambda$create$0(EGLDisplay eGLDisplay, EGLConfig eGLConfig, long j, EGLContext eGLContext) {
        EGLManager eGLManager = new EGLManager(eGLDisplay, eGLConfig, eGLContext);
        eGLManager.initTime = (System.nanoTime() - j) / 1000;
        return Result.value(eGLManager);
    }

    static /* synthetic */ Result lambda$create$3(long j, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext) {
        Logging.i("EGL initialization: " + ((System.nanoTime() - j) / 1000) + "us");
        return Result.value(new EGLManager(eGLDisplay, eGLConfig, eGLContext));
    }

    @Override // com.amazonaws.ivs.player.Releasable
    public void release() {
        makeCurrent();
        if (this.mEGLContext != EGL14.EGL_NO_CONTEXT) {
            EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
        }
        EGL14.eglReleaseThread();
        if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglTerminate(this.mEGLDisplay);
        }
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
    }

    String getString(int i) {
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
            return "";
        }
        return GLES20.glGetString(i);
    }

    EGLDisplay getEGLDisplay() {
        return this.mEGLDisplay;
    }

    EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    EGLConfig getEGLConfig() {
        return this.mEGLConfig;
    }

    Result<EGLException, EGLSurface> createEGLScreenSurface(final Surface surface) {
        return check("Create Window Surface", new Supplier() { // from class: com.amazonaws.ivs.player.EGLManager$$ExternalSyntheticLambda5
            @Override // com.amazonaws.ivs.player.Supplier
            public final Object get() {
                return this.f$0.m11045x6f083b46(surface);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$createEGLScreenSurface$6$com-amazonaws-ivs-player-EGLManager, reason: not valid java name */
    /* synthetic */ EGLSurface m11045x6f083b46(Surface surface) {
        return EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, surface, new int[]{12344}, 0);
    }

    Result<EGLException, EGLSurface> createEGLOffscreenSurface() {
        return check("Create Pbuffer Surface", new Supplier() { // from class: com.amazonaws.ivs.player.EGLManager$$ExternalSyntheticLambda1
            @Override // com.amazonaws.ivs.player.Supplier
            public final Object get() {
                return this.f$0.m11044x230b77ba();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$createEGLOffscreenSurface$7$com-amazonaws-ivs-player-EGLManager, reason: not valid java name */
    /* synthetic */ EGLSurface m11044x230b77ba() {
        return EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[]{12375, 1, 12374, 1, 12344}, 0);
    }

    Result<EGLException, IVSSurface> createIVSSurface(Surface surface) {
        if (surface == null) {
            return createEGLOffscreenSurface().map(new Function() { // from class: com.amazonaws.ivs.player.EGLManager$$ExternalSyntheticLambda0
                @Override // com.amazonaws.ivs.player.Function
                public final Object apply(Object obj) {
                    return this.f$0.m11046lambda$createIVSSurface$8$comamazonawsivsplayerEGLManager((EGLSurface) obj);
                }
            });
        }
        return createEGLScreenSurface(surface).map(new Function() { // from class: com.amazonaws.ivs.player.EGLManager$$ExternalSyntheticLambda4
            @Override // com.amazonaws.ivs.player.Function
            public final Object apply(Object obj) {
                return this.f$0.m11047lambda$createIVSSurface$9$comamazonawsivsplayerEGLManager((EGLSurface) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$createIVSSurface$8$com-amazonaws-ivs-player-EGLManager, reason: not valid java name */
    /* synthetic */ IVSSurface m11046lambda$createIVSSurface$8$comamazonawsivsplayerEGLManager(EGLSurface eGLSurface) {
        return new IVSSurface(this, eGLSurface);
    }

    /* JADX INFO: renamed from: lambda$createIVSSurface$9$com-amazonaws-ivs-player-EGLManager, reason: not valid java name */
    /* synthetic */ IVSSurface m11047lambda$createIVSSurface$9$comamazonawsivsplayerEGLManager(EGLSurface eGLSurface) {
        return new IVSSurface(this, eGLSurface);
    }

    void releaseSurface(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.mEGLDisplay, eGLSurface);
    }

    private EGLManager(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext) {
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        EGLContext eGLContext2 = EGL14.EGL_NO_CONTEXT;
        this.initTime = 0L;
        this.mEGLDisplay = eGLDisplay;
        this.mEGLConfig = eGLConfig;
        this.mEGLContext = eGLContext;
    }

    private static Result<EGLException, EGLDisplay> createDisplay() {
        final EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            return Result.error(new EGLException("No display connection is available", -1));
        }
        return check("EGL Initialize", new Supplier() { // from class: com.amazonaws.ivs.player.EGLManager$$ExternalSyntheticLambda6
            @Override // com.amazonaws.ivs.player.Supplier
            public final Object get() {
                return EGLManager.lambda$createDisplay$10(eGLDisplayEglGetDisplay);
            }
        }, new Predicate() { // from class: com.amazonaws.ivs.player.EGLManager$$ExternalSyntheticLambda7
            @Override // com.amazonaws.ivs.player.Predicate
            public final boolean test(Object obj) {
                return EGLManager.lambda$createDisplay$11((EGLDisplay) obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$createDisplay$11(EGLDisplay eGLDisplay) {
        int[] iArr = new int[2];
        return EGL14.eglInitialize(eGLDisplay, iArr, 0, iArr, 1);
    }

    private static Result<EGLException, EGLContext> createContext(final EGLDisplay eGLDisplay, final EGLConfig eGLConfig, final EGLContext eGLContext, final int i) {
        return check("Create EGL Context", new Supplier() { // from class: com.amazonaws.ivs.player.EGLManager$$ExternalSyntheticLambda12
            @Override // com.amazonaws.ivs.player.Supplier
            public final Object get() {
                return EGLManager.lambda$createContext$12(i, eGLDisplay, eGLConfig, eGLContext);
            }
        });
    }

    static /* synthetic */ EGLContext lambda$createContext$12(int i, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext) {
        int[] iArr = {12440, i, 12344};
        if (eGLContext == null) {
            eGLContext = EGL14.EGL_NO_CONTEXT;
        }
        return EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr, 0);
    }

    private static Result<EGLException, EGLConfig> createConfig(EGLDisplay eGLDisplay, int i) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(eGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i == 3 ? 68 : 4, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return Result.error(new EGLException("EGL choose config failed", 0));
        }
        return Result.value(eGLConfigArr[0]);
    }

    void makeCurrent() {
        EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
    }

    void makeCurrent(EGLSurface eGLSurface) {
        EGL14.eglMakeCurrent(this.mEGLDisplay, eGLSurface, eGLSurface, this.mEGLContext);
    }

    void makeCurrent(EGLSurface eGLSurface, EGLSurface eGLSurface2) {
        EGL14.eglMakeCurrent(this.mEGLDisplay, eGLSurface, eGLSurface2, this.mEGLContext);
    }

    private static EGLException checkInternal(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError != 12288) {
            return new EGLException(str, iEglGetError);
        }
        return null;
    }

    static EGLException check(String str, Runnable runnable) {
        runnable.run();
        return checkInternal(str);
    }

    static <V> Result<EGLException, V> check(String str, Supplier<V> supplier) {
        V v = supplier.get();
        EGLException eGLExceptionCheckInternal = checkInternal(str);
        if (eGLExceptionCheckInternal != null) {
            return Result.error(eGLExceptionCheckInternal);
        }
        return Result.value(v);
    }

    static <V> Result<EGLException, V> check(String str, Supplier<V> supplier, Predicate<V> predicate) {
        V v = supplier.get();
        EGLException eGLExceptionCheckInternal = checkInternal(str);
        if (eGLExceptionCheckInternal != null) {
            return Result.error(eGLExceptionCheckInternal);
        }
        if (!predicate.test(v)) {
            return Result.error(new EGLException(str + " post condition failed", -1));
        }
        return Result.value(v);
    }

    void currentCall(Runnable runnable, EGLSurface eGLSurface) {
        makeCurrent(eGLSurface);
        runnable.run();
        makeCurrent();
    }

    <V> V currentCall(Supplier<V> supplier, EGLSurface eGLSurface) {
        makeCurrent(eGLSurface);
        V v = supplier.get();
        makeCurrent();
        return v;
    }

    class IVSSurface implements Releasable {
        EGLSurface eglSurface;
        EGLManager helper;
        private final int[] status;

        private IVSSurface(EGLManager eGLManager, EGLSurface eGLSurface) {
            this.helper = eGLManager;
            this.eglSurface = eGLSurface;
            this.status = new int[1];
        }

        int width() {
            EGL14.eglQuerySurface(this.helper.getEGLDisplay(), this.eglSurface, 12375, this.status, 0);
            return this.status[0];
        }

        int height() {
            EGL14.eglQuerySurface(this.helper.getEGLDisplay(), this.eglSurface, 12374, this.status, 0);
            return this.status[0];
        }

        void setPresentationTimestamp(long j) {
            EGLExt.eglPresentationTimeANDROID(this.helper.getEGLDisplay(), this.eglSurface, j);
        }

        boolean swapBuffers() {
            return EGL14.eglSwapBuffers(this.helper.getEGLDisplay(), this.eglSurface);
        }

        @Override // com.amazonaws.ivs.player.Releasable
        public void release() {
            this.helper.releaseSurface(this.eglSurface);
        }
    }
}
