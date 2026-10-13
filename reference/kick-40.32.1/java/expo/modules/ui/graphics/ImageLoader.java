package expo.modules.ui.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.util.LruCache;
import android.util.Xml;
import androidx.collection.SieveCacheKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.compose.ui.unit.Dp;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.util.UriUtil;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.kotlin.okhttp.OkHttpCoroutinesExtensionsKt;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.bouncycastle.asn1.eac.EACTags;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: ImageLoader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\t\b\u0007\u0018\u0000 12\u00020\u0001:\u000201B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001b\u001a\u00020\u0017J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!J\u0012\u0010\"\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010#\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0002J\u0017\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000eH\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u000eH\u0002¢\u0006\u0004\b.\u0010/R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u00062"}, d2 = {"Lexpo/modules/ui/graphics/ImageLoader;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "okHttpClient", "Lokhttp3/OkHttpClient;", "<init>", "(Landroid/content/Context;Lokhttp3/OkHttpClient;)V", "imageCache", "expo/modules/ui/graphics/ImageLoader$imageCache$1", "Lexpo/modules/ui/graphics/ImageLoader$imageCache$1;", "loadFromUri", "Lexpo/modules/ui/graphics/ImageLoader$ImageResult;", "uriString", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "loadUncached", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFromHttp", "", ImagesContract.URL, "loadFromResourceId", "parseImageFromBytes", "bytes", "isXmlContent", "", "parseXmlToImageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseVectorElement", "parsePathElement", "builder", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "parseDimension", "Landroidx/compose/ui/unit/Dp;", "value", "parseDimension-u2uoSUM", "(Ljava/lang/String;)F", "parseColor", "Landroidx/compose/ui/graphics/Color;", "colorValue", "parseColor-vNxB06k", "(Ljava/lang/String;)J", "ImageResult", "Companion", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageLoader {
    private static final String TAG = "ImageLoader";
    private final Context context;
    private final ImageLoader$imageCache$1 imageCache;
    private final OkHttpClient okHttpClient;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: expo.modules.ui.graphics.ImageLoader$downloadFromHttp$1, reason: invalid class name */
    /* JADX INFO: compiled from: ImageLoader.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ui.graphics.ImageLoader", f = "ImageLoader.kt", i = {0, 0}, l = {WebmConstants.MkvEbmlElement.CODEC_ID}, m = "downloadFromHttp", n = {ImagesContract.URL, "request"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImageLoader.this.downloadFromHttp(null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.ui.graphics.ImageLoader$loadUncached$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ImageLoader.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ui.graphics.ImageLoader", f = "ImageLoader.kt", i = {0}, l = {112}, m = "loadUncached", n = {"uri"}, s = {"L$0"})
    static final class C09271 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09271(Continuation<? super C09271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImageLoader.this.loadUncached(null, this);
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [expo.modules.ui.graphics.ImageLoader$imageCache$1] */
    public ImageLoader(Context context, OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        this.context = context;
        this.okHttpClient = okHttpClient;
        final int iMemoryCacheSizeKilobytes = INSTANCE.memoryCacheSizeKilobytes();
        this.imageCache = new LruCache<String, ImageResult>(iMemoryCacheSizeKilobytes) { // from class: expo.modules.ui.graphics.ImageLoader$imageCache$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String key, ImageLoader.ImageResult value) {
                Bitmap bitmap;
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                Drawable drawable = value.getDrawable();
                BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
                if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) {
                    return 1;
                }
                return RangesKt.coerceAtLeast(bitmap.getAllocationByteCount() / 1024, 1);
            }
        };
    }

    /* JADX INFO: compiled from: ImageLoader.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u001c"}, d2 = {"Lexpo/modules/ui/graphics/ImageLoader$ImageResult;", "", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "drawable", "Landroid/graphics/drawable/Drawable;", "error", "", "<init>", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V", "getImageVector", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getError", "()Ljava/lang/String;", "isSuccess", "", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ImageResult {
        public static final int $stable = 8;
        private final Drawable drawable;
        private final String error;
        private final ImageVector imageVector;

        public ImageResult() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ ImageResult copy$default(ImageResult imageResult, ImageVector imageVector, Drawable drawable, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                imageVector = imageResult.imageVector;
            }
            if ((i & 2) != 0) {
                drawable = imageResult.drawable;
            }
            if ((i & 4) != 0) {
                str = imageResult.error;
            }
            return imageResult.copy(imageVector, drawable, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ImageVector getImageVector() {
            return this.imageVector;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Drawable getDrawable() {
            return this.drawable;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getError() {
            return this.error;
        }

        public final ImageResult copy(ImageVector imageVector, Drawable drawable, String error) {
            return new ImageResult(imageVector, drawable, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageResult)) {
                return false;
            }
            ImageResult imageResult = (ImageResult) other;
            return Intrinsics.areEqual(this.imageVector, imageResult.imageVector) && Intrinsics.areEqual(this.drawable, imageResult.drawable) && Intrinsics.areEqual(this.error, imageResult.error);
        }

        public int hashCode() {
            ImageVector imageVector = this.imageVector;
            int iHashCode = (imageVector == null ? 0 : imageVector.hashCode()) * 31;
            Drawable drawable = this.drawable;
            int iHashCode2 = (iHashCode + (drawable == null ? 0 : drawable.hashCode())) * 31;
            String str = this.error;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "ImageResult(imageVector=" + this.imageVector + ", drawable=" + this.drawable + ", error=" + this.error + ")";
        }

        public ImageResult(ImageVector imageVector, Drawable drawable, String str) {
            this.imageVector = imageVector;
            this.drawable = drawable;
            this.error = str;
        }

        public /* synthetic */ ImageResult(ImageVector imageVector, Drawable drawable, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : imageVector, (i & 2) != 0 ? null : drawable, (i & 4) != 0 ? null : str);
        }

        public final ImageVector getImageVector() {
            return this.imageVector;
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }

        public final String getError() {
            return this.error;
        }

        public final boolean isSuccess() {
            return (this.imageVector == null && this.drawable == null) ? false : true;
        }
    }

    /* JADX INFO: renamed from: expo.modules.ui.graphics.ImageLoader$loadFromUri$2, reason: invalid class name */
    /* JADX INFO: compiled from: ImageLoader.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lexpo/modules/ui/graphics/ImageLoader$ImageResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ui.graphics.ImageLoader$loadFromUri$2", f = "ImageLoader.kt", i = {0}, l = {EACTags.ANSWER_TO_RESET}, m = "invokeSuspend", n = {"uri"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {
        final /* synthetic */ String $uriString;
        Object L$0;
        int label;
        final /* synthetic */ ImageLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, ImageLoader imageLoader, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$uriString = str;
            this.this$0 = imageLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$uriString, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = this.$uriString;
                if (str == null || str.length() == 0) {
                    return new ImageResult(null, null, "Image URI is empty", 3, null);
                }
                try {
                    Uri uri = Uri.parse(this.$uriString);
                    ImageResult imageResult = get(this.$uriString);
                    if (imageResult != null) {
                        return imageResult;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(uri);
                    this.label = 1;
                    obj = this.this$0.loadUncached(uri, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Exception e) {
                    Log.e("ImageLoader", "Failed to parse URI: " + this.$uriString, e);
                    return new ImageResult(null, null, "Failed to parse image URI: " + this.$uriString, 3, null);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ImageLoader imageLoader = this.this$0;
            String str2 = this.$uriString;
            ImageResult imageResult2 = (ImageResult) obj;
            if (imageResult2.isSuccess()) {
                imageLoader.imageCache.put(str2, imageResult2);
            }
            return obj;
        }
    }

    public final Object loadFromUri(String str, Continuation<? super ImageResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, this, null), continuation);
    }

    public final void close() {
        evictAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x0090 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x00d4 A[Catch: Exception -> 0x011d, CancellationException -> 0x0145, TRY_LEAVE, TryCatch #4 {CancellationException -> 0x0145, Exception -> 0x011d, blocks: (B:12:0x0030, B:38:0x0091, B:58:0x00e4, B:17:0x003f, B:19:0x004b, B:21:0x0050, B:23:0x0056, B:24:0x005a, B:26:0x005f, B:50:0x00c8, B:52:0x00d4, B:55:0x00de, B:64:0x00ed, B:65:0x00f0, B:66:0x00f1, B:67:0x0102, B:29:0x0069, B:35:0x007d, B:32:0x0073, B:39:0x0094, B:42:0x009d, B:44:0x00a3, B:45:0x00ad, B:46:0x00be, B:47:0x00bf, B:68:0x0103, B:71:0x010d, B:72:0x011c, B:53:0x00d6, B:62:0x00eb), top: B:86:0x0028, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Object loadUncached(Uri uri, Continuation<? super ImageResult> continuation) {
        C09271 c09271;
        byte[] bytes;
        InputStream inputStreamOpenInputStream;
        InputStream inputStream;
        byte[] bytes2;
        if (continuation instanceof C09271) {
            c09271 = (C09271) continuation;
            if ((c09271.label & Integer.MIN_VALUE) != 0) {
                c09271.label -= Integer.MIN_VALUE;
            } else {
                c09271 = new C09271(continuation);
            }
        } else {
            c09271 = new C09271(continuation);
        }
        Object objDownloadFromHttp = c09271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09271.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objDownloadFromHttp);
                if (Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_RESOURCE_SCHEME)) {
                    return loadFromResourceId(uri);
                }
                String scheme = uri.getScheme();
                if (scheme != null) {
                    switch (scheme.hashCode()) {
                        case -368816979:
                            if (!scheme.equals(UriUtil.QUALIFIED_RESOURCE_SCHEME)) {
                                break;
                            }
                            inputStreamOpenInputStream = this.context.getContentResolver().openInputStream(uri);
                            if (inputStreamOpenInputStream != null) {
                                inputStream = inputStreamOpenInputStream;
                                try {
                                    bytes2 = ByteStreamsKt.readBytes(inputStream);
                                    CloseableKt.closeFinally(inputStream, null);
                                    if (bytes2 != null) {
                                        bytes = bytes2;
                                        return parseImageFromBytes(bytes);
                                    }
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        CloseableKt.closeFinally(inputStream, th);
                                        throw th2;
                                    }
                                }
                            }
                            throw new IOException("Unable to open image URI: " + uri);
                        case 3143036:
                            if (scheme.equals("file")) {
                                String path = uri.getPath();
                                if (path == null) {
                                    throw new IOException("Image file URI has no path: " + uri);
                                }
                                bytes = FilesKt.readBytes(new File(path));
                                return parseImageFromBytes(bytes);
                            }
                            break;
                        case 3213448:
                            if (!scheme.equals("http")) {
                            }
                            String string = uri.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                            c09271.L$0 = uri;
                            c09271.label = 1;
                            objDownloadFromHttp = downloadFromHttp(string, c09271);
                            if (objDownloadFromHttp == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 99617003:
                            if (!scheme.equals("https")) {
                            }
                            String string2 = uri.toString();
                            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                            c09271.L$0 = uri;
                            c09271.label = 1;
                            objDownloadFromHttp = downloadFromHttp(string2, c09271);
                            if (objDownloadFromHttp == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 951530617:
                            if (!scheme.equals("content")) {
                                break;
                            }
                            inputStreamOpenInputStream = this.context.getContentResolver().openInputStream(uri);
                            if (inputStreamOpenInputStream != null) {
                                inputStream = inputStreamOpenInputStream;
                                bytes2 = ByteStreamsKt.readBytes(inputStream);
                                CloseableKt.closeFinally(inputStream, null);
                                if (bytes2 != null) {
                                    bytes = bytes2;
                                    return parseImageFromBytes(bytes);
                                }
                            }
                            throw new IOException("Unable to open image URI: " + uri);
                        default:
                            break;
                    }
                }
                String scheme2 = uri.getScheme();
                if (scheme2 == null) {
                    scheme2 = "none";
                }
                throw new IOException("Unsupported image URI scheme: " + scheme2);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objDownloadFromHttp);
            bytes = (byte[]) objDownloadFromHttp;
            return parseImageFromBytes(bytes);
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "Failed to load image from URI: " + uri;
            }
            String str = message;
            Log.e("ImageLoader", str, e2);
            return new ImageResult(null, null, str, 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object downloadFromHttp(String str, Continuation<? super byte[]> continuation) {
        AnonymousClass1 anonymousClass1;
        byte[] bArrBytes;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAwait = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            Request requestBuild = new Request.Builder().url(str).build();
            Call callNewCall = this.okHttpClient.newCall(requestBuild);
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(requestBuild);
            anonymousClass1.label = 1;
            objAwait = OkHttpCoroutinesExtensionsKt.await(callNewCall, anonymousClass1);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objAwait);
        }
        Closeable closeable = (Closeable) objAwait;
        try {
            Response response = (Response) closeable;
            if (!response.isSuccessful()) {
                throw new IOException("Failed to download image from " + str + ": HTTP " + response.code());
            }
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody != null && (bArrBytes = responseBodyBody.bytes()) != null) {
                CloseableKt.closeFinally(closeable, null);
                return bArrBytes;
            }
            throw new IOException("Image response from " + str + " has no body");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(closeable, th);
                throw th2;
            }
        }
    }

    private final ImageResult loadFromResourceId(Uri uri) {
        Integer num;
        String strTrimStart;
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null || (intOrNull = StringsKt.toIntOrNull(lastPathSegment)) == null) {
            String path = uri.getPath();
            if (path == null || (strTrimStart = StringsKt.trimStart(path, '/')) == null) {
                num = null;
            } else {
                Integer intOrNull = StringsKt.toIntOrNull(strTrimStart);
                num = intOrNull;
            }
        } else {
            num = intOrNull;
        }
        if (num == null || num.intValue() <= 0) {
            Log.w("ImageLoader", "Invalid resource ID in URI: " + uri);
            return new ImageResult(null, null, "Invalid image resource ID: " + uri, 3, null);
        }
        try {
            XmlResourceParser xml = this.context.getResources().getXml(num.intValue());
            Intrinsics.checkNotNullExpressionValue(xml, "getXml(...)");
            XmlResourceParser xmlResourceParser = xml;
            try {
                ImageVector xmlToImageVector = parseXmlToImageVector(xmlResourceParser);
                if (xmlToImageVector != null) {
                    ImageResult imageResult = new ImageResult(xmlToImageVector, null, null, 6, null);
                    AutoCloseableKt.closeFinally(xmlResourceParser, null);
                    return imageResult;
                }
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(xmlResourceParser, null);
                try {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.context.getResources(), num.intValue());
                    if (bitmapDecodeResource == null) {
                        return new ImageResult(null, null, "Failed to decode image resource " + num, 3, null);
                    }
                    Resources resources = this.context.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                    return new ImageResult(null, new BitmapDrawable(resources, bitmapDecodeResource), null, 5, null);
                } catch (Exception e) {
                    Log.e("ImageLoader", "Failed to load resource " + num, e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = "Failed to load image resource " + num;
                    }
                    return new ImageResult(null, null, message, 3, null);
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(xmlResourceParser, th);
                    throw th2;
                }
            }
        } catch (Exception e2) {
            Log.d("ImageLoader", "Resource " + num + " is not XML, trying as raw resource", e2);
        }
    }

    private final ImageResult parseImageFromBytes(byte[] bytes) {
        if (isXmlContent(bytes)) {
            ImageVector xmlToImageVector = parseXmlToImageVector(bytes);
            if (xmlToImageVector != null) {
                return new ImageResult(xmlToImageVector, null, null, 6, null);
            }
            return new ImageResult(null, null, "Failed to decode XML image", 3, null);
        }
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        if (bitmapDecodeByteArray == null) {
            return new ImageResult(null, null, "Failed to decode bitmap image", 3, null);
        }
        Resources resources = this.context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return new ImageResult(null, new BitmapDrawable(resources, bitmapDecodeByteArray), null, 5, null);
    }

    private final boolean isXmlContent(byte[] bytes) {
        if (bytes.length < 5) {
            return false;
        }
        int i = (bytes[0] == -17 && bytes[1] == -69 && bytes[2] == -65) ? 3 : 0;
        int iMin = Math.min(i + 10, bytes.length);
        while (i < iMin) {
            byte b = bytes[i];
            if (b == 60) {
                return true;
            }
            if (b != 32 && b != 9 && b != 10 && b != 13) {
                return false;
            }
            i++;
        }
        return false;
    }

    public final ImageVector parseXmlToImageVector(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        try {
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bytes), "UTF-8");
            Intrinsics.checkNotNull(xmlPullParserNewPullParser);
            return parseXmlToImageVector(xmlPullParserNewPullParser);
        } catch (Exception e) {
            Log.e("ImageLoader", "Failed to parse XML to ImageVector", e);
            return null;
        }
    }

    public final ImageVector parseXmlToImageVector(XmlPullParser parser) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        try {
            int eventType = parser.getEventType();
            while (eventType != 1) {
                if (eventType == 2 && Intrinsics.areEqual(parser.getName(), "vector")) {
                    return parseVectorElement(parser);
                }
                eventType = parser.next();
            }
            Log.w("ImageLoader", "No <vector> element found in XML");
            return null;
        } catch (Exception e) {
            Log.e("ImageLoader", "Failed to parse XML to ImageVector", e);
            return null;
        }
    }

    private final void parsePathElement(XmlPullParser parser, ImageVector.Builder builder) {
        int iM7634getEvenOddRgk1Os;
        try {
            String attributeValue = "";
            int iM7635getNonZeroRgk1Os = PathFillType.INSTANCE.m7635getNonZeroRgk1Os();
            int attributeCount = parser.getAttributeCount();
            int i = iM7635getNonZeroRgk1Os;
            Color colorM7328boximpl = null;
            for (int i2 = 0; i2 < attributeCount; i2++) {
                String attributeName = parser.getAttributeName(i2);
                if (attributeName != null) {
                    int iHashCode = attributeName.hashCode();
                    if (iHashCode != -1141881952) {
                        if (iHashCode != -729055395) {
                            if (iHashCode == 1233923439 && attributeName.equals("pathData")) {
                                attributeValue = parser.getAttributeValue(i2);
                                Intrinsics.checkNotNullExpressionValue(attributeValue, "getAttributeValue(...)");
                            }
                        } else if (attributeName.equals("fillType")) {
                            String attributeValue2 = parser.getAttributeValue(i2);
                            if (Intrinsics.areEqual(attributeValue2, "evenOdd") || Intrinsics.areEqual(attributeValue2, "1")) {
                                iM7634getEvenOddRgk1Os = PathFillType.INSTANCE.m7634getEvenOddRgk1Os();
                            } else {
                                iM7634getEvenOddRgk1Os = PathFillType.INSTANCE.m7635getNonZeroRgk1Os();
                            }
                            i = iM7634getEvenOddRgk1Os;
                        }
                    } else if (attributeName.equals("fillColor")) {
                        String attributeValue3 = parser.getAttributeValue(i2);
                        Intrinsics.checkNotNullExpressionValue(attributeValue3, "getAttributeValue(...)");
                        colorM7328boximpl = Color.m7328boximpl(m12134parseColorvNxB06k(attributeValue3));
                    }
                }
            }
            if (attributeValue.length() > 0) {
                ImageVector.Builder.m8069addPathoIyEayM$default(builder, new PathParser().parsePathString(attributeValue).toNodes(), i, null, colorM7328boximpl != null ? new SolidColor(colorM7328boximpl.m7348unboximpl(), null) : null, 0.0f, null, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 16372, null);
            }
        } catch (Exception e) {
            Log.e("ImageLoader", "Failed to parse <path> element", e);
        }
    }

    /* JADX INFO: renamed from: parseDimension-u2uoSUM, reason: not valid java name */
    private final float m12135parseDimensionu2uoSUM(String value) {
        try {
            return Dp.m10168constructorimpl(Float.parseFloat(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(value, "dp", "", false, 4, (Object) null), "dip", "", false, 4, (Object) null), "px", "", false, 4, (Object) null)));
        } catch (Exception unused) {
            Log.w("ImageLoader", "Failed to parse dimension: " + value + ", using default 24dp");
            return Dp.m10168constructorimpl(24.0f);
        }
    }

    /* JADX INFO: renamed from: parseColor-vNxB06k, reason: not valid java name */
    private final long m12134parseColorvNxB06k(String colorValue) {
        try {
            if (StringsKt.startsWith$default(colorValue, "#", false, 2, (Object) null)) {
                return ColorKt.Color(android.graphics.Color.parseColor(colorValue));
            }
            if (!StringsKt.startsWith$default(colorValue, "@android:color/", false, 2, (Object) null) && !StringsKt.startsWith$default(colorValue, "?attr/", false, 2, (Object) null)) {
                Log.w("ImageLoader", "Unknown color format: " + colorValue + ", using black");
                return Color.INSTANCE.m7364getBlack0d7_KjU();
            }
            Log.d("ImageLoader", "Theme color attribute not resolved: " + colorValue + ", using black");
            return Color.INSTANCE.m7364getBlack0d7_KjU();
        } catch (Exception e) {
            Log.e("ImageLoader", "Failed to parse color: " + colorValue, e);
            return Color.INSTANCE.m7364getBlack0d7_KjU();
        }
    }

    /* JADX INFO: compiled from: ImageLoader.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lexpo/modules/ui/graphics/ImageLoader$Companion;", "", "<init>", "()V", "TAG", "", "memoryCacheSizeKilobytes", "", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int memoryCacheSizeKilobytes() {
            return (int) RangesKt.coerceIn((Runtime.getRuntime().maxMemory() / 1024) / 8, 1L, SieveCacheKt.NodeLinkMask);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final ImageVector parseVectorElement(XmlPullParser parser) {
        try {
            float fM10168constructorimpl = Dp.m10168constructorimpl(24.0f);
            float fM10168constructorimpl2 = Dp.m10168constructorimpl(24.0f);
            int attributeCount = parser.getAttributeCount();
            float fFloatValue = 24.0f;
            float fFloatValue2 = 24.0f;
            float fM12135parseDimensionu2uoSUM = fM10168constructorimpl;
            float fM12135parseDimensionu2uoSUM2 = fM10168constructorimpl2;
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = parser.getAttributeName(i);
                if (attributeName != null) {
                    switch (attributeName.hashCode()) {
                        case -1499022144:
                            if (attributeName.equals("viewportWidth")) {
                                String attributeValue = parser.getAttributeValue(i);
                                Intrinsics.checkNotNullExpressionValue(attributeValue, "getAttributeValue(...)");
                                Float floatOrNull = StringsKt.toFloatOrNull(attributeValue);
                                fFloatValue = floatOrNull != null ? floatOrNull.floatValue() : 24.0f;
                            }
                            break;
                        case -1221029593:
                            if (attributeName.equals(ViewProps.HEIGHT)) {
                                String attributeValue2 = parser.getAttributeValue(i);
                                Intrinsics.checkNotNullExpressionValue(attributeValue2, "getAttributeValue(...)");
                                fM12135parseDimensionu2uoSUM2 = m12135parseDimensionu2uoSUM(attributeValue2);
                            }
                            break;
                        case 113126854:
                            if (attributeName.equals(ViewProps.WIDTH)) {
                                String attributeValue3 = parser.getAttributeValue(i);
                                Intrinsics.checkNotNullExpressionValue(attributeValue3, "getAttributeValue(...)");
                                fM12135parseDimensionu2uoSUM = m12135parseDimensionu2uoSUM(attributeValue3);
                            }
                            break;
                        case 341959021:
                            if (attributeName.equals("viewportHeight")) {
                                String attributeValue4 = parser.getAttributeValue(i);
                                Intrinsics.checkNotNullExpressionValue(attributeValue4, "getAttributeValue(...)");
                                Float floatOrNull2 = StringsKt.toFloatOrNull(attributeValue4);
                                fFloatValue2 = floatOrNull2 != null ? floatOrNull2.floatValue() : 24.0f;
                            }
                            break;
                    }
                }
            }
            ImageVector.Builder builder = new ImageVector.Builder(null, fM12135parseDimensionu2uoSUM, fM12135parseDimensionu2uoSUM2, fFloatValue, fFloatValue2, 0L, 0, false, 225, null);
            int next = parser.next();
            while (next != 1) {
                if (next != 2) {
                    if (next == 3 && Intrinsics.areEqual(parser.getName(), "vector")) {
                        return builder.build();
                    }
                } else if (Intrinsics.areEqual(parser.getName(), "path")) {
                    parsePathElement(parser, builder);
                }
                next = parser.next();
            }
            return builder.build();
        } catch (Exception e) {
            Log.e("ImageLoader", "Failed to parse <vector> element", e);
            return null;
        }
    }
}
