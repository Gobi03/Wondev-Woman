#!/bin/sh

rm *.class

fsc Entities.scala

fsc GameGadgetsPackage.scala
fsc FieldPackage.scala
fsc HumanPackage.scala

fsc GameStatePackage.scala

fsc Main.scala
