package androidx.compose.foundation;

import android.app.RemoteAction;
import android.graphics.RenderNode;
import android.hardware.camera2.MultiResolutionImageReader;
import android.hardware.camera2.params.MultiResolutionStreamConfigurationMap;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.EditorBoundsInfo;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import java.util.Collection;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PreferKeepClearNode$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ RemoteAction m(Object obj) {
        return (RemoteAction) obj;
    }

    public static /* synthetic */ RenderNode m(String str) {
        return new RenderNode(str);
    }

    public static /* synthetic */ MultiResolutionImageReader m(Collection collection, int i, int i2) {
        return new MultiResolutionImageReader(collection, i, i2);
    }

    public static /* synthetic */ MultiResolutionImageReader m(Collection collection, int i, int i2, long j) {
        return new MultiResolutionImageReader(collection, i, i2, j);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ WindowInsetsAnimationControlListener m1653m(Object obj) {
        return (WindowInsetsAnimationControlListener) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ WindowInsetsAnimationController m1654m(Object obj) {
        return (WindowInsetsAnimationController) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ DeleteGesture m1655m(Object obj) {
        return (DeleteGesture) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ DeleteRangeGesture m1656m(Object obj) {
        return (DeleteRangeGesture) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ EditorBoundsInfo.Builder m1657m() {
        return new EditorBoundsInfo.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ HandwritingGesture m1658m(Object obj) {
        return (HandwritingGesture) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ JoinOrSplitGesture m1659m(Object obj) {
        return (JoinOrSplitGesture) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ SelectRangeGesture m1660m(Object obj) {
        return (SelectRangeGesture) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m1663m() {
        return MultiResolutionStreamConfigurationMap.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m1671m() {
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m1677m(Object obj) {
        return obj instanceof SelectRangeGesture;
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m1678m$1() {
        return MultiResolutionImageReader.class;
    }

    public static /* bridge */ /* synthetic */ boolean m$1(Object obj) {
        return obj instanceof DeleteRangeGesture;
    }

    public static /* bridge */ /* synthetic */ Class m$2() {
        return SelectGesture.class;
    }

    public static /* bridge */ /* synthetic */ boolean m$2(Object obj) {
        return obj instanceof JoinOrSplitGesture;
    }

    public static /* bridge */ /* synthetic */ Class m$3() {
        return SelectRangeGesture.class;
    }

    public static /* bridge */ /* synthetic */ Class m$4() {
        return DeleteRangeGesture.class;
    }

    public static /* bridge */ /* synthetic */ Class m$5() {
        return DeleteGesture.class;
    }

    public static /* bridge */ /* synthetic */ Class m$6() {
        return JoinOrSplitGesture.class;
    }

    public static /* bridge */ /* synthetic */ Class m$7() {
        return InsertGesture.class;
    }

    public static /* bridge */ /* synthetic */ Class m$8() {
        return RemoveSpaceGesture.class;
    }
}
