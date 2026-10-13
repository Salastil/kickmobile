package expo.modules.kotlin.types.descriptors;

import io.github.expo.pika.PIntrospectionData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypeDescriptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fR\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0018\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0003\u0010\u0011\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/types/descriptors/RawTypeDescriptor;", "", "jClass", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "isNullable", "", "()Z", "introspection", "Lio/github/expo/pika/PIntrospectionData;", "getIntrospection", "()Lio/github/expo/pika/PIntrospectionData;", "Simple", "Parameterized", "Star", "Lexpo/modules/kotlin/types/descriptors/RawTypeDescriptor$Parameterized;", "Lexpo/modules/kotlin/types/descriptors/RawTypeDescriptor$Simple;", "Lexpo/modules/kotlin/types/descriptors/RawTypeDescriptor$Star;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface RawTypeDescriptor {
    PIntrospectionData<?> getIntrospection();

    Class<?> getJClass();

    boolean isNullable();

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u001a\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lexpo/modules/kotlin/types/descriptors/RawTypeDescriptor$Simple;", "Lexpo/modules/kotlin/types/descriptors/RawTypeDescriptor;", "jClass", "Ljava/lang/Class;", "isNullable", "", "introspection", "Lio/github/expo/pika/PIntrospectionData;", "<init>", "(Ljava/lang/Class;ZLio/github/expo/pika/PIntrospectionData;)V", "getJClass", "()Ljava/lang/Class;", "()Z", "getIntrospection", "()Lio/github/expo/pika/PIntrospectionData;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Simple implements RawTypeDescriptor {
        public static final int $stable = 8;
        private final PIntrospectionData<?> introspection;
        private final boolean isNullable;
        private final Class<?> jClass;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Simple copy$default(Simple simple, Class cls, boolean z, PIntrospectionData pIntrospectionData, int i, Object obj) {
            if ((i & 1) != 0) {
                cls = simple.jClass;
            }
            if ((i & 2) != 0) {
                z = simple.isNullable;
            }
            if ((i & 4) != 0) {
                pIntrospectionData = simple.introspection;
            }
            return simple.copy(cls, z, pIntrospectionData);
        }

        public final Class<?> component1() {
            return this.jClass;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsNullable() {
            return this.isNullable;
        }

        public final PIntrospectionData<?> component3() {
            return this.introspection;
        }

        public final Simple copy(Class<?> jClass, boolean isNullable, PIntrospectionData<?> introspection) {
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            return new Simple(jClass, isNullable, introspection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Simple)) {
                return false;
            }
            Simple simple = (Simple) other;
            return Intrinsics.areEqual(this.jClass, simple.jClass) && this.isNullable == simple.isNullable && Intrinsics.areEqual(this.introspection, simple.introspection);
        }

        public int hashCode() {
            int iHashCode = ((this.jClass.hashCode() * 31) + Boolean.hashCode(this.isNullable)) * 31;
            PIntrospectionData<?> pIntrospectionData = this.introspection;
            return iHashCode + (pIntrospectionData == null ? 0 : pIntrospectionData.hashCode());
        }

        public String toString() {
            return "Simple(jClass=" + this.jClass + ", isNullable=" + this.isNullable + ", introspection=" + this.introspection + ")";
        }

        public Simple(Class<?> jClass, boolean z, PIntrospectionData<?> pIntrospectionData) {
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            this.jClass = jClass;
            this.isNullable = z;
            this.introspection = pIntrospectionData;
        }

        @Override // expo.modules.kotlin.types.descriptors.RawTypeDescriptor
        public Class<?> getJClass() {
            return this.jClass;
        }

        @Override // expo.modules.kotlin.types.descriptors.RawTypeDescriptor
        public boolean isNullable() {
            return this.isNullable;
        }

        @Override // expo.modules.kotlin.types.descriptors.RawTypeDescriptor
        public PIntrospectionData<?> getIntrospection() {
            return this.introspection;
        }
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\tHÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u001a\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lexpo/modules/kotlin/types/descriptors/RawTypeDescriptor$Parameterized;", "Lexpo/modules/kotlin/types/descriptors/RawTypeDescriptor;", "jClass", "Ljava/lang/Class;", "isNullable", "", "introspection", "Lio/github/expo/pika/PIntrospectionData;", "params", "", "<init>", "(Ljava/lang/Class;ZLio/github/expo/pika/PIntrospectionData;Ljava/util/List;)V", "getJClass", "()Ljava/lang/Class;", "()Z", "getIntrospection", "()Lio/github/expo/pika/PIntrospectionData;", "getParams", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Parameterized implements RawTypeDescriptor {
        public static final int $stable = 8;
        private final PIntrospectionData<?> introspection;
        private final boolean isNullable;
        private final Class<?> jClass;
        private final List<RawTypeDescriptor> params;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Parameterized copy$default(Parameterized parameterized, Class cls, boolean z, PIntrospectionData pIntrospectionData, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                cls = parameterized.jClass;
            }
            if ((i & 2) != 0) {
                z = parameterized.isNullable;
            }
            if ((i & 4) != 0) {
                pIntrospectionData = parameterized.introspection;
            }
            if ((i & 8) != 0) {
                list = parameterized.params;
            }
            return parameterized.copy(cls, z, pIntrospectionData, list);
        }

        public final Class<?> component1() {
            return this.jClass;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsNullable() {
            return this.isNullable;
        }

        public final PIntrospectionData<?> component3() {
            return this.introspection;
        }

        public final List<RawTypeDescriptor> component4() {
            return this.params;
        }

        public final Parameterized copy(Class<?> jClass, boolean isNullable, PIntrospectionData<?> introspection, List<? extends RawTypeDescriptor> params) {
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            Intrinsics.checkNotNullParameter(params, "params");
            return new Parameterized(jClass, isNullable, introspection, params);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Parameterized)) {
                return false;
            }
            Parameterized parameterized = (Parameterized) other;
            return Intrinsics.areEqual(this.jClass, parameterized.jClass) && this.isNullable == parameterized.isNullable && Intrinsics.areEqual(this.introspection, parameterized.introspection) && Intrinsics.areEqual(this.params, parameterized.params);
        }

        public int hashCode() {
            int iHashCode = ((this.jClass.hashCode() * 31) + Boolean.hashCode(this.isNullable)) * 31;
            PIntrospectionData<?> pIntrospectionData = this.introspection;
            return ((iHashCode + (pIntrospectionData == null ? 0 : pIntrospectionData.hashCode())) * 31) + this.params.hashCode();
        }

        public String toString() {
            return "Parameterized(jClass=" + this.jClass + ", isNullable=" + this.isNullable + ", introspection=" + this.introspection + ", params=" + this.params + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Parameterized(Class<?> jClass, boolean z, PIntrospectionData<?> pIntrospectionData, List<? extends RawTypeDescriptor> params) {
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            Intrinsics.checkNotNullParameter(params, "params");
            this.jClass = jClass;
            this.isNullable = z;
            this.introspection = pIntrospectionData;
            this.params = params;
        }

        @Override // expo.modules.kotlin.types.descriptors.RawTypeDescriptor
        public Class<?> getJClass() {
            return this.jClass;
        }

        @Override // expo.modules.kotlin.types.descriptors.RawTypeDescriptor
        public boolean isNullable() {
            return this.isNullable;
        }

        @Override // expo.modules.kotlin.types.descriptors.RawTypeDescriptor
        public PIntrospectionData<?> getIntrospection() {
            return this.introspection;
        }

        public final List<RawTypeDescriptor> getParams() {
            return this.params;
        }
    }

    /* JADX INFO: compiled from: TypeDescriptor.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lexpo/modules/kotlin/types/descriptors/RawTypeDescriptor$Star;", "Lexpo/modules/kotlin/types/descriptors/RawTypeDescriptor;", "<init>", "()V", "jClass", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "isNullable", "", "()Z", "introspection", "Lio/github/expo/pika/PIntrospectionData;", "getIntrospection", "()Lio/github/expo/pika/PIntrospectionData;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Star implements RawTypeDescriptor {
        private static final PIntrospectionData<?> introspection = null;
        public static final Star INSTANCE = new Star();
        private static final Class<?> jClass = Object.class;
        private static final boolean isNullable = true;
        public static final int $stable = 8;

        private Star() {
        }

        @Override // expo.modules.kotlin.types.descriptors.RawTypeDescriptor
        public Class<?> getJClass() {
            return jClass;
        }

        @Override // expo.modules.kotlin.types.descriptors.RawTypeDescriptor
        public boolean isNullable() {
            return isNullable;
        }

        @Override // expo.modules.kotlin.types.descriptors.RawTypeDescriptor
        public PIntrospectionData<?> getIntrospection() {
            return introspection;
        }
    }
}
