#!/bin/bash
# if
C=0
if [ $1 -lt $2 ]
then
  echo $1 "<" $2
  C=$[ 4*($1 + $2) ]
  echo $C
fi
# for
