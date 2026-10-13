package expo.modules.ui.textfield;

import android.graphics.Color;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.OptimizedComposeProps;
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

/* JADX INFO: compiled from: BasicTextField.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001WBÓ\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\"\b\u0002\u0010\u001b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\u0002`\u001f0\u001cj\u0002` ¢\u0006\u0004\b!\u0010\"J\t\u0010>\u001a\u00020\u0004HÆ\u0003J\t\u0010?\u001a\u00020\u0004HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010'J\t\u0010A\u001a\u00020\tHÆ\u0003J\t\u0010B\u001a\u00020\tHÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\t\u0010D\u001a\u00020\tHÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010F\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010G\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u001aHÆ\u0003J#\u0010M\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\u0002`\u001f0\u001cj\u0002` HÆ\u0003JÚ\u0001\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\"\b\u0002\u0010\u001b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\u0002`\u001f0\u001cj\u0002` HÆ\u0001¢\u0006\u0002\u0010OJ\u0013\u0010P\u001a\u00020\t2\b\u0010Q\u001a\u0004\u0018\u00010RHÖ\u0003J\f\u0010S\u001a\u0006\u0012\u0002\b\u00030TH\u0016J\t\u0010U\u001a\u00020\u0007HÖ\u0001J\t\u0010V\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010(\u001a\u0004\b.\u0010'R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010(\u001a\u0004\b/\u0010'R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R+\u0010\u001b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\u0002`\u001f0\u001cj\u0002` ¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=¨\u0006X"}, d2 = {"Lexpo/modules/ui/textfield/BasicTextFieldProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "value", "Lexpo/modules/ui/state/ObservableState;", "selection", "maxLength", "", "autoFocus", "", "enabled", "readOnly", "singleLine", "maxLines", "minLines", "textStyle", "Lexpo/modules/ui/textfield/TextFieldTextStyleRecord;", "visualTransformation", "", "keyboardOptions", "Lexpo/modules/ui/textfield/TextFieldKeyboardOptionsRecord;", "cursorColor", "Landroid/graphics/Color;", "textSelectionColors", "Lexpo/modules/ui/textfield/TextFieldSelectionColorsRecord;", "onValueChangeSync", "Lexpo/modules/ui/state/WorkletCallback;", "modifiers", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Lexpo/modules/ui/state/ObservableState;Lexpo/modules/ui/state/ObservableState;Ljava/lang/Integer;ZZZZLjava/lang/Integer;Ljava/lang/Integer;Lexpo/modules/ui/textfield/TextFieldTextStyleRecord;Ljava/lang/String;Lexpo/modules/ui/textfield/TextFieldKeyboardOptionsRecord;Landroid/graphics/Color;Lexpo/modules/ui/textfield/TextFieldSelectionColorsRecord;Lexpo/modules/ui/state/WorkletCallback;Ljava/util/List;)V", "getValue", "()Lexpo/modules/ui/state/ObservableState;", "getSelection", "getMaxLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAutoFocus", "()Z", "getEnabled", "getReadOnly", "getSingleLine", "getMaxLines", "getMinLines", "getTextStyle", "()Lexpo/modules/ui/textfield/TextFieldTextStyleRecord;", "getVisualTransformation", "()Ljava/lang/String;", "getKeyboardOptions", "()Lexpo/modules/ui/textfield/TextFieldKeyboardOptionsRecord;", "getCursorColor", "()Landroid/graphics/Color;", "getTextSelectionColors", "()Lexpo/modules/ui/textfield/TextFieldSelectionColorsRecord;", "getOnValueChangeSync", "()Lexpo/modules/ui/state/WorkletCallback;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Lexpo/modules/ui/state/ObservableState;Lexpo/modules/ui/state/ObservableState;Ljava/lang/Integer;ZZZZLjava/lang/Integer;Ljava/lang/Integer;Lexpo/modules/ui/textfield/TextFieldTextStyleRecord;Ljava/lang/String;Lexpo/modules/ui/textfield/TextFieldKeyboardOptionsRecord;Landroid/graphics/Color;Lexpo/modules/ui/textfield/TextFieldSelectionColorsRecord;Lexpo/modules/ui/state/WorkletCallback;Ljava/util/List;)Lexpo/modules/ui/textfield/BasicTextFieldProps;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BasicTextFieldProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public boolean autoFocus;
    public Color cursorColor;
    public boolean enabled;
    public TextFieldKeyboardOptionsRecord keyboardOptions;
    public Integer maxLength;
    public Integer maxLines;
    public Integer minLines;
    public List<Map<String, Dynamic>> modifiers;
    public WorkletCallback onValueChangeSync;
    public boolean readOnly;
    public ObservableState selection;
    public boolean singleLine;
    public TextFieldSelectionColorsRecord textSelectionColors;
    public TextFieldTextStyleRecord textStyle;
    public ObservableState value;
    public String visualTransformation;

    /* JADX INFO: compiled from: BasicTextField.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/textfield/BasicTextFieldProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<BasicTextFieldProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(BasicTextFieldProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("value", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ObservableState.class, false, null), 0, __pika, false, true, false), new PProperty("selection", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ObservableState.class, false, null), 1, __pika, false, true, false), new PProperty("maxLength", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.INT_NULLABLE, 2, __pika, false, true, false), new PProperty("autoFocus", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 3, __pika, false, true, false), new PProperty("enabled", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 4, __pika, false, true, false), new PProperty("readOnly", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 5, __pika, false, true, false), new PProperty("singleLine", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 6, __pika, false, true, false), new PProperty("maxLines", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.INT_NULLABLE, 7, __pika, false, true, false), new PProperty("minLines", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.INT_NULLABLE, 8, __pika, false, true, false), new PProperty("textStyle", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(TextFieldTextStyleRecord.class, true, null), 9, __pika, false, true, false), new PProperty("visualTransformation", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.STRING_NULLABLE, 10, __pika, false, true, false), new PProperty("keyboardOptions", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(TextFieldKeyboardOptionsRecord.class, true, null), 11, __pika, false, true, false), new PProperty("cursorColor", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 12, __pika, false, true, false), new PProperty("textSelectionColors", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(TextFieldSelectionColorsRecord.class, true, null), 13, __pika, false, true, false), new PProperty("onValueChangeSync", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(WorkletCallback.class, true, null), 14, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 15, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("component8", PVisibility.PUBLIC), new PFunction("component9", PVisibility.PUBLIC), new PFunction("component10", PVisibility.PUBLIC), new PFunction("component11", PVisibility.PUBLIC), new PFunction("component12", PVisibility.PUBLIC), new PFunction("component13", PVisibility.PUBLIC), new PFunction("component14", PVisibility.PUBLIC), new PFunction("component15", PVisibility.PUBLIC), new PFunction("component16", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return ((BasicTextFieldProps) obj).getValue();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return ((BasicTextFieldProps) obj).getSelection();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return ((BasicTextFieldProps) obj).getMaxLength();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return Boolean.valueOf(((BasicTextFieldProps) obj).getAutoFocus());
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return Boolean.valueOf(((BasicTextFieldProps) obj).getEnabled());
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return Boolean.valueOf(((BasicTextFieldProps) obj).getReadOnly());
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return Boolean.valueOf(((BasicTextFieldProps) obj).getSingleLine());
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return ((BasicTextFieldProps) obj).getMaxLines();
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return ((BasicTextFieldProps) obj).getMinLines();
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return ((BasicTextFieldProps) obj).getTextStyle();
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return ((BasicTextFieldProps) obj).getVisualTransformation();
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return ((BasicTextFieldProps) obj).getKeyboardOptions();
                case 12:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return ((BasicTextFieldProps) obj).getCursorColor();
                case 13:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return ((BasicTextFieldProps) obj).getTextSelectionColors();
                case 14:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return ((BasicTextFieldProps) obj).getOnValueChangeSync();
                case 15:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    return ((BasicTextFieldProps) obj).getModifiers();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.state.ObservableState");
                    ((BasicTextFieldProps) obj).value = (ObservableState) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.state.ObservableState");
                    ((BasicTextFieldProps) obj).selection = (ObservableState) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    ((BasicTextFieldProps) obj).maxLength = (Integer) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((BasicTextFieldProps) obj).autoFocus = ((Boolean) obj2).booleanValue();
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((BasicTextFieldProps) obj).enabled = ((Boolean) obj2).booleanValue();
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((BasicTextFieldProps) obj).readOnly = ((Boolean) obj2).booleanValue();
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((BasicTextFieldProps) obj).singleLine = ((Boolean) obj2).booleanValue();
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    ((BasicTextFieldProps) obj).maxLines = (Integer) obj2;
                    return;
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    ((BasicTextFieldProps) obj).minLines = (Integer) obj2;
                    return;
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    ((BasicTextFieldProps) obj).textStyle = (TextFieldTextStyleRecord) obj2;
                    return;
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    ((BasicTextFieldProps) obj).visualTransformation = (String) obj2;
                    return;
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    ((BasicTextFieldProps) obj).keyboardOptions = (TextFieldKeyboardOptionsRecord) obj2;
                    return;
                case 12:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    ((BasicTextFieldProps) obj).cursorColor = (Color) obj2;
                    return;
                case 13:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    ((BasicTextFieldProps) obj).textSelectionColors = (TextFieldSelectionColorsRecord) obj2;
                    return;
                case 14:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    ((BasicTextFieldProps) obj).onValueChangeSync = (WorkletCallback) obj2;
                    return;
                case 15:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.BasicTextFieldProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                    ((BasicTextFieldProps) obj).modifiers = (List) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public BasicTextFieldProps() {
        this(null, null, null, false, false, false, false, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BasicTextFieldProps copy$default(BasicTextFieldProps basicTextFieldProps, ObservableState observableState, ObservableState observableState2, Integer num, boolean z, boolean z2, boolean z3, boolean z4, Integer num2, Integer num3, TextFieldTextStyleRecord textFieldTextStyleRecord, String str, TextFieldKeyboardOptionsRecord textFieldKeyboardOptionsRecord, Color color, TextFieldSelectionColorsRecord textFieldSelectionColorsRecord, WorkletCallback workletCallback, List list, int i, Object obj) {
        ObservableState observableState3 = (i & 1) != 0 ? basicTextFieldProps.value : observableState;
        return basicTextFieldProps.copy(observableState3, (i & 2) != 0 ? basicTextFieldProps.selection : observableState2, (i & 4) != 0 ? basicTextFieldProps.maxLength : num, (i & 8) != 0 ? basicTextFieldProps.autoFocus : z, (i & 16) != 0 ? basicTextFieldProps.enabled : z2, (i & 32) != 0 ? basicTextFieldProps.readOnly : z3, (i & 64) != 0 ? basicTextFieldProps.singleLine : z4, (i & 128) != 0 ? basicTextFieldProps.maxLines : num2, (i & 256) != 0 ? basicTextFieldProps.minLines : num3, (i & 512) != 0 ? basicTextFieldProps.textStyle : textFieldTextStyleRecord, (i & 1024) != 0 ? basicTextFieldProps.visualTransformation : str, (i & 2048) != 0 ? basicTextFieldProps.keyboardOptions : textFieldKeyboardOptionsRecord, (i & 4096) != 0 ? basicTextFieldProps.cursorColor : color, (i & 8192) != 0 ? basicTextFieldProps.textSelectionColors : textFieldSelectionColorsRecord, (i & 16384) != 0 ? basicTextFieldProps.onValueChangeSync : workletCallback, (i & 32768) != 0 ? basicTextFieldProps.modifiers : list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ObservableState getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final TextFieldTextStyleRecord getTextStyle() {
        return this.textStyle;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getVisualTransformation() {
        return this.visualTransformation;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final TextFieldKeyboardOptionsRecord getKeyboardOptions() {
        return this.keyboardOptions;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Color getCursorColor() {
        return this.cursorColor;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final TextFieldSelectionColorsRecord getTextSelectionColors() {
        return this.textSelectionColors;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final WorkletCallback getOnValueChangeSync() {
        return this.onValueChangeSync;
    }

    public final List<Map<String, Dynamic>> component16() {
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
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getReadOnly() {
        return this.readOnly;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getSingleLine() {
        return this.singleLine;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getMaxLines() {
        return this.maxLines;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getMinLines() {
        return this.minLines;
    }

    public final BasicTextFieldProps copy(ObservableState value, ObservableState selection, Integer maxLength, boolean autoFocus, boolean enabled, boolean readOnly, boolean singleLine, Integer maxLines, Integer minLines, TextFieldTextStyleRecord textStyle, String visualTransformation, TextFieldKeyboardOptionsRecord keyboardOptions, Color cursorColor, TextFieldSelectionColorsRecord textSelectionColors, WorkletCallback onValueChangeSync, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new BasicTextFieldProps(value, selection, maxLength, autoFocus, enabled, readOnly, singleLine, maxLines, minLines, textStyle, visualTransformation, keyboardOptions, cursorColor, textSelectionColors, onValueChangeSync, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BasicTextFieldProps)) {
            return false;
        }
        BasicTextFieldProps basicTextFieldProps = (BasicTextFieldProps) other;
        return Intrinsics.areEqual(this.value, basicTextFieldProps.value) && Intrinsics.areEqual(this.selection, basicTextFieldProps.selection) && Intrinsics.areEqual(this.maxLength, basicTextFieldProps.maxLength) && this.autoFocus == basicTextFieldProps.autoFocus && this.enabled == basicTextFieldProps.enabled && this.readOnly == basicTextFieldProps.readOnly && this.singleLine == basicTextFieldProps.singleLine && Intrinsics.areEqual(this.maxLines, basicTextFieldProps.maxLines) && Intrinsics.areEqual(this.minLines, basicTextFieldProps.minLines) && Intrinsics.areEqual(this.textStyle, basicTextFieldProps.textStyle) && Intrinsics.areEqual(this.visualTransformation, basicTextFieldProps.visualTransformation) && Intrinsics.areEqual(this.keyboardOptions, basicTextFieldProps.keyboardOptions) && Intrinsics.areEqual(this.cursorColor, basicTextFieldProps.cursorColor) && Intrinsics.areEqual(this.textSelectionColors, basicTextFieldProps.textSelectionColors) && Intrinsics.areEqual(this.onValueChangeSync, basicTextFieldProps.onValueChangeSync) && Intrinsics.areEqual(this.modifiers, basicTextFieldProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = ((this.value.hashCode() * 31) + this.selection.hashCode()) * 31;
        Integer num = this.maxLength;
        int iHashCode2 = (((((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.autoFocus)) * 31) + Boolean.hashCode(this.enabled)) * 31) + Boolean.hashCode(this.readOnly)) * 31) + Boolean.hashCode(this.singleLine)) * 31;
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
        Color color = this.cursorColor;
        int iHashCode8 = (iHashCode7 + (color == null ? 0 : color.hashCode())) * 31;
        TextFieldSelectionColorsRecord textFieldSelectionColorsRecord = this.textSelectionColors;
        int iHashCode9 = (iHashCode8 + (textFieldSelectionColorsRecord == null ? 0 : textFieldSelectionColorsRecord.hashCode())) * 31;
        WorkletCallback workletCallback = this.onValueChangeSync;
        return ((iHashCode9 + (workletCallback != null ? workletCallback.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "BasicTextFieldProps(value=" + this.value + ", selection=" + this.selection + ", maxLength=" + this.maxLength + ", autoFocus=" + this.autoFocus + ", enabled=" + this.enabled + ", readOnly=" + this.readOnly + ", singleLine=" + this.singleLine + ", maxLines=" + this.maxLines + ", minLines=" + this.minLines + ", textStyle=" + this.textStyle + ", visualTransformation=" + this.visualTransformation + ", keyboardOptions=" + this.keyboardOptions + ", cursorColor=" + this.cursorColor + ", textSelectionColors=" + this.textSelectionColors + ", onValueChangeSync=" + this.onValueChangeSync + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BasicTextFieldProps(ObservableState value, ObservableState selection, Integer num, boolean z, boolean z2, boolean z3, boolean z4, Integer num2, Integer num3, TextFieldTextStyleRecord textFieldTextStyleRecord, String str, TextFieldKeyboardOptionsRecord textFieldKeyboardOptionsRecord, Color color, TextFieldSelectionColorsRecord textFieldSelectionColorsRecord, WorkletCallback workletCallback, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.value = value;
        this.selection = selection;
        this.maxLength = num;
        this.autoFocus = z;
        this.enabled = z2;
        this.readOnly = z3;
        this.singleLine = z4;
        this.maxLines = num2;
        this.minLines = num3;
        this.textStyle = textFieldTextStyleRecord;
        this.visualTransformation = str;
        this.keyboardOptions = textFieldKeyboardOptionsRecord;
        this.cursorColor = color;
        this.textSelectionColors = textFieldSelectionColorsRecord;
        this.onValueChangeSync = workletCallback;
        this.modifiers = modifiers;
    }

    public /* synthetic */ BasicTextFieldProps(ObservableState observableState, ObservableState observableState2, Integer num, boolean z, boolean z2, boolean z3, boolean z4, Integer num2, Integer num3, TextFieldTextStyleRecord textFieldTextStyleRecord, String str, TextFieldKeyboardOptionsRecord textFieldKeyboardOptionsRecord, Color color, TextFieldSelectionColorsRecord textFieldSelectionColorsRecord, WorkletCallback workletCallback, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ObservableState("") : observableState, (i & 2) != 0 ? new ObservableState(MapsKt.mapOf(TuplesKt.to(ViewProps.START, 0), TuplesKt.to(ViewProps.END, 0))) : observableState2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? false : z, (i & 16) == 0 ? z2 : true, (i & 32) != 0 ? false : z3, (i & 64) == 0 ? z4 : false, (i & 128) != 0 ? null : num2, (i & 256) != 0 ? null : num3, (i & 512) != 0 ? null : textFieldTextStyleRecord, (i & 1024) != 0 ? null : str, (i & 2048) != 0 ? null : textFieldKeyboardOptionsRecord, (i & 4096) != 0 ? null : color, (i & 8192) != 0 ? null : textFieldSelectionColorsRecord, (i & 16384) != 0 ? null : workletCallback, (i & 32768) != 0 ? CollectionsKt.emptyList() : list);
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

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
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

    public final Color getCursorColor() {
        return this.cursorColor;
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
