package io.github.centrifugal.centrifuge.internal.protocol;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class Protocol {

    public interface ClientInfoOrBuilder extends MessageLiteOrBuilder {
        ByteString getChanInfo();

        String getClient();

        ByteString getClientBytes();

        ByteString getConnInfo();

        String getUser();

        ByteString getUserBytes();
    }

    public interface CommandOrBuilder extends MessageLiteOrBuilder {
        ConnectRequest getConnect();

        HistoryRequest getHistory();

        int getId();

        PingRequest getPing();

        PresenceRequest getPresence();

        PresenceStatsRequest getPresenceStats();

        PublishRequest getPublish();

        RefreshRequest getRefresh();

        RPCRequest getRpc();

        SendRequest getSend();

        SubRefreshRequest getSubRefresh();

        SubscribeRequest getSubscribe();

        UnsubscribeRequest getUnsubscribe();

        boolean hasConnect();

        boolean hasHistory();

        boolean hasPing();

        boolean hasPresence();

        boolean hasPresenceStats();

        boolean hasPublish();

        boolean hasRefresh();

        boolean hasRpc();

        boolean hasSend();

        boolean hasSubRefresh();

        boolean hasSubscribe();

        boolean hasUnsubscribe();
    }

    public interface ConnectOrBuilder extends MessageLiteOrBuilder {
        boolean containsSubs(String str);

        String getClient();

        ByteString getClientBytes();

        ByteString getData();

        boolean getExpires();

        String getNode();

        ByteString getNodeBytes();

        int getPing();

        boolean getPong();

        String getSession();

        ByteString getSessionBytes();

        @Deprecated
        Map<String, SubscribeResult> getSubs();

        int getSubsCount();

        Map<String, SubscribeResult> getSubsMap();

        SubscribeResult getSubsOrDefault(String str, SubscribeResult subscribeResult);

        SubscribeResult getSubsOrThrow(String str);

        long getTime();

        int getTtl();

        String getVersion();

        ByteString getVersionBytes();
    }

    public interface ConnectRequestOrBuilder extends MessageLiteOrBuilder {
        boolean containsHeaders(String str);

        boolean containsSubs(String str);

        ByteString getData();

        long getFlag();

        @Deprecated
        Map<String, String> getHeaders();

        int getHeadersCount();

        Map<String, String> getHeadersMap();

        String getHeadersOrDefault(String str, String str2);

        String getHeadersOrThrow(String str);

        String getName();

        ByteString getNameBytes();

        @Deprecated
        Map<String, SubscribeRequest> getSubs();

        int getSubsCount();

        Map<String, SubscribeRequest> getSubsMap();

        SubscribeRequest getSubsOrDefault(String str, SubscribeRequest subscribeRequest);

        SubscribeRequest getSubsOrThrow(String str);

        String getToken();

        ByteString getTokenBytes();

        String getVersion();

        ByteString getVersionBytes();
    }

    public interface ConnectResultOrBuilder extends MessageLiteOrBuilder {
        boolean containsSubs(String str);

        String getClient();

        ByteString getClientBytes();

        ByteString getData();

        boolean getExpires();

        String getNode();

        ByteString getNodeBytes();

        int getPing();

        boolean getPong();

        String getSession();

        ByteString getSessionBytes();

        @Deprecated
        Map<String, SubscribeResult> getSubs();

        int getSubsCount();

        Map<String, SubscribeResult> getSubsMap();

        SubscribeResult getSubsOrDefault(String str, SubscribeResult subscribeResult);

        SubscribeResult getSubsOrThrow(String str);

        long getTime();

        int getTtl();

        String getVersion();

        ByteString getVersionBytes();
    }

    public interface DisconnectOrBuilder extends MessageLiteOrBuilder {
        int getCode();

        String getReason();

        ByteString getReasonBytes();

        boolean getReconnect();
    }

    public interface EmulationRequestOrBuilder extends MessageLiteOrBuilder {
        ByteString getData();

        String getNode();

        ByteString getNodeBytes();

        String getSession();

        ByteString getSessionBytes();
    }

    public interface ErrorOrBuilder extends MessageLiteOrBuilder {
        int getCode();

        String getMessage();

        ByteString getMessageBytes();

        boolean getTemporary();
    }

    public interface FilterNodeOrBuilder extends MessageLiteOrBuilder {
        String getCmp();

        ByteString getCmpBytes();

        String getKey();

        ByteString getKeyBytes();

        FilterNode getNodes(int i);

        int getNodesCount();

        List<FilterNode> getNodesList();

        String getOp();

        ByteString getOpBytes();

        String getVal();

        ByteString getValBytes();

        String getVals(int i);

        ByteString getValsBytes(int i);

        int getValsCount();

        List<String> getValsList();
    }

    public interface HistoryRequestOrBuilder extends MessageLiteOrBuilder {
        String getChannel();

        ByteString getChannelBytes();

        int getLimit();

        boolean getReverse();

        StreamPosition getSince();

        boolean hasSince();
    }

    public interface HistoryResultOrBuilder extends MessageLiteOrBuilder {
        String getEpoch();

        ByteString getEpochBytes();

        long getOffset();

        Publication getPublications(int i);

        int getPublicationsCount();

        List<Publication> getPublicationsList();
    }

    public interface JoinOrBuilder extends MessageLiteOrBuilder {
        ClientInfo getInfo();

        boolean hasInfo();
    }

    public interface KeyedItemOrBuilder extends MessageLiteOrBuilder {
        String getKey();

        ByteString getKeyBytes();

        long getVersion();
    }

    public interface LeaveOrBuilder extends MessageLiteOrBuilder {
        ClientInfo getInfo();

        boolean hasInfo();
    }

    public interface MessageOrBuilder extends MessageLiteOrBuilder {
        ByteString getData();
    }

    public interface PingRequestOrBuilder extends MessageLiteOrBuilder {
    }

    public interface PingResultOrBuilder extends MessageLiteOrBuilder {
    }

    public interface PresenceRequestOrBuilder extends MessageLiteOrBuilder {
        String getChannel();

        ByteString getChannelBytes();
    }

    public interface PresenceResultOrBuilder extends MessageLiteOrBuilder {
        boolean containsPresence(String str);

        @Deprecated
        Map<String, ClientInfo> getPresence();

        int getPresenceCount();

        Map<String, ClientInfo> getPresenceMap();

        ClientInfo getPresenceOrDefault(String str, ClientInfo clientInfo);

        ClientInfo getPresenceOrThrow(String str);
    }

    public interface PresenceStatsRequestOrBuilder extends MessageLiteOrBuilder {
        String getChannel();

        ByteString getChannelBytes();
    }

    public interface PresenceStatsResultOrBuilder extends MessageLiteOrBuilder {
        int getNumClients();

        int getNumUsers();
    }

    public interface PublicationOrBuilder extends MessageLiteOrBuilder {
        boolean containsTags(String str);

        String getChannel();

        ByteString getChannelBytes();

        ByteString getData();

        boolean getDelta();

        String getEpoch();

        ByteString getEpochBytes();

        ClientInfo getInfo();

        String getKey();

        ByteString getKeyBytes();

        long getOffset();

        ByteString getPrevData();

        boolean getRemoved();

        long getScore();

        @Deprecated
        Map<String, String> getTags();

        int getTagsCount();

        Map<String, String> getTagsMap();

        String getTagsOrDefault(String str, String str2);

        String getTagsOrThrow(String str);

        long getTime();

        long getVersion();

        boolean hasInfo();
    }

    public interface PublishRequestOrBuilder extends MessageLiteOrBuilder {
        String getChannel();

        ByteString getChannelBytes();

        ByteString getData();

        String getKey();

        ByteString getKeyBytes();

        boolean getRemoved();

        int getType();
    }

    public interface PublishResultOrBuilder extends MessageLiteOrBuilder {
    }

    public interface PushOrBuilder extends MessageLiteOrBuilder {
        String getChannel();

        ByteString getChannelBytes();

        Connect getConnect();

        Disconnect getDisconnect();

        long getId();

        Join getJoin();

        Leave getLeave();

        Message getMessage();

        Publication getPub();

        Refresh getRefresh();

        Subscribe getSubscribe();

        Unsubscribe getUnsubscribe();

        boolean hasConnect();

        boolean hasDisconnect();

        boolean hasJoin();

        boolean hasLeave();

        boolean hasMessage();

        boolean hasPub();

        boolean hasRefresh();

        boolean hasSubscribe();

        boolean hasUnsubscribe();
    }

    public interface RPCRequestOrBuilder extends MessageLiteOrBuilder {
        ByteString getData();

        String getMethod();

        ByteString getMethodBytes();
    }

    public interface RPCResultOrBuilder extends MessageLiteOrBuilder {
        ByteString getData();
    }

    public interface RefreshOrBuilder extends MessageLiteOrBuilder {
        boolean getExpires();

        int getTtl();
    }

    public interface RefreshRequestOrBuilder extends MessageLiteOrBuilder {
        String getToken();

        ByteString getTokenBytes();
    }

    public interface RefreshResultOrBuilder extends MessageLiteOrBuilder {
        String getClient();

        ByteString getClientBytes();

        boolean getExpires();

        int getTtl();

        String getVersion();

        ByteString getVersionBytes();
    }

    public interface ReplyOrBuilder extends MessageLiteOrBuilder {
        ConnectResult getConnect();

        Error getError();

        HistoryResult getHistory();

        int getId();

        PingResult getPing();

        PresenceResult getPresence();

        PresenceStatsResult getPresenceStats();

        PublishResult getPublish();

        Push getPush();

        RefreshResult getRefresh();

        RPCResult getRpc();

        SubRefreshResult getSubRefresh();

        SubscribeResult getSubscribe();

        UnsubscribeResult getUnsubscribe();

        boolean hasConnect();

        boolean hasError();

        boolean hasHistory();

        boolean hasPing();

        boolean hasPresence();

        boolean hasPresenceStats();

        boolean hasPublish();

        boolean hasPush();

        boolean hasRefresh();

        boolean hasRpc();

        boolean hasSubRefresh();

        boolean hasSubscribe();

        boolean hasUnsubscribe();
    }

    public interface SendRequestOrBuilder extends MessageLiteOrBuilder {
        ByteString getData();
    }

    public interface StreamPositionOrBuilder extends MessageLiteOrBuilder {
        String getEpoch();

        ByteString getEpochBytes();

        long getOffset();
    }

    public interface SubRefreshRequestOrBuilder extends MessageLiteOrBuilder {
        String getChannel();

        ByteString getChannelBytes();

        String getToken();

        ByteString getTokenBytes();

        TrackBatch getTrack(int i);

        int getTrackCount();

        List<TrackBatch> getTrackList();

        int getType();

        String getUntrack(int i);

        ByteString getUntrackBytes(int i);

        int getUntrackCount();

        List<String> getUntrackList();
    }

    public interface SubRefreshResultOrBuilder extends MessageLiteOrBuilder {
        boolean getExpires();

        Publication getItems(int i);

        int getItemsCount();

        List<Publication> getItemsList();

        int getTtl();
    }

    public interface SubscribeOrBuilder extends MessageLiteOrBuilder {
        ByteString getData();

        String getEpoch();

        ByteString getEpochBytes();

        long getOffset();

        boolean getPositioned();

        boolean getRecoverable();
    }

    public interface SubscribeRequestOrBuilder extends MessageLiteOrBuilder {
        boolean getAsc();

        String getChannel();

        ByteString getChannelBytes();

        String getCursor();

        ByteString getCursorBytes();

        ByteString getData();

        String getDelta();

        ByteString getDeltaBytes();

        String getEpoch();

        ByteString getEpochBytes();

        long getFlag();

        boolean getJoinLeave();

        int getLimit();

        long getOffset();

        int getPhase();

        boolean getPositioned();

        boolean getRecover();

        boolean getRecoverable();

        FilterNode getTf();

        String getToken();

        ByteString getTokenBytes();

        int getType();

        boolean hasTf();
    }

    public interface SubscribeResultOrBuilder extends MessageLiteOrBuilder {
        String getCursor();

        ByteString getCursorBytes();

        ByteString getData();

        boolean getDelta();

        String getEpoch();

        ByteString getEpochBytes();

        boolean getExpires();

        long getId();

        long getOffset();

        int getPhase();

        boolean getPositioned();

        Publication getPublications(int i);

        int getPublicationsCount();

        List<Publication> getPublicationsList();

        int getPublishDebounce();

        boolean getRecoverable();

        boolean getRecovered();

        Publication getState(int i);

        int getStateCount();

        List<Publication> getStateList();

        int getTtl();

        int getType();

        boolean getWasRecovering();
    }

    public interface TrackBatchOrBuilder extends MessageLiteOrBuilder {
        KeyedItem getItems(int i);

        int getItemsCount();

        List<KeyedItem> getItemsList();

        String getSignature();

        ByteString getSignatureBytes();
    }

    public interface UnsubscribeOrBuilder extends MessageLiteOrBuilder {
        int getCode();

        String getReason();

        ByteString getReasonBytes();
    }

    public interface UnsubscribeRequestOrBuilder extends MessageLiteOrBuilder {
        String getChannel();

        ByteString getChannelBytes();
    }

    public interface UnsubscribeResultOrBuilder extends MessageLiteOrBuilder {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Protocol() {
    }

    public static final class Error extends GeneratedMessageLite<Error, Builder> implements ErrorOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final Error DEFAULT_INSTANCE;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        private static volatile Parser<Error> PARSER = null;
        public static final int TEMPORARY_FIELD_NUMBER = 3;
        private int code_;
        private String message_ = "";
        private boolean temporary_;

        private Error() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ErrorOrBuilder
        public int getCode() {
            return this.code_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCode(int i) {
            this.code_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.code_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ErrorOrBuilder
        public String getMessage() {
            return this.message_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ErrorOrBuilder
        public ByteString getMessageBytes() {
            return ByteString.copyFromUtf8(this.message_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessage(String str) {
            str.getClass();
            this.message_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMessage() {
            this.message_ = getDefaultInstance().getMessage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessageBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.message_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ErrorOrBuilder
        public boolean getTemporary() {
            return this.temporary_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTemporary(boolean z) {
            this.temporary_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTemporary() {
            this.temporary_ = false;
        }

        public static Error parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Error parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Error parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Error parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Error parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Error parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Error parseFrom(InputStream inputStream) throws IOException {
            return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Error parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Error parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Error) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Error parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Error) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Error parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Error parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Error) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Error error) {
            return DEFAULT_INSTANCE.createBuilder(error);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Error, Builder> implements ErrorOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Error.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ErrorOrBuilder
            public int getCode() {
                return ((Error) this.instance).getCode();
            }

            public Builder setCode(int i) {
                copyOnWrite();
                ((Error) this.instance).setCode(i);
                return this;
            }

            public Builder clearCode() {
                copyOnWrite();
                ((Error) this.instance).clearCode();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ErrorOrBuilder
            public String getMessage() {
                return ((Error) this.instance).getMessage();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ErrorOrBuilder
            public ByteString getMessageBytes() {
                return ((Error) this.instance).getMessageBytes();
            }

            public Builder setMessage(String str) {
                copyOnWrite();
                ((Error) this.instance).setMessage(str);
                return this;
            }

            public Builder clearMessage() {
                copyOnWrite();
                ((Error) this.instance).clearMessage();
                return this;
            }

            public Builder setMessageBytes(ByteString byteString) {
                copyOnWrite();
                ((Error) this.instance).setMessageBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ErrorOrBuilder
            public boolean getTemporary() {
                return ((Error) this.instance).getTemporary();
            }

            public Builder setTemporary(boolean z) {
                copyOnWrite();
                ((Error) this.instance).setTemporary(z);
                return this;
            }

            public Builder clearTemporary() {
                copyOnWrite();
                ((Error) this.instance).clearTemporary();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new Error();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002Ȉ\u0003\u0007", new Object[]{"code_", "message_", "temporary_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Error> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Error.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Error error = new Error();
            DEFAULT_INSTANCE = error;
            GeneratedMessageLite.registerDefaultInstance(Error.class, error);
        }

        public static Error getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Error> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: io.github.centrifugal.centrifuge.internal.protocol.Protocol$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes8.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class EmulationRequest extends GeneratedMessageLite<EmulationRequest, Builder> implements EmulationRequestOrBuilder {
        public static final int DATA_FIELD_NUMBER = 3;
        private static final EmulationRequest DEFAULT_INSTANCE;
        public static final int NODE_FIELD_NUMBER = 1;
        private static volatile Parser<EmulationRequest> PARSER = null;
        public static final int SESSION_FIELD_NUMBER = 2;
        private String node_ = "";
        private String session_ = "";
        private ByteString data_ = ByteString.EMPTY;

        private EmulationRequest() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.EmulationRequestOrBuilder
        public String getNode() {
            return this.node_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.EmulationRequestOrBuilder
        public ByteString getNodeBytes() {
            return ByteString.copyFromUtf8(this.node_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNode(String str) {
            str.getClass();
            this.node_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNode() {
            this.node_ = getDefaultInstance().getNode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNodeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.node_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.EmulationRequestOrBuilder
        public String getSession() {
            return this.session_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.EmulationRequestOrBuilder
        public ByteString getSessionBytes() {
            return ByteString.copyFromUtf8(this.session_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSession(String str) {
            str.getClass();
            this.session_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSession() {
            this.session_ = getDefaultInstance().getSession();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.session_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.EmulationRequestOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(ByteString byteString) {
            byteString.getClass();
            this.data_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        public static EmulationRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EmulationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static EmulationRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EmulationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static EmulationRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EmulationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static EmulationRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EmulationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EmulationRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EmulationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EmulationRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EmulationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static EmulationRequest parseFrom(InputStream inputStream) throws IOException {
            return (EmulationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EmulationRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EmulationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EmulationRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EmulationRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EmulationRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EmulationRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EmulationRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EmulationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EmulationRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EmulationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(EmulationRequest emulationRequest) {
            return DEFAULT_INSTANCE.createBuilder(emulationRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<EmulationRequest, Builder> implements EmulationRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(EmulationRequest.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.EmulationRequestOrBuilder
            public String getNode() {
                return ((EmulationRequest) this.instance).getNode();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.EmulationRequestOrBuilder
            public ByteString getNodeBytes() {
                return ((EmulationRequest) this.instance).getNodeBytes();
            }

            public Builder setNode(String str) {
                copyOnWrite();
                ((EmulationRequest) this.instance).setNode(str);
                return this;
            }

            public Builder clearNode() {
                copyOnWrite();
                ((EmulationRequest) this.instance).clearNode();
                return this;
            }

            public Builder setNodeBytes(ByteString byteString) {
                copyOnWrite();
                ((EmulationRequest) this.instance).setNodeBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.EmulationRequestOrBuilder
            public String getSession() {
                return ((EmulationRequest) this.instance).getSession();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.EmulationRequestOrBuilder
            public ByteString getSessionBytes() {
                return ((EmulationRequest) this.instance).getSessionBytes();
            }

            public Builder setSession(String str) {
                copyOnWrite();
                ((EmulationRequest) this.instance).setSession(str);
                return this;
            }

            public Builder clearSession() {
                copyOnWrite();
                ((EmulationRequest) this.instance).clearSession();
                return this;
            }

            public Builder setSessionBytes(ByteString byteString) {
                copyOnWrite();
                ((EmulationRequest) this.instance).setSessionBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.EmulationRequestOrBuilder
            public ByteString getData() {
                return ((EmulationRequest) this.instance).getData();
            }

            public Builder setData(ByteString byteString) {
                copyOnWrite();
                ((EmulationRequest) this.instance).setData(byteString);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((EmulationRequest) this.instance).clearData();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new EmulationRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\n", new Object[]{"node_", "session_", "data_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EmulationRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (EmulationRequest.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            EmulationRequest emulationRequest = new EmulationRequest();
            DEFAULT_INSTANCE = emulationRequest;
            GeneratedMessageLite.registerDefaultInstance(EmulationRequest.class, emulationRequest);
        }

        public static EmulationRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EmulationRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Command extends GeneratedMessageLite<Command, Builder> implements CommandOrBuilder {
        public static final int CONNECT_FIELD_NUMBER = 4;
        private static final Command DEFAULT_INSTANCE;
        public static final int HISTORY_FIELD_NUMBER = 10;
        public static final int ID_FIELD_NUMBER = 1;
        private static volatile Parser<Command> PARSER = null;
        public static final int PING_FIELD_NUMBER = 11;
        public static final int PRESENCE_FIELD_NUMBER = 8;
        public static final int PRESENCE_STATS_FIELD_NUMBER = 9;
        public static final int PUBLISH_FIELD_NUMBER = 7;
        public static final int REFRESH_FIELD_NUMBER = 14;
        public static final int RPC_FIELD_NUMBER = 13;
        public static final int SEND_FIELD_NUMBER = 12;
        public static final int SUBSCRIBE_FIELD_NUMBER = 5;
        public static final int SUB_REFRESH_FIELD_NUMBER = 15;
        public static final int UNSUBSCRIBE_FIELD_NUMBER = 6;
        private int bitField0_;
        private ConnectRequest connect_;
        private HistoryRequest history_;
        private int id_;
        private PingRequest ping_;
        private PresenceStatsRequest presenceStats_;
        private PresenceRequest presence_;
        private PublishRequest publish_;
        private RefreshRequest refresh_;
        private RPCRequest rpc_;
        private SendRequest send_;
        private SubRefreshRequest subRefresh_;
        private SubscribeRequest subscribe_;
        private UnsubscribeRequest unsubscribe_;

        private Command() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public int getId() {
            return this.id_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(int i) {
            this.id_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.id_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public boolean hasConnect() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public ConnectRequest getConnect() {
            ConnectRequest connectRequest = this.connect_;
            return connectRequest == null ? ConnectRequest.getDefaultInstance() : connectRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setConnect(ConnectRequest connectRequest) {
            connectRequest.getClass();
            this.connect_ = connectRequest;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeConnect(ConnectRequest connectRequest) {
            connectRequest.getClass();
            ConnectRequest connectRequest2 = this.connect_;
            if (connectRequest2 != null && connectRequest2 != ConnectRequest.getDefaultInstance()) {
                this.connect_ = ConnectRequest.newBuilder(this.connect_).mergeFrom(connectRequest).buildPartial();
            } else {
                this.connect_ = connectRequest;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConnect() {
            this.connect_ = null;
            this.bitField0_ &= -2;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public boolean hasSubscribe() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public SubscribeRequest getSubscribe() {
            SubscribeRequest subscribeRequest = this.subscribe_;
            return subscribeRequest == null ? SubscribeRequest.getDefaultInstance() : subscribeRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSubscribe(SubscribeRequest subscribeRequest) {
            subscribeRequest.getClass();
            this.subscribe_ = subscribeRequest;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSubscribe(SubscribeRequest subscribeRequest) {
            subscribeRequest.getClass();
            SubscribeRequest subscribeRequest2 = this.subscribe_;
            if (subscribeRequest2 != null && subscribeRequest2 != SubscribeRequest.getDefaultInstance()) {
                this.subscribe_ = SubscribeRequest.newBuilder(this.subscribe_).mergeFrom(subscribeRequest).buildPartial();
            } else {
                this.subscribe_ = subscribeRequest;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSubscribe() {
            this.subscribe_ = null;
            this.bitField0_ &= -3;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public boolean hasUnsubscribe() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public UnsubscribeRequest getUnsubscribe() {
            UnsubscribeRequest unsubscribeRequest = this.unsubscribe_;
            return unsubscribeRequest == null ? UnsubscribeRequest.getDefaultInstance() : unsubscribeRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnsubscribe(UnsubscribeRequest unsubscribeRequest) {
            unsubscribeRequest.getClass();
            this.unsubscribe_ = unsubscribeRequest;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeUnsubscribe(UnsubscribeRequest unsubscribeRequest) {
            unsubscribeRequest.getClass();
            UnsubscribeRequest unsubscribeRequest2 = this.unsubscribe_;
            if (unsubscribeRequest2 != null && unsubscribeRequest2 != UnsubscribeRequest.getDefaultInstance()) {
                this.unsubscribe_ = UnsubscribeRequest.newBuilder(this.unsubscribe_).mergeFrom(unsubscribeRequest).buildPartial();
            } else {
                this.unsubscribe_ = unsubscribeRequest;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnsubscribe() {
            this.unsubscribe_ = null;
            this.bitField0_ &= -5;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public boolean hasPublish() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public PublishRequest getPublish() {
            PublishRequest publishRequest = this.publish_;
            return publishRequest == null ? PublishRequest.getDefaultInstance() : publishRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPublish(PublishRequest publishRequest) {
            publishRequest.getClass();
            this.publish_ = publishRequest;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePublish(PublishRequest publishRequest) {
            publishRequest.getClass();
            PublishRequest publishRequest2 = this.publish_;
            if (publishRequest2 != null && publishRequest2 != PublishRequest.getDefaultInstance()) {
                this.publish_ = PublishRequest.newBuilder(this.publish_).mergeFrom(publishRequest).buildPartial();
            } else {
                this.publish_ = publishRequest;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPublish() {
            this.publish_ = null;
            this.bitField0_ &= -9;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public boolean hasPresence() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public PresenceRequest getPresence() {
            PresenceRequest presenceRequest = this.presence_;
            return presenceRequest == null ? PresenceRequest.getDefaultInstance() : presenceRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPresence(PresenceRequest presenceRequest) {
            presenceRequest.getClass();
            this.presence_ = presenceRequest;
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePresence(PresenceRequest presenceRequest) {
            presenceRequest.getClass();
            PresenceRequest presenceRequest2 = this.presence_;
            if (presenceRequest2 != null && presenceRequest2 != PresenceRequest.getDefaultInstance()) {
                this.presence_ = PresenceRequest.newBuilder(this.presence_).mergeFrom(presenceRequest).buildPartial();
            } else {
                this.presence_ = presenceRequest;
            }
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPresence() {
            this.presence_ = null;
            this.bitField0_ &= -17;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public boolean hasPresenceStats() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public PresenceStatsRequest getPresenceStats() {
            PresenceStatsRequest presenceStatsRequest = this.presenceStats_;
            return presenceStatsRequest == null ? PresenceStatsRequest.getDefaultInstance() : presenceStatsRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPresenceStats(PresenceStatsRequest presenceStatsRequest) {
            presenceStatsRequest.getClass();
            this.presenceStats_ = presenceStatsRequest;
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePresenceStats(PresenceStatsRequest presenceStatsRequest) {
            presenceStatsRequest.getClass();
            PresenceStatsRequest presenceStatsRequest2 = this.presenceStats_;
            if (presenceStatsRequest2 != null && presenceStatsRequest2 != PresenceStatsRequest.getDefaultInstance()) {
                this.presenceStats_ = PresenceStatsRequest.newBuilder(this.presenceStats_).mergeFrom(presenceStatsRequest).buildPartial();
            } else {
                this.presenceStats_ = presenceStatsRequest;
            }
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPresenceStats() {
            this.presenceStats_ = null;
            this.bitField0_ &= -33;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public boolean hasHistory() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public HistoryRequest getHistory() {
            HistoryRequest historyRequest = this.history_;
            return historyRequest == null ? HistoryRequest.getDefaultInstance() : historyRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHistory(HistoryRequest historyRequest) {
            historyRequest.getClass();
            this.history_ = historyRequest;
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeHistory(HistoryRequest historyRequest) {
            historyRequest.getClass();
            HistoryRequest historyRequest2 = this.history_;
            if (historyRequest2 != null && historyRequest2 != HistoryRequest.getDefaultInstance()) {
                this.history_ = HistoryRequest.newBuilder(this.history_).mergeFrom(historyRequest).buildPartial();
            } else {
                this.history_ = historyRequest;
            }
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHistory() {
            this.history_ = null;
            this.bitField0_ &= -65;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public boolean hasPing() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public PingRequest getPing() {
            PingRequest pingRequest = this.ping_;
            return pingRequest == null ? PingRequest.getDefaultInstance() : pingRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPing(PingRequest pingRequest) {
            pingRequest.getClass();
            this.ping_ = pingRequest;
            this.bitField0_ |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePing(PingRequest pingRequest) {
            pingRequest.getClass();
            PingRequest pingRequest2 = this.ping_;
            if (pingRequest2 != null && pingRequest2 != PingRequest.getDefaultInstance()) {
                this.ping_ = PingRequest.newBuilder(this.ping_).mergeFrom(pingRequest).buildPartial();
            } else {
                this.ping_ = pingRequest;
            }
            this.bitField0_ |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPing() {
            this.ping_ = null;
            this.bitField0_ &= -129;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public boolean hasSend() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public SendRequest getSend() {
            SendRequest sendRequest = this.send_;
            return sendRequest == null ? SendRequest.getDefaultInstance() : sendRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSend(SendRequest sendRequest) {
            sendRequest.getClass();
            this.send_ = sendRequest;
            this.bitField0_ |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSend(SendRequest sendRequest) {
            sendRequest.getClass();
            SendRequest sendRequest2 = this.send_;
            if (sendRequest2 != null && sendRequest2 != SendRequest.getDefaultInstance()) {
                this.send_ = SendRequest.newBuilder(this.send_).mergeFrom(sendRequest).buildPartial();
            } else {
                this.send_ = sendRequest;
            }
            this.bitField0_ |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSend() {
            this.send_ = null;
            this.bitField0_ &= -257;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public boolean hasRpc() {
            return (this.bitField0_ & 512) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public RPCRequest getRpc() {
            RPCRequest rPCRequest = this.rpc_;
            return rPCRequest == null ? RPCRequest.getDefaultInstance() : rPCRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRpc(RPCRequest rPCRequest) {
            rPCRequest.getClass();
            this.rpc_ = rPCRequest;
            this.bitField0_ |= 512;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRpc(RPCRequest rPCRequest) {
            rPCRequest.getClass();
            RPCRequest rPCRequest2 = this.rpc_;
            if (rPCRequest2 != null && rPCRequest2 != RPCRequest.getDefaultInstance()) {
                this.rpc_ = RPCRequest.newBuilder(this.rpc_).mergeFrom(rPCRequest).buildPartial();
            } else {
                this.rpc_ = rPCRequest;
            }
            this.bitField0_ |= 512;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRpc() {
            this.rpc_ = null;
            this.bitField0_ &= -513;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public boolean hasRefresh() {
            return (this.bitField0_ & 1024) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public RefreshRequest getRefresh() {
            RefreshRequest refreshRequest = this.refresh_;
            return refreshRequest == null ? RefreshRequest.getDefaultInstance() : refreshRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRefresh(RefreshRequest refreshRequest) {
            refreshRequest.getClass();
            this.refresh_ = refreshRequest;
            this.bitField0_ |= 1024;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRefresh(RefreshRequest refreshRequest) {
            refreshRequest.getClass();
            RefreshRequest refreshRequest2 = this.refresh_;
            if (refreshRequest2 != null && refreshRequest2 != RefreshRequest.getDefaultInstance()) {
                this.refresh_ = RefreshRequest.newBuilder(this.refresh_).mergeFrom(refreshRequest).buildPartial();
            } else {
                this.refresh_ = refreshRequest;
            }
            this.bitField0_ |= 1024;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRefresh() {
            this.refresh_ = null;
            this.bitField0_ &= -1025;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public boolean hasSubRefresh() {
            return (this.bitField0_ & 2048) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
        public SubRefreshRequest getSubRefresh() {
            SubRefreshRequest subRefreshRequest = this.subRefresh_;
            return subRefreshRequest == null ? SubRefreshRequest.getDefaultInstance() : subRefreshRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSubRefresh(SubRefreshRequest subRefreshRequest) {
            subRefreshRequest.getClass();
            this.subRefresh_ = subRefreshRequest;
            this.bitField0_ |= 2048;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSubRefresh(SubRefreshRequest subRefreshRequest) {
            subRefreshRequest.getClass();
            SubRefreshRequest subRefreshRequest2 = this.subRefresh_;
            if (subRefreshRequest2 != null && subRefreshRequest2 != SubRefreshRequest.getDefaultInstance()) {
                this.subRefresh_ = SubRefreshRequest.newBuilder(this.subRefresh_).mergeFrom(subRefreshRequest).buildPartial();
            } else {
                this.subRefresh_ = subRefreshRequest;
            }
            this.bitField0_ |= 2048;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSubRefresh() {
            this.subRefresh_ = null;
            this.bitField0_ &= -2049;
        }

        public static Command parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Command parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Command parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Command parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Command parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Command parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Command parseFrom(InputStream inputStream) throws IOException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Command parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Command parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Command) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Command parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Command) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Command parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Command parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Command) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Command command) {
            return DEFAULT_INSTANCE.createBuilder(command);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Command, Builder> implements CommandOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Command.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public int getId() {
                return ((Command) this.instance).getId();
            }

            public Builder setId(int i) {
                copyOnWrite();
                ((Command) this.instance).setId(i);
                return this;
            }

            public Builder clearId() {
                copyOnWrite();
                ((Command) this.instance).clearId();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public boolean hasConnect() {
                return ((Command) this.instance).hasConnect();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public ConnectRequest getConnect() {
                return ((Command) this.instance).getConnect();
            }

            public Builder setConnect(ConnectRequest connectRequest) {
                copyOnWrite();
                ((Command) this.instance).setConnect(connectRequest);
                return this;
            }

            public Builder setConnect(ConnectRequest.Builder builder) {
                copyOnWrite();
                ((Command) this.instance).setConnect(builder.build());
                return this;
            }

            public Builder mergeConnect(ConnectRequest connectRequest) {
                copyOnWrite();
                ((Command) this.instance).mergeConnect(connectRequest);
                return this;
            }

            public Builder clearConnect() {
                copyOnWrite();
                ((Command) this.instance).clearConnect();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public boolean hasSubscribe() {
                return ((Command) this.instance).hasSubscribe();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public SubscribeRequest getSubscribe() {
                return ((Command) this.instance).getSubscribe();
            }

            public Builder setSubscribe(SubscribeRequest subscribeRequest) {
                copyOnWrite();
                ((Command) this.instance).setSubscribe(subscribeRequest);
                return this;
            }

            public Builder setSubscribe(SubscribeRequest.Builder builder) {
                copyOnWrite();
                ((Command) this.instance).setSubscribe(builder.build());
                return this;
            }

            public Builder mergeSubscribe(SubscribeRequest subscribeRequest) {
                copyOnWrite();
                ((Command) this.instance).mergeSubscribe(subscribeRequest);
                return this;
            }

            public Builder clearSubscribe() {
                copyOnWrite();
                ((Command) this.instance).clearSubscribe();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public boolean hasUnsubscribe() {
                return ((Command) this.instance).hasUnsubscribe();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public UnsubscribeRequest getUnsubscribe() {
                return ((Command) this.instance).getUnsubscribe();
            }

            public Builder setUnsubscribe(UnsubscribeRequest unsubscribeRequest) {
                copyOnWrite();
                ((Command) this.instance).setUnsubscribe(unsubscribeRequest);
                return this;
            }

            public Builder setUnsubscribe(UnsubscribeRequest.Builder builder) {
                copyOnWrite();
                ((Command) this.instance).setUnsubscribe(builder.build());
                return this;
            }

            public Builder mergeUnsubscribe(UnsubscribeRequest unsubscribeRequest) {
                copyOnWrite();
                ((Command) this.instance).mergeUnsubscribe(unsubscribeRequest);
                return this;
            }

            public Builder clearUnsubscribe() {
                copyOnWrite();
                ((Command) this.instance).clearUnsubscribe();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public boolean hasPublish() {
                return ((Command) this.instance).hasPublish();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public PublishRequest getPublish() {
                return ((Command) this.instance).getPublish();
            }

            public Builder setPublish(PublishRequest publishRequest) {
                copyOnWrite();
                ((Command) this.instance).setPublish(publishRequest);
                return this;
            }

            public Builder setPublish(PublishRequest.Builder builder) {
                copyOnWrite();
                ((Command) this.instance).setPublish(builder.build());
                return this;
            }

            public Builder mergePublish(PublishRequest publishRequest) {
                copyOnWrite();
                ((Command) this.instance).mergePublish(publishRequest);
                return this;
            }

            public Builder clearPublish() {
                copyOnWrite();
                ((Command) this.instance).clearPublish();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public boolean hasPresence() {
                return ((Command) this.instance).hasPresence();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public PresenceRequest getPresence() {
                return ((Command) this.instance).getPresence();
            }

            public Builder setPresence(PresenceRequest presenceRequest) {
                copyOnWrite();
                ((Command) this.instance).setPresence(presenceRequest);
                return this;
            }

            public Builder setPresence(PresenceRequest.Builder builder) {
                copyOnWrite();
                ((Command) this.instance).setPresence(builder.build());
                return this;
            }

            public Builder mergePresence(PresenceRequest presenceRequest) {
                copyOnWrite();
                ((Command) this.instance).mergePresence(presenceRequest);
                return this;
            }

            public Builder clearPresence() {
                copyOnWrite();
                ((Command) this.instance).clearPresence();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public boolean hasPresenceStats() {
                return ((Command) this.instance).hasPresenceStats();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public PresenceStatsRequest getPresenceStats() {
                return ((Command) this.instance).getPresenceStats();
            }

            public Builder setPresenceStats(PresenceStatsRequest presenceStatsRequest) {
                copyOnWrite();
                ((Command) this.instance).setPresenceStats(presenceStatsRequest);
                return this;
            }

            public Builder setPresenceStats(PresenceStatsRequest.Builder builder) {
                copyOnWrite();
                ((Command) this.instance).setPresenceStats(builder.build());
                return this;
            }

            public Builder mergePresenceStats(PresenceStatsRequest presenceStatsRequest) {
                copyOnWrite();
                ((Command) this.instance).mergePresenceStats(presenceStatsRequest);
                return this;
            }

            public Builder clearPresenceStats() {
                copyOnWrite();
                ((Command) this.instance).clearPresenceStats();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public boolean hasHistory() {
                return ((Command) this.instance).hasHistory();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public HistoryRequest getHistory() {
                return ((Command) this.instance).getHistory();
            }

            public Builder setHistory(HistoryRequest historyRequest) {
                copyOnWrite();
                ((Command) this.instance).setHistory(historyRequest);
                return this;
            }

            public Builder setHistory(HistoryRequest.Builder builder) {
                copyOnWrite();
                ((Command) this.instance).setHistory(builder.build());
                return this;
            }

            public Builder mergeHistory(HistoryRequest historyRequest) {
                copyOnWrite();
                ((Command) this.instance).mergeHistory(historyRequest);
                return this;
            }

            public Builder clearHistory() {
                copyOnWrite();
                ((Command) this.instance).clearHistory();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public boolean hasPing() {
                return ((Command) this.instance).hasPing();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public PingRequest getPing() {
                return ((Command) this.instance).getPing();
            }

            public Builder setPing(PingRequest pingRequest) {
                copyOnWrite();
                ((Command) this.instance).setPing(pingRequest);
                return this;
            }

            public Builder setPing(PingRequest.Builder builder) {
                copyOnWrite();
                ((Command) this.instance).setPing(builder.build());
                return this;
            }

            public Builder mergePing(PingRequest pingRequest) {
                copyOnWrite();
                ((Command) this.instance).mergePing(pingRequest);
                return this;
            }

            public Builder clearPing() {
                copyOnWrite();
                ((Command) this.instance).clearPing();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public boolean hasSend() {
                return ((Command) this.instance).hasSend();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public SendRequest getSend() {
                return ((Command) this.instance).getSend();
            }

            public Builder setSend(SendRequest sendRequest) {
                copyOnWrite();
                ((Command) this.instance).setSend(sendRequest);
                return this;
            }

            public Builder setSend(SendRequest.Builder builder) {
                copyOnWrite();
                ((Command) this.instance).setSend(builder.build());
                return this;
            }

            public Builder mergeSend(SendRequest sendRequest) {
                copyOnWrite();
                ((Command) this.instance).mergeSend(sendRequest);
                return this;
            }

            public Builder clearSend() {
                copyOnWrite();
                ((Command) this.instance).clearSend();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public boolean hasRpc() {
                return ((Command) this.instance).hasRpc();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public RPCRequest getRpc() {
                return ((Command) this.instance).getRpc();
            }

            public Builder setRpc(RPCRequest rPCRequest) {
                copyOnWrite();
                ((Command) this.instance).setRpc(rPCRequest);
                return this;
            }

            public Builder setRpc(RPCRequest.Builder builder) {
                copyOnWrite();
                ((Command) this.instance).setRpc(builder.build());
                return this;
            }

            public Builder mergeRpc(RPCRequest rPCRequest) {
                copyOnWrite();
                ((Command) this.instance).mergeRpc(rPCRequest);
                return this;
            }

            public Builder clearRpc() {
                copyOnWrite();
                ((Command) this.instance).clearRpc();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public boolean hasRefresh() {
                return ((Command) this.instance).hasRefresh();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public RefreshRequest getRefresh() {
                return ((Command) this.instance).getRefresh();
            }

            public Builder setRefresh(RefreshRequest refreshRequest) {
                copyOnWrite();
                ((Command) this.instance).setRefresh(refreshRequest);
                return this;
            }

            public Builder setRefresh(RefreshRequest.Builder builder) {
                copyOnWrite();
                ((Command) this.instance).setRefresh(builder.build());
                return this;
            }

            public Builder mergeRefresh(RefreshRequest refreshRequest) {
                copyOnWrite();
                ((Command) this.instance).mergeRefresh(refreshRequest);
                return this;
            }

            public Builder clearRefresh() {
                copyOnWrite();
                ((Command) this.instance).clearRefresh();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public boolean hasSubRefresh() {
                return ((Command) this.instance).hasSubRefresh();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.CommandOrBuilder
            public SubRefreshRequest getSubRefresh() {
                return ((Command) this.instance).getSubRefresh();
            }

            public Builder setSubRefresh(SubRefreshRequest subRefreshRequest) {
                copyOnWrite();
                ((Command) this.instance).setSubRefresh(subRefreshRequest);
                return this;
            }

            public Builder setSubRefresh(SubRefreshRequest.Builder builder) {
                copyOnWrite();
                ((Command) this.instance).setSubRefresh(builder.build());
                return this;
            }

            public Builder mergeSubRefresh(SubRefreshRequest subRefreshRequest) {
                copyOnWrite();
                ((Command) this.instance).mergeSubRefresh(subRefreshRequest);
                return this;
            }

            public Builder clearSubRefresh() {
                copyOnWrite();
                ((Command) this.instance).clearSubRefresh();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Command();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\r\u0000\u0001\u0001\u000f\r\u0000\u0000\u0000\u0001\u000b\u0004ဉ\u0000\u0005ဉ\u0001\u0006ဉ\u0002\u0007ဉ\u0003\bဉ\u0004\tဉ\u0005\nဉ\u0006\u000bဉ\u0007\fဉ\b\rဉ\t\u000eဉ\n\u000fဉ\u000b", new Object[]{"bitField0_", "id_", "connect_", "subscribe_", "unsubscribe_", "publish_", "presence_", "presenceStats_", "history_", "ping_", "send_", "rpc_", "refresh_", "subRefresh_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Command> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Command.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Command command = new Command();
            DEFAULT_INSTANCE = command;
            GeneratedMessageLite.registerDefaultInstance(Command.class, command);
        }

        public static Command getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Command> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Reply extends GeneratedMessageLite<Reply, Builder> implements ReplyOrBuilder {
        public static final int CONNECT_FIELD_NUMBER = 5;
        private static final Reply DEFAULT_INSTANCE;
        public static final int ERROR_FIELD_NUMBER = 2;
        public static final int HISTORY_FIELD_NUMBER = 11;
        public static final int ID_FIELD_NUMBER = 1;
        private static volatile Parser<Reply> PARSER = null;
        public static final int PING_FIELD_NUMBER = 12;
        public static final int PRESENCE_FIELD_NUMBER = 9;
        public static final int PRESENCE_STATS_FIELD_NUMBER = 10;
        public static final int PUBLISH_FIELD_NUMBER = 8;
        public static final int PUSH_FIELD_NUMBER = 4;
        public static final int REFRESH_FIELD_NUMBER = 14;
        public static final int RPC_FIELD_NUMBER = 13;
        public static final int SUBSCRIBE_FIELD_NUMBER = 6;
        public static final int SUB_REFRESH_FIELD_NUMBER = 15;
        public static final int UNSUBSCRIBE_FIELD_NUMBER = 7;
        private int bitField0_;
        private ConnectResult connect_;
        private Error error_;
        private HistoryResult history_;
        private int id_;
        private PingResult ping_;
        private PresenceStatsResult presenceStats_;
        private PresenceResult presence_;
        private PublishResult publish_;
        private Push push_;
        private RefreshResult refresh_;
        private RPCResult rpc_;
        private SubRefreshResult subRefresh_;
        private SubscribeResult subscribe_;
        private UnsubscribeResult unsubscribe_;

        private Reply() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public int getId() {
            return this.id_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(int i) {
            this.id_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.id_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public boolean hasError() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public Error getError() {
            Error error = this.error_;
            return error == null ? Error.getDefaultInstance() : error;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setError(Error error) {
            error.getClass();
            this.error_ = error;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeError(Error error) {
            error.getClass();
            Error error2 = this.error_;
            if (error2 != null && error2 != Error.getDefaultInstance()) {
                this.error_ = Error.newBuilder(this.error_).mergeFrom(error).buildPartial();
            } else {
                this.error_ = error;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearError() {
            this.error_ = null;
            this.bitField0_ &= -2;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public boolean hasPush() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public Push getPush() {
            Push push = this.push_;
            return push == null ? Push.getDefaultInstance() : push;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPush(Push push) {
            push.getClass();
            this.push_ = push;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePush(Push push) {
            push.getClass();
            Push push2 = this.push_;
            if (push2 != null && push2 != Push.getDefaultInstance()) {
                this.push_ = Push.newBuilder(this.push_).mergeFrom(push).buildPartial();
            } else {
                this.push_ = push;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPush() {
            this.push_ = null;
            this.bitField0_ &= -3;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public boolean hasConnect() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public ConnectResult getConnect() {
            ConnectResult connectResult = this.connect_;
            return connectResult == null ? ConnectResult.getDefaultInstance() : connectResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setConnect(ConnectResult connectResult) {
            connectResult.getClass();
            this.connect_ = connectResult;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeConnect(ConnectResult connectResult) {
            connectResult.getClass();
            ConnectResult connectResult2 = this.connect_;
            if (connectResult2 != null && connectResult2 != ConnectResult.getDefaultInstance()) {
                this.connect_ = ConnectResult.newBuilder(this.connect_).mergeFrom(connectResult).buildPartial();
            } else {
                this.connect_ = connectResult;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConnect() {
            this.connect_ = null;
            this.bitField0_ &= -5;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public boolean hasSubscribe() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public SubscribeResult getSubscribe() {
            SubscribeResult subscribeResult = this.subscribe_;
            return subscribeResult == null ? SubscribeResult.getDefaultInstance() : subscribeResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSubscribe(SubscribeResult subscribeResult) {
            subscribeResult.getClass();
            this.subscribe_ = subscribeResult;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSubscribe(SubscribeResult subscribeResult) {
            subscribeResult.getClass();
            SubscribeResult subscribeResult2 = this.subscribe_;
            if (subscribeResult2 != null && subscribeResult2 != SubscribeResult.getDefaultInstance()) {
                this.subscribe_ = SubscribeResult.newBuilder(this.subscribe_).mergeFrom(subscribeResult).buildPartial();
            } else {
                this.subscribe_ = subscribeResult;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSubscribe() {
            this.subscribe_ = null;
            this.bitField0_ &= -9;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public boolean hasUnsubscribe() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public UnsubscribeResult getUnsubscribe() {
            UnsubscribeResult unsubscribeResult = this.unsubscribe_;
            return unsubscribeResult == null ? UnsubscribeResult.getDefaultInstance() : unsubscribeResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnsubscribe(UnsubscribeResult unsubscribeResult) {
            unsubscribeResult.getClass();
            this.unsubscribe_ = unsubscribeResult;
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeUnsubscribe(UnsubscribeResult unsubscribeResult) {
            unsubscribeResult.getClass();
            UnsubscribeResult unsubscribeResult2 = this.unsubscribe_;
            if (unsubscribeResult2 != null && unsubscribeResult2 != UnsubscribeResult.getDefaultInstance()) {
                this.unsubscribe_ = UnsubscribeResult.newBuilder(this.unsubscribe_).mergeFrom(unsubscribeResult).buildPartial();
            } else {
                this.unsubscribe_ = unsubscribeResult;
            }
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnsubscribe() {
            this.unsubscribe_ = null;
            this.bitField0_ &= -17;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public boolean hasPublish() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public PublishResult getPublish() {
            PublishResult publishResult = this.publish_;
            return publishResult == null ? PublishResult.getDefaultInstance() : publishResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPublish(PublishResult publishResult) {
            publishResult.getClass();
            this.publish_ = publishResult;
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePublish(PublishResult publishResult) {
            publishResult.getClass();
            PublishResult publishResult2 = this.publish_;
            if (publishResult2 != null && publishResult2 != PublishResult.getDefaultInstance()) {
                this.publish_ = PublishResult.newBuilder(this.publish_).mergeFrom(publishResult).buildPartial();
            } else {
                this.publish_ = publishResult;
            }
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPublish() {
            this.publish_ = null;
            this.bitField0_ &= -33;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public boolean hasPresence() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public PresenceResult getPresence() {
            PresenceResult presenceResult = this.presence_;
            return presenceResult == null ? PresenceResult.getDefaultInstance() : presenceResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPresence(PresenceResult presenceResult) {
            presenceResult.getClass();
            this.presence_ = presenceResult;
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePresence(PresenceResult presenceResult) {
            presenceResult.getClass();
            PresenceResult presenceResult2 = this.presence_;
            if (presenceResult2 != null && presenceResult2 != PresenceResult.getDefaultInstance()) {
                this.presence_ = PresenceResult.newBuilder(this.presence_).mergeFrom(presenceResult).buildPartial();
            } else {
                this.presence_ = presenceResult;
            }
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPresence() {
            this.presence_ = null;
            this.bitField0_ &= -65;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public boolean hasPresenceStats() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public PresenceStatsResult getPresenceStats() {
            PresenceStatsResult presenceStatsResult = this.presenceStats_;
            return presenceStatsResult == null ? PresenceStatsResult.getDefaultInstance() : presenceStatsResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPresenceStats(PresenceStatsResult presenceStatsResult) {
            presenceStatsResult.getClass();
            this.presenceStats_ = presenceStatsResult;
            this.bitField0_ |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePresenceStats(PresenceStatsResult presenceStatsResult) {
            presenceStatsResult.getClass();
            PresenceStatsResult presenceStatsResult2 = this.presenceStats_;
            if (presenceStatsResult2 != null && presenceStatsResult2 != PresenceStatsResult.getDefaultInstance()) {
                this.presenceStats_ = PresenceStatsResult.newBuilder(this.presenceStats_).mergeFrom(presenceStatsResult).buildPartial();
            } else {
                this.presenceStats_ = presenceStatsResult;
            }
            this.bitField0_ |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPresenceStats() {
            this.presenceStats_ = null;
            this.bitField0_ &= -129;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public boolean hasHistory() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public HistoryResult getHistory() {
            HistoryResult historyResult = this.history_;
            return historyResult == null ? HistoryResult.getDefaultInstance() : historyResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHistory(HistoryResult historyResult) {
            historyResult.getClass();
            this.history_ = historyResult;
            this.bitField0_ |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeHistory(HistoryResult historyResult) {
            historyResult.getClass();
            HistoryResult historyResult2 = this.history_;
            if (historyResult2 != null && historyResult2 != HistoryResult.getDefaultInstance()) {
                this.history_ = HistoryResult.newBuilder(this.history_).mergeFrom(historyResult).buildPartial();
            } else {
                this.history_ = historyResult;
            }
            this.bitField0_ |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHistory() {
            this.history_ = null;
            this.bitField0_ &= -257;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public boolean hasPing() {
            return (this.bitField0_ & 512) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public PingResult getPing() {
            PingResult pingResult = this.ping_;
            return pingResult == null ? PingResult.getDefaultInstance() : pingResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPing(PingResult pingResult) {
            pingResult.getClass();
            this.ping_ = pingResult;
            this.bitField0_ |= 512;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePing(PingResult pingResult) {
            pingResult.getClass();
            PingResult pingResult2 = this.ping_;
            if (pingResult2 != null && pingResult2 != PingResult.getDefaultInstance()) {
                this.ping_ = PingResult.newBuilder(this.ping_).mergeFrom(pingResult).buildPartial();
            } else {
                this.ping_ = pingResult;
            }
            this.bitField0_ |= 512;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPing() {
            this.ping_ = null;
            this.bitField0_ &= -513;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public boolean hasRpc() {
            return (this.bitField0_ & 1024) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public RPCResult getRpc() {
            RPCResult rPCResult = this.rpc_;
            return rPCResult == null ? RPCResult.getDefaultInstance() : rPCResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRpc(RPCResult rPCResult) {
            rPCResult.getClass();
            this.rpc_ = rPCResult;
            this.bitField0_ |= 1024;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRpc(RPCResult rPCResult) {
            rPCResult.getClass();
            RPCResult rPCResult2 = this.rpc_;
            if (rPCResult2 != null && rPCResult2 != RPCResult.getDefaultInstance()) {
                this.rpc_ = RPCResult.newBuilder(this.rpc_).mergeFrom(rPCResult).buildPartial();
            } else {
                this.rpc_ = rPCResult;
            }
            this.bitField0_ |= 1024;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRpc() {
            this.rpc_ = null;
            this.bitField0_ &= -1025;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public boolean hasRefresh() {
            return (this.bitField0_ & 2048) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public RefreshResult getRefresh() {
            RefreshResult refreshResult = this.refresh_;
            return refreshResult == null ? RefreshResult.getDefaultInstance() : refreshResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRefresh(RefreshResult refreshResult) {
            refreshResult.getClass();
            this.refresh_ = refreshResult;
            this.bitField0_ |= 2048;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRefresh(RefreshResult refreshResult) {
            refreshResult.getClass();
            RefreshResult refreshResult2 = this.refresh_;
            if (refreshResult2 != null && refreshResult2 != RefreshResult.getDefaultInstance()) {
                this.refresh_ = RefreshResult.newBuilder(this.refresh_).mergeFrom(refreshResult).buildPartial();
            } else {
                this.refresh_ = refreshResult;
            }
            this.bitField0_ |= 2048;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRefresh() {
            this.refresh_ = null;
            this.bitField0_ &= -2049;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public boolean hasSubRefresh() {
            return (this.bitField0_ & 4096) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
        public SubRefreshResult getSubRefresh() {
            SubRefreshResult subRefreshResult = this.subRefresh_;
            return subRefreshResult == null ? SubRefreshResult.getDefaultInstance() : subRefreshResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSubRefresh(SubRefreshResult subRefreshResult) {
            subRefreshResult.getClass();
            this.subRefresh_ = subRefreshResult;
            this.bitField0_ |= 4096;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSubRefresh(SubRefreshResult subRefreshResult) {
            subRefreshResult.getClass();
            SubRefreshResult subRefreshResult2 = this.subRefresh_;
            if (subRefreshResult2 != null && subRefreshResult2 != SubRefreshResult.getDefaultInstance()) {
                this.subRefresh_ = SubRefreshResult.newBuilder(this.subRefresh_).mergeFrom(subRefreshResult).buildPartial();
            } else {
                this.subRefresh_ = subRefreshResult;
            }
            this.bitField0_ |= 4096;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSubRefresh() {
            this.subRefresh_ = null;
            this.bitField0_ &= -4097;
        }

        public static Reply parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Reply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Reply parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Reply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Reply parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Reply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Reply parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Reply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Reply parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Reply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Reply parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Reply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Reply parseFrom(InputStream inputStream) throws IOException {
            return (Reply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Reply parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Reply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Reply parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Reply) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Reply parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Reply) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Reply parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Reply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Reply parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Reply) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Reply reply) {
            return DEFAULT_INSTANCE.createBuilder(reply);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Reply, Builder> implements ReplyOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Reply.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public int getId() {
                return ((Reply) this.instance).getId();
            }

            public Builder setId(int i) {
                copyOnWrite();
                ((Reply) this.instance).setId(i);
                return this;
            }

            public Builder clearId() {
                copyOnWrite();
                ((Reply) this.instance).clearId();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public boolean hasError() {
                return ((Reply) this.instance).hasError();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public Error getError() {
                return ((Reply) this.instance).getError();
            }

            public Builder setError(Error error) {
                copyOnWrite();
                ((Reply) this.instance).setError(error);
                return this;
            }

            public Builder setError(Error.Builder builder) {
                copyOnWrite();
                ((Reply) this.instance).setError(builder.build());
                return this;
            }

            public Builder mergeError(Error error) {
                copyOnWrite();
                ((Reply) this.instance).mergeError(error);
                return this;
            }

            public Builder clearError() {
                copyOnWrite();
                ((Reply) this.instance).clearError();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public boolean hasPush() {
                return ((Reply) this.instance).hasPush();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public Push getPush() {
                return ((Reply) this.instance).getPush();
            }

            public Builder setPush(Push push) {
                copyOnWrite();
                ((Reply) this.instance).setPush(push);
                return this;
            }

            public Builder setPush(Push.Builder builder) {
                copyOnWrite();
                ((Reply) this.instance).setPush(builder.build());
                return this;
            }

            public Builder mergePush(Push push) {
                copyOnWrite();
                ((Reply) this.instance).mergePush(push);
                return this;
            }

            public Builder clearPush() {
                copyOnWrite();
                ((Reply) this.instance).clearPush();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public boolean hasConnect() {
                return ((Reply) this.instance).hasConnect();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public ConnectResult getConnect() {
                return ((Reply) this.instance).getConnect();
            }

            public Builder setConnect(ConnectResult connectResult) {
                copyOnWrite();
                ((Reply) this.instance).setConnect(connectResult);
                return this;
            }

            public Builder setConnect(ConnectResult.Builder builder) {
                copyOnWrite();
                ((Reply) this.instance).setConnect(builder.build());
                return this;
            }

            public Builder mergeConnect(ConnectResult connectResult) {
                copyOnWrite();
                ((Reply) this.instance).mergeConnect(connectResult);
                return this;
            }

            public Builder clearConnect() {
                copyOnWrite();
                ((Reply) this.instance).clearConnect();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public boolean hasSubscribe() {
                return ((Reply) this.instance).hasSubscribe();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public SubscribeResult getSubscribe() {
                return ((Reply) this.instance).getSubscribe();
            }

            public Builder setSubscribe(SubscribeResult subscribeResult) {
                copyOnWrite();
                ((Reply) this.instance).setSubscribe(subscribeResult);
                return this;
            }

            public Builder setSubscribe(SubscribeResult.Builder builder) {
                copyOnWrite();
                ((Reply) this.instance).setSubscribe(builder.build());
                return this;
            }

            public Builder mergeSubscribe(SubscribeResult subscribeResult) {
                copyOnWrite();
                ((Reply) this.instance).mergeSubscribe(subscribeResult);
                return this;
            }

            public Builder clearSubscribe() {
                copyOnWrite();
                ((Reply) this.instance).clearSubscribe();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public boolean hasUnsubscribe() {
                return ((Reply) this.instance).hasUnsubscribe();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public UnsubscribeResult getUnsubscribe() {
                return ((Reply) this.instance).getUnsubscribe();
            }

            public Builder setUnsubscribe(UnsubscribeResult unsubscribeResult) {
                copyOnWrite();
                ((Reply) this.instance).setUnsubscribe(unsubscribeResult);
                return this;
            }

            public Builder setUnsubscribe(UnsubscribeResult.Builder builder) {
                copyOnWrite();
                ((Reply) this.instance).setUnsubscribe(builder.build());
                return this;
            }

            public Builder mergeUnsubscribe(UnsubscribeResult unsubscribeResult) {
                copyOnWrite();
                ((Reply) this.instance).mergeUnsubscribe(unsubscribeResult);
                return this;
            }

            public Builder clearUnsubscribe() {
                copyOnWrite();
                ((Reply) this.instance).clearUnsubscribe();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public boolean hasPublish() {
                return ((Reply) this.instance).hasPublish();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public PublishResult getPublish() {
                return ((Reply) this.instance).getPublish();
            }

            public Builder setPublish(PublishResult publishResult) {
                copyOnWrite();
                ((Reply) this.instance).setPublish(publishResult);
                return this;
            }

            public Builder setPublish(PublishResult.Builder builder) {
                copyOnWrite();
                ((Reply) this.instance).setPublish(builder.build());
                return this;
            }

            public Builder mergePublish(PublishResult publishResult) {
                copyOnWrite();
                ((Reply) this.instance).mergePublish(publishResult);
                return this;
            }

            public Builder clearPublish() {
                copyOnWrite();
                ((Reply) this.instance).clearPublish();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public boolean hasPresence() {
                return ((Reply) this.instance).hasPresence();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public PresenceResult getPresence() {
                return ((Reply) this.instance).getPresence();
            }

            public Builder setPresence(PresenceResult presenceResult) {
                copyOnWrite();
                ((Reply) this.instance).setPresence(presenceResult);
                return this;
            }

            public Builder setPresence(PresenceResult.Builder builder) {
                copyOnWrite();
                ((Reply) this.instance).setPresence(builder.build());
                return this;
            }

            public Builder mergePresence(PresenceResult presenceResult) {
                copyOnWrite();
                ((Reply) this.instance).mergePresence(presenceResult);
                return this;
            }

            public Builder clearPresence() {
                copyOnWrite();
                ((Reply) this.instance).clearPresence();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public boolean hasPresenceStats() {
                return ((Reply) this.instance).hasPresenceStats();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public PresenceStatsResult getPresenceStats() {
                return ((Reply) this.instance).getPresenceStats();
            }

            public Builder setPresenceStats(PresenceStatsResult presenceStatsResult) {
                copyOnWrite();
                ((Reply) this.instance).setPresenceStats(presenceStatsResult);
                return this;
            }

            public Builder setPresenceStats(PresenceStatsResult.Builder builder) {
                copyOnWrite();
                ((Reply) this.instance).setPresenceStats(builder.build());
                return this;
            }

            public Builder mergePresenceStats(PresenceStatsResult presenceStatsResult) {
                copyOnWrite();
                ((Reply) this.instance).mergePresenceStats(presenceStatsResult);
                return this;
            }

            public Builder clearPresenceStats() {
                copyOnWrite();
                ((Reply) this.instance).clearPresenceStats();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public boolean hasHistory() {
                return ((Reply) this.instance).hasHistory();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public HistoryResult getHistory() {
                return ((Reply) this.instance).getHistory();
            }

            public Builder setHistory(HistoryResult historyResult) {
                copyOnWrite();
                ((Reply) this.instance).setHistory(historyResult);
                return this;
            }

            public Builder setHistory(HistoryResult.Builder builder) {
                copyOnWrite();
                ((Reply) this.instance).setHistory(builder.build());
                return this;
            }

            public Builder mergeHistory(HistoryResult historyResult) {
                copyOnWrite();
                ((Reply) this.instance).mergeHistory(historyResult);
                return this;
            }

            public Builder clearHistory() {
                copyOnWrite();
                ((Reply) this.instance).clearHistory();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public boolean hasPing() {
                return ((Reply) this.instance).hasPing();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public PingResult getPing() {
                return ((Reply) this.instance).getPing();
            }

            public Builder setPing(PingResult pingResult) {
                copyOnWrite();
                ((Reply) this.instance).setPing(pingResult);
                return this;
            }

            public Builder setPing(PingResult.Builder builder) {
                copyOnWrite();
                ((Reply) this.instance).setPing(builder.build());
                return this;
            }

            public Builder mergePing(PingResult pingResult) {
                copyOnWrite();
                ((Reply) this.instance).mergePing(pingResult);
                return this;
            }

            public Builder clearPing() {
                copyOnWrite();
                ((Reply) this.instance).clearPing();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public boolean hasRpc() {
                return ((Reply) this.instance).hasRpc();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public RPCResult getRpc() {
                return ((Reply) this.instance).getRpc();
            }

            public Builder setRpc(RPCResult rPCResult) {
                copyOnWrite();
                ((Reply) this.instance).setRpc(rPCResult);
                return this;
            }

            public Builder setRpc(RPCResult.Builder builder) {
                copyOnWrite();
                ((Reply) this.instance).setRpc(builder.build());
                return this;
            }

            public Builder mergeRpc(RPCResult rPCResult) {
                copyOnWrite();
                ((Reply) this.instance).mergeRpc(rPCResult);
                return this;
            }

            public Builder clearRpc() {
                copyOnWrite();
                ((Reply) this.instance).clearRpc();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public boolean hasRefresh() {
                return ((Reply) this.instance).hasRefresh();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public RefreshResult getRefresh() {
                return ((Reply) this.instance).getRefresh();
            }

            public Builder setRefresh(RefreshResult refreshResult) {
                copyOnWrite();
                ((Reply) this.instance).setRefresh(refreshResult);
                return this;
            }

            public Builder setRefresh(RefreshResult.Builder builder) {
                copyOnWrite();
                ((Reply) this.instance).setRefresh(builder.build());
                return this;
            }

            public Builder mergeRefresh(RefreshResult refreshResult) {
                copyOnWrite();
                ((Reply) this.instance).mergeRefresh(refreshResult);
                return this;
            }

            public Builder clearRefresh() {
                copyOnWrite();
                ((Reply) this.instance).clearRefresh();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public boolean hasSubRefresh() {
                return ((Reply) this.instance).hasSubRefresh();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ReplyOrBuilder
            public SubRefreshResult getSubRefresh() {
                return ((Reply) this.instance).getSubRefresh();
            }

            public Builder setSubRefresh(SubRefreshResult subRefreshResult) {
                copyOnWrite();
                ((Reply) this.instance).setSubRefresh(subRefreshResult);
                return this;
            }

            public Builder setSubRefresh(SubRefreshResult.Builder builder) {
                copyOnWrite();
                ((Reply) this.instance).setSubRefresh(builder.build());
                return this;
            }

            public Builder mergeSubRefresh(SubRefreshResult subRefreshResult) {
                copyOnWrite();
                ((Reply) this.instance).mergeSubRefresh(subRefreshResult);
                return this;
            }

            public Builder clearSubRefresh() {
                copyOnWrite();
                ((Reply) this.instance).clearSubRefresh();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Reply();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000e\u0000\u0001\u0001\u000f\u000e\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0004ဉ\u0001\u0005ဉ\u0002\u0006ဉ\u0003\u0007ဉ\u0004\bဉ\u0005\tဉ\u0006\nဉ\u0007\u000bဉ\b\fဉ\t\rဉ\n\u000eဉ\u000b\u000fဉ\f", new Object[]{"bitField0_", "id_", "error_", "push_", "connect_", "subscribe_", "unsubscribe_", "publish_", "presence_", "presenceStats_", "history_", "ping_", "rpc_", "refresh_", "subRefresh_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Reply> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Reply.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Reply reply = new Reply();
            DEFAULT_INSTANCE = reply;
            GeneratedMessageLite.registerDefaultInstance(Reply.class, reply);
        }

        public static Reply getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Reply> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Push extends GeneratedMessageLite<Push, Builder> implements PushOrBuilder {
        public static final int CHANNEL_FIELD_NUMBER = 2;
        public static final int CONNECT_FIELD_NUMBER = 10;
        private static final Push DEFAULT_INSTANCE;
        public static final int DISCONNECT_FIELD_NUMBER = 11;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int JOIN_FIELD_NUMBER = 5;
        public static final int LEAVE_FIELD_NUMBER = 6;
        public static final int MESSAGE_FIELD_NUMBER = 8;
        private static volatile Parser<Push> PARSER = null;
        public static final int PUB_FIELD_NUMBER = 4;
        public static final int REFRESH_FIELD_NUMBER = 12;
        public static final int SUBSCRIBE_FIELD_NUMBER = 9;
        public static final int UNSUBSCRIBE_FIELD_NUMBER = 7;
        private int bitField0_;
        private String channel_ = "";
        private Connect connect_;
        private Disconnect disconnect_;
        private long id_;
        private Join join_;
        private Leave leave_;
        private Message message_;
        private Publication pub_;
        private Refresh refresh_;
        private Subscribe subscribe_;
        private Unsubscribe unsubscribe_;

        private Push() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public long getId() {
            return this.id_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(long j) {
            this.id_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.id_ = 0L;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public String getChannel() {
            return this.channel_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public ByteString getChannelBytes() {
            return ByteString.copyFromUtf8(this.channel_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannel(String str) {
            str.getClass();
            this.channel_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannel() {
            this.channel_ = getDefaultInstance().getChannel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.channel_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public boolean hasPub() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public Publication getPub() {
            Publication publication = this.pub_;
            return publication == null ? Publication.getDefaultInstance() : publication;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPub(Publication publication) {
            publication.getClass();
            this.pub_ = publication;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePub(Publication publication) {
            publication.getClass();
            Publication publication2 = this.pub_;
            if (publication2 != null && publication2 != Publication.getDefaultInstance()) {
                this.pub_ = Publication.newBuilder(this.pub_).mergeFrom(publication).buildPartial();
            } else {
                this.pub_ = publication;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPub() {
            this.pub_ = null;
            this.bitField0_ &= -2;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public boolean hasJoin() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public Join getJoin() {
            Join join = this.join_;
            return join == null ? Join.getDefaultInstance() : join;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJoin(Join join) {
            join.getClass();
            this.join_ = join;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeJoin(Join join) {
            join.getClass();
            Join join2 = this.join_;
            if (join2 != null && join2 != Join.getDefaultInstance()) {
                this.join_ = Join.newBuilder(this.join_).mergeFrom(join).buildPartial();
            } else {
                this.join_ = join;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearJoin() {
            this.join_ = null;
            this.bitField0_ &= -3;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public boolean hasLeave() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public Leave getLeave() {
            Leave leave = this.leave_;
            return leave == null ? Leave.getDefaultInstance() : leave;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLeave(Leave leave) {
            leave.getClass();
            this.leave_ = leave;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeLeave(Leave leave) {
            leave.getClass();
            Leave leave2 = this.leave_;
            if (leave2 != null && leave2 != Leave.getDefaultInstance()) {
                this.leave_ = Leave.newBuilder(this.leave_).mergeFrom(leave).buildPartial();
            } else {
                this.leave_ = leave;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLeave() {
            this.leave_ = null;
            this.bitField0_ &= -5;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public boolean hasUnsubscribe() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public Unsubscribe getUnsubscribe() {
            Unsubscribe unsubscribe = this.unsubscribe_;
            return unsubscribe == null ? Unsubscribe.getDefaultInstance() : unsubscribe;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnsubscribe(Unsubscribe unsubscribe) {
            unsubscribe.getClass();
            this.unsubscribe_ = unsubscribe;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeUnsubscribe(Unsubscribe unsubscribe) {
            unsubscribe.getClass();
            Unsubscribe unsubscribe2 = this.unsubscribe_;
            if (unsubscribe2 != null && unsubscribe2 != Unsubscribe.getDefaultInstance()) {
                this.unsubscribe_ = Unsubscribe.newBuilder(this.unsubscribe_).mergeFrom(unsubscribe).buildPartial();
            } else {
                this.unsubscribe_ = unsubscribe;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnsubscribe() {
            this.unsubscribe_ = null;
            this.bitField0_ &= -9;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public boolean hasMessage() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public Message getMessage() {
            Message message = this.message_;
            return message == null ? Message.getDefaultInstance() : message;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessage(Message message) {
            message.getClass();
            this.message_ = message;
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMessage(Message message) {
            message.getClass();
            Message message2 = this.message_;
            if (message2 != null && message2 != Message.getDefaultInstance()) {
                this.message_ = Message.newBuilder(this.message_).mergeFrom(message).buildPartial();
            } else {
                this.message_ = message;
            }
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMessage() {
            this.message_ = null;
            this.bitField0_ &= -17;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public boolean hasSubscribe() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public Subscribe getSubscribe() {
            Subscribe subscribe = this.subscribe_;
            return subscribe == null ? Subscribe.getDefaultInstance() : subscribe;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSubscribe(Subscribe subscribe) {
            subscribe.getClass();
            this.subscribe_ = subscribe;
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSubscribe(Subscribe subscribe) {
            subscribe.getClass();
            Subscribe subscribe2 = this.subscribe_;
            if (subscribe2 != null && subscribe2 != Subscribe.getDefaultInstance()) {
                this.subscribe_ = Subscribe.newBuilder(this.subscribe_).mergeFrom(subscribe).buildPartial();
            } else {
                this.subscribe_ = subscribe;
            }
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSubscribe() {
            this.subscribe_ = null;
            this.bitField0_ &= -33;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public boolean hasConnect() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public Connect getConnect() {
            Connect connect = this.connect_;
            return connect == null ? Connect.getDefaultInstance() : connect;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setConnect(Connect connect) {
            connect.getClass();
            this.connect_ = connect;
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeConnect(Connect connect) {
            connect.getClass();
            Connect connect2 = this.connect_;
            if (connect2 != null && connect2 != Connect.getDefaultInstance()) {
                this.connect_ = Connect.newBuilder(this.connect_).mergeFrom(connect).buildPartial();
            } else {
                this.connect_ = connect;
            }
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConnect() {
            this.connect_ = null;
            this.bitField0_ &= -65;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public boolean hasDisconnect() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public Disconnect getDisconnect() {
            Disconnect disconnect = this.disconnect_;
            return disconnect == null ? Disconnect.getDefaultInstance() : disconnect;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDisconnect(Disconnect disconnect) {
            disconnect.getClass();
            this.disconnect_ = disconnect;
            this.bitField0_ |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDisconnect(Disconnect disconnect) {
            disconnect.getClass();
            Disconnect disconnect2 = this.disconnect_;
            if (disconnect2 != null && disconnect2 != Disconnect.getDefaultInstance()) {
                this.disconnect_ = Disconnect.newBuilder(this.disconnect_).mergeFrom(disconnect).buildPartial();
            } else {
                this.disconnect_ = disconnect;
            }
            this.bitField0_ |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDisconnect() {
            this.disconnect_ = null;
            this.bitField0_ &= -129;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public boolean hasRefresh() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
        public Refresh getRefresh() {
            Refresh refresh = this.refresh_;
            return refresh == null ? Refresh.getDefaultInstance() : refresh;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRefresh(Refresh refresh) {
            refresh.getClass();
            this.refresh_ = refresh;
            this.bitField0_ |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRefresh(Refresh refresh) {
            refresh.getClass();
            Refresh refresh2 = this.refresh_;
            if (refresh2 != null && refresh2 != Refresh.getDefaultInstance()) {
                this.refresh_ = Refresh.newBuilder(this.refresh_).mergeFrom(refresh).buildPartial();
            } else {
                this.refresh_ = refresh;
            }
            this.bitField0_ |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRefresh() {
            this.refresh_ = null;
            this.bitField0_ &= -257;
        }

        public static Push parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Push) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Push parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Push) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Push parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Push) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Push parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Push) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Push parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Push) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Push parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Push) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Push parseFrom(InputStream inputStream) throws IOException {
            return (Push) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Push parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Push) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Push parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Push) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Push parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Push) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Push parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Push) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Push parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Push) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Push push) {
            return DEFAULT_INSTANCE.createBuilder(push);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Push, Builder> implements PushOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Push.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public long getId() {
                return ((Push) this.instance).getId();
            }

            public Builder setId(long j) {
                copyOnWrite();
                ((Push) this.instance).setId(j);
                return this;
            }

            public Builder clearId() {
                copyOnWrite();
                ((Push) this.instance).clearId();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public String getChannel() {
                return ((Push) this.instance).getChannel();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public ByteString getChannelBytes() {
                return ((Push) this.instance).getChannelBytes();
            }

            public Builder setChannel(String str) {
                copyOnWrite();
                ((Push) this.instance).setChannel(str);
                return this;
            }

            public Builder clearChannel() {
                copyOnWrite();
                ((Push) this.instance).clearChannel();
                return this;
            }

            public Builder setChannelBytes(ByteString byteString) {
                copyOnWrite();
                ((Push) this.instance).setChannelBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public boolean hasPub() {
                return ((Push) this.instance).hasPub();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public Publication getPub() {
                return ((Push) this.instance).getPub();
            }

            public Builder setPub(Publication publication) {
                copyOnWrite();
                ((Push) this.instance).setPub(publication);
                return this;
            }

            public Builder setPub(Publication.Builder builder) {
                copyOnWrite();
                ((Push) this.instance).setPub(builder.build());
                return this;
            }

            public Builder mergePub(Publication publication) {
                copyOnWrite();
                ((Push) this.instance).mergePub(publication);
                return this;
            }

            public Builder clearPub() {
                copyOnWrite();
                ((Push) this.instance).clearPub();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public boolean hasJoin() {
                return ((Push) this.instance).hasJoin();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public Join getJoin() {
                return ((Push) this.instance).getJoin();
            }

            public Builder setJoin(Join join) {
                copyOnWrite();
                ((Push) this.instance).setJoin(join);
                return this;
            }

            public Builder setJoin(Join.Builder builder) {
                copyOnWrite();
                ((Push) this.instance).setJoin(builder.build());
                return this;
            }

            public Builder mergeJoin(Join join) {
                copyOnWrite();
                ((Push) this.instance).mergeJoin(join);
                return this;
            }

            public Builder clearJoin() {
                copyOnWrite();
                ((Push) this.instance).clearJoin();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public boolean hasLeave() {
                return ((Push) this.instance).hasLeave();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public Leave getLeave() {
                return ((Push) this.instance).getLeave();
            }

            public Builder setLeave(Leave leave) {
                copyOnWrite();
                ((Push) this.instance).setLeave(leave);
                return this;
            }

            public Builder setLeave(Leave.Builder builder) {
                copyOnWrite();
                ((Push) this.instance).setLeave(builder.build());
                return this;
            }

            public Builder mergeLeave(Leave leave) {
                copyOnWrite();
                ((Push) this.instance).mergeLeave(leave);
                return this;
            }

            public Builder clearLeave() {
                copyOnWrite();
                ((Push) this.instance).clearLeave();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public boolean hasUnsubscribe() {
                return ((Push) this.instance).hasUnsubscribe();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public Unsubscribe getUnsubscribe() {
                return ((Push) this.instance).getUnsubscribe();
            }

            public Builder setUnsubscribe(Unsubscribe unsubscribe) {
                copyOnWrite();
                ((Push) this.instance).setUnsubscribe(unsubscribe);
                return this;
            }

            public Builder setUnsubscribe(Unsubscribe.Builder builder) {
                copyOnWrite();
                ((Push) this.instance).setUnsubscribe(builder.build());
                return this;
            }

            public Builder mergeUnsubscribe(Unsubscribe unsubscribe) {
                copyOnWrite();
                ((Push) this.instance).mergeUnsubscribe(unsubscribe);
                return this;
            }

            public Builder clearUnsubscribe() {
                copyOnWrite();
                ((Push) this.instance).clearUnsubscribe();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public boolean hasMessage() {
                return ((Push) this.instance).hasMessage();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public Message getMessage() {
                return ((Push) this.instance).getMessage();
            }

            public Builder setMessage(Message message) {
                copyOnWrite();
                ((Push) this.instance).setMessage(message);
                return this;
            }

            public Builder setMessage(Message.Builder builder) {
                copyOnWrite();
                ((Push) this.instance).setMessage(builder.build());
                return this;
            }

            public Builder mergeMessage(Message message) {
                copyOnWrite();
                ((Push) this.instance).mergeMessage(message);
                return this;
            }

            public Builder clearMessage() {
                copyOnWrite();
                ((Push) this.instance).clearMessage();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public boolean hasSubscribe() {
                return ((Push) this.instance).hasSubscribe();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public Subscribe getSubscribe() {
                return ((Push) this.instance).getSubscribe();
            }

            public Builder setSubscribe(Subscribe subscribe) {
                copyOnWrite();
                ((Push) this.instance).setSubscribe(subscribe);
                return this;
            }

            public Builder setSubscribe(Subscribe.Builder builder) {
                copyOnWrite();
                ((Push) this.instance).setSubscribe(builder.build());
                return this;
            }

            public Builder mergeSubscribe(Subscribe subscribe) {
                copyOnWrite();
                ((Push) this.instance).mergeSubscribe(subscribe);
                return this;
            }

            public Builder clearSubscribe() {
                copyOnWrite();
                ((Push) this.instance).clearSubscribe();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public boolean hasConnect() {
                return ((Push) this.instance).hasConnect();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public Connect getConnect() {
                return ((Push) this.instance).getConnect();
            }

            public Builder setConnect(Connect connect) {
                copyOnWrite();
                ((Push) this.instance).setConnect(connect);
                return this;
            }

            public Builder setConnect(Connect.Builder builder) {
                copyOnWrite();
                ((Push) this.instance).setConnect(builder.build());
                return this;
            }

            public Builder mergeConnect(Connect connect) {
                copyOnWrite();
                ((Push) this.instance).mergeConnect(connect);
                return this;
            }

            public Builder clearConnect() {
                copyOnWrite();
                ((Push) this.instance).clearConnect();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public boolean hasDisconnect() {
                return ((Push) this.instance).hasDisconnect();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public Disconnect getDisconnect() {
                return ((Push) this.instance).getDisconnect();
            }

            public Builder setDisconnect(Disconnect disconnect) {
                copyOnWrite();
                ((Push) this.instance).setDisconnect(disconnect);
                return this;
            }

            public Builder setDisconnect(Disconnect.Builder builder) {
                copyOnWrite();
                ((Push) this.instance).setDisconnect(builder.build());
                return this;
            }

            public Builder mergeDisconnect(Disconnect disconnect) {
                copyOnWrite();
                ((Push) this.instance).mergeDisconnect(disconnect);
                return this;
            }

            public Builder clearDisconnect() {
                copyOnWrite();
                ((Push) this.instance).clearDisconnect();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public boolean hasRefresh() {
                return ((Push) this.instance).hasRefresh();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PushOrBuilder
            public Refresh getRefresh() {
                return ((Push) this.instance).getRefresh();
            }

            public Builder setRefresh(Refresh refresh) {
                copyOnWrite();
                ((Push) this.instance).setRefresh(refresh);
                return this;
            }

            public Builder setRefresh(Refresh.Builder builder) {
                copyOnWrite();
                ((Push) this.instance).setRefresh(builder.build());
                return this;
            }

            public Builder mergeRefresh(Refresh refresh) {
                copyOnWrite();
                ((Push) this.instance).mergeRefresh(refresh);
                return this;
            }

            public Builder clearRefresh() {
                copyOnWrite();
                ((Push) this.instance).clearRefresh();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new Push();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0001\u0001\f\u000b\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0004ဉ\u0000\u0005ဉ\u0001\u0006ဉ\u0002\u0007ဉ\u0003\bဉ\u0004\tဉ\u0005\nဉ\u0006\u000bဉ\u0007\fဉ\b", new Object[]{"bitField0_", "id_", "channel_", "pub_", "join_", "leave_", "unsubscribe_", "message_", "subscribe_", "connect_", "disconnect_", "refresh_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Push> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Push.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Push push = new Push();
            DEFAULT_INSTANCE = push;
            GeneratedMessageLite.registerDefaultInstance(Push.class, push);
        }

        public static Push getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Push> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ClientInfo extends GeneratedMessageLite<ClientInfo, Builder> implements ClientInfoOrBuilder {
        public static final int CHAN_INFO_FIELD_NUMBER = 4;
        public static final int CLIENT_FIELD_NUMBER = 2;
        public static final int CONN_INFO_FIELD_NUMBER = 3;
        private static final ClientInfo DEFAULT_INSTANCE;
        private static volatile Parser<ClientInfo> PARSER = null;
        public static final int USER_FIELD_NUMBER = 1;
        private String user_ = "";
        private String client_ = "";
        private ByteString connInfo_ = ByteString.EMPTY;
        private ByteString chanInfo_ = ByteString.EMPTY;

        private ClientInfo() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ClientInfoOrBuilder
        public String getUser() {
            return this.user_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ClientInfoOrBuilder
        public ByteString getUserBytes() {
            return ByteString.copyFromUtf8(this.user_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUser(String str) {
            str.getClass();
            this.user_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUser() {
            this.user_ = getDefaultInstance().getUser();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.user_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ClientInfoOrBuilder
        public String getClient() {
            return this.client_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ClientInfoOrBuilder
        public ByteString getClientBytes() {
            return ByteString.copyFromUtf8(this.client_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClient(String str) {
            str.getClass();
            this.client_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClient() {
            this.client_ = getDefaultInstance().getClient();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.client_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ClientInfoOrBuilder
        public ByteString getConnInfo() {
            return this.connInfo_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setConnInfo(ByteString byteString) {
            byteString.getClass();
            this.connInfo_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConnInfo() {
            this.connInfo_ = getDefaultInstance().getConnInfo();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ClientInfoOrBuilder
        public ByteString getChanInfo() {
            return this.chanInfo_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChanInfo(ByteString byteString) {
            byteString.getClass();
            this.chanInfo_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChanInfo() {
            this.chanInfo_ = getDefaultInstance().getChanInfo();
        }

        public static ClientInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ClientInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ClientInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ClientInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ClientInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ClientInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ClientInfo parseFrom(InputStream inputStream) throws IOException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ClientInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ClientInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ClientInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ClientInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ClientInfo clientInfo) {
            return DEFAULT_INSTANCE.createBuilder(clientInfo);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ClientInfo, Builder> implements ClientInfoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ClientInfo.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ClientInfoOrBuilder
            public String getUser() {
                return ((ClientInfo) this.instance).getUser();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ClientInfoOrBuilder
            public ByteString getUserBytes() {
                return ((ClientInfo) this.instance).getUserBytes();
            }

            public Builder setUser(String str) {
                copyOnWrite();
                ((ClientInfo) this.instance).setUser(str);
                return this;
            }

            public Builder clearUser() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearUser();
                return this;
            }

            public Builder setUserBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientInfo) this.instance).setUserBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ClientInfoOrBuilder
            public String getClient() {
                return ((ClientInfo) this.instance).getClient();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ClientInfoOrBuilder
            public ByteString getClientBytes() {
                return ((ClientInfo) this.instance).getClientBytes();
            }

            public Builder setClient(String str) {
                copyOnWrite();
                ((ClientInfo) this.instance).setClient(str);
                return this;
            }

            public Builder clearClient() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearClient();
                return this;
            }

            public Builder setClientBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientInfo) this.instance).setClientBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ClientInfoOrBuilder
            public ByteString getConnInfo() {
                return ((ClientInfo) this.instance).getConnInfo();
            }

            public Builder setConnInfo(ByteString byteString) {
                copyOnWrite();
                ((ClientInfo) this.instance).setConnInfo(byteString);
                return this;
            }

            public Builder clearConnInfo() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearConnInfo();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ClientInfoOrBuilder
            public ByteString getChanInfo() {
                return ((ClientInfo) this.instance).getChanInfo();
            }

            public Builder setChanInfo(ByteString byteString) {
                copyOnWrite();
                ((ClientInfo) this.instance).setChanInfo(byteString);
                return this;
            }

            public Builder clearChanInfo() {
                copyOnWrite();
                ((ClientInfo) this.instance).clearChanInfo();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new ClientInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\n\u0004\n", new Object[]{"user_", "client_", "connInfo_", "chanInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ClientInfo> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ClientInfo.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ClientInfo clientInfo = new ClientInfo();
            DEFAULT_INSTANCE = clientInfo;
            GeneratedMessageLite.registerDefaultInstance(ClientInfo.class, clientInfo);
        }

        public static ClientInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ClientInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Publication extends GeneratedMessageLite<Publication, Builder> implements PublicationOrBuilder {
        public static final int CHANNEL_FIELD_NUMBER = 10;
        public static final int DATA_FIELD_NUMBER = 4;
        private static final Publication DEFAULT_INSTANCE;
        public static final int DELTA_FIELD_NUMBER = 8;
        public static final int EPOCH_FIELD_NUMBER = 14;
        public static final int INFO_FIELD_NUMBER = 5;
        public static final int KEY_FIELD_NUMBER = 11;
        public static final int OFFSET_FIELD_NUMBER = 6;
        private static volatile Parser<Publication> PARSER = null;
        public static final int PREV_DATA_FIELD_NUMBER = 15;
        public static final int REMOVED_FIELD_NUMBER = 12;
        public static final int SCORE_FIELD_NUMBER = 13;
        public static final int TAGS_FIELD_NUMBER = 7;
        public static final int TIME_FIELD_NUMBER = 9;
        public static final int VERSION_FIELD_NUMBER = 16;
        private int bitField0_;
        private boolean delta_;
        private ClientInfo info_;
        private long offset_;
        private boolean removed_;
        private long score_;
        private long time_;
        private long version_;
        private MapFieldLite<String, String> tags_ = MapFieldLite.emptyMapField();
        private ByteString data_ = ByteString.EMPTY;
        private String channel_ = "";
        private String key_ = "";
        private String epoch_ = "";
        private ByteString prevData_ = ByteString.EMPTY;

        private Publication() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(ByteString byteString) {
            byteString.getClass();
            this.data_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public boolean hasInfo() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public ClientInfo getInfo() {
            ClientInfo clientInfo = this.info_;
            return clientInfo == null ? ClientInfo.getDefaultInstance() : clientInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInfo(ClientInfo clientInfo) {
            clientInfo.getClass();
            this.info_ = clientInfo;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeInfo(ClientInfo clientInfo) {
            clientInfo.getClass();
            ClientInfo clientInfo2 = this.info_;
            if (clientInfo2 != null && clientInfo2 != ClientInfo.getDefaultInstance()) {
                this.info_ = ClientInfo.newBuilder(this.info_).mergeFrom(clientInfo).buildPartial();
            } else {
                this.info_ = clientInfo;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInfo() {
            this.info_ = null;
            this.bitField0_ &= -2;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public long getOffset() {
            return this.offset_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOffset(long j) {
            this.offset_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOffset() {
            this.offset_ = 0L;
        }

        private static final class TagsDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

            private TagsDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, String> internalGetTags() {
            return this.tags_;
        }

        private MapFieldLite<String, String> internalGetMutableTags() {
            if (!this.tags_.isMutable()) {
                this.tags_ = this.tags_.mutableCopy();
            }
            return this.tags_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public int getTagsCount() {
            return internalGetTags().size();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public boolean containsTags(String str) {
            str.getClass();
            return internalGetTags().containsKey(str);
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        @Deprecated
        public Map<String, String> getTags() {
            return getTagsMap();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public Map<String, String> getTagsMap() {
            return Collections.unmodifiableMap(internalGetTags());
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public String getTagsOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetTags = internalGetTags();
            return mapFieldLiteInternalGetTags.containsKey(str) ? mapFieldLiteInternalGetTags.get(str) : str2;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public String getTagsOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetTags = internalGetTags();
            if (!mapFieldLiteInternalGetTags.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return mapFieldLiteInternalGetTags.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableTagsMap() {
            return internalGetMutableTags();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public boolean getDelta() {
            return this.delta_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDelta(boolean z) {
            this.delta_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDelta() {
            this.delta_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public long getTime() {
            return this.time_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(long j) {
            this.time_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.time_ = 0L;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public String getChannel() {
            return this.channel_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public ByteString getChannelBytes() {
            return ByteString.copyFromUtf8(this.channel_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannel(String str) {
            str.getClass();
            this.channel_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannel() {
            this.channel_ = getDefaultInstance().getChannel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.channel_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public String getKey() {
            return this.key_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public ByteString getKeyBytes() {
            return ByteString.copyFromUtf8(this.key_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKey(String str) {
            str.getClass();
            this.key_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKey() {
            this.key_ = getDefaultInstance().getKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.key_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public boolean getRemoved() {
            return this.removed_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoved(boolean z) {
            this.removed_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoved() {
            this.removed_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public long getScore() {
            return this.score_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setScore(long j) {
            this.score_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearScore() {
            this.score_ = 0L;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public String getEpoch() {
            return this.epoch_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public ByteString getEpochBytes() {
            return ByteString.copyFromUtf8(this.epoch_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEpoch(String str) {
            str.getClass();
            this.epoch_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEpoch() {
            this.epoch_ = getDefaultInstance().getEpoch();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEpochBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.epoch_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public ByteString getPrevData() {
            return this.prevData_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrevData(ByteString byteString) {
            byteString.getClass();
            this.prevData_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrevData() {
            this.prevData_ = getDefaultInstance().getPrevData();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
        public long getVersion() {
            return this.version_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(long j) {
            this.version_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.version_ = 0L;
        }

        public static Publication parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Publication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Publication parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Publication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Publication parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Publication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Publication parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Publication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Publication parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Publication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Publication parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Publication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Publication parseFrom(InputStream inputStream) throws IOException {
            return (Publication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Publication parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Publication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Publication parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Publication) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Publication parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Publication) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Publication parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Publication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Publication parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Publication) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Publication publication) {
            return DEFAULT_INSTANCE.createBuilder(publication);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Publication, Builder> implements PublicationOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Publication.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public ByteString getData() {
                return ((Publication) this.instance).getData();
            }

            public Builder setData(ByteString byteString) {
                copyOnWrite();
                ((Publication) this.instance).setData(byteString);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((Publication) this.instance).clearData();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public boolean hasInfo() {
                return ((Publication) this.instance).hasInfo();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public ClientInfo getInfo() {
                return ((Publication) this.instance).getInfo();
            }

            public Builder setInfo(ClientInfo clientInfo) {
                copyOnWrite();
                ((Publication) this.instance).setInfo(clientInfo);
                return this;
            }

            public Builder setInfo(ClientInfo.Builder builder) {
                copyOnWrite();
                ((Publication) this.instance).setInfo(builder.build());
                return this;
            }

            public Builder mergeInfo(ClientInfo clientInfo) {
                copyOnWrite();
                ((Publication) this.instance).mergeInfo(clientInfo);
                return this;
            }

            public Builder clearInfo() {
                copyOnWrite();
                ((Publication) this.instance).clearInfo();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public long getOffset() {
                return ((Publication) this.instance).getOffset();
            }

            public Builder setOffset(long j) {
                copyOnWrite();
                ((Publication) this.instance).setOffset(j);
                return this;
            }

            public Builder clearOffset() {
                copyOnWrite();
                ((Publication) this.instance).clearOffset();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public int getTagsCount() {
                return ((Publication) this.instance).getTagsMap().size();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public boolean containsTags(String str) {
                str.getClass();
                return ((Publication) this.instance).getTagsMap().containsKey(str);
            }

            public Builder clearTags() {
                copyOnWrite();
                ((Publication) this.instance).getMutableTagsMap().clear();
                return this;
            }

            public Builder removeTags(String str) {
                str.getClass();
                copyOnWrite();
                ((Publication) this.instance).getMutableTagsMap().remove(str);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            @Deprecated
            public Map<String, String> getTags() {
                return getTagsMap();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public Map<String, String> getTagsMap() {
                return Collections.unmodifiableMap(((Publication) this.instance).getTagsMap());
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public String getTagsOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> tagsMap = ((Publication) this.instance).getTagsMap();
                return tagsMap.containsKey(str) ? tagsMap.get(str) : str2;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public String getTagsOrThrow(String str) {
                str.getClass();
                Map<String, String> tagsMap = ((Publication) this.instance).getTagsMap();
                if (!tagsMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return tagsMap.get(str);
            }

            public Builder putTags(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((Publication) this.instance).getMutableTagsMap().put(str, str2);
                return this;
            }

            public Builder putAllTags(Map<String, String> map) {
                copyOnWrite();
                ((Publication) this.instance).getMutableTagsMap().putAll(map);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public boolean getDelta() {
                return ((Publication) this.instance).getDelta();
            }

            public Builder setDelta(boolean z) {
                copyOnWrite();
                ((Publication) this.instance).setDelta(z);
                return this;
            }

            public Builder clearDelta() {
                copyOnWrite();
                ((Publication) this.instance).clearDelta();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public long getTime() {
                return ((Publication) this.instance).getTime();
            }

            public Builder setTime(long j) {
                copyOnWrite();
                ((Publication) this.instance).setTime(j);
                return this;
            }

            public Builder clearTime() {
                copyOnWrite();
                ((Publication) this.instance).clearTime();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public String getChannel() {
                return ((Publication) this.instance).getChannel();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public ByteString getChannelBytes() {
                return ((Publication) this.instance).getChannelBytes();
            }

            public Builder setChannel(String str) {
                copyOnWrite();
                ((Publication) this.instance).setChannel(str);
                return this;
            }

            public Builder clearChannel() {
                copyOnWrite();
                ((Publication) this.instance).clearChannel();
                return this;
            }

            public Builder setChannelBytes(ByteString byteString) {
                copyOnWrite();
                ((Publication) this.instance).setChannelBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public String getKey() {
                return ((Publication) this.instance).getKey();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public ByteString getKeyBytes() {
                return ((Publication) this.instance).getKeyBytes();
            }

            public Builder setKey(String str) {
                copyOnWrite();
                ((Publication) this.instance).setKey(str);
                return this;
            }

            public Builder clearKey() {
                copyOnWrite();
                ((Publication) this.instance).clearKey();
                return this;
            }

            public Builder setKeyBytes(ByteString byteString) {
                copyOnWrite();
                ((Publication) this.instance).setKeyBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public boolean getRemoved() {
                return ((Publication) this.instance).getRemoved();
            }

            public Builder setRemoved(boolean z) {
                copyOnWrite();
                ((Publication) this.instance).setRemoved(z);
                return this;
            }

            public Builder clearRemoved() {
                copyOnWrite();
                ((Publication) this.instance).clearRemoved();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public long getScore() {
                return ((Publication) this.instance).getScore();
            }

            public Builder setScore(long j) {
                copyOnWrite();
                ((Publication) this.instance).setScore(j);
                return this;
            }

            public Builder clearScore() {
                copyOnWrite();
                ((Publication) this.instance).clearScore();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public String getEpoch() {
                return ((Publication) this.instance).getEpoch();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public ByteString getEpochBytes() {
                return ((Publication) this.instance).getEpochBytes();
            }

            public Builder setEpoch(String str) {
                copyOnWrite();
                ((Publication) this.instance).setEpoch(str);
                return this;
            }

            public Builder clearEpoch() {
                copyOnWrite();
                ((Publication) this.instance).clearEpoch();
                return this;
            }

            public Builder setEpochBytes(ByteString byteString) {
                copyOnWrite();
                ((Publication) this.instance).setEpochBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public ByteString getPrevData() {
                return ((Publication) this.instance).getPrevData();
            }

            public Builder setPrevData(ByteString byteString) {
                copyOnWrite();
                ((Publication) this.instance).setPrevData(byteString);
                return this;
            }

            public Builder clearPrevData() {
                copyOnWrite();
                ((Publication) this.instance).clearPrevData();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublicationOrBuilder
            public long getVersion() {
                return ((Publication) this.instance).getVersion();
            }

            public Builder setVersion(long j) {
                copyOnWrite();
                ((Publication) this.instance).setVersion(j);
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((Publication) this.instance).clearVersion();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Publication();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\r\u0000\u0001\u0004\u0010\r\u0001\u0000\u0000\u0004\n\u0005ဉ\u0000\u0006\u0003\u00072\b\u0007\t\u0002\nȈ\u000bȈ\f\u0007\r\u0010\u000eȈ\u000f\n\u0010\u0003", new Object[]{"bitField0_", "data_", "info_", "offset_", "tags_", TagsDefaultEntryHolder.defaultEntry, "delta_", "time_", "channel_", "key_", "removed_", "score_", "epoch_", "prevData_", "version_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Publication> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Publication.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Publication publication = new Publication();
            DEFAULT_INSTANCE = publication;
            GeneratedMessageLite.registerDefaultInstance(Publication.class, publication);
        }

        public static Publication getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Publication> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Join extends GeneratedMessageLite<Join, Builder> implements JoinOrBuilder {
        private static final Join DEFAULT_INSTANCE;
        public static final int INFO_FIELD_NUMBER = 1;
        private static volatile Parser<Join> PARSER;
        private int bitField0_;
        private ClientInfo info_;

        private Join() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.JoinOrBuilder
        public boolean hasInfo() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.JoinOrBuilder
        public ClientInfo getInfo() {
            ClientInfo clientInfo = this.info_;
            return clientInfo == null ? ClientInfo.getDefaultInstance() : clientInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInfo(ClientInfo clientInfo) {
            clientInfo.getClass();
            this.info_ = clientInfo;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeInfo(ClientInfo clientInfo) {
            clientInfo.getClass();
            ClientInfo clientInfo2 = this.info_;
            if (clientInfo2 != null && clientInfo2 != ClientInfo.getDefaultInstance()) {
                this.info_ = ClientInfo.newBuilder(this.info_).mergeFrom(clientInfo).buildPartial();
            } else {
                this.info_ = clientInfo;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInfo() {
            this.info_ = null;
            this.bitField0_ &= -2;
        }

        public static Join parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Join) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Join parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Join) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Join parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Join) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Join parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Join) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Join parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Join) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Join parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Join) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Join parseFrom(InputStream inputStream) throws IOException {
            return (Join) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Join parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Join) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Join parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Join) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Join parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Join) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Join parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Join) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Join parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Join) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Join join) {
            return DEFAULT_INSTANCE.createBuilder(join);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Join, Builder> implements JoinOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Join.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.JoinOrBuilder
            public boolean hasInfo() {
                return ((Join) this.instance).hasInfo();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.JoinOrBuilder
            public ClientInfo getInfo() {
                return ((Join) this.instance).getInfo();
            }

            public Builder setInfo(ClientInfo clientInfo) {
                copyOnWrite();
                ((Join) this.instance).setInfo(clientInfo);
                return this;
            }

            public Builder setInfo(ClientInfo.Builder builder) {
                copyOnWrite();
                ((Join) this.instance).setInfo(builder.build());
                return this;
            }

            public Builder mergeInfo(ClientInfo clientInfo) {
                copyOnWrite();
                ((Join) this.instance).mergeInfo(clientInfo);
                return this;
            }

            public Builder clearInfo() {
                copyOnWrite();
                ((Join) this.instance).clearInfo();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new Join();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "info_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Join> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Join.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Join join = new Join();
            DEFAULT_INSTANCE = join;
            GeneratedMessageLite.registerDefaultInstance(Join.class, join);
        }

        public static Join getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Join> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Leave extends GeneratedMessageLite<Leave, Builder> implements LeaveOrBuilder {
        private static final Leave DEFAULT_INSTANCE;
        public static final int INFO_FIELD_NUMBER = 1;
        private static volatile Parser<Leave> PARSER;
        private int bitField0_;
        private ClientInfo info_;

        private Leave() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.LeaveOrBuilder
        public boolean hasInfo() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.LeaveOrBuilder
        public ClientInfo getInfo() {
            ClientInfo clientInfo = this.info_;
            return clientInfo == null ? ClientInfo.getDefaultInstance() : clientInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInfo(ClientInfo clientInfo) {
            clientInfo.getClass();
            this.info_ = clientInfo;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeInfo(ClientInfo clientInfo) {
            clientInfo.getClass();
            ClientInfo clientInfo2 = this.info_;
            if (clientInfo2 != null && clientInfo2 != ClientInfo.getDefaultInstance()) {
                this.info_ = ClientInfo.newBuilder(this.info_).mergeFrom(clientInfo).buildPartial();
            } else {
                this.info_ = clientInfo;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInfo() {
            this.info_ = null;
            this.bitField0_ &= -2;
        }

        public static Leave parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Leave) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Leave parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Leave) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Leave parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Leave) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Leave parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Leave) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Leave parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Leave) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Leave parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Leave) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Leave parseFrom(InputStream inputStream) throws IOException {
            return (Leave) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Leave parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Leave) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Leave parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Leave) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Leave parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Leave) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Leave parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Leave) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Leave parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Leave) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Leave leave) {
            return DEFAULT_INSTANCE.createBuilder(leave);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Leave, Builder> implements LeaveOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Leave.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.LeaveOrBuilder
            public boolean hasInfo() {
                return ((Leave) this.instance).hasInfo();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.LeaveOrBuilder
            public ClientInfo getInfo() {
                return ((Leave) this.instance).getInfo();
            }

            public Builder setInfo(ClientInfo clientInfo) {
                copyOnWrite();
                ((Leave) this.instance).setInfo(clientInfo);
                return this;
            }

            public Builder setInfo(ClientInfo.Builder builder) {
                copyOnWrite();
                ((Leave) this.instance).setInfo(builder.build());
                return this;
            }

            public Builder mergeInfo(ClientInfo clientInfo) {
                copyOnWrite();
                ((Leave) this.instance).mergeInfo(clientInfo);
                return this;
            }

            public Builder clearInfo() {
                copyOnWrite();
                ((Leave) this.instance).clearInfo();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new Leave();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "info_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Leave> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Leave.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Leave leave = new Leave();
            DEFAULT_INSTANCE = leave;
            GeneratedMessageLite.registerDefaultInstance(Leave.class, leave);
        }

        public static Leave getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Leave> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Unsubscribe extends GeneratedMessageLite<Unsubscribe, Builder> implements UnsubscribeOrBuilder {
        public static final int CODE_FIELD_NUMBER = 2;
        private static final Unsubscribe DEFAULT_INSTANCE;
        private static volatile Parser<Unsubscribe> PARSER = null;
        public static final int REASON_FIELD_NUMBER = 3;
        private int code_;
        private String reason_ = "";

        private Unsubscribe() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.UnsubscribeOrBuilder
        public int getCode() {
            return this.code_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCode(int i) {
            this.code_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.code_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.UnsubscribeOrBuilder
        public String getReason() {
            return this.reason_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.UnsubscribeOrBuilder
        public ByteString getReasonBytes() {
            return ByteString.copyFromUtf8(this.reason_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReason(String str) {
            str.getClass();
            this.reason_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReason() {
            this.reason_ = getDefaultInstance().getReason();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReasonBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.reason_ = byteString.toStringUtf8();
        }

        public static Unsubscribe parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Unsubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Unsubscribe parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Unsubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Unsubscribe parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Unsubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Unsubscribe parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Unsubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Unsubscribe parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Unsubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Unsubscribe parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Unsubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Unsubscribe parseFrom(InputStream inputStream) throws IOException {
            return (Unsubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Unsubscribe parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Unsubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Unsubscribe parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Unsubscribe) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Unsubscribe parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Unsubscribe) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Unsubscribe parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Unsubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Unsubscribe parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Unsubscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Unsubscribe unsubscribe) {
            return DEFAULT_INSTANCE.createBuilder(unsubscribe);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Unsubscribe, Builder> implements UnsubscribeOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Unsubscribe.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.UnsubscribeOrBuilder
            public int getCode() {
                return ((Unsubscribe) this.instance).getCode();
            }

            public Builder setCode(int i) {
                copyOnWrite();
                ((Unsubscribe) this.instance).setCode(i);
                return this;
            }

            public Builder clearCode() {
                copyOnWrite();
                ((Unsubscribe) this.instance).clearCode();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.UnsubscribeOrBuilder
            public String getReason() {
                return ((Unsubscribe) this.instance).getReason();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.UnsubscribeOrBuilder
            public ByteString getReasonBytes() {
                return ((Unsubscribe) this.instance).getReasonBytes();
            }

            public Builder setReason(String str) {
                copyOnWrite();
                ((Unsubscribe) this.instance).setReason(str);
                return this;
            }

            public Builder clearReason() {
                copyOnWrite();
                ((Unsubscribe) this.instance).clearReason();
                return this;
            }

            public Builder setReasonBytes(ByteString byteString) {
                copyOnWrite();
                ((Unsubscribe) this.instance).setReasonBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new Unsubscribe();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003Ȉ", new Object[]{"code_", "reason_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Unsubscribe> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Unsubscribe.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Unsubscribe unsubscribe = new Unsubscribe();
            DEFAULT_INSTANCE = unsubscribe;
            GeneratedMessageLite.registerDefaultInstance(Unsubscribe.class, unsubscribe);
        }

        public static Unsubscribe getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Unsubscribe> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Subscribe extends GeneratedMessageLite<Subscribe, Builder> implements SubscribeOrBuilder {
        public static final int DATA_FIELD_NUMBER = 7;
        private static final Subscribe DEFAULT_INSTANCE;
        public static final int EPOCH_FIELD_NUMBER = 4;
        public static final int OFFSET_FIELD_NUMBER = 5;
        private static volatile Parser<Subscribe> PARSER = null;
        public static final int POSITIONED_FIELD_NUMBER = 6;
        public static final int RECOVERABLE_FIELD_NUMBER = 1;
        private long offset_;
        private boolean positioned_;
        private boolean recoverable_;
        private String epoch_ = "";
        private ByteString data_ = ByteString.EMPTY;

        private Subscribe() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeOrBuilder
        public boolean getRecoverable() {
            return this.recoverable_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRecoverable(boolean z) {
            this.recoverable_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRecoverable() {
            this.recoverable_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeOrBuilder
        public String getEpoch() {
            return this.epoch_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeOrBuilder
        public ByteString getEpochBytes() {
            return ByteString.copyFromUtf8(this.epoch_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEpoch(String str) {
            str.getClass();
            this.epoch_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEpoch() {
            this.epoch_ = getDefaultInstance().getEpoch();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEpochBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.epoch_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeOrBuilder
        public long getOffset() {
            return this.offset_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOffset(long j) {
            this.offset_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOffset() {
            this.offset_ = 0L;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeOrBuilder
        public boolean getPositioned() {
            return this.positioned_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPositioned(boolean z) {
            this.positioned_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPositioned() {
            this.positioned_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(ByteString byteString) {
            byteString.getClass();
            this.data_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        public static Subscribe parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Subscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Subscribe parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Subscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Subscribe parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Subscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Subscribe parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Subscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Subscribe parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Subscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Subscribe parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Subscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Subscribe parseFrom(InputStream inputStream) throws IOException {
            return (Subscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Subscribe parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Subscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Subscribe parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Subscribe) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Subscribe parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Subscribe) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Subscribe parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Subscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Subscribe parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Subscribe) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Subscribe subscribe) {
            return DEFAULT_INSTANCE.createBuilder(subscribe);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Subscribe, Builder> implements SubscribeOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Subscribe.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeOrBuilder
            public boolean getRecoverable() {
                return ((Subscribe) this.instance).getRecoverable();
            }

            public Builder setRecoverable(boolean z) {
                copyOnWrite();
                ((Subscribe) this.instance).setRecoverable(z);
                return this;
            }

            public Builder clearRecoverable() {
                copyOnWrite();
                ((Subscribe) this.instance).clearRecoverable();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeOrBuilder
            public String getEpoch() {
                return ((Subscribe) this.instance).getEpoch();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeOrBuilder
            public ByteString getEpochBytes() {
                return ((Subscribe) this.instance).getEpochBytes();
            }

            public Builder setEpoch(String str) {
                copyOnWrite();
                ((Subscribe) this.instance).setEpoch(str);
                return this;
            }

            public Builder clearEpoch() {
                copyOnWrite();
                ((Subscribe) this.instance).clearEpoch();
                return this;
            }

            public Builder setEpochBytes(ByteString byteString) {
                copyOnWrite();
                ((Subscribe) this.instance).setEpochBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeOrBuilder
            public long getOffset() {
                return ((Subscribe) this.instance).getOffset();
            }

            public Builder setOffset(long j) {
                copyOnWrite();
                ((Subscribe) this.instance).setOffset(j);
                return this;
            }

            public Builder clearOffset() {
                copyOnWrite();
                ((Subscribe) this.instance).clearOffset();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeOrBuilder
            public boolean getPositioned() {
                return ((Subscribe) this.instance).getPositioned();
            }

            public Builder setPositioned(boolean z) {
                copyOnWrite();
                ((Subscribe) this.instance).setPositioned(z);
                return this;
            }

            public Builder clearPositioned() {
                copyOnWrite();
                ((Subscribe) this.instance).clearPositioned();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeOrBuilder
            public ByteString getData() {
                return ((Subscribe) this.instance).getData();
            }

            public Builder setData(ByteString byteString) {
                copyOnWrite();
                ((Subscribe) this.instance).setData(byteString);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((Subscribe) this.instance).clearData();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new Subscribe();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0007\u0005\u0000\u0000\u0000\u0001\u0007\u0004Ȉ\u0005\u0003\u0006\u0007\u0007\n", new Object[]{"recoverable_", "epoch_", "offset_", "positioned_", "data_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Subscribe> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Subscribe.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Subscribe subscribe = new Subscribe();
            DEFAULT_INSTANCE = subscribe;
            GeneratedMessageLite.registerDefaultInstance(Subscribe.class, subscribe);
        }

        public static Subscribe getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Subscribe> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Message extends GeneratedMessageLite<Message, Builder> implements MessageOrBuilder {
        public static final int DATA_FIELD_NUMBER = 1;
        private static final Message DEFAULT_INSTANCE;
        private static volatile Parser<Message> PARSER;
        private ByteString data_ = ByteString.EMPTY;

        private Message() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.MessageOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(ByteString byteString) {
            byteString.getClass();
            this.data_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        public static Message parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Message parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Message parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Message parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Message parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Message parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Message parseFrom(InputStream inputStream) throws IOException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Message parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Message parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Message) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Message parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Message) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Message parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Message parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Message message) {
            return DEFAULT_INSTANCE.createBuilder(message);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Message, Builder> implements MessageOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Message.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.MessageOrBuilder
            public ByteString getData() {
                return ((Message) this.instance).getData();
            }

            public Builder setData(ByteString byteString) {
                copyOnWrite();
                ((Message) this.instance).setData(byteString);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((Message) this.instance).clearData();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new Message();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n", new Object[]{"data_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Message> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Message.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Message message = new Message();
            DEFAULT_INSTANCE = message;
            GeneratedMessageLite.registerDefaultInstance(Message.class, message);
        }

        public static Message getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Message> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Connect extends GeneratedMessageLite<Connect, Builder> implements ConnectOrBuilder {
        public static final int CLIENT_FIELD_NUMBER = 1;
        public static final int DATA_FIELD_NUMBER = 3;
        private static final Connect DEFAULT_INSTANCE;
        public static final int EXPIRES_FIELD_NUMBER = 5;
        public static final int NODE_FIELD_NUMBER = 10;
        private static volatile Parser<Connect> PARSER = null;
        public static final int PING_FIELD_NUMBER = 7;
        public static final int PONG_FIELD_NUMBER = 8;
        public static final int SESSION_FIELD_NUMBER = 9;
        public static final int SUBS_FIELD_NUMBER = 4;
        public static final int TIME_FIELD_NUMBER = 11;
        public static final int TTL_FIELD_NUMBER = 6;
        public static final int VERSION_FIELD_NUMBER = 2;
        private boolean expires_;
        private int ping_;
        private boolean pong_;
        private long time_;
        private int ttl_;
        private MapFieldLite<String, SubscribeResult> subs_ = MapFieldLite.emptyMapField();
        private String client_ = "";
        private String version_ = "";
        private ByteString data_ = ByteString.EMPTY;
        private String session_ = "";
        private String node_ = "";

        private Connect() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public String getClient() {
            return this.client_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public ByteString getClientBytes() {
            return ByteString.copyFromUtf8(this.client_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClient(String str) {
            str.getClass();
            this.client_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClient() {
            this.client_ = getDefaultInstance().getClient();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.client_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public String getVersion() {
            return this.version_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public ByteString getVersionBytes() {
            return ByteString.copyFromUtf8(this.version_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(String str) {
            str.getClass();
            this.version_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.version_ = getDefaultInstance().getVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.version_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(ByteString byteString) {
            byteString.getClass();
            this.data_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        private static final class SubsDefaultEntryHolder {
            static final MapEntryLite<String, SubscribeResult> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, SubscribeResult.getDefaultInstance());

            private SubsDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, SubscribeResult> internalGetSubs() {
            return this.subs_;
        }

        private MapFieldLite<String, SubscribeResult> internalGetMutableSubs() {
            if (!this.subs_.isMutable()) {
                this.subs_ = this.subs_.mutableCopy();
            }
            return this.subs_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public int getSubsCount() {
            return internalGetSubs().size();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public boolean containsSubs(String str) {
            str.getClass();
            return internalGetSubs().containsKey(str);
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        @Deprecated
        public Map<String, SubscribeResult> getSubs() {
            return getSubsMap();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public Map<String, SubscribeResult> getSubsMap() {
            return Collections.unmodifiableMap(internalGetSubs());
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public SubscribeResult getSubsOrDefault(String str, SubscribeResult subscribeResult) {
            str.getClass();
            MapFieldLite<String, SubscribeResult> mapFieldLiteInternalGetSubs = internalGetSubs();
            return mapFieldLiteInternalGetSubs.containsKey(str) ? mapFieldLiteInternalGetSubs.get(str) : subscribeResult;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public SubscribeResult getSubsOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, SubscribeResult> mapFieldLiteInternalGetSubs = internalGetSubs();
            if (!mapFieldLiteInternalGetSubs.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return mapFieldLiteInternalGetSubs.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, SubscribeResult> getMutableSubsMap() {
            return internalGetMutableSubs();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public boolean getExpires() {
            return this.expires_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExpires(boolean z) {
            this.expires_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExpires() {
            this.expires_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public int getTtl() {
            return this.ttl_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTtl(int i) {
            this.ttl_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTtl() {
            this.ttl_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public int getPing() {
            return this.ping_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPing(int i) {
            this.ping_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPing() {
            this.ping_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public boolean getPong() {
            return this.pong_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPong(boolean z) {
            this.pong_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPong() {
            this.pong_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public String getSession() {
            return this.session_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public ByteString getSessionBytes() {
            return ByteString.copyFromUtf8(this.session_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSession(String str) {
            str.getClass();
            this.session_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSession() {
            this.session_ = getDefaultInstance().getSession();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.session_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public String getNode() {
            return this.node_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public ByteString getNodeBytes() {
            return ByteString.copyFromUtf8(this.node_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNode(String str) {
            str.getClass();
            this.node_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNode() {
            this.node_ = getDefaultInstance().getNode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNodeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.node_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
        public long getTime() {
            return this.time_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(long j) {
            this.time_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.time_ = 0L;
        }

        public static Connect parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Connect parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Connect parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Connect parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Connect parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Connect parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Connect parseFrom(InputStream inputStream) throws IOException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Connect parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Connect parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Connect) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Connect parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Connect) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Connect parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Connect parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Connect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Connect connect) {
            return DEFAULT_INSTANCE.createBuilder(connect);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Connect, Builder> implements ConnectOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Connect.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public String getClient() {
                return ((Connect) this.instance).getClient();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public ByteString getClientBytes() {
                return ((Connect) this.instance).getClientBytes();
            }

            public Builder setClient(String str) {
                copyOnWrite();
                ((Connect) this.instance).setClient(str);
                return this;
            }

            public Builder clearClient() {
                copyOnWrite();
                ((Connect) this.instance).clearClient();
                return this;
            }

            public Builder setClientBytes(ByteString byteString) {
                copyOnWrite();
                ((Connect) this.instance).setClientBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public String getVersion() {
                return ((Connect) this.instance).getVersion();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public ByteString getVersionBytes() {
                return ((Connect) this.instance).getVersionBytes();
            }

            public Builder setVersion(String str) {
                copyOnWrite();
                ((Connect) this.instance).setVersion(str);
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((Connect) this.instance).clearVersion();
                return this;
            }

            public Builder setVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((Connect) this.instance).setVersionBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public ByteString getData() {
                return ((Connect) this.instance).getData();
            }

            public Builder setData(ByteString byteString) {
                copyOnWrite();
                ((Connect) this.instance).setData(byteString);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((Connect) this.instance).clearData();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public int getSubsCount() {
                return ((Connect) this.instance).getSubsMap().size();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public boolean containsSubs(String str) {
                str.getClass();
                return ((Connect) this.instance).getSubsMap().containsKey(str);
            }

            public Builder clearSubs() {
                copyOnWrite();
                ((Connect) this.instance).getMutableSubsMap().clear();
                return this;
            }

            public Builder removeSubs(String str) {
                str.getClass();
                copyOnWrite();
                ((Connect) this.instance).getMutableSubsMap().remove(str);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            @Deprecated
            public Map<String, SubscribeResult> getSubs() {
                return getSubsMap();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public Map<String, SubscribeResult> getSubsMap() {
                return Collections.unmodifiableMap(((Connect) this.instance).getSubsMap());
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public SubscribeResult getSubsOrDefault(String str, SubscribeResult subscribeResult) {
                str.getClass();
                Map<String, SubscribeResult> subsMap = ((Connect) this.instance).getSubsMap();
                return subsMap.containsKey(str) ? subsMap.get(str) : subscribeResult;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public SubscribeResult getSubsOrThrow(String str) {
                str.getClass();
                Map<String, SubscribeResult> subsMap = ((Connect) this.instance).getSubsMap();
                if (!subsMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return subsMap.get(str);
            }

            public Builder putSubs(String str, SubscribeResult subscribeResult) {
                str.getClass();
                subscribeResult.getClass();
                copyOnWrite();
                ((Connect) this.instance).getMutableSubsMap().put(str, subscribeResult);
                return this;
            }

            public Builder putAllSubs(Map<String, SubscribeResult> map) {
                copyOnWrite();
                ((Connect) this.instance).getMutableSubsMap().putAll(map);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public boolean getExpires() {
                return ((Connect) this.instance).getExpires();
            }

            public Builder setExpires(boolean z) {
                copyOnWrite();
                ((Connect) this.instance).setExpires(z);
                return this;
            }

            public Builder clearExpires() {
                copyOnWrite();
                ((Connect) this.instance).clearExpires();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public int getTtl() {
                return ((Connect) this.instance).getTtl();
            }

            public Builder setTtl(int i) {
                copyOnWrite();
                ((Connect) this.instance).setTtl(i);
                return this;
            }

            public Builder clearTtl() {
                copyOnWrite();
                ((Connect) this.instance).clearTtl();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public int getPing() {
                return ((Connect) this.instance).getPing();
            }

            public Builder setPing(int i) {
                copyOnWrite();
                ((Connect) this.instance).setPing(i);
                return this;
            }

            public Builder clearPing() {
                copyOnWrite();
                ((Connect) this.instance).clearPing();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public boolean getPong() {
                return ((Connect) this.instance).getPong();
            }

            public Builder setPong(boolean z) {
                copyOnWrite();
                ((Connect) this.instance).setPong(z);
                return this;
            }

            public Builder clearPong() {
                copyOnWrite();
                ((Connect) this.instance).clearPong();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public String getSession() {
                return ((Connect) this.instance).getSession();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public ByteString getSessionBytes() {
                return ((Connect) this.instance).getSessionBytes();
            }

            public Builder setSession(String str) {
                copyOnWrite();
                ((Connect) this.instance).setSession(str);
                return this;
            }

            public Builder clearSession() {
                copyOnWrite();
                ((Connect) this.instance).clearSession();
                return this;
            }

            public Builder setSessionBytes(ByteString byteString) {
                copyOnWrite();
                ((Connect) this.instance).setSessionBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public String getNode() {
                return ((Connect) this.instance).getNode();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public ByteString getNodeBytes() {
                return ((Connect) this.instance).getNodeBytes();
            }

            public Builder setNode(String str) {
                copyOnWrite();
                ((Connect) this.instance).setNode(str);
                return this;
            }

            public Builder clearNode() {
                copyOnWrite();
                ((Connect) this.instance).clearNode();
                return this;
            }

            public Builder setNodeBytes(ByteString byteString) {
                copyOnWrite();
                ((Connect) this.instance).setNodeBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectOrBuilder
            public long getTime() {
                return ((Connect) this.instance).getTime();
            }

            public Builder setTime(long j) {
                copyOnWrite();
                ((Connect) this.instance).setTime(j);
                return this;
            }

            public Builder clearTime() {
                copyOnWrite();
                ((Connect) this.instance).clearTime();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new Connect();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0000\u0001\u000b\u000b\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\n\u00042\u0005\u0007\u0006\u000b\u0007\u000b\b\u0007\tȈ\nȈ\u000b\u0002", new Object[]{"client_", "version_", "data_", "subs_", SubsDefaultEntryHolder.defaultEntry, "expires_", "ttl_", "ping_", "pong_", "session_", "node_", "time_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Connect> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Connect.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Connect connect = new Connect();
            DEFAULT_INSTANCE = connect;
            GeneratedMessageLite.registerDefaultInstance(Connect.class, connect);
        }

        public static Connect getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Connect> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Disconnect extends GeneratedMessageLite<Disconnect, Builder> implements DisconnectOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final Disconnect DEFAULT_INSTANCE;
        private static volatile Parser<Disconnect> PARSER = null;
        public static final int REASON_FIELD_NUMBER = 2;
        public static final int RECONNECT_FIELD_NUMBER = 3;
        private int code_;
        private String reason_ = "";
        private boolean reconnect_;

        private Disconnect() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.DisconnectOrBuilder
        public int getCode() {
            return this.code_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCode(int i) {
            this.code_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.code_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.DisconnectOrBuilder
        public String getReason() {
            return this.reason_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.DisconnectOrBuilder
        public ByteString getReasonBytes() {
            return ByteString.copyFromUtf8(this.reason_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReason(String str) {
            str.getClass();
            this.reason_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReason() {
            this.reason_ = getDefaultInstance().getReason();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReasonBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.reason_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.DisconnectOrBuilder
        public boolean getReconnect() {
            return this.reconnect_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReconnect(boolean z) {
            this.reconnect_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReconnect() {
            this.reconnect_ = false;
        }

        public static Disconnect parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Disconnect parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Disconnect parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Disconnect parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Disconnect parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Disconnect parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Disconnect parseFrom(InputStream inputStream) throws IOException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Disconnect parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Disconnect parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Disconnect) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Disconnect parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Disconnect) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Disconnect parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Disconnect parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Disconnect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Disconnect disconnect) {
            return DEFAULT_INSTANCE.createBuilder(disconnect);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Disconnect, Builder> implements DisconnectOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Disconnect.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.DisconnectOrBuilder
            public int getCode() {
                return ((Disconnect) this.instance).getCode();
            }

            public Builder setCode(int i) {
                copyOnWrite();
                ((Disconnect) this.instance).setCode(i);
                return this;
            }

            public Builder clearCode() {
                copyOnWrite();
                ((Disconnect) this.instance).clearCode();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.DisconnectOrBuilder
            public String getReason() {
                return ((Disconnect) this.instance).getReason();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.DisconnectOrBuilder
            public ByteString getReasonBytes() {
                return ((Disconnect) this.instance).getReasonBytes();
            }

            public Builder setReason(String str) {
                copyOnWrite();
                ((Disconnect) this.instance).setReason(str);
                return this;
            }

            public Builder clearReason() {
                copyOnWrite();
                ((Disconnect) this.instance).clearReason();
                return this;
            }

            public Builder setReasonBytes(ByteString byteString) {
                copyOnWrite();
                ((Disconnect) this.instance).setReasonBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.DisconnectOrBuilder
            public boolean getReconnect() {
                return ((Disconnect) this.instance).getReconnect();
            }

            public Builder setReconnect(boolean z) {
                copyOnWrite();
                ((Disconnect) this.instance).setReconnect(z);
                return this;
            }

            public Builder clearReconnect() {
                copyOnWrite();
                ((Disconnect) this.instance).clearReconnect();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new Disconnect();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002Ȉ\u0003\u0007", new Object[]{"code_", "reason_", "reconnect_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Disconnect> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Disconnect.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Disconnect disconnect = new Disconnect();
            DEFAULT_INSTANCE = disconnect;
            GeneratedMessageLite.registerDefaultInstance(Disconnect.class, disconnect);
        }

        public static Disconnect getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Disconnect> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Refresh extends GeneratedMessageLite<Refresh, Builder> implements RefreshOrBuilder {
        private static final Refresh DEFAULT_INSTANCE;
        public static final int EXPIRES_FIELD_NUMBER = 1;
        private static volatile Parser<Refresh> PARSER = null;
        public static final int TTL_FIELD_NUMBER = 2;
        private boolean expires_;
        private int ttl_;

        private Refresh() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshOrBuilder
        public boolean getExpires() {
            return this.expires_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExpires(boolean z) {
            this.expires_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExpires() {
            this.expires_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshOrBuilder
        public int getTtl() {
            return this.ttl_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTtl(int i) {
            this.ttl_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTtl() {
            this.ttl_ = 0;
        }

        public static Refresh parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Refresh) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Refresh parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Refresh) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Refresh parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Refresh) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Refresh parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Refresh) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Refresh parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Refresh) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Refresh parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Refresh) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Refresh parseFrom(InputStream inputStream) throws IOException {
            return (Refresh) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Refresh parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Refresh) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Refresh parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Refresh) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Refresh parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Refresh) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Refresh parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Refresh) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Refresh parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Refresh) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Refresh refresh) {
            return DEFAULT_INSTANCE.createBuilder(refresh);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Refresh, Builder> implements RefreshOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Refresh.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshOrBuilder
            public boolean getExpires() {
                return ((Refresh) this.instance).getExpires();
            }

            public Builder setExpires(boolean z) {
                copyOnWrite();
                ((Refresh) this.instance).setExpires(z);
                return this;
            }

            public Builder clearExpires() {
                copyOnWrite();
                ((Refresh) this.instance).clearExpires();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshOrBuilder
            public int getTtl() {
                return ((Refresh) this.instance).getTtl();
            }

            public Builder setTtl(int i) {
                copyOnWrite();
                ((Refresh) this.instance).setTtl(i);
                return this;
            }

            public Builder clearTtl() {
                copyOnWrite();
                ((Refresh) this.instance).clearTtl();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new Refresh();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002\u000b", new Object[]{"expires_", "ttl_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Refresh> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Refresh.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Refresh refresh = new Refresh();
            DEFAULT_INSTANCE = refresh;
            GeneratedMessageLite.registerDefaultInstance(Refresh.class, refresh);
        }

        public static Refresh getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Refresh> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ConnectRequest extends GeneratedMessageLite<ConnectRequest, Builder> implements ConnectRequestOrBuilder {
        public static final int DATA_FIELD_NUMBER = 2;
        private static final ConnectRequest DEFAULT_INSTANCE;
        public static final int FLAG_FIELD_NUMBER = 7;
        public static final int HEADERS_FIELD_NUMBER = 6;
        public static final int NAME_FIELD_NUMBER = 4;
        private static volatile Parser<ConnectRequest> PARSER = null;
        public static final int SUBS_FIELD_NUMBER = 3;
        public static final int TOKEN_FIELD_NUMBER = 1;
        public static final int VERSION_FIELD_NUMBER = 5;
        private long flag_;
        private MapFieldLite<String, SubscribeRequest> subs_ = MapFieldLite.emptyMapField();
        private MapFieldLite<String, String> headers_ = MapFieldLite.emptyMapField();
        private String token_ = "";
        private ByteString data_ = ByteString.EMPTY;
        private String name_ = "";
        private String version_ = "";

        private ConnectRequest() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public String getToken() {
            return this.token_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public ByteString getTokenBytes() {
            return ByteString.copyFromUtf8(this.token_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setToken(String str) {
            str.getClass();
            this.token_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearToken() {
            this.token_ = getDefaultInstance().getToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTokenBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.token_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(ByteString byteString) {
            byteString.getClass();
            this.data_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        private static final class SubsDefaultEntryHolder {
            static final MapEntryLite<String, SubscribeRequest> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, SubscribeRequest.getDefaultInstance());

            private SubsDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, SubscribeRequest> internalGetSubs() {
            return this.subs_;
        }

        private MapFieldLite<String, SubscribeRequest> internalGetMutableSubs() {
            if (!this.subs_.isMutable()) {
                this.subs_ = this.subs_.mutableCopy();
            }
            return this.subs_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public int getSubsCount() {
            return internalGetSubs().size();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public boolean containsSubs(String str) {
            str.getClass();
            return internalGetSubs().containsKey(str);
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        @Deprecated
        public Map<String, SubscribeRequest> getSubs() {
            return getSubsMap();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public Map<String, SubscribeRequest> getSubsMap() {
            return Collections.unmodifiableMap(internalGetSubs());
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public SubscribeRequest getSubsOrDefault(String str, SubscribeRequest subscribeRequest) {
            str.getClass();
            MapFieldLite<String, SubscribeRequest> mapFieldLiteInternalGetSubs = internalGetSubs();
            return mapFieldLiteInternalGetSubs.containsKey(str) ? mapFieldLiteInternalGetSubs.get(str) : subscribeRequest;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public SubscribeRequest getSubsOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, SubscribeRequest> mapFieldLiteInternalGetSubs = internalGetSubs();
            if (!mapFieldLiteInternalGetSubs.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return mapFieldLiteInternalGetSubs.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, SubscribeRequest> getMutableSubsMap() {
            return internalGetMutableSubs();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.name_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public String getVersion() {
            return this.version_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public ByteString getVersionBytes() {
            return ByteString.copyFromUtf8(this.version_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(String str) {
            str.getClass();
            this.version_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.version_ = getDefaultInstance().getVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.version_ = byteString.toStringUtf8();
        }

        private static final class HeadersDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

            private HeadersDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, String> internalGetHeaders() {
            return this.headers_;
        }

        private MapFieldLite<String, String> internalGetMutableHeaders() {
            if (!this.headers_.isMutable()) {
                this.headers_ = this.headers_.mutableCopy();
            }
            return this.headers_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public int getHeadersCount() {
            return internalGetHeaders().size();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public boolean containsHeaders(String str) {
            str.getClass();
            return internalGetHeaders().containsKey(str);
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        @Deprecated
        public Map<String, String> getHeaders() {
            return getHeadersMap();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public Map<String, String> getHeadersMap() {
            return Collections.unmodifiableMap(internalGetHeaders());
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public String getHeadersOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetHeaders = internalGetHeaders();
            return mapFieldLiteInternalGetHeaders.containsKey(str) ? mapFieldLiteInternalGetHeaders.get(str) : str2;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public String getHeadersOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> mapFieldLiteInternalGetHeaders = internalGetHeaders();
            if (!mapFieldLiteInternalGetHeaders.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return mapFieldLiteInternalGetHeaders.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableHeadersMap() {
            return internalGetMutableHeaders();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
        public long getFlag() {
            return this.flag_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFlag(long j) {
            this.flag_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFlag() {
            this.flag_ = 0L;
        }

        public static ConnectRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ConnectRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ConnectRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ConnectRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ConnectRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ConnectRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ConnectRequest parseFrom(InputStream inputStream) throws IOException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConnectRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConnectRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConnectRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConnectRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConnectRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConnectRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ConnectRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ConnectRequest connectRequest) {
            return DEFAULT_INSTANCE.createBuilder(connectRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ConnectRequest, Builder> implements ConnectRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ConnectRequest.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public String getToken() {
                return ((ConnectRequest) this.instance).getToken();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public ByteString getTokenBytes() {
                return ((ConnectRequest) this.instance).getTokenBytes();
            }

            public Builder setToken(String str) {
                copyOnWrite();
                ((ConnectRequest) this.instance).setToken(str);
                return this;
            }

            public Builder clearToken() {
                copyOnWrite();
                ((ConnectRequest) this.instance).clearToken();
                return this;
            }

            public Builder setTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((ConnectRequest) this.instance).setTokenBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public ByteString getData() {
                return ((ConnectRequest) this.instance).getData();
            }

            public Builder setData(ByteString byteString) {
                copyOnWrite();
                ((ConnectRequest) this.instance).setData(byteString);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((ConnectRequest) this.instance).clearData();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public int getSubsCount() {
                return ((ConnectRequest) this.instance).getSubsMap().size();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public boolean containsSubs(String str) {
                str.getClass();
                return ((ConnectRequest) this.instance).getSubsMap().containsKey(str);
            }

            public Builder clearSubs() {
                copyOnWrite();
                ((ConnectRequest) this.instance).getMutableSubsMap().clear();
                return this;
            }

            public Builder removeSubs(String str) {
                str.getClass();
                copyOnWrite();
                ((ConnectRequest) this.instance).getMutableSubsMap().remove(str);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            @Deprecated
            public Map<String, SubscribeRequest> getSubs() {
                return getSubsMap();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public Map<String, SubscribeRequest> getSubsMap() {
                return Collections.unmodifiableMap(((ConnectRequest) this.instance).getSubsMap());
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public SubscribeRequest getSubsOrDefault(String str, SubscribeRequest subscribeRequest) {
                str.getClass();
                Map<String, SubscribeRequest> subsMap = ((ConnectRequest) this.instance).getSubsMap();
                return subsMap.containsKey(str) ? subsMap.get(str) : subscribeRequest;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public SubscribeRequest getSubsOrThrow(String str) {
                str.getClass();
                Map<String, SubscribeRequest> subsMap = ((ConnectRequest) this.instance).getSubsMap();
                if (!subsMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return subsMap.get(str);
            }

            public Builder putSubs(String str, SubscribeRequest subscribeRequest) {
                str.getClass();
                subscribeRequest.getClass();
                copyOnWrite();
                ((ConnectRequest) this.instance).getMutableSubsMap().put(str, subscribeRequest);
                return this;
            }

            public Builder putAllSubs(Map<String, SubscribeRequest> map) {
                copyOnWrite();
                ((ConnectRequest) this.instance).getMutableSubsMap().putAll(map);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public String getName() {
                return ((ConnectRequest) this.instance).getName();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public ByteString getNameBytes() {
                return ((ConnectRequest) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((ConnectRequest) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((ConnectRequest) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((ConnectRequest) this.instance).setNameBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public String getVersion() {
                return ((ConnectRequest) this.instance).getVersion();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public ByteString getVersionBytes() {
                return ((ConnectRequest) this.instance).getVersionBytes();
            }

            public Builder setVersion(String str) {
                copyOnWrite();
                ((ConnectRequest) this.instance).setVersion(str);
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((ConnectRequest) this.instance).clearVersion();
                return this;
            }

            public Builder setVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((ConnectRequest) this.instance).setVersionBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public int getHeadersCount() {
                return ((ConnectRequest) this.instance).getHeadersMap().size();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public boolean containsHeaders(String str) {
                str.getClass();
                return ((ConnectRequest) this.instance).getHeadersMap().containsKey(str);
            }

            public Builder clearHeaders() {
                copyOnWrite();
                ((ConnectRequest) this.instance).getMutableHeadersMap().clear();
                return this;
            }

            public Builder removeHeaders(String str) {
                str.getClass();
                copyOnWrite();
                ((ConnectRequest) this.instance).getMutableHeadersMap().remove(str);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            @Deprecated
            public Map<String, String> getHeaders() {
                return getHeadersMap();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public Map<String, String> getHeadersMap() {
                return Collections.unmodifiableMap(((ConnectRequest) this.instance).getHeadersMap());
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public String getHeadersOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> headersMap = ((ConnectRequest) this.instance).getHeadersMap();
                return headersMap.containsKey(str) ? headersMap.get(str) : str2;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public String getHeadersOrThrow(String str) {
                str.getClass();
                Map<String, String> headersMap = ((ConnectRequest) this.instance).getHeadersMap();
                if (!headersMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return headersMap.get(str);
            }

            public Builder putHeaders(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((ConnectRequest) this.instance).getMutableHeadersMap().put(str, str2);
                return this;
            }

            public Builder putAllHeaders(Map<String, String> map) {
                copyOnWrite();
                ((ConnectRequest) this.instance).getMutableHeadersMap().putAll(map);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectRequestOrBuilder
            public long getFlag() {
                return ((ConnectRequest) this.instance).getFlag();
            }

            public Builder setFlag(long j) {
                copyOnWrite();
                ((ConnectRequest) this.instance).setFlag(j);
                return this;
            }

            public Builder clearFlag() {
                copyOnWrite();
                ((ConnectRequest) this.instance).clearFlag();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new ConnectRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0002\u0000\u0000\u0001Ȉ\u0002\n\u00032\u0004Ȉ\u0005Ȉ\u00062\u0007\u0002", new Object[]{"token_", "data_", "subs_", SubsDefaultEntryHolder.defaultEntry, "name_", "version_", "headers_", HeadersDefaultEntryHolder.defaultEntry, "flag_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ConnectRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ConnectRequest.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ConnectRequest connectRequest = new ConnectRequest();
            DEFAULT_INSTANCE = connectRequest;
            GeneratedMessageLite.registerDefaultInstance(ConnectRequest.class, connectRequest);
        }

        public static ConnectRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ConnectRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ConnectResult extends GeneratedMessageLite<ConnectResult, Builder> implements ConnectResultOrBuilder {
        public static final int CLIENT_FIELD_NUMBER = 1;
        public static final int DATA_FIELD_NUMBER = 5;
        private static final ConnectResult DEFAULT_INSTANCE;
        public static final int EXPIRES_FIELD_NUMBER = 3;
        public static final int NODE_FIELD_NUMBER = 10;
        private static volatile Parser<ConnectResult> PARSER = null;
        public static final int PING_FIELD_NUMBER = 7;
        public static final int PONG_FIELD_NUMBER = 8;
        public static final int SESSION_FIELD_NUMBER = 9;
        public static final int SUBS_FIELD_NUMBER = 6;
        public static final int TIME_FIELD_NUMBER = 11;
        public static final int TTL_FIELD_NUMBER = 4;
        public static final int VERSION_FIELD_NUMBER = 2;
        private boolean expires_;
        private int ping_;
        private boolean pong_;
        private long time_;
        private int ttl_;
        private MapFieldLite<String, SubscribeResult> subs_ = MapFieldLite.emptyMapField();
        private String client_ = "";
        private String version_ = "";
        private ByteString data_ = ByteString.EMPTY;
        private String session_ = "";
        private String node_ = "";

        private ConnectResult() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public String getClient() {
            return this.client_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public ByteString getClientBytes() {
            return ByteString.copyFromUtf8(this.client_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClient(String str) {
            str.getClass();
            this.client_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClient() {
            this.client_ = getDefaultInstance().getClient();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.client_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public String getVersion() {
            return this.version_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public ByteString getVersionBytes() {
            return ByteString.copyFromUtf8(this.version_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(String str) {
            str.getClass();
            this.version_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.version_ = getDefaultInstance().getVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.version_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public boolean getExpires() {
            return this.expires_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExpires(boolean z) {
            this.expires_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExpires() {
            this.expires_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public int getTtl() {
            return this.ttl_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTtl(int i) {
            this.ttl_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTtl() {
            this.ttl_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(ByteString byteString) {
            byteString.getClass();
            this.data_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        private static final class SubsDefaultEntryHolder {
            static final MapEntryLite<String, SubscribeResult> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, SubscribeResult.getDefaultInstance());

            private SubsDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, SubscribeResult> internalGetSubs() {
            return this.subs_;
        }

        private MapFieldLite<String, SubscribeResult> internalGetMutableSubs() {
            if (!this.subs_.isMutable()) {
                this.subs_ = this.subs_.mutableCopy();
            }
            return this.subs_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public int getSubsCount() {
            return internalGetSubs().size();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public boolean containsSubs(String str) {
            str.getClass();
            return internalGetSubs().containsKey(str);
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        @Deprecated
        public Map<String, SubscribeResult> getSubs() {
            return getSubsMap();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public Map<String, SubscribeResult> getSubsMap() {
            return Collections.unmodifiableMap(internalGetSubs());
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public SubscribeResult getSubsOrDefault(String str, SubscribeResult subscribeResult) {
            str.getClass();
            MapFieldLite<String, SubscribeResult> mapFieldLiteInternalGetSubs = internalGetSubs();
            return mapFieldLiteInternalGetSubs.containsKey(str) ? mapFieldLiteInternalGetSubs.get(str) : subscribeResult;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public SubscribeResult getSubsOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, SubscribeResult> mapFieldLiteInternalGetSubs = internalGetSubs();
            if (!mapFieldLiteInternalGetSubs.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return mapFieldLiteInternalGetSubs.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, SubscribeResult> getMutableSubsMap() {
            return internalGetMutableSubs();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public int getPing() {
            return this.ping_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPing(int i) {
            this.ping_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPing() {
            this.ping_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public boolean getPong() {
            return this.pong_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPong(boolean z) {
            this.pong_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPong() {
            this.pong_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public String getSession() {
            return this.session_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public ByteString getSessionBytes() {
            return ByteString.copyFromUtf8(this.session_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSession(String str) {
            str.getClass();
            this.session_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSession() {
            this.session_ = getDefaultInstance().getSession();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.session_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public String getNode() {
            return this.node_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public ByteString getNodeBytes() {
            return ByteString.copyFromUtf8(this.node_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNode(String str) {
            str.getClass();
            this.node_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNode() {
            this.node_ = getDefaultInstance().getNode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNodeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.node_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
        public long getTime() {
            return this.time_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(long j) {
            this.time_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.time_ = 0L;
        }

        public static ConnectResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ConnectResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ConnectResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConnectResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ConnectResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ConnectResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ConnectResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConnectResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ConnectResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ConnectResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ConnectResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConnectResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ConnectResult parseFrom(InputStream inputStream) throws IOException {
            return (ConnectResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConnectResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConnectResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConnectResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConnectResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConnectResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConnectResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConnectResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ConnectResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ConnectResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConnectResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ConnectResult connectResult) {
            return DEFAULT_INSTANCE.createBuilder(connectResult);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ConnectResult, Builder> implements ConnectResultOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ConnectResult.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public String getClient() {
                return ((ConnectResult) this.instance).getClient();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public ByteString getClientBytes() {
                return ((ConnectResult) this.instance).getClientBytes();
            }

            public Builder setClient(String str) {
                copyOnWrite();
                ((ConnectResult) this.instance).setClient(str);
                return this;
            }

            public Builder clearClient() {
                copyOnWrite();
                ((ConnectResult) this.instance).clearClient();
                return this;
            }

            public Builder setClientBytes(ByteString byteString) {
                copyOnWrite();
                ((ConnectResult) this.instance).setClientBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public String getVersion() {
                return ((ConnectResult) this.instance).getVersion();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public ByteString getVersionBytes() {
                return ((ConnectResult) this.instance).getVersionBytes();
            }

            public Builder setVersion(String str) {
                copyOnWrite();
                ((ConnectResult) this.instance).setVersion(str);
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((ConnectResult) this.instance).clearVersion();
                return this;
            }

            public Builder setVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((ConnectResult) this.instance).setVersionBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public boolean getExpires() {
                return ((ConnectResult) this.instance).getExpires();
            }

            public Builder setExpires(boolean z) {
                copyOnWrite();
                ((ConnectResult) this.instance).setExpires(z);
                return this;
            }

            public Builder clearExpires() {
                copyOnWrite();
                ((ConnectResult) this.instance).clearExpires();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public int getTtl() {
                return ((ConnectResult) this.instance).getTtl();
            }

            public Builder setTtl(int i) {
                copyOnWrite();
                ((ConnectResult) this.instance).setTtl(i);
                return this;
            }

            public Builder clearTtl() {
                copyOnWrite();
                ((ConnectResult) this.instance).clearTtl();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public ByteString getData() {
                return ((ConnectResult) this.instance).getData();
            }

            public Builder setData(ByteString byteString) {
                copyOnWrite();
                ((ConnectResult) this.instance).setData(byteString);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((ConnectResult) this.instance).clearData();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public int getSubsCount() {
                return ((ConnectResult) this.instance).getSubsMap().size();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public boolean containsSubs(String str) {
                str.getClass();
                return ((ConnectResult) this.instance).getSubsMap().containsKey(str);
            }

            public Builder clearSubs() {
                copyOnWrite();
                ((ConnectResult) this.instance).getMutableSubsMap().clear();
                return this;
            }

            public Builder removeSubs(String str) {
                str.getClass();
                copyOnWrite();
                ((ConnectResult) this.instance).getMutableSubsMap().remove(str);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            @Deprecated
            public Map<String, SubscribeResult> getSubs() {
                return getSubsMap();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public Map<String, SubscribeResult> getSubsMap() {
                return Collections.unmodifiableMap(((ConnectResult) this.instance).getSubsMap());
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public SubscribeResult getSubsOrDefault(String str, SubscribeResult subscribeResult) {
                str.getClass();
                Map<String, SubscribeResult> subsMap = ((ConnectResult) this.instance).getSubsMap();
                return subsMap.containsKey(str) ? subsMap.get(str) : subscribeResult;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public SubscribeResult getSubsOrThrow(String str) {
                str.getClass();
                Map<String, SubscribeResult> subsMap = ((ConnectResult) this.instance).getSubsMap();
                if (!subsMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return subsMap.get(str);
            }

            public Builder putSubs(String str, SubscribeResult subscribeResult) {
                str.getClass();
                subscribeResult.getClass();
                copyOnWrite();
                ((ConnectResult) this.instance).getMutableSubsMap().put(str, subscribeResult);
                return this;
            }

            public Builder putAllSubs(Map<String, SubscribeResult> map) {
                copyOnWrite();
                ((ConnectResult) this.instance).getMutableSubsMap().putAll(map);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public int getPing() {
                return ((ConnectResult) this.instance).getPing();
            }

            public Builder setPing(int i) {
                copyOnWrite();
                ((ConnectResult) this.instance).setPing(i);
                return this;
            }

            public Builder clearPing() {
                copyOnWrite();
                ((ConnectResult) this.instance).clearPing();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public boolean getPong() {
                return ((ConnectResult) this.instance).getPong();
            }

            public Builder setPong(boolean z) {
                copyOnWrite();
                ((ConnectResult) this.instance).setPong(z);
                return this;
            }

            public Builder clearPong() {
                copyOnWrite();
                ((ConnectResult) this.instance).clearPong();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public String getSession() {
                return ((ConnectResult) this.instance).getSession();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public ByteString getSessionBytes() {
                return ((ConnectResult) this.instance).getSessionBytes();
            }

            public Builder setSession(String str) {
                copyOnWrite();
                ((ConnectResult) this.instance).setSession(str);
                return this;
            }

            public Builder clearSession() {
                copyOnWrite();
                ((ConnectResult) this.instance).clearSession();
                return this;
            }

            public Builder setSessionBytes(ByteString byteString) {
                copyOnWrite();
                ((ConnectResult) this.instance).setSessionBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public String getNode() {
                return ((ConnectResult) this.instance).getNode();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public ByteString getNodeBytes() {
                return ((ConnectResult) this.instance).getNodeBytes();
            }

            public Builder setNode(String str) {
                copyOnWrite();
                ((ConnectResult) this.instance).setNode(str);
                return this;
            }

            public Builder clearNode() {
                copyOnWrite();
                ((ConnectResult) this.instance).clearNode();
                return this;
            }

            public Builder setNodeBytes(ByteString byteString) {
                copyOnWrite();
                ((ConnectResult) this.instance).setNodeBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.ConnectResultOrBuilder
            public long getTime() {
                return ((ConnectResult) this.instance).getTime();
            }

            public Builder setTime(long j) {
                copyOnWrite();
                ((ConnectResult) this.instance).setTime(j);
                return this;
            }

            public Builder clearTime() {
                copyOnWrite();
                ((ConnectResult) this.instance).clearTime();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new ConnectResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0000\u0001\u000b\u000b\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004\u000b\u0005\n\u00062\u0007\u000b\b\u0007\tȈ\nȈ\u000b\u0002", new Object[]{"client_", "version_", "expires_", "ttl_", "data_", "subs_", SubsDefaultEntryHolder.defaultEntry, "ping_", "pong_", "session_", "node_", "time_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ConnectResult> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ConnectResult.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ConnectResult connectResult = new ConnectResult();
            DEFAULT_INSTANCE = connectResult;
            GeneratedMessageLite.registerDefaultInstance(ConnectResult.class, connectResult);
        }

        public static ConnectResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ConnectResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class RefreshRequest extends GeneratedMessageLite<RefreshRequest, Builder> implements RefreshRequestOrBuilder {
        private static final RefreshRequest DEFAULT_INSTANCE;
        private static volatile Parser<RefreshRequest> PARSER = null;
        public static final int TOKEN_FIELD_NUMBER = 1;
        private String token_ = "";

        private RefreshRequest() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshRequestOrBuilder
        public String getToken() {
            return this.token_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshRequestOrBuilder
        public ByteString getTokenBytes() {
            return ByteString.copyFromUtf8(this.token_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setToken(String str) {
            str.getClass();
            this.token_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearToken() {
            this.token_ = getDefaultInstance().getToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTokenBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.token_ = byteString.toStringUtf8();
        }

        public static RefreshRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (RefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static RefreshRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RefreshRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (RefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RefreshRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RefreshRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (RefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RefreshRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RefreshRequest parseFrom(InputStream inputStream) throws IOException {
            return (RefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RefreshRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RefreshRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RefreshRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RefreshRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RefreshRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RefreshRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (RefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RefreshRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RefreshRequest refreshRequest) {
            return DEFAULT_INSTANCE.createBuilder(refreshRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<RefreshRequest, Builder> implements RefreshRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(RefreshRequest.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshRequestOrBuilder
            public String getToken() {
                return ((RefreshRequest) this.instance).getToken();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshRequestOrBuilder
            public ByteString getTokenBytes() {
                return ((RefreshRequest) this.instance).getTokenBytes();
            }

            public Builder setToken(String str) {
                copyOnWrite();
                ((RefreshRequest) this.instance).setToken(str);
                return this;
            }

            public Builder clearToken() {
                copyOnWrite();
                ((RefreshRequest) this.instance).clearToken();
                return this;
            }

            public Builder setTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((RefreshRequest) this.instance).setTokenBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new RefreshRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"token_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<RefreshRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (RefreshRequest.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            RefreshRequest refreshRequest = new RefreshRequest();
            DEFAULT_INSTANCE = refreshRequest;
            GeneratedMessageLite.registerDefaultInstance(RefreshRequest.class, refreshRequest);
        }

        public static RefreshRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RefreshRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class RefreshResult extends GeneratedMessageLite<RefreshResult, Builder> implements RefreshResultOrBuilder {
        public static final int CLIENT_FIELD_NUMBER = 1;
        private static final RefreshResult DEFAULT_INSTANCE;
        public static final int EXPIRES_FIELD_NUMBER = 3;
        private static volatile Parser<RefreshResult> PARSER = null;
        public static final int TTL_FIELD_NUMBER = 4;
        public static final int VERSION_FIELD_NUMBER = 2;
        private boolean expires_;
        private int ttl_;
        private String client_ = "";
        private String version_ = "";

        private RefreshResult() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshResultOrBuilder
        public String getClient() {
            return this.client_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshResultOrBuilder
        public ByteString getClientBytes() {
            return ByteString.copyFromUtf8(this.client_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClient(String str) {
            str.getClass();
            this.client_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClient() {
            this.client_ = getDefaultInstance().getClient();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.client_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshResultOrBuilder
        public String getVersion() {
            return this.version_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshResultOrBuilder
        public ByteString getVersionBytes() {
            return ByteString.copyFromUtf8(this.version_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(String str) {
            str.getClass();
            this.version_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.version_ = getDefaultInstance().getVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.version_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshResultOrBuilder
        public boolean getExpires() {
            return this.expires_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExpires(boolean z) {
            this.expires_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExpires() {
            this.expires_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshResultOrBuilder
        public int getTtl() {
            return this.ttl_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTtl(int i) {
            this.ttl_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTtl() {
            this.ttl_ = 0;
        }

        public static RefreshResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (RefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static RefreshResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RefreshResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (RefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RefreshResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RefreshResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (RefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RefreshResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RefreshResult parseFrom(InputStream inputStream) throws IOException {
            return (RefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RefreshResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RefreshResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RefreshResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RefreshResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RefreshResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RefreshResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (RefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RefreshResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RefreshResult refreshResult) {
            return DEFAULT_INSTANCE.createBuilder(refreshResult);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<RefreshResult, Builder> implements RefreshResultOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(RefreshResult.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshResultOrBuilder
            public String getClient() {
                return ((RefreshResult) this.instance).getClient();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshResultOrBuilder
            public ByteString getClientBytes() {
                return ((RefreshResult) this.instance).getClientBytes();
            }

            public Builder setClient(String str) {
                copyOnWrite();
                ((RefreshResult) this.instance).setClient(str);
                return this;
            }

            public Builder clearClient() {
                copyOnWrite();
                ((RefreshResult) this.instance).clearClient();
                return this;
            }

            public Builder setClientBytes(ByteString byteString) {
                copyOnWrite();
                ((RefreshResult) this.instance).setClientBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshResultOrBuilder
            public String getVersion() {
                return ((RefreshResult) this.instance).getVersion();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshResultOrBuilder
            public ByteString getVersionBytes() {
                return ((RefreshResult) this.instance).getVersionBytes();
            }

            public Builder setVersion(String str) {
                copyOnWrite();
                ((RefreshResult) this.instance).setVersion(str);
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((RefreshResult) this.instance).clearVersion();
                return this;
            }

            public Builder setVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((RefreshResult) this.instance).setVersionBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshResultOrBuilder
            public boolean getExpires() {
                return ((RefreshResult) this.instance).getExpires();
            }

            public Builder setExpires(boolean z) {
                copyOnWrite();
                ((RefreshResult) this.instance).setExpires(z);
                return this;
            }

            public Builder clearExpires() {
                copyOnWrite();
                ((RefreshResult) this.instance).clearExpires();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RefreshResultOrBuilder
            public int getTtl() {
                return ((RefreshResult) this.instance).getTtl();
            }

            public Builder setTtl(int i) {
                copyOnWrite();
                ((RefreshResult) this.instance).setTtl(i);
                return this;
            }

            public Builder clearTtl() {
                copyOnWrite();
                ((RefreshResult) this.instance).clearTtl();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new RefreshResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004\u000b", new Object[]{"client_", "version_", "expires_", "ttl_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<RefreshResult> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (RefreshResult.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            RefreshResult refreshResult = new RefreshResult();
            DEFAULT_INSTANCE = refreshResult;
            GeneratedMessageLite.registerDefaultInstance(RefreshResult.class, refreshResult);
        }

        public static RefreshResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RefreshResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SubscribeRequest extends GeneratedMessageLite<SubscribeRequest, Builder> implements SubscribeRequestOrBuilder {
        public static final int ASC_FIELD_NUMBER = 19;
        public static final int CHANNEL_FIELD_NUMBER = 1;
        public static final int CURSOR_FIELD_NUMBER = 17;
        public static final int DATA_FIELD_NUMBER = 8;
        private static final SubscribeRequest DEFAULT_INSTANCE;
        public static final int DELTA_FIELD_NUMBER = 12;
        public static final int EPOCH_FIELD_NUMBER = 6;
        public static final int FLAG_FIELD_NUMBER = 14;
        public static final int JOIN_LEAVE_FIELD_NUMBER = 11;
        public static final int LIMIT_FIELD_NUMBER = 18;
        public static final int OFFSET_FIELD_NUMBER = 7;
        private static volatile Parser<SubscribeRequest> PARSER = null;
        public static final int PHASE_FIELD_NUMBER = 16;
        public static final int POSITIONED_FIELD_NUMBER = 9;
        public static final int RECOVERABLE_FIELD_NUMBER = 10;
        public static final int RECOVER_FIELD_NUMBER = 3;
        public static final int TF_FIELD_NUMBER = 13;
        public static final int TOKEN_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 15;
        private boolean asc_;
        private int bitField0_;
        private long flag_;
        private boolean joinLeave_;
        private int limit_;
        private long offset_;
        private int phase_;
        private boolean positioned_;
        private boolean recover_;
        private boolean recoverable_;
        private FilterNode tf_;
        private int type_;
        private String channel_ = "";
        private String token_ = "";
        private String epoch_ = "";
        private ByteString data_ = ByteString.EMPTY;
        private String delta_ = "";
        private String cursor_ = "";

        private SubscribeRequest() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public String getChannel() {
            return this.channel_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public ByteString getChannelBytes() {
            return ByteString.copyFromUtf8(this.channel_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannel(String str) {
            str.getClass();
            this.channel_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannel() {
            this.channel_ = getDefaultInstance().getChannel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.channel_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public String getToken() {
            return this.token_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public ByteString getTokenBytes() {
            return ByteString.copyFromUtf8(this.token_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setToken(String str) {
            str.getClass();
            this.token_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearToken() {
            this.token_ = getDefaultInstance().getToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTokenBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.token_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public boolean getRecover() {
            return this.recover_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRecover(boolean z) {
            this.recover_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRecover() {
            this.recover_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public String getEpoch() {
            return this.epoch_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public ByteString getEpochBytes() {
            return ByteString.copyFromUtf8(this.epoch_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEpoch(String str) {
            str.getClass();
            this.epoch_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEpoch() {
            this.epoch_ = getDefaultInstance().getEpoch();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEpochBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.epoch_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public long getOffset() {
            return this.offset_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOffset(long j) {
            this.offset_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOffset() {
            this.offset_ = 0L;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(ByteString byteString) {
            byteString.getClass();
            this.data_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public boolean getPositioned() {
            return this.positioned_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPositioned(boolean z) {
            this.positioned_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPositioned() {
            this.positioned_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public boolean getRecoverable() {
            return this.recoverable_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRecoverable(boolean z) {
            this.recoverable_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRecoverable() {
            this.recoverable_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public boolean getJoinLeave() {
            return this.joinLeave_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJoinLeave(boolean z) {
            this.joinLeave_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearJoinLeave() {
            this.joinLeave_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public String getDelta() {
            return this.delta_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public ByteString getDeltaBytes() {
            return ByteString.copyFromUtf8(this.delta_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDelta(String str) {
            str.getClass();
            this.delta_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDelta() {
            this.delta_ = getDefaultInstance().getDelta();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeltaBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.delta_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public boolean hasTf() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public FilterNode getTf() {
            FilterNode filterNode = this.tf_;
            return filterNode == null ? FilterNode.getDefaultInstance() : filterNode;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTf(FilterNode filterNode) {
            filterNode.getClass();
            this.tf_ = filterNode;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTf(FilterNode filterNode) {
            filterNode.getClass();
            FilterNode filterNode2 = this.tf_;
            if (filterNode2 != null && filterNode2 != FilterNode.getDefaultInstance()) {
                this.tf_ = FilterNode.newBuilder(this.tf_).mergeFrom(filterNode).buildPartial();
            } else {
                this.tf_ = filterNode;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTf() {
            this.tf_ = null;
            this.bitField0_ &= -2;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public long getFlag() {
            return this.flag_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFlag(long j) {
            this.flag_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFlag() {
            this.flag_ = 0L;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public int getType() {
            return this.type_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(int i) {
            this.type_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.type_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public int getPhase() {
            return this.phase_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPhase(int i) {
            this.phase_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPhase() {
            this.phase_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public String getCursor() {
            return this.cursor_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public ByteString getCursorBytes() {
            return ByteString.copyFromUtf8(this.cursor_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCursor(String str) {
            str.getClass();
            this.cursor_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCursor() {
            this.cursor_ = getDefaultInstance().getCursor();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCursorBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.cursor_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public int getLimit() {
            return this.limit_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLimit(int i) {
            this.limit_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLimit() {
            this.limit_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
        public boolean getAsc() {
            return this.asc_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAsc(boolean z) {
            this.asc_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAsc() {
            this.asc_ = false;
        }

        public static SubscribeRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SubscribeRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SubscribeRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SubscribeRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SubscribeRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SubscribeRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SubscribeRequest parseFrom(InputStream inputStream) throws IOException {
            return (SubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SubscribeRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SubscribeRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SubscribeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SubscribeRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubscribeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SubscribeRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SubscribeRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SubscribeRequest subscribeRequest) {
            return DEFAULT_INSTANCE.createBuilder(subscribeRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SubscribeRequest, Builder> implements SubscribeRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SubscribeRequest.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public String getChannel() {
                return ((SubscribeRequest) this.instance).getChannel();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public ByteString getChannelBytes() {
                return ((SubscribeRequest) this.instance).getChannelBytes();
            }

            public Builder setChannel(String str) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setChannel(str);
                return this;
            }

            public Builder clearChannel() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearChannel();
                return this;
            }

            public Builder setChannelBytes(ByteString byteString) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setChannelBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public String getToken() {
                return ((SubscribeRequest) this.instance).getToken();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public ByteString getTokenBytes() {
                return ((SubscribeRequest) this.instance).getTokenBytes();
            }

            public Builder setToken(String str) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setToken(str);
                return this;
            }

            public Builder clearToken() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearToken();
                return this;
            }

            public Builder setTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setTokenBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public boolean getRecover() {
                return ((SubscribeRequest) this.instance).getRecover();
            }

            public Builder setRecover(boolean z) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setRecover(z);
                return this;
            }

            public Builder clearRecover() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearRecover();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public String getEpoch() {
                return ((SubscribeRequest) this.instance).getEpoch();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public ByteString getEpochBytes() {
                return ((SubscribeRequest) this.instance).getEpochBytes();
            }

            public Builder setEpoch(String str) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setEpoch(str);
                return this;
            }

            public Builder clearEpoch() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearEpoch();
                return this;
            }

            public Builder setEpochBytes(ByteString byteString) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setEpochBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public long getOffset() {
                return ((SubscribeRequest) this.instance).getOffset();
            }

            public Builder setOffset(long j) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setOffset(j);
                return this;
            }

            public Builder clearOffset() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearOffset();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public ByteString getData() {
                return ((SubscribeRequest) this.instance).getData();
            }

            public Builder setData(ByteString byteString) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setData(byteString);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearData();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public boolean getPositioned() {
                return ((SubscribeRequest) this.instance).getPositioned();
            }

            public Builder setPositioned(boolean z) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setPositioned(z);
                return this;
            }

            public Builder clearPositioned() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearPositioned();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public boolean getRecoverable() {
                return ((SubscribeRequest) this.instance).getRecoverable();
            }

            public Builder setRecoverable(boolean z) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setRecoverable(z);
                return this;
            }

            public Builder clearRecoverable() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearRecoverable();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public boolean getJoinLeave() {
                return ((SubscribeRequest) this.instance).getJoinLeave();
            }

            public Builder setJoinLeave(boolean z) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setJoinLeave(z);
                return this;
            }

            public Builder clearJoinLeave() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearJoinLeave();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public String getDelta() {
                return ((SubscribeRequest) this.instance).getDelta();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public ByteString getDeltaBytes() {
                return ((SubscribeRequest) this.instance).getDeltaBytes();
            }

            public Builder setDelta(String str) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setDelta(str);
                return this;
            }

            public Builder clearDelta() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearDelta();
                return this;
            }

            public Builder setDeltaBytes(ByteString byteString) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setDeltaBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public boolean hasTf() {
                return ((SubscribeRequest) this.instance).hasTf();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public FilterNode getTf() {
                return ((SubscribeRequest) this.instance).getTf();
            }

            public Builder setTf(FilterNode filterNode) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setTf(filterNode);
                return this;
            }

            public Builder setTf(FilterNode.Builder builder) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setTf(builder.build());
                return this;
            }

            public Builder mergeTf(FilterNode filterNode) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).mergeTf(filterNode);
                return this;
            }

            public Builder clearTf() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearTf();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public long getFlag() {
                return ((SubscribeRequest) this.instance).getFlag();
            }

            public Builder setFlag(long j) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setFlag(j);
                return this;
            }

            public Builder clearFlag() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearFlag();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public int getType() {
                return ((SubscribeRequest) this.instance).getType();
            }

            public Builder setType(int i) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setType(i);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearType();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public int getPhase() {
                return ((SubscribeRequest) this.instance).getPhase();
            }

            public Builder setPhase(int i) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setPhase(i);
                return this;
            }

            public Builder clearPhase() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearPhase();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public String getCursor() {
                return ((SubscribeRequest) this.instance).getCursor();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public ByteString getCursorBytes() {
                return ((SubscribeRequest) this.instance).getCursorBytes();
            }

            public Builder setCursor(String str) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setCursor(str);
                return this;
            }

            public Builder clearCursor() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearCursor();
                return this;
            }

            public Builder setCursorBytes(ByteString byteString) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setCursorBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public int getLimit() {
                return ((SubscribeRequest) this.instance).getLimit();
            }

            public Builder setLimit(int i) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setLimit(i);
                return this;
            }

            public Builder clearLimit() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearLimit();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeRequestOrBuilder
            public boolean getAsc() {
                return ((SubscribeRequest) this.instance).getAsc();
            }

            public Builder setAsc(boolean z) {
                copyOnWrite();
                ((SubscribeRequest) this.instance).setAsc(z);
                return this;
            }

            public Builder clearAsc() {
                copyOnWrite();
                ((SubscribeRequest) this.instance).clearAsc();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SubscribeRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0006Ȉ\u0007\u0003\b\n\t\u0007\n\u0007\u000b\u0007\fȈ\rဉ\u0000\u000e\u0002\u000f\u0004\u0010\u0004\u0011Ȉ\u0012\u0004\u0013\u0007", new Object[]{"bitField0_", "channel_", "token_", "recover_", "epoch_", "offset_", "data_", "positioned_", "recoverable_", "joinLeave_", "delta_", "tf_", "flag_", "type_", "phase_", "cursor_", "limit_", "asc_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SubscribeRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SubscribeRequest.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            SubscribeRequest subscribeRequest = new SubscribeRequest();
            DEFAULT_INSTANCE = subscribeRequest;
            GeneratedMessageLite.registerDefaultInstance(SubscribeRequest.class, subscribeRequest);
        }

        public static SubscribeRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SubscribeRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SubscribeResult extends GeneratedMessageLite<SubscribeResult, Builder> implements SubscribeResultOrBuilder {
        public static final int CURSOR_FIELD_NUMBER = 17;
        public static final int DATA_FIELD_NUMBER = 11;
        private static final SubscribeResult DEFAULT_INSTANCE;
        public static final int DELTA_FIELD_NUMBER = 13;
        public static final int EPOCH_FIELD_NUMBER = 6;
        public static final int EXPIRES_FIELD_NUMBER = 1;
        public static final int ID_FIELD_NUMBER = 14;
        public static final int OFFSET_FIELD_NUMBER = 9;
        private static volatile Parser<SubscribeResult> PARSER = null;
        public static final int PHASE_FIELD_NUMBER = 16;
        public static final int POSITIONED_FIELD_NUMBER = 10;
        public static final int PUBLICATIONS_FIELD_NUMBER = 7;
        public static final int PUBLISH_DEBOUNCE_FIELD_NUMBER = 19;
        public static final int RECOVERABLE_FIELD_NUMBER = 3;
        public static final int RECOVERED_FIELD_NUMBER = 8;
        public static final int STATE_FIELD_NUMBER = 18;
        public static final int TTL_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 15;
        public static final int WAS_RECOVERING_FIELD_NUMBER = 12;
        private boolean delta_;
        private boolean expires_;
        private long id_;
        private long offset_;
        private int phase_;
        private boolean positioned_;
        private int publishDebounce_;
        private boolean recoverable_;
        private boolean recovered_;
        private int ttl_;
        private int type_;
        private boolean wasRecovering_;
        private String epoch_ = "";
        private Internal.ProtobufList<Publication> publications_ = emptyProtobufList();
        private ByteString data_ = ByteString.EMPTY;
        private String cursor_ = "";
        private Internal.ProtobufList<Publication> state_ = emptyProtobufList();

        private SubscribeResult() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public boolean getExpires() {
            return this.expires_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExpires(boolean z) {
            this.expires_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExpires() {
            this.expires_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public int getTtl() {
            return this.ttl_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTtl(int i) {
            this.ttl_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTtl() {
            this.ttl_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public boolean getRecoverable() {
            return this.recoverable_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRecoverable(boolean z) {
            this.recoverable_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRecoverable() {
            this.recoverable_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public String getEpoch() {
            return this.epoch_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public ByteString getEpochBytes() {
            return ByteString.copyFromUtf8(this.epoch_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEpoch(String str) {
            str.getClass();
            this.epoch_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEpoch() {
            this.epoch_ = getDefaultInstance().getEpoch();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEpochBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.epoch_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public List<Publication> getPublicationsList() {
            return this.publications_;
        }

        public List<? extends PublicationOrBuilder> getPublicationsOrBuilderList() {
            return this.publications_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public int getPublicationsCount() {
            return this.publications_.size();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public Publication getPublications(int i) {
            return this.publications_.get(i);
        }

        public PublicationOrBuilder getPublicationsOrBuilder(int i) {
            return this.publications_.get(i);
        }

        private void ensurePublicationsIsMutable() {
            Internal.ProtobufList<Publication> protobufList = this.publications_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.publications_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPublications(int i, Publication publication) {
            publication.getClass();
            ensurePublicationsIsMutable();
            this.publications_.set(i, publication);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPublications(Publication publication) {
            publication.getClass();
            ensurePublicationsIsMutable();
            this.publications_.add(publication);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPublications(int i, Publication publication) {
            publication.getClass();
            ensurePublicationsIsMutable();
            this.publications_.add(i, publication);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllPublications(Iterable<? extends Publication> iterable) {
            ensurePublicationsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.publications_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPublications() {
            this.publications_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removePublications(int i) {
            ensurePublicationsIsMutable();
            this.publications_.remove(i);
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public boolean getRecovered() {
            return this.recovered_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRecovered(boolean z) {
            this.recovered_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRecovered() {
            this.recovered_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public long getOffset() {
            return this.offset_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOffset(long j) {
            this.offset_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOffset() {
            this.offset_ = 0L;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public boolean getPositioned() {
            return this.positioned_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPositioned(boolean z) {
            this.positioned_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPositioned() {
            this.positioned_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(ByteString byteString) {
            byteString.getClass();
            this.data_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public boolean getWasRecovering() {
            return this.wasRecovering_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWasRecovering(boolean z) {
            this.wasRecovering_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWasRecovering() {
            this.wasRecovering_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public boolean getDelta() {
            return this.delta_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDelta(boolean z) {
            this.delta_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDelta() {
            this.delta_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public long getId() {
            return this.id_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(long j) {
            this.id_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.id_ = 0L;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public int getType() {
            return this.type_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(int i) {
            this.type_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.type_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public int getPhase() {
            return this.phase_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPhase(int i) {
            this.phase_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPhase() {
            this.phase_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public String getCursor() {
            return this.cursor_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public ByteString getCursorBytes() {
            return ByteString.copyFromUtf8(this.cursor_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCursor(String str) {
            str.getClass();
            this.cursor_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCursor() {
            this.cursor_ = getDefaultInstance().getCursor();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCursorBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.cursor_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public List<Publication> getStateList() {
            return this.state_;
        }

        public List<? extends PublicationOrBuilder> getStateOrBuilderList() {
            return this.state_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public int getStateCount() {
            return this.state_.size();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public Publication getState(int i) {
            return this.state_.get(i);
        }

        public PublicationOrBuilder getStateOrBuilder(int i) {
            return this.state_.get(i);
        }

        private void ensureStateIsMutable() {
            Internal.ProtobufList<Publication> protobufList = this.state_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.state_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setState(int i, Publication publication) {
            publication.getClass();
            ensureStateIsMutable();
            this.state_.set(i, publication);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addState(Publication publication) {
            publication.getClass();
            ensureStateIsMutable();
            this.state_.add(publication);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addState(int i, Publication publication) {
            publication.getClass();
            ensureStateIsMutable();
            this.state_.add(i, publication);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllState(Iterable<? extends Publication> iterable) {
            ensureStateIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.state_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearState() {
            this.state_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeState(int i) {
            ensureStateIsMutable();
            this.state_.remove(i);
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
        public int getPublishDebounce() {
            return this.publishDebounce_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPublishDebounce(int i) {
            this.publishDebounce_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPublishDebounce() {
            this.publishDebounce_ = 0;
        }

        public static SubscribeResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SubscribeResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SubscribeResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SubscribeResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SubscribeResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SubscribeResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SubscribeResult parseFrom(InputStream inputStream) throws IOException {
            return (SubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SubscribeResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SubscribeResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SubscribeResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SubscribeResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubscribeResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SubscribeResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SubscribeResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SubscribeResult subscribeResult) {
            return DEFAULT_INSTANCE.createBuilder(subscribeResult);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SubscribeResult, Builder> implements SubscribeResultOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SubscribeResult.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public boolean getExpires() {
                return ((SubscribeResult) this.instance).getExpires();
            }

            public Builder setExpires(boolean z) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setExpires(z);
                return this;
            }

            public Builder clearExpires() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearExpires();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public int getTtl() {
                return ((SubscribeResult) this.instance).getTtl();
            }

            public Builder setTtl(int i) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setTtl(i);
                return this;
            }

            public Builder clearTtl() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearTtl();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public boolean getRecoverable() {
                return ((SubscribeResult) this.instance).getRecoverable();
            }

            public Builder setRecoverable(boolean z) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setRecoverable(z);
                return this;
            }

            public Builder clearRecoverable() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearRecoverable();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public String getEpoch() {
                return ((SubscribeResult) this.instance).getEpoch();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public ByteString getEpochBytes() {
                return ((SubscribeResult) this.instance).getEpochBytes();
            }

            public Builder setEpoch(String str) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setEpoch(str);
                return this;
            }

            public Builder clearEpoch() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearEpoch();
                return this;
            }

            public Builder setEpochBytes(ByteString byteString) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setEpochBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public List<Publication> getPublicationsList() {
                return Collections.unmodifiableList(((SubscribeResult) this.instance).getPublicationsList());
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public int getPublicationsCount() {
                return ((SubscribeResult) this.instance).getPublicationsCount();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public Publication getPublications(int i) {
                return ((SubscribeResult) this.instance).getPublications(i);
            }

            public Builder setPublications(int i, Publication publication) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setPublications(i, publication);
                return this;
            }

            public Builder setPublications(int i, Publication.Builder builder) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setPublications(i, builder.build());
                return this;
            }

            public Builder addPublications(Publication publication) {
                copyOnWrite();
                ((SubscribeResult) this.instance).addPublications(publication);
                return this;
            }

            public Builder addPublications(int i, Publication publication) {
                copyOnWrite();
                ((SubscribeResult) this.instance).addPublications(i, publication);
                return this;
            }

            public Builder addPublications(Publication.Builder builder) {
                copyOnWrite();
                ((SubscribeResult) this.instance).addPublications(builder.build());
                return this;
            }

            public Builder addPublications(int i, Publication.Builder builder) {
                copyOnWrite();
                ((SubscribeResult) this.instance).addPublications(i, builder.build());
                return this;
            }

            public Builder addAllPublications(Iterable<? extends Publication> iterable) {
                copyOnWrite();
                ((SubscribeResult) this.instance).addAllPublications(iterable);
                return this;
            }

            public Builder clearPublications() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearPublications();
                return this;
            }

            public Builder removePublications(int i) {
                copyOnWrite();
                ((SubscribeResult) this.instance).removePublications(i);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public boolean getRecovered() {
                return ((SubscribeResult) this.instance).getRecovered();
            }

            public Builder setRecovered(boolean z) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setRecovered(z);
                return this;
            }

            public Builder clearRecovered() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearRecovered();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public long getOffset() {
                return ((SubscribeResult) this.instance).getOffset();
            }

            public Builder setOffset(long j) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setOffset(j);
                return this;
            }

            public Builder clearOffset() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearOffset();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public boolean getPositioned() {
                return ((SubscribeResult) this.instance).getPositioned();
            }

            public Builder setPositioned(boolean z) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setPositioned(z);
                return this;
            }

            public Builder clearPositioned() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearPositioned();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public ByteString getData() {
                return ((SubscribeResult) this.instance).getData();
            }

            public Builder setData(ByteString byteString) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setData(byteString);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearData();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public boolean getWasRecovering() {
                return ((SubscribeResult) this.instance).getWasRecovering();
            }

            public Builder setWasRecovering(boolean z) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setWasRecovering(z);
                return this;
            }

            public Builder clearWasRecovering() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearWasRecovering();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public boolean getDelta() {
                return ((SubscribeResult) this.instance).getDelta();
            }

            public Builder setDelta(boolean z) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setDelta(z);
                return this;
            }

            public Builder clearDelta() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearDelta();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public long getId() {
                return ((SubscribeResult) this.instance).getId();
            }

            public Builder setId(long j) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setId(j);
                return this;
            }

            public Builder clearId() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearId();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public int getType() {
                return ((SubscribeResult) this.instance).getType();
            }

            public Builder setType(int i) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setType(i);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearType();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public int getPhase() {
                return ((SubscribeResult) this.instance).getPhase();
            }

            public Builder setPhase(int i) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setPhase(i);
                return this;
            }

            public Builder clearPhase() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearPhase();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public String getCursor() {
                return ((SubscribeResult) this.instance).getCursor();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public ByteString getCursorBytes() {
                return ((SubscribeResult) this.instance).getCursorBytes();
            }

            public Builder setCursor(String str) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setCursor(str);
                return this;
            }

            public Builder clearCursor() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearCursor();
                return this;
            }

            public Builder setCursorBytes(ByteString byteString) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setCursorBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public List<Publication> getStateList() {
                return Collections.unmodifiableList(((SubscribeResult) this.instance).getStateList());
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public int getStateCount() {
                return ((SubscribeResult) this.instance).getStateCount();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public Publication getState(int i) {
                return ((SubscribeResult) this.instance).getState(i);
            }

            public Builder setState(int i, Publication publication) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setState(i, publication);
                return this;
            }

            public Builder setState(int i, Publication.Builder builder) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setState(i, builder.build());
                return this;
            }

            public Builder addState(Publication publication) {
                copyOnWrite();
                ((SubscribeResult) this.instance).addState(publication);
                return this;
            }

            public Builder addState(int i, Publication publication) {
                copyOnWrite();
                ((SubscribeResult) this.instance).addState(i, publication);
                return this;
            }

            public Builder addState(Publication.Builder builder) {
                copyOnWrite();
                ((SubscribeResult) this.instance).addState(builder.build());
                return this;
            }

            public Builder addState(int i, Publication.Builder builder) {
                copyOnWrite();
                ((SubscribeResult) this.instance).addState(i, builder.build());
                return this;
            }

            public Builder addAllState(Iterable<? extends Publication> iterable) {
                copyOnWrite();
                ((SubscribeResult) this.instance).addAllState(iterable);
                return this;
            }

            public Builder clearState() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearState();
                return this;
            }

            public Builder removeState(int i) {
                copyOnWrite();
                ((SubscribeResult) this.instance).removeState(i);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubscribeResultOrBuilder
            public int getPublishDebounce() {
                return ((SubscribeResult) this.instance).getPublishDebounce();
            }

            public Builder setPublishDebounce(int i) {
                copyOnWrite();
                ((SubscribeResult) this.instance).setPublishDebounce(i);
                return this;
            }

            public Builder clearPublishDebounce() {
                copyOnWrite();
                ((SubscribeResult) this.instance).clearPublishDebounce();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SubscribeResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0011\u0000\u0000\u0001\u0013\u0011\u0000\u0002\u0000\u0001\u0007\u0002\u000b\u0003\u0007\u0006Ȉ\u0007\u001b\b\u0007\t\u0003\n\u0007\u000b\n\f\u0007\r\u0007\u000e\u0002\u000f\u0004\u0010\u0004\u0011Ȉ\u0012\u001b\u0013\u000b", new Object[]{"expires_", "ttl_", "recoverable_", "epoch_", "publications_", Publication.class, "recovered_", "offset_", "positioned_", "data_", "wasRecovering_", "delta_", "id_", "type_", "phase_", "cursor_", "state_", Publication.class, "publishDebounce_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SubscribeResult> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SubscribeResult.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            SubscribeResult subscribeResult = new SubscribeResult();
            DEFAULT_INSTANCE = subscribeResult;
            GeneratedMessageLite.registerDefaultInstance(SubscribeResult.class, subscribeResult);
        }

        public static SubscribeResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SubscribeResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class KeyedItem extends GeneratedMessageLite<KeyedItem, Builder> implements KeyedItemOrBuilder {
        private static final KeyedItem DEFAULT_INSTANCE;
        public static final int KEY_FIELD_NUMBER = 1;
        private static volatile Parser<KeyedItem> PARSER = null;
        public static final int VERSION_FIELD_NUMBER = 2;
        private String key_ = "";
        private long version_;

        private KeyedItem() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.KeyedItemOrBuilder
        public String getKey() {
            return this.key_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.KeyedItemOrBuilder
        public ByteString getKeyBytes() {
            return ByteString.copyFromUtf8(this.key_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKey(String str) {
            str.getClass();
            this.key_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKey() {
            this.key_ = getDefaultInstance().getKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.key_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.KeyedItemOrBuilder
        public long getVersion() {
            return this.version_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(long j) {
            this.version_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.version_ = 0L;
        }

        public static KeyedItem parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (KeyedItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static KeyedItem parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (KeyedItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static KeyedItem parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (KeyedItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static KeyedItem parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (KeyedItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static KeyedItem parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (KeyedItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static KeyedItem parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (KeyedItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static KeyedItem parseFrom(InputStream inputStream) throws IOException {
            return (KeyedItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KeyedItem parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (KeyedItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static KeyedItem parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (KeyedItem) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KeyedItem parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (KeyedItem) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static KeyedItem parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (KeyedItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static KeyedItem parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (KeyedItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(KeyedItem keyedItem) {
            return DEFAULT_INSTANCE.createBuilder(keyedItem);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<KeyedItem, Builder> implements KeyedItemOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(KeyedItem.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.KeyedItemOrBuilder
            public String getKey() {
                return ((KeyedItem) this.instance).getKey();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.KeyedItemOrBuilder
            public ByteString getKeyBytes() {
                return ((KeyedItem) this.instance).getKeyBytes();
            }

            public Builder setKey(String str) {
                copyOnWrite();
                ((KeyedItem) this.instance).setKey(str);
                return this;
            }

            public Builder clearKey() {
                copyOnWrite();
                ((KeyedItem) this.instance).clearKey();
                return this;
            }

            public Builder setKeyBytes(ByteString byteString) {
                copyOnWrite();
                ((KeyedItem) this.instance).setKeyBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.KeyedItemOrBuilder
            public long getVersion() {
                return ((KeyedItem) this.instance).getVersion();
            }

            public Builder setVersion(long j) {
                copyOnWrite();
                ((KeyedItem) this.instance).setVersion(j);
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((KeyedItem) this.instance).clearVersion();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new KeyedItem();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0003", new Object[]{"key_", "version_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<KeyedItem> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (KeyedItem.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            KeyedItem keyedItem = new KeyedItem();
            DEFAULT_INSTANCE = keyedItem;
            GeneratedMessageLite.registerDefaultInstance(KeyedItem.class, keyedItem);
        }

        public static KeyedItem getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<KeyedItem> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class TrackBatch extends GeneratedMessageLite<TrackBatch, Builder> implements TrackBatchOrBuilder {
        private static final TrackBatch DEFAULT_INSTANCE;
        public static final int ITEMS_FIELD_NUMBER = 2;
        private static volatile Parser<TrackBatch> PARSER = null;
        public static final int SIGNATURE_FIELD_NUMBER = 1;
        private String signature_ = "";
        private Internal.ProtobufList<KeyedItem> items_ = emptyProtobufList();

        private TrackBatch() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.TrackBatchOrBuilder
        public String getSignature() {
            return this.signature_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.TrackBatchOrBuilder
        public ByteString getSignatureBytes() {
            return ByteString.copyFromUtf8(this.signature_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSignature(String str) {
            str.getClass();
            this.signature_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSignature() {
            this.signature_ = getDefaultInstance().getSignature();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSignatureBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.signature_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.TrackBatchOrBuilder
        public List<KeyedItem> getItemsList() {
            return this.items_;
        }

        public List<? extends KeyedItemOrBuilder> getItemsOrBuilderList() {
            return this.items_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.TrackBatchOrBuilder
        public int getItemsCount() {
            return this.items_.size();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.TrackBatchOrBuilder
        public KeyedItem getItems(int i) {
            return this.items_.get(i);
        }

        public KeyedItemOrBuilder getItemsOrBuilder(int i) {
            return this.items_.get(i);
        }

        private void ensureItemsIsMutable() {
            Internal.ProtobufList<KeyedItem> protobufList = this.items_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.items_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setItems(int i, KeyedItem keyedItem) {
            keyedItem.getClass();
            ensureItemsIsMutable();
            this.items_.set(i, keyedItem);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addItems(KeyedItem keyedItem) {
            keyedItem.getClass();
            ensureItemsIsMutable();
            this.items_.add(keyedItem);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addItems(int i, KeyedItem keyedItem) {
            keyedItem.getClass();
            ensureItemsIsMutable();
            this.items_.add(i, keyedItem);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllItems(Iterable<? extends KeyedItem> iterable) {
            ensureItemsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.items_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearItems() {
            this.items_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeItems(int i) {
            ensureItemsIsMutable();
            this.items_.remove(i);
        }

        public static TrackBatch parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TrackBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static TrackBatch parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TrackBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TrackBatch parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TrackBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TrackBatch parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TrackBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TrackBatch parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TrackBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TrackBatch parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TrackBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TrackBatch parseFrom(InputStream inputStream) throws IOException {
            return (TrackBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TrackBatch parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TrackBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TrackBatch parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TrackBatch) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TrackBatch parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TrackBatch) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TrackBatch parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (TrackBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TrackBatch parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TrackBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(TrackBatch trackBatch) {
            return DEFAULT_INSTANCE.createBuilder(trackBatch);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<TrackBatch, Builder> implements TrackBatchOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(TrackBatch.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.TrackBatchOrBuilder
            public String getSignature() {
                return ((TrackBatch) this.instance).getSignature();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.TrackBatchOrBuilder
            public ByteString getSignatureBytes() {
                return ((TrackBatch) this.instance).getSignatureBytes();
            }

            public Builder setSignature(String str) {
                copyOnWrite();
                ((TrackBatch) this.instance).setSignature(str);
                return this;
            }

            public Builder clearSignature() {
                copyOnWrite();
                ((TrackBatch) this.instance).clearSignature();
                return this;
            }

            public Builder setSignatureBytes(ByteString byteString) {
                copyOnWrite();
                ((TrackBatch) this.instance).setSignatureBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.TrackBatchOrBuilder
            public List<KeyedItem> getItemsList() {
                return Collections.unmodifiableList(((TrackBatch) this.instance).getItemsList());
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.TrackBatchOrBuilder
            public int getItemsCount() {
                return ((TrackBatch) this.instance).getItemsCount();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.TrackBatchOrBuilder
            public KeyedItem getItems(int i) {
                return ((TrackBatch) this.instance).getItems(i);
            }

            public Builder setItems(int i, KeyedItem keyedItem) {
                copyOnWrite();
                ((TrackBatch) this.instance).setItems(i, keyedItem);
                return this;
            }

            public Builder setItems(int i, KeyedItem.Builder builder) {
                copyOnWrite();
                ((TrackBatch) this.instance).setItems(i, builder.build());
                return this;
            }

            public Builder addItems(KeyedItem keyedItem) {
                copyOnWrite();
                ((TrackBatch) this.instance).addItems(keyedItem);
                return this;
            }

            public Builder addItems(int i, KeyedItem keyedItem) {
                copyOnWrite();
                ((TrackBatch) this.instance).addItems(i, keyedItem);
                return this;
            }

            public Builder addItems(KeyedItem.Builder builder) {
                copyOnWrite();
                ((TrackBatch) this.instance).addItems(builder.build());
                return this;
            }

            public Builder addItems(int i, KeyedItem.Builder builder) {
                copyOnWrite();
                ((TrackBatch) this.instance).addItems(i, builder.build());
                return this;
            }

            public Builder addAllItems(Iterable<? extends KeyedItem> iterable) {
                copyOnWrite();
                ((TrackBatch) this.instance).addAllItems(iterable);
                return this;
            }

            public Builder clearItems() {
                copyOnWrite();
                ((TrackBatch) this.instance).clearItems();
                return this;
            }

            public Builder removeItems(int i) {
                copyOnWrite();
                ((TrackBatch) this.instance).removeItems(i);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new TrackBatch();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"signature_", "items_", KeyedItem.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<TrackBatch> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (TrackBatch.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            TrackBatch trackBatch = new TrackBatch();
            DEFAULT_INSTANCE = trackBatch;
            GeneratedMessageLite.registerDefaultInstance(TrackBatch.class, trackBatch);
        }

        public static TrackBatch getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TrackBatch> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SubRefreshRequest extends GeneratedMessageLite<SubRefreshRequest, Builder> implements SubRefreshRequestOrBuilder {
        public static final int CHANNEL_FIELD_NUMBER = 1;
        private static final SubRefreshRequest DEFAULT_INSTANCE;
        private static volatile Parser<SubRefreshRequest> PARSER = null;
        public static final int TOKEN_FIELD_NUMBER = 2;
        public static final int TRACK_FIELD_NUMBER = 4;
        public static final int TYPE_FIELD_NUMBER = 3;
        public static final int UNTRACK_FIELD_NUMBER = 5;
        private int type_;
        private String channel_ = "";
        private String token_ = "";
        private Internal.ProtobufList<TrackBatch> track_ = emptyProtobufList();
        private Internal.ProtobufList<String> untrack_ = GeneratedMessageLite.emptyProtobufList();

        private SubRefreshRequest() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
        public String getChannel() {
            return this.channel_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
        public ByteString getChannelBytes() {
            return ByteString.copyFromUtf8(this.channel_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannel(String str) {
            str.getClass();
            this.channel_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannel() {
            this.channel_ = getDefaultInstance().getChannel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.channel_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
        public String getToken() {
            return this.token_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
        public ByteString getTokenBytes() {
            return ByteString.copyFromUtf8(this.token_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setToken(String str) {
            str.getClass();
            this.token_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearToken() {
            this.token_ = getDefaultInstance().getToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTokenBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.token_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
        public int getType() {
            return this.type_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(int i) {
            this.type_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.type_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
        public List<TrackBatch> getTrackList() {
            return this.track_;
        }

        public List<? extends TrackBatchOrBuilder> getTrackOrBuilderList() {
            return this.track_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
        public int getTrackCount() {
            return this.track_.size();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
        public TrackBatch getTrack(int i) {
            return this.track_.get(i);
        }

        public TrackBatchOrBuilder getTrackOrBuilder(int i) {
            return this.track_.get(i);
        }

        private void ensureTrackIsMutable() {
            Internal.ProtobufList<TrackBatch> protobufList = this.track_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.track_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrack(int i, TrackBatch trackBatch) {
            trackBatch.getClass();
            ensureTrackIsMutable();
            this.track_.set(i, trackBatch);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTrack(TrackBatch trackBatch) {
            trackBatch.getClass();
            ensureTrackIsMutable();
            this.track_.add(trackBatch);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTrack(int i, TrackBatch trackBatch) {
            trackBatch.getClass();
            ensureTrackIsMutable();
            this.track_.add(i, trackBatch);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllTrack(Iterable<? extends TrackBatch> iterable) {
            ensureTrackIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.track_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTrack() {
            this.track_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeTrack(int i) {
            ensureTrackIsMutable();
            this.track_.remove(i);
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
        public List<String> getUntrackList() {
            return this.untrack_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
        public int getUntrackCount() {
            return this.untrack_.size();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
        public String getUntrack(int i) {
            return this.untrack_.get(i);
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
        public ByteString getUntrackBytes(int i) {
            return ByteString.copyFromUtf8(this.untrack_.get(i));
        }

        private void ensureUntrackIsMutable() {
            Internal.ProtobufList<String> protobufList = this.untrack_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.untrack_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUntrack(int i, String str) {
            str.getClass();
            ensureUntrackIsMutable();
            this.untrack_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUntrack(String str) {
            str.getClass();
            ensureUntrackIsMutable();
            this.untrack_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUntrack(Iterable<String> iterable) {
            ensureUntrackIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.untrack_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUntrack() {
            this.untrack_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUntrackBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            ensureUntrackIsMutable();
            this.untrack_.add(byteString.toStringUtf8());
        }

        public static SubRefreshRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SubRefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SubRefreshRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubRefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SubRefreshRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SubRefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SubRefreshRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubRefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SubRefreshRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SubRefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SubRefreshRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubRefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SubRefreshRequest parseFrom(InputStream inputStream) throws IOException {
            return (SubRefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SubRefreshRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubRefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SubRefreshRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SubRefreshRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SubRefreshRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubRefreshRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SubRefreshRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SubRefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SubRefreshRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubRefreshRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SubRefreshRequest subRefreshRequest) {
            return DEFAULT_INSTANCE.createBuilder(subRefreshRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SubRefreshRequest, Builder> implements SubRefreshRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SubRefreshRequest.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
            public String getChannel() {
                return ((SubRefreshRequest) this.instance).getChannel();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
            public ByteString getChannelBytes() {
                return ((SubRefreshRequest) this.instance).getChannelBytes();
            }

            public Builder setChannel(String str) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).setChannel(str);
                return this;
            }

            public Builder clearChannel() {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).clearChannel();
                return this;
            }

            public Builder setChannelBytes(ByteString byteString) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).setChannelBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
            public String getToken() {
                return ((SubRefreshRequest) this.instance).getToken();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
            public ByteString getTokenBytes() {
                return ((SubRefreshRequest) this.instance).getTokenBytes();
            }

            public Builder setToken(String str) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).setToken(str);
                return this;
            }

            public Builder clearToken() {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).clearToken();
                return this;
            }

            public Builder setTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).setTokenBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
            public int getType() {
                return ((SubRefreshRequest) this.instance).getType();
            }

            public Builder setType(int i) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).setType(i);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).clearType();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
            public List<TrackBatch> getTrackList() {
                return Collections.unmodifiableList(((SubRefreshRequest) this.instance).getTrackList());
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
            public int getTrackCount() {
                return ((SubRefreshRequest) this.instance).getTrackCount();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
            public TrackBatch getTrack(int i) {
                return ((SubRefreshRequest) this.instance).getTrack(i);
            }

            public Builder setTrack(int i, TrackBatch trackBatch) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).setTrack(i, trackBatch);
                return this;
            }

            public Builder setTrack(int i, TrackBatch.Builder builder) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).setTrack(i, builder.build());
                return this;
            }

            public Builder addTrack(TrackBatch trackBatch) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).addTrack(trackBatch);
                return this;
            }

            public Builder addTrack(int i, TrackBatch trackBatch) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).addTrack(i, trackBatch);
                return this;
            }

            public Builder addTrack(TrackBatch.Builder builder) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).addTrack(builder.build());
                return this;
            }

            public Builder addTrack(int i, TrackBatch.Builder builder) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).addTrack(i, builder.build());
                return this;
            }

            public Builder addAllTrack(Iterable<? extends TrackBatch> iterable) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).addAllTrack(iterable);
                return this;
            }

            public Builder clearTrack() {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).clearTrack();
                return this;
            }

            public Builder removeTrack(int i) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).removeTrack(i);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
            public List<String> getUntrackList() {
                return Collections.unmodifiableList(((SubRefreshRequest) this.instance).getUntrackList());
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
            public int getUntrackCount() {
                return ((SubRefreshRequest) this.instance).getUntrackCount();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
            public String getUntrack(int i) {
                return ((SubRefreshRequest) this.instance).getUntrack(i);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshRequestOrBuilder
            public ByteString getUntrackBytes(int i) {
                return ((SubRefreshRequest) this.instance).getUntrackBytes(i);
            }

            public Builder setUntrack(int i, String str) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).setUntrack(i, str);
                return this;
            }

            public Builder addUntrack(String str) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).addUntrack(str);
                return this;
            }

            public Builder addAllUntrack(Iterable<String> iterable) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).addAllUntrack(iterable);
                return this;
            }

            public Builder clearUntrack() {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).clearUntrack();
                return this;
            }

            public Builder addUntrackBytes(ByteString byteString) {
                copyOnWrite();
                ((SubRefreshRequest) this.instance).addUntrackBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new SubRefreshRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004\u0004\u001b\u0005Ț", new Object[]{"channel_", "token_", "type_", "track_", TrackBatch.class, "untrack_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SubRefreshRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SubRefreshRequest.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            SubRefreshRequest subRefreshRequest = new SubRefreshRequest();
            DEFAULT_INSTANCE = subRefreshRequest;
            GeneratedMessageLite.registerDefaultInstance(SubRefreshRequest.class, subRefreshRequest);
        }

        public static SubRefreshRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SubRefreshRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SubRefreshResult extends GeneratedMessageLite<SubRefreshResult, Builder> implements SubRefreshResultOrBuilder {
        private static final SubRefreshResult DEFAULT_INSTANCE;
        public static final int EXPIRES_FIELD_NUMBER = 1;
        public static final int ITEMS_FIELD_NUMBER = 3;
        private static volatile Parser<SubRefreshResult> PARSER = null;
        public static final int TTL_FIELD_NUMBER = 2;
        private boolean expires_;
        private Internal.ProtobufList<Publication> items_ = emptyProtobufList();
        private int ttl_;

        private SubRefreshResult() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshResultOrBuilder
        public boolean getExpires() {
            return this.expires_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExpires(boolean z) {
            this.expires_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExpires() {
            this.expires_ = false;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshResultOrBuilder
        public int getTtl() {
            return this.ttl_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTtl(int i) {
            this.ttl_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTtl() {
            this.ttl_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshResultOrBuilder
        public List<Publication> getItemsList() {
            return this.items_;
        }

        public List<? extends PublicationOrBuilder> getItemsOrBuilderList() {
            return this.items_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshResultOrBuilder
        public int getItemsCount() {
            return this.items_.size();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshResultOrBuilder
        public Publication getItems(int i) {
            return this.items_.get(i);
        }

        public PublicationOrBuilder getItemsOrBuilder(int i) {
            return this.items_.get(i);
        }

        private void ensureItemsIsMutable() {
            Internal.ProtobufList<Publication> protobufList = this.items_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.items_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setItems(int i, Publication publication) {
            publication.getClass();
            ensureItemsIsMutable();
            this.items_.set(i, publication);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addItems(Publication publication) {
            publication.getClass();
            ensureItemsIsMutable();
            this.items_.add(publication);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addItems(int i, Publication publication) {
            publication.getClass();
            ensureItemsIsMutable();
            this.items_.add(i, publication);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllItems(Iterable<? extends Publication> iterable) {
            ensureItemsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.items_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearItems() {
            this.items_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeItems(int i) {
            ensureItemsIsMutable();
            this.items_.remove(i);
        }

        public static SubRefreshResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SubRefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SubRefreshResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubRefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SubRefreshResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SubRefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SubRefreshResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubRefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SubRefreshResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SubRefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SubRefreshResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubRefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SubRefreshResult parseFrom(InputStream inputStream) throws IOException {
            return (SubRefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SubRefreshResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubRefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SubRefreshResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SubRefreshResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SubRefreshResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubRefreshResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SubRefreshResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SubRefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SubRefreshResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubRefreshResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SubRefreshResult subRefreshResult) {
            return DEFAULT_INSTANCE.createBuilder(subRefreshResult);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SubRefreshResult, Builder> implements SubRefreshResultOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SubRefreshResult.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshResultOrBuilder
            public boolean getExpires() {
                return ((SubRefreshResult) this.instance).getExpires();
            }

            public Builder setExpires(boolean z) {
                copyOnWrite();
                ((SubRefreshResult) this.instance).setExpires(z);
                return this;
            }

            public Builder clearExpires() {
                copyOnWrite();
                ((SubRefreshResult) this.instance).clearExpires();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshResultOrBuilder
            public int getTtl() {
                return ((SubRefreshResult) this.instance).getTtl();
            }

            public Builder setTtl(int i) {
                copyOnWrite();
                ((SubRefreshResult) this.instance).setTtl(i);
                return this;
            }

            public Builder clearTtl() {
                copyOnWrite();
                ((SubRefreshResult) this.instance).clearTtl();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshResultOrBuilder
            public List<Publication> getItemsList() {
                return Collections.unmodifiableList(((SubRefreshResult) this.instance).getItemsList());
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshResultOrBuilder
            public int getItemsCount() {
                return ((SubRefreshResult) this.instance).getItemsCount();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SubRefreshResultOrBuilder
            public Publication getItems(int i) {
                return ((SubRefreshResult) this.instance).getItems(i);
            }

            public Builder setItems(int i, Publication publication) {
                copyOnWrite();
                ((SubRefreshResult) this.instance).setItems(i, publication);
                return this;
            }

            public Builder setItems(int i, Publication.Builder builder) {
                copyOnWrite();
                ((SubRefreshResult) this.instance).setItems(i, builder.build());
                return this;
            }

            public Builder addItems(Publication publication) {
                copyOnWrite();
                ((SubRefreshResult) this.instance).addItems(publication);
                return this;
            }

            public Builder addItems(int i, Publication publication) {
                copyOnWrite();
                ((SubRefreshResult) this.instance).addItems(i, publication);
                return this;
            }

            public Builder addItems(Publication.Builder builder) {
                copyOnWrite();
                ((SubRefreshResult) this.instance).addItems(builder.build());
                return this;
            }

            public Builder addItems(int i, Publication.Builder builder) {
                copyOnWrite();
                ((SubRefreshResult) this.instance).addItems(i, builder.build());
                return this;
            }

            public Builder addAllItems(Iterable<? extends Publication> iterable) {
                copyOnWrite();
                ((SubRefreshResult) this.instance).addAllItems(iterable);
                return this;
            }

            public Builder clearItems() {
                copyOnWrite();
                ((SubRefreshResult) this.instance).clearItems();
                return this;
            }

            public Builder removeItems(int i) {
                copyOnWrite();
                ((SubRefreshResult) this.instance).removeItems(i);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new SubRefreshResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0007\u0002\u000b\u0003\u001b", new Object[]{"expires_", "ttl_", "items_", Publication.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SubRefreshResult> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SubRefreshResult.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            SubRefreshResult subRefreshResult = new SubRefreshResult();
            DEFAULT_INSTANCE = subRefreshResult;
            GeneratedMessageLite.registerDefaultInstance(SubRefreshResult.class, subRefreshResult);
        }

        public static SubRefreshResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SubRefreshResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class UnsubscribeRequest extends GeneratedMessageLite<UnsubscribeRequest, Builder> implements UnsubscribeRequestOrBuilder {
        public static final int CHANNEL_FIELD_NUMBER = 1;
        private static final UnsubscribeRequest DEFAULT_INSTANCE;
        private static volatile Parser<UnsubscribeRequest> PARSER;
        private String channel_ = "";

        private UnsubscribeRequest() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.UnsubscribeRequestOrBuilder
        public String getChannel() {
            return this.channel_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.UnsubscribeRequestOrBuilder
        public ByteString getChannelBytes() {
            return ByteString.copyFromUtf8(this.channel_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannel(String str) {
            str.getClass();
            this.channel_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannel() {
            this.channel_ = getDefaultInstance().getChannel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.channel_ = byteString.toStringUtf8();
        }

        public static UnsubscribeRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UnsubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static UnsubscribeRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UnsubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UnsubscribeRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UnsubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UnsubscribeRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UnsubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UnsubscribeRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UnsubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UnsubscribeRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UnsubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UnsubscribeRequest parseFrom(InputStream inputStream) throws IOException {
            return (UnsubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UnsubscribeRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UnsubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UnsubscribeRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UnsubscribeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UnsubscribeRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UnsubscribeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UnsubscribeRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UnsubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UnsubscribeRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UnsubscribeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UnsubscribeRequest unsubscribeRequest) {
            return DEFAULT_INSTANCE.createBuilder(unsubscribeRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UnsubscribeRequest, Builder> implements UnsubscribeRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(UnsubscribeRequest.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.UnsubscribeRequestOrBuilder
            public String getChannel() {
                return ((UnsubscribeRequest) this.instance).getChannel();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.UnsubscribeRequestOrBuilder
            public ByteString getChannelBytes() {
                return ((UnsubscribeRequest) this.instance).getChannelBytes();
            }

            public Builder setChannel(String str) {
                copyOnWrite();
                ((UnsubscribeRequest) this.instance).setChannel(str);
                return this;
            }

            public Builder clearChannel() {
                copyOnWrite();
                ((UnsubscribeRequest) this.instance).clearChannel();
                return this;
            }

            public Builder setChannelBytes(ByteString byteString) {
                copyOnWrite();
                ((UnsubscribeRequest) this.instance).setChannelBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new UnsubscribeRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"channel_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<UnsubscribeRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (UnsubscribeRequest.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            UnsubscribeRequest unsubscribeRequest = new UnsubscribeRequest();
            DEFAULT_INSTANCE = unsubscribeRequest;
            GeneratedMessageLite.registerDefaultInstance(UnsubscribeRequest.class, unsubscribeRequest);
        }

        public static UnsubscribeRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UnsubscribeRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class UnsubscribeResult extends GeneratedMessageLite<UnsubscribeResult, Builder> implements UnsubscribeResultOrBuilder {
        private static final UnsubscribeResult DEFAULT_INSTANCE;
        private static volatile Parser<UnsubscribeResult> PARSER;

        private UnsubscribeResult() {
        }

        public static UnsubscribeResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UnsubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static UnsubscribeResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UnsubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UnsubscribeResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UnsubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UnsubscribeResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UnsubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UnsubscribeResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UnsubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UnsubscribeResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UnsubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UnsubscribeResult parseFrom(InputStream inputStream) throws IOException {
            return (UnsubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UnsubscribeResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UnsubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UnsubscribeResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UnsubscribeResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UnsubscribeResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UnsubscribeResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UnsubscribeResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UnsubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UnsubscribeResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UnsubscribeResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UnsubscribeResult unsubscribeResult) {
            return DEFAULT_INSTANCE.createBuilder(unsubscribeResult);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UnsubscribeResult, Builder> implements UnsubscribeResultOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(UnsubscribeResult.DEFAULT_INSTANCE);
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new UnsubscribeResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<UnsubscribeResult> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (UnsubscribeResult.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            UnsubscribeResult unsubscribeResult = new UnsubscribeResult();
            DEFAULT_INSTANCE = unsubscribeResult;
            GeneratedMessageLite.registerDefaultInstance(UnsubscribeResult.class, unsubscribeResult);
        }

        public static UnsubscribeResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UnsubscribeResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class PublishRequest extends GeneratedMessageLite<PublishRequest, Builder> implements PublishRequestOrBuilder {
        public static final int CHANNEL_FIELD_NUMBER = 1;
        public static final int DATA_FIELD_NUMBER = 2;
        private static final PublishRequest DEFAULT_INSTANCE;
        public static final int KEY_FIELD_NUMBER = 4;
        private static volatile Parser<PublishRequest> PARSER = null;
        public static final int REMOVED_FIELD_NUMBER = 5;
        public static final int TYPE_FIELD_NUMBER = 3;
        private String channel_ = "";
        private ByteString data_ = ByteString.EMPTY;
        private String key_ = "";
        private boolean removed_;
        private int type_;

        private PublishRequest() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublishRequestOrBuilder
        public String getChannel() {
            return this.channel_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublishRequestOrBuilder
        public ByteString getChannelBytes() {
            return ByteString.copyFromUtf8(this.channel_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannel(String str) {
            str.getClass();
            this.channel_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannel() {
            this.channel_ = getDefaultInstance().getChannel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.channel_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublishRequestOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(ByteString byteString) {
            byteString.getClass();
            this.data_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublishRequestOrBuilder
        public int getType() {
            return this.type_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(int i) {
            this.type_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.type_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublishRequestOrBuilder
        public String getKey() {
            return this.key_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublishRequestOrBuilder
        public ByteString getKeyBytes() {
            return ByteString.copyFromUtf8(this.key_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKey(String str) {
            str.getClass();
            this.key_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKey() {
            this.key_ = getDefaultInstance().getKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.key_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublishRequestOrBuilder
        public boolean getRemoved() {
            return this.removed_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoved(boolean z) {
            this.removed_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoved() {
            this.removed_ = false;
        }

        public static PublishRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PublishRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static PublishRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PublishRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PublishRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PublishRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PublishRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PublishRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PublishRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PublishRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PublishRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PublishRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PublishRequest parseFrom(InputStream inputStream) throws IOException {
            return (PublishRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PublishRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PublishRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PublishRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PublishRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PublishRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PublishRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PublishRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PublishRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PublishRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PublishRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PublishRequest publishRequest) {
            return DEFAULT_INSTANCE.createBuilder(publishRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PublishRequest, Builder> implements PublishRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(PublishRequest.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublishRequestOrBuilder
            public String getChannel() {
                return ((PublishRequest) this.instance).getChannel();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublishRequestOrBuilder
            public ByteString getChannelBytes() {
                return ((PublishRequest) this.instance).getChannelBytes();
            }

            public Builder setChannel(String str) {
                copyOnWrite();
                ((PublishRequest) this.instance).setChannel(str);
                return this;
            }

            public Builder clearChannel() {
                copyOnWrite();
                ((PublishRequest) this.instance).clearChannel();
                return this;
            }

            public Builder setChannelBytes(ByteString byteString) {
                copyOnWrite();
                ((PublishRequest) this.instance).setChannelBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublishRequestOrBuilder
            public ByteString getData() {
                return ((PublishRequest) this.instance).getData();
            }

            public Builder setData(ByteString byteString) {
                copyOnWrite();
                ((PublishRequest) this.instance).setData(byteString);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((PublishRequest) this.instance).clearData();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublishRequestOrBuilder
            public int getType() {
                return ((PublishRequest) this.instance).getType();
            }

            public Builder setType(int i) {
                copyOnWrite();
                ((PublishRequest) this.instance).setType(i);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((PublishRequest) this.instance).clearType();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublishRequestOrBuilder
            public String getKey() {
                return ((PublishRequest) this.instance).getKey();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublishRequestOrBuilder
            public ByteString getKeyBytes() {
                return ((PublishRequest) this.instance).getKeyBytes();
            }

            public Builder setKey(String str) {
                copyOnWrite();
                ((PublishRequest) this.instance).setKey(str);
                return this;
            }

            public Builder clearKey() {
                copyOnWrite();
                ((PublishRequest) this.instance).clearKey();
                return this;
            }

            public Builder setKeyBytes(ByteString byteString) {
                copyOnWrite();
                ((PublishRequest) this.instance).setKeyBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PublishRequestOrBuilder
            public boolean getRemoved() {
                return ((PublishRequest) this.instance).getRemoved();
            }

            public Builder setRemoved(boolean z) {
                copyOnWrite();
                ((PublishRequest) this.instance).setRemoved(z);
                return this;
            }

            public Builder clearRemoved() {
                copyOnWrite();
                ((PublishRequest) this.instance).clearRemoved();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new PublishRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\u0004\u0004Ȉ\u0005\u0007", new Object[]{"channel_", "data_", "type_", "key_", "removed_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PublishRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PublishRequest.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            PublishRequest publishRequest = new PublishRequest();
            DEFAULT_INSTANCE = publishRequest;
            GeneratedMessageLite.registerDefaultInstance(PublishRequest.class, publishRequest);
        }

        public static PublishRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PublishRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class PublishResult extends GeneratedMessageLite<PublishResult, Builder> implements PublishResultOrBuilder {
        private static final PublishResult DEFAULT_INSTANCE;
        private static volatile Parser<PublishResult> PARSER;

        private PublishResult() {
        }

        public static PublishResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PublishResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static PublishResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PublishResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PublishResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PublishResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PublishResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PublishResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PublishResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PublishResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PublishResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PublishResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PublishResult parseFrom(InputStream inputStream) throws IOException {
            return (PublishResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PublishResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PublishResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PublishResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PublishResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PublishResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PublishResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PublishResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PublishResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PublishResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PublishResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PublishResult publishResult) {
            return DEFAULT_INSTANCE.createBuilder(publishResult);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PublishResult, Builder> implements PublishResultOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(PublishResult.DEFAULT_INSTANCE);
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new PublishResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PublishResult> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PublishResult.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            PublishResult publishResult = new PublishResult();
            DEFAULT_INSTANCE = publishResult;
            GeneratedMessageLite.registerDefaultInstance(PublishResult.class, publishResult);
        }

        public static PublishResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PublishResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class PresenceRequest extends GeneratedMessageLite<PresenceRequest, Builder> implements PresenceRequestOrBuilder {
        public static final int CHANNEL_FIELD_NUMBER = 1;
        private static final PresenceRequest DEFAULT_INSTANCE;
        private static volatile Parser<PresenceRequest> PARSER;
        private String channel_ = "";

        private PresenceRequest() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceRequestOrBuilder
        public String getChannel() {
            return this.channel_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceRequestOrBuilder
        public ByteString getChannelBytes() {
            return ByteString.copyFromUtf8(this.channel_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannel(String str) {
            str.getClass();
            this.channel_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannel() {
            this.channel_ = getDefaultInstance().getChannel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.channel_ = byteString.toStringUtf8();
        }

        public static PresenceRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PresenceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static PresenceRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PresenceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PresenceRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PresenceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PresenceRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PresenceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PresenceRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PresenceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PresenceRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PresenceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PresenceRequest parseFrom(InputStream inputStream) throws IOException {
            return (PresenceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PresenceRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PresenceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PresenceRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PresenceRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PresenceRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PresenceRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PresenceRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PresenceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PresenceRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PresenceRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PresenceRequest presenceRequest) {
            return DEFAULT_INSTANCE.createBuilder(presenceRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PresenceRequest, Builder> implements PresenceRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(PresenceRequest.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceRequestOrBuilder
            public String getChannel() {
                return ((PresenceRequest) this.instance).getChannel();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceRequestOrBuilder
            public ByteString getChannelBytes() {
                return ((PresenceRequest) this.instance).getChannelBytes();
            }

            public Builder setChannel(String str) {
                copyOnWrite();
                ((PresenceRequest) this.instance).setChannel(str);
                return this;
            }

            public Builder clearChannel() {
                copyOnWrite();
                ((PresenceRequest) this.instance).clearChannel();
                return this;
            }

            public Builder setChannelBytes(ByteString byteString) {
                copyOnWrite();
                ((PresenceRequest) this.instance).setChannelBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new PresenceRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"channel_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PresenceRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PresenceRequest.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            PresenceRequest presenceRequest = new PresenceRequest();
            DEFAULT_INSTANCE = presenceRequest;
            GeneratedMessageLite.registerDefaultInstance(PresenceRequest.class, presenceRequest);
        }

        public static PresenceRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PresenceRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class PresenceResult extends GeneratedMessageLite<PresenceResult, Builder> implements PresenceResultOrBuilder {
        private static final PresenceResult DEFAULT_INSTANCE;
        private static volatile Parser<PresenceResult> PARSER = null;
        public static final int PRESENCE_FIELD_NUMBER = 1;
        private MapFieldLite<String, ClientInfo> presence_ = MapFieldLite.emptyMapField();

        private PresenceResult() {
        }

        private static final class PresenceDefaultEntryHolder {
            static final MapEntryLite<String, ClientInfo> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, ClientInfo.getDefaultInstance());

            private PresenceDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, ClientInfo> internalGetPresence() {
            return this.presence_;
        }

        private MapFieldLite<String, ClientInfo> internalGetMutablePresence() {
            if (!this.presence_.isMutable()) {
                this.presence_ = this.presence_.mutableCopy();
            }
            return this.presence_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceResultOrBuilder
        public int getPresenceCount() {
            return internalGetPresence().size();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceResultOrBuilder
        public boolean containsPresence(String str) {
            str.getClass();
            return internalGetPresence().containsKey(str);
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceResultOrBuilder
        @Deprecated
        public Map<String, ClientInfo> getPresence() {
            return getPresenceMap();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceResultOrBuilder
        public Map<String, ClientInfo> getPresenceMap() {
            return Collections.unmodifiableMap(internalGetPresence());
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceResultOrBuilder
        public ClientInfo getPresenceOrDefault(String str, ClientInfo clientInfo) {
            str.getClass();
            MapFieldLite<String, ClientInfo> mapFieldLiteInternalGetPresence = internalGetPresence();
            return mapFieldLiteInternalGetPresence.containsKey(str) ? mapFieldLiteInternalGetPresence.get(str) : clientInfo;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceResultOrBuilder
        public ClientInfo getPresenceOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, ClientInfo> mapFieldLiteInternalGetPresence = internalGetPresence();
            if (!mapFieldLiteInternalGetPresence.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return mapFieldLiteInternalGetPresence.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, ClientInfo> getMutablePresenceMap() {
            return internalGetMutablePresence();
        }

        public static PresenceResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PresenceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static PresenceResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PresenceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PresenceResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PresenceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PresenceResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PresenceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PresenceResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PresenceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PresenceResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PresenceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PresenceResult parseFrom(InputStream inputStream) throws IOException {
            return (PresenceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PresenceResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PresenceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PresenceResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PresenceResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PresenceResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PresenceResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PresenceResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PresenceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PresenceResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PresenceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PresenceResult presenceResult) {
            return DEFAULT_INSTANCE.createBuilder(presenceResult);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PresenceResult, Builder> implements PresenceResultOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(PresenceResult.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceResultOrBuilder
            public int getPresenceCount() {
                return ((PresenceResult) this.instance).getPresenceMap().size();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceResultOrBuilder
            public boolean containsPresence(String str) {
                str.getClass();
                return ((PresenceResult) this.instance).getPresenceMap().containsKey(str);
            }

            public Builder clearPresence() {
                copyOnWrite();
                ((PresenceResult) this.instance).getMutablePresenceMap().clear();
                return this;
            }

            public Builder removePresence(String str) {
                str.getClass();
                copyOnWrite();
                ((PresenceResult) this.instance).getMutablePresenceMap().remove(str);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceResultOrBuilder
            @Deprecated
            public Map<String, ClientInfo> getPresence() {
                return getPresenceMap();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceResultOrBuilder
            public Map<String, ClientInfo> getPresenceMap() {
                return Collections.unmodifiableMap(((PresenceResult) this.instance).getPresenceMap());
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceResultOrBuilder
            public ClientInfo getPresenceOrDefault(String str, ClientInfo clientInfo) {
                str.getClass();
                Map<String, ClientInfo> presenceMap = ((PresenceResult) this.instance).getPresenceMap();
                return presenceMap.containsKey(str) ? presenceMap.get(str) : clientInfo;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceResultOrBuilder
            public ClientInfo getPresenceOrThrow(String str) {
                str.getClass();
                Map<String, ClientInfo> presenceMap = ((PresenceResult) this.instance).getPresenceMap();
                if (!presenceMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return presenceMap.get(str);
            }

            public Builder putPresence(String str, ClientInfo clientInfo) {
                str.getClass();
                clientInfo.getClass();
                copyOnWrite();
                ((PresenceResult) this.instance).getMutablePresenceMap().put(str, clientInfo);
                return this;
            }

            public Builder putAllPresence(Map<String, ClientInfo> map) {
                copyOnWrite();
                ((PresenceResult) this.instance).getMutablePresenceMap().putAll(map);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new PresenceResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"presence_", PresenceDefaultEntryHolder.defaultEntry});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PresenceResult> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PresenceResult.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            PresenceResult presenceResult = new PresenceResult();
            DEFAULT_INSTANCE = presenceResult;
            GeneratedMessageLite.registerDefaultInstance(PresenceResult.class, presenceResult);
        }

        public static PresenceResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PresenceResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class PresenceStatsRequest extends GeneratedMessageLite<PresenceStatsRequest, Builder> implements PresenceStatsRequestOrBuilder {
        public static final int CHANNEL_FIELD_NUMBER = 1;
        private static final PresenceStatsRequest DEFAULT_INSTANCE;
        private static volatile Parser<PresenceStatsRequest> PARSER;
        private String channel_ = "";

        private PresenceStatsRequest() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceStatsRequestOrBuilder
        public String getChannel() {
            return this.channel_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceStatsRequestOrBuilder
        public ByteString getChannelBytes() {
            return ByteString.copyFromUtf8(this.channel_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannel(String str) {
            str.getClass();
            this.channel_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannel() {
            this.channel_ = getDefaultInstance().getChannel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.channel_ = byteString.toStringUtf8();
        }

        public static PresenceStatsRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PresenceStatsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static PresenceStatsRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PresenceStatsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PresenceStatsRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PresenceStatsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PresenceStatsRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PresenceStatsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PresenceStatsRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PresenceStatsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PresenceStatsRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PresenceStatsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PresenceStatsRequest parseFrom(InputStream inputStream) throws IOException {
            return (PresenceStatsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PresenceStatsRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PresenceStatsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PresenceStatsRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PresenceStatsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PresenceStatsRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PresenceStatsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PresenceStatsRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PresenceStatsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PresenceStatsRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PresenceStatsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PresenceStatsRequest presenceStatsRequest) {
            return DEFAULT_INSTANCE.createBuilder(presenceStatsRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PresenceStatsRequest, Builder> implements PresenceStatsRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(PresenceStatsRequest.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceStatsRequestOrBuilder
            public String getChannel() {
                return ((PresenceStatsRequest) this.instance).getChannel();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceStatsRequestOrBuilder
            public ByteString getChannelBytes() {
                return ((PresenceStatsRequest) this.instance).getChannelBytes();
            }

            public Builder setChannel(String str) {
                copyOnWrite();
                ((PresenceStatsRequest) this.instance).setChannel(str);
                return this;
            }

            public Builder clearChannel() {
                copyOnWrite();
                ((PresenceStatsRequest) this.instance).clearChannel();
                return this;
            }

            public Builder setChannelBytes(ByteString byteString) {
                copyOnWrite();
                ((PresenceStatsRequest) this.instance).setChannelBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new PresenceStatsRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"channel_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PresenceStatsRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PresenceStatsRequest.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            PresenceStatsRequest presenceStatsRequest = new PresenceStatsRequest();
            DEFAULT_INSTANCE = presenceStatsRequest;
            GeneratedMessageLite.registerDefaultInstance(PresenceStatsRequest.class, presenceStatsRequest);
        }

        public static PresenceStatsRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PresenceStatsRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class PresenceStatsResult extends GeneratedMessageLite<PresenceStatsResult, Builder> implements PresenceStatsResultOrBuilder {
        private static final PresenceStatsResult DEFAULT_INSTANCE;
        public static final int NUM_CLIENTS_FIELD_NUMBER = 1;
        public static final int NUM_USERS_FIELD_NUMBER = 2;
        private static volatile Parser<PresenceStatsResult> PARSER;
        private int numClients_;
        private int numUsers_;

        private PresenceStatsResult() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceStatsResultOrBuilder
        public int getNumClients() {
            return this.numClients_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNumClients(int i) {
            this.numClients_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNumClients() {
            this.numClients_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceStatsResultOrBuilder
        public int getNumUsers() {
            return this.numUsers_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNumUsers(int i) {
            this.numUsers_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNumUsers() {
            this.numUsers_ = 0;
        }

        public static PresenceStatsResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PresenceStatsResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static PresenceStatsResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PresenceStatsResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PresenceStatsResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PresenceStatsResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PresenceStatsResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PresenceStatsResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PresenceStatsResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PresenceStatsResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PresenceStatsResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PresenceStatsResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PresenceStatsResult parseFrom(InputStream inputStream) throws IOException {
            return (PresenceStatsResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PresenceStatsResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PresenceStatsResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PresenceStatsResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PresenceStatsResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PresenceStatsResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PresenceStatsResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PresenceStatsResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PresenceStatsResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PresenceStatsResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PresenceStatsResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PresenceStatsResult presenceStatsResult) {
            return DEFAULT_INSTANCE.createBuilder(presenceStatsResult);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PresenceStatsResult, Builder> implements PresenceStatsResultOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(PresenceStatsResult.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceStatsResultOrBuilder
            public int getNumClients() {
                return ((PresenceStatsResult) this.instance).getNumClients();
            }

            public Builder setNumClients(int i) {
                copyOnWrite();
                ((PresenceStatsResult) this.instance).setNumClients(i);
                return this;
            }

            public Builder clearNumClients() {
                copyOnWrite();
                ((PresenceStatsResult) this.instance).clearNumClients();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.PresenceStatsResultOrBuilder
            public int getNumUsers() {
                return ((PresenceStatsResult) this.instance).getNumUsers();
            }

            public Builder setNumUsers(int i) {
                copyOnWrite();
                ((PresenceStatsResult) this.instance).setNumUsers(i);
                return this;
            }

            public Builder clearNumUsers() {
                copyOnWrite();
                ((PresenceStatsResult) this.instance).clearNumUsers();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new PresenceStatsResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"numClients_", "numUsers_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PresenceStatsResult> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PresenceStatsResult.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            PresenceStatsResult presenceStatsResult = new PresenceStatsResult();
            DEFAULT_INSTANCE = presenceStatsResult;
            GeneratedMessageLite.registerDefaultInstance(PresenceStatsResult.class, presenceStatsResult);
        }

        public static PresenceStatsResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PresenceStatsResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class StreamPosition extends GeneratedMessageLite<StreamPosition, Builder> implements StreamPositionOrBuilder {
        private static final StreamPosition DEFAULT_INSTANCE;
        public static final int EPOCH_FIELD_NUMBER = 2;
        public static final int OFFSET_FIELD_NUMBER = 1;
        private static volatile Parser<StreamPosition> PARSER;
        private String epoch_ = "";
        private long offset_;

        private StreamPosition() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.StreamPositionOrBuilder
        public long getOffset() {
            return this.offset_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOffset(long j) {
            this.offset_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOffset() {
            this.offset_ = 0L;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.StreamPositionOrBuilder
        public String getEpoch() {
            return this.epoch_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.StreamPositionOrBuilder
        public ByteString getEpochBytes() {
            return ByteString.copyFromUtf8(this.epoch_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEpoch(String str) {
            str.getClass();
            this.epoch_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEpoch() {
            this.epoch_ = getDefaultInstance().getEpoch();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEpochBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.epoch_ = byteString.toStringUtf8();
        }

        public static StreamPosition parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StreamPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static StreamPosition parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StreamPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StreamPosition parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StreamPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StreamPosition parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StreamPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StreamPosition parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StreamPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StreamPosition parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StreamPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StreamPosition parseFrom(InputStream inputStream) throws IOException {
            return (StreamPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StreamPosition parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StreamPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StreamPosition parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StreamPosition) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StreamPosition parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StreamPosition) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StreamPosition parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StreamPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StreamPosition parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StreamPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StreamPosition streamPosition) {
            return DEFAULT_INSTANCE.createBuilder(streamPosition);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StreamPosition, Builder> implements StreamPositionOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(StreamPosition.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.StreamPositionOrBuilder
            public long getOffset() {
                return ((StreamPosition) this.instance).getOffset();
            }

            public Builder setOffset(long j) {
                copyOnWrite();
                ((StreamPosition) this.instance).setOffset(j);
                return this;
            }

            public Builder clearOffset() {
                copyOnWrite();
                ((StreamPosition) this.instance).clearOffset();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.StreamPositionOrBuilder
            public String getEpoch() {
                return ((StreamPosition) this.instance).getEpoch();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.StreamPositionOrBuilder
            public ByteString getEpochBytes() {
                return ((StreamPosition) this.instance).getEpochBytes();
            }

            public Builder setEpoch(String str) {
                copyOnWrite();
                ((StreamPosition) this.instance).setEpoch(str);
                return this;
            }

            public Builder clearEpoch() {
                copyOnWrite();
                ((StreamPosition) this.instance).clearEpoch();
                return this;
            }

            public Builder setEpochBytes(ByteString byteString) {
                copyOnWrite();
                ((StreamPosition) this.instance).setEpochBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new StreamPosition();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0003\u0002Ȉ", new Object[]{"offset_", "epoch_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StreamPosition> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StreamPosition.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            StreamPosition streamPosition = new StreamPosition();
            DEFAULT_INSTANCE = streamPosition;
            GeneratedMessageLite.registerDefaultInstance(StreamPosition.class, streamPosition);
        }

        public static StreamPosition getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StreamPosition> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class HistoryRequest extends GeneratedMessageLite<HistoryRequest, Builder> implements HistoryRequestOrBuilder {
        public static final int CHANNEL_FIELD_NUMBER = 1;
        private static final HistoryRequest DEFAULT_INSTANCE;
        public static final int LIMIT_FIELD_NUMBER = 7;
        private static volatile Parser<HistoryRequest> PARSER = null;
        public static final int REVERSE_FIELD_NUMBER = 9;
        public static final int SINCE_FIELD_NUMBER = 8;
        private int bitField0_;
        private String channel_ = "";
        private int limit_;
        private boolean reverse_;
        private StreamPosition since_;

        private HistoryRequest() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryRequestOrBuilder
        public String getChannel() {
            return this.channel_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryRequestOrBuilder
        public ByteString getChannelBytes() {
            return ByteString.copyFromUtf8(this.channel_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannel(String str) {
            str.getClass();
            this.channel_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChannel() {
            this.channel_ = getDefaultInstance().getChannel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChannelBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.channel_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryRequestOrBuilder
        public int getLimit() {
            return this.limit_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLimit(int i) {
            this.limit_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLimit() {
            this.limit_ = 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryRequestOrBuilder
        public boolean hasSince() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryRequestOrBuilder
        public StreamPosition getSince() {
            StreamPosition streamPosition = this.since_;
            return streamPosition == null ? StreamPosition.getDefaultInstance() : streamPosition;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSince(StreamPosition streamPosition) {
            streamPosition.getClass();
            this.since_ = streamPosition;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSince(StreamPosition streamPosition) {
            streamPosition.getClass();
            StreamPosition streamPosition2 = this.since_;
            if (streamPosition2 != null && streamPosition2 != StreamPosition.getDefaultInstance()) {
                this.since_ = StreamPosition.newBuilder(this.since_).mergeFrom(streamPosition).buildPartial();
            } else {
                this.since_ = streamPosition;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSince() {
            this.since_ = null;
            this.bitField0_ &= -2;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryRequestOrBuilder
        public boolean getReverse() {
            return this.reverse_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReverse(boolean z) {
            this.reverse_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReverse() {
            this.reverse_ = false;
        }

        public static HistoryRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (HistoryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static HistoryRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (HistoryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static HistoryRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (HistoryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static HistoryRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (HistoryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static HistoryRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (HistoryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static HistoryRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (HistoryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static HistoryRequest parseFrom(InputStream inputStream) throws IOException {
            return (HistoryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static HistoryRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HistoryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static HistoryRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (HistoryRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static HistoryRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HistoryRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static HistoryRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (HistoryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static HistoryRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HistoryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(HistoryRequest historyRequest) {
            return DEFAULT_INSTANCE.createBuilder(historyRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<HistoryRequest, Builder> implements HistoryRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(HistoryRequest.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryRequestOrBuilder
            public String getChannel() {
                return ((HistoryRequest) this.instance).getChannel();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryRequestOrBuilder
            public ByteString getChannelBytes() {
                return ((HistoryRequest) this.instance).getChannelBytes();
            }

            public Builder setChannel(String str) {
                copyOnWrite();
                ((HistoryRequest) this.instance).setChannel(str);
                return this;
            }

            public Builder clearChannel() {
                copyOnWrite();
                ((HistoryRequest) this.instance).clearChannel();
                return this;
            }

            public Builder setChannelBytes(ByteString byteString) {
                copyOnWrite();
                ((HistoryRequest) this.instance).setChannelBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryRequestOrBuilder
            public int getLimit() {
                return ((HistoryRequest) this.instance).getLimit();
            }

            public Builder setLimit(int i) {
                copyOnWrite();
                ((HistoryRequest) this.instance).setLimit(i);
                return this;
            }

            public Builder clearLimit() {
                copyOnWrite();
                ((HistoryRequest) this.instance).clearLimit();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryRequestOrBuilder
            public boolean hasSince() {
                return ((HistoryRequest) this.instance).hasSince();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryRequestOrBuilder
            public StreamPosition getSince() {
                return ((HistoryRequest) this.instance).getSince();
            }

            public Builder setSince(StreamPosition streamPosition) {
                copyOnWrite();
                ((HistoryRequest) this.instance).setSince(streamPosition);
                return this;
            }

            public Builder setSince(StreamPosition.Builder builder) {
                copyOnWrite();
                ((HistoryRequest) this.instance).setSince(builder.build());
                return this;
            }

            public Builder mergeSince(StreamPosition streamPosition) {
                copyOnWrite();
                ((HistoryRequest) this.instance).mergeSince(streamPosition);
                return this;
            }

            public Builder clearSince() {
                copyOnWrite();
                ((HistoryRequest) this.instance).clearSince();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryRequestOrBuilder
            public boolean getReverse() {
                return ((HistoryRequest) this.instance).getReverse();
            }

            public Builder setReverse(boolean z) {
                copyOnWrite();
                ((HistoryRequest) this.instance).setReverse(z);
                return this;
            }

            public Builder clearReverse() {
                copyOnWrite();
                ((HistoryRequest) this.instance).clearReverse();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new HistoryRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\t\u0004\u0000\u0000\u0000\u0001Ȉ\u0007\u0004\bဉ\u0000\t\u0007", new Object[]{"bitField0_", "channel_", "limit_", "since_", "reverse_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<HistoryRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (HistoryRequest.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            HistoryRequest historyRequest = new HistoryRequest();
            DEFAULT_INSTANCE = historyRequest;
            GeneratedMessageLite.registerDefaultInstance(HistoryRequest.class, historyRequest);
        }

        public static HistoryRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HistoryRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class HistoryResult extends GeneratedMessageLite<HistoryResult, Builder> implements HistoryResultOrBuilder {
        private static final HistoryResult DEFAULT_INSTANCE;
        public static final int EPOCH_FIELD_NUMBER = 2;
        public static final int OFFSET_FIELD_NUMBER = 3;
        private static volatile Parser<HistoryResult> PARSER = null;
        public static final int PUBLICATIONS_FIELD_NUMBER = 1;
        private long offset_;
        private Internal.ProtobufList<Publication> publications_ = emptyProtobufList();
        private String epoch_ = "";

        private HistoryResult() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryResultOrBuilder
        public List<Publication> getPublicationsList() {
            return this.publications_;
        }

        public List<? extends PublicationOrBuilder> getPublicationsOrBuilderList() {
            return this.publications_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryResultOrBuilder
        public int getPublicationsCount() {
            return this.publications_.size();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryResultOrBuilder
        public Publication getPublications(int i) {
            return this.publications_.get(i);
        }

        public PublicationOrBuilder getPublicationsOrBuilder(int i) {
            return this.publications_.get(i);
        }

        private void ensurePublicationsIsMutable() {
            Internal.ProtobufList<Publication> protobufList = this.publications_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.publications_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPublications(int i, Publication publication) {
            publication.getClass();
            ensurePublicationsIsMutable();
            this.publications_.set(i, publication);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPublications(Publication publication) {
            publication.getClass();
            ensurePublicationsIsMutable();
            this.publications_.add(publication);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPublications(int i, Publication publication) {
            publication.getClass();
            ensurePublicationsIsMutable();
            this.publications_.add(i, publication);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllPublications(Iterable<? extends Publication> iterable) {
            ensurePublicationsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.publications_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPublications() {
            this.publications_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removePublications(int i) {
            ensurePublicationsIsMutable();
            this.publications_.remove(i);
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryResultOrBuilder
        public String getEpoch() {
            return this.epoch_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryResultOrBuilder
        public ByteString getEpochBytes() {
            return ByteString.copyFromUtf8(this.epoch_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEpoch(String str) {
            str.getClass();
            this.epoch_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEpoch() {
            this.epoch_ = getDefaultInstance().getEpoch();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEpochBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.epoch_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryResultOrBuilder
        public long getOffset() {
            return this.offset_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOffset(long j) {
            this.offset_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOffset() {
            this.offset_ = 0L;
        }

        public static HistoryResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (HistoryResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static HistoryResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (HistoryResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static HistoryResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (HistoryResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static HistoryResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (HistoryResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static HistoryResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (HistoryResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static HistoryResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (HistoryResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static HistoryResult parseFrom(InputStream inputStream) throws IOException {
            return (HistoryResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static HistoryResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HistoryResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static HistoryResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (HistoryResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static HistoryResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HistoryResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static HistoryResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (HistoryResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static HistoryResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (HistoryResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(HistoryResult historyResult) {
            return DEFAULT_INSTANCE.createBuilder(historyResult);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<HistoryResult, Builder> implements HistoryResultOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(HistoryResult.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryResultOrBuilder
            public List<Publication> getPublicationsList() {
                return Collections.unmodifiableList(((HistoryResult) this.instance).getPublicationsList());
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryResultOrBuilder
            public int getPublicationsCount() {
                return ((HistoryResult) this.instance).getPublicationsCount();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryResultOrBuilder
            public Publication getPublications(int i) {
                return ((HistoryResult) this.instance).getPublications(i);
            }

            public Builder setPublications(int i, Publication publication) {
                copyOnWrite();
                ((HistoryResult) this.instance).setPublications(i, publication);
                return this;
            }

            public Builder setPublications(int i, Publication.Builder builder) {
                copyOnWrite();
                ((HistoryResult) this.instance).setPublications(i, builder.build());
                return this;
            }

            public Builder addPublications(Publication publication) {
                copyOnWrite();
                ((HistoryResult) this.instance).addPublications(publication);
                return this;
            }

            public Builder addPublications(int i, Publication publication) {
                copyOnWrite();
                ((HistoryResult) this.instance).addPublications(i, publication);
                return this;
            }

            public Builder addPublications(Publication.Builder builder) {
                copyOnWrite();
                ((HistoryResult) this.instance).addPublications(builder.build());
                return this;
            }

            public Builder addPublications(int i, Publication.Builder builder) {
                copyOnWrite();
                ((HistoryResult) this.instance).addPublications(i, builder.build());
                return this;
            }

            public Builder addAllPublications(Iterable<? extends Publication> iterable) {
                copyOnWrite();
                ((HistoryResult) this.instance).addAllPublications(iterable);
                return this;
            }

            public Builder clearPublications() {
                copyOnWrite();
                ((HistoryResult) this.instance).clearPublications();
                return this;
            }

            public Builder removePublications(int i) {
                copyOnWrite();
                ((HistoryResult) this.instance).removePublications(i);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryResultOrBuilder
            public String getEpoch() {
                return ((HistoryResult) this.instance).getEpoch();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryResultOrBuilder
            public ByteString getEpochBytes() {
                return ((HistoryResult) this.instance).getEpochBytes();
            }

            public Builder setEpoch(String str) {
                copyOnWrite();
                ((HistoryResult) this.instance).setEpoch(str);
                return this;
            }

            public Builder clearEpoch() {
                copyOnWrite();
                ((HistoryResult) this.instance).clearEpoch();
                return this;
            }

            public Builder setEpochBytes(ByteString byteString) {
                copyOnWrite();
                ((HistoryResult) this.instance).setEpochBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.HistoryResultOrBuilder
            public long getOffset() {
                return ((HistoryResult) this.instance).getOffset();
            }

            public Builder setOffset(long j) {
                copyOnWrite();
                ((HistoryResult) this.instance).setOffset(j);
                return this;
            }

            public Builder clearOffset() {
                copyOnWrite();
                ((HistoryResult) this.instance).clearOffset();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new HistoryResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002Ȉ\u0003\u0003", new Object[]{"publications_", Publication.class, "epoch_", "offset_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<HistoryResult> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (HistoryResult.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            HistoryResult historyResult = new HistoryResult();
            DEFAULT_INSTANCE = historyResult;
            GeneratedMessageLite.registerDefaultInstance(HistoryResult.class, historyResult);
        }

        public static HistoryResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HistoryResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class PingRequest extends GeneratedMessageLite<PingRequest, Builder> implements PingRequestOrBuilder {
        private static final PingRequest DEFAULT_INSTANCE;
        private static volatile Parser<PingRequest> PARSER;

        private PingRequest() {
        }

        public static PingRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static PingRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PingRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PingRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PingRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PingRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PingRequest parseFrom(InputStream inputStream) throws IOException {
            return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PingRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PingRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PingRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PingRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PingRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PingRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PingRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PingRequest pingRequest) {
            return DEFAULT_INSTANCE.createBuilder(pingRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PingRequest, Builder> implements PingRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(PingRequest.DEFAULT_INSTANCE);
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new PingRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PingRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PingRequest.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            PingRequest pingRequest = new PingRequest();
            DEFAULT_INSTANCE = pingRequest;
            GeneratedMessageLite.registerDefaultInstance(PingRequest.class, pingRequest);
        }

        public static PingRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PingRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class PingResult extends GeneratedMessageLite<PingResult, Builder> implements PingResultOrBuilder {
        private static final PingResult DEFAULT_INSTANCE;
        private static volatile Parser<PingResult> PARSER;

        private PingResult() {
        }

        public static PingResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static PingResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PingResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PingResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PingResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PingResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PingResult parseFrom(InputStream inputStream) throws IOException {
            return (PingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PingResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PingResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PingResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PingResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PingResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PingResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PingResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PingResult pingResult) {
            return DEFAULT_INSTANCE.createBuilder(pingResult);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PingResult, Builder> implements PingResultOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(PingResult.DEFAULT_INSTANCE);
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new PingResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PingResult> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PingResult.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            PingResult pingResult = new PingResult();
            DEFAULT_INSTANCE = pingResult;
            GeneratedMessageLite.registerDefaultInstance(PingResult.class, pingResult);
        }

        public static PingResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PingResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class RPCRequest extends GeneratedMessageLite<RPCRequest, Builder> implements RPCRequestOrBuilder {
        public static final int DATA_FIELD_NUMBER = 1;
        private static final RPCRequest DEFAULT_INSTANCE;
        public static final int METHOD_FIELD_NUMBER = 2;
        private static volatile Parser<RPCRequest> PARSER;
        private ByteString data_ = ByteString.EMPTY;
        private String method_ = "";

        private RPCRequest() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RPCRequestOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(ByteString byteString) {
            byteString.getClass();
            this.data_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RPCRequestOrBuilder
        public String getMethod() {
            return this.method_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RPCRequestOrBuilder
        public ByteString getMethodBytes() {
            return ByteString.copyFromUtf8(this.method_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMethod(String str) {
            str.getClass();
            this.method_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMethod() {
            this.method_ = getDefaultInstance().getMethod();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMethodBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.method_ = byteString.toStringUtf8();
        }

        public static RPCRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (RPCRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static RPCRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RPCRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RPCRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (RPCRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RPCRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RPCRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RPCRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (RPCRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RPCRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RPCRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RPCRequest parseFrom(InputStream inputStream) throws IOException {
            return (RPCRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RPCRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RPCRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RPCRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RPCRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RPCRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RPCRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RPCRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (RPCRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RPCRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RPCRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RPCRequest rPCRequest) {
            return DEFAULT_INSTANCE.createBuilder(rPCRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<RPCRequest, Builder> implements RPCRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(RPCRequest.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RPCRequestOrBuilder
            public ByteString getData() {
                return ((RPCRequest) this.instance).getData();
            }

            public Builder setData(ByteString byteString) {
                copyOnWrite();
                ((RPCRequest) this.instance).setData(byteString);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((RPCRequest) this.instance).clearData();
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RPCRequestOrBuilder
            public String getMethod() {
                return ((RPCRequest) this.instance).getMethod();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RPCRequestOrBuilder
            public ByteString getMethodBytes() {
                return ((RPCRequest) this.instance).getMethodBytes();
            }

            public Builder setMethod(String str) {
                copyOnWrite();
                ((RPCRequest) this.instance).setMethod(str);
                return this;
            }

            public Builder clearMethod() {
                copyOnWrite();
                ((RPCRequest) this.instance).clearMethod();
                return this;
            }

            public Builder setMethodBytes(ByteString byteString) {
                copyOnWrite();
                ((RPCRequest) this.instance).setMethodBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new RPCRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\n\u0002Ȉ", new Object[]{"data_", "method_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<RPCRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (RPCRequest.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            RPCRequest rPCRequest = new RPCRequest();
            DEFAULT_INSTANCE = rPCRequest;
            GeneratedMessageLite.registerDefaultInstance(RPCRequest.class, rPCRequest);
        }

        public static RPCRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RPCRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class RPCResult extends GeneratedMessageLite<RPCResult, Builder> implements RPCResultOrBuilder {
        public static final int DATA_FIELD_NUMBER = 1;
        private static final RPCResult DEFAULT_INSTANCE;
        private static volatile Parser<RPCResult> PARSER;
        private ByteString data_ = ByteString.EMPTY;

        private RPCResult() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RPCResultOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(ByteString byteString) {
            byteString.getClass();
            this.data_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        public static RPCResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (RPCResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static RPCResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RPCResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RPCResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (RPCResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RPCResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RPCResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RPCResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (RPCResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RPCResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RPCResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RPCResult parseFrom(InputStream inputStream) throws IOException {
            return (RPCResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RPCResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RPCResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RPCResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RPCResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RPCResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RPCResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RPCResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (RPCResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RPCResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RPCResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RPCResult rPCResult) {
            return DEFAULT_INSTANCE.createBuilder(rPCResult);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<RPCResult, Builder> implements RPCResultOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(RPCResult.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.RPCResultOrBuilder
            public ByteString getData() {
                return ((RPCResult) this.instance).getData();
            }

            public Builder setData(ByteString byteString) {
                copyOnWrite();
                ((RPCResult) this.instance).setData(byteString);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((RPCResult) this.instance).clearData();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new RPCResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n", new Object[]{"data_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<RPCResult> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (RPCResult.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            RPCResult rPCResult = new RPCResult();
            DEFAULT_INSTANCE = rPCResult;
            GeneratedMessageLite.registerDefaultInstance(RPCResult.class, rPCResult);
        }

        public static RPCResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RPCResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SendRequest extends GeneratedMessageLite<SendRequest, Builder> implements SendRequestOrBuilder {
        public static final int DATA_FIELD_NUMBER = 1;
        private static final SendRequest DEFAULT_INSTANCE;
        private static volatile Parser<SendRequest> PARSER;
        private ByteString data_ = ByteString.EMPTY;

        private SendRequest() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SendRequestOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(ByteString byteString) {
            byteString.getClass();
            this.data_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        public static SendRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SendRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SendRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SendRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SendRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SendRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SendRequest parseFrom(InputStream inputStream) throws IOException {
            return (SendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SendRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SendRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SendRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SendRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SendRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SendRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SendRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SendRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SendRequest sendRequest) {
            return DEFAULT_INSTANCE.createBuilder(sendRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SendRequest, Builder> implements SendRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SendRequest.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.SendRequestOrBuilder
            public ByteString getData() {
                return ((SendRequest) this.instance).getData();
            }

            public Builder setData(ByteString byteString) {
                copyOnWrite();
                ((SendRequest) this.instance).setData(byteString);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((SendRequest) this.instance).clearData();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new SendRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n", new Object[]{"data_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SendRequest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SendRequest.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            SendRequest sendRequest = new SendRequest();
            DEFAULT_INSTANCE = sendRequest;
            GeneratedMessageLite.registerDefaultInstance(SendRequest.class, sendRequest);
        }

        public static SendRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SendRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class FilterNode extends GeneratedMessageLite<FilterNode, Builder> implements FilterNodeOrBuilder {
        public static final int CMP_FIELD_NUMBER = 3;
        private static final FilterNode DEFAULT_INSTANCE;
        public static final int KEY_FIELD_NUMBER = 2;
        public static final int NODES_FIELD_NUMBER = 6;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile Parser<FilterNode> PARSER = null;
        public static final int VALS_FIELD_NUMBER = 5;
        public static final int VAL_FIELD_NUMBER = 4;
        private String op_ = "";
        private String key_ = "";
        private String cmp_ = "";
        private String val_ = "";
        private Internal.ProtobufList<String> vals_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<FilterNode> nodes_ = emptyProtobufList();

        private FilterNode() {
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
        public String getOp() {
            return this.op_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
        public ByteString getOpBytes() {
            return ByteString.copyFromUtf8(this.op_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOp(String str) {
            str.getClass();
            this.op_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOp() {
            this.op_ = getDefaultInstance().getOp();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOpBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.op_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
        public String getKey() {
            return this.key_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
        public ByteString getKeyBytes() {
            return ByteString.copyFromUtf8(this.key_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKey(String str) {
            str.getClass();
            this.key_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKey() {
            this.key_ = getDefaultInstance().getKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.key_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
        public String getCmp() {
            return this.cmp_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
        public ByteString getCmpBytes() {
            return ByteString.copyFromUtf8(this.cmp_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCmp(String str) {
            str.getClass();
            this.cmp_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCmp() {
            this.cmp_ = getDefaultInstance().getCmp();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCmpBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.cmp_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
        public String getVal() {
            return this.val_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
        public ByteString getValBytes() {
            return ByteString.copyFromUtf8(this.val_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVal(String str) {
            str.getClass();
            this.val_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVal() {
            this.val_ = getDefaultInstance().getVal();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.val_ = byteString.toStringUtf8();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
        public List<String> getValsList() {
            return this.vals_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
        public int getValsCount() {
            return this.vals_.size();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
        public String getVals(int i) {
            return this.vals_.get(i);
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
        public ByteString getValsBytes(int i) {
            return ByteString.copyFromUtf8(this.vals_.get(i));
        }

        private void ensureValsIsMutable() {
            Internal.ProtobufList<String> protobufList = this.vals_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.vals_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVals(int i, String str) {
            str.getClass();
            ensureValsIsMutable();
            this.vals_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addVals(String str) {
            str.getClass();
            ensureValsIsMutable();
            this.vals_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllVals(Iterable<String> iterable) {
            ensureValsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.vals_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVals() {
            this.vals_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addValsBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            ensureValsIsMutable();
            this.vals_.add(byteString.toStringUtf8());
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
        public List<FilterNode> getNodesList() {
            return this.nodes_;
        }

        public List<? extends FilterNodeOrBuilder> getNodesOrBuilderList() {
            return this.nodes_;
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
        public int getNodesCount() {
            return this.nodes_.size();
        }

        @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
        public FilterNode getNodes(int i) {
            return this.nodes_.get(i);
        }

        public FilterNodeOrBuilder getNodesOrBuilder(int i) {
            return this.nodes_.get(i);
        }

        private void ensureNodesIsMutable() {
            Internal.ProtobufList<FilterNode> protobufList = this.nodes_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.nodes_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNodes(int i, FilterNode filterNode) {
            filterNode.getClass();
            ensureNodesIsMutable();
            this.nodes_.set(i, filterNode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addNodes(FilterNode filterNode) {
            filterNode.getClass();
            ensureNodesIsMutable();
            this.nodes_.add(filterNode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addNodes(int i, FilterNode filterNode) {
            filterNode.getClass();
            ensureNodesIsMutable();
            this.nodes_.add(i, filterNode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllNodes(Iterable<? extends FilterNode> iterable) {
            ensureNodesIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.nodes_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNodes() {
            this.nodes_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeNodes(int i) {
            ensureNodesIsMutable();
            this.nodes_.remove(i);
        }

        public static FilterNode parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FilterNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static FilterNode parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FilterNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FilterNode parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FilterNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FilterNode parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FilterNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FilterNode parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FilterNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FilterNode parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FilterNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FilterNode parseFrom(InputStream inputStream) throws IOException {
            return (FilterNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FilterNode parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FilterNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FilterNode parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FilterNode) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FilterNode parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FilterNode) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FilterNode parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FilterNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FilterNode parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FilterNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FilterNode filterNode) {
            return DEFAULT_INSTANCE.createBuilder(filterNode);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FilterNode, Builder> implements FilterNodeOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(FilterNode.DEFAULT_INSTANCE);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
            public String getOp() {
                return ((FilterNode) this.instance).getOp();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
            public ByteString getOpBytes() {
                return ((FilterNode) this.instance).getOpBytes();
            }

            public Builder setOp(String str) {
                copyOnWrite();
                ((FilterNode) this.instance).setOp(str);
                return this;
            }

            public Builder clearOp() {
                copyOnWrite();
                ((FilterNode) this.instance).clearOp();
                return this;
            }

            public Builder setOpBytes(ByteString byteString) {
                copyOnWrite();
                ((FilterNode) this.instance).setOpBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
            public String getKey() {
                return ((FilterNode) this.instance).getKey();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
            public ByteString getKeyBytes() {
                return ((FilterNode) this.instance).getKeyBytes();
            }

            public Builder setKey(String str) {
                copyOnWrite();
                ((FilterNode) this.instance).setKey(str);
                return this;
            }

            public Builder clearKey() {
                copyOnWrite();
                ((FilterNode) this.instance).clearKey();
                return this;
            }

            public Builder setKeyBytes(ByteString byteString) {
                copyOnWrite();
                ((FilterNode) this.instance).setKeyBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
            public String getCmp() {
                return ((FilterNode) this.instance).getCmp();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
            public ByteString getCmpBytes() {
                return ((FilterNode) this.instance).getCmpBytes();
            }

            public Builder setCmp(String str) {
                copyOnWrite();
                ((FilterNode) this.instance).setCmp(str);
                return this;
            }

            public Builder clearCmp() {
                copyOnWrite();
                ((FilterNode) this.instance).clearCmp();
                return this;
            }

            public Builder setCmpBytes(ByteString byteString) {
                copyOnWrite();
                ((FilterNode) this.instance).setCmpBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
            public String getVal() {
                return ((FilterNode) this.instance).getVal();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
            public ByteString getValBytes() {
                return ((FilterNode) this.instance).getValBytes();
            }

            public Builder setVal(String str) {
                copyOnWrite();
                ((FilterNode) this.instance).setVal(str);
                return this;
            }

            public Builder clearVal() {
                copyOnWrite();
                ((FilterNode) this.instance).clearVal();
                return this;
            }

            public Builder setValBytes(ByteString byteString) {
                copyOnWrite();
                ((FilterNode) this.instance).setValBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
            public List<String> getValsList() {
                return Collections.unmodifiableList(((FilterNode) this.instance).getValsList());
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
            public int getValsCount() {
                return ((FilterNode) this.instance).getValsCount();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
            public String getVals(int i) {
                return ((FilterNode) this.instance).getVals(i);
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
            public ByteString getValsBytes(int i) {
                return ((FilterNode) this.instance).getValsBytes(i);
            }

            public Builder setVals(int i, String str) {
                copyOnWrite();
                ((FilterNode) this.instance).setVals(i, str);
                return this;
            }

            public Builder addVals(String str) {
                copyOnWrite();
                ((FilterNode) this.instance).addVals(str);
                return this;
            }

            public Builder addAllVals(Iterable<String> iterable) {
                copyOnWrite();
                ((FilterNode) this.instance).addAllVals(iterable);
                return this;
            }

            public Builder clearVals() {
                copyOnWrite();
                ((FilterNode) this.instance).clearVals();
                return this;
            }

            public Builder addValsBytes(ByteString byteString) {
                copyOnWrite();
                ((FilterNode) this.instance).addValsBytes(byteString);
                return this;
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
            public List<FilterNode> getNodesList() {
                return Collections.unmodifiableList(((FilterNode) this.instance).getNodesList());
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
            public int getNodesCount() {
                return ((FilterNode) this.instance).getNodesCount();
            }

            @Override // io.github.centrifugal.centrifuge.internal.protocol.Protocol.FilterNodeOrBuilder
            public FilterNode getNodes(int i) {
                return ((FilterNode) this.instance).getNodes(i);
            }

            public Builder setNodes(int i, FilterNode filterNode) {
                copyOnWrite();
                ((FilterNode) this.instance).setNodes(i, filterNode);
                return this;
            }

            public Builder setNodes(int i, Builder builder) {
                copyOnWrite();
                ((FilterNode) this.instance).setNodes(i, builder.build());
                return this;
            }

            public Builder addNodes(FilterNode filterNode) {
                copyOnWrite();
                ((FilterNode) this.instance).addNodes(filterNode);
                return this;
            }

            public Builder addNodes(int i, FilterNode filterNode) {
                copyOnWrite();
                ((FilterNode) this.instance).addNodes(i, filterNode);
                return this;
            }

            public Builder addNodes(Builder builder) {
                copyOnWrite();
                ((FilterNode) this.instance).addNodes(builder.build());
                return this;
            }

            public Builder addNodes(int i, Builder builder) {
                copyOnWrite();
                ((FilterNode) this.instance).addNodes(i, builder.build());
                return this;
            }

            public Builder addAllNodes(Iterable<? extends FilterNode> iterable) {
                copyOnWrite();
                ((FilterNode) this.instance).addAllNodes(iterable);
                return this;
            }

            public Builder clearNodes() {
                copyOnWrite();
                ((FilterNode) this.instance).clearNodes();
                return this;
            }

            public Builder removeNodes(int i) {
                copyOnWrite();
                ((FilterNode) this.instance).removeNodes(i);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new FilterNode();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0002\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ț\u0006\u001b", new Object[]{"op_", "key_", "cmp_", "val_", "vals_", "nodes_", FilterNode.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FilterNode> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FilterNode.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            FilterNode filterNode = new FilterNode();
            DEFAULT_INSTANCE = filterNode;
            GeneratedMessageLite.registerDefaultInstance(FilterNode.class, filterNode);
        }

        public static FilterNode getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FilterNode> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
