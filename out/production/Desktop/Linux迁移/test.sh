#!/bin/bash

# echo "$0"
  # -eq：等于 ==
  #
  #-ne：不等于 !=
  #
  #-gt：大于 >
  #
  #-lt：小于 <
  #
  #-ge：大于等于 >=
  #
  #-le：小于等于 <=

if [ $1 -eq 1 ]
	then
	echo "banzhang zhen shuai"
elif [ $1 -eq 2 ]
	then
	echo "cls zhen shuai"
fi

C=$[(3+2)*3*$1]
echo $C
case $C in
	15)
	echo "banzhang"
	;;
	20)
	echo "666"
	;;
*)
	echo "renyao"
	;;
esac


# for
d=0
for(( i=1;i<=100;i++ ))
do
	d=$[$d+$i]
done
echo $d
