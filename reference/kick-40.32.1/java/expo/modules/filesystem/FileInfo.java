package expo.modules.filesystem;

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
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileSystemNextRecords.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00018BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010(\u001a\u00020\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJT\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\f\u00103\u001a\u0006\u0012\u0002\b\u000304H\u0016J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0006HÖ\u0001R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R(\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010!\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010!\u0012\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R(\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010!\u0012\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010\u001e\"\u0004\b'\u0010 ¨\u00069"}, d2 = {"Lexpo/modules/filesystem/FileInfo;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "exists", "", "uri", "", "md5", ContentDisposition.Parameters.Size, "", "modificationTime", "creationTime", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getExists$annotations", "()V", "getExists", "()Z", "setExists", "(Z)V", "getUri$annotations", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "getMd5$annotations", "getMd5", "setMd5", "getSize$annotations", "getSize", "()Ljava/lang/Long;", "setSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getModificationTime$annotations", "getModificationTime", "setModificationTime", "getCreationTime$annotations", "getCreationTime", "setCreationTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lexpo/modules/filesystem/FileInfo;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileInfo implements Record, PIntrospectionProvider {
    public Long creationTime;
    public boolean exists;
    public String md5;
    public Long modificationTime;
    public Long size;
    public String uri;

    /* JADX INFO: compiled from: FileSystemNextRecords.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/filesystem/FileInfo$__Pika;", "", "<init>", "()V", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<FileInfo> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(FileInfo.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("exists", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 0, __pika, true, true, false), new PProperty("uri", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 1, __pika, true, true, false), new PProperty("md5", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 2, __pika, true, true, false), new PProperty(ContentDisposition.Parameters.Size, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.LONG_NULLABLE, 3, __pika, true, true, false), new PProperty("modificationTime", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.LONG_NULLABLE, 4, __pika, true, true, false), new PProperty("creationTime", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.LONG_NULLABLE, 5, __pika, true, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.FileInfo");
                return Boolean.valueOf(((FileInfo) obj).getExists());
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.FileInfo");
                return ((FileInfo) obj).getUri();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.FileInfo");
                return ((FileInfo) obj).getMd5();
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.FileInfo");
                return ((FileInfo) obj).getSize();
            }
            if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.FileInfo");
                return ((FileInfo) obj).getModificationTime();
            }
            if (i != 5) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.FileInfo");
            return ((FileInfo) obj).getCreationTime();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.FileInfo");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((FileInfo) obj).setExists(((Boolean) obj2).booleanValue());
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.FileInfo");
                ((FileInfo) obj).setUri((String) obj2);
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.FileInfo");
                ((FileInfo) obj).setMd5((String) obj2);
                return;
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.FileInfo");
                ((FileInfo) obj).setSize((Long) obj2);
            } else if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.FileInfo");
                ((FileInfo) obj).setModificationTime((Long) obj2);
            } else {
                if (i != 5) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.FileInfo");
                ((FileInfo) obj).setCreationTime((Long) obj2);
            }
        }
    }

    public static /* synthetic */ FileInfo copy$default(FileInfo fileInfo, boolean z, String str, String str2, Long l, Long l2, Long l3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fileInfo.exists;
        }
        if ((i & 2) != 0) {
            str = fileInfo.uri;
        }
        if ((i & 4) != 0) {
            str2 = fileInfo.md5;
        }
        if ((i & 8) != 0) {
            l = fileInfo.size;
        }
        if ((i & 16) != 0) {
            l2 = fileInfo.modificationTime;
        }
        if ((i & 32) != 0) {
            l3 = fileInfo.creationTime;
        }
        Long l4 = l2;
        Long l5 = l3;
        return fileInfo.copy(z, str, str2, l, l4, l5);
    }

    @Field
    public static /* synthetic */ void getCreationTime$annotations() {
    }

    @Field
    public static /* synthetic */ void getExists$annotations() {
    }

    @Field
    public static /* synthetic */ void getMd5$annotations() {
    }

    @Field
    public static /* synthetic */ void getModificationTime$annotations() {
    }

    @Field
    public static /* synthetic */ void getSize$annotations() {
    }

    @Field
    public static /* synthetic */ void getUri$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getExists() {
        return this.exists;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getModificationTime() {
        return this.modificationTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getCreationTime() {
        return this.creationTime;
    }

    public final FileInfo copy(boolean exists, String uri, String md5, Long size, Long modificationTime, Long creationTime) {
        return new FileInfo(exists, uri, md5, size, modificationTime, creationTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileInfo)) {
            return false;
        }
        FileInfo fileInfo = (FileInfo) other;
        return this.exists == fileInfo.exists && Intrinsics.areEqual(this.uri, fileInfo.uri) && Intrinsics.areEqual(this.md5, fileInfo.md5) && Intrinsics.areEqual(this.size, fileInfo.size) && Intrinsics.areEqual(this.modificationTime, fileInfo.modificationTime) && Intrinsics.areEqual(this.creationTime, fileInfo.creationTime);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.exists) * 31;
        String str = this.uri;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.md5;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.size;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.modificationTime;
        int iHashCode5 = (iHashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.creationTime;
        return iHashCode5 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        return "FileInfo(exists=" + this.exists + ", uri=" + this.uri + ", md5=" + this.md5 + ", size=" + this.size + ", modificationTime=" + this.modificationTime + ", creationTime=" + this.creationTime + ")";
    }

    public FileInfo(boolean z, String str, String str2, Long l, Long l2, Long l3) {
        this.exists = z;
        this.uri = str;
        this.md5 = str2;
        this.size = l;
        this.modificationTime = l2;
        this.creationTime = l3;
    }

    public /* synthetic */ FileInfo(boolean z, String str, String str2, Long l, Long l2, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : l3);
    }

    public final boolean getExists() {
        return this.exists;
    }

    public final void setExists(boolean z) {
        this.exists = z;
    }

    public final String getUri() {
        return this.uri;
    }

    public final void setUri(String str) {
        this.uri = str;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final void setMd5(String str) {
        this.md5 = str;
    }

    public final Long getSize() {
        return this.size;
    }

    public final void setSize(Long l) {
        this.size = l;
    }

    public final Long getModificationTime() {
        return this.modificationTime;
    }

    public final void setModificationTime(Long l) {
        this.modificationTime = l;
    }

    public final Long getCreationTime() {
        return this.creationTime;
    }

    public final void setCreationTime(Long l) {
        this.creationTime = l;
    }
}
