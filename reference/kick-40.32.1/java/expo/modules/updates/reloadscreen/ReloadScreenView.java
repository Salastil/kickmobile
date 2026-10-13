package expo.modules.updates.reloadscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.interfaces.permissions.PermissionsResponse;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ReloadScreenView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fJ\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0013H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lexpo/modules/updates/reloadscreen/ReloadScreenView;", "Landroid/widget/FrameLayout;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "progressBar", "Landroid/widget/ProgressBar;", "imageView", "Landroid/widget/ImageView;", "currentConfiguration", "Lexpo/modules/updates/reloadscreen/ReloadScreenConfiguration;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "updateConfiguration", "", "configuration", "addImageView", "addSpinner", "spinnerConfig", "Lexpo/modules/updates/reloadscreen/SpinnerConfiguration;", "loadImage", "imageSource", "Lexpo/modules/updates/reloadscreen/ReloadScreenImageSource;", "loadImageFromUrl", "uri", "Landroid/net/Uri;", "handleImageLoadFailure", "dpToPx", "dp", "", "onDetachedFromWindow", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReloadScreenView extends FrameLayout {
    private ReloadScreenConfiguration currentConfiguration;
    private ImageView imageView;
    private ProgressBar progressBar;
    private final CoroutineScope scope;

    /* JADX INFO: compiled from: ReloadScreenView.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageResizeMode.values().length];
            try {
                iArr[ImageResizeMode.CONTAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageResizeMode.COVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageResizeMode.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImageResizeMode.STRETCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReloadScreenView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReloadScreenView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReloadScreenView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public /* synthetic */ ReloadScreenView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void updateConfiguration(ReloadScreenConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.currentConfiguration = configuration;
        removeAllViews();
        if (configuration.getImage() != null && configuration.getImageFullScreen()) {
            setBackgroundColor(0);
        } else {
            setBackgroundColor(configuration.getBackgroundColor());
        }
        if (configuration.getImage() != null) {
            addImageView(configuration);
        }
        if (configuration.getSpinner().getEnabled()) {
            addSpinner(configuration.getSpinner());
        }
    }

    private final void addImageView(ReloadScreenConfiguration configuration) {
        ImageView.ScaleType scaleType;
        ReloadScreenImageSource image = configuration.getImage();
        if (image == null) {
            return;
        }
        ImageView imageView = new ImageView(getContext());
        int i = WhenMappings.$EnumSwitchMapping$0[configuration.getImageResizeMode().ordinal()];
        if (i == 1) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        } else if (i == 2) {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        } else if (i == 3) {
            scaleType = ImageView.ScaleType.CENTER;
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            scaleType = ImageView.ScaleType.FIT_XY;
        }
        imageView.setScaleType(scaleType);
        if (!configuration.getImageFullScreen() && image.getWidth() != null && image.getHeight() != null && image.getWidth().doubleValue() > 0.0d && image.getHeight().doubleValue() > 0.0d) {
            Double scale = image.getScale();
            double dDoubleValue = scale != null ? scale.doubleValue() : 1.0d;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx((float) (image.getWidth().doubleValue() * dDoubleValue)), dpToPx((float) (image.getHeight().doubleValue() * dDoubleValue)));
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
        } else {
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        this.imageView = imageView;
        addView(imageView);
        loadImage(image);
    }

    private final void addSpinner(SpinnerConfiguration spinnerConfig) {
        ProgressBar progressBar = new ProgressBar(getContext());
        progressBar.setIndeterminate(true);
        int iDpToPx = dpToPx(spinnerConfig.getSize().getSize());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDpToPx, iDpToPx);
        layoutParams.gravity = 17;
        progressBar.setLayoutParams(layoutParams);
        Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setTint(spinnerConfig.getColor());
        }
        this.progressBar = progressBar;
        addView(progressBar);
    }

    private final void loadImage(ReloadScreenImageSource imageSource) {
        Uri url;
        ImageView imageView = this.imageView;
        if (imageView == null || (url = imageSource.getUrl()) == null) {
            return;
        }
        loadImageFromUrl(url, imageView);
    }

    /* JADX INFO: renamed from: expo.modules.updates.reloadscreen.ReloadScreenView$loadImageFromUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReloadScreenView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.reloadscreen.ReloadScreenView$loadImageFromUrl$1", f = "ReloadScreenView.kt", i = {0, 1}, l = {WebmConstants.MkvEbmlElement.CODEC_ID, 142}, m = "invokeSuspend", n = {"bitmap", "e"}, nl = {139, 146}, s = {"L$0", "L$0"}, v = 2)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ImageView $imageView;
        final /* synthetic */ Uri $uri;
        Object L$0;
        int label;
        final /* synthetic */ ReloadScreenView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Uri uri, ReloadScreenView reloadScreenView, ImageView imageView, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$uri = uri;
            this.this$0 = reloadScreenView;
            this.$imageView = imageView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$uri, this.this$0, this.$imageView, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x00cc  */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00ed, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new expo.modules.updates.reloadscreen.ReloadScreenView.AnonymousClass1.C01601(r13, r12.this$0, r12.$imageView, null), r12) == r1) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0110, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new expo.modules.updates.reloadscreen.ReloadScreenView.AnonymousClass1.AnonymousClass2(r12.this$0, null), r12) == r1) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0112, code lost:
        
            return r1;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 300
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.reloadscreen.ReloadScreenView.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: expo.modules.updates.reloadscreen.ReloadScreenView$loadImageFromUrl$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ReloadScreenView.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "expo.modules.updates.reloadscreen.ReloadScreenView$loadImageFromUrl$1$1", f = "ReloadScreenView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class C01601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Bitmap $bitmap;
            final /* synthetic */ ImageView $imageView;
            int label;
            final /* synthetic */ ReloadScreenView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01601(Bitmap bitmap, ReloadScreenView reloadScreenView, ImageView imageView, Continuation<? super C01601> continuation) {
                super(2, continuation);
                this.$bitmap = bitmap;
                this.this$0 = reloadScreenView;
                this.$imageView = imageView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01601(this.$bitmap, this.this$0, this.$imageView, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Bitmap bitmap = this.$bitmap;
                if (bitmap == null) {
                    this.this$0.handleImageLoadFailure();
                } else {
                    this.$imageView.setImageBitmap(bitmap);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: expo.modules.updates.reloadscreen.ReloadScreenView$loadImageFromUrl$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: ReloadScreenView.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "expo.modules.updates.reloadscreen.ReloadScreenView$loadImageFromUrl$1$2", f = "ReloadScreenView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ReloadScreenView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(ReloadScreenView reloadScreenView, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = reloadScreenView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.handleImageLoadFailure();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void loadImageFromUrl(Uri uri, ImageView imageView) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(uri, this, imageView, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleImageLoadFailure() {
        ImageView imageView = this.imageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ReloadScreenConfiguration reloadScreenConfiguration = this.currentConfiguration;
        if (reloadScreenConfiguration != null) {
            setBackgroundColor(reloadScreenConfiguration.getBackgroundColor());
            addSpinner(SpinnerConfiguration.copy$default(reloadScreenConfiguration.getSpinner(), true, 0, null, 6, null));
        }
    }

    private final int dpToPx(float dp) {
        return (int) (dp * getContext().getResources().getDisplayMetrics().density);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }
}
