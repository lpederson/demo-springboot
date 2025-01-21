pipeline {
    agent {
        node { label 'kubeagent' }
        docker { image 'gradle:8-jdk17' }
    }

    stage('Checkout') {
        checkout scm
    }

    stage('Test') {
        steps {
            sh 'gradle test'
        }
    }
}