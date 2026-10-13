package com.amazon.mediatailorsdk;

import androidx.compose.runtime.composer.linkbuffer.GroupFlagsSpec;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: AdData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/amazon/mediatailorsdk/NonLinearAdsData.NonLinearAd.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/amazon/mediatailorsdk/NonLinearAdsData$NonLinearAd;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class NonLinearAdsData$NonLinearAd$$serializer implements GeneratedSerializer<NonLinearAdsData.NonLinearAd> {
    public static final NonLinearAdsData$NonLinearAd$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        NonLinearAdsData$NonLinearAd$$serializer nonLinearAdsData$NonLinearAd$$serializer = new NonLinearAdsData$NonLinearAd$$serializer();
        INSTANCE = nonLinearAdsData$NonLinearAd$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.amazon.mediatailorsdk.NonLinearAdsData.NonLinearAd", nonLinearAdsData$NonLinearAd$$serializer, 23);
        pluginGeneratedSerialDescriptor.addElement("durationInSeconds", true);
        pluginGeneratedSerialDescriptor.addElement("adId", true);
        pluginGeneratedSerialDescriptor.addElement("adParameters", true);
        pluginGeneratedSerialDescriptor.addElement("adSystem", true);
        pluginGeneratedSerialDescriptor.addElement("adTitle", true);
        pluginGeneratedSerialDescriptor.addElement("creativeId", true);
        pluginGeneratedSerialDescriptor.addElement("creativeAdId", true);
        pluginGeneratedSerialDescriptor.addElement("creativeSequence", true);
        pluginGeneratedSerialDescriptor.addElement(ViewProps.WIDTH, true);
        pluginGeneratedSerialDescriptor.addElement(ViewProps.HEIGHT, true);
        pluginGeneratedSerialDescriptor.addElement("expandedWidth", true);
        pluginGeneratedSerialDescriptor.addElement("expandedHeight", true);
        pluginGeneratedSerialDescriptor.addElement("scalable", true);
        pluginGeneratedSerialDescriptor.addElement("maintainAspectRatio", true);
        pluginGeneratedSerialDescriptor.addElement("minSuggestedDuration", true);
        pluginGeneratedSerialDescriptor.addElement("apiFramework", true);
        pluginGeneratedSerialDescriptor.addElement("staticResource", true);
        pluginGeneratedSerialDescriptor.addElement("staticResourceCreativeType", true);
        pluginGeneratedSerialDescriptor.addElement("iFrameResource", true);
        pluginGeneratedSerialDescriptor.addElement("htmlResource", true);
        pluginGeneratedSerialDescriptor.addElement("clickThrough", true);
        pluginGeneratedSerialDescriptor.addElement("clickTracking", true);
        pluginGeneratedSerialDescriptor.addElement("clickTrackingId", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private NonLinearAdsData$NonLinearAd$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final NonLinearAdsData.NonLinearAd deserialize(Decoder decoder) {
        int i;
        String str;
        Double d;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        Boolean bool;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        Boolean bool2;
        int i2;
        int i3;
        String str21;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Double d2 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, DoubleSerializer.INSTANCE, null);
            String str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            String str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            String str24 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            String str25 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            String str26 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, null);
            String str27 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, null);
            String str28 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, null);
            String str29 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, null);
            String str30 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, null);
            String str31 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, null);
            String str32 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, null);
            Boolean bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, BooleanSerializer.INSTANCE, null);
            Boolean bool4 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, BooleanSerializer.INSTANCE, null);
            String str33 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, null);
            String str34 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, null);
            String str35 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, null);
            String str36 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, null);
            String str37 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, null);
            String str38 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 19, StringSerializer.INSTANCE, null);
            String str39 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 20, StringSerializer.INSTANCE, null);
            String str40 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, null);
            String str41 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 22, StringSerializer.INSTANCE, null);
            i = GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
            str4 = str39;
            str14 = str38;
            str = str41;
            str17 = str32;
            str13 = str31;
            str12 = str30;
            str16 = str37;
            str15 = str36;
            str18 = str35;
            str19 = str34;
            str20 = str33;
            bool = bool4;
            bool2 = bool3;
            d = d2;
            str3 = str40;
            str8 = str26;
            str6 = str24;
            str7 = str25;
            str11 = str29;
            str5 = str23;
            str2 = str22;
            str9 = str27;
            str10 = str28;
        } else {
            boolean z = true;
            Boolean bool5 = null;
            String str42 = null;
            String str43 = null;
            String str44 = null;
            String str45 = null;
            String str46 = null;
            String str47 = null;
            Boolean bool6 = null;
            String str48 = null;
            String str49 = null;
            String str50 = null;
            String str51 = null;
            Double d3 = null;
            String str52 = null;
            String str53 = null;
            String str54 = null;
            String str55 = null;
            String str56 = null;
            String str57 = null;
            String str58 = null;
            String str59 = null;
            String str60 = null;
            i = 0;
            String str61 = null;
            while (z) {
                String str62 = str49;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        bool5 = bool5;
                        str42 = str42;
                        str45 = str45;
                        str21 = str62;
                        z = false;
                        str49 = str21;
                        str42 = str42;
                        bool5 = bool5;
                        str45 = str45;
                        break;
                    case 0:
                        str21 = str62;
                        d3 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, DoubleSerializer.INSTANCE, d3);
                        i |= 1;
                        str48 = str48;
                        str49 = str21;
                        str42 = str42;
                        bool5 = bool5;
                        str45 = str45;
                        break;
                    case 1:
                        bool5 = bool5;
                        str42 = str42;
                        str45 = str45;
                        str21 = str62;
                        str52 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str52);
                        i |= 2;
                        str48 = str48;
                        str53 = str53;
                        str49 = str21;
                        str42 = str42;
                        bool5 = bool5;
                        str45 = str45;
                        break;
                    case 2:
                        bool5 = bool5;
                        str42 = str42;
                        str45 = str45;
                        str21 = str62;
                        str53 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str53);
                        i |= 4;
                        str48 = str48;
                        str54 = str54;
                        str49 = str21;
                        str42 = str42;
                        bool5 = bool5;
                        str45 = str45;
                        break;
                    case 3:
                        bool5 = bool5;
                        str42 = str42;
                        str45 = str45;
                        str21 = str62;
                        str54 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str54);
                        i |= 8;
                        str48 = str48;
                        str55 = str55;
                        str49 = str21;
                        str42 = str42;
                        bool5 = bool5;
                        str45 = str45;
                        break;
                    case 4:
                        bool5 = bool5;
                        str42 = str42;
                        str45 = str45;
                        str21 = str62;
                        str55 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str55);
                        i |= 16;
                        str48 = str48;
                        str56 = str56;
                        str49 = str21;
                        str42 = str42;
                        bool5 = bool5;
                        str45 = str45;
                        break;
                    case 5:
                        bool5 = bool5;
                        str42 = str42;
                        str45 = str45;
                        str21 = str62;
                        str56 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str56);
                        i |= 32;
                        str48 = str48;
                        str57 = str57;
                        str49 = str21;
                        str42 = str42;
                        bool5 = bool5;
                        str45 = str45;
                        break;
                    case 6:
                        bool5 = bool5;
                        str42 = str42;
                        str45 = str45;
                        str21 = str62;
                        str57 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str57);
                        i |= 64;
                        str48 = str48;
                        str58 = str58;
                        str49 = str21;
                        str42 = str42;
                        bool5 = bool5;
                        str45 = str45;
                        break;
                    case 7:
                        bool5 = bool5;
                        str42 = str42;
                        str45 = str45;
                        str21 = str62;
                        str58 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str58);
                        i |= 128;
                        str48 = str48;
                        str59 = str59;
                        str49 = str21;
                        str42 = str42;
                        bool5 = bool5;
                        str45 = str45;
                        break;
                    case 8:
                        bool5 = bool5;
                        str42 = str42;
                        str45 = str45;
                        str21 = str62;
                        str59 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str59);
                        i |= 256;
                        str48 = str48;
                        str60 = str60;
                        str49 = str21;
                        str42 = str42;
                        bool5 = bool5;
                        str45 = str45;
                        break;
                    case 9:
                        str21 = str62;
                        str60 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str60);
                        i |= 512;
                        str48 = str48;
                        str49 = str21;
                        str42 = str42;
                        bool5 = bool5;
                        str45 = str45;
                        break;
                    case 10:
                        bool5 = bool5;
                        str45 = str45;
                        str42 = str42;
                        i |= 1024;
                        str49 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str62);
                        str48 = str48;
                        str42 = str42;
                        bool5 = bool5;
                        str45 = str45;
                        break;
                    case 11:
                        str48 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str48);
                        i |= 2048;
                        str45 = str45;
                        bool5 = bool5;
                        str49 = str62;
                        break;
                    case 12:
                        str45 = str45;
                        str48 = str48;
                        bool6 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, BooleanSerializer.INSTANCE, bool6);
                        i |= 4096;
                        str45 = str45;
                        str49 = str62;
                        str48 = str48;
                        break;
                    case 13:
                        str45 = str45;
                        str48 = str48;
                        bool5 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, BooleanSerializer.INSTANCE, bool5);
                        i |= 8192;
                        str45 = str45;
                        str49 = str62;
                        str48 = str48;
                        break;
                    case 14:
                        str45 = str45;
                        str48 = str48;
                        str61 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str61);
                        i |= 16384;
                        str45 = str45;
                        str49 = str62;
                        str48 = str48;
                        break;
                    case 15:
                        str47 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str47);
                        i2 = 32768;
                        i |= i2;
                        str45 = str45;
                        str49 = str62;
                        str48 = str48;
                        break;
                    case 16:
                        str46 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str46);
                        i2 = 65536;
                        i |= i2;
                        str45 = str45;
                        str49 = str62;
                        str48 = str48;
                        break;
                    case 17:
                        str43 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str43);
                        i2 = 131072;
                        i |= i2;
                        str45 = str45;
                        str49 = str62;
                        str48 = str48;
                        break;
                    case 18:
                        str44 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, str44);
                        i2 = 262144;
                        i |= i2;
                        str45 = str45;
                        str49 = str62;
                        str48 = str48;
                        break;
                    case 19:
                        str42 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 19, StringSerializer.INSTANCE, str42);
                        i2 = 524288;
                        i |= i2;
                        str45 = str45;
                        str49 = str62;
                        str48 = str48;
                        break;
                    case 20:
                        str51 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 20, StringSerializer.INSTANCE, str51);
                        i3 = 1048576;
                        i |= i3;
                        str49 = str62;
                        str48 = str48;
                        break;
                    case 21:
                        str50 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, str50);
                        i3 = 2097152;
                        i |= i3;
                        str49 = str62;
                        str48 = str48;
                        break;
                    case 22:
                        str45 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 22, StringSerializer.INSTANCE, str45);
                        i3 = 4194304;
                        i |= i3;
                        str49 = str62;
                        str48 = str48;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            String str63 = str53;
            String str64 = str54;
            str = str45;
            d = d3;
            str2 = str52;
            str3 = str50;
            str4 = str51;
            str5 = str63;
            str6 = str64;
            str7 = str55;
            str8 = str56;
            str9 = str57;
            str10 = str58;
            str11 = str59;
            str12 = str60;
            str13 = str49;
            str14 = str42;
            bool = bool5;
            str15 = str43;
            str16 = str44;
            str17 = str48;
            str18 = str46;
            str19 = str47;
            str20 = str61;
            bool2 = bool6;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new NonLinearAdsData.NonLinearAd(i, d, str2, str5, str6, str7, str8, str9, str10, str11, str12, str13, str17, bool2, bool, str20, str19, str18, str15, str16, str14, str4, str3, str, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, NonLinearAdsData.NonLinearAd value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        NonLinearAdsData.NonLinearAd.write$Self$MediaTailor_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
