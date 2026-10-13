package expo.modules.ui.textfield;

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

/* JADX INFO: compiled from: TextFieldShared.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\f\u0010 \u001a\u0006\u0012\u0002\b\u00030!H\u0016J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e¨\u0006&"}, d2 = {"Lexpo/modules/ui/textfield/TextFieldKeyboardOptionsRecord;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "capitalization", "", "autoCorrectEnabled", "", "keyboardType", "imeAction", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getCapitalization$annotations", "()V", "getCapitalization", "()Ljava/lang/String;", "getAutoCorrectEnabled$annotations", "getAutoCorrectEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getKeyboardType$annotations", "getKeyboardType", "getImeAction$annotations", "getImeAction", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lexpo/modules/ui/textfield/TextFieldKeyboardOptionsRecord;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TextFieldKeyboardOptionsRecord implements Record, PIntrospectionProvider {
    public static final int $stable = 0;
    public Boolean autoCorrectEnabled;
    public String capitalization;
    public String imeAction;
    public String keyboardType;

    /* JADX INFO: compiled from: TextFieldShared.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/textfield/TextFieldKeyboardOptionsRecord$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<TextFieldKeyboardOptionsRecord> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(TextFieldKeyboardOptionsRecord.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("capitalization", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 0, __pika, false, true, false), new PProperty("autoCorrectEnabled", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN_NULLABLE, 1, __pika, false, true, false), new PProperty("keyboardType", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 2, __pika, false, true, false), new PProperty("imeAction", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 3, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldKeyboardOptionsRecord");
                return ((TextFieldKeyboardOptionsRecord) obj).getCapitalization();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldKeyboardOptionsRecord");
                return ((TextFieldKeyboardOptionsRecord) obj).getAutoCorrectEnabled();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldKeyboardOptionsRecord");
                return ((TextFieldKeyboardOptionsRecord) obj).getKeyboardType();
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldKeyboardOptionsRecord");
            return ((TextFieldKeyboardOptionsRecord) obj).getImeAction();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldKeyboardOptionsRecord");
                ((TextFieldKeyboardOptionsRecord) obj).capitalization = (String) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldKeyboardOptionsRecord");
                ((TextFieldKeyboardOptionsRecord) obj).autoCorrectEnabled = (Boolean) obj2;
            } else if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldKeyboardOptionsRecord");
                ((TextFieldKeyboardOptionsRecord) obj).keyboardType = (String) obj2;
            } else {
                if (i != 3) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldKeyboardOptionsRecord");
                ((TextFieldKeyboardOptionsRecord) obj).imeAction = (String) obj2;
            }
        }
    }

    public TextFieldKeyboardOptionsRecord() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TextFieldKeyboardOptionsRecord copy$default(TextFieldKeyboardOptionsRecord textFieldKeyboardOptionsRecord, String str, Boolean bool, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textFieldKeyboardOptionsRecord.capitalization;
        }
        if ((i & 2) != 0) {
            bool = textFieldKeyboardOptionsRecord.autoCorrectEnabled;
        }
        if ((i & 4) != 0) {
            str2 = textFieldKeyboardOptionsRecord.keyboardType;
        }
        if ((i & 8) != 0) {
            str3 = textFieldKeyboardOptionsRecord.imeAction;
        }
        return textFieldKeyboardOptionsRecord.copy(str, bool, str2, str3);
    }

    @Field
    public static /* synthetic */ void getAutoCorrectEnabled$annotations() {
    }

    @Field
    public static /* synthetic */ void getCapitalization$annotations() {
    }

    @Field
    public static /* synthetic */ void getImeAction$annotations() {
    }

    @Field
    public static /* synthetic */ void getKeyboardType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCapitalization() {
        return this.capitalization;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getAutoCorrectEnabled() {
        return this.autoCorrectEnabled;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getKeyboardType() {
        return this.keyboardType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getImeAction() {
        return this.imeAction;
    }

    public final TextFieldKeyboardOptionsRecord copy(String capitalization, Boolean autoCorrectEnabled, String keyboardType, String imeAction) {
        return new TextFieldKeyboardOptionsRecord(capitalization, autoCorrectEnabled, keyboardType, imeAction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextFieldKeyboardOptionsRecord)) {
            return false;
        }
        TextFieldKeyboardOptionsRecord textFieldKeyboardOptionsRecord = (TextFieldKeyboardOptionsRecord) other;
        return Intrinsics.areEqual(this.capitalization, textFieldKeyboardOptionsRecord.capitalization) && Intrinsics.areEqual(this.autoCorrectEnabled, textFieldKeyboardOptionsRecord.autoCorrectEnabled) && Intrinsics.areEqual(this.keyboardType, textFieldKeyboardOptionsRecord.keyboardType) && Intrinsics.areEqual(this.imeAction, textFieldKeyboardOptionsRecord.imeAction);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        String str = this.capitalization;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.autoCorrectEnabled;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.keyboardType;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.imeAction;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "TextFieldKeyboardOptionsRecord(capitalization=" + this.capitalization + ", autoCorrectEnabled=" + this.autoCorrectEnabled + ", keyboardType=" + this.keyboardType + ", imeAction=" + this.imeAction + ")";
    }

    public TextFieldKeyboardOptionsRecord(String str, Boolean bool, String str2, String str3) {
        this.capitalization = str;
        this.autoCorrectEnabled = bool;
        this.keyboardType = str2;
        this.imeAction = str3;
    }

    public /* synthetic */ TextFieldKeyboardOptionsRecord(String str, Boolean bool, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }

    public final String getCapitalization() {
        return this.capitalization;
    }

    public final Boolean getAutoCorrectEnabled() {
        return this.autoCorrectEnabled;
    }

    public final String getKeyboardType() {
        return this.keyboardType;
    }

    public final String getImeAction() {
        return this.imeAction;
    }
}
