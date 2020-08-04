package io.jss.svga;

import android.content.Context;
import android.view.View;


import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;

import java.net.URL;

public class SvgaPlayerExManager extends SimpleViewManager<View> {

    public static final String REACT_CLASS = "SvgaPlayerEx";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public View createViewInstance(ThemedReactContext c) {
        // TODO: Implement some actually useful functionality
        return null;
    }

    @ReactProp(name = "source")
    public void setSource(final SvgaPlayerExImageView view, String source) {
        Context context = view.getContext();
        if (source.startsWith("http") || source.startsWith("https")) {
            try {
                new SVGAParser(context).parse(new URL(source), new SVGAParser.ParseCompletion() {
                    @Override
                    public void onError() {
                    }
                    @Override
                    public void onComplete(SVGAVideoEntity videoItem) {
                        view.setVideoItem(videoItem);
                        view.startAnimation();
                    }

                });
            } catch (Exception e) {
            }
        } else {
            try {
                new SVGAParser(context).parse(source, new SVGAParser.ParseCompletion() {
                    @Override
                    public void onError() {
                    }
                    @Override
                    public void onComplete(SVGAVideoEntity videoItem) {
                        view.setVideoItem(videoItem);
                        view.startAnimation();
                    }
                });
            } catch (Exception e) {
            }
        }
    }

    @ReactProp(name = "loops", defaultInt = 0)
    public void setLoops(SvgaPlayerExImageView view, int loops) {
        view.setLoops(loops);
    }

    @ReactProp(name = "clearsAfterStop", defaultBoolean = true)
    public void setClearsAfterStop(SvgaPlayerExImageView view, Boolean clearsAfterStop) {
        view.setClearsAfterStop(clearsAfterStop);
    }

    @ReactProp(name = "currentState")
    public void setCurrentState(SvgaPlayerExImageView view, String currentState) {
        view.currentState = currentState;
        switch (currentState) {
            case "start":
                view.startAnimation();
                break;
            case "pause":
                view.pauseAnimation();
                break;
            case "stop":
                view.stopAnimation();
                break;
            case "clear":
                view.stopAnimation(true);
                break;
            default:
                break;
        }
    }

    @ReactProp(name = "toFrame", defaultInt = -1)
    public void setToFrame(SvgaPlayerExImageView view, int toFrame) {
        if (toFrame < 0) {
            return;
        }
        view.stepToFrame(toFrame, view.currentState.equals("play") ? true : false);
    }

    @ReactProp(name = "toPercentage", defaultFloat = -1.0f)
    public void setToPercentage(SvgaPlayerExImageView view, float toPercentage) {
        if (toPercentage < 0) {
            return;
        }
        view.stepToPercentage((double) toPercentage, view.currentState.equals("play") ? true : false);
    }
}
