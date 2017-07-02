#!/bin/sh

rm *.class

fsc CommonPackage.scala

fsc Entities.scala

fsc GameGadgetsPackage.scala

fsc FieldPackage.scala
fsc HumanPackage.scala

fsc GameStatePackage.scala

fsc GameAIPackage.scala

fsc Main.scala
