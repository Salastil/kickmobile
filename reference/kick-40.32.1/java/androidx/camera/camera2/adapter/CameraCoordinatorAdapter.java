package androidx.camera.camera2.adapter;

import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.internal.CameraCompatibilityFilter;
import androidx.camera.camera2.pipe.CameraDevices;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.CameraUpdateException;
import androidx.camera.core.impl.InternalCameraPresenceListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraCoordinatorAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\fH\u0016J\u0016\u0010@\u001a\u00020>2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001eH\u0016J\u0014\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\u001e0\u001eH\u0016J\u000e\u0010D\u001a\b\u0012\u0004\u0012\u00020%0\u001eH\u0016J\u0010\u0010E\u001a\u00020>2\u0006\u0010F\u001a\u00020%H\u0016J\u0010\u0010G\u001a\u00020>2\u0006\u0010F\u001a\u00020%H\u0016J\u0016\u0010H\u001a\u00020>2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020%0\u001eH\u0016J\b\u0010J\u001a\u00020>H\u0002J\u0012\u0010K\u001a\u0004\u0018\u00010\u001d2\u0006\u0010L\u001a\u00020\u001dH\u0016J\b\u0010M\u001a\u000200H\u0016J\u0010\u0010N\u001a\u00020>2\u0006\u0010O\u001a\u000200H\u0016J\u0010\u0010P\u001a\u00020>2\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u00020>2\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010T\u001a\u00020>H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R0\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR6\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001e0\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010\u000e\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001d0,8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R$\u0010/\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u000e\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0002078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u0010\u000e\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006U"}, d2 = {"Landroidx/camera/camera2/adapter/CameraCoordinatorAdapter;", "Landroidx/camera/core/concurrent/CameraCoordinator;", "Landroidx/camera/core/impl/InternalCameraPresenceListener;", "cameraPipe", "Landroidx/camera/camera2/pipe/CameraPipe;", "cameraDevices", "Landroidx/camera/camera2/pipe/CameraDevices;", "<init>", "(Landroidx/camera/camera2/pipe/CameraPipe;Landroidx/camera/camera2/pipe/CameraDevices;)V", "lock", "", "cameraRepository", "Landroidx/camera/core/impl/CameraRepository;", "getCameraRepository$annotations", "()V", "getCameraRepository", "()Landroidx/camera/core/impl/CameraRepository;", "setCameraRepository", "(Landroidx/camera/core/impl/CameraRepository;)V", "concurrentCameraIdsSet", "", "Landroidx/camera/camera2/pipe/CameraId;", "getConcurrentCameraIdsSet$annotations", "getConcurrentCameraIdsSet", "()Ljava/util/Set;", "setConcurrentCameraIdsSet", "(Ljava/util/Set;)V", "concurrentCameraIdMap", "", "", "", "getConcurrentCameraIdMap$annotations", "getConcurrentCameraIdMap", "()Ljava/util/Map;", "setConcurrentCameraIdMap", "(Ljava/util/Map;)V", "activeConcurrentCameraInfosList", "Landroidx/camera/core/CameraInfo;", "getActiveConcurrentCameraInfosList$annotations", "getActiveConcurrentCameraInfosList", "()Ljava/util/List;", "setActiveConcurrentCameraInfosList", "(Ljava/util/List;)V", "pendingCameraIds", "", "getPendingCameraIds", "setPendingCameraIds", "concurrentMode", "", "getConcurrentMode$annotations", "getConcurrentMode", "()I", "setConcurrentMode", "(I)V", "concurrentModeOn", "", "getConcurrentModeOn$annotations", "getConcurrentModeOn", "()Z", "setConcurrentModeOn", "(Z)V", "init", "", "repository", "onCamerasUpdated", "cameraIds", "getConcurrentCameraSelectors", "Landroidx/camera/core/CameraSelector;", "getActiveConcurrentCameraInfos", "addPendingCameraInfo", "cameraInfo", "removePendingCameraInfo", "setActiveConcurrentCameraInfos", "cameraInfos", "tryStartConcurrentGraph", "getPairedConcurrentCameraId", "cameraId", "getCameraOperatingMode", "setCameraOperatingMode", "cameraOperatingMode", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/camera/core/concurrent/CameraCoordinator$ConcurrentCameraModeListener;", "removeListener", "shutdown", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraCoordinatorAdapter implements CameraCoordinator, InternalCameraPresenceListener {
    private List<? extends CameraInfo> activeConcurrentCameraInfosList;
    private final CameraDevices cameraDevices;
    private CameraPipe cameraPipe;
    private CameraRepository cameraRepository;
    private Map<String, ? extends List<String>> concurrentCameraIdMap;
    private Set<? extends Set<CameraId>> concurrentCameraIdsSet;
    private int concurrentMode;
    private boolean concurrentModeOn;
    private final Object lock;
    private List<String> pendingCameraIds;

    public static /* synthetic */ void getActiveConcurrentCameraInfosList$annotations() {
    }

    public static /* synthetic */ void getCameraRepository$annotations() {
    }

    public static /* synthetic */ void getConcurrentCameraIdMap$annotations() {
    }

    public static /* synthetic */ void getConcurrentCameraIdsSet$annotations() {
    }

    public static /* synthetic */ void getConcurrentMode$annotations() {
    }

    public static /* synthetic */ void getConcurrentModeOn$annotations() {
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void addListener(CameraCoordinator.ConcurrentCameraModeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void removeListener(CameraCoordinator.ConcurrentCameraModeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public CameraCoordinatorAdapter(CameraPipe cameraPipe, CameraDevices cameraDevices) {
        Intrinsics.checkNotNullParameter(cameraDevices, "cameraDevices");
        this.cameraPipe = cameraPipe;
        this.cameraDevices = cameraDevices;
        this.lock = new Object();
        this.concurrentCameraIdsSet = SetsKt.emptySet();
        this.concurrentCameraIdMap = MapsKt.emptyMap();
        this.activeConcurrentCameraInfosList = CollectionsKt.emptyList();
        this.pendingCameraIds = new ArrayList();
    }

    public final CameraRepository getCameraRepository() {
        return this.cameraRepository;
    }

    public final void setCameraRepository(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    public final Set<Set<CameraId>> getConcurrentCameraIdsSet() {
        return this.concurrentCameraIdsSet;
    }

    public final void setConcurrentCameraIdsSet(Set<? extends Set<CameraId>> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.concurrentCameraIdsSet = set;
    }

    public final Map<String, List<String>> getConcurrentCameraIdMap() {
        return this.concurrentCameraIdMap;
    }

    public final void setConcurrentCameraIdMap(Map<String, ? extends List<String>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.concurrentCameraIdMap = map;
    }

    public final List<CameraInfo> getActiveConcurrentCameraInfosList() {
        return this.activeConcurrentCameraInfosList;
    }

    public final void setActiveConcurrentCameraInfosList(List<? extends CameraInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.activeConcurrentCameraInfosList = list;
    }

    public final List<String> getPendingCameraIds() {
        return this.pendingCameraIds;
    }

    public final void setPendingCameraIds(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.pendingCameraIds = list;
    }

    public final int getConcurrentMode() {
        return this.concurrentMode;
    }

    public final void setConcurrentMode(int i) {
        this.concurrentMode = i;
    }

    public final boolean getConcurrentModeOn() {
        return this.concurrentModeOn;
    }

    public final void setConcurrentModeOn(boolean z) {
        this.concurrentModeOn = z;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void init(CameraRepository repository) throws CameraUpdateException {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(repository, "repository");
        synchronized (this.lock) {
            this.cameraRepository = repository;
            Unit unit = Unit.INSTANCE;
        }
        List listM311awaitCameraIdsSeavPBo$default = CameraDevices.m311awaitCameraIdsSeavPBo$default(this.cameraDevices, null, 1, null);
        if (listM311awaitCameraIdsSeavPBo$default == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            List list = listM311awaitCameraIdsSeavPBo$default;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((CameraId) it.next()).m433unboximpl());
            }
            arrayListEmptyList = arrayList;
        }
        onCamerasUpdated(arrayListEmptyList);
    }

    @Override // androidx.camera.core.impl.InternalCameraPresenceListener
    public void onCamerasUpdated(List<String> cameraIds) throws CameraUpdateException {
        Intrinsics.checkNotNullParameter(cameraIds, "cameraIds");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Set<Set> setM313awaitConcurrentCameraIdsSeavPBo$default = CameraDevices.m313awaitConcurrentCameraIdsSeavPBo$default(this.cameraDevices, null, 1, null);
            if (setM313awaitConcurrentCameraIdsSeavPBo$default == null) {
                setM313awaitConcurrentCameraIdsSeavPBo$default = SetsKt.emptySet();
            }
            for (Set set : setM313awaitConcurrentCameraIdsSeavPBo$default) {
                Set set2 = set;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set2, 10));
                Iterator it = set2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((CameraId) it.next()).m433unboximpl());
                }
                Set set3 = CollectionsKt.toSet(arrayList);
                if (!cameraIds.containsAll(set3)) {
                    Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                    if (Logger.isWarnEnabled(Log.TAG)) {
                        android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Failed to retrieve concurrent camera: " + set3 + " from " + cameraIds);
                    }
                } else {
                    List list = CollectionsKt.toList(set);
                    if (list.size() >= 2) {
                        String strM433unboximpl = ((CameraId) list.get(0)).m433unboximpl();
                        String strM433unboximpl2 = ((CameraId) list.get(1)).m433unboximpl();
                        try {
                            if (CameraCompatibilityFilter.isBackwardCompatible(strM433unboximpl, this.cameraDevices) && CameraCompatibilityFilter.isBackwardCompatible(strM433unboximpl2, this.cameraDevices)) {
                                linkedHashSet.add(set);
                                if (!linkedHashMap.containsKey(strM433unboximpl)) {
                                    linkedHashMap.put(strM433unboximpl, new ArrayList());
                                }
                                Object obj = linkedHashMap.get(strM433unboximpl);
                                Intrinsics.checkNotNull(obj);
                                ((List) obj).add(strM433unboximpl2);
                                if (!linkedHashMap.containsKey(strM433unboximpl2)) {
                                    linkedHashMap.put(strM433unboximpl2, new ArrayList());
                                }
                                Object obj2 = linkedHashMap.get(strM433unboximpl2);
                                Intrinsics.checkNotNull(obj2);
                                ((List) obj2).add(strM433unboximpl);
                            }
                        } catch (InitializationException e) {
                            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                            if (Logger.isWarnEnabled(Log.TAG)) {
                                android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Skipping incompatible concurrent pair: " + set + " due to " + e.getMessage());
                            }
                        }
                    }
                }
            }
            synchronized (this.lock) {
                this.concurrentCameraIdsSet = linkedHashSet;
                this.concurrentCameraIdMap = linkedHashMap;
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e2) {
            throw new CameraUpdateException("Failed to retrieve concurrent camera id info for camera-pipe.", e2);
        }
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public List<List<CameraSelector>> getConcurrentCameraSelectors() {
        List<List<CameraSelector>> list;
        synchronized (this.lock) {
            Set<? extends Set<CameraId>> set = this.concurrentCameraIdsSet;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                Set set2 = (Set) it.next();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set2, 10));
                Iterator it2 = set2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(CameraSelector.of(CameraIdentifier.Factory.create$default(((CameraId) it2.next()).m433unboximpl(), null, null, 6, null)));
                }
                arrayList.add(CollectionsKt.toList(arrayList2));
            }
            list = CollectionsKt.toList(arrayList);
        }
        return list;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public List<CameraInfo> getActiveConcurrentCameraInfos() {
        ArrayList arrayList;
        synchronized (this.lock) {
            arrayList = new ArrayList(this.activeConcurrentCameraInfosList);
        }
        return arrayList;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void addPendingCameraInfo(CameraInfo cameraInfo) {
        Intrinsics.checkNotNullParameter(cameraInfo, "cameraInfo");
        synchronized (this.lock) {
            if (this.concurrentModeOn) {
                List<String> list = this.pendingCameraIds;
                String strM43getCameraIdzjxgSG8 = CameraInfoAdapter.INSTANCE.m43getCameraIdzjxgSG8(cameraInfo);
                CameraId cameraIdM426boximpl = strM43getCameraIdzjxgSG8 != null ? CameraId.m426boximpl(strM43getCameraIdzjxgSG8) : null;
                if (cameraIdM426boximpl == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                list.add(cameraIdM426boximpl.m433unboximpl());
                tryStartConcurrentGraph();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void removePendingCameraInfo(CameraInfo cameraInfo) {
        Intrinsics.checkNotNullParameter(cameraInfo, "cameraInfo");
        synchronized (this.lock) {
            if (this.concurrentModeOn) {
                List<String> list = this.pendingCameraIds;
                String strM43getCameraIdzjxgSG8 = CameraInfoAdapter.INSTANCE.m43getCameraIdzjxgSG8(cameraInfo);
                CameraId cameraIdM426boximpl = strM43getCameraIdzjxgSG8 != null ? CameraId.m426boximpl(strM43getCameraIdzjxgSG8) : null;
                if (cameraIdM426boximpl == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                list.remove(cameraIdM426boximpl.m433unboximpl());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void setActiveConcurrentCameraInfos(List<? extends CameraInfo> cameraInfos) {
        Intrinsics.checkNotNullParameter(cameraInfos, "cameraInfos");
        synchronized (this.lock) {
            this.activeConcurrentCameraInfosList = cameraInfos;
            tryStartConcurrentGraph();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void tryStartConcurrentGraph() {
        CameraInternalAdapter cameraInternalAdapter;
        synchronized (this.lock) {
            if (!this.activeConcurrentCameraInfosList.isEmpty() && !this.pendingCameraIds.isEmpty()) {
                List<? extends CameraInfo> list = this.activeConcurrentCameraInfosList;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        if (Intrinsics.areEqual(CollectionsKt.toSet(arrayList), CollectionsKt.toSet(this.pendingCameraIds))) {
                            this.pendingCameraIds.clear();
                            List<? extends CameraInfo> list2 = this.activeConcurrentCameraInfosList;
                            synchronized (this.lock) {
                                CameraRepository cameraRepository = this.cameraRepository;
                                if (cameraRepository == null) {
                                    Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                                    if (Logger.isErrorEnabled(Log.TAG)) {
                                        android.util.Log.e(Camera2Logger.TRUNCATED_TAG, "Coordinator has not been initialized with a CameraRepository.");
                                    }
                                    return;
                                }
                                ArrayList arrayList2 = new ArrayList();
                                Iterator<T> it2 = list2.iterator();
                                while (it2.hasNext()) {
                                    try {
                                        String strM43getCameraIdzjxgSG8 = CameraInfoAdapter.INSTANCE.m43getCameraIdzjxgSG8((CameraInfo) it2.next());
                                        Intrinsics.checkNotNull(strM43getCameraIdzjxgSG8);
                                        CameraInternal camera = cameraRepository.getCamera(strM43getCameraIdzjxgSG8);
                                        cameraInternalAdapter = camera instanceof CameraInternalAdapter ? (CameraInternalAdapter) camera : null;
                                    } catch (IllegalArgumentException unused) {
                                    }
                                    if (cameraInternalAdapter != null) {
                                        arrayList2.add(cameraInternalAdapter);
                                    }
                                }
                                ArrayList arrayList3 = arrayList2;
                                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                                Iterator it3 = arrayList3.iterator();
                                while (it3.hasNext()) {
                                    CameraGraph.Config deferredCameraGraphConfig$camera_camera2 = ((CameraInternalAdapter) it3.next()).getDeferredCameraGraphConfig$camera_camera2();
                                    if (deferredCameraGraphConfig$camera_camera2 == null) {
                                        throw new IllegalStateException("Every CameraInternal instance is expected to have a deferred CameraGraph config".toString());
                                    }
                                    arrayList4.add(deferredCameraGraphConfig$camera_camera2);
                                }
                                ArrayList arrayList5 = arrayList4;
                                CameraPipe cameraPipe = this.cameraPipe;
                                if (cameraPipe == null) {
                                    throw new IllegalStateException("Required value was null.".toString());
                                }
                                List<CameraGraph> listCreateCameraGraphs = cameraPipe.createCameraGraphs(new CameraGraph.ConcurrentConfig(arrayList5));
                                if (listCreateCameraGraphs.size() != arrayList5.size()) {
                                    throw new IllegalStateException("Check failed.");
                                }
                                for (Pair pair : CollectionsKt.zip(arrayList3, listCreateCameraGraphs)) {
                                    ((CameraInternalAdapter) pair.component1()).resumeDeferredCameraGraphCreation$camera_camera2((CameraGraph) pair.component2());
                                }
                                return;
                            }
                        }
                        return;
                    }
                    String strM43getCameraIdzjxgSG9 = CameraInfoAdapter.INSTANCE.m43getCameraIdzjxgSG8((CameraInfo) it.next());
                    CameraId cameraIdM426boximpl = strM43getCameraIdzjxgSG9 != null ? CameraId.m426boximpl(strM43getCameraIdzjxgSG9) : null;
                    if (cameraIdM426boximpl == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    arrayList.add(cameraIdM426boximpl.m433unboximpl());
                }
            }
        }
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public String getPairedConcurrentCameraId(String cameraId) {
        String str;
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        synchronized (this.lock) {
            List<String> list = this.concurrentCameraIdMap.get(cameraId);
            str = null;
            if (list != null) {
                loop0: for (String str2 : list) {
                    Iterator<? extends CameraInfo> it = this.activeConcurrentCameraInfosList.iterator();
                    while (it.hasNext()) {
                        String strM43getCameraIdzjxgSG8 = CameraInfoAdapter.INSTANCE.m43getCameraIdzjxgSG8(it.next());
                        if (strM43getCameraIdzjxgSG8 == null) {
                            strM43getCameraIdzjxgSG8 = null;
                        }
                        if (Intrinsics.areEqual(str2, strM43getCameraIdzjxgSG8)) {
                            str = str2;
                            break loop0;
                        }
                    }
                }
            }
        }
        return str;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public int getCameraOperatingMode() {
        int i;
        synchronized (this.lock) {
            i = this.concurrentMode;
        }
        return i;
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void setCameraOperatingMode(int cameraOperatingMode) {
        CameraRepository cameraRepository;
        synchronized (this.lock) {
            this.concurrentMode = cameraOperatingMode;
            cameraRepository = this.cameraRepository;
        }
        if (cameraRepository == null) {
            return;
        }
        boolean z = cameraOperatingMode == 2;
        this.concurrentModeOn = z;
        if (!z) {
            this.activeConcurrentCameraInfosList = CollectionsKt.emptyList();
        }
        Iterator<CameraInternal> it = cameraRepository.getCameras().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            CameraInternal next = it.next();
            CameraInternalAdapter cameraInternalAdapter = next instanceof CameraInternalAdapter ? (CameraInternalAdapter) next : null;
            if (cameraInternalAdapter != null) {
                if (cameraOperatingMode == 1) {
                    cameraInternalAdapter.setCameraGraphCreationMode$camera_camera2(true);
                } else if (cameraOperatingMode == 2) {
                    cameraInternalAdapter.setCameraGraphCreationMode$camera_camera2(false);
                }
            }
        }
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator
    public void shutdown() {
        this.cameraPipe = null;
        this.concurrentModeOn = false;
        synchronized (this.lock) {
            this.cameraRepository = null;
            this.concurrentCameraIdsSet = SetsKt.emptySet();
            this.concurrentCameraIdMap = MapsKt.emptyMap();
            this.activeConcurrentCameraInfosList = CollectionsKt.emptyList();
            this.concurrentMode = 0;
            this.pendingCameraIds.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
