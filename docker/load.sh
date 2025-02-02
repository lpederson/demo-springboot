
cp ../api/build/libs/api.jar .
docker build -t api --build-arg jar=api.jar -f Dockerfile .

cp ../backend/build/libs/backend.jar .
docker build -t backend --build-arg jar=backend.jar -f Dockerfile .
rm *.jar
