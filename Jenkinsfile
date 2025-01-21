pipeline {
    agent {
        docker { image 'gradle:8-jdk17' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'gradle test'
            }
        }
    }
}