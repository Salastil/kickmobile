package expo.modules.clipboard;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Base64;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt;
import kotlinx.coroutines.YieldKt;

/* JADX INFO: compiled from: ClipboardImage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0080@¢\u0006\u0002\u0010\u000e\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a\b\u0010\u0013\u001a\u00020\u0001H\u0000\u001a&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0080@¢\u0006\u0002\u0010\u0016\u001a\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0080@¢\u0006\u0002\u0010\u0019\u001a\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\u001b\u001a\u00020\u001c*\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u001d\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"PNG_PREFIX", "", "JPEG_PREFIX", "getImageFormatFromBase64", "Lexpo/modules/clipboard/ImageFormat;", "base64Image", "imageFromContentUri", "Lexpo/modules/clipboard/ImageResult;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "imageUri", "Landroid/net/Uri;", "options", "Lexpo/modules/clipboard/GetImageOptions;", "(Landroid/content/Context;Landroid/net/Uri;Lexpo/modules/clipboard/GetImageOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearClipboardCache", "", "clipboardCacheDir", "Ljava/io/File;", "hashFileName", "clipDataFromBase64Image", "Landroid/content/ClipData;", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bitmapFromContentUriAsync", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bitmapFromBase64String", "ensureExists", "", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-clipboard_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ClipboardImageKt {
    public static final String JPEG_PREFIX = "/9j/";
    public static final String PNG_PREFIX = "iVBORw0K";

    /* JADX INFO: compiled from: ClipboardImage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageFormat.values().length];
            try {
                iArr[ImageFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageFormat.JPG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: expo.modules.clipboard.ClipboardImageKt$bitmapFromContentUriAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClipboardImage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.clipboard.ClipboardImageKt", f = "ClipboardImage.kt", i = {0, 0}, l = {190}, m = "bitmapFromContentUriAsync", n = {RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "imageUri"}, s = {"L$0", "L$1"})
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
            return ClipboardImageKt.bitmapFromContentUriAsync(null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.clipboard.ClipboardImageKt$clipDataFromBase64Image$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ClipboardImage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.clipboard.ClipboardImageKt", f = "ClipboardImage.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {162, WebmConstants.MkvEbmlElement.BLOCK_MORE, 169}, m = "clipDataFromBase64Image", n = {RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "base64Image", "clipboardCacheDir", "bitmap", "format", "nameHash", "fileName", "it", "$i$a$-also-ClipboardImageKt$clipDataFromBase64Image$file$1", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "base64Image", "clipboardCacheDir", "bitmap", "format", "nameHash", "fileName", "file", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "base64Image", "clipboardCacheDir", "bitmap", "format", "nameHash", "fileName", "file", "fileStream", "outputStream", "$i$a$-use-ClipboardImageKt$clipDataFromBase64Image$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "I$0"})
    static final class C08141 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C08141(Continuation<? super C08141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ClipboardImageKt.clipDataFromBase64Image(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.clipboard.ClipboardImageKt$imageFromContentUri$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ClipboardImage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.clipboard.ClipboardImageKt", f = "ClipboardImage.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {79, 87}, m = "imageFromContentUri", n = {RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "imageUri", "options", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "imageUri", "options", "bitmap", "format", "outputStream", "quality"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"})
    static final class C08151 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C08151(Continuation<? super C08151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ClipboardImageKt.imageFromContentUri(null, null, null, this);
        }
    }

    public static final ImageFormat getImageFormatFromBase64(String base64Image) {
        Intrinsics.checkNotNullParameter(base64Image, "base64Image");
        String strSubstring = base64Image.substring(0, 8);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        if (StringsKt.startsWith$default(strSubstring, PNG_PREFIX, false, 2, (Object) null)) {
            return ImageFormat.PNG;
        }
        return StringsKt.startsWith$default(strSubstring, JPEG_PREFIX, false, 2, (Object) null) ? ImageFormat.JPG : ImageFormat.JPG;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object imageFromContentUri(Context context, Uri uri, GetImageOptions getImageOptions, Continuation<? super ImageResult> continuation) {
        C08151 c08151;
        Bitmap bitmap;
        ImageFormat imageFormat;
        ByteArrayOutputStream byteArrayOutputStream;
        if (continuation instanceof C08151) {
            c08151 = (C08151) continuation;
            if ((c08151.label & Integer.MIN_VALUE) != 0) {
                c08151.label -= Integer.MIN_VALUE;
            } else {
                c08151 = new C08151(continuation);
            }
        } else {
            c08151 = new C08151(continuation);
        }
        Object objBitmapFromContentUriAsync = c08151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08151.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objBitmapFromContentUriAsync);
            c08151.L$0 = SpillingKt.nullOutSpilledVariable(context);
            c08151.L$1 = SpillingKt.nullOutSpilledVariable(uri);
            c08151.L$2 = getImageOptions;
            c08151.label = 1;
            objBitmapFromContentUriAsync = bitmapFromContentUriAsync(context, uri, c08151);
            if (objBitmapFromContentUriAsync != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            getImageOptions = (GetImageOptions) c08151.L$2;
            uri = (Uri) c08151.L$1;
            context = (Context) c08151.L$0;
            ResultKt.throwOnFailure(objBitmapFromContentUriAsync);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c08151.I$0;
            byteArrayOutputStream = (ByteArrayOutputStream) c08151.L$5;
            imageFormat = (ImageFormat) c08151.L$4;
            bitmap = (Bitmap) c08151.L$3;
            ResultKt.throwOnFailure(objBitmapFromContentUriAsync);
        }
        String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        StringBuilder sb = new StringBuilder("data:" + imageFormat.getMimeType() + ";base64,");
        sb.append(strEncodeToString);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new ImageResult(string, bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmap2 = (Bitmap) objBitmapFromContentUriAsync;
        ImageFormat imageFormat2 = getImageOptions.getImageFormat();
        int jpegQuality = (int) (getImageOptions.getJpegQuality() * 100.0d);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        bitmap2.compress(imageFormat2.getCompressFormat(), jpegQuality, byteArrayOutputStream2);
        c08151.L$0 = SpillingKt.nullOutSpilledVariable(context);
        c08151.L$1 = SpillingKt.nullOutSpilledVariable(uri);
        c08151.L$2 = SpillingKt.nullOutSpilledVariable(getImageOptions);
        c08151.L$3 = bitmap2;
        c08151.L$4 = imageFormat2;
        c08151.L$5 = byteArrayOutputStream2;
        c08151.I$0 = jpegQuality;
        c08151.label = 2;
        if (YieldKt.yield(c08151) != coroutine_suspended) {
            bitmap = bitmap2;
            imageFormat = imageFormat2;
            byteArrayOutputStream = byteArrayOutputStream2;
            String strEncodeToString2 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            StringBuilder sb2 = new StringBuilder("data:" + imageFormat.getMimeType() + ";base64,");
            sb2.append(strEncodeToString2);
            String string2 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            return new ImageResult(string2, bitmap.getWidth(), bitmap.getHeight());
        }
        return coroutine_suspended;
    }

    public static final void clearClipboardCache(File clipboardCacheDir) {
        File[] fileArrListFiles;
        Intrinsics.checkNotNullParameter(clipboardCacheDir, "clipboardCacheDir");
        if (clipboardCacheDir.exists() && clipboardCacheDir.isDirectory() && (fileArrListFiles = clipboardCacheDir.listFiles()) != null) {
            for (File file : fileArrListFiles) {
                if (file.isDirectory()) {
                    Intrinsics.checkNotNull(file);
                    FilesKt.deleteRecursively(file);
                } else {
                    file.delete();
                }
            }
        }
    }

    public static final String hashFileName() throws NoSuchAlgorithmException {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        String str = "copied_image" + ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: expo.modules.clipboard.ClipboardImageKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ClipboardImageKt.hashFileName$lambda$3(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics.checkNotNull(bArrDigest);
        return ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: expo.modules.clipboard.ClipboardImageKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ClipboardImageKt.hashFileName$lambda$4(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence hashFileName$lambda$3(byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    static final CharSequence hashFileName$lambda$4(byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object clipDataFromBase64Image(Context context, String str, File file, Continuation<? super ClipData> continuation) throws NoSuchAlgorithmException, InvalidImageException {
        C08141 c08141;
        Bitmap bitmapBitmapFromBase64String;
        String str2;
        File file2;
        Context context2;
        ImageFormat imageFormat;
        final File file3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        ImageFormat imageFormat2;
        Bitmap bitmap;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        Closeable closeable;
        Function0 function0;
        Throwable th2;
        Context context3;
        if (continuation instanceof C08141) {
            c08141 = (C08141) continuation;
            if ((c08141.label & Integer.MIN_VALUE) != 0) {
                c08141.label -= Integer.MIN_VALUE;
            } else {
                c08141 = new C08141(continuation);
            }
        } else {
            c08141 = new C08141(continuation);
        }
        Object obj = c08141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08141.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            bitmapBitmapFromBase64String = bitmapFromBase64String(str);
            ImageFormat imageFormatFromBase64 = getImageFormatFromBase64(str);
            clearClipboardCache(file);
            String strHashFileName = hashFileName();
            int i2 = WhenMappings.$EnumSwitchMapping$0[imageFormatFromBase64.ordinal()];
            if (i2 == 1) {
                str2 = strHashFileName + ".png";
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str2 = strHashFileName + ".jpeg";
            }
            file2 = file;
            File file4 = new File(file2, str2);
            context2 = context;
            c08141.L$0 = context2;
            c08141.L$1 = SpillingKt.nullOutSpilledVariable(str);
            c08141.L$2 = SpillingKt.nullOutSpilledVariable(file2);
            c08141.L$3 = bitmapBitmapFromBase64String;
            c08141.L$4 = imageFormatFromBase64;
            c08141.L$5 = SpillingKt.nullOutSpilledVariable(strHashFileName);
            c08141.L$6 = SpillingKt.nullOutSpilledVariable(str2);
            c08141.L$7 = file4;
            c08141.L$8 = SpillingKt.nullOutSpilledVariable(file4);
            c08141.I$0 = 0;
            c08141.label = 1;
            if (ensureExists(file4, c08141) != coroutine_suspended) {
                imageFormat = imageFormatFromBase64;
                file3 = file4;
                String str8 = str2;
                str3 = strHashFileName;
                str4 = str8;
                str5 = str;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c08141.I$0;
                closeable = (Closeable) c08141.L$9;
                file3 = (File) c08141.L$7;
                context3 = (Context) c08141.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    th2 = null;
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(closeable, th2);
                    ClipData clipDataNewUri = ClipData.newUri(context3.getContentResolver(), "image", ClipboardFileProvider.INSTANCE.getUriForFile(context3, context3.getApplicationInfo().packageName + ".ClipboardFileProvider", file3));
                    Intrinsics.checkNotNullExpressionValue(clipDataNewUri, "newUri(...)");
                    return clipDataNewUri;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(closeable, th);
                        throw th4;
                    }
                }
            }
            file3 = (File) c08141.L$7;
            str6 = (String) c08141.L$6;
            str7 = (String) c08141.L$5;
            imageFormat2 = (ImageFormat) c08141.L$4;
            bitmap = (Bitmap) c08141.L$3;
            file2 = (File) c08141.L$2;
            String str9 = (String) c08141.L$1;
            Context context4 = (Context) c08141.L$0;
            ResultKt.throwOnFailure(obj);
            str5 = str9;
            context2 = context4;
            FileOutputStream fileOutputStream = (FileOutputStream) obj;
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                final BufferedOutputStream bufferedOutputStream2 = bufferedOutputStream;
                bitmap.compress(imageFormat2.getCompressFormat(), 100, bufferedOutputStream2);
                function0 = new Function0() { // from class: expo.modules.clipboard.ClipboardImageKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ClipboardImageKt.clipDataFromBase64Image$lambda$8$lambda$7(bufferedOutputStream2);
                    }
                };
                c08141.L$0 = context2;
                c08141.L$1 = SpillingKt.nullOutSpilledVariable(str5);
                c08141.L$2 = SpillingKt.nullOutSpilledVariable(file2);
                c08141.L$3 = SpillingKt.nullOutSpilledVariable(bitmap);
                c08141.L$4 = SpillingKt.nullOutSpilledVariable(imageFormat2);
                c08141.L$5 = SpillingKt.nullOutSpilledVariable(str7);
                c08141.L$6 = SpillingKt.nullOutSpilledVariable(str6);
                c08141.L$7 = file3;
                c08141.L$8 = SpillingKt.nullOutSpilledVariable(fileOutputStream);
                c08141.L$9 = bufferedOutputStream;
                c08141.L$10 = SpillingKt.nullOutSpilledVariable(bufferedOutputStream2);
                c08141.I$0 = 0;
                c08141.label = 3;
                th2 = null;
                if (InterruptibleKt.runInterruptible$default(null, function0, c08141, 1, null) != coroutine_suspended) {
                    closeable = bufferedOutputStream;
                    context3 = context2;
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(closeable, th2);
                    ClipData clipDataNewUri2 = ClipData.newUri(context3.getContentResolver(), "image", ClipboardFileProvider.INSTANCE.getUriForFile(context3, context3.getApplicationInfo().packageName + ".ClipboardFileProvider", file3));
                    Intrinsics.checkNotNullExpressionValue(clipDataNewUri2, "newUri(...)");
                    return clipDataNewUri2;
                }
                return coroutine_suspended;
            } catch (Throwable th5) {
                th = th5;
                closeable = bufferedOutputStream;
                throw th;
            }
        }
        int i4 = c08141.I$0;
        file3 = (File) c08141.L$7;
        str4 = (String) c08141.L$6;
        str3 = (String) c08141.L$5;
        imageFormat = (ImageFormat) c08141.L$4;
        Bitmap bitmap2 = (Bitmap) c08141.L$3;
        File file5 = (File) c08141.L$2;
        str5 = (String) c08141.L$1;
        Context context5 = (Context) c08141.L$0;
        ResultKt.throwOnFailure(obj);
        bitmapBitmapFromBase64String = bitmap2;
        file2 = file5;
        context2 = context5;
        Function0 function1 = new Function0() { // from class: expo.modules.clipboard.ClipboardImageKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ClipboardImageKt.clipDataFromBase64Image$lambda$6(file3);
            }
        };
        c08141.L$0 = context2;
        c08141.L$1 = SpillingKt.nullOutSpilledVariable(str5);
        c08141.L$2 = SpillingKt.nullOutSpilledVariable(file2);
        c08141.L$3 = bitmapBitmapFromBase64String;
        c08141.L$4 = imageFormat;
        c08141.L$5 = SpillingKt.nullOutSpilledVariable(str3);
        c08141.L$6 = SpillingKt.nullOutSpilledVariable(str4);
        c08141.L$7 = file3;
        c08141.L$8 = null;
        c08141.label = 2;
        Object objRunInterruptible$default = InterruptibleKt.runInterruptible$default(null, function1, c08141, 1, null);
        if (objRunInterruptible$default != coroutine_suspended) {
            str6 = str4;
            str7 = str3;
            imageFormat2 = imageFormat;
            bitmap = bitmapBitmapFromBase64String;
            obj = objRunInterruptible$default;
            FileOutputStream fileOutputStream2 = (FileOutputStream) obj;
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
            final BufferedOutputStream bufferedOutputStream3 = bufferedOutputStream;
            bitmap.compress(imageFormat2.getCompressFormat(), 100, bufferedOutputStream3);
            function0 = new Function0() { // from class: expo.modules.clipboard.ClipboardImageKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ClipboardImageKt.clipDataFromBase64Image$lambda$8$lambda$7(bufferedOutputStream3);
                }
            };
            c08141.L$0 = context2;
            c08141.L$1 = SpillingKt.nullOutSpilledVariable(str5);
            c08141.L$2 = SpillingKt.nullOutSpilledVariable(file2);
            c08141.L$3 = SpillingKt.nullOutSpilledVariable(bitmap);
            c08141.L$4 = SpillingKt.nullOutSpilledVariable(imageFormat2);
            c08141.L$5 = SpillingKt.nullOutSpilledVariable(str7);
            c08141.L$6 = SpillingKt.nullOutSpilledVariable(str6);
            c08141.L$7 = file3;
            c08141.L$8 = SpillingKt.nullOutSpilledVariable(fileOutputStream2);
            c08141.L$9 = bufferedOutputStream;
            c08141.L$10 = SpillingKt.nullOutSpilledVariable(bufferedOutputStream3);
            c08141.I$0 = 0;
            c08141.label = 3;
            th2 = null;
            if (InterruptibleKt.runInterruptible$default(null, function0, c08141, 1, null) != coroutine_suspended) {
                closeable = bufferedOutputStream;
                context3 = context2;
                Unit unit3 = Unit.INSTANCE;
                CloseableKt.closeFinally(closeable, th2);
                ClipData clipDataNewUri3 = ClipData.newUri(context3.getContentResolver(), "image", ClipboardFileProvider.INSTANCE.getUriForFile(context3, context3.getApplicationInfo().packageName + ".ClipboardFileProvider", file3));
                Intrinsics.checkNotNullExpressionValue(clipDataNewUri3, "newUri(...)");
                return clipDataNewUri3;
            }
        }
        return coroutine_suspended;
    }

    static final FileOutputStream clipDataFromBase64Image$lambda$6(File file) {
        return new FileOutputStream(file, false);
    }

    static final Unit clipDataFromBase64Image$lambda$8$lambda$7(BufferedOutputStream bufferedOutputStream) throws IOException {
        bufferedOutputStream.flush();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object bitmapFromContentUriAsync(final Context context, final Uri uri, Continuation<? super Bitmap> continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object objRunInterruptible = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objRunInterruptible);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            Function0 function0 = new Function0() { // from class: expo.modules.clipboard.ClipboardImageKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ClipboardImageKt.bitmapFromContentUriAsync$lambda$9(context, uri);
                }
            };
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(uri);
            anonymousClass1.label = 1;
            objRunInterruptible = InterruptibleKt.runInterruptible(io2, function0, anonymousClass1);
            if (objRunInterruptible == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objRunInterruptible);
        }
        Intrinsics.checkNotNullExpressionValue(objRunInterruptible, "runInterruptible(...)");
        return objRunInterruptible;
    }

    static final Bitmap bitmapFromContentUriAsync$lambda$9(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        if (Build.VERSION.SDK_INT < 28) {
            return MediaStore.Images.Media.getBitmap(contentResolver, uri);
        }
        ImageDecoder.Source sourceCreateSource = ImageDecoder.createSource(contentResolver, uri);
        Intrinsics.checkNotNullExpressionValue(sourceCreateSource, "createSource(...)");
        return ImageDecoder.decodeBitmap(sourceCreateSource);
    }

    public static final Bitmap bitmapFromBase64String(String base64Image) throws InvalidImageException {
        Intrinsics.checkNotNullParameter(base64Image, "base64Image");
        try {
            byte[] bArrDecode = Base64.decode(base64Image, 0);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            if (bitmapDecodeByteArray != null) {
                return bitmapDecodeByteArray;
            }
            throw new RuntimeException("Failed to convert base64 into Bitmap");
        } catch (RuntimeException e) {
            throw new InvalidImageException(base64Image, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ensureExists(final File file, Continuation<? super Boolean> continuation) {
        return InterruptibleKt.runInterruptible(Dispatchers.getIO(), new Function0() { // from class: expo.modules.clipboard.ClipboardImageKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ClipboardImageKt.ensureExists$lambda$10(file));
            }
        }, continuation);
    }

    static final boolean ensureExists$lambda$10(File file) {
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        return file.createNewFile();
    }
}
