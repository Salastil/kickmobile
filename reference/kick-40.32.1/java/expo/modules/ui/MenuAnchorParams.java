package expo.modules.ui;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModifierRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lexpo/modules/ui/MenuAnchorParams;", "Lexpo/modules/kotlin/records/Record;", "type", "Lexpo/modules/ui/MenuAnchorType;", "enabled", "", "<init>", "(Lexpo/modules/ui/MenuAnchorType;Z)V", "getType$annotations", "()V", "getType", "()Lexpo/modules/ui/MenuAnchorType;", "getEnabled$annotations", "getEnabled", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MenuAnchorParams implements Record {
    public static final int $stable = 0;
    private final boolean enabled;
    private final MenuAnchorType type;

    /* JADX WARN: Multi-variable type inference failed */
    public MenuAnchorParams() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MenuAnchorParams copy$default(MenuAnchorParams menuAnchorParams, MenuAnchorType menuAnchorType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            menuAnchorType = menuAnchorParams.type;
        }
        if ((i & 2) != 0) {
            z = menuAnchorParams.enabled;
        }
        return menuAnchorParams.copy(menuAnchorType, z);
    }

    @Field
    public static /* synthetic */ void getEnabled$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MenuAnchorType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final MenuAnchorParams copy(MenuAnchorType type, boolean enabled) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new MenuAnchorParams(type, enabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MenuAnchorParams)) {
            return false;
        }
        MenuAnchorParams menuAnchorParams = (MenuAnchorParams) other;
        return this.type == menuAnchorParams.type && this.enabled == menuAnchorParams.enabled;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + Boolean.hashCode(this.enabled);
    }

    public String toString() {
        return "MenuAnchorParams(type=" + this.type + ", enabled=" + this.enabled + ")";
    }

    public MenuAnchorParams(MenuAnchorType type, boolean z) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.enabled = z;
    }

    public /* synthetic */ MenuAnchorParams(MenuAnchorType menuAnchorType, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MenuAnchorType.PRIMARY_NOT_EDITABLE : menuAnchorType, (i & 2) != 0 ? true : z);
    }

    public final MenuAnchorType getType() {
        return this.type;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }
}
