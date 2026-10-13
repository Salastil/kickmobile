package expo.modules.filesystem;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.collection.SieveCacheKt;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.sharedobjects.SharedRef;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FileSystemFileHandle.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001!B%\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b \u0010\u001c¨\u0006\""}, d2 = {"Lexpo/modules/filesystem/FileSystemFileHandle;", "Lexpo/modules/kotlin/sharedobjects/SharedRef;", "Ljava/nio/channels/FileChannel;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "channel", "mode", "Lexpo/modules/filesystem/FileMode;", "parcelFileDescriptor", "Landroid/os/ParcelFileDescriptor;", "<init>", "(Ljava/nio/channels/FileChannel;Lexpo/modules/filesystem/FileMode;Landroid/os/ParcelFileDescriptor;)V", "fileChannel", "lock", "", "ensureIsOpen", "", "sharedObjectDidRelease", "close", "read", "", "length", "", "write", "data", "value", "offset", "getOffset", "()Ljava/lang/Long;", "setOffset", "(Ljava/lang/Long;)V", ContentDisposition.Parameters.Size, "getSize", "Companion", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileSystemFileHandle extends SharedRef<FileChannel> implements AutoCloseable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final FileChannel fileChannel;
    private final Object lock;
    private final FileMode mode;
    private final ParcelFileDescriptor parcelFileDescriptor;

    public /* synthetic */ FileSystemFileHandle(FileChannel fileChannel, FileMode fileMode, ParcelFileDescriptor parcelFileDescriptor, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileChannel, fileMode, parcelFileDescriptor);
    }

    /* synthetic */ FileSystemFileHandle(FileChannel fileChannel, FileMode fileMode, ParcelFileDescriptor parcelFileDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileChannel, fileMode, (i & 4) != 0 ? null : parcelFileDescriptor);
    }

    /* JADX INFO: compiled from: FileSystemFileHandle.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lexpo/modules/filesystem/FileSystemFileHandle$Companion;", "", "<init>", "()V", "forJavaFile", "Lexpo/modules/filesystem/FileSystemFileHandle;", "file", "Ljava/io/File;", "mode", "Lexpo/modules/filesystem/FileMode;", "forContentURI", "uri", "Landroid/net/Uri;", "contentResolver", "Landroid/content/ContentResolver;", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: FileSystemFileHandle.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FileMode.values().length];
                try {
                    iArr[FileMode.APPEND.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FileMode.TRUNCATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FileMode.READ.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[FileMode.WRITE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FileSystemFileHandle forJavaFile(File file, FileMode mode) throws IOException {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(mode, "mode");
            FileChannel channel = new RandomAccessFile(file, mode.getRafMode()).getChannel();
            int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
            if (i == 1) {
                channel.position(channel.size());
            } else if (i != 2) {
                Unit unit = Unit.INSTANCE;
            } else {
                channel.truncate(0L);
            }
            Intrinsics.checkNotNull(channel);
            return new FileSystemFileHandle(channel, mode, null, 4, null);
        }

        public final FileSystemFileHandle forContentURI(Uri uri, FileMode mode, ContentResolver contentResolver) throws Exceptions.IllegalArgument, UnsupportedContentUriReadWriteException, Exceptions.IllegalStateException, FileNotFoundException {
            FileChannel channel;
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
            if (mode == FileMode.READ_WRITE) {
                throw new UnsupportedContentUriReadWriteException();
            }
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, mode.getDescriptor());
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                throw new Exceptions.IllegalStateException("Could not open file descriptor for uri: " + uri, null, 2, null);
            }
            int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
            if (i == 1 || i == 2) {
                channel = new FileOutputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).getChannel();
            } else if (i == 3) {
                channel = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).getChannel();
            } else {
                if (i != 4) {
                    throw new Exceptions.IllegalArgument("Unsupported file mode: '" + mode + "'", null, 2, null);
                }
                channel = new FileOutputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).getChannel();
            }
            Intrinsics.checkNotNull(channel);
            return new FileSystemFileHandle(channel, mode, parcelFileDescriptorOpenFileDescriptor, defaultConstructorMarker);
        }
    }

    private FileSystemFileHandle(FileChannel fileChannel, FileMode fileMode, ParcelFileDescriptor parcelFileDescriptor) {
        super(fileChannel, null, 2, null);
        this.mode = fileMode;
        this.parcelFileDescriptor = parcelFileDescriptor;
        this.fileChannel = getRef();
        this.lock = new Object();
    }

    private final void ensureIsOpen() throws UnableToReadHandleException {
        if (!this.fileChannel.isOpen()) {
            throw new UnableToReadHandleException("file handle is closed");
        }
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public void sharedObjectDidRelease() {
        close();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            try {
                this.fileChannel.close();
                ParcelFileDescriptor parcelFileDescriptor = this.parcelFileDescriptor;
                if (parcelFileDescriptor != null) {
                    parcelFileDescriptor.close();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                ParcelFileDescriptor parcelFileDescriptor2 = this.parcelFileDescriptor;
                if (parcelFileDescriptor2 != null) {
                    parcelFileDescriptor2.close();
                }
                throw th;
            }
        }
    }

    public final byte[] read(long length) {
        synchronized (this.lock) {
            ensureIsOpen();
            this.mode.ensureCanRead();
            try {
                int iCoerceAtMost = (int) RangesKt.coerceAtMost(Math.min(length, this.fileChannel.size() - this.fileChannel.position()), SieveCacheKt.NodeLinkMask);
                int i = 0;
                if (iCoerceAtMost <= 0) {
                    return new byte[0];
                }
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iCoerceAtMost);
                while (i < iCoerceAtMost) {
                    int i2 = this.fileChannel.read(byteBufferAllocate);
                    if (i2 == -1) {
                        break;
                    }
                    i += i2;
                }
                byte[] bArrArray = byteBufferAllocate.array();
                Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
                return bArrArray;
            } catch (Exception e) {
                String message = e.getMessage();
                if (message == null) {
                    message = "unknown error";
                }
                throw new UnableToReadHandleException(message);
            }
        }
    }

    public final void write(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        synchronized (this.lock) {
            ensureIsOpen();
            this.mode.ensureCanWrite();
            try {
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(data);
                while (byteBufferWrap.hasRemaining()) {
                    this.fileChannel.write(byteBufferWrap);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Exception e) {
                String message = e.getMessage();
                if (message == null) {
                    message = "unknown error";
                }
                throw new UnableToWriteHandleException(message);
            }
        }
    }

    public final Long getOffset() {
        Long lValueOf;
        synchronized (this.lock) {
            try {
                lValueOf = Long.valueOf(this.fileChannel.position());
            } catch (Exception unused) {
                lValueOf = null;
            }
        }
        return lValueOf;
    }

    public final void setOffset(Long l) {
        if (l == null) {
            return;
        }
        synchronized (this.lock) {
            this.fileChannel.position(l.longValue());
        }
    }

    public final Long getSize() {
        Long lValueOf;
        synchronized (this.lock) {
            try {
                lValueOf = Long.valueOf(this.fileChannel.size());
            } catch (Exception unused) {
                lValueOf = null;
            }
        }
        return lValueOf;
    }
}
