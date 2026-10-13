package expo.modules.updates.launcher;

import androidx.media3.muxer.WebmConstants;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.manifest.EmbeddedUpdate;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: compiled from: DatabaseLauncher.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lexpo/modules/updates/db/entity/AssetEntity;", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.updates.launcher.DatabaseLauncher$launch$2$job$1", f = "DatabaseLauncher.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, nl = {WebmConstants.MkvEbmlElement.TRACK_TYPE}, s = {}, v = 2)
final class DatabaseLauncher$launch$2$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends AssetEntity, ? extends File>>, Object> {
    final /* synthetic */ AssetEntity $asset;
    final /* synthetic */ UpdatesDatabase $database;
    final /* synthetic */ EmbeddedUpdate $embeddedUpdate;
    final /* synthetic */ JSONObject $extraHeaders;
    int label;
    final /* synthetic */ DatabaseLauncher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DatabaseLauncher$launch$2$job$1(DatabaseLauncher databaseLauncher, AssetEntity assetEntity, UpdatesDatabase updatesDatabase, EmbeddedUpdate embeddedUpdate, JSONObject jSONObject, Continuation<? super DatabaseLauncher$launch$2$job$1> continuation) {
        super(2, continuation);
        this.this$0 = databaseLauncher;
        this.$asset = assetEntity;
        this.$database = updatesDatabase;
        this.$embeddedUpdate = embeddedUpdate;
        this.$extraHeaders = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DatabaseLauncher$launch$2$job$1(this.this$0, this.$asset, this.$database, this.$embeddedUpdate, this.$extraHeaders, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends AssetEntity, ? extends File>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<AssetEntity, ? extends File>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<AssetEntity, ? extends File>> continuation) {
        return ((DatabaseLauncher$launch$2$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.ensureAssetExists(this.$asset, this.$database, this.$embeddedUpdate, this.$extraHeaders, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return new Pair(this.$asset, (File) obj);
    }
}
