package org.koin.mp;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.context.KoinContext;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.logger.PrintLogger;

/* JADX INFO: compiled from: KoinPlatformTools.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bJ\u0012\u0010\t\u001a\u00020\u00052\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u00052\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J+\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\n\u0010\u0017\u001a\u00060\u0001j\u0002`\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00160\u001a¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f0\u001d\"\u0004\b\u0000\u0010\u001e\"\u0004\b\u0001\u0010\u001fJ\u0012\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001e0!\"\u0004\b\u0000\u0010\u001e¨\u0006\""}, d2 = {"Lorg/koin/mp/KoinPlatformTools;", "", "<init>", "()V", "getStackTrace", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getClassName", "kClass", "Lkotlin/reflect/KClass;", "getClassFullNameOrNull", "defaultLazyMode", "Lkotlin/LazyThreadSafetyMode;", "defaultLogger", "Lorg/koin/core/logger/Logger;", FirebaseAnalytics.Param.LEVEL, "Lorg/koin/core/logger/Level;", "defaultContext", "Lorg/koin/core/context/KoinContext;", "synchronized", "R", "lock", "Lorg/koin/mp/Lockable;", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "safeHashMap", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "safeSet", "", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KoinPlatformTools {
    public static final KoinPlatformTools INSTANCE = new KoinPlatformTools();

    private KoinPlatformTools() {
    }

    public static /* synthetic */ Logger defaultLogger$default(KoinPlatformTools koinPlatformTools, Level level, int i, Object obj) {
        if ((i & 1) != 0) {
            level = Level.INFO;
        }
        return koinPlatformTools.defaultLogger(level);
    }

    public final String getStackTrace(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        StringBuilder sb = new StringBuilder();
        sb.append(e);
        sb.append(InstanceFactory.ERROR_SEPARATOR);
        StackTraceElement[] stackTrace = e.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "getStackTrace(...)");
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
            if (StringsKt.contains$default((CharSequence) className, (CharSequence) "sun.reflect", false, 2, (Object) null)) {
                break;
            }
            arrayList.add(stackTraceElement);
        }
        sb.append(CollectionsKt.joinToString$default(arrayList, InstanceFactory.ERROR_SEPARATOR, null, null, 0, null, null, 62, null));
        return sb.toString();
    }

    public final String getClassName(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        String name = JvmClassMappingKt.getJavaClass((KClass) kClass).getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    public final String getClassFullNameOrNull(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        return kClass.getQualifiedName();
    }

    public final LazyThreadSafetyMode defaultLazyMode() {
        return LazyThreadSafetyMode.SYNCHRONIZED;
    }

    public final Logger defaultLogger(Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        return new PrintLogger(level);
    }

    public final KoinContext defaultContext() {
        return GlobalContext.INSTANCE;
    }

    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public final <R> R m14541synchronized(Object lock, Function0<? extends R> block) {
        R rInvoke;
        Intrinsics.checkNotNullParameter(lock, "lock");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (lock) {
            rInvoke = block.invoke();
        }
        return rInvoke;
    }

    public final <K, V> Map<K, V> safeHashMap() {
        return new ConcurrentHashMap();
    }

    public final <K> Set<K> safeSet() {
        Set<K> setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.checkNotNullExpressionValue(setNewSetFromMap, "newSetFromMap(...)");
        return setNewSetFromMap;
    }
}
