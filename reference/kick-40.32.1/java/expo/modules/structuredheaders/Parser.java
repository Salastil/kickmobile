package expo.modules.structuredheaders;

import android.util.Base64;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes9.dex */
public class Parser {
    private static char EOD = 65535;
    private final CharBuffer input;
    private final List<Integer> startPositions;

    public Parser(String str) {
        this(Collections.singletonList((String) Objects.requireNonNull(str, "input must not be null")));
    }

    public Parser(String... strArr) {
        this(Arrays.asList(strArr));
    }

    public Parser(Iterable<String> iterable) {
        List<Integer> arrayList = Collections.EMPTY_LIST;
        String strCheckASCII = null;
        StringBuilder sb = null;
        for (String str : (Iterable) Objects.requireNonNull(iterable, "fieldLines must not be null")) {
            if (strCheckASCII == null) {
                strCheckASCII = checkASCII(str);
            } else {
                if (sb == null) {
                    sb = new StringBuilder();
                    sb.append(strCheckASCII);
                }
                arrayList = arrayList.size() == 0 ? new ArrayList<>() : arrayList;
                arrayList.add(Integer.valueOf(sb.length()));
                sb.append(WebViewLogEventConsumer.DDTAGS_SEPARATOR);
                sb.append(checkASCII(str));
            }
        }
        if (strCheckASCII == null && sb == null) {
            throw new ParseException("Empty input", "", 0);
        }
        this.input = CharBuffer.wrap(sb != null ? sb : strCheckASCII);
        this.startPositions = arrayList;
    }

