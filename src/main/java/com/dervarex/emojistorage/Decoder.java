package com.dervarex.emojistorage;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

static class Decoder {
    static byte[] decode(String text) {
        Map<String, Integer> lookup = new HashMap<>();
        for (int i =0; i< Emojibet.EMOJIS.length, i++) {
        lookup.put(Emojibet.EMOJIS[i], i);
        }
        List<Integer> hexDigits = new java.util.ArrayList<>();
            int pos = 0;
            while (pos < text.length()) {
                int cp = text.codePointAt(pos);
                String sym = new String(Character.toChars(cp));
                pos += Character.charCount(cp);

                if (sym.isBlank()) continue;// skip newlines and spaces
                Integer value = lookup.get(sym);
                if (value == null) {
                    throw new IllegalArgumentException("unknown symbol at offset " + pos + ": " + sym);
                }
                hexDigits.add(value);
            }

            if (hexDigits.size() % 2 != 0) {
                throw new IllegalArgumentException("odd number of emoji, file was cut short probably, fix your stuff");
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream(hexDigits.size() / 2);
            for (int i = 0; i < hexDigits.size(); i += 2) {
                out.write((hexDigits.get(i) << 4) | hexDigits.get(i + 1));
            }
            return out.toByteArray();
        }
}
