/**
 * Validation helper class.
 * 
 * @author Bookmark
 * @require READ_PHONE_STATE permission
 */

package org.bookmark.helper;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import android.content.Context;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;

public class Device {

    /**
     * Check Internet connection status
     * 
     * @param cxt
     *            Context
     * @return true: has connect, false: no connect
     */

    public static boolean checkInternetConnect(final Context cxt) {
        final ConnectivityManager conMgr = (ConnectivityManager) cxt
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable()
                && conMgr.getActiveNetworkInfo().isConnected()) return true;
        else return false;
    }

    /**
     * Check SD card status
     * 
     * @return true: has SD, false: no SD
     */
    public static boolean checkSdCard() {
        return android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
    }

    /**
     * Device id
     * 
     * @param ctx
     * @return String device id
     */

    public static String getDeviceId(final Context ctx) {
        final TelephonyManager telephonyManager = (TelephonyManager) ctx
                .getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }

    /**
     * Get device model(HTC Dream, Dell Streak...)
     * 
     * @return String device model
     */

    public static String getDeviceModel() {
        return android.os.Build.MODEL;
    }

    /**
     * Get android version on current device
     * 
     * @return String version
     */

    public static String getAndroidVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * Get android version on current device
     * 
     * @return int version code
     */

    public static int getAndroidVersionCode() {
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * Get current ip address
     * 
     * @return string ip address
     */
    public static String getLocalIpAddress() {
        try {
            for (final Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en
                    .hasMoreElements();) {
                final NetworkInterface intf = en.nextElement();
                for (final Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr
                        .hasMoreElements();) {
                    final InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress())
                        return inetAddress.getHostAddress().toString();
                }
            }
        } catch (final SocketException ex) {}
        return null;
    }

    /**
     * Get phone number
     * 
     * @param ctx
     * @return
     */

    public static String getMyPhoneNumber(final Context ctx) {
        TelephonyManager mTelephonyMgr;
        mTelephonyMgr = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
        return mTelephonyMgr.getLine1Number();
    }

    public static String getCpuInfo() {
        ProcessBuilder cmd;
        String result = "";

        try {
            final String[] args = { "/system/bin/cat", "/proc/cpuinfo" };

            cmd = new ProcessBuilder(args);

            final Process process = cmd.start();
            final InputStream in = process.getInputStream();
            final byte[] re = new byte[1024];
            while (in.read(re) != -1)
                result += new String(re);
            in.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
