package expo.modules.filesystem;

import android.net.Uri;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PFunction;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PickFileOptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001$B+\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J8\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\f\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 H\u0016J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lexpo/modules/filesystem/PickFileOptions;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "initialUri", "Landroid/net/Uri;", "mimeTypes", "", "", "multipleFiles", "", "<init>", "(Landroid/net/Uri;Ljava/util/List;Ljava/lang/Boolean;)V", "getInitialUri$annotations", "()V", "getInitialUri", "()Landroid/net/Uri;", "getMimeTypes$annotations", "getMimeTypes", "()Ljava/util/List;", "getMultipleFiles$annotations", "getMultipleFiles", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Landroid/net/Uri;Ljava/util/List;Ljava/lang/Boolean;)Lexpo/modules/filesystem/PickFileOptions;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PickFileOptions implements Record, PIntrospectionProvider {
    public Uri initialUri;
    public List<String> mimeTypes;
    public Boolean multipleFiles;

    /* JADX INFO: compiled from: PickFileOptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/filesystem/PickFileOptions$__Pika;", "", "<init>", "()V", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<PickFileOptions> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(PickFileOptions.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("initialUri", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, true, null), 0, __pika, false, true, false), new PProperty("mimeTypes", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, true, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING}), null), 1, __pika, false, true, false), new PProperty("multipleFiles", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN_NULLABLE, 2, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.PickFileOptions");
                return ((PickFileOptions) obj).getInitialUri();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.PickFileOptions");
                return ((PickFileOptions) obj).getMimeTypes();
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.PickFileOptions");
            return ((PickFileOptions) obj).getMultipleFiles();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.PickFileOptions");
                ((PickFileOptions) obj).initialUri = (Uri) obj2;
            } else if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.PickFileOptions");
                ((PickFileOptions) obj).mimeTypes = (List) obj2;
            } else {
                if (i != 2) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.filesystem.PickFileOptions");
                ((PickFileOptions) obj).multipleFiles = (Boolean) obj2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PickFileOptions copy$default(PickFileOptions pickFileOptions, Uri uri, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = pickFileOptions.initialUri;
        }
        if ((i & 2) != 0) {
            list = pickFileOptions.mimeTypes;
        }
        if ((i & 4) != 0) {
            bool = pickFileOptions.multipleFiles;
        }
        return pickFileOptions.copy(uri, list, bool);
    }

    @Field
    public static /* synthetic */ void getInitialUri$annotations() {
    }

    @Field
    public static /* synthetic */ void getMimeTypes$annotations() {
    }

    @Field
    public static /* synthetic */ void getMultipleFiles$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getInitialUri() {
        return this.initialUri;
    }

    public final List<String> component2() {
        return this.mimeTypes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getMultipleFiles() {
        return this.multipleFiles;
    }

    public final PickFileOptions copy(Uri initialUri, List<String> mimeTypes, Boolean multipleFiles) {
        return new PickFileOptions(initialUri, mimeTypes, multipleFiles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PickFileOptions)) {
            return false;
        }
        PickFileOptions pickFileOptions = (PickFileOptions) other;
        return Intrinsics.areEqual(this.initialUri, pickFileOptions.initialUri) && Intrinsics.areEqual(this.mimeTypes, pickFileOptions.mimeTypes) && Intrinsics.areEqual(this.multipleFiles, pickFileOptions.multipleFiles);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Uri uri = this.initialUri;
        int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
        List<String> list = this.mimeTypes;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.multipleFiles;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "PickFileOptions(initialUri=" + this.initialUri + ", mimeTypes=" + this.mimeTypes + ", multipleFiles=" + this.multipleFiles + ")";
    }

    public PickFileOptions(Uri uri, List<String> list, Boolean bool) {
        this.initialUri = uri;
        this.mimeTypes = list;
        this.multipleFiles = bool;
    }

    public final Uri getInitialUri() {
        return this.initialUri;
    }

    public final List<String> getMimeTypes() {
        return this.mimeTypes;
    }

    public final Boolean getMultipleFiles() {
        return this.multipleFiles;
    }
}
