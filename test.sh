#!/usr/bin/env bash

RED="\e[0;31m"
GRN="\e[0;32m"
WHI="\e[0;37m"
YEL="\033[0;33m"
BYEL="\e[1;33m"
PUR="\033[0;35m"
BLU="\033[0;34m"
CYA="\033[0;36m"

HOME_PWD=$(pwd)

DISPLAY_VALID=0

if [ $# -eq 1 ] && [ $1 = "--no-valid" ]; then
	DISPLAY_VALID=1
fi

TOTAL=0
SUCCES=0

color()
{
    echo -e "$@" $WHI
}

testParse()
{
	result=$(cat "$1.txt" | sed '/^$/d;s/[[:blank:]]//g')
	expect=$(cat $1 | sed '/^$/d;s/[[:blank:]]//g' | tr -d '\n')
	if [ "$result" = "$expect" ]; then
		if [ $DISPLAY_VALID -eq 0 ]; then
			color $GRN"$1$WHI -- $duration"
		fi
        SUCCES=$((SUCCES+1))
		rm -f "$1.txt"
        else
                color $RED"$1$WHI --$YEL different parse$WHI -- $duration"
		echo $result
		echo "--"
		echo $expect
	fi
	rm -f ast.html
}

test_file_error()
{
	t1=$(date +%s%N)
	java -jar "${HOME_PWD}/target/cat-1.0-SNAPSHOT.jar" $1 >> /tmp/cat_compiler_tests 2>&1
	result=$?
	t2=$(date +%s%N)
	diff_ms=$(( (t2 - t1) / 1000000 ))
	duration=$(printf "%d.%03d s" $((diff_ms / 1000)) $((diff_ms % 1000)))
	if [ $result -eq $2 ]; then
		if [ $DISPLAY_VALID -eq 0 ]; then
			color $GRN"$1$WHI -- $duration"
		fi
		SUCCES=$((SUCCES+1))
        else
        	color $RED"$1$WHI -- $YEL$result | $2$WHI -- $duration"
        fi
}

test_file()
{
	t1=$(date +%s%N)
	java -jar "${HOME_PWD}/target/cat-1.0-SNAPSHOT.jar" $1 --txt >> /tmp/cat_compiler_tests 2>&1
	result=$?
	t2=$(date +%s%N)
	diff_ms=$(( (t2 - t1) / 1000000 ))
	duration=$(printf "%d.%03d s" $((diff_ms / 1000)) $((diff_ms % 1000)))
	if [ $result -eq 0 ]; then
		testParse $1
        #color $GRN"$1$WHI -- $duration"
		#SUCCES=$((SUCCES+1))
        else
        	color $RED"$1$WHI -- $YEL$result$WHI -- $duration"
        fi
}

color $PUR"COMPILING..."

mvn clean package -q

if [ $? -eq 0 ]; then
	color $GRN"DONE COMPILING"
else
	color $RED"ERROR COMPILING"
	exit 1
fi

TEST_FOLDER_VALID="src/test/java/valid/"
TEST_FOLDER_ERROR="src/test/java/error/"

TOTAL=0
SUCCES=0

test_dir_error() {
	for dir in *; do
		if [ -d "$dir" ]; then
			color $CYA"\n=== $dir ===\n"
			cd $dir
			test_dir_error
			cd ..
		elif [[ "$dir" == *.cat ]]; then
			TOTAL=$((TOTAL+1))
			test_file_error $dir $1
    		fi
	done
}


test_dir_valid() {
	for dir in *; do
		if [ -d "$dir" ]; then
			color $CYA"\n=== $dir ===\n"
			cd $dir
			test_dir_valid
			cd ..
		elif [[ "$dir" == *.cat ]]; then
			TOTAL=$((TOTAL+1))
			test_file $dir
    		fi
	done
}

cd $TEST_FOLDER_VALID

color "\n$YEL======== VALID ========"

test_dir_valid

cd $HOME_PWD

cd $TEST_FOLDER_ERROR

color "\n$YEL======== ERROR ========"

color "\n$BYEL======== LEXING ========\n"

cd lexing
test_dir_error 1
cd ..

color "\n$BYEL======== PARSING ========\n"

cd parsing
test_dir_error 1
cd ..

color "\n$BYEL======== BINDING ========\n"

cd binding
test_dir_error 3
cd ..

color "\n$BYEL======== TYPE ========\n"

cd type
test_dir_error 4
cd ..

color "\n$PUR======== $CYA$SUCCES / $TOTAL $PUR========"

cd $HOME_PWD
