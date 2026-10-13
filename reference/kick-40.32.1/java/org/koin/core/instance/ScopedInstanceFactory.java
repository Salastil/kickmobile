package org.koin.core.instance;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.trace.bootstrap.instrumentation.api.SamplerConstants;
import expo.modules.interfaces.permissions.PermissionsResponse;
import io.ktor.http.ContentDisposition;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.error.MissingScopeValueException;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: ScopedInstanceFactory.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J!\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u0015\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0015\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001eJ\u0015\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001eJ\b\u0010 \u001a\u00020\u0013H\u0016J\u001a\u0010!\u001a\u00020\u00132\n\u0010\"\u001a\u00060\rj\u0002`\u000e2\u0006\u0010#\u001a\u00020$R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR2\u0010\u000b\u001a&\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00028\u00000\fj\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00028\u0000`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lorg/koin/core/instance/ScopedInstanceFactory;", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/koin/core/instance/InstanceFactory;", "beanDefinition", "Lorg/koin/core/definition/BeanDefinition;", "holdInstance", "", "<init>", "(Lorg/koin/core/definition/BeanDefinition;Z)V", "getHoldInstance", "()Z", "values", "Ljava/util/HashMap;", "", "Lorg/koin/core/scope/ScopeID;", "Lkotlin/collections/HashMap;", ContentDisposition.Parameters.Size, "", "saveValue", "", "id", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "isCreated", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lorg/koin/core/instance/ResolutionContext;", SamplerConstants.DROP, PermissionsResponse.SCOPE_KEY, "Lorg/koin/core/scope/Scope;", "create", "(Lorg/koin/core/instance/ResolutionContext;)Ljava/lang/Object;", "get", "dropAll", "refreshInstance", "scopeID", "instance", "", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScopedInstanceFactory<T> extends InstanceFactory<T> {
    private final boolean holdInstance;
    private HashMap<String, T> values;

    public /* synthetic */ ScopedInstanceFactory(BeanDefinition beanDefinition, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(beanDefinition, (i & 2) != 0 ? true : z);
    }

    public final boolean getHoldInstance() {
        return this.holdInstance;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScopedInstanceFactory(BeanDefinition<T> beanDefinition, boolean z) {
        super(beanDefinition);
        Intrinsics.checkNotNullParameter(beanDefinition, "beanDefinition");
        this.holdInstance = z;
        this.values = new HashMap<>();
    }

    public final int size() {
        return this.values.size();
    }

    public final void saveValue(String id, T value) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.values.put(id, value);
    }

    @Override // org.koin.core.instance.InstanceFactory
    public boolean isCreated(ResolutionContext context) {
        Scope scope;
        return this.values.get((context == null || (scope = context.getScope()) == null) ? null : scope.getId()) != null;
    }

    @Override // org.koin.core.instance.InstanceFactory
    public void drop(Scope scope) {
        if (scope != null) {
            Function1<T, Unit> onClose = getBeanDefinition().getCallbacks().getOnClose();
            if (onClose != null) {
                onClose.invoke(this.values.get(scope.getId()));
            }
            this.values.remove(scope.getId());
        }
    }

    @Override // org.koin.core.instance.InstanceFactory
    public T create(ResolutionContext context) throws MissingScopeValueException {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.values.get(context.getScope().getId()) == null) {
            return (T) super.create(context);
        }
        T t = this.values.get(context.getScope().getId());
        if (t != null) {
            return t;
        }
        throw new MissingScopeValueException("Factory.create - Scoped instance not found for " + context.getScope().getId() + " in " + getBeanDefinition());
    }

    @Override // org.koin.core.instance.InstanceFactory
    public T get(final ResolutionContext context) throws MissingScopeValueException {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!Intrinsics.areEqual(context.getScope().getScopeQualifier(), getBeanDefinition().getScopeQualifier()) && !Intrinsics.areEqual(context.getScopeArchetype(), getBeanDefinition().getScopeQualifier())) {
            throw new IllegalStateException(("Wrong Scope qualifier: trying to open instance for " + context.getScope().getId() + " in " + getBeanDefinition()).toString());
        }
        KoinPlatformTools.INSTANCE.m14541synchronized(this, new Function0() { // from class: org.koin.core.instance.ScopedInstanceFactory$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScopedInstanceFactory.get$lambda$1(this.f$0, context);
            }
        });
        T t = this.values.get(context.getScope().getId());
        if (t != null) {
            return t;
        }
        throw new MissingScopeValueException("Factory.get -Scoped instance not found for " + context.getScope().getId() + " in " + getBeanDefinition());
    }

    static final Unit get$lambda$1(ScopedInstanceFactory scopedInstanceFactory, ResolutionContext resolutionContext) {
        if (!scopedInstanceFactory.isCreated(resolutionContext) && scopedInstanceFactory.holdInstance) {
            scopedInstanceFactory.values.put(resolutionContext.getScope().getId(), super.create(resolutionContext));
        }
        return Unit.INSTANCE;
    }

    @Override // org.koin.core.instance.InstanceFactory
    public void dropAll() {
        this.values.clear();
    }

    public final void refreshInstance(String scopeID, Object instance) {
        Intrinsics.checkNotNullParameter(scopeID, "scopeID");
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.values.put(scopeID, instance);
    }
}
