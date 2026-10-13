package com.useinsider.insider;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class SessionPayloadJobService extends JobService {

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a implements x4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JobParameters f308a;

        a(JobParameters jobParameters) {
            this.f308a = jobParameters;
        }

        @Override // com.useinsider.insider.x4
        public void a() {
        }

        @Override // com.useinsider.insider.x4
        public void b() {
            SessionPayloadJobService.this.a(this.f308a);
        }

        @Override // com.useinsider.insider.x4
        public void c() {
        }

        @Override // com.useinsider.insider.x4
        public void d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(JobParameters jobParameters) {
        try {
            e.h = h4.a().e(getApplicationContext(), s4.INSIDER.b()).getBoolean(r4.DEBUG_MODE.b(), false);
            JSONObject jSONObjectA = w4.a(getApplicationContext());
            if (jSONObjectA != null && jSONObjectA.length() != 0) {
                Debugger.a(DebuggingTag.sessionPayloadServiceIsRunning, 4);
                Debugger.b(DebuggingTag.sessionStopRequest, 4, jSONObjectA);
                new m4(getApplicationContext()).c(jSONObjectA, new a(jobParameters));
                return;
            }
            Debugger.a(DebuggingTag.sessionPayloadServiceIsRunningButNotFoundStoredData, 4);
            a(jobParameters);
        } catch (Exception e) {
            a(jobParameters);
            Insider.Instance.putException(e);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        try {
            ((ExecutorService) b5.c.a()).execute(new Runnable() { // from class: com.useinsider.insider.SessionPayloadJobService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(jobParameters);
                }
            });
            return true;
        } catch (Exception e) {
            a(jobParameters);
            Insider.Instance.putException(e);
            return true;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (jobScheduler != null) {
                jobScheduler.cancel(4674337);
                Debugger.a(DebuggingTag.sessionPayloadServiceCanceled, 4);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JobParameters jobParameters) {
        try {
            jobFinished(jobParameters, false);
            Debugger.a(DebuggingTag.sessionPayloadServiceIsStopped, 4);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static void b(Context context) {
        if (context == null) {
            return;
        }
        try {
            JobInfo jobInfoBuild = new JobInfo.Builder(4674337, new ComponentName(context, (Class<?>) SessionPayloadJobService.class)).setMinimumLatency(4000L).setOverrideDeadline(8000L).setRequiredNetworkType(1).build();
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (jobScheduler != null) {
                jobScheduler.schedule(jobInfoBuild);
                Debugger.a(DebuggingTag.sessionPayloadServiceScheduled, 4);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
