package expo.modules.updates.reloadscreen;

import android.net.Uri;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
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

/* JADX INFO: compiled from: ReloadScreenConfiguration.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001'B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0083\u0004J\f\u0010!\u001a\u0006\u0012\u0002\b\u00030\"H\u0016J\n\u0010#\u001a\u00020$HÖ\u0081\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u0011R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u0011¨\u0006("}, d2 = {"Lexpo/modules/updates/reloadscreen/ReloadScreenImageSource;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", ImagesContract.URL, "Landroid/net/Uri;", ViewProps.WIDTH, "", ViewProps.HEIGHT, "scale", "<init>", "(Landroid/net/Uri;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getUrl$annotations", "()V", "getUrl", "()Landroid/net/Uri;", "getWidth$annotations", "getWidth", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHeight$annotations", "getHeight", "getScale$annotations", "getScale", "component1", "component2", "component3", "component4", "copy", "(Landroid/net/Uri;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lexpo/modules/updates/reloadscreen/ReloadScreenImageSource;", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ReloadScreenImageSource implements Record, PIntrospectionProvider {
    public Double height;
    public Double scale;
    public Uri url;
    public Double width;

    public ReloadScreenImageSource() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ReloadScreenImageSource copy$default(ReloadScreenImageSource reloadScreenImageSource, Uri uri, Double d, Double d2, Double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = reloadScreenImageSource.url;
        }
        if ((i & 2) != 0) {
            d = reloadScreenImageSource.width;
        }
        if ((i & 4) != 0) {
            d2 = reloadScreenImageSource.height;
        }
        if ((i & 8) != 0) {
            d3 = reloadScreenImageSource.scale;
        }
        return reloadScreenImageSource.copy(uri, d, d2, d3);
    }

    @Field
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getScale$annotations() {
    }

    @Field
    public static /* synthetic */ void getUrl$annotations() {
    }

    @Field
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getScale() {
        return this.scale;
    }

    public final ReloadScreenImageSource copy(Uri url, Double width, Double height, Double scale) {
        return new ReloadScreenImageSource(url, width, height, scale);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReloadScreenImageSource)) {
            return false;
        }
        ReloadScreenImageSource reloadScreenImageSource = (ReloadScreenImageSource) other;
        return Intrinsics.areEqual(this.url, reloadScreenImageSource.url) && Intrinsics.areEqual((Object) this.width, (Object) reloadScreenImageSource.width) && Intrinsics.areEqual((Object) this.height, (Object) reloadScreenImageSource.height) && Intrinsics.areEqual((Object) this.scale, (Object) reloadScreenImageSource.scale);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Uri uri = this.url;
        int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
        Double d = this.width;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.height;
        int iHashCode3 = (iHashCode2 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.scale;
        return iHashCode3 + (d3 != null ? d3.hashCode() : 0);
    }

    public String toString() {
        return "ReloadScreenImageSource(url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", scale=" + this.scale + ")";
    }

    /* JADX INFO: compiled from: ReloadScreenConfiguration.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/reloadscreen/ReloadScreenImageSource$__Pika;", "", "<init>", "()V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ReloadScreenImageSource> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ReloadScreenImageSource.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty(ImagesContract.URL, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, true, null), 0, __pika, false, true, false), new PProperty(ViewProps.WIDTH, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.DOUBLE_NULLABLE, 1, __pika, false, true, false), new PProperty(ViewProps.HEIGHT, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.DOUBLE_NULLABLE, 2, __pika, false, true, false), new PProperty("scale", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.DOUBLE_NULLABLE, 3, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenImageSource");
                return ((ReloadScreenImageSource) obj).getUrl();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenImageSource");
                return ((ReloadScreenImageSource) obj).getWidth();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenImageSource");
                return ((ReloadScreenImageSource) obj).getHeight();
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenImageSource");
            return ((ReloadScreenImageSource) obj).getScale();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenImageSource");
                ((ReloadScreenImageSource) obj).url = (Uri) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenImageSource");
                ((ReloadScreenImageSource) obj).width = (Double) obj2;
            } else if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenImageSource");
                ((ReloadScreenImageSource) obj).height = (Double) obj2;
            } else {
                if (i != 3) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.ReloadScreenImageSource");
                ((ReloadScreenImageSource) obj).scale = (Double) obj2;
            }
        }

        private __Pika() {
        }
    }

    public ReloadScreenImageSource(Uri uri, Double d, Double d2, Double d3) {
        this.url = uri;
        this.width = d;
        this.height = d2;
        this.scale = d3;
    }

    public /* synthetic */ ReloadScreenImageSource(Uri uri, Double d, Double d2, Double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : uri, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : d2, (i & 8) != 0 ? null : d3);
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final Double getWidth() {
        return this.width;
    }

    public final Double getHeight() {
        return this.height;
    }

    public final Double getScale() {
        return this.scale;
    }
}
