pipeline {
    agent {
        docker { image 'gradle:7-jdk17' }
    }
    stages {
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}