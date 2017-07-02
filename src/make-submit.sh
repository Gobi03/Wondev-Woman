#!/bin/sh

file=Submit.scala

rm ${file}
touch ${file}

cat Entities.scala >> ${file}

cat GameGadgetsPackage.scala >> ${file}
cat FieldPackage.scala >> ${file}
cat HumanPackage.scala >> ${file}

cat GameStatePackage.scala >> ${file}

cat Main.scala >> ${file}
