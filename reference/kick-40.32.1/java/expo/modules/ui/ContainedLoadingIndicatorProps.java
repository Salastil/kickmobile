package expo.modules.ui;

import android.graphics.Color;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.OptimizedComposeProps;
import expo.modules.ui.state.ObservableState;
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

/* JADX INFO: compiled from: LoadingView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\"\b\u0002\u0010\b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J#\u0010\u001b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000eHÆ\u0003JQ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\"\b\u0002\u0010\b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000eHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\f\u0010!\u001a\u0006\u0012\u0002\b\u00030\"H\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u000bHÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R+\u0010\b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lexpo/modules/ui/ContainedLoadingIndicatorProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "progress", "Lexpo/modules/ui/state/ObservableState;", "color", "Landroid/graphics/Color;", "containerColor", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Lexpo/modules/ui/state/ObservableState;Landroid/graphics/Color;Landroid/graphics/Color;Ljava/util/List;)V", "getProgress", "()Lexpo/modules/ui/state/ObservableState;", "getColor", "()Landroid/graphics/Color;", "getContainerColor", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ContainedLoadingIndicatorProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color color;
    public Color containerColor;
    public List<Map<String, Dynamic>> modifiers;
    public ObservableState progress;

    /* JADX INFO: compiled from: LoadingView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/ContainedLoadingIndicatorProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ContainedLoadingIndicatorProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ContainedLoadingIndicatorProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("progress", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ObservableState.class, true, null), 0, __pika, false, true, false), new PProperty("color", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 1, __pika, false, true, false), new PProperty("containerColor", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 2, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 3, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ContainedLoadingIndicatorProps");
                return ((ContainedLoadingIndicatorProps) obj).getProgress();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ContainedLoadingIndicatorProps");
                return ((ContainedLoadingIndicatorProps) obj).getColor();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ContainedLoadingIndicatorProps");
                return ((ContainedLoadingIndicatorProps) obj).getContainerColor();
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ContainedLoadingIndicatorProps");
            return ((ContainedLoadingIndicatorProps) obj).getModifiers();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ContainedLoadingIndicatorProps");
                ((ContainedLoadingIndicatorProps) obj).progress = (ObservableState) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ContainedLoadingIndicatorProps");
                ((ContainedLoadingIndicatorProps) obj).color = (Color) obj2;
            } else if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ContainedLoadingIndicatorProps");
                ((ContainedLoadingIndicatorProps) obj).containerColor = (Color) obj2;
            } else {
                if (i != 3) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ContainedLoadingIndicatorProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                ((ContainedLoadingIndicatorProps) obj).modifiers = (List) obj2;
            }
        }
    }

    public ContainedLoadingIndicatorProps() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContainedLoadingIndicatorProps copy$default(ContainedLoadingIndicatorProps containedLoadingIndicatorProps, ObservableState observableState, Color color, Color color2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            observableState = containedLoadingIndicatorProps.progress;
        }
        if ((i & 2) != 0) {
            color = containedLoadingIndicatorProps.color;
        }
        if ((i & 4) != 0) {
            color2 = containedLoadingIndicatorProps.containerColor;
        }
        if ((i & 8) != 0) {
            list = containedLoadingIndicatorProps.modifiers;
        }
        return containedLoadingIndicatorProps.copy(observableState, color, color2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ObservableState getProgress() {
        return this.progress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Color getContainerColor() {
        return this.containerColor;
    }

    public final List<Map<String, Dynamic>> component4() {
        return this.modifiers;
    }

    public final ContainedLoadingIndicatorProps copy(ObservableState progress, Color color, Color containerColor, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new ContainedLoadingIndicatorProps(progress, color, containerColor, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContainedLoadingIndicatorProps)) {
            return false;
        }
        ContainedLoadingIndicatorProps containedLoadingIndicatorProps = (ContainedLoadingIndicatorProps) other;
        return Intrinsics.areEqual(this.progress, containedLoadingIndicatorProps.progress) && Intrinsics.areEqual(this.color, containedLoadingIndicatorProps.color) && Intrinsics.areEqual(this.containerColor, containedLoadingIndicatorProps.containerColor) && Intrinsics.areEqual(this.modifiers, containedLoadingIndicatorProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        ObservableState observableState = this.progress;
        int iHashCode = (observableState == null ? 0 : observableState.hashCode()) * 31;
        Color color = this.color;
        int iHashCode2 = (iHashCode + (color == null ? 0 : color.hashCode())) * 31;
        Color color2 = this.containerColor;
        return ((iHashCode2 + (color2 != null ? color2.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "ContainedLoadingIndicatorProps(progress=" + this.progress + ", color=" + this.color + ", containerColor=" + this.containerColor + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContainedLoadingIndicatorProps(ObservableState observableState, Color color, Color color2, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.progress = observableState;
        this.color = color;
        this.containerColor = color2;
        this.modifiers = modifiers;
    }

    public final ObservableState getProgress() {
        return this.progress;
    }

    public final Color getColor() {
        return this.color;
    }

    public final Color getContainerColor() {
        return this.containerColor;
    }

    public /* synthetic */ ContainedLoadingIndicatorProps(ObservableState observableState, Color color, Color color2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : observableState, (i & 2) != 0 ? null : color, (i & 4) != 0 ? null : color2, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
