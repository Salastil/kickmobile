package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes5.dex */
public interface Resource<Z> {
    Z get();

    Class<Z> getResourceClass();

    int getSize();

    void recycle();
}
