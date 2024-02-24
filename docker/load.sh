

cp ../build/libs/*.jar .
docker build --no-cache -t springboot-app -f Dockerfile .
rm *.jar
