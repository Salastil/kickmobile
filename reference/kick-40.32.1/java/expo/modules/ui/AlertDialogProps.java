package expo.modules.ui;

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

/* JADX INFO: compiled from: AlertDialogView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001*BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\"\b\u0002\u0010\t\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\nj\u0002`\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J#\u0010\u001e\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\nj\u0002`\u000fHÆ\u0003JR\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\"\b\u0002\u0010\t\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\nj\u0002`\u000fHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\f\u0010%\u001a\u0006\u0012\u0002\b\u00030&H\u0016J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R+\u0010\t\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\nj\u0002`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006+"}, d2 = {"Lexpo/modules/ui/AlertDialogProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "colors", "Lexpo/modules/ui/AlertDialogColors;", "tonalElevation", "", "properties", "Lexpo/modules/ui/ExpoDialogProperties;", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Lexpo/modules/ui/AlertDialogColors;Ljava/lang/Double;Lexpo/modules/ui/ExpoDialogProperties;Ljava/util/List;)V", "getColors", "()Lexpo/modules/ui/AlertDialogColors;", "getTonalElevation", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getProperties", "()Lexpo/modules/ui/ExpoDialogProperties;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Lexpo/modules/ui/AlertDialogColors;Ljava/lang/Double;Lexpo/modules/ui/ExpoDialogProperties;Ljava/util/List;)Lexpo/modules/ui/AlertDialogProps;", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AlertDialogProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public AlertDialogColors colors;
    public List<Map<String, Dynamic>> modifiers;
    public ExpoDialogProperties properties;
    public Double tonalElevation;

    /* JADX INFO: compiled from: AlertDialogView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/AlertDialogProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<AlertDialogProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(AlertDialogProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("colors", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(AlertDialogColors.class, false, AlertDialogColors.__Pika.__pika$IntrospectionData), 0, __pika, false, true, false), new PProperty("tonalElevation", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.DOUBLE_NULLABLE, 1, __pika, false, true, false), new PProperty("properties", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ExpoDialogProperties.class, false, ExpoDialogProperties.__Pika.__pika$IntrospectionData), 2, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 3, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AlertDialogProps");
                return ((AlertDialogProps) obj).getColors();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AlertDialogProps");
                return ((AlertDialogProps) obj).getTonalElevation();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AlertDialogProps");
                return ((AlertDialogProps) obj).getProperties();
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AlertDialogProps");
            return ((AlertDialogProps) obj).getModifiers();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AlertDialogProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.AlertDialogColors");
                ((AlertDialogProps) obj).colors = (AlertDialogColors) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AlertDialogProps");
                ((AlertDialogProps) obj).tonalElevation = (Double) obj2;
            } else {
                if (i == 2) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AlertDialogProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.ExpoDialogProperties");
                    ((AlertDialogProps) obj).properties = (ExpoDialogProperties) obj2;
                    return;
                }
                if (i != 3) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AlertDialogProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                ((AlertDialogProps) obj).modifiers = (List) obj2;
            }
        }
    }

    public AlertDialogProps() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlertDialogProps copy$default(AlertDialogProps alertDialogProps, AlertDialogColors alertDialogColors, Double d, ExpoDialogProperties expoDialogProperties, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            alertDialogColors = alertDialogProps.colors;
        }
        if ((i & 2) != 0) {
            d = alertDialogProps.tonalElevation;
        }
        if ((i & 4) != 0) {
            expoDialogProperties = alertDialogProps.properties;
        }
        if ((i & 8) != 0) {
            list = alertDialogProps.modifiers;
        }
        return alertDialogProps.copy(alertDialogColors, d, expoDialogProperties, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AlertDialogColors getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getTonalElevation() {
        return this.tonalElevation;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ExpoDialogProperties getProperties() {
        return this.properties;
    }

    public final List<Map<String, Dynamic>> component4() {
        return this.modifiers;
    }

    public final AlertDialogProps copy(AlertDialogColors colors, Double tonalElevation, ExpoDialogProperties properties, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new AlertDialogProps(colors, tonalElevation, properties, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlertDialogProps)) {
            return false;
        }
        AlertDialogProps alertDialogProps = (AlertDialogProps) other;
        return Intrinsics.areEqual(this.colors, alertDialogProps.colors) && Intrinsics.areEqual((Object) this.tonalElevation, (Object) alertDialogProps.tonalElevation) && Intrinsics.areEqual(this.properties, alertDialogProps.properties) && Intrinsics.areEqual(this.modifiers, alertDialogProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        Double d = this.tonalElevation;
        return ((((iHashCode + (d == null ? 0 : d.hashCode())) * 31) + this.properties.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "AlertDialogProps(colors=" + this.colors + ", tonalElevation=" + this.tonalElevation + ", properties=" + this.properties + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AlertDialogProps(AlertDialogColors colors, Double d, ExpoDialogProperties properties, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.colors = colors;
        this.tonalElevation = d;
        this.properties = properties;
        this.modifiers = modifiers;
    }

    public /* synthetic */ AlertDialogProps(AlertDialogColors alertDialogColors, Double d, ExpoDialogProperties expoDialogProperties, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new AlertDialogColors(null, null, null, null, 15, null) : alertDialogColors, (i & 2) != 0 ? null : d, (i & 4) != 0 ? new ExpoDialogProperties(false, false, false, false, 15, null) : expoDialogProperties, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final AlertDialogColors getColors() {
        return this.colors;
    }

    public final Double getTonalElevation() {
        return this.tonalElevation;
    }

    public final ExpoDialogProperties getProperties() {
        return this.properties;
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
