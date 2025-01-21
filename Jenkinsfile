pipeline {
    agent {
        node { label 'kubeagent' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'gradle test'
            }
        }
    }
}