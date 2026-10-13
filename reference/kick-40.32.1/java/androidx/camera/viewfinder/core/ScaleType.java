package androidx.camera.viewfinder.core;

import androidx.camera.viewfinder.core.impl.Alignment;
import androidx.camera.viewfinder.core.impl.ContentScale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ScaleType.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Landroidx/camera/viewfinder/core/ScaleType;", "", "id", "", "contentScale", "Landroidx/camera/viewfinder/core/impl/ContentScale;", "alignment", "Landroidx/camera/viewfinder/core/impl/Alignment;", "<init>", "(Ljava/lang/String;IILandroidx/camera/viewfinder/core/impl/ContentScale;Landroidx/camera/viewfinder/core/impl/Alignment;)V", "getId", "()I", "getContentScale$viewfinder_core_release", "()Landroidx/camera/viewfinder/core/impl/ContentScale;", "getAlignment$viewfinder_core_release", "()Landroidx/camera/viewfinder/core/impl/Alignment;", "FILL_START", "FILL_CENTER", "FILL_END", "FIT_START", "FIT_CENTER", "FIT_END", "Companion", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum ScaleType {
    FILL_START(0, ScaleTypeKt.Fill, ScaleTypeKt.Start),
    FILL_CENTER(1, ScaleTypeKt.Fill, ScaleTypeKt.Center),
    FILL_END(2, ScaleTypeKt.Fill, ScaleTypeKt.End),
    FIT_START(3, ScaleTypeKt.Fit, ScaleTypeKt.Start),
    FIT_CENTER(4, ScaleTypeKt.Fit, ScaleTypeKt.Center),
    FIT_END(5, ScaleTypeKt.Fit, ScaleTypeKt.End);

    private final Alignment alignment;
    private final ContentScale contentScale;
    private final int id;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final ScaleType fromId(int i) {
        return INSTANCE.fromId(i);
    }

    public static EnumEntries<ScaleType> getEntries() {
        return $ENTRIES;
    }

    ScaleType(int i, ContentScale contentScale, Alignment alignment) {
        this.id = i;
        this.contentScale = contentScale;
        this.alignment = alignment;
    }

    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: getContentScale$viewfinder_core_release, reason: from getter */
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    /* JADX INFO: renamed from: getAlignment$viewfinder_core_release, reason: from getter */
    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* JADX INFO: compiled from: ScaleType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/viewfinder/core/ScaleType$Companion;", "", "<init>", "()V", "fromId", "Landroidx/camera/viewfinder/core/ScaleType;", "id", "", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ScaleType fromId(int id) {
            for (ScaleType scaleType : ScaleType.values()) {
                if (scaleType.getId() == id) {
                    return scaleType;
                }
            }
            throw new IllegalArgumentException("Unknown scale type id " + id);
        }
    }
}
