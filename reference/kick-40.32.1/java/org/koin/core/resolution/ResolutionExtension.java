package org.koin.core.resolution;

import expo.modules.interfaces.permissions.PermissionsResponse;
import kotlin.Metadata;
import org.koin.core.instance.ResolutionContext;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: CoreResolver.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"Lorg/koin/core/resolution/ResolutionExtension;", "", "name", "", "getName", "()Ljava/lang/String;", "resolve", PermissionsResponse.SCOPE_KEY, "Lorg/koin/core/scope/Scope;", "instanceContext", "Lorg/koin/core/instance/ResolutionContext;", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ResolutionExtension {
    String getName();

    Object resolve(Scope scope, ResolutionContext instanceContext);
}
