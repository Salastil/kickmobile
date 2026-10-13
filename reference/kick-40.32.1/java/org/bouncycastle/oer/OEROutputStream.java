package org.bouncycastle.oer;

import io.ktor.sse.ServerSentEventKt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1IA5String;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1UTF8String;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes11.dex */
public class OEROutputStream extends OutputStream {
    private static final int[] bits = {1, 2, 4, 8, 16, 32, 64, 128};
    protected PrintWriter debugOutput = null;
    private final OutputStream out;

    /* JADX INFO: renamed from: org.bouncycastle.oer.OEROutputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType;

        static {
            int[] iArr = new int[OERDefinition.BaseType.values().length];
            $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType = iArr;
            try {
                iArr[OERDefinition.BaseType.Supplier.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.SEQ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.SEQ_OF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.CHOICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.ENUM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.INT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.OCTET_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.IA5String.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.UTF8_STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.BIT_STRING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.NULL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.EXTENSION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.ENUM_ITEM.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.BOOLEAN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public OEROutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    public static int byteLength(long j) {
        int i = 8;
        while (i > 0 && ((-72057594037927936L) & j) == 0) {
            j <<= 8;
            i--;
        }
        return i;
    }

    private void encodeLength(long j) throws IOException {
        if (j <= 127) {
            this.out.write((int) j);
            return;
        }
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(BigInteger.valueOf(j));
        this.out.write(bArrAsUnsignedByteArray.length | 128);
        this.out.write(bArrAsUnsignedByteArray);
    }

    private void encodeQuantity(long j) throws IOException {
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(BigInteger.valueOf(j));
        this.out.write(bArrAsUnsignedByteArray.length);
        this.out.write(bArrAsUnsignedByteArray);
    }

    protected void debugPrint(String str) {
        if (this.debugOutput == null) {
            return;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i = -1;
        for (int i2 = 0; i2 != stackTrace.length; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (stackTraceElement.getMethodName().equals("debugPrint")) {
                i = 0;
            } else if (stackTraceElement.getClassName().contains("OERInput")) {
                i++;
            }
        }
        while (true) {
            PrintWriter printWriter = this.debugOutput;
            if (i <= 0) {
                printWriter.append((CharSequence) str).append((CharSequence) "\n");
                this.debugOutput.flush();
                return;
            } else {
                printWriter.append((CharSequence) "    ");
                i--;
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
    }

    /* JADX WARN: Code duplicated, block: B:210:0x0477  */
    /* JADX WARN: Code duplicated, block: B:214:0x0487  */
    /* JADX WARN: Code duplicated, block: B:217:0x049a  */
    /* JADX WARN: Code duplicated, block: B:220:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:222:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:228:0x04c9  */
    /* JADX WARN: Code duplicated, block: B:231:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:234:0x04df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:235:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:238:0x04ec  */
    /* JADX WARN: Code duplicated, block: B:243:0x0504  */
    /* JADX WARN: Code duplicated, block: B:246:0x0512  */
    /* JADX WARN: Code duplicated, block: B:247:0x0516  */
    /* JADX WARN: Code duplicated, block: B:251:0x0527  */
    /* JADX WARN: Code duplicated, block: B:253:0x052d  */
    /* JADX WARN: Code duplicated, block: B:278:0x04cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:280:0x04cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:284:0x04fd A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:288:0x0546 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public void write(ASN1Encodable aSN1Encodable, Element element) throws IOException {
        boolean z;
        int i;
        List<Element> children;
        int i2;
        ByteArrayOutputStream byteArrayOutputStream;
        int i3;
        int i4;
        int i5;
        Element elementResult;
        ASN1Encodable objectAt;
        int i6;
        Enumeration objects;
        int size;
        String str;
        byte[] bArrLongToBigEndian;
        if (aSN1Encodable == OEROptional.ABSENT) {
            return;
        }
        if (aSN1Encodable instanceof OEROptional) {
            write(((OEROptional) aSN1Encodable).get(), element);
            return;
        }
        ASN1Primitive aSN1Primitive = aSN1Encodable.toASN1Primitive();
        int i7 = 6;
        switch (AnonymousClass1.$SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[element.getBaseType().ordinal()]) {
            case 1:
                write(aSN1Primitive, element.getElementSupplier().build());
                return;
            case 2:
                ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(aSN1Primitive);
                if (element.isExtensionsInDefinition()) {
                    int i8 = 0;
                    while (true) {
                        if (i8 < element.getChildren().size()) {
                            Element element2 = element.getChildren().get(i8);
                            if (element2.getBaseType() != OERDefinition.BaseType.EXTENSION) {
                                if (element2.getBlock() <= 0 || i8 >= aSN1Sequence.size() || OEROptional.ABSENT.equals(aSN1Sequence.getObjectAt(i8))) {
                                    i8++;
                                } else {
                                    z = true;
                                }
                            }
                        }
                        z = false;
                    }
                    i = z ? bits[7] : 0;
                } else {
                    i7 = 7;
                    z = false;
                    i = 0;
                }
                for (int i9 = 0; i9 < element.getChildren().size(); i9++) {
                    Element element3 = element.getChildren().get(i9);
                    if (element3.getBaseType() != OERDefinition.BaseType.EXTENSION) {
                        if (element3.getBlock() > 0) {
                            if (i7 != 7) {
                                this.out.write(i);
                            }
                            children = element.getChildren();
                            i2 = 0;
                            while (i2 < children.size()) {
                                elementResult = element.getChildren().get(i2);
                                if (elementResult.getBaseType() != OERDefinition.BaseType.EXTENSION) {
                                    if (elementResult.getBlock() > 0) {
                                        if (z) {
                                            byteArrayOutputStream = new ByteArrayOutputStream();
                                            i3 = 7;
                                            i5 = 0;
                                            for (i4 = i2; i4 < children.size(); i4++) {
                                                if (i3 < 0) {
                                                    byteArrayOutputStream.write(i5);
                                                    i3 = 7;
                                                    i5 = 0;
                                                }
                                                if (i4 >= aSN1Sequence.size() && !OEROptional.ABSENT.equals(aSN1Sequence.getObjectAt(i4))) {
                                                    i5 |= bits[i3];
                                                }
                                                i3--;
                                            }
                                            if (i3 != 7) {
                                                byteArrayOutputStream.write(i5);
                                            }
                                            encodeLength(byteArrayOutputStream.size() + 1);
                                            if (i3 == 7) {
                                                write(0);
                                            } else {
                                                write(i3 + 1);
                                            }
                                            write(byteArrayOutputStream.toByteArray());
                                            while (i2 < children.size()) {
                                                if (i2 >= aSN1Sequence.size() && !OEROptional.ABSENT.equals(aSN1Sequence.getObjectAt(i2))) {
                                                    writePlainType(aSN1Sequence.getObjectAt(i2), children.get(i2));
                                                }
                                                i2++;
                                            }
                                        }
                                        this.out.flush();
                                        debugPrint(element.appendLabel(""));
                                        return;
                                    }
                                    objectAt = aSN1Sequence.getObjectAt(i2);
                                    if (elementResult.getaSwitch() != null) {
                                        elementResult = elementResult.getaSwitch().result(new SwitchIndexer.Asn1SequenceIndexer(aSN1Sequence));
                                    }
                                    if (elementResult.getDefaultValue() != null || !elementResult.getDefaultValue().equals(objectAt)) {
                                        write(objectAt, elementResult);
                                    }
                                }
                                i2++;
                            }
                            if (z) {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                i3 = 7;
                                i5 = 0;
                                while (i4 < children.size()) {
                                    if (i3 < 0) {
                                        byteArrayOutputStream.write(i5);
                                        i3 = 7;
                                        i5 = 0;
                                    }
                                    if (i4 >= aSN1Sequence.size()) {
                                    }
                                    i3--;
                                }
                                if (i3 != 7) {
                                    byteArrayOutputStream.write(i5);
                                }
                                encodeLength(byteArrayOutputStream.size() + 1);
                                if (i3 == 7) {
                                    write(0);
                                } else {
                                    write(i3 + 1);
                                }
                                write(byteArrayOutputStream.toByteArray());
                                while (i2 < children.size()) {
                                    if (i2 >= aSN1Sequence.size()) {
                                    }
                                    i2++;
                                }
                            }
                            this.out.flush();
                            debugPrint(element.appendLabel(""));
                            return;
                        }
                        Element elementExpandDeferredDefinition = Element.expandDeferredDefinition(element3, element);
                        if (element.getaSwitch() != null) {
                            elementExpandDeferredDefinition = Element.expandDeferredDefinition(element.getaSwitch().result(new SwitchIndexer.Asn1SequenceIndexer(aSN1Sequence)), element);
                        }
                        if (i7 < 0) {
                            this.out.write(i);
                            i7 = 7;
                            i = 0;
                        }
                        ASN1Encodable objectAt2 = aSN1Sequence.getObjectAt(i9);
                        if (elementExpandDeferredDefinition.isExplicit() && (objectAt2 instanceof OEROptional)) {
                            throw new IllegalStateException("absent sequence element that is required by oer definition");
                        }
                        if (!elementExpandDeferredDefinition.isExplicit()) {
                            ASN1Encodable objectAt3 = aSN1Sequence.getObjectAt(i9);
                            if (elementExpandDeferredDefinition.getDefaultValue() != null) {
                                if (objectAt3 instanceof OEROptional) {
                                    OEROptional oEROptional = (OEROptional) objectAt3;
                                    if (oEROptional.isDefined() && !oEROptional.get().equals(elementExpandDeferredDefinition.getDefaultValue())) {
                                        i6 = bits[i7];
                                        i |= i6;
                                    }
                                } else if (!elementExpandDeferredDefinition.getDefaultValue().equals(objectAt3)) {
                                    i6 = bits[i7];
                                    i |= i6;
                                }
                            } else if (objectAt2 != OEROptional.ABSENT) {
                                i6 = bits[i7];
                                i |= i6;
                            }
                            i7--;
                        }
                    }
                }
                if (i7 != 7) {
                    this.out.write(i);
                }
                children = element.getChildren();
                i2 = 0;
                while (i2 < children.size()) {
                    elementResult = element.getChildren().get(i2);
                    if (elementResult.getBaseType() != OERDefinition.BaseType.EXTENSION) {
                        if (elementResult.getBlock() > 0) {
                            if (z) {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                i3 = 7;
                                i5 = 0;
                                while (i4 < children.size()) {
                                    if (i3 < 0) {
                                        byteArrayOutputStream.write(i5);
                                        i3 = 7;
                                        i5 = 0;
                                    }
                                    if (i4 >= aSN1Sequence.size()) {
                                    }
                                    i3--;
                                }
                                if (i3 != 7) {
                                    byteArrayOutputStream.write(i5);
                                }
                                encodeLength(byteArrayOutputStream.size() + 1);
                                if (i3 == 7) {
                                    write(0);
                                } else {
                                    write(i3 + 1);
                                }
                                write(byteArrayOutputStream.toByteArray());
                                while (i2 < children.size()) {
                                    if (i2 >= aSN1Sequence.size()) {
                                    }
                                    i2++;
                                }
                            }
                            this.out.flush();
                            debugPrint(element.appendLabel(""));
                            return;
                        }
                        objectAt = aSN1Sequence.getObjectAt(i2);
                        if (elementResult.getaSwitch() != null) {
                            elementResult = elementResult.getaSwitch().result(new SwitchIndexer.Asn1SequenceIndexer(aSN1Sequence));
                        }
                        if (elementResult.getDefaultValue() != null) {
                            write(objectAt, elementResult);
                        } else {
                            write(objectAt, elementResult);
                        }
                    }
                    i2++;
                }
                if (z) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    i3 = 7;
                    i5 = 0;
                    while (i4 < children.size()) {
                        if (i3 < 0) {
                            byteArrayOutputStream.write(i5);
                            i3 = 7;
                            i5 = 0;
                        }
                        if (i4 >= aSN1Sequence.size()) {
                        }
                        i3--;
                    }
                    if (i3 != 7) {
                        byteArrayOutputStream.write(i5);
                    }
                    encodeLength(byteArrayOutputStream.size() + 1);
                    if (i3 == 7) {
                        write(0);
                    } else {
                        write(i3 + 1);
                    }
                    write(byteArrayOutputStream.toByteArray());
                    while (i2 < children.size()) {
                        if (i2 >= aSN1Sequence.size()) {
                        }
                        i2++;
                    }
                }
                this.out.flush();
                debugPrint(element.appendLabel(""));
                return;
            case 3:
                if (aSN1Primitive instanceof ASN1Set) {
                    ASN1Set aSN1Set = (ASN1Set) aSN1Primitive;
                    objects = aSN1Set.getObjects();
                    size = aSN1Set.size();
                } else {
                    if (!(aSN1Primitive instanceof ASN1Sequence)) {
                        throw new IllegalStateException("encodable at for SEQ_OF is not a container");
                    }
                    ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Primitive;
                    objects = aSN1Sequence2.getObjects();
                    size = aSN1Sequence2.size();
                }
                encodeQuantity(size);
                Element elementExpandDeferredDefinition2 = Element.expandDeferredDefinition(element.getFirstChid(), element);
                while (objects.hasMoreElements()) {
                    write((ASN1Encodable) objects.nextElement(), elementExpandDeferredDefinition2);
                }
                this.out.flush();
                debugPrint(element.appendLabel(""));
                return;
            case 4:
                ASN1Primitive aSN1Primitive2 = aSN1Primitive.toASN1Primitive();
                BitBuilder bitBuilder = new BitBuilder();
                boolean z2 = aSN1Primitive2 instanceof ASN1TaggedObject;
                if (!z2) {
                    throw new IllegalStateException("only support tagged objects");
                }
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive2;
                int tagClass = aSN1TaggedObject.getTagClass();
                bitBuilder.writeBit(tagClass & 128).writeBit(tagClass & 64);
                int tagNo = aSN1TaggedObject.getTagNo();
                ASN1Primitive aSN1Primitive3 = aSN1TaggedObject.getBaseObject().toASN1Primitive();
                if (tagNo <= 63) {
                    bitBuilder.writeBits(tagNo, 6);
                } else {
                    bitBuilder.writeBits(255L, 6);
                    bitBuilder.write7BitBytes(tagNo);
                }
                if (this.debugOutput != null && z2) {
                    int tagClass2 = aSN1TaggedObject.getTagClass();
                    if (tagClass2 == 64) {
                        str = "AS";
                    } else if (tagClass2 == 128) {
                        str = "CS";
                    } else if (tagClass2 == 192) {
                        str = "PR";
                    }
                    debugPrint(element.appendLabel(str));
                }
                bitBuilder.writeAndClear(this.out);
                Element elementExpandDeferredDefinition3 = Element.expandDeferredDefinition(element.getChildren().get(tagNo), element);
                if (elementExpandDeferredDefinition3.getBlock() > 0) {
                    writePlainType(aSN1Primitive3, elementExpandDeferredDefinition3);
                } else {
                    write(aSN1Primitive3, elementExpandDeferredDefinition3);
                }
                this.out.flush();
                return;
            case 5:
                BigInteger value = aSN1Primitive instanceof ASN1Integer ? ASN1Integer.getInstance(aSN1Primitive).getValue() : ASN1Enumerated.getInstance(aSN1Primitive).getValue();
                Iterator<Element> it = element.getChildren().iterator();
                while (it.hasNext()) {
                    if (Element.expandDeferredDefinition(it.next(), element).getEnumValue().equals(value)) {
                        if (value.compareTo(BigInteger.valueOf(127L)) > 0) {
                            byte[] byteArray = value.toByteArray();
                            this.out.write((byteArray.length & 255) | 128);
                            this.out.write(byteArray);
                        } else {
                            this.out.write(value.intValue() & 127);
                        }
                        this.out.flush();
                        debugPrint(element.appendLabel(element.rangeExpression()));
                        return;
                    }
                }
                throw new IllegalArgumentException("enum value " + value + ServerSentEventKt.SPACE + Hex.toHexString(value.toByteArray()) + " no in defined child list");
            case 6:
                ASN1Integer aSN1Integer = ASN1Integer.getInstance(aSN1Primitive);
                int iIntBytesForRange = element.intBytesForRange();
                if (iIntBytesForRange > 0) {
                    byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(iIntBytesForRange, aSN1Integer.getValue());
                    if (iIntBytesForRange != 1 && iIntBytesForRange != 2 && iIntBytesForRange != 4 && iIntBytesForRange != 8) {
                        throw new IllegalStateException("unknown uint length " + iIntBytesForRange);
                    }
                    this.out.write(bArrAsUnsignedByteArray);
                } else if (iIntBytesForRange < 0) {
                    BigInteger value2 = aSN1Integer.getValue();
                    if (iIntBytesForRange == -8) {
                        bArrLongToBigEndian = Pack.longToBigEndian(BigIntegers.longValueExact(value2));
                    } else if (iIntBytesForRange == -4) {
                        bArrLongToBigEndian = Pack.intToBigEndian(BigIntegers.intValueExact(value2));
                    } else if (iIntBytesForRange == -2) {
                        bArrLongToBigEndian = Pack.shortToBigEndian(BigIntegers.shortValueExact(value2));
                    } else {
                        if (iIntBytesForRange != -1) {
                            throw new IllegalStateException("unknown twos compliment length");
                        }
                        bArrLongToBigEndian = new byte[]{BigIntegers.byteValueExact(value2)};
                    }
                    this.out.write(bArrLongToBigEndian);
                } else {
                    boolean zIsLowerRangeZero = element.isLowerRangeZero();
                    BigInteger value3 = aSN1Integer.getValue();
                    byte[] bArrAsUnsignedByteArray2 = zIsLowerRangeZero ? BigIntegers.asUnsignedByteArray(value3) : value3.toByteArray();
                    encodeLength(bArrAsUnsignedByteArray2.length);
                    this.out.write(bArrAsUnsignedByteArray2);
                }
                debugPrint(element.appendLabel(element.rangeExpression()));
                this.out.flush();
                return;
            case 7:
                byte[] octets = ASN1OctetString.getInstance(aSN1Primitive).getOctets();
                if (!element.isFixedLength()) {
                    encodeLength(octets.length);
                }
                this.out.write(octets);
                debugPrint(element.appendLabel(element.rangeExpression()));
                this.out.flush();
                return;
            case 8:
                byte[] octets2 = ASN1IA5String.getInstance(aSN1Primitive).getOctets();
                if (element.isFixedLength() && element.getUpperBound().intValue() != octets2.length) {
                    throw new IOException("IA5String string length does not equal declared fixed length " + octets2.length + ServerSentEventKt.SPACE + element.getUpperBound());
                }
                if (!element.isFixedLength()) {
                    encodeLength(octets2.length);
                }
                this.out.write(octets2);
                debugPrint(element.appendLabel(""));
                this.out.flush();
                return;
            case 9:
                byte[] uTF8ByteArray = Strings.toUTF8ByteArray(ASN1UTF8String.getInstance(aSN1Primitive).getString());
                encodeLength(uTF8ByteArray.length);
                this.out.write(uTF8ByteArray);
                debugPrint(element.appendLabel(""));
                this.out.flush();
                return;
            case 10:
                ASN1BitString aSN1BitString = ASN1BitString.getInstance(aSN1Primitive);
                byte[] bytes = aSN1BitString.getBytes();
                if (!element.isFixedLength()) {
                    int padBits = aSN1BitString.getPadBits();
                    encodeLength(bytes.length + 1);
                    this.out.write(padBits);
                }
                this.out.write(bytes);
                debugPrint(element.appendLabel(element.rangeExpression()));
                this.out.flush();
                return;
            case 11:
            case 13:
            default:
                return;
            case 12:
                byte[] octets3 = ASN1OctetString.getInstance(aSN1Primitive).getOctets();
                if (!element.isFixedLength()) {
                    encodeLength(octets3.length);
                }
                this.out.write(octets3);
                debugPrint(element.appendLabel(element.rangeExpression()));
                this.out.flush();
                return;
            case 14:
                debugPrint(element.getLabel());
                boolean zIsTrue = ASN1Boolean.getInstance(aSN1Primitive).isTrue();
                OutputStream outputStream = this.out;
                if (zIsTrue) {
                    outputStream.write(255);
                } else {
                    outputStream.write(0);
                }
                this.out.flush();
                return;
        }
    }

    public void writePlainType(ASN1Encodable aSN1Encodable, Element element) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OEROutputStream oEROutputStream = new OEROutputStream(byteArrayOutputStream);
        oEROutputStream.write(aSN1Encodable, element);
        oEROutputStream.flush();
        oEROutputStream.close();
        encodeLength(byteArrayOutputStream.size());
        write(byteArrayOutputStream.toByteArray());
    }
}
