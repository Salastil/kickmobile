package expo.modules.ui;

import android.graphics.Color;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PFunction;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SegmentedButtonView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001CB\u0097\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0099\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\f\u0010=\u001a\u0006\u0012\u0002\b\u00030>H\u0016J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020BHÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0015R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0015R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010\u0015R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010\u0015R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0015R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0013\u001a\u0004\b+\u0010\u0015¨\u0006D"}, d2 = {"Lexpo/modules/ui/SegmentedButtonColors;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "activeBorderColor", "Landroid/graphics/Color;", "activeContentColor", "inactiveBorderColor", "inactiveContentColor", "disabledActiveBorderColor", "disabledActiveContentColor", "disabledInactiveBorderColor", "disabledInactiveContentColor", "activeContainerColor", "inactiveContainerColor", "disabledActiveContainerColor", "disabledInactiveContainerColor", "<init>", "(Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;)V", "getActiveBorderColor$annotations", "()V", "getActiveBorderColor", "()Landroid/graphics/Color;", "getActiveContentColor$annotations", "getActiveContentColor", "getInactiveBorderColor$annotations", "getInactiveBorderColor", "getInactiveContentColor$annotations", "getInactiveContentColor", "getDisabledActiveBorderColor$annotations", "getDisabledActiveBorderColor", "getDisabledActiveContentColor$annotations", "getDisabledActiveContentColor", "getDisabledInactiveBorderColor$annotations", "getDisabledInactiveBorderColor", "getDisabledInactiveContentColor$annotations", "getDisabledInactiveContentColor", "getActiveContainerColor$annotations", "getActiveContainerColor", "getInactiveContainerColor$annotations", "getInactiveContainerColor", "getDisabledActiveContainerColor$annotations", "getDisabledActiveContainerColor", "getDisabledInactiveContainerColor$annotations", "getDisabledInactiveContainerColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SegmentedButtonColors implements Record, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color activeBorderColor;
    public Color activeContainerColor;
    public Color activeContentColor;
    public Color disabledActiveBorderColor;
    public Color disabledActiveContainerColor;
    public Color disabledActiveContentColor;
    public Color disabledInactiveBorderColor;
    public Color disabledInactiveContainerColor;
    public Color disabledInactiveContentColor;
    public Color inactiveBorderColor;
    public Color inactiveContainerColor;
    public Color inactiveContentColor;

    /* JADX INFO: compiled from: SegmentedButtonView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/SegmentedButtonColors$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<SegmentedButtonColors> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(SegmentedButtonColors.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("activeBorderColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 0, __pika, false, true, false), new PProperty("activeContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 1, __pika, false, true, false), new PProperty("inactiveBorderColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 2, __pika, false, true, false), new PProperty("inactiveContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 3, __pika, false, true, false), new PProperty("disabledActiveBorderColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 4, __pika, false, true, false), new PProperty("disabledActiveContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 5, __pika, false, true, false), new PProperty("disabledInactiveBorderColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 6, __pika, false, true, false), new PProperty("disabledInactiveContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 7, __pika, false, true, false), new PProperty("activeContainerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 8, __pika, false, true, false), new PProperty("inactiveContainerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 9, __pika, false, true, false), new PProperty("disabledActiveContainerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 10, __pika, false, true, false), new PProperty("disabledInactiveContainerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 11, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("component8", PVisibility.PUBLIC), new PFunction("component9", PVisibility.PUBLIC), new PFunction("component10", PVisibility.PUBLIC), new PFunction("component11", PVisibility.PUBLIC), new PFunction("component12", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    return ((SegmentedButtonColors) obj).getActiveBorderColor();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    return ((SegmentedButtonColors) obj).getActiveContentColor();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    return ((SegmentedButtonColors) obj).getInactiveBorderColor();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    return ((SegmentedButtonColors) obj).getInactiveContentColor();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    return ((SegmentedButtonColors) obj).getDisabledActiveBorderColor();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    return ((SegmentedButtonColors) obj).getDisabledActiveContentColor();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    return ((SegmentedButtonColors) obj).getDisabledInactiveBorderColor();
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    return ((SegmentedButtonColors) obj).getDisabledInactiveContentColor();
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    return ((SegmentedButtonColors) obj).getActiveContainerColor();
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    return ((SegmentedButtonColors) obj).getInactiveContainerColor();
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    return ((SegmentedButtonColors) obj).getDisabledActiveContainerColor();
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    return ((SegmentedButtonColors) obj).getDisabledInactiveContainerColor();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    ((SegmentedButtonColors) obj).activeBorderColor = (Color) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    ((SegmentedButtonColors) obj).activeContentColor = (Color) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    ((SegmentedButtonColors) obj).inactiveBorderColor = (Color) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    ((SegmentedButtonColors) obj).inactiveContentColor = (Color) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    ((SegmentedButtonColors) obj).disabledActiveBorderColor = (Color) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    ((SegmentedButtonColors) obj).disabledActiveContentColor = (Color) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    ((SegmentedButtonColors) obj).disabledInactiveBorderColor = (Color) obj2;
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    ((SegmentedButtonColors) obj).disabledInactiveContentColor = (Color) obj2;
                    return;
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    ((SegmentedButtonColors) obj).activeContainerColor = (Color) obj2;
                    return;
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    ((SegmentedButtonColors) obj).inactiveContainerColor = (Color) obj2;
                    return;
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    ((SegmentedButtonColors) obj).disabledActiveContainerColor = (Color) obj2;
                    return;
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SegmentedButtonColors");
                    ((SegmentedButtonColors) obj).disabledInactiveContainerColor = (Color) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public SegmentedButtonColors() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ SegmentedButtonColors copy$default(SegmentedButtonColors segmentedButtonColors, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, Color color7, Color color8, Color color9, Color color10, Color color11, Color color12, int i, Object obj) {
        if ((i & 1) != 0) {
            color = segmentedButtonColors.activeBorderColor;
        }
        if ((i & 2) != 0) {
            color2 = segmentedButtonColors.activeContentColor;
        }
        if ((i & 4) != 0) {
            color3 = segmentedButtonColors.inactiveBorderColor;
        }
        if ((i & 8) != 0) {
            color4 = segmentedButtonColors.inactiveContentColor;
        }
        if ((i & 16) != 0) {
            color5 = segmentedButtonColors.disabledActiveBorderColor;
        }
        if ((i & 32) != 0) {
            color6 = segmentedButtonColors.disabledActiveContentColor;
        }
        if ((i & 64) != 0) {
            color7 = segmentedButtonColors.disabledInactiveBorderColor;
        }
        if ((i & 128) != 0) {
            color8 = segmentedButtonColors.disabledInactiveContentColor;
        }
        if ((i & 256) != 0) {
            color9 = segmentedButtonColors.activeContainerColor;
        }
        if ((i & 512) != 0) {
            color10 = segmentedButtonColors.inactiveContainerColor;
        }
        if ((i & 1024) != 0) {
            color11 = segmentedButtonColors.disabledActiveContainerColor;
        }
        if ((i & 2048) != 0) {
            color12 = segmentedButtonColors.disabledInactiveContainerColor;
        }
        Color color13 = color11;
        Color color14 = color12;
        Color color15 = color9;
        Color color16 = color10;
        Color color17 = color7;
        Color color18 = color8;
        Color color19 = color5;
        Color color20 = color6;
        return segmentedButtonColors.copy(color, color2, color3, color4, color19, color20, color17, color18, color15, color16, color13, color14);
    }

    @Field
    public static /* synthetic */ void getActiveBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getActiveContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getActiveContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledActiveBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledActiveContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledActiveContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledInactiveBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledInactiveContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledInactiveContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getInactiveBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getInactiveContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getInactiveContentColor$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Color getActiveBorderColor() {
        return this.activeBorderColor;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Color getInactiveContainerColor() {
        return this.inactiveContainerColor;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Color getDisabledActiveContainerColor() {
        return this.disabledActiveContainerColor;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Color getDisabledInactiveContainerColor() {
        return this.disabledInactiveContainerColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getActiveContentColor() {
        return this.activeContentColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Color getInactiveBorderColor() {
        return this.inactiveBorderColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Color getInactiveContentColor() {
        return this.inactiveContentColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Color getDisabledActiveBorderColor() {
        return this.disabledActiveBorderColor;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Color getDisabledActiveContentColor() {
        return this.disabledActiveContentColor;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Color getDisabledInactiveBorderColor() {
        return this.disabledInactiveBorderColor;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Color getDisabledInactiveContentColor() {
        return this.disabledInactiveContentColor;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Color getActiveContainerColor() {
        return this.activeContainerColor;
    }

    public final SegmentedButtonColors copy(Color activeBorderColor, Color activeContentColor, Color inactiveBorderColor, Color inactiveContentColor, Color disabledActiveBorderColor, Color disabledActiveContentColor, Color disabledInactiveBorderColor, Color disabledInactiveContentColor, Color activeContainerColor, Color inactiveContainerColor, Color disabledActiveContainerColor, Color disabledInactiveContainerColor) {
        return new SegmentedButtonColors(activeBorderColor, activeContentColor, inactiveBorderColor, inactiveContentColor, disabledActiveBorderColor, disabledActiveContentColor, disabledInactiveBorderColor, disabledInactiveContentColor, activeContainerColor, inactiveContainerColor, disabledActiveContainerColor, disabledInactiveContainerColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SegmentedButtonColors)) {
            return false;
        }
        SegmentedButtonColors segmentedButtonColors = (SegmentedButtonColors) other;
        return Intrinsics.areEqual(this.activeBorderColor, segmentedButtonColors.activeBorderColor) && Intrinsics.areEqual(this.activeContentColor, segmentedButtonColors.activeContentColor) && Intrinsics.areEqual(this.inactiveBorderColor, segmentedButtonColors.inactiveBorderColor) && Intrinsics.areEqual(this.inactiveContentColor, segmentedButtonColors.inactiveContentColor) && Intrinsics.areEqual(this.disabledActiveBorderColor, segmentedButtonColors.disabledActiveBorderColor) && Intrinsics.areEqual(this.disabledActiveContentColor, segmentedButtonColors.disabledActiveContentColor) && Intrinsics.areEqual(this.disabledInactiveBorderColor, segmentedButtonColors.disabledInactiveBorderColor) && Intrinsics.areEqual(this.disabledInactiveContentColor, segmentedButtonColors.disabledInactiveContentColor) && Intrinsics.areEqual(this.activeContainerColor, segmentedButtonColors.activeContainerColor) && Intrinsics.areEqual(this.inactiveContainerColor, segmentedButtonColors.inactiveContainerColor) && Intrinsics.areEqual(this.disabledActiveContainerColor, segmentedButtonColors.disabledActiveContainerColor) && Intrinsics.areEqual(this.disabledInactiveContainerColor, segmentedButtonColors.disabledInactiveContainerColor);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Color color = this.activeBorderColor;
        int iHashCode = (color == null ? 0 : color.hashCode()) * 31;
        Color color2 = this.activeContentColor;
        int iHashCode2 = (iHashCode + (color2 == null ? 0 : color2.hashCode())) * 31;
        Color color3 = this.inactiveBorderColor;
        int iHashCode3 = (iHashCode2 + (color3 == null ? 0 : color3.hashCode())) * 31;
        Color color4 = this.inactiveContentColor;
        int iHashCode4 = (iHashCode3 + (color4 == null ? 0 : color4.hashCode())) * 31;
        Color color5 = this.disabledActiveBorderColor;
        int iHashCode5 = (iHashCode4 + (color5 == null ? 0 : color5.hashCode())) * 31;
        Color color6 = this.disabledActiveContentColor;
        int iHashCode6 = (iHashCode5 + (color6 == null ? 0 : color6.hashCode())) * 31;
        Color color7 = this.disabledInactiveBorderColor;
        int iHashCode7 = (iHashCode6 + (color7 == null ? 0 : color7.hashCode())) * 31;
        Color color8 = this.disabledInactiveContentColor;
        int iHashCode8 = (iHashCode7 + (color8 == null ? 0 : color8.hashCode())) * 31;
        Color color9 = this.activeContainerColor;
        int iHashCode9 = (iHashCode8 + (color9 == null ? 0 : color9.hashCode())) * 31;
        Color color10 = this.inactiveContainerColor;
        int iHashCode10 = (iHashCode9 + (color10 == null ? 0 : color10.hashCode())) * 31;
        Color color11 = this.disabledActiveContainerColor;
        int iHashCode11 = (iHashCode10 + (color11 == null ? 0 : color11.hashCode())) * 31;
        Color color12 = this.disabledInactiveContainerColor;
        return iHashCode11 + (color12 != null ? color12.hashCode() : 0);
    }

    public String toString() {
        return "SegmentedButtonColors(activeBorderColor=" + this.activeBorderColor + ", activeContentColor=" + this.activeContentColor + ", inactiveBorderColor=" + this.inactiveBorderColor + ", inactiveContentColor=" + this.inactiveContentColor + ", disabledActiveBorderColor=" + this.disabledActiveBorderColor + ", disabledActiveContentColor=" + this.disabledActiveContentColor + ", disabledInactiveBorderColor=" + this.disabledInactiveBorderColor + ", disabledInactiveContentColor=" + this.disabledInactiveContentColor + ", activeContainerColor=" + this.activeContainerColor + ", inactiveContainerColor=" + this.inactiveContainerColor + ", disabledActiveContainerColor=" + this.disabledActiveContainerColor + ", disabledInactiveContainerColor=" + this.disabledInactiveContainerColor + ")";
    }

    public SegmentedButtonColors(Color color, Color color2, Color color3, Color color4, Color color5, Color color6, Color color7, Color color8, Color color9, Color color10, Color color11, Color color12) {
        this.activeBorderColor = color;
        this.activeContentColor = color2;
        this.inactiveBorderColor = color3;
        this.inactiveContentColor = color4;
        this.disabledActiveBorderColor = color5;
        this.disabledActiveContentColor = color6;
        this.disabledInactiveBorderColor = color7;
        this.disabledInactiveContentColor = color8;
        this.activeContainerColor = color9;
        this.inactiveContainerColor = color10;
        this.disabledActiveContainerColor = color11;
        this.disabledInactiveContainerColor = color12;
    }

    public /* synthetic */ SegmentedButtonColors(Color color, Color color2, Color color3, Color color4, Color color5, Color color6, Color color7, Color color8, Color color9, Color color10, Color color11, Color color12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : color, (i & 2) != 0 ? null : color2, (i & 4) != 0 ? null : color3, (i & 8) != 0 ? null : color4, (i & 16) != 0 ? null : color5, (i & 32) != 0 ? null : color6, (i & 64) != 0 ? null : color7, (i & 128) != 0 ? null : color8, (i & 256) != 0 ? null : color9, (i & 512) != 0 ? null : color10, (i & 1024) != 0 ? null : color11, (i & 2048) != 0 ? null : color12);
    }

    public final Color getActiveBorderColor() {
        return this.activeBorderColor;
    }

    public final Color getActiveContentColor() {
        return this.activeContentColor;
    }

    public final Color getInactiveBorderColor() {
        return this.inactiveBorderColor;
    }

    public final Color getInactiveContentColor() {
        return this.inactiveContentColor;
    }

    public final Color getDisabledActiveBorderColor() {
        return this.disabledActiveBorderColor;
    }

    public final Color getDisabledActiveContentColor() {
        return this.disabledActiveContentColor;
    }

    public final Color getDisabledInactiveBorderColor() {
        return this.disabledInactiveBorderColor;
    }

    public final Color getDisabledInactiveContentColor() {
        return this.disabledInactiveContentColor;
    }

    public final Color getActiveContainerColor() {
        return this.activeContainerColor;
    }

    public final Color getInactiveContainerColor() {
        return this.inactiveContainerColor;
    }

    public final Color getDisabledActiveContainerColor() {
        return this.disabledActiveContainerColor;
    }

    public final Color getDisabledInactiveContainerColor() {
        return this.disabledInactiveContainerColor;
    }
}
