package com.facebook.imagepipeline.network;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkResponseData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/network/NetworkResponseData;", "", "<init>", "()V", "Bytes", "Stream", "Lcom/facebook/imagepipeline/network/NetworkResponseData$Bytes;", "Lcom/facebook/imagepipeline/network/NetworkResponseData$Stream;", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class NetworkResponseData {
    public /* synthetic */ NetworkResponseData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private NetworkResponseData() {
    }

    /* JADX INFO: compiled from: NetworkResponseData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/imagepipeline/network/NetworkResponseData$Bytes;", "Lcom/facebook/imagepipeline/network/NetworkResponseData;", "data", "", "length", "", "<init>", "([BI)V", "getData", "()[B", "getLength", "()I", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Bytes extends NetworkResponseData {
        private final byte[] data;
        private final int length;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Bytes(byte[] data, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.length = i;
        }

        public final byte[] getData() {
            return this.data;
        }

        public final int getLength() {
            return this.length;
        }
    }

    /* JADX INFO: compiled from: NetworkResponseData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/imagepipeline/network/NetworkResponseData$Stream;", "Lcom/facebook/imagepipeline/network/NetworkResponseData;", "stream", "Ljava/io/InputStream;", "length", "", "<init>", "(Ljava/io/InputStream;I)V", "getStream", "()Ljava/io/InputStream;", "getLength", "()I", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Stream extends NetworkResponseData {
        private final int length;
        private final InputStream stream;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Stream(InputStream stream, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(stream, "stream");
            this.stream = stream;
            this.length = i;
        }

        public final int getLength() {
            return this.length;
        }

        public final InputStream getStream() {
            return this.stream;
        }
    }
}
