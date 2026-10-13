package org.bouncycastle.oer;

import io.ktor.sse.ServerSentEventKt;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes11.dex */
public class OERInputStream extends FilterInputStream {
    private static final int[] bits = {1, 2, 4, 8, 16, 32, 64, 128};
    private static final int[] bitsR = {128, 64, 32, 16, 8, 4, 2, 1};
    protected PrintWriter debugOutput;
    protected PrintWriter debugStream;
    private int maxByteAllocation;

    /* JADX INFO: renamed from: org.bouncycastle.oer.OERInputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType;

        static {
            int[] iArr = new int[OERDefinition.BaseType.values().length];
            $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType = iArr;
            try {
                iArr[OERDefinition.BaseType.OPAQUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.Switch.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.Supplier.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.SEQ_OF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.SEQ.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.CHOICE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.ENUM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.INT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.OCTET_STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.IA5String.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.UTF8_STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.BIT_STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.NULL.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.EXTENSION.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[OERDefinition.BaseType.BOOLEAN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public static class Choice extends OERInputStream {
        final int preamble;
        final int tag;
        final int tagClass;

        public Choice(InputStream inputStream) throws IOException {
            int i;
            super(inputStream);
            int i2 = read();
            this.preamble = i2;
            if (i2 < 0) {
                throw new EOFException("expecting preamble byte of choice");
            }
            this.tagClass = i2 & 192;
            int i3 = i2 & 63;
            if (i3 >= 63) {
                i3 = 0;
                do {
                    i = inputStream.read();
                    if (i < 0) {
                        throw new EOFException("expecting further tag bytes");
                    }
                    i3 = (i3 << 7) | (i & 127);
                } while ((i & 128) != 0);
            }
            this.tag = i3;
        }

        public int getTag() {
            return this.tag;
        }

        public int getTagClass() {
            return this.tagClass;
        }

        public boolean isApplicationTagClass() {
            return this.tagClass == 64;
        }

        public boolean isContextSpecific() {
            return this.tagClass == 128;
        }

        public boolean isPrivateTagClass() {
            return this.tagClass == 192;
        }

        public boolean isUniversalTagClass() {
            return this.tagClass == 0;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder("CHOICE(");
            int i = this.tagClass;
            if (i == 0) {
                str = "Universal ";
            } else if (i == 64) {
                str = "Application ";
            } else {
                if (i != 128) {
                    if (i == 192) {
                        str = "Private ";
                    }
                    sb.append("Tag = " + this.tag);
                    sb.append(")");
                    return sb.toString();
                }
                str = "ContextSpecific ";
            }
            sb.append(str);
            sb.append("Tag = " + this.tag);
            sb.append(")");
            return sb.toString();
        }
    }

    private static final class LengthInfo {
        private final BigInteger length;
        private final boolean shortForm;

        public LengthInfo(BigInteger bigInteger, boolean z) {
            this.length = bigInteger;
            this.shortForm = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int intLength() {
            return BigIntegers.intValueExact(this.length);
        }
    }

    public static class Sequence extends OERInputStream {
        private final boolean extensionFlagSet;
        private final int preamble;
        private final boolean[] valuePresent;

        public Sequence(InputStream inputStream, Element element) throws IOException {
            int i;
            super(inputStream);
            if (!element.hasPopulatedExtension() && element.getOptionals() <= 0 && !element.hasDefaultChildren()) {
                this.preamble = 0;
                this.extensionFlagSet = false;
                this.valuePresent = null;
                return;
            }
            int i2 = this.in.read();
            this.preamble = i2;
            if (i2 < 0) {
                throw new EOFException("expecting preamble byte of sequence");
            }
            this.extensionFlagSet = element.hasPopulatedExtension() && (i2 & 128) == 128;
            this.valuePresent = new boolean[element.getChildren().size()];
            int i3 = element.hasPopulatedExtension() ? 6 : 7;
            int i4 = 0;
            for (Element element2 : element.getChildren()) {
                if (element2.getBaseType() != OERDefinition.BaseType.EXTENSION) {
                    if (element2.getBlock() != 0) {
                        return;
                    }
                    if (element2.isExplicit()) {
                        i = i4 + 1;
                        this.valuePresent[i4] = true;
                    } else {
                        if (i3 < 0) {
                            i2 = inputStream.read();
                            if (i2 < 0) {
                                throw new EOFException("expecting mask byte sequence");
                            }
                            i3 = 7;
                        }
                        i = i4 + 1;
                        this.valuePresent[i4] = (OERInputStream.bits[i3] & i2) > 0;
                        i3--;
                    }
                    i4 = i;
                }
            }
        }

        public boolean hasExtension() {
            return this.extensionFlagSet;
        }

        public boolean hasOptional(int i) {
            return this.valuePresent[i];
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("SEQ(");
            sb.append(hasExtension() ? "Ext " : "");
            if (this.valuePresent != null) {
                int i = 0;
                while (true) {
                    boolean[] zArr = this.valuePresent;
                    if (i >= zArr.length) {
                        break;
                    }
                    sb.append(zArr[i] ? "1" : "0");
                    i++;
                }
            } else {
                sb.append("*");
            }
            sb.append(")");
            return sb.toString();
        }
    }

    public OERInputStream(InputStream inputStream) {
        super(inputStream);
        this.debugOutput = null;
        this.maxByteAllocation = 1048576;
        this.debugStream = null;
    }

    public OERInputStream(InputStream inputStream, int i) {
        super(inputStream);
        this.debugOutput = null;
        this.debugStream = null;
        this.maxByteAllocation = i;
    }

    private ASN1Encodable absent(Element element) {
        debugPrint(element + "Absent");
        return OEROptional.ABSENT;
    }

    private byte[] allocateArray(int i) {
        if (i <= this.maxByteAllocation) {
            return new byte[i];
        }
        throw new IllegalArgumentException("required byte array size " + i + " was greater than " + this.maxByteAllocation);
    }

    private int countOptionalChildTypes(Element element) {
        Iterator<Element> it = element.getChildren().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += !it.next().isExplicit() ? 1 : 0;
        }
        return i;
    }

    public static ASN1Encodable parse(byte[] bArr, Element element) throws IOException {
        return new OERInputStream(new ByteArrayInputStream(bArr)).parse(element);
    }

    public Choice choice() throws IOException {
        return new Choice(this);
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

    public BigInteger enumeration() throws IOException {
        int i = read();
        if (i == -1) {
            throw new EOFException("expecting prefix of enumeration");
        }
        if ((i & 128) != 128) {
            return BigInteger.valueOf(i);
        }
        int i2 = i & 127;
        if (i2 == 0) {
            return BigInteger.ZERO;
        }
        byte[] bArr = new byte[i2];
        if (Streams.readFully(this, bArr) == i2) {
            return new BigInteger(1, bArr);
        }
        throw new EOFException("unable to fully read integer component of enumeration");
    }

    public BigInteger int16() throws Exception {
        return parseInt(false, 2);
    }

    public BigInteger int32() throws Exception {
        return parseInt(false, 4);
    }

    public BigInteger int64() throws Exception {
        return parseInt(false, 8);
    }

    public BigInteger int8() throws Exception {
        return parseInt(false, 1);
    }

    /* JADX WARN: Code duplicated, block: B:147:0x041c  */
    /* JADX WARN: Code duplicated, block: B:162:0x0455  */
    /* JADX WARN: Code duplicated, block: B:164:0x046a  */
    /* JADX WARN: Code duplicated, block: B:170:0x047d  */
    /* JADX WARN: Code duplicated, block: B:171:0x0484  */
    /* JADX WARN: Code duplicated, block: B:173:0x0487  */
    /* JADX WARN: Code duplicated, block: B:175:0x0494  */
    /* JADX WARN: Code duplicated, block: B:178:0x04a0 A[LOOP:4: B:176:0x049c->B:178:0x04a0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:179:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:183:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:185:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:190:0x04d2  */
    /* JADX WARN: Code duplicated, block: B:222:0x04ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:224:0x04c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x0297 A[PHI: r2
      0x0297: PHI (r2v19 byte[]) = (r2v18 byte[]), (r2v20 byte[]) binds: [B:98:0x0295, B:94:0x027b] A[DONT_GENERATE, DONT_INLINE]] */
    public ASN1Object parse(Element element) throws Throwable {
        byte[] bArrAllocateArray;
        int length;
        Element element2;
        ASN1Encodable openType;
        int iIntLength;
        Element elementResult;
        ASN1Encodable defaultValue;
        byte[] bArrAllocateArray2;
        BigInteger bigInteger;
        int i = 8;
        switch (AnonymousClass1.$SwitchMap$org$bouncycastle$oer$OERDefinition$BaseType[element.getBaseType().ordinal()]) {
            case 1:
                return parse(new Element(element.resolveSupplier().build(), element));
            case 2:
                throw new IllegalStateException("A switch element should only be found within a sequence.");
            case 3:
                return parse(new Element(element.getElementSupplier().build(), element));
            case 4:
                byte[] bArrAllocateArray3 = allocateArray(readLength().intLength());
                if (Streams.readFully(this, bArrAllocateArray3) != bArrAllocateArray3.length) {
                    throw new IOException("could not read all of count of seq-of values");
                }
                int iIntValue = BigIntegers.fromUnsignedByteArray(bArrAllocateArray3).intValue();
                debugPrint(element + "(len = " + iIntValue + ")");
                ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                if (element.getChildren().get(0).getaSwitch() != null) {
                    throw new IllegalStateException("element def for item in SEQ OF has a switch, switches only supported in sequences");
                }
                for (int i2 = 0; i2 < iIntValue; i2++) {
                    aSN1EncodableVector.add(parse(Element.expandDeferredDefinition(element.getChildren().get(0), element)));
                }
                return new DERSequence(aSN1EncodableVector);
            case 5:
                Sequence sequence = new Sequence(this.in, element);
                debugPrint(element + sequence.toString());
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                List<Element> children = element.getChildren();
                int i3 = 0;
                while (i3 < children.size()) {
                    Element element3 = children.get(i3);
                    if (element3.getBaseType() != OERDefinition.BaseType.EXTENSION) {
                        if (element3.getBlock() > 0) {
                            if (sequence.extensionFlagSet) {
                                bArrAllocateArray = allocateArray(readLength().intLength());
                                if (Streams.readFully(this.in, bArrAllocateArray) == bArrAllocateArray.length) {
                                    throw new IOException("did not fully read presence list.");
                                }
                                length = (bArrAllocateArray.length * 8) - bArrAllocateArray[0];
                                while (true) {
                                    if (i3 >= children.size() || i < length) {
                                        if (i3 < children.size()) {
                                            element2 = children.get(i3);
                                        } else {
                                            element2 = null;
                                        }
                                        if (element2 == null) {
                                            if (i >= length && (bArrAllocateArray[i / 8] & bitsR[i % 8]) != 0) {
                                                openType = parseOpenType(element2);
                                            } else {
                                                if (element2.isExplicit()) {
                                                    throw new IOException("extension is marked as explicit but is not defined in presence list");
                                                }
                                                openType = OEROptional.ABSENT;
                                            }
                                            aSN1EncodableVector2.add(openType);
                                        } else if ((bArrAllocateArray[i / 8] & bitsR[i % 8]) != 0) {
                                            iIntLength = readLength().intLength();
                                            while (true) {
                                                iIntLength--;
                                                if (iIntLength >= 0) {
                                                    this.in.read();
                                                }
                                            }
                                        }
                                        i++;
                                        i3++;
                                    }
                                }
                            }
                            return new DERSequence(aSN1EncodableVector2);
                        }
                        Element elementExpandDeferredDefinition = Element.expandDeferredDefinition(element3, element);
                        if (elementExpandDeferredDefinition.getaSwitch() != null) {
                            elementResult = elementExpandDeferredDefinition.getaSwitch().result(new SwitchIndexer.Asn1EncodableVectorIndexer(aSN1EncodableVector2));
                            if (elementResult.getParent() != element) {
                                elementResult = new Element(elementResult, element);
                            }
                        } else {
                            elementResult = elementExpandDeferredDefinition;
                        }
                        if (sequence.valuePresent == null) {
                            defaultValue = parse(elementResult);
                        } else if (!sequence.valuePresent[i3]) {
                            defaultValue = elementResult.getDefaultValue() != null ? elementExpandDeferredDefinition.getDefaultValue() : absent(elementExpandDeferredDefinition);
                        } else if (elementResult.isExplicit()) {
                            defaultValue = parse(elementResult);
                        } else {
                            defaultValue = OEROptional.getInstance(parse(elementResult));
                        }
                        aSN1EncodableVector2.add(defaultValue);
                    }
                    i3++;
                }
                if (sequence.extensionFlagSet) {
                    bArrAllocateArray = allocateArray(readLength().intLength());
                    if (Streams.readFully(this.in, bArrAllocateArray) == bArrAllocateArray.length) {
                        throw new IOException("did not fully read presence list.");
                    }
                    length = (bArrAllocateArray.length * 8) - bArrAllocateArray[0];
                    while (true) {
                        if (i3 >= children.size()) {
                        }
                        if (i3 < children.size()) {
                            element2 = children.get(i3);
                        } else {
                            element2 = null;
                        }
                        if (element2 == null) {
                            if (i >= length) {
                                if (element2.isExplicit()) {
                                    throw new IOException("extension is marked as explicit but is not defined in presence list");
                                }
                                openType = OEROptional.ABSENT;
                            } else {
                                if (element2.isExplicit()) {
                                    throw new IOException("extension is marked as explicit but is not defined in presence list");
                                }
                                openType = OEROptional.ABSENT;
                            }
                            aSN1EncodableVector2.add(openType);
                        } else if ((bArrAllocateArray[i / 8] & bitsR[i % 8]) != 0) {
                            iIntLength = readLength().intLength();
                            while (true) {
                                iIntLength--;
                                if (iIntLength >= 0) {
                                    this.in.read();
                                }
                            }
                        }
                        i++;
                        i3++;
                    }
                }
                return new DERSequence(aSN1EncodableVector2);
            case 6:
                Choice choice = choice();
                debugPrint(choice.toString() + ServerSentEventKt.SPACE + choice.tag);
                if (!choice.isContextSpecific()) {
                    if (choice.isApplicationTagClass()) {
                        throw new IllegalStateException("Unimplemented tag type");
                    }
                    if (choice.isPrivateTagClass()) {
                        throw new IllegalStateException("Unimplemented tag type");
                    }
                    if (choice.isUniversalTagClass()) {
                        throw new IllegalStateException("Unimplemented tag type");
                    }
                    throw new IllegalStateException("Unimplemented tag type");
                }
                Element elementExpandDeferredDefinition2 = Element.expandDeferredDefinition(element.getChildren().get(choice.getTag()), element);
                if (elementExpandDeferredDefinition2.getBlock() > 0) {
                    debugPrint("Chosen (Ext): " + elementExpandDeferredDefinition2);
                    return new DERTaggedObject(choice.tag, parseOpenType(elementExpandDeferredDefinition2));
                }
                debugPrint("Chosen: " + elementExpandDeferredDefinition2);
                return new DERTaggedObject(choice.tag, parse(elementExpandDeferredDefinition2));
            case 7:
                BigInteger bigIntegerEnumeration = enumeration();
                debugPrint(element + "ENUM(" + bigIntegerEnumeration + ") = " + element.getChildren().get(bigIntegerEnumeration.intValue()).getLabel());
                return new ASN1Enumerated(bigIntegerEnumeration);
            case 8:
                int iIntBytesForRange = element.intBytesForRange();
                if (iIntBytesForRange != 0) {
                    bArrAllocateArray2 = allocateArray(Math.abs(iIntBytesForRange));
                    Streams.readFully(this, bArrAllocateArray2);
                    bigInteger = iIntBytesForRange < 0 ? new BigInteger(bArrAllocateArray2) : BigIntegers.fromUnsignedByteArray(bArrAllocateArray2);
                } else if (element.isLowerRangeZero()) {
                    bArrAllocateArray2 = allocateArray(readLength().intLength());
                    Streams.readFully(this, bArrAllocateArray2);
                    if (bArrAllocateArray2.length == 0) {
                        bigInteger = BigInteger.ZERO;
                    } else {
                        bigInteger = new BigInteger(1, bArrAllocateArray2);
                    }
                } else {
                    bArrAllocateArray2 = allocateArray(readLength().intLength());
                    Streams.readFully(this, bArrAllocateArray2);
                    if (bArrAllocateArray2.length == 0) {
                        bigInteger = BigInteger.ZERO;
                    } else {
                        bigInteger = new BigInteger(bArrAllocateArray2);
                    }
                }
                if (this.debugOutput != null) {
                    debugPrint(element + "INTEGER byteLen= " + bArrAllocateArray2.length + " hex= " + bigInteger.toString(16) + ")");
                }
                return new ASN1Integer(bigInteger);
            case 9:
                int iIntLength2 = (element.getUpperBound() == null || !element.getUpperBound().equals(element.getLowerBound())) ? readLength().intLength() : element.getUpperBound().intValue();
                byte[] bArrAllocateArray4 = allocateArray(iIntLength2);
                if (Streams.readFully(this, bArrAllocateArray4) != iIntLength2) {
                    throw new IOException("did not read all of " + element.getLabel());
                }
                if (this.debugOutput != null) {
                    int iMin = Math.min(bArrAllocateArray4.length, 32);
                    StringBuilder sb = new StringBuilder();
                    sb.append(element);
                    sb.append("OCTET STRING (");
                    sb.append(bArrAllocateArray4.length);
                    sb.append(") = ");
                    sb.append(Hex.toHexString(bArrAllocateArray4, 0, iMin));
                    sb.append(ServerSentEventKt.SPACE);
                    sb.append(bArrAllocateArray4.length > 32 ? "..." : "");
                    debugPrint(sb.toString());
                }
                return new DEROctetString(bArrAllocateArray4);
            case 10:
                byte[] bArrAllocateArray5 = allocateArray(element.isFixedLength() ? element.getUpperBound().intValue() : readLength().intLength());
                if (Streams.readFully(this, bArrAllocateArray5) != bArrAllocateArray5.length) {
                    throw new IOException("could not read all of IA5 string");
                }
                String strFromByteArray = Strings.fromByteArray(bArrAllocateArray5);
                if (this.debugOutput != null) {
                    debugPrint(element.appendLabel("IA5 String (" + bArrAllocateArray5.length + ") = " + strFromByteArray));
                }
                return new DERIA5String(strFromByteArray);
            case 11:
                byte[] bArrAllocateArray6 = allocateArray(readLength().intLength());
                if (Streams.readFully(this, bArrAllocateArray6) != bArrAllocateArray6.length) {
                    throw new IOException("could not read all of utf 8 string");
                }
                String strFromUTF8ByteArray = Strings.fromUTF8ByteArray(bArrAllocateArray6);
                if (this.debugOutput != null) {
                    debugPrint(element + "UTF8 String (" + bArrAllocateArray6.length + ") = " + strFromUTF8ByteArray);
                }
                return new DERUTF8String(strFromUTF8ByteArray);
            case 12:
                byte[] bArrAllocateArray7 = element.isFixedLength() ? new byte[element.getLowerBound().intValue() / 8] : allocateArray((BigInteger.ZERO.compareTo(element.getUpperBound()) > 0 ? element.getUpperBound().intValue() : readLength().intLength()) / 8);
                Streams.readFully(this, bArrAllocateArray7);
                if (this.debugOutput != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("BIT STRING(" + (bArrAllocateArray7.length * 8) + ") = ");
                    for (int i4 = 0; i4 != bArrAllocateArray7.length; i4++) {
                        byte b = bArrAllocateArray7[i4];
                        for (int i5 = 0; i5 < 8; i5++) {
                            stringBuffer.append((b & 128) > 0 ? "1" : "0");
                            b = (byte) (b << 1);
                        }
                    }
                    debugPrint(element + stringBuffer.toString());
                }
                return new DERBitString(bArrAllocateArray7);
            case 13:
                debugPrint(element + "NULL");
                return DERNull.INSTANCE;
            case 14:
                LengthInfo length2 = readLength();
                byte[] bArr = new byte[length2.intLength()];
                if (Streams.readFully(this, bArr) != length2.intLength()) {
                    throw new IOException("could not read all of count of open value in choice (...) ");
                }
                debugPrint("ext " + length2.intLength() + ServerSentEventKt.SPACE + Hex.toHexString(bArr));
                return new DEROctetString(bArr);
            case 15:
                return read() == 0 ? ASN1Boolean.FALSE : ASN1Boolean.TRUE;
            default:
                throw new IllegalStateException("Unhandled type " + element.getBaseType());
        }
    }

