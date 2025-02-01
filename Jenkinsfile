pipeline {
    stages {
        stage('Test') {
            steps {
                container('gradle') {
                    sh 'gradle test'
                }
            }
        }
    }
}