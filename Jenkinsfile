pipeline {
    agent any

    environment {
        APP_NAME = "springboot-demo"
        REGISTRY = "docker1.home"
        VERSION = "v1"
        TAG = "${VERSION}-${currentBuild.number}"
        API_IMAGE = "${APP_NAME}-api:${TAG}"
        BACKEND_IMAGE = "${APP_NAME}-backend:${TAG}"
    }

    stages {
        //stage("Cleanup Workspace"){
        //    steps {
        //        cleanWs()
        //    }
        //}
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
                    sh "docker tag ${API_IMAGE} ${REGISTRY}/${API_IMAGE}"
                    sh "docker push ${REGISTRY}/${API_IMAGE}"
                }
            }
        }

        stage ('Cleanup Artifacts') {
            steps {
                script {
                    sh "docker rmi ${API_IMAGE}"
                }
             }
        }
    }
}