package com.dervarex.emojistorage;

import java.nio.file.Path;

public final class Main {
    public static void main(String[] args) throws java.io.IOException {
        if (args.length != 3) {
            System.out.println("use it like that: encode|decode <input> <output>");
            System.exit(1);
        }
        Path in = Path.of(args[1]);
        Path out = Path.of(args[2]);
        switch (args[0]) {
            case "encode" -> Converter.encodeFile(in, out);
            case "decode" -> Converter.decodeFile(in, out);
            default -> System.exit(1);
        }
    }
}