    private static String checkASCII(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 0 || cCharAt > 127) {
                throw new ParseException(String.format("Invalid character in field line at position %d: '%c' (0x%04x) (input: %s)", Integer.valueOf(i), Character.valueOf(cCharAt), Integer.valueOf(cCharAt), str), str, i);
            }
        }
        return str;
    }

    private NumberItem<? extends Object> internalParseBareIntegerOrDecimal() {
        int i;
        StringBuilder sb = new StringBuilder(20);
        if (checkNextChar('-')) {
            advance();
            i = -1;
        } else {
            i = 1;
        }
        if (!checkNextChar("0123456789")) {
            throw complaint("Illegal start for Integer or Decimal: '" + ((Object) this.input) + "'");
        }
        boolean z = false;
        boolean z2 = false;
        while (hasRemaining() && !z) {
            char cPeek = peek();
            if (Utils.isDigit(cPeek)) {
                sb.append(cPeek);
                advance();
            } else if (z2 || cPeek != '.') {
                z = true;
            } else {
                if (sb.length() > 12) {
                    throw complaint("Illegal position for decimal point in Decimal after '" + ((Object) sb) + "'");
                }
                sb.append(cPeek);
                advance();
                z2 = true;
            }
            if (sb.length() > (z2 ? 16 : 15)) {
                backout();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(z2 ? "Decimal" : "Integer");
                sb2.append(" too long: ");
                sb2.append(sb.length());
                sb2.append(" characters");
                throw complaint(sb2.toString());
            }
        }
        if (!z2) {
            return IntegerItem.valueOf(((long) i) * Long.parseLong(sb.toString()));
        }
        int iIndexOf = sb.indexOf(".");
        int length = (sb.length() - iIndexOf) - 1;
        if (length < 1) {
            backout();
            throw complaint("Decimal must not end in '.'");
        }
        if (length == 1) {
            sb.append("00");
        } else if (length == 2) {
            sb.append("0");
        } else if (length > 3) {
            backout();
            throw complaint("Maximum number of fractional digits is 3, found: " + length + ", in: " + ((Object) sb));
        }
        sb.deleteCharAt(iIndexOf);
        return DecimalItem.valueOf(((long) i) * Long.parseLong(sb.toString()));
    }

    private NumberItem<? extends Object> internalParseIntegerOrDecimal() {
        return internalParseBareIntegerOrDecimal().withParams2(internalParseParameters());
    }

    private StringItem internalParseBareString() {
        if (getOrEOD() != '\"') {
            throw complaint("String must start with double quote: '" + ((Object) this.input) + "'");
        }
        StringBuilder sb = new StringBuilder(length());
        while (hasRemaining()) {
            if (this.startPositions.contains(Integer.valueOf(position()))) {
                throw complaint("String crosses field line boundary at position " + position());
            }
            char c = get();
            if (c == '\\') {
                char orEOD = getOrEOD();
                if (orEOD == EOD) {
                    throw complaint("Incomplete escape sequence at position " + position());
                }
                if (orEOD != '\"' && orEOD != '\\') {
                    backout();
                    throw complaint("Invalid escape sequence character '" + orEOD + "' at position " + position());
                }
                sb.append(orEOD);
            } else {
                if (c == '\"') {
                    return StringItem.valueOf(sb.toString());
                }
                if (c < ' ' || c >= 127) {
                    throw complaint("Invalid character in String at position " + position());
                }
                sb.append(c);
            }
        }
        throw complaint("Closing DQUOTE missing");
    }

    private StringItem internalParseString() {
        return internalParseBareString().withParams2(internalParseParameters());
    }

    private TokenItem internalParseBareToken() {
        char orEOD = getOrEOD();
        if (orEOD != '*' && !Utils.isAlpha(orEOD)) {
            throw complaint("Token must start with ALPHA or *: '" + ((Object) this.input) + "'");
        }
        StringBuilder sb = new StringBuilder(length());
        sb.append(orEOD);
        boolean z = false;
        while (hasRemaining() && !z) {
            char cPeek = peek();
            if (cPeek <= ' ' || cPeek >= 127 || "\"(),;<=>?@[\\]{}".indexOf(cPeek) >= 0) {
                z = true;
            } else {
                advance();
                sb.append(cPeek);
            }
        }
        return TokenItem.valueOf(sb.toString());
    }

    private TokenItem internalParseToken() {
        return internalParseBareToken().withParams2(internalParseParameters());
    }

    private static boolean isBase64Char(char c) {
        return Utils.isAlpha(c) || Utils.isDigit(c) || c == '+' || c == '/' || c == '=';
    }

    private ByteSequenceItem internalParseBareByteSequence() {
        if (getOrEOD() != ':') {
            throw complaint("Byte Sequence must start with colon: " + ((Object) this.input));
        }
        StringBuilder sb = new StringBuilder(length());
        boolean z = false;
        while (hasRemaining() && !z) {
            char c = get();
            if (c == ':') {
                z = true;
            } else {
                if (!isBase64Char(c)) {
                    throw complaint("Invalid Byte Sequence Character '" + c + "' at position " + position());
                }
                sb.append(c);
            }
        }
        if (!z) {
            throw complaint("Byte Sequence must end with COLON: '" + ((Object) sb) + "'");
        }
        try {
            return ByteSequenceItem.valueOf(Base64.decode(sb.toString(), 0));
        } catch (IllegalArgumentException e) {
            throw complaint(e.getMessage(), e);
        }
    }

    private ByteSequenceItem internalParseByteSequence() {
        return internalParseBareByteSequence().withParams2(internalParseParameters());
    }

    private BooleanItem internalParseBareBoolean() {
        char orEOD = getOrEOD();
        if (orEOD == EOD) {
            throw complaint("Missing data in Boolean");
        }
        if (orEOD != '?') {
            backout();
            throw complaint(String.format("Boolean must start with question mark, got '%c'", Character.valueOf(orEOD)));
        }
        char orEOD2 = getOrEOD();
        if (orEOD2 == EOD) {
            throw complaint("Missing data in Boolean");
        }
        if (orEOD2 != '0' && orEOD2 != '1') {
            backout();
            throw complaint(String.format("Expected '0' or '1' in Boolean, found '%c'", Character.valueOf(orEOD2)));
        }
        return BooleanItem.valueOf(orEOD2 == '1');
    }

    private BooleanItem internalParseBoolean() {
        return internalParseBareBoolean().withParams2(internalParseParameters());
    }

    private String internalParseKey() {
        char orEOD = getOrEOD();
        if (orEOD == EOD) {
            throw complaint("Missing data in Key");
        }
        if (orEOD != '*' && !Utils.isLcAlpha(orEOD)) {
            backout();
            throw complaint("Key must start with LCALPHA or '*': " + format(orEOD));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(orEOD);
        boolean z = false;
        while (hasRemaining() && !z) {
            char cPeek = peek();
            if (Utils.isLcAlpha(cPeek) || Utils.isDigit(cPeek) || cPeek == '_' || cPeek == '-' || cPeek == '.' || cPeek == '*') {
                sb.append(cPeek);
                advance();
            } else {
                z = true;
            }
        }
        return sb.toString();
    }

    private Parameters internalParseParameters() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean z = false;
        while (hasRemaining() && !z) {
            if (peek() != ';') {
                z = true;
            } else {
                advance();
                removeLeadingSP();
                String strInternalParseKey = internalParseKey();
                Item<? extends Object> itemValueOf = BooleanItem.valueOf(true);
                if (peek() == '=') {
                    advance();
                    itemValueOf = internalParseBareItem();
                }
                linkedHashMap.put(strInternalParseKey, itemValueOf);
            }
        }
        return Parameters.valueOf(linkedHashMap);
    }

    private Item<? extends Object> internalParseBareItem() {
        if (!hasRemaining()) {
            throw complaint("Empty string found when parsing Bare Item");
        }
        char cPeek = peek();
        if (Utils.isDigit(cPeek) || cPeek == '-') {
            return internalParseBareIntegerOrDecimal();
        }
        if (cPeek == '\"') {
            return internalParseBareString();
        }
        if (cPeek == '?') {
            return internalParseBareBoolean();
        }
        if (cPeek == '*' || Utils.isAlpha(cPeek)) {
            return internalParseBareToken();
        }
        if (cPeek == ':') {
            return internalParseBareByteSequence();
        }
        throw complaint("Unexpected start character in Bare Item: " + format(cPeek));
    }

    private Item<? extends Object> internalParseItem() {
        return internalParseBareItem().withParams2(internalParseParameters());
    }

    private ListElement<? extends Object> internalParseItemOrInnerList() {
        return peek() == '(' ? internalParseInnerList() : internalParseItem();
    }

    private List<ListElement<? extends Object>> internalParseOuterList() {
        ArrayList arrayList = new ArrayList();
        while (hasRemaining()) {
            arrayList.add(internalParseItemOrInnerList());
            removeLeadingOWS();
            if (!hasRemaining()) {
                break;
            }
            char c = get();
            if (c != ',') {
                backout();
                throw complaint("Expected COMMA in List, got: " + format(c));
            }
            removeLeadingOWS();
            if (!hasRemaining()) {
                throw complaint("Found trailing COMMA in List");
            }
        }
        return arrayList;
    }

    private List<Item<? extends Object>> internalParseBareInnerList() {
        if (getOrEOD() != '(') {
            throw complaint("Inner List must start with '(': " + ((Object) this.input));
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (hasRemaining() && !z) {
            removeLeadingSP();
            if (peek() == ')') {
                advance();
                z = true;
            } else {
                arrayList.add(internalParseItem());
                char cPeek = peek();
                if (cPeek == EOD) {
                    throw complaint("Missing data in Inner List");
                }
                if (cPeek != ' ' && cPeek != ')') {
                    throw complaint("Expected SP or ')' in Inner List, got: " + format(cPeek));
                }
            }
        }
        if (z) {
            return arrayList;
        }
        throw complaint("Inner List must end with ')': " + ((Object) this.input));
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [expo.modules.structuredheaders.InnerList] */
    private InnerList internalParseInnerList() {
        List<Item<? extends Object>> listInternalParseBareInnerList = internalParseBareInnerList();
        return InnerList.valueOf(listInternalParseBareInnerList).withParams2(internalParseParameters());
    }

    private Dictionary internalParseDictionary() {
        ListElement<? extends Object> listElementWithParams2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean z = false;
        while (hasRemaining() && !z) {
            String strInternalParseKey = internalParseKey();
            if (peek() == '=') {
                advance();
                listElementWithParams2 = internalParseItemOrInnerList();
            } else {
                listElementWithParams2 = BooleanItem.valueOf(true).withParams2(internalParseParameters());
            }
            linkedHashMap.put(strInternalParseKey, listElementWithParams2);
            removeLeadingOWS();
            if (hasRemaining()) {
                char c = get();
                if (c != ',') {
                    backout();
                    throw complaint("Expected COMMA in Dictionary, found: " + format(c));
                }
                removeLeadingOWS();
                if (!hasRemaining()) {
                    throw complaint("Found trailing COMMA in Dictionary");
                }
            } else {
                z = true;
            }
        }
        return Dictionary.valueOf(linkedHashMap);
    }

    protected static IntegerItem parseInteger(String str) {
        Parser parser = new Parser(str);
        NumberItem<? extends Object> numberItemInternalParseIntegerOrDecimal = parser.internalParseIntegerOrDecimal();
        if (!(numberItemInternalParseIntegerOrDecimal instanceof IntegerItem)) {
            throw parser.complaint("String parsed as Integer '" + str + "' is a Decimal");
        }
        parser.assertEmpty("Extra characters in string parsed as Integer");
        return (IntegerItem) numberItemInternalParseIntegerOrDecimal;
    }

    protected static DecimalItem parseDecimal(String str) {
        Parser parser = new Parser(str);
        NumberItem<? extends Object> numberItemInternalParseIntegerOrDecimal = parser.internalParseIntegerOrDecimal();
        if (!(numberItemInternalParseIntegerOrDecimal instanceof DecimalItem)) {
            throw parser.complaint("String parsed as Decimal '" + str + "' is an Integer");
        }
        parser.assertEmpty("Extra characters in string parsed as Decimal");
        return (DecimalItem) numberItemInternalParseIntegerOrDecimal;
    }

    public OuterList parseList() {
        removeLeadingSP();
        List<ListElement<? extends Object>> listInternalParseOuterList = internalParseOuterList();
        removeLeadingSP();
        assertEmpty("Extra characters in string parsed as List");
        return OuterList.valueOf(listInternalParseOuterList);
    }

    public Dictionary parseDictionary() {
        removeLeadingSP();
        Dictionary dictionaryInternalParseDictionary = internalParseDictionary();
        removeLeadingSP();
        assertEmpty("Extra characters in string parsed as Dictionary");
        return dictionaryInternalParseDictionary;
    }

    public Item<? extends Object> parseItem() {
        removeLeadingSP();
        Item<? extends Object> itemInternalParseItem = internalParseItem();
        removeLeadingSP();
        assertEmpty("Extra characters in string parsed as Item");
        return itemInternalParseItem;
    }

    public static OuterList parseList(String str) {
        Parser parser = new Parser(str);
        List<ListElement<? extends Object>> listInternalParseOuterList = parser.internalParseOuterList();
        parser.assertEmpty("Extra characters in string parsed as List");
        return OuterList.valueOf(listInternalParseOuterList);
    }

    public static Parametrizable<? extends Object> parseItemOrInnerList(String str) {
        Parser parser = new Parser(str);
        ListElement<? extends Object> listElementInternalParseItemOrInnerList = parser.internalParseItemOrInnerList();
        parser.assertEmpty("Extra characters in string parsed as Item or Inner List");
        return listElementInternalParseItemOrInnerList;
    }

    public static InnerList parseInnerList(String str) {
        Parser parser = new Parser(str);
        InnerList innerListInternalParseInnerList = parser.internalParseInnerList();
        parser.assertEmpty("Extra characters in string parsed as Inner List");
        return innerListInternalParseInnerList;
    }

    public static Dictionary parseDictionary(String str) {
        Parser parser = new Parser(str);
        Dictionary dictionaryInternalParseDictionary = parser.internalParseDictionary();
        parser.assertEmpty("Extra characters in string parsed as Dictionary");
        return dictionaryInternalParseDictionary;
    }

    public static Item<? extends Object> parseItem(String str) {
        Parser parser = new Parser(str);
        Item<? extends Object> item = parser.parseItem();
        parser.assertEmpty("Extra characters in string parsed as Item");
        return item;
    }

    public static Item<? extends Object> parseBareItem(String str) {
        Parser parser = new Parser(str);
        Item<? extends Object> itemInternalParseBareItem = parser.internalParseBareItem();
        parser.assertEmpty("Extra characters in string parsed as Bare Item");
        return itemInternalParseBareItem;
    }

    public static Parameters parseParameters(String str) {
        Parser parser = new Parser(str);
        Parameters parametersInternalParseParameters = parser.internalParseParameters();
        parser.assertEmpty("Extra characters in string parsed as Parameters");
        return parametersInternalParseParameters;
    }

    public static String parseKey(String str) {
        Parser parser = new Parser(str);
        String strInternalParseKey = parser.internalParseKey();
        parser.assertEmpty("Extra characters in string parsed as Key");
        return strInternalParseKey;
    }

    public static NumberItem<? extends Object> parseIntegerOrDecimal(String str) {
        Parser parser = new Parser(str);
        NumberItem<? extends Object> numberItemInternalParseIntegerOrDecimal = parser.internalParseIntegerOrDecimal();
        parser.assertEmpty("Extra characters in string parsed as Integer or Decimal");
        return numberItemInternalParseIntegerOrDecimal;
    }

    public static StringItem parseString(String str) {
        Parser parser = new Parser(str);
        StringItem stringItemInternalParseString = parser.internalParseString();
        parser.assertEmpty("Extra characters in string parsed as String");
        return stringItemInternalParseString;
    }

    public static TokenItem parseToken(String str) {
        Parser parser = new Parser(str);
        TokenItem tokenItemInternalParseToken = parser.internalParseToken();
        parser.assertEmpty("Extra characters in string parsed as Token");
        return tokenItemInternalParseToken;
    }

    public static ByteSequenceItem parseByteSequence(String str) {
        Parser parser = new Parser(str);
        ByteSequenceItem byteSequenceItemInternalParseByteSequence = parser.internalParseByteSequence();
        parser.assertEmpty("Extra characters in string parsed as Byte Sequence");
        return byteSequenceItemInternalParseByteSequence;
    }

    public static BooleanItem parseBoolean(String str) {
        Parser parser = new Parser(str);
        BooleanItem booleanItemInternalParseBoolean = parser.internalParseBoolean();
        parser.assertEmpty("Extra characters at position %d in string parsed as Boolean: '%s'");
        return booleanItemInternalParseBoolean;
    }

    private void assertEmpty(String str) {
        if (hasRemaining()) {
            throw complaint(String.format(str, Integer.valueOf(position()), this.input));
        }
    }

    private void advance() {
        CharBuffer charBuffer = this.input;
        charBuffer.position(charBuffer.position() + 1);
    }

    private void backout() {
        CharBuffer charBuffer = this.input;
        charBuffer.position(charBuffer.position() - 1);
    }

    private boolean checkNextChar(char c) {
        return hasRemaining() && this.input.charAt(0) == c;
    }

    private boolean checkNextChar(String str) {
        return hasRemaining() && str.indexOf(this.input.charAt(0)) >= 0;
    }

    private char get() {
        return this.input.get();
    }

    private char getOrEOD() {
        return hasRemaining() ? get() : EOD;
    }

    private boolean hasRemaining() {
        return this.input.hasRemaining();
    }

    private int length() {
        return this.input.length();
    }

    private char peek() {
        return hasRemaining() ? this.input.charAt(0) : EOD;
    }

    private int position() {
        return this.input.position();
    }

    private void removeLeadingSP() {
        while (checkNextChar(' ')) {
            advance();
        }
    }

    private void removeLeadingOWS() {
        while (checkNextChar(" \t")) {
            advance();
        }
    }

    private ParseException complaint(String str) {
        return new ParseException(str, this.input);
    }

    private ParseException complaint(String str, Throwable th) {
        return new ParseException(str, this.input, th);
    }

    private static String format(char c) {
        String str;
        if (c == '\t') {
            str = "HTAB";
        } else {
            str = "'" + c + "'";
        }
        return String.format("%s (\\u%04x)", str, Integer.valueOf(c));
    }
}
