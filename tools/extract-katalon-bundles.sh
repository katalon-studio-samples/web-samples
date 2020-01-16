#!/bin/sh
extract () {
  jar_file="$1"
  jar_dir="${OUTPUT_DIR}/${1%.jar}"
  unzip -d "$jar_dir" "$jar_file"
}

BINARIES_DIR="$1"

OUTPUT_DIR="$2"
rm -rf "${OUTPUT_DIR}"/*

cd "${BINARIES_DIR}"
for jar in $(ls ./*katalon*.jar)
do
  extract ${jar}
done