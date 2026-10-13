package expo.modules.kasada;

import android.content.Context;
import androidx.tracing.Trace;
import com.datadog.android.log.LogAttributes;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.TypeDescriptorOfKt;
import io.mobileshield.sdk.InitializeException;
import io.mobileshield.sdk.MobileShield;
import io.mobileshield.sdk.MobileShieldReadinessListener;
import io.mobileshield.sdk.Priority;
import io.mobileshield.sdk.config.Config;
import io.mobileshield.sdk.config.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import org.bouncycastle.i18n.ErrorBundle;

/* JADX INFO: compiled from: KasadaModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\rH\u0002J \u0010\u000e\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00110\rH\u0002J\u001c\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u001c\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002J&\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lexpo/modules/kasada/KasadaModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "startupState", "Lexpo/modules/kasada/KasadaModule$StartupState;", "startupFailureReason", "", "startupFailureDetails", "startupPromises", "", "Lexpo/modules/kotlin/Promise;", "startupResult", "", "resolveStartupPromises", "", "result", "", "failStartup", "reason", ErrorBundle.DETAIL_ENTRY, "completeStartup", "unavailableStartup", "startMobileShield", "userAgent", LogAttributes.HOST, "protectedEndpoints", "", "mapStartupFailureReason", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "StartupState", "kasada_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KasadaModule extends Module {
    private String startupFailureDetails;
    private String startupFailureReason;
    private StartupState startupState = StartupState.IDLE;
    private final List<Promise> startupPromises = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: KasadaModule.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/kasada/KasadaModule$StartupState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "STARTING", "READY", "FAILED", "kasada_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    enum StartupState {
        IDLE,
        STARTING,
        READY,
        FAILED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<StartupState> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: KasadaModule.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StartupState.values().length];
            try {
                iArr[StartupState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StartupState.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StartupState.STARTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StartupState.IDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized Map<String, String> startupResult() {
        Pair[] pairArr;
        String str;
        pairArr = new Pair[3];
        int i = WhenMappings.$EnumSwitchMapping$0[this.startupState.ordinal()];
        if (i == 1) {
            str = "ready";
        } else if (i == 2) {
            str = "failed";
        } else if (i == 3) {
            str = "starting";
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            str = "idle";
        }
        pairArr[0] = TuplesKt.to("state", str);
        pairArr[1] = TuplesKt.to("reason", this.startupFailureReason);
        pairArr[2] = TuplesKt.to(ErrorBundle.DETAIL_ENTRY, this.startupFailureDetails);
        return MapsKt.mapOf(pairArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void resolveStartupPromises$default(KasadaModule kasadaModule, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = kasadaModule.startupResult();
        }
        kasadaModule.resolveStartupPromises(map);
    }

    private final synchronized void resolveStartupPromises(Map<String, ? extends Object> result) {
        List list = CollectionsKt.toList(this.startupPromises);
        this.startupPromises.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Promise) it.next()).resolve(result);
        }
    }

    static /* synthetic */ void failStartup$default(KasadaModule kasadaModule, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        kasadaModule.failStartup(str, str2);
    }

    private final void failStartup(String reason, String details) {
        synchronized (this) {
            this.startupState = StartupState.FAILED;
            this.startupFailureReason = reason;
            this.startupFailureDetails = details;
            Unit unit = Unit.INSTANCE;
        }
        resolveStartupPromises$default(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void completeStartup() {
        synchronized (this) {
            this.startupState = StartupState.READY;
            this.startupFailureReason = null;
            this.startupFailureDetails = null;
            Unit unit = Unit.INSTANCE;
        }
        resolveStartupPromises$default(this, null, 1, null);
    }

    static /* synthetic */ void unavailableStartup$default(KasadaModule kasadaModule, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        kasadaModule.unavailableStartup(str, str2);
    }

    private final void unavailableStartup(String reason, String details) {
        Map<String, ? extends Object> mapMapOf = MapsKt.mapOf(TuplesKt.to("state", "unavailable"), TuplesKt.to("reason", reason), TuplesKt.to(ErrorBundle.DETAIL_ENTRY, details));
        synchronized (this) {
            this.startupState = StartupState.IDLE;
            this.startupFailureReason = reason;
            this.startupFailureDetails = details;
            Unit unit = Unit.INSTANCE;
        }
        resolveStartupPromises(mapMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startMobileShield(String userAgent, String host, List<String> protectedEndpoints) {
        try {
            List<String> list = protectedEndpoints;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Config.INSTANCE.create(Method.POST, host, (String) it.next()));
            }
            Config[] configArr = (Config[]) arrayList.toArray(new Config[0]);
            Context reactContext = getAppContext().getReactContext();
            Context applicationContext = reactContext != null ? reactContext.getApplicationContext() : null;
            if (applicationContext == null) {
                unavailableStartup$default(this, "NO_CONTEXT", null, 2, null);
            } else {
                MobileShield.init(applicationContext, userAgent, new MobileShieldReadinessListener() { // from class: expo.modules.kasada.KasadaModule.startMobileShield.1
                    @Override // io.mobileshield.sdk.MobileShieldReadinessListener
                    public /* bridge */ void onAwaitingInterrogation() {
                        super.onAwaitingInterrogation();
                    }

                    @Override // io.mobileshield.sdk.MobileShieldReadinessListener
                    public void onReady() {
                        KasadaModule.this.completeStartup();
                    }

                    @Override // io.mobileshield.sdk.MobileShieldReadinessListener
                    public void onInitialisationInProgress() {
                        KasadaModule kasadaModule = KasadaModule.this;
                        synchronized (kasadaModule) {
                            if (!kasadaModule.startupPromises.isEmpty()) {
                                kasadaModule.startupState = StartupState.STARTING;
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }

                    @Override // io.mobileshield.sdk.MobileShieldReadinessListener
                    public void onUnreachableServer(int reason) {
                        String strMapStartupFailureReason = KasadaModule.this.mapStartupFailureReason(reason);
                        int iHashCode = strMapStartupFailureReason.hashCode();
                        if (iHashCode == -1466757626 ? strMapStartupFailureReason.equals("TIMED_OUT") : iHashCode == -523024468 ? strMapStartupFailureReason.equals("NETWORK_NOT_AVAILABLE") : !(iHashCode != 77867656 || !strMapStartupFailureReason.equals("RETRY"))) {
                            KasadaModule.unavailableStartup$default(KasadaModule.this, strMapStartupFailureReason, null, 2, null);
                        } else {
                            KasadaModule.failStartup$default(KasadaModule.this, strMapStartupFailureReason, null, 2, null);
                        }
                    }
                }, Priority.LOW, (Config[]) Arrays.copyOf(configArr, configArr.length));
            }
        } catch (Throwable th) {
            failStartup("INITIALIZATION_EXCEPTION", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String mapStartupFailureReason(int reason) {
        if (reason == 1) {
            return "TIMED_OUT";
        }
        if (reason == 2) {
            return "NETWORK_NOT_AVAILABLE";
        }
        if (reason == 3) {
            return "PROTECTION_FAILED";
        }
        if (reason == 4) {
            return "RETRY";
        }
        return "UNKNOWN";
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        KasadaModule kasadaModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (kasadaModule.getClass() + ".ModuleDefinition"));
        try {
            final ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(kasadaModule);
            moduleDefinitionBuilder.Name("Kasada");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr = new AnyType[3];
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            Object obj = null;
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError), new Function0<KType>() { // from class: expo.modules.kasada.KasadaModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                if (typeDescriptor == null) {
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2), new Function0<KType>() { // from class: expo.modules.kasada.KasadaModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                    objM12684constructorimpl2 = null;
                }
                TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                if (typeDescriptor2 == null) {
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType2 = new AnyType(typeDescriptor2, converters);
            }
            anyTypeArr[1] = anyType2;
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType3 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3), new Function0<KType>() { // from class: expo.modules.kasada.KasadaModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                        }
                    }));
                } catch (Throwable th3) {
                    Result.Companion companion6 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                    objM12684constructorimpl3 = null;
                }
                TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                if (typeDescriptor3 == null) {
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                }
                anyType3 = new AnyType(typeDescriptor3, converters);
            }
            anyTypeArr[2] = anyType3;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent(ViewProps.START, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kasada.KasadaModule$definition$lambda$0$$inlined$AsyncFunctionWithPromise$4
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    List list = (List) objArr[2];
                    String str = (String) obj3;
                    String str2 = (String) obj2;
                    synchronized (moduleDefinitionBuilder) {
                        int i = KasadaModule.WhenMappings.$EnumSwitchMapping$0[this.startupState.ordinal()];
                        if (i == 1 || i == 2) {
                            promise.resolve(this.startupResult());
                            return;
                        }
                        if (i == 3) {
                            this.startupPromises.add(promise);
                            return;
                        }
                        if (i != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        this.startupState = KasadaModule.StartupState.STARTING;
                        this.startupFailureReason = null;
                        this.startupFailureDetails = null;
                        this.startupPromises.add(promise);
                        this.startMobileShield(str2, str, list);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder2.getAsyncFunctions().put(ViewProps.START, asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getHeaders", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kasada.KasadaModule$definition$lambda$0$$inlined$AsyncFunction$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws InitializeException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws InitializeException {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        MobileShield.getHeaders(new KasadaModule$definition$1$2$1(promise));
                    }
                });
            } else {
                TypeConverterProvider converters2 = moduleDefinitionBuilder3.getConverters();
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType4 == null) {
                    try {
                        Result.Companion companion7 = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4), new Function0<KType>() { // from class: expo.modules.kasada.KasadaModule$definition$lambda$0$$inlined$AsyncFunction$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Promise.class);
                            }
                        }));
                    } catch (Throwable th4) {
                        Result.Companion companion8 = Result.INSTANCE;
                        objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                    }
                    if (!Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                        obj = objM12684constructorimpl4;
                    }
                    TypeDescriptor typeDescriptor4 = (TypeDescriptor) obj;
                    if (typeDescriptor4 == null) {
                        typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Promise.class));
                    }
                    anyType4 = new AnyType(typeDescriptor4, converters2);
                }
                anyTypeArr2[0] = anyType4;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.kasada.KasadaModule$definition$lambda$0$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) throws InitializeException {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        MobileShield.getHeaders(new KasadaModule$definition$1$2$1((Promise) objArr[0]));
                        return Unit.INSTANCE;
                    }
                };
                if (Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    stringAsyncFunctionComponent = new IntAsyncFunctionComponent("getHeaders", anyTypeArr2, function1);
                } else if (Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    stringAsyncFunctionComponent = new BoolAsyncFunctionComponent("getHeaders", anyTypeArr2, function1);
                } else if (Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                    stringAsyncFunctionComponent = new DoubleAsyncFunctionComponent("getHeaders", anyTypeArr2, function1);
                } else if (Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                    stringAsyncFunctionComponent = new FloatAsyncFunctionComponent("getHeaders", anyTypeArr2, function1);
                } else {
                    stringAsyncFunctionComponent = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("getHeaders", anyTypeArr2, function1) : new UntypedAsyncFunctionComponent("getHeaders", anyTypeArr2, function1);
                }
                asyncFunctionWithPromiseComponent = stringAsyncFunctionComponent;
            }
            AsyncFunctionComponent asyncFunctionComponent = asyncFunctionWithPromiseComponent;
            moduleDefinitionBuilder3.getAsyncFunctions().put("getHeaders", asyncFunctionWithPromiseComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionWithPromiseComponent;
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th5) {
            Trace.endSection();
            throw th5;
        }
    }
}
