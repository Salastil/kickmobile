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

/* JADX INFO: compiled from: SwitchView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001SBÇ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0004HÆ\u0003JÉ\u0001\u0010H\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010LHÖ\u0003J\f\u0010M\u001a\u0006\u0012\u0002\b\u00030NH\u0016J\t\u0010O\u001a\u00020PHÖ\u0001J\t\u0010Q\u001a\u00020RHÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\u0019R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0017\u001a\u0004\b'\u0010\u0019R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0019R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010\u0019R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0017\u001a\u0004\b-\u0010\u0019R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0017\u001a\u0004\b/\u0010\u0019R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0017\u001a\u0004\b1\u0010\u0019R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u0017\u001a\u0004\b3\u0010\u0019R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u0017\u001a\u0004\b5\u0010\u0019R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u0017\u001a\u0004\b7\u0010\u0019¨\u0006T"}, d2 = {"Lexpo/modules/ui/SwitchColors;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "checkedThumbColor", "Landroid/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "<init>", "(Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;)V", "getCheckedThumbColor$annotations", "()V", "getCheckedThumbColor", "()Landroid/graphics/Color;", "getCheckedTrackColor$annotations", "getCheckedTrackColor", "getCheckedBorderColor$annotations", "getCheckedBorderColor", "getCheckedIconColor$annotations", "getCheckedIconColor", "getUncheckedThumbColor$annotations", "getUncheckedThumbColor", "getUncheckedTrackColor$annotations", "getUncheckedTrackColor", "getUncheckedBorderColor$annotations", "getUncheckedBorderColor", "getUncheckedIconColor$annotations", "getUncheckedIconColor", "getDisabledCheckedThumbColor$annotations", "getDisabledCheckedThumbColor", "getDisabledCheckedTrackColor$annotations", "getDisabledCheckedTrackColor", "getDisabledCheckedBorderColor$annotations", "getDisabledCheckedBorderColor", "getDisabledCheckedIconColor$annotations", "getDisabledCheckedIconColor", "getDisabledUncheckedThumbColor$annotations", "getDisabledUncheckedThumbColor", "getDisabledUncheckedTrackColor$annotations", "getDisabledUncheckedTrackColor", "getDisabledUncheckedBorderColor$annotations", "getDisabledUncheckedBorderColor", "getDisabledUncheckedIconColor$annotations", "getDisabledUncheckedIconColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SwitchColors implements Record, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color checkedBorderColor;
    public Color checkedIconColor;
    public Color checkedThumbColor;
    public Color checkedTrackColor;
    public Color disabledCheckedBorderColor;
    public Color disabledCheckedIconColor;
    public Color disabledCheckedThumbColor;
    public Color disabledCheckedTrackColor;
    public Color disabledUncheckedBorderColor;
    public Color disabledUncheckedIconColor;
    public Color disabledUncheckedThumbColor;
    public Color disabledUncheckedTrackColor;
    public Color uncheckedBorderColor;
    public Color uncheckedIconColor;
    public Color uncheckedThumbColor;
    public Color uncheckedTrackColor;

    /* JADX INFO: compiled from: SwitchView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/SwitchColors$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<SwitchColors> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(SwitchColors.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("checkedThumbColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 0, __pika, false, true, false), new PProperty("checkedTrackColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 1, __pika, false, true, false), new PProperty("checkedBorderColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 2, __pika, false, true, false), new PProperty("checkedIconColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 3, __pika, false, true, false), new PProperty("uncheckedThumbColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 4, __pika, false, true, false), new PProperty("uncheckedTrackColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 5, __pika, false, true, false), new PProperty("uncheckedBorderColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 6, __pika, false, true, false), new PProperty("uncheckedIconColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 7, __pika, false, true, false), new PProperty("disabledCheckedThumbColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 8, __pika, false, true, false), new PProperty("disabledCheckedTrackColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 9, __pika, false, true, false), new PProperty("disabledCheckedBorderColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 10, __pika, false, true, false), new PProperty("disabledCheckedIconColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 11, __pika, false, true, false), new PProperty("disabledUncheckedThumbColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 12, __pika, false, true, false), new PProperty("disabledUncheckedTrackColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 13, __pika, false, true, false), new PProperty("disabledUncheckedBorderColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 14, __pika, false, true, false), new PProperty("disabledUncheckedIconColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 15, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("component8", PVisibility.PUBLIC), new PFunction("component9", PVisibility.PUBLIC), new PFunction("component10", PVisibility.PUBLIC), new PFunction("component11", PVisibility.PUBLIC), new PFunction("component12", PVisibility.PUBLIC), new PFunction("component13", PVisibility.PUBLIC), new PFunction("component14", PVisibility.PUBLIC), new PFunction("component15", PVisibility.PUBLIC), new PFunction("component16", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getCheckedThumbColor();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getCheckedTrackColor();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getCheckedBorderColor();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getCheckedIconColor();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getUncheckedThumbColor();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getUncheckedTrackColor();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getUncheckedBorderColor();
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getUncheckedIconColor();
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getDisabledCheckedThumbColor();
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getDisabledCheckedTrackColor();
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getDisabledCheckedBorderColor();
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getDisabledCheckedIconColor();
                case 12:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getDisabledUncheckedThumbColor();
                case 13:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getDisabledUncheckedTrackColor();
                case 14:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getDisabledUncheckedBorderColor();
                case 15:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    return ((SwitchColors) obj).getDisabledUncheckedIconColor();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).checkedThumbColor = (Color) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).checkedTrackColor = (Color) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).checkedBorderColor = (Color) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).checkedIconColor = (Color) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).uncheckedThumbColor = (Color) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).uncheckedTrackColor = (Color) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).uncheckedBorderColor = (Color) obj2;
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).uncheckedIconColor = (Color) obj2;
                    return;
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).disabledCheckedThumbColor = (Color) obj2;
                    return;
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).disabledCheckedTrackColor = (Color) obj2;
                    return;
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).disabledCheckedBorderColor = (Color) obj2;
                    return;
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).disabledCheckedIconColor = (Color) obj2;
                    return;
                case 12:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).disabledUncheckedThumbColor = (Color) obj2;
                    return;
                case 13:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).disabledUncheckedTrackColor = (Color) obj2;
                    return;
                case 14:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).disabledUncheckedBorderColor = (Color) obj2;
                    return;
                case 15:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SwitchColors");
                    ((SwitchColors) obj).disabledUncheckedIconColor = (Color) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public SwitchColors() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    public static /* synthetic */ SwitchColors copy$default(SwitchColors switchColors, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, Color color7, Color color8, Color color9, Color color10, Color color11, Color color12, Color color13, Color color14, Color color15, Color color16, int i, Object obj) {
        Color color17 = (i & 1) != 0 ? switchColors.checkedThumbColor : color;
        return switchColors.copy(color17, (i & 2) != 0 ? switchColors.checkedTrackColor : color2, (i & 4) != 0 ? switchColors.checkedBorderColor : color3, (i & 8) != 0 ? switchColors.checkedIconColor : color4, (i & 16) != 0 ? switchColors.uncheckedThumbColor : color5, (i & 32) != 0 ? switchColors.uncheckedTrackColor : color6, (i & 64) != 0 ? switchColors.uncheckedBorderColor : color7, (i & 128) != 0 ? switchColors.uncheckedIconColor : color8, (i & 256) != 0 ? switchColors.disabledCheckedThumbColor : color9, (i & 512) != 0 ? switchColors.disabledCheckedTrackColor : color10, (i & 1024) != 0 ? switchColors.disabledCheckedBorderColor : color11, (i & 2048) != 0 ? switchColors.disabledCheckedIconColor : color12, (i & 4096) != 0 ? switchColors.disabledUncheckedThumbColor : color13, (i & 8192) != 0 ? switchColors.disabledUncheckedTrackColor : color14, (i & 16384) != 0 ? switchColors.disabledUncheckedBorderColor : color15, (i & 32768) != 0 ? switchColors.disabledUncheckedIconColor : color16);
    }

    @Field
    public static /* synthetic */ void getCheckedBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getCheckedIconColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getCheckedThumbColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getCheckedTrackColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledCheckedBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledCheckedIconColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledCheckedThumbColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledCheckedTrackColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledUncheckedBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledUncheckedIconColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledUncheckedThumbColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledUncheckedTrackColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getUncheckedBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getUncheckedIconColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getUncheckedThumbColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getUncheckedTrackColor$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Color getCheckedThumbColor() {
        return this.checkedThumbColor;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Color getDisabledCheckedTrackColor() {
        return this.disabledCheckedTrackColor;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Color getDisabledCheckedBorderColor() {
        return this.disabledCheckedBorderColor;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Color getDisabledCheckedIconColor() {
        return this.disabledCheckedIconColor;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Color getDisabledUncheckedThumbColor() {
        return this.disabledUncheckedThumbColor;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Color getDisabledUncheckedTrackColor() {
        return this.disabledUncheckedTrackColor;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Color getDisabledUncheckedBorderColor() {
        return this.disabledUncheckedBorderColor;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Color getDisabledUncheckedIconColor() {
        return this.disabledUncheckedIconColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getCheckedTrackColor() {
        return this.checkedTrackColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Color getCheckedBorderColor() {
        return this.checkedBorderColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Color getCheckedIconColor() {
        return this.checkedIconColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Color getUncheckedThumbColor() {
        return this.uncheckedThumbColor;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Color getUncheckedTrackColor() {
        return this.uncheckedTrackColor;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Color getUncheckedBorderColor() {
        return this.uncheckedBorderColor;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Color getUncheckedIconColor() {
        return this.uncheckedIconColor;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Color getDisabledCheckedThumbColor() {
        return this.disabledCheckedThumbColor;
    }

    public final SwitchColors copy(Color checkedThumbColor, Color checkedTrackColor, Color checkedBorderColor, Color checkedIconColor, Color uncheckedThumbColor, Color uncheckedTrackColor, Color uncheckedBorderColor, Color uncheckedIconColor, Color disabledCheckedThumbColor, Color disabledCheckedTrackColor, Color disabledCheckedBorderColor, Color disabledCheckedIconColor, Color disabledUncheckedThumbColor, Color disabledUncheckedTrackColor, Color disabledUncheckedBorderColor, Color disabledUncheckedIconColor) {
        return new SwitchColors(checkedThumbColor, checkedTrackColor, checkedBorderColor, checkedIconColor, uncheckedThumbColor, uncheckedTrackColor, uncheckedBorderColor, uncheckedIconColor, disabledCheckedThumbColor, disabledCheckedTrackColor, disabledCheckedBorderColor, disabledCheckedIconColor, disabledUncheckedThumbColor, disabledUncheckedTrackColor, disabledUncheckedBorderColor, disabledUncheckedIconColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SwitchColors)) {
            return false;
        }
        SwitchColors switchColors = (SwitchColors) other;
        return Intrinsics.areEqual(this.checkedThumbColor, switchColors.checkedThumbColor) && Intrinsics.areEqual(this.checkedTrackColor, switchColors.checkedTrackColor) && Intrinsics.areEqual(this.checkedBorderColor, switchColors.checkedBorderColor) && Intrinsics.areEqual(this.checkedIconColor, switchColors.checkedIconColor) && Intrinsics.areEqual(this.uncheckedThumbColor, switchColors.uncheckedThumbColor) && Intrinsics.areEqual(this.uncheckedTrackColor, switchColors.uncheckedTrackColor) && Intrinsics.areEqual(this.uncheckedBorderColor, switchColors.uncheckedBorderColor) && Intrinsics.areEqual(this.uncheckedIconColor, switchColors.uncheckedIconColor) && Intrinsics.areEqual(this.disabledCheckedThumbColor, switchColors.disabledCheckedThumbColor) && Intrinsics.areEqual(this.disabledCheckedTrackColor, switchColors.disabledCheckedTrackColor) && Intrinsics.areEqual(this.disabledCheckedBorderColor, switchColors.disabledCheckedBorderColor) && Intrinsics.areEqual(this.disabledCheckedIconColor, switchColors.disabledCheckedIconColor) && Intrinsics.areEqual(this.disabledUncheckedThumbColor, switchColors.disabledUncheckedThumbColor) && Intrinsics.areEqual(this.disabledUncheckedTrackColor, switchColors.disabledUncheckedTrackColor) && Intrinsics.areEqual(this.disabledUncheckedBorderColor, switchColors.disabledUncheckedBorderColor) && Intrinsics.areEqual(this.disabledUncheckedIconColor, switchColors.disabledUncheckedIconColor);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Color color = this.checkedThumbColor;
        int iHashCode = (color == null ? 0 : color.hashCode()) * 31;
        Color color2 = this.checkedTrackColor;
        int iHashCode2 = (iHashCode + (color2 == null ? 0 : color2.hashCode())) * 31;
        Color color3 = this.checkedBorderColor;
        int iHashCode3 = (iHashCode2 + (color3 == null ? 0 : color3.hashCode())) * 31;
        Color color4 = this.checkedIconColor;
        int iHashCode4 = (iHashCode3 + (color4 == null ? 0 : color4.hashCode())) * 31;
        Color color5 = this.uncheckedThumbColor;
        int iHashCode5 = (iHashCode4 + (color5 == null ? 0 : color5.hashCode())) * 31;
        Color color6 = this.uncheckedTrackColor;
        int iHashCode6 = (iHashCode5 + (color6 == null ? 0 : color6.hashCode())) * 31;
        Color color7 = this.uncheckedBorderColor;
        int iHashCode7 = (iHashCode6 + (color7 == null ? 0 : color7.hashCode())) * 31;
        Color color8 = this.uncheckedIconColor;
        int iHashCode8 = (iHashCode7 + (color8 == null ? 0 : color8.hashCode())) * 31;
        Color color9 = this.disabledCheckedThumbColor;
        int iHashCode9 = (iHashCode8 + (color9 == null ? 0 : color9.hashCode())) * 31;
        Color color10 = this.disabledCheckedTrackColor;
        int iHashCode10 = (iHashCode9 + (color10 == null ? 0 : color10.hashCode())) * 31;
        Color color11 = this.disabledCheckedBorderColor;
        int iHashCode11 = (iHashCode10 + (color11 == null ? 0 : color11.hashCode())) * 31;
        Color color12 = this.disabledCheckedIconColor;
        int iHashCode12 = (iHashCode11 + (color12 == null ? 0 : color12.hashCode())) * 31;
        Color color13 = this.disabledUncheckedThumbColor;
        int iHashCode13 = (iHashCode12 + (color13 == null ? 0 : color13.hashCode())) * 31;
        Color color14 = this.disabledUncheckedTrackColor;
        int iHashCode14 = (iHashCode13 + (color14 == null ? 0 : color14.hashCode())) * 31;
        Color color15 = this.disabledUncheckedBorderColor;
        int iHashCode15 = (iHashCode14 + (color15 == null ? 0 : color15.hashCode())) * 31;
        Color color16 = this.disabledUncheckedIconColor;
        return iHashCode15 + (color16 != null ? color16.hashCode() : 0);
    }

    public String toString() {
        return "SwitchColors(checkedThumbColor=" + this.checkedThumbColor + ", checkedTrackColor=" + this.checkedTrackColor + ", checkedBorderColor=" + this.checkedBorderColor + ", checkedIconColor=" + this.checkedIconColor + ", uncheckedThumbColor=" + this.uncheckedThumbColor + ", uncheckedTrackColor=" + this.uncheckedTrackColor + ", uncheckedBorderColor=" + this.uncheckedBorderColor + ", uncheckedIconColor=" + this.uncheckedIconColor + ", disabledCheckedThumbColor=" + this.disabledCheckedThumbColor + ", disabledCheckedTrackColor=" + this.disabledCheckedTrackColor + ", disabledCheckedBorderColor=" + this.disabledCheckedBorderColor + ", disabledCheckedIconColor=" + this.disabledCheckedIconColor + ", disabledUncheckedThumbColor=" + this.disabledUncheckedThumbColor + ", disabledUncheckedTrackColor=" + this.disabledUncheckedTrackColor + ", disabledUncheckedBorderColor=" + this.disabledUncheckedBorderColor + ", disabledUncheckedIconColor=" + this.disabledUncheckedIconColor + ")";
    }

    public SwitchColors(Color color, Color color2, Color color3, Color color4, Color color5, Color color6, Color color7, Color color8, Color color9, Color color10, Color color11, Color color12, Color color13, Color color14, Color color15, Color color16) {
        this.checkedThumbColor = color;
        this.checkedTrackColor = color2;
        this.checkedBorderColor = color3;
        this.checkedIconColor = color4;
        this.uncheckedThumbColor = color5;
        this.uncheckedTrackColor = color6;
        this.uncheckedBorderColor = color7;
        this.uncheckedIconColor = color8;
        this.disabledCheckedThumbColor = color9;
        this.disabledCheckedTrackColor = color10;
        this.disabledCheckedBorderColor = color11;
        this.disabledCheckedIconColor = color12;
        this.disabledUncheckedThumbColor = color13;
        this.disabledUncheckedTrackColor = color14;
        this.disabledUncheckedBorderColor = color15;
        this.disabledUncheckedIconColor = color16;
    }

    public /* synthetic */ SwitchColors(Color color, Color color2, Color color3, Color color4, Color color5, Color color6, Color color7, Color color8, Color color9, Color color10, Color color11, Color color12, Color color13, Color color14, Color color15, Color color16, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : color, (i & 2) != 0 ? null : color2, (i & 4) != 0 ? null : color3, (i & 8) != 0 ? null : color4, (i & 16) != 0 ? null : color5, (i & 32) != 0 ? null : color6, (i & 64) != 0 ? null : color7, (i & 128) != 0 ? null : color8, (i & 256) != 0 ? null : color9, (i & 512) != 0 ? null : color10, (i & 1024) != 0 ? null : color11, (i & 2048) != 0 ? null : color12, (i & 4096) != 0 ? null : color13, (i & 8192) != 0 ? null : color14, (i & 16384) != 0 ? null : color15, (i & 32768) != 0 ? null : color16);
    }

    public final Color getCheckedThumbColor() {
        return this.checkedThumbColor;
    }

    public final Color getCheckedTrackColor() {
        return this.checkedTrackColor;
    }

    public final Color getCheckedBorderColor() {
        return this.checkedBorderColor;
    }

    public final Color getCheckedIconColor() {
        return this.checkedIconColor;
    }

    public final Color getUncheckedThumbColor() {
        return this.uncheckedThumbColor;
    }

    public final Color getUncheckedTrackColor() {
        return this.uncheckedTrackColor;
    }

    public final Color getUncheckedBorderColor() {
        return this.uncheckedBorderColor;
    }

    public final Color getUncheckedIconColor() {
        return this.uncheckedIconColor;
    }

    public final Color getDisabledCheckedThumbColor() {
        return this.disabledCheckedThumbColor;
    }

    public final Color getDisabledCheckedTrackColor() {
        return this.disabledCheckedTrackColor;
    }

    public final Color getDisabledCheckedBorderColor() {
        return this.disabledCheckedBorderColor;
    }

    public final Color getDisabledCheckedIconColor() {
        return this.disabledCheckedIconColor;
    }

    public final Color getDisabledUncheckedThumbColor() {
        return this.disabledUncheckedThumbColor;
    }

    public final Color getDisabledUncheckedTrackColor() {
        return this.disabledUncheckedTrackColor;
    }

    public final Color getDisabledUncheckedBorderColor() {
        return this.disabledUncheckedBorderColor;
    }

    public final Color getDisabledUncheckedIconColor() {
        return this.disabledUncheckedIconColor;
    }
}
