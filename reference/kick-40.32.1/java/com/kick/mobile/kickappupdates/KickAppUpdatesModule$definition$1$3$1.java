package com.kick.mobile.kickappupdates;

import com.google.android.play.core.appupdate.AppUpdateInfo;
import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KickAppUpdatesModule.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final class KickAppUpdatesModule$definition$1$3$1 implements Function1<AppUpdateInfo, Unit> {
    final /* synthetic */ Promise $promise;

    KickAppUpdatesModule$definition$1$3$1(Promise promise) {
        this.$promise = promise;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppUpdateInfo appUpdateInfo) {
        invoke2(appUpdateInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppUpdateInfo appUpdateInfoResult) {
        Intrinsics.checkNotNullParameter(appUpdateInfoResult, "appUpdateInfoResult");
        this.$promise.resolve(MapsKt.mapOf(TuplesKt.to("latestVersion", Integer.valueOf(appUpdateInfoResult.availableVersionCode())), TuplesKt.to("updateAvailable", Integer.valueOf(appUpdateInfoResult.updateAvailability()))));
    }
}
