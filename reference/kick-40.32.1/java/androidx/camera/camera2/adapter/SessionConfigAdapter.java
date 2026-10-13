package androidx.camera.camera2.adapter;

import android.media.MediaCodec;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.internal.StreamUseCaseUtil;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SessionConfigAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 02\u00020\u0001:\u00010B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010#\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010$\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000bJ4\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\u0010\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0\u0003H\u0007J\"\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003H\u0007J\u0016\u0010-\u001a\u00020\f2\f\u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u00010/H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Landroidx/camera/camera2/adapter/SessionConfigAdapter;", "", "useCases", "", "Landroidx/camera/core/UseCase;", "isPrimary", "", "<init>", "(Ljava/util/Collection;Z)V", "surfaceToStreamUseCaseMap", "", "Landroidx/camera/core/impl/DeferrableSurface;", "", "getSurfaceToStreamUseCaseMap", "()Ljava/util/Map;", "surfaceToStreamUseCaseMap$delegate", "Lkotlin/Lazy;", "surfaceToStreamUseHintMap", "getSurfaceToStreamUseHintMap", "surfaceToStreamUseHintMap$delegate", "validatingBuilder", "Landroidx/camera/core/impl/SessionConfig$ValidatingBuilder;", "getValidatingBuilder", "()Landroidx/camera/core/impl/SessionConfig$ValidatingBuilder;", "validatingBuilder$delegate", "sessionConfig", "Landroidx/camera/core/impl/SessionConfig;", "getSessionConfig", "()Landroidx/camera/core/impl/SessionConfig;", "sessionConfig$delegate", "deferrableSurfaces", "", "getDeferrableSurfaces", "()Ljava/util/List;", "deferrableSurfaces$delegate", "getValidSessionConfigOrNull", "isSessionConfigValid", "reportSurfaceInvalid", "", "deferrableSurface", "getSurfaceToStreamUseCaseMapping", "sessionConfigs", "useCaseConfigs", "Landroidx/camera/core/impl/UseCaseConfig;", "getSurfaceToStreamUseHintMapping", "getStreamUseHintForContainerClass", "kClass", "Ljava/lang/Class;", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SessionConfigAdapter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: deferrableSurfaces$delegate, reason: from kotlin metadata */
    private final Lazy deferrableSurfaces;
    private final boolean isPrimary;

    /* JADX INFO: renamed from: sessionConfig$delegate, reason: from kotlin metadata */
    private final Lazy sessionConfig;

    /* JADX INFO: renamed from: surfaceToStreamUseCaseMap$delegate, reason: from kotlin metadata */
    private final Lazy surfaceToStreamUseCaseMap;

    /* JADX INFO: renamed from: surfaceToStreamUseHintMap$delegate, reason: from kotlin metadata */
    private final Lazy surfaceToStreamUseHintMap;
    private final Collection<UseCase> useCases;

    /* JADX INFO: renamed from: validatingBuilder$delegate, reason: from kotlin metadata */
    private final Lazy validatingBuilder;

    /* JADX WARN: Multi-variable type inference failed */
    public SessionConfigAdapter(Collection<? extends UseCase> useCases, boolean z) {
        Intrinsics.checkNotNullParameter(useCases, "useCases");
        this.useCases = useCases;
        this.isPrimary = z;
        this.surfaceToStreamUseCaseMap = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.adapter.SessionConfigAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionConfigAdapter.surfaceToStreamUseCaseMap_delegate$lambda$0(this.f$0);
            }
        });
        this.surfaceToStreamUseHintMap = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.adapter.SessionConfigAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionConfigAdapter.surfaceToStreamUseHintMap_delegate$lambda$0(this.f$0);
            }
        });
        this.validatingBuilder = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.adapter.SessionConfigAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionConfigAdapter.validatingBuilder_delegate$lambda$0(this.f$0);
            }
        });
        this.sessionConfig = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.adapter.SessionConfigAdapter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionConfigAdapter.sessionConfig_delegate$lambda$0(this.f$0);
            }
        });
        this.deferrableSurfaces = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.adapter.SessionConfigAdapter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionConfigAdapter.deferrableSurfaces_delegate$lambda$0(this.f$0);
            }
        });
    }

    public /* synthetic */ SessionConfigAdapter(Collection collection, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(collection, (i & 2) != 0 ? true : z);
    }

    public final Map<DeferrableSurface, Long> getSurfaceToStreamUseCaseMap() {
        return (Map) this.surfaceToStreamUseCaseMap.getValue();
    }

    static final Map surfaceToStreamUseCaseMap_delegate$lambda$0(SessionConfigAdapter sessionConfigAdapter) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (UseCase useCase : sessionConfigAdapter.useCases) {
            arrayList.add(INSTANCE.getSessionConfig(useCase, sessionConfigAdapter.isPrimary));
            UseCaseConfig<?> currentConfig = useCase.getCurrentConfig();
            Intrinsics.checkNotNullExpressionValue(currentConfig, "getCurrentConfig(...)");
            arrayList2.add(currentConfig);
        }
        return sessionConfigAdapter.getSurfaceToStreamUseCaseMapping(arrayList, arrayList2);
    }

    public final Map<DeferrableSurface, Long> getSurfaceToStreamUseHintMap() {
        return (Map) this.surfaceToStreamUseHintMap.getValue();
    }

    static final Map surfaceToStreamUseHintMap_delegate$lambda$0(SessionConfigAdapter sessionConfigAdapter) {
        Collection<UseCase> collection = sessionConfigAdapter.useCases;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.getSessionConfig((UseCase) it.next(), sessionConfigAdapter.isPrimary));
        }
        return sessionConfigAdapter.getSurfaceToStreamUseHintMapping(arrayList);
    }

    private final SessionConfig.ValidatingBuilder getValidatingBuilder() {
        return (SessionConfig.ValidatingBuilder) this.validatingBuilder.getValue();
    }

    static final SessionConfig.ValidatingBuilder validatingBuilder_delegate$lambda$0(SessionConfigAdapter sessionConfigAdapter) {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        Iterator<UseCase> it = sessionConfigAdapter.useCases.iterator();
        while (it.hasNext()) {
            validatingBuilder.add(INSTANCE.getSessionConfig(it.next(), sessionConfigAdapter.isPrimary));
        }
        return validatingBuilder;
    }

    private final SessionConfig getSessionConfig() {
        return (SessionConfig) this.sessionConfig.getValue();
    }

    static final SessionConfig sessionConfig_delegate$lambda$0(SessionConfigAdapter sessionConfigAdapter) {
        if (!sessionConfigAdapter.getValidatingBuilder().isValid()) {
            throw new IllegalStateException("Check failed.");
        }
        SessionConfig sessionConfigBuild = sessionConfigAdapter.getValidatingBuilder().build();
        Intrinsics.checkNotNullExpressionValue(sessionConfigBuild, "build(...)");
        return sessionConfigBuild;
    }

    public final List<DeferrableSurface> getDeferrableSurfaces() {
        Object value = this.deferrableSurfaces.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (List) value;
    }

    static final List deferrableSurfaces_delegate$lambda$0(SessionConfigAdapter sessionConfigAdapter) {
        if (!sessionConfigAdapter.getValidatingBuilder().isValid()) {
            throw new IllegalStateException("Check failed.");
        }
        SessionConfig.OutputConfig postviewOutputConfig = sessionConfigAdapter.getSessionConfig().getPostviewOutputConfig();
        if (postviewOutputConfig != null) {
            ArrayList arrayList = new ArrayList();
            List<DeferrableSurface> surfaces = sessionConfigAdapter.getSessionConfig().getSurfaces();
            Intrinsics.checkNotNullExpressionValue(surfaces, "getSurfaces(...)");
            arrayList.addAll(surfaces);
            DeferrableSurface surface = postviewOutputConfig.getSurface();
            Intrinsics.checkNotNullExpressionValue(surface, "getSurface(...)");
            arrayList.add(surface);
            List listUnmodifiableList = Collections.unmodifiableList(arrayList);
            if (listUnmodifiableList != null) {
                return listUnmodifiableList;
            }
        }
        return sessionConfigAdapter.getSessionConfig().getSurfaces();
    }

    public final SessionConfig getValidSessionConfigOrNull() {
        if (isSessionConfigValid()) {
            return getSessionConfig();
        }
        return null;
    }

    public final boolean isSessionConfigValid() {
        return getValidatingBuilder().isValid();
    }

    public final void reportSurfaceInvalid(DeferrableSurface deferrableSurface) {
        Object next;
        Intrinsics.checkNotNullParameter(deferrableSurface, "deferrableSurface");
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Unavailable " + deferrableSurface + ", notify SessionConfig invalid");
        }
        Iterator<T> it = this.useCases.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!INSTANCE.getSessionConfig((UseCase) next, this.isPrimary).getSurfaces().contains(deferrableSurface));
        UseCase useCase = (UseCase) next;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new AnonymousClass2(useCase != null ? useCase.getSessionConfig() : null, null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.adapter.SessionConfigAdapter$reportSurfaceInvalid$2, reason: invalid class name */
    /* JADX INFO: compiled from: SessionConfigAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.adapter.SessionConfigAdapter$reportSurfaceInvalid$2", f = "SessionConfigAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SessionConfig $sessionConfig;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SessionConfig sessionConfig, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$sessionConfig = sessionConfig;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$sessionConfig, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SessionConfig.ErrorListener errorListener;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SessionConfig sessionConfig = this.$sessionConfig;
            if (sessionConfig != null && (errorListener = sessionConfig.getErrorListener()) != null) {
                errorListener.onError(this.$sessionConfig, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
            }
            return Unit.INSTANCE;
        }
    }

    public final Map<DeferrableSurface, Long> getSurfaceToStreamUseCaseMapping(Collection<SessionConfig> sessionConfigs, Collection<? extends UseCaseConfig<?>> useCaseConfigs) {
        Intrinsics.checkNotNullParameter(sessionConfigs, "sessionConfigs");
        Intrinsics.checkNotNullParameter(useCaseConfigs, "useCaseConfigs");
        Collection<SessionConfig> collection = sessionConfigs;
        if (!collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                if (((SessionConfig) it.next()).getTemplateType() == 5) {
                    Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                    if (Logger.isErrorEnabled(Log.TAG)) {
                        android.util.Log.e(Camera2Logger.TRUNCATED_TAG, "ZSL in populateSurfaceToStreamUseCaseMapping()");
                    }
                    return MapsKt.emptyMap();
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        StreamUseCaseUtil.INSTANCE.populateSurfaceToStreamUseCaseMapping(sessionConfigs, useCaseConfigs, linkedHashMap);
        return linkedHashMap;
    }

    public final Map<DeferrableSurface, Long> getSurfaceToStreamUseHintMapping(Collection<SessionConfig> sessionConfigs) {
        Intrinsics.checkNotNullParameter(sessionConfigs, "sessionConfigs");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (SessionConfig sessionConfig : sessionConfigs) {
            for (DeferrableSurface deferrableSurface : sessionConfig.getSurfaces()) {
                if (sessionConfig.getImplementationOptions().containsOption(Camera2ImplConfig.STREAM_USE_HINT_OPTION) && sessionConfig.getImplementationOptions().retrieveOption(Camera2ImplConfig.STREAM_USE_HINT_OPTION) != null) {
                    Object objRetrieveOption = sessionConfig.getImplementationOptions().retrieveOption(Camera2ImplConfig.STREAM_USE_HINT_OPTION);
                    Intrinsics.checkNotNull(objRetrieveOption);
                    linkedHashMap.put(deferrableSurface, objRetrieveOption);
                } else {
                    linkedHashMap.put(deferrableSurface, Long.valueOf(getStreamUseHintForContainerClass(deferrableSurface.getContainerClass())));
                }
            }
        }
        return linkedHashMap;
    }

    private final long getStreamUseHintForContainerClass(Class<?> kClass) {
        return Intrinsics.areEqual(kClass, MediaCodec.class) ? OutputStream.StreamUseHint.INSTANCE.m673getVIDEO_RECORD4VYZOf8() : OutputStream.StreamUseHint.INSTANCE.m672getDEFAULT4VYZOf8();
    }

    /* JADX INFO: compiled from: SessionConfigAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/adapter/SessionConfigAdapter$Companion;", "", "<init>", "()V", "getSessionConfig", "Landroidx/camera/core/impl/SessionConfig;", "Landroidx/camera/core/UseCase;", "isPrimary", "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SessionConfig getSessionConfig(UseCase useCase, boolean z) {
            SessionConfig secondarySessionConfig;
            String str;
            Intrinsics.checkNotNullParameter(useCase, "<this>");
            if (z) {
                secondarySessionConfig = useCase.getSessionConfig();
                str = "getSessionConfig(...)";
            } else {
                secondarySessionConfig = useCase.getSecondarySessionConfig();
                str = "getSecondarySessionConfig(...)";
            }
            Intrinsics.checkNotNullExpressionValue(secondarySessionConfig, str);
            return secondarySessionConfig;
        }
    }
}
