package com.facebook.fresco.vito.core.impl;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.closeables.AutoCleanupDelegate;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.fresco.vito.core.CombinedImageListener;
import com.facebook.fresco.vito.core.FrescoDrawableInterface;
import com.facebook.fresco.vito.core.ImagePerfLoggingListener;
import com.facebook.fresco.vito.core.VitoImagePerfListener;
import com.facebook.fresco.vito.core.VitoImageRequest;
import com.facebook.fresco.vito.listener.ImageListener;
import com.facebook.fresco.vito.renderer.DrawableImageDataModel;
import com.facebook.fresco.vito.renderer.ImageDataModel;
import com.facebook.react.uimanager.ViewProps;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: KFrescoVitoDrawable.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BC\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\n\u0010x\u001a\u0004\u0018\u00010yH\u0016J\u0011\u0010\u007f\u001a\u00020Q2\u0007\u0010\u0080\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0084\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010\u0085\u0001\u001a\u00020Q2\u0007\u0010\u0086\u0001\u001a\u00020\u0007H\u0016J\u0014\u0010\u0088\u0001\u001a\u00020Q2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010,H\u0016J\u0016\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0001H\u0016J\u001b\u0010\u0093\u0001\u001a\u00020\u00072\u0007\u0010\u0094\u0001\u001a\u00020\u00072\u0007\u0010\u0095\u0001\u001a\u00020\u0007H\u0016J\u0007\u0010\u0096\u0001\u001a\u00020QJ\u0013\u0010¯\u0001\u001a\u00020Q2\b\u0010°\u0001\u001a\u00030±\u0001H\u0016J\u0012\u0010²\u0001\u001a\u00020Q2\u0007\u0010³\u0001\u001a\u00020<H\u0014J\u0014\u0010´\u0001\u001a\u00020Q2\t\u0010³\u0001\u001a\u0004\u0018\u00010<H\u0002J\u0012\u0010µ\u0001\u001a\u00020Q2\u0007\u0010¶\u0001\u001a\u00020]H\u0016J\u0015\u0010·\u0001\u001a\u00020Q2\n\u0010¸\u0001\u001a\u0005\u0018\u00010\u0098\u0001H\u0016J\t\u0010¹\u0001\u001a\u00020]H\u0016J\u0010\u0010º\u0001\u001a\u00030\u009e\u0001H\u0000¢\u0006\u0003\b»\u0001J\u0012\u0010¼\u0001\u001a\u00020Q2\u0007\u0010½\u0001\u001a\u00020\u0001H\u0016J$\u0010¾\u0001\u001a\u00020Q2\u0007\u0010½\u0001\u001a\u00020\u00012\u0007\u0010¿\u0001\u001a\u00020s2\u0007\u0010À\u0001\u001a\u00020\u000fH\u0016J\u001b\u0010Á\u0001\u001a\u00020Q2\u0007\u0010½\u0001\u001a\u00020\u00012\u0007\u0010¿\u0001\u001a\u00020sH\u0016J\u001b\u0010Â\u0001\u001a\u00020Q2\u0007\u0010Ã\u0001\u001a\u00020]2\u0007\u0010Ä\u0001\u001a\u00020]H\u0016J\t\u0010Å\u0001\u001a\u00020QH\u0016J\u0013\u0010Æ\u0001\u001a\u00020Q2\b\u0010Ç\u0001\u001a\u00030È\u0001H\u0016J\t\u0010É\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010Ê\u0001\u001a\u00020Q2\u0007\u0010\u0094\u0001\u001a\u00020\u0007H\u0016J\t\u0010Ë\u0001\u001a\u00020]H\u0016J\t\u0010Ì\u0001\u001a\u00020]H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001a\u0010(\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R\u0011\u00104\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u00010\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001c\"\u0004\b:\u0010\u001eR\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R?\u0010C\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001a\u0018\u00010B2\u0010\u0010A\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001a\u0018\u00010B8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0011\u0010J\u001a\u00020K¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u000e\u0010N\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010O\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001c\u0010V\u001a\u0004\u0018\u00010WX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001a\u0010\\\u001a\u00020]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010_\"\u0004\bd\u0010aR\u001a\u0010e\u001a\u000e\u0012\u0004\u0012\u00020g\u0012\u0004\u0012\u00020Q0fX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010h\u001a\u0004\u0018\u00010g2\b\u0010A\u001a\u0004\u0018\u00010g8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010o\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010S\"\u0004\bq\u0010UR\u001c\u0010r\u001a\u0004\u0018\u00010sX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0014\u0010z\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b{\u0010\u0011R\u0014\u0010|\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b}\u0010~R\u0019\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0016\u0010\u0087\u0001\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010\u0016R0\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00012\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0012\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0099\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030P¢\u0006\t\n\u0000\u001a\u0005\b\u009a\u0001\u0010SR\u0019\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020Q0P¢\u0006\t\n\u0000\u001a\u0005\b\u009c\u0001\u0010SR\u0015\u0010\u009d\u0001\u001a\u00030\u009e\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0015\u0010¡\u0001\u001a\u00030\u009e\u0001¢\u0006\n\n\u0000\u001a\u0006\b¢\u0001\u0010 \u0001R\"\u0010£\u0001\u001a\u0005\u0018\u00010\u009e\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¤\u0001\u0010 \u0001\"\u0006\b¥\u0001\u0010¦\u0001R\u0015\u0010§\u0001\u001a\u00030\u009e\u0001¢\u0006\n\n\u0000\u001a\u0006\b¨\u0001\u0010 \u0001R\"\u0010©\u0001\u001a\u0005\u0018\u00010\u009e\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bª\u0001\u0010 \u0001\"\u0006\b«\u0001\u0010¦\u0001R\"\u0010¬\u0001\u001a\u0005\u0018\u00010\u009e\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u00ad\u0001\u0010 \u0001\"\u0006\b®\u0001\u0010¦\u0001¨\u0006Í\u0001"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/KFrescoVitoDrawable;", "Landroid/graphics/drawable/Drawable;", "Lcom/facebook/fresco/vito/core/FrescoDrawableInterface;", "Landroid/graphics/drawable/Drawable$Callback;", "_imagePerfListener", "Lcom/facebook/fresco/vito/core/VitoImagePerfListener;", "resetVitoImageRequestListener", "", "resetLocalVitoImageRequestListener", "resetLocalImagePerfStateListener", "resetControllerListener2", "optimizeAlphaHandling", "<init>", "(Lcom/facebook/fresco/vito/core/VitoImagePerfListener;ZZZZZ)V", "_imageId", "", "get_imageId", "()J", "set_imageId", "(J)V", "_isLoading", "get_isLoading", "()Z", "set_isLoading", "(Z)V", "callerContext", "", "getCallerContext", "()Ljava/lang/Object;", "setCallerContext", "(Ljava/lang/Object;)V", "uiFramework", "", "getUiFramework", "()Ljava/lang/String;", "setUiFramework", "(Ljava/lang/String;)V", "forceReloadIfImageAlreadySet", "getForceReloadIfImageAlreadySet", "setForceReloadIfImageAlreadySet", "retriggerListenersIfImageAlreadySet", "getRetriggerListenersIfImageAlreadySet", "setRetriggerListenersIfImageAlreadySet", "_visibilityCallback", "Lcom/facebook/drawee/drawable/VisibilityCallback;", "get_visibilityCallback", "()Lcom/facebook/drawee/drawable/VisibilityCallback;", "set_visibilityCallback", "(Lcom/facebook/drawee/drawable/VisibilityCallback;)V", "_fetchSubmitted", "get_fetchSubmitted", "set_fetchSubmitted", "listenerManager", "Lcom/facebook/fresco/vito/core/CombinedImageListener;", "getListenerManager", "()Lcom/facebook/fresco/vito/core/CombinedImageListener;", "extras", "getExtras", "setExtras", "viewportDimensions", "Landroid/graphics/Rect;", "getViewportDimensions", "()Landroid/graphics/Rect;", "setViewportDimensions", "(Landroid/graphics/Rect;)V", "<set-?>", "Lcom/facebook/datasource/DataSource;", "dataSource", "getDataSource", "()Lcom/facebook/datasource/DataSource;", "setDataSource", "(Lcom/facebook/datasource/DataSource;)V", "dataSource$delegate", "Lcom/facebook/fresco/vito/core/impl/DataSourceCleanupDelegate;", "releaseState", "Lcom/facebook/fresco/vito/core/impl/ImageReleaseScheduler$ImageReleaseState;", "getReleaseState", "()Lcom/facebook/fresco/vito/core/impl/ImageReleaseScheduler$ImageReleaseState;", "hasBoundsSet", "onBoundsChangedCallback", "Lkotlin/Function0;", "", "getOnBoundsChangedCallback", "()Lkotlin/jvm/functions/Function0;", "setOnBoundsChangedCallback", "(Lkotlin/jvm/functions/Function0;)V", "imageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", "getImageRequest", "()Lcom/facebook/fresco/vito/core/VitoImageRequest;", "setImageRequest", "(Lcom/facebook/fresco/vito/core/VitoImageRequest;)V", "_intrinsicWidth", "", "get_intrinsicWidth", "()I", "set_intrinsicWidth", "(I)V", "_intrinsicHeight", "get_intrinsicHeight", "set_intrinsicHeight", "closeableCleanupFunction", "Lkotlin/Function1;", "Ljava/io/Closeable;", "closeable", "getCloseable", "()Ljava/io/Closeable;", "setCloseable", "(Ljava/io/Closeable;)V", "closeable$delegate", "Lcom/facebook/common/closeables/AutoCleanupDelegate;", "offerBackOnRelease", "getOfferBackOnRelease", "setOfferBackOnRelease", "refetchRunnable", "Ljava/lang/Runnable;", "getRefetchRunnable", "()Ljava/lang/Runnable;", "setRefetchRunnable", "(Ljava/lang/Runnable;)V", "getImagePerfLoggingListener", "Lcom/facebook/fresco/vito/core/ImagePerfLoggingListener;", "imageId", "getImageId", "imagePerfListener", "getImagePerfListener", "()Lcom/facebook/fresco/vito/core/VitoImagePerfListener;", "setMutateDrawables", "mutateDrawables", "actualImageDrawable", "getActualImageDrawable", "()Landroid/graphics/drawable/Drawable;", "hasImage", "setFetchSubmitted", "fetchSubmitted", "isFetchSubmitted", "setVisibilityCallback", "visibilityCallback", "value", "Lcom/facebook/fresco/vito/listener/ImageListener;", "imageListener", "getImageListener", "()Lcom/facebook/fresco/vito/listener/ImageListener;", "setImageListener", "(Lcom/facebook/fresco/vito/listener/ImageListener;)V", "setOverlayDrawable", "drawable", "setVisible", ViewProps.VISIBLE, "restart", "reset", "drawableColorFilter", "Landroid/graphics/ColorFilter;", "callbackProvider", "getCallbackProvider", "invalidateLayerCallback", "getInvalidateLayerCallback", "placeholderLayer", "Lcom/facebook/fresco/vito/core/impl/ImageLayerDataModel;", "getPlaceholderLayer", "()Lcom/facebook/fresco/vito/core/impl/ImageLayerDataModel;", "actualImageLayer", "getActualImageLayer", "progressLayer", "getProgressLayer", "setProgressLayer", "(Lcom/facebook/fresco/vito/core/impl/ImageLayerDataModel;)V", "overlayImageLayer", "getOverlayImageLayer", "debugOverlayImageLayer", "getDebugOverlayImageLayer", "setDebugOverlayImageLayer", "backgroundLayer", "getBackgroundLayer", "setBackgroundLayer", "draw", "canvas", "Landroid/graphics/Canvas;", "onBoundsChange", "bounds", "setLayerBounds", "setAlpha", "alpha", "setColorFilter", "colorFilter", "getOpacity", "createLayer", "createLayer$core_impl_release", "invalidateDrawable", "who", "scheduleDrawable", "what", "when", "unscheduleDrawable", "setIntrinsicSize", ViewProps.WIDTH, ViewProps.HEIGHT, "configureWhenUnderlyingChanged", "getActualImageBounds", "outBounds", "Landroid/graphics/RectF;", "hasBitmapWithGainmap", "reportVisible", "getIntrinsicWidth", "getIntrinsicHeight", "core-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KFrescoVitoDrawable extends Drawable implements FrescoDrawableInterface, Drawable.Callback {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(KFrescoVitoDrawable.class, "dataSource", "getDataSource()Lcom/facebook/datasource/DataSource;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(KFrescoVitoDrawable.class, "closeable", "getCloseable()Ljava/io/Closeable;", 0))};
    private boolean _fetchSubmitted;
    private long _imageId;
    private final VitoImagePerfListener _imagePerfListener;
    private int _intrinsicHeight;
    private int _intrinsicWidth;
    private boolean _isLoading;
    private VisibilityCallback _visibilityCallback;
    private final ImageLayerDataModel actualImageLayer;
    private ImageLayerDataModel backgroundLayer;
    private final Function0<Drawable.Callback> callbackProvider;
    private Object callerContext;

    /* JADX INFO: renamed from: closeable$delegate, reason: from kotlin metadata */
    private final AutoCleanupDelegate closeable;
    private final Function1<Closeable, Unit> closeableCleanupFunction;

    /* JADX INFO: renamed from: dataSource$delegate, reason: from kotlin metadata */
    private final DataSourceCleanupDelegate dataSource;
    private ImageLayerDataModel debugOverlayImageLayer;
    private ColorFilter drawableColorFilter;
    private Object extras;
    private boolean forceReloadIfImageAlreadySet;
    private boolean hasBoundsSet;
    private VitoImageRequest imageRequest;
    private final Function0<Unit> invalidateLayerCallback;
    private final CombinedImageListener listenerManager;
    private Function0<Unit> offerBackOnRelease;
    private Function0<Unit> onBoundsChangedCallback;
    private final boolean optimizeAlphaHandling;
    private final ImageLayerDataModel overlayImageLayer;
    private final ImageLayerDataModel placeholderLayer;
    private ImageLayerDataModel progressLayer;
    private Runnable refetchRunnable;
    private final ImageReleaseScheduler.ImageReleaseState releaseState;
    private final boolean resetControllerListener2;
    private final boolean resetLocalImagePerfStateListener;
    private final boolean resetLocalVitoImageRequestListener;
    private final boolean resetVitoImageRequestListener;
    private boolean retriggerListenersIfImageAlreadySet;
    private String uiFramework;
    private Rect viewportDimensions;

    public KFrescoVitoDrawable() {
        this(null, false, false, false, false, false, 63, null);
    }

    static final KFrescoVitoDrawable callbackProvider$lambda$3(KFrescoVitoDrawable kFrescoVitoDrawable) {
        return kFrescoVitoDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setMutateDrawables(boolean mutateDrawables) {
    }

    public /* synthetic */ KFrescoVitoDrawable(NopImagePerfListener nopImagePerfListener, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new NopImagePerfListener() : nopImagePerfListener, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? false : z5);
    }

    public KFrescoVitoDrawable(VitoImagePerfListener _imagePerfListener, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(_imagePerfListener, "_imagePerfListener");
        this._imagePerfListener = _imagePerfListener;
        this.resetVitoImageRequestListener = z;
        this.resetLocalVitoImageRequestListener = z2;
        this.resetLocalImagePerfStateListener = z3;
        this.resetControllerListener2 = z4;
        this.optimizeAlphaHandling = z5;
        this.listenerManager = new CombinedImageListenerImpl();
        this.dataSource = new DataSourceCleanupDelegate();
        this.releaseState = ImageReleaseScheduler.INSTANCE.createReleaseState(this);
        this._intrinsicWidth = -1;
        this._intrinsicHeight = -1;
        Function1<Closeable, Unit> function1 = new Function1() { // from class: com.facebook.fresco.vito.core.impl.KFrescoVitoDrawable$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KFrescoVitoDrawable.closeableCleanupFunction$lambda$0(this.f$0, (Closeable) obj);
            }
        };
        this.closeableCleanupFunction = function1;
        this.closeable = new AutoCleanupDelegate(null, function1);
        this.callbackProvider = new Function0() { // from class: com.facebook.fresco.vito.core.impl.KFrescoVitoDrawable$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return KFrescoVitoDrawable.callbackProvider$lambda$3(this.f$0);
            }
        };
        this.invalidateLayerCallback = new Function0() { // from class: com.facebook.fresco.vito.core.impl.KFrescoVitoDrawable$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return KFrescoVitoDrawable.invalidateLayerCallback$lambda$4(this.f$0);
            }
        };
        this.placeholderLayer = createLayer$core_impl_release();
        this.actualImageLayer = createLayer$core_impl_release();
        this.overlayImageLayer = createLayer$core_impl_release();
    }

    public final long get_imageId() {
        return this._imageId;
    }

    public final void set_imageId(long j) {
        this._imageId = j;
    }

    public final boolean get_isLoading() {
        return this._isLoading;
    }

    public final void set_isLoading(boolean z) {
        this._isLoading = z;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public Object getCallerContext() {
        return this.callerContext;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setCallerContext(Object obj) {
        this.callerContext = obj;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public String getUiFramework() {
        return this.uiFramework;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setUiFramework(String str) {
        this.uiFramework = str;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public boolean getForceReloadIfImageAlreadySet() {
        return this.forceReloadIfImageAlreadySet;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setForceReloadIfImageAlreadySet(boolean z) {
        this.forceReloadIfImageAlreadySet = z;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public boolean getRetriggerListenersIfImageAlreadySet() {
        return this.retriggerListenersIfImageAlreadySet;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setRetriggerListenersIfImageAlreadySet(boolean z) {
        this.retriggerListenersIfImageAlreadySet = z;
    }

    public final VisibilityCallback get_visibilityCallback() {
        return this._visibilityCallback;
    }

    public final void set_visibilityCallback(VisibilityCallback visibilityCallback) {
        this._visibilityCallback = visibilityCallback;
    }

    public final boolean get_fetchSubmitted() {
        return this._fetchSubmitted;
    }

    public final void set_fetchSubmitted(boolean z) {
        this._fetchSubmitted = z;
    }

    public final CombinedImageListener getListenerManager() {
        return this.listenerManager;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public Object getExtras() {
        return this.extras;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setExtras(Object obj) {
        this.extras = obj;
    }

    public final Rect getViewportDimensions() {
        return this.viewportDimensions;
    }

    public final void setViewportDimensions(Rect rect) {
        this.viewportDimensions = rect;
    }

    public final DataSource<? extends Object> getDataSource() {
        return this.dataSource.getValue(this, $$delegatedProperties[0]);
    }

    public final void setDataSource(DataSource<? extends Object> dataSource) {
        this.dataSource.setValue(this, $$delegatedProperties[0], dataSource);
    }

    public final ImageReleaseScheduler.ImageReleaseState getReleaseState() {
        return this.releaseState;
    }

    public final Function0<Unit> getOnBoundsChangedCallback() {
        return this.onBoundsChangedCallback;
    }

    public final void setOnBoundsChangedCallback(Function0<Unit> function0) {
        this.onBoundsChangedCallback = function0;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public VitoImageRequest getImageRequest() {
        return this.imageRequest;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setImageRequest(VitoImageRequest vitoImageRequest) {
        this.imageRequest = vitoImageRequest;
    }

    public final int get_intrinsicWidth() {
        return this._intrinsicWidth;
    }

    public final void set_intrinsicWidth(int i) {
        this._intrinsicWidth = i;
    }

    public final int get_intrinsicHeight() {
        return this._intrinsicHeight;
    }

    public final void set_intrinsicHeight(int i) {
        this._intrinsicHeight = i;
    }

    static final Unit closeableCleanupFunction$lambda$0(KFrescoVitoDrawable kFrescoVitoDrawable, Closeable resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        ImageReleaseScheduler.INSTANCE.cancelAllReleasing(kFrescoVitoDrawable);
        try {
            resource.close();
        } catch (IOException unused) {
        }
        return Unit.INSTANCE;
    }

    public final Closeable getCloseable() {
        return (Closeable) this.closeable.getValue(this, $$delegatedProperties[1]);
    }

    public final void setCloseable(Closeable closeable) {
        this.closeable.setValue(this, $$delegatedProperties[1], closeable);
    }

    public final Function0<Unit> getOfferBackOnRelease() {
        return this.offerBackOnRelease;
    }

    public final void setOfferBackOnRelease(Function0<Unit> function0) {
        this.offerBackOnRelease = function0;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public Runnable getRefetchRunnable() {
        return this.refetchRunnable;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setRefetchRunnable(Runnable runnable) {
        this.refetchRunnable = runnable;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public ImagePerfLoggingListener getImagePerfLoggingListener() {
        return this.listenerManager.getImagePerfLoggingListener();
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    /* JADX INFO: renamed from: getImageId, reason: from getter */
    public long get_imageId() {
        return this._imageId;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    /* JADX INFO: renamed from: getImagePerfListener, reason: from getter */
    public VitoImagePerfListener get_imagePerfListener() {
        return this._imagePerfListener;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public Drawable getActualImageDrawable() {
        ImageDataModel dataModel = this.actualImageLayer.getDataModel();
        DrawableImageDataModel drawableImageDataModel = dataModel instanceof DrawableImageDataModel ? (DrawableImageDataModel) dataModel : null;
        if (drawableImageDataModel != null) {
            return drawableImageDataModel.getDrawable();
        }
        return null;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public boolean hasImage() {
        return this.actualImageLayer.getDataModel() != null;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setFetchSubmitted(boolean fetchSubmitted) {
        this._fetchSubmitted = fetchSubmitted;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public boolean isFetchSubmitted() {
        return this._fetchSubmitted;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setVisibilityCallback(VisibilityCallback visibilityCallback) {
        this._visibilityCallback = visibilityCallback;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public ImageListener getImageListener() {
        return this.listenerManager.getImageListener();
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setImageListener(ImageListener imageListener) {
        this.listenerManager.setImageListener(imageListener);
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public Drawable setOverlayDrawable(Drawable drawable) {
        ImageLayerDataModel.configure$default(this.overlayImageLayer, drawable != null ? new DrawableImageDataModel(drawable, false, 2, null) : null, null, null, null, null, null, 56, null);
        return drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        VisibilityCallback visibilityCallback = this._visibilityCallback;
        if (visibilityCallback != null) {
            visibilityCallback.onVisibilityChange(visible);
        }
        return super.setVisible(visible, restart);
    }

    public final void reset() {
        KFrescoVitoDrawable kFrescoVitoDrawable;
        Function0<Unit> function0 = this.offerBackOnRelease;
        if (function0 != null) {
            function0.invoke();
        }
        this.offerBackOnRelease = null;
        VitoImageRequest imageRequest = getImageRequest();
        if (imageRequest != null) {
            kFrescoVitoDrawable = this;
            this.listenerManager.onRelease(get_imageId(), imageRequest, ExtrasUtilsKt.obtainExtras$default(kFrescoVitoDrawable, null, null, null, 7, null));
        } else {
            kFrescoVitoDrawable = this;
        }
        kFrescoVitoDrawable.get_imagePerfListener().onImageRelease(kFrescoVitoDrawable);
        ImageReleaseScheduler.INSTANCE.cancelAllReleasing(kFrescoVitoDrawable);
        kFrescoVitoDrawable._imageId = 0L;
        kFrescoVitoDrawable.setCloseable(null);
        kFrescoVitoDrawable.setDataSource(null);
        kFrescoVitoDrawable.setImageRequest(null);
        kFrescoVitoDrawable._isLoading = false;
        kFrescoVitoDrawable.setCallerContext(null);
        kFrescoVitoDrawable._intrinsicWidth = -1;
        kFrescoVitoDrawable._intrinsicHeight = -1;
        kFrescoVitoDrawable.setForceReloadIfImageAlreadySet(false);
        kFrescoVitoDrawable.setRetriggerListenersIfImageAlreadySet(false);
        ImageLayerDataModel.reset$default(kFrescoVitoDrawable.placeholderLayer, false, 1, null);
        ImageLayerDataModel.reset$default(kFrescoVitoDrawable.actualImageLayer, false, 1, null);
        ImageLayerDataModel imageLayerDataModel = kFrescoVitoDrawable.progressLayer;
        if (imageLayerDataModel != null) {
            ImageLayerDataModel.reset$default(imageLayerDataModel, false, 1, null);
        }
        ImageLayerDataModel.reset$default(kFrescoVitoDrawable.overlayImageLayer, false, 1, null);
        ImageLayerDataModel imageLayerDataModel2 = kFrescoVitoDrawable.debugOverlayImageLayer;
        if (imageLayerDataModel2 != null) {
            ImageLayerDataModel.reset$default(imageLayerDataModel2, false, 1, null);
        }
        ImageLayerDataModel imageLayerDataModel3 = kFrescoVitoDrawable.backgroundLayer;
        if (imageLayerDataModel3 != null) {
            ImageLayerDataModel.reset$default(imageLayerDataModel3, false, 1, null);
        }
        kFrescoVitoDrawable.hasBoundsSet = false;
        kFrescoVitoDrawable.onBoundsChangedCallback = null;
        kFrescoVitoDrawable.listenerManager.onReset(kFrescoVitoDrawable.resetVitoImageRequestListener, kFrescoVitoDrawable.resetLocalVitoImageRequestListener, kFrescoVitoDrawable.resetLocalImagePerfStateListener, kFrescoVitoDrawable.resetControllerListener2);
    }

    public final Function0<Drawable.Callback> getCallbackProvider() {
        return this.callbackProvider;
    }

    static final Unit invalidateLayerCallback$lambda$4(KFrescoVitoDrawable kFrescoVitoDrawable) {
        kFrescoVitoDrawable.invalidateSelf();
        return Unit.INSTANCE;
    }

    public final Function0<Unit> getInvalidateLayerCallback() {
        return this.invalidateLayerCallback;
    }

    public final ImageLayerDataModel getPlaceholderLayer() {
        return this.placeholderLayer;
    }

    public final ImageLayerDataModel getActualImageLayer() {
        return this.actualImageLayer;
    }

    public final ImageLayerDataModel getProgressLayer() {
        return this.progressLayer;
    }

    public final void setProgressLayer(ImageLayerDataModel imageLayerDataModel) {
        this.progressLayer = imageLayerDataModel;
    }

    public final ImageLayerDataModel getOverlayImageLayer() {
        return this.overlayImageLayer;
    }

    public final ImageLayerDataModel getDebugOverlayImageLayer() {
        return this.debugOverlayImageLayer;
    }

    public final void setDebugOverlayImageLayer(ImageLayerDataModel imageLayerDataModel) {
        this.debugOverlayImageLayer = imageLayerDataModel;
    }

    public final ImageLayerDataModel getBackgroundLayer() {
        return this.backgroundLayer;
    }

    public final void setBackgroundLayer(ImageLayerDataModel imageLayerDataModel) {
        this.backgroundLayer = imageLayerDataModel;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!this.hasBoundsSet) {
            setLayerBounds(getBounds());
        }
        ImageLayerDataModel imageLayerDataModel = this.backgroundLayer;
        if (imageLayerDataModel != null) {
            imageLayerDataModel.draw(canvas);
        }
        this.placeholderLayer.draw(canvas);
        this.actualImageLayer.draw(canvas);
        ImageLayerDataModel imageLayerDataModel2 = this.progressLayer;
        if (imageLayerDataModel2 != null) {
            imageLayerDataModel2.draw(canvas);
        }
        this.overlayImageLayer.draw(canvas);
        ImageLayerDataModel imageLayerDataModel3 = this.debugOverlayImageLayer;
        if (imageLayerDataModel3 != null) {
            imageLayerDataModel3.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        setLayerBounds(bounds);
        Function0<Unit> function0 = this.onBoundsChangedCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void setLayerBounds(Rect bounds) {
        if (bounds != null) {
            ImageLayerDataModel.configure$default(this.placeholderLayer, null, null, null, null, bounds, null, 47, null);
            ImageLayerDataModel.configure$default(this.actualImageLayer, null, null, null, null, bounds, null, 47, null);
            ImageLayerDataModel imageLayerDataModel = this.progressLayer;
            if (imageLayerDataModel != null) {
                ImageLayerDataModel.configure$default(imageLayerDataModel, null, null, null, null, bounds, null, 47, null);
            }
            ImageLayerDataModel.configure$default(this.overlayImageLayer, null, null, null, null, bounds, null, 47, null);
            ImageLayerDataModel imageLayerDataModel2 = this.debugOverlayImageLayer;
            if (imageLayerDataModel2 != null) {
                ImageLayerDataModel.configure$default(imageLayerDataModel2, null, null, null, null, bounds, null, 47, null);
            }
            ImageLayerDataModel imageLayerDataModel3 = this.backgroundLayer;
            if (imageLayerDataModel3 != null) {
                ImageLayerDataModel.configure$default(imageLayerDataModel3, null, null, null, null, bounds, null, 47, null);
            }
            this.hasBoundsSet = true;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.placeholderLayer.setAlpha(alpha);
        this.actualImageLayer.setAlpha(alpha);
        ImageLayerDataModel imageLayerDataModel = this.progressLayer;
        if (imageLayerDataModel != null) {
            imageLayerDataModel.setAlpha(alpha);
        }
        this.overlayImageLayer.setAlpha(alpha);
        ImageLayerDataModel imageLayerDataModel2 = this.debugOverlayImageLayer;
        if (imageLayerDataModel2 != null) {
            imageLayerDataModel2.setAlpha(alpha);
        }
        ImageLayerDataModel imageLayerDataModel3 = this.backgroundLayer;
        if (imageLayerDataModel3 != null) {
            imageLayerDataModel3.setAlpha(alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.drawableColorFilter = colorFilter;
    }

    public final ImageLayerDataModel createLayer$core_impl_release() {
        return new ImageLayerDataModel(this.callbackProvider, this.invalidateLayerCallback, this.optimizeAlphaHandling);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        scheduleSelf(what, when);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable who, Runnable what) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        unscheduleSelf(what);
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void setIntrinsicSize(int width, int height) {
        this._intrinsicWidth = width;
        this._intrinsicHeight = height;
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void configureWhenUnderlyingChanged() {
        ImageLayerDataModel.configure$default(this.actualImageLayer, null, null, null, null, null, null, 63, null);
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public void getActualImageBounds(RectF outBounds) {
        Intrinsics.checkNotNullParameter(outBounds, "outBounds");
        throw new UnsupportedOperationException("Not implemented for KVito");
    }

    @Override // com.facebook.fresco.vito.core.FrescoDrawableInterface
    public boolean hasBitmapWithGainmap() {
        return this.actualImageLayer.hasBitmapWithGainmap();
    }

    @Override // com.facebook.fresco.ui.common.VisibilityAware
    public void reportVisible(boolean visible) {
        ImagePerfLoggingListener imagePerfLoggingListener = getImagePerfLoggingListener();
        if (imagePerfLoggingListener != null) {
            imagePerfLoggingListener.reportVisible(visible);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = this._intrinsicWidth;
        return i != -1 ? i : super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = this._intrinsicHeight;
        return i != -1 ? i : super.getIntrinsicHeight();
    }
}
