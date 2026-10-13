package expo.modules.ui;

import android.graphics.Color;
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

/* JADX INFO: compiled from: ModalBottomSheetView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00016B\u0081\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\"\b\u0002\u0010\u000e\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u0002`\u00130\u000fj\u0002`\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0004HÆ\u0003J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003J#\u0010,\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u0002`\u00130\u000fj\u0002`\u0014HÆ\u0003J\u0083\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\"\b\u0002\u0010\u000e\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u0002`\u00130\u000fj\u0002`\u0014HÆ\u0001J\u0013\u0010.\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\f\u00101\u001a\u0006\u0012\u0002\b\u000302H\u0016J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R+\u0010\u000e\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u0002`\u00130\u000fj\u0002`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00067"}, d2 = {"Lexpo/modules/ui/ModalBottomSheetViewProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "skipPartiallyExpanded", "", "initialFullyExpanded", "containerColor", "Landroid/graphics/Color;", "contentColor", "scrimColor", "showDragHandle", "sheetGesturesEnabled", "properties", "Lexpo/modules/ui/ModalBottomSheetPropertiesRecord;", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(ZZLandroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;ZZLexpo/modules/ui/ModalBottomSheetPropertiesRecord;Ljava/util/List;)V", "getSkipPartiallyExpanded", "()Z", "getInitialFullyExpanded", "getContainerColor", "()Landroid/graphics/Color;", "getContentColor", "getScrimColor", "getShowDragHandle", "getSheetGesturesEnabled", "getProperties", "()Lexpo/modules/ui/ModalBottomSheetPropertiesRecord;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ModalBottomSheetViewProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color containerColor;
    public Color contentColor;
    public boolean initialFullyExpanded;
    public List<Map<String, Dynamic>> modifiers;
    public ModalBottomSheetPropertiesRecord properties;
    public Color scrimColor;
    public boolean sheetGesturesEnabled;
    public boolean showDragHandle;
    public boolean skipPartiallyExpanded;

    /* JADX INFO: compiled from: ModalBottomSheetView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/ModalBottomSheetViewProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ModalBottomSheetViewProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ModalBottomSheetViewProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("skipPartiallyExpanded", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 0, __pika, false, true, false), new PProperty("initialFullyExpanded", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 1, __pika, false, true, false), new PProperty("containerColor", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 2, __pika, false, true, false), new PProperty("contentColor", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 3, __pika, false, true, false), new PProperty("scrimColor", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 4, __pika, false, true, false), new PProperty("showDragHandle", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 5, __pika, false, true, false), new PProperty("sheetGesturesEnabled", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 6, __pika, false, true, false), new PProperty("properties", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ModalBottomSheetPropertiesRecord.class, false, ModalBottomSheetPropertiesRecord.__Pika.__pika$IntrospectionData), 7, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 8, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("component8", PVisibility.PUBLIC), new PFunction("component9", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    return Boolean.valueOf(((ModalBottomSheetViewProps) obj).getSkipPartiallyExpanded());
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    return Boolean.valueOf(((ModalBottomSheetViewProps) obj).getInitialFullyExpanded());
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    return ((ModalBottomSheetViewProps) obj).getContainerColor();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    return ((ModalBottomSheetViewProps) obj).getContentColor();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    return ((ModalBottomSheetViewProps) obj).getScrimColor();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    return Boolean.valueOf(((ModalBottomSheetViewProps) obj).getShowDragHandle());
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    return Boolean.valueOf(((ModalBottomSheetViewProps) obj).getSheetGesturesEnabled());
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    return ((ModalBottomSheetViewProps) obj).getProperties();
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    return ((ModalBottomSheetViewProps) obj).getModifiers();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((ModalBottomSheetViewProps) obj).skipPartiallyExpanded = ((Boolean) obj2).booleanValue();
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((ModalBottomSheetViewProps) obj).initialFullyExpanded = ((Boolean) obj2).booleanValue();
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    ((ModalBottomSheetViewProps) obj).containerColor = (Color) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    ((ModalBottomSheetViewProps) obj).contentColor = (Color) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    ((ModalBottomSheetViewProps) obj).scrimColor = (Color) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((ModalBottomSheetViewProps) obj).showDragHandle = ((Boolean) obj2).booleanValue();
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((ModalBottomSheetViewProps) obj).sheetGesturesEnabled = ((Boolean) obj2).booleanValue();
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetPropertiesRecord");
                    ((ModalBottomSheetViewProps) obj).properties = (ModalBottomSheetPropertiesRecord) obj2;
                    return;
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetViewProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                    ((ModalBottomSheetViewProps) obj).modifiers = (List) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public ModalBottomSheetViewProps() {
        this(false, false, null, null, null, false, false, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModalBottomSheetViewProps copy$default(ModalBottomSheetViewProps modalBottomSheetViewProps, boolean z, boolean z2, Color color, Color color2, Color color3, boolean z3, boolean z4, ModalBottomSheetPropertiesRecord modalBottomSheetPropertiesRecord, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = modalBottomSheetViewProps.skipPartiallyExpanded;
        }
        if ((i & 2) != 0) {
            z2 = modalBottomSheetViewProps.initialFullyExpanded;
        }
        if ((i & 4) != 0) {
            color = modalBottomSheetViewProps.containerColor;
        }
        if ((i & 8) != 0) {
            color2 = modalBottomSheetViewProps.contentColor;
        }
        if ((i & 16) != 0) {
            color3 = modalBottomSheetViewProps.scrimColor;
        }
        if ((i & 32) != 0) {
            z3 = modalBottomSheetViewProps.showDragHandle;
        }
        if ((i & 64) != 0) {
            z4 = modalBottomSheetViewProps.sheetGesturesEnabled;
        }
        if ((i & 128) != 0) {
            modalBottomSheetPropertiesRecord = modalBottomSheetViewProps.properties;
        }
        if ((i & 256) != 0) {
            list = modalBottomSheetViewProps.modifiers;
        }
        ModalBottomSheetPropertiesRecord modalBottomSheetPropertiesRecord2 = modalBottomSheetPropertiesRecord;
        List list2 = list;
        boolean z5 = z3;
        boolean z6 = z4;
        Color color4 = color3;
        Color color5 = color;
        return modalBottomSheetViewProps.copy(z, z2, color5, color2, color4, z5, z6, modalBottomSheetPropertiesRecord2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSkipPartiallyExpanded() {
        return this.skipPartiallyExpanded;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getInitialFullyExpanded() {
        return this.initialFullyExpanded;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Color getContainerColor() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Color getContentColor() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Color getScrimColor() {
        return this.scrimColor;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getShowDragHandle() {
        return this.showDragHandle;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getSheetGesturesEnabled() {
        return this.sheetGesturesEnabled;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ModalBottomSheetPropertiesRecord getProperties() {
        return this.properties;
    }

    public final List<Map<String, Dynamic>> component9() {
        return this.modifiers;
    }

    public final ModalBottomSheetViewProps copy(boolean skipPartiallyExpanded, boolean initialFullyExpanded, Color containerColor, Color contentColor, Color scrimColor, boolean showDragHandle, boolean sheetGesturesEnabled, ModalBottomSheetPropertiesRecord properties, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new ModalBottomSheetViewProps(skipPartiallyExpanded, initialFullyExpanded, containerColor, contentColor, scrimColor, showDragHandle, sheetGesturesEnabled, properties, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModalBottomSheetViewProps)) {
            return false;
        }
        ModalBottomSheetViewProps modalBottomSheetViewProps = (ModalBottomSheetViewProps) other;
        return this.skipPartiallyExpanded == modalBottomSheetViewProps.skipPartiallyExpanded && this.initialFullyExpanded == modalBottomSheetViewProps.initialFullyExpanded && Intrinsics.areEqual(this.containerColor, modalBottomSheetViewProps.containerColor) && Intrinsics.areEqual(this.contentColor, modalBottomSheetViewProps.contentColor) && Intrinsics.areEqual(this.scrimColor, modalBottomSheetViewProps.scrimColor) && this.showDragHandle == modalBottomSheetViewProps.showDragHandle && this.sheetGesturesEnabled == modalBottomSheetViewProps.sheetGesturesEnabled && Intrinsics.areEqual(this.properties, modalBottomSheetViewProps.properties) && Intrinsics.areEqual(this.modifiers, modalBottomSheetViewProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.skipPartiallyExpanded) * 31) + Boolean.hashCode(this.initialFullyExpanded)) * 31;
        Color color = this.containerColor;
        int iHashCode2 = (iHashCode + (color == null ? 0 : color.hashCode())) * 31;
        Color color2 = this.contentColor;
        int iHashCode3 = (iHashCode2 + (color2 == null ? 0 : color2.hashCode())) * 31;
        Color color3 = this.scrimColor;
        return ((((((((iHashCode3 + (color3 != null ? color3.hashCode() : 0)) * 31) + Boolean.hashCode(this.showDragHandle)) * 31) + Boolean.hashCode(this.sheetGesturesEnabled)) * 31) + this.properties.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "ModalBottomSheetViewProps(skipPartiallyExpanded=" + this.skipPartiallyExpanded + ", initialFullyExpanded=" + this.initialFullyExpanded + ", containerColor=" + this.containerColor + ", contentColor=" + this.contentColor + ", scrimColor=" + this.scrimColor + ", showDragHandle=" + this.showDragHandle + ", sheetGesturesEnabled=" + this.sheetGesturesEnabled + ", properties=" + this.properties + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ModalBottomSheetViewProps(boolean z, boolean z2, Color color, Color color2, Color color3, boolean z3, boolean z4, ModalBottomSheetPropertiesRecord properties, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.skipPartiallyExpanded = z;
        this.initialFullyExpanded = z2;
        this.containerColor = color;
        this.contentColor = color2;
        this.scrimColor = color3;
        this.showDragHandle = z3;
        this.sheetGesturesEnabled = z4;
        this.properties = properties;
        this.modifiers = modifiers;
    }

    public final boolean getSkipPartiallyExpanded() {
        return this.skipPartiallyExpanded;
    }

    public final boolean getInitialFullyExpanded() {
        return this.initialFullyExpanded;
    }

    public final Color getContainerColor() {
        return this.containerColor;
    }

    public final Color getContentColor() {
        return this.contentColor;
    }

    public final Color getScrimColor() {
        return this.scrimColor;
    }

    public final boolean getShowDragHandle() {
        return this.showDragHandle;
    }

    public final boolean getSheetGesturesEnabled() {
        return this.sheetGesturesEnabled;
    }

    public /* synthetic */ ModalBottomSheetViewProps(boolean z, boolean z2, Color color, Color color2, Color color3, boolean z3, boolean z4, ModalBottomSheetPropertiesRecord modalBottomSheetPropertiesRecord, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : color, (i & 8) != 0 ? null : color2, (i & 16) != 0 ? null : color3, (i & 32) != 0 ? true : z3, (i & 64) != 0 ? true : z4, (i & 128) != 0 ? new ModalBottomSheetPropertiesRecord(false, false, 3, null) : modalBottomSheetPropertiesRecord, (i & 256) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final ModalBottomSheetPropertiesRecord getProperties() {
        return this.properties;
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
