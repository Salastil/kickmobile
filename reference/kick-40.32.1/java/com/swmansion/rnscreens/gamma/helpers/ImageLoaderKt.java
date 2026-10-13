package com.swmansion.rnscreens.gamma.helpers;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageLoader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00030\tH\u0000\u001a.\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00012\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00030\tH\u0000\u001a.\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000e2\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00030\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"TAG", "", "resolveImage", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "systemDrawableResourceName", "imageUri", "onComplete", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "loadImage", "uri", "loadImageInternal", "Landroid/net/Uri;", "react-native-screens_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ImageLoaderKt {
    private static final String TAG = "ImageLoader";

    public static final void resolveImage(Context context, String str, String str2, Function1<? super Drawable, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        if (str != null) {
            onComplete.invoke(SystemDrawableKt.getSystemDrawableResource(context, str));
        } else if (str2 != null) {
            loadImage(context, str2, onComplete);
        } else {
            onComplete.invoke(null);
        }
    }

    public static final void loadImage(Context context, String uri, final Function1<? super Drawable, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        Uri uri2 = new ImageSource(context, uri).getUri(context);
        if (uri2 == null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.swmansion.rnscreens.gamma.helpers.ImageLoaderKt$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    onComplete.invoke(null);
                }
            });
        } else {
            loadImageInternal(context, uri2, new Function1() { // from class: com.swmansion.rnscreens.gamma.helpers.ImageLoaderKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ImageLoaderKt.loadImage$lambda$1(onComplete, (Drawable) obj);
                }
            });
        }
    }

    static final Unit loadImage$lambda$1(final Function1 function1, final Drawable drawable) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.swmansion.rnscreens.gamma.helpers.ImageLoaderKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                function1.invoke(drawable);
            }
        });
        return Unit.INSTANCE;
    }

    private static final void loadImageInternal(final Context context, final Uri uri, final Function1<? super Drawable, Unit> function1) {
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).build(), context).subscribe(new BaseDataSubscriber<CloseableReference<CloseableImage>>() { // from class: com.swmansion.rnscreens.gamma.helpers.ImageLoaderKt.loadImageInternal.1
            /* JADX WARN: Code duplicated, block: B:21:0x0057  */
            @Override // com.facebook.datasource.BaseDataSubscriber
            protected void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                BitmapDrawable bitmapDrawable;
                Bitmap underlyingBitmap;
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                if (dataSource.isFinished()) {
                    CloseableReference<CloseableImage> result = dataSource.getResult();
                    if (result == null) {
                        function1.invoke(null);
                        return;
                    }
                    CloseableReference<CloseableImage> closeableReference = result;
                    Context context2 = context;
                    try {
                        CloseableImage closeableImage = closeableReference.get();
                        Intrinsics.checkNotNullExpressionValue(closeableImage, "get(...)");
                        CloseableImage closeableImage2 = closeableImage;
                        if (!(closeableImage2 instanceof CloseableStaticBitmap) || (underlyingBitmap = ((CloseableStaticBitmap) closeableImage2).getUnderlyingBitmap()) == null) {
                            bitmapDrawable = null;
                        } else {
                            Bitmap.Config config = underlyingBitmap.getConfig();
                            if (config == null) {
                                config = Bitmap.Config.ARGB_8888;
                            }
                            Bitmap bitmapCopy = underlyingBitmap.copy(config, false);
                            if (bitmapCopy != null) {
                                Resources resources = context2.getResources();
                                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                                bitmapDrawable = new BitmapDrawable(resources, bitmapCopy);
                            } else {
                                bitmapDrawable = null;
                            }
                        }
                        CloseableKt.closeFinally(closeableReference, null);
                        function1.invoke(bitmapDrawable);
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

            @Override // com.facebook.datasource.BaseDataSubscriber
            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                Log.e("ImageLoader", "[RNScreens] Error loading image: " + uri, dataSource.getFailureCause());
                function1.invoke(null);
            }

            @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                function1.invoke(null);
            }
        }, CallerThreadExecutor.getInstance());
    }
}
