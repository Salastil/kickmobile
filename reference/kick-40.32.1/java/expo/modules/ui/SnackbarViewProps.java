package expo.modules.ui;

import android.graphics.Color;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.OptimizedComposeProps;
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

/* JADX INFO: compiled from: SnackbarView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001*B\u0089\u0001\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u0012(\b\u0002\u0010\u000b\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\fj\u0002`\u00110\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u0004HÆ\u0003J)\u0010 \u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\fj\u0002`\u00110\u0004HÆ\u0003J\u008b\u0001\u0010!\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00042(\b\u0002\u0010\u000b\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\fj\u0002`\u00110\u0004HÆ\u0001J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\f\u0010%\u001a\u0006\u0012\u0002\b\u00030&H\u0016J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u000eHÖ\u0001R\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R1\u0010\u000b\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\fj\u0002`\u00110\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015¨\u0006+"}, d2 = {"Lexpo/modules/ui/SnackbarViewProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "containerColor", "Landroidx/compose/runtime/MutableState;", "Landroid/graphics/Color;", "contentColor", "actionContentColor", "dismissActionContentColor", "actionOnNewLine", "", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", "getContainerColor", "()Landroidx/compose/runtime/MutableState;", "getContentColor", "getActionContentColor", "getDismissActionContentColor", "getActionOnNewLine", "getModifiers", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SnackbarViewProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 0;
    public MutableState<Color> actionContentColor;
    public MutableState<Boolean> actionOnNewLine;
    public MutableState<Color> containerColor;
    public MutableState<Color> contentColor;
    public MutableState<Color> dismissActionContentColor;
    public MutableState<List<Map<String, Dynamic>>> modifiers;

    /* JADX INFO: compiled from: SnackbarView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/SnackbarViewProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<SnackbarViewProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(SnackbarViewProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("containerColor", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null)}), null), 0, __pika, false, true, false), new PProperty("contentColor", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null)}), null), 1, __pika, false, true, false), new PProperty("actionContentColor", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null)}), null), 2, __pika, false, true, false), new PProperty("dismissActionContentColor", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null)}), null), 3, __pika, false, true, false), new PProperty("actionOnNewLine", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.BOOLEAN}), null), 4, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null)}), null), 5, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarViewProps");
                return ((SnackbarViewProps) obj).getContainerColor();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarViewProps");
                return ((SnackbarViewProps) obj).getContentColor();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarViewProps");
                return ((SnackbarViewProps) obj).getActionContentColor();
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarViewProps");
                return ((SnackbarViewProps) obj).getDismissActionContentColor();
            }
            if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarViewProps");
                return ((SnackbarViewProps) obj).getActionOnNewLine();
            }
            if (i != 5) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarViewProps");
            return ((SnackbarViewProps) obj).getModifiers();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarViewProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<android.graphics.Color?>");
                ((SnackbarViewProps) obj).containerColor = (MutableState) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarViewProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<android.graphics.Color?>");
                ((SnackbarViewProps) obj).contentColor = (MutableState) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarViewProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<android.graphics.Color?>");
                ((SnackbarViewProps) obj).actionContentColor = (MutableState) obj2;
                return;
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarViewProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<android.graphics.Color?>");
                ((SnackbarViewProps) obj).dismissActionContentColor = (MutableState) obj2;
                return;
            }
            if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarViewProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.Boolean>");
                ((SnackbarViewProps) obj).actionOnNewLine = (MutableState) obj2;
                return;
            }
            if (i != 5) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarViewProps");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>>");
            ((SnackbarViewProps) obj).modifiers = (MutableState) obj2;
        }
    }

    public SnackbarViewProps() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SnackbarViewProps copy$default(SnackbarViewProps snackbarViewProps, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableState = snackbarViewProps.containerColor;
        }
        if ((i & 2) != 0) {
            mutableState2 = snackbarViewProps.contentColor;
        }
        if ((i & 4) != 0) {
            mutableState3 = snackbarViewProps.actionContentColor;
        }
        if ((i & 8) != 0) {
            mutableState4 = snackbarViewProps.dismissActionContentColor;
        }
        if ((i & 16) != 0) {
            mutableState5 = snackbarViewProps.actionOnNewLine;
        }
        if ((i & 32) != 0) {
            mutableState6 = snackbarViewProps.modifiers;
        }
        MutableState mutableState7 = mutableState5;
        MutableState mutableState8 = mutableState6;
        return snackbarViewProps.copy(mutableState, mutableState2, mutableState3, mutableState4, mutableState7, mutableState8);
    }

    public final MutableState<Color> component1() {
        return this.containerColor;
    }

    public final MutableState<Color> component2() {
        return this.contentColor;
    }

    public final MutableState<Color> component3() {
        return this.actionContentColor;
    }

    public final MutableState<Color> component4() {
        return this.dismissActionContentColor;
    }

    public final MutableState<Boolean> component5() {
        return this.actionOnNewLine;
    }

    public final MutableState<List<Map<String, Dynamic>>> component6() {
        return this.modifiers;
    }

    public final SnackbarViewProps copy(MutableState<Color> containerColor, MutableState<Color> contentColor, MutableState<Color> actionContentColor, MutableState<Color> dismissActionContentColor, MutableState<Boolean> actionOnNewLine, MutableState<List<Map<String, Dynamic>>> modifiers) {
        Intrinsics.checkNotNullParameter(containerColor, "containerColor");
        Intrinsics.checkNotNullParameter(contentColor, "contentColor");
        Intrinsics.checkNotNullParameter(actionContentColor, "actionContentColor");
        Intrinsics.checkNotNullParameter(dismissActionContentColor, "dismissActionContentColor");
        Intrinsics.checkNotNullParameter(actionOnNewLine, "actionOnNewLine");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new SnackbarViewProps(containerColor, contentColor, actionContentColor, dismissActionContentColor, actionOnNewLine, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SnackbarViewProps)) {
            return false;
        }
        SnackbarViewProps snackbarViewProps = (SnackbarViewProps) other;
        return Intrinsics.areEqual(this.containerColor, snackbarViewProps.containerColor) && Intrinsics.areEqual(this.contentColor, snackbarViewProps.contentColor) && Intrinsics.areEqual(this.actionContentColor, snackbarViewProps.actionContentColor) && Intrinsics.areEqual(this.dismissActionContentColor, snackbarViewProps.dismissActionContentColor) && Intrinsics.areEqual(this.actionOnNewLine, snackbarViewProps.actionOnNewLine) && Intrinsics.areEqual(this.modifiers, snackbarViewProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return (((((((((this.containerColor.hashCode() * 31) + this.contentColor.hashCode()) * 31) + this.actionContentColor.hashCode()) * 31) + this.dismissActionContentColor.hashCode()) * 31) + this.actionOnNewLine.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "SnackbarViewProps(containerColor=" + this.containerColor + ", contentColor=" + this.contentColor + ", actionContentColor=" + this.actionContentColor + ", dismissActionContentColor=" + this.dismissActionContentColor + ", actionOnNewLine=" + this.actionOnNewLine + ", modifiers=" + this.modifiers + ")";
    }

    public SnackbarViewProps(MutableState<Color> containerColor, MutableState<Color> contentColor, MutableState<Color> actionContentColor, MutableState<Color> dismissActionContentColor, MutableState<Boolean> actionOnNewLine, MutableState<List<Map<String, Dynamic>>> modifiers) {
        Intrinsics.checkNotNullParameter(containerColor, "containerColor");
        Intrinsics.checkNotNullParameter(contentColor, "contentColor");
        Intrinsics.checkNotNullParameter(actionContentColor, "actionContentColor");
        Intrinsics.checkNotNullParameter(dismissActionContentColor, "dismissActionContentColor");
        Intrinsics.checkNotNullParameter(actionOnNewLine, "actionOnNewLine");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.containerColor = containerColor;
        this.contentColor = contentColor;
        this.actionContentColor = actionContentColor;
        this.dismissActionContentColor = dismissActionContentColor;
        this.actionOnNewLine = actionOnNewLine;
        this.modifiers = modifiers;
    }

    public /* synthetic */ SnackbarViewProps(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState, (i & 2) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState2, (i & 4) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState3, (i & 8) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState4, (i & 16) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null) : mutableState5, (i & 32) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null) : mutableState6);
    }

    public final MutableState<Color> getContainerColor() {
        return this.containerColor;
    }

    public final MutableState<Color> getContentColor() {
        return this.contentColor;
    }

    public final MutableState<Color> getActionContentColor() {
        return this.actionContentColor;
    }

    public final MutableState<Color> getDismissActionContentColor() {
        return this.dismissActionContentColor;
    }

    public final MutableState<Boolean> getActionOnNewLine() {
        return this.actionOnNewLine;
    }

    public final MutableState<List<Map<String, Dynamic>>> getModifiers() {
        return this.modifiers;
    }
}
