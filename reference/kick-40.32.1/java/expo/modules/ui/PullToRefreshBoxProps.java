package expo.modules.ui;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.OptimizedComposeProps;
import expo.modules.ui.convertibles.ContentAlignment;
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

/* JADX INFO: compiled from: PullToRefreshBoxView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\"\b\u0002\u0010\t\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\nj\u0002`\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J#\u0010\u001c\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\nj\u0002`\u000fHÆ\u0003JM\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\"\b\u0002\u0010\t\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\nj\u0002`\u000fHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\f\u0010!\u001a\u0006\u0012\u0002\b\u00030\"H\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R+\u0010\t\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\nj\u0002`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lexpo/modules/ui/PullToRefreshBoxProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "isRefreshing", "", "contentAlignment", "Lexpo/modules/ui/convertibles/ContentAlignment;", "indicator", "Lexpo/modules/ui/PullToRefreshIndicatorProps;", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(ZLexpo/modules/ui/convertibles/ContentAlignment;Lexpo/modules/ui/PullToRefreshIndicatorProps;Ljava/util/List;)V", "()Z", "getContentAlignment", "()Lexpo/modules/ui/convertibles/ContentAlignment;", "getIndicator", "()Lexpo/modules/ui/PullToRefreshIndicatorProps;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PullToRefreshBoxProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public ContentAlignment contentAlignment;
    public PullToRefreshIndicatorProps indicator;
    public boolean isRefreshing;
    public List<Map<String, Dynamic>> modifiers;

    /* JADX INFO: compiled from: PullToRefreshBoxView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/PullToRefreshBoxProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<PullToRefreshBoxProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(PullToRefreshBoxProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("isRefreshing", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 0, __pika, false, true, false), new PProperty("contentAlignment", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ContentAlignment.class, true, null), 1, __pika, false, true, false), new PProperty("indicator", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(PullToRefreshIndicatorProps.class, false, PullToRefreshIndicatorProps.__Pika.__pika$IntrospectionData), 2, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 3, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PullToRefreshBoxProps");
                return Boolean.valueOf(((PullToRefreshBoxProps) obj).isRefreshing());
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PullToRefreshBoxProps");
                return ((PullToRefreshBoxProps) obj).getContentAlignment();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PullToRefreshBoxProps");
                return ((PullToRefreshBoxProps) obj).getIndicator();
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PullToRefreshBoxProps");
            return ((PullToRefreshBoxProps) obj).getModifiers();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PullToRefreshBoxProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((PullToRefreshBoxProps) obj).isRefreshing = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PullToRefreshBoxProps");
                ((PullToRefreshBoxProps) obj).contentAlignment = (ContentAlignment) obj2;
            } else {
                if (i == 2) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PullToRefreshBoxProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.PullToRefreshIndicatorProps");
                    ((PullToRefreshBoxProps) obj).indicator = (PullToRefreshIndicatorProps) obj2;
                    return;
                }
                if (i != 3) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PullToRefreshBoxProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                ((PullToRefreshBoxProps) obj).modifiers = (List) obj2;
            }
        }
    }

    public PullToRefreshBoxProps() {
        this(false, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PullToRefreshBoxProps copy$default(PullToRefreshBoxProps pullToRefreshBoxProps, boolean z, ContentAlignment contentAlignment, PullToRefreshIndicatorProps pullToRefreshIndicatorProps, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pullToRefreshBoxProps.isRefreshing;
        }
        if ((i & 2) != 0) {
            contentAlignment = pullToRefreshBoxProps.contentAlignment;
        }
        if ((i & 4) != 0) {
            pullToRefreshIndicatorProps = pullToRefreshBoxProps.indicator;
        }
        if ((i & 8) != 0) {
            list = pullToRefreshBoxProps.modifiers;
        }
        return pullToRefreshBoxProps.copy(z, contentAlignment, pullToRefreshIndicatorProps, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsRefreshing() {
        return this.isRefreshing;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ContentAlignment getContentAlignment() {
        return this.contentAlignment;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PullToRefreshIndicatorProps getIndicator() {
        return this.indicator;
    }

    public final List<Map<String, Dynamic>> component4() {
        return this.modifiers;
    }

    public final PullToRefreshBoxProps copy(boolean isRefreshing, ContentAlignment contentAlignment, PullToRefreshIndicatorProps indicator, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new PullToRefreshBoxProps(isRefreshing, contentAlignment, indicator, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PullToRefreshBoxProps)) {
            return false;
        }
        PullToRefreshBoxProps pullToRefreshBoxProps = (PullToRefreshBoxProps) other;
        return this.isRefreshing == pullToRefreshBoxProps.isRefreshing && this.contentAlignment == pullToRefreshBoxProps.contentAlignment && Intrinsics.areEqual(this.indicator, pullToRefreshBoxProps.indicator) && Intrinsics.areEqual(this.modifiers, pullToRefreshBoxProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.isRefreshing) * 31;
        ContentAlignment contentAlignment = this.contentAlignment;
        return ((((iHashCode + (contentAlignment == null ? 0 : contentAlignment.hashCode())) * 31) + this.indicator.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "PullToRefreshBoxProps(isRefreshing=" + this.isRefreshing + ", contentAlignment=" + this.contentAlignment + ", indicator=" + this.indicator + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PullToRefreshBoxProps(boolean z, ContentAlignment contentAlignment, PullToRefreshIndicatorProps indicator, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.isRefreshing = z;
        this.contentAlignment = contentAlignment;
        this.indicator = indicator;
        this.modifiers = modifiers;
    }

    public final boolean isRefreshing() {
        return this.isRefreshing;
    }

    public final ContentAlignment getContentAlignment() {
        return this.contentAlignment;
    }

    public /* synthetic */ PullToRefreshBoxProps(boolean z, ContentAlignment contentAlignment, PullToRefreshIndicatorProps pullToRefreshIndicatorProps, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : contentAlignment, (i & 4) != 0 ? new PullToRefreshIndicatorProps(null, null, null, 7, null) : pullToRefreshIndicatorProps, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final PullToRefreshIndicatorProps getIndicator() {
        return this.indicator;
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
