package com.datadog.android.rum.internal.startup;

import android.app.Activity;
import com.datadog.android.rum.internal.domain.Time;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumStartupScenario.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0003\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getActivity", "()Ljava/lang/ref/WeakReference;", "hasSavedInstanceStateBundle", "", "getHasSavedInstanceStateBundle", "()Z", "initialTime", "Lcom/datadog/android/rum/internal/domain/Time;", "getInitialTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "Cold", "WarmAfterActivityDestroyed", "WarmFirstActivity", "Lcom/datadog/android/rum/internal/startup/RumStartupScenario$Cold;", "Lcom/datadog/android/rum/internal/startup/RumStartupScenario$WarmAfterActivityDestroyed;", "Lcom/datadog/android/rum/internal/startup/RumStartupScenario$WarmFirstActivity;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RumStartupScenario {
    WeakReference<Activity> getActivity();

    boolean getHasSavedInstanceStateBundle();

    Time getInitialTime();

    /* JADX INFO: compiled from: RumStartupScenario.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumStartupScenario$Cold;", "Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "hasSavedInstanceStateBundle", "", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "appStartActivityOnCreateGapNs", "", "initialTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(ZLjava/lang/ref/WeakReference;JLcom/datadog/android/rum/internal/domain/Time;)V", "getActivity", "()Ljava/lang/ref/WeakReference;", "getAppStartActivityOnCreateGapNs", "()J", "getHasSavedInstanceStateBundle", "()Z", "getInitialTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Cold implements RumStartupScenario {
        private final WeakReference<Activity> activity;
        private final long appStartActivityOnCreateGapNs;
        private final boolean hasSavedInstanceStateBundle;
        private final Time initialTime;

        public Cold(boolean z, WeakReference<Activity> activity, long j, Time initialTime) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(initialTime, "initialTime");
            this.hasSavedInstanceStateBundle = z;
            this.activity = activity;
            this.appStartActivityOnCreateGapNs = j;
            this.initialTime = initialTime;
        }

        @Override // com.datadog.android.rum.internal.startup.RumStartupScenario
        public boolean getHasSavedInstanceStateBundle() {
            return this.hasSavedInstanceStateBundle;
        }

        @Override // com.datadog.android.rum.internal.startup.RumStartupScenario
        public WeakReference<Activity> getActivity() {
            return this.activity;
        }

        public final long getAppStartActivityOnCreateGapNs() {
            return this.appStartActivityOnCreateGapNs;
        }

        @Override // com.datadog.android.rum.internal.startup.RumStartupScenario
        public Time getInitialTime() {
            return this.initialTime;
        }
    }

    /* JADX INFO: compiled from: RumStartupScenario.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumStartupScenario$WarmFirstActivity;", "Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "hasSavedInstanceStateBundle", "", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "appStartActivityOnCreateGapNs", "", "initialTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(ZLjava/lang/ref/WeakReference;JLcom/datadog/android/rum/internal/domain/Time;)V", "getActivity", "()Ljava/lang/ref/WeakReference;", "getAppStartActivityOnCreateGapNs", "()J", "getHasSavedInstanceStateBundle", "()Z", "getInitialTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class WarmFirstActivity implements RumStartupScenario {
        private final WeakReference<Activity> activity;
        private final long appStartActivityOnCreateGapNs;
        private final boolean hasSavedInstanceStateBundle;
        private final Time initialTime;

        public WarmFirstActivity(boolean z, WeakReference<Activity> activity, long j, Time initialTime) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(initialTime, "initialTime");
            this.hasSavedInstanceStateBundle = z;
            this.activity = activity;
            this.appStartActivityOnCreateGapNs = j;
            this.initialTime = initialTime;
        }

        @Override // com.datadog.android.rum.internal.startup.RumStartupScenario
        public boolean getHasSavedInstanceStateBundle() {
            return this.hasSavedInstanceStateBundle;
        }

        @Override // com.datadog.android.rum.internal.startup.RumStartupScenario
        public WeakReference<Activity> getActivity() {
            return this.activity;
        }

        public final long getAppStartActivityOnCreateGapNs() {
            return this.appStartActivityOnCreateGapNs;
        }

        @Override // com.datadog.android.rum.internal.startup.RumStartupScenario
        public Time getInitialTime() {
            return this.initialTime;
        }
    }

    /* JADX INFO: compiled from: RumStartupScenario.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumStartupScenario$WarmAfterActivityDestroyed;", "Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "hasSavedInstanceStateBundle", "", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "initialTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(ZLjava/lang/ref/WeakReference;Lcom/datadog/android/rum/internal/domain/Time;)V", "getActivity", "()Ljava/lang/ref/WeakReference;", "getHasSavedInstanceStateBundle", "()Z", "getInitialTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class WarmAfterActivityDestroyed implements RumStartupScenario {
        private final WeakReference<Activity> activity;
        private final boolean hasSavedInstanceStateBundle;
        private final Time initialTime;

        public WarmAfterActivityDestroyed(boolean z, WeakReference<Activity> activity, Time initialTime) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(initialTime, "initialTime");
            this.hasSavedInstanceStateBundle = z;
            this.activity = activity;
            this.initialTime = initialTime;
        }

        @Override // com.datadog.android.rum.internal.startup.RumStartupScenario
        public boolean getHasSavedInstanceStateBundle() {
            return this.hasSavedInstanceStateBundle;
        }

        @Override // com.datadog.android.rum.internal.startup.RumStartupScenario
        public WeakReference<Activity> getActivity() {
            return this.activity;
        }

        @Override // com.datadog.android.rum.internal.startup.RumStartupScenario
        public Time getInitialTime() {
            return this.initialTime;
        }
    }
}
