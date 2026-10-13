package expo.modules.filesystem.unifiedfile;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.documentfile.provider.DocumentFile;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.filesystem.fsops.CopyMoveStrategy;
import expo.modules.filesystem.fsops.DestinationSpec;
import expo.modules.kotlin.AppContext;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: SAFDocumentFile.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001dH\u0016J\u000f\u0010!\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0002\u0010#J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u000fH\u0016J\b\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u0017H\u0016J\b\u00103\u001a\u00020\"H\u0016J\u0010\u00104\u001a\u0004\u0018\u00010\u00002\u0006\u00105\u001a\u00020\u0017J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\u000007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010 R\u0016\u0010)\u001a\u0004\u0018\u00010\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010#R\u0014\u00108\u001a\u000209X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lexpo/modules/filesystem/unifiedfile/SAFDocumentFile;", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/content/Context;Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "documentFile", "Landroidx/documentfile/provider/DocumentFile;", "getDocumentFile", "()Landroidx/documentfile/provider/DocumentFile;", "exists", "", "isDirectory", "isFile", "parentFile", "getParentFile", "()Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "createFile", "mimeType", "", "displayName", "createDirectory", "delete", "deleteRecursively", "listFilesAsUnified", "", "type", "getType", "()Ljava/lang/String;", "lastModified", "", "()Ljava/lang/Long;", "fileName", "getFileName", "getContentUri", "appContext", "Lexpo/modules/kotlin/AppContext;", "creationTime", "getCreationTime", "outputStream", "Ljava/io/OutputStream;", "append", "inputStream", "Ljava/io/InputStream;", "openFileDescriptor", "Landroid/os/ParcelFileDescriptor;", "mode", "length", "findFile", "name", "walkTopDown", "Lkotlin/sequences/Sequence;", "copyMoveStrategy", "Lexpo/modules/filesystem/fsops/CopyMoveStrategy;", "getCopyMoveStrategy", "()Lexpo/modules/filesystem/fsops/CopyMoveStrategy;", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SAFDocumentFile implements UnifiedFileInterface {
    private final Context context;
    private final CopyMoveStrategy copyMoveStrategy;
    private final Uri uri;

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Long getCreationTime() {
        return null;
    }

    public SAFDocumentFile(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.context = context;
        this.uri = uri;
        this.copyMoveStrategy = new CopyMoveStrategy.SAF(this, context);
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Object copyTo(DestinationSpec destinationSpec, Continuation<? super Unit> continuation) {
        return super.copyTo(destinationSpec, continuation);
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Uri getUri() {
        return this.uri;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Object moveTo(DestinationSpec destinationSpec, Continuation<? super Uri> continuation) {
        return super.moveTo(destinationSpec, continuation);
    }

    public final DocumentFile getDocumentFile() {
        List<String> pathSegments = getUri().getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "getPathSegments(...)");
        String str = (String) CollectionsKt.getOrNull(pathSegments, 0);
        if (str == null) {
            str = "tree";
        }
        boolean zAreEqual = Intrinsics.areEqual(str, "document");
        Context context = this.context;
        if (zAreEqual) {
            return DocumentFile.fromSingleUri(context, getUri());
        }
        return DocumentFile.fromTreeUri(context, getUri());
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean exists() {
        DocumentFile documentFile = getDocumentFile();
        return documentFile != null && documentFile.exists();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean isDirectory() {
        DocumentFile documentFile = getDocumentFile();
        return documentFile != null && documentFile.isDirectory();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean isFile() {
        DocumentFile documentFile = getDocumentFile();
        return documentFile != null && documentFile.isFile();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public UnifiedFileInterface getParentFile() {
        DocumentFile parentFile;
        Uri uri;
        DocumentFile documentFile = getDocumentFile();
        return (documentFile == null || (parentFile = documentFile.getParentFile()) == null || (uri = parentFile.getUri()) == null) ? null : new SAFDocumentFile(this.context, uri);
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public UnifiedFileInterface createFile(String mimeType, String displayName) {
        Uri uri;
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        DocumentFile documentFile = getDocumentFile();
        SAFDocumentFile sAFDocumentFile = null;
        DocumentFile documentFileCreateFile = documentFile != null ? documentFile.createFile(mimeType, displayName) : null;
        if (documentFileCreateFile != null && (uri = documentFileCreateFile.getUri()) != null) {
            sAFDocumentFile = new SAFDocumentFile(this.context, uri);
        }
        return sAFDocumentFile;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public UnifiedFileInterface createDirectory(String displayName) {
        Uri uri;
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        DocumentFile documentFile = getDocumentFile();
        SAFDocumentFile sAFDocumentFile = null;
        DocumentFile documentFileCreateDirectory = documentFile != null ? documentFile.createDirectory(displayName) : null;
        if (documentFileCreateDirectory != null && (uri = documentFileCreateDirectory.getUri()) != null) {
            sAFDocumentFile = new SAFDocumentFile(this.context, uri);
        }
        return sAFDocumentFile;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean delete() {
        DocumentFile documentFile = getDocumentFile();
        return documentFile != null && documentFile.delete();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean deleteRecursively() {
        DocumentFile documentFile = getDocumentFile();
        return documentFile != null && SAFDocumentFileKt.deleteRecursively(documentFile);
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public List<UnifiedFileInterface> listFilesAsUnified() {
        DocumentFile[] documentFileArrListFiles;
        DocumentFile documentFile = getDocumentFile();
        if (documentFile == null || (documentFileArrListFiles = documentFile.listFiles()) == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(documentFileArrListFiles.length);
        for (DocumentFile documentFile2 : documentFileArrListFiles) {
            Context context = this.context;
            Uri uri = documentFile2.getUri();
            Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
            arrayList.add(new SAFDocumentFile(context, uri));
        }
        return arrayList;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public String getType() {
        DocumentFile documentFile = getDocumentFile();
        if (documentFile != null) {
            return documentFile.getType();
        }
        return null;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Long lastModified() {
        DocumentFile documentFile = getDocumentFile();
        if (documentFile != null) {
            return Long.valueOf(documentFile.lastModified());
        }
        return null;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public String getFileName() {
        DocumentFile documentFile = getDocumentFile();
        if (documentFile != null) {
            return documentFile.getName();
        }
        return null;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Uri getContentUri(AppContext appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        return getUri();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public OutputStream outputStream(boolean append) throws FileNotFoundException {
        String str;
        if (append) {
            str = "wa";
        } else {
            str = "w";
        }
        OutputStream outputStreamOpenOutputStream = this.context.getContentResolver().openOutputStream(getUri(), str);
        if (outputStreamOpenOutputStream != null) {
            return outputStreamOpenOutputStream;
        }
        throw new IllegalStateException("Unable to open output stream for URI: " + getUri());
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public InputStream inputStream() throws FileNotFoundException {
        InputStream inputStreamOpenInputStream = this.context.getContentResolver().openInputStream(getUri());
        if (inputStreamOpenInputStream != null) {
            return inputStreamOpenInputStream;
        }
        throw new IllegalStateException("Unable to open input stream for URI: " + getUri());
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public ParcelFileDescriptor openFileDescriptor(String mode) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(mode, "mode");
        try {
            Result.Companion companion = Result.INSTANCE;
            SAFDocumentFile sAFDocumentFile = this;
            objM12684constructorimpl = Result.m12684constructorimpl(this.context.getContentResolver().openFileDescriptor(getUri(), mode));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        return (ParcelFileDescriptor) objM12684constructorimpl;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public long length() {
        DocumentFile documentFile = getDocumentFile();
        if (documentFile != null) {
            return documentFile.length();
        }
        return 0L;
    }

    public final SAFDocumentFile findFile(String name) {
        DocumentFile documentFileFindFile;
        Intrinsics.checkNotNullParameter(name, "name");
        DocumentFile documentFile = getDocumentFile();
        if (documentFile == null || (documentFileFindFile = documentFile.findFile(name)) == null) {
            return null;
        }
        Context context = this.context;
        Uri uri = documentFileFindFile.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
        return new SAFDocumentFile(context, uri);
    }

    /* JADX INFO: renamed from: expo.modules.filesystem.unifiedfile.SAFDocumentFile$walkTopDown$1, reason: invalid class name */
    /* JADX INFO: compiled from: SAFDocumentFile.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lexpo/modules/filesystem/unifiedfile/SAFDocumentFile;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.filesystem.unifiedfile.SAFDocumentFile$walkTopDown$1", f = "SAFDocumentFile.kt", i = {0, 1, 1, 1, 1, 1, 1}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 111}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "$this$forEach$iv", "element$iv", "child", "$i$f$forEach", "$i$a$-forEach-SAFDocumentFile$walkTopDown$1$1"}, s = {"L$0", "L$0", "L$1", "L$3", "L$4", "I$0", "I$3"})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super SAFDocumentFile>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = SAFDocumentFile.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super SAFDocumentFile> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x006d  */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x004a, code lost:
        
            if (r0.yield(r14.this$0, r14) == r1) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00a5, code lost:
        
            if (r0.yieldAll(r10, r14) == r1) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a7, code lost:
        
            return r1;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00a5 -> B:24:0x00a8). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = r14.L$0
                kotlin.sequences.SequenceScope r0 = (kotlin.sequences.SequenceScope) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r14.label
                r3 = 2
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L3a
                if (r2 == r5) goto L36
                if (r2 != r3) goto L2e
                int r2 = r14.I$2
                int r6 = r14.I$1
                int r7 = r14.I$0
                java.lang.Object r8 = r14.L$4
                androidx.documentfile.provider.DocumentFile r8 = (androidx.documentfile.provider.DocumentFile) r8
                java.lang.Object r8 = r14.L$3
                androidx.documentfile.provider.DocumentFile r8 = (androidx.documentfile.provider.DocumentFile) r8
                java.lang.Object r8 = r14.L$2
                expo.modules.filesystem.unifiedfile.SAFDocumentFile r8 = (expo.modules.filesystem.unifiedfile.SAFDocumentFile) r8
                java.lang.Object r9 = r14.L$1
                androidx.documentfile.provider.DocumentFile[] r9 = (androidx.documentfile.provider.DocumentFile[]) r9
                kotlin.ResultKt.throwOnFailure(r15)
                goto La8
            L2e:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r15)
                throw r14
            L36:
                kotlin.ResultKt.throwOnFailure(r15)
                goto L4d
            L3a:
                kotlin.ResultKt.throwOnFailure(r15)
                expo.modules.filesystem.unifiedfile.SAFDocumentFile r15 = expo.modules.filesystem.unifiedfile.SAFDocumentFile.this
                r2 = r14
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r14.L$0 = r0
                r14.label = r5
                java.lang.Object r15 = r0.yield(r15, r2)
                if (r15 != r1) goto L4d
                goto La7
            L4d:
                expo.modules.filesystem.unifiedfile.SAFDocumentFile r15 = expo.modules.filesystem.unifiedfile.SAFDocumentFile.this
                boolean r15 = r15.isDirectory()
                if (r15 == 0) goto Laa
                expo.modules.filesystem.unifiedfile.SAFDocumentFile r15 = expo.modules.filesystem.unifiedfile.SAFDocumentFile.this
                androidx.documentfile.provider.DocumentFile r15 = r15.getDocumentFile()
                if (r15 == 0) goto Laa
                androidx.documentfile.provider.DocumentFile[] r15 = r15.listFiles()
                if (r15 == 0) goto Laa
                expo.modules.filesystem.unifiedfile.SAFDocumentFile r2 = expo.modules.filesystem.unifiedfile.SAFDocumentFile.this
                int r6 = r15.length
                r9 = r15
                r8 = r2
                r7 = r4
                r2 = r6
                r6 = r7
            L6b:
                if (r6 >= r2) goto Laa
                r15 = r9[r6]
                expo.modules.filesystem.unifiedfile.SAFDocumentFile r10 = new expo.modules.filesystem.unifiedfile.SAFDocumentFile
                android.content.Context r11 = expo.modules.filesystem.unifiedfile.SAFDocumentFile.access$getContext$p(r8)
                android.net.Uri r12 = r15.getUri()
                java.lang.String r13 = "getUri(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
                r10.<init>(r11, r12)
                kotlin.sequences.Sequence r10 = r10.walkTopDown()
                r14.L$0 = r0
                r14.L$1 = r9
                r14.L$2 = r8
                java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
                r14.L$3 = r11
                java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
                r14.L$4 = r15
                r14.I$0 = r7
                r14.I$1 = r6
                r14.I$2 = r2
                r14.I$3 = r4
                r14.label = r3
                java.lang.Object r15 = r0.yieldAll(r10, r14)
                if (r15 != r1) goto La8
            La7:
                return r1
            La8:
                int r6 = r6 + r5
                goto L6b
            Laa:
                kotlin.Unit r14 = kotlin.Unit.INSTANCE
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.unifiedfile.SAFDocumentFile.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Sequence<SAFDocumentFile> walkTopDown() {
        return SequencesKt.sequence(new AnonymousClass1(null));
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public CopyMoveStrategy getCopyMoveStrategy() {
        return this.copyMoveStrategy;
    }
}
