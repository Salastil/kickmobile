package com.datadog.android.sqlite;

import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.core.SdkReference;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: DatadogDatabaseErrorHandler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/sqlite/DatadogDatabaseErrorHandler;", "Landroid/database/DatabaseErrorHandler;", "sdkInstanceName", "", "defaultErrorHandler", "(Ljava/lang/String;Landroid/database/DatabaseErrorHandler;)V", "getDefaultErrorHandler$dd_sdk_android_rum_release", "()Landroid/database/DatabaseErrorHandler;", "sdkReference", "Lcom/datadog/android/core/SdkReference;", "onCorruption", "", "dbObj", "Landroid/database/sqlite/SQLiteDatabase;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogDatabaseErrorHandler implements DatabaseErrorHandler {
    public static final String DATABASE_CORRUPTION_ERROR_MESSAGE = "Corruption reported by sqlite database: %s";
    private final DatabaseErrorHandler defaultErrorHandler;
    private final String sdkInstanceName;
    private final SdkReference sdkReference;

    /* JADX WARN: Multi-variable type inference failed */
    public DatadogDatabaseErrorHandler() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public DatadogDatabaseErrorHandler(String str, DatabaseErrorHandler defaultErrorHandler) {
        Intrinsics.checkNotNullParameter(defaultErrorHandler, "defaultErrorHandler");
        this.sdkInstanceName = str;
        this.defaultErrorHandler = defaultErrorHandler;
        this.sdkReference = new SdkReference(str, null, 2, null);
    }

    public /* synthetic */ DatadogDatabaseErrorHandler(String str, DefaultDatabaseErrorHandler defaultDatabaseErrorHandler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? new DefaultDatabaseErrorHandler() : defaultDatabaseErrorHandler);
    }

    /* JADX INFO: renamed from: getDefaultErrorHandler$dd_sdk_android_rum_release, reason: from getter */
    public final DatabaseErrorHandler getDefaultErrorHandler() {
        return this.defaultErrorHandler;
    }

    @Override // android.database.DatabaseErrorHandler
    public void onCorruption(SQLiteDatabase dbObj) {
        final String str;
        Intrinsics.checkNotNullParameter(dbObj, "dbObj");
        this.defaultErrorHandler.onCorruption(dbObj);
        SdkCore sdkCore = this.sdkReference.get();
        if (sdkCore != null) {
            RumMonitor rumMonitor = GlobalRumMonitor.get(sdkCore);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format(Locale.US, DATABASE_CORRUPTION_ERROR_MESSAGE, Arrays.copyOf(new Object[]{dbObj.getPath()}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            rumMonitor.addError(str2, RumErrorSource.SOURCE, null, MapsKt.mapOf(TuplesKt.to(RumAttributes.ERROR_DATABASE_PATH, dbObj.getPath()), TuplesKt.to(RumAttributes.ERROR_DATABASE_VERSION, Integer.valueOf(dbObj.getVersion()))));
            return;
        }
        String str3 = this.sdkInstanceName;
        if (str3 == null) {
            str = "Default SDK instance";
        } else {
            str = "SDK instance with name=" + str3;
        }
        InternalLogger.DefaultImpls.log$default(InternalLogger.INSTANCE.getUNBOUND(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.sqlite.DatadogDatabaseErrorHandler.onCorruption.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return str + " is not found, skipping reporting the corruption of sqlite database: %s";
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }
}
