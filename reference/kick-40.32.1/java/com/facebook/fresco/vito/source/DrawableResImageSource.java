package com.facebook.fresco.vito.source;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DrawableResImageSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0019\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/fresco/vito/source/DrawableResImageSource;", "Lcom/facebook/fresco/vito/source/ImageSource;", "resId", "", "<init>", "(I)V", "getResId", "()I", "prefetchedDrawable", "Landroid/graphics/drawable/Drawable;", "equals", "", "other", "", "hashCode", "getClassNameString", "", LinkHeader.Rel.Prefetch, "", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "createDrawable", "createPrefetchDrawable", "component1", "copy", "toString", "Companion", "source_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DrawableResImageSource implements ImageSource {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Function2<? super Resources, ? super Integer, ? extends Object> customPrefetchFunction;
    private static boolean isPrefetchEnabled;
    private Drawable prefetchedDrawable;
    private final int resId;

    public static /* synthetic */ DrawableResImageSource copy$default(DrawableResImageSource drawableResImageSource, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = drawableResImageSource.resId;
        }
        return drawableResImageSource.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getResId() {
        return this.resId;
    }

    public final DrawableResImageSource copy(int resId) {
        return new DrawableResImageSource(resId);
    }

    public String toString() {
        return "DrawableResImageSource(resId=" + this.resId + ")";
    }

    public DrawableResImageSource(int i) {
        this.resId = i;
    }

    public final int getResId() {
        return this.resId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.facebook.fresco.vito.source.DrawableResImageSource");
        return this.resId == ((DrawableResImageSource) other).resId;
    }

    public int hashCode() {
        return this.resId;
    }

    @Override // com.facebook.fresco.vito.source.ImageSource
    public String getClassNameString() {
        return "DrawableResImageSource";
    }

    public final void prefetch(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        if (isPrefetchEnabled) {
            createPrefetchDrawable(resources);
        }
        Function2<? super Resources, ? super Integer, ? extends Object> function2 = customPrefetchFunction;
        if (function2 != null) {
            function2.invoke(resources, Integer.valueOf(this.resId));
        }
    }

    public final Drawable createDrawable(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        createPrefetchDrawable(resources);
        Drawable drawable = this.prefetchedDrawable;
        if (drawable != null) {
            return drawable;
        }
        throw new IllegalStateException("Failed to create drawable");
    }

    private final void createPrefetchDrawable(Resources resources) {
        if (this.prefetchedDrawable == null) {
            this.prefetchedDrawable = resources.getDrawable(this.resId);
        }
    }

    /* JADX INFO: compiled from: DrawableResImageSource.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/facebook/fresco/vito/source/DrawableResImageSource$Companion;", "", "<init>", "()V", "isPrefetchEnabled", "", "()Z", "setPrefetchEnabled", "(Z)V", "customPrefetchFunction", "Lkotlin/Function2;", "Landroid/content/res/Resources;", "", "getCustomPrefetchFunction", "()Lkotlin/jvm/functions/Function2;", "setCustomPrefetchFunction", "(Lkotlin/jvm/functions/Function2;)V", "source_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isPrefetchEnabled() {
            return DrawableResImageSource.isPrefetchEnabled;
        }

        public final void setPrefetchEnabled(boolean z) {
            DrawableResImageSource.isPrefetchEnabled = z;
        }

        public final Function2<Resources, Integer, Object> getCustomPrefetchFunction() {
            return DrawableResImageSource.customPrefetchFunction;
        }

        public final void setCustomPrefetchFunction(Function2<? super Resources, ? super Integer, ? extends Object> function2) {
            DrawableResImageSource.customPrefetchFunction = function2;
        }
    }
}
