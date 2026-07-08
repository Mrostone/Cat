echo "Running on file : " $1

mvn clean compile && \
mvn exec:java -Dexec.mainClass="io.rostone.cat.Main" -Dexec.args="$1"
