package expo.modules.easclient;

import android.content.Context;
import android.content.SharedPreferences;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.notifications.serverregistration.InstallationId;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EASClientID.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lexpo/modules/easclient/EASClientID;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", InstallationId.LEGACY_PREFERENCES_UUID_KEY, "Ljava/util/UUID;", "getUuid", "()Ljava/util/UUID;", "uuid$delegate", "Lkotlin/Lazy;", "Companion", "expo-eas-client_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EASClientID {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;

    /* JADX INFO: renamed from: uuid$delegate, reason: from kotlin metadata */
    private final Lazy uuid;

    /* JADX INFO: compiled from: EASClientID.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/easclient/EASClientID$Companion;", "", "<init>", "()V", "deterministicUniformValue", "", InstallationId.LEGACY_PREFERENCES_UUID_KEY, "Ljava/util/UUID;", "expo-eas-client_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final double deterministicUniformValue(UUID uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            long jM12867constructorimpl = ULong.m12867constructorimpl(uuid.getLeastSignificantBits() ^ uuid.getMostSignificantBits());
            long jM12867constructorimpl2 = ULong.m12867constructorimpl(ULong.m12867constructorimpl(jM12867constructorimpl ^ ULong.m12867constructorimpl(jM12867constructorimpl >>> 30)) * (-4658895280553007687L));
            long jM12867constructorimpl3 = ULong.m12867constructorimpl(ULong.m12867constructorimpl(jM12867constructorimpl2 ^ ULong.m12867constructorimpl(jM12867constructorimpl2 >>> 27)) * (-7723592293110705685L));
            return UnsignedKt.ulongToDouble(ULong.m12867constructorimpl(ULong.m12867constructorimpl(jM12867constructorimpl3 ^ ULong.m12867constructorimpl(jM12867constructorimpl3 >>> 31)) >>> 11)) / 9.007199254740992E15d;
        }
    }

    public EASClientID(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.uuid = LazyKt.lazy(new Function0() { // from class: expo.modules.easclient.EASClientID$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EASClientID.uuid_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final UUID getUuid() {
        Object value = this.uuid.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (UUID) value;
    }

    static final UUID uuid_delegate$lambda$0(EASClientID eASClientID) {
        SharedPreferences sharedPreferences = eASClientID.context.getSharedPreferences("dev.expo.EASSharedPreferences", 0);
        String string = sharedPreferences.getString("eas-client-id", null);
        if (string == null) {
            string = UUID.randomUUID().toString();
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("eas-client-id", string);
            editorEdit.apply();
        }
        return UUID.fromString(string);
    }
}
