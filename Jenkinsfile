pipeline {
    agent {
        node { label 'kubeagent' }
        //docker { image 'gradle:8-jdk17' }
    }
    stages {
        stage('Test') {
            agent {
                docker {
                    image 'gradle:8.2.0-jdk17-alpine'
                    reuseNode true
                }
            }
            steps {
                sh 'gradle test'
            }
        }
    }
}