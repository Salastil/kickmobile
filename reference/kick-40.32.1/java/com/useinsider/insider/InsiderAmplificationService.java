package com.useinsider.insider;

import android.app.job.JobParameters;
import android.app.job.JobService;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class InsiderAmplificationService extends JobService {

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JobParameters f288a;

        a(JobParameters jobParameters) {
            this.f288a = jobParameters;
        }

        @Override // java.lang.Runnable
        public void run() {
            new m4(InsiderAmplificationService.this.getApplicationContext()).a(Insider.Instance.getCurrentUser());
            Debugger.a(DebuggingTag.insiderAmplificationServiceRunAndReschedule, 4);
            InsiderAmplificationService.this.jobFinished(this.f288a, true);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        Debugger.a(DebuggingTag.insiderAmplificationServiceStarting, 4);
        new Thread(new a(jobParameters)).start();
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
