package io.ktor.client.request.forms;

import androidx.media3.muxer.WebmConstants;
import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.content.PartData;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;

/* JADX INFO: compiled from: formDsl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u0000\"\u0006\u0012\u0002\b\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a2\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\f\u001a]\u0010\u0015\u001a\u00020\t*\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0019\b\u0004\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0004 \u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a_\u0010\u0015\u001a\u00020\t*\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0005 \u0001¢\u0006\u0004\b\u0015\u0010\u001a\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {"", "Lio/ktor/client/request/forms/FormPart;", "values", "", "Lio/ktor/http/content/PartData;", "formData", "([Lio/ktor/client/request/forms/FormPart;)Ljava/util/List;", "Lkotlin/Function1;", "Lio/ktor/client/request/forms/FormBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "", "key", "Lio/ktor/http/Headers;", "headers", "", ContentDisposition.Parameters.Size, "Lkotlinx/io/Sink;", "bodyBuilder", "append", "(Lio/ktor/client/request/forms/FormBuilder;Ljava/lang/String;Lio/ktor/http/Headers;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "filename", "Lio/ktor/http/ContentType;", "contentType", "(Lio/ktor/client/request/forms/FormBuilder;Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/ContentType;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FormDslKt {
    public static final List<PartData> formData(FormPart<?>... values) {
        PartData binaryChannelItem;
        Intrinsics.checkNotNullParameter(values, "values");
        ArrayList arrayList = new ArrayList();
        for (FormPart<?> formPart : values) {
            String key = formPart.getKey();
            final Object objComponent2 = formPart.component2();
            Headers headers = formPart.getHeaders();
            HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
            headersBuilder.append("Content-Disposition", "form-data; name=" + HeaderValueWithParametersKt.escapeIfNeeded(key));
            headersBuilder.appendAll(headers);
            if (objComponent2 instanceof String) {
                binaryChannelItem = new PartData.FormItem((String) objComponent2, new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof Number) {
                binaryChannelItem = new PartData.FormItem(objComponent2.toString(), new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof Boolean) {
                binaryChannelItem = new PartData.FormItem(String.valueOf(((Boolean) objComponent2).booleanValue()), new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof byte[]) {
                headersBuilder.append("Content-Length", String.valueOf(((byte[]) objComponent2).length));
                binaryChannelItem = new PartData.BinaryItem(new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FormDslKt.formData$lambda$0$4(objComponent2);
                    }
                }, new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof Source) {
                if (objComponent2 instanceof Buffer) {
                    headersBuilder.append("Content-Length", String.valueOf(ByteReadPacketKt.getRemaining((Source) objComponent2)));
                }
                binaryChannelItem = new PartData.BinaryItem(new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FormDslKt.formData$lambda$0$6(objComponent2);
                    }
                }, new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FormDslKt.formData$lambda$0$7(objComponent2);
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof InputProvider) {
                InputProvider inputProvider = (InputProvider) objComponent2;
                Long size = inputProvider.getSize();
                if (size != null) {
                    headersBuilder.append("Content-Length", String.valueOf(size.longValue()));
                }
                binaryChannelItem = new PartData.BinaryItem(inputProvider.getBlock(), new Function0() { // from class: io.ktor.client.request.forms.FormDslKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof ChannelProvider) {
                ChannelProvider channelProvider = (ChannelProvider) objComponent2;
                Long size2 = channelProvider.getSize();
                if (size2 != null) {
                    headersBuilder.append("Content-Length", String.valueOf(size2.longValue()));
                }
                binaryChannelItem = new PartData.BinaryChannelItem(channelProvider.getBlock(), headersBuilder.build());
            } else {
                throw new IllegalStateException(("Unknown form content type: " + objComponent2).toString());
            }
            arrayList.add(binaryChannelItem);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Source formData$lambda$0$4(Object obj) {
        return ByteReadPacketKt.ByteReadPacket$default((byte[]) obj, 0, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Source formData$lambda$0$6(Object obj) {
        return ((Source) obj).peek();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit formData$lambda$0$7(Object obj) {
        ((Source) obj).close();
        return Unit.INSTANCE;
    }

    public static final List<PartData> formData(Function1<? super FormBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FormBuilder formBuilder = new FormBuilder();
        block.invoke(formBuilder);
        FormPart[] formPartArr = (FormPart[]) formBuilder.build().toArray(new FormPart[0]);
        return formData((FormPart<?>[]) Arrays.copyOf(formPartArr, formPartArr.length));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String key, Headers headers, Long l, Function1 bodyBuilder, int i, Object obj) {
        if ((i & 2) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        if ((i & 4) != 0) {
            l = null;
        }
        Intrinsics.checkNotNullParameter(formBuilder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(bodyBuilder, "bodyBuilder");
        formBuilder.append(new FormPart(key, new InputProvider(l, new AnonymousClass1(bodyBuilder)), headers));
    }

    public static final void append(FormBuilder formBuilder, String key, Headers headers, Long l, Function1<? super Sink, Unit> bodyBuilder) {
        Intrinsics.checkNotNullParameter(formBuilder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(bodyBuilder, "bodyBuilder");
        formBuilder.append(new FormPart(key, new InputProvider(l, new AnonymousClass1(bodyBuilder)), headers));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String str, String str2, ContentType contentType, Long l, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            contentType = null;
        }
        if ((i & 8) != 0) {
            l = null;
        }
        append(formBuilder, str, str2, contentType, l, function1);
    }

    public static final void append(FormBuilder formBuilder, String key, String filename, ContentType contentType, Long l, Function1<? super Sink, Unit> bodyBuilder) {
        Intrinsics.checkNotNullParameter(formBuilder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(bodyBuilder, "bodyBuilder");
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        headersBuilder.set("Content-Disposition", "filename=" + HeaderValueWithParametersKt.escapeIfNeeded(filename));
        if (contentType != null) {
            headersBuilder.set("Content-Type", contentType.toString());
        }
        formBuilder.append(new FormPart(key, new InputProvider(l, new AnonymousClass1(bodyBuilder)), headersBuilder.build()));
    }

    /* JADX INFO: renamed from: io.ktor.client.request.forms.FormDslKt$append$1, reason: invalid class name */
    /* JADX INFO: compiled from: formDsl.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass1 implements Function0<Source> {
        final /* synthetic */ Function1<Sink, Unit> $bodyBuilder;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super Sink, Unit> function1) {
            this.$bodyBuilder = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Source invoke() {
            Function1<Sink, Unit> function1 = this.$bodyBuilder;
            Buffer buffer = new Buffer();
            function1.invoke(buffer);
            return buffer;
        }
    }
}
