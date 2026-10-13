package androidx.camera.lifecycle;

import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.Logger;
import androidx.camera.core.RotationProvider;
import androidx.camera.core.SessionConfig;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class LifecycleCameraRepository {
    private static final String TAG = "LifecycleCameraRepository";
    private final ArrayDeque<LifecycleOwner> mActiveLifecycleOwners;
    CameraCoordinator mCameraCoordinator;
    private final Map<Key, LifecycleCamera> mCameraMap;
    private final int mDeviceId;
    private final Map<LifecycleCameraRepositoryObserver, Set<Key>> mLifecycleObserverMap;
    private final Object mLock;

    @Retention(RetentionPolicy.SOURCE)
    @interface FromUseCaseAdapter {
    }

    LifecycleCameraRepository() {
        this(ContextUtil.getDefaultDeviceId());
    }

    LifecycleCameraRepository(int i) {
        this.mLock = new Object();
        this.mCameraMap = new HashMap();
        this.mLifecycleObserverMap = new HashMap();
        this.mActiveLifecycleOwners = new ArrayDeque<>();
        this.mDeviceId = i;
    }

    int getDeviceId() {
        return this.mDeviceId;
    }

    LifecycleCamera createLifecycleCamera(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter cameraUseCaseAdapter, RotationProvider rotationProvider) {
        synchronized (this.mLock) {
            Preconditions.checkArgument(this.mCameraMap.get(Key.create(lifecycleOwner, cameraUseCaseAdapter.getAdapterIdentifier())) == null, "LifecycleCamera already exists for the given LifecycleOwner and set of cameras");
            LifecycleCamera lifecycleCamera = new LifecycleCamera(lifecycleOwner, cameraUseCaseAdapter, rotationProvider);
            if (cameraUseCaseAdapter.getUseCases().isEmpty()) {
                lifecycleCamera.suspend();
            }
            if (lifecycleOwner.getLifecycle().getState() == Lifecycle.State.DESTROYED) {
                return lifecycleCamera;
            }
            registerCamera(lifecycleCamera);
            return lifecycleCamera;
        }
    }

    LifecycleCamera getLifecycleCamera(LifecycleOwner lifecycleOwner, CameraIdentifier cameraIdentifier) {
        synchronized (this.mLock) {
            LifecycleCamera lifecycleCamera = this.mCameraMap.get(Key.create(lifecycleOwner, cameraIdentifier));
            if (lifecycleCamera == null || !lifecycleCamera.getCameraUseCaseAdapter().isRemoved()) {
                return lifecycleCamera;
            }
            unregisterCamera(lifecycleCamera);
            return null;
        }
    }

    Collection<LifecycleCamera> getLifecycleCameras() {
        Collection<LifecycleCamera> collectionUnmodifiableCollection;
        synchronized (this.mLock) {
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(this.mCameraMap.values());
        }
        return collectionUnmodifiableCollection;
    }

    void removeLifecycleCameras(Set<Key> set) {
        synchronized (this.mLock) {
            if (set == null) {
                try {
                    set = this.mCameraMap.keySet();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (Key key : set) {
                if (this.mCameraMap.containsKey(key)) {
                    unregisterCamera(this.mCameraMap.get(key));
                }
            }
        }
    }

    void clear() {
        synchronized (this.mLock) {
            Iterator it = new HashSet(this.mLifecycleObserverMap.keySet()).iterator();
            while (it.hasNext()) {
                unregisterLifecycle(((LifecycleCameraRepositoryObserver) it.next()).getLifecycleOwner());
            }
        }
    }

    private void registerCamera(LifecycleCamera lifecycleCamera) {
        Set<Key> hashSet;
        synchronized (this.mLock) {
            LifecycleOwner lifecycleOwner = lifecycleCamera.getLifecycleOwner();
            Key keyCreate = Key.create(lifecycleOwner, lifecycleCamera.getCameraUseCaseAdapter().getAdapterIdentifier());
            LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
            if (lifecycleCameraRepositoryObserver != null) {
                hashSet = this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver);
            } else {
                hashSet = new HashSet<>();
            }
            hashSet.add(keyCreate);
            this.mCameraMap.put(keyCreate, lifecycleCamera);
            if (lifecycleCameraRepositoryObserver == null) {
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver2 = new LifecycleCameraRepositoryObserver(lifecycleOwner, this);
                this.mLifecycleObserverMap.put(lifecycleCameraRepositoryObserver2, hashSet);
                lifecycleOwner.getLifecycle().addObserver(lifecycleCameraRepositoryObserver2);
            }
        }
    }

    private void unregisterCamera(LifecycleCamera lifecycleCamera) {
        synchronized (this.mLock) {
            LifecycleOwner lifecycleOwner = lifecycleCamera.getLifecycleOwner();
            Key keyCreate = Key.create(lifecycleOwner, lifecycleCamera.getCameraUseCaseAdapter().getAdapterIdentifier());
            this.mCameraMap.remove(keyCreate);
            HashSet hashSet = new HashSet();
            for (LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver : this.mLifecycleObserverMap.keySet()) {
                if (lifecycleOwner.equals(lifecycleCameraRepositoryObserver.getLifecycleOwner())) {
                    Set<Key> set = this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver);
                    set.remove(keyCreate);
                    if (set.isEmpty()) {
                        hashSet.add(lifecycleCameraRepositoryObserver.getLifecycleOwner());
                    }
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                unregisterLifecycle((LifecycleOwner) it.next());
            }
        }
    }

    void unregisterLifecycle(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
            if (lifecycleCameraRepositoryObserver == null) {
                return;
            }
            setInactive(lifecycleOwner);
            Iterator<Key> it = this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver).iterator();
            while (it.hasNext()) {
                this.mCameraMap.remove(it.next());
            }
            this.mLifecycleObserverMap.remove(lifecycleCameraRepositoryObserver);
            lifecycleCameraRepositoryObserver.getLifecycleOwner().getLifecycle().removeObserver(lifecycleCameraRepositoryObserver);
        }
    }

    private LifecycleCameraRepositoryObserver getLifecycleCameraRepositoryObserver(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            for (LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver : this.mLifecycleObserverMap.keySet()) {
                if (lifecycleOwner.equals(lifecycleCameraRepositoryObserver.getLifecycleOwner())) {
                    return lifecycleCameraRepositoryObserver;
                }
            }
            return null;
        }
    }

    void bindToLifecycleCamera(LifecycleCamera lifecycleCamera, SessionConfig sessionConfig, CameraCoordinator cameraCoordinator) {
        synchronized (this.mLock) {
            Preconditions.checkArgument(!sessionConfig.getUseCases().isEmpty());
            this.mCameraCoordinator = cameraCoordinator;
            LifecycleOwner lifecycleOwner = lifecycleCamera.getLifecycleOwner();
            pruneStaleLifecycleCameras(lifecycleOwner);
            LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
            if (lifecycleCameraRepositoryObserver == null) {
                return;
            }
            Set<Key> set = this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver);
            CameraCoordinator cameraCoordinator2 = this.mCameraCoordinator;
            if (cameraCoordinator2 == null || cameraCoordinator2.getCameraOperatingMode() != 2) {
                Iterator<Key> it = set.iterator();
                while (it.hasNext()) {
                    LifecycleCamera lifecycleCamera2 = (LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(it.next()));
                    if (!lifecycleCamera2.equals(lifecycleCamera) && !lifecycleCamera2.getUseCases().isEmpty()) {
                        if (!lifecycleCamera2.isLegacySessionConfigBound() && !sessionConfig.getIsLegacy()) {
                            lifecycleCamera2.unbindAll();
                        } else {
                            throw new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner. Please unbind first.");
                        }
                    }
                }
            }
            try {
                lifecycleCamera.bind(sessionConfig);
                if (lifecycleOwner.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
                    setActive(lifecycleOwner);
                }
            } catch (CameraUseCaseAdapter.CameraException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    private void pruneStaleLifecycleCameras(LifecycleOwner lifecycleOwner) {
        LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
        if (lifecycleCameraRepositoryObserver == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (Key key : (Set) Objects.requireNonNull(this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver))) {
            LifecycleCamera lifecycleCamera = this.mCameraMap.get(key);
            if (lifecycleCamera != null && lifecycleCamera.getCameraUseCaseAdapter().isRemoved()) {
                hashSet.add(key);
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        Logger.w(TAG, "Removing " + hashSet.size() + " stale LifecycleCamera(s).");
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            unregisterCamera((LifecycleCamera) Objects.requireNonNull(this.mCameraMap.get((Key) it.next())));
        }
    }

    void unbind(SessionConfig sessionConfig) {
        unbind(sessionConfig, null);
    }

    void unbind(SessionConfig sessionConfig, Set<Key> set) {
        synchronized (this.mLock) {
            if (set == null) {
                try {
                    set = this.mCameraMap.keySet();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (Key key : set) {
                if (this.mCameraMap.containsKey(key)) {
                    LifecycleCamera lifecycleCamera = this.mCameraMap.get(key);
                    boolean zIsEmpty = lifecycleCamera.getUseCases().isEmpty();
                    lifecycleCamera.unbind(sessionConfig);
                    if (!zIsEmpty && lifecycleCamera.getUseCases().isEmpty()) {
                        setInactive(lifecycleCamera.getLifecycleOwner());
                    }
                }
            }
        }
    }

    void unbindAll() {
        unbindAll(null);
    }

    void unbindAll(Set<Key> set) {
        synchronized (this.mLock) {
            if (set == null) {
                try {
                    set = this.mCameraMap.keySet();
                } catch (Throwable th) {
                    throw th;
                }
            }
            Iterator<Key> it = set.iterator();
            while (it.hasNext()) {
                LifecycleCamera lifecycleCamera = this.mCameraMap.get(it.next());
                if (lifecycleCamera != null) {
                    lifecycleCamera.unbindAll();
                    setInactive(lifecycleCamera.getLifecycleOwner());
                }
            }
        }
    }

    void setActive(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            if (hasUseCaseBound(lifecycleOwner)) {
                if (this.mActiveLifecycleOwners.isEmpty()) {
                    this.mActiveLifecycleOwners.push(lifecycleOwner);
                } else {
                    CameraCoordinator cameraCoordinator = this.mCameraCoordinator;
                    if (cameraCoordinator == null || cameraCoordinator.getCameraOperatingMode() != 2) {
                        LifecycleOwner lifecycleOwnerPeek = this.mActiveLifecycleOwners.peek();
                        if (!lifecycleOwner.equals(lifecycleOwnerPeek)) {
                            suspendUseCases(lifecycleOwnerPeek);
                            this.mActiveLifecycleOwners.remove(lifecycleOwner);
                            this.mActiveLifecycleOwners.push(lifecycleOwner);
                        }
                    }
                }
                unsuspendUseCases(lifecycleOwner);
            }
        }
    }

    void setInactive(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            this.mActiveLifecycleOwners.remove(lifecycleOwner);
            suspendUseCases(lifecycleOwner);
            if (!this.mActiveLifecycleOwners.isEmpty()) {
                unsuspendUseCases(this.mActiveLifecycleOwners.peek());
            }
        }
    }

    private boolean hasUseCaseBound(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
            if (lifecycleCameraRepositoryObserver == null) {
                return false;
            }
            Iterator<Key> it = this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver).iterator();
            while (it.hasNext()) {
                if (!((LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(it.next()))).getUseCases().isEmpty()) {
                    return true;
                }
            }
            return false;
        }
    }

    private void suspendUseCases(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
            if (lifecycleCameraRepositoryObserver == null) {
                return;
            }
            Iterator<Key> it = this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver).iterator();
            while (it.hasNext()) {
                ((LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(it.next()))).suspend();
            }
        }
    }

    private void unsuspendUseCases(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            Iterator<Key> it = this.mLifecycleObserverMap.get(getLifecycleCameraRepositoryObserver(lifecycleOwner)).iterator();
            while (it.hasNext()) {
                LifecycleCamera lifecycleCamera = this.mCameraMap.get(it.next());
                if (!((LifecycleCamera) Preconditions.checkNotNull(lifecycleCamera)).getUseCases().isEmpty()) {
                    lifecycleCamera.unsuspend();
                }
            }
        }
    }

    static abstract class Key {
        public abstract CameraIdentifier getCameraIdentifier();

        public abstract int getLifecycleOwnerHash();

        Key() {
        }

        static Key create(LifecycleOwner lifecycleOwner, CameraIdentifier cameraIdentifier) {
            return new AutoValue_LifecycleCameraRepository_Key(System.identityHashCode(lifecycleOwner), cameraIdentifier);
        }
    }

    private static class LifecycleCameraRepositoryObserver implements LifecycleObserver {
        private final LifecycleCameraRepository mLifecycleCameraRepository;
        private final LifecycleOwner mLifecycleOwner;

        LifecycleCameraRepositoryObserver(LifecycleOwner lifecycleOwner, LifecycleCameraRepository lifecycleCameraRepository) {
            this.mLifecycleOwner = lifecycleOwner;
            this.mLifecycleCameraRepository = lifecycleCameraRepository;
        }

        LifecycleOwner getLifecycleOwner() {
            return this.mLifecycleOwner;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart(LifecycleOwner lifecycleOwner) {
            this.mLifecycleCameraRepository.setActive(lifecycleOwner);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStop(LifecycleOwner lifecycleOwner) {
            this.mLifecycleCameraRepository.setInactive(lifecycleOwner);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy(LifecycleOwner lifecycleOwner) {
            this.mLifecycleCameraRepository.unregisterLifecycle(lifecycleOwner);
        }
    }
}
