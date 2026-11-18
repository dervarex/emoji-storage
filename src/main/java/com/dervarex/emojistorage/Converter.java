package com.dervarex.emojistorage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

final class Converter {

    private Converter() {}

    static void encodeFile(Path input, Path output) throws IOException {
        byte[] data = Files.readAllBytes(input);
        String text = Emcoder.encode(data);
        Files.writeString(output, text, StandardCharsets.UTF_8);
    }

    static void decodeFile(Path input, Path output) throws IOException {
        String text = Files.readString(input, StandardCharsets.UTF_8);
        byte[] data = Decoder.decode(text);
        Files.write(output, data);
    }
}
