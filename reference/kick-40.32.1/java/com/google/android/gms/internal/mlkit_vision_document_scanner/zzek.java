package com.google.android.gms.internal.mlkit_vision_document_scanner;

import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
final class zzek implements ObjectEncoder {
    static final zzek zza = new zzek();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("cameraSource");
        zzar zzarVar = new zzar();
        zzarVar.zza(1);
        zzb = builder.withProperty(zzarVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder(MixedWebViewEventConsumer.EVENT_TYPE_KEY);
        zzar zzarVar2 = new zzar();
        zzarVar2.zza(2);
        zzc = builder2.withProperty(zzarVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("requestedPreviewHeight");
        zzar zzarVar3 = new zzar();
        zzarVar3.zza(3);
        zzd = builder3.withProperty(zzarVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("requestedPreviewWidth");
        zzar zzarVar4 = new zzar();
        zzarVar4.zza(4);
        zze = builder4.withProperty(zzarVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("actualPreviewHeight");
        zzar zzarVar5 = new zzar();
        zzarVar5.zza(5);
        zzf = builder5.withProperty(zzarVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("actualPreviewWidth");
        zzar zzarVar6 = new zzar();
        zzarVar6.zza(6);
        zzg = builder6.withProperty(zzarVar6.zzb()).build();
    }

    private zzek() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
