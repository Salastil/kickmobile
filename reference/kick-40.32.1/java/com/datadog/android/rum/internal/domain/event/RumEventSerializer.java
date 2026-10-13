package com.datadog.android.rum.internal.domain.event;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.constraints.DataConstraints;
import com.datadog.android.core.constraints.DatadogDataConstraints;
import com.datadog.android.core.internal.utils.JsonSerializer;
import com.datadog.android.core.persistence.Serializer;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.model.TimeseriesCpuEvent;
import com.datadog.android.rum.model.TimeseriesMemoryEvent;
import com.datadog.android.rum.model.ViewEvent;
import com.datadog.android.rum.model.VitalAppLaunchEvent;
import com.datadog.android.rum.model.VitalOperationStepEvent;
import com.datadog.android.telemetry.model.TelemetryConfigurationEvent;
import com.datadog.android.telemetry.model.TelemetryDebugEvent;
import com.datadog.android.telemetry.model.TelemetryErrorEvent;
import com.datadog.android.telemetry.model.TelemetryUsageEvent;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumEventSerializer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u0000\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001bH\u0002J,\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001d2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001fH\u0002J,\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001d2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001fH\u0002J,\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001d2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/datadog/android/rum/internal/domain/event/RumEventSerializer;", "Lcom/datadog/android/core/persistence/Serializer;", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "dataConstraints", "Lcom/datadog/android/core/constraints/DataConstraints;", "(Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/core/constraints/DataConstraints;)V", "extractKnownAttributes", "Lcom/google/gson/JsonObject;", "jsonObject", "serialize", "", "model", "serializeActionEvent", "Lcom/datadog/android/rum/model/ActionEvent;", "serializeErrorEvent", "Lcom/datadog/android/rum/model/ErrorEvent;", "serializeLongTaskEvent", "Lcom/datadog/android/rum/model/LongTaskEvent;", "serializeResourceEvent", "Lcom/datadog/android/rum/model/ResourceEvent;", "serializeViewEvent", "Lcom/datadog/android/rum/model/ViewEvent;", "serializeVitalAppLaunchEvent", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent;", "serializeVitalOperationStepEvent", "Lcom/datadog/android/rum/model/VitalOperationStepEvent;", "validateAccountAttributes", "", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "validateContextAttributes", "validateUserAttributes", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumEventSerializer implements Serializer<Object> {
    public static final String ACCOUNT_ATTRIBUTE_PREFIX = "account";
    public static final String ACCOUNT_EXTRA_GROUP_VERBOSE_NAME = "account extra information";
    public static final String GLOBAL_ATTRIBUTE_PREFIX = "context";
    public static final String USER_ATTRIBUTE_PREFIX = "usr";
    public static final String USER_EXTRA_GROUP_VERBOSE_NAME = "user extra information";
    private final DataConstraints dataConstraints;
    private final InternalLogger internalLogger;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> knownAttributes = SetsKt.setOf((Object[]) new String[]{RumAttributes.ACTION_GESTURE_DIRECTION, RumAttributes.ACTION_GESTURE_FROM_STATE, RumAttributes.ACTION_GESTURE_TO_STATE, RumAttributes.ACTION_TARGET_PARENT_RESOURCE_ID, RumAttributes.ACTION_TARGET_PARENT_CLASSNAME, RumAttributes.ACTION_TARGET_PARENT_INDEX, RumAttributes.ACTION_TARGET_CLASS_NAME, RumAttributes.ACTION_TARGET_RESOURCE_ID, RumAttributes.ACTION_TARGET_TITLE, RumAttributes.ACTION_TARGET_SELECTED, RumAttributes.ACTION_TARGET_ROLE, RumAttributes.ERROR_RESOURCE_METHOD, RumAttributes.ERROR_RESOURCE_STATUS_CODE, RumAttributes.ERROR_RESOURCE_URL});
    private static final Set<String> ignoredAttributes = SetsKt.setOf((Object[]) new String[]{RumAttributes.INTERNAL_TIMESTAMP, RumAttributes.INTERNAL_ERROR_TYPE, "_dd.error.source_type", RumAttributes.INTERNAL_ERROR_IS_CRASH});
    private static final Set<String> crossPlatformTransitAttributes = SetsKt.setOf((Object[]) new String[]{RumAttributes.INTERNAL_TIMESTAMP, RumAttributes.INTERNAL_ERROR_TYPE, "_dd.error.source_type", RumAttributes.INTERNAL_ERROR_IS_CRASH});

    public RumEventSerializer(InternalLogger internalLogger, DataConstraints dataConstraints) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(dataConstraints, "dataConstraints");
        this.internalLogger = internalLogger;
        this.dataConstraints = dataConstraints;
    }

    public /* synthetic */ RumEventSerializer(InternalLogger internalLogger, DatadogDataConstraints datadogDataConstraints, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalLogger, (i & 2) != 0 ? new DatadogDataConstraints(internalLogger) : datadogDataConstraints);
    }

    @Override // com.datadog.android.core.persistence.Serializer
    public String serialize(Object model) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (model instanceof ViewEvent) {
            return serializeViewEvent((ViewEvent) model);
        }
        if (model instanceof ErrorEvent) {
            return serializeErrorEvent((ErrorEvent) model);
        }
        if (model instanceof ActionEvent) {
            return serializeActionEvent((ActionEvent) model);
        }
        if (model instanceof ResourceEvent) {
            return serializeResourceEvent((ResourceEvent) model);
        }
        if (model instanceof LongTaskEvent) {
            return serializeLongTaskEvent((LongTaskEvent) model);
        }
        if (model instanceof VitalOperationStepEvent) {
            return serializeVitalOperationStepEvent((VitalOperationStepEvent) model);
        }
        if (model instanceof VitalAppLaunchEvent) {
            return serializeVitalAppLaunchEvent((VitalAppLaunchEvent) model);
        }
        if (model instanceof TelemetryDebugEvent) {
            String string = ((TelemetryDebugEvent) model).toJson().toString();
            Intrinsics.checkNotNullExpressionValue(string, "{\n                model.….toString()\n            }");
            return string;
        }
        if (model instanceof TelemetryErrorEvent) {
            String string2 = ((TelemetryErrorEvent) model).toJson().toString();
            Intrinsics.checkNotNullExpressionValue(string2, "{\n                model.….toString()\n            }");
            return string2;
        }
        if (model instanceof TelemetryConfigurationEvent) {
            String string3 = ((TelemetryConfigurationEvent) model).toJson().toString();
            Intrinsics.checkNotNullExpressionValue(string3, "{\n                model.….toString()\n            }");
            return string3;
        }
        if (model instanceof TelemetryUsageEvent) {
            String string4 = ((TelemetryUsageEvent) model).toJson().toString();
            Intrinsics.checkNotNullExpressionValue(string4, "{\n                model.….toString()\n            }");
            return string4;
        }
        if (model instanceof TimeseriesCpuEvent) {
            String string5 = ((TimeseriesCpuEvent) model).toJson().toString();
            Intrinsics.checkNotNullExpressionValue(string5, "{\n                model.….toString()\n            }");
            return string5;
        }
        if (model instanceof TimeseriesMemoryEvent) {
            String string6 = ((TimeseriesMemoryEvent) model).toJson().toString();
            Intrinsics.checkNotNullExpressionValue(string6, "{\n                model.….toString()\n            }");
            return string6;
        }
        if (model instanceof JsonObject) {
            return model.toString();
        }
        String string7 = new JsonObject().toString();
        Intrinsics.checkNotNullExpressionValue(string7, "{\n                JsonOb….toString()\n            }");
        return string7;
    }

    private final String serializeViewEvent(ViewEvent model) {
        ViewEvent.Usr usr = model.getUsr();
        ViewEvent.Usr usrCopy$default = usr != null ? ViewEvent.Usr.copy$default(usr, null, null, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateUserAttributes(model.getUsr().getAdditionalProperties()), this.internalLogger)), 15, null) : null;
        ViewEvent.Account account = model.getAccount();
        ViewEvent.Account accountCopy$default = account != null ? ViewEvent.Account.copy$default(account, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateAccountAttributes(model.getAccount().getAdditionalProperties()), this.internalLogger)), 3, null) : null;
        ViewEvent.Context context = model.getContext();
        ViewEvent.Context contextCopy = context != null ? context.copy(MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateContextAttributes(model.getContext().getAdditionalProperties()), this.internalLogger))) : null;
        ViewEvent.ViewEventView view = model.getView();
        ViewEvent.CustomTimings customTimings = model.getView().getCustomTimings();
        JsonObject asJsonObject = ViewEvent.copy$default(model, 0L, null, null, null, null, null, null, null, null, ViewEvent.ViewEventView.copy$default(view, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, customTimings != null ? customTimings.copy(this.dataConstraints.validateTimings(model.getView().getCustomTimings().getAdditionalProperties())) : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -67108865, 524287, null), usrCopy$default, accountCopy$default, null, null, null, null, null, null, null, null, contextCopy, null, null, null, null, 32502271, null).toJson().getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "sanitizedModel.toJson().asJsonObject");
        String string = extractKnownAttributes(asJsonObject).toString();
        Intrinsics.checkNotNullExpressionValue(string, "extractKnownAttributes(s….asJsonObject).toString()");
        return string;
    }

    private final String serializeErrorEvent(ErrorEvent model) {
        ErrorEvent.Usr usr = model.getUsr();
        ErrorEvent.Usr usrCopy$default = usr != null ? ErrorEvent.Usr.copy$default(usr, null, null, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateUserAttributes(model.getUsr().getAdditionalProperties()), this.internalLogger)), 15, null) : null;
        ErrorEvent.Account account = model.getAccount();
        ErrorEvent.Account accountCopy$default = account != null ? ErrorEvent.Account.copy$default(account, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateAccountAttributes(model.getAccount().getAdditionalProperties()), this.internalLogger)), 3, null) : null;
        ErrorEvent.Context context = model.getContext();
        JsonObject asJsonObject = ErrorEvent.copy$default(model, 0L, null, null, null, null, null, null, null, null, null, usrCopy$default, accountCopy$default, null, null, null, null, null, null, null, null, context != null ? context.copy(MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateContextAttributes(model.getContext().getAdditionalProperties()), this.internalLogger))) : null, null, null, null, null, null, null, 133166079, null).toJson().getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "sanitizedModel.toJson().asJsonObject");
        String string = extractKnownAttributes(asJsonObject).toString();
        Intrinsics.checkNotNullExpressionValue(string, "extractKnownAttributes(s….asJsonObject).toString()");
        return string;
    }

    private final String serializeResourceEvent(ResourceEvent model) {
        ResourceEvent.Usr usr = model.getUsr();
        ResourceEvent.Usr usrCopy$default = usr != null ? ResourceEvent.Usr.copy$default(usr, null, null, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateUserAttributes(model.getUsr().getAdditionalProperties()), this.internalLogger)), 15, null) : null;
        ResourceEvent.Account account = model.getAccount();
        ResourceEvent.Account accountCopy$default = account != null ? ResourceEvent.Account.copy$default(account, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateAccountAttributes(model.getAccount().getAdditionalProperties()), this.internalLogger)), 3, null) : null;
        ResourceEvent.Context context = model.getContext();
        JsonObject asJsonObject = ResourceEvent.copy$default(model, 0L, null, null, null, null, null, null, null, null, null, usrCopy$default, accountCopy$default, null, null, null, null, null, null, null, null, context != null ? context.copy(MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateContextAttributes(model.getContext().getAdditionalProperties()), this.internalLogger))) : null, null, null, null, null, 32502783, null).toJson().getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "sanitizedModel.toJson().asJsonObject");
        String string = extractKnownAttributes(asJsonObject).toString();
        Intrinsics.checkNotNullExpressionValue(string, "extractKnownAttributes(s….asJsonObject).toString()");
        return string;
    }

    private final String serializeActionEvent(ActionEvent model) {
        ActionEvent.Usr usr = model.getUsr();
        ActionEvent.Usr usrCopy$default = usr != null ? ActionEvent.Usr.copy$default(usr, null, null, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateUserAttributes(model.getUsr().getAdditionalProperties()), this.internalLogger)), 15, null) : null;
        ActionEvent.Account account = model.getAccount();
        ActionEvent.Account accountCopy$default = account != null ? ActionEvent.Account.copy$default(account, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateAccountAttributes(model.getAccount().getAdditionalProperties()), this.internalLogger)), 3, null) : null;
        ActionEvent.Context context = model.getContext();
        JsonObject asJsonObject = ActionEvent.copy$default(model, 0L, null, null, null, null, null, null, null, null, null, usrCopy$default, accountCopy$default, null, null, null, null, null, null, null, null, context != null ? context.copy(MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateContextAttributes(model.getContext().getAdditionalProperties()), this.internalLogger))) : null, null, null, null, 15725567, null).toJson().getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "sanitizedModel.toJson().asJsonObject");
        String string = extractKnownAttributes(asJsonObject).toString();
        Intrinsics.checkNotNullExpressionValue(string, "extractKnownAttributes(s….asJsonObject).toString()");
        return string;
    }

    private final String serializeLongTaskEvent(LongTaskEvent model) {
        LongTaskEvent.Usr usr = model.getUsr();
        LongTaskEvent.Usr usrCopy$default = usr != null ? LongTaskEvent.Usr.copy$default(usr, null, null, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateUserAttributes(model.getUsr().getAdditionalProperties()), this.internalLogger)), 15, null) : null;
        LongTaskEvent.Account account = model.getAccount();
        LongTaskEvent.Account accountCopy$default = account != null ? LongTaskEvent.Account.copy$default(account, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateAccountAttributes(model.getAccount().getAdditionalProperties()), this.internalLogger)), 3, null) : null;
        LongTaskEvent.Context context = model.getContext();
        JsonObject asJsonObject = LongTaskEvent.copy$default(model, 0L, null, null, null, null, null, null, null, null, null, usrCopy$default, accountCopy$default, null, null, null, null, null, null, null, null, context != null ? context.copy(MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateContextAttributes(model.getContext().getAdditionalProperties()), this.internalLogger))) : null, null, null, null, null, 32502783, null).toJson().getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "sanitizedModel.toJson().asJsonObject");
        String string = extractKnownAttributes(asJsonObject).toString();
        Intrinsics.checkNotNullExpressionValue(string, "extractKnownAttributes(s….asJsonObject).toString()");
        return string;
    }

    private final String serializeVitalOperationStepEvent(VitalOperationStepEvent model) {
        VitalOperationStepEvent.Usr usr = model.getUsr();
        VitalOperationStepEvent.Usr usrCopy$default = usr != null ? VitalOperationStepEvent.Usr.copy$default(usr, null, null, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateUserAttributes(model.getUsr().getAdditionalProperties()), this.internalLogger)), 15, null) : null;
        VitalOperationStepEvent.Account account = model.getAccount();
        VitalOperationStepEvent.Account accountCopy$default = account != null ? VitalOperationStepEvent.Account.copy$default(account, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateAccountAttributes(model.getAccount().getAdditionalProperties()), this.internalLogger)), 3, null) : null;
        VitalOperationStepEvent.Context context = model.getContext();
        JsonObject asJsonObject = VitalOperationStepEvent.copy$default(model, 0L, null, null, null, null, null, null, null, null, null, usrCopy$default, accountCopy$default, null, null, null, null, null, null, null, null, context != null ? context.copy(MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateContextAttributes(model.getContext().getAdditionalProperties()), this.internalLogger))) : null, null, null, null, 15725567, null).toJson().getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "sanitizedModel.toJson().asJsonObject");
        String string = extractKnownAttributes(asJsonObject).toString();
        Intrinsics.checkNotNullExpressionValue(string, "extractKnownAttributes(s….asJsonObject).toString()");
        return string;
    }

    private final String serializeVitalAppLaunchEvent(VitalAppLaunchEvent model) {
        VitalAppLaunchEvent.Usr usr = model.getUsr();
        VitalAppLaunchEvent.Usr usrCopy$default = usr != null ? VitalAppLaunchEvent.Usr.copy$default(usr, null, null, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateUserAttributes(model.getUsr().getAdditionalProperties()), this.internalLogger)), 15, null) : null;
        VitalAppLaunchEvent.Account account = model.getAccount();
        VitalAppLaunchEvent.Account accountCopy$default = account != null ? VitalAppLaunchEvent.Account.copy$default(account, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateAccountAttributes(model.getAccount().getAdditionalProperties()), this.internalLogger)), 3, null) : null;
        VitalAppLaunchEvent.Context context = model.getContext();
        JsonObject asJsonObject = VitalAppLaunchEvent.copy$default(model, 0L, null, null, null, null, null, null, null, null, null, usrCopy$default, accountCopy$default, null, null, null, null, null, null, null, null, context != null ? context.copy(MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(validateContextAttributes(model.getContext().getAdditionalProperties()), this.internalLogger))) : null, null, null, null, 15725567, null).toJson().getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(asJsonObject, "sanitizedModel.toJson().asJsonObject");
        String string = extractKnownAttributes(asJsonObject).toString();
        Intrinsics.checkNotNullExpressionValue(string, "extractKnownAttributes(s….asJsonObject).toString()");
        return string;
    }

    private final Map<String, Object> validateContextAttributes(Map<String, ? extends Object> attributes) {
        DataConstraints dataConstraints = this.dataConstraints;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Object> entry : attributes.entrySet()) {
            if (!crossPlatformTransitAttributes.contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return DataConstraints.DefaultImpls.validateAttributes$default(dataConstraints, linkedHashMap, GLOBAL_ATTRIBUTE_PREFIX, null, ignoredAttributes, 4, null);
    }

    private final Map<String, Object> validateAccountAttributes(Map<String, ? extends Object> attributes) {
        return this.dataConstraints.validateAttributes(attributes, "account", "account extra information", ignoredAttributes);
    }

    private final Map<String, Object> validateUserAttributes(Map<String, ? extends Object> attributes) {
        return this.dataConstraints.validateAttributes(attributes, "usr", "user extra information", ignoredAttributes);
    }

    private final JsonObject extractKnownAttributes(JsonObject jsonObject) {
        if (jsonObject.has(GLOBAL_ATTRIBUTE_PREFIX)) {
            JsonObject asJsonObject = jsonObject.getAsJsonObject(GLOBAL_ATTRIBUTE_PREFIX);
            Set<Map.Entry<String, JsonElement>> setEntrySet = asJsonObject.entrySet();
            Intrinsics.checkNotNullExpressionValue(setEntrySet, "contextObject\n                .entrySet()");
            ArrayList<Map.Entry> arrayList = new ArrayList();
            for (Object obj : setEntrySet) {
                if (knownAttributes.contains(((Map.Entry) obj).getKey())) {
                    arrayList.add(obj);
                }
            }
            for (Map.Entry entry : arrayList) {
                asJsonObject.remove((String) entry.getKey());
                jsonObject.add((String) entry.getKey(), (JsonElement) entry.getValue());
            }
        }
        return jsonObject;
    }

    /* JADX INFO: compiled from: RumEventSerializer.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/internal/domain/event/RumEventSerializer$Companion;", "", "()V", "ACCOUNT_ATTRIBUTE_PREFIX", "", "ACCOUNT_EXTRA_GROUP_VERBOSE_NAME", "GLOBAL_ATTRIBUTE_PREFIX", "USER_ATTRIBUTE_PREFIX", "USER_EXTRA_GROUP_VERBOSE_NAME", "crossPlatformTransitAttributes", "", "getCrossPlatformTransitAttributes$dd_sdk_android_rum_release", "()Ljava/util/Set;", "ignoredAttributes", "getIgnoredAttributes$dd_sdk_android_rum_release", "knownAttributes", "getKnownAttributes$dd_sdk_android_rum_release", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getKnownAttributes$dd_sdk_android_rum_release() {
            return RumEventSerializer.knownAttributes;
        }

        public final Set<String> getIgnoredAttributes$dd_sdk_android_rum_release() {
            return RumEventSerializer.ignoredAttributes;
        }

        public final Set<String> getCrossPlatformTransitAttributes$dd_sdk_android_rum_release() {
            return RumEventSerializer.crossPlatformTransitAttributes;
        }
    }
}
