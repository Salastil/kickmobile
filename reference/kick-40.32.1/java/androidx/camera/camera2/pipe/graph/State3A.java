package androidx.camera.camera2.pipe.graph;

import android.hardware.camera2.params.MeteringRectangle;
import androidx.camera.camera2.pipe.AeMode;
import androidx.camera.camera2.pipe.AfMode;
import androidx.camera.camera2.pipe.AwbMode;
import androidx.camera.camera2.pipe.FlashMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GraphState3A.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\b'J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\b)J\u0010\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\b+J\u0010\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\b-J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00102\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00103\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\"J\u009a\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b5\u00106J\u0014\u00107\u001a\u00020\u00102\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00109\u001a\u00020:HÖ\u0081\u0004J\n\u0010;\u001a\u00020<HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010#\u001a\u0004\b%\u0010\"¨\u0006="}, d2 = {"Landroidx/camera/camera2/pipe/graph/State3A;", "", "aeMode", "Landroidx/camera/camera2/pipe/AeMode;", "afMode", "Landroidx/camera/camera2/pipe/AfMode;", "awbMode", "Landroidx/camera/camera2/pipe/AwbMode;", "flashMode", "Landroidx/camera/camera2/pipe/FlashMode;", "aeRegions", "", "Landroid/hardware/camera2/params/MeteringRectangle;", "afRegions", "awbRegions", "aeLock", "", "afLock", "awbLock", "<init>", "(Landroidx/camera/camera2/pipe/AeMode;Landroidx/camera/camera2/pipe/AfMode;Landroidx/camera/camera2/pipe/AwbMode;Landroidx/camera/camera2/pipe/FlashMode;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAeMode-O_cDUUs", "()Landroidx/camera/camera2/pipe/AeMode;", "getAfMode-32_E3BI", "()Landroidx/camera/camera2/pipe/AfMode;", "getAwbMode-aLFtWSU", "()Landroidx/camera/camera2/pipe/AwbMode;", "getFlashMode-cL-19HE", "()Landroidx/camera/camera2/pipe/FlashMode;", "getAeRegions", "()Ljava/util/List;", "getAfRegions", "getAwbRegions", "getAeLock", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAfLock", "getAwbLock", "component1", "component1-O_cDUUs", "component2", "component2-32_E3BI", "component3", "component3-aLFtWSU", "component4", "component4-cL-19HE", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "copy-7jOEVJU", "(Landroidx/camera/camera2/pipe/AeMode;Landroidx/camera/camera2/pipe/AfMode;Landroidx/camera/camera2/pipe/AwbMode;Landroidx/camera/camera2/pipe/FlashMode;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Landroidx/camera/camera2/pipe/graph/State3A;", "equals", "other", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class State3A {
    private final Boolean aeLock;
    private final AeMode aeMode;
    private final List<MeteringRectangle> aeRegions;
    private final Boolean afLock;
    private final AfMode afMode;
    private final List<MeteringRectangle> afRegions;
    private final Boolean awbLock;
    private final AwbMode awbMode;
    private final List<MeteringRectangle> awbRegions;
    private final FlashMode flashMode;

    public /* synthetic */ State3A(AeMode aeMode, AfMode afMode, AwbMode awbMode, FlashMode flashMode, List list, List list2, List list3, Boolean bool, Boolean bool2, Boolean bool3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aeMode, afMode, awbMode, flashMode, list, list2, list3, bool, bool2, bool3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-7jOEVJU$default, reason: not valid java name */
    public static /* synthetic */ State3A m975copy7jOEVJU$default(State3A state3A, AeMode aeMode, AfMode afMode, AwbMode awbMode, FlashMode flashMode, List list, List list2, List list3, Boolean bool, Boolean bool2, Boolean bool3, int i, Object obj) {
        if ((i & 1) != 0) {
            aeMode = state3A.aeMode;
        }
        if ((i & 2) != 0) {
            afMode = state3A.afMode;
        }
        if ((i & 4) != 0) {
            awbMode = state3A.awbMode;
        }
        if ((i & 8) != 0) {
            flashMode = state3A.flashMode;
        }
        if ((i & 16) != 0) {
            list = state3A.aeRegions;
        }
        if ((i & 32) != 0) {
            list2 = state3A.afRegions;
        }
        if ((i & 64) != 0) {
            list3 = state3A.awbRegions;
        }
        if ((i & 128) != 0) {
            bool = state3A.aeLock;
        }
        if ((i & 256) != 0) {
            bool2 = state3A.afLock;
        }
        if ((i & 512) != 0) {
            bool3 = state3A.awbLock;
        }
        Boolean bool4 = bool2;
        Boolean bool5 = bool3;
        List list4 = list3;
        Boolean bool6 = bool;
        List list5 = list;
        List list6 = list2;
        return state3A.m980copy7jOEVJU(aeMode, afMode, awbMode, flashMode, list5, list6, list4, bool6, bool4, bool5);
    }

    /* JADX INFO: renamed from: component1-O_cDUUs, reason: not valid java name and from getter */
    public final AeMode getAeMode() {
        return this.aeMode;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Boolean getAwbLock() {
        return this.awbLock;
    }

    /* JADX INFO: renamed from: component2-32_E3BI, reason: not valid java name and from getter */
    public final AfMode getAfMode() {
        return this.afMode;
    }

    /* JADX INFO: renamed from: component3-aLFtWSU, reason: not valid java name and from getter */
    public final AwbMode getAwbMode() {
        return this.awbMode;
    }

    /* JADX INFO: renamed from: component4-cL-19HE, reason: not valid java name and from getter */
    public final FlashMode getFlashMode() {
        return this.flashMode;
    }

    public final List<MeteringRectangle> component5() {
        return this.aeRegions;
    }

    public final List<MeteringRectangle> component6() {
        return this.afRegions;
    }

    public final List<MeteringRectangle> component7() {
        return this.awbRegions;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getAeLock() {
        return this.aeLock;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getAfLock() {
        return this.afLock;
    }

    /* JADX INFO: renamed from: copy-7jOEVJU, reason: not valid java name */
    public final State3A m980copy7jOEVJU(AeMode aeMode, AfMode afMode, AwbMode awbMode, FlashMode flashMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions, Boolean aeLock, Boolean afLock, Boolean awbLock) {
        return new State3A(aeMode, afMode, awbMode, flashMode, aeRegions, afRegions, awbRegions, aeLock, afLock, awbLock, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof State3A)) {
            return false;
        }
        State3A state3A = (State3A) other;
        return Intrinsics.areEqual(this.aeMode, state3A.aeMode) && Intrinsics.areEqual(this.afMode, state3A.afMode) && Intrinsics.areEqual(this.awbMode, state3A.awbMode) && Intrinsics.areEqual(this.flashMode, state3A.flashMode) && Intrinsics.areEqual(this.aeRegions, state3A.aeRegions) && Intrinsics.areEqual(this.afRegions, state3A.afRegions) && Intrinsics.areEqual(this.awbRegions, state3A.awbRegions) && Intrinsics.areEqual(this.aeLock, state3A.aeLock) && Intrinsics.areEqual(this.afLock, state3A.afLock) && Intrinsics.areEqual(this.awbLock, state3A.awbLock);
    }

    public int hashCode() {
        AeMode aeMode = this.aeMode;
        int iM157hashCodeimpl = (aeMode == null ? 0 : AeMode.m157hashCodeimpl(aeMode.m160unboximpl())) * 31;
        AfMode afMode = this.afMode;
        int iM175hashCodeimpl = (iM157hashCodeimpl + (afMode == null ? 0 : AfMode.m175hashCodeimpl(afMode.m179unboximpl()))) * 31;
        AwbMode awbMode = this.awbMode;
        int iM202hashCodeimpl = (iM175hashCodeimpl + (awbMode == null ? 0 : AwbMode.m202hashCodeimpl(awbMode.m205unboximpl()))) * 31;
        FlashMode flashMode = this.flashMode;
        int iM484hashCodeimpl = (iM202hashCodeimpl + (flashMode == null ? 0 : FlashMode.m484hashCodeimpl(flashMode.m486unboximpl()))) * 31;
        List<MeteringRectangle> list = this.aeRegions;
        int iHashCode = (iM484hashCodeimpl + (list == null ? 0 : list.hashCode())) * 31;
        List<MeteringRectangle> list2 = this.afRegions;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MeteringRectangle> list3 = this.awbRegions;
        int iHashCode3 = (iHashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Boolean bool = this.aeLock;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.afLock;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.awbLock;
        return iHashCode5 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        return "State3A(aeMode=" + this.aeMode + ", afMode=" + this.afMode + ", awbMode=" + this.awbMode + ", flashMode=" + this.flashMode + ", aeRegions=" + this.aeRegions + ", afRegions=" + this.afRegions + ", awbRegions=" + this.awbRegions + ", aeLock=" + this.aeLock + ", afLock=" + this.afLock + ", awbLock=" + this.awbLock + ')';
    }

    private State3A(AeMode aeMode, AfMode afMode, AwbMode awbMode, FlashMode flashMode, List<MeteringRectangle> list, List<MeteringRectangle> list2, List<MeteringRectangle> list3, Boolean bool, Boolean bool2, Boolean bool3) {
        this.aeMode = aeMode;
        this.afMode = afMode;
        this.awbMode = awbMode;
        this.flashMode = flashMode;
        this.aeRegions = list;
        this.afRegions = list2;
        this.awbRegions = list3;
        this.aeLock = bool;
        this.afLock = bool2;
        this.awbLock = bool3;
    }

    public /* synthetic */ State3A(AeMode aeMode, AfMode afMode, AwbMode awbMode, FlashMode flashMode, List list, List list2, List list3, Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : aeMode, (i & 2) != 0 ? null : afMode, (i & 4) != 0 ? null : awbMode, (i & 8) != 0 ? null : flashMode, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : list2, (i & 64) != 0 ? null : list3, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : bool2, (i & 512) != 0 ? null : bool3, null);
    }

    /* JADX INFO: renamed from: getAeMode-O_cDUUs, reason: not valid java name */
    public final AeMode m981getAeModeO_cDUUs() {
        return this.aeMode;
    }

    /* JADX INFO: renamed from: getAfMode-32_E3BI, reason: not valid java name */
    public final AfMode m982getAfMode32_E3BI() {
        return this.afMode;
    }

    /* JADX INFO: renamed from: getAwbMode-aLFtWSU, reason: not valid java name */
    public final AwbMode m983getAwbModeaLFtWSU() {
        return this.awbMode;
    }

    /* JADX INFO: renamed from: getFlashMode-cL-19HE, reason: not valid java name */
    public final FlashMode m984getFlashModecL19HE() {
        return this.flashMode;
    }

    public final List<MeteringRectangle> getAeRegions() {
        return this.aeRegions;
    }

    public final List<MeteringRectangle> getAfRegions() {
        return this.afRegions;
    }

    public final List<MeteringRectangle> getAwbRegions() {
        return this.awbRegions;
    }

    public final Boolean getAeLock() {
        return this.aeLock;
    }

    public final Boolean getAfLock() {
        return this.afLock;
    }

    public final Boolean getAwbLock() {
        return this.awbLock;
    }
}
