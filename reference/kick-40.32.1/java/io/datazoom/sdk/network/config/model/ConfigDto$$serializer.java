package io.datazoom.sdk.network.config.model;

import com.facebook.hermes.intl.Constants;
import java.util.List;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: ConfigDto.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"io/datazoom/sdk/network/config/model/ConfigDto.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/datazoom/sdk/network/config/model/ConfigDto;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class ConfigDto$$serializer implements GeneratedSerializer<ConfigDto> {
    public static final ConfigDto$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ConfigDto$$serializer configDto$$serializer = new ConfigDto$$serializer();
        INSTANCE = configDto$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.datazoom.sdk.network.config.model.ConfigDto", configDto$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("datapoints", true);
        pluginGeneratedSerialDescriptor.addElement("customer_code", true);
        pluginGeneratedSerialDescriptor.addElement("connector_list", true);
        pluginGeneratedSerialDescriptor.addElement("configuration_id", true);
        pluginGeneratedSerialDescriptor.addElement("endpoints", true);
        pluginGeneratedSerialDescriptor.addElement("content_milestone_percent", true);
        pluginGeneratedSerialDescriptor.addElement("ad_milestone_percent", true);
        pluginGeneratedSerialDescriptor.addElement("content_qv_sec", true);
        pluginGeneratedSerialDescriptor.addElement("ad_qv_sec", true);
        pluginGeneratedSerialDescriptor.addElement("heartbeat_interval_ms", false);
        pluginGeneratedSerialDescriptor.addElement("app_session_timeout_mins", true);
        pluginGeneratedSerialDescriptor.addElement("om_enabled", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConfigDto$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr = ConfigDto.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(ConfigDto$DataPoints$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ConfigDto$Endpoints$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[5].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[6].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[7].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[8].getValue()), LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ConfigDto deserialize(Decoder decoder) {
        int i;
        String str;
        String str2;
        List list;
        List list2;
        Integer num;
        String str3;
        boolean zDecodeBooleanElement;
        long j;
        List list3;
        List list4;
        ConfigDto.DataPoints dataPoints;
        ConfigDto.Endpoints endpoints;
        char c;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ConfigDto.$childSerializers;
        ConfigDto.DataPoints dataPoints2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            ConfigDto.DataPoints dataPoints3 = (ConfigDto.DataPoints) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, ConfigDto$DataPoints$$serializer.INSTANCE, null);
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            ConfigDto.Endpoints endpoints2 = (ConfigDto.Endpoints) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ConfigDto$Endpoints$$serializer.INSTANCE, null);
            List list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), null);
            List list6 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), null);
            List list7 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), null);
            List list8 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), null);
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 9);
            i = 4095;
            num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, null);
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 11);
            list3 = list5;
            j = jDecodeLongElement;
            list2 = list8;
            endpoints = endpoints2;
            list = list7;
            dataPoints = dataPoints3;
            str3 = str5;
            str2 = str4;
            list4 = list6;
            str = str6;
        } else {
            int i2 = 11;
            ConfigDto.Endpoints endpoints3 = null;
            List list9 = null;
            String str7 = null;
            int i3 = 7;
            int i4 = 6;
            int i5 = 5;
            int i6 = 8;
            boolean z = true;
            i = 0;
            boolean zDecodeBooleanElement2 = false;
            long jDecodeLongElement2 = 0;
            List list10 = null;
            List list11 = null;
            List list12 = null;
            Integer num2 = null;
            String str8 = null;
            String str9 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        lazyArr = lazyArr;
                        i5 = 5;
                        i4 = 6;
                        i3 = 7;
                        i6 = 8;
                        break;
                    case 0:
                        dataPoints2 = (ConfigDto.DataPoints) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, ConfigDto$DataPoints$$serializer.INSTANCE, dataPoints2);
                        i |= 1;
                        lazyArr = lazyArr;
                        i2 = 11;
                        i5 = 5;
                        i4 = 6;
                        i3 = 7;
                        i6 = 8;
                        break;
                    case 1:
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str9);
                        i |= 2;
                        lazyArr = lazyArr;
                        i2 = 11;
                        i5 = 5;
                        i4 = 6;
                        i3 = 7;
                        i6 = 8;
                        break;
                    case 2:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str8);
                        i |= 4;
                        lazyArr = lazyArr;
                        i2 = 11;
                        i5 = 5;
                        i4 = 6;
                        i3 = 7;
                        i6 = 8;
                        break;
                    case 3:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str7);
                        i |= 8;
                        lazyArr = lazyArr;
                        i2 = 11;
                        i5 = 5;
                        i4 = 6;
                        i3 = 7;
                        i6 = 8;
                        break;
                    case 4:
                        endpoints3 = (ConfigDto.Endpoints) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ConfigDto$Endpoints$$serializer.INSTANCE, endpoints3);
                        i |= 16;
                        lazyArr = lazyArr;
                        i2 = 11;
                        i5 = 5;
                        i4 = 6;
                        i3 = 7;
                        i6 = 8;
                        break;
                    case 5:
                        Lazy[] lazyArr2 = lazyArr;
                        list9 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, (DeserializationStrategy) lazyArr2[i5].getValue(), list9);
                        i |= 32;
                        lazyArr = lazyArr2;
                        i2 = 11;
                        i4 = 6;
                        i3 = 7;
                        i6 = 8;
                        break;
                    case 6:
                        Lazy[] lazyArr3 = lazyArr;
                        list12 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, (DeserializationStrategy) lazyArr3[i4].getValue(), list12);
                        i |= 64;
                        lazyArr = lazyArr3;
                        i2 = 11;
                        i3 = 7;
                        i6 = 8;
                        break;
                    case 7:
                        Lazy[] lazyArr4 = lazyArr;
                        list11 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, (DeserializationStrategy) lazyArr4[i3].getValue(), list11);
                        i |= 128;
                        lazyArr = lazyArr4;
                        i2 = 11;
                        i6 = 8;
                        break;
                    case 8:
                        list10 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i6, (DeserializationStrategy) lazyArr[i6].getValue(), list10);
                        i |= 256;
                        lazyArr = lazyArr;
                        i2 = 11;
                        break;
                    case 9:
                        c = '\n';
                        jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 9);
                        i |= 512;
                        i2 = 11;
                        break;
                    case 10:
                        c = '\n';
                        num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num2);
                        i |= 1024;
                        i2 = 11;
                        break;
                    case 11:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, i2);
                        i |= 2048;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            List list13 = list11;
            str = str7;
            str2 = str9;
            list = list13;
            list2 = list10;
            num = num2;
            str3 = str8;
            zDecodeBooleanElement = zDecodeBooleanElement2;
            j = jDecodeLongElement2;
            list3 = list9;
            list4 = list12;
            dataPoints = dataPoints2;
            endpoints = endpoints3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ConfigDto(i, dataPoints, str2, str3, str, endpoints, list3, list4, list, list2, j, num, zDecodeBooleanElement, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ConfigDto value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        ConfigDto.write$Self$base(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
