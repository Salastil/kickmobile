package expo.modules.securestore;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PEmptyArrays;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import io.ktor.sse.ServerSentEventKt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SecureStoreOptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001fB/\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\f\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0016R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006 "}, d2 = {"Lexpo/modules/securestore/SecureStoreOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "Lio/github/expo/pika/PIntrospectionProvider;", "authenticationPrompt", "", "keychainService", AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, "", "requireConfirmation", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getAuthenticationPrompt$annotations", "()V", "getAuthenticationPrompt", "()Ljava/lang/String;", "setAuthenticationPrompt", "(Ljava/lang/String;)V", "getKeychainService$annotations", "getKeychainService", "setKeychainService", "getRequireAuthentication$annotations", "getRequireAuthentication", "()Z", "setRequireAuthentication", "(Z)V", "getRequireConfirmation$annotations", "getRequireConfirmation", "setRequireConfirmation", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "__Pika", "expo-secure-store_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SecureStoreOptions implements Record, Serializable, PIntrospectionProvider {
    public String authenticationPrompt;
    public String keychainService;
    public boolean requireAuthentication;
    public boolean requireConfirmation;

    /* JADX INFO: compiled from: SecureStoreOptions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/securestore/SecureStoreOptions$__Pika;", "", "<init>", "()V", "expo-secure-store_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<SecureStoreOptions> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(SecureStoreOptions.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("authenticationPrompt", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING, 0, __pika, true, true, false), new PProperty("keychainService", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING, 1, __pika, true, true, false), new PProperty(AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 2, __pika, true, true, false), new PProperty("requireConfirmation", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 3, __pika, true, true, false)}, PEmptyArrays.EMPTY_FUNCTIONS, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.securestore.SecureStoreOptions");
                return ((SecureStoreOptions) obj).getAuthenticationPrompt();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.securestore.SecureStoreOptions");
                return ((SecureStoreOptions) obj).getKeychainService();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.securestore.SecureStoreOptions");
                return Boolean.valueOf(((SecureStoreOptions) obj).getRequireAuthentication());
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.securestore.SecureStoreOptions");
            return Boolean.valueOf(((SecureStoreOptions) obj).getRequireConfirmation());
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.securestore.SecureStoreOptions");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                ((SecureStoreOptions) obj).setAuthenticationPrompt((String) obj2);
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.securestore.SecureStoreOptions");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                ((SecureStoreOptions) obj).setKeychainService((String) obj2);
            } else if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.securestore.SecureStoreOptions");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((SecureStoreOptions) obj).setRequireAuthentication(((Boolean) obj2).booleanValue());
            } else {
                if (i != 3) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.securestore.SecureStoreOptions");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((SecureStoreOptions) obj).setRequireConfirmation(((Boolean) obj2).booleanValue());
            }
        }
    }

    public SecureStoreOptions() {
        this(null, null, false, false, 15, null);
    }

    @Field
    public static /* synthetic */ void getAuthenticationPrompt$annotations() {
    }

    @Field
    public static /* synthetic */ void getKeychainService$annotations() {
    }

    @Field
    public static /* synthetic */ void getRequireAuthentication$annotations() {
    }

    @Field
    public static /* synthetic */ void getRequireConfirmation$annotations() {
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public SecureStoreOptions(String authenticationPrompt, String keychainService, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(authenticationPrompt, "authenticationPrompt");
        Intrinsics.checkNotNullParameter(keychainService, "keychainService");
        this.authenticationPrompt = authenticationPrompt;
        this.keychainService = keychainService;
        this.requireAuthentication = z;
        this.requireConfirmation = z2;
    }

    public /* synthetic */ SecureStoreOptions(String str, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ServerSentEventKt.SPACE : str, (i & 2) != 0 ? SecureStoreModule.DEFAULT_KEYSTORE_ALIAS : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? true : z2);
    }

    public final String getAuthenticationPrompt() {
        return this.authenticationPrompt;
    }

    public final void setAuthenticationPrompt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.authenticationPrompt = str;
    }

    public final String getKeychainService() {
        return this.keychainService;
    }

    public final void setKeychainService(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keychainService = str;
    }

    public final boolean getRequireAuthentication() {
        return this.requireAuthentication;
    }

    public final void setRequireAuthentication(boolean z) {
        this.requireAuthentication = z;
    }

    public final boolean getRequireConfirmation() {
        return this.requireConfirmation;
    }

    public final void setRequireConfirmation(boolean z) {
        this.requireConfirmation = z;
    }
}
