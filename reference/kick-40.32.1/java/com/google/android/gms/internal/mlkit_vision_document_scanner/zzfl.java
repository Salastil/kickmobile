package com.google.android.gms.internal.mlkit_vision_document_scanner;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
final class zzfl implements ObjectEncoder {
    static final zzfl zza = new zzfl();
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
    private static final FieldDescriptor zzm;
    private static final FieldDescriptor zzn;
    private static final FieldDescriptor zzo;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("initialImageUriCount");
        zzar zzarVar = new zzar();
        zzarVar.zza(1);
        zzb = builder.withProperty(zzarVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("defaultCaptureMode");
        zzar zzarVar2 = new zzar();
        zzarVar2.zza(2);
        zzc = builder2.withProperty(zzarVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("flashModeChangeAllowed");
        zzar zzarVar3 = new zzar();
        zzarVar3.zza(3);
        zzd = builder3.withProperty(zzarVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("galleryImportAllowed");
        zzar zzarVar4 = new zzar();
        zzarVar4.zza(4);
        zze = builder4.withProperty(zzarVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("multiPageAllowed");
        zzar zzarVar5 = new zzar();
        zzarVar5.zza(5);
        zzf = builder5.withProperty(zzarVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("filterAllowed");
        zzar zzarVar6 = new zzar();
        zzarVar6.zza(6);
        zzg = builder6.withProperty(zzarVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("targetResolutionWidth");
        zzar zzarVar7 = new zzar();
        zzarVar7.zza(7);
        zzh = builder7.withProperty(zzarVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("targetResolutionHeight");
        zzar zzarVar8 = new zzar();
        zzarVar8.zza(8);
        zzi = builder8.withProperty(zzarVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("resultFormats");
        zzar zzarVar9 = new zzar();
        zzarVar9.zza(9);
        zzj = builder9.withProperty(zzarVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("pageEditListenerSet");
        zzar zzarVar10 = new zzar();
        zzarVar10.zza(10);
        zzk = builder10.withProperty(zzarVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("shadowRemovalAllowed");
        zzar zzarVar11 = new zzar();
        zzarVar11.zza(11);
        zzl = builder11.withProperty(zzarVar11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("stainRemovalAllowed");
        zzar zzarVar12 = new zzar();
        zzarVar12.zza(12);
        zzm = builder12.withProperty(zzarVar12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("enableAllNewFeaturesByDefault");
        zzar zzarVar13 = new zzar();
        zzarVar13.zza(13);
        zzn = builder13.withProperty(zzarVar13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("pageLimitMax");
        zzar zzarVar14 = new zzar();
        zzarVar14.zza(14);
        zzo = builder14.withProperty(zzarVar14.zzb()).build();
    }

    private zzfl() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzlq zzlqVar = (zzlq) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzlqVar.zzk());
        objectEncoderContext2.add(zzc, zzlqVar.zzb());
        objectEncoderContext2.add(zzd, zzlqVar.zze());
        objectEncoderContext2.add(zze, zzlqVar.zzf());
        objectEncoderContext2.add(zzf, zzlqVar.zzg());
        objectEncoderContext2.add(zzg, zzlqVar.zzd());
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, (Object) null);
        objectEncoderContext2.add(zzj, zzlqVar.zza());
        objectEncoderContext2.add(zzk, zzlqVar.zzh());
        objectEncoderContext2.add(zzl, zzlqVar.zzi());
        objectEncoderContext2.add(zzm, zzlqVar.zzj());
        objectEncoderContext2.add(zzn, zzlqVar.zzc());
        objectEncoderContext2.add(zzo, zzlqVar.zzl());
    }
}
