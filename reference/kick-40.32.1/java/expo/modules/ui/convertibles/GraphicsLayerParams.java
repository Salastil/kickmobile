package expo.modules.ui.convertibles;

import android.graphics.Color;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import expo.modules.ui.BuiltinShapeRecord;
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

/* JADX INFO: compiled from: GraphicsLayerParams.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001:B_\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0004HÆ\u0003J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000fHÆ\u0003Ja\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u00101\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\f\u00104\u001a\u0006\u0012\u0002\b\u000305H\u0016J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\"R\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010\"R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010'¨\u0006;"}, d2 = {"Lexpo/modules/ui/convertibles/GraphicsLayerParams;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "cameraDistance", "", "transformOriginX", "transformOriginY", "clip", "", "shape", "Lexpo/modules/ui/BuiltinShapeRecord;", "ambientShadowColor", "Landroid/graphics/Color;", "spotShadowColor", "compositingStrategy", "Lexpo/modules/ui/convertibles/CompositingStrategyType;", "<init>", "(FFFZLexpo/modules/ui/BuiltinShapeRecord;Landroid/graphics/Color;Landroid/graphics/Color;Lexpo/modules/ui/convertibles/CompositingStrategyType;)V", "getCameraDistance$annotations", "()V", "getCameraDistance", "()F", "getTransformOriginX$annotations", "getTransformOriginX", "getTransformOriginY$annotations", "getTransformOriginY", "getClip$annotations", "getClip", "()Z", "getShape$annotations", "getShape", "()Lexpo/modules/ui/BuiltinShapeRecord;", "getAmbientShadowColor$annotations", "getAmbientShadowColor", "()Landroid/graphics/Color;", "getSpotShadowColor$annotations", "getSpotShadowColor", "getCompositingStrategy$annotations", "getCompositingStrategy", "()Lexpo/modules/ui/convertibles/CompositingStrategyType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GraphicsLayerParams implements Record, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color ambientShadowColor;
    public float cameraDistance;
    public boolean clip;
    public CompositingStrategyType compositingStrategy;
    public BuiltinShapeRecord shape;
    public Color spotShadowColor;
    public float transformOriginX;
    public float transformOriginY;

    /* JADX INFO: compiled from: GraphicsLayerParams.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/convertibles/GraphicsLayerParams$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<GraphicsLayerParams> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(GraphicsLayerParams.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("cameraDistance", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 0, __pika, false, true, false), new PProperty("transformOriginX", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 1, __pika, false, true, false), new PProperty("transformOriginY", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 2, __pika, false, true, false), new PProperty("clip", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 3, __pika, false, true, false), new PProperty("shape", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(BuiltinShapeRecord.class, true, BuiltinShapeRecord.__Pika.__pika$IntrospectionData), 4, __pika, false, true, false), new PProperty("ambientShadowColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 5, __pika, false, true, false), new PProperty("spotShadowColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 6, __pika, false, true, false), new PProperty("compositingStrategy", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(CompositingStrategyType.class, true, null), 7, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("component8", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    return Float.valueOf(((GraphicsLayerParams) obj).getCameraDistance());
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    return Float.valueOf(((GraphicsLayerParams) obj).getTransformOriginX());
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    return Float.valueOf(((GraphicsLayerParams) obj).getTransformOriginY());
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    return Boolean.valueOf(((GraphicsLayerParams) obj).getClip());
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    return ((GraphicsLayerParams) obj).getShape();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    return ((GraphicsLayerParams) obj).getAmbientShadowColor();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    return ((GraphicsLayerParams) obj).getSpotShadowColor();
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    return ((GraphicsLayerParams) obj).getCompositingStrategy();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((GraphicsLayerParams) obj).cameraDistance = ((Float) obj2).floatValue();
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((GraphicsLayerParams) obj).transformOriginX = ((Float) obj2).floatValue();
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((GraphicsLayerParams) obj).transformOriginY = ((Float) obj2).floatValue();
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((GraphicsLayerParams) obj).clip = ((Boolean) obj2).booleanValue();
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    ((GraphicsLayerParams) obj).shape = (BuiltinShapeRecord) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    ((GraphicsLayerParams) obj).ambientShadowColor = (Color) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    ((GraphicsLayerParams) obj).spotShadowColor = (Color) obj2;
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.GraphicsLayerParams");
                    ((GraphicsLayerParams) obj).compositingStrategy = (CompositingStrategyType) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public GraphicsLayerParams() {
        this(0.0f, 0.0f, 0.0f, false, null, null, null, null, 255, null);
    }

    public static /* synthetic */ GraphicsLayerParams copy$default(GraphicsLayerParams graphicsLayerParams, float f, float f2, float f3, boolean z, BuiltinShapeRecord builtinShapeRecord, Color color, Color color2, CompositingStrategyType compositingStrategyType, int i, Object obj) {
        if ((i & 1) != 0) {
            f = graphicsLayerParams.cameraDistance;
        }
        if ((i & 2) != 0) {
            f2 = graphicsLayerParams.transformOriginX;
        }
        if ((i & 4) != 0) {
            f3 = graphicsLayerParams.transformOriginY;
        }
        if ((i & 8) != 0) {
            z = graphicsLayerParams.clip;
        }
        if ((i & 16) != 0) {
            builtinShapeRecord = graphicsLayerParams.shape;
        }
        if ((i & 32) != 0) {
            color = graphicsLayerParams.ambientShadowColor;
        }
        if ((i & 64) != 0) {
            color2 = graphicsLayerParams.spotShadowColor;
        }
        if ((i & 128) != 0) {
            compositingStrategyType = graphicsLayerParams.compositingStrategy;
        }
        Color color3 = color2;
        CompositingStrategyType compositingStrategyType2 = compositingStrategyType;
        BuiltinShapeRecord builtinShapeRecord2 = builtinShapeRecord;
        Color color4 = color;
        return graphicsLayerParams.copy(f, f2, f3, z, builtinShapeRecord2, color4, color3, compositingStrategyType2);
    }

    @Field
    public static /* synthetic */ void getAmbientShadowColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getCameraDistance$annotations() {
    }

    @Field
    public static /* synthetic */ void getClip$annotations() {
    }

    @Field
    public static /* synthetic */ void getCompositingStrategy$annotations() {
    }

    @Field
    public static /* synthetic */ void getShape$annotations() {
    }

    @Field
    public static /* synthetic */ void getSpotShadowColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getTransformOriginX$annotations() {
    }

    @Field
    public static /* synthetic */ void getTransformOriginY$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getTransformOriginX() {
        return this.transformOriginX;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getTransformOriginY() {
        return this.transformOriginY;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getClip() {
        return this.clip;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final BuiltinShapeRecord getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Color getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Color getSpotShadowColor() {
        return this.spotShadowColor;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final CompositingStrategyType getCompositingStrategy() {
        return this.compositingStrategy;
    }

    public final GraphicsLayerParams copy(float cameraDistance, float transformOriginX, float transformOriginY, boolean clip, BuiltinShapeRecord shape, Color ambientShadowColor, Color spotShadowColor, CompositingStrategyType compositingStrategy) {
        return new GraphicsLayerParams(cameraDistance, transformOriginX, transformOriginY, clip, shape, ambientShadowColor, spotShadowColor, compositingStrategy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GraphicsLayerParams)) {
            return false;
        }
        GraphicsLayerParams graphicsLayerParams = (GraphicsLayerParams) other;
        return Float.compare(this.cameraDistance, graphicsLayerParams.cameraDistance) == 0 && Float.compare(this.transformOriginX, graphicsLayerParams.transformOriginX) == 0 && Float.compare(this.transformOriginY, graphicsLayerParams.transformOriginY) == 0 && this.clip == graphicsLayerParams.clip && Intrinsics.areEqual(this.shape, graphicsLayerParams.shape) && Intrinsics.areEqual(this.ambientShadowColor, graphicsLayerParams.ambientShadowColor) && Intrinsics.areEqual(this.spotShadowColor, graphicsLayerParams.spotShadowColor) && this.compositingStrategy == graphicsLayerParams.compositingStrategy;
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = ((((((Float.hashCode(this.cameraDistance) * 31) + Float.hashCode(this.transformOriginX)) * 31) + Float.hashCode(this.transformOriginY)) * 31) + Boolean.hashCode(this.clip)) * 31;
        BuiltinShapeRecord builtinShapeRecord = this.shape;
        int iHashCode2 = (iHashCode + (builtinShapeRecord == null ? 0 : builtinShapeRecord.hashCode())) * 31;
        Color color = this.ambientShadowColor;
        int iHashCode3 = (iHashCode2 + (color == null ? 0 : color.hashCode())) * 31;
        Color color2 = this.spotShadowColor;
        int iHashCode4 = (iHashCode3 + (color2 == null ? 0 : color2.hashCode())) * 31;
        CompositingStrategyType compositingStrategyType = this.compositingStrategy;
        return iHashCode4 + (compositingStrategyType != null ? compositingStrategyType.hashCode() : 0);
    }

    public String toString() {
        return "GraphicsLayerParams(cameraDistance=" + this.cameraDistance + ", transformOriginX=" + this.transformOriginX + ", transformOriginY=" + this.transformOriginY + ", clip=" + this.clip + ", shape=" + this.shape + ", ambientShadowColor=" + this.ambientShadowColor + ", spotShadowColor=" + this.spotShadowColor + ", compositingStrategy=" + this.compositingStrategy + ")";
    }

    public GraphicsLayerParams(float f, float f2, float f3, boolean z, BuiltinShapeRecord builtinShapeRecord, Color color, Color color2, CompositingStrategyType compositingStrategyType) {
        this.cameraDistance = f;
        this.transformOriginX = f2;
        this.transformOriginY = f3;
        this.clip = z;
        this.shape = builtinShapeRecord;
        this.ambientShadowColor = color;
        this.spotShadowColor = color2;
        this.compositingStrategy = compositingStrategyType;
    }

    public /* synthetic */ GraphicsLayerParams(float f, float f2, float f3, boolean z, BuiltinShapeRecord builtinShapeRecord, Color color, Color color2, CompositingStrategyType compositingStrategyType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 8.0f : f, (i & 2) != 0 ? 0.5f : f2, (i & 4) != 0 ? 0.5f : f3, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : builtinShapeRecord, (i & 32) != 0 ? null : color, (i & 64) != 0 ? null : color2, (i & 128) != 0 ? null : compositingStrategyType);
    }

    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    public final float getTransformOriginX() {
        return this.transformOriginX;
    }

    public final float getTransformOriginY() {
        return this.transformOriginY;
    }

    public final boolean getClip() {
        return this.clip;
    }

    public final BuiltinShapeRecord getShape() {
        return this.shape;
    }

    public final Color getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    public final Color getSpotShadowColor() {
        return this.spotShadowColor;
    }

    public final CompositingStrategyType getCompositingStrategy() {
        return this.compositingStrategy;
    }
}
