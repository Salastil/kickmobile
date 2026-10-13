package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.FabricUIManagerBinding;
import com.facebook.react.fabric.mounting.MountingManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PullTransactionMountItem.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/react/fabric/mounting/mountitems/PullTransactionMountItem;", "Lcom/facebook/react/fabric/mounting/mountitems/MountItem;", "surfaceId", "", "binding", "Lcom/facebook/react/fabric/FabricUIManagerBinding;", "<init>", "(ILcom/facebook/react/fabric/FabricUIManagerBinding;)V", "execute", "", "mountingManager", "Lcom/facebook/react/fabric/mounting/MountingManager;", "getSurfaceId", "toString", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PullTransactionMountItem implements MountItem {
    private final FabricUIManagerBinding binding;
    private final int surfaceId;

    public PullTransactionMountItem(int i, FabricUIManagerBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.surfaceId = i;
        this.binding = binding;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        Intrinsics.checkNotNullParameter(mountingManager, "mountingManager");
        this.binding.pullAndExecuteTransaction(this.surfaceId);
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public int getSurfaceId() {
        return this.surfaceId;
    }

    public String toString() {
        return "PullTransactionMountItem [surfaceId: " + this.surfaceId + "]";
    }
}
