package androidx.camera.camera2.pipe.internal;

import android.os.Trace;
import androidx.camera.camera2.pipe.CameraBackend;
import androidx.camera.camera2.pipe.CameraBackendId;
import androidx.camera.camera2.pipe.CameraBackends;
import androidx.camera.camera2.pipe.CameraDevices;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.Log;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: CameraDevicesImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Singleton
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0017J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0097@¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0097@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096@¢\u0006\u0004\b\u001a\u0010\u000fJ!\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ(\u0010\u001e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001f\u0018\u00010\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096@¢\u0006\u0004\b \u0010\u000fJ'\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001f\u0018\u00010\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\"\u0010#J$\u0010$\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096@¢\u0006\u0004\b&\u0010'J#\u0010(\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b)\u0010*J!\u0010+\u001a\u00020,2\u0006\u0010%\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b-\u0010.J!\u0010/\u001a\u00020,2\u0006\u0010%\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b0\u0010.J'\u00101\u001a\b\u0012\u0004\u0012\u00020,022\u0006\u0010%\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u00020,2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b6\u00107J\u001f\u00108\u001a\b\u0012\u0004\u0012\u00020,022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u00020<2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b=\u0010>R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Landroidx/camera/camera2/pipe/internal/CameraDevicesImpl;", "Landroidx/camera/camera2/pipe/CameraDevices;", "cameraBackends", "Landroidx/camera/camera2/pipe/CameraBackends;", "<init>", "(Landroidx/camera/camera2/pipe/CameraBackends;)V", "findAll", "", "Landroidx/camera/camera2/pipe/CameraId;", "ids", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "camera", "getMetadata-0r8Bogc", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitMetadata", "awaitMetadata-EfqyGwQ", "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/CameraMetadata;", "cameraIdsFlow", "Lkotlinx/coroutines/flow/Flow;", "cameraBackendId", "Landroidx/camera/camera2/pipe/CameraBackendId;", "cameraIdsFlow-SeavPBo", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "getCameraIds", "getCameraIds-iAq86To", "awaitCameraIds", "awaitCameraIds-SeavPBo", "(Ljava/lang/String;)Ljava/util/List;", "getConcurrentCameraIds", "", "getConcurrentCameraIds-iAq86To", "awaitConcurrentCameraIds", "awaitConcurrentCameraIds-SeavPBo", "(Ljava/lang/String;)Ljava/util/Set;", "getCameraMetadata", "cameraId", "getCameraMetadata-_mltaTw", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCameraMetadata", "awaitCameraMetadata-FpsL5FU", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/camera/camera2/pipe/CameraMetadata;", "prewarm", "", "prewarm-FpsL5FU", "(Ljava/lang/String;Ljava/lang/String;)V", "disconnect", "disconnect-FpsL5FU", "disconnectAsync", "Lkotlinx/coroutines/Deferred;", "disconnectAsync-FpsL5FU", "(Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/Deferred;", "disconnectAll", "disconnectAll-SeavPBo", "(Ljava/lang/String;)V", "disconnectAllAsync", "disconnectAllAsync-SeavPBo", "(Ljava/lang/String;)Lkotlinx/coroutines/Deferred;", "getCameraBackend", "Landroidx/camera/camera2/pipe/CameraBackend;", "getCameraBackend-SeavPBo", "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/CameraBackend;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraDevicesImpl implements CameraDevices {
    private final CameraBackends cameraBackends;

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.internal.CameraDevicesImpl$ids$1, reason: invalid class name */
    /* JADX INFO: compiled from: CameraDevicesImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.internal.CameraDevicesImpl", f = "CameraDevicesImpl.kt", i = {}, l = {49}, m = "ids", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraDevicesImpl.this.ids(this);
        }
    }

    @Inject
    public CameraDevicesImpl(CameraBackends cameraBackends) {
        Intrinsics.checkNotNullParameter(cameraBackends, "cameraBackends");
        this.cameraBackends = cameraBackends;
    }

    @Override // androidx.camera.camera2.pipe.CameraDevices
    @Deprecated(level = DeprecationLevel.WARNING, message = "findAll() is not able to specify a specific CameraBackendId to query.", replaceWith = @ReplaceWith(expression = "awaitCameraIds", imports = {}))
    public List<CameraId> findAll() {
        List<CameraId> listM311awaitCameraIdsSeavPBo$default = CameraDevices.m311awaitCameraIdsSeavPBo$default(this, null, 1, null);
        return listM311awaitCameraIdsSeavPBo$default == null ? CollectionsKt.emptyList() : listM311awaitCameraIdsSeavPBo$default;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.camera.camera2.pipe.CameraDevices
    @Deprecated(level = DeprecationLevel.WARNING, message = "ids() is not able to specify a specific CameraBackendId to query.", replaceWith = @ReplaceWith(expression = "getCameraIds", imports = {}))
    public Object ids(Continuation<? super List<CameraId>> continuation) {
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
        Object objM319getCameraIdsiAq86To$default = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objM319getCameraIdsiAq86To$default);
            anonymousClass1.label = 1;
            objM319getCameraIdsiAq86To$default = CameraDevices.m319getCameraIdsiAq86To$default(this, null, anonymousClass1, 1, null);
            if (objM319getCameraIdsiAq86To$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objM319getCameraIdsiAq86To$default);
        }
        List list = (List) objM319getCameraIdsiAq86To$default;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.camera.camera2.pipe.CameraDevices
    @Deprecated(level = DeprecationLevel.WARNING, message = "getMetadata() is not able to specify a specific CameraBackendId to query.", replaceWith = @ReplaceWith(expression = "getCameraMetadata", imports = {}))
    /* JADX INFO: renamed from: getMetadata-0r8Bogc */
    public Object mo335getMetadata0r8Bogc(String str, Continuation<? super CameraMetadata> continuation) {
        CameraDevicesImpl$getMetadata$1 cameraDevicesImpl$getMetadata$1;
        if (continuation instanceof CameraDevicesImpl$getMetadata$1) {
            cameraDevicesImpl$getMetadata$1 = (CameraDevicesImpl$getMetadata$1) continuation;
            if ((cameraDevicesImpl$getMetadata$1.label & Integer.MIN_VALUE) != 0) {
                cameraDevicesImpl$getMetadata$1.label -= Integer.MIN_VALUE;
            } else {
                cameraDevicesImpl$getMetadata$1 = new CameraDevicesImpl$getMetadata$1(this, continuation);
            }
        } else {
            cameraDevicesImpl$getMetadata$1 = new CameraDevicesImpl$getMetadata$1(this, continuation);
        }
        CameraDevicesImpl$getMetadata$1 cameraDevicesImpl$getMetadata$2 = cameraDevicesImpl$getMetadata$1;
        Object objM320getCameraMetadata_mltaTw$default = cameraDevicesImpl$getMetadata$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = cameraDevicesImpl$getMetadata$2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objM320getCameraMetadata_mltaTw$default);
            cameraDevicesImpl$getMetadata$2.label = 1;
            objM320getCameraMetadata_mltaTw$default = CameraDevices.m320getCameraMetadata_mltaTw$default(this, str, null, cameraDevicesImpl$getMetadata$2, 2, null);
            if (objM320getCameraMetadata_mltaTw$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objM320getCameraMetadata_mltaTw$default);
        }
        if (objM320getCameraMetadata_mltaTw$default != null) {
            return objM320getCameraMetadata_mltaTw$default;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // androidx.camera.camera2.pipe.CameraDevices
    @Deprecated(level = DeprecationLevel.WARNING, message = "awaitMetadata() is not able to specify a specific CameraBackendId to query.", replaceWith = @ReplaceWith(expression = "awaitCameraMetadata", imports = {}))
    /* JADX INFO: renamed from: awaitMetadata-EfqyGwQ */
    public CameraMetadata mo326awaitMetadataEfqyGwQ(String camera) {
        Intrinsics.checkNotNullParameter(camera, "camera");
        CameraMetadata cameraMetadataM312awaitCameraMetadataFpsL5FU$default = CameraDevices.m312awaitCameraMetadataFpsL5FU$default(this, camera, null, 2, null);
        if (cameraMetadataM312awaitCameraMetadataFpsL5FU$default != null) {
            return cameraMetadataM312awaitCameraMetadataFpsL5FU$default;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // androidx.camera.camera2.pipe.CameraDevices
    /* JADX INFO: renamed from: cameraIdsFlow-SeavPBo */
    public Flow<List<CameraId>> mo327cameraIdsFlowSeavPBo(String cameraBackendId) {
        return m999getCameraBackendSeavPBo(cameraBackendId).getCameraIds();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.camera.camera2.pipe.CameraDevices
    /* JADX INFO: renamed from: getCameraIds-iAq86To */
    public Object mo332getCameraIdsiAq86To(String str, Continuation<? super List<CameraId>> continuation) {
        CameraDevicesImpl$getCameraIds$1 cameraDevicesImpl$getCameraIds$1;
        CameraBackend cameraBackendM999getCameraBackendSeavPBo;
        if (continuation instanceof CameraDevicesImpl$getCameraIds$1) {
            cameraDevicesImpl$getCameraIds$1 = (CameraDevicesImpl$getCameraIds$1) continuation;
            if ((cameraDevicesImpl$getCameraIds$1.label & Integer.MIN_VALUE) != 0) {
                cameraDevicesImpl$getCameraIds$1.label -= Integer.MIN_VALUE;
            } else {
                cameraDevicesImpl$getCameraIds$1 = new CameraDevicesImpl$getCameraIds$1(this, continuation);
            }
        } else {
            cameraDevicesImpl$getCameraIds$1 = new CameraDevicesImpl$getCameraIds$1(this, continuation);
        }
        Object cameraIds = cameraDevicesImpl$getCameraIds$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = cameraDevicesImpl$getCameraIds$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(cameraIds);
            cameraBackendM999getCameraBackendSeavPBo = m999getCameraBackendSeavPBo(str);
            cameraDevicesImpl$getCameraIds$1.L$0 = cameraBackendM999getCameraBackendSeavPBo;
            cameraDevicesImpl$getCameraIds$1.label = 1;
            cameraIds = cameraBackendM999getCameraBackendSeavPBo.getCameraIds(cameraDevicesImpl$getCameraIds$1);
            if (cameraIds == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cameraBackendM999getCameraBackendSeavPBo = (CameraBackend) cameraDevicesImpl$getCameraIds$1.L$0;
            ResultKt.throwOnFailure(cameraIds);
        }
        List list = (List) cameraIds;
        if (list == null && Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, "Failed to load cameraIds from " + ((Object) CameraBackendId.m240toStringimpl(cameraBackendM999getCameraBackendSeavPBo.mo226getIdQwmhuAM())));
        }
        return list;
    }

    @Override // androidx.camera.camera2.pipe.CameraDevices
    /* JADX INFO: renamed from: awaitCameraIds-SeavPBo */
    public List<CameraId> mo323awaitCameraIdsSeavPBo(String cameraBackendId) {
        CameraBackend cameraBackendM999getCameraBackendSeavPBo = m999getCameraBackendSeavPBo(cameraBackendId);
        List<CameraId> listAwaitCameraIds = cameraBackendM999getCameraBackendSeavPBo.awaitCameraIds();
        if (listAwaitCameraIds == null && Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, "Failed to load cameraIds from " + ((Object) CameraBackendId.m240toStringimpl(cameraBackendM999getCameraBackendSeavPBo.mo226getIdQwmhuAM())));
        }
        return listAwaitCameraIds;
    }

    @Override // androidx.camera.camera2.pipe.CameraDevices
    /* JADX INFO: renamed from: getConcurrentCameraIds-iAq86To */
    public Object mo334getConcurrentCameraIdsiAq86To(String str, Continuation<? super Set<? extends Set<CameraId>>> continuation) {
        return m999getCameraBackendSeavPBo(str).getConcurrentCameraIds(continuation);
    }

    @Override // androidx.camera.camera2.pipe.CameraDevices
    /* JADX INFO: renamed from: awaitConcurrentCameraIds-SeavPBo */
    public Set<Set<CameraId>> mo325awaitConcurrentCameraIdsSeavPBo(String cameraBackendId) {
        return m999getCameraBackendSeavPBo(cameraBackendId).awaitConcurrentCameraIds();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.camera.camera2.pipe.CameraDevices
    /* JADX INFO: renamed from: getCameraMetadata-_mltaTw */
    public Object mo333getCameraMetadata_mltaTw(String str, String str2, Continuation<? super CameraMetadata> continuation) {
        CameraDevicesImpl$getCameraMetadata$1 cameraDevicesImpl$getCameraMetadata$1;
        CameraBackend cameraBackendM999getCameraBackendSeavPBo;
        if (continuation instanceof CameraDevicesImpl$getCameraMetadata$1) {
            cameraDevicesImpl$getCameraMetadata$1 = (CameraDevicesImpl$getCameraMetadata$1) continuation;
            if ((cameraDevicesImpl$getCameraMetadata$1.label & Integer.MIN_VALUE) != 0) {
                cameraDevicesImpl$getCameraMetadata$1.label -= Integer.MIN_VALUE;
            } else {
                cameraDevicesImpl$getCameraMetadata$1 = new CameraDevicesImpl$getCameraMetadata$1(this, continuation);
            }
        } else {
            cameraDevicesImpl$getCameraMetadata$1 = new CameraDevicesImpl$getCameraMetadata$1(this, continuation);
        }
        Object objMo225getCameraMetadata0r8Bogc = cameraDevicesImpl$getCameraMetadata$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = cameraDevicesImpl$getCameraMetadata$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo225getCameraMetadata0r8Bogc);
            cameraBackendM999getCameraBackendSeavPBo = m999getCameraBackendSeavPBo(str2);
            cameraDevicesImpl$getCameraMetadata$1.L$0 = str;
            cameraDevicesImpl$getCameraMetadata$1.L$1 = cameraBackendM999getCameraBackendSeavPBo;
            cameraDevicesImpl$getCameraMetadata$1.label = 1;
            objMo225getCameraMetadata0r8Bogc = cameraBackendM999getCameraBackendSeavPBo.mo225getCameraMetadata0r8Bogc(str, cameraDevicesImpl$getCameraMetadata$1);
            if (objMo225getCameraMetadata0r8Bogc == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cameraBackendM999getCameraBackendSeavPBo = (CameraBackend) cameraDevicesImpl$getCameraMetadata$1.L$1;
            str = (String) cameraDevicesImpl$getCameraMetadata$1.L$0;
            ResultKt.throwOnFailure(objMo225getCameraMetadata0r8Bogc);
        }
        CameraMetadata cameraMetadata = (CameraMetadata) objMo225getCameraMetadata0r8Bogc;
        if (cameraMetadata == null && Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, "Failed to load metadata for " + ((Object) CameraId.m432toStringimpl(str)) + " from " + ((Object) CameraBackendId.m240toStringimpl(cameraBackendM999getCameraBackendSeavPBo.mo226getIdQwmhuAM())));
        }
        return cameraMetadata;
    }

    @Override // androidx.camera.camera2.pipe.CameraDevices
    /* JADX INFO: renamed from: awaitCameraMetadata-FpsL5FU */
    public CameraMetadata mo324awaitCameraMetadataFpsL5FU(String cameraId, String cameraBackendId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        CameraBackend cameraBackendM999getCameraBackendSeavPBo = m999getCameraBackendSeavPBo(cameraBackendId);
        CameraMetadata cameraMetadataMo222awaitCameraMetadataEfqyGwQ = cameraBackendM999getCameraBackendSeavPBo.mo222awaitCameraMetadataEfqyGwQ(cameraId);
        if (cameraMetadataMo222awaitCameraMetadataEfqyGwQ == null && Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, "Failed to load metadata for " + ((Object) CameraId.m432toStringimpl(cameraId)) + " from " + ((Object) CameraBackendId.m240toStringimpl(cameraBackendM999getCameraBackendSeavPBo.mo226getIdQwmhuAM())));
        }
        return cameraMetadataMo222awaitCameraMetadataEfqyGwQ;
    }

    @Override // androidx.camera.camera2.pipe.CameraDevices
    /* JADX INFO: renamed from: prewarm-FpsL5FU */
    public void mo336prewarmFpsL5FU(String cameraId, String cameraBackendId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        m999getCameraBackendSeavPBo(cameraBackendId).mo228prewarmEfqyGwQ(cameraId);
    }

    @Override // androidx.camera.camera2.pipe.CameraDevices
    /* JADX INFO: renamed from: disconnect-FpsL5FU */
    public void mo328disconnectFpsL5FU(String cameraId, String cameraBackendId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        m999getCameraBackendSeavPBo(cameraBackendId).mo223disconnectEfqyGwQ(cameraId);
    }

    @Override // androidx.camera.camera2.pipe.CameraDevices
    /* JADX INFO: renamed from: disconnectAsync-FpsL5FU */
    public Deferred<Unit> mo331disconnectAsyncFpsL5FU(String cameraId, String cameraBackendId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        return m999getCameraBackendSeavPBo(cameraBackendId).mo224disconnectAsyncEfqyGwQ(cameraId);
    }

    @Override // androidx.camera.camera2.pipe.CameraDevices
    /* JADX INFO: renamed from: disconnectAll-SeavPBo */
    public void mo329disconnectAllSeavPBo(String cameraBackendId) {
        m999getCameraBackendSeavPBo(cameraBackendId).disconnectAll();
    }

    @Override // androidx.camera.camera2.pipe.CameraDevices
    /* JADX INFO: renamed from: disconnectAllAsync-SeavPBo */
    public Deferred<Unit> mo330disconnectAllAsyncSeavPBo(String cameraBackendId) {
        return m999getCameraBackendSeavPBo(cameraBackendId).disconnectAllAsync();
    }

    /* JADX INFO: renamed from: getCameraBackend-SeavPBo, reason: not valid java name */
    private final CameraBackend m999getCameraBackendSeavPBo(String cameraBackendId) {
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection("getCameraBackend");
            if (cameraBackendId == null) {
                cameraBackendId = this.cameraBackends.getDefault().mo226getIdQwmhuAM();
            }
            CameraBackend cameraBackendMo242getSG3A4s8 = this.cameraBackends.mo242getSG3A4s8(cameraBackendId);
            if (cameraBackendMo242getSG3A4s8 == null) {
                throw new IllegalStateException(("Failed to load CameraBackend " + ((Object) CameraBackendId.m240toStringimpl(cameraBackendId))).toString());
            }
            Trace.endSection();
            return cameraBackendMo242getSG3A4s8;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }
}
