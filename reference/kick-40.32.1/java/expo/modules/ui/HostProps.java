package expo.modules.ui;

import android.graphics.Color;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.facebook.react.uimanager.ViewProps;
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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001*B\u007f\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004HÆ\u0003J\u0081\u0001\u0010 \u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0010\b\u0002\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00042\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004HÆ\u0001J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\f\u0010$\u001a\u0006\u0012\u0002\b\u00030%H\u0016J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006+"}, d2 = {"Lexpo/modules/ui/HostProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "colorScheme", "Landroidx/compose/runtime/MutableState;", "Lexpo/modules/ui/ExpoColorScheme;", "seedColor", "Landroid/graphics/Color;", ViewProps.LAYOUT_DIRECTION, "Lexpo/modules/ui/ExpoLayoutDirection;", "useViewportSizeMeasurement", "", "ignoreSafeAreaKeyboardInsets", "matchContentsHorizontal", "matchContentsVertical", "<init>", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", "getColorScheme", "()Landroidx/compose/runtime/MutableState;", "getSeedColor", "getLayoutDirection", "getUseViewportSizeMeasurement", "getIgnoreSafeAreaKeyboardInsets", "getMatchContentsHorizontal", "getMatchContentsVertical", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HostProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 0;
    public MutableState<ExpoColorScheme> colorScheme;
    public MutableState<Boolean> ignoreSafeAreaKeyboardInsets;
    public MutableState<ExpoLayoutDirection> layoutDirection;
    public MutableState<Boolean> matchContentsHorizontal;
    public MutableState<Boolean> matchContentsVertical;
    public MutableState<Color> seedColor;
    public MutableState<Boolean> useViewportSizeMeasurement;

    /* JADX INFO: compiled from: HostView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/HostProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<HostProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(HostProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("colorScheme", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(ExpoColorScheme.class, true, null)}), null), 0, __pika, false, true, false), new PProperty("seedColor", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null)}), null), 1, __pika, false, true, false), new PProperty(ViewProps.LAYOUT_DIRECTION, PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(ExpoLayoutDirection.class, false, null)}), null), 2, __pika, false, true, false), new PProperty("useViewportSizeMeasurement", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.BOOLEAN}), null), 3, __pika, false, true, false), new PProperty("ignoreSafeAreaKeyboardInsets", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.BOOLEAN}), null), 4, __pika, false, true, false), new PProperty("matchContentsHorizontal", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.BOOLEAN_NULLABLE}), null), 5, __pika, false, true, false), new PProperty("matchContentsVertical", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.BOOLEAN_NULLABLE}), null), 6, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HostProps");
                    return ((HostProps) obj).getColorScheme();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HostProps");
                    return ((HostProps) obj).getSeedColor();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HostProps");
                    return ((HostProps) obj).getLayoutDirection();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HostProps");
                    return ((HostProps) obj).getUseViewportSizeMeasurement();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HostProps");
                    return ((HostProps) obj).getIgnoreSafeAreaKeyboardInsets();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HostProps");
                    return ((HostProps) obj).getMatchContentsHorizontal();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HostProps");
                    return ((HostProps) obj).getMatchContentsVertical();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HostProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<expo.modules.ui.ExpoColorScheme?>");
                    ((HostProps) obj).colorScheme = (MutableState) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HostProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<android.graphics.Color?>");
                    ((HostProps) obj).seedColor = (MutableState) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HostProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<expo.modules.ui.ExpoLayoutDirection>");
                    ((HostProps) obj).layoutDirection = (MutableState) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HostProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.Boolean>");
                    ((HostProps) obj).useViewportSizeMeasurement = (MutableState) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HostProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.Boolean>");
                    ((HostProps) obj).ignoreSafeAreaKeyboardInsets = (MutableState) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HostProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.Boolean?>");
                    ((HostProps) obj).matchContentsHorizontal = (MutableState) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HostProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.Boolean?>");
                    ((HostProps) obj).matchContentsVertical = (MutableState) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public HostProps() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostProps copy$default(HostProps hostProps, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableState = hostProps.colorScheme;
        }
        if ((i & 2) != 0) {
            mutableState2 = hostProps.seedColor;
        }
        if ((i & 4) != 0) {
            mutableState3 = hostProps.layoutDirection;
        }
        if ((i & 8) != 0) {
            mutableState4 = hostProps.useViewportSizeMeasurement;
        }
        if ((i & 16) != 0) {
            mutableState5 = hostProps.ignoreSafeAreaKeyboardInsets;
        }
        if ((i & 32) != 0) {
            mutableState6 = hostProps.matchContentsHorizontal;
        }
        if ((i & 64) != 0) {
            mutableState7 = hostProps.matchContentsVertical;
        }
        MutableState mutableState8 = mutableState6;
        MutableState mutableState9 = mutableState7;
        MutableState mutableState10 = mutableState5;
        MutableState mutableState11 = mutableState3;
        return hostProps.copy(mutableState, mutableState2, mutableState11, mutableState4, mutableState10, mutableState8, mutableState9);
    }

    public final MutableState<ExpoColorScheme> component1() {
        return this.colorScheme;
    }

    public final MutableState<Color> component2() {
        return this.seedColor;
    }

    public final MutableState<ExpoLayoutDirection> component3() {
        return this.layoutDirection;
    }

    public final MutableState<Boolean> component4() {
        return this.useViewportSizeMeasurement;
    }

    public final MutableState<Boolean> component5() {
        return this.ignoreSafeAreaKeyboardInsets;
    }

    public final MutableState<Boolean> component6() {
        return this.matchContentsHorizontal;
    }

    public final MutableState<Boolean> component7() {
        return this.matchContentsVertical;
    }

    public final HostProps copy(MutableState<ExpoColorScheme> colorScheme, MutableState<Color> seedColor, MutableState<ExpoLayoutDirection> layoutDirection, MutableState<Boolean> useViewportSizeMeasurement, MutableState<Boolean> ignoreSafeAreaKeyboardInsets, MutableState<Boolean> matchContentsHorizontal, MutableState<Boolean> matchContentsVertical) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(seedColor, "seedColor");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(useViewportSizeMeasurement, "useViewportSizeMeasurement");
        Intrinsics.checkNotNullParameter(ignoreSafeAreaKeyboardInsets, "ignoreSafeAreaKeyboardInsets");
        Intrinsics.checkNotNullParameter(matchContentsHorizontal, "matchContentsHorizontal");
        Intrinsics.checkNotNullParameter(matchContentsVertical, "matchContentsVertical");
        return new HostProps(colorScheme, seedColor, layoutDirection, useViewportSizeMeasurement, ignoreSafeAreaKeyboardInsets, matchContentsHorizontal, matchContentsVertical);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostProps)) {
            return false;
        }
        HostProps hostProps = (HostProps) other;
        return Intrinsics.areEqual(this.colorScheme, hostProps.colorScheme) && Intrinsics.areEqual(this.seedColor, hostProps.seedColor) && Intrinsics.areEqual(this.layoutDirection, hostProps.layoutDirection) && Intrinsics.areEqual(this.useViewportSizeMeasurement, hostProps.useViewportSizeMeasurement) && Intrinsics.areEqual(this.ignoreSafeAreaKeyboardInsets, hostProps.ignoreSafeAreaKeyboardInsets) && Intrinsics.areEqual(this.matchContentsHorizontal, hostProps.matchContentsHorizontal) && Intrinsics.areEqual(this.matchContentsVertical, hostProps.matchContentsVertical);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return (((((((((((this.colorScheme.hashCode() * 31) + this.seedColor.hashCode()) * 31) + this.layoutDirection.hashCode()) * 31) + this.useViewportSizeMeasurement.hashCode()) * 31) + this.ignoreSafeAreaKeyboardInsets.hashCode()) * 31) + this.matchContentsHorizontal.hashCode()) * 31) + this.matchContentsVertical.hashCode();
    }

    public String toString() {
        return "HostProps(colorScheme=" + this.colorScheme + ", seedColor=" + this.seedColor + ", layoutDirection=" + this.layoutDirection + ", useViewportSizeMeasurement=" + this.useViewportSizeMeasurement + ", ignoreSafeAreaKeyboardInsets=" + this.ignoreSafeAreaKeyboardInsets + ", matchContentsHorizontal=" + this.matchContentsHorizontal + ", matchContentsVertical=" + this.matchContentsVertical + ")";
    }

    public HostProps(MutableState<ExpoColorScheme> colorScheme, MutableState<Color> seedColor, MutableState<ExpoLayoutDirection> layoutDirection, MutableState<Boolean> useViewportSizeMeasurement, MutableState<Boolean> ignoreSafeAreaKeyboardInsets, MutableState<Boolean> matchContentsHorizontal, MutableState<Boolean> matchContentsVertical) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(seedColor, "seedColor");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(useViewportSizeMeasurement, "useViewportSizeMeasurement");
        Intrinsics.checkNotNullParameter(ignoreSafeAreaKeyboardInsets, "ignoreSafeAreaKeyboardInsets");
        Intrinsics.checkNotNullParameter(matchContentsHorizontal, "matchContentsHorizontal");
        Intrinsics.checkNotNullParameter(matchContentsVertical, "matchContentsVertical");
        this.colorScheme = colorScheme;
        this.seedColor = seedColor;
        this.layoutDirection = layoutDirection;
        this.useViewportSizeMeasurement = useViewportSizeMeasurement;
        this.ignoreSafeAreaKeyboardInsets = ignoreSafeAreaKeyboardInsets;
        this.matchContentsHorizontal = matchContentsHorizontal;
        this.matchContentsVertical = matchContentsVertical;
    }

    public /* synthetic */ HostProps(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState, (i & 2) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState2, (i & 4) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ExpoLayoutDirection.LeftToRight, null, 2, null) : mutableState3, (i & 8) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null) : mutableState4, (i & 16) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null) : mutableState5, (i & 32) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState6, (i & 64) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState7);
    }

    public final MutableState<ExpoColorScheme> getColorScheme() {
        return this.colorScheme;
    }

    public final MutableState<Color> getSeedColor() {
        return this.seedColor;
    }

    public final MutableState<ExpoLayoutDirection> getLayoutDirection() {
        return this.layoutDirection;
    }

    public final MutableState<Boolean> getUseViewportSizeMeasurement() {
        return this.useViewportSizeMeasurement;
    }

    public final MutableState<Boolean> getIgnoreSafeAreaKeyboardInsets() {
        return this.ignoreSafeAreaKeyboardInsets;
    }

    public final MutableState<Boolean> getMatchContentsHorizontal() {
        return this.matchContentsHorizontal;
    }

    public final MutableState<Boolean> getMatchContentsVertical() {
        return this.matchContentsVertical;
    }
}
