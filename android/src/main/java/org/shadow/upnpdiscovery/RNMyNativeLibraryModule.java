
package org.shadow.upnpdiscovery;

import android.content.Context;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.stetho.json.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class RNMyNativeLibraryModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private static String TAG = "UPnpDiscovery";

  public RNMyNativeLibraryModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "UPnpDiscovery";
  }

  @ReactMethod
  public void searchDevices(boolean value, Callback errorCallback, Callback successCallback){
    if(value){
      successCallback.invoke(1, 2, 3, 4);
    } else {
      errorCallback.invoke("value1", 12, "nice", false);
    }
  }

  @ReactMethod
  public void doSomeWork(boolean value, Callback errorCallback, final Callback successCallback){

    Context context = this.reactContext.getApplicationContext();

    UPnPDiscovery.discoveryDevices(context, new UPnPDiscovery.OnDiscoveryListener() {
      @Override
      public void OnStart() {
        Log.i(TAG, "Start discovering");
      }

      @Override
      public void OnFoundNewDevice(UPnPDevice device) {
        Log.i(TAG, "Found device");
      }

      @Override
      public void OnFinish(HashSet<UPnPDevice> devices) {
        Log.i(TAG, "Finish device");

        Iterator<UPnPDevice> iterator = devices.iterator();
        WritableArray result = Arguments.createArray();

        while (iterator.hasNext()){
          UPnPDevice device = iterator.next();

          WritableMap item = Arguments.createMap();

          item.putString("name", device.getFriendlyName());
          item.putString("ip", device.getHostAddress());
          item.putString("modelName", device.getModelName());
          item.putString("serialNumber", device.getSerialNumber());
          item.putString("manufacturer", device.getManufacturer());
        }

        successCallback.invoke(result);
      }

      @Override
      public void OnError(Exception e) {
        Log.i(TAG, "Error discovering");
      }
    });
  }

}