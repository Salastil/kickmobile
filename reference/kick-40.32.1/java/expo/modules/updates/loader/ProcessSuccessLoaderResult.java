package expo.modules.updates.loader;

import expo.modules.updates.db.entity.UpdateEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RemoteLoader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lexpo/modules/updates/loader/ProcessSuccessLoaderResult;", "", "availableUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "didRollBackToEmbedded", "", "<init>", "(Lexpo/modules/updates/db/entity/UpdateEntity;Z)V", "getAvailableUpdate", "()Lexpo/modules/updates/db/entity/UpdateEntity;", "getDidRollBackToEmbedded", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ProcessSuccessLoaderResult {
    private final UpdateEntity availableUpdate;
    private final boolean didRollBackToEmbedded;

    public static /* synthetic */ ProcessSuccessLoaderResult copy$default(ProcessSuccessLoaderResult processSuccessLoaderResult, UpdateEntity updateEntity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            updateEntity = processSuccessLoaderResult.availableUpdate;
        }
        if ((i & 2) != 0) {
            z = processSuccessLoaderResult.didRollBackToEmbedded;
        }
        return processSuccessLoaderResult.copy(updateEntity, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UpdateEntity getAvailableUpdate() {
        return this.availableUpdate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getDidRollBackToEmbedded() {
        return this.didRollBackToEmbedded;
    }

    public final ProcessSuccessLoaderResult copy(UpdateEntity availableUpdate, boolean didRollBackToEmbedded) {
        return new ProcessSuccessLoaderResult(availableUpdate, didRollBackToEmbedded);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcessSuccessLoaderResult)) {
            return false;
        }
        ProcessSuccessLoaderResult processSuccessLoaderResult = (ProcessSuccessLoaderResult) other;
        return Intrinsics.areEqual(this.availableUpdate, processSuccessLoaderResult.availableUpdate) && this.didRollBackToEmbedded == processSuccessLoaderResult.didRollBackToEmbedded;
    }

    public int hashCode() {
        UpdateEntity updateEntity = this.availableUpdate;
        return ((updateEntity == null ? 0 : updateEntity.hashCode()) * 31) + Boolean.hashCode(this.didRollBackToEmbedded);
    }

    public String toString() {
        return "ProcessSuccessLoaderResult(availableUpdate=" + this.availableUpdate + ", didRollBackToEmbedded=" + this.didRollBackToEmbedded + ")";
    }

    public ProcessSuccessLoaderResult(UpdateEntity updateEntity, boolean z) {
        this.availableUpdate = updateEntity;
        this.didRollBackToEmbedded = z;
    }

    public final UpdateEntity getAvailableUpdate() {
        return this.availableUpdate;
    }

    public final boolean getDidRollBackToEmbedded() {
        return this.didRollBackToEmbedded;
    }
}
