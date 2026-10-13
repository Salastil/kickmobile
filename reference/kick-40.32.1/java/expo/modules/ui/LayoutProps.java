package expo.modules.ui;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.OptimizedComposeProps;
import expo.modules.ui.convertibles.ContentAlignment;
import expo.modules.ui.convertibles.HorizontalAlignment;
import expo.modules.ui.convertibles.HorizontalArrangementCustom;
import expo.modules.ui.convertibles.HorizontalArrangementDefault;
import expo.modules.ui.convertibles.VerticalAlignment;
import expo.modules.ui.convertibles.VerticalArrangementCustom;
import expo.modules.ui.convertibles.VerticalArrangementDefault;
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

/* JADX INFO: compiled from: ComposeViews.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001;B\u0097\u0001\u0012\u001c\b\u0002\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\"\b\u0002\u0010\u0014\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016j\u0002`\u00190\u0015j\u0002`\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007HÆ\u0003J\u001d\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u000bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0013HÆ\u0003J#\u00100\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016j\u0002`\u00190\u0015j\u0002`\u001aHÆ\u0003J\u0099\u0001\u00101\u001a\u00020\u00002\u001c\b\u0002\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\"\b\u0002\u0010\u0014\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016j\u0002`\u00190\u0015j\u0002`\u001aHÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\f\u00106\u001a\u0006\u0012\u0002\b\u000307H\u0016J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020\u0017HÖ\u0001R%\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R+\u0010\u0014\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016j\u0002`\u00190\u0015j\u0002`\u001a¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006<"}, d2 = {"Lexpo/modules/ui/LayoutProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "horizontalArrangement", "Lexpo/modules/kotlin/types/Either;", "Lexpo/modules/ui/convertibles/HorizontalArrangementDefault;", "Lexpo/modules/ui/convertibles/HorizontalArrangementCustom;", "Lexpo/modules/ui/convertibles/HorizontalArrangement;", "verticalArrangement", "Lexpo/modules/ui/convertibles/VerticalArrangementDefault;", "Lexpo/modules/ui/convertibles/VerticalArrangementCustom;", "Lexpo/modules/ui/convertibles/VerticalArrangement;", "horizontalAlignment", "Lexpo/modules/ui/convertibles/HorizontalAlignment;", "verticalAlignment", "Lexpo/modules/ui/convertibles/VerticalAlignment;", "contentAlignment", "Lexpo/modules/ui/convertibles/ContentAlignment;", "floatingToolbarExitAlwaysScrollBehavior", "Lexpo/modules/ui/FloatingToolbarExitAlwaysScrollBehavior;", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Lexpo/modules/kotlin/types/Either;Lexpo/modules/kotlin/types/Either;Lexpo/modules/ui/convertibles/HorizontalAlignment;Lexpo/modules/ui/convertibles/VerticalAlignment;Lexpo/modules/ui/convertibles/ContentAlignment;Lexpo/modules/ui/FloatingToolbarExitAlwaysScrollBehavior;Ljava/util/List;)V", "getHorizontalArrangement", "()Lexpo/modules/kotlin/types/Either;", "getVerticalArrangement", "getHorizontalAlignment", "()Lexpo/modules/ui/convertibles/HorizontalAlignment;", "getVerticalAlignment", "()Lexpo/modules/ui/convertibles/VerticalAlignment;", "getContentAlignment", "()Lexpo/modules/ui/convertibles/ContentAlignment;", "getFloatingToolbarExitAlwaysScrollBehavior", "()Lexpo/modules/ui/FloatingToolbarExitAlwaysScrollBehavior;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LayoutProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public ContentAlignment contentAlignment;
    public FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior;
    public HorizontalAlignment horizontalAlignment;
    public Either<HorizontalArrangementDefault, HorizontalArrangementCustom> horizontalArrangement;
    public List<Map<String, Dynamic>> modifiers;
    public VerticalAlignment verticalAlignment;
    public Either<VerticalArrangementDefault, VerticalArrangementCustom> verticalArrangement;

    /* JADX INFO: compiled from: ComposeViews.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/LayoutProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<LayoutProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(LayoutProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("horizontalArrangement", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, true, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(HorizontalArrangementDefault.class, false, null), PTypeDescriptorRegistry.getOrCreateConcrete(HorizontalArrangementCustom.class, false, null)}), null), 0, __pika, false, true, false), new PProperty("verticalArrangement", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, true, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(VerticalArrangementDefault.class, false, null), PTypeDescriptorRegistry.getOrCreateConcrete(VerticalArrangementCustom.class, false, null)}), null), 1, __pika, false, true, false), new PProperty("horizontalAlignment", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(HorizontalAlignment.class, true, null), 2, __pika, false, true, false), new PProperty("verticalAlignment", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(VerticalAlignment.class, true, null), 3, __pika, false, true, false), new PProperty("contentAlignment", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ContentAlignment.class, true, null), 4, __pika, false, true, false), new PProperty("floatingToolbarExitAlwaysScrollBehavior", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(FloatingToolbarExitAlwaysScrollBehavior.class, true, null), 5, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 6, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LayoutProps");
                    return ((LayoutProps) obj).getHorizontalArrangement();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LayoutProps");
                    return ((LayoutProps) obj).getVerticalArrangement();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LayoutProps");
                    return ((LayoutProps) obj).getHorizontalAlignment();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LayoutProps");
                    return ((LayoutProps) obj).getVerticalAlignment();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LayoutProps");
                    return ((LayoutProps) obj).getContentAlignment();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LayoutProps");
                    return ((LayoutProps) obj).getFloatingToolbarExitAlwaysScrollBehavior();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LayoutProps");
                    return ((LayoutProps) obj).getModifiers();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LayoutProps");
                    ((LayoutProps) obj).horizontalArrangement = (Either) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LayoutProps");
                    ((LayoutProps) obj).verticalArrangement = (Either) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LayoutProps");
                    ((LayoutProps) obj).horizontalAlignment = (HorizontalAlignment) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LayoutProps");
                    ((LayoutProps) obj).verticalAlignment = (VerticalAlignment) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LayoutProps");
                    ((LayoutProps) obj).contentAlignment = (ContentAlignment) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LayoutProps");
                    ((LayoutProps) obj).floatingToolbarExitAlwaysScrollBehavior = (FloatingToolbarExitAlwaysScrollBehavior) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LayoutProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                    ((LayoutProps) obj).modifiers = (List) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public LayoutProps() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LayoutProps copy$default(LayoutProps layoutProps, Either either, Either either2, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, ContentAlignment contentAlignment, FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            either = layoutProps.horizontalArrangement;
        }
        if ((i & 2) != 0) {
            either2 = layoutProps.verticalArrangement;
        }
        if ((i & 4) != 0) {
            horizontalAlignment = layoutProps.horizontalAlignment;
        }
        if ((i & 8) != 0) {
            verticalAlignment = layoutProps.verticalAlignment;
        }
        if ((i & 16) != 0) {
            contentAlignment = layoutProps.contentAlignment;
        }
        if ((i & 32) != 0) {
            floatingToolbarExitAlwaysScrollBehavior = layoutProps.floatingToolbarExitAlwaysScrollBehavior;
        }
        if ((i & 64) != 0) {
            list = layoutProps.modifiers;
        }
        FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior2 = floatingToolbarExitAlwaysScrollBehavior;
        List list2 = list;
        ContentAlignment contentAlignment2 = contentAlignment;
        HorizontalAlignment horizontalAlignment2 = horizontalAlignment;
        return layoutProps.copy(either, either2, horizontalAlignment2, verticalAlignment, contentAlignment2, floatingToolbarExitAlwaysScrollBehavior2, list2);
    }

    public final Either<HorizontalArrangementDefault, HorizontalArrangementCustom> component1() {
        return this.horizontalArrangement;
    }

    public final Either<VerticalArrangementDefault, VerticalArrangementCustom> component2() {
        return this.verticalArrangement;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final HorizontalAlignment getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final VerticalAlignment getVerticalAlignment() {
        return this.verticalAlignment;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ContentAlignment getContentAlignment() {
        return this.contentAlignment;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final FloatingToolbarExitAlwaysScrollBehavior getFloatingToolbarExitAlwaysScrollBehavior() {
        return this.floatingToolbarExitAlwaysScrollBehavior;
    }

    public final List<Map<String, Dynamic>> component7() {
        return this.modifiers;
    }

    public final LayoutProps copy(Either<HorizontalArrangementDefault, HorizontalArrangementCustom> horizontalArrangement, Either<VerticalArrangementDefault, VerticalArrangementCustom> verticalArrangement, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, ContentAlignment contentAlignment, FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new LayoutProps(horizontalArrangement, verticalArrangement, horizontalAlignment, verticalAlignment, contentAlignment, floatingToolbarExitAlwaysScrollBehavior, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LayoutProps)) {
            return false;
        }
        LayoutProps layoutProps = (LayoutProps) other;
        return Intrinsics.areEqual(this.horizontalArrangement, layoutProps.horizontalArrangement) && Intrinsics.areEqual(this.verticalArrangement, layoutProps.verticalArrangement) && this.horizontalAlignment == layoutProps.horizontalAlignment && this.verticalAlignment == layoutProps.verticalAlignment && this.contentAlignment == layoutProps.contentAlignment && this.floatingToolbarExitAlwaysScrollBehavior == layoutProps.floatingToolbarExitAlwaysScrollBehavior && Intrinsics.areEqual(this.modifiers, layoutProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Either<HorizontalArrangementDefault, HorizontalArrangementCustom> either = this.horizontalArrangement;
        int iHashCode = (either == null ? 0 : either.hashCode()) * 31;
        Either<VerticalArrangementDefault, VerticalArrangementCustom> either2 = this.verticalArrangement;
        int iHashCode2 = (iHashCode + (either2 == null ? 0 : either2.hashCode())) * 31;
        HorizontalAlignment horizontalAlignment = this.horizontalAlignment;
        int iHashCode3 = (iHashCode2 + (horizontalAlignment == null ? 0 : horizontalAlignment.hashCode())) * 31;
        VerticalAlignment verticalAlignment = this.verticalAlignment;
        int iHashCode4 = (iHashCode3 + (verticalAlignment == null ? 0 : verticalAlignment.hashCode())) * 31;
        ContentAlignment contentAlignment = this.contentAlignment;
        int iHashCode5 = (iHashCode4 + (contentAlignment == null ? 0 : contentAlignment.hashCode())) * 31;
        FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior = this.floatingToolbarExitAlwaysScrollBehavior;
        return ((iHashCode5 + (floatingToolbarExitAlwaysScrollBehavior != null ? floatingToolbarExitAlwaysScrollBehavior.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "LayoutProps(horizontalArrangement=" + this.horizontalArrangement + ", verticalArrangement=" + this.verticalArrangement + ", horizontalAlignment=" + this.horizontalAlignment + ", verticalAlignment=" + this.verticalAlignment + ", contentAlignment=" + this.contentAlignment + ", floatingToolbarExitAlwaysScrollBehavior=" + this.floatingToolbarExitAlwaysScrollBehavior + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutProps(Either<HorizontalArrangementDefault, HorizontalArrangementCustom> either, Either<VerticalArrangementDefault, VerticalArrangementCustom> either2, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, ContentAlignment contentAlignment, FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.horizontalArrangement = either;
        this.verticalArrangement = either2;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.contentAlignment = contentAlignment;
        this.floatingToolbarExitAlwaysScrollBehavior = floatingToolbarExitAlwaysScrollBehavior;
        this.modifiers = modifiers;
    }

    public final Either<HorizontalArrangementDefault, HorizontalArrangementCustom> getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    public final Either<VerticalArrangementDefault, VerticalArrangementCustom> getVerticalArrangement() {
        return this.verticalArrangement;
    }

    public final HorizontalAlignment getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public final VerticalAlignment getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public final ContentAlignment getContentAlignment() {
        return this.contentAlignment;
    }

    public final FloatingToolbarExitAlwaysScrollBehavior getFloatingToolbarExitAlwaysScrollBehavior() {
        return this.floatingToolbarExitAlwaysScrollBehavior;
    }

    public /* synthetic */ LayoutProps(Either either, Either either2, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, ContentAlignment contentAlignment, FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : either, (i & 2) != 0 ? null : either2, (i & 4) != 0 ? null : horizontalAlignment, (i & 8) != 0 ? null : verticalAlignment, (i & 16) != 0 ? null : contentAlignment, (i & 32) != 0 ? null : floatingToolbarExitAlwaysScrollBehavior, (i & 64) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
