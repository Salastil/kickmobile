package expo.modules.filesystem.fsops;

import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import expo.modules.filesystem.UnableToCopyException;
import expo.modules.filesystem.unifiedfile.JavaFile;
import expo.modules.filesystem.unifiedfile.SAFDocumentFile;
import expo.modules.filesystem.unifiedfile.UnifiedFileInterface;
import expo.modules.kotlin.exception.Exceptions;
import java.io.IOException;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DestinationSink.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\r\u000e\u000f\u0010B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lexpo/modules/filesystem/fsops/DestinationSink;", "", "spec", "Lexpo/modules/filesystem/fsops/DestinationSpec;", "<init>", "(Lexpo/modules/filesystem/fsops/DestinationSpec;)V", "getSpec", "()Lexpo/modules/filesystem/fsops/DestinationSpec;", "receiveFrom", "Landroid/net/Uri;", "source", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "(Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LocalFile", "SAF", "ContentResource", "Asset", "Lexpo/modules/filesystem/fsops/DestinationSink$Asset;", "Lexpo/modules/filesystem/fsops/DestinationSink$ContentResource;", "Lexpo/modules/filesystem/fsops/DestinationSink$LocalFile;", "Lexpo/modules/filesystem/fsops/DestinationSink$SAF;", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class DestinationSink {
    private final DestinationSpec spec;

    public /* synthetic */ DestinationSink(DestinationSpec destinationSpec, DefaultConstructorMarker defaultConstructorMarker) {
        this(destinationSpec);
    }

    public abstract Object receiveFrom(UnifiedFileInterface unifiedFileInterface, Continuation<? super Uri> continuation);

    private DestinationSink(DestinationSpec destinationSpec) {
        this.spec = destinationSpec;
    }

    public final DestinationSpec getSpec() {
        return this.spec;
    }

    /* JADX INFO: compiled from: DestinationSink.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lexpo/modules/filesystem/fsops/DestinationSink$LocalFile;", "Lexpo/modules/filesystem/fsops/DestinationSink;", "spec", "Lexpo/modules/filesystem/fsops/DestinationSpec;", TypedValues.Attributes.S_TARGET, "Lexpo/modules/filesystem/unifiedfile/JavaFile;", "<init>", "(Lexpo/modules/filesystem/fsops/DestinationSpec;Lexpo/modules/filesystem/unifiedfile/JavaFile;)V", "getTarget", "()Lexpo/modules/filesystem/unifiedfile/JavaFile;", "receiveFrom", "Landroid/net/Uri;", "source", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "(Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class LocalFile extends DestinationSink {
        private final JavaFile target;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocalFile(DestinationSpec spec, JavaFile target) {
            super(spec, null);
            Intrinsics.checkNotNullParameter(spec, "spec");
            Intrinsics.checkNotNullParameter(target, "target");
            this.target = target;
        }

        public final JavaFile getTarget() {
            return this.target;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
        
            if (expo.modules.filesystem.fsops.UtilitiesKt.copyDirectoryParallel$default(r10, r2, r3, 0, r5, 8, null) == r0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
        
            if (expo.modules.filesystem.fsops.UtilitiesKt.copyDirectoryParallel$default(r10, r1, null, 0, r5, 12, null) == r0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x008f, code lost:
        
            return r0;
         */
        @Override // expo.modules.filesystem.fsops.DestinationSink
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object receiveFrom(expo.modules.filesystem.unifiedfile.UnifiedFileInterface r10, kotlin.coroutines.Continuation<? super android.net.Uri> r11) throws expo.modules.kotlin.exception.Exceptions.IllegalArgument, java.io.IOException, expo.modules.kotlin.exception.Exceptions.IllegalStateException {
            /*
                Method dump skipped, instruction units count: 211
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.fsops.DestinationSink.LocalFile.receiveFrom(expo.modules.filesystem.unifiedfile.UnifiedFileInterface, kotlin.coroutines.Continuation):java.lang.Object");
        }

        static final Unit receiveFrom$lambda$0(UnifiedFileInterface src, UnifiedFileInterface dst) throws IOException {
            Intrinsics.checkNotNullParameter(src, "src");
            Intrinsics.checkNotNullParameter(dst, "dst");
            Path path = ((JavaFile) src).toPath();
            Intrinsics.checkNotNullExpressionValue(path, "toPath(...)");
            Path path2 = ((JavaFile) dst).toPath();
            Intrinsics.checkNotNullExpressionValue(path2, "toPath(...)");
            NioUtilitiesKt.copyFileNio(path, path2);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: DestinationSink.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\f¨\u0006\u0012"}, d2 = {"Lexpo/modules/filesystem/fsops/DestinationSink$SAF;", "Lexpo/modules/filesystem/fsops/DestinationSink;", "spec", "Lexpo/modules/filesystem/fsops/DestinationSpec;", TypedValues.Attributes.S_TARGET, "Lexpo/modules/filesystem/unifiedfile/SAFDocumentFile;", "isContainer", "", "<init>", "(Lexpo/modules/filesystem/fsops/DestinationSpec;Lexpo/modules/filesystem/unifiedfile/SAFDocumentFile;Z)V", "getTarget", "()Lexpo/modules/filesystem/unifiedfile/SAFDocumentFile;", "()Z", "receiveFrom", "Landroid/net/Uri;", "source", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "(Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SAF extends DestinationSink {
        private final boolean isContainer;
        private final SAFDocumentFile target;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SAF(DestinationSpec spec, SAFDocumentFile target, boolean z) {
            super(spec, null);
            Intrinsics.checkNotNullParameter(spec, "spec");
            Intrinsics.checkNotNullParameter(target, "target");
            this.target = target;
            this.isContainer = z;
        }

        public /* synthetic */ SAF(DestinationSpec destinationSpec, SAFDocumentFile sAFDocumentFile, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(destinationSpec, sAFDocumentFile, (i & 4) != 0 ? false : z);
        }

        public final SAFDocumentFile getTarget() {
            return this.target;
        }

        /* JADX INFO: renamed from: isContainer, reason: from getter */
        public final boolean getIsContainer() {
            return this.isContainer;
        }

        @Override // expo.modules.filesystem.fsops.DestinationSink
        public Object receiveFrom(UnifiedFileInterface unifiedFileInterface, Continuation<? super Uri> continuation) throws Exceptions.IllegalArgument, Exceptions.IllegalStateException {
            SAFDocumentFile sAFDocumentFileCreateFile;
            SAFDocumentFile sAFDocumentFileCreateDirectory;
            boolean zIsDirectory = unifiedFileInterface.isDirectory();
            boolean z = this.isContainer;
            if (zIsDirectory) {
                if (z) {
                    String fileName = unifiedFileInterface.getFileName();
                    if (fileName == null) {
                        throw new Exceptions.IllegalStateException("Source has no directory name", null, 2, null);
                    }
                    sAFDocumentFileCreateDirectory = this.target.createDirectory(fileName);
                    if (sAFDocumentFileCreateDirectory == null) {
                        throw new Exceptions.IllegalStateException("Failed to create directory: " + fileName, null, 2, null);
                    }
                } else {
                    sAFDocumentFileCreateDirectory = this.target;
                }
                UtilitiesKt.copyDirectoryViaStream(unifiedFileInterface, sAFDocumentFileCreateDirectory);
                return sAFDocumentFileCreateDirectory.getUri();
            }
            if (z) {
                String fileName2 = unifiedFileInterface.getFileName();
                if (fileName2 == null) {
                    throw new Exceptions.IllegalStateException("Source has no file name", null, 2, null);
                }
                String type = unifiedFileInterface.getType();
                if (type == null) {
                    type = "*/*";
                }
                sAFDocumentFileCreateFile = this.target.createFile(type, fileName2);
                if (sAFDocumentFileCreateFile == null) {
                    throw new Exceptions.IllegalStateException("Failed to create file: " + fileName2, null, 2, null);
                }
            } else {
                sAFDocumentFileCreateFile = this.target;
            }
            UtilitiesKt.copyFileWithChannelFallback(unifiedFileInterface, sAFDocumentFileCreateFile);
            return sAFDocumentFileCreateFile.getUri();
        }
    }

    /* JADX INFO: compiled from: DestinationSink.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/filesystem/fsops/DestinationSink$ContentResource;", "Lexpo/modules/filesystem/fsops/DestinationSink;", "spec", "Lexpo/modules/filesystem/fsops/DestinationSpec;", "<init>", "(Lexpo/modules/filesystem/fsops/DestinationSpec;)V", "receiveFrom", "Landroid/net/Uri;", "source", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "(Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ContentResource extends DestinationSink {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContentResource(DestinationSpec spec) {
            super(spec, null);
            Intrinsics.checkNotNullParameter(spec, "spec");
        }

        @Override // expo.modules.filesystem.fsops.DestinationSink
        public Object receiveFrom(UnifiedFileInterface unifiedFileInterface, Continuation<? super Uri> continuation) throws UnableToCopyException {
            throw new UnableToCopyException("Cannot copy to read-only destination");
        }
    }

    /* JADX INFO: compiled from: DestinationSink.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/filesystem/fsops/DestinationSink$Asset;", "Lexpo/modules/filesystem/fsops/DestinationSink;", "spec", "Lexpo/modules/filesystem/fsops/DestinationSpec;", "<init>", "(Lexpo/modules/filesystem/fsops/DestinationSpec;)V", "receiveFrom", "Landroid/net/Uri;", "source", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "(Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Asset extends DestinationSink {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Asset(DestinationSpec spec) {
            super(spec, null);
            Intrinsics.checkNotNullParameter(spec, "spec");
        }

        @Override // expo.modules.filesystem.fsops.DestinationSink
        public Object receiveFrom(UnifiedFileInterface unifiedFileInterface, Continuation<? super Uri> continuation) throws UnableToCopyException {
            throw new UnableToCopyException("Cannot copy to read-only destination");
        }
    }
}
