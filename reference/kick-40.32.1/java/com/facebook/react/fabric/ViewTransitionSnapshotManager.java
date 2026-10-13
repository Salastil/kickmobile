package com.facebook.react.fabric;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ViewTransitionSnapshotManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u000bH\u0003J\b\u0010\u0016\u001a\u00020\u0013H\u0003J\u0016\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nJ \u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003J\u0016\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\u0013J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020#H\u0016J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020#H\u0017J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020#H\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020#H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\f8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R,\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\f8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/facebook/react/fabric/ViewTransitionSnapshotManager;", "Lcom/facebook/react/bridge/UIManagerListener;", "uiManager", "Lcom/facebook/react/fabric/FabricUIManager;", "mountingManager", "Lcom/facebook/react/fabric/mounting/MountingManager;", "<init>", "(Lcom/facebook/react/fabric/FabricUIManager;Lcom/facebook/react/fabric/mounting/MountingManager;)V", "viewSnapshots", "Ljava/util/LinkedHashMap;", "", "Landroid/graphics/Bitmap;", "Lkotlin/collections/LinkedHashMap;", "pendingTargets", "listenerRegistered", "", "mainHandler", "Landroid/os/Handler;", "onBitmapCaptured", "", "reactTag", "bitmap", "ensureListenerRegistered", "captureViewSnapshot", "surfaceId", "captureHardwareBitmap", "view", "Landroid/view/View;", "window", "Landroid/view/Window;", "setViewSnapshot", "sourceTag", "targetTag", "clearPendingSnapshots", "willDispatchViewUpdates", "Lcom/facebook/react/bridge/UIManager;", "willMountItems", "didMountItems", "didDispatchMountItems", "didScheduleMountItems", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ViewTransitionSnapshotManager implements UIManagerListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean listenerRegistered;
    private final Handler mainHandler;
    private final MountingManager mountingManager;
    private final LinkedHashMap<Integer, Integer> pendingTargets;
    private final FabricUIManager uiManager;
    private final LinkedHashMap<Integer, Bitmap> viewSnapshots;

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didDispatchMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didScheduleMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willDispatchViewUpdates(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    public ViewTransitionSnapshotManager(FabricUIManager uiManager, MountingManager mountingManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        Intrinsics.checkNotNullParameter(mountingManager, "mountingManager");
        this.uiManager = uiManager;
        this.mountingManager = mountingManager;
        this.viewSnapshots = new LinkedHashMap<>();
        this.pendingTargets = new LinkedHashMap<>();
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: compiled from: ViewTransitionSnapshotManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"Lcom/facebook/react/fabric/ViewTransitionSnapshotManager$Companion;", "", "<init>", "()V", "captureSoftwareBitmap", "Landroid/graphics/Bitmap;", "view", "Landroid/view/View;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bitmap captureSoftwareBitmap(View view) {
            if (view.getWidth() <= 0 || view.getHeight() <= 0) {
                return null;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkExpressionValueIsNotNull(bitmapCreateBitmap, "Bitmap.createBitmap(width, height, config)");
            view.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        }
    }

    private final void onBitmapCaptured(int reactTag, Bitmap bitmap) {
        this.viewSnapshots.put(Integer.valueOf(reactTag), bitmap);
        if (this.pendingTargets.containsKey(Integer.valueOf(reactTag))) {
            ensureListenerRegistered();
        }
    }

    private final void ensureListenerRegistered() {
        if (this.listenerRegistered) {
            return;
        }
        this.listenerRegistered = true;
        this.uiManager.addUIManagerEventListener(this);
    }

    public final void captureViewSnapshot(final int reactTag, final int surfaceId) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.fabric.ViewTransitionSnapshotManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ViewTransitionSnapshotManager.captureViewSnapshot$lambda$2(this.f$0, surfaceId, reactTag);
            }
        });
    }

    static final void captureViewSnapshot$lambda$2(ViewTransitionSnapshotManager viewTransitionSnapshotManager, int i, int i2) {
        Activity currentActivity;
        SurfaceMountingManager surfaceManager = viewTransitionSnapshotManager.mountingManager.getSurfaceManager(i);
        if (surfaceManager != null && surfaceManager.getViewExists(i2)) {
            View view = surfaceManager.getView(i2);
            if (view.getWidth() <= 0 || view.getHeight() <= 0) {
                return;
            }
            if (!ReactNativeFeatureFlags.viewTransitionUseHardwareBitmapAndroid() || Build.VERSION.SDK_INT < 26) {
                Bitmap bitmapCaptureSoftwareBitmap = INSTANCE.captureSoftwareBitmap(view);
                if (bitmapCaptureSoftwareBitmap != null) {
                    viewTransitionSnapshotManager.onBitmapCaptured(i2, bitmapCaptureSoftwareBitmap);
                    return;
                }
                return;
            }
            Context context = view.getContext();
            Window window = null;
            ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
            if (reactContext != null && (currentActivity = reactContext.getCurrentActivity()) != null) {
                window = currentActivity.getWindow();
            }
            if (window == null) {
                Bitmap bitmapCaptureSoftwareBitmap2 = INSTANCE.captureSoftwareBitmap(view);
                if (bitmapCaptureSoftwareBitmap2 != null) {
                    viewTransitionSnapshotManager.onBitmapCaptured(i2, bitmapCaptureSoftwareBitmap2);
                    return;
                }
                return;
            }
            viewTransitionSnapshotManager.captureHardwareBitmap(view, i2, window);
        }
    }

    private final void captureHardwareBitmap(View view, int reactTag, Window window) {
        final ViewTransitionSnapshotManager viewTransitionSnapshotManager;
        final View view2;
        final int i;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        final int width = view.getWidth();
        final int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        int i2 = iArr[0];
        int i3 = iArr[1];
        Rect rect = new Rect(i2, i3, i2 + width, i3 + height);
        Rect rect2 = new Rect(RangesKt.coerceAtLeast(rect.left, 0), RangesKt.coerceAtLeast(rect.top, 0), RangesKt.coerceAtMost(rect.right, window.getDecorView().getWidth()), RangesKt.coerceAtMost(rect.bottom, window.getDecorView().getHeight()));
        if (rect2.isEmpty()) {
            return;
        }
        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkExpressionValueIsNotNull(bitmapCreateBitmap, "Bitmap.createBitmap(width, height, config)");
        final int i4 = rect2.left - rect.left;
        final int i5 = rect2.top - rect.top;
        try {
            viewTransitionSnapshotManager = this;
            view2 = view;
            i = reactTag;
            try {
                PixelCopy.request(window, rect2, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.facebook.react.fabric.ViewTransitionSnapshotManager$$ExternalSyntheticLambda3
                    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                    public final void onPixelCopyFinished(int i6) {
                        ViewTransitionSnapshotManager.captureHardwareBitmap$lambda$4(width, height, bitmapCreateBitmap, i4, i5, viewTransitionSnapshotManager, i, view2, i6);
                    }
                }, viewTransitionSnapshotManager.mainHandler);
            } catch (IllegalArgumentException unused) {
                bitmapCreateBitmap.recycle();
                Bitmap bitmapCaptureSoftwareBitmap = INSTANCE.captureSoftwareBitmap(view2);
                if (bitmapCaptureSoftwareBitmap != null) {
                    viewTransitionSnapshotManager.onBitmapCaptured(i, bitmapCaptureSoftwareBitmap);
                }
            }
        } catch (IllegalArgumentException unused2) {
            viewTransitionSnapshotManager = this;
            view2 = view;
            i = reactTag;
        }
    }

    public final void setViewSnapshot(final int sourceTag, final int targetTag) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.fabric.ViewTransitionSnapshotManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ViewTransitionSnapshotManager.setViewSnapshot$lambda$6(this.f$0, sourceTag, targetTag);
            }
        });
    }

    static final void setViewSnapshot$lambda$6(ViewTransitionSnapshotManager viewTransitionSnapshotManager, int i, int i2) {
        viewTransitionSnapshotManager.pendingTargets.put(Integer.valueOf(i), Integer.valueOf(i2));
        if (viewTransitionSnapshotManager.viewSnapshots.containsKey(Integer.valueOf(i))) {
            viewTransitionSnapshotManager.ensureListenerRegistered();
        }
    }

    public final void clearPendingSnapshots() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.fabric.ViewTransitionSnapshotManager$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                ViewTransitionSnapshotManager.clearPendingSnapshots$lambda$7(this.f$0);
            }
        });
    }

    static final void clearPendingSnapshots$lambda$7(ViewTransitionSnapshotManager viewTransitionSnapshotManager) {
        viewTransitionSnapshotManager.viewSnapshots.clear();
        viewTransitionSnapshotManager.pendingTargets.clear();
        if (viewTransitionSnapshotManager.listenerRegistered) {
            viewTransitionSnapshotManager.listenerRegistered = false;
            viewTransitionSnapshotManager.uiManager.removeUIManagerEventListener(viewTransitionSnapshotManager);
        }
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didMountItems(UIManager uiManager) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        for (Map.Entry<Integer, Integer> entry : this.pendingTargets.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            SurfaceMountingManager surfaceManagerForView = this.mountingManager.getSurfaceManagerForView(iIntValue2);
            if (surfaceManagerForView != null && (bitmap = this.viewSnapshots.get(Integer.valueOf(iIntValue))) != null) {
                surfaceManagerForView.applyViewSnapshot(iIntValue2, bitmap);
            }
        }
    }

    static final void captureHardwareBitmap$lambda$4(int i, int i2, Bitmap bitmap, int i3, int i4, ViewTransitionSnapshotManager viewTransitionSnapshotManager, int i5, View view, int i6) {
        if (i6 != 0) {
            bitmap.recycle();
            Bitmap bitmapCaptureSoftwareBitmap = INSTANCE.captureSoftwareBitmap(view);
            if (bitmapCaptureSoftwareBitmap != null) {
                viewTransitionSnapshotManager.onBitmapCaptured(i5, bitmapCaptureSoftwareBitmap);
                return;
            }
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Intrinsics.checkExpressionValueIsNotNull(bitmapCreateBitmap, "Bitmap.createBitmap(width, height, config)");
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, i3, i4, (Paint) null);
        bitmap.recycle();
        viewTransitionSnapshotManager.onBitmapCaptured(i5, bitmapCreateBitmap);
    }
}
