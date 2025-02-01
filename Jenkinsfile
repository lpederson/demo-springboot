pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                script {
                    docker.image('gradle:7-jdk17').inside {
                        sh 'gradle test'
                    }
                }
            }
        }
    }
}