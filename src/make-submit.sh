#!/bin/sh

file=Submit.scala
touch ${file}

cat Entities.scala >> ${file}
cat Main.scala >> ${file}
