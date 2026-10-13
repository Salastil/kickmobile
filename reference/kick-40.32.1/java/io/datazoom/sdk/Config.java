package io.datazoom.sdk;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.logs.LogLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Config.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0012\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lio/datazoom/sdk/Config;", "", "configurationId", "", "isProduction", "", "logLevel", "Lio/datazoom/sdk/logs/LogLevel;", "apiUrl", "<init>", "(Ljava/lang/String;ZLio/datazoom/sdk/logs/LogLevel;Ljava/lang/String;)V", "builder", "Lio/datazoom/sdk/Config$Builder;", "(Lio/datazoom/sdk/Config$Builder;)V", "getConfigurationId", "()Ljava/lang/String;", "()Z", "getLogLevel", "()Lio/datazoom/sdk/logs/LogLevel;", "getApiUrl", "Companion", "Builder", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Config {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String apiUrl;
    private final String configurationId;
    private final boolean isProduction;
    private final LogLevel logLevel;

    public /* synthetic */ Config(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private Config(String str, boolean z, LogLevel logLevel, String str2) {
        this.configurationId = str;
        this.isProduction = z;
        this.logLevel = logLevel;
        this.apiUrl = str2;
        if (str.length() == 0) {
            throw new IllegalArgumentException("Api secret cannot be empty");
        }
        if (str2.length() == 0) {
            throw new IllegalArgumentException("Api url cannot be empty");
        }
    }

    public final String getConfigurationId() {
        return this.configurationId;
    }

    /* JADX INFO: renamed from: isProduction, reason: from getter */
    public final boolean getIsProduction() {
        return this.isProduction;
    }

    /* synthetic */ Config(String str, boolean z, LogLevel logLevel, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z, (i & 4) != 0 ? LogLevel.WARNING : logLevel, str2);
    }

    public final LogLevel getLogLevel() {
        return this.logLevel;
    }

    public final String getApiUrl() {
        return this.apiUrl;
    }

    private Config(Builder builder) {
        this(builder.getConfigurationId(), builder.getIsProduction(), builder.getLogLevel(), builder.getApiUrl());
    }

    /* JADX INFO: compiled from: Config.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0019\b\u0002\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lio/datazoom/sdk/Config$Companion;", "", "<init>", "()V", "build", "Lio/datazoom/sdk/Config;", "configurationId", "", "block", "Lkotlin/Function1;", "Lio/datazoom/sdk/Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Config build$default(Companion companion, String configurationId, Function1 block, int i, Object obj) {
            if ((i & 2) != 0) {
                block = new Function1<Builder, Unit>() { // from class: io.datazoom.sdk.Config$Companion$build$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Config.Builder builder) {
                        Intrinsics.checkNotNullParameter(builder, "<this>");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Config.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }
                };
            }
            Intrinsics.checkNotNullParameter(configurationId, "configurationId");
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder(configurationId);
            block.invoke(builder);
            return builder.build();
        }

        public final Config build(String configurationId, Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(configurationId, "configurationId");
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder(configurationId);
            block.invoke(builder);
            return builder.build();
        }
    }

    /* JADX INFO: compiled from: Config.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0014"}, d2 = {"Lio/datazoom/sdk/Config$Builder;", "", "configurationId", "", "<init>", "(Ljava/lang/String;)V", "getConfigurationId", "()Ljava/lang/String;", "value", "", "isProduction", "()Z", "Lio/datazoom/sdk/logs/LogLevel;", "logLevel", "getLogLevel", "()Lio/datazoom/sdk/logs/LogLevel;", "apiUrl", "getApiUrl", "build", "Lio/datazoom/sdk/Config;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        private String apiUrl;
        private final String configurationId;
        private boolean isProduction;
        private LogLevel logLevel;

        public Builder(String configurationId) {
            Intrinsics.checkNotNullParameter(configurationId, "configurationId");
            this.configurationId = configurationId;
            this.isProduction = true;
            this.logLevel = LogLevel.OFF;
            this.apiUrl = "https://platform.datazoom.io";
        }

        public final String getConfigurationId() {
            return this.configurationId;
        }

        /* JADX INFO: renamed from: isProduction, reason: from getter */
        public final boolean getIsProduction() {
            return this.isProduction;
        }

        public final LogLevel getLogLevel() {
            return this.logLevel;
        }

        public final String getApiUrl() {
            return this.apiUrl;
        }

        public final Builder isProduction(boolean isProduction) {
            String str;
            this.isProduction = isProduction;
            if (isProduction) {
                str = "https://platform.datazoom.io";
            } else {
                str = "https://stagingplatform.datazoom.io";
            }
            this.apiUrl = str;
            return this;
        }

        public final Builder logLevel(LogLevel logLevel) {
            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
            this.logLevel = logLevel;
            return this;
        }

        public final Builder apiUrl(String apiUrl) {
            Intrinsics.checkNotNullParameter(apiUrl, "apiUrl");
            this.apiUrl = apiUrl;
            return this;
        }

        public final Config build() {
            return new Config(this, null);
        }
    }
}
