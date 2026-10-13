package io.datazoom.sdk.network.events.model;

import com.facebook.hermes.intl.Constants;
import java.util.HashMap;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: EventDto.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"io/datazoom/sdk/network/events/model/EventDto.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/datazoom/sdk/network/events/model/EventDto;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class EventDto$$serializer implements GeneratedSerializer<EventDto> {
    public static final EventDto$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        EventDto$$serializer eventDto$$serializer = new EventDto$$serializer();
        INSTANCE = eventDto$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.datazoom.sdk.network.events.model.EventDto", eventDto$$serializer, 17);
        pluginGeneratedSerialDescriptor.addElement("customer_code", true);
        pluginGeneratedSerialDescriptor.addElement("configuration_id", true);
        pluginGeneratedSerialDescriptor.addElement("event_id", true);
        pluginGeneratedSerialDescriptor.addElement("connector_list", true);
        pluginGeneratedSerialDescriptor.addElement("event", false);
        pluginGeneratedSerialDescriptor.addElement("user_details", true);
        pluginGeneratedSerialDescriptor.addElement("device", true);
        pluginGeneratedSerialDescriptor.addElement("geo_location", true);
        pluginGeneratedSerialDescriptor.addElement("network", true);
        pluginGeneratedSerialDescriptor.addElement("video", true);
        pluginGeneratedSerialDescriptor.addElement("ad", true);
        pluginGeneratedSerialDescriptor.addElement("page", true);
        pluginGeneratedSerialDescriptor.addElement("ops_metadata", true);
        pluginGeneratedSerialDescriptor.addElement("cdn", true);
        pluginGeneratedSerialDescriptor.addElement("player", true);
        pluginGeneratedSerialDescriptor.addElement("custom", true);
        pluginGeneratedSerialDescriptor.addElement("cmcd", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private EventDto$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr = EventDto.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), EventDto$Event$$serializer.INSTANCE, BuiltinSerializersKt.getNullable((KSerializer) lazyArr[5].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[6].getValue()), lazyArr[7].getValue(), lazyArr[8].getValue(), lazyArr[9].getValue(), lazyArr[10].getValue(), lazyArr[11].getValue(), lazyArr[12].getValue(), lazyArr[13].getValue(), lazyArr[14].getValue(), lazyArr[15].getValue(), lazyArr[16].getValue()};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final EventDto deserialize(Decoder decoder) {
        int i;
        HashMap map;
        HashMap map2;
        HashMap map3;
        HashMap map4;
        HashMap map5;
        HashMap map6;
        String str;
        HashMap map7;
        HashMap map8;
        HashMap map9;
        HashMap map10;
        HashMap map11;
        String str2;
        String str3;
        EventDto.Event event;
        HashMap map12;
        String str4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = EventDto.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            EventDto.Event event2 = (EventDto.Event) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, EventDto$Event$$serializer.INSTANCE, null);
            HashMap map13 = (HashMap) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), null);
            HashMap map14 = (HashMap) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), null);
            HashMap map15 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), null);
            HashMap map16 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), null);
            HashMap map17 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), null);
            HashMap map18 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), null);
            HashMap map19 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 11, (DeserializationStrategy) lazyArr[11].getValue(), null);
            HashMap map20 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 12, (DeserializationStrategy) lazyArr[12].getValue(), null);
            HashMap map21 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 13, (DeserializationStrategy) lazyArr[13].getValue(), null);
            HashMap map22 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 14, (DeserializationStrategy) lazyArr[14].getValue(), null);
            i = 131071;
            map7 = map22;
            map10 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 15, (DeserializationStrategy) lazyArr[15].getValue(), null);
            str4 = str7;
            str2 = str6;
            map6 = map16;
            map11 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 16, (DeserializationStrategy) lazyArr[16].getValue(), null);
            map12 = map18;
            map5 = map17;
            map2 = map15;
            map8 = map21;
            map3 = map20;
            map4 = map19;
            map = map14;
            str3 = str5;
            event = event2;
            map9 = map13;
            str = strDecodeStringElement;
        } else {
            int i2 = 16;
            int i3 = 5;
            int i4 = 8;
            boolean z = true;
            HashMap map23 = null;
            HashMap map24 = null;
            HashMap map25 = null;
            EventDto.Event event3 = null;
            HashMap map26 = null;
            HashMap map27 = null;
            String str8 = null;
            String strDecodeStringElement2 = null;
            HashMap map28 = null;
            HashMap map29 = null;
            HashMap map30 = null;
            String str9 = null;
            int i5 = 10;
            int i6 = 9;
            int i7 = 7;
            int i8 = 6;
            i = 0;
            String str10 = null;
            HashMap map31 = null;
            HashMap map32 = null;
            HashMap map33 = null;
            HashMap map34 = null;
            while (z) {
                int i9 = i2;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        map23 = map23;
                        map24 = map24;
                        z = false;
                        map24 = map24;
                        map23 = map23;
                        i2 = 16;
                        i3 = 5;
                        i8 = 6;
                        i7 = 7;
                        i4 = 8;
                        i6 = 9;
                        i5 = 10;
                        break;
                    case 0:
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str9);
                        i |= 1;
                        str10 = str10;
                        map24 = map24;
                        map23 = map23;
                        i2 = 16;
                        i3 = 5;
                        i8 = 6;
                        i7 = 7;
                        i4 = 8;
                        i6 = 9;
                        i5 = 10;
                        break;
                    case 1:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i |= 2;
                        str10 = str10;
                        map24 = map24;
                        map23 = map23;
                        i2 = 16;
                        i3 = 5;
                        i8 = 6;
                        i7 = 7;
                        i4 = 8;
                        i6 = 9;
                        i5 = 10;
                        break;
                    case 2:
                        map23 = map23;
                        map24 = map24;
                        str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str10);
                        i |= 4;
                        map24 = map24;
                        map23 = map23;
                        i2 = 16;
                        i3 = 5;
                        i8 = 6;
                        i7 = 7;
                        i4 = 8;
                        i6 = 9;
                        i5 = 10;
                        break;
                    case 3:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str8);
                        i |= 8;
                        map23 = map23;
                        str10 = str10;
                        i2 = 16;
                        i3 = 5;
                        i8 = 6;
                        i7 = 7;
                        i4 = 8;
                        i6 = 9;
                        i5 = 10;
                        break;
                    case 4:
                        event3 = (EventDto.Event) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, EventDto$Event$$serializer.INSTANCE, event3);
                        i |= 16;
                        map23 = map23;
                        str10 = str10;
                        i2 = 16;
                        i3 = 5;
                        i8 = 6;
                        i7 = 7;
                        i4 = 8;
                        i6 = 9;
                        i5 = 10;
                        break;
                    case 5:
                        map24 = (HashMap) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, (DeserializationStrategy) lazyArr[i3].getValue(), map24);
                        i |= 32;
                        map23 = map23;
                        str10 = str10;
                        i2 = 16;
                        i8 = 6;
                        i7 = 7;
                        i4 = 8;
                        i6 = 9;
                        i5 = 10;
                        break;
                    case 6:
                        map25 = (HashMap) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i8, (DeserializationStrategy) lazyArr[i8].getValue(), map25);
                        i |= 64;
                        map23 = map23;
                        str10 = str10;
                        i2 = 16;
                        i7 = 7;
                        i4 = 8;
                        i6 = 9;
                        i5 = 10;
                        break;
                    case 7:
                        map26 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i7, (DeserializationStrategy) lazyArr[i7].getValue(), map26);
                        i |= 128;
                        map23 = map23;
                        str10 = str10;
                        i2 = 16;
                        i4 = 8;
                        i6 = 9;
                        i5 = 10;
                        break;
                    case 8:
                        map34 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i4, (DeserializationStrategy) lazyArr[i4].getValue(), map34);
                        i |= 256;
                        map23 = map23;
                        str10 = str10;
                        i2 = 16;
                        i6 = 9;
                        i5 = 10;
                        break;
                    case 9:
                        map33 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i6, (DeserializationStrategy) lazyArr[i6].getValue(), map33);
                        i |= 512;
                        map23 = map23;
                        str10 = str10;
                        i2 = 16;
                        i5 = 10;
                        break;
                    case 10:
                        map27 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i5, (DeserializationStrategy) lazyArr[i5].getValue(), map27);
                        i |= 1024;
                        map28 = map28;
                        map23 = map23;
                        str10 = str10;
                        i2 = 16;
                        break;
                    case 11:
                        map32 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 11, (DeserializationStrategy) lazyArr[11].getValue(), map32);
                        i |= 2048;
                        map23 = map23;
                        str10 = str10;
                        i2 = 16;
                        break;
                    case 12:
                        map31 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 12, (DeserializationStrategy) lazyArr[12].getValue(), map31);
                        i |= 4096;
                        map23 = map23;
                        str10 = str10;
                        i2 = 16;
                        break;
                    case 13:
                        map28 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 13, (DeserializationStrategy) lazyArr[13].getValue(), map28);
                        i |= 8192;
                        map29 = map29;
                        map23 = map23;
                        str10 = str10;
                        i2 = 16;
                        break;
                    case 14:
                        map30 = map30;
                        map29 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 14, (DeserializationStrategy) lazyArr[14].getValue(), map29);
                        i |= 16384;
                        map23 = map23;
                        str10 = str10;
                        i2 = 16;
                        break;
                    case 15:
                        map30 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 15, (DeserializationStrategy) lazyArr[15].getValue(), map30);
                        i |= 32768;
                        map23 = map23;
                        str10 = str10;
                        i2 = 16;
                        break;
                    case 16:
                        map23 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i9, (DeserializationStrategy) lazyArr[i9].getValue(), map23);
                        i |= 65536;
                        i2 = i9;
                        str10 = str10;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            map = map25;
            map2 = map26;
            map3 = map31;
            map4 = map32;
            map5 = map33;
            map6 = map34;
            str = strDecodeStringElement2;
            map7 = map29;
            map8 = map28;
            map9 = map24;
            map10 = map30;
            map11 = map23;
            str2 = str10;
            str3 = str9;
            event = event3;
            map12 = map27;
            str4 = str8;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new EventDto(i, str3, str, str2, str4, event, map9, map, map2, map6, map5, map12, map4, map3, map8, map7, map10, map11, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, EventDto value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        EventDto.write$Self$base(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
