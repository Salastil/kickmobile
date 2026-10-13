package expo.modules.ui.textfield;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.OptimizedComposeProps;
import expo.modules.ui.ShapeRecord;
import expo.modules.ui.state.ObservableState;
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
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001cBó\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\"\b\u0002\u0010 \u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"j\u0002`$0!j\u0002`%¢\u0006\u0004\b&\u0010'J\t\u0010G\u001a\u00020\u0004HÆ\u0003J\t\u0010H\u001a\u00020\u0004HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010,J\t\u0010J\u001a\u00020\tHÆ\u0003J\t\u0010K\u001a\u00020\u000bHÆ\u0003J\t\u0010L\u001a\u00020\tHÆ\u0003J\t\u0010M\u001a\u00020\tHÆ\u0003J\t\u0010N\u001a\u00020\tHÆ\u0003J\t\u0010O\u001a\u00020\tHÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010R\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u001fHÆ\u0003J#\u0010Y\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"j\u0002`$0!j\u0002`%HÆ\u0003Jú\u0001\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\"\b\u0002\u0010 \u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"j\u0002`$0!j\u0002`%HÆ\u0001¢\u0006\u0002\u0010[J\u0013\u0010\\\u001a\u00020\t2\b\u0010]\u001a\u0004\u0018\u00010^HÖ\u0003J\f\u0010_\u001a\u0006\u0012\u0002\b\u00030`H\u0016J\t\u0010a\u001a\u00020\u0007HÖ\u0001J\t\u0010b\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010/R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b4\u0010/R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010-\u001a\u0004\b5\u0010,R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010-\u001a\u0004\b6\u0010,R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR+\u0010 \u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"j\u0002`$0!j\u0002`%¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F¨\u0006d"}, d2 = {"Lexpo/modules/ui/textfield/TextFieldProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "value", "Lexpo/modules/ui/state/ObservableState;", "selection", "maxLength", "", "autoFocus", "", "variant", "Lexpo/modules/ui/textfield/TextFieldVariant;", "enabled", "readOnly", "isError", "singleLine", "maxLines", "minLines", "textStyle", "Lexpo/modules/ui/textfield/TextFieldTextStyleRecord;", "visualTransformation", "", "keyboardOptions", "Lexpo/modules/ui/textfield/TextFieldKeyboardOptionsRecord;", "shape", "Lexpo/modules/ui/ShapeRecord;", "colors", "Lexpo/modules/ui/textfield/TextFieldColorsRecord;", "textSelectionColors", "Lexpo/modules/ui/textfield/TextFieldSelectionColorsRecord;", "onValueChangeSync", "Lexpo/modules/ui/state/WorkletCallback;", "modifiers", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Lexpo/modules/ui/state/ObservableState;Lexpo/modules/ui/state/ObservableState;Ljava/lang/Integer;ZLexpo/modules/ui/textfield/TextFieldVariant;ZZZZLjava/lang/Integer;Ljava/lang/Integer;Lexpo/modules/ui/textfield/TextFieldTextStyleRecord;Ljava/lang/String;Lexpo/modules/ui/textfield/TextFieldKeyboardOptionsRecord;Lexpo/modules/ui/ShapeRecord;Lexpo/modules/ui/textfield/TextFieldColorsRecord;Lexpo/modules/ui/textfield/TextFieldSelectionColorsRecord;Lexpo/modules/ui/state/WorkletCallback;Ljava/util/List;)V", "getValue", "()Lexpo/modules/ui/state/ObservableState;", "getSelection", "getMaxLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAutoFocus", "()Z", "getVariant", "()Lexpo/modules/ui/textfield/TextFieldVariant;", "getEnabled", "getReadOnly", "getSingleLine", "getMaxLines", "getMinLines", "getTextStyle", "()Lexpo/modules/ui/textfield/TextFieldTextStyleRecord;", "getVisualTransformation", "()Ljava/lang/String;", "getKeyboardOptions", "()Lexpo/modules/ui/textfield/TextFieldKeyboardOptionsRecord;", "getShape", "()Lexpo/modules/ui/ShapeRecord;", "getColors", "()Lexpo/modules/ui/textfield/TextFieldColorsRecord;", "getTextSelectionColors", "()Lexpo/modules/ui/textfield/TextFieldSelectionColorsRecord;", "getOnValueChangeSync", "()Lexpo/modules/ui/state/WorkletCallback;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Lexpo/modules/ui/state/ObservableState;Lexpo/modules/ui/state/ObservableState;Ljava/lang/Integer;ZLexpo/modules/ui/textfield/TextFieldVariant;ZZZZLjava/lang/Integer;Ljava/lang/Integer;Lexpo/modules/ui/textfield/TextFieldTextStyleRecord;Ljava/lang/String;Lexpo/modules/ui/textfield/TextFieldKeyboardOptionsRecord;Lexpo/modules/ui/ShapeRecord;Lexpo/modules/ui/textfield/TextFieldColorsRecord;Lexpo/modules/ui/textfield/TextFieldSelectionColorsRecord;Lexpo/modules/ui/state/WorkletCallback;Ljava/util/List;)Lexpo/modules/ui/textfield/TextFieldProps;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TextFieldProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public boolean autoFocus;
    public TextFieldColorsRecord colors;
    public boolean enabled;
    public boolean isError;
    public TextFieldKeyboardOptionsRecord keyboardOptions;
    public Integer maxLength;
    public Integer maxLines;
    public Integer minLines;
    public List<Map<String, Dynamic>> modifiers;
    public WorkletCallback onValueChangeSync;
    public boolean readOnly;
    public ObservableState selection;
    public ShapeRecord shape;
    public boolean singleLine;
    public TextFieldSelectionColorsRecord textSelectionColors;
    public TextFieldTextStyleRecord textStyle;
    public ObservableState value;
    public TextFieldVariant variant;
    public String visualTransformation;

    /* JADX INFO: compiled from: TextField.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/textfield/TextFieldProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<TextFieldProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(TextFieldProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("value", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ObservableState.class, false, null), 0, __pika, false, true, false), new PProperty("selection", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ObservableState.class, false, null), 1, __pika, false, true, false), new PProperty("maxLength", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.INT_NULLABLE, 2, __pika, false, true, false), new PProperty("autoFocus", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 3, __pika, false, true, false), new PProperty("variant", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(TextFieldVariant.class, false, null), 4, __pika, false, true, false), new PProperty("enabled", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 5, __pika, false, true, false), new PProperty("readOnly", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 6, __pika, false, true, false), new PProperty("isError", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 7, __pika, false, true, false), new PProperty("singleLine", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 8, __pika, false, true, false), new PProperty("maxLines", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.INT_NULLABLE, 9, __pika, false, true, false), new PProperty("minLines", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.INT_NULLABLE, 10, __pika, false, true, false), new PProperty("textStyle", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(TextFieldTextStyleRecord.class, true, null), 11, __pika, false, true, false), new PProperty("visualTransformation", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.STRING_NULLABLE, 12, __pika, false, true, false), new PProperty("keyboardOptions", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(TextFieldKeyboardOptionsRecord.class, true, null), 13, __pika, false, true, false), new PProperty("shape", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ShapeRecord.class, true, ShapeRecord.__Pika.__pika$IntrospectionData), 14, __pika, false, true, false), new PProperty("colors", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(TextFieldColorsRecord.class, true, TextFieldColorsRecord.__Pika.__pika$IntrospectionData), 15, __pika, false, true, false), new PProperty("textSelectionColors", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(TextFieldSelectionColorsRecord.class, true, TextFieldSelectionColorsRecord.__Pika.__pika$IntrospectionData), 16, __pika, false, true, false), new PProperty("onValueChangeSync", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(WorkletCallback.class, true, null), 17, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 18, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("component8", PVisibility.PUBLIC), new PFunction("component9", PVisibility.PUBLIC), new PFunction("component10", PVisibility.PUBLIC), new PFunction("component11", PVisibility.PUBLIC), new PFunction("component12", PVisibility.PUBLIC), new PFunction("component13", PVisibility.PUBLIC), new PFunction("component14", PVisibility.PUBLIC), new PFunction("component15", PVisibility.PUBLIC), new PFunction("component16", PVisibility.PUBLIC), new PFunction("component17", PVisibility.PUBLIC), new PFunction("component18", PVisibility.PUBLIC), new PFunction("component19", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return ((TextFieldProps) obj).getValue();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return ((TextFieldProps) obj).getSelection();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return ((TextFieldProps) obj).getMaxLength();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return Boolean.valueOf(((TextFieldProps) obj).getAutoFocus());
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return ((TextFieldProps) obj).getVariant();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return Boolean.valueOf(((TextFieldProps) obj).getEnabled());
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return Boolean.valueOf(((TextFieldProps) obj).getReadOnly());
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return Boolean.valueOf(((TextFieldProps) obj).isError());
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return Boolean.valueOf(((TextFieldProps) obj).getSingleLine());
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return ((TextFieldProps) obj).getMaxLines();
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return ((TextFieldProps) obj).getMinLines();
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return ((TextFieldProps) obj).getTextStyle();
                case 12:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return ((TextFieldProps) obj).getVisualTransformation();
                case 13:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return ((TextFieldProps) obj).getKeyboardOptions();
                case 14:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return ((TextFieldProps) obj).getShape();
                case 15:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return ((TextFieldProps) obj).getColors();
                case 16:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return ((TextFieldProps) obj).getTextSelectionColors();
                case 17:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return ((TextFieldProps) obj).getOnValueChangeSync();
                case 18:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    return ((TextFieldProps) obj).getModifiers();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.state.ObservableState");
                    ((TextFieldProps) obj).value = (ObservableState) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.state.ObservableState");
                    ((TextFieldProps) obj).selection = (ObservableState) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    ((TextFieldProps) obj).maxLength = (Integer) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((TextFieldProps) obj).autoFocus = ((Boolean) obj2).booleanValue();
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldVariant");
                    ((TextFieldProps) obj).variant = (TextFieldVariant) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((TextFieldProps) obj).enabled = ((Boolean) obj2).booleanValue();
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((TextFieldProps) obj).readOnly = ((Boolean) obj2).booleanValue();
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((TextFieldProps) obj).isError = ((Boolean) obj2).booleanValue();
                    return;
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((TextFieldProps) obj).singleLine = ((Boolean) obj2).booleanValue();
                    return;
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    ((TextFieldProps) obj).maxLines = (Integer) obj2;
                    return;
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    ((TextFieldProps) obj).minLines = (Integer) obj2;
                    return;
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    ((TextFieldProps) obj).textStyle = (TextFieldTextStyleRecord) obj2;
                    return;
                case 12:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    ((TextFieldProps) obj).visualTransformation = (String) obj2;
                    return;
                case 13:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    ((TextFieldProps) obj).keyboardOptions = (TextFieldKeyboardOptionsRecord) obj2;
                    return;
                case 14:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    ((TextFieldProps) obj).shape = (ShapeRecord) obj2;
                    return;
                case 15:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    ((TextFieldProps) obj).colors = (TextFieldColorsRecord) obj2;
                    return;
                case 16:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    ((TextFieldProps) obj).textSelectionColors = (TextFieldSelectionColorsRecord) obj2;
                    return;
                case 17:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    ((TextFieldProps) obj).onValueChangeSync = (WorkletCallback) obj2;
                    return;
                case 18:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                    ((TextFieldProps) obj).modifiers = (List) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public TextFieldProps() {
        this(null, null, null, false, null, false, false, false, false, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextFieldProps copy$default(TextFieldProps textFieldProps, ObservableState observableState, ObservableState observableState2, Integer num, boolean z, TextFieldVariant textFieldVariant, boolean z2, boolean z3, boolean z4, boolean z5, Integer num2, Integer num3, TextFieldTextStyleRecord textFieldTextStyleRecord, String str, TextFieldKeyboardOptionsRecord textFieldKeyboardOptionsRecord, ShapeRecord shapeRecord, TextFieldColorsRecord textFieldColorsRecord, TextFieldSelectionColorsRecord textFieldSelectionColorsRecord, WorkletCallback workletCallback, List list, int i, Object obj) {
        List list2;
        WorkletCallback workletCallback2;
        ObservableState observableState3 = (i & 1) != 0 ? textFieldProps.value : observableState;
        ObservableState observableState4 = (i & 2) != 0 ? textFieldProps.selection : observableState2;
        Integer num4 = (i & 4) != 0 ? textFieldProps.maxLength : num;
        boolean z6 = (i & 8) != 0 ? textFieldProps.autoFocus : z;
        TextFieldVariant textFieldVariant2 = (i & 16) != 0 ? textFieldProps.variant : textFieldVariant;
        boolean z7 = (i & 32) != 0 ? textFieldProps.enabled : z2;
        boolean z8 = (i & 64) != 0 ? textFieldProps.readOnly : z3;
        boolean z9 = (i & 128) != 0 ? textFieldProps.isError : z4;
        boolean z10 = (i & 256) != 0 ? textFieldProps.singleLine : z5;
        Integer num5 = (i & 512) != 0 ? textFieldProps.maxLines : num2;
        Integer num6 = (i & 1024) != 0 ? textFieldProps.minLines : num3;
        TextFieldTextStyleRecord textFieldTextStyleRecord2 = (i & 2048) != 0 ? textFieldProps.textStyle : textFieldTextStyleRecord;
        String str2 = (i & 4096) != 0 ? textFieldProps.visualTransformation : str;
        TextFieldKeyboardOptionsRecord textFieldKeyboardOptionsRecord2 = (i & 8192) != 0 ? textFieldProps.keyboardOptions : textFieldKeyboardOptionsRecord;
        ObservableState observableState5 = observableState3;
        ShapeRecord shapeRecord2 = (i & 16384) != 0 ? textFieldProps.shape : shapeRecord;
        TextFieldColorsRecord textFieldColorsRecord2 = (i & 32768) != 0 ? textFieldProps.colors : textFieldColorsRecord;
        TextFieldSelectionColorsRecord textFieldSelectionColorsRecord2 = (i & 65536) != 0 ? textFieldProps.textSelectionColors : textFieldSelectionColorsRecord;
        WorkletCallback workletCallback3 = (i & 131072) != 0 ? textFieldProps.onValueChangeSync : workletCallback;
        if ((i & 262144) != 0) {
            workletCallback2 = workletCallback3;
            list2 = textFieldProps.modifiers;
        } else {
            list2 = list;
            workletCallback2 = workletCallback3;
        }
        return textFieldProps.copy(observableState5, observableState4, num4, z6, textFieldVariant2, z7, z8, z9, z10, num5, num6, textFieldTextStyleRecord2, str2, textFieldKeyboardOptionsRecord2, shapeRecord2, textFieldColorsRecord2, textFieldSelectionColorsRecord2, workletCallback2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ObservableState getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getMaxLines() {
        return this.maxLines;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Integer getMinLines() {
        return this.minLines;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final TextFieldTextStyleRecord getTextStyle() {
        return this.textStyle;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getVisualTransformation() {
        return this.visualTransformation;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final TextFieldKeyboardOptionsRecord getKeyboardOptions() {
        return this.keyboardOptions;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final ShapeRecord getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final TextFieldColorsRecord getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final TextFieldSelectionColorsRecord getTextSelectionColors() {
        return this.textSelectionColors;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final WorkletCallback getOnValueChangeSync() {
        return this.onValueChangeSync;
    }

    public final List<Map<String, Dynamic>> component19() {
        return this.modifiers;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ObservableState getSelection() {
        return this.selection;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getMaxLength() {
        return this.maxLength;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getAutoFocus() {
        return this.autoFocus;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final TextFieldVariant getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getReadOnly() {
        return this.readOnly;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsError() {
        return this.isError;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final TextFieldProps copy(ObservableState value, ObservableState selection, Integer maxLength, boolean autoFocus, TextFieldVariant variant, boolean enabled, boolean readOnly, boolean isError, boolean singleLine, Integer maxLines, Integer minLines, TextFieldTextStyleRecord textStyle, String visualTransformation, TextFieldKeyboardOptionsRecord keyboardOptions, ShapeRecord shape, TextFieldColorsRecord colors, TextFieldSelectionColorsRecord textSelectionColors, WorkletCallback onValueChangeSync, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new TextFieldProps(value, selection, maxLength, autoFocus, variant, enabled, readOnly, isError, singleLine, maxLines, minLines, textStyle, visualTransformation, keyboardOptions, shape, colors, textSelectionColors, onValueChangeSync, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextFieldProps)) {
            return false;
        }
        TextFieldProps textFieldProps = (TextFieldProps) other;
        return Intrinsics.areEqual(this.value, textFieldProps.value) && Intrinsics.areEqual(this.selection, textFieldProps.selection) && Intrinsics.areEqual(this.maxLength, textFieldProps.maxLength) && this.autoFocus == textFieldProps.autoFocus && this.variant == textFieldProps.variant && this.enabled == textFieldProps.enabled && this.readOnly == textFieldProps.readOnly && this.isError == textFieldProps.isError && this.singleLine == textFieldProps.singleLine && Intrinsics.areEqual(this.maxLines, textFieldProps.maxLines) && Intrinsics.areEqual(this.minLines, textFieldProps.minLines) && Intrinsics.areEqual(this.textStyle, textFieldProps.textStyle) && Intrinsics.areEqual(this.visualTransformation, textFieldProps.visualTransformation) && Intrinsics.areEqual(this.keyboardOptions, textFieldProps.keyboardOptions) && Intrinsics.areEqual(this.shape, textFieldProps.shape) && Intrinsics.areEqual(this.colors, textFieldProps.colors) && Intrinsics.areEqual(this.textSelectionColors, textFieldProps.textSelectionColors) && Intrinsics.areEqual(this.onValueChangeSync, textFieldProps.onValueChangeSync) && Intrinsics.areEqual(this.modifiers, textFieldProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = ((this.value.hashCode() * 31) + this.selection.hashCode()) * 31;
        Integer num = this.maxLength;
        int iHashCode2 = (((((((((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.autoFocus)) * 31) + this.variant.hashCode()) * 31) + Boolean.hashCode(this.enabled)) * 31) + Boolean.hashCode(this.readOnly)) * 31) + Boolean.hashCode(this.isError)) * 31) + Boolean.hashCode(this.singleLine)) * 31;
        Integer num2 = this.maxLines;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.minLines;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        TextFieldTextStyleRecord textFieldTextStyleRecord = this.textStyle;
        int iHashCode5 = (iHashCode4 + (textFieldTextStyleRecord == null ? 0 : textFieldTextStyleRecord.hashCode())) * 31;
        String str = this.visualTransformation;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        TextFieldKeyboardOptionsRecord textFieldKeyboardOptionsRecord = this.keyboardOptions;
        int iHashCode7 = (iHashCode6 + (textFieldKeyboardOptionsRecord == null ? 0 : textFieldKeyboardOptionsRecord.hashCode())) * 31;
        ShapeRecord shapeRecord = this.shape;
        int iHashCode8 = (iHashCode7 + (shapeRecord == null ? 0 : shapeRecord.hashCode())) * 31;
        TextFieldColorsRecord textFieldColorsRecord = this.colors;
        int iHashCode9 = (iHashCode8 + (textFieldColorsRecord == null ? 0 : textFieldColorsRecord.hashCode())) * 31;
        TextFieldSelectionColorsRecord textFieldSelectionColorsRecord = this.textSelectionColors;
        int iHashCode10 = (iHashCode9 + (textFieldSelectionColorsRecord == null ? 0 : textFieldSelectionColorsRecord.hashCode())) * 31;
        WorkletCallback workletCallback = this.onValueChangeSync;
        return ((iHashCode10 + (workletCallback != null ? workletCallback.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "TextFieldProps(value=" + this.value + ", selection=" + this.selection + ", maxLength=" + this.maxLength + ", autoFocus=" + this.autoFocus + ", variant=" + this.variant + ", enabled=" + this.enabled + ", readOnly=" + this.readOnly + ", isError=" + this.isError + ", singleLine=" + this.singleLine + ", maxLines=" + this.maxLines + ", minLines=" + this.minLines + ", textStyle=" + this.textStyle + ", visualTransformation=" + this.visualTransformation + ", keyboardOptions=" + this.keyboardOptions + ", shape=" + this.shape + ", colors=" + this.colors + ", textSelectionColors=" + this.textSelectionColors + ", onValueChangeSync=" + this.onValueChangeSync + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextFieldProps(ObservableState value, ObservableState selection, Integer num, boolean z, TextFieldVariant variant, boolean z2, boolean z3, boolean z4, boolean z5, Integer num2, Integer num3, TextFieldTextStyleRecord textFieldTextStyleRecord, String str, TextFieldKeyboardOptionsRecord textFieldKeyboardOptionsRecord, ShapeRecord shapeRecord, TextFieldColorsRecord textFieldColorsRecord, TextFieldSelectionColorsRecord textFieldSelectionColorsRecord, WorkletCallback workletCallback, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.value = value;
        this.selection = selection;
        this.maxLength = num;
        this.autoFocus = z;
        this.variant = variant;
        this.enabled = z2;
        this.readOnly = z3;
        this.isError = z4;
        this.singleLine = z5;
        this.maxLines = num2;
        this.minLines = num3;
        this.textStyle = textFieldTextStyleRecord;
        this.visualTransformation = str;
        this.keyboardOptions = textFieldKeyboardOptionsRecord;
        this.shape = shapeRecord;
        this.colors = textFieldColorsRecord;
        this.textSelectionColors = textFieldSelectionColorsRecord;
        this.onValueChangeSync = workletCallback;
        this.modifiers = modifiers;
    }

    public /* synthetic */ TextFieldProps(ObservableState observableState, ObservableState observableState2, Integer num, boolean z, TextFieldVariant textFieldVariant, boolean z2, boolean z3, boolean z4, boolean z5, Integer num2, Integer num3, TextFieldTextStyleRecord textFieldTextStyleRecord, String str, TextFieldKeyboardOptionsRecord textFieldKeyboardOptionsRecord, ShapeRecord shapeRecord, TextFieldColorsRecord textFieldColorsRecord, TextFieldSelectionColorsRecord textFieldSelectionColorsRecord, WorkletCallback workletCallback, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ObservableState("") : observableState, (i & 2) != 0 ? new ObservableState(MapsKt.mapOf(TuplesKt.to(ViewProps.START, 0), TuplesKt.to(ViewProps.END, 0))) : observableState2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? false : z, (i & 16) != 0 ? TextFieldVariant.FILLED : textFieldVariant, (i & 32) == 0 ? z2 : true, (i & 64) != 0 ? false : z3, (i & 128) != 0 ? false : z4, (i & 256) == 0 ? z5 : false, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : num3, (i & 2048) != 0 ? null : textFieldTextStyleRecord, (i & 4096) != 0 ? null : str, (i & 8192) != 0 ? null : textFieldKeyboardOptionsRecord, (i & 16384) != 0 ? null : shapeRecord, (i & 32768) != 0 ? null : textFieldColorsRecord, (i & 65536) != 0 ? null : textFieldSelectionColorsRecord, (i & 131072) != 0 ? null : workletCallback, (i & 262144) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final ObservableState getValue() {
        return this.value;
    }

    public final ObservableState getSelection() {
        return this.selection;
    }

    public final Integer getMaxLength() {
        return this.maxLength;
    }

    public final boolean getAutoFocus() {
        return this.autoFocus;
    }

    public final TextFieldVariant getVariant() {
        return this.variant;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final boolean isError() {
        return this.isError;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final Integer getMaxLines() {
        return this.maxLines;
    }

    public final Integer getMinLines() {
        return this.minLines;
    }

    public final TextFieldTextStyleRecord getTextStyle() {
        return this.textStyle;
    }

    public final String getVisualTransformation() {
        return this.visualTransformation;
    }

    public final TextFieldKeyboardOptionsRecord getKeyboardOptions() {
        return this.keyboardOptions;
    }

    public final ShapeRecord getShape() {
        return this.shape;
    }

    public final TextFieldColorsRecord getColors() {
        return this.colors;
    }

    public final TextFieldSelectionColorsRecord getTextSelectionColors() {
        return this.textSelectionColors;
    }

    public final WorkletCallback getOnValueChangeSync() {
        return this.onValueChangeSync;
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
