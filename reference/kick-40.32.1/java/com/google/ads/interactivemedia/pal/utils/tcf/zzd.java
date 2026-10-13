package com.google.ads.interactivemedia.pal.utils.tcf;

import com.google.android.gms.internal.pal.zznp;
import com.google.android.gms.internal.pal.zzup;
import com.google.android.gms.internal.pal.zzuw;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzd {
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static boolean zza(zzc zzcVar, boolean z, boolean z2) {
        if (!zzcVar.zzb().booleanValue() || zzcVar.zza().equals("tcunavailable") || zzcVar.zza().isEmpty()) {
            return true;
        }
        zzup zzupVar = zzup.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        Integer num = zzb.zza;
        Map map = (Map) zzcVar.zzl().get(zzupVar);
        return (map == null ? null : (zzuw) map.get(num)) != zzuw.PURPOSE_RESTRICTION_NOT_ALLOWED && zzc(zzcVar.zzi(), num) && ((zzupVar.equals(zzupVar) && zzcVar.zzf() && zzcVar.zze().equals("CH")) || zzc(zzcVar.zzg(), zzupVar));
    }

    public static boolean zzb(zzc zzcVar) {
        if (!zzcVar.zzb().booleanValue() || zzcVar.zza().equals("tcunavailable") || zzcVar.zzk() == null) {
            return true;
        }
        zznp zznpVarZzk = zzcVar.zzk();
        zznp zznpVarZza = zznp.zza();
        if (zznpVarZzk == null) {
            zznpVarZzk = zznpVarZza;
        }
        zznp zznpVarZzi = zzcVar.zzi();
        Integer num = zzb.zza;
        return zzc(zznpVarZzi, num) || zzc(zzcVar.zzj(), num) || zzc(zznpVarZzk, num);
    }

    private static boolean zzc(Map map, Object obj) {
        Boolean bool = (Boolean) map.get(obj);
        return bool != null && bool.booleanValue();
    }
}
