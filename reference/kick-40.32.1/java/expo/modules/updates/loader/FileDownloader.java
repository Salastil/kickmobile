package expo.modules.updates.loader;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.core.logging.LoggerUtilsKt;
import expo.modules.manifests.core.Manifest;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import expo.modules.structuredheaders.Dictionary;
import expo.modules.structuredheaders.OuterList;
import expo.modules.structuredheaders.StringItem;
import expo.modules.updates.BSPatch;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.codesigning.CodeSigningConfiguration;
import expo.modules.updates.codesigning.ExpoProjectInformation;
import expo.modules.updates.codesigning.SignatureValidationResult;
import expo.modules.updates.codesigning.ValidationResult;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.launcher.NoDatabaseLauncher;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.ManifestMetadata;
import expo.modules.updates.manifest.ResponseHeaderData;
import expo.modules.updates.manifest.ResponsePartHeaderData;
import expo.modules.updates.manifest.ResponsePartInfo;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.manifest.UpdateFactory;
import expo.modules.updates.selectionpolicy.SelectionPolicies;
import expo.modules.updates.utils.AndroidResourceAssetUtils;
import io.ktor.http.ContentType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartReader;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FileDownloader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 x2\u00020\u0001:\u0005tuvwxB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB9\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u0010J\u0092\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\"\b\u0002\u0010#\u001a\u001c\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%\u0018\u00010$j\u0004\u0018\u0001`&H\u0081@¢\u0006\u0004\b'\u0010(J:\u0010)\u001a\u00020*2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/H\u0002J\u001a\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020-2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002Jh\u00102\u001a\u00020*2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00103\u001a\u0002042\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\"\b\u0002\u0010#\u001a\u001c\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%\u0018\u00010$j\u0004\u0018\u0001`&H\u0002JY\u00105\u001a\u0002062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00103\u001a\u0002042\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\"\b\u0002\u0010#\u001a\u001c\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%\u0018\u00010$j\u0004\u0018\u0001`&H\u0001¢\u0006\u0002\b7JL\u00108\u001a\u0002062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\"\b\u0002\u0010#\u001a\u001c\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%\u0018\u00010$j\u0004\u0018\u0001`&H\u0002J:\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00032 \u0010#\u001a\u001c\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%\u0018\u00010$j\u0004\u0018\u0001`&H\u0002JA\u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u0002042\u0006\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010G\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\bHJ\u0015\u0010I\u001a\u00020J2\u0006\u0010.\u001a\u00020/H\u0000¢\u0006\u0002\bKJ \u0010L\u001a\u00020J2\u0006\u0010.\u001a\u00020/2\u0006\u00103\u001a\u0002042\u0006\u0010M\u001a\u00020NH\u0002J\u001a\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010\u0005H\u0002J$\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020R2\b\u0010W\u001a\u0004\u0018\u00010\u00162\b\u0010S\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010X\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u0005H\u0002J\u0018\u0010[\u001a\u00020J2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0086@¢\u0006\u0002\u0010\\Jv\u0010]\u001a\u00020^2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010_\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0016\b\u0002\u0010`\u001a\u0010\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020%\u0018\u00010a2\"\b\u0002\u0010#\u001a\u001c\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%\u0018\u00010$j\u0004\u0018\u0001`&H\u0086@¢\u0006\u0002\u0010cJ\"\u0010d\u001a\u00020/2\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0082@¢\u0006\u0002\u0010eJ\b\u0010f\u001a\u00020gH\u0002J\b\u0010h\u001a\u00020\u0003H\u0002J*\u0010i\u001a\u00020\u00182\u0006\u0010j\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007JL\u0010k\u001a\u00020U2\u0006\u0010l\u001a\u00020\u00052\u0006\u0010m\u001a\u00020\u00162\u0006\u0010M\u001a\u00020N2\u0006\u0010n\u001a\u00020o2\b\u0010W\u001a\u0004\u0018\u00010\u00162\b\u0010S\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010p\u001a\u00020q*\u00020q2\b\u0010r\u001a\u0004\u0018\u00010\u0016H\u0002J\"\u0010s\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R<\u0010;\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020=0<8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006y"}, d2 = {"Lexpo/modules/updates/loader/FileDownloader;", "", "filesDirectory", "Ljava/io/File;", "easClientID", "", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "<init>", "(Ljava/io/File;Ljava/lang/String;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/db/UpdatesDatabase;)V", "client", "Lokhttp3/OkHttpClient;", "(Ljava/io/File;Ljava/lang/String;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/db/UpdatesDatabase;Lokhttp3/OkHttpClient;)V", "downloadAssetAndVerifyHashAndWriteToPath", "Lexpo/modules/updates/loader/FileDownloader$FileDownloadResult;", UriUtil.LOCAL_ASSET_SCHEME, "Lexpo/modules/updates/db/entity/AssetEntity;", "extraHeaders", "Lorg/json/JSONObject;", "request", "Lokhttp3/Request;", "expectedBase64URLEncodedSHA256Hash", FirebaseAnalytics.Param.DESTINATION, "updatesDirectory", "progressListener", "Lexpo/modules/updates/loader/FileDownloadProgressListener;", "allowPatch", "", "launchedUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "requestedUpdate", "embeddedAssetExtractor", "Lkotlin/Function2;", "", "Lexpo/modules/updates/loader/EmbeddedAssetExtractor;", "downloadAssetAndVerifyHashAndWriteToPath$expo_updates_release", "(Lexpo/modules/updates/db/entity/AssetEntity;Lorg/json/JSONObject;Lokhttp3/Request;Ljava/lang/String;Ljava/io/File;Ljava/io/File;Lexpo/modules/updates/loader/FileDownloadProgressListener;ZLexpo/modules/updates/db/entity/UpdateEntity;Lexpo/modules/updates/db/entity/UpdateEntity;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fallbackBundleDownload", "", "(Lexpo/modules/updates/db/entity/AssetEntity;Lorg/json/JSONObject;Lexpo/modules/updates/loader/FileDownloadProgressListener;Ljava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parsePatchResponseMetadata", "Lexpo/modules/updates/loader/FileDownloader$PatchResponseMetadata;", "response", "Lokhttp3/Response;", "validatePatchResponseMetadata", "metadata", "applyPatchAndVerify", "responseBody", "Lokhttp3/ResponseBody;", "prepareAssetForDiff", "Lexpo/modules/updates/loader/FileDownloader$LaunchAssetContext;", "prepareAssetForDiff$expo_updates_release", "preparePatchBaseAsset", "extractEmbeddedPatchBaseAsset", "launchAssetEntity", "applyPatch", "Lkotlin/Function3;", "", "getApplyPatch$expo_updates_release$annotations", "()V", "getApplyPatch$expo_updates_release", "()Lkotlin/jvm/functions/Function3;", "setApplyPatch$expo_updates_release", "(Lkotlin/jvm/functions/Function3;)V", "applyHermesDiff", "baseFile", "diffBody", "requestedUpdateId", "applyHermesDiff$expo_updates_release", "parseRemoteUpdateResponse", "Lexpo/modules/updates/loader/UpdateResponse;", "parseRemoteUpdateResponse$expo_updates_release", "parseMultipartRemoteUpdateResponse", "responseHeaderData", "Lexpo/modules/updates/manifest/ResponseHeaderData;", "parseDirective", "Lexpo/modules/updates/loader/UpdateResponsePart$DirectiveUpdateResponsePart;", "directiveResponsePartInfo", "Lexpo/modules/updates/manifest/ResponsePartInfo;", "certificateChainFromManifestResponse", "parseManifest", "Lexpo/modules/updates/loader/UpdateResponsePart$ManifestUpdateResponsePart;", "manifestResponseInfo", "extensions", "describeUnsuccessfulResponse", "truncateForErrorMessage", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "downloadRemoteUpdate", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadAsset", "Lexpo/modules/updates/loader/FileDownloader$AssetDownloadResult;", "destinationDirectory", "assetLoadProgressListener", "Lkotlin/Function1;", "", "(Lexpo/modules/updates/db/entity/AssetEntity;Ljava/io/File;Lorg/json/JSONObject;Lexpo/modules/updates/db/entity/UpdateEntity;Lexpo/modules/updates/db/entity/UpdateEntity;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadData", "(Lokhttp3/Request;Lexpo/modules/updates/loader/FileDownloadProgressListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCache", "Lokhttp3/Cache;", "getCacheDirectory", "createRequestForAsset", "assetEntity", "checkCodeSigningAndCreateManifest", "bodyString", "preManifest", "responsePartHeaderData", "Lexpo/modules/updates/manifest/ResponsePartHeaderData;", "addHeadersFromJSONObject", "Lokhttp3/Request$Builder;", "headers", "createRequestForRemoteUpdate", "FileDownloadResult", "AssetDownloadResult", "PatchResponseMetadata", "LaunchAssetContext", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FileDownloader {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_ERROR_BODY_LENGTH = 512;
    private Function3<? super String, ? super String, ? super String, Integer> applyPatch;
    private OkHttpClient client;
    private final UpdatesConfiguration configuration;
    private final UpdatesDatabase database;
    private final String easClientID;
    private final File filesDirectory;
    private final UpdatesLogger logger;

    /* JADX INFO: renamed from: expo.modules.updates.loader.FileDownloader$downloadAsset$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileDownloader.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.loader.FileDownloader", f = "FileDownloader.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {786}, m = "downloadAsset", n = {UriUtil.LOCAL_ASSET_SCHEME, "destinationDirectory", "extraHeaders", "launchedUpdate", "requestedUpdate", "assetLoadProgressListener", "embeddedAssetExtractor", "filename", "path", "canApplyPatch"}, nl = {805}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileDownloader.this.downloadAsset(null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.FileDownloader$downloadRemoteUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileDownloader.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.loader.FileDownloader", f = "FileDownloader.kt", i = {0}, l = {731}, m = "downloadRemoteUpdate", n = {"extraHeaders"}, nl = {735}, s = {"L$0"}, v = 2)
    static final class C09311 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09311(Continuation<? super C09311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileDownloader.this.downloadRemoteUpdate(null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.FileDownloader$fallbackBundleDownload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileDownloader.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.loader.FileDownloader", f = "FileDownloader.kt", i = {0, 0, 0, 0, 0, 0}, l = {228}, m = "fallbackBundleDownload", n = {UriUtil.LOCAL_ASSET_SCHEME, "extraHeaders", "progressListener", FirebaseAnalytics.Param.DESTINATION, "expectedBase64URLEncodedSHA256Hash", "fallbackRequest"}, nl = {229}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C09321 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C09321(Continuation<? super C09321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileDownloader.this.fallbackBundleDownload(null, null, null, null, null, this);
        }
    }

    public static /* synthetic */ void getApplyPatch$expo_updates_release$annotations() {
    }

    public FileDownloader(File filesDirectory, String easClientID, UpdatesConfiguration configuration, UpdatesLogger logger, UpdatesDatabase database) {
        Intrinsics.checkNotNullParameter(filesDirectory, "filesDirectory");
        Intrinsics.checkNotNullParameter(easClientID, "easClientID");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(database, "database");
        this.filesDirectory = filesDirectory;
        this.easClientID = easClientID;
        this.configuration = configuration;
        this.logger = logger;
        this.database = database;
        this.client = OkHttpClientProvider.getOkHttpClient().newBuilder().cache(getCache()).connectTimeout(Math.max(configuration.getLaunchWaitMs(), 10000L), TimeUnit.MILLISECONDS).readTimeout(Math.max(configuration.getLaunchWaitMs(), 10000L), TimeUnit.MILLISECONDS).addInterceptor(CompressionInterceptor.INSTANCE).build();
        this.applyPatch = new Function3() { // from class: expo.modules.updates.loader.FileDownloader$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Integer.valueOf(FileDownloader.applyPatch$lambda$0((String) obj, (String) obj2, (String) obj3));
            }
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileDownloader(File filesDirectory, String easClientID, UpdatesConfiguration configuration, UpdatesLogger logger, UpdatesDatabase database, OkHttpClient client) {
        this(filesDirectory, easClientID, configuration, logger, database);
        Intrinsics.checkNotNullParameter(filesDirectory, "filesDirectory");
        Intrinsics.checkNotNullParameter(easClientID, "easClientID");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    /* JADX INFO: compiled from: FileDownloader.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lexpo/modules/updates/loader/FileDownloader$FileDownloadResult;", "", "file", "Ljava/io/File;", "hash", "", "<init>", "(Ljava/io/File;[B)V", "getFile", "()Ljava/io/File;", "getHash", "()[B", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class FileDownloadResult {
        private final File file;
        private final byte[] hash;

        public static /* synthetic */ FileDownloadResult copy$default(FileDownloadResult fileDownloadResult, File file, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                file = fileDownloadResult.file;
            }
            if ((i & 2) != 0) {
                bArr = fileDownloadResult.hash;
            }
            return fileDownloadResult.copy(file, bArr);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final File getFile() {
            return this.file;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final byte[] getHash() {
            return this.hash;
        }

        public final FileDownloadResult copy(File file, byte[] hash) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(hash, "hash");
            return new FileDownloadResult(file, hash);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileDownloadResult)) {
                return false;
            }
            FileDownloadResult fileDownloadResult = (FileDownloadResult) other;
            return Intrinsics.areEqual(this.file, fileDownloadResult.file) && Intrinsics.areEqual(this.hash, fileDownloadResult.hash);
        }

        public int hashCode() {
            return (this.file.hashCode() * 31) + Arrays.hashCode(this.hash);
        }

        public String toString() {
            return "FileDownloadResult(file=" + this.file + ", hash=" + Arrays.toString(this.hash) + ")";
        }

        public FileDownloadResult(File file, byte[] hash) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(hash, "hash");
            this.file = file;
            this.hash = hash;
        }

        public final File getFile() {
            return this.file;
        }

        public final byte[] getHash() {
            return this.hash;
        }
    }

    /* JADX INFO: compiled from: FileDownloader.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lexpo/modules/updates/loader/FileDownloader$AssetDownloadResult;", "", "assetEntity", "Lexpo/modules/updates/db/entity/AssetEntity;", "isNew", "", "<init>", "(Lexpo/modules/updates/db/entity/AssetEntity;Z)V", "getAssetEntity", "()Lexpo/modules/updates/db/entity/AssetEntity;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class AssetDownloadResult {
        private final AssetEntity assetEntity;
        private final boolean isNew;

        public static /* synthetic */ AssetDownloadResult copy$default(AssetDownloadResult assetDownloadResult, AssetEntity assetEntity, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                assetEntity = assetDownloadResult.assetEntity;
            }
            if ((i & 2) != 0) {
                z = assetDownloadResult.isNew;
            }
            return assetDownloadResult.copy(assetEntity, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AssetEntity getAssetEntity() {
            return this.assetEntity;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsNew() {
            return this.isNew;
        }

        public final AssetDownloadResult copy(AssetEntity assetEntity, boolean isNew) {
            Intrinsics.checkNotNullParameter(assetEntity, "assetEntity");
            return new AssetDownloadResult(assetEntity, isNew);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AssetDownloadResult)) {
                return false;
            }
            AssetDownloadResult assetDownloadResult = (AssetDownloadResult) other;
            return Intrinsics.areEqual(this.assetEntity, assetDownloadResult.assetEntity) && this.isNew == assetDownloadResult.isNew;
        }

        public int hashCode() {
            return (this.assetEntity.hashCode() * 31) + Boolean.hashCode(this.isNew);
        }

        public String toString() {
            return "AssetDownloadResult(assetEntity=" + this.assetEntity + ", isNew=" + this.isNew + ")";
        }

        public AssetDownloadResult(AssetEntity assetEntity, boolean z) {
            Intrinsics.checkNotNullParameter(assetEntity, "assetEntity");
            this.assetEntity = assetEntity;
            this.isNew = z;
        }

        public final AssetEntity getAssetEntity() {
            return this.assetEntity;
        }

        public final boolean isNew() {
            return this.isNew;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object downloadAssetAndVerifyHashAndWriteToPath$expo_updates_release$default(FileDownloader fileDownloader, AssetEntity assetEntity, JSONObject jSONObject, Request request, String str, File file, File file2, FileDownloadProgressListener fileDownloadProgressListener, boolean z, UpdateEntity updateEntity, UpdateEntity updateEntity2, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 64) != 0) {
            fileDownloadProgressListener = null;
        }
        if ((i & 256) != 0) {
            updateEntity = null;
        }
        if ((i & 512) != 0) {
            updateEntity2 = null;
        }
        if ((i & 1024) != 0) {
            function2 = null;
        }
        return fileDownloader.downloadAssetAndVerifyHashAndWriteToPath$expo_updates_release(assetEntity, jSONObject, request, str, file, file2, fileDownloadProgressListener, z, updateEntity, updateEntity2, function2, continuation);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 13961. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final java.lang.Object downloadAssetAndVerifyHashAndWriteToPath$expo_updates_release(expo.modules.updates.db.entity.AssetEntity r27, org.json.JSONObject r28, okhttp3.Request r29, java.lang.String r30, java.io.File r31, java.io.File r32, expo.modules.updates.loader.FileDownloadProgressListener r33, boolean r34, expo.modules.updates.db.entity.UpdateEntity r35, expo.modules.updates.db.entity.UpdateEntity r36, kotlin.jvm.functions.Function2<? super expo.modules.updates.db.entity.AssetEntity, ? super java.io.File, kotlin.Unit> r37, kotlin.coroutines.Continuation<? super expo.modules.updates.loader.FileDownloader.FileDownloadResult> r38) {
        /*
            Method dump skipped, instruction units count: 1396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.loader.FileDownloader.downloadAssetAndVerifyHashAndWriteToPath$expo_updates_release(expo.modules.updates.db.entity.AssetEntity, org.json.JSONObject, okhttp3.Request, java.lang.String, java.io.File, java.io.File, expo.modules.updates.loader.FileDownloadProgressListener, boolean, expo.modules.updates.db.entity.UpdateEntity, expo.modules.updates.db.entity.UpdateEntity, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object fallbackBundleDownload(AssetEntity assetEntity, JSONObject jSONObject, FileDownloadProgressListener fileDownloadProgressListener, File file, String str, Continuation<? super byte[]> continuation) {
        C09321 c09321;
        Request request;
        if (continuation instanceof C09321) {
            c09321 = (C09321) continuation;
            if ((c09321.label & Integer.MIN_VALUE) != 0) {
                c09321.label -= Integer.MIN_VALUE;
            } else {
                c09321 = new C09321(continuation);
            }
        } else {
            c09321 = new C09321(continuation);
        }
        Object obj = c09321.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09321.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Request requestCreateRequestForAsset = createRequestForAsset(assetEntity, jSONObject, this.configuration, false);
            c09321.L$0 = SpillingKt.nullOutSpilledVariable(assetEntity);
            c09321.L$1 = SpillingKt.nullOutSpilledVariable(jSONObject);
            c09321.L$2 = SpillingKt.nullOutSpilledVariable(fileDownloadProgressListener);
            c09321.L$3 = file;
            c09321.L$4 = str;
            c09321.L$5 = requestCreateRequestForAsset;
            c09321.label = 1;
            Object objDownloadData = downloadData(requestCreateRequestForAsset, fileDownloadProgressListener, c09321);
            if (objDownloadData == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objDownloadData;
            request = requestCreateRequestForAsset;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            request = (Request) c09321.L$5;
            str = (String) c09321.L$4;
            file = (File) c09321.L$3;
            ResultKt.throwOnFailure(obj);
        }
        Response response = (Response) obj;
        try {
            Response response2 = response;
            ResponseBody responseBodyBody = response2.body();
            if (responseBodyBody == null) {
                throw new IOException("Fallback asset download response from " + request.url() + " had no body");
            }
            ResponseBody responseBody = responseBodyBody;
            try {
                ResponseBody responseBody2 = responseBody;
                if (!response2.isSuccessful()) {
                    throw new IOException(responseBody2.string());
                }
                InputStream inputStreamByteStream = responseBody2.byteStream();
                try {
                    byte[] bArrVerifySHA256AndWriteToFile = UpdatesUtils.INSTANCE.verifySHA256AndWriteToFile(inputStreamByteStream, file, str);
                    CloseableKt.closeFinally(inputStreamByteStream, null);
                    CloseableKt.closeFinally(responseBody, null);
                    CloseableKt.closeFinally(response, null);
                    return bArrVerifySHA256AndWriteToFile;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(inputStreamByteStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(responseBody, th3);
                    throw th4;
                }
            }
            try {
                throw th;
            } catch (Throwable th5) {
                CloseableKt.closeFinally(response, th);
                throw th5;
            }
        } catch (Throwable th6) {
            throw th6;
        }
    }

    /* JADX INFO: compiled from: FileDownloader.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lexpo/modules/updates/loader/FileDownloader$PatchResponseMetadata;", "", "hasImBsdiff", "", "statusCode", "", "expoBaseUpdateId", "", "<init>", "(ZILjava/lang/String;)V", "getHasImBsdiff", "()Z", "getStatusCode", "()I", "getExpoBaseUpdateId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final /* data */ class PatchResponseMetadata {
        private final String expoBaseUpdateId;
        private final boolean hasImBsdiff;
        private final int statusCode;

        public static /* synthetic */ PatchResponseMetadata copy$default(PatchResponseMetadata patchResponseMetadata, boolean z, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = patchResponseMetadata.hasImBsdiff;
            }
            if ((i2 & 2) != 0) {
                i = patchResponseMetadata.statusCode;
            }
            if ((i2 & 4) != 0) {
                str = patchResponseMetadata.expoBaseUpdateId;
            }
            return patchResponseMetadata.copy(z, i, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getHasImBsdiff() {
            return this.hasImBsdiff;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getStatusCode() {
            return this.statusCode;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getExpoBaseUpdateId() {
            return this.expoBaseUpdateId;
        }

        public final PatchResponseMetadata copy(boolean hasImBsdiff, int statusCode, String expoBaseUpdateId) {
            return new PatchResponseMetadata(hasImBsdiff, statusCode, expoBaseUpdateId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PatchResponseMetadata)) {
                return false;
            }
            PatchResponseMetadata patchResponseMetadata = (PatchResponseMetadata) other;
            return this.hasImBsdiff == patchResponseMetadata.hasImBsdiff && this.statusCode == patchResponseMetadata.statusCode && Intrinsics.areEqual(this.expoBaseUpdateId, patchResponseMetadata.expoBaseUpdateId);
        }

        public int hashCode() {
            int iHashCode = ((Boolean.hashCode(this.hasImBsdiff) * 31) + Integer.hashCode(this.statusCode)) * 31;
            String str = this.expoBaseUpdateId;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "PatchResponseMetadata(hasImBsdiff=" + this.hasImBsdiff + ", statusCode=" + this.statusCode + ", expoBaseUpdateId=" + this.expoBaseUpdateId + ")";
        }

        public PatchResponseMetadata(boolean z, int i, String str) {
            this.hasImBsdiff = z;
            this.statusCode = i;
            this.expoBaseUpdateId = str;
        }

        public final boolean getHasImBsdiff() {
            return this.hasImBsdiff;
        }

        public final int getStatusCode() {
            return this.statusCode;
        }

        public final String getExpoBaseUpdateId() {
            return this.expoBaseUpdateId;
        }
    }

    private final PatchResponseMetadata parsePatchResponseMetadata(Response response) {
        List listSplit$default;
        String strHeader$default = Response.header$default(response, "im", null, 2, null);
        boolean z = false;
        if (strHeader$default != null && (listSplit$default = StringsKt.split$default((CharSequence) strHeader$default, new char[]{AbstractJsonLexerKt.COMMA}, false, 0, 6, (Object) null)) != null) {
            List list = listSplit$default;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
            }
            ArrayList arrayList2 = arrayList;
            if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    if (StringsKt.equals((String) it2.next(), "bsdiff", true)) {
                        z = true;
                        break;
                    }
                }
            }
        }
        int iCode = response.code();
        if (z || iCode == 226) {
            return new PatchResponseMetadata(z, iCode, Response.header$default(response, "expo-base-update-id", null, 2, null));
        }
        return null;
    }

    private final boolean validatePatchResponseMetadata(PatchResponseMetadata metadata, UpdateEntity launchedUpdate) {
        String lowerCase;
        UUID id;
        String string;
        String lowerCase2 = null;
        if (launchedUpdate == null || (id = launchedUpdate.getId()) == null || (string = id.toString()) == null) {
            lowerCase = null;
        } else {
            lowerCase = string.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        }
        String expoBaseUpdateId = metadata.getExpoBaseUpdateId();
        if (expoBaseUpdateId != null) {
            lowerCase2 = expoBaseUpdateId.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        }
        if ((metadata.getHasImBsdiff() || metadata.getStatusCode() == 226) && lowerCase2 != null) {
            return lowerCase == null || Intrinsics.areEqual(lowerCase2, lowerCase);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] applyPatchAndVerify(AssetEntity asset, ResponseBody responseBody, File destination, File updatesDirectory, UpdateEntity launchedUpdate, UpdateEntity requestedUpdate, String expectedBase64URLEncodedSHA256Hash, Function2<? super AssetEntity, ? super File, Unit> embeddedAssetExtractor) throws Exception {
        UUID id;
        LaunchAssetContext launchAssetContextPrepareAssetForDiff$expo_updates_release = prepareAssetForDiff$expo_updates_release(asset, responseBody, destination, updatesDirectory, launchedUpdate, embeddedAssetExtractor);
        try {
            return applyHermesDiff$expo_updates_release(launchAssetContextPrepareAssetForDiff$expo_updates_release.getBaseFile(), responseBody, destination, expectedBase64URLEncodedSHA256Hash, asset, (requestedUpdate == null || (id = requestedUpdate.getId()) == null) ? null : id.toString());
        } finally {
            if (launchAssetContextPrepareAssetForDiff$expo_updates_release.isTemporary()) {
                launchAssetContextPrepareAssetForDiff$expo_updates_release.getBaseFile().delete();
            }
        }
    }

    /* JADX INFO: compiled from: FileDownloader.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lexpo/modules/updates/loader/FileDownloader$LaunchAssetContext;", "", "baseFile", "Ljava/io/File;", "isTemporary", "", "<init>", "(Ljava/io/File;Z)V", "getBaseFile", "()Ljava/io/File;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class LaunchAssetContext {
        private final File baseFile;
        private final boolean isTemporary;

        public static /* synthetic */ LaunchAssetContext copy$default(LaunchAssetContext launchAssetContext, File file, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                file = launchAssetContext.baseFile;
            }
            if ((i & 2) != 0) {
                z = launchAssetContext.isTemporary;
            }
            return launchAssetContext.copy(file, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final File getBaseFile() {
            return this.baseFile;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsTemporary() {
            return this.isTemporary;
        }

        public final LaunchAssetContext copy(File baseFile, boolean isTemporary) {
            Intrinsics.checkNotNullParameter(baseFile, "baseFile");
            return new LaunchAssetContext(baseFile, isTemporary);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LaunchAssetContext)) {
                return false;
            }
            LaunchAssetContext launchAssetContext = (LaunchAssetContext) other;
            return Intrinsics.areEqual(this.baseFile, launchAssetContext.baseFile) && this.isTemporary == launchAssetContext.isTemporary;
        }

        public int hashCode() {
            return (this.baseFile.hashCode() * 31) + Boolean.hashCode(this.isTemporary);
        }

        public String toString() {
            return "LaunchAssetContext(baseFile=" + this.baseFile + ", isTemporary=" + this.isTemporary + ")";
        }

        public LaunchAssetContext(File baseFile, boolean z) {
            Intrinsics.checkNotNullParameter(baseFile, "baseFile");
            this.baseFile = baseFile;
            this.isTemporary = z;
        }

        public /* synthetic */ LaunchAssetContext(File file, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(file, (i & 2) != 0 ? false : z);
        }

        public final File getBaseFile() {
            return this.baseFile;
        }

        public final boolean isTemporary() {
            return this.isTemporary;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LaunchAssetContext prepareAssetForDiff$expo_updates_release$default(FileDownloader fileDownloader, AssetEntity assetEntity, ResponseBody responseBody, File file, File file2, UpdateEntity updateEntity, Function2 function2, int i, Object obj) {
        if ((i & 32) != 0) {
            function2 = null;
        }
        return fileDownloader.prepareAssetForDiff$expo_updates_release(assetEntity, responseBody, file, file2, updateEntity, function2);
    }

    public final LaunchAssetContext prepareAssetForDiff$expo_updates_release(AssetEntity asset, ResponseBody responseBody, File destination, File updatesDirectory, UpdateEntity launchedUpdate, Function2<? super AssetEntity, ? super File, Unit> embeddedAssetExtractor) throws Exception {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(launchedUpdate, "launchedUpdate");
        try {
            return preparePatchBaseAsset(asset, destination, updatesDirectory, launchedUpdate, embeddedAssetExtractor);
        } catch (Exception e) {
            responseBody.close();
            if (e instanceof IOException) {
                throw e;
            }
            throw new IOException("Failed to prepare asset for diff", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ LaunchAssetContext preparePatchBaseAsset$default(FileDownloader fileDownloader, AssetEntity assetEntity, File file, File file2, UpdateEntity updateEntity, Function2 function2, int i, Object obj) {
        if ((i & 16) != 0) {
            function2 = null;
        }
        return fileDownloader.preparePatchBaseAsset(assetEntity, file, file2, updateEntity, function2);
    }

    private final LaunchAssetContext preparePatchBaseAsset(AssetEntity asset, File destination, File updatesDirectory, UpdateEntity launchedUpdate, Function2<? super AssetEntity, ? super File, Unit> embeddedAssetExtractor) throws IOException {
        File file;
        String base64Url;
        if (!asset.getIsLaunchAsset()) {
            throw new IOException("Received patch for non-launch asset " + asset.getKey());
        }
        UUID id = launchedUpdate.getId();
        AssetEntity assetEntityLoadLaunchAssetForUpdate = this.database.updateDao().loadLaunchAssetForUpdate(id);
        if (assetEntityLoadLaunchAssetForUpdate == null) {
            throw new IOException("Launch asset not found for current update " + id);
        }
        String relativePath = assetEntityLoadLaunchAssetForUpdate.getRelativePath();
        if (relativePath == null) {
            throw new IOException("Launch asset for update " + id + " is missing a relative path");
        }
        boolean zIsAndroidResourceAsset = AndroidResourceAssetUtils.INSTANCE.isAndroidResourceAsset(relativePath);
        if (zIsAndroidResourceAsset) {
            file = extractEmbeddedPatchBaseAsset(assetEntityLoadLaunchAssetForUpdate, destination, embeddedAssetExtractor);
        } else {
            file = new File(updatesDirectory, relativePath);
        }
        if (!file.exists()) {
            throw new IOException("Base asset " + file + " is missing; cannot apply patch");
        }
        String expectedHash = assetEntityLoadLaunchAssetForUpdate.getExpectedHash();
        if (expectedHash != null) {
            try {
                base64Url = UpdatesUtils.INSTANCE.toBase64Url(UpdatesUtils.INSTANCE.sha256(file));
            } catch (Exception unused) {
                base64Url = null;
            }
            if (base64Url != null && !Intrinsics.areEqual(expectedHash, base64Url)) {
                this.logger.warn("Asset hash mismatch for update " + id + "; expected=" + expectedHash + " actual=" + base64Url, UpdatesErrorCode.AssetsFailedToLoad, id.toString(), asset.getKey());
                if (zIsAndroidResourceAsset) {
                    file.delete();
                }
                throw new IOException("Asset hash mismatch for update " + id + "; expected=" + expectedHash + " actual=" + base64Url);
            }
        }
        return new LaunchAssetContext(file, zIsAndroidResourceAsset);
    }

    private final File extractEmbeddedPatchBaseAsset(AssetEntity launchAssetEntity, File destination, Function2<? super AssetEntity, ? super File, Unit> embeddedAssetExtractor) throws IOException {
        if (embeddedAssetExtractor == null) {
            throw new IOException("The launch asset lives in the app binary and cannot be extracted without an extractor");
        }
        File file = new File(destination.getAbsolutePath() + ".base");
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            embeddedAssetExtractor.invoke(launchAssetEntity, file);
            return file;
        } catch (Exception e) {
            file.delete();
            IOException iOException = e instanceof IOException ? (IOException) e : null;
            if (iOException == null) {
                iOException = new IOException("Failed to extract the embedded launch asset", e);
            }
            throw iOException;
        }
    }

    public final Function3<String, String, String, Integer> getApplyPatch$expo_updates_release() {
        return this.applyPatch;
    }

    public final void setApplyPatch$expo_updates_release(Function3<? super String, ? super String, ? super String, Integer> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.applyPatch = function3;
    }

    static final int applyPatch$lambda$0(String baseFilePath, String newFilePath, String patchFilePath) {
        Intrinsics.checkNotNullParameter(baseFilePath, "baseFilePath");
        Intrinsics.checkNotNullParameter(newFilePath, "newFilePath");
        Intrinsics.checkNotNullParameter(patchFilePath, "patchFilePath");
        return BSPatch.applyPatch(baseFilePath, newFilePath, patchFilePath);
    }

    /* JADX WARN: Code duplicated, block: B:69:0x016d  */
    /* JADX WARN: Code duplicated, block: B:72:0x0176  */
    public final byte[] applyHermesDiff$expo_updates_release(File baseFile, ResponseBody diffBody, File destination, String expectedBase64URLEncodedSHA256Hash, AssetEntity asset, String requestedUpdateId) throws Throwable {
        Throwable th;
        Intrinsics.checkNotNullParameter(baseFile, "baseFile");
        Intrinsics.checkNotNullParameter(diffBody, "diffBody");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(asset, "asset");
        File file = new File(destination.getAbsolutePath() + ".patch");
        File file2 = new File(destination.getAbsolutePath() + ".patched");
        try {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                File parentFile2 = file2.getParentFile();
                if (parentFile2 != null) {
                    parentFile2.mkdirs();
                }
                try {
                    InputStream inputStreamByteStream = diffBody.byteStream();
                    try {
                        try {
                            InputStream inputStream = inputStreamByteStream;
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                try {
                                    ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
                                    CloseableKt.closeFinally(fileOutputStream, null);
                                    CloseableKt.closeFinally(inputStreamByteStream, null);
                                    Function3<? super String, ? super String, ? super String, Integer> function3 = this.applyPatch;
                                    String absolutePath = baseFile.getAbsolutePath();
                                    Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                                    String absolutePath2 = file2.getAbsolutePath();
                                    Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
                                    String absolutePath3 = file.getAbsolutePath();
                                    Intrinsics.checkNotNullExpressionValue(absolutePath3, "getAbsolutePath(...)");
                                    int iIntValue = function3.invoke(absolutePath, absolutePath2, absolutePath3).intValue();
                                    if (iIntValue != 0) {
                                        throw new IOException("BSPatch exited with code " + iIntValue + " while applying patch");
                                    }
                                    FileInputStream fileInputStream = new FileInputStream(file2);
                                    try {
                                        byte[] bArrVerifySHA256AndWriteToFile = UpdatesUtils.INSTANCE.verifySHA256AndWriteToFile(fileInputStream, destination, expectedBase64URLEncodedSHA256Hash);
                                        this.logger.info("Applied diff for asset " + asset.getKey(), UpdatesErrorCode.None, requestedUpdateId, asset.getKey());
                                        CloseableKt.closeFinally(fileInputStream, null);
                                        if (file.exists()) {
                                            file.delete();
                                        }
                                        if (file2.exists()) {
                                            file2.delete();
                                        }
                                        return bArrVerifySHA256AndWriteToFile;
                                    } catch (Throwable th2) {
                                        try {
                                            throw th2;
                                        } catch (Throwable th3) {
                                            CloseableKt.closeFinally(fileInputStream, th2);
                                            throw th3;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    Throwable th5 = th;
                                    try {
                                        throw th5;
                                    } catch (Throwable th6) {
                                        CloseableKt.closeFinally(fileOutputStream, th5);
                                        throw th6;
                                    }
                                }
                            } catch (Throwable th7) {
                                th = th7;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            th = th;
                            try {
                                throw th;
                            } catch (Throwable th9) {
                                CloseableKt.closeFinally(inputStreamByteStream, th);
                                throw th9;
                            }
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        th = th;
                        throw th;
                    }
                } catch (Exception e) {
                    e = e;
                    IOException iOException = e instanceof IOException ? (IOException) e : null;
                    if (iOException == null) {
                        iOException = new IOException("Failed to apply patch", e);
                    }
                    this.logger.error("Failed to apply patch for asset " + asset.getKey(), iOException, UpdatesErrorCode.AssetsFailedToLoad);
                    throw iOException;
                }
            } catch (Throwable th11) {
                th = th11;
                if (file.exists()) {
                    file.delete();
                }
                if (file2.exists()) {
                    file2.delete();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
        } catch (Throwable th12) {
            th = th12;
            if (file.exists()) {
                file.delete();
            }
            if (file2.exists()) {
                file2.delete();
            }
            throw th;
        }
    }

    public final UpdateResponse parseRemoteUpdateResponse$expo_updates_release(Response response) throws IOException {
        Intrinsics.checkNotNullParameter(response, "response");
        Headers headers = response.headers();
        ResponseHeaderData responseHeaderData = new ResponseHeaderData(headers.get("expo-protocol-version"), headers.get("expo-server-defined-headers"), headers.get("expo-manifest-filters"));
        ResponseBody responseBodyBody = response.body();
        if (response.code() == 204 || responseBodyBody == null) {
            if (responseHeaderData.getProtocolVersion() != null && responseHeaderData.getProtocolVersion().intValue() > 0) {
                return new UpdateResponse(responseHeaderData, null, null);
            }
            IOException iOException = new IOException("Empty body");
            this.logger.error("Invalid update response", iOException, UpdatesErrorCode.UpdateFailedToLoad);
            throw new IOException("Invalid update response", iOException);
        }
        MediaType mediaType = responseBodyBody.get$contentType();
        if (Intrinsics.areEqual(mediaType != null ? mediaType.type() : null, ContentType.MultiPart.TYPE)) {
            return parseMultipartRemoteUpdateResponse(response, responseBodyBody, responseHeaderData);
        }
        ResponsePartHeaderData responsePartHeaderData = new ResponsePartHeaderData(headers.get("expo-signature"));
        ResponseBody responseBodyBody2 = response.body();
        Intrinsics.checkNotNull(responseBodyBody2);
        return new UpdateResponse(responseHeaderData, parseManifest(new ResponsePartInfo(responseHeaderData, responsePartHeaderData, responseBodyBody2.string()), null, null), null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final UpdateResponse parseMultipartRemoteUpdateResponse(Response response, ResponseBody responseBody, ResponseHeaderData responseHeaderData) throws IOException {
        Pair pair;
        String utf8;
        String utf9;
        Pair pair2;
        String contentDispositionNameParameter;
        JSONObject jSONObject;
        if (response.peekBody(1L).bytes().length != 0) {
            try {
                MultipartReader multipartReader = new MultipartReader(responseBody);
                try {
                    MultipartReader multipartReader2 = multipartReader;
                    pair = null;
                    utf8 = null;
                    utf9 = null;
                    pair2 = null;
                    while (true) {
                        MultipartReader.Part partNextPart = multipartReader2.nextPart();
                        if (partNextPart == null) {
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(multipartReader, null);
                        } else {
                            MultipartReader.Part part = partNextPart;
                            try {
                                MultipartReader.Part part2 = part;
                                Headers headers = part2.getHeaders();
                                BufferedSource bufferedSourceBody = part2.getBody();
                                String str = headers.get("content-disposition");
                                if (str != null && (contentDispositionNameParameter = UpdatesUtils.INSTANCE.parseContentDispositionNameParameter(str)) != null) {
                                    switch (contentDispositionNameParameter.hashCode()) {
                                        case -1809421292:
                                            if (contentDispositionNameParameter.equals("extensions")) {
                                                utf8 = bufferedSourceBody.readUtf8();
                                            }
                                            break;
                                        case -1044926951:
                                            if (contentDispositionNameParameter.equals("certificate_chain")) {
                                                utf9 = bufferedSourceBody.readUtf8();
                                            }
                                            break;
                                        case -962590641:
                                            if (contentDispositionNameParameter.equals("directive")) {
                                                pair2 = new Pair(bufferedSourceBody.readUtf8(), headers);
                                            }
                                            break;
                                        case 130625071:
                                            if (contentDispositionNameParameter.equals("manifest")) {
                                                pair = new Pair(bufferedSourceBody.readUtf8(), headers);
                                            }
                                            break;
                                    }
                                }
                                Unit unit2 = Unit.INSTANCE;
                                CloseableKt.closeFinally(part, null);
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    CloseableKt.closeFinally(part, th);
                                    throw th2;
                                }
                            }
                        }
                        this.logger.error("Error while reading multipart remote update response", e, UpdatesErrorCode.UpdateFailedToLoad);
                        throw new IOException("Error while reading multipart remote update response", e);
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(multipartReader, th3);
                        throw th4;
                    }
                }
            } catch (Exception e) {
                this.logger.error("Error while reading multipart remote update response", e, UpdatesErrorCode.UpdateFailedToLoad);
                throw new IOException("Error while reading multipart remote update response", e);
            }
        }
        pair = null;
        utf8 = null;
        utf9 = null;
        pair2 = null;
        if (utf8 != null) {
            try {
                jSONObject = new JSONObject(utf8);
            } catch (Exception e2) {
                this.logger.error("Failed to parse multipart remote update extensions part", e2, UpdatesErrorCode.UpdateFailedToLoad);
                throw new IOException("Failed to parse multipart remote update extensions part", e2);
            }
        } else {
            jSONObject = null;
        }
        if (this.configuration.getEnableExpoUpdatesProtocolV0CompatibilityMode() && pair == null) {
            IOException iOException = new IOException("Multipart response missing manifest part. Manifest is required in version 0 of the expo-updates protocol. This may be due to the response being for a different protocol version.");
            this.logger.error("Invalid update response", iOException, UpdatesErrorCode.UpdateFailedToLoad);
            throw new IOException("Invalid update response", iOException);
        }
        ResponsePartInfo responsePartInfo = pair != null ? new ResponsePartInfo(responseHeaderData, new ResponsePartHeaderData(((Headers) pair.getSecond()).get("expo-signature")), (String) pair.getFirst()) : null;
        ResponsePartInfo responsePartInfo2 = (this.configuration.getEnableExpoUpdatesProtocolV0CompatibilityMode() || pair2 == null) ? null : new ResponsePartInfo(responseHeaderData, new ResponsePartHeaderData(((Headers) pair2.getSecond()).get("expo-signature")), (String) pair2.getFirst());
        return new UpdateResponse(responseHeaderData, responsePartInfo != null ? parseManifest(responsePartInfo, jSONObject, utf9) : null, responsePartInfo2 != null ? parseDirective(responsePartInfo2, utf9) : null);
    }

    private final UpdateResponsePart.DirectiveUpdateResponsePart parseDirective(ResponsePartInfo directiveResponsePartInfo, String certificateChainFromManifestResponse) throws IOException {
        String body = directiveResponsePartInfo.getBody();
        try {
            CodeSigningConfiguration codeSigningConfiguration = this.configuration.getCodeSigningConfiguration();
            if (codeSigningConfiguration != null) {
                String signature = directiveResponsePartInfo.getResponsePartHeaderData().getSignature();
                byte[] bytes = body.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                SignatureValidationResult signatureValidationResultValidateSignature = codeSigningConfiguration.validateSignature(signature, bytes, certificateChainFromManifestResponse);
                if (signatureValidationResultValidateSignature.getValidationResult() == ValidationResult.INVALID) {
                    throw new IOException("Incorrect signature");
                }
                if (signatureValidationResultValidateSignature.getValidationResult() != ValidationResult.SKIPPED) {
                    UpdateDirective updateDirectiveFromJSONString = UpdateDirective.INSTANCE.fromJSONString(body);
                    ExpoProjectInformation expoProjectInformation = signatureValidationResultValidateSignature.getExpoProjectInformation();
                    if (expoProjectInformation != null) {
                        String projectId = expoProjectInformation.getProjectId();
                        SigningInfo signingInfo = updateDirectiveFromJSONString.getSigningInfo();
                        if (!Intrinsics.areEqual(projectId, signingInfo != null ? signingInfo.getEasProjectId() : null) || !Intrinsics.areEqual(expoProjectInformation.getScopeKey(), updateDirectiveFromJSONString.getSigningInfo().getScopeKey())) {
                            throw new CertificateException("Code signing certificate project ID or scope key does not match project ID or scope key in response part");
                        }
                    }
                }
            }
            return new UpdateResponsePart.DirectiveUpdateResponsePart(UpdateDirective.INSTANCE.fromJSONString(body));
        } catch (Exception e) {
            this.logger.error("Code signing verification failed for directive", e, UpdatesErrorCode.UpdateCodeSigningError);
            throw new IOException("Code signing verification failed for directive", e);
        }
    }

    private final UpdateResponsePart.ManifestUpdateResponsePart parseManifest(ResponsePartInfo manifestResponseInfo, JSONObject extensions, String certificateChainFromManifestResponse) {
        return checkCodeSigningAndCreateManifest(manifestResponseInfo.getBody(), new JSONObject(manifestResponseInfo.getBody()), manifestResponseInfo.getResponseHeaderData(), manifestResponseInfo.getResponsePartHeaderData(), extensions, certificateChainFromManifestResponse, this.configuration, this.logger);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003d  */
    private final String describeUnsuccessfulResponse(Response response) {
        String strString;
        String strTruncateForErrorMessage;
        try {
            ResponseBody responseBodyBody = response.body();
            strString = responseBodyBody != null ? responseBodyBody.string() : null;
        } catch (IOException e) {
            this.logger.warn("Could not read body of unsuccessful remote update response: " + LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(e), UpdatesErrorCode.UpdateFailedToLoad);
        }
        if (strString == null) {
            strTruncateForErrorMessage = "Unknown error";
        } else {
            String str = StringsKt.isBlank(strString) ? null : strString;
            if (str == null || (strTruncateForErrorMessage = truncateForErrorMessage(str)) == null) {
                strTruncateForErrorMessage = "Unknown error";
            }
        }
        return "HTTP " + response.code() + ": " + strTruncateForErrorMessage;
    }

    private final String truncateForErrorMessage(String body) {
        if (body.length() <= 512) {
            return body;
        }
        return StringsKt.take(body, 512) + "… (truncated, " + body.length() + " characters total)";
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0063 A[Catch: Exception -> 0x0085, TryCatch #2 {Exception -> 0x0085, blocks: (B:24:0x005b, B:26:0x0063, B:28:0x0068, B:29:0x0084, B:21:0x0054), top: B:41:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0068 A[Catch: Exception -> 0x0085, TryCatch #2 {Exception -> 0x0085, blocks: (B:24:0x005b, B:26:0x0063, B:28:0x0068, B:29:0x0084, B:21:0x0054), top: B:41:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object downloadRemoteUpdate(JSONObject jSONObject, Continuation<? super UpdateResponse> continuation) throws IOException {
        C09311 c09311;
        FileDownloader fileDownloader;
        Exception exc;
        Response response;
        if (continuation instanceof C09311) {
            c09311 = (C09311) continuation;
            if ((c09311.label & Integer.MIN_VALUE) != 0) {
                c09311.label -= Integer.MIN_VALUE;
            } else {
                c09311 = new C09311(continuation);
            }
        } else {
            c09311 = new C09311(continuation);
        }
        C09311 c09312 = c09311;
        Object objDownloadData$default = c09312.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09312.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                ResultKt.throwOnFailure(objDownloadData$default);
                fileDownloader = this;
                response = (Response) objDownloadData$default;
                if (response.isSuccessful()) {
                    IOException iOException = new IOException(fileDownloader.describeUnsuccessfulResponse(response));
                    fileDownloader.logger.error("Remote update request not successful", iOException, UpdatesErrorCode.UpdateFailedToLoad);
                    throw new IOException("Remote update request not successful", iOException);
                }
                return fileDownloader.parseRemoteUpdateResponse$expo_updates_release(response);
            } catch (Exception e) {
                exc = e;
                fileDownloader = this;
                fileDownloader.logger.error("Failed to download remote update", exc, UpdatesErrorCode.UpdateFailedToLoad);
                throw new IOException("Failed to download remote update", exc);
            }
        }
        ResultKt.throwOnFailure(objDownloadData$default);
        try {
            Request requestCreateRequestForRemoteUpdate = createRequestForRemoteUpdate(jSONObject, this.configuration, this.logger);
            c09312.L$0 = SpillingKt.nullOutSpilledVariable(jSONObject);
            c09312.label = 1;
            fileDownloader = this;
            try {
                objDownloadData$default = downloadData$default(fileDownloader, requestCreateRequestForRemoteUpdate, null, c09312, 2, null);
                if (objDownloadData$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                response = (Response) objDownloadData$default;
                if (response.isSuccessful()) {
                    IOException iOException2 = new IOException(fileDownloader.describeUnsuccessfulResponse(response));
                    fileDownloader.logger.error("Remote update request not successful", iOException2, UpdatesErrorCode.UpdateFailedToLoad);
                    throw new IOException("Remote update request not successful", iOException2);
                }
                return fileDownloader.parseRemoteUpdateResponse$expo_updates_release(response);
            } catch (Exception e2) {
                e = e2;
                exc = e;
                fileDownloader.logger.error("Failed to download remote update", exc, UpdatesErrorCode.UpdateFailedToLoad);
                throw new IOException("Failed to download remote update", exc);
            }
        } catch (Exception e3) {
            e = e3;
            fileDownloader = this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object downloadAsset$default(FileDownloader fileDownloader, AssetEntity assetEntity, File file, JSONObject jSONObject, UpdateEntity updateEntity, UpdateEntity updateEntity2, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 32) != 0) {
            function1 = null;
        }
        if ((i & 64) != 0) {
            function2 = null;
        }
        return fileDownloader.downloadAsset(assetEntity, file, jSONObject, updateEntity, updateEntity2, function1, function2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v3 */
    public final Object downloadAsset(AssetEntity assetEntity, File file, JSONObject jSONObject, UpdateEntity updateEntity, UpdateEntity updateEntity2, final Function1<? super Double, Unit> function1, Function2<? super AssetEntity, ? super File, Unit> function2, Continuation<? super AssetDownloadResult> continuation) throws IOException {
        AnonymousClass1 anonymousClass1;
        Object obj;
        String str;
        AssetEntity assetEntity2 = assetEntity;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj2 = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj2);
                if (assetEntity2.getUrl() == null) {
                    String str2 = "Failed to download asset " + assetEntity.getKey();
                    Exception exc = new Exception("Asset missing URL");
                    this.logger.error(str2, exc, UpdatesErrorCode.AssetsFailedToLoad);
                    throw new IOException(str2, exc);
                }
                String strCreateFilenameForAsset = UpdatesUtils.INSTANCE.createFilenameForAsset(assetEntity2);
                if (!UpdatesUtils.INSTANCE.isSafeFilename(strCreateFilenameForAsset)) {
                    String str3 = "Failed to download asset " + assetEntity.getKey();
                    IOException iOException = new IOException("Asset filename \"" + strCreateFilenameForAsset + "\" would resolve outside the updates directory");
                    this.logger.error(str3, iOException, UpdatesErrorCode.AssetsFailedToLoad);
                    throw new IOException(str3, iOException);
                }
                File file2 = new File(file, strCreateFilenameForAsset);
                if (file2.exists()) {
                    assetEntity2.setRelativePath(strCreateFilenameForAsset);
                    return new AssetDownloadResult(assetEntity2, false);
                }
                ?? r9 = (!assetEntity2.getIsLaunchAsset() || updateEntity == null || updateEntity2 == null || Intrinsics.areEqual(updateEntity.getId(), updateEntity2.getId())) ? 0 : 1;
                try {
                    Request requestCreateRequestForAsset = createRequestForAsset(assetEntity2, jSONObject, this.configuration, r9);
                    String expectedHash = assetEntity2.getExpectedHash();
                    FileDownloaderKt$sam$expo_modules_updates_loader_FileDownloadProgressListener$0 fileDownloaderKt$sam$expo_modules_updates_loader_FileDownloadProgressListener$0 = function1 != null ? new FileDownloaderKt$sam$expo_modules_updates_loader_FileDownloadProgressListener$0(new Function1() { // from class: expo.modules.updates.loader.FileDownloader$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return FileDownloader.downloadAsset$lambda$0$0(function1, ((Double) obj3).doubleValue());
                        }
                    }) : null;
                    anonymousClass2.L$0 = assetEntity2;
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(file);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(jSONObject);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(updateEntity);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(updateEntity2);
                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(function1);
                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(function2);
                    anonymousClass2.L$7 = strCreateFilenameForAsset;
                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(file2);
                    anonymousClass2.I$0 = r9;
                    anonymousClass2.label = 1;
                    Object objDownloadAssetAndVerifyHashAndWriteToPath$expo_updates_release = downloadAssetAndVerifyHashAndWriteToPath$expo_updates_release(assetEntity2, jSONObject, requestCreateRequestForAsset, expectedHash, file2, file, fileDownloaderKt$sam$expo_modules_updates_loader_FileDownloadProgressListener$0, r9, updateEntity, updateEntity2, function2, anonymousClass2);
                    if (objDownloadAssetAndVerifyHashAndWriteToPath$expo_updates_release == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    assetEntity2 = assetEntity;
                    obj = objDownloadAssetAndVerifyHashAndWriteToPath$expo_updates_release;
                    str = strCreateFilenameForAsset;
                } catch (Exception e) {
                    e = e;
                    assetEntity2 = assetEntity;
                    String str4 = "Failed to download asset " + assetEntity2.getKey();
                    this.logger.error(str4, e, UpdatesErrorCode.AssetsFailedToLoad);
                    throw new IOException(str4, e);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass2.I$0;
                String str5 = (String) anonymousClass2.L$7;
                assetEntity2 = (AssetEntity) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj2);
                obj = obj2;
                str = str5;
            }
            assetEntity2.setDownloadTime(new Date());
            assetEntity2.setRelativePath(str);
            assetEntity2.setHash(((FileDownloadResult) obj).getHash());
            return new AssetDownloadResult(assetEntity2, true);
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit downloadAsset$lambda$0$0(Function1 function1, double d) {
        function1.invoke(Double.valueOf(d));
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object downloadData$default(FileDownloader fileDownloader, Request request, FileDownloadProgressListener fileDownloadProgressListener, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            fileDownloadProgressListener = null;
        }
        return fileDownloader.downloadData(request, fileDownloadProgressListener, continuation);
    }

    private final Cache getCache() {
        return new Cache(getCacheDirectory(), 52428800L);
    }

    private final File getCacheDirectory() {
        return new File(this.filesDirectory, "okhttp");
    }

    public static /* synthetic */ Request createRequestForAsset$default(FileDownloader fileDownloader, AssetEntity assetEntity, JSONObject jSONObject, UpdatesConfiguration updatesConfiguration, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return fileDownloader.createRequestForAsset(assetEntity, jSONObject, updatesConfiguration, z);
    }

    public final Request createRequestForAsset(AssetEntity assetEntity, JSONObject extraHeaders, UpdatesConfiguration configuration, boolean allowPatch) {
        Intrinsics.checkNotNullParameter(assetEntity, "assetEntity");
        Intrinsics.checkNotNullParameter(extraHeaders, "extraHeaders");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Request.Builder builder = new Request.Builder();
        Uri url = assetEntity.getUrl();
        Intrinsics.checkNotNull(url);
        String string = url.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Request.Builder builderHeader = addHeadersFromJSONObject(addHeadersFromJSONObject(builder.url(string), assetEntity.getExtraRequestHeaders()), extraHeaders).header("Expo-Platform", "android").header("Expo-Protocol-Version", "1").header("Expo-API-Version", "1").header("Expo-Updates-Environment", "BARE").header("EAS-Client-ID", this.easClientID);
        boolean z = allowPatch && assetEntity.getIsLaunchAsset() && configuration.getEnableBsdiffPatchSupport() && assetEntity.getExpectedHash() != null;
        extraHeaders.optString("Expo-Current-Update-ID", "");
        extraHeaders.optString("Expo-Requested-Update-ID", "");
        builderHeader.header("Accept", "*/*");
        if (z) {
            builderHeader.header("A-IM", "bsdiff");
        } else {
            builderHeader.removeHeader("A-IM");
        }
        String runtimeVersionRaw = configuration.getRuntimeVersionRaw();
        String str = runtimeVersionRaw;
        if (str != null && str.length() != 0) {
            builderHeader.header("Expo-Runtime-Version", runtimeVersionRaw);
        }
        for (Map.Entry<String, String> entry : configuration.getRequestHeaders().entrySet()) {
            builderHeader.header(entry.getKey(), entry.getValue());
        }
        return builderHeader.build();
    }

    private final UpdateResponsePart.ManifestUpdateResponsePart checkCodeSigningAndCreateManifest(String bodyString, JSONObject preManifest, ResponseHeaderData responseHeaderData, ResponsePartHeaderData responsePartHeaderData, JSONObject extensions, String certificateChainFromManifestResponse, UpdatesConfiguration configuration, UpdatesLogger logger) throws Exception {
        preManifest.put("isVerified", false);
        try {
            CodeSigningConfiguration codeSigningConfiguration = configuration.getCodeSigningConfiguration();
            if (codeSigningConfiguration != null) {
                String signature = responsePartHeaderData.getSignature();
                byte[] bytes = bodyString.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                SignatureValidationResult signatureValidationResultValidateSignature = codeSigningConfiguration.validateSignature(signature, bytes, certificateChainFromManifestResponse);
                if (signatureValidationResultValidateSignature.getValidationResult() == ValidationResult.INVALID) {
                    throw new IOException("Incorrect signature");
                }
                if (signatureValidationResultValidateSignature.getValidationResult() != ValidationResult.SKIPPED) {
                    Manifest manifest = UpdateFactory.INSTANCE.getUpdate(preManifest, responseHeaderData, extensions, configuration).getManifest();
                    ExpoProjectInformation expoProjectInformation = signatureValidationResultValidateSignature.getExpoProjectInformation();
                    if (expoProjectInformation != null && (!Intrinsics.areEqual(expoProjectInformation.getProjectId(), manifest.getEASProjectID()) || !Intrinsics.areEqual(expoProjectInformation.getScopeKey(), manifest.getScopeKey()))) {
                        throw new CertificateException("Code signing certificate project ID or scope key does not match project ID or scope key in response");
                    }
                    UpdatesLogger.info$default(logger, "Manifest code signing signature verified successfully", null, 2, null);
                    preManifest.put("isVerified", true);
                }
            }
            Update update = UpdateFactory.INSTANCE.getUpdate(preManifest, responseHeaderData, extensions, configuration);
            SelectionPolicies selectionPolicies = SelectionPolicies.INSTANCE;
            UpdateEntity updateEntity = update.getUpdateEntity();
            Intrinsics.checkNotNull(updateEntity);
            if (!selectionPolicies.matchesFilters(updateEntity, responseHeaderData.getManifestFilters())) {
                throw new Exception("Manifest filters do not match manifest content for downloaded manifest");
            }
            return new UpdateResponsePart.ManifestUpdateResponsePart(update);
        } catch (Exception e) {
            logger.error("Code signing verification failed for manifest", e, UpdatesErrorCode.UpdateCodeSigningError);
            throw new IOException("Code signing verification failed for manifest", e);
        }
    }

    private final Request.Builder addHeadersFromJSONObject(Request.Builder builder, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectValueOf;
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            for (String str : SequencesKt.asSequence(itKeys)) {
                Intrinsics.checkNotNull(str);
                if (Intrinsics.areEqual(Object.class, String.class)) {
                    String string = jSONObject.getString(str);
                    if (string == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                    }
                    jSONObjectValueOf = string;
                } else if (Intrinsics.areEqual(Object.class, Double.class)) {
                    jSONObjectValueOf = Double.valueOf(jSONObject.getDouble(str));
                } else if (Intrinsics.areEqual(Object.class, Integer.class)) {
                    jSONObjectValueOf = Integer.valueOf(jSONObject.getInt(str));
                } else if (Intrinsics.areEqual(Object.class, Long.class)) {
                    jSONObjectValueOf = Long.valueOf(jSONObject.getLong(str));
                } else if (Intrinsics.areEqual(Object.class, Boolean.class)) {
                    jSONObjectValueOf = Boolean.valueOf(jSONObject.getBoolean(str));
                } else if (Intrinsics.areEqual(Object.class, JSONArray.class)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    if (jSONArray == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                    }
                    jSONObjectValueOf = jSONArray;
                } else if (Intrinsics.areEqual(Object.class, JSONObject.class)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                    if (jSONObject2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                    }
                    jSONObjectValueOf = jSONObject2;
                } else {
                    jSONObjectValueOf = jSONObject.get(str);
                    if (jSONObjectValueOf == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                    }
                }
                builder.header(str, jSONObjectValueOf.toString());
            }
        }
        return builder;
    }

    public final Request createRequestForRemoteUpdate(JSONObject extraHeaders, UpdatesConfiguration configuration, UpdatesLogger logger) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Request.Builder builder = new Request.Builder();
        String string = configuration.getUpdateUrl().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Request.Builder builderHeader = addHeadersFromJSONObject(builder.url(string), extraHeaders).header("Accept", "multipart/mixed,application/expo+json,application/json").header("Expo-Platform", "android").header("Expo-Protocol-Version", "1").header("Expo-API-Version", "1").header("Expo-Updates-Environment", "BARE").header("Expo-JSON-Error", "true").header("EAS-Client-ID", this.easClientID);
        String runtimeVersionRaw = configuration.getRuntimeVersionRaw();
        String str = runtimeVersionRaw;
        if (str != null && str.length() != 0) {
            builderHeader.header("Expo-Runtime-Version", runtimeVersionRaw);
        }
        String strConsumeErrorLog = NoDatabaseLauncher.INSTANCE.consumeErrorLog(this.filesDirectory, logger);
        if (strConsumeErrorLog != null) {
            String strSubstring = strConsumeErrorLog.substring(0, Math.min(1024, strConsumeErrorLog.length()));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            builderHeader.header("Expo-Fatal-Error", strSubstring);
        }
        for (Map.Entry<String, String> entry : configuration.getRequestHeaders().entrySet()) {
            builderHeader.header(entry.getKey(), entry.getValue());
        }
        CodeSigningConfiguration codeSigningConfiguration = configuration.getCodeSigningConfiguration();
        if (codeSigningConfiguration != null) {
            builderHeader.header("expo-expect-signature", codeSigningConfiguration.getAcceptSignatureHeader());
        }
        return builderHeader.build();
    }

    /* JADX INFO: compiled from: FileDownloader.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ$\u0010\u000f\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/updates/loader/FileDownloader$Companion;", "", "<init>", "()V", "MAX_ERROR_BODY_LENGTH", "", "getExtraHeadersForRemoteUpdateRequest", "Lorg/json/JSONObject;", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "configuration", "Lexpo/modules/updates/UpdatesConfiguration;", "launchedUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "embeddedUpdate", "getExtraHeadersForRemoteAssetRequest", "requestedUpdate", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JSONObject getExtraHeadersForRemoteUpdateRequest(UpdatesDatabase database, UpdatesConfiguration configuration, UpdateEntity launchedUpdate, UpdateEntity embeddedUpdate) throws JSONException {
            Intrinsics.checkNotNullParameter(database, "database");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            JSONObject serverDefinedHeaders = ManifestMetadata.getServerDefinedHeaders(database, configuration);
            if (serverDefinedHeaders == null) {
                serverDefinedHeaders = new JSONObject();
            }
            Map<String, String> extraParams = ManifestMetadata.INSTANCE.getExtraParams(database, configuration);
            if (extraParams != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(extraParams.size()));
                Iterator<T> it = extraParams.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(entry.getKey(), StringItem.valueOf((String) entry.getValue()));
                }
                serverDefinedHeaders.put("Expo-Extra-Params", Dictionary.valueOf(linkedHashMap).serialize());
            }
            if (launchedUpdate != null) {
                String string = launchedUpdate.getId().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                String lowerCase = string.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                serverDefinedHeaders.put("Expo-Current-Update-ID", lowerCase);
            }
            if (embeddedUpdate != null) {
                String string2 = embeddedUpdate.getId().toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                String lowerCase2 = string2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                serverDefinedHeaders.put("Expo-Embedded-Update-ID", lowerCase2);
            }
            List<UUID> listLoadRecentUpdateIdsWithFailedLaunch = database.updateDao().loadRecentUpdateIdsWithFailedLaunch();
            if (!listLoadRecentUpdateIdsWithFailedLaunch.isEmpty()) {
                List<UUID> list = listLoadRecentUpdateIdsWithFailedLaunch;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(StringItem.valueOf(((UUID) it2.next()).toString()));
                }
                serverDefinedHeaders.put("Expo-Recent-Failed-Update-IDs", OuterList.valueOf(arrayList).serialize());
            }
            return serverDefinedHeaders;
        }

        public final JSONObject getExtraHeadersForRemoteAssetRequest(UpdateEntity launchedUpdate, UpdateEntity embeddedUpdate, UpdateEntity requestedUpdate) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            if (launchedUpdate != null) {
                String string = launchedUpdate.getId().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                String lowerCase = string.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                jSONObject.put("Expo-Current-Update-ID", lowerCase);
            }
            if (embeddedUpdate != null) {
                String string2 = embeddedUpdate.getId().toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                String lowerCase2 = string2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                jSONObject.put("Expo-Embedded-Update-ID", lowerCase2);
            }
            if (requestedUpdate != null) {
                String string3 = requestedUpdate.getId().toString();
                Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                String lowerCase3 = string3.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                jSONObject.put("Expo-Requested-Update-ID", lowerCase3);
            }
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadData(Request request, FileDownloadProgressListener fileDownloadProgressListener, Continuation<? super Response> continuation) {
        ResponseBody responseBodyBody;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final Call callNewCall = this.client.newCall(request);
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: expo.modules.updates.loader.FileDownloader$downloadData$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                callNewCall.cancel();
            }
        });
        try {
            Response responseExecute = callNewCall.execute();
            Response responseBuild = null;
            if (fileDownloadProgressListener != null && (responseBodyBody = responseExecute.body()) != null) {
                responseBuild = responseExecute.newBuilder().body(new FileDownloadProgressResponseBody(responseBodyBody, fileDownloadProgressListener)).build();
            }
            CancellableContinuationImpl cancellableContinuationImpl3 = cancellableContinuationImpl2;
            Result.Companion companion = Result.INSTANCE;
            if (responseBuild != null) {
                responseExecute = responseBuild;
            }
            cancellableContinuationImpl3.resumeWith(Result.m12684constructorimpl(responseExecute));
        } catch (Exception e) {
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m12684constructorimpl(ResultKt.createFailure(e)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
