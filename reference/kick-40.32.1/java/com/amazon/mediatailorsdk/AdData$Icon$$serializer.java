package com.amazon.mediatailorsdk;

import com.facebook.react.uimanager.ViewProps;
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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/amazon/mediatailorsdk/AdData.Icon.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/amazon/mediatailorsdk/AdData$Icon;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdData$Icon$$serializer implements GeneratedSerializer<AdData.Icon> {
    public static final AdData$Icon$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AdData$Icon$$serializer adData$Icon$$serializer = new AdData$Icon$$serializer();
        INSTANCE = adData$Icon$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.amazon.mediatailorsdk.AdData.Icon", adData$Icon$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("program", true);
        pluginGeneratedSerialDescriptor.addElement(ViewProps.WIDTH, true);
        pluginGeneratedSerialDescriptor.addElement(ViewProps.HEIGHT, true);
        pluginGeneratedSerialDescriptor.addElement("xPosition", true);
        pluginGeneratedSerialDescriptor.addElement("yPosition", true);
        pluginGeneratedSerialDescriptor.addElement("apiFramework", true);
        pluginGeneratedSerialDescriptor.addElement("duration", true);
        pluginGeneratedSerialDescriptor.addElement("offset", true);
        pluginGeneratedSerialDescriptor.addElement("pxratio", true);
        pluginGeneratedSerialDescriptor.addElement("staticResource", true);
        pluginGeneratedSerialDescriptor.addElement("staticResources", true);
        pluginGeneratedSerialDescriptor.addElement("iconClicks", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdData$Icon$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) AdData.Icon.$childSerializers[10].getValue()), BuiltinSerializersKt.getNullable(AdData$Icon$IconClicks$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final AdData.Icon deserialize(Decoder decoder) {
        String str;
        AdData.Icon.StaticResource[] staticResourceArr;
        String str2;
        String str3;
        AdData.Icon.IconClicks iconClicks;
        int i;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = AdData.Icon.$childSerializers;
        String str11 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            String str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            String str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            String str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            String str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, null);
            String str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, null);
            String str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, null);
            String str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, null);
            String str20 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, null);
            str7 = str17;
            str3 = str13;
            str9 = str19;
            str5 = str15;
            str = str16;
            str8 = str14;
            staticResourceArr = (AdData.Icon.StaticResource[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), null);
            iconClicks = (AdData.Icon.IconClicks) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, AdData$Icon$IconClicks$$serializer.INSTANCE, null);
            str4 = str20;
            i = 4095;
            str2 = str18;
            str10 = str12;
        } else {
            AdData.Icon.StaticResource[] staticResourceArr2 = null;
            String str21 = null;
            String str22 = null;
            String str23 = null;
            String str24 = null;
            String str25 = null;
            str = null;
            String str26 = null;
            int i3 = 10;
            boolean z = true;
            int i4 = 0;
            AdData.Icon.IconClicks iconClicks2 = null;
            String str27 = null;
            String str28 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        iconClicks2 = iconClicks2;
                        i3 = 10;
                        i4 = i4;
                        break;
                    case 0:
                        str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str11);
                        i2 = i4 | 1;
                        iconClicks2 = iconClicks2;
                        i3 = 10;
                        i4 = i2;
                        lazyArr = lazyArr;
                        break;
                    case 1:
                        str28 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str28);
                        i2 = i4 | 2;
                        iconClicks2 = iconClicks2;
                        i3 = 10;
                        i4 = i2;
                        lazyArr = lazyArr;
                        break;
                    case 2:
                        str27 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str27);
                        i2 = i4 | 4;
                        iconClicks2 = iconClicks2;
                        i3 = 10;
                        i4 = i2;
                        lazyArr = lazyArr;
                        break;
                    case 3:
                        str26 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str26);
                        i2 = i4 | 8;
                        iconClicks2 = iconClicks2;
                        i3 = 10;
                        i4 = i2;
                        lazyArr = lazyArr;
                        break;
                    case 4:
                        str24 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str24);
                        i2 = i4 | 16;
                        iconClicks2 = iconClicks2;
                        i3 = 10;
                        i4 = i2;
                        lazyArr = lazyArr;
                        break;
                    case 5:
                        str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str);
                        i2 = i4 | 32;
                        iconClicks2 = iconClicks2;
                        i3 = 10;
                        i4 = i2;
                        lazyArr = lazyArr;
                        break;
                    case 6:
                        str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str23);
                        i2 = i4 | 64;
                        iconClicks2 = iconClicks2;
                        i3 = 10;
                        i4 = i2;
                        lazyArr = lazyArr;
                        break;
                    case 7:
                        str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str22);
                        i2 = i4 | 128;
                        iconClicks2 = iconClicks2;
                        i3 = 10;
                        i4 = i2;
                        lazyArr = lazyArr;
                        break;
                    case 8:
                        str21 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str21);
                        i2 = i4 | 256;
                        iconClicks2 = iconClicks2;
                        i3 = 10;
                        i4 = i2;
                        lazyArr = lazyArr;
                        break;
                    case 9:
                        str25 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str25);
                        i2 = i4 | 512;
                        iconClicks2 = iconClicks2;
                        i3 = 10;
                        i4 = i2;
                        lazyArr = lazyArr;
                        break;
                    case 10:
                        lazyArr = lazyArr;
                        staticResourceArr2 = (AdData.Icon.StaticResource[]) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, (DeserializationStrategy) lazyArr[i3].getValue(), staticResourceArr2);
                        i2 = i4 | 1024;
                        iconClicks2 = iconClicks2;
                        i4 = i2;
                        lazyArr = lazyArr;
                        break;
                    case 11:
                        lazyArr = lazyArr;
                        iconClicks2 = (AdData.Icon.IconClicks) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, AdData$Icon$IconClicks$$serializer.INSTANCE, iconClicks2);
                        i4 |= 2048;
                        lazyArr = lazyArr;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            int i5 = i4;
            AdData.Icon.IconClicks iconClicks3 = iconClicks2;
            staticResourceArr = staticResourceArr2;
            str2 = str22;
            str3 = str28;
            iconClicks = iconClicks3;
            i = i5;
            str4 = str25;
            str5 = str24;
            str6 = str26;
            str7 = str23;
            str8 = str27;
            str9 = str21;
            str10 = str11;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AdData.Icon(i, str10, str3, str8, str6, str5, str, str7, str2, str9, str4, staticResourceArr, iconClicks, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, AdData.Icon value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        AdData.Icon.write$Self$MediaTailor_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
