#!/bin/sh

file=Submit.scala

rm ${file}
touch ${file}

cat Entities.scala >> ${file}

cat GameObjects.scala >> ${file}
cat FieldObject.scala >> ${file}

cat Main.scala >> ${file}
