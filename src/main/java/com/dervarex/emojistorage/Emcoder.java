package com.dervarex.emojistorage;

import java.io.IOException;

static class Emcoder {
    static String encode(byte[] data) {
        StringBuilder out = new StringBuilder(data.length * 2 * 4);
        for (byte byte : data) {
            int value = byte & 0xFF;
            out.append(Emojibet.EMOJIS[value >> 4]);
            out.append(Emojibet.EMOJIS[value & 0x0F]);
        }
        return out.toString();
    }
    static void encodeFile(Path input, Path out) throws IOException {
        byte[] data = Files.readAllBytes(input);
        Files.writeString(out, encode(data), StandardCharsets.UTF_8);
    }
}
