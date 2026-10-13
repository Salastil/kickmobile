package expo.modules.ui.button;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.OptimizedComposeProps;
import expo.modules.ui.ShapeRecord;
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

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001,BW\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\"\b\u0002\u0010\u000b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\fj\u0002`\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J#\u0010\"\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\fj\u0002`\u0011HÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\"\b\u0002\u0010\u000b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\fj\u0002`\u0011HÆ\u0001J\u0013\u0010$\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\f\u0010'\u001a\u0006\u0012\u0002\b\u00030(H\u0016J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR+\u0010\u000b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\fj\u0002`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lexpo/modules/ui/button/ButtonProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "colors", "Lexpo/modules/ui/button/ButtonColors;", "enabled", "", "contentPadding", "Lexpo/modules/ui/button/ContentPaddingRecord;", "shape", "Lexpo/modules/ui/ShapeRecord;", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Lexpo/modules/ui/button/ButtonColors;ZLexpo/modules/ui/button/ContentPaddingRecord;Lexpo/modules/ui/ShapeRecord;Ljava/util/List;)V", "getColors", "()Lexpo/modules/ui/button/ButtonColors;", "getEnabled", "()Z", "getContentPadding", "()Lexpo/modules/ui/button/ContentPaddingRecord;", "getShape", "()Lexpo/modules/ui/ShapeRecord;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ButtonProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public ButtonColors colors;
    public ContentPaddingRecord contentPadding;
    public boolean enabled;
    public List<Map<String, Dynamic>> modifiers;
    public ShapeRecord shape;

    /* JADX INFO: compiled from: Button.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/button/ButtonProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ButtonProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ButtonProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("colors", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ButtonColors.class, false, ButtonColors.__Pika.__pika$IntrospectionData), 0, __pika, false, true, false), new PProperty("enabled", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 1, __pika, false, true, false), new PProperty("contentPadding", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ContentPaddingRecord.class, true, ContentPaddingRecord.__Pika.__pika$IntrospectionData), 2, __pika, false, true, false), new PProperty("shape", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ShapeRecord.class, true, ShapeRecord.__Pika.__pika$IntrospectionData), 3, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 4, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.button.ButtonProps");
                return ((ButtonProps) obj).getColors();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.button.ButtonProps");
                return Boolean.valueOf(((ButtonProps) obj).getEnabled());
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.button.ButtonProps");
                return ((ButtonProps) obj).getContentPadding();
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.button.ButtonProps");
                return ((ButtonProps) obj).getShape();
            }
            if (i != 4) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.button.ButtonProps");
            return ((ButtonProps) obj).getModifiers();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.button.ButtonProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.button.ButtonColors");
                ((ButtonProps) obj).colors = (ButtonColors) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.button.ButtonProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((ButtonProps) obj).enabled = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.button.ButtonProps");
                ((ButtonProps) obj).contentPadding = (ContentPaddingRecord) obj2;
            } else if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.button.ButtonProps");
                ((ButtonProps) obj).shape = (ShapeRecord) obj2;
            } else {
                if (i != 4) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.button.ButtonProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                ((ButtonProps) obj).modifiers = (List) obj2;
            }
        }
    }

    public ButtonProps() {
        this(null, false, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ButtonProps copy$default(ButtonProps buttonProps, ButtonColors buttonColors, boolean z, ContentPaddingRecord contentPaddingRecord, ShapeRecord shapeRecord, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            buttonColors = buttonProps.colors;
        }
        if ((i & 2) != 0) {
            z = buttonProps.enabled;
        }
        if ((i & 4) != 0) {
            contentPaddingRecord = buttonProps.contentPadding;
        }
        if ((i & 8) != 0) {
            shapeRecord = buttonProps.shape;
        }
        if ((i & 16) != 0) {
            list = buttonProps.modifiers;
        }
        List list2 = list;
        ContentPaddingRecord contentPaddingRecord2 = contentPaddingRecord;
        return buttonProps.copy(buttonColors, z, contentPaddingRecord2, shapeRecord, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ButtonColors getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ContentPaddingRecord getContentPadding() {
        return this.contentPadding;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ShapeRecord getShape() {
        return this.shape;
    }

    public final List<Map<String, Dynamic>> component5() {
        return this.modifiers;
    }

    public final ButtonProps copy(ButtonColors colors, boolean enabled, ContentPaddingRecord contentPadding, ShapeRecord shape, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new ButtonProps(colors, enabled, contentPadding, shape, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonProps)) {
            return false;
        }
        ButtonProps buttonProps = (ButtonProps) other;
        return Intrinsics.areEqual(this.colors, buttonProps.colors) && this.enabled == buttonProps.enabled && Intrinsics.areEqual(this.contentPadding, buttonProps.contentPadding) && Intrinsics.areEqual(this.shape, buttonProps.shape) && Intrinsics.areEqual(this.modifiers, buttonProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = ((this.colors.hashCode() * 31) + Boolean.hashCode(this.enabled)) * 31;
        ContentPaddingRecord contentPaddingRecord = this.contentPadding;
        int iHashCode2 = (iHashCode + (contentPaddingRecord == null ? 0 : contentPaddingRecord.hashCode())) * 31;
        ShapeRecord shapeRecord = this.shape;
        return ((iHashCode2 + (shapeRecord != null ? shapeRecord.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "ButtonProps(colors=" + this.colors + ", enabled=" + this.enabled + ", contentPadding=" + this.contentPadding + ", shape=" + this.shape + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ButtonProps(ButtonColors colors, boolean z, ContentPaddingRecord contentPaddingRecord, ShapeRecord shapeRecord, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.colors = colors;
        this.enabled = z;
        this.contentPadding = contentPaddingRecord;
        this.shape = shapeRecord;
        this.modifiers = modifiers;
    }

    public /* synthetic */ ButtonProps(ButtonColors buttonColors, boolean z, ContentPaddingRecord contentPaddingRecord, ShapeRecord shapeRecord, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ButtonColors() : buttonColors, (i & 2) != 0 ? true : z, (i & 4) != 0 ? null : contentPaddingRecord, (i & 8) != 0 ? null : shapeRecord, (i & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final ButtonColors getColors() {
        return this.colors;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final ContentPaddingRecord getContentPadding() {
        return this.contentPadding;
    }

    public final ShapeRecord getShape() {
        return this.shape;
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
