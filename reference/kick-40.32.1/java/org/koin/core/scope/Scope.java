package org.koin.core.scope;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.koin.core.Koin;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.error.ClosedScopeException;
import org.koin.core.error.MissingPropertyException;
import org.koin.core.error.MissingScopeValueException;
import org.koin.core.error.NoDefinitionFoundException;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.ResolutionContext;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.KoinDslMarker;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.registry.InstanceRegistry;
import org.koin.core.registry.InstanceRegistry$scopeDeclaredInstance$definitionFunction$1;
import org.koin.core.time.DurationExtKt;
import org.koin.ext.KClassExtKt;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: Scope.kt */
/* JADX INFO: loaded from: classes11.dex */
@KoinDslMarker
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\"\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010 \u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070!H\u0007J\t\u0010*\u001a\u00020\tH\u0086\bJ\u001b\u0010?\u001a\u00020@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00000!H\u0000¢\u0006\u0002\bBJ\u001f\u0010C\u001a\u00020@2\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000E\"\u00020\u0000¢\u0006\u0002\u0010FJ\u001f\u0010G\u001a\u00020@2\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000E\"\u00020\u0000¢\u0006\u0002\u0010FJL\u0010H\u001a\b\u0012\u0004\u0012\u0002HJ0I\"\n\b\u0000\u0010J\u0018\u0001*\u00020\u00012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010L\u001a\u00020M2\u0016\b\n\u0010N\u001a\u0010\u0012\u0004\u0012\u000202\u0018\u00010Oj\u0004\u0018\u0001`PH\u0086\bø\u0001\u0000JN\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001HJ0I\"\n\b\u0000\u0010J\u0018\u0001*\u00020\u00012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010L\u001a\u00020M2\u0016\b\n\u0010N\u001a\u0010\u0012\u0004\u0012\u000202\u0018\u00010Oj\u0004\u0018\u0001`PH\u0086\bø\u0001\u0000JA\u0010R\u001a\u0002HJ\"\n\b\u0000\u0010J\u0018\u0001*\u00020\u00012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00042\u0016\b\n\u0010N\u001a\u0010\u0012\u0004\u0012\u000202\u0018\u00010Oj\u0004\u0018\u0001`PH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010SJ\u001c\u0010T\u001a\u0004\u0018\u0001HJ\"\n\b\u0000\u0010J\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0002\u0010%JC\u0010U\u001a\u0004\u0018\u0001HJ\"\n\b\u0000\u0010J\u0018\u0001*\u00020\u00012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00042\u0016\b\n\u0010N\u001a\u0010\u0012\u0004\u0012\u000202\u0018\u00010Oj\u0004\u0018\u0001`PH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010SJC\u0010U\u001a\u0004\u0018\u0001HJ\"\u0004\b\u0000\u0010J2\n\u0010V\u001a\u0006\u0012\u0002\b\u00030W2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010N\u001a\u0010\u0012\u0004\u0012\u000202\u0018\u00010Oj\u0004\u0018\u0001`P¢\u0006\u0002\u0010XJ\u001f\u0010U\u001a\u0004\u0018\u0001HJ\"\u0004\b\u0000\u0010J2\u0006\u0010Y\u001a\u00020ZH\u0000¢\u0006\u0004\b[\u0010\\JA\u0010R\u001a\u0002HJ\"\u0004\b\u0000\u0010J2\n\u0010V\u001a\u0006\u0012\u0002\b\u00030W2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010N\u001a\u0010\u0012\u0004\u0012\u000202\u0018\u00010Oj\u0004\u0018\u0001`P¢\u0006\u0002\u0010XJ7\u0010]\u001a\u0002HJ\"\u0004\b\u0000\u0010J2\n\u0010V\u001a\u0006\u0012\u0002\b\u00030W2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010N\u001a\u0004\u0018\u000102H\u0007¢\u0006\u0002\u0010^J5\u0010_\u001a\u0002HJ\"\u0004\b\u0000\u0010J2\n\u0010V\u001a\u0006\u0012\u0002\b\u00030W2\b\u0010K\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010N\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010^J\u001f\u0010`\u001a\u00020@2\n\u0010V\u001a\u0006\u0012\u0002\b\u00030W2\b\u0010K\u001a\u0004\u0018\u00010\u0004H\u0082\bJ$\u0010a\u001a\u00020@2\n\u0010V\u001a\u0006\u0012\u0002\b\u00030W2\u0006\u0010b\u001a\u00020cH\u0082\b¢\u0006\u0004\bd\u0010eJ3\u0010f\u001a\u0002HJ\"\u0004\b\u0000\u0010J2\b\u0010K\u001a\u0004\u0018\u00010\u00042\n\u0010V\u001a\u0006\u0012\u0002\b\u00030W2\b\u0010N\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u0010gJ\t\u0010h\u001a\u00020@H\u0082\bJ%\u0010i\u001a\u0002HJ\"\u0004\b\u0000\u0010J2\b\u0010N\u001a\u0004\u0018\u0001022\u0006\u0010j\u001a\u00020ZH\u0002¢\u0006\u0002\u0010kJ\u0016\u0010l\u001a\b\u0012\u0004\u0012\u000202012\u0006\u0010N\u001a\u000202H\u0002J\u0016\u0010m\u001a\u00020@2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020201H\u0002J\u000e\u0010o\u001a\b\u0012\u0004\u0012\u00020201H\u0002J\u001b\u0010p\u001a\u0002HJ\"\u0004\b\u0000\u0010J2\u0006\u0010j\u001a\u00020ZH\u0002¢\u0006\u0002\u0010\\JR\u0010q\u001a\u00020@\"\u0006\b\u0000\u0010J\u0018\u00012\u0006\u0010r\u001a\u0002HJ2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00042\u0012\b\u0002\u0010s\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030W0!2\b\b\u0002\u0010t\u001a\u00020\t2\b\b\u0002\u0010u\u001a\u00020\tH\u0086\b¢\u0006\u0002\u0010vJ\u0006\u0010w\u001a\u00020\rJ\u0012\u0010x\u001a\u00020\u00002\n\u0010y\u001a\u00060\u0006j\u0002`\u0007J\u000e\u0010z\u001a\u00020@2\u0006\u0010{\u001a\u00020-J\u001b\u0010|\u001a\b\u0012\u0004\u0012\u0002HJ0!\"\n\b\u0000\u0010J\u0018\u0001*\u00020\u0001H\u0086\bJ\u001e\u0010|\u001a\b\u0012\u0004\u0012\u0002HJ0!\"\u0004\b\u0000\u0010J2\n\u0010V\u001a\u0006\u0012\u0002\b\u00030WJ&\u0010}\u001a\u0002HJ\"\b\b\u0000\u0010J*\u00020\u00012\u0006\u0010~\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u0002HJ¢\u0006\u0003\u0010\u0080\u0001J!\u0010\u0081\u0001\u001a\u0004\u0018\u0001HJ\"\b\b\u0000\u0010J*\u00020\u00012\u0006\u0010~\u001a\u00020\u0006¢\u0006\u0003\u0010\u0082\u0001J\u001e\u0010}\u001a\u0002HJ\"\b\b\u0000\u0010J*\u00020\u00012\u0006\u0010~\u001a\u00020\u0006¢\u0006\u0003\u0010\u0082\u0001J\u0007\u0010\u0083\u0001\u001a\u00020@J\t\u0010\u0084\u0001\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\f\u001a\u00020\r8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u001cj\b\u0012\u0004\u0012\u00020\u0000`\u001dX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR&\u0010\"\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b)\u0010\u0014R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.X\u0082\u0004¢\u0006\u0002\n\u0000RF\u0010/\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020201\u0018\u000100j\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020201\u0018\u0001`38\u0000@\u0000X\u0081\u000e¢\u0006\u0016\n\u0002\u00109\u0012\u0004\b4\u0010\u0018\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u0010:\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010;\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\b=\u0010>\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0085\u0001"}, d2 = {"Lorg/koin/core/scope/Scope;", "", "Lorg/koin/mp/Lockable;", "scopeQualifier", "Lorg/koin/core/qualifier/Qualifier;", "id", "", "Lorg/koin/core/scope/ScopeID;", "isRoot", "", "scopeArchetype", "Lorg/koin/core/qualifier/TypeQualifier;", "_koin", "Lorg/koin/core/Koin;", "<init>", "(Lorg/koin/core/qualifier/Qualifier;Ljava/lang/String;ZLorg/koin/core/qualifier/TypeQualifier;Lorg/koin/core/Koin;)V", "getScopeQualifier", "()Lorg/koin/core/qualifier/Qualifier;", "getId", "()Ljava/lang/String;", "()Z", "getScopeArchetype", "()Lorg/koin/core/qualifier/TypeQualifier;", "get_koin$annotations", "()V", "get_koin", "()Lorg/koin/core/Koin;", "linkedScopes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLinkedScopes$koin_core", "()Ljava/util/ArrayList;", "getLinkedScopeIds", "", "sourceValue", "getSourceValue$annotations", "getSourceValue", "()Ljava/lang/Object;", "setSourceValue", "(Ljava/lang/Object;)V", "closed", "getClosed", "isNotClosed", "_callbacks", "Ljava/util/LinkedHashSet;", "Lorg/koin/core/scope/ScopeCallback;", "Lkotlin/collections/LinkedHashSet;", "parameterStack", "Ljava/lang/ThreadLocal;", "Lkotlin/collections/ArrayDeque;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/mp/ThreadLocal;", "getParameterStack$koin_core$annotations", "getParameterStack$koin_core", "()Ljava/lang/ThreadLocal;", "setParameterStack$koin_core", "(Ljava/lang/ThreadLocal;)V", "Ljava/lang/ThreadLocal;", "_closed", "logger", "Lorg/koin/core/logger/Logger;", "getLogger", "()Lorg/koin/core/logger/Logger;", "create", "", "links", "create$koin_core", "linkTo", "scopes", "", "([Lorg/koin/core/scope/Scope;)V", "unlink", "inject", "Lkotlin/Lazy;", ExifInterface.GPS_DIRECTION_TRUE, "qualifier", "mode", "Lkotlin/LazyThreadSafetyMode;", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersDefinition;", "injectOrNull", "get", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getSource", "getOrNull", "clazz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ctx", "Lorg/koin/core/instance/ResolutionContext;", "getOrNull$koin_core", "(Lorg/koin/core/instance/ResolutionContext;)Ljava/lang/Object;", "getWithParameters", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lorg/koin/core/parameter/ParametersHolder;)Ljava/lang/Object;", "resolve", "logInstanceRequest", "logInstanceDuration", "duration", "Lkotlin/time/Duration;", "logInstanceDuration-HG0u8IE", "(Lkotlin/reflect/KClass;J)V", "resolveInstance", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lorg/koin/core/parameter/ParametersHolder;)Ljava/lang/Object;", "checkScopeIsOpen", "stackParametersCall", "instanceContext", "(Lorg/koin/core/parameter/ParametersHolder;Lorg/koin/core/instance/ResolutionContext;)Ljava/lang/Object;", "onParameterOnStack", "clearParameterStack", "stack", "getOrCreateParameterStack", "resolveFromContext", "declare", "instance", "secondaryTypes", "allowOverride", "holdInstance", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;ZZ)V", "getKoin", "getScope", "scopeID", "registerCallback", "callback", "getAll", "getProperty", "key", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getPropertyOrNull", "(Ljava/lang/String;)Ljava/lang/Object;", "close", "toString", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Scope {
    private final LinkedHashSet<ScopeCallback> _callbacks;
    private boolean _closed;
    private final Koin _koin;
    private final String id;
    private final boolean isRoot;
    private final ArrayList<Scope> linkedScopes;
    private ThreadLocal<ArrayDeque<ParametersHolder>> parameterStack;
    private final TypeQualifier scopeArchetype;
    private final Qualifier scopeQualifier;
    private Object sourceValue;

    public static /* synthetic */ void getParameterStack$koin_core$annotations() {
    }

    public static /* synthetic */ void getSourceValue$annotations() {
    }

    public static /* synthetic */ void get_koin$annotations() {
    }

    public /* synthetic */ Scope(Qualifier qualifier, String str, boolean z, TypeQualifier typeQualifier, Koin koin, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(qualifier, str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : typeQualifier, koin);
    }

    public final Qualifier getScopeQualifier() {
        return this.scopeQualifier;
    }

    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: isRoot, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    public final TypeQualifier getScopeArchetype() {
        return this.scopeArchetype;
    }

    public final Koin get_koin() {
        return this._koin;
    }

    public Scope(Qualifier scopeQualifier, String id, boolean z, TypeQualifier typeQualifier, Koin _koin) {
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this.scopeQualifier = scopeQualifier;
        this.id = id;
        this.isRoot = z;
        this.scopeArchetype = typeQualifier;
        this._koin = _koin;
        this.linkedScopes = new ArrayList<>();
        this._callbacks = new LinkedHashSet<>();
    }

    public final ArrayList<Scope> getLinkedScopes$koin_core() {
        return this.linkedScopes;
    }

    public final List<String> getLinkedScopeIds() {
        ArrayList<Scope> arrayList = this.linkedScopes;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Scope) it.next()).id);
        }
        return arrayList2;
    }

    public final Object getSourceValue() {
        return this.sourceValue;
    }

    public final void setSourceValue(Object obj) {
        this.sourceValue = obj;
    }

    /* JADX INFO: renamed from: getClosed, reason: from getter */
    public final boolean get_closed() {
        return this._closed;
    }

    public final boolean isNotClosed() {
        return !get_closed();
    }

    public final ThreadLocal<ArrayDeque<ParametersHolder>> getParameterStack$koin_core() {
        return this.parameterStack;
    }

    public final void setParameterStack$koin_core(ThreadLocal<ArrayDeque<ParametersHolder>> threadLocal) {
        this.parameterStack = threadLocal;
    }

    public final Logger getLogger() {
        return this._koin.getLogger();
    }

    public final void create$koin_core(List<Scope> links) {
        Intrinsics.checkNotNullParameter(links, "links");
        this.linkedScopes.addAll(links);
    }

    public final void linkTo(Scope... scopes) {
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        if (!this.isRoot) {
            this.linkedScopes.addAll(0, ArraysKt.toList(scopes));
            return;
        }
        throw new IllegalStateException("Can't add scope link to a root scope".toString());
    }

    public final void unlink(Scope... scopes) {
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        if (!this.isRoot) {
            CollectionsKt.removeAll(this.linkedScopes, scopes);
            return;
        }
        throw new IllegalStateException("Can't remove scope link to a root scope".toString());
    }

    public static /* synthetic */ Lazy inject$default(Scope scope, Qualifier qualifier, LazyThreadSafetyMode mode, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            mode = LazyThreadSafetyMode.SYNCHRONIZED;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) scope.new C12061(qualifier, function0));
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: org.koin.core.scope.Scope$inject$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Scope.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class C12061<T> implements Function0<T> {
        final /* synthetic */ Function0<ParametersHolder> $parameters;
        final /* synthetic */ Qualifier $qualifier;

        /* JADX WARN: Multi-variable type inference failed */
        public C12061(Qualifier qualifier, Function0<? extends ParametersHolder> function0) {
            this.$qualifier = qualifier;
            this.$parameters = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            Scope scope = Scope.this;
            Qualifier qualifier = this.$qualifier;
            Function0<ParametersHolder> function0 = this.$parameters;
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) scope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
        }
    }

    public final /* synthetic */ <T> Lazy<T> inject(Qualifier qualifier, LazyThreadSafetyMode mode, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new C12061(qualifier, parameters));
    }

    public static /* synthetic */ Lazy injectOrNull$default(Scope scope, Qualifier qualifier, LazyThreadSafetyMode mode, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            mode = LazyThreadSafetyMode.SYNCHRONIZED;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) scope.new C12071(qualifier, function0));
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: org.koin.core.scope.Scope$injectOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Scope.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class C12071<T> implements Function0<T> {
        final /* synthetic */ Function0<ParametersHolder> $parameters;
        final /* synthetic */ Qualifier $qualifier;

        /* JADX WARN: Multi-variable type inference failed */
        public C12071(Qualifier qualifier, Function0<? extends ParametersHolder> function0) {
            this.$qualifier = qualifier;
            this.$parameters = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            Scope scope = Scope.this;
            Qualifier qualifier = this.$qualifier;
            Function0<ParametersHolder> function0 = this.$parameters;
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) scope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
        }
    }

    public final /* synthetic */ <T> Lazy<T> injectOrNull(Qualifier qualifier, LazyThreadSafetyMode mode, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new C12071(qualifier, parameters));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(Scope scope, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return scope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T get(Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, parameters);
    }

    public final /* synthetic */ <T> T getSource() {
        T t = (T) getSourceValue();
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getOrNull$default(Scope scope, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return scope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T getOrNull(Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getOrNull$default(Scope scope, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return scope.getOrNull(kClass, qualifier, function0);
    }

    public final <T> T getOrNull(KClass<?> clazz, Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            return (T) get(clazz, qualifier, parameters);
        } catch (ClosedScopeException unused) {
            this._koin.getLogger().debug("* Scope closed - no instance found for " + KClassExtKt.getFullName(clazz) + " on scope " + this);
            return null;
        } catch (MissingScopeValueException unused2) {
            this._koin.getLogger().debug("* No Scoped value found for type '" + KClassExtKt.getFullName(clazz) + "' on scope '" + this + '\'');
            return null;
        } catch (NoDefinitionFoundException unused3) {
            this._koin.getLogger().debug("* No instance found for type '" + KClassExtKt.getFullName(clazz) + "' on scope '" + this + '\'');
            return null;
        }
    }

    public final <T> T getOrNull$koin_core(ResolutionContext ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        try {
            return (T) getWithParameters(ctx.getClazz(), ctx.getQualifier(), ctx.getParameters());
        } catch (ClosedScopeException unused) {
            this._koin.getLogger().debug("* Scope closed - no instance found for " + KClassExtKt.getFullName(ctx.getClazz()) + " on scope " + this);
            return null;
        } catch (NoDefinitionFoundException unused2) {
            this._koin.getLogger().debug("* No instance found for type '" + KClassExtKt.getFullName(ctx.getClazz()) + "' on scope '" + this + '\'');
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(Scope scope, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return scope.get(kClass, qualifier, function0);
    }

    public final <T> T get(KClass<?> clazz, Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) resolve(clazz, qualifier, parameters != null ? parameters.invoke() : null);
    }

    public static /* synthetic */ Object getWithParameters$default(Scope scope, KClass kClass, Qualifier qualifier, ParametersHolder parametersHolder, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            parametersHolder = null;
        }
        return scope.getWithParameters(kClass, qualifier, parametersHolder);
    }

    public final <T> T getWithParameters(KClass<?> clazz, Qualifier qualifier, ParametersHolder parameters) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) resolve(clazz, qualifier, parameters);
    }

    static /* synthetic */ Object resolve$default(Scope scope, KClass kClass, Qualifier qualifier, ParametersHolder parametersHolder, int i, Object obj) {
        if ((i & 4) != 0) {
            parametersHolder = null;
        }
        return scope.resolve(kClass, qualifier, parametersHolder);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x002d  */
    private final <T> T resolve(KClass<?> clazz, Qualifier qualifier, ParametersHolder parameters) {
        String str;
        if (this._koin.getLogger().getLevel().compareTo(Level.DEBUG) > 0) {
            return (T) resolveInstance(qualifier, clazz, parameters);
        }
        String str2 = "";
        if (qualifier != null) {
            str = " with qualifier '" + qualifier + '\'';
            if (str == null) {
                str = "";
            }
        } else {
            str = "";
        }
        if (!this.isRoot) {
            str2 = " - scope:'" + this.id + '\'';
        }
        this._koin.getLogger().display(Level.DEBUG, "|- '" + KClassExtKt.getFullName(clazz) + '\'' + str + str2 + "...");
        TimedValue timedValue = new TimedValue(resolveInstance(qualifier, clazz, parameters), TimeSource.Monotonic.ValueTimeMark.m14186elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m14181markNowz9LOYto()), null);
        long jM14203getDurationUwyO8pc = timedValue.m14203getDurationUwyO8pc();
        this._koin.getLogger().display(Level.DEBUG, "|- '" + KClassExtKt.getFullName(clazz) + "' in " + DurationExtKt.m14540getInMsLRDsOJo(jM14203getDurationUwyO8pc) + " ms");
        return (T) timedValue.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0019  */
    private final void logInstanceRequest(KClass<?> clazz, Qualifier qualifier) {
        String str;
        String str2 = "";
        if (qualifier != null) {
            str = " with qualifier '" + qualifier + '\'';
            if (str == null) {
                str = "";
            }
        } else {
            str = "";
        }
        if (!this.isRoot) {
            str2 = " - scope:'" + this.id + '\'';
        }
        this._koin.getLogger().display(Level.DEBUG, "|- '" + KClassExtKt.getFullName(clazz) + '\'' + str + str2 + "...");
    }

    /* JADX INFO: renamed from: logInstanceDuration-HG0u8IE, reason: not valid java name */
    private final void m14539logInstanceDurationHG0u8IE(KClass<?> clazz, long duration) {
        this._koin.getLogger().display(Level.DEBUG, "|- '" + KClassExtKt.getFullName(clazz) + "' in " + DurationExtKt.m14540getInMsLRDsOJo(duration) + " ms");
    }

    private final void checkScopeIsOpen() throws ClosedScopeException {
        if (this._closed) {
            throw new ClosedScopeException("Scope '" + this.id + "' is closed");
        }
    }

    private final <T> T stackParametersCall(ParametersHolder parameters, ResolutionContext instanceContext) {
        if (parameters == null) {
            return (T) resolveFromContext(instanceContext);
        }
        Logger logger = this._koin.getLogger();
        Level level = Level.DEBUG;
        if (logger.getLevel().compareTo(level) <= 0) {
            logger.display(level, "| >> parameters " + parameters);
        }
        ArrayDeque<ParametersHolder> arrayDequeOnParameterOnStack = onParameterOnStack(parameters);
        try {
            return (T) resolveFromContext(instanceContext);
        } finally {
            this._koin.getLogger().debug("| << parameters");
            clearParameterStack(arrayDequeOnParameterOnStack);
        }
    }

    private final ArrayDeque<ParametersHolder> onParameterOnStack(ParametersHolder parameters) {
        ArrayDeque<ParametersHolder> orCreateParameterStack = getOrCreateParameterStack();
        orCreateParameterStack.addFirst(parameters);
        return orCreateParameterStack;
    }

    private final void clearParameterStack(ArrayDeque<ParametersHolder> stack) {
        stack.removeFirstOrNull();
        if (stack.isEmpty()) {
            ThreadLocal<ArrayDeque<ParametersHolder>> threadLocal = this.parameterStack;
            if (threadLocal != null) {
                threadLocal.remove();
            }
            this.parameterStack = null;
        }
    }

    private final ArrayDeque<ParametersHolder> getOrCreateParameterStack() {
        ArrayDeque<ParametersHolder> arrayDeque;
        ThreadLocal<ArrayDeque<ParametersHolder>> threadLocal = this.parameterStack;
        if (threadLocal != null && (arrayDeque = threadLocal.get()) != null) {
            return arrayDeque;
        }
        ArrayDeque<ParametersHolder> arrayDeque2 = new ArrayDeque<>();
        ThreadLocal<ArrayDeque<ParametersHolder>> threadLocal2 = new ThreadLocal<>();
        this.parameterStack = threadLocal2;
        threadLocal2.set(arrayDeque2);
        return arrayDeque2;
    }

    private final <T> T resolveFromContext(ResolutionContext instanceContext) {
        return (T) this._koin.getResolver().resolveFromContext(this, instanceContext);
    }

    public static /* synthetic */ void declare$default(Scope scope, Object obj, Qualifier qualifier, List list, boolean z, boolean z2, int i, Object obj2) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        List secondaryTypes = list;
        if ((i & 8) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            z2 = false;
        }
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.INSTANCE;
        Intrinsics.needClassReification();
        koinPlatformTools.m14541synchronized(scope, scope.new AnonymousClass1(obj, qualifier2, secondaryTypes, z3, z2));
    }

    /* JADX INFO: renamed from: org.koin.core.scope.Scope$declare$1, reason: invalid class name */
    /* JADX INFO: compiled from: Scope.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass1 implements Function0<Unit> {
        final /* synthetic */ boolean $allowOverride;
        final /* synthetic */ boolean $holdInstance;
        final /* synthetic */ T $instance;
        final /* synthetic */ Qualifier $qualifier;
        final /* synthetic */ List<KClass<?>> $secondaryTypes;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(T t, Qualifier qualifier, List<? extends KClass<?>> list, boolean z, boolean z2) {
            this.$instance = t;
            this.$qualifier = qualifier;
            this.$secondaryTypes = list;
            this.$allowOverride = z;
            this.$holdInstance = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String value;
            Function2 instanceRegistry$scopeDeclaredInstance$definitionFunction$1;
            String value2;
            InstanceRegistry instanceRegistry = Scope.this.get_koin().getInstanceRegistry();
            final T t = this.$instance;
            Qualifier scopeQualifier = Scope.this.getScopeQualifier();
            String id = Scope.this.getId();
            Qualifier qualifier = this.$qualifier;
            List<KClass<?>> list = this.$secondaryTypes;
            boolean z = this.$allowOverride;
            boolean z2 = this.$holdInstance;
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            StringBuilder sb = new StringBuilder();
            sb.append(KClassExtKt.getFullName(orCreateKotlinClass));
            sb.append(AbstractJsonLexerKt.COLON);
            if (qualifier == null || (value = qualifier.getValue()) == null) {
                value = "";
            }
            sb.append(value);
            sb.append(AbstractJsonLexerKt.COLON);
            sb.append(scopeQualifier);
            String string = sb.toString();
            InstanceFactory<?> instanceFactory = instanceRegistry.getInstances().get(string);
            ScopedInstanceFactory scopedInstanceFactory = instanceFactory instanceof ScopedInstanceFactory ? (ScopedInstanceFactory) instanceFactory : null;
            if (scopedInstanceFactory != null) {
                scopedInstanceFactory.saveValue(id, t);
                return;
            }
            if (z2) {
                Intrinsics.needClassReification();
                instanceRegistry$scopeDeclaredInstance$definitionFunction$1 = new Function2<Scope, ParametersHolder, T>() { // from class: org.koin.core.scope.Scope$declare$1$invoke$$inlined$scopeDeclaredInstance$1
                    @Override // kotlin.jvm.functions.Function2
                    public final T invoke(Scope scope, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(scope, "<this>");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return (T) t;
                    }
                };
            } else {
                instanceRegistry$scopeDeclaredInstance$definitionFunction$1 = new InstanceRegistry$scopeDeclaredInstance$definitionFunction$1(orCreateKotlinClass);
            }
            Function2 function2 = instanceRegistry$scopeDeclaredInstance$definitionFunction$1;
            Kind kind = Kind.Scoped;
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, kind, list);
            ScopedInstanceFactory scopedInstanceFactory2 = new ScopedInstanceFactory(beanDefinition, z2);
            ScopedInstanceFactory scopedInstanceFactory3 = scopedInstanceFactory2;
            InstanceRegistry.saveMapping$default(instanceRegistry, z, string, scopedInstanceFactory3, false, 8, null);
            Iterator<T> it = beanDefinition.getSecondaryTypes().iterator();
            while (it.hasNext()) {
                KClass kClass = (KClass) it.next();
                Qualifier qualifier2 = beanDefinition.getQualifier();
                Qualifier scopeQualifier2 = beanDefinition.getScopeQualifier();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(KClassExtKt.getFullName(kClass));
                sb2.append(AbstractJsonLexerKt.COLON);
                if (qualifier2 == null || (value2 = qualifier2.getValue()) == null) {
                    value2 = "";
                }
                sb2.append(value2);
                sb2.append(AbstractJsonLexerKt.COLON);
                sb2.append(scopeQualifier2);
                InstanceRegistry.saveMapping$default(instanceRegistry, z, sb2.toString(), scopedInstanceFactory3, false, 8, null);
            }
            scopedInstanceFactory2.saveValue(id, t);
        }
    }

    public final /* synthetic */ <T> void declare(T instance, Qualifier qualifier, List<? extends KClass<?>> secondaryTypes, boolean allowOverride, boolean holdInstance) {
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.INSTANCE;
        Intrinsics.needClassReification();
        koinPlatformTools.m14541synchronized(this, new AnonymousClass1(instance, qualifier, secondaryTypes, allowOverride, holdInstance));
    }

    /* JADX INFO: renamed from: getKoin, reason: from getter */
    public final Koin get_koin() {
        return this._koin;
    }

    public final Scope getScope(String scopeID) {
        Intrinsics.checkNotNullParameter(scopeID, "scopeID");
        return get_koin().getScope(scopeID);
    }

    public final void registerCallback(ScopeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this._callbacks.add(callback);
    }

    public final /* synthetic */ <T> List<T> getAll() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return getAll(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final <T> List<T> getAll(KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        List<T> all$koin_core = this._koin.getInstanceRegistry().getAll$koin_core(clazz, new ResolutionContext(this._koin.getLogger(), this, clazz, null, null, 24, null));
        ArrayList<Scope> arrayList = this.linkedScopes;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList2, ((Scope) it.next()).getAll(clazz));
        }
        return CollectionsKt.plus((Collection) all$koin_core, (Iterable) arrayList2);
    }

    public final <T> T getProperty(String key, T defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (T) this._koin.getProperty(key, defaultValue);
    }

    public final <T> T getPropertyOrNull(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this._koin.getProperty(key);
    }

    public final <T> T getProperty(String key) throws MissingPropertyException {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) this._koin.getProperty(key);
        if (t != null) {
            return t;
        }
        throw new MissingPropertyException("Property '" + key + "' not found");
    }

    public final void close() {
        KoinPlatformTools.INSTANCE.m14541synchronized(this, new Function0() { // from class: org.koin.core.scope.Scope$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Scope.close$lambda$7(this.f$0);
            }
        });
    }

    static final Unit close$lambda$7(Scope scope) {
        ArrayDeque<ParametersHolder> arrayDeque;
        scope._koin.getLogger().debug("|- (-) Scope - id:'" + scope.id + '\'');
        Iterator<T> it = scope._callbacks.iterator();
        while (it.hasNext()) {
            ((ScopeCallback) it.next()).onScopeClose(scope);
        }
        scope._callbacks.clear();
        scope._closed = true;
        scope.sourceValue = null;
        ThreadLocal<ArrayDeque<ParametersHolder>> threadLocal = scope.parameterStack;
        if (threadLocal != null && (arrayDeque = threadLocal.get()) != null) {
            arrayDeque.clear();
        }
        scope.parameterStack = null;
        scope._koin.getScopeRegistry().deleteScope$koin_core(scope);
        return Unit.INSTANCE;
    }

    public String toString() {
        return "['" + this.id + "']";
    }

    private final <T> T resolveInstance(Qualifier qualifier, KClass<?> clazz, ParametersHolder parameters) throws ClosedScopeException {
        if (!this._closed) {
            return (T) stackParametersCall(parameters, new ResolutionContext(this._koin.getLogger(), this, clazz, qualifier, parameters));
        }
        throw new ClosedScopeException("Scope '" + this.id + "' is closed");
    }
}
