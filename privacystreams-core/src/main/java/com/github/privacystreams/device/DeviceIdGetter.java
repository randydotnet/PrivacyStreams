package com.github.privacystreams.device;

import android.Manifest;
import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.telephony.TelephonyManager;

import com.github.privacystreams.commons.ItemFunction;
import com.github.privacystreams.core.Item;
import com.github.privacystreams.core.UQI;

/**
 * Get device id
 */
class DeviceIdGetter extends ItemFunction<String> {

    DeviceIdGetter() {
        this.addRequiredPermissions(Manifest.permission.READ_PHONE_STATE);
    }

    private transient String uuid;

    @Override
    public String apply(UQI uqi, Item input) {
        if (this.uuid == null) {
            TelephonyManager tm = (TelephonyManager) uqi.getContext().getSystemService(Context.TELEPHONY_SERVICE);
            this.uuid = tm.getDeviceId();
        }
        return this.uuid;
    }
}
