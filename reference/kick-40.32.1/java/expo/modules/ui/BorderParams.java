package expo.modules.ui;

import android.graphics.Color;
import com.facebook.react.uimanager.ViewProps;
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

/* JADX INFO: compiled from: ModifierRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001cB\u001d\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\f\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lexpo/modules/ui/BorderParams;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", ViewProps.BORDER_WIDTH, "", ViewProps.BORDER_COLOR, "Landroid/graphics/Color;", "<init>", "(ILandroid/graphics/Color;)V", "getBorderWidth$annotations", "()V", "getBorderWidth", "()I", "getBorderColor$annotations", "getBorderColor", "()Landroid/graphics/Color;", "component1", "component2", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BorderParams implements Record, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color borderColor;
    public int borderWidth;

    /* JADX INFO: compiled from: ModifierRegistry.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/BorderParams$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<BorderParams> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(BorderParams.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty(ViewProps.BORDER_WIDTH, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.INT, 0, __pika, false, true, false), new PProperty(ViewProps.BORDER_COLOR, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 1, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BorderParams");
                return Integer.valueOf(((BorderParams) obj).getBorderWidth());
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BorderParams");
            return ((BorderParams) obj).getBorderColor();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BorderParams");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                ((BorderParams) obj).borderWidth = ((Integer) obj2).intValue();
                return;
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BorderParams");
            ((BorderParams) obj).borderColor = (Color) obj2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BorderParams() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BorderParams copy$default(BorderParams borderParams, int i, Color color, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = borderParams.borderWidth;
        }
        if ((i2 & 2) != 0) {
            color = borderParams.borderColor;
        }
        return borderParams.copy(i, color);
    }

    @Field
    public static /* synthetic */ void getBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getBorderWidth$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBorderWidth() {
        return this.borderWidth;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getBorderColor() {
        return this.borderColor;
    }

    public final BorderParams copy(int borderWidth, Color borderColor) {
        return new BorderParams(borderWidth, borderColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BorderParams)) {
            return false;
        }
        BorderParams borderParams = (BorderParams) other;
        return this.borderWidth == borderParams.borderWidth && Intrinsics.areEqual(this.borderColor, borderParams.borderColor);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.borderWidth) * 31;
        Color color = this.borderColor;
        return iHashCode + (color == null ? 0 : color.hashCode());
    }

    public String toString() {
        return "BorderParams(borderWidth=" + this.borderWidth + ", borderColor=" + this.borderColor + ")";
    }

    public BorderParams(int i, Color color) {
        this.borderWidth = i;
        this.borderColor = color;
    }

    public /* synthetic */ BorderParams(int i, Color color, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? null : color);
    }

    public final int getBorderWidth() {
        return this.borderWidth;
    }

    public final Color getBorderColor() {
        return this.borderColor;
    }
}
