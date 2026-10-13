package expo.modules.filesystem.fsops;

import android.os.ParcelFileDescriptor;
import androidx.media3.muxer.WebmConstants;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.filesystem.unifiedfile.UnifiedFileInterface;
import expo.modules.kotlin.exception.Exceptions;
import io.ktor.http.ContentDisposition;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* JADX INFO: compiled from: Utilities.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aL\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t26\u0010\n\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\t0\u000bH\u0080\bø\u0001\u0000\u001a\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aD\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u001a\b\u0002\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0080@¢\u0006\u0002\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"copyFileViaStream", "", "source", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "dest", "copyFileViaChannel", "", "copyChannelContents", ContentDisposition.Parameters.Size, "", "transferTo", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", ViewProps.POSITION, "count", "copyFileWithChannelFallback", "copyDirectoryViaStream", "copyDirectoryParallel", "copyFile", "parallelism", "", "(Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;Lkotlin/jvm/functions/Function2;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-file-system_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UtilitiesKt {
    public static final void copyFileViaStream(UnifiedFileInterface source, UnifiedFileInterface dest) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        if (!source.isFile()) {
            throw new IllegalArgumentException("Source must be a file".toString());
        }
        InputStream inputStream = source.inputStream();
        try {
            InputStream inputStream2 = inputStream;
            OutputStream outputStreamOutputStream$default = UnifiedFileInterface.outputStream$default(dest, false, 1, null);
            try {
                ByteStreamsKt.copyTo(inputStream2, outputStreamOutputStream$default, 65536);
                CloseableKt.closeFinally(outputStreamOutputStream$default, null);
                CloseableKt.closeFinally(inputStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(outputStreamOutputStream$default, th);
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

    public static final boolean copyFileViaChannel(UnifiedFileInterface source, UnifiedFileInterface dest) {
        Object objM12684constructorimpl;
        boolean z;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = source.openFileDescriptor("r");
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            return false;
        }
        ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
        try {
            ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor2 = dest.openFileDescriptor("w");
            if (parcelFileDescriptorOpenFileDescriptor2 == null) {
                CloseableKt.closeFinally(parcelFileDescriptor, null);
                return false;
            }
            ParcelFileDescriptor parcelFileDescriptor3 = parcelFileDescriptorOpenFileDescriptor2;
            try {
                ParcelFileDescriptor parcelFileDescriptor4 = parcelFileDescriptor3;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    FileChannel channel = new FileInputStream(parcelFileDescriptor2.getFileDescriptor()).getChannel();
                    try {
                        FileChannel fileChannel = channel;
                        FileChannel channel2 = new FileOutputStream(parcelFileDescriptor4.getFileDescriptor()).getChannel();
                        try {
                            FileChannel fileChannel2 = channel2;
                            long size = fileChannel.size();
                            long j = 0;
                            while (true) {
                                if (j >= size) {
                                    z = true;
                                    break;
                                }
                                long jTransferTo = fileChannel.transferTo(j, size - j, fileChannel2);
                                if (jTransferTo <= 0) {
                                    z = false;
                                    break;
                                }
                                j += jTransferTo;
                            }
                            CloseableKt.closeFinally(channel2, null);
                            CloseableKt.closeFinally(channel, null);
                            objM12684constructorimpl = Result.m12684constructorimpl(Boolean.valueOf(z));
                            if (Result.m12687exceptionOrNullimpl(objM12684constructorimpl) != null) {
                                objM12684constructorimpl = false;
                            }
                            boolean zBooleanValue = ((Boolean) objM12684constructorimpl).booleanValue();
                            CloseableKt.closeFinally(parcelFileDescriptor3, null);
                            CloseableKt.closeFinally(parcelFileDescriptor, null);
                            return zBooleanValue;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(channel2, th);
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CloseableKt.closeFinally(channel, th3);
                            throw th4;
                        }
                    }
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                }
            } catch (Throwable th6) {
                try {
                    throw th6;
                } catch (Throwable th7) {
                    CloseableKt.closeFinally(parcelFileDescriptor3, th6);
                    throw th7;
                }
            }
        } catch (Throwable th8) {
            try {
                throw th8;
            } catch (Throwable th9) {
                CloseableKt.closeFinally(parcelFileDescriptor, th8);
                throw th9;
            }
        }
    }

    public static final boolean copyChannelContents(long j, Function2<? super Long, ? super Long, Long> transferTo) {
        Intrinsics.checkNotNullParameter(transferTo, "transferTo");
        long j2 = 0;
        while (j2 < j) {
            long jLongValue = transferTo.invoke(Long.valueOf(j2), Long.valueOf(j - j2)).longValue();
            if (jLongValue <= 0) {
                return false;
            }
            j2 += jLongValue;
        }
        return true;
    }

    public static final void copyFileWithChannelFallback(UnifiedFileInterface source, UnifiedFileInterface dest) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        if (copyFileViaChannel(source, dest)) {
            return;
        }
        copyFileViaStream(source, dest);
    }

    public static final void copyDirectoryViaStream(UnifiedFileInterface source, UnifiedFileInterface dest) throws Exceptions.IllegalArgument, Exceptions.IllegalStateException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        if (!source.isDirectory()) {
            throw new IllegalArgumentException("Source must be directory".toString());
        }
        if (!dest.isDirectory()) {
            throw new IllegalArgumentException("Dest must be directory".toString());
        }
        for (UnifiedFileInterface unifiedFileInterface : source.listFilesAsUnified()) {
            String fileName = unifiedFileInterface.getFileName();
            if (fileName == null) {
                throw new Exceptions.IllegalArgument("Child has no file name", null, 2, null);
            }
            if (unifiedFileInterface.isDirectory()) {
                UnifiedFileInterface unifiedFileInterfaceCreateDirectory = dest.createDirectory(fileName);
                if (unifiedFileInterfaceCreateDirectory == null) {
                    throw new Exceptions.IllegalStateException("Failed to create directory: " + fileName, null, 2, null);
                }
                copyDirectoryViaStream(unifiedFileInterface, unifiedFileInterfaceCreateDirectory);
            } else {
                String type = unifiedFileInterface.getType();
                if (type == null) {
                    type = "*/*";
                }
                UnifiedFileInterface unifiedFileInterfaceCreateFile = dest.createFile(type, fileName);
                if (unifiedFileInterfaceCreateFile == null) {
                    throw new Exceptions.IllegalStateException("Failed to create file: " + fileName, null, 2, null);
                }
                copyFileWithChannelFallback(unifiedFileInterface, unifiedFileInterfaceCreateFile);
            }
        }
    }

    /* JADX INFO: renamed from: expo.modules.filesystem.fsops.UtilitiesKt$copyDirectoryParallel$2, reason: invalid class name */
    /* JADX INFO: compiled from: Utilities.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<UnifiedFileInterface, UnifiedFileInterface, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(2, UtilitiesKt.class, "copyFileWithChannelFallback", "copyFileWithChannelFallback(Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;)V", 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(UnifiedFileInterface unifiedFileInterface, UnifiedFileInterface unifiedFileInterface2) {
            invoke2(unifiedFileInterface, unifiedFileInterface2);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UnifiedFileInterface p0, UnifiedFileInterface p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            UtilitiesKt.copyFileWithChannelFallback(p0, p1);
        }
    }

    public static /* synthetic */ Object copyDirectoryParallel$default(UnifiedFileInterface unifiedFileInterface, UnifiedFileInterface unifiedFileInterface2, Function2 function2, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function2 = AnonymousClass2.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            i = 4;
        }
        return copyDirectoryParallel(unifiedFileInterface, unifiedFileInterface2, function2, i, continuation);
    }

    /* JADX INFO: renamed from: expo.modules.filesystem.fsops.UtilitiesKt$copyDirectoryParallel$3, reason: invalid class name */
    /* JADX INFO: compiled from: Utilities.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.filesystem.fsops.UtilitiesKt$copyDirectoryParallel$3", f = "Utilities.kt", i = {0, 0}, l = {WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, s = {"L$0", "L$1"})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<UnifiedFileInterface, UnifiedFileInterface, Unit> $copyFile;
        final /* synthetic */ UnifiedFileInterface $dest;
        final /* synthetic */ int $parallelism;
        final /* synthetic */ UnifiedFileInterface $source;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(UnifiedFileInterface unifiedFileInterface, UnifiedFileInterface unifiedFileInterface2, int i, Function2<? super UnifiedFileInterface, ? super UnifiedFileInterface, Unit> function2, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$source = unifiedFileInterface;
            this.$dest = unifiedFileInterface2;
            this.$parallelism = i;
            this.$copyFile = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$source, this.$dest, this.$parallelism, this.$copyFile, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!this.$source.isDirectory()) {
                    throw new IllegalArgumentException("Source must be directory".toString());
                }
                if (!this.$dest.isDirectory()) {
                    throw new IllegalArgumentException("Dest must be directory".toString());
                }
                Semaphore semaphoreSemaphore$default = SemaphoreKt.Semaphore$default(this.$parallelism, 0, 2, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(semaphoreSemaphore$default);
                this.label = 1;
                if (invokeSuspend$walk(semaphoreSemaphore$default, coroutineScope, this.$copyFile, this.$source, this.$dest, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:19:0x00bd  */
        /* JADX WARN: Code duplicated, block: B:21:0x00cb  */
        /* JADX WARN: Code duplicated, block: B:23:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:25:0x00d9  */
        /* JADX WARN: Code duplicated, block: B:28:0x0114  */
        /* JADX WARN: Code duplicated, block: B:35:0x016c  */
        /* JADX WARN: Code duplicated, block: B:38:0x017c  */
        /* JADX WARN: Code duplicated, block: B:41:0x0184 A[Catch: all -> 0x01c4, TryCatch #0 {all -> 0x01c4, blocks: (B:36:0x0176, B:39:0x017e, B:41:0x0184, B:42:0x01ab, B:43:0x01c3), top: B:51:0x0176 }] */
        /* JADX WARN: Code duplicated, block: B:55:0x01c9 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:56:0x0139 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:57:0x0123 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x016b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0016  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x016c -> B:51:0x0176). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public static final java.lang.Object invokeSuspend$walk(kotlinx.coroutines.sync.Semaphore r23, kotlinx.coroutines.CoroutineScope r24, kotlin.jvm.functions.Function2<? super expo.modules.filesystem.unifiedfile.UnifiedFileInterface, ? super expo.modules.filesystem.unifiedfile.UnifiedFileInterface, kotlin.Unit> r25, expo.modules.filesystem.unifiedfile.UnifiedFileInterface r26, expo.modules.filesystem.unifiedfile.UnifiedFileInterface r27, kotlin.coroutines.Continuation<? super kotlin.Unit> r28) {
            /*
                Method dump skipped, instruction units count: 470
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.fsops.UtilitiesKt.AnonymousClass3.invokeSuspend$walk(kotlinx.coroutines.sync.Semaphore, kotlinx.coroutines.CoroutineScope, kotlin.jvm.functions.Function2, expo.modules.filesystem.unifiedfile.UnifiedFileInterface, expo.modules.filesystem.unifiedfile.UnifiedFileInterface, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    public static final Object copyDirectoryParallel(UnifiedFileInterface unifiedFileInterface, UnifiedFileInterface unifiedFileInterface2, Function2<? super UnifiedFileInterface, ? super UnifiedFileInterface, Unit> function2, int i, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass3(unifiedFileInterface, unifiedFileInterface2, i, function2, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }
}
