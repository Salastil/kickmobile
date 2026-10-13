package com.google.android.gms.internal.mlkit_vision_document_scanner;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
final class zzib implements ObjectEncoder {
    static final zzib zza = new zzib();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("inferenceCommonLogEvent");
        zzar zzarVar = new zzar();
        zzarVar.zza(1);
        zzb = builder.withProperty(zzarVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("imageInfo");
        zzar zzarVar2 = new zzar();
        zzarVar2.zza(2);
        zzc = builder2.withProperty(zzarVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("captionCount");
        zzar zzarVar3 = new zzar();
        zzarVar3.zza(4);
        zzd = builder3.withProperty(zzarVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("highestScore");
        zzar zzarVar4 = new zzar();
        zzarVar4.zza(5);
        zze = builder4.withProperty(zzarVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("imageType");
        zzar zzarVar5 = new zzar();
        zzarVar5.zza(6);
        zzf = builder5.withProperty(zzarVar5.zzb()).build();
    }

    private zzib() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
