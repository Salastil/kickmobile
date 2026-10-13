package org.koin.core.resolution;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.interfaces.permissions.PermissionsResponse;
import kotlin.Metadata;
import org.koin.core.instance.ResolutionContext;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: InstanceResolver.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lorg/koin/core/resolution/InstanceResolver;", "", "resolveFromContext", ExifInterface.GPS_DIRECTION_TRUE, PermissionsResponse.SCOPE_KEY, "Lorg/koin/core/scope/Scope;", "instanceContext", "Lorg/koin/core/instance/ResolutionContext;", "(Lorg/koin/core/scope/Scope;Lorg/koin/core/instance/ResolutionContext;)Ljava/lang/Object;", "koin-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface InstanceResolver {
    <T> T resolveFromContext(Scope scope, ResolutionContext instanceContext);
}
