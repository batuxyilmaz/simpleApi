pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    docker.image('maven:3.8.2-openjdk-11').inside {
                        sh 'mvn clean install'
                    }
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    docker.image('maven:3.8.2-openjdk-11').inside {
                        sh 'mvn test'
                    }
                }
            }
        }

        stage('Package') {
            steps {
                script {
                    docker.image('maven:3.8.2-openjdk-11').inside {
                        sh 'mvn package'
                    }
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("simpleapi:latest")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://hub.docker.com/', 'docker-registry-credentials') {
                        docker.image("simpleapi:latest").push()
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline successful! Deploy your application.'
            // Add deployment steps here
        }
    }
}
