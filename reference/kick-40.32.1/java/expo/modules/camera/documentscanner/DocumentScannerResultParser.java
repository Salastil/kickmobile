package expo.modules.camera.documentscanner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult;
import expo.modules.camera.utils.FileSystemUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentScannerResultParser.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0002¨\u0006\u0011"}, d2 = {"Lexpo/modules/camera/documentscanner/DocumentScannerResultParser;", "", "<init>", "()V", "parse", "Landroid/os/Bundle;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "result", "Lcom/google/mlkit/vision/documentscanner/GmsDocumentScanningResult;", "cacheDir", "Ljava/io/File;", "copyToCache", "", "source", "Landroid/net/Uri;", "extension", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentScannerResultParser {
    public static final DocumentScannerResultParser INSTANCE = new DocumentScannerResultParser();

    private DocumentScannerResultParser() {
    }

    public final Bundle parse(Context context, GmsDocumentScanningResult result, File cacheDir) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        List<GmsDocumentScanningResult.Page> pages = result.getPages();
        if (pages == null) {
            pages = CollectionsKt.emptyList();
        }
        List<GmsDocumentScanningResult.Page> list = pages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (GmsDocumentScanningResult.Page page : list) {
            DocumentScannerResultParser documentScannerResultParser = INSTANCE;
            Uri imageUri = page.getImageUri();
            Intrinsics.checkNotNullExpressionValue(imageUri, "getImageUri(...)");
            arrayList.add(documentScannerResultParser.copyToCache(context, imageUri, cacheDir, ".jpg"));
        }
        Bundle bundle = new Bundle();
        bundle.putStringArray("pages", (String[]) arrayList.toArray(new String[0]));
        GmsDocumentScanningResult.Pdf pdf = result.getPdf();
        if (pdf != null) {
            DocumentScannerResultParser documentScannerResultParser2 = INSTANCE;
            Uri uri = pdf.getUri();
            Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
            bundle.putString("pdfUri", documentScannerResultParser2.copyToCache(context, uri, cacheDir, ".pdf"));
        }
        return bundle;
    }

    private final String copyToCache(Context context, Uri source, File cacheDir, String extension) throws IOException {
        File fileGenerateOutputFile = FileSystemUtils.INSTANCE.generateOutputFile(cacheDir, "DocumentScanner", extension);
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(source);
        if (inputStreamOpenInputStream == null) {
            throw new IOException("Could not open the scanned document at " + source);
        }
        InputStream inputStream = inputStreamOpenInputStream;
        try {
            InputStream inputStream2 = inputStream;
            FileOutputStream fileOutputStream = new FileOutputStream(fileGenerateOutputFile);
            try {
                ByteStreamsKt.copyTo$default(inputStream2, fileOutputStream, 0, 2, null);
                CloseableKt.closeFinally(fileOutputStream, null);
                CloseableKt.closeFinally(inputStream, null);
                String string = Uri.fromFile(fileGenerateOutputFile).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(inputStream, th3);
                throw th4;
            }
        }
    }
}
