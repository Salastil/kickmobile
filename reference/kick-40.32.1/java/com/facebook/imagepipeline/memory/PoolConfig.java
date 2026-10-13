package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PoolConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0002)*B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0011\u0010\u001a\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\rR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b&\u0010(¨\u0006+"}, d2 = {"Lcom/facebook/imagepipeline/memory/PoolConfig;", "", "builder", "Lcom/facebook/imagepipeline/memory/PoolConfig$Builder;", "<init>", "(Lcom/facebook/imagepipeline/memory/PoolConfig$Builder;)V", "bitmapPoolParams", "Lcom/facebook/imagepipeline/memory/PoolParams;", "getBitmapPoolParams", "()Lcom/facebook/imagepipeline/memory/PoolParams;", "bitmapPoolStatsTracker", "Lcom/facebook/imagepipeline/memory/PoolStatsTracker;", "getBitmapPoolStatsTracker", "()Lcom/facebook/imagepipeline/memory/PoolStatsTracker;", "flexByteArrayPoolParams", "getFlexByteArrayPoolParams", "memoryTrimmableRegistry", "Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "getMemoryTrimmableRegistry", "()Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "memoryChunkPoolParams", "getMemoryChunkPoolParams", "memoryChunkPoolStatsTracker", "getMemoryChunkPoolStatsTracker", "smallByteArrayPoolParams", "getSmallByteArrayPoolParams", "smallByteArrayPoolStatsTracker", "getSmallByteArrayPoolStatsTracker", "bitmapPoolType", "", "getBitmapPoolType", "()Ljava/lang/String;", "bitmapPoolMaxPoolSize", "", "getBitmapPoolMaxPoolSize", "()I", "bitmapPoolMaxBitmapSize", "getBitmapPoolMaxBitmapSize", "isRegisterLruBitmapPoolAsMemoryTrimmable", "", "()Z", "Builder", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PoolConfig {
    public static final int BITMAP_POOL_MAX_BITMAP_SIZE_DEFAULT = 4194304;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int bitmapPoolMaxBitmapSize;
    private final int bitmapPoolMaxPoolSize;
    private final PoolParams bitmapPoolParams;
    private final PoolStatsTracker bitmapPoolStatsTracker;
    private final String bitmapPoolType;
    private final PoolParams flexByteArrayPoolParams;
    private final boolean isRegisterLruBitmapPoolAsMemoryTrimmable;
    private final PoolParams memoryChunkPoolParams;
    private final PoolStatsTracker memoryChunkPoolStatsTracker;
    private final MemoryTrimmableRegistry memoryTrimmableRegistry;
    private final PoolParams smallByteArrayPoolParams;
    private final PoolStatsTracker smallByteArrayPoolStatsTracker;

    public /* synthetic */ PoolConfig(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @JvmStatic
    public static final Builder newBuilder() {
        return INSTANCE.newBuilder();
    }

    private PoolConfig(Builder builder) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PoolConfig()");
        }
        PoolParams bitmapPoolParams = builder.getBitmapPoolParams();
        this.bitmapPoolParams = bitmapPoolParams == null ? DefaultBitmapPoolParams.get() : bitmapPoolParams;
        NoOpPoolStatsTracker bitmapPoolStatsTracker = builder.getBitmapPoolStatsTracker();
        if (bitmapPoolStatsTracker == null) {
            NoOpPoolStatsTracker noOpPoolStatsTracker = NoOpPoolStatsTracker.getInstance();
            Intrinsics.checkNotNullExpressionValue(noOpPoolStatsTracker, "getInstance(...)");
            bitmapPoolStatsTracker = noOpPoolStatsTracker;
        }
        this.bitmapPoolStatsTracker = bitmapPoolStatsTracker;
        PoolParams flexByteArrayPoolParams = builder.getFlexByteArrayPoolParams();
        this.flexByteArrayPoolParams = flexByteArrayPoolParams == null ? DefaultFlexByteArrayPoolParams.get() : flexByteArrayPoolParams;
        NoOpMemoryTrimmableRegistry memoryTrimmableRegistry = builder.getMemoryTrimmableRegistry();
        if (memoryTrimmableRegistry == null) {
            NoOpMemoryTrimmableRegistry noOpMemoryTrimmableRegistry = NoOpMemoryTrimmableRegistry.getInstance();
            Intrinsics.checkNotNullExpressionValue(noOpMemoryTrimmableRegistry, "getInstance(...)");
            memoryTrimmableRegistry = noOpMemoryTrimmableRegistry;
        }
        this.memoryTrimmableRegistry = memoryTrimmableRegistry;
        PoolParams memoryChunkPoolParams = builder.getMemoryChunkPoolParams();
        this.memoryChunkPoolParams = memoryChunkPoolParams == null ? DefaultNativeMemoryChunkPoolParams.get() : memoryChunkPoolParams;
        NoOpPoolStatsTracker memoryChunkPoolStatsTracker = builder.getMemoryChunkPoolStatsTracker();
        if (memoryChunkPoolStatsTracker == null) {
            NoOpPoolStatsTracker noOpPoolStatsTracker2 = NoOpPoolStatsTracker.getInstance();
            Intrinsics.checkNotNullExpressionValue(noOpPoolStatsTracker2, "getInstance(...)");
            memoryChunkPoolStatsTracker = noOpPoolStatsTracker2;
        }
        this.memoryChunkPoolStatsTracker = memoryChunkPoolStatsTracker;
        PoolParams smallByteArrayPoolParams = builder.getSmallByteArrayPoolParams();
        this.smallByteArrayPoolParams = smallByteArrayPoolParams == null ? DefaultByteArrayPoolParams.get() : smallByteArrayPoolParams;
        NoOpPoolStatsTracker smallByteArrayPoolStatsTracker = builder.getSmallByteArrayPoolStatsTracker();
        if (smallByteArrayPoolStatsTracker == null) {
            NoOpPoolStatsTracker noOpPoolStatsTracker3 = NoOpPoolStatsTracker.getInstance();
            Intrinsics.checkNotNullExpressionValue(noOpPoolStatsTracker3, "getInstance(...)");
            smallByteArrayPoolStatsTracker = noOpPoolStatsTracker3;
        }
        this.smallByteArrayPoolStatsTracker = smallByteArrayPoolStatsTracker;
        String bitmapPoolType = builder.getBitmapPoolType();
        this.bitmapPoolType = bitmapPoolType == null ? "legacy" : bitmapPoolType;
        this.bitmapPoolMaxPoolSize = builder.getBitmapPoolMaxPoolSize();
        this.bitmapPoolMaxBitmapSize = builder.getBitmapPoolMaxBitmapSize() > 0 ? builder.getBitmapPoolMaxBitmapSize() : 4194304;
        this.isRegisterLruBitmapPoolAsMemoryTrimmable = builder.getRegisterLruBitmapPoolAsMemoryTrimmable();
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public final PoolParams getBitmapPoolParams() {
        return this.bitmapPoolParams;
    }

    public final PoolStatsTracker getBitmapPoolStatsTracker() {
        return this.bitmapPoolStatsTracker;
    }

    public final PoolParams getFlexByteArrayPoolParams() {
        return this.flexByteArrayPoolParams;
    }

    public final MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.memoryTrimmableRegistry;
    }

    public final PoolParams getMemoryChunkPoolParams() {
        return this.memoryChunkPoolParams;
    }

    public final PoolStatsTracker getMemoryChunkPoolStatsTracker() {
        return this.memoryChunkPoolStatsTracker;
    }

    public final PoolParams getSmallByteArrayPoolParams() {
        return this.smallByteArrayPoolParams;
    }

    public final PoolStatsTracker getSmallByteArrayPoolStatsTracker() {
        return this.smallByteArrayPoolStatsTracker;
    }

    public final String getBitmapPoolType() {
        return this.bitmapPoolType;
    }

    public final int getBitmapPoolMaxPoolSize() {
        return this.bitmapPoolMaxPoolSize;
    }

    public final int getBitmapPoolMaxBitmapSize() {
        return this.bitmapPoolMaxBitmapSize;
    }

    /* JADX INFO: renamed from: isRegisterLruBitmapPoolAsMemoryTrimmable, reason: from getter */
    public final boolean getIsRegisterLruBitmapPoolAsMemoryTrimmable() {
        return this.isRegisterLruBitmapPoolAsMemoryTrimmable;
    }

    /* JADX INFO: compiled from: PoolConfig.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010<\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0010\u0010=\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0005J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000bJ\u000e\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u0005J\u000e\u0010B\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000bJ\u0006\u0010C\u001a\u00020DJ\u0010\u0010E\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010&J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,J\u000e\u0010G\u001a\u00020\u00002\u0006\u00101\u001a\u00020,J\u000e\u0010H\u001a\u00020\u00002\u0006\u00104\u001a\u000205R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001c\u0010\"\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u001a\u00104\u001a\u000205X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006I"}, d2 = {"Lcom/facebook/imagepipeline/memory/PoolConfig$Builder;", "", "<init>", "()V", "bitmapPoolParams", "Lcom/facebook/imagepipeline/memory/PoolParams;", "getBitmapPoolParams$imagepipeline_release", "()Lcom/facebook/imagepipeline/memory/PoolParams;", "setBitmapPoolParams$imagepipeline_release", "(Lcom/facebook/imagepipeline/memory/PoolParams;)V", "bitmapPoolStatsTracker", "Lcom/facebook/imagepipeline/memory/PoolStatsTracker;", "getBitmapPoolStatsTracker$imagepipeline_release", "()Lcom/facebook/imagepipeline/memory/PoolStatsTracker;", "setBitmapPoolStatsTracker$imagepipeline_release", "(Lcom/facebook/imagepipeline/memory/PoolStatsTracker;)V", "flexByteArrayPoolParams", "getFlexByteArrayPoolParams$imagepipeline_release", "setFlexByteArrayPoolParams$imagepipeline_release", "memoryTrimmableRegistry", "Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "getMemoryTrimmableRegistry$imagepipeline_release", "()Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "setMemoryTrimmableRegistry$imagepipeline_release", "(Lcom/facebook/common/memory/MemoryTrimmableRegistry;)V", "memoryChunkPoolParams", "getMemoryChunkPoolParams$imagepipeline_release", "setMemoryChunkPoolParams$imagepipeline_release", "memoryChunkPoolStatsTracker", "getMemoryChunkPoolStatsTracker$imagepipeline_release", "setMemoryChunkPoolStatsTracker$imagepipeline_release", "smallByteArrayPoolParams", "getSmallByteArrayPoolParams$imagepipeline_release", "setSmallByteArrayPoolParams$imagepipeline_release", "smallByteArrayPoolStatsTracker", "getSmallByteArrayPoolStatsTracker$imagepipeline_release", "setSmallByteArrayPoolStatsTracker$imagepipeline_release", "bitmapPoolType", "", "getBitmapPoolType$imagepipeline_release", "()Ljava/lang/String;", "setBitmapPoolType$imagepipeline_release", "(Ljava/lang/String;)V", "bitmapPoolMaxPoolSize", "", "getBitmapPoolMaxPoolSize$imagepipeline_release", "()I", "setBitmapPoolMaxPoolSize$imagepipeline_release", "(I)V", "bitmapPoolMaxBitmapSize", "getBitmapPoolMaxBitmapSize$imagepipeline_release", "setBitmapPoolMaxBitmapSize$imagepipeline_release", "registerLruBitmapPoolAsMemoryTrimmable", "", "getRegisterLruBitmapPoolAsMemoryTrimmable$imagepipeline_release", "()Z", "setRegisterLruBitmapPoolAsMemoryTrimmable$imagepipeline_release", "(Z)V", "setBitmapPoolParams", "setBitmapPoolStatsTracker", "setFlexByteArrayPoolParams", "setMemoryTrimmableRegistry", "setNativeMemoryChunkPoolParams", "setNativeMemoryChunkPoolStatsTracker", "setSmallByteArrayPoolParams", "commonByteArrayPoolParams", "setSmallByteArrayPoolStatsTracker", "build", "Lcom/facebook/imagepipeline/memory/PoolConfig;", "setBitmapPoolType", "setBitmapPoolMaxPoolSize", "setBitmapPoolMaxBitmapSize", "setRegisterLruBitmapPoolAsMemoryTrimmable", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        private int bitmapPoolMaxBitmapSize;
        private int bitmapPoolMaxPoolSize;
        private PoolParams bitmapPoolParams;
        private PoolStatsTracker bitmapPoolStatsTracker;
        private String bitmapPoolType;
        private PoolParams flexByteArrayPoolParams;
        private PoolParams memoryChunkPoolParams;
        private PoolStatsTracker memoryChunkPoolStatsTracker;
        private MemoryTrimmableRegistry memoryTrimmableRegistry;
        private boolean registerLruBitmapPoolAsMemoryTrimmable;
        private PoolParams smallByteArrayPoolParams;
        private PoolStatsTracker smallByteArrayPoolStatsTracker;

        /* JADX INFO: renamed from: getBitmapPoolParams$imagepipeline_release, reason: from getter */
        public final PoolParams getBitmapPoolParams() {
            return this.bitmapPoolParams;
        }

        public final void setBitmapPoolParams$imagepipeline_release(PoolParams poolParams) {
            this.bitmapPoolParams = poolParams;
        }

        /* JADX INFO: renamed from: getBitmapPoolStatsTracker$imagepipeline_release, reason: from getter */
        public final PoolStatsTracker getBitmapPoolStatsTracker() {
            return this.bitmapPoolStatsTracker;
        }

        public final void setBitmapPoolStatsTracker$imagepipeline_release(PoolStatsTracker poolStatsTracker) {
            this.bitmapPoolStatsTracker = poolStatsTracker;
        }

        /* JADX INFO: renamed from: getFlexByteArrayPoolParams$imagepipeline_release, reason: from getter */
        public final PoolParams getFlexByteArrayPoolParams() {
            return this.flexByteArrayPoolParams;
        }

        public final void setFlexByteArrayPoolParams$imagepipeline_release(PoolParams poolParams) {
            this.flexByteArrayPoolParams = poolParams;
        }

        /* JADX INFO: renamed from: getMemoryTrimmableRegistry$imagepipeline_release, reason: from getter */
        public final MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
            return this.memoryTrimmableRegistry;
        }

        public final void setMemoryTrimmableRegistry$imagepipeline_release(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.memoryTrimmableRegistry = memoryTrimmableRegistry;
        }

        /* JADX INFO: renamed from: getMemoryChunkPoolParams$imagepipeline_release, reason: from getter */
        public final PoolParams getMemoryChunkPoolParams() {
            return this.memoryChunkPoolParams;
        }

        public final void setMemoryChunkPoolParams$imagepipeline_release(PoolParams poolParams) {
            this.memoryChunkPoolParams = poolParams;
        }

        /* JADX INFO: renamed from: getMemoryChunkPoolStatsTracker$imagepipeline_release, reason: from getter */
        public final PoolStatsTracker getMemoryChunkPoolStatsTracker() {
            return this.memoryChunkPoolStatsTracker;
        }

        public final void setMemoryChunkPoolStatsTracker$imagepipeline_release(PoolStatsTracker poolStatsTracker) {
            this.memoryChunkPoolStatsTracker = poolStatsTracker;
        }

        /* JADX INFO: renamed from: getSmallByteArrayPoolParams$imagepipeline_release, reason: from getter */
        public final PoolParams getSmallByteArrayPoolParams() {
            return this.smallByteArrayPoolParams;
        }

        public final void setSmallByteArrayPoolParams$imagepipeline_release(PoolParams poolParams) {
            this.smallByteArrayPoolParams = poolParams;
        }

        /* JADX INFO: renamed from: getSmallByteArrayPoolStatsTracker$imagepipeline_release, reason: from getter */
        public final PoolStatsTracker getSmallByteArrayPoolStatsTracker() {
            return this.smallByteArrayPoolStatsTracker;
        }

        public final void setSmallByteArrayPoolStatsTracker$imagepipeline_release(PoolStatsTracker poolStatsTracker) {
            this.smallByteArrayPoolStatsTracker = poolStatsTracker;
        }

        /* JADX INFO: renamed from: getBitmapPoolType$imagepipeline_release, reason: from getter */
        public final String getBitmapPoolType() {
            return this.bitmapPoolType;
        }

        public final void setBitmapPoolType$imagepipeline_release(String str) {
            this.bitmapPoolType = str;
        }

        /* JADX INFO: renamed from: getBitmapPoolMaxPoolSize$imagepipeline_release, reason: from getter */
        public final int getBitmapPoolMaxPoolSize() {
            return this.bitmapPoolMaxPoolSize;
        }

        public final void setBitmapPoolMaxPoolSize$imagepipeline_release(int i) {
            this.bitmapPoolMaxPoolSize = i;
        }

        /* JADX INFO: renamed from: getBitmapPoolMaxBitmapSize$imagepipeline_release, reason: from getter */
        public final int getBitmapPoolMaxBitmapSize() {
            return this.bitmapPoolMaxBitmapSize;
        }

        public final void setBitmapPoolMaxBitmapSize$imagepipeline_release(int i) {
            this.bitmapPoolMaxBitmapSize = i;
        }

        /* JADX INFO: renamed from: getRegisterLruBitmapPoolAsMemoryTrimmable$imagepipeline_release, reason: from getter */
        public final boolean getRegisterLruBitmapPoolAsMemoryTrimmable() {
            return this.registerLruBitmapPoolAsMemoryTrimmable;
        }

        public final void setRegisterLruBitmapPoolAsMemoryTrimmable$imagepipeline_release(boolean z) {
            this.registerLruBitmapPoolAsMemoryTrimmable = z;
        }

        public final Builder setBitmapPoolParams(PoolParams bitmapPoolParams) {
            Intrinsics.checkNotNullParameter(bitmapPoolParams, "bitmapPoolParams");
            this.bitmapPoolParams = bitmapPoolParams;
            return this;
        }

        public final Builder setBitmapPoolStatsTracker(PoolStatsTracker bitmapPoolStatsTracker) {
            Intrinsics.checkNotNullParameter(bitmapPoolStatsTracker, "bitmapPoolStatsTracker");
            this.bitmapPoolStatsTracker = bitmapPoolStatsTracker;
            return this;
        }

        public final Builder setFlexByteArrayPoolParams(PoolParams flexByteArrayPoolParams) {
            this.flexByteArrayPoolParams = flexByteArrayPoolParams;
            return this;
        }

        public final Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.memoryTrimmableRegistry = memoryTrimmableRegistry;
            return this;
        }

        public final Builder setNativeMemoryChunkPoolParams(PoolParams memoryChunkPoolParams) {
            Intrinsics.checkNotNullParameter(memoryChunkPoolParams, "memoryChunkPoolParams");
            this.memoryChunkPoolParams = memoryChunkPoolParams;
            return this;
        }

        public final Builder setNativeMemoryChunkPoolStatsTracker(PoolStatsTracker memoryChunkPoolStatsTracker) {
            Intrinsics.checkNotNullParameter(memoryChunkPoolStatsTracker, "memoryChunkPoolStatsTracker");
            this.memoryChunkPoolStatsTracker = memoryChunkPoolStatsTracker;
            return this;
        }

        public final Builder setSmallByteArrayPoolParams(PoolParams commonByteArrayPoolParams) {
            Intrinsics.checkNotNullParameter(commonByteArrayPoolParams, "commonByteArrayPoolParams");
            this.smallByteArrayPoolParams = commonByteArrayPoolParams;
            return this;
        }

        public final Builder setSmallByteArrayPoolStatsTracker(PoolStatsTracker smallByteArrayPoolStatsTracker) {
            Intrinsics.checkNotNullParameter(smallByteArrayPoolStatsTracker, "smallByteArrayPoolStatsTracker");
            this.smallByteArrayPoolStatsTracker = smallByteArrayPoolStatsTracker;
            return this;
        }

        public final PoolConfig build() {
            return new PoolConfig(this, null);
        }

        public final Builder setBitmapPoolType(String bitmapPoolType) {
            this.bitmapPoolType = bitmapPoolType;
            return this;
        }

        public final Builder setBitmapPoolMaxPoolSize(int bitmapPoolMaxPoolSize) {
            this.bitmapPoolMaxPoolSize = bitmapPoolMaxPoolSize;
            return this;
        }

        public final Builder setBitmapPoolMaxBitmapSize(int bitmapPoolMaxBitmapSize) {
            this.bitmapPoolMaxBitmapSize = bitmapPoolMaxBitmapSize;
            return this;
        }

        public final Builder setRegisterLruBitmapPoolAsMemoryTrimmable(boolean registerLruBitmapPoolAsMemoryTrimmable) {
            this.registerLruBitmapPoolAsMemoryTrimmable = registerLruBitmapPoolAsMemoryTrimmable;
            return this;
        }
    }

    /* JADX INFO: compiled from: PoolConfig.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/memory/PoolConfig$Companion;", "", "<init>", "()V", "BITMAP_POOL_MAX_BITMAP_SIZE_DEFAULT", "", "newBuilder", "Lcom/facebook/imagepipeline/memory/PoolConfig$Builder;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Builder newBuilder() {
            return new Builder();
        }
    }
}
