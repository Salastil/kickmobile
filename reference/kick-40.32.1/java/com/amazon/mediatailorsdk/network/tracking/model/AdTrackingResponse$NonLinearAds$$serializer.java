package com.amazon.mediatailorsdk.network.tracking.model;

import com.amazon.mediatailorsdk.NonLinearAdsData;
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

/* JADX INFO: compiled from: AdTrackingResponse.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse.NonLinearAds.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdTrackingResponse$NonLinearAds$$serializer implements GeneratedSerializer<AdTrackingResponse.NonLinearAds> {
    public static final AdTrackingResponse$NonLinearAds$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AdTrackingResponse$NonLinearAds$$serializer adTrackingResponse$NonLinearAds$$serializer = new AdTrackingResponse$NonLinearAds$$serializer();
        INSTANCE = adTrackingResponse$NonLinearAds$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse.NonLinearAds", adTrackingResponse$NonLinearAds$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("nonLinearAdList", true);
        pluginGeneratedSerialDescriptor.addElement("extensions", true);
        pluginGeneratedSerialDescriptor.addElement("trackingEvents", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdTrackingResponse$NonLinearAds$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr = AdTrackingResponse.NonLinearAds.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable((KSerializer) lazyArr[0].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[1].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue())};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final AdTrackingResponse.NonLinearAds deserialize(Decoder decoder) {
        int i;
        NonLinearAdsData.NonLinearAd[] nonLinearAdArr;
        NonLinearAdsData.Extension[] extensionArr;
        NonLinearAdsData.TrackingEvent[] trackingEventArr;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = AdTrackingResponse.NonLinearAds.$childSerializers;
        NonLinearAdsData.NonLinearAd[] nonLinearAdArr2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            NonLinearAdsData.NonLinearAd[] nonLinearAdArr3 = (NonLinearAdsData.NonLinearAd[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
            NonLinearAdsData.Extension[] extensionArr2 = (NonLinearAdsData.Extension[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            trackingEventArr = (NonLinearAdsData.TrackingEvent[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            nonLinearAdArr = nonLinearAdArr3;
            i = 7;
            extensionArr = extensionArr2;
        } else {
            boolean z = true;
            int i2 = 0;
            NonLinearAdsData.Extension[] extensionArr3 = null;
            NonLinearAdsData.TrackingEvent[] trackingEventArr2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    nonLinearAdArr2 = (NonLinearAdsData.NonLinearAd[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), nonLinearAdArr2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    extensionArr3 = (NonLinearAdsData.Extension[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), extensionArr3);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    trackingEventArr2 = (NonLinearAdsData.TrackingEvent[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), trackingEventArr2);
                    i2 |= 4;
                }
            }
            i = i2;
            nonLinearAdArr = nonLinearAdArr2;
            extensionArr = extensionArr3;
            trackingEventArr = trackingEventArr2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AdTrackingResponse.NonLinearAds(i, nonLinearAdArr, extensionArr, trackingEventArr, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, AdTrackingResponse.NonLinearAds value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        AdTrackingResponse.NonLinearAds.write$Self$MediaTailor_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
