package io.github.expo.pika;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PTypeDescriptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lio/github/expo/pika/PTypeDescriptor;", "", "Concrete", "Star", "Lio/github/expo/pika/PTypeDescriptor$Concrete;", "Lio/github/expo/pika/PTypeDescriptor$Star;", "pika-api"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PTypeDescriptor {

    /* JADX INFO: compiled from: PTypeDescriptor.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0001\u000fB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lio/github/expo/pika/PTypeDescriptor$Concrete;", "Lio/github/expo/pika/PTypeDescriptor;", "pType", "Lio/github/expo/pika/PType;", "isNullable", "", "introspection", "Lio/github/expo/pika/PIntrospectionData;", "<init>", "(Lio/github/expo/pika/PType;ZLio/github/expo/pika/PIntrospectionData;)V", "getPType", "()Lio/github/expo/pika/PType;", "()Z", "getIntrospection", "()Lio/github/expo/pika/PIntrospectionData;", "Parameterized", "pika-api"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static class Concrete implements PTypeDescriptor {
        private final PIntrospectionData<?> introspection;
        private final boolean isNullable;
        private final PType pType;

        public Concrete(PType pType, boolean z, PIntrospectionData<?> pIntrospectionData) {
            Intrinsics.checkNotNullParameter(pType, "pType");
            this.pType = pType;
            this.isNullable = z;
            this.introspection = pIntrospectionData;
        }

        public /* synthetic */ Concrete(PType pType, boolean z, PIntrospectionData pIntrospectionData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(pType, z, (i & 4) != 0 ? null : pIntrospectionData);
        }

        public final PType getPType() {
            return this.pType;
        }

        /* JADX INFO: renamed from: isNullable, reason: from getter */
        public final boolean getIsNullable() {
            return this.isNullable;
        }

        public final PIntrospectionData<?> getIntrospection() {
            return this.introspection;
        }

        /* JADX INFO: compiled from: PTypeDescriptor.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/github/expo/pika/PTypeDescriptor$Concrete$Parameterized;", "Lio/github/expo/pika/PTypeDescriptor$Concrete;", "pType", "Lio/github/expo/pika/PType;", "isNullable", "", "parameters", "", "Lio/github/expo/pika/PTypeDescriptor;", "introspection", "Lio/github/expo/pika/PIntrospectionData;", "<init>", "(Lio/github/expo/pika/PType;ZLjava/util/List;Lio/github/expo/pika/PIntrospectionData;)V", "getParameters", "()Ljava/util/List;", "pika-api"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Parameterized extends Concrete {
            private final List<PTypeDescriptor> parameters;

            public /* synthetic */ Parameterized(PType pType, boolean z, List list, PIntrospectionData pIntrospectionData, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(pType, z, list, (i & 8) != 0 ? null : pIntrospectionData);
            }

            public final List<PTypeDescriptor> getParameters() {
                return this.parameters;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Parameterized(PType pType, boolean z, List<? extends PTypeDescriptor> parameters, PIntrospectionData<?> pIntrospectionData) {
                super(pType, z, pIntrospectionData);
                Intrinsics.checkNotNullParameter(pType, "pType");
                Intrinsics.checkNotNullParameter(parameters, "parameters");
                this.parameters = parameters;
            }
        }
    }

    /* JADX INFO: compiled from: PTypeDescriptor.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lio/github/expo/pika/PTypeDescriptor$Star;", "Lio/github/expo/pika/PTypeDescriptor;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "pika-api"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Star implements PTypeDescriptor {
        public static final Star INSTANCE = new Star();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Star)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1199262803;
        }

        public String toString() {
            return "Star";
        }

        private Star() {
        }
    }
}
