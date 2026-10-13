package androidx.compose.foundation.layout;

import androidx.collection.MutableLongList;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpRect;
import com.facebook.react.uimanager.ViewProps;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.crypto.CryptoServicesPermission;

/* JADX INFO: compiled from: Grid.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012H\u0016¢\u0006\u0004\b%\u0010\u0016J\u0017\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010)\u001a\u00020*H\u0016J\u0017\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012H\u0016¢\u0006\u0004\b/\u0010\u0016J\u0017\u0010.\u001a\u00020#2\u0006\u0010&\u001a\u00020'H\u0016¢\u0006\u0004\b0\u0010\u0016J\u0010\u0010.\u001a\u00020#2\u0006\u0010)\u001a\u00020*H\u0016J\u0017\u0010.\u001a\u00020#2\u0006\u0010$\u001a\u00020+H\u0016¢\u0006\u0004\b1\u0010-J\u0017\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\u0012H\u0016¢\u0006\u0004\b4\u0010\u0016J\u001f\u00102\u001a\u00020#2\u0006\u0010.\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012H\u0016¢\u0006\u0004\b5\u00106J\u0017\u0010\u0011\u001a\u00020#2\u0006\u00102\u001a\u00020\u0012H\u0016¢\u0006\u0004\b7\u0010\u0016J\u0017\u0010\u0018\u001a\u00020#2\u0006\u00102\u001a\u00020\u0012H\u0016¢\u0006\u0004\b8\u0010\u0016J\u0014\u00109\u001a\u00020:*\u00020\u0012H\u0097\u0001¢\u0006\u0004\b;\u0010<J\u0014\u00109\u001a\u00020:*\u00020=H\u0097\u0001¢\u0006\u0004\b>\u0010?J\u0014\u0010@\u001a\u00020\u0012*\u00020:H\u0097\u0001¢\u0006\u0004\bA\u0010BJ\u0014\u0010@\u001a\u00020\u0012*\u00020*H\u0097\u0001¢\u0006\u0004\bA\u0010CJ\u0014\u0010@\u001a\u00020\u0012*\u00020=H\u0097\u0001¢\u0006\u0004\bD\u0010EJ\u0014\u0010F\u001a\u00020G*\u00020HH\u0097\u0001¢\u0006\u0004\bI\u0010JJ\u0014\u0010K\u001a\u00020**\u00020\u0012H\u0097\u0001¢\u0006\u0004\bL\u0010CJ\u0014\u0010K\u001a\u00020**\u00020=H\u0097\u0001¢\u0006\u0004\bM\u0010EJ\r\u0010N\u001a\u00020O*\u00020PH\u0097\u0001J\u0014\u0010Q\u001a\u00020H*\u00020GH\u0097\u0001¢\u0006\u0004\bR\u0010JJ\u0014\u0010S\u001a\u00020=*\u00020:H\u0097\u0001¢\u0006\u0004\bT\u0010UJ\u0014\u0010S\u001a\u00020=*\u00020*H\u0097\u0001¢\u0006\u0004\bT\u0010VJ\u0014\u0010S\u001a\u00020=*\u00020\u0012H\u0097\u0001¢\u0006\u0004\bW\u0010VR\u0016\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u00020\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001c\u0010\u001b\u001a\u00020\u001cX\u0096\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010\u0003\u001a\u00020*8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bX\u0010\u0014R\u0014\u0010Y\u001a\u00020*8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bZ\u0010\u0014¨\u0006["}, d2 = {"Landroidx/compose/foundation/layout/GridConfigurationScopeImpl;", "Landroidx/compose/foundation/layout/GridConfigurationScope;", "Landroidx/compose/ui/unit/Density;", "density", CryptoServicesPermission.CONSTRAINTS, "Landroidx/compose/ui/unit/Constraints;", "<init>", "(Landroidx/compose/ui/unit/Density;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "columnSpecs", "Landroidx/collection/MutableLongList;", "getColumnSpecs", "()Landroidx/collection/MutableLongList;", "rowSpecs", "getRowSpecs", ViewProps.COLUMN_GAP, "Landroidx/compose/ui/unit/Dp;", "getColumnGap-D9Ej5fM", "()F", "setColumnGap-0680j_4", "(F)V", "F", ViewProps.ROW_GAP, "getRowGap-D9Ej5fM", "setRowGap-0680j_4", "flow", "Landroidx/compose/foundation/layout/GridFlow;", "getFlow-ITJdzs4", "()I", "setFlow-4t4_IgM", "(I)V", "I", "column", "", ContentDisposition.Parameters.Size, "column-0680j_4", "weight", "Landroidx/compose/foundation/layout/Fr;", "column-XZblgos", "percentage", "", "Landroidx/compose/foundation/layout/GridTrackSize;", "column-118E5d0", "(J)V", "row", "row-0680j_4", "row-XZblgos", "row-118E5d0", ViewProps.GAP, "all", "gap-0680j_4", "gap-YgX7TsA", "(FF)V", "columnGap-0680j_4", "rowGap-0680j_4", "roundToPx", "", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "(F)F", "toDp-GaN1DYA", "(J)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toSp-0xMU5do", "getDensity", "fontScale", "getFontScale", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class GridConfigurationScopeImpl implements GridConfigurationScope, Density {
    private final /* synthetic */ Density $$delegate_0;
    private float columnGap;
    private final MutableLongList columnSpecs;
    private final long constraints;
    private int flow;
    private float rowGap;
    private final MutableLongList rowSpecs;

    public /* synthetic */ GridConfigurationScopeImpl(Density density, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(density, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: getDensity */
    public float get_density() {
        return this.$$delegate_0.get_density();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: getFontScale */
    public float get_fontScale() {
        return this.$$delegate_0.get_fontScale();
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public int mo1727roundToPxR2X_6o(long j) {
        return this.$$delegate_0.mo1727roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public int mo1728roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo1728roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public float mo1729toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo1729toDpGaN1DYA(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo1730toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo1730toDpu2uoSUM(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo1731toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo1731toDpu2uoSUM(i);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public long mo1732toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo1732toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public float mo1733toPxR2X_6o(long j) {
        return this.$$delegate_0.mo1733toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public float mo1734toPx0680j_4(float f) {
        return this.$$delegate_0.mo1734toPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    public Rect toRect(DpRect dpRect) {
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public long mo1735toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo1735toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public long mo1736toSp0xMU5do(float f) {
        return this.$$delegate_0.mo1736toSp0xMU5do(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo1737toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo1737toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo1738toSpkPz2Gy4(int i) {
        return this.$$delegate_0.mo1738toSpkPz2Gy4(i);
    }

    private GridConfigurationScopeImpl(Density density, long j) {
        this.$$delegate_0 = density;
        this.constraints = j;
        this.columnSpecs = new MutableLongList(0, 1, null);
        this.rowSpecs = new MutableLongList(0, 1, null);
        this.columnGap = Dp.m10168constructorimpl(0.0f);
        this.rowGap = Dp.m10168constructorimpl(0.0f);
        GridFlow.Companion companion = GridFlow.INSTANCE;
        this.flow = GridFlow.m2261constructorimpl(0);
    }

    @Override // androidx.compose.foundation.layout.GridConfigurationScope
    /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: from getter */
    public long getConstraints() {
        return this.constraints;
    }

    public final MutableLongList getColumnSpecs() {
        return this.columnSpecs;
    }

    public final MutableLongList getRowSpecs() {
        return this.rowSpecs;
    }

    /* JADX INFO: renamed from: getColumnGap-D9Ej5fM, reason: not valid java name and from getter */
    public final float getColumnGap() {
        return this.columnGap;
    }

    /* JADX INFO: renamed from: setColumnGap-0680j_4, reason: not valid java name */
    public final void m2258setColumnGap0680j_4(float f) {
        this.columnGap = f;
    }

    /* JADX INFO: renamed from: getRowGap-D9Ej5fM, reason: not valid java name and from getter */
    public final float getRowGap() {
        return this.rowGap;
    }

    /* JADX INFO: renamed from: setRowGap-0680j_4, reason: not valid java name */
    public final void m2259setRowGap0680j_4(float f) {
        this.rowGap = f;
    }

    @Override // androidx.compose.foundation.layout.GridConfigurationScope
    /* JADX INFO: renamed from: getFlow-ITJdzs4, reason: from getter */
    public int getFlow() {
        return this.flow;
    }

    @Override // androidx.compose.foundation.layout.GridConfigurationScope
    /* JADX INFO: renamed from: setFlow-4t4_IgM */
    public void mo2255setFlow4t4_IgM(int i) {
        this.flow = i;
    }

    @Override // androidx.compose.foundation.layout.GridConfigurationScope
    /* JADX INFO: renamed from: column-0680j_4 */
    public void mo2239column0680j_4(float size) {
        mo2240column118E5d0(GridTrackSize.INSTANCE.m2292FixedpsSkOvk(size));
    }

    @Override // androidx.compose.foundation.layout.GridConfigurationScope
    /* JADX INFO: renamed from: column-XZblgos */
    public void mo2241columnXZblgos(float weight) {
        mo2240column118E5d0(GridTrackSize.INSTANCE.m2293FlexKGB9zo8(weight));
    }

    @Override // androidx.compose.foundation.layout.GridConfigurationScope
    public void column(float percentage) {
        mo2240column118E5d0(GridTrackSize.INSTANCE.m2295Percentage9Tp3RV8(percentage));
    }

    @Override // androidx.compose.foundation.layout.GridConfigurationScope
    /* JADX INFO: renamed from: column-118E5d0 */
    public void mo2240column118E5d0(long size) {
        this.columnSpecs.add(size);
    }

    @Override // androidx.compose.foundation.layout.GridConfigurationScope
    /* JADX INFO: renamed from: row-0680j_4 */
    public void mo2251row0680j_4(float size) {
        mo2252row118E5d0(GridTrackSize.INSTANCE.m2292FixedpsSkOvk(size));
    }

    @Override // androidx.compose.foundation.layout.GridConfigurationScope
    /* JADX INFO: renamed from: row-XZblgos */
    public void mo2253rowXZblgos(float weight) {
        mo2252row118E5d0(GridTrackSize.INSTANCE.m2293FlexKGB9zo8(weight));
    }

    @Override // androidx.compose.foundation.layout.GridConfigurationScope
    public void row(float percentage) {
        mo2252row118E5d0(GridTrackSize.INSTANCE.m2295Percentage9Tp3RV8(percentage));
    }

    @Override // androidx.compose.foundation.layout.GridConfigurationScope
    /* JADX INFO: renamed from: row-118E5d0 */
    public void mo2252row118E5d0(long size) {
        this.rowSpecs.add(size);
    }

    @Override // androidx.compose.foundation.layout.GridConfigurationScope
    /* JADX INFO: renamed from: gap-0680j_4 */
    public void mo2243gap0680j_4(float all) {
        if (all < 0.0f) {
            throw new IllegalArgumentException("Gap must be non-negative".toString());
        }
        this.columnGap = all;
        this.rowGap = all;
    }

    @Override // androidx.compose.foundation.layout.GridConfigurationScope
    /* JADX INFO: renamed from: gap-YgX7TsA */
    public void mo2244gapYgX7TsA(float row, float column) {
        if (row < 0.0f) {
            throw new IllegalArgumentException("Row gap must be non-negative".toString());
        }
        if (column < 0.0f) {
            throw new IllegalArgumentException("Column gap must be non-negative".toString());
        }
        this.rowGap = row;
        this.columnGap = column;
    }

    @Override // androidx.compose.foundation.layout.GridConfigurationScope
    /* JADX INFO: renamed from: columnGap-0680j_4 */
    public void mo2242columnGap0680j_4(float gap) {
        if (gap < 0.0f) {
            throw new IllegalArgumentException("Column gap must be non-negative".toString());
        }
        this.columnGap = gap;
    }

    @Override // androidx.compose.foundation.layout.GridConfigurationScope
    /* JADX INFO: renamed from: rowGap-0680j_4 */
    public void mo2254rowGap0680j_4(float gap) {
        if (gap < 0.0f) {
            throw new IllegalArgumentException("Row gap must be non-negative".toString());
        }
        this.rowGap = gap;
    }
}