    public BigInteger parseInt(boolean z, int i) throws Exception {
        byte[] bArr = new byte[i];
        if (Streams.readFully(this, bArr) == i) {
            return z ? new BigInteger(1, bArr) : new BigInteger(bArr);
        }
        throw new IllegalStateException("integer not fully read");
    }

    protected ASN1Encodable parseOpenType(Element element) throws Throwable {
        OERInputStream oERInputStream;
        Throwable th;
        byte[] bArrAllocateArray = allocateArray(readLength().intLength());
        if (Streams.readFully(this.in, bArrAllocateArray) != bArrAllocateArray.length) {
            throw new IOException("did not fully read open type as raw bytes");
        }
        try {
            oERInputStream = new OERInputStream(new ByteArrayInputStream(bArrAllocateArray));
            try {
                ASN1Object aSN1Object = oERInputStream.parse(element);
                oERInputStream.close();
                return aSN1Object;
            } catch (Throwable th2) {
                th = th2;
                if (oERInputStream != null) {
                    oERInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            oERInputStream = null;
            th = th3;
        }
    }

    public LengthInfo readLength() throws IOException {
        int i = read();
        if (i == -1) {
            throw new EOFException("expecting length");
        }
        if ((i & 128) == 0) {
            StringBuilder sb = new StringBuilder("Len (Short form): ");
            int i2 = i & 127;
            sb.append(i2);
            debugPrint(sb.toString());
            return new LengthInfo(BigInteger.valueOf(i2), true);
        }
        int i3 = i & 127;
        byte[] bArr = new byte[i3];
        if (Streams.readFully(this, bArr) != i3) {
            throw new EOFException("did not read all bytes of length definition");
        }
        debugPrint("Len (Long Form): " + i3 + " actual len: " + Hex.toHexString(bArr));
        return new LengthInfo(BigIntegers.fromUnsignedByteArray(bArr), false);
    }

    public BigInteger uint16() throws Exception {
        return parseInt(true, 2);
    }

    public BigInteger uint32() throws Exception {
        return parseInt(true, 4);
    }

    public BigInteger uint64() throws Exception {
        return parseInt(false, 8);
    }

    public BigInteger uint8() throws Exception {
        return parseInt(true, 1);
    }
}
