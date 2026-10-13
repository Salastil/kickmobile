package expo.modules.font;

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

/* JADX INFO: compiled from: FontLoaderRecords.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001!B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J0\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\f\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0016J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lexpo/modules/font/FontFaceRecord;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "localUri", "", "weight", "", "style", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getLocalUri$annotations", "()V", "getLocalUri", "()Ljava/lang/String;", "getWeight$annotations", "getWeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStyle$annotations", "getStyle", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lexpo/modules/font/FontFaceRecord;", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "toString", "__Pika", "expo-font_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FontFaceRecord implements Record, PIntrospectionProvider {
    public String localUri;
    public String style;
    public Integer weight;

    /* JADX INFO: compiled from: FontLoaderRecords.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/font/FontFaceRecord$__Pika;", "", "<init>", "()V", "expo-font_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<FontFaceRecord> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(FontFaceRecord.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("localUri", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING, 0, __pika, false, true, false), new PProperty("weight", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.INT_NULLABLE, 1, __pika, false, true, false), new PProperty("style", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 2, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.font.FontFaceRecord");
                return ((FontFaceRecord) obj).getLocalUri();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.font.FontFaceRecord");
                return ((FontFaceRecord) obj).getWeight();
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.font.FontFaceRecord");
            return ((FontFaceRecord) obj).getStyle();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.font.FontFaceRecord");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                ((FontFaceRecord) obj).localUri = (String) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.font.FontFaceRecord");
                ((FontFaceRecord) obj).weight = (Integer) obj2;
            } else {
                if (i != 2) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.font.FontFaceRecord");
                ((FontFaceRecord) obj).style = (String) obj2;
            }
        }
    }

    public FontFaceRecord() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ FontFaceRecord copy$default(FontFaceRecord fontFaceRecord, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fontFaceRecord.localUri;
        }
        if ((i & 2) != 0) {
            num = fontFaceRecord.weight;
        }
        if ((i & 4) != 0) {
            str2 = fontFaceRecord.style;
        }
        return fontFaceRecord.copy(str, num, str2);
    }

    @Field
    public static /* synthetic */ void getLocalUri$annotations() {
    }

    @Field
    public static /* synthetic */ void getStyle$annotations() {
    }

    @Field
    public static /* synthetic */ void getWeight$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLocalUri() {
        return this.localUri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getWeight() {
        return this.weight;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStyle() {
        return this.style;
    }

    public final FontFaceRecord copy(String localUri, Integer weight, String style) {
        Intrinsics.checkNotNullParameter(localUri, "localUri");
        return new FontFaceRecord(localUri, weight, style);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FontFaceRecord)) {
            return false;
        }
        FontFaceRecord fontFaceRecord = (FontFaceRecord) other;
        return Intrinsics.areEqual(this.localUri, fontFaceRecord.localUri) && Intrinsics.areEqual(this.weight, fontFaceRecord.weight) && Intrinsics.areEqual(this.style, fontFaceRecord.style);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = this.localUri.hashCode() * 31;
        Integer num = this.weight;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.style;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "FontFaceRecord(localUri=" + this.localUri + ", weight=" + this.weight + ", style=" + this.style + ")";
    }

    public FontFaceRecord(String localUri, Integer num, String str) {
        Intrinsics.checkNotNullParameter(localUri, "localUri");
        this.localUri = localUri;
        this.weight = num;
        this.style = str;
    }

    public final String getLocalUri() {
        return this.localUri;
    }

    public /* synthetic */ FontFaceRecord(String str, Integer num, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2);
    }

    public final Integer getWeight() {
        return this.weight;
    }

    public final String getStyle() {
        return this.style;
    }
}
