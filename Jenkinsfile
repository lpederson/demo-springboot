pipeline {
    agent {
        docker { image 'gradle:8-jdk17' }
    }
    stage('Test') {
        gradle test
    }
}