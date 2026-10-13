package io.github.expo.pika;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PProperty.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003BW\b\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010$\u001a\u00028\u00012\u0006\u0010%\u001a\u00028\u0000¢\u0006\u0002\u0010&J\u001b\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u0001¢\u0006\u0002\u0010*R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\"R\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u0014\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\"¨\u0006+"}, d2 = {"Lio/github/expo/pika/PProperty;", "OwnerType", "Type", "", "name", "", "visibility", "Lio/github/expo/pika/PVisibility;", "annotations", "", "Lio/github/expo/pika/PAnnotation;", "type", "Lio/github/expo/pika/PTypeDescriptor;", FirebaseAnalytics.Param.INDEX, "", "accessor", "Lio/github/expo/pika/PPropertyAccessor;", "isMutable", "", "hasBackingField", "isDelegated", "<init>", "(Ljava/lang/String;Lio/github/expo/pika/PVisibility;[Lio/github/expo/pika/PAnnotation;Lio/github/expo/pika/PTypeDescriptor;ILio/github/expo/pika/PPropertyAccessor;ZZZ)V", "getName", "()Ljava/lang/String;", "getVisibility", "()Lio/github/expo/pika/PVisibility;", "getAnnotations", "()[Lio/github/expo/pika/PAnnotation;", "[Lio/github/expo/pika/PAnnotation;", "getType", "()Lio/github/expo/pika/PTypeDescriptor;", "getIndex", "()I", "()Z", "getHasBackingField", "get", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "set", "", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "pika-api"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PProperty<OwnerType, Type> {
    private final PPropertyAccessor accessor;
    private final PAnnotation[] annotations;
    private final boolean hasBackingField;
    private final int index;
    private final boolean isDelegated;
    private final boolean isMutable;
    private final String name;
    private final PTypeDescriptor type;
    private final PVisibility visibility;

    public PProperty(String name, PVisibility visibility, PAnnotation[] annotations, PTypeDescriptor type, int i, PPropertyAccessor accessor, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(accessor, "accessor");
        this.name = name;
        this.visibility = visibility;
        this.annotations = annotations;
        this.type = type;
        this.index = i;
        this.accessor = accessor;
        this.isMutable = z;
        this.hasBackingField = z2;
        this.isDelegated = z3;
    }

    public final String getName() {
        return this.name;
    }

    public final PVisibility getVisibility() {
        return this.visibility;
    }

    public final PAnnotation[] getAnnotations() {
        return this.annotations;
    }

    public final PTypeDescriptor getType() {
        return this.type;
    }

    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: isMutable, reason: from getter */
    public final boolean getIsMutable() {
        return this.isMutable;
    }

    public final boolean getHasBackingField() {
        return this.hasBackingField;
    }

    /* JADX INFO: renamed from: isDelegated, reason: from getter */
    public final boolean getIsDelegated() {
        return this.isDelegated;
    }

    public final Type get(OwnerType instance) {
        return (Type) this.accessor.__pika$PropertyGet(instance, this.index);
    }

    public final void set(OwnerType instance, Type value) {
        this.accessor.__pika$PropertySet(instance, this.index, value);
    }
}
