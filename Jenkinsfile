pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                dir('backend'){
                sh './mvnw clean compile'
                }
            }
        }
    }
}
