package expo.modules.crypto;

import io.github.expo.modules.v2.records.Record;
import io.github.expo.modules.v2.records.RecordCodec;
import io.github.expo.modules.v2.records.RecordField;
import io.github.expo.modules.v2.records.RecordRegistry;
import io.github.expo.modules.v2.records.RecordSchema;
import io.github.expo.modules.v2.records.readers.RecordReader;
import io.github.expo.modules.v2.records.writers.RecordWriter;
import io.github.expo.modules.v2.types.TypeDescriptor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DigestOptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0003\u0012\u0013\u0014B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lexpo/modules/crypto/DigestOptions;", "", "Lio/github/expo/modules/v2/records/Record;", "encoding", "Lexpo/modules/crypto/DigestOptions$Encoding;", "<init>", "(Lexpo/modules/crypto/DigestOptions$Encoding;)V", "getEncoding", "()Lexpo/modules/crypto/DigestOptions$Encoding;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Encoding", "Companion", "RecordCodec$ExpoModulesV2", "expo-crypto_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DigestOptions implements Record {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final RecordCodec<DigestOptions> recordCodec$ExpoModulesV2 = new RecordCodec<DigestOptions>() { // from class: expo.modules.crypto.DigestOptions$RecordCodec$ExpoModulesV2
        private final Class<DigestOptions> recordClass;
        private final RecordSchema schema;
        private final TypeDescriptor type$0;

        {
            TypeDescriptor.Simple simple = new TypeDescriptor.Simple(DigestOptions.Encoding.class, false);
            this.type$0 = simple;
            this.recordClass = DigestOptions.class;
            this.schema = new RecordSchema("DigestOptions", true, new RecordField("encoding", simple, true));
            RecordRegistry.INSTANCE.register(this);
        }

        @Override // io.github.expo.modules.v2.records.RecordCodec
        public final void encode(DigestOptions value, RecordWriter writer) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(writer, "writer");
            writer.write(value.getEncoding(), this.type$0);
        }

        @Override // io.github.expo.modules.v2.records.RecordCodec
        public final Class<DigestOptions> getRecordClass() {
            return this.recordClass;
        }

        @Override // io.github.expo.modules.v2.records.RecordCodec
        public final RecordSchema getSchema() {
            return this.schema;
        }

        @Override // io.github.expo.modules.v2.records.RecordCodec
        public DigestOptions fromMap(Map<String, ? extends Object> map) {
            return (DigestOptions) super.fromMap(map);
        }

        @Override // io.github.expo.modules.v2.records.RecordCodec
        public /* bridge */ /* synthetic */ Record fromMap(Map map) {
            return fromMap((Map<String, ? extends Object>) map);
        }

        @Override // io.github.expo.modules.v2.records.RecordCodec
        public Map<String, Object> toMap(DigestOptions digestOptions) {
            return super.toMap(digestOptions);
        }

        @Override // io.github.expo.modules.v2.records.RecordCodec
        public final DigestOptions decode(RecordReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return new DigestOptions(reader.readIsPresent() ? (DigestOptions.Encoding) reader.read(this.type$0) : DigestOptions.Encoding.HEX);
        }
    };
    private final Encoding encoding;

    /* JADX INFO: compiled from: DigestOptions.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lexpo/modules/crypto/DigestOptions$Companion;", "", "<init>", "()V", "recordCodec$ExpoModulesV2", "Lio/github/expo/modules/v2/records/RecordCodec;", "Lexpo/modules/crypto/DigestOptions;", "getRecordCodec$ExpoModulesV2", "()Lio/github/expo/modules/v2/records/RecordCodec;", "expo-crypto_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RecordCodec<DigestOptions> getRecordCodec$ExpoModulesV2() {
            return DigestOptions.recordCodec$ExpoModulesV2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DigestOptions() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DigestOptions copy$default(DigestOptions digestOptions, Encoding encoding, int i, Object obj) {
        if ((i & 1) != 0) {
            encoding = digestOptions.encoding;
        }
        return digestOptions.copy(encoding);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Encoding getEncoding() {
        return this.encoding;
    }

    public final DigestOptions copy(Encoding encoding) {
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        return new DigestOptions(encoding);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DigestOptions) && this.encoding == ((DigestOptions) other).encoding;
    }

    public int hashCode() {
        return this.encoding.hashCode();
    }

    public String toString() {
        return "DigestOptions(encoding=" + this.encoding + ")";
    }

    public DigestOptions(Encoding encoding) {
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        this.encoding = encoding;
    }

    public /* synthetic */ DigestOptions(Encoding encoding, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Encoding.HEX : encoding);
    }

    public final Encoding getEncoding() {
        return this.encoding;
    }

    /* JADX INFO: compiled from: DigestOptions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/crypto/DigestOptions$Encoding;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "HEX", "BASE64", "expo-crypto_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Encoding {
        HEX("hex"),
        BASE64("base64");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String value;

        public static EnumEntries<Encoding> getEntries() {
            return $ENTRIES;
        }

        Encoding(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }
}
