package com.facebook.fresco.vito.core.impl;

import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.fresco.urimod.Dimensions;
import com.facebook.fresco.vito.core.ImagePipelineUtils;
import com.facebook.fresco.vito.core.impl.source.DataSourceImageSource;
import com.facebook.fresco.vito.core.impl.source.ImagePipelineImageSource;
import com.facebook.fresco.vito.core.impl.source.RetainingImageSource;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.source.EmptyImageSource;
import com.facebook.fresco.vito.source.FirstAvailableImageSource;
import com.facebook.fresco.vito.source.ImageSource;
import com.facebook.fresco.vito.source.IncreasingQualityImageSource;
import com.facebook.fresco.vito.source.SingleImageSource;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageSourceToImagePipelineAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007Jt\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007Jr\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\b\u0010\"\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010#\u001a\u00020$2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u001c\u0010%\u001a\u0004\u0018\u00010\u000e*\u00020&2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001c\u0010'\u001a\u0004\u0018\u00010\u000e*\u00020(2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/ImageSourceToImagePipelineAdapter;", "", "<init>", "()V", "NO_REQUEST_EXCEPTION", "Ljava/lang/NullPointerException;", "getNO_REQUEST_EXCEPTION", "()Ljava/lang/NullPointerException;", "NO_REQUEST_SUPPLIER", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "maybeExtractFinalImageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "imageSource", "Lcom/facebook/fresco/vito/source/ImageSource;", "imagePipelineUtils", "Lcom/facebook/fresco/vito/core/ImagePipelineUtils;", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "createDataSourceSupplier", "imagePipeline", "Lcom/facebook/imagepipeline/core/ImagePipeline;", "callerContext", "requestListener", "Lcom/facebook/imagepipeline/listener/RequestListener;", "uiComponentId", "", "extras", "", "viewport", "Lcom/facebook/fresco/urimod/Dimensions;", "createDataSource", "imageRequest", "requestLevel", "Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;", "extractSingleRequest", "Lcom/facebook/fresco/vito/source/SingleImageSource;", "extractFirstAvailableRequest", "Lcom/facebook/fresco/vito/source/FirstAvailableImageSource;", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageSourceToImagePipelineAdapter {
    public static final ImageSourceToImagePipelineAdapter INSTANCE = new ImageSourceToImagePipelineAdapter();
    private static final NullPointerException NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
    private static final Supplier<DataSource<CloseableReference<CloseableImage>>> NO_REQUEST_SUPPLIER = new Supplier() { // from class: com.facebook.fresco.vito.core.impl.ImageSourceToImagePipelineAdapter$$ExternalSyntheticLambda0
        @Override // com.facebook.common.internal.Supplier
        public final Object get() {
            return DataSources.immediateFailedDataSource(ImageSourceToImagePipelineAdapter.NO_REQUEST_EXCEPTION);
        }
    };

    private ImageSourceToImagePipelineAdapter() {
    }

    public final NullPointerException getNO_REQUEST_EXCEPTION() {
        return NO_REQUEST_EXCEPTION;
    }

    @JvmStatic
    public static final ImageRequest maybeExtractFinalImageRequest(ImageSource imageSource, ImagePipelineUtils imagePipelineUtils, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        Intrinsics.checkNotNullParameter(imagePipelineUtils, "imagePipelineUtils");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        if (imageSource instanceof SingleImageSource) {
            return INSTANCE.extractSingleRequest((SingleImageSource) imageSource, imagePipelineUtils, imageOptions);
        }
        if (imageSource instanceof EmptyImageSource) {
            return null;
        }
        if (imageSource instanceof FirstAvailableImageSource) {
            return INSTANCE.extractFirstAvailableRequest((FirstAvailableImageSource) imageSource, imagePipelineUtils, imageOptions);
        }
        if (imageSource instanceof IncreasingQualityImageSource) {
            return maybeExtractFinalImageRequest(((IncreasingQualityImageSource) imageSource).getHighResSource(), imagePipelineUtils, imageOptions);
        }
        if (imageSource instanceof ImagePipelineImageSource) {
            return ((ImagePipelineImageSource) imageSource).maybeExtractFinalImageRequest(imagePipelineUtils, imageOptions);
        }
        if (imageSource instanceof RetainingImageSource) {
            return maybeExtractFinalImageRequest(((RetainingImageSource) imageSource).get_currentSource(), imagePipelineUtils, imageOptions);
        }
        return null;
    }

    @JvmStatic
    public static final Supplier<DataSource<CloseableReference<CloseableImage>>> createDataSourceSupplier(final ImageSource imageSource, final ImagePipeline imagePipeline, final ImagePipelineUtils imagePipelineUtils, final ImageOptions imageOptions, final Object callerContext, final RequestListener requestListener, final String uiComponentId, final Map<String, Object> extras, final Dimensions viewport) {
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        Intrinsics.checkNotNullParameter(imagePipeline, "imagePipeline");
        Intrinsics.checkNotNullParameter(imagePipelineUtils, "imagePipelineUtils");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        Intrinsics.checkNotNullParameter(uiComponentId, "uiComponentId");
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (imageSource instanceof SingleImageSource) {
            return new Supplier() { // from class: com.facebook.fresco.vito.core.impl.ImageSourceToImagePipelineAdapter$$ExternalSyntheticLambda1
                @Override // com.facebook.common.internal.Supplier
                public final Object get() {
                    ImageSource imageSource2 = imageSource;
                    ImagePipelineUtils imagePipelineUtils2 = imagePipelineUtils;
                    ImageOptions imageOptions2 = imageOptions;
                    return ImageSourceToImagePipelineAdapter.createDataSource(ImageSourceToImagePipelineAdapter.INSTANCE.extractSingleRequest((SingleImageSource) imageSource2, imagePipelineUtils2, imageOptions2), imagePipeline, callerContext, requestListener, uiComponentId, ImageRequest.RequestLevel.FULL_FETCH, extras, viewport, imageOptions2);
                }
            };
        }
        if (imageSource instanceof ImagePipelineImageSource) {
            return new Supplier() { // from class: com.facebook.fresco.vito.core.impl.ImageSourceToImagePipelineAdapter$$ExternalSyntheticLambda2
                @Override // com.facebook.common.internal.Supplier
                public final Object get() {
                    return ImageSourceToImagePipelineAdapter.createDataSourceSupplier$lambda$2(imageSource, imagePipelineUtils, imageOptions, imagePipeline, callerContext, requestListener, uiComponentId, extras, viewport);
                }
            };
        }
        if (imageSource instanceof EmptyImageSource) {
            return NO_REQUEST_SUPPLIER;
        }
        if (imageSource instanceof FirstAvailableImageSource) {
            FirstAvailableImageSource firstAvailableImageSource = (FirstAvailableImageSource) imageSource;
            ImageSource[] imageSources = firstAvailableImageSource.getImageSources();
            ArrayList arrayList = new ArrayList(firstAvailableImageSource.getImageSources().length);
            for (ImageSource imageSource2 : imageSources) {
                arrayList.add(createDataSourceSupplier(imageSource2, imagePipeline, imagePipelineUtils, imageOptions, callerContext, requestListener, uiComponentId, extras, viewport));
            }
            FirstAvailableDataSourceSupplier firstAvailableDataSourceSupplierCreate = FirstAvailableDataSourceSupplier.create(arrayList);
            Intrinsics.checkNotNullExpressionValue(firstAvailableDataSourceSupplierCreate, "create(...)");
            return firstAvailableDataSourceSupplierCreate;
        }
        if (imageSource instanceof IncreasingQualityImageSource) {
            IncreasingQualityImageSource increasingQualityImageSource = (IncreasingQualityImageSource) imageSource;
            IncreasingQualityDataSourceSupplier increasingQualityDataSourceSupplierCreate = IncreasingQualityDataSourceSupplier.create(CollectionsKt.arrayListOf(createDataSourceSupplier(increasingQualityImageSource.getHighResSource(), imagePipeline, imagePipelineUtils, imageOptions, callerContext, requestListener, uiComponentId, extras, viewport), createDataSourceSupplier(increasingQualityImageSource.getLowResSource(), imagePipeline, imagePipelineUtils, imageOptions, callerContext, requestListener, uiComponentId, extras, viewport)));
            Intrinsics.checkNotNullExpressionValue(increasingQualityDataSourceSupplierCreate, "create(...)");
            return increasingQualityDataSourceSupplierCreate;
        }
        if (!(imageSource instanceof RetainingImageSource)) {
            return imageSource instanceof DataSourceImageSource ? ((DataSourceImageSource) imageSource).getDataSourceSupplier() : NO_REQUEST_SUPPLIER;
        }
        RetainingImageSource retainingImageSource = (RetainingImageSource) imageSource;
        retainingImageSource.setImageSourceUpdateFunction(new Function1() { // from class: com.facebook.fresco.vito.core.impl.ImageSourceToImagePipelineAdapter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImageSourceToImagePipelineAdapter.createDataSourceSupplier$lambda$4(imagePipeline, imagePipelineUtils, imageOptions, callerContext, requestListener, uiComponentId, extras, viewport, (ImageSource) obj);
            }
        });
        return retainingImageSource.getDataSourceSupplier();
    }

    static final DataSource createDataSourceSupplier$lambda$2(ImageSource imageSource, ImagePipelineUtils imagePipelineUtils, ImageOptions imageOptions, ImagePipeline imagePipeline, Object obj, RequestListener requestListener, String str, Map map, Dimensions dimensions) {
        ImagePipelineImageSource imagePipelineImageSource = (ImagePipelineImageSource) imageSource;
        return createDataSource(imagePipelineImageSource.maybeExtractFinalImageRequest(imagePipelineUtils, imageOptions), imagePipeline, obj, requestListener, str, imagePipelineImageSource.getRequestLevelForFetch(), map, dimensions, imageOptions);
    }

    static final Supplier createDataSourceSupplier$lambda$4(ImagePipeline imagePipeline, ImagePipelineUtils imagePipelineUtils, ImageOptions imageOptions, Object obj, RequestListener requestListener, String str, Map map, Dimensions dimensions, ImageSource newImageSource) {
        Intrinsics.checkNotNullParameter(newImageSource, "newImageSource");
        return createDataSourceSupplier(newImageSource, imagePipeline, imagePipelineUtils, imageOptions, obj, requestListener, str, map, dimensions);
    }

    public static /* synthetic */ DataSource createDataSource$default(ImageRequest imageRequest, ImagePipeline imagePipeline, Object obj, RequestListener requestListener, String str, ImageRequest.RequestLevel requestLevel, Map map, Dimensions dimensions, ImageOptions imageOptions, int i, Object obj2) {
        if ((i & 32) != 0) {
            requestLevel = ImageRequest.RequestLevel.FULL_FETCH;
        }
        return createDataSource(imageRequest, imagePipeline, obj, requestListener, str, requestLevel, map, dimensions, imageOptions);
    }

    @JvmStatic
    public static final DataSource<CloseableReference<CloseableImage>> createDataSource(ImageRequest imageRequest, ImagePipeline imagePipeline, Object callerContext, RequestListener requestListener, String uiComponentId, ImageRequest.RequestLevel requestLevel, Map<String, Object> extras, Dimensions viewport, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(imagePipeline, "imagePipeline");
        Intrinsics.checkNotNullParameter(uiComponentId, "uiComponentId");
        Intrinsics.checkNotNullParameter(requestLevel, "requestLevel");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        if (viewport != null) {
            extras.put("viewport", viewport);
        }
        extras.put("scaletype", imageOptions.getActualImageScaleType());
        if (imageRequest != null) {
            return imagePipeline.fetchDecodedImage(imageRequest, callerContext, requestLevel, requestListener, uiComponentId, extras);
        }
        DataSource<CloseableReference<CloseableImage>> dataSource = NO_REQUEST_SUPPLIER.get();
        Intrinsics.checkNotNull(dataSource);
        return dataSource;
    }

    public final ImageRequest extractSingleRequest(SingleImageSource singleImageSource, ImagePipelineUtils imagePipelineUtils, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(singleImageSource, "<this>");
        Intrinsics.checkNotNullParameter(imagePipelineUtils, "imagePipelineUtils");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        return imagePipelineUtils.buildImageRequest(singleImageSource.getImageUri(), imageOptions);
    }

    public final ImageRequest extractFirstAvailableRequest(FirstAvailableImageSource firstAvailableImageSource, ImagePipelineUtils imagePipelineUtils, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(firstAvailableImageSource, "<this>");
        Intrinsics.checkNotNullParameter(imagePipelineUtils, "imagePipelineUtils");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        for (ImageSource imageSource : firstAvailableImageSource.getImageSources()) {
            ImageRequest imageRequestMaybeExtractFinalImageRequest = maybeExtractFinalImageRequest(imageSource, imagePipelineUtils, imageOptions);
            if (imageRequestMaybeExtractFinalImageRequest != null) {
                return imageRequestMaybeExtractFinalImageRequest;
            }
        }
        return null;
    }
}
