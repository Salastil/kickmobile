package androidx.camera.camera2.impl;

import androidx.camera.camera2.adapter.ZslControlNoOpImpl;
import androidx.camera.camera2.compat.quirk.CameraQuirks;
import androidx.camera.camera2.compat.workaround.TemplateParamsQuirkOverride;
import androidx.camera.camera2.config.CameraConfig;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.ConfigQueryResult;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.StreamFormat;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import androidx.camera.core.featuregroup.impl.FeatureCombinationQuery;
import androidx.camera.core.impl.SessionConfig;
import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: FeatureCombinationQueryImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/camera/camera2/impl/FeatureCombinationQueryImpl;", "Landroidx/camera/core/featuregroup/impl/FeatureCombinationQuery;", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "cameraPipe", "Landroidx/camera/camera2/pipe/CameraPipe;", "cameraQuirks", "Landroidx/camera/camera2/compat/quirk/CameraQuirks;", "<init>", "(Landroidx/camera/camera2/pipe/CameraMetadata;Landroidx/camera/camera2/pipe/CameraPipe;Landroidx/camera/camera2/compat/quirk/CameraQuirks;)V", "isSupported", "", "sessionConfig", "Landroidx/camera/core/impl/SessionConfig;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureCombinationQueryImpl implements FeatureCombinationQuery {
    private final CameraMetadata cameraMetadata;
    private final CameraPipe cameraPipe;
    private final CameraQuirks cameraQuirks;

    public FeatureCombinationQueryImpl(CameraMetadata cameraMetadata, CameraPipe cameraPipe, CameraQuirks cameraQuirks) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        Intrinsics.checkNotNullParameter(cameraPipe, "cameraPipe");
        Intrinsics.checkNotNullParameter(cameraQuirks, "cameraQuirks");
        this.cameraMetadata = cameraMetadata;
        this.cameraPipe = cameraPipe;
        this.cameraQuirks = cameraQuirks;
    }

    @Override // androidx.camera.core.featuregroup.impl.FeatureCombinationQuery
    public boolean isSupported(SessionConfig sessionConfig) {
        Intrinsics.checkNotNullParameter(sessionConfig, "sessionConfig");
        return ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(CameraGraphConfigProvider.m88create79VDu0o$default(new CameraGraphConfigProvider(new CameraCallbackMap(), new ComboRequestListener(), new CameraConfig(this.cameraMetadata.getCamera(), null), this.cameraQuirks, new ZslControlNoOpImpl(), new TemplateParamsQuirkOverride(this.cameraQuirks.getQuirks()), this.cameraMetadata, null, null, 384, null), CameraGraph.OperatingMode.INSTANCE.m417getNORMAL2uNL3no(), sessionConfig, true, null, null, null, null, TimeseriesConfiguration.DEFAULT_BUFFER_SIZE, null), null), 1, null)).booleanValue();
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.FeatureCombinationQueryImpl$isSupported$1, reason: invalid class name */
    /* JADX INFO: compiled from: FeatureCombinationQueryImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.FeatureCombinationQueryImpl$isSupported$1", f = "FeatureCombinationQueryImpl.kt", i = {}, l = {EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ CameraGraphConfigProvider.CameraGraphCreationResult $creationResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CameraGraphConfigProvider.CameraGraphCreationResult cameraGraphCreationResult, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$creationResult = cameraGraphCreationResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeatureCombinationQueryImpl.this.new AnonymousClass1(this.$creationResult, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = FeatureCombinationQueryImpl.this.cameraPipe.mo451isConfigSupportedNpXggIU(this.$creationResult.getConfig(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CameraGraphConfigProvider.CameraGraphCreationResult cameraGraphCreationResult = this.$creationResult;
            ConfigQueryResult configQueryResult = (ConfigQueryResult) obj;
            int value = configQueryResult.getValue();
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                String str = Camera2Logger.TRUNCATED_TAG;
                List<CameraStream.Config> streams = cameraGraphCreationResult.getConfig().getStreams();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(streams, 10));
                Iterator<T> it = streams.iterator();
                while (it.hasNext()) {
                    List<OutputStream.Config> outputs = ((CameraStream.Config) it.next()).getOutputs();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(outputs, 10));
                    for (OutputStream.Config config : outputs) {
                        arrayList2.add("size=" + config.getSize() + ", format=" + ((Object) StreamFormat.m752toStringimpl(config.getFormat())) + ", dynamicRangeProfile" + config.getDynamicRangeProfile());
                    }
                    arrayList.add(arrayList2);
                }
                android.util.Log.d(str, "FeatureCombinationQueryImpl#isSupported: result = " + ((Object) ConfigQueryResult.m474toStringimpl(value)) + " for sessionParameters = " + cameraGraphCreationResult.getConfig().getSessionParameters() + " and streams = " + arrayList);
            }
            return Boxing.boxBoolean(ConfigQueryResult.m472equalsimpl0(configQueryResult.getValue(), ConfigQueryResult.INSTANCE.m476getSUPPORTEDXp6DSB4()));
        }
    }
}
