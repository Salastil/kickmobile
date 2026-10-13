package com.datadog.trace.bootstrap.config.provider;

import com.datadog.trace.api.ConfigOrigin;
import com.datadog.trace.util.Strings;
import java.util.Properties;

/* JADX INFO: loaded from: classes6.dex */
final class PropertiesConfigSource extends ConfigProvider.Source {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final String CONFIG_FILE_STATUS = "_dd.config.file.status";
    private final Properties props;
    private final boolean useSystemPropertyFormat;

    public PropertiesConfigSource(Properties properties, boolean z) {
        this.props = properties;
        this.useSystemPropertyFormat = z;
    }

    public String getConfigFileStatus() {
        return this.props.getProperty(CONFIG_FILE_STATUS);
    }

    @Override // com.datadog.trace.bootstrap.config.provider.ConfigProvider.Source
    protected String get(String str) {
        Properties properties = this.props;
        if (this.useSystemPropertyFormat) {
            str = Strings.propertyNameToSystemPropertyName(str);
        }
        return properties.getProperty(str);
    }

    @Override // com.datadog.trace.bootstrap.config.provider.ConfigProvider.Source
    public ConfigOrigin origin() {
        return ConfigOrigin.JVM_PROP;
    }
}
