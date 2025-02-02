pipeline {
    agent any

    environment {
        APP_NAME = "springboot-demo"
        RELEASE_NUMBER = "1.0"
        IMAGE_TAG = "${RELEASE_NUMBER}"
        REGISTRY = "docker1.home"

        API_IMAGE = "${APP_NAME}-api"
        BACKEND_IMAGE = "${APP_NAME}-backend"
    }

    stages {
        stage("Cleanup Workspace"){
            steps {
                cleanWs()
            }
        }
        stage('Test') {
            agent {
                docker { image 'gradle:7-jdk17' }
            }
            steps {
                sh 'gradle test'
            }
        }
        stage('Publish') {
            steps{
                script{
                    sh "docker build -f Dockerfile_api -t ${API_IMAGE} ."
                    sh "docker tag ${API_IMAGE}:latest ${REGISTRY}/${API_IMAGE}:latest"
                    sh "docker push ${REGISTRY}/${API_IMAGE}:latest"
                }
            }
        }

        stage ('Cleanup Artifacts') {
            steps {
                script {
                    sh "docker rmi ${IMAGE_NAME}:${IMAGE_TAG}"
                     sh "docker rmi ${IMAGE_NAME}:latest"
                 }
             }
        }
    }
}