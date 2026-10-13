package expo.modules.ui;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.OptimizedComposeProps;
import expo.modules.ui.state.ObservableState;
import expo.modules.ui.state.WorkletCallback;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PEmptyArrays;
import io.github.expo.pika.PFunction;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SyncSwitchView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&BM\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\"\b\u0002\u0010\t\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\nj\u0002`\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J#\u0010\u001c\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\nj\u0002`\u000fHÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\"\b\u0002\u0010\t\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\nj\u0002`\u000fHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\f\u0010!\u001a\u0006\u0012\u0002\b\u00030\"H\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\fHÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R+\u0010\t\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\nj\u0002`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lexpo/modules/ui/SyncSwitchProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "isOn", "Lexpo/modules/ui/state/ObservableState;", "onCheckedChangeSync", "Lexpo/modules/ui/state/WorkletCallback;", "enabled", "", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Lexpo/modules/ui/state/ObservableState;Lexpo/modules/ui/state/WorkletCallback;ZLjava/util/List;)V", "()Lexpo/modules/ui/state/ObservableState;", "getOnCheckedChangeSync", "()Lexpo/modules/ui/state/WorkletCallback;", "getEnabled", "()Z", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SyncSwitchProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public boolean enabled;
    public ObservableState isOn;
    public List<Map<String, Dynamic>> modifiers;
    public WorkletCallback onCheckedChangeSync;

    /* JADX INFO: compiled from: SyncSwitchView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/SyncSwitchProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<SyncSwitchProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(SyncSwitchProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("isOn", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ObservableState.class, true, null), 0, __pika, false, true, false), new PProperty("onCheckedChangeSync", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(WorkletCallback.class, true, null), 1, __pika, false, true, false), new PProperty("enabled", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 2, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 3, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SyncSwitchProps");
                return ((SyncSwitchProps) obj).isOn();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SyncSwitchProps");
                return ((SyncSwitchProps) obj).getOnCheckedChangeSync();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SyncSwitchProps");
                return Boolean.valueOf(((SyncSwitchProps) obj).getEnabled());
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SyncSwitchProps");
            return ((SyncSwitchProps) obj).getModifiers();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SyncSwitchProps");
                ((SyncSwitchProps) obj).isOn = (ObservableState) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SyncSwitchProps");
                ((SyncSwitchProps) obj).onCheckedChangeSync = (WorkletCallback) obj2;
            } else {
                if (i == 2) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SyncSwitchProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((SyncSwitchProps) obj).enabled = ((Boolean) obj2).booleanValue();
                    return;
                }
                if (i != 3) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SyncSwitchProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                ((SyncSwitchProps) obj).modifiers = (List) obj2;
            }
        }
    }

    public SyncSwitchProps() {
        this(null, null, false, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyncSwitchProps copy$default(SyncSwitchProps syncSwitchProps, ObservableState observableState, WorkletCallback workletCallback, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            observableState = syncSwitchProps.isOn;
        }
        if ((i & 2) != 0) {
            workletCallback = syncSwitchProps.onCheckedChangeSync;
        }
        if ((i & 4) != 0) {
            z = syncSwitchProps.enabled;
        }
        if ((i & 8) != 0) {
            list = syncSwitchProps.modifiers;
        }
        return syncSwitchProps.copy(observableState, workletCallback, z, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ObservableState getIsOn() {
        return this.isOn;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WorkletCallback getOnCheckedChangeSync() {
        return this.onCheckedChangeSync;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<Map<String, Dynamic>> component4() {
        return this.modifiers;
    }

    public final SyncSwitchProps copy(ObservableState isOn, WorkletCallback onCheckedChangeSync, boolean enabled, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new SyncSwitchProps(isOn, onCheckedChangeSync, enabled, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncSwitchProps)) {
            return false;
        }
        SyncSwitchProps syncSwitchProps = (SyncSwitchProps) other;
        return Intrinsics.areEqual(this.isOn, syncSwitchProps.isOn) && Intrinsics.areEqual(this.onCheckedChangeSync, syncSwitchProps.onCheckedChangeSync) && this.enabled == syncSwitchProps.enabled && Intrinsics.areEqual(this.modifiers, syncSwitchProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        ObservableState observableState = this.isOn;
        int iHashCode = (observableState == null ? 0 : observableState.hashCode()) * 31;
        WorkletCallback workletCallback = this.onCheckedChangeSync;
        return ((((iHashCode + (workletCallback != null ? workletCallback.hashCode() : 0)) * 31) + Boolean.hashCode(this.enabled)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "SyncSwitchProps(isOn=" + this.isOn + ", onCheckedChangeSync=" + this.onCheckedChangeSync + ", enabled=" + this.enabled + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SyncSwitchProps(ObservableState observableState, WorkletCallback workletCallback, boolean z, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.isOn = observableState;
        this.onCheckedChangeSync = workletCallback;
        this.enabled = z;
        this.modifiers = modifiers;
    }

    public final ObservableState isOn() {
        return this.isOn;
    }

    public final WorkletCallback getOnCheckedChangeSync() {
        return this.onCheckedChangeSync;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public /* synthetic */ SyncSwitchProps(ObservableState observableState, WorkletCallback workletCallback, boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : observableState, (i & 2) != 0 ? null : workletCallback, (i & 4) != 0 ? true : z, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
