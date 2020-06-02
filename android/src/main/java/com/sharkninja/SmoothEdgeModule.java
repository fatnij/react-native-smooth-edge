package com.sharkninja;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.sharkninja.map.SmoothEdge;

public class SmoothEdgeModule extends ReactContextBaseJavaModule {
    private static SmoothEdge smoothEdge = new SmoothEdge();

    private final ReactApplicationContext reactContext;

    public SmoothEdgeModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "SmoothEdge";
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }

    @ReactMethod
    public String getMapData(String floorStr, int type) {
        String result = "";
        try {
            result = smoothEdge.smoothEdgePbFloorV4(floorStr, type);
        } catch (Exception e) {
            result = "{\"error\": \"all map empty\", \"code\": -1}";
        }
        return result;
    }
}
