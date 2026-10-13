package expo.modules.filesystem;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.FileObserver;
import com.datadog.trace.api.config.ProfilingConfig;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.services.FilePermissionService;
import expo.modules.kotlin.sharedobjects.SharedObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: FileSystemWatcher.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001:\u0006EFGHIJB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010%\u001a\u00020#J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020#H\u0002J*\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u001a\u0010-\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0+0.H\u0002J$\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020!0+2\f\u00102\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\u001e\u00103\u001a\u00020#2\f\u00102\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u00104\u001a\u000200H\u0002JG\u00105\u001a\u00020#2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b>\u0010?J\u0012\u0010@\u001a\u00020\u001c2\b\u0010A\u001a\u0004\u0018\u00010\u001cH\u0002J!\u0010B\u001a\u00020;*\b\u0012\u0004\u0012\u00020,0+2\u0006\u00108\u001a\u00020\u001cH\u0002¢\u0006\u0004\bC\u0010DR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R:\u0010\u001a\u001a.\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001bj\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lexpo/modules/filesystem/FileSystemWatcher;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "appContext", "Lexpo/modules/kotlin/AppContext;", "uri", "Landroid/net/Uri;", "options", "Lexpo/modules/filesystem/WatchOptions;", "<init>", "(Lexpo/modules/kotlin/AppContext;Landroid/net/Uri;Lexpo/modules/filesystem/WatchOptions;)V", "backgroundCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "watchedFile", "Ljava/io/File;", "watchedUri", "debounceDuration", "Lkotlin/time/Duration;", "J", "isWatchingDirectory", "", "lock", "", "observer", "Landroid/os/FileObserver;", "debounceJob", "Lkotlinx/coroutines/Job;", "pendingEvents", "Ljava/util/LinkedHashMap;", "", "", "Lexpo/modules/filesystem/FileSystemWatcher$PendingEvent;", "Lkotlin/collections/LinkedHashMap;", "pendingMoveFrom", "Lexpo/modules/filesystem/FileSystemWatcher$PendingMove;", ViewProps.START, "", "createFileObserver", "stop", "handleEvent", "event", "Lexpo/modules/filesystem/FileSystemWatcher$RawWatchEvent;", "flushPendingEvents", "mergeEvents", "", "Lexpo/modules/filesystem/FileSystemWatcher$MergedEvent;", "eventsSnapshot", "", "emitPairedMoveEvents", "Lexpo/modules/filesystem/FileSystemWatcher$PairedMoves;", "moveFromEvents", "mergedEvents", "emitUnpairedEvents", "pairedMoves", "emitEvent", "type", "Lexpo/modules/filesystem/WatchEventType;", "path", "isDirectory", "flags", "Lexpo/modules/filesystem/FileSystemWatcher$WatchEventFlags;", "newPath", "newPathIsDirectory", "emitEvent-ZsM1Sv4", "(Lexpo/modules/filesystem/WatchEventType;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/Boolean;)V", "childUri", "changedPath", "flagsFor", "flagsFor-PQnVR-E", "(Ljava/util/List;Ljava/lang/String;)I", "PendingEvent", "PendingMove", "MergedEvent", "PairedMoves", "RawWatchEvent", "WatchEventFlags", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileSystemWatcher extends SharedObject {
    private final CoroutineScope backgroundCoroutineScope;
    private final long debounceDuration;
    private Job debounceJob;
    private final boolean isWatchingDirectory;
    private final Object lock;
    private FileObserver observer;
    private final LinkedHashMap<String, List<PendingEvent>> pendingEvents;
    private final List<PendingMove> pendingMoveFrom;
    private final File watchedFile;
    private final Uri watchedUri;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemWatcher(AppContext appContext, Uri uri, WatchOptions watchOptions) throws WatcherPermissionException, WatcherSetupException, Exceptions.ReactContextLost, WatcherUnsupportedPathException, WatcherPathNotFoundException {
        long duration;
        EnumSet<FilePermissionService.Permission> pathPermissions;
        super(appContext);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.backgroundCoroutineScope = appContext.getBackgroundCoroutineScope();
        if (watchOptions == null) {
            duration = FileSystemWatcherKt.DEFAULT_DEBOUNCE;
        } else {
            long debounce = watchOptions.getDebounce();
            Duration.Companion companion = Duration.INSTANCE;
            duration = DurationKt.toDuration(debounce, DurationUnit.MILLISECONDS);
        }
        this.debounceDuration = duration;
        this.lock = new Object();
        this.pendingEvents = new LinkedHashMap<>();
        this.pendingMoveFrom = new ArrayList();
        if (!Intrinsics.areEqual(uri.getScheme(), "file")) {
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            throw new WatcherUnsupportedPathException(string);
        }
        String path = uri.getPath();
        if (path == null) {
            String string2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            throw new WatcherSetupException(string2);
        }
        File file = new File(path);
        this.watchedFile = file;
        if (!file.exists()) {
            throw new WatcherPathNotFoundException(path);
        }
        if (!file.canRead()) {
            throw new WatcherPermissionException(path);
        }
        Context reactContext = appContext.getReactContext();
        if (reactContext == null) {
            throw new Exceptions.ReactContextLost();
        }
        FilePermissionService filePermission = appContext.getFilePermission();
        if (filePermission != null) {
            String path2 = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
            pathPermissions = filePermission.getPathPermissions(reactContext, path2);
        } else {
            pathPermissions = null;
        }
        if (pathPermissions == null || !pathPermissions.contains(FilePermissionService.Permission.READ)) {
            throw new WatcherPermissionException(path);
        }
        this.watchedUri = Uri.fromFile(file);
        this.isWatchingDirectory = file.isDirectory();
    }

    public final void start() {
        if (this.observer != null) {
            return;
        }
        FileObserver fileObserverCreateFileObserver = createFileObserver(this.watchedFile);
        fileObserverCreateFileObserver.startWatching();
        this.observer = fileObserverCreateFileObserver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createFileObserver$handleRawEvent(FileSystemWatcher fileSystemWatcher, int i, String str) {
        fileSystemWatcher.handleEvent(new RawWatchEvent(WatchEventFlags.m11926constructorimpl(i), str, null));
    }

    private final FileObserver createFileObserver(File watchedFile) {
        if (Build.VERSION.SDK_INT >= 29) {
            return new FileObserver(watchedFile) { // from class: expo.modules.filesystem.FileSystemWatcher.createFileObserver.1
                @Override // android.os.FileObserver
                public void onEvent(int event, String path) {
                    FileSystemWatcher.createFileObserver$handleRawEvent(this, event, path);
                }
            };
        }
        return new FileObserver(watchedFile.getPath()) { // from class: expo.modules.filesystem.FileSystemWatcher.createFileObserver.2
            @Override // android.os.FileObserver
            public void onEvent(int event, String path) {
                FileSystemWatcher.createFileObserver$handleRawEvent(FileSystemWatcher.this, event, path);
            }
        };
    }

    public final void stop() {
        FileObserver fileObserver = this.observer;
        if (fileObserver != null) {
            fileObserver.stopWatching();
        }
        this.observer = null;
        synchronized (this.lock) {
            Job job = this.debounceJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.debounceJob = null;
            this.pendingEvents.clear();
            this.pendingMoveFrom.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void handleEvent(RawWatchEvent event) {
        if (event.isEmpty()) {
            return;
        }
        if (event.isSelfEvent()) {
            WatchEventType selfEventType = event.getSelfEventType();
            String string = this.watchedUri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            m11914emitEventZsM1Sv4$default(this, selfEventType, string, this.isWatchingDirectory, event.m11924getFlagsocRs8C0(), null, null, 48, null);
            stop();
            return;
        }
        boolean zResolveIsDirectory = event.resolveIsDirectory(this.watchedFile, this.isWatchingDirectory);
        synchronized (this.lock) {
            if (WatchEventFlags.m11933isMoveFromimpl(event.m11924getFlagsocRs8C0()) && event.getChangedPath() != null) {
                this.pendingMoveFrom.add(new PendingMove(event.getChangedPath(), zResolveIsDirectory));
            }
            LinkedHashMap<String, List<PendingEvent>> linkedHashMap = this.pendingEvents;
            String changedPath = event.getChangedPath();
            ArrayList arrayList = linkedHashMap.get(changedPath);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(changedPath, arrayList);
            }
            arrayList.add(new PendingEvent(event, zResolveIsDirectory));
            Job job = this.debounceJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.debounceJob = BuildersKt__Builders_commonKt.launch$default(this.backgroundCoroutineScope, null, null, new FileSystemWatcher$handleEvent$1$2(this, null), 3, null);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.util.Map] */
    public final void flushPendingEvents() {
        List<PendingMove> list;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.lock) {
            LinkedHashMap<String, List<PendingEvent>> linkedHashMap = this.pendingEvents;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
            for (Object obj : linkedHashMap.entrySet()) {
                linkedHashMap2.put(((Map.Entry) obj).getKey(), CollectionsKt.toList((Iterable) ((Map.Entry) obj).getValue()));
            }
            objectRef.element = linkedHashMap2;
            list = CollectionsKt.toList(this.pendingMoveFrom);
            this.pendingEvents.clear();
            this.pendingMoveFrom.clear();
            this.debounceJob = null;
            Unit unit = Unit.INSTANCE;
        }
        List<MergedEvent> listMergeEvents = mergeEvents((Map) objectRef.element);
        emitUnpairedEvents(listMergeEvents, emitPairedMoveEvents(list, listMergeEvents));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.Set, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3, types: [expo.modules.filesystem.FileSystemWatcher$PendingMove] */
    /* JADX WARN: Type inference failed for: r4v4 */
    private final PairedMoves emitPairedMoveEvents(List<PendingMove> moveFromEvents, List<MergedEvent> mergedEvents) {
        ?? pendingMove;
        ArrayList arrayList = new ArrayList();
        Iterator it = mergedEvents.iterator();
        while (true) {
            pendingMove = 0;
            pendingMove = 0;
            if (!it.hasNext()) {
                break;
            }
            MergedEvent mergedEvent = (MergedEvent) it.next();
            String changedPath = mergedEvent.getChangedPath();
            if (changedPath != null) {
                if (!WatchEventFlags.m11934isMoveToimpl(mergedEvent.m11919getFlagsocRs8C0())) {
                    changedPath = null;
                }
                if (changedPath != null) {
                    pendingMove = new PendingMove(changedPath, mergedEvent.isDirectory());
                }
            }
            if (pendingMove != 0) {
                arrayList.add(pendingMove);
            }
        }
        ArrayList arrayList2 = arrayList;
        PairedMoves pairedMoves = new PairedMoves(pendingMove, pendingMove, 3, pendingMove);
        int iMin = Math.min(moveFromEvents.size(), arrayList2.size());
        for (int i = 0; i < iMin; i++) {
            PendingMove pendingMove2 = moveFromEvents.get(i);
            PendingMove pendingMove3 = (PendingMove) arrayList2.get(i);
            m11913emitEventZsM1Sv4(WatchEventType.RENAMED, childUri(pendingMove2.getPath()), pendingMove2.isDirectory(), WatchEventFlags.m11938orM3vCxXk(m11915flagsForPQnVRE(mergedEvents, pendingMove2.getPath()), m11915flagsForPQnVRE(mergedEvents, pendingMove3.getPath())), childUri(pendingMove3.getPath()), Boolean.valueOf(pendingMove3.isDirectory()));
            pairedMoves.getSources().add(pendingMove2.getPath());
            pairedMoves.getDestinations().add(pendingMove3.getPath());
        }
        return pairedMoves;
    }

    private final void emitUnpairedEvents(List<MergedEvent> mergedEvents, PairedMoves pairedMoves) {
        for (MergedEvent mergedEvent : mergedEvents) {
            if (!mergedEvent.isPairedMove(pairedMoves)) {
                Iterator<WatchEventType> it = WatchEventFlags.m11940toUnifiedTypesimpl(mergedEvent.m11919getFlagsocRs8C0()).iterator();
                while (it.hasNext()) {
                    m11914emitEventZsM1Sv4$default(this, it.next(), childUri(mergedEvent.getChangedPath()), mergedEvent.isDirectory(), mergedEvent.m11919getFlagsocRs8C0(), null, null, 48, null);
                }
            }
        }
    }

    /* JADX INFO: renamed from: emitEvent-ZsM1Sv4$default, reason: not valid java name */
    static /* synthetic */ void m11914emitEventZsM1Sv4$default(FileSystemWatcher fileSystemWatcher, WatchEventType watchEventType, String str, boolean z, int i, String str2, Boolean bool, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            str2 = null;
        }
        if ((i2 & 32) != 0) {
            bool = null;
        }
        fileSystemWatcher.m11913emitEventZsM1Sv4(watchEventType, str, z, i, str2, bool);
    }

    /* JADX INFO: renamed from: emitEvent-ZsM1Sv4, reason: not valid java name */
    private final void m11913emitEventZsM1Sv4(WatchEventType type, String path, boolean isDirectory, int flags, String newPath, Boolean newPathIsDirectory) {
        Boolean boolValueOf;
        if (newPath != null) {
            boolValueOf = Boolean.valueOf(newPathIsDirectory != null ? newPathIsDirectory.booleanValue() : isDirectory);
        } else {
            boolValueOf = null;
        }
        emit("change", new WatchEventPayload(type, path, isDirectory, flags, newPath, boolValueOf));
    }

    private final String childUri(String changedPath) {
        if (changedPath == null) {
            String string = this.watchedUri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        String string2 = Uri.fromFile(new File(this.watchedFile, changedPath)).toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }

    /* JADX INFO: compiled from: FileSystemWatcher.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lexpo/modules/filesystem/FileSystemWatcher$PendingEvent;", "", "event", "Lexpo/modules/filesystem/FileSystemWatcher$RawWatchEvent;", "isDirectory", "", "<init>", "(Lexpo/modules/filesystem/FileSystemWatcher$RawWatchEvent;Z)V", "getEvent", "()Lexpo/modules/filesystem/FileSystemWatcher$RawWatchEvent;", "()Z", "flags", "Lexpo/modules/filesystem/FileSystemWatcher$WatchEventFlags;", "getFlags-ocRs8C0", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class PendingEvent {
        private final RawWatchEvent event;
        private final boolean isDirectory;

        public static /* synthetic */ PendingEvent copy$default(PendingEvent pendingEvent, RawWatchEvent rawWatchEvent, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                rawWatchEvent = pendingEvent.event;
            }
            if ((i & 2) != 0) {
                z = pendingEvent.isDirectory;
            }
            return pendingEvent.copy(rawWatchEvent, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RawWatchEvent getEvent() {
            return this.event;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsDirectory() {
            return this.isDirectory;
        }

        public final PendingEvent copy(RawWatchEvent event, boolean isDirectory) {
            Intrinsics.checkNotNullParameter(event, "event");
            return new PendingEvent(event, isDirectory);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingEvent)) {
                return false;
            }
            PendingEvent pendingEvent = (PendingEvent) other;
            return Intrinsics.areEqual(this.event, pendingEvent.event) && this.isDirectory == pendingEvent.isDirectory;
        }

        public int hashCode() {
            return (this.event.hashCode() * 31) + Boolean.hashCode(this.isDirectory);
        }

        public String toString() {
            return "PendingEvent(event=" + this.event + ", isDirectory=" + this.isDirectory + ")";
        }

        public PendingEvent(RawWatchEvent event, boolean z) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
            this.isDirectory = z;
        }

        public final RawWatchEvent getEvent() {
            return this.event;
        }

        public final boolean isDirectory() {
            return this.isDirectory;
        }

        /* JADX INFO: renamed from: getFlags-ocRs8C0, reason: not valid java name */
        public final int m11920getFlagsocRs8C0() {
            return this.event.m11924getFlagsocRs8C0();
        }
    }

    /* JADX INFO: compiled from: FileSystemWatcher.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0013"}, d2 = {"Lexpo/modules/filesystem/FileSystemWatcher$PendingMove;", "", "path", "", "isDirectory", "", "<init>", "(Ljava/lang/String;Z)V", "getPath", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class PendingMove {
        private final boolean isDirectory;
        private final String path;

        public static /* synthetic */ PendingMove copy$default(PendingMove pendingMove, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pendingMove.path;
            }
            if ((i & 2) != 0) {
                z = pendingMove.isDirectory;
            }
            return pendingMove.copy(str, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsDirectory() {
            return this.isDirectory;
        }

        public final PendingMove copy(String path, boolean isDirectory) {
            Intrinsics.checkNotNullParameter(path, "path");
            return new PendingMove(path, isDirectory);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingMove)) {
                return false;
            }
            PendingMove pendingMove = (PendingMove) other;
            return Intrinsics.areEqual(this.path, pendingMove.path) && this.isDirectory == pendingMove.isDirectory;
        }

        public int hashCode() {
            return (this.path.hashCode() * 31) + Boolean.hashCode(this.isDirectory);
        }

        public String toString() {
            return "PendingMove(path=" + this.path + ", isDirectory=" + this.isDirectory + ")";
        }

        public PendingMove(String path, boolean z) {
            Intrinsics.checkNotNullParameter(path, "path");
            this.path = path;
            this.isDirectory = z;
        }

        public final String getPath() {
            return this.path;
        }

        public final boolean isDirectory() {
            return this.isDirectory;
        }
    }

    /* JADX INFO: compiled from: FileSystemWatcher.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\rJ\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J0\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000f¨\u0006\u001f"}, d2 = {"Lexpo/modules/filesystem/FileSystemWatcher$MergedEvent;", "", "changedPath", "", "flags", "Lexpo/modules/filesystem/FileSystemWatcher$WatchEventFlags;", "isDirectory", "", "<init>", "(Ljava/lang/String;IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getChangedPath", "()Ljava/lang/String;", "getFlags-ocRs8C0", "()I", "I", "()Z", "isPairedMove", "pairedMoves", "Lexpo/modules/filesystem/FileSystemWatcher$PairedMoves;", "component1", "component2", "component2-ocRs8C0", "component3", "copy", "copy-yAwzcwU", "(Ljava/lang/String;IZ)Lexpo/modules/filesystem/FileSystemWatcher$MergedEvent;", "equals", "other", "hashCode", "", "toString", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class MergedEvent {
        private final String changedPath;
        private final int flags;
        private final boolean isDirectory;

        public /* synthetic */ MergedEvent(String str, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, z);
        }

        /* JADX INFO: renamed from: copy-yAwzcwU$default, reason: not valid java name */
        public static /* synthetic */ MergedEvent m11916copyyAwzcwU$default(MergedEvent mergedEvent, String str, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = mergedEvent.changedPath;
            }
            if ((i2 & 2) != 0) {
                i = mergedEvent.flags;
            }
            if ((i2 & 4) != 0) {
                z = mergedEvent.isDirectory;
            }
            return mergedEvent.m11918copyyAwzcwU(str, i, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getChangedPath() {
            return this.changedPath;
        }

        /* JADX INFO: renamed from: component2-ocRs8C0, reason: not valid java name and from getter */
        public final int getFlags() {
            return this.flags;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsDirectory() {
            return this.isDirectory;
        }

        /* JADX INFO: renamed from: copy-yAwzcwU, reason: not valid java name */
        public final MergedEvent m11918copyyAwzcwU(String changedPath, int flags, boolean isDirectory) {
            return new MergedEvent(changedPath, flags, isDirectory, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MergedEvent)) {
                return false;
            }
            MergedEvent mergedEvent = (MergedEvent) other;
            return Intrinsics.areEqual(this.changedPath, mergedEvent.changedPath) && WatchEventFlags.m11929equalsimpl0(this.flags, mergedEvent.flags) && this.isDirectory == mergedEvent.isDirectory;
        }

        public int hashCode() {
            String str = this.changedPath;
            return ((((str == null ? 0 : str.hashCode()) * 31) + WatchEventFlags.m11930hashCodeimpl(this.flags)) * 31) + Boolean.hashCode(this.isDirectory);
        }

        public String toString() {
            return "MergedEvent(changedPath=" + this.changedPath + ", flags=" + WatchEventFlags.m11939toStringimpl(this.flags) + ", isDirectory=" + this.isDirectory + ")";
        }

        private MergedEvent(String str, int i, boolean z) {
            this.changedPath = str;
            this.flags = i;
            this.isDirectory = z;
        }

        public final String getChangedPath() {
            return this.changedPath;
        }

        /* JADX INFO: renamed from: getFlags-ocRs8C0, reason: not valid java name */
        public final int m11919getFlagsocRs8C0() {
            return this.flags;
        }

        public final boolean isDirectory() {
            return this.isDirectory;
        }

        public final boolean isPairedMove(PairedMoves pairedMoves) {
            Intrinsics.checkNotNullParameter(pairedMoves, "pairedMoves");
            if (this.changedPath != null) {
                return pairedMoves.getSources().contains(this.changedPath) || pairedMoves.getDestinations().contains(this.changedPath);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: FileSystemWatcher.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lexpo/modules/filesystem/FileSystemWatcher$PairedMoves;", "", "sources", "", "", "destinations", "<init>", "(Ljava/util/Set;Ljava/util/Set;)V", "getSources", "()Ljava/util/Set;", "getDestinations", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class PairedMoves {
        private final Set<String> destinations;
        private final Set<String> sources;

        /* JADX WARN: Multi-variable type inference failed */
        public PairedMoves() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PairedMoves copy$default(PairedMoves pairedMoves, Set set, Set set2, int i, Object obj) {
            if ((i & 1) != 0) {
                set = pairedMoves.sources;
            }
            if ((i & 2) != 0) {
                set2 = pairedMoves.destinations;
            }
            return pairedMoves.copy(set, set2);
        }

        public final Set<String> component1() {
            return this.sources;
        }

        public final Set<String> component2() {
            return this.destinations;
        }

        public final PairedMoves copy(Set<String> sources, Set<String> destinations) {
            Intrinsics.checkNotNullParameter(sources, "sources");
            Intrinsics.checkNotNullParameter(destinations, "destinations");
            return new PairedMoves(sources, destinations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PairedMoves)) {
                return false;
            }
            PairedMoves pairedMoves = (PairedMoves) other;
            return Intrinsics.areEqual(this.sources, pairedMoves.sources) && Intrinsics.areEqual(this.destinations, pairedMoves.destinations);
        }

        public int hashCode() {
            return (this.sources.hashCode() * 31) + this.destinations.hashCode();
        }

        public String toString() {
            return "PairedMoves(sources=" + this.sources + ", destinations=" + this.destinations + ")";
        }

        public PairedMoves(Set<String> sources, Set<String> destinations) {
            Intrinsics.checkNotNullParameter(sources, "sources");
            Intrinsics.checkNotNullParameter(destinations, "destinations");
            this.sources = sources;
            this.destinations = destinations;
        }

        public /* synthetic */ PairedMoves(LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new LinkedHashSet() : linkedHashSet, (i & 2) != 0 ? new LinkedHashSet() : linkedHashSet2);
        }

        public final Set<String> getSources() {
            return this.sources;
        }

        public final Set<String> getDestinations() {
            return this.destinations;
        }
    }

    /* JADX INFO: compiled from: FileSystemWatcher.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eJ\u0010\u0010\u0019\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001a\u0010\tJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, d2 = {"Lexpo/modules/filesystem/FileSystemWatcher$RawWatchEvent;", "", "flags", "Lexpo/modules/filesystem/FileSystemWatcher$WatchEventFlags;", "changedPath", "", "<init>", "(ILjava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFlags-ocRs8C0", "()I", "I", "getChangedPath", "()Ljava/lang/String;", "isEmpty", "", "()Z", "isSelfEvent", "selfEventType", "Lexpo/modules/filesystem/WatchEventType;", "getSelfEventType", "()Lexpo/modules/filesystem/WatchEventType;", "resolveIsDirectory", "watchedFile", "Ljava/io/File;", "defaultValue", "component1", "component1-ocRs8C0", "component2", "copy", "copy-_42QVCs", "(ILjava/lang/String;)Lexpo/modules/filesystem/FileSystemWatcher$RawWatchEvent;", "equals", "other", "hashCode", "", "toString", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class RawWatchEvent {
        private final String changedPath;
        private final int flags;

        public /* synthetic */ RawWatchEvent(int i, String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str);
        }

        /* JADX INFO: renamed from: copy-_42QVCs$default, reason: not valid java name */
        public static /* synthetic */ RawWatchEvent m11921copy_42QVCs$default(RawWatchEvent rawWatchEvent, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = rawWatchEvent.flags;
            }
            if ((i2 & 2) != 0) {
                str = rawWatchEvent.changedPath;
            }
            return rawWatchEvent.m11923copy_42QVCs(i, str);
        }

        /* JADX INFO: renamed from: component1-ocRs8C0, reason: not valid java name and from getter */
        public final int getFlags() {
            return this.flags;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getChangedPath() {
            return this.changedPath;
        }

        /* JADX INFO: renamed from: copy-_42QVCs, reason: not valid java name */
        public final RawWatchEvent m11923copy_42QVCs(int flags, String changedPath) {
            return new RawWatchEvent(flags, changedPath, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RawWatchEvent)) {
                return false;
            }
            RawWatchEvent rawWatchEvent = (RawWatchEvent) other;
            return WatchEventFlags.m11929equalsimpl0(this.flags, rawWatchEvent.flags) && Intrinsics.areEqual(this.changedPath, rawWatchEvent.changedPath);
        }

        public int hashCode() {
            int iM11930hashCodeimpl = WatchEventFlags.m11930hashCodeimpl(this.flags) * 31;
            String str = this.changedPath;
            return iM11930hashCodeimpl + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "RawWatchEvent(flags=" + WatchEventFlags.m11939toStringimpl(this.flags) + ", changedPath=" + this.changedPath + ")";
        }

        private RawWatchEvent(int i, String str) {
            this.flags = i;
            this.changedPath = str;
        }

        public final String getChangedPath() {
            return this.changedPath;
        }

        /* JADX INFO: renamed from: getFlags-ocRs8C0, reason: not valid java name */
        public final int m11924getFlagsocRs8C0() {
            return this.flags;
        }

        public final boolean isEmpty() {
            return WatchEventFlags.m11932isEmptyimpl(this.flags);
        }

        public final boolean isSelfEvent() {
            return WatchEventFlags.m11936isSelfEventimpl(this.flags);
        }

        public final WatchEventType getSelfEventType() {
            if (WatchEventFlags.m11935isSelfDeleteimpl(this.flags)) {
                return WatchEventType.DELETED;
            }
            return WatchEventType.RENAMED;
        }

        public final boolean resolveIsDirectory(File watchedFile, boolean defaultValue) {
            Intrinsics.checkNotNullParameter(watchedFile, "watchedFile");
            if (WatchEventFlags.m11931isDirectoryimpl(this.flags)) {
                return true;
            }
            return this.changedPath != null ? new File(watchedFile, this.changedPath).isDirectory() : defaultValue;
        }
    }

    /* JADX INFO: compiled from: FileSystemWatcher.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0083@\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\b#\u0010$J\u001a\u0010%\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b)\u0010\u0005J\u0010\u0010*\u001a\u00020+HÖ\u0001¢\u0006\u0004\b,\u0010-R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000b\u0088\u0001\u0002¨\u0006/"}, d2 = {"Lexpo/modules/filesystem/FileSystemWatcher$WatchEventFlags;", "", "rawValue", "", "constructor-impl", "(I)I", "getRawValue", "()I", "isEmpty", "", "isEmpty-impl", "(I)Z", "isDirectory", "isDirectory-impl", "isMoveFrom", "isMoveFrom-impl", "isMoveTo", "isMoveTo-impl", "isSelfDelete", "isSelfDelete-impl", "isSelfMove", "isSelfMove-impl", "isSelfEvent", "isSelfEvent-impl", "contains", "flag", "contains-impl", "(II)Z", "or", "other", "or-M3vCxXk", "(II)I", "toUnifiedTypes", "", "Lexpo/modules/filesystem/WatchEventType;", "toUnifiedTypes-impl", "(I)Ljava/util/List;", "equals", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @JvmInline
    private static final class WatchEventFlags {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int NONE = m11926constructorimpl(0);
        private final int rawValue;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ WatchEventFlags m11925boximpl(int i) {
            return new WatchEventFlags(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m11926constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: contains-impl, reason: not valid java name */
        public static final boolean m11927containsimpl(int i, int i2) {
            return (i & i2) != 0;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m11928equalsimpl(int i, Object obj) {
            return (obj instanceof WatchEventFlags) && i == ((WatchEventFlags) obj).m11941unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m11929equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m11930hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
        public static final boolean m11932isEmptyimpl(int i) {
            return i == 0;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m11939toStringimpl(int i) {
            return "WatchEventFlags(rawValue=" + i + ")";
        }

        public boolean equals(Object obj) {
            return m11928equalsimpl(this.rawValue, obj);
        }

        public int hashCode() {
            return m11930hashCodeimpl(this.rawValue);
        }

        public String toString() {
            return m11939toStringimpl(this.rawValue);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m11941unboximpl() {
            return this.rawValue;
        }

        private /* synthetic */ WatchEventFlags(int i) {
            this.rawValue = i;
        }

        public final int getRawValue() {
            return this.rawValue;
        }

        /* JADX INFO: renamed from: isDirectory-impl, reason: not valid java name */
        public static final boolean m11931isDirectoryimpl(int i) {
            return m11927containsimpl(i, 1073741824);
        }

        /* JADX INFO: renamed from: isMoveFrom-impl, reason: not valid java name */
        public static final boolean m11933isMoveFromimpl(int i) {
            return m11927containsimpl(i, 64);
        }

        /* JADX INFO: renamed from: isMoveTo-impl, reason: not valid java name */
        public static final boolean m11934isMoveToimpl(int i) {
            return m11927containsimpl(i, 128);
        }

        /* JADX INFO: renamed from: isSelfDelete-impl, reason: not valid java name */
        public static final boolean m11935isSelfDeleteimpl(int i) {
            return m11927containsimpl(i, 1024);
        }

        /* JADX INFO: renamed from: isSelfMove-impl, reason: not valid java name */
        public static final boolean m11937isSelfMoveimpl(int i) {
            return m11927containsimpl(i, 2048);
        }

        /* JADX INFO: renamed from: isSelfEvent-impl, reason: not valid java name */
        public static final boolean m11936isSelfEventimpl(int i) {
            return m11935isSelfDeleteimpl(i) || m11937isSelfMoveimpl(i);
        }

        /* JADX INFO: renamed from: or-M3vCxXk, reason: not valid java name */
        public static final int m11938orM3vCxXk(int i, int i2) {
            return m11926constructorimpl(i | i2);
        }

        /* JADX INFO: renamed from: toUnifiedTypes-impl, reason: not valid java name */
        public static final List<WatchEventType> m11940toUnifiedTypesimpl(int i) {
            ArrayList arrayList = new ArrayList();
            if (m11927containsimpl(i, 256)) {
                arrayList.add(WatchEventType.CREATED);
            }
            if (m11927containsimpl(i, 2)) {
                arrayList.add(WatchEventType.MODIFIED);
            }
            if (m11927containsimpl(i, 512)) {
                arrayList.add(WatchEventType.DELETED);
            }
            if (m11933isMoveFromimpl(i) || m11934isMoveToimpl(i)) {
                arrayList.add(WatchEventType.RENAMED);
            }
            ArrayList arrayListListOf = arrayList;
            if (arrayListListOf.isEmpty()) {
                arrayListListOf = CollectionsKt.listOf(WatchEventType.MODIFIED);
            }
            return arrayListListOf;
        }

        /* JADX INFO: compiled from: FileSystemWatcher.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lexpo/modules/filesystem/FileSystemWatcher$WatchEventFlags$Companion;", "", "<init>", "()V", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT, "Lexpo/modules/filesystem/FileSystemWatcher$WatchEventFlags;", "getNONE-ocRs8C0", "()I", "I", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getNONE-ocRs8C0, reason: not valid java name */
            public final int m11942getNONEocRs8C0() {
                return WatchEventFlags.NONE;
            }
        }
    }

    /* JADX INFO: renamed from: flagsFor-PQnVR-E, reason: not valid java name */
    private final int m11915flagsForPQnVRE(List<MergedEvent> list, String str) {
        Object next;
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((MergedEvent) next).getChangedPath(), str));
        MergedEvent mergedEvent = (MergedEvent) next;
        return mergedEvent != null ? mergedEvent.m11919getFlagsocRs8C0() : WatchEventFlags.INSTANCE.m11942getNONEocRs8C0();
    }

    private final List<MergedEvent> mergeEvents(Map<String, ? extends List<PendingEvent>> eventsSnapshot) {
        ArrayList arrayList = new ArrayList(eventsSnapshot.size());
        for (Map.Entry<String, ? extends List<PendingEvent>> entry : eventsSnapshot.entrySet()) {
            String key = entry.getKey();
            List<PendingEvent> value = entry.getValue();
            int iM11942getNONEocRs8C0 = WatchEventFlags.INSTANCE.m11942getNONEocRs8C0();
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                iM11942getNONEocRs8C0 = WatchEventFlags.m11938orM3vCxXk(iM11942getNONEocRs8C0, ((PendingEvent) it.next()).m11920getFlagsocRs8C0());
            }
            boolean z = false;
            if (!(value instanceof Collection) || !value.isEmpty()) {
                Iterator<T> it2 = value.iterator();
                while (it2.hasNext()) {
                    if (((PendingEvent) it2.next()).isDirectory()) {
                        z = true;
                        break;
                    }
                }
            }
            arrayList.add(new MergedEvent(key, iM11942getNONEocRs8C0, z, null));
        }
        return arrayList;
    }
}
