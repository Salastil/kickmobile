package org.koin.core.instance;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.trace.bootstrap.instrumentation.api.SamplerConstants;
import expo.modules.interfaces.permissions.PermissionsResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: SingleInstanceFactory.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0015\u0010\u0014\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u0015R\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0017"}, d2 = {"Lorg/koin/core/instance/SingleInstanceFactory;", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/koin/core/instance/InstanceFactory;", "beanDefinition", "Lorg/koin/core/definition/BeanDefinition;", "<init>", "(Lorg/koin/core/definition/BeanDefinition;)V", "value", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "isCreated", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lorg/koin/core/instance/ResolutionContext;", SamplerConstants.DROP, "", PermissionsResponse.SCOPE_KEY, "Lorg/koin/core/scope/Scope;", "dropAll", "create", "(Lorg/koin/core/instance/ResolutionContext;)Ljava/lang/Object;", "get", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SingleInstanceFactory<T> extends InstanceFactory<T> {
    private T value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleInstanceFactory(BeanDefinition<T> beanDefinition) {
        super(beanDefinition);
        Intrinsics.checkNotNullParameter(beanDefinition, "beanDefinition");
    }

    private final T getValue() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Single instance created couldn't return value".toString());
    }

    @Override // org.koin.core.instance.InstanceFactory
    public boolean isCreated(ResolutionContext context) {
        return this.value != null;
    }

    @Override // org.koin.core.instance.InstanceFactory
    public void drop(Scope scope) {
        Function1<T, Unit> onClose = getBeanDefinition().getCallbacks().getOnClose();
        if (onClose != null) {
            onClose.invoke(this.value);
        }
        this.value = null;
    }

    @Override // org.koin.core.instance.InstanceFactory
    public void dropAll() {
        InstanceFactory.drop$default(this, null, 1, null);
    }

    @Override // org.koin.core.instance.InstanceFactory
    public T create(ResolutionContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.value == null) {
            return (T) super.create(context);
        }
        return getValue();
    }

    @Override // org.koin.core.instance.InstanceFactory
    public T get(final ResolutionContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        KoinPlatformTools.INSTANCE.m14541synchronized(this, new Function0() { // from class: org.koin.core.instance.SingleInstanceFactory$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SingleInstanceFactory.get$lambda$0(this.f$0, context);
            }
        });
        return getValue();
    }

    static final Unit get$lambda$0(SingleInstanceFactory singleInstanceFactory, ResolutionContext resolutionContext) {
        if (!singleInstanceFactory.isCreated(resolutionContext)) {
            singleInstanceFactory.value = (T) singleInstanceFactory.create(resolutionContext);
        }
        return Unit.INSTANCE;
    }
}
