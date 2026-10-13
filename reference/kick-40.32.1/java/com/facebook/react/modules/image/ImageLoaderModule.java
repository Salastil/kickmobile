package com.facebook.react.modules.image;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.SparseArray;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.DownsampleMode;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapBuilder;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.fresco.ReactNetworkImageRequest;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.image.ReactCallerContextFactory;
import com.facebook.react.views.imagehelper.ImageSource;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageLoaderModule.kt */
/* JADX INFO: loaded from: classes6.dex */
@ReactModule(name = "ImageLoader")
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0005\u0010\u000eJ\u001a\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0017J$\u0010\"\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010 \u001a\u00020!H\u0017J\u001c\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0&2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+2\u0006\u0010 \u001a\u00020!H\u0002J\u001c\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0'0&2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\"\u00100\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u00101\u001a\u0002022\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u000202H\u0016J\u0018\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u0002072\u0006\u0010 \u001a\u00020!H\u0017J \u00108\u001a\u00020\u001d2\u0006\u00104\u001a\u0002092\u000e\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0002J\u001a\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00132\u0006\u00104\u001a\u000209H\u0002J\b\u0010<\u001a\u00020\u001dH\u0016J\b\u0010=\u001a\u00020\u001dH\u0016J\b\u0010>\u001a\u00020\u001dH\u0016R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R$\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006@"}, d2 = {"Lcom/facebook/react/modules/image/ImageLoaderModule;", "Lcom/facebook/fbreact/specs/NativeImageLoaderAndroidSpec;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "callerContext", "", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/Object;)V", "imagePipeline", "Lcom/facebook/imagepipeline/core/ImagePipeline;", "callerContextFactory", "Lcom/facebook/react/views/image/ReactCallerContextFactory;", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/imagepipeline/core/ImagePipeline;Lcom/facebook/react/views/image/ReactCallerContextFactory;)V", "_imagePipeline", "enqueuedRequestMonitor", "enqueuedRequests", "Landroid/util/SparseArray;", "Lcom/facebook/datasource/DataSource;", "Ljava/lang/Void;", "getCallerContext", "()Ljava/lang/Object;", "value", "getImagePipeline", "()Lcom/facebook/imagepipeline/core/ImagePipeline;", "setImagePipeline", "(Lcom/facebook/imagepipeline/core/ImagePipeline;)V", "getSize", "", "uriString", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "getSizeWithHeaders", "headers", "Lcom/facebook/react/bridge/ReadableMap;", "createSizeSubscriber", "Lcom/facebook/datasource/DataSubscriber;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/common/memory/PooledByteBuffer;", "resolveDataUriSize", "uri", "Landroid/net/Uri;", "createDecodedSizeSubscriber", "Lcom/facebook/imagepipeline/image/CloseableImage;", "resolveResourceSize", "name", "prefetchImage", "requestIdAsDouble", "", "abortRequest", "requestId", "queryCache", "uris", "Lcom/facebook/react/bridge/ReadableArray;", "registerRequest", "", "request", "removeRequest", "onHostResume", "onHostPause", "onHostDestroy", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageLoaderModule extends NativeImageLoaderAndroidSpec implements LifecycleEventListener {
    private static final String ERROR_GET_SIZE_FAILURE = "E_GET_SIZE_FAILURE";
    private static final String ERROR_INVALID_URI = "E_INVALID_URI";
    private static final String ERROR_PREFETCH_FAILURE = "E_PREFETCH_FAILURE";
    public static final String NAME = "ImageLoader";
    private ImagePipeline _imagePipeline;
    private final Object callerContext;
    private ReactCallerContextFactory callerContextFactory;
    private final Object enqueuedRequestMonitor;
    private final SparseArray<DataSource<Void>> enqueuedRequests;

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    private final Object getCallerContext() {
        Object orCreateCallerContext;
        ReactCallerContextFactory reactCallerContextFactory = this.callerContextFactory;
        return (reactCallerContextFactory == null || (orCreateCallerContext = reactCallerContextFactory.getOrCreateCallerContext("", "")) == null) ? this.callerContext : orCreateCallerContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImagePipeline getImagePipeline() {
        ImagePipeline imagePipeline = this._imagePipeline;
        if (imagePipeline != null) {
            return imagePipeline;
        }
        ImagePipeline imagePipeline2 = Fresco.getImagePipeline();
        Intrinsics.checkNotNullExpressionValue(imagePipeline2, "getImagePipeline(...)");
        return imagePipeline2;
    }

    private final void setImagePipeline(ImagePipeline imagePipeline) {
        this._imagePipeline = imagePipeline;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLoaderModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.enqueuedRequestMonitor = new Object();
        this.enqueuedRequests = new SparseArray<>();
        this.callerContext = this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLoaderModule(ReactApplicationContext reactContext, Object obj) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.enqueuedRequestMonitor = new Object();
        this.enqueuedRequests = new SparseArray<>();
        this.callerContext = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLoaderModule(ReactApplicationContext reactContext, ImagePipeline imagePipeline, ReactCallerContextFactory callerContextFactory) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(imagePipeline, "imagePipeline");
        Intrinsics.checkNotNullParameter(callerContextFactory, "callerContextFactory");
        this.enqueuedRequestMonitor = new Object();
        this.enqueuedRequests = new SparseArray<>();
        this.callerContextFactory = callerContextFactory;
        setImagePipeline(imagePipeline);
        this.callerContext = null;
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    @ReactMethod
    public void getSize(String uriString, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        String str = uriString;
        if (str == null || str.length() == 0) {
            promise.reject(ERROR_INVALID_URI, "Cannot get the size of an image for an empty URI");
            return;
        }
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        ImageSource imageSource = new ImageSource(reactApplicationContext, uriString, 0.0d, 0.0d, null, 28, null);
        if (imageSource.get_isResource()) {
            resolveResourceSize(uriString, promise);
        } else {
            if (UriUtil.isDataUri(imageSource.getUri())) {
                resolveDataUriSize(imageSource.getUri(), promise);
                return;
            }
            ImageRequest imageRequestBuild = ImageRequestBuilder.newBuilderWithSource(imageSource.getUri()).setRotationOptions(RotationOptions.INSTANCE.disableRotation()).build();
            Intrinsics.checkNotNullExpressionValue(imageRequestBuild, "build(...)");
            getImagePipeline().fetchEncodedImage(imageRequestBuild, getCallerContext()).subscribe(createSizeSubscriber(promise), CallerThreadExecutor.getInstance());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    @ReactMethod
    public void getSizeWithHeaders(String uriString, ReadableMap headers, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        String str = uriString;
        if (str == null || str.length() == 0) {
            promise.reject(ERROR_INVALID_URI, "Cannot get the size of an image for an empty URI");
            return;
        }
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        ImageSource imageSource = new ImageSource(reactApplicationContext, uriString, 0.0d, 0.0d, null, 28, null);
        if (imageSource.get_isResource()) {
            resolveResourceSize(uriString, promise);
            return;
        }
        if (UriUtil.isDataUri(imageSource.getUri())) {
            resolveDataUriSize(imageSource.getUri(), promise);
            return;
        }
        ImageRequestBuilder rotationOptions = ImageRequestBuilder.newBuilderWithSource(imageSource.getUri()).setRotationOptions(RotationOptions.INSTANCE.disableRotation());
        Intrinsics.checkNotNullExpressionValue(rotationOptions, "setRotationOptions(...)");
        getImagePipeline().fetchEncodedImage(ReactNetworkImageRequest.Companion.fromBuilderWithHeaders$default(ReactNetworkImageRequest.INSTANCE, rotationOptions, headers, null, 4, null), getCallerContext()).subscribe(createSizeSubscriber(promise), CallerThreadExecutor.getInstance());
    }

    private final DataSubscriber<CloseableReference<PooledByteBuffer>> createSizeSubscriber(final Promise promise) {
        return new BaseDataSubscriber<CloseableReference<PooledByteBuffer>>() { // from class: com.facebook.react.modules.image.ImageLoaderModule.createSizeSubscriber.1
            @Override // com.facebook.datasource.BaseDataSubscriber
            protected void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> dataSource) throws Throwable {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                if (!dataSource.isFinished()) {
                    return;
                }
                CloseableReference<PooledByteBuffer> result = dataSource.getResult();
                if (result == null) {
                    promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, "Failed to get the size of the image");
                    return;
                }
                EncodedImage encodedImage = null;
                try {
                    try {
                        EncodedImage encodedImage2 = new EncodedImage(result);
                        try {
                            boolean z = encodedImage2.getRotationAngle() == 90 || encodedImage2.getRotationAngle() == 270 || encodedImage2.getExifOrientation() == 5 || encodedImage2.getExifOrientation() == 7;
                            int height = z ? encodedImage2.getHeight() : encodedImage2.getWidth();
                            int width = z ? encodedImage2.getWidth() : encodedImage2.getHeight();
                            if (height >= 0 && width >= 0) {
                                WritableMap writableMapCreateMap = Arguments.createMap();
                                ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
                                readableMapBuilder.put(ViewProps.WIDTH, height);
                                readableMapBuilder.put(ViewProps.HEIGHT, width);
                                promise.resolve(writableMapCreateMap);
                                encodedImage2.close();
                                CloseableReference.closeSafely(result);
                                return;
                            }
                            promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, "Failed to get the size of the image");
                            encodedImage2.close();
                            CloseableReference.closeSafely(result);
                        } catch (Exception e) {
                            e = e;
                            encodedImage = encodedImage2;
                            promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, e);
                            if (encodedImage != null) {
                                encodedImage.close();
                            }
                            CloseableReference.closeSafely(result);
                        } catch (Throwable th) {
                            th = th;
                            encodedImage = encodedImage2;
                            if (encodedImage != null) {
                                encodedImage.close();
                            }
                            CloseableReference.closeSafely(result);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            protected void onFailureImpl(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, dataSource.getFailureCause());
            }
        };
    }

    private final void resolveDataUriSize(Uri uri, Promise promise) {
        getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).setRotationOptions(RotationOptions.INSTANCE.autoRotate()).setDownsampleOverride(DownsampleMode.NEVER).build(), getCallerContext()).subscribe(createDecodedSizeSubscriber(promise), CallerThreadExecutor.getInstance());
    }

    private final DataSubscriber<CloseableReference<CloseableImage>> createDecodedSizeSubscriber(final Promise promise) {
        return new BaseDataSubscriber<CloseableReference<CloseableImage>>() { // from class: com.facebook.react.modules.image.ImageLoaderModule.createDecodedSizeSubscriber.1
            @Override // com.facebook.datasource.BaseDataSubscriber
            protected void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                if (dataSource.isFinished()) {
                    CloseableReference<CloseableImage> result = dataSource.getResult();
                    try {
                        if (result == null) {
                            promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, "Failed to get the size of the image");
                            return;
                        }
                        CloseableImage closeableImage = result.get();
                        Intrinsics.checkNotNullExpressionValue(closeableImage, "get(...)");
                        CloseableImage closeableImage2 = closeableImage;
                        int width = closeableImage2.getWidth();
                        int height = closeableImage2.getHeight();
                        if (width >= 0 && height >= 0) {
                            Promise promise2 = promise;
                            WritableMap writableMapCreateMap = Arguments.createMap();
                            ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
                            readableMapBuilder.put(ViewProps.WIDTH, width);
                            readableMapBuilder.put(ViewProps.HEIGHT, height);
                            promise2.resolve(writableMapCreateMap);
                            return;
                        }
                        promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, "Failed to get the size of the image");
                    } catch (Exception e) {
                        promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, e);
                    } finally {
                        CloseableReference.closeSafely(result);
                    }
                }
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                promise.reject(ImageLoaderModule.ERROR_GET_SIZE_FAILURE, dataSource.getFailureCause());
            }
        };
    }

    private final void resolveResourceSize(String name, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        try {
            Drawable resourceDrawable = ResourceDrawableIdHelper.getResourceDrawable(reactApplicationContext, name);
            if (resourceDrawable == null) {
                promise.reject(ERROR_GET_SIZE_FAILURE, "Could not resolve drawable resource: " + name);
                return;
            }
            int intrinsicWidth = resourceDrawable.getIntrinsicWidth();
            int intrinsicHeight = resourceDrawable.getIntrinsicHeight();
            if (intrinsicWidth < 0 || intrinsicHeight < 0) {
                promise.reject(ERROR_GET_SIZE_FAILURE, "Drawable resource has no intrinsic size: " + name);
            } else {
                WritableMap writableMapCreateMap = Arguments.createMap();
                ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
                readableMapBuilder.put(ViewProps.WIDTH, intrinsicWidth);
                readableMapBuilder.put(ViewProps.HEIGHT, intrinsicHeight);
                promise.resolve(writableMapCreateMap);
            }
        } catch (Exception e) {
            promise.reject(ERROR_GET_SIZE_FAILURE, e);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    public void prefetchImage(String uriString, double requestIdAsDouble, final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        final int i = (int) requestIdAsDouble;
        String str = uriString;
        if (str == null || str.length() == 0) {
            promise.reject(ERROR_INVALID_URI, "Cannot prefetch an image for an empty URI");
            return;
        }
        ImageRequest imageRequestBuild = ImageRequestBuilder.newBuilderWithSource(Uri.parse(uriString)).build();
        Intrinsics.checkNotNullExpressionValue(imageRequestBuild, "build(...)");
        DataSource<Void> dataSourcePrefetchToDiskCache = getImagePipeline().prefetchToDiskCache(imageRequestBuild, getCallerContext());
        BaseDataSubscriber<Void> baseDataSubscriber = new BaseDataSubscriber<Void>() { // from class: com.facebook.react.modules.image.ImageLoaderModule$prefetchImage$prefetchSubscriber$1
            @Override // com.facebook.datasource.BaseDataSubscriber
            protected void onNewResultImpl(DataSource<Void> dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                try {
                    if (dataSource.isFinished()) {
                        this.this$0.removeRequest(i);
                        promise.resolve(true);
                    }
                } catch (Exception e) {
                    promise.reject("E_PREFETCH_FAILURE", e);
                } finally {
                    dataSource.close();
                }
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            protected void onFailureImpl(DataSource<Void> dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                try {
                    this.this$0.removeRequest(i);
                    promise.reject("E_PREFETCH_FAILURE", dataSource.getFailureCause());
                } finally {
                    dataSource.close();
                }
            }
        };
        registerRequest(i, dataSourcePrefetchToDiskCache);
        dataSourcePrefetchToDiskCache.subscribe(baseDataSubscriber, CallerThreadExecutor.getInstance());
    }

    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    public void abortRequest(double requestId) {
        DataSource<Void> dataSourceRemoveRequest = removeRequest((int) requestId);
        if (dataSourceRemoveRequest != null) {
            dataSourceRemoveRequest.close();
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.facebook.react.modules.image.ImageLoaderModule$queryCache$1] */
    @Override // com.facebook.fbreact.specs.NativeImageLoaderAndroidSpec
    @ReactMethod
    public void queryCache(ReadableArray uris, Promise promise) {
        Intrinsics.checkNotNullParameter(uris, "uris");
        Intrinsics.checkNotNullParameter(promise, "promise");
        new GuardedAsyncTask<Void, Void>(this, uris, getReactApplicationContext()) { // from class: com.facebook.react.modules.image.ImageLoaderModule.queryCache.1
            final /* synthetic */ ReadableArray $uris;
            final /* synthetic */ ImageLoaderModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(reactApplicationContext);
                Intrinsics.checkNotNull(reactApplicationContext);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void... params) {
                Intrinsics.checkNotNullParameter(params, "params");
                ImageLoaderModule imageLoaderModule = this.this$0;
                ReadableArray readableArray = this.$uris;
                WritableMap writableMapCreateMap = Arguments.createMap();
                ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
                ImagePipeline imagePipeline = imageLoaderModule.getImagePipeline();
                int size = readableArray.size();
                for (int i = 0; i < size; i++) {
                    String string = readableArray.getString(i);
                    String str = string;
                    if (str != null && str.length() != 0) {
                        Uri uri = Uri.parse(string);
                        if (imagePipeline.isInBitmapMemoryCache(uri)) {
                            readableMapBuilder.put(string, "memory");
                        } else if (imagePipeline.isInDiskCacheSync(uri)) {
                            readableMapBuilder.put(string, "disk");
                        }
                    }
                }
                this.$promise.resolve(writableMapCreateMap);
            }
        }.executeOnExecutor(GuardedAsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private final void registerRequest(int requestId, DataSource<Void> request) {
        synchronized (this.enqueuedRequestMonitor) {
            this.enqueuedRequests.put(requestId, request);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DataSource<Void> removeRequest(int requestId) {
        DataSource<Void> dataSource;
        synchronized (this.enqueuedRequestMonitor) {
            dataSource = this.enqueuedRequests.get(requestId);
            this.enqueuedRequests.remove(requestId);
        }
        return dataSource;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        synchronized (this.enqueuedRequestMonitor) {
            int size = this.enqueuedRequests.size();
            int i = 0;
            while (true) {
                SparseArray<DataSource<Void>> sparseArray = this.enqueuedRequests;
                if (i < size) {
                    DataSource<Void> dataSourceValueAt = sparseArray.valueAt(i);
                    Intrinsics.checkNotNullExpressionValue(dataSourceValueAt, "valueAt(...)");
                    dataSourceValueAt.close();
                    i++;
                } else {
                    sparseArray.clear();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }
}
