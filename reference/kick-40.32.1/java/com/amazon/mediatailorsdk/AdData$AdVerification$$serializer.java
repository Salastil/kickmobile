package com.amazon.mediatailorsdk;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: AdData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/amazon/mediatailorsdk/AdData.AdVerification.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/amazon/mediatailorsdk/AdData$AdVerification;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdData$AdVerification$$serializer implements GeneratedSerializer<AdData.AdVerification> {
    public static final AdData$AdVerification$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AdData$AdVerification$$serializer adData$AdVerification$$serializer = new AdData$AdVerification$$serializer();
        INSTANCE = adData$AdVerification$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.amazon.mediatailorsdk.AdData.AdVerification", adData$AdVerification$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("executableResource", true);
        pluginGeneratedSerialDescriptor.addElement("javaScriptResource", true);
        pluginGeneratedSerialDescriptor.addElement("trackingEvents", true);
        pluginGeneratedSerialDescriptor.addElement("vendor", true);
        pluginGeneratedSerialDescriptor.addElement("verificationParameters", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdData$AdVerification$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr = AdData.AdVerification.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable((KSerializer) lazyArr[0].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[1].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final AdData.AdVerification deserialize(Decoder decoder) {
        int i;
        AdData.AdVerification.ExecutableResource[] executableResourceArr;
        AdData.AdVerification.JavaScriptResource[] javaScriptResourceArr;
        AdData.AdVerification.TrackingEvent[] trackingEventArr;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = AdData.AdVerification.$childSerializers;
        int i2 = 0;
        AdData.AdVerification.ExecutableResource[] executableResourceArr2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            AdData.AdVerification.ExecutableResource[] executableResourceArr3 = (AdData.AdVerification.ExecutableResource[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
            AdData.AdVerification.JavaScriptResource[] javaScriptResourceArr2 = (AdData.AdVerification.JavaScriptResource[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            trackingEventArr = (AdData.AdVerification.TrackingEvent[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            executableResourceArr = executableResourceArr3;
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            i = 31;
            javaScriptResourceArr = javaScriptResourceArr2;
        } else {
            int i3 = 1;
            int i4 = 0;
            AdData.AdVerification.JavaScriptResource[] javaScriptResourceArr3 = null;
            AdData.AdVerification.TrackingEvent[] trackingEventArr2 = null;
            String str3 = null;
            String str4 = null;
            while (i3 != 0) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                int i5 = i2;
                if (iDecodeElementIndex == -1) {
                    i2 = i5;
                    i3 = i2;
                } else if (iDecodeElementIndex != 0) {
                    if (iDecodeElementIndex == 1) {
                        javaScriptResourceArr3 = (AdData.AdVerification.JavaScriptResource[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), javaScriptResourceArr3);
                        i4 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        trackingEventArr2 = (AdData.AdVerification.TrackingEvent[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), trackingEventArr2);
                        i4 |= 4;
                    } else if (iDecodeElementIndex == 3) {
                        str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str3);
                        i4 |= 8;
                    } else {
                        if (iDecodeElementIndex != 4) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str4);
                        i4 |= 16;
                    }
                    i2 = i5;
                } else {
                    executableResourceArr2 = (AdData.AdVerification.ExecutableResource[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, (DeserializationStrategy) lazyArr[i5].getValue(), executableResourceArr2);
                    i4 |= 1;
                    i2 = i5;
                }
            }
            i = i4;
            executableResourceArr = executableResourceArr2;
            javaScriptResourceArr = javaScriptResourceArr3;
            trackingEventArr = trackingEventArr2;
            str = str3;
            str2 = str4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AdData.AdVerification(i, executableResourceArr, javaScriptResourceArr, trackingEventArr, str, str2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, AdData.AdVerification value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        AdData.AdVerification.write$Self$MediaTailor_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
