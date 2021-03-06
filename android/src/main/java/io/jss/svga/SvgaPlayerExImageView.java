package io.jss.svga;

import android.content.Context;
import android.util.AttributeSet;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGAImageView;

public class SvgaPlayerExImageView extends SVGAImageView {

    private final SVGACallback callback;
    protected String currentState;


    public SvgaPlayerExImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        callback = new SVGACallback() {
            @Override
            public void onPause() {

            }

            @Override
            public void onFinished() {
                WritableMap map = Arguments.createMap();
                map.putString("action", "onFinished");
                ReactContext reactContext = (ReactContext) getContext();
                reactContext.getJSModule(RCTEventEmitter.class).
                        receiveEvent(getId(), "topChange", map);
            }

            @Override
            public void onRepeat() {

            }

            @Override
            public void onStep(int i, double v) {
                WritableMap changeMap = Arguments.createMap();
                changeMap.putString("action", "onFrame");
                changeMap.putInt("value", i);
                ReactContext reactContext = (ReactContext) getContext();
                reactContext.getJSModule(RCTEventEmitter.class).
                        receiveEvent(getId(), "topChange", changeMap);
                WritableMap map = Arguments.createMap();
                map.putString("action", "onPercentage");
                map.putDouble("value", v);
                reactContext.getJSModule(RCTEventEmitter.class).
                        receiveEvent(getId(), "topChange", map);
            }
        };
    }
}
