package io.github.expo.modules.v2.converters;

import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.types.CppType;
import io.github.expo.modules.v2.types.TypeCodes;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnumConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001'B#\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00102\f\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b!\u0010\"J\u001d\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010%J\u0014\u0010&\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u001b\u001a\u00020\u0010H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lio/github/expo/modules/v2/converters/EnumConverter;", "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "enumClass", "Ljava/lang/Class;", "isNullable", "", "<init>", "(Ljava/lang/Class;Z)V", "constants", "", "[Ljava/lang/Enum;", "property", "Ljava/lang/reflect/Field;", "isIntBacked", "jsValues", "", "[Ljava/lang/Object;", "constantsByValue", "", "codes", "Lio/github/expo/modules/v2/types/TypeCodes;", "getCodes-pj4Pta4", "()[I", "isPassthrough", "()Z", "fromJni", "value", "toJni", "writeToBuffer", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "writeToBuffer-uOnPpUM", "(Ljava/nio/ByteBuffer;Ljava/lang/Enum;)V", "readFromBuffer", "readFromBuffer-R_h_rCc", "(Ljava/nio/ByteBuffer;)Ljava/lang/Enum;", "entryOf", "Companion", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EnumConverter extends TypeConverter<Enum<?>> {
    private static final Companion Companion = new Companion(null);
    private final Enum<?>[] constants;
    private final Map<Object, Enum<?>> constantsByValue;
    private final Class<? extends Enum<?>> enumClass;
    private final boolean isIntBacked;
    private final Object[] jsValues;
    private final Field property;

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public boolean isPassthrough() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumConverter(Class<? extends Enum<?>> enumClass, boolean z) {
        Object objName;
        super(z);
        Intrinsics.checkNotNullParameter(enumClass, "enumClass");
        this.enumClass = enumClass;
        Object[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants == null) {
            throw new IllegalArgumentException((enumClass.getName() + " is not an enum class").toString());
        }
        Enum<?>[] enumArr = (Enum[]) enumConstants;
        this.constants = enumArr;
        Field fieldPropertyOf = Companion.propertyOf(enumClass);
        this.property = fieldPropertyOf;
        this.isIntBacked = Intrinsics.areEqual(fieldPropertyOf != null ? fieldPropertyOf.getType() : null, Integer.TYPE);
        int length = enumArr.length;
        Object[] objArr = new Object[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            Field field = this.property;
            if (field == null || (objName = field.get(this.constants[i2])) == null) {
                objName = this.constants[i2].name();
            }
            objArr[i2] = objName;
        }
        this.jsValues = objArr;
        ArrayList arrayList = new ArrayList(objArr.length);
        int length2 = objArr.length;
        int i3 = 0;
        while (i < length2) {
            arrayList.add(TuplesKt.to(objArr[i], this.constants[i3]));
            i++;
            i3++;
        }
        this.constantsByValue = MapsKt.toMap(arrayList);
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: getCodes-pj4Pta4 */
    public int[] getCodes() {
        int iM12412nullableIpqU398;
        if (this.isIntBacked) {
            iM12412nullableIpqU398 = getIsNullable() ? CppType.m12412nullableIpqU398(CppType.INSTANCE.m12426getBOX_INTz4oZPQ(), true) : CppType.INSTANCE.m12433getINTz4oZPQ();
        } else {
            iM12412nullableIpqU398 = CppType.m12412nullableIpqU398(CppType.INSTANCE.m12443getSTRINGz4oZPQ(), getIsNullable());
        }
        return CppType.m12418toTypeCodespj4Pta4(iM12412nullableIpqU398);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public Enum<?> fromJni(Object value) {
        EnumConverter enumConverter = this;
        if (value != null) {
            return entryOf(value);
        }
        if (enumConverter.getIsNullable()) {
            return null;
        }
        throw new IllegalArgumentException("A non-nullable " + CppType.m12417toStringimpl(TypeCodes.m12452getHeadz4oZPQ(enumConverter.getCodes())) + " bridge value arrived as null");
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    public Object toJni(Enum<?> value) {
        if (value != null) {
            return this.jsValues[value.ordinal()];
        }
        return null;
    }

    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: writeToBuffer-uOnPpUM, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public void mo12333writeToBufferuOnPpUM(ByteBuffer buf, Enum<?> value) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (getIsNullable()) {
            BinaryBuffer.m12274putBooleanWPjWIpM(buf, value != null);
            if (value == null) {
                return;
            }
        } else if (value == null) {
            throw new IllegalArgumentException("Cannot encode null into a non-nullable slot");
        }
        boolean z = this.isIntBacked;
        Object[] objArr = this.jsValues;
        if (z) {
            Object obj = objArr[value.ordinal()];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            BinaryBuffer.m12285putIntWPjWIpM(buf, ((Integer) obj).intValue());
        } else {
            Object obj2 = objArr[value.ordinal()];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            BinaryBuffer.m12293putStringWPjWIpM(buf, (String) obj2);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.github.expo.modules.v2.converters.TypeConverter
    /* JADX INFO: renamed from: readFromBuffer-R_h_rCc */
    public Enum<?> mo12332readFromBufferR_h_rCc(ByteBuffer buf) {
        Object objM12271getStringimpl;
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (getIsNullable() && !BinaryBuffer.m12249getBooleanimpl(buf)) {
            return null;
        }
        if (this.isIntBacked) {
            objM12271getStringimpl = Integer.valueOf(BinaryBuffer.m12260getIntimpl(buf));
        } else {
            objM12271getStringimpl = BinaryBuffer.m12271getStringimpl(buf);
        }
        return entryOf(objM12271getStringimpl);
    }

    private final Enum<?> entryOf(Object value) {
        Enum<?> r0 = this.constantsByValue.get(value);
        if (r0 != null) {
            return r0;
        }
        throw new IllegalArgumentException("'" + value + "' is not a valid " + this.enumClass.getSimpleName() + ". Pass one of: " + ArraysKt.joinToString$default(this.jsValues, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: io.github.expo.modules.v2.converters.EnumConverter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EnumConverter.entryOf$lambda$6(this.f$0, obj);
            }
        }, 31, (Object) null));
    }

    static final CharSequence entryOf$lambda$6(EnumConverter enumConverter, Object it) {
        String strValueOf;
        Intrinsics.checkNotNullParameter(it, "it");
        if (enumConverter.isIntBacked) {
            strValueOf = String.valueOf(it);
        } else {
            strValueOf = "'" + it + "'";
        }
        return strValueOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: EnumConverter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\b0\u0007¨\u0006\t"}, d2 = {"Lio/github/expo/modules/v2/converters/EnumConverter$Companion;", "", "<init>", "()V", "propertyOf", "Ljava/lang/reflect/Field;", "enumClass", "Ljava/lang/Class;", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Field propertyOf(Class<? extends Enum<?>> enumClass) {
            Intrinsics.checkNotNullParameter(enumClass, "enumClass");
            Field[] declaredFields = enumClass.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
            ArrayList arrayList = new ArrayList();
            for (Field field : declaredFields) {
                Field field2 = field;
                if (!Modifier.isStatic(field2.getModifiers()) && !field2.isSynthetic()) {
                    arrayList.add(field);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (arrayList2.isEmpty()) {
                return null;
            }
            Field field3 = (Field) CollectionsKt.singleOrNull((List) arrayList2);
            if (field3 != null) {
                Field field4 = (Intrinsics.areEqual(field3.getType(), String.class) || Intrinsics.areEqual(field3.getType(), Integer.TYPE)) ? field3 : null;
                if (field4 != null) {
                    field4.setAccessible(true);
                    return field4;
                }
            }
            throw new IllegalArgumentException(enumClass.getName() + " cannot cross to JavaScript: an enum crosses by its entry names, or by the value of its only property when that property is a String or an Int, but it declares " + CollectionsKt.joinToString$default(arrayList2, null, null, null, 0, null, new Function1() { // from class: io.github.expo.modules.v2.converters.EnumConverter$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EnumConverter.Companion.propertyOf$lambda$2((Field) obj);
                }
            }, 31, null) + ". Give it a single String or Int property, or remove its properties");
        }

        static final CharSequence propertyOf$lambda$2(Field field) {
            return field.getName() + ": " + field.getType().getSimpleName();
        }
    }
}
