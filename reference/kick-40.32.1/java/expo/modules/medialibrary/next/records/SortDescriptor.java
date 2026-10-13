package expo.modules.medialibrary.next.records;

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
import io.ktor.sse.ServerSentEventKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SortDescriptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ$\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\f\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lexpo/modules/medialibrary/next/records/SortDescriptor;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "key", "Lexpo/modules/medialibrary/next/records/AssetField;", "ascending", "", "<init>", "(Lexpo/modules/medialibrary/next/records/AssetField;Ljava/lang/Boolean;)V", "getKey$annotations", "()V", "getKey", "()Lexpo/modules/medialibrary/next/records/AssetField;", "getAscending$annotations", "getAscending", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "toMediaStoreQueryString", "", "component1", "component2", "copy", "(Lexpo/modules/medialibrary/next/records/AssetField;Ljava/lang/Boolean;)Lexpo/modules/medialibrary/next/records/SortDescriptor;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SortDescriptor implements Record, PIntrospectionProvider {
    public Boolean ascending;
    public AssetField key;

    /* JADX INFO: compiled from: SortDescriptor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/medialibrary/next/records/SortDescriptor$__Pika;", "", "<init>", "()V", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<SortDescriptor> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(SortDescriptor.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("key", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(AssetField.class, false, null), 0, __pika, false, true, false), new PProperty("ascending", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN_NULLABLE, 1, __pika, false, true, false)}, new PFunction[]{new PFunction("toMediaStoreQueryString", PVisibility.PUBLIC), new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.SortDescriptor");
                return ((SortDescriptor) obj).getKey();
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.SortDescriptor");
            return ((SortDescriptor) obj).getAscending();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.SortDescriptor");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.AssetField");
                ((SortDescriptor) obj).key = (AssetField) obj2;
                return;
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.medialibrary.next.records.SortDescriptor");
            ((SortDescriptor) obj).ascending = (Boolean) obj2;
        }
    }

    public static /* synthetic */ SortDescriptor copy$default(SortDescriptor sortDescriptor, AssetField assetField, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            assetField = sortDescriptor.key;
        }
        if ((i & 2) != 0) {
            bool = sortDescriptor.ascending;
        }
        return sortDescriptor.copy(assetField, bool);
    }

    @Field
    public static /* synthetic */ void getAscending$annotations() {
    }

    @Field
    public static /* synthetic */ void getKey$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AssetField getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getAscending() {
        return this.ascending;
    }

    public final SortDescriptor copy(AssetField key, Boolean ascending) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new SortDescriptor(key, ascending);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SortDescriptor)) {
            return false;
        }
        SortDescriptor sortDescriptor = (SortDescriptor) other;
        return this.key == sortDescriptor.key && Intrinsics.areEqual(this.ascending, sortDescriptor.ascending);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = this.key.hashCode() * 31;
        Boolean bool = this.ascending;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "SortDescriptor(key=" + this.key + ", ascending=" + this.ascending + ")";
    }

    public SortDescriptor(AssetField key, Boolean bool) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.ascending = bool;
    }

    public final AssetField getKey() {
        return this.key;
    }

    public /* synthetic */ SortDescriptor(AssetField assetField, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(assetField, (i & 2) != 0 ? true : bool);
    }

    public final Boolean getAscending() {
        return this.ascending;
    }

    public final String toMediaStoreQueryString() {
        String str;
        Boolean bool = this.ascending;
        if (bool != null ? bool.booleanValue() : true) {
            str = "ASC";
        } else {
            str = "DESC";
        }
        return this.key.toMediaStoreColumn() + ServerSentEventKt.SPACE + str;
    }
}
