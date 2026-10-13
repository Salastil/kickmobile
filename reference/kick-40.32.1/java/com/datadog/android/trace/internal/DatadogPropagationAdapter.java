package com.datadog.android.trace.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.trace.api.propagation.DatadogPropagation;
import com.datadog.android.trace.api.span.DatadogSpanContext;
import com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: DatadogPropagationAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0002Jg\u0010\u000b\u001a\u0004\u0018\u00010\f\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u0002H\r2H\u0010\u000f\u001aD\u0012\u0013\u0012\u0011H\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000e\u0012%\u0012#\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\u0016¢\u0006\u0002\u0010\u0016Jp\u0010\u0017\u001a\u00020\u0015\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000e\u001a\u0002H\r2K\u0010\u0019\u001aG\u0012\u0013\u0012\u0011H\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00150\u001aH\u0016¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/datadog/android/trace/internal/DatadogPropagationAdapter;", "Lcom/datadog/android/trace/api/propagation/DatadogPropagation;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "delegate", "Lcom/datadog/trace/bootstrap/instrumentation/api/AgentPropagation;", "(Lcom/datadog/android/api/InternalLogger;Lcom/datadog/trace/bootstrap/instrumentation/api/AgentPropagation;)V", "constructErrorMessage", "", "klass", "Lkotlin/reflect/KClass;", "extract", "Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "C", "carrier", "getter", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "classifier", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Lcom/datadog/android/trace/api/span/DatadogSpanContext;", "inject", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "setter", "Lkotlin/Function3;", "key", "value", "(Lcom/datadog/android/trace/api/span/DatadogSpanContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogPropagationAdapter implements DatadogPropagation {
    private final AgentPropagation delegate;
    private final InternalLogger internalLogger;

    public DatadogPropagationAdapter(InternalLogger internalLogger, AgentPropagation delegate) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.internalLogger = internalLogger;
        this.delegate = delegate;
    }

    @Override // com.datadog.android.trace.api.propagation.DatadogPropagation
    public <C> void inject(final DatadogSpanContext context, C carrier, final Function3<? super C, ? super String, ? super String, Unit> setter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(setter, "setter");
        if (!(context instanceof DatadogSpanContextAdapter)) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.trace.internal.DatadogPropagationAdapter.inject.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return DatadogPropagationAdapter.this.constructErrorMessage(Reflection.getOrCreateKotlinClass(context.getClass()));
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            this.delegate.inject(((DatadogSpanContextAdapter) context).getDelegate(), carrier, new AgentPropagation.Setter() { // from class: com.datadog.android.trace.internal.DatadogPropagationAdapter$$ExternalSyntheticLambda0
                @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation.Setter
                public final void set(Object obj, String str, String str2) {
                    setter.invoke(obj, str, str2);
                }
            });
        }
    }

    static final void extract$lambda$1(Function2 function2, Object obj, AgentPropagation.KeyClassifier cls) {
        Intrinsics.checkNotNullExpressionValue(cls, "cls");
        function2.invoke(obj, new DatadogPropagationAdapter$extract$1$1(cls));
    }

    @Override // com.datadog.android.trace.api.propagation.DatadogPropagation
    public <C> DatadogSpanContext extract(C carrier, final Function2<? super C, ? super Function2<? super String, ? super String, Boolean>, Unit> getter) {
        Intrinsics.checkNotNullParameter(getter, "getter");
        AgentSpan.Context.Extracted extractedExtract = this.delegate.extract(carrier, new AgentPropagation.ContextVisitor() { // from class: com.datadog.android.trace.internal.DatadogPropagationAdapter$$ExternalSyntheticLambda1
            @Override // com.datadog.trace.bootstrap.instrumentation.api.AgentPropagation.ContextVisitor
            public final void forEachKey(Object obj, AgentPropagation.KeyClassifier keyClassifier) {
                DatadogPropagationAdapter.extract$lambda$1(getter, obj, keyClassifier);
            }
        });
        return extractedExtract != null ? new DatadogSpanContextAdapter(extractedExtract) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String constructErrorMessage(KClass<?> klass) {
        return "DatadogPropagationAdapter supports only DatadogSpanContextAdapter instances for injection but " + klass.getSimpleName() + " is given";
    }
}
