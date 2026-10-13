package com.useinsider.insider;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class u {
    u() {
    }

    private static JobInfo a(int i, JobScheduler jobScheduler) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            if (jobInfo.getId() == i) {
                return jobInfo;
            }
        }
        return null;
    }

    void b(Context context) {
        try {
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            int i = f.v;
            int i2 = f.u;
            JobInfo jobInfoA = a(i, jobScheduler);
            if (jobInfoA != null && jobInfoA.getIntervalMillis() != i2) {
                a(context);
                Debugger.a(DebuggingTag.insiderAmplificationServiceFrequencyDiff, 4);
            }
            JobInfo.Builder builder = new JobInfo.Builder(i, new ComponentName(context, (Class<?>) InsiderAmplificationService.class));
            builder.setRequiredNetworkType(1);
            builder.setRequiresCharging(false);
            builder.setPeriodic(i2);
            if (w4.j(context, "android.permission.RECEIVE_BOOT_COMPLETED")) {
                builder.setPersisted(true);
            }
            if (jobScheduler.schedule(builder.build()) == 1) {
                Debugger.a(DebuggingTag.insiderAmplificationServiceStart, 4);
            } else {
                Debugger.a(DebuggingTag.insiderAmplificationServiceFail, 4);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void a(Context context) {
        try {
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            jobScheduler.cancel(f.v);
            Debugger.a(DebuggingTag.insiderAmplificationServiceCancel, 4);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void a(SharedPreferences sharedPreferences, boolean z) {
        try {
            sharedPreferences.edit().putBoolean(f.q, z).apply();
            Debugger.a(DebuggingTag.insiderAmplificationServiceStatus, 4, Boolean.valueOf(z));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
