pipeline {
    agent {
        docker { image 'gradle' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'gradle test'
            }
        }
    }
}