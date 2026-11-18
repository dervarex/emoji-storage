#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
rm -rf out && mkdir -p out
javac -encoding UTF-8 -d out $(find src -name '*.java')
jar --create --file out/emoji-storage.jar --main-class com.dervarex.emojistorage.Main -C out com
java -jar out/emoji-storage.jar "$@" || true
