package com.datadog.android.rum.internal.thread;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: NoOpScheduledExecutorService.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J4\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u000f\u0018\u00010\u000e\"\u0004\b\u0000\u0010\u00102\u0016\u0010\u0011\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0018\u00010\u0012H\u0016JF\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u000f\u0018\u00010\u000e\"\u0004\b\u0000\u0010\u00102\u0016\u0010\u0011\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J-\u0010\u0014\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\u0016\u0010\u0011\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0015J?\u0010\u0014\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\u0016\u0010\u0011\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J*\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J8\u0010\u0019\u001a\n\u0012\u0004\u0012\u0002H\u001c\u0018\u00010\u001a\"\u0004\b\u0000\u0010\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u001c\u0018\u00010\u00132\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J2\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J2\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eH\u0016J\u0018\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f2\b\u0010%\u001a\u0004\u0018\u00010\fH\u0016J-\u0010$\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u000f\"\u0004\b\u0000\u0010\u00102\b\u0010%\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u0002H\u0010H\u0016¢\u0006\u0002\u0010'J&\u0010$\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u000f\"\u0004\b\u0000\u0010\u00102\u000e\u0010%\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u0013H\u0016¨\u0006("}, d2 = {"Lcom/datadog/android/rum/internal/thread/NoOpScheduledExecutorService;", "Ljava/util/concurrent/ScheduledExecutorService;", "()V", "awaitTermination", "", InstrumentationTags.TIMEOUT, "", "unit", "Ljava/util/concurrent/TimeUnit;", "execute", "", "command", "Ljava/lang/Runnable;", "invokeAll", "", "Ljava/util/concurrent/Future;", ExifInterface.GPS_DIRECTION_TRUE, "tasks", "", "Ljava/util/concurrent/Callable;", "invokeAny", "(Ljava/util/Collection;)Ljava/lang/Object;", "(Ljava/util/Collection;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "isShutdown", "isTerminated", "schedule", "Ljava/util/concurrent/ScheduledFuture;", "delay", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "callable", "scheduleAtFixedRate", "initialDelay", TypedValues.Cycle.S_WAVE_PERIOD, "scheduleWithFixedDelay", "shutdown", "shutdownNow", "submit", "task", "result", "(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/Future;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpScheduledExecutorService implements ScheduledExecutorService, AutoCloseable {
    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long timeout, TimeUnit unit) {
        return false;
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        UByte$$ExternalSyntheticBackport0.m((ExecutorService) this);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
        return null;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
        return null;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        return null;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable task) {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable task, T result) {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> task) {
        return null;
    }
}
