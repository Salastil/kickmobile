package com.facebook.fresco.vito.source;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.LruCache;
import com.facebook.common.util.UriUtil;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageSourceProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H\u0007J*\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010*H\u0007J*\u0010'\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010*H\u0007J!\u0010,\u001a\u00020&2\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0.\"\u00020&H\u0007¢\u0006\u0002\u0010/J\u0018\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020&H\u0007J0\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010*H\u0007J\u001c\u00100\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u00010\u00072\b\u00104\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u00105\u001a\u00020&2\u0006\u00105\u001a\u000206H\u0007J\u0010\u00107\u001a\u00020&2\u0006\u00107\u001a\u000208H\u0007R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR)\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/facebook/fresco/vito/source/ImageSourceProvider;", "", "<init>", "()V", "uriParser", "Lkotlin/Function1;", "", "Landroid/net/Uri;", "getUriParser", "()Lkotlin/jvm/functions/Function1;", "setUriParser", "(Lkotlin/jvm/functions/Function1;)V", "shortcutResUris", "", "getShortcutResUris", "()Z", "setShortcutResUris", "(Z)V", "treatEmptyUriAsImageSource", "getTreatEmptyUriAsImageSource", "setTreatEmptyUriAsImageSource", "uriCacheSize", "", "getUriCacheSize", "()I", "setUriCacheSize", "(I)V", "uriCache", "Landroid/util/LruCache;", "getUriCache", "()Landroid/util/LruCache;", "uriCache$delegate", "Lkotlin/Lazy;", "emptyImageSource", "Lcom/facebook/fresco/vito/source/EmptyImageSource;", "nullUriImageSource", "emptyUriImageSource", "emptySource", "Lcom/facebook/fresco/vito/source/ImageSource;", "forUri", "uri", "extras", "", "uriString", "firstAvailable", "imageSources", "", "([Lcom/facebook/fresco/vito/source/ImageSource;)Lcom/facebook/fresco/vito/source/ImageSource;", "increasingQuality", "lowResImageSource", "highResImageSource", "lowResImageUri", "highResImageUri", "bitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "source_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageSourceProvider {
    private static boolean shortcutResUris;
    private static boolean treatEmptyUriAsImageSource;
    private static int uriCacheSize;
    public static final ImageSourceProvider INSTANCE = new ImageSourceProvider();
    private static Function1<? super String, ? extends Uri> uriParser = new Function1() { // from class: com.facebook.fresco.vito.source.ImageSourceProvider$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return ImageSourceProvider.uriParser$lambda$0((String) obj);
        }
    };

    /* JADX INFO: renamed from: uriCache$delegate, reason: from kotlin metadata */
    private static final Lazy uriCache = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.facebook.fresco.vito.source.ImageSourceProvider$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ImageSourceProvider.uriCache_delegate$lambda$1();
        }
    });
    private static final EmptyImageSource emptyImageSource = new EmptyImageSource("emptySource()");
    private static final EmptyImageSource nullUriImageSource = new EmptyImageSource("forUri(null)");
    private static final EmptyImageSource emptyUriImageSource = new EmptyImageSource("forUri(empty)");

    @JvmStatic
    public static final ImageSource forUri(Uri uri) {
        return forUri$default(uri, (Map) null, 2, (Object) null);
    }

    @JvmStatic
    public static final ImageSource forUri(String str) {
        return forUri$default(str, (Map) null, 2, (Object) null);
    }

    private ImageSourceProvider() {
    }

    public final Function1<String, Uri> getUriParser() {
        return uriParser;
    }

    public final void setUriParser(Function1<? super String, ? extends Uri> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        uriParser = function1;
    }

    static final Uri uriParser$lambda$0(String uriString) {
        Intrinsics.checkNotNullParameter(uriString, "uriString");
        Uri uri = Uri.parse(uriString);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        return uri;
    }

    public final boolean getShortcutResUris() {
        return shortcutResUris;
    }

    public final void setShortcutResUris(boolean z) {
        shortcutResUris = z;
    }

    public final boolean getTreatEmptyUriAsImageSource() {
        return treatEmptyUriAsImageSource;
    }

    public final void setTreatEmptyUriAsImageSource(boolean z) {
        treatEmptyUriAsImageSource = z;
    }

    public final int getUriCacheSize() {
        return uriCacheSize;
    }

    public final void setUriCacheSize(int i) {
        uriCacheSize = i;
    }

    public final LruCache<String, Uri> getUriCache() {
        return (LruCache) uriCache.getValue();
    }

    static final LruCache uriCache_delegate$lambda$1() {
        if (uriCacheSize > 0) {
            return new LruCache(uriCacheSize);
        }
        return null;
    }

    @JvmStatic
    public static final ImageSource emptySource() {
        return emptyImageSource;
    }

    public static /* synthetic */ ImageSource forUri$default(Uri uri, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        return forUri(uri, (Map<String, ? extends Object>) map);
    }

    @JvmStatic
    public static final ImageSource forUri(Uri uri, Map<String, ? extends Object> extras) {
        if (uri == null) {
            return nullUriImageSource;
        }
        if (treatEmptyUriAsImageSource) {
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (string.length() == 0) {
                return emptyUriImageSource;
            }
        }
        if (shortcutResUris && Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_RESOURCE_SCHEME)) {
            String lastPathSegment = uri.getLastPathSegment();
            return new DrawableResImageSource(lastPathSegment != null ? Integer.parseInt(lastPathSegment) : 0);
        }
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        if (extras != null) {
            mapCreateMapBuilder.putAll(extras);
        }
        mapCreateMapBuilder.put("uri_source", uri);
        return new SingleImageSourceImpl(uri, MapsKt.build(mapCreateMapBuilder));
    }

    public static /* synthetic */ ImageSource forUri$default(String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        return forUri(str, (Map<String, ? extends Object>) map);
    }

    @JvmStatic
    public static final ImageSource forUri(String uriString, Map<String, ? extends Object> extras) {
        LruCache<String, Uri> uriCache2;
        if (uriString != null) {
            LruCache<String, Uri> uriCache3 = INSTANCE.getUriCache();
            Uri uri = uriCache3 != null ? uriCache3.get(uriString) : null;
            if (uri != null) {
                return forUri(uri, extras);
            }
        }
        Uri uriInvoke = uriString != null ? uriParser.invoke(uriString) : null;
        if (uriInvoke != null && (uriCache2 = INSTANCE.getUriCache()) != null) {
            uriCache2.put(uriString, uriInvoke);
        }
        return forUri(uriInvoke, extras);
    }

    @JvmStatic
    public static final ImageSource firstAvailable(ImageSource... imageSources) {
        Intrinsics.checkNotNullParameter(imageSources, "imageSources");
        return new FirstAvailableImageSource(imageSources);
    }

    @JvmStatic
    public static final ImageSource increasingQuality(ImageSource lowResImageSource, ImageSource highResImageSource) {
        Intrinsics.checkNotNullParameter(lowResImageSource, "lowResImageSource");
        Intrinsics.checkNotNullParameter(highResImageSource, "highResImageSource");
        return new IncreasingQualityImageSource(lowResImageSource, highResImageSource, null);
    }

    public static /* synthetic */ ImageSource increasingQuality$default(ImageSource imageSource, ImageSource imageSource2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        return increasingQuality(imageSource, imageSource2, map);
    }

    @JvmStatic
    public static final ImageSource increasingQuality(ImageSource lowResImageSource, ImageSource highResImageSource, Map<String, ? extends Object> extras) {
        Intrinsics.checkNotNullParameter(lowResImageSource, "lowResImageSource");
        Intrinsics.checkNotNullParameter(highResImageSource, "highResImageSource");
        return new IncreasingQualityImageSource(lowResImageSource, highResImageSource, extras);
    }

    @JvmStatic
    public static final ImageSource increasingQuality(Uri lowResImageUri, Uri highResImageUri) {
        if (lowResImageUri == null) {
            return forUri$default(highResImageUri, (Map) null, 2, (Object) null);
        }
        return new IncreasingQualityImageSource(forUri$default(lowResImageUri, (Map) null, 2, (Object) null), forUri$default(highResImageUri, (Map) null, 2, (Object) null), null, 4, null);
    }

    @JvmStatic
    public static final ImageSource bitmap(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return new BitmapImageSource(bitmap);
    }

    @JvmStatic
    public static final ImageSource drawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return new DrawableImageSource(drawable);
    }
}
