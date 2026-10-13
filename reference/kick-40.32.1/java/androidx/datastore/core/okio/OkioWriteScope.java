package androidx.datastore.core.okio;

import androidx.datastore.core.WriteScope;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imageutils.JfifUtil;
import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.FileHandle;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

/* JADX INFO: compiled from: OkioStorage.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/datastore/core/okio/OkioWriteScope;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/okio/OkioReadScope;", "Landroidx/datastore/core/WriteScope;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;)V", "writeData", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OkioWriteScope<T> extends OkioReadScope<T> implements WriteScope<T> {

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioWriteScope$writeData$1, reason: invalid class name */
    /* JADX INFO: compiled from: OkioStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.okio.OkioWriteScope", f = "OkioStorage.kt", i = {0, 0, 0}, l = {JfifUtil.MARKER_SOI}, m = "writeData", n = {"$this$use$iv", "handle", "$this$use$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OkioWriteScope<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(OkioWriteScope<T> okioWriteScope, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = okioWriteScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.writeData(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioWriteScope(FileSystem fileSystem, Path path, OkioSerializer<T> serializer) {
        super(fileSystem, path, serializer);
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.datastore.core.WriteScope
    public Object writeData(T t, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        FileHandle fileHandleOpenReadWrite;
        Closeable closeable;
        Closeable closeable2;
        FileHandle fileHandle;
        Unit unit;
        Throwable th;
        Unit unit2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        Throwable th2 = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            checkClose();
            fileHandleOpenReadWrite = getFileSystem().openReadWrite(getPath());
            try {
                FileHandle fileHandle2 = fileHandleOpenReadWrite;
                BufferedSink bufferedSinkBuffer = Okio.buffer(FileHandle.sink$default(fileHandle2, 0L, 1, null));
                try {
                    OkioSerializer<T> serializer = getSerializer();
                    anonymousClass1.L$0 = fileHandleOpenReadWrite;
                    anonymousClass1.L$1 = fileHandle2;
                    anonymousClass1.L$2 = bufferedSinkBuffer;
                    anonymousClass1.label = 1;
                    if (serializer.writeTo(t, bufferedSinkBuffer, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    closeable = fileHandleOpenReadWrite;
                    fileHandle = fileHandle2;
                    closeable2 = bufferedSinkBuffer;
                } catch (Throwable th3) {
                    th = th3;
                    closeable = fileHandleOpenReadWrite;
                    closeable2 = bufferedSinkBuffer;
                    if (closeable2 != null) {
                        closeable2.close();
                    }
                    th = th;
                    unit2 = null;
                }
            } catch (Throwable th4) {
                th = th4;
                if (fileHandleOpenReadWrite != null) {
                    fileHandleOpenReadWrite.close();
                }
                th2 = th;
                unit = null;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            closeable2 = (Closeable) anonymousClass1.L$2;
            fileHandle = (FileHandle) anonymousClass1.L$1;
            closeable = (Closeable) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th5) {
                th = th5;
                if (closeable2 != null) {
                    try {
                        closeable2.close();
                    } catch (Throwable th6) {
                        try {
                            ExceptionsKt.addSuppressed(th, th6);
                        } catch (Throwable th7) {
                            th = th7;
                            fileHandleOpenReadWrite = closeable;
                            if (fileHandleOpenReadWrite != null) {
                                try {
                                    fileHandleOpenReadWrite.close();
                                } catch (Throwable th8) {
                                    ExceptionsKt.addSuppressed(th, th8);
                                }
                            }
                            th2 = th;
                            unit = null;
                        }
                    }
                }
                th = th;
                unit2 = null;
            }
        }
        fileHandle.flush();
        unit2 = Unit.INSTANCE;
        if (closeable2 != null) {
            try {
                closeable2.close();
            } catch (Throwable th9) {
                th = th9;
            }
        }
        th = null;
        Closeable closeable3 = closeable;
        if (th != null) {
            throw th;
        }
        Intrinsics.checkNotNull(unit2);
        unit = Unit.INSTANCE;
        if (closeable3 != null) {
            try {
                closeable3.close();
            } catch (Throwable th10) {
                th2 = th10;
            }
        }
        if (th2 != null) {
            throw th2;
        }
        Intrinsics.checkNotNull(unit);
        return Unit.INSTANCE;
    }
}
