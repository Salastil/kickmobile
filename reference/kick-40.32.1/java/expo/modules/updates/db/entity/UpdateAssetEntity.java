package expo.modules.updates.db.entity;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateAssetEntity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lexpo/modules/updates/db/entity/UpdateAssetEntity;", "", "updateId", "Ljava/util/UUID;", "assetId", "", "<init>", "(Ljava/util/UUID;J)V", "getUpdateId", "()Ljava/util/UUID;", "setUpdateId", "(Ljava/util/UUID;)V", "getAssetId", "()J", "setAssetId", "(J)V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdateAssetEntity {
    private long assetId;
    private UUID updateId;

    public UpdateAssetEntity(UUID updateId, long j) {
        Intrinsics.checkNotNullParameter(updateId, "updateId");
        this.updateId = updateId;
        this.assetId = j;
    }

    public final UUID getUpdateId() {
        return this.updateId;
    }

    public final void setUpdateId(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "<set-?>");
        this.updateId = uuid;
    }

    public final long getAssetId() {
        return this.assetId;
    }

    public final void setAssetId(long j) {
        this.assetId = j;
    }
}
