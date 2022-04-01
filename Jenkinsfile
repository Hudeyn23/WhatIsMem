pipeline {
    agent any

    tools {
        jdk 'openjdk-17'
        nodejs 'nodejs-17.8'
    }

    stages {
        stage('Build'){
            parallel {
                stage('Build backend') {
                    environment {
                        mvn = tool 'maven-3.8.5'
                    }

                    steps {
                        dir("backend") {
                            sh "${mvn}/bin/mvn package"
                        }
                    }
                }

                stage('Build frontend') {
                    steps {
                        dir("frontend") {
                            script {
                                sh "npm install"
                                sh "npm run build"
                                sh "ls"
                            }
                        }
                    }
                }

                stage('Login in registry') {
                    steps {
                        withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'password', usernameVariable: 'user')]) {
                            sh "docker login -u ${env.user} -p ${env.password}"
                        }
                    }
                }
            }
        }

        stage('Images') {
            parallel {
                stage('Build backend image') {
                    steps {
                        dir("backend") {
                            sh "docker build . -t nomelyanenko/membackend:main"
                        }
                        sh "docker push nomelyanenko/membackend:main"
                    }
                }

                stage('Build frontend image') {
                    steps {
                        dir("frontend") {
                            sh "docker build . -t nomelyanenko/memfrontend:main"
                        }
                        sh "docker push nomelyanenko/memfrontend:main"
                    }
                }
                tage('Deploy to k8s') {
                    steps {
                        withCredentials([file(credentialsId: 'kubeconfig', variable: 'CONFIG')]) {
                            sh "kubectl set image deployment/whatismem-backend backend=nomelyanenko/membackend:main —kubeconfig=\\\"$CONFIG\\\" -n gitlab "
                            sh "kubectl set image deployment/whatismem-frontend frontend=nomelyanenko/memfrontend:main —kubeconfig=\\\"$CONFIG\\\" -n gitlab"
                        }
                    }
                }
            }
        }

    }
}