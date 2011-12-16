/**
 * Utils helper class.
 * 
 * @author Bookmark
 */

package org.bookmark.helper;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.TypedValue;

public class Utils {
	public static float convertDiptoPixel(final Context ctx, final int dip) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, ctx.getResources()
		        .getDisplayMetrics());
	}
	
	public static float convertSiptoPixel(final Context ctx, final int sip) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sip, ctx.getResources()
		        .getDisplayMetrics());
	}
	
	public static int random(final int length) {
		return (int) Math.round(Math.random() * (length - 1));
	}
	
	public static String randomQuote(final String[] quote_list) {
		return quote_list[Utils.random(quote_list.length)];
	}
	
	/**
	 * Indicates whether the specified action can be used as an intent. This
	 * method queries the package manager for installed packages that can
	 * respond to an intent with the specified action. If no suitable package is
	 * found, this method returns false.
	 * 
	 * @param context
	 *            The application's environment.
	 * @param action
	 *            The Intent action to check for availability.
	 * @return True if an Intent with the specified action can be sent and
	 *         responded to, false otherwise.
	 */
	public static boolean isIntentAvailable(final Context context, final String action) {
		final PackageManager packageManager = context.getPackageManager();
		final Intent intent = new Intent(action);
		final List<ResolveInfo> list = packageManager.queryIntentActivities(intent,
		        PackageManager.MATCH_DEFAULT_ONLY);
		return list.size() > 0;
	}
	
	public static boolean isApplicationInstall(final Context ctx, final String package_name) {
		try {
			ctx.getPackageManager().getApplicationInfo(package_name, 0);
			return true;
		} catch (final PackageManager.NameNotFoundException e) {
			return false;
		}
	}
	
	public static void createShortcut(Context ctx, int title, int icon, Intent shortcutIntent) {
		shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		
		final Intent putShortCutIntent = new Intent();
		putShortCutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT,
		        shortcutIntent);
		
		// Sets the custom shortcut's title
		putShortCutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME,
		        ctx.getString(title));
		putShortCutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(
		        ctx, icon));
		putShortCutIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
		ctx.sendBroadcast(putShortCutIntent);
	}
}
