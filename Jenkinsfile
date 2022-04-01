pipeline {
    agent any

    stages {
        stage('Build') {
            environment {
                mvn = tool 'maven-3.8.5'
            }
            steps {
                dir('backend') {
                    sh './mvn clean compile'
                }
            }
        }
    }
}
