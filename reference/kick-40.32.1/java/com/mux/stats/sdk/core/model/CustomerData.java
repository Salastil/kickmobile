package com.mux.stats.sdk.core.model;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class CustomerData extends BaseQueryData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CustomerPlayerData f247a;
    private CustomerVideoData b;
    private CustomerViewData c;
    private CustomerViewerData d;
    private CustomData e;

    public CustomerData() {
        this.f247a = new CustomerPlayerData();
        this.b = new CustomerVideoData();
        this.c = new CustomerViewData();
        this.d = new CustomerViewerData();
        this.e = new CustomData();
    }

    public CustomerData(CustomerPlayerData customerPlayerData, CustomerVideoData customerVideoData, CustomerViewData customerViewData) {
        this.f247a = new CustomerPlayerData();
        this.b = new CustomerVideoData();
        this.c = new CustomerViewData();
        this.d = new CustomerViewerData();
        this.e = new CustomData();
        this.f247a = customerPlayerData;
        this.b = customerVideoData;
        this.c = customerViewData;
    }

    public CustomerData(CustomerPlayerData customerPlayerData, CustomerVideoData customerVideoData, CustomerViewData customerViewData, CustomData customData) {
        this(customerPlayerData, customerVideoData, customerViewData);
        this.e = customData;
    }

    public CustomerData(CustomerPlayerData customerPlayerData, CustomerVideoData customerVideoData, CustomerViewData customerViewData, CustomerViewerData customerViewerData, CustomData customData) {
        this(customerPlayerData, customerVideoData, customerViewData, customData);
        this.d = customerViewerData;
    }

    public CustomData getCustomData() {
        return this.e;
    }

    public CustomerPlayerData getCustomerPlayerData() {
        return this.f247a;
    }

    public CustomerVideoData getCustomerVideoData() {
        return this.b;
    }

    public CustomerViewData getCustomerViewData() {
        return this.c;
    }

    public CustomerViewerData getCustomerViewerData() {
        return this.d;
    }

    @Override // com.mux.stats.sdk.core.model.BaseQueryData
    public JSONObject getMuxDictionary() throws JSONException {
        BaseQueryData baseQueryData = new BaseQueryData() { // from class: com.mux.stats.sdk.core.model.CustomerData.1
            @Override // com.mux.stats.sdk.core.model.BaseQueryData
            public final void sync() {
            }
        };
        baseQueryData.update(this.f247a.getMuxDictionary());
        baseQueryData.update(this.b.getMuxDictionary());
        baseQueryData.update(this.c.getMuxDictionary());
        baseQueryData.update(this.d.getMuxDictionary());
        baseQueryData.update(this.e.getMuxDictionary());
        return baseQueryData.getMuxDictionary();
    }

    public void setCustomData(CustomData customData) {
        this.e = customData;
    }

    public void setCustomerPlayerData(CustomerPlayerData customerPlayerData) {
        this.f247a = customerPlayerData;
    }

    public void setCustomerVideoData(CustomerVideoData customerVideoData) {
        this.b = customerVideoData;
    }

    public void setCustomerViewData(CustomerViewData customerViewData) {
        this.c = customerViewData;
    }

    public void setCustomerViewerData(CustomerViewerData customerViewerData) {
        this.d = customerViewerData;
    }

    @Override // com.mux.stats.sdk.core.model.BaseQueryData
    public void sync() {
    }

    public void update(CustomerData customerData) {
        this.f247a.update(customerData.getCustomerPlayerData());
        this.b.update(customerData.getCustomerVideoData());
        this.c.update(customerData.getCustomerViewData());
        this.d.update(customerData.getCustomerViewerData());
        this.e.update(customerData.getCustomData());
    }
}
