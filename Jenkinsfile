pipeline {
    agent any

    tools {
        jdk 'openjdk-17'
        nodejs 'nodejs-17.8'
    }

    stages {
        stage('Build') {
            environment {
                mvn = tool 'maven-3.8.5'
            }
            steps {
                dir('backend') {
                    sh "${mvn}/bin/mvn clean compile"
                }
            }
        }
    }
}
