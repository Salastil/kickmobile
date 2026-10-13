package io.ktor.client.plugins.contentnegotiation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: ContentNegotiation.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class ContentNegotiationKt$ContentNegotiation$1 extends FunctionReferenceImpl implements Function0<ContentNegotiationConfig> {
    public static final ContentNegotiationKt$ContentNegotiation$1 INSTANCE = new ContentNegotiationKt$ContentNegotiation$1();

    ContentNegotiationKt$ContentNegotiation$1() {
        super(0, ContentNegotiationConfig.class, "<init>", "<init>()V", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ContentNegotiationConfig invoke() {
        return new ContentNegotiationConfig();
    }
}
