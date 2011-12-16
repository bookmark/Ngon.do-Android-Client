package org.bookmark.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCore {

    public final static int TYPE_ALNUM    = 0;

    public final static int TYPE_ALPHA    = 1;

    public final static int TYPE_HEXDEC   = 2;

    public final static int TYPE_NUMERIC  = 3;

    public final static int TYPE_NOZERO   = 4;

    public final static int TYPE_DISTINCT = 5;

    public static String humanize(final String input) {
        final String output = input.replace("_", " ").replace("-", " ");
        return output;
    }

    public static String underscore(final String input) {
        final String output = input.replace(" ", "_");
        return output;
    }

    public static String removeDuplicateWhitespace(final String input) {
        final String sPattern = "\\s+";
        final String sReplace = " ";
        final Pattern pattern = Pattern.compile(sPattern);
        final Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll(sReplace);
    }

    public static String random(final int type, final int length) {
        final String char_lib = TextCore.getCharList(type);
        String output = null;
        final int num = char_lib.length();

        for (int i = 0; i < num; i++)
            output += char_lib.charAt(Utils.random(num));

        return output;
    }

    public static String getCharList(final int type) {
        String libs = null;

        switch (type) {
            case TYPE_ALNUM:
                libs = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;
            case TYPE_ALPHA:
                libs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;
            case TYPE_HEXDEC:
                libs = "0123456789abcdef";
                break;
            case TYPE_NUMERIC:
                libs = "0123456789";
                break;
            case TYPE_NOZERO:
                libs = "123456789";
                break;
            case TYPE_DISTINCT:
                libs = "2345679ACDEFHJKLMNPRSTUVWXYZ";
                break;
        }

        return libs;
    }

    public static String pad(final String str, final int size, final char padChar) {
        final StringBuffer padded = new StringBuffer(str);
        while (padded.length() < size)
            padded.append(padChar);

        return padded.toString();
    }

    public static boolean checkXmlSpecialChar(final String s) {
        return s.contains("&") || s.contains("\"") || s.contains("'") || s.contains("<")
                || s.contains(">");
    }

    public static String escapeXml(String s) {
        s = s.replace("&", "&amp;").replace("\"", "&quot;").replace("'", "&apos;")
                .replace("<", "&lt;").replace(">", "&gt;");

        return s;
    }

    public static String ucWords(String line) {
        line = line.trim().toLowerCase();
        final String data[] = line.split("\\s");
        line = "";
        for (final String element : data)
            if (element.length() > 1) line = line + element.substring(0, 1).toUpperCase()
                    + element.substring(1) + " ";
            else line = line + element.toUpperCase();
        return line.trim();
    }

}
