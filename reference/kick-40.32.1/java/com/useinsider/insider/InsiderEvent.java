package com.useinsider.insider;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class InsiderEvent implements Serializable {
    private String name;
    private Map<String, Object> parameters;
    private long timestamp;

    InsiderEvent(String str) {
        try {
            this.name = str;
            this.parameters = new ConcurrentHashMap();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private void addParameter(String str, Object obj) {
        try {
            if (w4.d(str)) {
                this.parameters.put(str, obj);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Deprecated
    public InsiderEvent addParameterWithArray(String str, String[] strArr) {
        return addParameterWithStringArray(str, strArr);
    }

    public InsiderEvent addParameterWithBoolean(String str, boolean z) {
        try {
            addParameter(str, Boolean.valueOf(z));
            return this;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return this;
        }
    }

    public InsiderEvent addParameterWithDate(String str, Date date) {
        try {
            String strA = w4.a(date);
            if (strA == null) {
                return this;
            }
            addParameter(str, strA);
            return this;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return this;
        }
    }

    public InsiderEvent addParameterWithDouble(String str, double d) {
        try {
            addParameter(str, Double.valueOf(d));
            return this;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return this;
        }
    }

    public InsiderEvent addParameterWithInt(String str, int i) {
        try {
            addParameter(str, Integer.valueOf(i));
            return this;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return this;
        }
    }

    public InsiderEvent addParameterWithNumericArray(String str, Number[] numberArr) {
        if (!w4.d(str)) {
            return this;
        }
        Number[] numberArrA = w4.a((Object[]) numberArr);
        if (numberArrA == null) {
            numberArrA = new Number[0];
        }
        addParameter(str, numberArrA);
        return this;
    }

    public InsiderEvent addParameterWithString(String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() != 0) {
                    addParameter(str, str2);
                    return this;
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
        return this;
    }

    public InsiderEvent addParameterWithStringArray(String str, String[] strArr) {
        if (!w4.d(str)) {
            return this;
        }
        String[] strArrB = w4.b((Object[]) strArr);
        if (strArrB == null) {
            strArrB = new String[0];
        }
        addParameter(str, strArrB);
        return this;
    }

    public InsiderEvent addParameters(Map<String, ?> map) {
        try {
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                JSONObject jSONObjectPut = new JSONObject().put("event_name", this.name).put("event_parameters", w4.g(map));
                if (obj != null) {
                    if (obj instanceof String) {
                        addParameterWithString(str, (String) obj);
                    } else if (obj instanceof Double) {
                        addParameterWithDouble(str, ((Double) obj).doubleValue());
                    } else if (obj instanceof Integer) {
                        addParameterWithInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Boolean) {
                        addParameterWithBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Date) {
                        addParameterWithDate(str, (Date) obj);
                    } else if (obj instanceof String[]) {
                        addParameterWithStringArray(str, (String[]) obj);
                    } else if (obj instanceof Number[]) {
                        addParameterWithNumericArray(str, (Number[]) obj);
                    } else {
                        HashMap map2 = new HashMap();
                        map2.put("value", obj);
                        Debugger.a(DebuggingTag.warningMessageForEventValue, 5, map2);
                        f3.a("error", "Value of parameter is an unsupported type.", jSONObjectPut, "InsiderEvent-addParameters");
                    }
                }
            }
            return this;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return this;
        }
    }

    public void build() {
        try {
            if (!w4.a(this.parameters, this.name)) {
                f3.a("error", "The event parameter is not valid.", new JSONObject().put("event_name", this.name).put("event_parameters", w4.g(this.parameters)).put("isValidEventParameters", false), "InsiderEvent-build");
            } else {
                this.timestamp = w4.b();
                Insider.Instance.buildEvent(this);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    InsiderEvent cloneEvent() {
        try {
            InsiderEvent insiderEvent = new InsiderEvent(getName());
            insiderEvent.parameters = this.parameters;
            insiderEvent.timestamp = this.timestamp;
            return insiderEvent;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    Map<String, Object> getEventPayload() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        try {
            concurrentHashMap.put("event_name", this.name);
            concurrentHashMap.put("timestamp", Long.valueOf(this.timestamp));
            concurrentHashMap.put("event_params", this.parameters);
            return concurrentHashMap;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return concurrentHashMap;
        }
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Object> getParameters() {
        return this.parameters;
    }

    Map<String, Object> toMapForWizard() {
        try {
            HashMap map = new HashMap();
            map.put("event_name", getName());
            map.put("event_params", w4.b((Map) getParameters()));
            return map;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return new HashMap();
        }
    }
}
