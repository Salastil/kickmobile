package com.google.android.gms.internal.mlkit_vision_document_scanner;

import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
final class zzfj implements ObjectEncoder {
    static final zzfj zza = new zzfj();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;
    private static final FieldDescriptor zzk;
    private static final FieldDescriptor zzl;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("screenName");
        zzar zzarVar = new zzar();
        zzarVar.zza(1);
        zzb = builder.withProperty(zzarVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder(RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY);
        zzar zzarVar2 = new zzar();
        zzarVar2.zza(2);
        zzc = builder2.withProperty(zzarVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("timestampMs");
        zzar zzarVar3 = new zzar();
        zzarVar3.zza(3);
        zzd = builder3.withProperty(zzarVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("options");
        zzar zzarVar4 = new zzar();
        zzarVar4.zza(4);
        zze = builder4.withProperty(zzarVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("elementName");
        zzar zzarVar5 = new zzar();
        zzarVar5.zza(5);
        zzf = builder5.withProperty(zzarVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("isAutoCaptureMode");
        zzar zzarVar6 = new zzar();
        zzarVar6.zza(6);
        zzg = builder6.withProperty(zzarVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("pageIndex");
        zzar zzarVar7 = new zzar();
        zzarVar7.zza(7);
        zzh = builder7.withProperty(zzarVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("appliedToAllPages");
        zzar zzarVar8 = new zzar();
        zzarVar8.zza(8);
        zzi = builder8.withProperty(zzarVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("errorCode");
        zzar zzarVar9 = new zzar();
        zzarVar9.zza(9);
        zzj = builder9.withProperty(zzarVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("callerAppId");
        zzar zzarVar10 = new zzar();
        zzarVar10.zza(10);
        zzk = builder10.withProperty(zzarVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("cleanUpStrokeSize");
        zzar zzarVar11 = new zzar();
        zzarVar11.zza(11);
        zzl = builder11.withProperty(zzarVar11.zzb()).build();
    }

    private zzfj() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
