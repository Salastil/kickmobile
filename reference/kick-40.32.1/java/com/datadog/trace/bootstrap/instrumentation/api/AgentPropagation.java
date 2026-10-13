package com.datadog.trace.bootstrap.instrumentation.api;

import com.datadog.trace.api.TracePropagationStyle;

/* JADX INFO: loaded from: classes6.dex */
public interface AgentPropagation {

    public interface BinaryContextVisitor<C> extends ContextVisitor<C> {
        void forEachKey(C c, BinaryKeyClassifier binaryKeyClassifier);
    }

    public interface BinaryKeyClassifier {
        boolean accept(String str, byte[] bArr);
    }

    public interface BinarySetter<C> extends Setter<C> {
        void set(C c, String str, byte[] bArr);
    }

    public interface ContextVisitor<C> {
        void forEachKey(C c, KeyClassifier keyClassifier);
    }

    public interface KeyClassifier {
        boolean accept(String str, String str2);
    }

    public interface Setter<C> {
        void set(C c, String str, String str2);
    }

    <C> AgentSpan.Context.Extracted extract(C c, ContextVisitor<C> contextVisitor);

    <C> void inject(AgentSpan.Context context, C c, Setter<C> setter);

    <C> void inject(AgentSpan agentSpan, C c, Setter<C> setter);

    <C> void inject(AgentSpan agentSpan, C c, Setter<C> setter, TracePropagationStyle tracePropagationStyle);
}
