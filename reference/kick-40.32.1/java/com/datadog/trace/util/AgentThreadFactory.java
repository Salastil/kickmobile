package com.datadog.trace.util;

import com.datadog.trace.logger.LoggerFactory;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes6.dex */
public final class AgentThreadFactory implements ThreadFactory {
    public static final ThreadGroup AGENT_THREAD_GROUP = new ThreadGroup("dd-trace-java");
    public static final long THREAD_JOIN_TIMOUT_MS = 800;
    private final AgentThread agentThread;

    public enum AgentThread {
        TASK_SCHEDULER("dd-task-scheduler"),
        TRACE_STARTUP("dd-agent-startup-datadog-tracer"),
        TRACE_MONITOR("dd-trace-monitor"),
        TRACE_PROCESSOR("dd-trace-processor"),
        SPAN_SAMPLING_PROCESSOR("dd-span-sampling-processor"),
        TRACE_CASSANDRA_ASYNC_SESSION("dd-cassandra-session-executor"),
        METRICS_AGGREGATOR("dd-metrics-aggregator"),
        STATSD_CLIENT("dd-statsd-client"),
        JMX_STARTUP("dd-agent-startup-jmxfetch"),
        JMX_COLLECTOR("dd-jmx-collector"),
        PROFILER_STARTUP("dd-agent-startup-datadog-profiler"),
        PROFILER_RECORDING_SCHEDULER("dd-profiler-recording-scheduler"),
        PROFILER_HTTP_DISPATCHER("dd-profiler-http-dispatcher"),
        APPSEC_HTTP_DISPATCHER("dd-appsec-http-dispatcher"),
        TELEMETRY("dd-telemetry"),
        FLEET_MANAGEMENT_POLLER("dd-fleet-management-poller"),
        REMOTE_CONFIG("dd-remote-config"),
        TRACER_FLARE("dd-tracer-flare"),
        CWS_TLS("dd-cws-tls"),
        PROCESS_SUPERVISOR("dd-process-supervisor"),
        DEBUGGER_HTTP_DISPATCHER("dd-debugger-upload-http-dispatcher");

        public final String threadName;

        AgentThread(String str) {
            this.threadName = str;
        }
    }

    public AgentThreadFactory(AgentThread agentThread) {
        this.agentThread = agentThread;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return newAgentThread(this.agentThread, runnable);
    }

    public static Thread newAgentThread(AgentThread agentThread, Runnable runnable) {
        return newAgentThread(agentThread, null, runnable, true);
    }

    public static Thread newAgentThread(AgentThread agentThread, Runnable runnable, boolean z) {
        return newAgentThread(agentThread, null, runnable, z);
    }

    public static Thread newAgentThread(final AgentThread agentThread, String str, final Runnable runnable, boolean z) {
        String str2;
        if (str != null) {
            str2 = agentThread.threadName + str;
        } else {
            str2 = agentThread.threadName;
        }
        Thread thread = new Thread(AGENT_THREAD_GROUP, runnable, str2);
        thread.setDaemon(z);
        thread.setContextClassLoader(null);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.datadog.trace.util.AgentThreadFactory.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread2, Throwable th) {
                LoggerFactory.getLogger(runnable.getClass()).error("Uncaught exception {} in {}", th, agentThread.threadName, th);
            }
        });
        return thread;
    }
}
