package expo.modules.updates.manifest;

import android.util.Log;
import expo.modules.structuredheaders.BooleanItem;
import expo.modules.structuredheaders.Item;
import expo.modules.structuredheaders.ListElement;
import expo.modules.structuredheaders.NumberItem;
import expo.modules.structuredheaders.ParseException;
import expo.modules.structuredheaders.Parser;
import expo.modules.structuredheaders.StringItem;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ResponseHeaderData.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÂ\u0003J-\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lexpo/modules/updates/manifest/ResponseHeaderData;", "", "protocolVersionRaw", "", "serverDefinedHeadersRaw", "manifestFiltersRaw", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "protocolVersion", "", "getProtocolVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "serverDefinedHeaders", "Lorg/json/JSONObject;", "getServerDefinedHeaders", "()Lorg/json/JSONObject;", "serverDefinedHeaders$delegate", "Lkotlin/Lazy;", "manifestFilters", "getManifestFilters", "manifestFilters$delegate", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ResponseHeaderData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ResponseHeaderData";

    /* JADX INFO: renamed from: manifestFilters$delegate, reason: from kotlin metadata */
    private final Lazy manifestFilters;
    private final String manifestFiltersRaw;
    private final Integer protocolVersion;
    private final String protocolVersionRaw;

    /* JADX INFO: renamed from: serverDefinedHeaders$delegate, reason: from kotlin metadata */
    private final Lazy serverDefinedHeaders;
    private final String serverDefinedHeadersRaw;

    public ResponseHeaderData() {
        this(null, null, null, 7, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getProtocolVersionRaw() {
        return this.protocolVersionRaw;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final String getServerDefinedHeadersRaw() {
        return this.serverDefinedHeadersRaw;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final String getManifestFiltersRaw() {
        return this.manifestFiltersRaw;
    }

    public static /* synthetic */ ResponseHeaderData copy$default(ResponseHeaderData responseHeaderData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = responseHeaderData.protocolVersionRaw;
        }
        if ((i & 2) != 0) {
            str2 = responseHeaderData.serverDefinedHeadersRaw;
        }
        if ((i & 4) != 0) {
            str3 = responseHeaderData.manifestFiltersRaw;
        }
        return responseHeaderData.copy(str, str2, str3);
    }

    public final ResponseHeaderData copy(String protocolVersionRaw, String serverDefinedHeadersRaw, String manifestFiltersRaw) {
        return new ResponseHeaderData(protocolVersionRaw, serverDefinedHeadersRaw, manifestFiltersRaw);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseHeaderData)) {
            return false;
        }
        ResponseHeaderData responseHeaderData = (ResponseHeaderData) other;
        return Intrinsics.areEqual(this.protocolVersionRaw, responseHeaderData.protocolVersionRaw) && Intrinsics.areEqual(this.serverDefinedHeadersRaw, responseHeaderData.serverDefinedHeadersRaw) && Intrinsics.areEqual(this.manifestFiltersRaw, responseHeaderData.manifestFiltersRaw);
    }

    public int hashCode() {
        String str = this.protocolVersionRaw;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.serverDefinedHeadersRaw;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.manifestFiltersRaw;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ResponseHeaderData(protocolVersionRaw=" + this.protocolVersionRaw + ", serverDefinedHeadersRaw=" + this.serverDefinedHeadersRaw + ", manifestFiltersRaw=" + this.manifestFiltersRaw + ")";
    }

    public ResponseHeaderData(String str, String str2, String str3) {
        this.protocolVersionRaw = str;
        this.serverDefinedHeadersRaw = str2;
        this.manifestFiltersRaw = str3;
        this.protocolVersion = str != null ? Integer.valueOf(str) : null;
        this.serverDefinedHeaders = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.manifest.ResponseHeaderData$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ResponseHeaderData.serverDefinedHeaders_delegate$lambda$0(this.f$0);
            }
        });
        this.manifestFilters = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.manifest.ResponseHeaderData$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ResponseHeaderData.manifestFilters_delegate$lambda$0(this.f$0);
            }
        });
    }

    public /* synthetic */ ResponseHeaderData(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final Integer getProtocolVersion() {
        return this.protocolVersion;
    }

    public final JSONObject getServerDefinedHeaders() {
        return (JSONObject) this.serverDefinedHeaders.getValue();
    }

    static final JSONObject serverDefinedHeaders_delegate$lambda$0(ResponseHeaderData responseHeaderData) {
        String str = responseHeaderData.serverDefinedHeadersRaw;
        if (str != null) {
            return INSTANCE.headerDictionaryToJSONObject(str);
        }
        return null;
    }

    public final JSONObject getManifestFilters() {
        return (JSONObject) this.manifestFilters.getValue();
    }

    static final JSONObject manifestFilters_delegate$lambda$0(ResponseHeaderData responseHeaderData) {
        String str = responseHeaderData.manifestFiltersRaw;
        if (str != null) {
            return INSTANCE.headerDictionaryToJSONObject(str);
        }
        return null;
    }

    /* JADX INFO: compiled from: ResponseHeaderData.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lexpo/modules/updates/manifest/ResponseHeaderData$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "headerDictionaryToJSONObject", "Lorg/json/JSONObject;", "headerDictionary", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JSONObject headerDictionaryToJSONObject(String headerDictionary) {
            JSONObject jSONObject = new JSONObject();
            try {
                Map<String, ListElement<? extends Object>> map = new Parser(headerDictionary).parseDictionary().get();
                for (String str : map.keySet()) {
                    ListElement<? extends Object> listElement = map.get(str);
                    Intrinsics.checkNotNull(listElement);
                    ListElement<? extends Object> listElement2 = listElement;
                    if ((listElement2 instanceof StringItem) || (listElement2 instanceof BooleanItem) || (listElement2 instanceof NumberItem)) {
                        jSONObject.put(str, ((Item) listElement2).get());
                    }
                }
                return jSONObject;
            } catch (ParseException e) {
                Log.e(ResponseHeaderData.TAG, "Failed to parse manifest header content", e);
                return null;
            } catch (JSONException e2) {
                Log.e(ResponseHeaderData.TAG, "Failed to parse manifest header content", e2);
                return null;
            }
        }
    }
}
