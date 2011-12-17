package org.bookmark.helper;

import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.os.Environment;

public class FileCore {
    public static boolean hasExist(final Context ctx, String file_path) {
        file_path = Environment.getExternalStorageDirectory() + file_path + ".bee";
        if (!DeviceCore.checkSdCard()) return false;

        final java.io.File file = new java.io.File(file_path);
        if (file.exists()) return true;

        return false;
    }

    public static java.io.File[] findFile(final String folder_path, final String pattern) {
        return new java.io.File(folder_path).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(final java.io.File dir, final String filename) {
                return filename.matches(pattern);
            }
        });
    }

    public static String getStringFromAsset(final Context ctx, final String assetFile) {
        InputStream is;
        try {
            is = ctx.getAssets().open(assetFile);
            final int size = is.available();

            // Read the entire asset into a local byte buffer.
            final byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            // Convert the buffer into a Java string.
            return new String(buffer);
        } catch (final IOException e) {
            return "";
        }

    }
}
