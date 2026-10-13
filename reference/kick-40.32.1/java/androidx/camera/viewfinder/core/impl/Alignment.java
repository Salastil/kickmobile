package androidx.camera.viewfinder.core.impl;

import android.util.SizeF;
import com.facebook.react.uimanager.ViewProps;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

/* JADX INFO: compiled from: Transformations.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/camera/viewfinder/core/impl/Alignment;", "", "align", "Landroidx/camera/viewfinder/core/impl/OffsetF;", ContentDisposition.Parameters.Size, "Landroid/util/SizeF;", "space", ViewProps.LAYOUT_DIRECTION, "", "align-41g9ag8", "(Landroid/util/SizeF;Landroid/util/SizeF;I)J", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Alignment {
    /* JADX INFO: renamed from: align-41g9ag8 */
    long mo1259align41g9ag8(SizeF size, SizeF space, int layoutDirection);
}
