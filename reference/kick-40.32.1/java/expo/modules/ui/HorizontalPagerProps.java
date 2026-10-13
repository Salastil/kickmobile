package expo.modules.ui;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.OptimizedComposeProps;
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

/* JADX INFO: compiled from: HorizontalPagerView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00017B\u0081\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\"\b\u0002\u0010\u0010\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00150\u0011j\u0002`\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\u0017\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000fHÆ\u0003J#\u0010.\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00150\u0011j\u0002`\u0016HÆ\u0003J\u0083\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\"\b\u0002\u0010\u0010\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00150\u0011j\u0002`\u0016HÆ\u0001J\u0013\u00100\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\f\u00103\u001a\u0006\u0012\u0002\b\u000304H\u0016J\t\u00105\u001a\u00020\u0004HÖ\u0001J\t\u00106\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R+\u0010\u0010\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00150\u0011j\u0002`\u0016¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00068"}, d2 = {"Lexpo/modules/ui/HorizontalPagerProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "initialPage", "", "pageSpacing", "", "contentPadding", "Lexpo/modules/kotlin/types/Either;", "Lexpo/modules/ui/PaddingValuesRecord;", "userScrollEnabled", "", "reverseLayout", "beyondViewportPageCount", "onPageScrollSync", "Lexpo/modules/ui/state/WorkletCallback;", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(IFLexpo/modules/kotlin/types/Either;ZZILexpo/modules/ui/state/WorkletCallback;Ljava/util/List;)V", "getInitialPage", "()I", "getPageSpacing", "()F", "getContentPadding", "()Lexpo/modules/kotlin/types/Either;", "getUserScrollEnabled", "()Z", "getReverseLayout", "getBeyondViewportPageCount", "getOnPageScrollSync", "()Lexpo/modules/ui/state/WorkletCallback;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HorizontalPagerProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public int beyondViewportPageCount;
    public Either<Float, PaddingValuesRecord> contentPadding;
    public int initialPage;
    public List<Map<String, Dynamic>> modifiers;
    public WorkletCallback onPageScrollSync;
    public float pageSpacing;
    public boolean reverseLayout;
    public boolean userScrollEnabled;

    /* JADX INFO: compiled from: HorizontalPagerView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/HorizontalPagerProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<HorizontalPagerProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(HorizontalPagerProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("initialPage", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.INT, 0, __pika, false, true, false), new PProperty("pageSpacing", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT, 1, __pika, false, true, false), new PProperty("contentPadding", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, true, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.FLOAT, PTypeDescriptorRegistry.getOrCreateConcrete(PaddingValuesRecord.class, false, null)}), null), 2, __pika, false, true, false), new PProperty("userScrollEnabled", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 3, __pika, false, true, false), new PProperty("reverseLayout", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 4, __pika, false, true, false), new PProperty("beyondViewportPageCount", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.INT, 5, __pika, false, true, false), new PProperty("onPageScrollSync", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(WorkletCallback.class, true, null), 6, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 7, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("component8", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    return Integer.valueOf(((HorizontalPagerProps) obj).getInitialPage());
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    return Float.valueOf(((HorizontalPagerProps) obj).getPageSpacing());
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    return ((HorizontalPagerProps) obj).getContentPadding();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    return Boolean.valueOf(((HorizontalPagerProps) obj).getUserScrollEnabled());
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    return Boolean.valueOf(((HorizontalPagerProps) obj).getReverseLayout());
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    return Integer.valueOf(((HorizontalPagerProps) obj).getBeyondViewportPageCount());
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    return ((HorizontalPagerProps) obj).getOnPageScrollSync();
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    return ((HorizontalPagerProps) obj).getModifiers();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    ((HorizontalPagerProps) obj).initialPage = ((Integer) obj2).intValue();
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((HorizontalPagerProps) obj).pageSpacing = ((Float) obj2).floatValue();
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    ((HorizontalPagerProps) obj).contentPadding = (Either) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((HorizontalPagerProps) obj).userScrollEnabled = ((Boolean) obj2).booleanValue();
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((HorizontalPagerProps) obj).reverseLayout = ((Boolean) obj2).booleanValue();
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    ((HorizontalPagerProps) obj).beyondViewportPageCount = ((Integer) obj2).intValue();
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    ((HorizontalPagerProps) obj).onPageScrollSync = (WorkletCallback) obj2;
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                    ((HorizontalPagerProps) obj).modifiers = (List) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public HorizontalPagerProps() {
        this(0, 0.0f, null, false, false, 0, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HorizontalPagerProps copy$default(HorizontalPagerProps horizontalPagerProps, int i, float f, Either either, boolean z, boolean z2, int i2, WorkletCallback workletCallback, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = horizontalPagerProps.initialPage;
        }
        if ((i3 & 2) != 0) {
            f = horizontalPagerProps.pageSpacing;
        }
        if ((i3 & 4) != 0) {
            either = horizontalPagerProps.contentPadding;
        }
        if ((i3 & 8) != 0) {
            z = horizontalPagerProps.userScrollEnabled;
        }
        if ((i3 & 16) != 0) {
            z2 = horizontalPagerProps.reverseLayout;
        }
        if ((i3 & 32) != 0) {
            i2 = horizontalPagerProps.beyondViewportPageCount;
        }
        if ((i3 & 64) != 0) {
            workletCallback = horizontalPagerProps.onPageScrollSync;
        }
        if ((i3 & 128) != 0) {
            list = horizontalPagerProps.modifiers;
        }
        WorkletCallback workletCallback2 = workletCallback;
        List list2 = list;
        boolean z3 = z2;
        int i4 = i2;
        return horizontalPagerProps.copy(i, f, either, z, z3, i4, workletCallback2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getInitialPage() {
        return this.initialPage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getPageSpacing() {
        return this.pageSpacing;
    }

    public final Either<Float, PaddingValuesRecord> component3() {
        return this.contentPadding;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getUserScrollEnabled() {
        return this.userScrollEnabled;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getBeyondViewportPageCount() {
        return this.beyondViewportPageCount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final WorkletCallback getOnPageScrollSync() {
        return this.onPageScrollSync;
    }

    public final List<Map<String, Dynamic>> component8() {
        return this.modifiers;
    }

    public final HorizontalPagerProps copy(int initialPage, float pageSpacing, Either<Float, PaddingValuesRecord> contentPadding, boolean userScrollEnabled, boolean reverseLayout, int beyondViewportPageCount, WorkletCallback onPageScrollSync, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new HorizontalPagerProps(initialPage, pageSpacing, contentPadding, userScrollEnabled, reverseLayout, beyondViewportPageCount, onPageScrollSync, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HorizontalPagerProps)) {
            return false;
        }
        HorizontalPagerProps horizontalPagerProps = (HorizontalPagerProps) other;
        return this.initialPage == horizontalPagerProps.initialPage && Float.compare(this.pageSpacing, horizontalPagerProps.pageSpacing) == 0 && Intrinsics.areEqual(this.contentPadding, horizontalPagerProps.contentPadding) && this.userScrollEnabled == horizontalPagerProps.userScrollEnabled && this.reverseLayout == horizontalPagerProps.reverseLayout && this.beyondViewportPageCount == horizontalPagerProps.beyondViewportPageCount && Intrinsics.areEqual(this.onPageScrollSync, horizontalPagerProps.onPageScrollSync) && Intrinsics.areEqual(this.modifiers, horizontalPagerProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.initialPage) * 31) + Float.hashCode(this.pageSpacing)) * 31;
        Either<Float, PaddingValuesRecord> either = this.contentPadding;
        int iHashCode2 = (((((((iHashCode + (either == null ? 0 : either.hashCode())) * 31) + Boolean.hashCode(this.userScrollEnabled)) * 31) + Boolean.hashCode(this.reverseLayout)) * 31) + Integer.hashCode(this.beyondViewportPageCount)) * 31;
        WorkletCallback workletCallback = this.onPageScrollSync;
        return ((iHashCode2 + (workletCallback != null ? workletCallback.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "HorizontalPagerProps(initialPage=" + this.initialPage + ", pageSpacing=" + this.pageSpacing + ", contentPadding=" + this.contentPadding + ", userScrollEnabled=" + this.userScrollEnabled + ", reverseLayout=" + this.reverseLayout + ", beyondViewportPageCount=" + this.beyondViewportPageCount + ", onPageScrollSync=" + this.onPageScrollSync + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HorizontalPagerProps(int i, float f, Either<Float, PaddingValuesRecord> either, boolean z, boolean z2, int i2, WorkletCallback workletCallback, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.initialPage = i;
        this.pageSpacing = f;
        this.contentPadding = either;
        this.userScrollEnabled = z;
        this.reverseLayout = z2;
        this.beyondViewportPageCount = i2;
        this.onPageScrollSync = workletCallback;
        this.modifiers = modifiers;
    }

    public final int getInitialPage() {
        return this.initialPage;
    }

    public final float getPageSpacing() {
        return this.pageSpacing;
    }

    public final Either<Float, PaddingValuesRecord> getContentPadding() {
        return this.contentPadding;
    }

    public final boolean getUserScrollEnabled() {
        return this.userScrollEnabled;
    }

    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public final int getBeyondViewportPageCount() {
        return this.beyondViewportPageCount;
    }

    public final WorkletCallback getOnPageScrollSync() {
        return this.onPageScrollSync;
    }

    public /* synthetic */ HorizontalPagerProps(int i, float f, Either either, boolean z, boolean z2, int i2, WorkletCallback workletCallback, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0.0f : f, (i3 & 4) != 0 ? null : either, (i3 & 8) != 0 ? true : z, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? 0 : i2, (i3 & 64) != 0 ? null : workletCallback, (i3 & 128) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
