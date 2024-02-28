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
                    sh 'mvn clean install'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t simpleapi .'
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: '	9a9402a7-a913-422d-a023-7d14bbe45009', passwordVariable: 'Desi1234$', usernameVariable: 'batuhan.yilmaz@desi.com.tr')]) {
                        sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                    }
                    sh 'docker push simpleapi'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo 'Building Docker Image'
                    // Your deployment steps go here
                }
            }
        }
    }
}
