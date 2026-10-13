package org.koin.core.module.dsl;

import androidx.media3.muxer.WebmConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.dsl.ScopeDSL;

/* JADX INFO: compiled from: ScopedOf.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a]\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001ak\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001*\u00020\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u00020\u00072-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001ay\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001*\u00020\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00020\u000e2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a\u0087\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001*\u00020\u00032 \b\u0004\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00020\u00102-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a\u0095\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001*\u00020\u00032&\b\u0004\u0010\u0004\u001a \u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00020\u00122-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a£\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001*\u00020\u00032,\b\u0004\u0010\u0004\u001a&\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00020\u00142-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a±\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001*\u00020\u000322\b\u0004\u0010\u0004\u001a,\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00020\u00162-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a¿\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001*\u00020\u000328\b\u0004\u0010\u0004\u001a2\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00020\u00182-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001aÍ\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001*\u00020\u00032>\b\u0004\u0010\u0004\u001a8\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u00020\u001a2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001aÛ\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001*\u00020\u00032D\b\u0004\u0010\u0004\u001a>\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u00020\u001c2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001aé\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001*\u00020\u00032J\b\u0004\u0010\u0004\u001aD\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u00020\u001e2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a÷\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001*\u00020\u00032P\b\u0004\u0010\u0004\u001aJ\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H\u00020 2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a\u0085\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001*\u00020\u00032V\b\u0004\u0010\u0004\u001aP\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\u00020\"2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a\u0093\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001*\u00020\u00032\\\b\u0004\u0010\u0004\u001aV\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H\u00020$2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a¡\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001*\u00020\u00032b\b\u0004\u0010\u0004\u001a\\\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H\u00020&2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a¯\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001*\u00020\u00032h\b\u0004\u0010\u0004\u001ab\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H\u00020(2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a½\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001\"\u0006\b\u0010\u0010)\u0018\u0001*\u00020\u00032n\b\u0004\u0010\u0004\u001ah\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H\u00020*2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001aË\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001\"\u0006\b\u0010\u0010)\u0018\u0001\"\u0006\b\u0011\u0010+\u0018\u0001*\u00020\u00032t\b\u0004\u0010\u0004\u001an\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u0002H\u00020,2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001aÙ\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001\"\u0006\b\u0010\u0010)\u0018\u0001\"\u0006\b\u0011\u0010+\u0018\u0001\"\u0006\b\u0012\u0010-\u0018\u0001*\u00020\u00032z\b\u0004\u0010\u0004\u001at\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H\u00020.2-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001aè\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001\"\u0006\b\u0010\u0010)\u0018\u0001\"\u0006\b\u0011\u0010+\u0018\u0001\"\u0006\b\u0012\u0010-\u0018\u0001\"\u0006\b\u0013\u0010/\u0018\u0001*\u00020\u00032\u0080\u0001\b\u0004\u0010\u0004\u001az\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u0002H\u0002002-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a÷\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001\"\u0006\b\u0010\u0010)\u0018\u0001\"\u0006\b\u0011\u0010+\u0018\u0001\"\u0006\b\u0012\u0010-\u0018\u0001\"\u0006\b\u0013\u0010/\u0018\u0001\"\u0006\b\u0014\u00101\u0018\u0001*\u00020\u00032\u0087\u0001\b\u0004\u0010\u0004\u001a\u0080\u0001\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u0002H1\u0012\u0004\u0012\u0002H\u0002022-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a\u0085\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001\"\u0006\b\u0010\u0010)\u0018\u0001\"\u0006\b\u0011\u0010+\u0018\u0001\"\u0006\b\u0012\u0010-\u0018\u0001\"\u0006\b\u0013\u0010/\u0018\u0001\"\u0006\b\u0014\u00101\u0018\u0001\"\u0006\b\u0015\u00103\u0018\u0001*\u00020\u00032\u008d\u0001\b\u0004\u0010\u0004\u001a\u0086\u0001\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u0002H1\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H\u0002042-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a\u0093\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\f\u0018\u0001\"\u0006\b\u0002\u0010\r\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0011\u0018\u0001\"\u0006\b\u0005\u0010\u0013\u0018\u0001\"\u0006\b\u0006\u0010\u0015\u0018\u0001\"\u0006\b\u0007\u0010\u0017\u0018\u0001\"\u0006\b\b\u0010\u0019\u0018\u0001\"\u0006\b\t\u0010\u001b\u0018\u0001\"\u0006\b\n\u0010\u001d\u0018\u0001\"\u0006\b\u000b\u0010\u001f\u0018\u0001\"\u0006\b\f\u0010!\u0018\u0001\"\u0006\b\r\u0010#\u0018\u0001\"\u0006\b\u000e\u0010%\u0018\u0001\"\u0006\b\u000f\u0010'\u0018\u0001\"\u0006\b\u0010\u0010)\u0018\u0001\"\u0006\b\u0011\u0010+\u0018\u0001\"\u0006\b\u0012\u0010-\u0018\u0001\"\u0006\b\u0013\u0010/\u0018\u0001\"\u0006\b\u0014\u00101\u0018\u0001\"\u0006\b\u0015\u00103\u0018\u0001\"\u0006\b\u0016\u00105\u0018\u0001*\u00020\u00032\u0093\u0001\b\u0004\u0010\u0004\u001a\u008c\u0001\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u0002H1\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H5\u0012\u0004\u0012\u0002H\u0002062-\b\n\u0010\u0006\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\n\u0012\u0004\u0012\u0002H\u0002\u0018\u0001`\u000b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00067"}, d2 = {"scopedOf", "Lorg/koin/core/definition/KoinDefinition;", "R", "Lorg/koin/dsl/ScopeDSL;", "constructor", "Lkotlin/Function0;", "options", "Lkotlin/Function1;", "Lorg/koin/core/definition/BeanDefinition;", "", "Lkotlin/ExtensionFunctionType;", "Lorg/koin/core/module/dsl/DefinitionOptions;", "T1", "T2", "Lkotlin/Function2;", "T3", "Lkotlin/Function3;", "T4", "Lkotlin/Function4;", "T5", "Lkotlin/Function5;", "T6", "Lkotlin/Function6;", "T7", "Lkotlin/Function7;", "T8", "Lkotlin/Function8;", "T9", "Lkotlin/Function9;", "T10", "Lkotlin/Function10;", "T11", "Lkotlin/Function11;", "T12", "Lkotlin/Function12;", "T13", "Lkotlin/Function13;", "T14", "Lkotlin/Function14;", "T15", "Lkotlin/Function15;", "T16", "Lkotlin/Function16;", "T17", "Lkotlin/Function17;", "T18", "Lkotlin/Function18;", "T19", "Lkotlin/Function19;", "T20", "Lkotlin/Function20;", "T21", "Lkotlin/Function21;", "T22", "Lkotlin/Function22;", "koin-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ScopedOfKt {
    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function0 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass1, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass1<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function0<R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function0<? extends R> function0) {
            this.$constructor = function0;
        }

        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            return this.$constructor.invoke();
        }
    }

    public static final /* synthetic */ <R> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function0<? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass1, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function1 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass2, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$2, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass2<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function1<T1, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super T1, ? extends R> function1) {
            this.$constructor = function1;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function1<T1, R> function1 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            return function1.invoke((T1) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function1<? super T1, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass2, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function2 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass3, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$3, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass3<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function2<T1, T2, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function2<? super T1, ? super T2, ? extends R> function2) {
            this.$constructor = function2;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function2<T1, T2, R> function2 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            return function2.invoke((T1) obj, (T2) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function2<? super T1, ? super T2, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass3, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function3 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass4, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$4, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass4<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function3<T1, T2, T3, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
            this.$constructor = function3;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function3<T1, T2, T3, R> function3 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            return function3.invoke((T1) obj, (T2) obj2, (T3) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function3<? super T1, ? super T2, ? super T3, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass4, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function4 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass5, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$5, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass5<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function4<T1, T2, T3, T4, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass5(Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
            this.$constructor = function4;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function4<T1, T2, T3, T4, R> function4 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            return function4.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass5, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function5 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass6 anonymousClass6 = new AnonymousClass6(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass6, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$6, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass6<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function5<T1, T2, T3, T4, T5, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass6(Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
            this.$constructor = function5;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function5<T1, T2, T3, T4, T5, R> function5 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            return function5.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass6 anonymousClass6 = new AnonymousClass6(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass6, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function6 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass7, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$7, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass7<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function6<T1, T2, T3, T4, T5, T6, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
            this.$constructor = function6;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function6<T1, T2, T3, T4, T5, T6, R> function6 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            return function6.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass7, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function7 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass8 anonymousClass8 = new AnonymousClass8(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass8, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$8, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass8<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function7<T1, T2, T3, T4, T5, T6, T7, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass8(Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
            this.$constructor = function7;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function7<T1, T2, T3, T4, T5, T6, T7, R> function7 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            return function7.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass8 anonymousClass8 = new AnonymousClass8(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass8, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function8 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass9 anonymousClass9 = new AnonymousClass9(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass9, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$9, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass9<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass9(Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
            this.$constructor = function8;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            Object obj7 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T8");
            return function8.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) obj7, (T8) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass9 anonymousClass9 = new AnonymousClass9(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass9, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function9 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass10 anonymousClass10 = new AnonymousClass10(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass10, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$10, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass10<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass10(Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
            this.$constructor = function9;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            Object obj7 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T8");
            Object obj8 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T9");
            return function9.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) obj7, (T8) obj8, (T9) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass10 anonymousClass10 = new AnonymousClass10(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass10, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function10 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass11 anonymousClass11 = new AnonymousClass11(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass11, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$11, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass11<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass11(Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10) {
            this.$constructor = function10;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> function10 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            Object obj7 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T8");
            Object obj8 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T9");
            Object obj9 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T10");
            return function10.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) obj7, (T8) obj8, (T9) obj9, (T10) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass11 anonymousClass11 = new AnonymousClass11(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass11, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function11 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass12 anonymousClass12 = new AnonymousClass12(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass12, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$12, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass12<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass12(Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> function11) {
            this.$constructor = function11;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> function11 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            Object obj7 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T8");
            Object obj8 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T9");
            Object obj9 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T10");
            Object obj10 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T11");
            return function11.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) obj7, (T8) obj8, (T9) obj9, (T10) obj10, (T11) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass12 anonymousClass12 = new AnonymousClass12(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass12, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function12 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass13 anonymousClass13 = new AnonymousClass13(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass13, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$13, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass13<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass13(Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> function12) {
            this.$constructor = function12;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> function12 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            Object obj7 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T8");
            Object obj8 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T9");
            Object obj9 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T10");
            Object obj10 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T11");
            Object obj11 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T12");
            return function12.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) obj7, (T8) obj8, (T9) obj9, (T10) obj10, (T11) obj11, (T12) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass13 anonymousClass13 = new AnonymousClass13(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass13, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function13 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass14 anonymousClass14 = new AnonymousClass14(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass14, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$14, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass14<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass14(Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> function13) {
            this.$constructor = function13;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> function13 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            Object obj7 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T8");
            Object obj8 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T9");
            Object obj9 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T10");
            Object obj10 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T11");
            Object obj11 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T12");
            Object obj12 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T13");
            return function13.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) obj7, (T8) obj8, (T9) obj9, (T10) obj10, (T11) obj11, (T12) obj12, (T13) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass14 anonymousClass14 = new AnonymousClass14(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass14, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function14 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass15 anonymousClass15 = new AnonymousClass15(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass15, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$15, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass15<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass15(Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> function14) {
            this.$constructor = function14;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> function14 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            Object obj7 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T8");
            Object obj8 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T9");
            Object obj9 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T10");
            Object obj10 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T11");
            Object obj11 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T12");
            Object obj12 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T13");
            Object obj13 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T14");
            return function14.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) obj7, (T8) obj8, (T9) obj9, (T10) obj10, (T11) obj11, (T12) obj12, (T13) obj13, (T14) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass15 anonymousClass15 = new AnonymousClass15(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass15, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function15 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass16 anonymousClass16 = new AnonymousClass16(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass16, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$16, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass16<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass16(Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> function15) {
            this.$constructor = function15;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> function15 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            Object obj7 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T8");
            Object obj8 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T9");
            Object obj9 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T10");
            Object obj10 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T11");
            Object obj11 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T12");
            Object obj12 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T13");
            Object obj13 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T14");
            Object obj14 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T15");
            return function15.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) obj7, (T8) obj8, (T9) obj9, (T10) obj10, (T11) obj11, (T12) obj12, (T13) obj13, (T14) obj14, (T15) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass16 anonymousClass16 = new AnonymousClass16(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass16, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function16 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass17 anonymousClass17 = new AnonymousClass17(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass17, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$17, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass17<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass17(Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> function16) {
            this.$constructor = function16;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> function16 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            Object obj7 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T8");
            Object obj8 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T9");
            Object obj9 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T10");
            Object obj10 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T11");
            Object obj11 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T12");
            Object obj12 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T13");
            Object obj13 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T14");
            Object obj14 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T15");
            Object obj15 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T16");
            return function16.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) obj7, (T8) obj8, (T9) obj9, (T10) obj10, (T11) obj11, (T12) obj12, (T13) obj13, (T14) obj14, (T15) obj15, (T16) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass17 anonymousClass17 = new AnonymousClass17(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass17, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function17 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass18 anonymousClass18 = new AnonymousClass18(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass18, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$18, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass18<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass18(Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> function17) {
            this.$constructor = function17;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> function17 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            Object obj7 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T8");
            Object obj8 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T9");
            Object obj9 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T10");
            Object obj10 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T11");
            Object obj11 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T12");
            Object obj12 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T13");
            Object obj13 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T14");
            Object obj14 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T15");
            Object obj15 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T16");
            Object obj16 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T17");
            return function17.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) obj7, (T8) obj8, (T9) obj9, (T10) obj10, (T11) obj11, (T12) obj12, (T13) obj13, (T14) obj14, (T15) obj15, (T16) obj16, (T17) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass18 anonymousClass18 = new AnonymousClass18(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass18, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function18 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass19 anonymousClass19 = new AnonymousClass19(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass19, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$19, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass19<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass19(Function18<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? extends R> function18) {
            this.$constructor = function18;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> function18 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            Object obj7 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T8");
            Object obj8 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T9");
            Object obj9 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T10");
            Object obj10 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T11");
            Object obj11 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T12");
            Object obj12 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T13");
            Object obj13 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T14");
            Object obj14 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T15");
            Object obj15 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T16");
            Object obj16 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T17");
            Object obj17 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T18");
            return function18.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) obj7, (T8) obj8, (T9) obj9, (T10) obj10, (T11) obj11, (T12) obj12, (T13) obj13, (T14) obj14, (T15) obj15, (T16) obj16, (T17) obj17, (T18) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function18<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass19 anonymousClass19 = new AnonymousClass19(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass19, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function19 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass20 anonymousClass20 = new AnonymousClass20(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass20, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$20, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass20<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass20(Function19<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? extends R> function19) {
            this.$constructor = function19;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> function19 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            Object obj7 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T8");
            Object obj8 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T9");
            Object obj9 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T10");
            Object obj10 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T11");
            Object obj11 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T12");
            Object obj12 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T13");
            Object obj13 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T14");
            Object obj14 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T15");
            Object obj15 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T16");
            Object obj16 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T17");
            Object obj17 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T18");
            Object obj18 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T19");
            return function19.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) obj7, (T8) obj8, (T9) obj9, (T10) obj10, (T11) obj11, (T12) obj12, (T13) obj13, (T14) obj14, (T15) obj15, (T16) obj16, (T17) obj17, (T18) obj18, (T19) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function19<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass20 anonymousClass20 = new AnonymousClass20(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass20, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function20 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass21 anonymousClass21 = new AnonymousClass21(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass21, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$21, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass21<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass21(Function20<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? extends R> function20) {
            this.$constructor = function20;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> function20 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            Object obj7 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T8");
            Object obj8 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T9");
            Object obj9 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T10");
            Object obj10 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T11");
            Object obj11 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T12");
            Object obj12 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T13");
            Object obj13 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T14");
            Object obj14 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T15");
            Object obj15 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T16");
            Object obj16 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T17");
            Object obj17 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T18");
            Object obj18 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T19");
            Object obj19 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T20");
            return function20.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) obj7, (T8) obj8, (T9) obj9, (T10) obj10, (T11) obj11, (T12) obj12, (T13) obj13, (T14) obj14, (T15) obj15, (T16) obj16, (T17) obj17, (T18) obj18, (T19) obj19, (T20) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function20<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass21 anonymousClass21 = new AnonymousClass21(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass21, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function21 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass22 anonymousClass22 = new AnonymousClass22(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass22, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$22, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass22<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass22(Function21<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? extends R> function21) {
            this.$constructor = function21;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> function21 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            Object obj7 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T8");
            Object obj8 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T9");
            Object obj9 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T10");
            Object obj10 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T11");
            Object obj11 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T12");
            Object obj12 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T13");
            Object obj13 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T14");
            Object obj14 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T15");
            Object obj15 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T16");
            Object obj16 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T17");
            Object obj17 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T18");
            Object obj18 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T19");
            Object obj19 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T20");
            Object obj20 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T21");
            return function21.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) obj7, (T8) obj8, (T9) obj9, (T10) obj10, (T11) obj11, (T12) obj12, (T13) obj13, (T14) obj14, (T15) obj15, (T16) obj16, (T17) obj17, (T18) obj18, (T19) obj19, (T20) obj20, (T21) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function21<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass22 anonymousClass22 = new AnonymousClass22(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass22, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    public static /* synthetic */ KoinDefinition scopedOf$default(ScopeDSL scopeDSL, Function22 constructor, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass23 anonymousClass23 = new AnonymousClass23(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass23, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.core.module.dsl.ScopedOfKt$scopedOf$23, reason: invalid class name */
    /* JADX INFO: compiled from: ScopedOf.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass23<R> implements Function2<Scope, ParametersHolder, R> {
        final /* synthetic */ Function22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> $constructor;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass23(Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> function22) {
            this.$constructor = function22;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(it, "it");
            Function22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> function22 = this.$constructor;
            Intrinsics.reifiedOperationMarker(4, "T1");
            Object obj = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T2");
            Object obj2 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T3");
            Object obj3 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T4");
            Object obj4 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T5");
            Object obj5 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T6");
            Object obj6 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T7");
            Object obj7 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T8");
            Object obj8 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T9");
            Object obj9 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T10");
            Object obj10 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T11");
            Object obj11 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T12");
            Object obj12 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T13");
            Object obj13 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T14");
            Object obj14 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T15");
            Object obj15 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T16");
            Object obj16 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T17");
            Object obj17 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T18");
            Object obj18 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T19");
            Object obj19 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T20");
            Object obj20 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T21");
            Object obj21 = scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null);
            Intrinsics.reifiedOperationMarker(4, "T22");
            return function22.invoke((T1) obj, (T2) obj2, (T3) obj3, (T4) obj4, (T5) obj5, (T6) obj6, (T7) obj7, (T8) obj8, (T9) obj9, (T10) obj10, (T11) obj11, (T12) obj12, (T13) obj13, (T14) obj14, (T15) obj15, (T16) obj16, (T17) obj17, (T18) obj18, (T19) obj19, (T20) obj20, (T21) obj21, (T22) scoped.get(Reflection.getOrCreateKotlinClass(Object.class), null, null));
        }
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> KoinDefinition<R> scopedOf(ScopeDSL scopeDSL, Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.needClassReification();
        AnonymousClass23 anonymousClass23 = new AnonymousClass23(constructor);
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), null, anonymousClass23, kind, listEmptyList), false, 2, null);
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return OptionDSLKt.onOptions(new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory), function1);
    }
}
