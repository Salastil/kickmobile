package com.facebook.fresco.vito.options;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatedOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0007J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J)\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/facebook/fresco/vito/options/AnimatedOptions;", "", "loopCount", "", "thumbnailUrl", "", "disableAnimation", "", "<init>", "(ILjava/lang/String;Z)V", "getLoopCount", "()I", "getThumbnailUrl", "()Ljava/lang/String;", "getDisableAnimation", "()Z", "isInfinite", "isAnimationDisabled", "useFallbackThumbnail", "equals", "other", "hashCode", "component1", "component2", "component3", "copy", "toString", "Companion", "options_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnimatedOptions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AnimatedOptions INFINITE = new AnimatedOptions(0, null, false, 6, null);
    public static final int LOOP_COUNT_INFINITE = 0;
    private final boolean disableAnimation;
    private final int loopCount;
    private final String thumbnailUrl;

    public static /* synthetic */ AnimatedOptions copy$default(AnimatedOptions animatedOptions, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = animatedOptions.loopCount;
        }
        if ((i2 & 2) != 0) {
            str = animatedOptions.thumbnailUrl;
        }
        if ((i2 & 4) != 0) {
            z = animatedOptions.disableAnimation;
        }
        return animatedOptions.copy(i, str, z);
    }

    @JvmStatic
    public static final AnimatedOptions disableAnimation() {
        return INSTANCE.disableAnimation();
    }

    @JvmStatic
    public static final AnimatedOptions infinite() {
        return INSTANCE.infinite();
    }

    @JvmStatic
    public static final AnimatedOptions loop(int i) {
        return INSTANCE.loop(i);
    }

    @JvmStatic
    public static final AnimatedOptions loop(int i, String str) {
        return INSTANCE.loop(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLoopCount() {
        return this.loopCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getDisableAnimation() {
        return this.disableAnimation;
    }

    public final AnimatedOptions copy(int loopCount, String thumbnailUrl, boolean disableAnimation) {
        return new AnimatedOptions(loopCount, thumbnailUrl, disableAnimation);
    }

    public String toString() {
        return "AnimatedOptions(loopCount=" + this.loopCount + ", thumbnailUrl=" + this.thumbnailUrl + ", disableAnimation=" + this.disableAnimation + ")";
    }

    public AnimatedOptions(int i, String str, boolean z) {
        this.loopCount = i;
        this.thumbnailUrl = str;
        this.disableAnimation = z;
    }

    public /* synthetic */ AnimatedOptions(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? false : z);
    }

    public final int getLoopCount() {
        return this.loopCount;
    }

    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final boolean getDisableAnimation() {
        return this.disableAnimation;
    }

    public final boolean isInfinite() {
        return this.loopCount == 0;
    }

    public final boolean isAnimationDisabled() {
        return this.disableAnimation;
    }

    public final boolean useFallbackThumbnail() {
        String str = this.thumbnailUrl;
        return (str == null || str.length() == 0 || isInfinite()) ? false : true;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        AnimatedOptions animatedOptions = other instanceof AnimatedOptions ? (AnimatedOptions) other : null;
        return animatedOptions != null && this.loopCount == animatedOptions.loopCount && Intrinsics.areEqual(this.thumbnailUrl, animatedOptions.thumbnailUrl) && this.disableAnimation == animatedOptions.disableAnimation;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.loopCount) * 31;
        String str = this.thumbnailUrl;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.disableAnimation);
    }

    /* JADX INFO: compiled from: AnimatedOptions.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0007H\u0007J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0007J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/facebook/fresco/vito/options/AnimatedOptions$Companion;", "", "<init>", "()V", "LOOP_COUNT_INFINITE", "", "INFINITE", "Lcom/facebook/fresco/vito/options/AnimatedOptions;", "getINFINITE", "()Lcom/facebook/fresco/vito/options/AnimatedOptions;", "infinite", "loop", "loopCount", "thumbnailUrl", "", "disableAnimation", "options_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnimatedOptions getINFINITE() {
            return AnimatedOptions.INFINITE;
        }

        @JvmStatic
        public final AnimatedOptions infinite() {
            return getINFINITE();
        }

        @JvmStatic
        public final AnimatedOptions loop(int loopCount) {
            return new AnimatedOptions(loopCount, null, false, 6, null);
        }

        @JvmStatic
        public final AnimatedOptions loop(int loopCount, String thumbnailUrl) {
            return new AnimatedOptions(loopCount, thumbnailUrl, false, 4, null);
        }

        @JvmStatic
        public final AnimatedOptions disableAnimation() {
            return new AnimatedOptions(-1, null, true);
        }
    }
}
