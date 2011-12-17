package org.bookmark.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class SMS {
    public static void send(final Context ctx, final String phone, final String content) {
        final Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:" + phone));
        sendIntent.putExtra("address", phone);
        sendIntent.putExtra("sms_body", content);
        ctx.startActivity(sendIntent);
    }
}
