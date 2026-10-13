package expo.modules.filesystem;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.filesystem.unifiedfile.AssetFile;
import expo.modules.filesystem.unifiedfile.ContentProviderFile;
import expo.modules.filesystem.unifiedfile.JavaFile;
import expo.modules.filesystem.unifiedfile.SAFDocumentFile;
import expo.modules.filesystem.unifiedfile.UnifiedFileInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.services.FilePermissionService;
import expo.modules.kotlin.sharedobjects.SharedObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: FileSystemPath.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0013H&J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0000J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019J\n\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0002J(\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(J\u001e\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00002\u0006\u0010'\u001a\u00020+H\u0086@¢\u0006\u0002\u0010,J\u001e\u0010-\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00002\u0006\u0010'\u001a\u00020+H\u0086@¢\u0006\u0002\u0010,J\u000e\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u001fJ\u0010\u00100\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u001fH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u00101\u001a\u0004\u0018\u0001028F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0013\u00105\u001a\u0004\u0018\u0001028F¢\u0006\u0006\u001a\u0004\b6\u00104¨\u00067"}, d2 = {"Lexpo/modules/filesystem/FileSystemPath;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "setUri", "fileAdapter", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "file", "getFile", "()Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "javaFile", "Ljava/io/File;", "getJavaFile", "()Ljava/io/File;", "delete", "", "validateType", "getMoveOrCopyPath", FirebaseAnalytics.Param.DESTINATION, "validatePermission", "permission", "Lexpo/modules/kotlin/services/FilePermissionService$Permission;", "checkPermission", "", "internalFileServedByOwnProvider", "servesSamePath", "authority", "", "candidate", "rootName", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "checkPermissionForPath", "path", "validateCanCreate", "options", "Lexpo/modules/filesystem/CreateOptions;", "copy", "to", "Lexpo/modules/filesystem/RelocationOptions;", "(Lexpo/modules/filesystem/FileSystemPath;Lexpo/modules/filesystem/RelocationOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "move", "rename", "newName", "renamedUri", "modificationTime", "", "getModificationTime", "()Ljava/lang/Long;", "creationTime", "getCreationTime", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FileSystemPath extends SharedObject {
    private UnifiedFileInterface fileAdapter;
    private Uri uri;

    /* JADX INFO: renamed from: expo.modules.filesystem.FileSystemPath$move$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileSystemPath.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.filesystem.FileSystemPath", f = "FileSystemPath.kt", i = {0, 0}, l = {244}, m = "move", n = {"to", "options"}, s = {"L$0", "L$1"})
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
            return FileSystemPath.this.move(null, null, this);
        }
    }

    public abstract void validateType();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemPath(Uri uri) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void setUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<set-?>");
        this.uri = uri;
    }

    public final UnifiedFileInterface getFile() throws Exceptions.ReactContextLost {
        Context reactContext;
        JavaFile assetFile;
        UnifiedFileInterface unifiedFileInterface = this.fileAdapter;
        if (Intrinsics.areEqual(unifiedFileInterface != null ? unifiedFileInterface.getUri() : null, this.uri)) {
            return unifiedFileInterface;
        }
        AppContext appContext = getAppContext();
        if (appContext == null || (reactContext = appContext.getReactContext()) == null) {
            throw new Exceptions.ReactContextLost();
        }
        if (FileSystemPathKt.isSAFUri(this.uri, reactContext)) {
            assetFile = new SAFDocumentFile(reactContext, this.uri);
        } else if (FileSystemPathKt.isContentUri(this.uri)) {
            assetFile = new ContentProviderFile(reactContext, this.uri);
        } else {
            assetFile = FileSystemPathKt.isAssetUri(this.uri) ? new AssetFile(reactContext, this.uri) : new JavaFile(this.uri);
        }
        this.fileAdapter = assetFile;
        return assetFile;
    }

    public final File getJavaFile() throws Exception {
        if (FileSystemPathKt.isContentUri(this.uri)) {
            throw new Exception("This method cannot be used with content URIs: " + this.uri);
        }
        Object file = getFile();
        Intrinsics.checkNotNull(file, "null cannot be cast to non-null type java.io.File");
        return (File) file;
    }

    public final void delete() throws UnableToDeleteException, InvalidPermissionException {
        validatePermission(FilePermissionService.Permission.WRITE);
        if (!getFile().exists()) {
            throw new UnableToDeleteException("uri '" + getFile().getUri() + "' does not exist");
        }
        if (getFile().isDirectory()) {
            if (getFile().deleteRecursively()) {
                return;
            }
            throw new UnableToDeleteException("failed to delete '" + getFile().getUri() + "'");
        }
        if (getFile().delete()) {
            return;
        }
        throw new UnableToDeleteException("failed to delete '" + getFile().getUri() + "'");
    }

    public final File getMoveOrCopyPath(FileSystemPath destination) throws CopyOrMoveDirectoryToFileException, DestinationDoesNotExistException {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination instanceof FileSystemDirectory) {
            if (this instanceof FileSystemFile) {
                if (!((FileSystemDirectory) destination).getExists()) {
                    throw new DestinationDoesNotExistException();
                }
                return new File(destination.getJavaFile(), getJavaFile().getName());
            }
            if (((FileSystemDirectory) destination).getExists()) {
                return new File(destination.getJavaFile(), getJavaFile().getName());
            }
            File parentFile = destination.getJavaFile().getParentFile();
            if (parentFile == null || !parentFile.exists()) {
                throw new DestinationDoesNotExistException();
            }
            return destination.getJavaFile();
        }
        if (!(this instanceof FileSystemFile)) {
            throw new CopyOrMoveDirectoryToFileException();
        }
        File parentFile2 = destination.getJavaFile().getParentFile();
        if (parentFile2 == null || !parentFile2.exists()) {
            throw new DestinationDoesNotExistException();
        }
        return destination.getJavaFile();
    }

    public final void validatePermission(FilePermissionService.Permission permission) throws InvalidPermissionException {
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (!checkPermission(permission)) {
            throw new InvalidPermissionException(permission);
        }
    }

    public final boolean checkPermission(FilePermissionService.Permission permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (FileSystemPathKt.isContentUri(this.uri)) {
            try {
                File fileInternalFileServedByOwnProvider = internalFileServedByOwnProvider();
                if (fileInternalFileServedByOwnProvider == null) {
                    return true;
                }
                String path = fileInternalFileServedByOwnProvider.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                return checkPermissionForPath(path, permission);
            } catch (IOException unused) {
                return false;
            }
        }
        if (FileSystemPathKt.isAssetUri(this.uri)) {
            return true;
        }
        String path2 = getJavaFile().getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
        return checkPermissionForPath(path2, permission);
    }

    private final File internalFileServedByOwnProvider() {
        Context reactContext;
        String authority;
        String strSubstringAfterLast$default;
        ProviderInfo providerInfoResolveContentProvider;
        Object next;
        File file;
        AppContext appContext = getAppContext();
        if (appContext == null || (reactContext = appContext.getReactContext()) == null || (authority = this.uri.getAuthority()) == null || (strSubstringAfterLast$default = StringsKt.substringAfterLast$default(authority, '@', (String) null, 2, (Object) null)) == null || (providerInfoResolveContentProvider = reactContext.getPackageManager().resolveContentProvider(strSubstringAfterLast$default, 0)) == null || !Intrinsics.areEqual(providerInfoResolveContentProvider.packageName, reactContext.getPackageName())) {
            return null;
        }
        List<String> pathSegments = this.uri.getPathSegments();
        if (pathSegments.size() < 2) {
            return null;
        }
        Intrinsics.checkNotNull(pathSegments);
        String str = (String) CollectionsKt.first((List) pathSegments);
        final String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.drop(pathSegments, 1), DomExceptionUtils.SEPARATOR, null, null, 0, null, null, 62, null);
        Iterator it = SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(CollectionsKt.listOf((Object[]) new File[]{reactContext.getFilesDir(), reactContext.getCacheDir()})), new Function1() { // from class: expo.modules.filesystem.FileSystemPath$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                File file2 = (File) obj;
                return TuplesKt.to(file2, new File(file2, strJoinToString$default).getCanonicalFile());
            }
        }), new Function1() { // from class: expo.modules.filesystem.FileSystemPath$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(FileSystemPath.internalFileServedByOwnProvider$lambda$2((Pair) obj));
            }
        }).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            file = (File) ((Pair) next).component2();
            Intrinsics.checkNotNull(file);
            Intrinsics.checkNotNull(str);
        } while (!servesSamePath(strSubstringAfterLast$default, file, str, reactContext));
        Pair pair = (Pair) next;
        if (pair != null) {
            return (File) pair.getSecond();
        }
        return null;
    }

    static final boolean internalFileServedByOwnProvider$lambda$2(Pair pair) throws IOException {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        File file = (File) pair.component1();
        String path = ((File) pair.component2()).getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return StringsKt.startsWith$default(path, file.getCanonicalPath() + DomExceptionUtils.SEPARATOR, false, 2, (Object) null);
    }

    private final boolean servesSamePath(String authority, File candidate, String rootName, Context context) {
        try {
            List<String> pathSegments = FileProvider.getUriForFile(context, authority, candidate).getPathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments, "getPathSegments(...)");
            return Intrinsics.areEqual(CollectionsKt.firstOrNull((List) pathSegments), rootName);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0025  */
    private final boolean checkPermissionForPath(String path, FilePermissionService.Permission permission) throws Exceptions.ReactContextLost {
        EnumSet<FilePermissionService.Permission> enumSetNoneOf;
        FilePermissionService filePermission;
        Context reactContext;
        AppContext appContext = getAppContext();
        if (appContext != null && (filePermission = appContext.getFilePermission()) != null) {
            AppContext appContext2 = getAppContext();
            if (appContext2 != null && (reactContext = appContext2.getReactContext()) != null) {
                enumSetNoneOf = filePermission.getPathPermissions(reactContext, path);
                if (enumSetNoneOf == null) {
                    enumSetNoneOf = EnumSet.noneOf(FilePermissionService.Permission.class);
                }
            } else {
                throw new Exceptions.ReactContextLost();
            }
        } else {
            enumSetNoneOf = EnumSet.noneOf(FilePermissionService.Permission.class);
        }
        return enumSetNoneOf.contains(permission);
    }

    public final void validateCanCreate(CreateOptions options) throws UnableToCreateException {
        Intrinsics.checkNotNullParameter(options, "options");
        if (!options.getOverwrite() && getFile().exists()) {
            throw new UnableToCreateException("it already exists");
        }
    }

    public final Object copy(FileSystemPath fileSystemPath, RelocationOptions relocationOptions, Continuation<? super Unit> continuation) throws InvalidPermissionException {
        validateType();
        fileSystemPath.validateType();
        validatePermission(FilePermissionService.Permission.READ);
        fileSystemPath.validatePermission(FilePermissionService.Permission.WRITE);
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(fileSystemPath, relocationOptions, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: expo.modules.filesystem.FileSystemPath$copy$2, reason: invalid class name */
    /* JADX INFO: compiled from: FileSystemPath.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.filesystem.FileSystemPath$copy$2", f = "FileSystemPath.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RelocationOptions $options;
        final /* synthetic */ FileSystemPath $to;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(FileSystemPath fileSystemPath, RelocationOptions relocationOptions, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$to = fileSystemPath;
            this.$options = relocationOptions;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileSystemPath.this.new AnonymousClass2(this.$to, this.$options, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FileSystemPath.this.getFile().copyTo(FileSystemPathKt.asCopyOrMoveDestination(this.$to, this.$options.getOverwrite()), this) == coroutine_suspended) {
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
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object move(FileSystemPath fileSystemPath, RelocationOptions relocationOptions, Continuation<? super Unit> continuation) throws InvalidPermissionException {
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
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            validateType();
            fileSystemPath.validateType();
            validatePermission(FilePermissionService.Permission.WRITE);
            fileSystemPath.validatePermission(FilePermissionService.Permission.WRITE);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            FileSystemPath$move$finalUri$1 fileSystemPath$move$finalUri$1 = new FileSystemPath$move$finalUri$1(this, fileSystemPath, relocationOptions, null);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fileSystemPath);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(relocationOptions);
            anonymousClass1.label = 1;
            objWithContext = BuildersKt.withContext(io2, fileSystemPath$move$finalUri$1, anonymousClass1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        this.uri = (Uri) objWithContext;
        return Unit.INSTANCE;
    }

    public final void rename(String newName) throws IOException, UnableToCreateException, InvalidPermissionException {
        Intrinsics.checkNotNullParameter(newName, "newName");
        validateType();
        validatePermission(FilePermissionService.Permission.WRITE);
        FileSystemPathKt.validateFileSystemChildName(newName);
        File parentFile = getJavaFile().getParentFile();
        if (parentFile == null) {
            throw new UnableToCreateException("parent directory does not exist");
        }
        String canonicalPath = parentFile.getCanonicalPath();
        File file = new File(parentFile, newName);
        File parentFile2 = file.getCanonicalFile().getParentFile();
        if (!Intrinsics.areEqual(parentFile2 != null ? parentFile2.getCanonicalPath() : null, canonicalPath)) {
            throw new UnableToCreateException("child path escapes parent directory");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            Path path = getJavaFile().toPath();
            Intrinsics.checkNotNullExpressionValue(path, "toPath(...)");
            Path path2 = file.toPath();
            Intrinsics.checkNotNullExpressionValue(path2, "toPath(...)");
            Intrinsics.checkNotNullExpressionValue(Files.move(path, path2, (CopyOption[]) Arrays.copyOf(new CopyOption[0], 0)), "move(...)");
        } else {
            FilesKt.copyTo$default(getJavaFile(), file, false, 0, 6, null);
            Boolean.valueOf(getJavaFile().delete());
        }
        this.uri = renamedUri(newName);
    }

    private final Uri renamedUri(String newName) {
        String string = this.uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String strSubstring = string.substring(0, StringsKt.lastIndexOf$default((CharSequence) StringsKt.trimEnd(string, '/'), '/', 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String string2 = Uri.parse(strSubstring).buildUpon().appendPath(newName).build().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        if (this instanceof FileSystemDirectory) {
            string2 = string2 + DomExceptionUtils.SEPARATOR;
        }
        Uri uri = Uri.parse(string2);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        return uri;
    }

    public final Long getModificationTime() {
        validateType();
        return getFile().lastModified();
    }

    public final Long getCreationTime() {
        return getFile().getCreationTime();
    }
}
