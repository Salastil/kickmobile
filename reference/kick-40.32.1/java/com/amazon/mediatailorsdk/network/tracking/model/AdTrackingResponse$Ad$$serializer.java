package com.amazon.mediatailorsdk.network.tracking.model;

import com.amazon.mediatailorsdk.AdData;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: AdTrackingResponse.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse.Ad.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Ad;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdTrackingResponse$Ad$$serializer implements GeneratedSerializer<AdTrackingResponse.Ad> {
    public static final AdTrackingResponse$Ad$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AdTrackingResponse$Ad$$serializer adTrackingResponse$Ad$$serializer = new AdTrackingResponse$Ad$$serializer();
        INSTANCE = adTrackingResponse$Ad$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse.Ad", adTrackingResponse$Ad$$serializer, 18);
        pluginGeneratedSerialDescriptor.addElement("startTime", true);
        pluginGeneratedSerialDescriptor.addElement("startTimeInSeconds", true);
        pluginGeneratedSerialDescriptor.addElement("adProgramDateTime", true);
        pluginGeneratedSerialDescriptor.addElement("duration", true);
        pluginGeneratedSerialDescriptor.addElement("durationInSeconds", true);
        pluginGeneratedSerialDescriptor.addElement("adId", true);
        pluginGeneratedSerialDescriptor.addElement("adParameters", true);
        pluginGeneratedSerialDescriptor.addElement("adSystem", true);
        pluginGeneratedSerialDescriptor.addElement("adTitle", true);
        pluginGeneratedSerialDescriptor.addElement("adVerifications", true);
        pluginGeneratedSerialDescriptor.addElement("icons", true);
        pluginGeneratedSerialDescriptor.addElement("companionAds", true);
        pluginGeneratedSerialDescriptor.addElement("creativeId", true);
        pluginGeneratedSerialDescriptor.addElement("creativeSequence", true);
        pluginGeneratedSerialDescriptor.addElement("extensions", true);
        pluginGeneratedSerialDescriptor.addElement("trackingEvents", true);
        pluginGeneratedSerialDescriptor.addElement("vastAdId", true);
        pluginGeneratedSerialDescriptor.addElement("skipOffset", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdTrackingResponse$Ad$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr = AdTrackingResponse.Ad.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[9].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[10].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[11].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[14].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[15].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final AdTrackingResponse.Ad deserialize(Decoder decoder) {
        String str;
        AdData.Icon[] iconArr;
        String str2;
        AdData.TrackingEvent[] trackingEventArr;
        AdData.Extension[] extensionArr;
        String str3;
        String str4;
        String str5;
        String str6;
        int i;
        AdData.AdVerification[] adVerificationArr;
        String str7;
        AdData.CompanionAd[] companionAdArr;
        String str8;
        String str9;
        String str10;
        String str11;
        Double d;
        Double d2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = AdTrackingResponse.Ad.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            Double d3 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, DoubleSerializer.INSTANCE, null);
            String str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            String str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            d = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, DoubleSerializer.INSTANCE, null);
            String str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, null);
            String str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, null);
            String str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, null);
            String str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, null);
            AdData.AdVerification[] adVerificationArr2 = (AdData.AdVerification[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), null);
            AdData.Icon[] iconArr2 = (AdData.Icon[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), null);
            companionAdArr = (AdData.CompanionAd[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, (DeserializationStrategy) lazyArr[11].getValue(), null);
            String str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, null);
            String str20 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, null);
            AdData.Extension[] extensionArr2 = (AdData.Extension[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 14, (DeserializationStrategy) lazyArr[14].getValue(), null);
            AdData.TrackingEvent[] trackingEventArr2 = (AdData.TrackingEvent[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 15, (DeserializationStrategy) lazyArr[15].getValue(), null);
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, null);
            str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, null);
            str9 = str16;
            i = 262143;
            trackingEventArr = trackingEventArr2;
            extensionArr = extensionArr2;
            str = str20;
            str3 = str19;
            str8 = str13;
            adVerificationArr = adVerificationArr2;
            str6 = str17;
            str5 = str18;
            iconArr = iconArr2;
            str10 = str15;
            str7 = str14;
            str11 = str12;
            d2 = d3;
        } else {
            int i2 = 9;
            boolean z = true;
            String str21 = null;
            AdData.Icon[] iconArr3 = null;
            String str22 = null;
            String str23 = null;
            String str24 = null;
            String str25 = null;
            Double d4 = null;
            AdData.AdVerification[] adVerificationArr3 = null;
            String str26 = null;
            String str27 = null;
            String str28 = null;
            String str29 = null;
            AdData.Extension[] extensionArr3 = null;
            AdData.TrackingEvent[] trackingEventArr3 = null;
            String str30 = null;
            String str31 = null;
            int i3 = 10;
            int i4 = 0;
            Double d5 = null;
            AdData.CompanionAd[] companionAdArr2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        str30 = str30;
                        z = false;
                        iconArr3 = iconArr3;
                        i2 = 9;
                        i3 = 10;
                        str30 = str30;
                        break;
                    case 0:
                        str31 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str31);
                        i4 |= 1;
                        iconArr3 = iconArr3;
                        str21 = str21;
                        i2 = 9;
                        i3 = 10;
                        str30 = str30;
                        break;
                    case 1:
                        d5 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, DoubleSerializer.INSTANCE, d5);
                        i4 |= 2;
                        iconArr3 = iconArr3;
                        str21 = str21;
                        i2 = 9;
                        i3 = 10;
                        str30 = str30;
                        break;
                    case 2:
                        str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str22);
                        i4 |= 4;
                        str21 = str21;
                        d5 = d5;
                        i2 = 9;
                        i3 = 10;
                        str30 = str30;
                        break;
                    case 3:
                        str27 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str27);
                        i4 |= 8;
                        str21 = str21;
                        d5 = d5;
                        i2 = 9;
                        i3 = 10;
                        str30 = str30;
                        break;
                    case 4:
                        d4 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, DoubleSerializer.INSTANCE, d4);
                        i4 |= 16;
                        str21 = str21;
                        d5 = d5;
                        i2 = 9;
                        i3 = 10;
                        str30 = str30;
                        break;
                    case 5:
                        str26 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str26);
                        i4 |= 32;
                        str21 = str21;
                        d5 = d5;
                        i2 = 9;
                        i3 = 10;
                        str30 = str30;
                        break;
                    case 6:
                        str25 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str25);
                        i4 |= 64;
                        str21 = str21;
                        d5 = d5;
                        i2 = 9;
                        i3 = 10;
                        str30 = str30;
                        break;
                    case 7:
                        str24 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str24);
                        i4 |= 128;
                        str21 = str21;
                        d5 = d5;
                        i2 = 9;
                        i3 = 10;
                        str30 = str30;
                        break;
                    case 8:
                        str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str23);
                        i4 |= 256;
                        str21 = str21;
                        d5 = d5;
                        i2 = 9;
                        i3 = 10;
                        str30 = str30;
                        break;
                    case 9:
                        str30 = str30;
                        adVerificationArr3 = (AdData.AdVerification[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, (DeserializationStrategy) lazyArr[i2].getValue(), adVerificationArr3);
                        i4 |= 512;
                        str21 = str21;
                        d5 = d5;
                        i3 = 10;
                        str30 = str30;
                        break;
                    case 10:
                        str30 = str30;
                        iconArr3 = (AdData.Icon[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, (DeserializationStrategy) lazyArr[i3].getValue(), iconArr3);
                        i4 |= 1024;
                        str28 = str28;
                        str21 = str21;
                        d5 = d5;
                        str30 = str30;
                        break;
                    case 11:
                        str30 = str30;
                        companionAdArr2 = (AdData.CompanionAd[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, (DeserializationStrategy) lazyArr[11].getValue(), companionAdArr2);
                        i4 |= 2048;
                        str21 = str21;
                        d5 = d5;
                        str30 = str30;
                        break;
                    case 12:
                        str30 = str30;
                        str28 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str28);
                        i4 |= 4096;
                        str29 = str29;
                        str21 = str21;
                        d5 = d5;
                        str30 = str30;
                        break;
                    case 13:
                        str30 = str30;
                        str29 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str29);
                        i4 |= 8192;
                        extensionArr3 = extensionArr3;
                        str21 = str21;
                        d5 = d5;
                        str30 = str30;
                        break;
                    case 14:
                        str30 = str30;
                        extensionArr3 = (AdData.Extension[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 14, (DeserializationStrategy) lazyArr[14].getValue(), extensionArr3);
                        i4 |= 16384;
                        trackingEventArr3 = trackingEventArr3;
                        str21 = str21;
                        d5 = d5;
                        str30 = str30;
                        break;
                    case 15:
                        str30 = str30;
                        trackingEventArr3 = (AdData.TrackingEvent[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 15, (DeserializationStrategy) lazyArr[15].getValue(), trackingEventArr3);
                        i4 |= 32768;
                        str21 = str21;
                        d5 = d5;
                        str30 = str30;
                        break;
                    case 16:
                        i4 |= 65536;
                        str21 = str21;
                        str30 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str30);
                        d5 = d5;
                        break;
                    case 17:
                        str21 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str21);
                        i4 |= 131072;
                        d5 = d5;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = str29;
            iconArr = iconArr3;
            str2 = str30;
            trackingEventArr = trackingEventArr3;
            extensionArr = extensionArr3;
            str3 = str28;
            str4 = str21;
            str5 = str23;
            str6 = str24;
            i = i4;
            adVerificationArr = adVerificationArr3;
            str7 = str27;
            companionAdArr = companionAdArr2;
            str8 = str22;
            str9 = str25;
            str10 = str26;
            str11 = str31;
            d = d4;
            d2 = d5;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AdTrackingResponse.Ad(i, str11, d2, str8, str7, d, str10, str9, str6, str5, adVerificationArr, iconArr, companionAdArr, str3, str, extensionArr, trackingEventArr, str2, str4, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, AdTrackingResponse.Ad value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        AdTrackingResponse.Ad.write$Self$MediaTailor_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
