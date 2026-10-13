package expo.modules.medialibrary.next.records;

import android.net.Uri;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import expo.modules.medialibrary.next.objects.wrappers.MediaType;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AssetMetadata.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001@B[\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u00103\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010#J\t\u00104\u001a\u00020\u000eHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u00106\u001a\u00020\u0011HÆ\u0003Jt\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\f\u0010<\u001a\u0006\u0012\u0002\b\u00030=H\u0016J\t\u0010>\u001a\u00020\u000bHÖ\u0001J\t\u0010?\u001a\u00020\tHÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u001aR\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010 R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010$\u0012\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010#R \u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010$\u0012\u0004\b%\u0010\u0015\u001a\u0004\b&\u0010#R\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010)R \u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b*\u0010\u0015\u001a\u0004\b+\u0010\u001aR\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0015\u001a\u0004\b\u0010\u0010-¨\u0006A"}, d2 = {"Lexpo/modules/medialibrary/next/records/AssetMetadata;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "id", "Landroid/net/Uri;", "creationTime", "", "duration", "filename", "", ViewProps.HEIGHT, "", ViewProps.WIDTH, "mediaType", "Lexpo/modules/medialibrary/next/objects/wrappers/MediaType;", "modificationTime", "isFavorite", "", "<init>", "(Landroid/net/Uri;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lexpo/modules/medialibrary/next/objects/wrappers/MediaType;Ljava/lang/Long;Z)V", "getId$annotations", "()V", "getId", "()Landroid/net/Uri;", "getCreationTime$annotations", "getCreationTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDuration$annotations", "getDuration", "getFilename$annotations", "getFilename", "()Ljava/lang/String;", "getHeight$annotations", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidth$annotations", "getWidth", "getMediaType$annotations", "getMediaType", "()Lexpo/modules/medialibrary/next/objects/wrappers/MediaType;", "getModificationTime$annotations", "getModificationTime", "isFavorite$annotations", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Landroid/net/Uri;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lexpo/modules/medialibrary/next/objects/wrappers/MediaType;Ljava/lang/Long;Z)Lexpo/modules/medialibrary/next/records/AssetMetadata;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "toString", "__Pika", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AssetMetadata implements Record, PIntrospectionProvider {
    public Long creationTime;
    public Long duration;
    public String filename;
    public Integer height;
    public Uri id;
    public boolean isFavorite;
    public MediaType mediaType;
    public Long modificationTime;
    public Integer width;

    /* JADX INFO: compiled from: AssetMetadata.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/medialibrary/next/records/AssetMetadata$__Pika;", "", "<init>", "()V", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<AssetMetadata> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(AssetMetadata.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("id", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, false, null), 0, __pika, false, true, false), new PProperty("creationTime", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.LONG_NULLABLE, 1, __pika, false, true, false), new PProperty("duration", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.LONG_NULLABLE, 2, __pika, false, true, false), new PProperty("filename", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 3, __pika, false, true, false), new PProperty(ViewProps.HEIGHT, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.INT_NULLABLE, 4, __pika, false, true, false), new PProperty(ViewProps.WIDTH, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.INT_NULLABLE, 5, __pika, false, true, false), new PProperty("mediaType", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(MediaType.class, false, null), 6, __pika, false, true, false), new PProperty("modificationTime", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.LONG_NULLABLE, 7, __pika, false, true, false), new PProperty("isFavorite", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 8, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("component8", PVisibility.PUBLIC), new PFunction("component9", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    return ((AssetMetadata) obj).getId();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    return ((AssetMetadata) obj).getCreationTime();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    return ((AssetMetadata) obj).getDuration();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    return ((AssetMetadata) obj).getFilename();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    return ((AssetMetadata) obj).getHeight();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    return ((AssetMetadata) obj).getWidth();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    return ((AssetMetadata) obj).getMediaType();
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    return ((AssetMetadata) obj).getModificationTime();
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    return Boolean.valueOf(((AssetMetadata) obj).isFavorite());
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.net.Uri");
                    ((AssetMetadata) obj).id = (Uri) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    ((AssetMetadata) obj).creationTime = (Long) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    ((AssetMetadata) obj).duration = (Long) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    ((AssetMetadata) obj).filename = (String) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    ((AssetMetadata) obj).height = (Integer) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    ((AssetMetadata) obj).width = (Integer) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.medialibrary.next.objects.wrappers.MediaType");
                    ((AssetMetadata) obj).mediaType = (MediaType) obj2;
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    ((AssetMetadata) obj).modificationTime = (Long) obj2;
                    return;
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetMetadata");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((AssetMetadata) obj).isFavorite = ((Boolean) obj2).booleanValue();
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public static /* synthetic */ AssetMetadata copy$default(AssetMetadata assetMetadata, Uri uri, Long l, Long l2, String str, Integer num, Integer num2, MediaType mediaType, Long l3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = assetMetadata.id;
        }
        if ((i & 2) != 0) {
            l = assetMetadata.creationTime;
        }
        if ((i & 4) != 0) {
            l2 = assetMetadata.duration;
        }
        if ((i & 8) != 0) {
            str = assetMetadata.filename;
        }
        if ((i & 16) != 0) {
            num = assetMetadata.height;
        }
        if ((i & 32) != 0) {
            num2 = assetMetadata.width;
        }
        if ((i & 64) != 0) {
            mediaType = assetMetadata.mediaType;
        }
        if ((i & 128) != 0) {
            l3 = assetMetadata.modificationTime;
        }
        if ((i & 256) != 0) {
            z = assetMetadata.isFavorite;
        }
        Long l4 = l3;
        boolean z2 = z;
        Integer num3 = num2;
        MediaType mediaType2 = mediaType;
        Integer num4 = num;
        Long l5 = l2;
        return assetMetadata.copy(uri, l, l5, str, num4, num3, mediaType2, l4, z2);
    }

    @Field
    public static /* synthetic */ void getCreationTime$annotations() {
    }

    @Field
    public static /* synthetic */ void getDuration$annotations() {
    }

    @Field
    public static /* synthetic */ void getFilename$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getId$annotations() {
    }

    @Field
    public static /* synthetic */ void getMediaType$annotations() {
    }

    @Field
    public static /* synthetic */ void getModificationTime$annotations() {
    }

    @Field
    public static /* synthetic */ void getWidth$annotations() {
    }

    @Field
    public static /* synthetic */ void isFavorite$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getCreationTime() {
        return this.creationTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MediaType getMediaType() {
        return this.mediaType;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getModificationTime() {
        return this.modificationTime;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsFavorite() {
        return this.isFavorite;
    }

    public final AssetMetadata copy(Uri id, Long creationTime, Long duration, String filename, Integer height, Integer width, MediaType mediaType, Long modificationTime, boolean isFavorite) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        return new AssetMetadata(id, creationTime, duration, filename, height, width, mediaType, modificationTime, isFavorite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AssetMetadata)) {
            return false;
        }
        AssetMetadata assetMetadata = (AssetMetadata) other;
        return Intrinsics.areEqual(this.id, assetMetadata.id) && Intrinsics.areEqual(this.creationTime, assetMetadata.creationTime) && Intrinsics.areEqual(this.duration, assetMetadata.duration) && Intrinsics.areEqual(this.filename, assetMetadata.filename) && Intrinsics.areEqual(this.height, assetMetadata.height) && Intrinsics.areEqual(this.width, assetMetadata.width) && this.mediaType == assetMetadata.mediaType && Intrinsics.areEqual(this.modificationTime, assetMetadata.modificationTime) && this.isFavorite == assetMetadata.isFavorite;
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        Long l = this.creationTime;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.duration;
        int iHashCode3 = (iHashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str = this.filename;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.height;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.width;
        int iHashCode6 = (((iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31) + this.mediaType.hashCode()) * 31;
        Long l3 = this.modificationTime;
        return ((iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31) + Boolean.hashCode(this.isFavorite);
    }

    public String toString() {
        return "AssetMetadata(id=" + this.id + ", creationTime=" + this.creationTime + ", duration=" + this.duration + ", filename=" + this.filename + ", height=" + this.height + ", width=" + this.width + ", mediaType=" + this.mediaType + ", modificationTime=" + this.modificationTime + ", isFavorite=" + this.isFavorite + ")";
    }

    public AssetMetadata(Uri id, Long l, Long l2, String str, Integer num, Integer num2, MediaType mediaType, Long l3, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        this.id = id;
        this.creationTime = l;
        this.duration = l2;
        this.filename = str;
        this.height = num;
        this.width = num2;
        this.mediaType = mediaType;
        this.modificationTime = l3;
        this.isFavorite = z;
    }

    public final Uri getId() {
        return this.id;
    }

    public final Long getCreationTime() {
        return this.creationTime;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final MediaType getMediaType() {
        return this.mediaType;
    }

    public final Long getModificationTime() {
        return this.modificationTime;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }
}
