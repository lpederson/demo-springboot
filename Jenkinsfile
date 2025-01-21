pipeline {
    agent {
        kubernetes {
          label 'kubeagent'
          defaultContainer 'jnlp'
          yaml """
apiVersion: v1
kind: Pod
metadata:
labels:
  component: ci
spec:
  # Use service account that can deploy to all namespaces
  namespace: jenkins
  serviceAccountName: jenkins
  containers:
  - name: gradle
    image: gradle:8-jdk17
    command:
    - cat
    tty: true
  - name: docker
    image: docker:latest
    command:
    - cat
    tty: true
    volumeMounts:
    - mountPath: /var/run/docker.sock
      name: docker-sock
  volumes:
    - name: docker-sock
      hostPath:
        path: /var/run/docker.sock
"""
        }
    }

// pipeline {
//     agent {
//         node { label 'kubeagent' }
        //docker { image 'gradle:8-jdk17' }

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