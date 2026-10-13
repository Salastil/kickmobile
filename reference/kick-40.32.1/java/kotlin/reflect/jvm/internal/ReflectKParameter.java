package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.KParameter;

/* JADX INFO: compiled from: ReflectKCallable.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectKParameter;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/ReflectKCallable;", "getCallable", "()Lkotlin/reflect/jvm/internal/ReflectKCallable;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ReflectKParameter extends KParameter {
    ReflectKCallable<?> getCallable();
}
