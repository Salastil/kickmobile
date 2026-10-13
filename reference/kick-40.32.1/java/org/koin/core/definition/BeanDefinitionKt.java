package org.koin.core.definition;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.ext.KClassExtKt;

/* JADX INFO: compiled from: BeanDefinition.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\b\u001aw\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\t0\u000f\"\u0006\b\u0000\u0010\t\u0018\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052)\b\b\u0010\u0013\u001a#\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\t0\nj\b\u0012\u0004\u0012\u0002H\t`\u0014¢\u0006\u0002\b\r2\u0012\b\u0002\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00162\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\bø\u0001\u0000\u001aI\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\t0\u000f\"\u0006\b\u0000\u0010\t\u0018\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00162\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\b*\n\u0010\u0007\"\u00020\u00012\u00020\u0001*>\u0010\b\u001a\u0004\b\u0000\u0010\t\"\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\t0\n¢\u0006\u0002\b\r2\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\t0\n¢\u0006\u0002\b\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"indexKey", "", "clazz", "Lkotlin/reflect/KClass;", "typeQualifier", "Lorg/koin/core/qualifier/Qualifier;", "scopeQualifier", "IndexKey", "Definition", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lkotlin/ExtensionFunctionType;", "_createDefinition", "Lorg/koin/core/definition/BeanDefinition;", "kind", "Lorg/koin/core/definition/Kind;", "qualifier", "definition", "Lorg/koin/core/definition/Definition;", "secondaryTypes", "", "_createDeclaredDefinition", "koin-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BeanDefinitionKt {
    public static final String indexKey(KClass<?> clazz, Qualifier qualifier, Qualifier scopeQualifier) {
        String value;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        StringBuilder sb = new StringBuilder();
        sb.append(KClassExtKt.getFullName(clazz));
        sb.append(AbstractJsonLexerKt.COLON);
        if (qualifier == null || (value = qualifier.getValue()) == null) {
            value = "";
        }
        sb.append(value);
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(scopeQualifier);
        return sb.toString();
    }

    public static /* synthetic */ BeanDefinition _createDefinition$default(Kind kind, Qualifier qualifier, Function2 definition, List list, Qualifier scopeQualifier, int i, Object obj) {
        if ((i & 1) != 0) {
            kind = Kind.Singleton;
        }
        Kind kind2 = kind;
        if ((i & 2) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        if ((i & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        List secondaryTypes = list;
        Intrinsics.checkNotNullParameter(kind2, "kind");
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, definition, kind2, secondaryTypes);
    }

    public static final /* synthetic */ <T> BeanDefinition<T> _createDefinition(Kind kind, Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition, List<? extends KClass<?>> secondaryTypes, Qualifier scopeQualifier) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new BeanDefinition<>(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, kind, secondaryTypes);
    }

    public static /* synthetic */ BeanDefinition _createDeclaredDefinition$default(Kind kind, Qualifier qualifier, List list, Qualifier scopeQualifier, int i, Object obj) {
        if ((i & 1) != 0) {
            kind = Kind.Singleton;
        }
        Kind kind2 = kind;
        if ((i & 2) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        List secondaryTypes = list;
        Intrinsics.checkNotNullParameter(kind2, "kind");
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.needClassReification();
        return new BeanDefinition(scopeQualifier, orCreateKotlinClass, qualifier2, AnonymousClass1.INSTANCE, kind2, secondaryTypes);
    }

    public static final /* synthetic */ <T> BeanDefinition<T> _createDeclaredDefinition(Kind kind, Qualifier qualifier, List<? extends KClass<?>> secondaryTypes, Qualifier scopeQualifier) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.needClassReification();
        return new BeanDefinition<>(scopeQualifier, orCreateKotlinClass, qualifier, AnonymousClass1.INSTANCE, kind, secondaryTypes);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: org.koin.core.definition.BeanDefinitionKt$_createDeclaredDefinition$1, reason: invalid class name */
    /* JADX INFO: compiled from: BeanDefinition.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass1<T> implements Function2<Scope, ParametersHolder, T> {
        public static final AnonymousClass1 INSTANCE;

        static {
            Intrinsics.needClassReification();
            INSTANCE = new AnonymousClass1();
        }

        @Override // kotlin.jvm.functions.Function2
        public final T invoke(Scope BeanDefinition, ParametersHolder it) {
            Intrinsics.checkNotNullParameter(BeanDefinition, "$this$BeanDefinition");
            Intrinsics.checkNotNullParameter(it, "it");
            throw new IllegalStateException("declared instance error ".toString());
        }
    }
}
