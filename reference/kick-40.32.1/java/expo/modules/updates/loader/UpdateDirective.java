package expo.modules.updates.loader;

import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesUtils;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RemoteUpdate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \n2\u00020\u0001:\u0003\b\t\nB\u0013\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lexpo/modules/updates/loader/UpdateDirective;", "", "signingInfo", "Lexpo/modules/updates/loader/SigningInfo;", "<init>", "(Lexpo/modules/updates/loader/SigningInfo;)V", "getSigningInfo", "()Lexpo/modules/updates/loader/SigningInfo;", "NoUpdateAvailableUpdateDirective", "RollBackToEmbeddedUpdateDirective", "Companion", "Lexpo/modules/updates/loader/UpdateDirective$NoUpdateAvailableUpdateDirective;", "Lexpo/modules/updates/loader/UpdateDirective$RollBackToEmbeddedUpdateDirective;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class UpdateDirective {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SigningInfo signingInfo;

    public /* synthetic */ UpdateDirective(SigningInfo signingInfo, DefaultConstructorMarker defaultConstructorMarker) {
        this(signingInfo);
    }

    /* JADX INFO: compiled from: RemoteUpdate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/updates/loader/UpdateDirective$NoUpdateAvailableUpdateDirective;", "Lexpo/modules/updates/loader/UpdateDirective;", "signingInfo", "Lexpo/modules/updates/loader/SigningInfo;", "<init>", "(Lexpo/modules/updates/loader/SigningInfo;)V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class NoUpdateAvailableUpdateDirective extends UpdateDirective {
        public NoUpdateAvailableUpdateDirective(SigningInfo signingInfo) {
            super(signingInfo, null);
        }
    }

    private UpdateDirective(SigningInfo signingInfo) {
        this.signingInfo = signingInfo;
    }

    public final SigningInfo getSigningInfo() {
        return this.signingInfo;
    }

    /* JADX INFO: compiled from: RemoteUpdate.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lexpo/modules/updates/loader/UpdateDirective$RollBackToEmbeddedUpdateDirective;", "Lexpo/modules/updates/loader/UpdateDirective;", "commitTime", "Ljava/util/Date;", "signingInfo", "Lexpo/modules/updates/loader/SigningInfo;", "<init>", "(Ljava/util/Date;Lexpo/modules/updates/loader/SigningInfo;)V", "getCommitTime", "()Ljava/util/Date;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class RollBackToEmbeddedUpdateDirective extends UpdateDirective {
        private final Date commitTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RollBackToEmbeddedUpdateDirective(Date commitTime, SigningInfo signingInfo) {
            super(signingInfo, null);
            Intrinsics.checkNotNullParameter(commitTime, "commitTime");
            this.commitTime = commitTime;
        }

        public final Date getCommitTime() {
            return this.commitTime;
        }
    }

    /* JADX INFO: compiled from: RemoteUpdate.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/updates/loader/UpdateDirective$Companion;", "", "<init>", "()V", "fromJSONString", "Lexpo/modules/updates/loader/UpdateDirective;", "jsonString", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UpdateDirective fromJSONString(String jsonString) throws JSONException {
            JSONObject jSONObject;
            String string;
            JSONObject jSONObject2;
            String string2;
            JSONObject jSONObject3;
            String string3;
            String string4;
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            JSONObject jSONObject4 = new JSONObject(jsonString);
            SigningInfo signingInfo = null;
            if (!jSONObject4.has("extra")) {
                jSONObject = null;
            } else if (Intrinsics.areEqual(JSONObject.class, String.class)) {
                Object string5 = jSONObject4.getString("extra");
                if (string5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) string5;
            } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
                jSONObject = (JSONObject) Double.valueOf(jSONObject4.getDouble("extra"));
            } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
                jSONObject = (JSONObject) Integer.valueOf(jSONObject4.getInt("extra"));
            } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
                jSONObject = (JSONObject) Long.valueOf(jSONObject4.getLong("extra"));
            } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
                jSONObject = (JSONObject) Boolean.valueOf(jSONObject4.getBoolean("extra"));
            } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
                Object jSONArray = jSONObject4.getJSONArray("extra");
                if (jSONArray == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) jSONArray;
            } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
                jSONObject = jSONObject4.getJSONObject("extra");
                if (jSONObject == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            } else {
                Object obj = jSONObject4.get("extra");
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) obj;
            }
            if (jSONObject != null) {
                if (!jSONObject.has("signingInfo")) {
                    jSONObject3 = null;
                } else if (Intrinsics.areEqual(JSONObject.class, String.class)) {
                    Object string6 = jSONObject.getString("signingInfo");
                    if (string6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject3 = (JSONObject) string6;
                } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
                    jSONObject3 = (JSONObject) Double.valueOf(jSONObject.getDouble("signingInfo"));
                } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
                    jSONObject3 = (JSONObject) Integer.valueOf(jSONObject.getInt("signingInfo"));
                } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
                    jSONObject3 = (JSONObject) Long.valueOf(jSONObject.getLong("signingInfo"));
                } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
                    jSONObject3 = (JSONObject) Boolean.valueOf(jSONObject.getBoolean("signingInfo"));
                } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
                    Object jSONArray2 = jSONObject.getJSONArray("signingInfo");
                    if (jSONArray2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject3 = (JSONObject) jSONArray2;
                } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
                    jSONObject3 = jSONObject.getJSONObject("signingInfo");
                    if (jSONObject3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                } else {
                    Object obj2 = jSONObject.get("signingInfo");
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject3 = (JSONObject) obj2;
                }
                if (jSONObject3 != null) {
                    if (Intrinsics.areEqual(String.class, String.class)) {
                        string3 = jSONObject3.getString("projectId");
                        if (string3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(String.class, Double.class)) {
                        string3 = (String) Double.valueOf(jSONObject3.getDouble("projectId"));
                    } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                        string3 = (String) Integer.valueOf(jSONObject3.getInt("projectId"));
                    } else if (Intrinsics.areEqual(String.class, Long.class)) {
                        string3 = (String) Long.valueOf(jSONObject3.getLong("projectId"));
                    } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                        string3 = (String) Boolean.valueOf(jSONObject3.getBoolean("projectId"));
                    } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                        Object jSONArray3 = jSONObject3.getJSONArray("projectId");
                        if (jSONArray3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string3 = (String) jSONArray3;
                    } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                        Object jSONObject5 = jSONObject3.getJSONObject("projectId");
                        if (jSONObject5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string3 = (String) jSONObject5;
                    } else {
                        Object obj3 = jSONObject3.get("projectId");
                        if (obj3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string3 = (String) obj3;
                    }
                    if (Intrinsics.areEqual(String.class, String.class)) {
                        string4 = jSONObject3.getString(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY);
                        if (string4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(String.class, Double.class)) {
                        string4 = (String) Double.valueOf(jSONObject3.getDouble(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY));
                    } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                        string4 = (String) Integer.valueOf(jSONObject3.getInt(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY));
                    } else if (Intrinsics.areEqual(String.class, Long.class)) {
                        string4 = (String) Long.valueOf(jSONObject3.getLong(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY));
                    } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                        string4 = (String) Boolean.valueOf(jSONObject3.getBoolean(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY));
                    } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                        Object jSONArray4 = jSONObject3.getJSONArray(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY);
                        if (jSONArray4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string4 = (String) jSONArray4;
                    } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                        Object jSONObject6 = jSONObject3.getJSONObject(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY);
                        if (jSONObject6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string4 = (String) jSONObject6;
                    } else {
                        Object obj4 = jSONObject3.get(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY);
                        if (obj4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string4 = (String) obj4;
                    }
                    signingInfo = new SigningInfo(string3, string4);
                }
            }
            if (Intrinsics.areEqual(String.class, String.class)) {
                string = jSONObject4.getString("type");
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(String.class, Double.class)) {
                string = (String) Double.valueOf(jSONObject4.getDouble("type"));
            } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                string = (String) Integer.valueOf(jSONObject4.getInt("type"));
            } else if (Intrinsics.areEqual(String.class, Long.class)) {
                string = (String) Long.valueOf(jSONObject4.getLong("type"));
            } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                string = (String) Boolean.valueOf(jSONObject4.getBoolean("type"));
            } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                Object jSONArray5 = jSONObject4.getJSONArray("type");
                if (jSONArray5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) jSONArray5;
            } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                Object jSONObject7 = jSONObject4.getJSONObject("type");
                if (jSONObject7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) jSONObject7;
            } else {
                Object obj5 = jSONObject4.get("type");
                if (obj5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) obj5;
            }
            if (Intrinsics.areEqual(string, "noUpdateAvailable")) {
                return new NoUpdateAvailableUpdateDirective(signingInfo);
            }
            if (!Intrinsics.areEqual(string, "rollBackToEmbedded")) {
                throw new Error("Invalid message messageType: " + string);
            }
            UpdatesUtils updatesUtils = UpdatesUtils.INSTANCE;
            if (Intrinsics.areEqual(JSONObject.class, String.class)) {
                Object string7 = jSONObject4.getString("parameters");
                if (string7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject2 = (JSONObject) string7;
            } else if (Intrinsics.areEqual(JSONObject.class, Double.class)) {
                jSONObject2 = (JSONObject) Double.valueOf(jSONObject4.getDouble("parameters"));
            } else if (Intrinsics.areEqual(JSONObject.class, Integer.class)) {
                jSONObject2 = (JSONObject) Integer.valueOf(jSONObject4.getInt("parameters"));
            } else if (Intrinsics.areEqual(JSONObject.class, Long.class)) {
                jSONObject2 = (JSONObject) Long.valueOf(jSONObject4.getLong("parameters"));
            } else if (Intrinsics.areEqual(JSONObject.class, Boolean.class)) {
                jSONObject2 = (JSONObject) Boolean.valueOf(jSONObject4.getBoolean("parameters"));
            } else if (Intrinsics.areEqual(JSONObject.class, JSONArray.class)) {
                Object jSONArray6 = jSONObject4.getJSONArray("parameters");
                if (jSONArray6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject2 = (JSONObject) jSONArray6;
            } else if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
                jSONObject2 = jSONObject4.getJSONObject("parameters");
                if (jSONObject2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            } else {
                Object obj6 = jSONObject4.get("parameters");
                if (obj6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject2 = (JSONObject) obj6;
            }
            if (Intrinsics.areEqual(String.class, String.class)) {
                string2 = jSONObject2.getString("commitTime");
                if (string2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(String.class, Double.class)) {
                string2 = (String) Double.valueOf(jSONObject2.getDouble("commitTime"));
            } else if (Intrinsics.areEqual(String.class, Integer.class)) {
                string2 = (String) Integer.valueOf(jSONObject2.getInt("commitTime"));
            } else if (Intrinsics.areEqual(String.class, Long.class)) {
                string2 = (String) Long.valueOf(jSONObject2.getLong("commitTime"));
            } else if (Intrinsics.areEqual(String.class, Boolean.class)) {
                string2 = (String) Boolean.valueOf(jSONObject2.getBoolean("commitTime"));
            } else if (Intrinsics.areEqual(String.class, JSONArray.class)) {
                Object jSONArray7 = jSONObject2.getJSONArray("commitTime");
                if (jSONArray7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string2 = (String) jSONArray7;
            } else if (Intrinsics.areEqual(String.class, JSONObject.class)) {
                Object jSONObject8 = jSONObject2.getJSONObject("commitTime");
                if (jSONObject8 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string2 = (String) jSONObject8;
            } else {
                Object obj7 = jSONObject2.get("commitTime");
                if (obj7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string2 = (String) obj7;
            }
            return new RollBackToEmbeddedUpdateDirective(updatesUtils.parseDateString(string2), signingInfo);
        }
    }
}
