package io.datazoom.sdk.network.events;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.network.Resource;
import io.datazoom.sdk.network.events.model.EventDto;
import io.datazoom.sdk.network.events.model.EventResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: SendEventUseCase.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H¦@¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lio/datazoom/sdk/network/events/SendEventUseCase;", "", "invoke", "Lio/datazoom/sdk/network/Resource;", "Lio/datazoom/sdk/network/events/model/EventResponse;", "list", "", "Lio/datazoom/sdk/network/events/model/EventDto;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface SendEventUseCase {
    Object invoke(List<EventDto> list, Continuation<? super Resource<EventResponse>> continuation);
}
