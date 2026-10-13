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
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileSystemWatcher.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00010B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJN\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\f\u0010,\u001a\u0006\u0012\u0002\b\u00030-H\u0016J\t\u0010.\u001a\u00020\nHÖ\u0001J\t\u0010/\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0007\u0010\u0017R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0015R \u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010 \u0012\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u001f¨\u00061"}, d2 = {"Lexpo/modules/filesystem/WatchEventPayload;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "type", "Lexpo/modules/filesystem/WatchEventType;", "path", "", "isDirectory", "", "nativeEventFlags", "", "newPath", "newPathIsDirectory", "<init>", "(Lexpo/modules/filesystem/WatchEventType;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/Boolean;)V", "getType$annotations", "()V", "getType", "()Lexpo/modules/filesystem/WatchEventType;", "getPath$annotations", "getPath", "()Ljava/lang/String;", "isDirectory$annotations", "()Z", "getNativeEventFlags$annotations", "getNativeEventFlags", "()I", "getNewPath$annotations", "getNewPath", "getNewPathIsDirectory$annotations", "getNewPathIsDirectory", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lexpo/modules/filesystem/WatchEventType;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/Boolean;)Lexpo/modules/filesystem/WatchEventPayload;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "toString", "__Pika", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class WatchEventPayload implements Record, PIntrospectionProvider {
    public boolean isDirectory;
    public int nativeEventFlags;
    public String newPath;
    public Boolean newPathIsDirectory;
    public String path;
    public WatchEventType type;

    /* JADX INFO: compiled from: FileSystemWatcher.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/filesystem/WatchEventPayload$__Pika;", "", "<init>", "()V", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<WatchEventPayload> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(WatchEventPayload.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("type", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(WatchEventType.class, false, null), 0, __pika, false, true, false), new PProperty("path", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING, 1, __pika, false, true, false), new PProperty("isDirectory", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 2, __pika, false, true, false), new PProperty("nativeEventFlags", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.INT, 3, __pika, false, true, false), new PProperty("newPath", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 4, __pika, false, true, false), new PProperty("newPathIsDirectory", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN_NULLABLE, 5, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.WatchEventPayload");
                return ((WatchEventPayload) obj).getType();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.WatchEventPayload");
                return ((WatchEventPayload) obj).getPath();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.WatchEventPayload");
                return Boolean.valueOf(((WatchEventPayload) obj).isDirectory());
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.WatchEventPayload");
                return Integer.valueOf(((WatchEventPayload) obj).getNativeEventFlags());
            }
            if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.WatchEventPayload");
                return ((WatchEventPayload) obj).getNewPath();
            }
            if (i != 5) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.WatchEventPayload");
            return ((WatchEventPayload) obj).getNewPathIsDirectory();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.WatchEventPayload");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.filesystem.WatchEventType");
                ((WatchEventPayload) obj).type = (WatchEventType) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.WatchEventPayload");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                ((WatchEventPayload) obj).path = (String) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.WatchEventPayload");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((WatchEventPayload) obj).isDirectory = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.WatchEventPayload");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                ((WatchEventPayload) obj).nativeEventFlags = ((Integer) obj2).intValue();
                return;
            }
            if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.WatchEventPayload");
                ((WatchEventPayload) obj).newPath = (String) obj2;
            } else {
                if (i != 5) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.WatchEventPayload");
                ((WatchEventPayload) obj).newPathIsDirectory = (Boolean) obj2;
            }
        }
    }

    public static /* synthetic */ WatchEventPayload copy$default(WatchEventPayload watchEventPayload, WatchEventType watchEventType, String str, boolean z, int i, String str2, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            watchEventType = watchEventPayload.type;
        }
        if ((i2 & 2) != 0) {
            str = watchEventPayload.path;
        }
        if ((i2 & 4) != 0) {
            z = watchEventPayload.isDirectory;
        }
        if ((i2 & 8) != 0) {
            i = watchEventPayload.nativeEventFlags;
        }
        if ((i2 & 16) != 0) {
            str2 = watchEventPayload.newPath;
        }
        if ((i2 & 32) != 0) {
            bool = watchEventPayload.newPathIsDirectory;
        }
        String str3 = str2;
        Boolean bool2 = bool;
        return watchEventPayload.copy(watchEventType, str, z, i, str3, bool2);
    }

    @Field
    public static /* synthetic */ void getNativeEventFlags$annotations() {
    }

    @Field
    public static /* synthetic */ void getNewPath$annotations() {
    }

    @Field
    public static /* synthetic */ void getNewPathIsDirectory$annotations() {
    }

    @Field
    public static /* synthetic */ void getPath$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    @Field
    public static /* synthetic */ void isDirectory$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WatchEventType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsDirectory() {
        return this.isDirectory;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getNativeEventFlags() {
        return this.nativeEventFlags;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getNewPath() {
        return this.newPath;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getNewPathIsDirectory() {
        return this.newPathIsDirectory;
    }

    public final WatchEventPayload copy(WatchEventType type, String path, boolean isDirectory, int nativeEventFlags, String newPath, Boolean newPathIsDirectory) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(path, "path");
        return new WatchEventPayload(type, path, isDirectory, nativeEventFlags, newPath, newPathIsDirectory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WatchEventPayload)) {
            return false;
        }
        WatchEventPayload watchEventPayload = (WatchEventPayload) other;
        return this.type == watchEventPayload.type && Intrinsics.areEqual(this.path, watchEventPayload.path) && this.isDirectory == watchEventPayload.isDirectory && this.nativeEventFlags == watchEventPayload.nativeEventFlags && Intrinsics.areEqual(this.newPath, watchEventPayload.newPath) && Intrinsics.areEqual(this.newPathIsDirectory, watchEventPayload.newPathIsDirectory);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = ((((((this.type.hashCode() * 31) + this.path.hashCode()) * 31) + Boolean.hashCode(this.isDirectory)) * 31) + Integer.hashCode(this.nativeEventFlags)) * 31;
        String str = this.newPath;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.newPathIsDirectory;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "WatchEventPayload(type=" + this.type + ", path=" + this.path + ", isDirectory=" + this.isDirectory + ", nativeEventFlags=" + this.nativeEventFlags + ", newPath=" + this.newPath + ", newPathIsDirectory=" + this.newPathIsDirectory + ")";
    }

    public WatchEventPayload(WatchEventType type, String path, boolean z, int i, String str, Boolean bool) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(path, "path");
        this.type = type;
        this.path = path;
        this.isDirectory = z;
        this.nativeEventFlags = i;
        this.newPath = str;
        this.newPathIsDirectory = bool;
    }

    public /* synthetic */ WatchEventPayload(WatchEventType watchEventType, String str, boolean z, int i, String str2, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(watchEventType, str, z, i, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? null : bool);
    }

    public final WatchEventType getType() {
        return this.type;
    }

    public final String getPath() {
        return this.path;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final int getNativeEventFlags() {
        return this.nativeEventFlags;
    }

    public final String getNewPath() {
        return this.newPath;
    }

    public final Boolean getNewPathIsDirectory() {
        return this.newPathIsDirectory;
    }
}
