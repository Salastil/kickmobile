package expo.modules.imagepicker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.imagepipeline.common.RotationOptions;
import expo.modules.imagepicker.exporters.CompressionImageExporter;
import expo.modules.imagepicker.exporters.ImageExportResult;
import expo.modules.imagepicker.exporters.ImageExporter;
import expo.modules.imagepicker.exporters.RawImageExporter;
import expo.modules.kotlin.providers.AppContextProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaHandler.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J8\u0010\n\u001a\u00020\u000b2\u001e\u0010\f\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\rj\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0080@¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0010H\u0002J\u0016\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lexpo/modules/imagepicker/MediaHandler;", "", "appContextProvider", "Lexpo/modules/kotlin/providers/AppContextProvider;", "<init>", "(Lexpo/modules/kotlin/providers/AppContextProvider;)V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "readExtras", "Lexpo/modules/imagepicker/ImagePickerResponse;", "bareResult", "", "Lkotlin/Pair;", "Lexpo/modules/imagepicker/MediaType;", "Landroid/net/Uri;", "Lexpo/modules/imagepicker/contracts/MediaList;", "options", "Lexpo/modules/imagepicker/ImagePickerOptions;", "readExtras$expo_image_picker_release", "(Ljava/util/List;Lexpo/modules/imagepicker/ImagePickerOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "handleImage", "Lexpo/modules/imagepicker/ImagePickerAsset;", "sourceUri", "(Landroid/net/Uri;Lexpo/modules/imagepicker/ImagePickerOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAdditionalFileData", "Lexpo/modules/imagepicker/AdditionalFileData;", "uri", "handleVideo", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-image-picker_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MediaHandler {
    private final AppContextProvider appContextProvider;

    /* JADX INFO: compiled from: MediaHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: expo.modules.imagepicker.MediaHandler$handleImage$1, reason: invalid class name */
    /* JADX INFO: compiled from: MediaHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagepicker.MediaHandler", f = "MediaHandler.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {58, 60, 63}, m = "handleImage", n = {"sourceUri", "options", "exporter", "mimeType", "outputFile", "sourceUri", "options", "exporter", "mimeType", "outputFile", "exportedImage", "it", "$i$a$-let-MediaHandler$handleImage$base64$2", "sourceUri", "options", "exporter", "mimeType", "outputFile", "exportedImage", "base64", "it", "$i$a$-let-MediaHandler$handleImage$exif$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MediaHandler.this.handleImage(null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.imagepicker.MediaHandler$handleVideo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MediaHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagepicker.MediaHandler", f = "MediaHandler.kt", i = {0, 0}, l = {102}, m = "handleVideo", n = {"sourceUri", "outputFile"}, s = {"L$0", "L$1"})
    static final class C08231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C08231(Continuation<? super C08231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MediaHandler.this.handleVideo(null, this);
        }
    }

    public MediaHandler(AppContextProvider appContextProvider) {
        Intrinsics.checkNotNullParameter(appContextProvider, "appContextProvider");
        this.appContextProvider = appContextProvider;
    }

    private final Context getContext() {
        Context reactContext = this.appContextProvider.getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new IllegalArgumentException("React Application Context is null".toString());
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:21:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:22:0x00da  */
    /* JADX WARN: Code duplicated, block: B:40:0x0189  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0128 -> B:31:0x0131). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0189 -> B:41:0x01b9). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object readExtras$expo_image_picker_release(java.util.List<? extends kotlin.Pair<? extends expo.modules.imagepicker.MediaType, ? extends android.net.Uri>> r32, expo.modules.imagepicker.ImagePickerOptions r33, kotlin.coroutines.Continuation<? super expo.modules.imagepicker.ImagePickerResponse> r34) {
        /*
            Method dump skipped, instruction units count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.MediaHandler.readExtras$expo_image_picker_release(java.util.List, expo.modules.imagepicker.ImagePickerOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final File getCacheDirectory() {
        return this.appContextProvider.getAppContext().getCacheDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x0156  */
    /* JADX WARN: Code duplicated, block: B:40:0x0164  */
    /* JADX WARN: Code duplicated, block: B:45:0x017a  */
    /* JADX WARN: Code duplicated, block: B:47:0x017d  */
    /* JADX WARN: Code duplicated, block: B:50:0x01af  */
    /* JADX WARN: Code duplicated, block: B:53:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:56:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:58:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:61:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:64:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object handleImage(Uri uri, ImagePickerOptions imagePickerOptions, Continuation<? super ImagePickerAsset> continuation) throws IOException, FailedToCreateFileException {
        AnonymousClass1 anonymousClass1;
        CompressionImageExporter compressionImageExporter;
        Uri uri2;
        ImageExporter imageExporter;
        String str;
        File file;
        ImagePickerOptions imagePickerOptions2;
        ImageExportResult imageExportResult;
        Uri uri3;
        ImagePickerOptions imagePickerOptions3;
        ImageExporter imageExporter2;
        ImageExportResult imageExportResult2;
        ImagePickerOptions imagePickerOptions4;
        String str2;
        Boolean boolBoxBoolean;
        String str3;
        Bundle bundle;
        Object objExif;
        ImageExportResult imageExportResult3;
        String str4;
        Uri uri4;
        ByteArrayOutputStream byteArrayOutputStream;
        AdditionalFileData additionalFileData;
        String name;
        long length;
        Long fileSize;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (imagePickerOptions.getQuality() == 1.0d) {
                compressionImageExporter = new RawImageExporter();
            } else {
                compressionImageExporter = new CompressionImageExporter(this.appContextProvider, imagePickerOptions.getQuality());
            }
            ContentResolver contentResolver = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            String type = ImagePickerUtilsKt.getType(contentResolver, uri);
            if (type == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            File fileCreateOutputFile = ImagePickerUtilsKt.createOutputFile(getCacheDirectory(), ImagePickerUtilsKt.toImageFileExtension(type));
            ContentResolver contentResolver2 = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver2, "getContentResolver(...)");
            anonymousClass1.L$0 = uri;
            anonymousClass1.L$1 = imagePickerOptions;
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(compressionImageExporter);
            anonymousClass1.L$3 = type;
            anonymousClass1.L$4 = fileCreateOutputFile;
            anonymousClass1.label = 1;
            Object objExportAsync = compressionImageExporter.exportAsync(uri, fileCreateOutputFile, contentResolver2, anonymousClass1);
            if (objExportAsync != coroutine_suspended) {
                uri2 = uri;
                imageExporter = compressionImageExporter;
                obj = objExportAsync;
                str = type;
                file = fileCreateOutputFile;
                imagePickerOptions2 = imagePickerOptions;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            File file2 = (File) anonymousClass1.L$4;
            String str5 = (String) anonymousClass1.L$3;
            ImageExporter imageExporter3 = (ImageExporter) anonymousClass1.L$2;
            imagePickerOptions2 = (ImagePickerOptions) anonymousClass1.L$1;
            uri2 = (Uri) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            file = file2;
            imageExporter = imageExporter3;
            str = str5;
        } else {
            if (i == 2) {
                int i2 = anonymousClass1.I$0;
                boolean z = anonymousClass1.Z$0;
                imageExportResult2 = (ImageExportResult) anonymousClass1.L$5;
                file = (File) anonymousClass1.L$4;
                str = (String) anonymousClass1.L$3;
                imageExporter2 = (ImageExporter) anonymousClass1.L$2;
                imagePickerOptions3 = (ImagePickerOptions) anonymousClass1.L$1;
                uri3 = (Uri) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                byteArrayOutputStream = (ByteArrayOutputStream) obj;
                if (byteArrayOutputStream != null) {
                    String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    imageExportResult = imageExportResult2;
                    str2 = strEncodeToString;
                    imagePickerOptions4 = imagePickerOptions3;
                    uri2 = uri3;
                } else {
                    imageExportResult = imageExportResult2;
                    imageExporter = imageExporter2;
                    imagePickerOptions2 = imagePickerOptions3;
                    uri2 = uri3;
                    imagePickerOptions4 = imagePickerOptions2;
                    imageExporter2 = imageExporter;
                    str2 = null;
                }
                boolBoxBoolean = Boxing.boxBoolean(imagePickerOptions4.getExif());
                if (!boolBoxBoolean.booleanValue()) {
                    boolBoxBoolean = null;
                }
                if (boolBoxBoolean != null) {
                    boolean zBooleanValue = boolBoxBoolean.booleanValue();
                    ContentResolver contentResolver3 = getContext().getContentResolver();
                    Intrinsics.checkNotNullExpressionValue(contentResolver3, "getContentResolver(...)");
                    anonymousClass1.L$0 = uri2;
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(imagePickerOptions4);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(imageExporter2);
                    anonymousClass1.L$3 = str;
                    anonymousClass1.L$4 = file;
                    anonymousClass1.L$5 = imageExportResult;
                    anonymousClass1.L$6 = str2;
                    anonymousClass1.Z$0 = zBooleanValue;
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.label = 3;
                    objExif = imageExportResult.exif(contentResolver3, anonymousClass1);
                    if (objExif != coroutine_suspended) {
                        imageExportResult3 = imageExportResult;
                        obj = objExif;
                        str4 = str;
                        uri4 = uri2;
                    }
                    return coroutine_suspended;
                }
                str3 = str;
                bundle = null;
                String str6 = str2;
                additionalFileData = getAdditionalFileData(uri2);
                MediaType mediaType = MediaType.IMAGE;
                String string = Uri.fromFile(file).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                int width = imageExportResult.getWidth();
                int height = imageExportResult.getHeight();
                if (additionalFileData != null || (name = additionalFileData.getFileName()) == null) {
                    name = file.getName();
                }
                String str7 = name;
                if (additionalFileData != null || (fileSize = additionalFileData.getFileSize()) == null) {
                    length = file.length();
                } else {
                    length = fileSize.longValue();
                }
                return new ImagePickerAsset(ImagePickerUtilsKt.getMediaStoreAssetId(uri2), mediaType, string, width, height, str7, Boxing.boxLong(length), str3, str6, bundle, null, null, 3072, null);
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = anonymousClass1.I$0;
            boolean z2 = anonymousClass1.Z$0;
            str2 = (String) anonymousClass1.L$6;
            imageExportResult3 = (ImageExportResult) anonymousClass1.L$5;
            file = (File) anonymousClass1.L$4;
            str4 = (String) anonymousClass1.L$3;
            uri4 = (Uri) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Bundle bundle2 = (Bundle) obj;
        uri2 = uri4;
        imageExportResult = imageExportResult3;
        str3 = str4;
        bundle = bundle2;
        String str8 = str2;
        additionalFileData = getAdditionalFileData(uri2);
        MediaType mediaType2 = MediaType.IMAGE;
        String string2 = Uri.fromFile(file).toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        int width2 = imageExportResult.getWidth();
        int height2 = imageExportResult.getHeight();
        if (additionalFileData != null) {
            name = file.getName();
        } else {
            name = file.getName();
        }
        String str9 = name;
        if (additionalFileData != null) {
            length = file.length();
        } else {
            length = file.length();
        }
        return new ImagePickerAsset(ImagePickerUtilsKt.getMediaStoreAssetId(uri2), mediaType2, string2, width2, height2, str9, Boxing.boxLong(length), str3, str8, bundle, null, null, 3072, null);
        imageExportResult = (ImageExportResult) obj;
        Boolean boolBoxBoolean2 = Boxing.boxBoolean(imagePickerOptions2.getBase64());
        if (!boolBoxBoolean2.booleanValue()) {
            boolBoxBoolean2 = null;
        }
        if (boolBoxBoolean2 != null) {
            boolean zBooleanValue2 = boolBoxBoolean2.booleanValue();
            ContentResolver contentResolver4 = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver4, "getContentResolver(...)");
            anonymousClass1.L$0 = uri2;
            anonymousClass1.L$1 = imagePickerOptions2;
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(imageExporter);
            anonymousClass1.L$3 = str;
            anonymousClass1.L$4 = file;
            anonymousClass1.L$5 = imageExportResult;
            anonymousClass1.Z$0 = zBooleanValue2;
            anonymousClass1.I$0 = 0;
            anonymousClass1.label = 2;
            Object objData = imageExportResult.data(contentResolver4, anonymousClass1);
            if (objData != coroutine_suspended) {
                uri3 = uri2;
                imagePickerOptions3 = imagePickerOptions2;
                imageExporter2 = imageExporter;
                imageExportResult2 = imageExportResult;
                obj = objData;
                byteArrayOutputStream = (ByteArrayOutputStream) obj;
                if (byteArrayOutputStream != null) {
                    String strEncodeToString2 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    imageExportResult = imageExportResult2;
                    str2 = strEncodeToString2;
                    imagePickerOptions4 = imagePickerOptions3;
                    uri2 = uri3;
                } else {
                    imageExportResult = imageExportResult2;
                    imageExporter = imageExporter2;
                    imagePickerOptions2 = imagePickerOptions3;
                    uri2 = uri3;
                    imagePickerOptions4 = imagePickerOptions2;
                    imageExporter2 = imageExporter;
                    str2 = null;
                }
                boolBoxBoolean = Boxing.boxBoolean(imagePickerOptions4.getExif());
                if (!boolBoxBoolean.booleanValue()) {
                    boolBoxBoolean = null;
                }
                if (boolBoxBoolean != null) {
                    boolean zBooleanValue3 = boolBoxBoolean.booleanValue();
                    ContentResolver contentResolver5 = getContext().getContentResolver();
                    Intrinsics.checkNotNullExpressionValue(contentResolver5, "getContentResolver(...)");
                    anonymousClass1.L$0 = uri2;
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(imagePickerOptions4);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(imageExporter2);
                    anonymousClass1.L$3 = str;
                    anonymousClass1.L$4 = file;
                    anonymousClass1.L$5 = imageExportResult;
                    anonymousClass1.L$6 = str2;
                    anonymousClass1.Z$0 = zBooleanValue3;
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.label = 3;
                    objExif = imageExportResult.exif(contentResolver5, anonymousClass1);
                    if (objExif != coroutine_suspended) {
                        imageExportResult3 = imageExportResult;
                        obj = objExif;
                        str4 = str;
                        uri4 = uri2;
                        Bundle bundle3 = (Bundle) obj;
                        uri2 = uri4;
                        imageExportResult = imageExportResult3;
                        str3 = str4;
                        bundle = bundle3;
                    }
                } else {
                    str3 = str;
                    bundle = null;
                }
                String str10 = str2;
                additionalFileData = getAdditionalFileData(uri2);
                MediaType mediaType3 = MediaType.IMAGE;
                String string3 = Uri.fromFile(file).toString();
                Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                int width3 = imageExportResult.getWidth();
                int height3 = imageExportResult.getHeight();
                if (additionalFileData != null) {
                    name = file.getName();
                } else {
                    name = file.getName();
                }
                String str11 = name;
                if (additionalFileData != null) {
                    length = file.length();
                } else {
                    length = file.length();
                }
                return new ImagePickerAsset(ImagePickerUtilsKt.getMediaStoreAssetId(uri2), mediaType3, string3, width3, height3, str11, Boxing.boxLong(length), str3, str10, bundle, null, null, 3072, null);
            }
        } else {
            imagePickerOptions4 = imagePickerOptions2;
            imageExporter2 = imageExporter;
            str2 = null;
            boolBoxBoolean = Boxing.boxBoolean(imagePickerOptions4.getExif());
            if (!boolBoxBoolean.booleanValue()) {
                boolBoxBoolean = null;
            }
            if (boolBoxBoolean != null) {
                boolean zBooleanValue4 = boolBoxBoolean.booleanValue();
                ContentResolver contentResolver6 = getContext().getContentResolver();
                Intrinsics.checkNotNullExpressionValue(contentResolver6, "getContentResolver(...)");
                anonymousClass1.L$0 = uri2;
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(imagePickerOptions4);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(imageExporter2);
                anonymousClass1.L$3 = str;
                anonymousClass1.L$4 = file;
                anonymousClass1.L$5 = imageExportResult;
                anonymousClass1.L$6 = str2;
                anonymousClass1.Z$0 = zBooleanValue4;
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 3;
                objExif = imageExportResult.exif(contentResolver6, anonymousClass1);
                if (objExif != coroutine_suspended) {
                    imageExportResult3 = imageExportResult;
                    obj = objExif;
                    str4 = str;
                    uri4 = uri2;
                    Bundle bundle4 = (Bundle) obj;
                    uri2 = uri4;
                    imageExportResult = imageExportResult3;
                    str3 = str4;
                    bundle = bundle4;
                }
            } else {
                str3 = str;
                bundle = null;
            }
            String str12 = str2;
            additionalFileData = getAdditionalFileData(uri2);
            MediaType mediaType4 = MediaType.IMAGE;
            String string4 = Uri.fromFile(file).toString();
            Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
            int width4 = imageExportResult.getWidth();
            int height4 = imageExportResult.getHeight();
            if (additionalFileData != null) {
                name = file.getName();
            } else {
                name = file.getName();
            }
            String str13 = name;
            if (additionalFileData != null) {
                length = file.length();
            } else {
                length = file.length();
            }
            return new ImagePickerAsset(ImagePickerUtilsKt.getMediaStoreAssetId(uri2), mediaType4, string4, width4, height4, str13, Boxing.boxLong(length), str3, str12, bundle, null, null, 3072, null);
        }
        return coroutine_suspended;
    }

    private final AdditionalFileData getAdditionalFileData(Uri uri) {
        Object objM12684constructorimpl;
        Cursor cursorQuery = getContext().getContentResolver().query(uri, (String[]) CollectionsKt.listOf((Object[]) new String[]{"_display_name", "_size"}).toArray(new String[0]), null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        Cursor cursor = cursorQuery;
        try {
            Cursor cursor2 = cursor;
            if (!cursor2.moveToFirst()) {
                CloseableKt.closeFinally(cursor, null);
                return null;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                MediaHandler mediaHandler = this;
                Integer numValueOf = Integer.valueOf(cursor2.getColumnIndex("_display_name"));
                if (numValueOf.intValue() == -1) {
                    numValueOf = null;
                }
                String string = numValueOf != null ? cursor2.getString(numValueOf.intValue()) : null;
                Integer numValueOf2 = Integer.valueOf(cursor2.getColumnIndex("_size"));
                if (numValueOf2.intValue() == -1) {
                    numValueOf2 = null;
                }
                objM12684constructorimpl = Result.m12684constructorimpl(new AdditionalFileData(string, numValueOf2 != null ? Long.valueOf(cursor2.getLong(numValueOf2.intValue())) : null));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            AdditionalFileData additionalFileData = (AdditionalFileData) objM12684constructorimpl;
            CloseableKt.closeFinally(cursor, null);
            return additionalFileData;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.closeFinally(cursor, th2);
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object handleVideo(Uri uri, Continuation<? super ImagePickerAsset> continuation) throws IOException, FailedToCreateFileException, FailedToExtractVideoMetadataException {
        C08231 c08231;
        File fileCreateOutputFile;
        int i;
        int i2;
        Uri uri2 = uri;
        if (continuation instanceof C08231) {
            c08231 = (C08231) continuation;
            if ((c08231.label & Integer.MIN_VALUE) != 0) {
                c08231.label -= Integer.MIN_VALUE;
            } else {
                c08231 = new C08231(continuation);
            }
        } else {
            c08231 = new C08231(continuation);
        }
        Object obj = c08231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c08231.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            fileCreateOutputFile = ImagePickerUtilsKt.createOutputFile(getCacheDirectory(), ".mp4");
            ContentResolver contentResolver = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            c08231.L$0 = uri2;
            c08231.L$1 = fileCreateOutputFile;
            c08231.label = 1;
            if (ImagePickerUtilsKt.copyFile(uri2, fileCreateOutputFile, contentResolver, c08231) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            File file = (File) c08231.L$1;
            Uri uri3 = (Uri) c08231.L$0;
            ResultKt.throwOnFailure(obj);
            fileCreateOutputFile = file;
            uri2 = uri3;
        }
        Uri uriFromFile = Uri.fromFile(fileCreateOutputFile);
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(getContext(), uriFromFile);
            AdditionalFileData additionalFileData = getAdditionalFileData(uri2);
            ContentResolver contentResolver2 = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver2, "getContentResolver(...)");
            String type = ImagePickerUtilsKt.getType(contentResolver2, uri2);
            int iExtractInt = ImagePickerUtilsKt.extractInt(mediaMetadataRetriever, 18);
            int iExtractInt2 = ImagePickerUtilsKt.extractInt(mediaMetadataRetriever, 19);
            int iExtractInt3 = ImagePickerUtilsKt.extractInt(mediaMetadataRetriever, 24);
            if (iExtractInt3 % RotationOptions.ROTATE_180 != 0) {
                i2 = iExtractInt;
                i = iExtractInt2;
            } else {
                i = iExtractInt;
                i2 = iExtractInt2;
            }
            MediaType mediaType = MediaType.VIDEO;
            String string = uriFromFile.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return new ImagePickerAsset(ImagePickerUtilsKt.getMediaStoreAssetId(uri2), mediaType, string, i, i2, additionalFileData != null ? additionalFileData.getFileName() : null, additionalFileData != null ? additionalFileData.getFileSize() : null, type, null, null, Boxing.boxInt(ImagePickerUtilsKt.extractInt(mediaMetadataRetriever, 9)), Boxing.boxInt(iExtractInt3), 768, null);
        } catch (FailedToExtractVideoMetadataException e) {
            throw new FailedToExtractVideoMetadataException(fileCreateOutputFile, e);
        }
    }
}
