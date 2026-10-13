package com.datadog.trace.core.scopemanager;

import com.datadog.android.api.InternalLogger;
import com.datadog.trace.api.Config;
import com.datadog.trace.api.Stateful;
import com.datadog.trace.api.scopemanager.ExtendedScopeListener;
import com.datadog.trace.api.scopemanager.ScopeListener;
import com.datadog.trace.bootstrap.instrumentation.api.AgentScope;
import com.datadog.trace.bootstrap.instrumentation.api.AgentScopeManager;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.bootstrap.instrumentation.api.AgentTracer;
import com.datadog.trace.bootstrap.instrumentation.api.ProfilerContext;
import com.datadog.trace.bootstrap.instrumentation.api.ProfilingContextIntegration;
import com.datadog.trace.bootstrap.instrumentation.api.ScopeSource;
import com.datadog.trace.core.monitor.HealthMetrics;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import com.datadog.trace.relocate.api.RatelimitedLogger;
import com.datadog.trace.util.AgentTaskScheduler;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public final class ContinuableScopeManager implements AgentScopeManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long iterationKeepAlive = TimeUnit.SECONDS.toMillis(Config.get().getScopeIterationKeepAlive());
    private final int depthLimit;
    final List<ExtendedScopeListener> extendedScopeListeners;
    final HealthMetrics healthMetrics;
    private final boolean inheritAsyncPropagation;
    private final Logger log;
    private final ProfilingContextIntegration profilingContextIntegration;
    private final RatelimitedLogger ratelimitedLogger;
    volatile ConcurrentMap<ScopeStack, ContinuableScope> rootIterationScopes;
    final List<ScopeListener> scopeListeners;
    final boolean strictMode;
    private final ScopeStackThreadLocal tlsScopeStack;

    public ContinuableScopeManager(int i, boolean z, boolean z2, InternalLogger internalLogger) {
        this(i, z, z2, ProfilingContextIntegration.NoOp.INSTANCE, HealthMetrics.NO_OP, internalLogger);
    }

    public ContinuableScopeManager(int i, boolean z, boolean z2, ProfilingContextIntegration profilingContextIntegration, HealthMetrics healthMetrics, InternalLogger internalLogger) {
        this.depthLimit = i == 0 ? Integer.MAX_VALUE : i;
        this.strictMode = z;
        this.inheritAsyncPropagation = z2;
        this.scopeListeners = new CopyOnWriteArrayList();
        this.extendedScopeListeners = new CopyOnWriteArrayList();
        this.healthMetrics = healthMetrics;
        this.profilingContextIntegration = profilingContextIntegration;
        Logger logger = LoggerFactory.getLogger("ContinuableScopeManager", internalLogger);
        this.log = logger;
        RatelimitedLogger ratelimitedLogger = new RatelimitedLogger(logger, 1, TimeUnit.SECONDS);
        this.ratelimitedLogger = ratelimitedLogger;
        this.tlsScopeStack = new ScopeStackThreadLocal(profilingContextIntegration, ratelimitedLogger);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScopeManager
    public AgentScope activate(AgentSpan agentSpan, ScopeSource scopeSource) {
        return activate(agentSpan, scopeSource.id(), false, false);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScopeManager
    public AgentScope activate(AgentSpan agentSpan, ScopeSource scopeSource, boolean z) {
        return activate(agentSpan, scopeSource.id(), true, z);
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScopeManager
    public AgentScope.Continuation captureSpan(AgentSpan agentSpan) {
        SingleContinuation singleContinuation = new SingleContinuation(this, agentSpan, ScopeSource.INSTRUMENTATION.id(), this.log);
        singleContinuation.register();
        this.healthMetrics.onCaptureContinuation();
        return singleContinuation;
    }

    private AgentScope activate(AgentSpan agentSpan, byte b, boolean z, boolean z2) {
        ScopeStack scopeStack = scopeStack();
        ContinuableScope continuableScope = scopeStack.top;
        if (continuableScope != null && continuableScope.span.equals(agentSpan)) {
            continuableScope.incrementReferences();
            return continuableScope;
        }
        int iDepth = scopeStack.depth();
        if (this.depthLimit <= iDepth) {
            this.healthMetrics.onScopeStackOverflow();
            this.log.debug("Scope depth limit exceeded ({}).  Returning NoopScope.", Integer.valueOf(iDepth));
            return AgentTracer.NoopAgentScope.INSTANCE;
        }
        if (!z) {
            z2 = (!this.inheritAsyncPropagation || continuableScope == null) ? true : continuableScope.isAsyncPropagating();
        }
        ContinuableScope continuableScope2 = new ContinuableScope(this, agentSpan, b, z2, createScopeState(agentSpan), this.log, this.ratelimitedLogger);
        scopeStack.push(continuableScope2);
        this.healthMetrics.onActivateScope();
        return continuableScope2;
    }

    ContinuableScope continueSpan(AbstractContinuation abstractContinuation, AgentSpan agentSpan, byte b) {
        ContinuableScope continuableScope;
        ScopeStack scopeStack = scopeStack();
        ContinuableScope continuableScope2 = scopeStack.top;
        if (continuableScope2 != null && continuableScope2.span.equals(agentSpan)) {
            continuableScope2.incrementReferences();
            if (abstractContinuation != null) {
                abstractContinuation.cancelFromContinuedScopeClose();
            }
            return continuableScope2;
        }
        Stateful statefulCreateScopeState = createScopeState(agentSpan);
        if (abstractContinuation != null) {
            continuableScope = new ContinuingScope(this, agentSpan, b, true, abstractContinuation, statefulCreateScopeState, this.log, this.ratelimitedLogger);
        } else {
            continuableScope = new ContinuableScope(this, agentSpan, b, true, statefulCreateScopeState, this.log, this.ratelimitedLogger);
        }
        scopeStack.push(continuableScope);
        return continuableScope;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScopeManager
    public void closePrevious(boolean z) {
        ScopeStack scopeStack = scopeStack();
        ContinuableScope continuableScope = scopeStack.top;
        if (continuableScope == null || continuableScope.source() != ScopeSource.ITERATION.id()) {
            return;
        }
        if (iterationKeepAlive > 0) {
            cancelRootIterationScopeCleanup(scopeStack, continuableScope);
        }
        continuableScope.close();
        scopeStack.cleanup();
        if (z) {
            continuableScope.span.finishWithEndToEnd();
            this.healthMetrics.onFinishContinuation();
        }
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScopeManager
    public AgentScope activateNext(AgentSpan agentSpan) {
        ScopeStack scopeStack = scopeStack();
        int iDepth = scopeStack.depth();
        if (this.depthLimit <= iDepth) {
            this.healthMetrics.onScopeStackOverflow();
            this.log.debug("Scope depth limit exceeded ({}).  Returning NoopScope.", Integer.valueOf(iDepth));
            return AgentTracer.NoopAgentScope.INSTANCE;
        }
        ContinuableScope continuableScope = scopeStack.top;
        ContinuableScope continuableScope2 = new ContinuableScope(this, agentSpan, ScopeSource.ITERATION.id(), (!this.inheritAsyncPropagation || continuableScope == null) ? true : continuableScope.isAsyncPropagating(), createScopeState(agentSpan), this.log, this.ratelimitedLogger);
        if (iterationKeepAlive > 0 && iDepth == 0) {
            scheduleRootIterationScopeCleanup(scopeStack, continuableScope2);
        }
        scopeStack.push(continuableScope2);
        return continuableScope2;
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScopeManager
    public AgentScope active() {
        return scopeStack().active();
    }

    @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentScopeManager
    public AgentSpan activeSpan() {
        ContinuableScope continuableScopeActive = scopeStack().active();
        if (continuableScopeActive == null) {
            return null;
        }
        return continuableScopeActive.span;
    }

    public void addScopeListener(ScopeListener scopeListener) {
        if (scopeListener instanceof ExtendedScopeListener) {
            addExtendedScopeListener((ExtendedScopeListener) scopeListener);
            return;
        }
        this.scopeListeners.add(scopeListener);
        this.log.debug("Added scope listener {}", scopeListener);
        if (activeSpan() != null) {
            scopeListener.afterScopeActivated();
        }
    }

    private void addExtendedScopeListener(ExtendedScopeListener extendedScopeListener) {
        this.extendedScopeListeners.add(extendedScopeListener);
        this.log.debug("Added scope listener {}", extendedScopeListener);
        AgentSpan agentSpanActiveSpan = activeSpan();
        if (agentSpanActiveSpan == null || agentSpanActiveSpan == AgentTracer.NoopAgentSpan.INSTANCE) {
            return;
        }
        extendedScopeListener.afterScopeActivated(agentSpanActiveSpan.getTraceId(), agentSpanActiveSpan.mo11181getLocalRootSpan().getSpanId(), agentSpanActiveSpan.context().getSpanId(), agentSpanActiveSpan.traceConfig());
    }

    private Stateful createScopeState(AgentSpan agentSpan) {
        if (agentSpan.context() instanceof ProfilerContext) {
            return this.profilingContextIntegration.newScopeState((ProfilerContext) agentSpan.context());
        }
        return Stateful.DEFAULT;
    }

    ScopeStack scopeStack() {
        return this.tlsScopeStack.get();
    }

    static final class ScopeStackThreadLocal extends ThreadLocal<ScopeStack> {
        private final ProfilingContextIntegration profilingContextIntegration;
        private final RatelimitedLogger ratelimitedLogger;

        ScopeStackThreadLocal(ProfilingContextIntegration profilingContextIntegration, RatelimitedLogger ratelimitedLogger) {
            this.profilingContextIntegration = profilingContextIntegration;
            this.ratelimitedLogger = ratelimitedLogger;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public ScopeStack initialValue() {
            return new ScopeStack(this.profilingContextIntegration, this.ratelimitedLogger);
        }
    }

    private void scheduleRootIterationScopeCleanup(ScopeStack scopeStack, ContinuableScope continuableScope) {
        if (this.rootIterationScopes == null) {
            synchronized (this) {
                if (this.rootIterationScopes == null) {
                    this.rootIterationScopes = new ConcurrentHashMap();
                    RootIterationCleaner.scheduleFor(this.rootIterationScopes);
                }
            }
        }
        this.rootIterationScopes.put(scopeStack, continuableScope);
    }

    private void cancelRootIterationScopeCleanup(ScopeStack scopeStack, ContinuableScope continuableScope) {
        if (this.rootIterationScopes != null) {
            this.rootIterationScopes.remove(scopeStack, continuableScope);
        }
    }

    private static final class RootIterationCleaner implements AgentTaskScheduler.Task<Map<ScopeStack, ContinuableScope>> {
        private static final RootIterationCleaner CLEANER = new RootIterationCleaner();

        private RootIterationCleaner() {
        }

        public static void scheduleFor(Map<ScopeStack, ContinuableScope> map) {
            AgentTaskScheduler.INSTANCE.scheduleAtFixedRate(CLEANER, map, ContinuableScopeManager.iterationKeepAlive, Math.min(ContinuableScopeManager.iterationKeepAlive, 10000L), TimeUnit.MILLISECONDS);
        }

        @Override // com.datadog.trace.util.AgentTaskScheduler.Task
        public void run(Map<ScopeStack, ContinuableScope> map) {
            Iterator<Map.Entry<ScopeStack, ContinuableScope>> it = map.entrySet().iterator();
            long jCurrentTimeMillis = System.currentTimeMillis() - ContinuableScopeManager.iterationKeepAlive;
            while (it.hasNext()) {
                Map.Entry<ScopeStack, ContinuableScope> next = it.next();
                ScopeStack key = next.getKey();
                ContinuableScope value = next.getValue();
                if (!value.alive()) {
                    it.remove();
                } else {
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    if (value.span.getStartTime() / 1000000 < jCurrentTimeMillis) {
                        key.overdueRootScope = value;
                        value.span.finishWithEndToEnd();
                        it.remove();
                    }
                }
            }
        }
    }
}
