package com.facebook.cache.disk;

import android.os.Environment;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.CountingOutputStream;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.react.uimanager.events.PointerEventHelper;
import com.google.android.gms.actions.SearchIntents;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: DefaultDiskStorage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 C2\u00020\u0001:\b<=>?@ABCB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0007J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u001c\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0016J\u0014\u0010%\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010&\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010'\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u0010(\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010'\u001a\u00020\fH\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\u0003H\u0002J\b\u0010/\u001a\u00020\u0016H\u0016J\b\u00100\u001a\u000201H\u0016J\u0012\u00102\u001a\u0002032\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0010\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u000206H\u0002J\u000e\u00107\u001a\b\u0012\u0004\u0012\u00020,08H\u0016J\u0014\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010\u0003H\u0002R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/facebook/cache/disk/DefaultDiskStorage;", "Lcom/facebook/cache/disk/DiskStorage;", "rootDirectory", "Ljava/io/File;", "version", "", "cacheErrorLogger", "Lcom/facebook/cache/common/CacheErrorLogger;", "<init>", "(Ljava/io/File;ILcom/facebook/cache/common/CacheErrorLogger;)V", "mRootDirectory", "mIsExternal", "", "mVersionDirectory", "mCacheErrorLogger", "mClock", "Lcom/facebook/common/time/Clock;", "isEnabled", "isExternal", "getStorageName", "", "recreateDirectoryIfVersionChanges", "", "getContentFileFor", "resourceId", "getSubdirectoryPath", "getSubdirectory", "purgeUnexpectedResources", "mkdirs", "directory", "message", "insert", "Lcom/facebook/cache/disk/DiskStorage$Inserter;", "debugInfo", "", "getResource", "Lcom/facebook/binaryresource/BinaryResource;", "getFilename", "contains", PointerEventHelper.POINTER_TYPE_TOUCH, SearchIntents.EXTRA_QUERY, "remove", "", "entry", "Lcom/facebook/cache/disk/DiskStorage$Entry;", "doRemove", "contentFile", "clearAll", "getDumpInfo", "Lcom/facebook/cache/disk/DiskStorage$DiskDumpInfo;", "dumpCacheEntry", "Lcom/facebook/cache/disk/DiskStorage$DiskDumpInfoEntry;", "typeOfBytes", "bytes", "", "getEntries", "", "getShardFileInfo", "Lcom/facebook/cache/disk/DefaultDiskStorage$FileInfo;", "file", "IncompleteFileException", "EntriesCollector", "PurgingVisitor", "EntryImpl", "FileType", "FileInfo", "InserterImpl", "Companion", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DefaultDiskStorage implements DiskStorage {
    private static final String CONTENT_FILE_EXTENSION = ".cnt";
    private static final String DEFAULT_DISK_STORAGE_VERSION_PREFIX = "v2";
    private static final int SHARDING_BUCKET_COUNT = 100;
    private static final String TEMP_FILE_EXTENSION = ".tmp";
    private static final long TEMP_FILE_LIFETIME_MS;
    private final CacheErrorLogger mCacheErrorLogger;
    private final Clock mClock;
    private final boolean mIsExternal;
    private final File mRootDirectory;
    private final File mVersionDirectory;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Class<?> TAG = DefaultDiskStorage.class;

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isEnabled() {
        return true;
    }

    public DefaultDiskStorage(File rootDirectory, int i, CacheErrorLogger cacheErrorLogger) {
        Intrinsics.checkNotNullParameter(rootDirectory, "rootDirectory");
        Intrinsics.checkNotNullParameter(cacheErrorLogger, "cacheErrorLogger");
        this.mRootDirectory = rootDirectory;
        Companion companion = INSTANCE;
        this.mIsExternal = companion.isExternal(rootDirectory, cacheErrorLogger);
        this.mVersionDirectory = new File(rootDirectory, companion.getVersionSubdirectoryName(i));
        this.mCacheErrorLogger = cacheErrorLogger;
        recreateDirectoryIfVersionChanges();
        SystemClock systemClock = SystemClock.get();
        Intrinsics.checkNotNullExpressionValue(systemClock, "get(...)");
        this.mClock = systemClock;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    /* JADX INFO: renamed from: isExternal, reason: from getter */
    public boolean getMIsExternal() {
        return this.mIsExternal;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public String getStorageName() {
        String absolutePath = this.mRootDirectory.getAbsolutePath();
        Intrinsics.checkNotNull(absolutePath);
        String strSubstring = absolutePath.substring(StringsKt.lastIndexOf$default((CharSequence) absolutePath, '/', 0, false, 6, (Object) null) + 1, absolutePath.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return "_" + strSubstring + "_" + absolutePath.hashCode();
    }

    private final void recreateDirectoryIfVersionChanges() {
        if (this.mRootDirectory.exists()) {
            if (this.mVersionDirectory.exists()) {
                return;
            } else {
                FileTree.deleteRecursively(this.mRootDirectory);
            }
        }
        try {
            FileUtils.mkdirs(this.mVersionDirectory);
        } catch (FileUtils.CreateDirectoryException unused) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "version directory could not be created: " + this.mVersionDirectory, null);
        }
    }

    /* JADX INFO: compiled from: DefaultDiskStorage.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/cache/disk/DefaultDiskStorage$IncompleteFileException;", "Ljava/io/IOException;", "expected", "", "actual", "<init>", "(JJ)V", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class IncompleteFileException extends IOException {
        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
        }
    }

    public final File getContentFileFor(String resourceId) {
        return new File(getFilename(resourceId));
    }

    private final String getSubdirectoryPath(String resourceId) {
        String strValueOf = String.valueOf(Math.abs(resourceId.hashCode() % 100));
        return this.mVersionDirectory + File.separator + strValueOf;
    }

    private final File getSubdirectory(String resourceId) {
        Intrinsics.checkNotNull(resourceId);
        return new File(getSubdirectoryPath(resourceId));
    }

    /* JADX INFO: compiled from: DefaultDiskStorage.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/facebook/cache/disk/DefaultDiskStorage$EntriesCollector;", "Lcom/facebook/common/file/FileTreeVisitor;", "<init>", "(Lcom/facebook/cache/disk/DefaultDiskStorage;)V", "result", "", "Lcom/facebook/cache/disk/DiskStorage$Entry;", "preVisitDirectory", "", "directory", "Ljava/io/File;", "visitFile", "file", "postVisitDirectory", "entries", "getEntries", "()Ljava/util/List;", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class EntriesCollector implements FileTreeVisitor {
        private final List<DiskStorage.Entry> result = new ArrayList();

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File directory) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File directory) {
        }

        public EntriesCollector() {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(File file) {
            FileInfo shardFileInfo = DefaultDiskStorage.this.getShardFileInfo(file);
            if (shardFileInfo == null || shardFileInfo.getType() != ".cnt") {
                return;
            }
            this.result.add(new EntryImpl(shardFileInfo.getResourceId(), file));
        }

        public final List<DiskStorage.Entry> getEntries() {
            List<DiskStorage.Entry> listUnmodifiableList = Collections.unmodifiableList(this.result);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(...)");
            return listUnmodifiableList;
        }
    }

    /* JADX INFO: compiled from: DefaultDiskStorage.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\r\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/cache/disk/DefaultDiskStorage$PurgingVisitor;", "Lcom/facebook/common/file/FileTreeVisitor;", "<init>", "(Lcom/facebook/cache/disk/DefaultDiskStorage;)V", "insideBaseDirectory", "", "preVisitDirectory", "", "directory", "Ljava/io/File;", "visitFile", "file", "postVisitDirectory", "isExpectedFile", "isRecentFile", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class PurgingVisitor implements FileTreeVisitor {
        private boolean insideBaseDirectory;

        public PurgingVisitor() {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File directory) {
            if (this.insideBaseDirectory || !Intrinsics.areEqual(directory, DefaultDiskStorage.this.mVersionDirectory)) {
                return;
            }
            this.insideBaseDirectory = true;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(File file) {
            if (this.insideBaseDirectory && isExpectedFile(file)) {
                return;
            }
            Intrinsics.checkNotNull(file);
            file.delete();
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File directory) {
            if (!Intrinsics.areEqual(DefaultDiskStorage.this.mRootDirectory, directory) && !this.insideBaseDirectory) {
                Intrinsics.checkNotNull(directory);
                directory.delete();
            }
            if (this.insideBaseDirectory && Intrinsics.areEqual(directory, DefaultDiskStorage.this.mVersionDirectory)) {
                this.insideBaseDirectory = false;
            }
        }

        public final boolean isExpectedFile(File file) {
            FileInfo shardFileInfo = DefaultDiskStorage.this.getShardFileInfo(file);
            if (shardFileInfo == null) {
                return false;
            }
            if (shardFileInfo.getType() == ".tmp") {
                Intrinsics.checkNotNull(file);
                return isRecentFile(file);
            }
            Preconditions.checkState(shardFileInfo.getType() == ".cnt");
            return true;
        }

        public final boolean isRecentFile(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return file.lastModified() > DefaultDiskStorage.this.mClock.now() - DefaultDiskStorage.INSTANCE.getTEMP_FILE_LIFETIME_MS();
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void purgeUnexpectedResources() {
        FileTree.walkFileTree(this.mRootDirectory, new PurgingVisitor());
    }

    private final void mkdirs(File directory, String message) throws IOException {
        try {
            FileUtils.mkdirs(directory);
        } catch (FileUtils.CreateDirectoryException e) {
            CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR;
            Class<?> cls = TAG;
            Intrinsics.checkNotNull(message);
            cacheErrorLogger.logError(cacheErrorCategory, cls, message, e);
            throw e;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.Inserter insert(String resourceId, Object debugInfo) throws IOException {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
        FileInfo fileInfo = new FileInfo(".tmp", resourceId);
        File subdirectory = getSubdirectory(fileInfo.getResourceId());
        if (!subdirectory.exists()) {
            mkdirs(subdirectory, "insert");
        }
        try {
            return new InserterImpl(this, resourceId, fileInfo.createTempFile(subdirectory));
        } catch (IOException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, TAG, "insert", e);
            throw e;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public BinaryResource getResource(String resourceId, Object debugInfo) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
        File contentFileFor = getContentFileFor(resourceId);
        if (!contentFileFor.exists()) {
            return null;
        }
        contentFileFor.setLastModified(this.mClock.now());
        return FileBinaryResource.INSTANCE.createOrNull(contentFileFor);
    }

    private final String getFilename(String resourceId) {
        Intrinsics.checkNotNull(resourceId);
        FileInfo fileInfo = new FileInfo(".cnt", resourceId);
        return fileInfo.toPath(getSubdirectoryPath(fileInfo.getResourceId()));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean contains(String resourceId, Object debugInfo) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
        return query(resourceId, false);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean touch(String resourceId, Object debugInfo) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
        return query(resourceId, true);
    }

    private final boolean query(String resourceId, boolean touch) {
        File contentFileFor = getContentFileFor(resourceId);
        boolean zExists = contentFileFor.exists();
        if (touch && zExists) {
            contentFileFor.setLastModified(this.mClock.now());
        }
        return zExists;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(DiskStorage.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return doRemove(((EntryImpl) entry).getResource().getFile());
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(String resourceId) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        return doRemove(getContentFileFor(resourceId));
    }

    private final long doRemove(File contentFile) {
        if (!contentFile.exists()) {
            return 0L;
        }
        long length = contentFile.length();
        if (contentFile.delete()) {
            return length;
        }
        return -1L;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() {
        FileTree.deleteContents(this.mRootDirectory);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.DiskDumpInfo getDumpInfo() throws Throwable {
        Integer numPut;
        List<DiskStorage.Entry> entries = getEntries();
        DiskStorage.DiskDumpInfo diskDumpInfo = new DiskStorage.DiskDumpInfo();
        Iterator<DiskStorage.Entry> it = entries.iterator();
        while (it.hasNext()) {
            DiskStorage.DiskDumpInfoEntry diskDumpInfoEntryDumpCacheEntry = dumpCacheEntry(it.next());
            String str = diskDumpInfoEntryDumpCacheEntry.type;
            Integer num = diskDumpInfo.typeCounts.get(str);
            if (num == null) {
                numPut = diskDumpInfo.typeCounts.put(str, 1);
            } else {
                numPut = diskDumpInfo.typeCounts.put(str, Integer.valueOf(num.intValue() + 1));
            }
            diskDumpInfo.entries.add(diskDumpInfoEntryDumpCacheEntry);
        }
        return diskDumpInfo;
    }

    private final DiskStorage.DiskDumpInfoEntry dumpCacheEntry(DiskStorage.Entry entry) throws Throwable {
        String str;
        Intrinsics.checkNotNull(entry, "null cannot be cast to non-null type com.facebook.cache.disk.DefaultDiskStorage.EntryImpl");
        EntryImpl entryImpl = (EntryImpl) entry;
        byte[] bytes = entryImpl.getResource().getBytes();
        String strTypeOfBytes = typeOfBytes(bytes);
        if (Intrinsics.areEqual(strTypeOfBytes, "undefined") && bytes.length >= 4) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format(null, "0x%02X 0x%02X 0x%02X 0x%02X", Arrays.copyOf(new Object[]{Byte.valueOf(bytes[0]), Byte.valueOf(bytes[1]), Byte.valueOf(bytes[2]), Byte.valueOf(bytes[3])}, 4));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        } else {
            str = "";
        }
        return new DiskStorage.DiskDumpInfoEntry(entryImpl.getId(), entryImpl.getResource().getFile().getPath(), strTypeOfBytes, entryImpl.getSize(), str);
    }

    private final String typeOfBytes(byte[] bytes) {
        if (bytes.length >= 2) {
            byte b = bytes[0];
            if (b == -1 && bytes[1] == -40) {
                return "jpg";
            }
            if (b == -119 && bytes[1] == 80) {
                return "png";
            }
            if (b == 82 && bytes[1] == 73) {
                return "webp";
            }
            if (b == 71 && bytes[1] == 73) {
                return "gif";
            }
            return "undefined";
        }
        return "undefined";
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public List<DiskStorage.Entry> getEntries() throws IOException {
        EntriesCollector entriesCollector = new EntriesCollector();
        FileTree.walkFileTree(this.mVersionDirectory, entriesCollector);
        return entriesCollector.getEntries();
    }

    /* JADX INFO: compiled from: DefaultDiskStorage.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/cache/disk/DefaultDiskStorage$EntryImpl;", "Lcom/facebook/cache/disk/DiskStorage$Entry;", "id", "", "cachedFile", "Ljava/io/File;", "<init>", "(Ljava/lang/String;Ljava/io/File;)V", "resource", "Lcom/facebook/binaryresource/FileBinaryResource;", ContentDisposition.Parameters.Size, "", "timestamp", "getId", "getTimestamp", "getResource", "getSize", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class EntryImpl implements DiskStorage.Entry {
        private final String id;
        private final FileBinaryResource resource;
        private long size;
        private long timestamp;

        public EntryImpl(String str, File file) {
            if (file == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            if (str != null) {
                this.id = str;
                this.resource = FileBinaryResource.INSTANCE.create(file);
                this.size = -1L;
                this.timestamp = -1L;
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public String getId() {
            return this.id;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getTimestamp() {
            if (this.timestamp < 0) {
                this.timestamp = this.resource.getFile().lastModified();
            }
            return this.timestamp;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public FileBinaryResource getResource() {
            return this.resource;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getSize() {
            if (this.size < 0) {
                this.size = this.resource.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileInfo getShardFileInfo(File file) {
        FileInfo.Companion companion = FileInfo.INSTANCE;
        Intrinsics.checkNotNull(file);
        FileInfo fileInfoFromFile = companion.fromFile(file);
        if (fileInfoFromFile != null && Intrinsics.areEqual(getSubdirectory(fileInfoFromFile.getResourceId()), file.getParentFile())) {
            return fileInfoFromFile;
        }
        return null;
    }

    /* JADX INFO: compiled from: DefaultDiskStorage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/facebook/cache/disk/DefaultDiskStorage$FileType;", "", "Companion", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FileType {
        public static final String CONTENT = ".cnt";

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String TEMP = ".tmp";

        /* JADX INFO: compiled from: DefaultDiskStorage.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/facebook/cache/disk/DefaultDiskStorage$FileType$Companion;", "", "<init>", "()V", "CONTENT", "", "TEMP", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String CONTENT = ".cnt";
            public static final String TEMP = ".tmp";

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: DefaultDiskStorage.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/facebook/cache/disk/DefaultDiskStorage$FileInfo;", "", "type", "", "resourceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getResourceId", "toString", "toPath", "parentPath", "createTempFile", "Ljava/io/File;", "parent", "Companion", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class FileInfo {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String resourceId;

        @FileType
        private final String type;

        public FileInfo(@FileType String type, String resourceId) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            this.type = type;
            this.resourceId = resourceId;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final String getType() {
            return this.type;
        }

        public String toString() {
            return this.type + "(" + this.resourceId + ")";
        }

        public final String toPath(String parentPath) {
            return parentPath + File.separator + this.resourceId + this.type;
        }

        public final File createTempFile(File parent) throws IOException {
            File fileCreateTempFile = File.createTempFile(this.resourceId + ".", ".tmp", parent);
            Intrinsics.checkNotNull(fileCreateTempFile);
            return fileCreateTempFile;
        }

        /* JADX INFO: compiled from: DefaultDiskStorage.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/cache/disk/DefaultDiskStorage$FileInfo$Companion;", "", "<init>", "()V", "fromFile", "Lcom/facebook/cache/disk/DefaultDiskStorage$FileInfo;", "file", "Ljava/io/File;", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final FileInfo fromFile(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                String name = file.getName();
                Intrinsics.checkNotNull(name);
                int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) name, FilenameUtils.EXTENSION_SEPARATOR, 0, false, 6, (Object) null);
                if (iLastIndexOf$default <= 0) {
                    return null;
                }
                String strSubstring = name.substring(iLastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String fileTypefromExtension = DefaultDiskStorage.INSTANCE.getFileTypefromExtension(strSubstring);
                if (fileTypefromExtension == null) {
                    return null;
                }
                String strSubstring2 = name.substring(0, iLastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                if (Intrinsics.areEqual(fileTypefromExtension, ".tmp")) {
                    int iLastIndexOf$default2 = StringsKt.lastIndexOf$default((CharSequence) strSubstring2, FilenameUtils.EXTENSION_SEPARATOR, 0, false, 6, (Object) null);
                    if (iLastIndexOf$default2 <= 0) {
                        return null;
                    }
                    strSubstring2 = strSubstring2.substring(0, iLastIndexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                }
                return new FileInfo(fileTypefromExtension, strSubstring2);
            }
        }
    }

    /* JADX INFO: compiled from: DefaultDiskStorage.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0087\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;", "Lcom/facebook/cache/disk/DiskStorage$Inserter;", "mResourceId", "", "mTemporaryFile", "Ljava/io/File;", "<init>", "(Lcom/facebook/cache/disk/DefaultDiskStorage;Ljava/lang/String;Ljava/io/File;)V", "getMTemporaryFile", "()Ljava/io/File;", "writeData", "", "callback", "Lcom/facebook/cache/common/WriterCallback;", "debugInfo", "", "commit", "Lcom/facebook/binaryresource/BinaryResource;", "time", "", "cleanUp", "", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class InserterImpl implements DiskStorage.Inserter {
        private final String mResourceId;
        private final File mTemporaryFile;
        final /* synthetic */ DefaultDiskStorage this$0;

        public InserterImpl(DefaultDiskStorage defaultDiskStorage, String mResourceId, File mTemporaryFile) {
            Intrinsics.checkNotNullParameter(mResourceId, "mResourceId");
            Intrinsics.checkNotNullParameter(mTemporaryFile, "mTemporaryFile");
            this.this$0 = defaultDiskStorage;
            this.mResourceId = mResourceId;
            this.mTemporaryFile = mTemporaryFile;
        }

        public final File getMTemporaryFile() {
            return this.mTemporaryFile;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public void writeData(WriterCallback callback, Object debugInfo) throws IOException {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.mTemporaryFile);
                try {
                    CountingOutputStream countingOutputStream = new CountingOutputStream(fileOutputStream);
                    callback.write(countingOutputStream);
                    countingOutputStream.flush();
                    long count = countingOutputStream.getCount();
                    fileOutputStream.close();
                    if (this.mTemporaryFile.length() != count) {
                        throw new IncompleteFileException(count, this.mTemporaryFile.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                this.this$0.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.TAG, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public BinaryResource commit(Object debugInfo) throws IOException {
            Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
            return commit(debugInfo, this.this$0.mClock.now());
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public BinaryResource commit(Object debugInfo, long time) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
            File contentFileFor = this.this$0.getContentFileFor(this.mResourceId);
            try {
                FileUtils.rename(this.mTemporaryFile, contentFileFor);
                if (contentFileFor.exists()) {
                    contentFileFor.setLastModified(time);
                }
                return FileBinaryResource.INSTANCE.create(contentFileFor);
            } catch (FileUtils.RenameException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                } else if (cause instanceof FileUtils.ParentDirNotFoundException) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                } else if (cause instanceof FileNotFoundException) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
                } else {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                }
                this.this$0.mCacheErrorLogger.logError(cacheErrorCategory, DefaultDiskStorage.TAG, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public boolean cleanUp() {
            return !this.mTemporaryFile.exists() || this.mTemporaryFile.delete();
        }
    }

    /* JADX INFO: compiled from: DefaultDiskStorage.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000bH\u0007J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0003R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/facebook/cache/disk/DefaultDiskStorage$Companion;", "", "<init>", "()V", "TAG", "Ljava/lang/Class;", "CONTENT_FILE_EXTENSION", "", "TEMP_FILE_EXTENSION", "DEFAULT_DISK_STORAGE_VERSION_PREFIX", "SHARDING_BUCKET_COUNT", "", "TEMP_FILE_LIFETIME_MS", "", "getTEMP_FILE_LIFETIME_MS", "()J", "isExternal", "", "directory", "Ljava/io/File;", "cacheErrorLogger", "Lcom/facebook/cache/common/CacheErrorLogger;", "getVersionSubdirectoryName", "version", "getFileTypefromExtension", "extension", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getTEMP_FILE_LIFETIME_MS() {
            return DefaultDiskStorage.TEMP_FILE_LIFETIME_MS;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isExternal(File directory, CacheErrorLogger cacheErrorLogger) {
            try {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (externalStorageDirectory != null) {
                    String string = externalStorageDirectory.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    String str = null;
                    try {
                        Intrinsics.checkNotNull(directory);
                        String canonicalPath = directory.getCanonicalPath();
                        try {
                            Intrinsics.checkNotNull(canonicalPath);
                            if (StringsKt.contains$default((CharSequence) canonicalPath, (CharSequence) string, false, 2, (Object) null)) {
                                return true;
                            }
                        } catch (IOException e) {
                            e = e;
                            str = canonicalPath;
                            Intrinsics.checkNotNull(cacheErrorLogger);
                            cacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.OTHER, DefaultDiskStorage.TAG, "failed to read folder to check if external: " + str, e);
                        }
                    } catch (IOException e2) {
                        e = e2;
                    }
                }
            } catch (Exception e3) {
                Intrinsics.checkNotNull(cacheErrorLogger);
                cacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.OTHER, DefaultDiskStorage.TAG, "failed to get the external storage directory!", e3);
            }
            return false;
        }

        public final String getVersionSubdirectoryName(int version) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(null, "%s.ols%d.%d", Arrays.copyOf(new Object[]{DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX, 100, Integer.valueOf(version)}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @FileType
        public final String getFileTypefromExtension(String extension) {
            if (Intrinsics.areEqual(".cnt", extension)) {
                return ".cnt";
            }
            if (Intrinsics.areEqual(".tmp", extension)) {
                return ".tmp";
            }
            return null;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        TEMP_FILE_LIFETIME_MS = 1800000L;
    }
}
