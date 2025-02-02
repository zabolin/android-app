package net.ivpn.core.vpn;

/*
 IVPN Android app
 https://github.com/ivpn/android-app

 Created by Oleksandr Mykhailenko.
 Copyright (c) 2020 Privatus Limited.

 This file is part of the IVPN Android app.

 The IVPN Android app is free software: you can redistribute it and/or
 modify it under the terms of the GNU General Public License as published by the Free
 Software Foundation, either version 3 of the License, or (at your option) any later version.

 The IVPN Android app is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 details.

 You should have received a copy of the GNU General Public License
 along with the IVPN Android app. If not, see <https://www.gnu.org/licenses/>.
*/

import net.ivpn.core.IVPNApplication;

public interface ServiceConstants {

    String PACKAGE_NAME = "net.ivpn.client";
    //ivpn service
    String START_VPN = PACKAGE_NAME + ".START_VPN";
    String DISCONNECT_VPN = PACKAGE_NAME + ".DISCONNECT_VPN";
    String STOP_VPN = PACKAGE_NAME + ".STOP_VPN";
    String PAUSE_VPN = PACKAGE_NAME + ".PAUSE_VPN";
    String RECONNECTING_VPN = PACKAGE_NAME + ".RECONNECTING_VPN";
    String RESUME_VPN = PACKAGE_NAME + ".RESUME_VPN";
    String VPN_CHANNEL = PACKAGE_NAME + ".VPN_CHANNEL";
    String VPN_STATUS = PACKAGE_NAME + ".VPN_STATUS";
    String NOTIFICATION_ACTION = PACKAGE_NAME + ".NOTIFICATION_ACTION";
    String NOTIFICATION_ACTION_EXTRA = PACKAGE_NAME + ".NOTIFICATION_ACTION_EXTRA";
    String DISCONNECT_ACTION = PACKAGE_NAME + ".DISCONNECT_ACTION";
    String PAUSE_ACTION = PACKAGE_NAME + ".PAUSE_ACTION";
    String RESUME_ACTION = PACKAGE_NAME + ".RESUME_ACTION";
    String RECONNECT_ACTION = PACKAGE_NAME + ".RECONNECT_ACTION";
    String STOP_ACTION = PACKAGE_NAME + ".STOP_ACTION";
    String VPN_EXTRA_STATUS = PACKAGE_NAME + ".VPN_EXTRA_STATUS";
    String VPN_PAUSE_DURATION_EXTRA = "VPN_PAUSE_DURATION_EXTRA";

    //Kill switch service
    String START_KILL_SWITCH = "START_KILL_SWITCH";
    String STOP_KILL_SWITCH = "STOP_KILL_SWITCH";
    String STOP_KILL_SWITCH_ACTION = "STOP_KILL_SWITCH_ACTION";
    String CONNECT_VPN_ACTION = "CONNECT_VPN_ACTION";
    String APP_SETTINGS_ACTION = "APP_SETTINGS_ACTION";
    String KILL_SWITCH_ACTION = "KILL_SWITCH_ACTION";
    String KILL_SWITCH_ACTION_EXTRA = "KILL_SWITCH_ACTION_EXTRA";
    String KILL_SWITCH_CHANNEL = PACKAGE_NAME + ".KILL_SWITCH_CHANNEL";

    //Wifi watcher service
    String START_WIFI_WATCHER = "START_WIFI_WATCHER";
    String STOP_WIFI_WATCHER = "STOP_WIFI_WATCHER";
    String WIFI_WATCHER_ACTION = "WIFI_WATCHER_ACTION";
    String WIFI_WATCHER_ACTION_EXTRA = "WIFI_WATCHER_ACTION_EXTRA";
    String WIFI_WATCHER_ACTION_VALUE = "WIFI_WATCHER_ACTION_VALUE";
    String WIFI_CHANGED_ACTION = "WIFI_CHANGED_ACTION";
    String WIFI_WATCHER_CHANNEL = PACKAGE_NAME + ".WIFI_WATCHER_CHANNEL";
    String ON_MOBILE_DATA_ACTION = "ON_MOBILE_DATA_ACTION";
    String NO_NETWORK_ACTION = "NO_NETWORK_ACTION";

    //WireGuard UI service actions
    String WIREGUARD_CONNECTING = "WIREGUARD_CONNECTING";
    String WIREGUARD_CONNECTED = "WIREGUARD_CONNECTED";
    String WIREGUARD_PAUSED = "WIREGUARD_PAUSED";
    String WIREGUARD_DISCONNECTED = "WIREGUARD_DISCONNECTED";

//    Update service actions
    String UPDATE_PROCEED = PACKAGE_NAME + ".UPDATE_PROCEED";
    String UPDATE_SKIP = PACKAGE_NAME + ".UPDATE_SKIP";
    String UPDATE_SETTINGS = PACKAGE_NAME + ".UPDATE_SETTINGS";
    String SHOW_UPDATE_NOTIFICATION = PACKAGE_NAME + ".SHOW_UPDATE_NOTIFICATION";
    String CANCEL_UPDATE_NOTIFICATION = PACKAGE_NAME + ".CANCEL_UPDATE_NOTIFICATION";
    String UPDATE_NOTIFICATION_ACTION = PACKAGE_NAME + ".UPDATE_NOTIFICATION_ACTION";
    String UPDATE_NOTIFICATION_ACTION_EXTRA = PACKAGE_NAME + ".UPDATE_NOTIFICATION_ACTION_EXTRA";
    String UPDATE_CHANNEL = PACKAGE_NAME + ".UPDATE_CHANNEL";

    int MTU = 1280;
    int IPV4_ROUTE_PREFIX = 0;
    int IPV6_ROUTE_PREFIX = 3;
    String IPV4_ROUTE = "0.0.0.0";
    String IPV6_ROUTE = "2000::";
    String IPV4 = "10.1.10.1";
    String IPV6 = "fd00:1:fd00:1:fd00:1:fd00:1";
    int IPV4_PREFIX = 32;
    int IPV6_PREFIX = 128;

    int IVPN_REQUEST_CODE = 119;
    int KILL_SWITCH_REQUEST_CODE = 120;

    int ENABLE_KILL_SWITCH = 97;
    int DISABLE_KILL_SWITCH = 98;
}
