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
                            sh "docker build . -t nomelyanenko/membackend:${env.BUILD_NUMBER}"
                        }
                        sh "docker push nomelyanenko/membackend:${env.BUILD_NUMBER}"
                    }
                }

                stage('Build frontend image') {
                    steps {
                        dir("frontend") {
                            sh "docker build . -t nomelyanenko/memfrontend:${env.BUILD_NUMBER}"
                        }
                        sh "docker push nomelyanenko/memfrontend:${env.BUILD_NUMBER}"
                    }
                }
            }
        }

        stage('Deploy to k8s') {
            steps {
                withCredentials([file(credentialsId: 'kubeconfig', variable: 'CONFIG')]) {
					sh "kubectl apply -f k8s-manifests/ingress.yaml --kubeconfig=\"$CONFIG\" -n gitlab"
                    sh "kubectl set image deployment/whatismem-backend backend=nomelyanenko/membackend:${env.BUILD_NUMBER} --kubeconfig=\"$CONFIG\" -n gitlab "
                    sh "kubectl set image deployment/whatismem-frontend frontend=nomelyanenko/memfrontend:${env.BUILD_NUMBER} --kubeconfig=\"$CONFIG\" -n gitlab"
                }
            }
        }

    }
}
