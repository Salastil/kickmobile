package com.facebook.fresco.vito.core;

import android.content.res.Resources;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.fresco.middleware.HasExtraData;
import com.facebook.fresco.urimod.Dimensions;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.source.ImageSource;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VitoImageRequest.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0016\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u0001H\u0018H\u0016¢\u0006\u0002\u0010\u001bJ\u001d\u0010\u001c\u001a\u0004\u0018\u0001H\u0018\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u001dJ'\u0010\u001c\u001a\u0004\u0018\u0001H\u0018\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u0001H\u0018H\u0016¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110!j\u0002`\"H\u0016J \u0010#\u001a\u00020\u00172\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110!j\u0002`\"H\u0016J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0018\u0010&\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u00002\u0006\u0010'\u001a\u00020\tJ\b\u0010(\u001a\u00020)H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/facebook/fresco/vito/core/VitoImageRequest;", "Lcom/facebook/fresco/middleware/HasExtraData;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "imageSource", "Lcom/facebook/fresco/vito/source/ImageSource;", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "logWithHighSamplingRate", "", "finalImageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "finalImageCacheKey", "Lcom/facebook/cache/common/CacheKey;", "extras", "", "", "", "viewport", "Lcom/facebook/fresco/urimod/Dimensions;", "<init>", "(Landroid/content/res/Resources;Lcom/facebook/fresco/vito/source/ImageSource;Lcom/facebook/fresco/vito/options/ImageOptions;ZLcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/cache/common/CacheKey;Ljava/util/Map;Lcom/facebook/fresco/urimod/Dimensions;)V", "putExtra", "", ExifInterface.LONGITUDE_EAST, "key", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "getExtra", "(Ljava/lang/String;)Ljava/lang/Object;", "valueIfNotFound", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getExtras", "", "Lcom/facebook/fresco/middleware/Extras;", "putExtras", "equals", "other", "equalsIfHasImage", "hasImage", "hashCode", "", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VitoImageRequest implements HasExtraData {
    public final Map<String, Object> extras;
    public final CacheKey finalImageCacheKey;
    public final ImageRequest finalImageRequest;
    public final ImageOptions imageOptions;
    public final ImageSource imageSource;
    public final boolean logWithHighSamplingRate;
    public final Resources resources;
    public final Dimensions viewport;

    public VitoImageRequest(Resources resources, ImageSource imageSource, ImageOptions imageOptions, boolean z, ImageRequest imageRequest, CacheKey cacheKey, Map<String, Object> extras, Dimensions dimensions) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.resources = resources;
        this.imageSource = imageSource;
        this.imageOptions = imageOptions;
        this.logWithHighSamplingRate = z;
        this.finalImageRequest = imageRequest;
        this.finalImageCacheKey = cacheKey;
        this.extras = extras;
        this.viewport = dimensions;
    }

    public /* synthetic */ VitoImageRequest(Resources resources, ImageSource imageSource, ImageOptions imageOptions, boolean z, ImageRequest imageRequest, CacheKey cacheKey, Map map, Dimensions dimensions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(resources, imageSource, imageOptions, (i & 8) != 0 ? false : z, imageRequest, cacheKey, (i & 64) != 0 ? new LinkedHashMap() : map, (i & 128) != 0 ? null : dimensions);
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public <E> void putExtra(String key, E value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, Object> map = this.extras;
        if (value == null) {
            map.remove(key);
        } else {
            map.put(key, value);
        }
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public <E> E getExtra(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        E e = (E) this.extras.get(key);
        if (e == null) {
            return null;
        }
        return e;
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public <E> E getExtra(String key, E valueIfNotFound) {
        Intrinsics.checkNotNullParameter(key, "key");
        E e = (E) getExtra(key);
        return e == null ? valueIfNotFound : e;
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public Map<String, Object> getExtras() {
        return this.extras;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && Intrinsics.areEqual(getClass(), other.getClass())) {
            VitoImageRequest vitoImageRequest = (VitoImageRequest) other;
            if (this.resources == vitoImageRequest.resources && Objects.equal(this.imageSource, vitoImageRequest.imageSource) && Objects.equal(this.imageOptions, vitoImageRequest.imageOptions)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equalsIfHasImage(VitoImageRequest other, boolean hasImage) {
        boolean zEqual;
        if (this == other) {
            return true;
        }
        if (other != null && this.resources == other.resources && Objects.equal(this.imageSource, other.imageSource)) {
            ImageOptions imageOptions = this.imageOptions;
            if (hasImage) {
                zEqual = imageOptions.equalsForActualImage(other.imageOptions);
            } else {
                zEqual = Objects.equal(imageOptions, other.imageOptions);
            }
            if (zEqual) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.resources.hashCode() * 31) + this.imageSource.hashCode()) * 31) + this.imageOptions.hashCode();
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public void putExtras(Map<String, ? extends Object> extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        for (Map.Entry<String, ? extends Object> entry : extras.entrySet()) {
            putExtra(entry.getKey(), entry.getValue());
        }
    }
}
