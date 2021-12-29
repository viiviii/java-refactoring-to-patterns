#!/bin/bash

replace_basename_in_java_files() {
  java_files="$(find "$1" -name "*.java")"
  for java_file in ${java_files}; do
    sed -i "" -e "s/\.${copy_basename}/\.${make_basename}/" "${java_file}"
  done
}

readonly copy_basename="example"
readonly make_basename="exercise"
readonly my_root_path="$(cd "$(dirname "$0")" && pwd -P)"
readonly copy_paths=($(find "${my_root_path}/src" -name "${copy_basename}" -type d))

count=0

for copy_path in "${copy_paths[@]}"; do
  make_path="$(dirname "${copy_path}")/${make_basename}"
  if [ ! -d "${make_path}" ]; then
    cp -R "${copy_path}" "${make_path}"
    replace_basename_in_java_files "${make_path}"
    count=$((count + 1))
  fi
done

echo "👻 complete! copy: ${count}, all: ${#copy_paths[@]} 👻"
