package com.danielngandu.nearbychurhces.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by Daniel Ng`andu on 28/01/2020
 */

public class PlaceDetailWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new PlaceDetailWidgetAdapter(this);
    }
}
