package com.datadog.android.trace.sqlite;

import android.database.sqlite.SQLiteDatabase;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.trace.GlobalDatadogTracer;
import com.datadog.android.trace.api.scope.DatadogScope;
import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.tracer.DatadogTracer;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SqliteDatabaseExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aL\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001d\u0010\u0007\u001a\u0019\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"transactionTraced", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/database/sqlite/SQLiteDatabase;", "operationName", "", "exclusive", "", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lkotlin/Function2;", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "Lkotlin/ExtensionFunctionType;", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "dd-sdk-android-trace_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SqliteDatabaseExtKt {
    public static /* synthetic */ Object transactionTraced$default(SQLiteDatabase sQLiteDatabase, String operationName, boolean z, Function2 body, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "<this>");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(body, "body");
        DatadogSpan datadogSpanActiveSpan = GlobalDatadogTracer.get().activeSpan();
        DatadogTracer datadogTracer = GlobalDatadogTracer.get();
        DatadogSpan datadogSpanStart = datadogTracer.buildSpan(operationName).withParentSpan(datadogSpanActiveSpan).start();
        DatadogScope datadogScopeActivateSpan = datadogTracer.activateSpan(datadogSpanStart);
        try {
            if (z) {
                sQLiteDatabase.beginTransaction();
            } else {
                sQLiteDatabase.beginTransactionNonExclusive();
            }
            try {
                Object objInvoke = body.invoke(datadogSpanStart, sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                datadogSpanStart.finish();
                if (datadogScopeActivateSpan != null) {
                    datadogScopeActivateSpan.close();
                }
                return objInvoke;
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            try {
                datadogSpanStart.logThrowable(th2);
                throw th2;
            } catch (Throwable th3) {
                datadogSpanStart.finish();
                if (datadogScopeActivateSpan != null) {
                    datadogScopeActivateSpan.close();
                }
                throw th3;
            }
        }
    }

    public static final <T> T transactionTraced(SQLiteDatabase sQLiteDatabase, String operationName, boolean z, Function2<? super DatadogSpan, ? super SQLiteDatabase, ? extends T> body) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "<this>");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(body, "body");
        DatadogSpan datadogSpanActiveSpan = GlobalDatadogTracer.get().activeSpan();
        DatadogTracer datadogTracer = GlobalDatadogTracer.get();
        DatadogSpan datadogSpanStart = datadogTracer.buildSpan(operationName).withParentSpan(datadogSpanActiveSpan).start();
        DatadogScope datadogScopeActivateSpan = datadogTracer.activateSpan(datadogSpanStart);
        try {
            if (z) {
                sQLiteDatabase.beginTransaction();
            } else {
                sQLiteDatabase.beginTransactionNonExclusive();
            }
            try {
                T tInvoke = body.invoke(datadogSpanStart, sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                datadogSpanStart.finish();
                if (datadogScopeActivateSpan != null) {
                    datadogScopeActivateSpan.close();
                }
                return tInvoke;
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            try {
                datadogSpanStart.logThrowable(th2);
                throw th2;
            } catch (Throwable th3) {
                datadogSpanStart.finish();
                if (datadogScopeActivateSpan != null) {
                    datadogScopeActivateSpan.close();
                }
                throw th3;
            }
        }
    }
}
