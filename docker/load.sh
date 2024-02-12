cp ../build/libs/*.jar .
docker build -t springboot-app -f Dockerfile .
rm *.jar