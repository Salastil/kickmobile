package expo.modules.filesystem;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import expo.modules.filesystem.unifiedfile.ContentProviderFile;
import expo.modules.filesystem.unifiedfile.JavaFile;
import expo.modules.filesystem.unifiedfile.SAFDocumentFile;
import expo.modules.filesystem.unifiedfile.UnifiedFileInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.jni.NativeArrayBuffer;
import expo.modules.kotlin.services.FilePermissionService;
import io.ktor.http.ContentDisposition;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.HexExtensionsKt;
import kotlin.text.HexFormat;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: FileSystemFile.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000eJ\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001c2\b\b\u0002\u0010\u001b\u001a\u00020\u000eJ\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u001aJ\u0006\u0010\u001f\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u001aJ\u0006\u0010!\u001a\u00020\u001dJ\u0006\u0010\"\u001a\u00020\u0003J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001aJ\u0010\u0010.\u001a\u00020/2\b\u0010\u0012\u001a\u0004\u0018\u000100R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010#\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0013\u0010(\u001a\u0004\u0018\u00010)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b-\u0010%¨\u00061"}, d2 = {"Lexpo/modules/filesystem/FileSystemFile;", "Lexpo/modules/filesystem/FileSystemPath;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "contentResolver", "Landroid/content/ContentResolver;", "getContentResolver", "()Landroid/content/ContentResolver;", "validatePath", "", "validateType", "exists", "", "getExists", "()Z", "create", "options", "Lexpo/modules/filesystem/CreateOptions;", "openHandle", "Lexpo/modules/filesystem/FileSystemFileHandle;", "mode", "Lexpo/modules/filesystem/FileMode;", "write", "content", "", "append", "Lexpo/modules/kotlin/jni/NativeArrayBuffer;", "", "asString", "text", "base64", "bytes", "asContentUri", "md5", "getMd5", "()Ljava/lang/String;", "digest", "algorithm", ContentDisposition.Parameters.Size, "", "getSize", "()Ljava/lang/Long;", "type", "getType", "info", "Lexpo/modules/filesystem/FileInfo;", "Lexpo/modules/filesystem/InfoOptions;", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileSystemFile extends FileSystemPath {
    public final void validatePath() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemFile(Uri uri) {
        super(uri);
        Intrinsics.checkNotNullParameter(uri, "uri");
    }

    private final ContentResolver getContentResolver() throws Exceptions.ReactContextLost {
        Context reactContext;
        ContentResolver contentResolver;
        AppContext appContext = getAppContext();
        if (appContext == null || (reactContext = appContext.getReactContext()) == null || (contentResolver = reactContext.getContentResolver()) == null) {
            throw new Exceptions.ReactContextLost();
        }
        return contentResolver;
    }

    @Override // expo.modules.filesystem.FileSystemPath
    public void validateType() throws InvalidTypeFileException {
        validatePermission(FilePermissionService.Permission.READ);
        if (getFile().exists() && getFile().isDirectory()) {
            throw new InvalidTypeFileException();
        }
    }

    public final boolean getExists() {
        if (checkPermission(FilePermissionService.Permission.READ)) {
            return getFile().isFile();
        }
        return false;
    }

    public static /* synthetic */ void create$default(FileSystemFile fileSystemFile, CreateOptions createOptions, int i, Object obj) throws InvalidTypeFileException, UnableToCreateException {
        if ((i & 1) != 0) {
            createOptions = new CreateOptions(false, false, false, 7, null);
        }
        fileSystemFile.create(createOptions);
    }

    public final void create(CreateOptions options) throws InvalidTypeFileException, UnableToCreateException {
        File parentFile;
        Intrinsics.checkNotNullParameter(options, "options");
        if (FileSystemPathKt.isContentUri(getUri())) {
            throw new UnableToCreateException("File.create function does not work with SAF content:// uris, use `Directory.createFile` instead");
        }
        validateType();
        validatePermission(FilePermissionService.Permission.WRITE);
        validateCanCreate(options);
        if (options.getOverwrite() && getExists()) {
            getJavaFile().delete();
        }
        if (options.getIntermediates() && (parentFile = getJavaFile().getParentFile()) != null) {
            parentFile.mkdirs();
        }
        if (!getJavaFile().createNewFile()) {
            throw new UnableToCreateException("file already exists or could not be created");
        }
    }

    public final FileSystemFileHandle openHandle(FileMode mode) throws UnsupportedContentUriReadWriteException, Exceptions.IllegalStateException {
        Object file = getFile();
        if (mode == null) {
            if ((file instanceof SAFDocumentFile) || (file instanceof ContentProviderFile)) {
                mode = FileMode.READ;
            } else {
                mode = FileMode.READ_WRITE;
            }
        }
        Iterator<FilePermissionService.Permission> it = FileSystemFileKt.requiredPermissions(mode).iterator();
        while (it.hasNext()) {
            validatePermission(it.next());
        }
        if (file instanceof JavaFile) {
            return FileSystemFileHandle.INSTANCE.forJavaFile((File) file, mode);
        }
        if (file instanceof SAFDocumentFile) {
            return FileSystemFileHandle.INSTANCE.forContentURI(((SAFDocumentFile) file).getUri(), mode, getContentResolver());
        }
        if (file instanceof ContentProviderFile) {
            if (mode == FileMode.READ_WRITE) {
                throw new UnsupportedContentUriReadWriteException();
            }
            try {
                return FileSystemFileHandle.INSTANCE.forContentURI(((ContentProviderFile) file).getUri(), mode, getContentResolver());
            } catch (Exception e) {
                throw new Exceptions.IllegalStateException("Failed to open file handle for content:// URI: " + ((ContentProviderFile) file).getUri() + ". The content provider may not support random access. Try reading the file using File.text() or File.bytes() instead.", e);
            }
        }
        throw new Exceptions.IllegalStateException("File handle is not supported for " + getFile().getUri(), null, 2, null);
    }

    public static /* synthetic */ void write$default(FileSystemFile fileSystemFile, String str, boolean z, int i, Object obj) throws InvalidTypeFileException, UnableToCreateException {
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystemFile.write(str, z);
    }

    public final void write(String content, boolean append) throws InvalidTypeFileException, UnableToCreateException {
        Intrinsics.checkNotNullParameter(content, "content");
        validateType();
        validatePermission(FilePermissionService.Permission.WRITE);
        if (!getExists()) {
            create$default(this, null, 1, null);
        }
        OutputStream outputStream = getFile().outputStream(append);
        try {
            byte[] bytes = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            outputStream.write(bytes);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(outputStream, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void write$default(FileSystemFile fileSystemFile, NativeArrayBuffer nativeArrayBuffer, boolean z, int i, Object obj) throws InvalidTypeFileException, UnableToCreateException {
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystemFile.write(nativeArrayBuffer, z);
    }

    public final void write(NativeArrayBuffer content, boolean append) throws InvalidTypeFileException, UnableToCreateException {
        Intrinsics.checkNotNullParameter(content, "content");
        validateType();
        validatePermission(FilePermissionService.Permission.WRITE);
        if (!getExists()) {
            create$default(this, null, 1, null);
        }
        if (FileSystemPathKt.isContentUri(getUri())) {
            OutputStream outputStream = getFile().outputStream(append);
            try {
                byte[] bArr = new byte[content.size()];
                content.toDirectBuffer().get(bArr);
                outputStream.write(bArr);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStream, null);
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(outputStream, th);
                    throw th2;
                }
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(getJavaFile(), append);
        try {
            Integer.valueOf(fileOutputStream.getChannel().write(content.toDirectBuffer()));
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(fileOutputStream, th3);
                throw th4;
            }
        }
    }

    public static /* synthetic */ void write$default(FileSystemFile fileSystemFile, byte[] bArr, boolean z, int i, Object obj) throws InvalidTypeFileException, UnableToCreateException {
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystemFile.write(bArr, z);
    }

    public final void write(byte[] content, boolean append) throws InvalidTypeFileException, UnableToCreateException {
        Intrinsics.checkNotNullParameter(content, "content");
        validateType();
        validatePermission(FilePermissionService.Permission.WRITE);
        if (!getExists()) {
            create$default(this, null, 1, null);
        }
        if (FileSystemPathKt.isContentUri(getUri())) {
            OutputStream outputStream = getFile().outputStream(append);
            try {
                outputStream.write(content);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStream, null);
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(outputStream, th);
                    throw th2;
                }
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(getJavaFile(), append);
        try {
            fileOutputStream.write(content);
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(fileOutputStream, th3);
                throw th4;
            }
        }
    }

    public final String asString() {
        String string = getFile().getUri().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.endsWith$default(string, DomExceptionUtils.SEPARATOR, false, 2, (Object) null) ? StringsKt.dropLast(string, 1) : string;
    }

    public final String text() throws InvalidTypeFileException {
        validateType();
        validatePermission(FilePermissionService.Permission.READ);
        InputStream inputStream = getFile().inputStream();
        try {
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String text = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                CloseableKt.closeFinally(inputStream, null);
                return text;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedReader, th);
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

    public final String base64() throws InvalidTypeFileException {
        validateType();
        validatePermission(FilePermissionService.Permission.READ);
        InputStream inputStream = getFile().inputStream();
        try {
            String strEncodeToString = Base64.encodeToString(ByteStreamsKt.readBytes(inputStream), 2);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
            CloseableKt.closeFinally(inputStream, null);
            return strEncodeToString;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStream, th);
                throw th2;
            }
        }
    }

    public final byte[] bytes() throws InvalidTypeFileException {
        validateType();
        validatePermission(FilePermissionService.Permission.READ);
        InputStream inputStream = getFile().inputStream();
        try {
            byte[] bytes = ByteStreamsKt.readBytes(inputStream);
            CloseableKt.closeFinally(inputStream, null);
            return bytes;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStream, th);
                throw th2;
            }
        }
    }

    public final Uri asContentUri() throws InvalidTypeFileException, MissingAppContextException {
        validateType();
        validatePermission(FilePermissionService.Permission.READ);
        UnifiedFileInterface file = getFile();
        AppContext appContext = getAppContext();
        if (appContext != null) {
            return file.getContentUri(appContext);
        }
        throw new MissingAppContextException();
    }

    public final String getMd5() {
        return digest(MessageDigestAlgorithms.MD5);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:24:0x006e A[Catch: all -> 0x0086, LOOP:0: B:22:0x0067->B:24:0x006e, LOOP_END, TryCatch #0 {all -> 0x0086, blocks: (B:21:0x0060, B:22:0x0067, B:24:0x006e, B:25:0x0073), top: B:35:0x0060 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0073 A[SYNTHETIC] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String digest(String algorithm) throws InvalidTypeFileException, UnsupportedDigestAlgorithmException, NoSuchAlgorithmException {
        MessageDigest messageDigest;
        InputStream inputStream;
        InputStream inputStream2;
        byte[] bArr;
        int i;
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        validateType();
        validatePermission(FilePermissionService.Permission.READ);
        switch (algorithm.hashCode()) {
            case -1523887726:
                if (algorithm.equals("SHA-256")) {
                    messageDigest = MessageDigest.getInstance("SHA-256");
                    inputStream = getFile().inputStream();
                    try {
                        inputStream2 = inputStream;
                        bArr = new byte[65536];
                        while (true) {
                            i = inputStream2.read(bArr);
                            if (i == -1) {
                                byte[] bArrDigest = messageDigest.digest();
                                Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
                                String hexString$default = HexExtensionsKt.toHexString$default(bArrDigest, (HexFormat) null, 1, (Object) null);
                                CloseableKt.closeFinally(inputStream, null);
                                return hexString$default;
                            }
                            messageDigest.update(bArr, 0, i);
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
                throw new UnsupportedDigestAlgorithmException(algorithm);
            case -1523886674:
                if (algorithm.equals("SHA-384")) {
                    messageDigest = MessageDigest.getInstance("SHA-384");
                    inputStream = getFile().inputStream();
                    inputStream2 = inputStream;
                    bArr = new byte[65536];
                    while (true) {
                        i = inputStream2.read(bArr);
                        if (i == -1) {
                            byte[] bArrDigest2 = messageDigest.digest();
                            Intrinsics.checkNotNullExpressionValue(bArrDigest2, "digest(...)");
                            String hexString$default2 = HexExtensionsKt.toHexString$default(bArrDigest2, (HexFormat) null, 1, (Object) null);
                            CloseableKt.closeFinally(inputStream, null);
                            return hexString$default2;
                        }
                        messageDigest.update(bArr, 0, i);
                    }
                }
                throw new UnsupportedDigestAlgorithmException(algorithm);
            case -1523884971:
                if (algorithm.equals("SHA-512")) {
                    messageDigest = MessageDigest.getInstance("SHA-512");
                    inputStream = getFile().inputStream();
                    inputStream2 = inputStream;
                    bArr = new byte[65536];
                    while (true) {
                        i = inputStream2.read(bArr);
                        if (i == -1) {
                            byte[] bArrDigest3 = messageDigest.digest();
                            Intrinsics.checkNotNullExpressionValue(bArrDigest3, "digest(...)");
                            String hexString$default3 = HexExtensionsKt.toHexString$default(bArrDigest3, (HexFormat) null, 1, (Object) null);
                            CloseableKt.closeFinally(inputStream, null);
                            return hexString$default3;
                        }
                        messageDigest.update(bArr, 0, i);
                    }
                }
                throw new UnsupportedDigestAlgorithmException(algorithm);
            case 76158:
                if (algorithm.equals(MessageDigestAlgorithms.MD5)) {
                    messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                    inputStream = getFile().inputStream();
                    inputStream2 = inputStream;
                    bArr = new byte[65536];
                    while (true) {
                        i = inputStream2.read(bArr);
                        if (i == -1) {
                            byte[] bArrDigest4 = messageDigest.digest();
                            Intrinsics.checkNotNullExpressionValue(bArrDigest4, "digest(...)");
                            String hexString$default4 = HexExtensionsKt.toHexString$default(bArrDigest4, (HexFormat) null, 1, (Object) null);
                            CloseableKt.closeFinally(inputStream, null);
                            return hexString$default4;
                        }
                        messageDigest.update(bArr, 0, i);
                    }
                }
                throw new UnsupportedDigestAlgorithmException(algorithm);
            case 78861104:
                if (algorithm.equals("SHA-1")) {
                    messageDigest = MessageDigest.getInstance("SHA-1");
                    inputStream = getFile().inputStream();
                    inputStream2 = inputStream;
                    bArr = new byte[65536];
                    while (true) {
                        i = inputStream2.read(bArr);
                        if (i == -1) {
                            byte[] bArrDigest5 = messageDigest.digest();
                            Intrinsics.checkNotNullExpressionValue(bArrDigest5, "digest(...)");
                            String hexString$default5 = HexExtensionsKt.toHexString$default(bArrDigest5, (HexFormat) null, 1, (Object) null);
                            CloseableKt.closeFinally(inputStream, null);
                            return hexString$default5;
                        }
                        messageDigest.update(bArr, 0, i);
                    }
                }
                throw new UnsupportedDigestAlgorithmException(algorithm);
            default:
                throw new UnsupportedDigestAlgorithmException(algorithm);
        }
    }

    public final Long getSize() {
        if (getFile().exists()) {
            return Long.valueOf(getFile().length());
        }
        return null;
    }

    public final String getType() {
        return getFile().getType();
    }

    public final FileInfo info(InfoOptions options) throws InvalidTypeFileException {
        validateType();
        validatePermission(FilePermissionService.Permission.READ);
        if (!getFile().exists()) {
            return new FileInfo(false, FileSystemPathKt.slashifyFilePath(getFile().getUri().toString()), null, null, null, null, 60, null);
        }
        FileInfo fileInfo = new FileInfo(true, FileSystemPathKt.slashifyFilePath(getFile().getUri().toString()), null, getSize(), getModificationTime(), getCreationTime(), 4, null);
        if (options != null && Intrinsics.areEqual((Object) options.getMd5(), (Object) true)) {
            fileInfo.setMd5(getMd5());
        }
        return fileInfo;
    }
}
