#!/usr/bin/env bash

RED="\e[0;31m"
GRN="\e[0;32m"
WHI="\e[0;37m"
YEL="\033[0;33m"
PUR="\033[0;35m"
BLU="\033[0;34m"
CYA="\033[0;36m"


TOTAL=0
SUCCES=0

color()
{
    echo -e "$@" $WHI
}

file()
{
	t1=$(date +%s%N)
	java -jar "${HOME_PWD}/target/cat-1.0-SNAPSHOT.jar" $1 >> /tmp/cat_compiler_tests 2>&1
	result=$?
	t2=$(date +%s%N)
	diff_ms=$(( (t2 - t1) / 1000000 ))
	duration=$(printf "%d.%03d s" $((diff_ms / 1000)) $((diff_ms % 1000)))
	if [ $result -eq 0 ]; then
                color $GRN"$1$WHI -- $duration"
		SUCCES=$((SUCCES+1))
        else
        	color $RED"$1$WHI -- $YEL$result$WHI -- $duration"
        fi
}

color $PUR"COMPILING..."

export MAVEN_OPTS="--sun-misc-unsafe-memory-access=allow"

mvn clean package -q

if [ $? -eq 0 ]; then
	color $GRN"DONE COMPILING"
else
	color $RED"ERROR COMPILING"
	exit 1
fi

TEST_FOLDER_VALID="src/test/java/valid/"

HOME_PWD=$(pwd)

TOTAL=0
SUCCES=0


test_dir() {
	for dir in *; do
		if [ -d "$dir" ]; then
			color $CYA"\n=== $dir ===\n"
			cd $dir
			test_dir
			cd ..
		elif [[ "$dir" == *.cat ]]; then
			TOTAL=$((TOTAL+1))
			file $dir
    		fi
	done
}

cd $TEST_FOLDER_VALID

test_dir

color "\n$PUR======== $SUCCES / $TOTAL ========"

cd $HOME_PWD
