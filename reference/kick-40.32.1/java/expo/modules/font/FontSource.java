package expo.modules.font;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.net.Uri;
import androidx.core.util.HalfKt$$ExternalSyntheticApiModelOutline0;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.useinsider.insider.k4$$ExternalSyntheticApiModelOutline0;
import expo.modules.kotlin.exception.CodedException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FontSource.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u0000 \n2\u00020\u0001:\u0003\b\t\nJ\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H'\u0082\u0001\u0002\u000b\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lexpo/modules/font/FontSource;", "", "load", "Landroid/graphics/Typeface;", "readForInstancing", "Ljava/nio/ByteBuffer;", "newFontBuilder", "Landroid/graphics/fonts/Font$Builder;", "Asset", "LocalFile", "Companion", "Lexpo/modules/font/FontSource$Asset;", "Lexpo/modules/font/FontSource$LocalFile;", "expo-font_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FontSource {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Typeface load();

    Font.Builder newFontBuilder();

    ByteBuffer readForInstancing();

    /* JADX INFO: compiled from: FontSource.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/font/FontSource$Asset;", "Lexpo/modules/font/FontSource;", "path", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Ljava/lang/String;Landroid/content/Context;)V", "load", "Landroid/graphics/Typeface;", "readForInstancing", "Ljava/nio/ByteBuffer;", "newFontBuilder", "Landroid/graphics/fonts/Font$Builder;", "expo-font_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Asset implements FontSource {
        private final Context context;
        private final String path;

        public Asset(String path, Context context) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(context, "context");
            this.path = path;
            this.context = context;
        }

        @Override // expo.modules.font.FontSource
        public Typeface load() {
            Typeface typefaceCreateFromAsset = Typeface.createFromAsset(this.context.getAssets(), this.path);
            Intrinsics.checkNotNullExpressionValue(typefaceCreateFromAsset, "createFromAsset(...)");
            return typefaceCreateFromAsset;
        }

        @Override // expo.modules.font.FontSource
        public ByteBuffer readForInstancing() throws IOException {
            InputStream inputStreamOpen = this.context.getAssets().open(this.path);
            try {
                InputStream inputStream = inputStreamOpen;
                Intrinsics.checkNotNull(inputStream);
                ByteBuffer atMost = FontBytesKt.readAtMost(inputStream, FontVariationAxes.TABLE_DIRECTORY_LIMIT);
                ByteBuffer wholeFont = !FontVariationAxes.INSTANCE.declaresVariations(atMost) ? null : FontBytesKt.readWholeFont(atMost, inputStream);
                CloseableKt.closeFinally(inputStreamOpen, null);
                return wholeFont;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpen, th);
                    throw th2;
                }
            }
        }

        @Override // expo.modules.font.FontSource
        public Font.Builder newFontBuilder() {
            HalfKt$$ExternalSyntheticApiModelOutline0.m10516m$1();
            return k4$$ExternalSyntheticApiModelOutline0.m(this.context.getAssets(), this.path);
        }
    }

    /* JADX INFO: compiled from: FontSource.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lexpo/modules/font/FontSource$LocalFile;", "Lexpo/modules/font/FontSource;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "load", "Landroid/graphics/Typeface;", "readForInstancing", "Ljava/nio/ByteBuffer;", "newFontBuilder", "Landroid/graphics/fonts/Font$Builder;", "expo-font_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class LocalFile implements FontSource {
        private final File file;

        public LocalFile(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            this.file = file;
        }

        @Override // expo.modules.font.FontSource
        public Typeface load() {
            Typeface typefaceCreateFromFile = Typeface.createFromFile(this.file);
            Intrinsics.checkNotNullExpressionValue(typefaceCreateFromFile, "createFromFile(...)");
            return typefaceCreateFromFile;
        }

        @Override // expo.modules.font.FontSource
        public ByteBuffer readForInstancing() {
            FileInputStream fileInputStream = new FileInputStream(this.file);
            try {
                FileInputStream fileInputStream2 = fileInputStream;
                MappedByteBuffer map = fileInputStream2.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, fileInputStream2.getChannel().size());
                CloseableKt.closeFinally(fileInputStream, null);
                FontVariationAxes fontVariationAxes = FontVariationAxes.INSTANCE;
                Intrinsics.checkNotNull(map);
                if (!fontVariationAxes.declaresVariations(map)) {
                    map = null;
                }
                return map;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileInputStream, th);
                    throw th2;
                }
            }
        }

        @Override // expo.modules.font.FontSource
        public Font.Builder newFontBuilder() {
            HalfKt$$ExternalSyntheticApiModelOutline0.m10516m$1();
            return k4$$ExternalSyntheticApiModelOutline0.m(this.file);
        }
    }

    /* JADX INFO: compiled from: FontSource.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/font/FontSource$Companion;", "", "<init>", "()V", "resolve", "Lexpo/modules/font/FontSource;", "localUri", "", "fontFamilyName", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "expo-font_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final FontSource resolve(String localUri, String fontFamilyName, Context context) throws CodedException {
            Intrinsics.checkNotNullParameter(localUri, "localUri");
            Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
            Intrinsics.checkNotNullParameter(context, "context");
            if (StringsKt.startsWith$default(localUri, "asset://", false, 2, (Object) null)) {
                String strSubstring = localUri.substring(9);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                return new Asset(strSubstring, context);
            }
            String path = Uri.parse(localUri).getPath();
            if (path == null) {
                throw new FileNotFoundException(localUri);
            }
            File file = new File(path);
            if (file.length() == 0) {
                throw new CodedException("Font file for " + fontFamilyName + " is empty. Make sure the local file path is correctly populated.", null, 2, null);
            }
            return new LocalFile(file);
        }
    }
}
