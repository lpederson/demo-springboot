pipeline {
    agent {
        docker { image 'gradle:8-jdk17' }
    }
    stage('Test') {
        steps {
            sh 'gradle test'
        }
    }
}