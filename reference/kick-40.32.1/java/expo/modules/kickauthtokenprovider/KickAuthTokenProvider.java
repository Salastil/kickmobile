package expo.modules.kickauthtokenprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KickAuthTokenProvider.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J1\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0010\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J;\u0010\u0018\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0010\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0019JO\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0010\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0010\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0002¨\u0006\""}, d2 = {"Lexpo/modules/kickauthtokenprovider/KickAuthTokenProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "onCreate", "", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", FirebaseAnalytics.Param.METHOD, "", "arg", "extras", "getType", "uri", "Landroid/net/Uri;", "insert", "values", "Landroid/content/ContentValues;", "delete", "", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", SearchIntents.EXTRA_QUERY, "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "isCallerAllowed", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "kick-auth-token-provider_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KickAuthTokenProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String method, String arg, Bundle extras) {
        Context context;
        Intrinsics.checkNotNullParameter(method, "method");
        if (!Intrinsics.areEqual(method, "getToken") || (context = getContext()) == null || !isCallerAllowed(context)) {
            return null;
        }
        try {
            MasterKey masterKeyBuild = new MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();
            Intrinsics.checkNotNullExpressionValue(masterKeyBuild, "build(...)");
            SharedPreferences sharedPreferencesCreate = EncryptedSharedPreferences.create(context, "secure_auth_store", masterKeyBuild, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
            Intrinsics.checkNotNullExpressionValue(sharedPreferencesCreate, "create(...)");
            String string = sharedPreferencesCreate.getString("access_token", null);
            Bundle bundle = new Bundle();
            bundle.putString("token", string);
            return bundle;
        } catch (Exception e) {
            Log.e("TokenProvider", "Failed to read token: " + e.getMessage());
            return null;
        }
    }

    private final boolean isCallerAllowed(Context context) {
        Set of = SetsKt.setOf((Object[]) new String[]{"com.kick.streaming", "com.kick.streaming.debug"});
        int callingUid = Binder.getCallingUid();
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(callingUid);
        if (packagesForUid == null || packagesForUid.length == 0) {
            Log.w("KickAuthTokenProvider", "Caller UID " + callingUid + " has no associated packages.");
            return false;
        }
        for (String str : packagesForUid) {
            if (of.contains(str)) {
                Log.v("KickAuthTokenProvider", "Caller package " + str + " is allowed.");
                return true;
            }
            Log.e("KickAuthTokenProvider", "Caller package " + str + " is not in the whitelist.");
        }
        Log.w("KickAuthTokenProvider", "Caller denied: no allowed packages among " + ArraysKt.joinToString$default(packagesForUid, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        return false;
    }
}
