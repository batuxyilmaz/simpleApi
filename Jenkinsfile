pipeline {
    agent any
tools{
    maven 'maven'
}
    stages {
        stage('Build Maven') {
            steps {
                checkout scm Git(branches:[[name:'*main']],extansions:[],userRemoteConfigs:[[url:'https://github.com/batuxyilmaz/simpleApi']])
                sh 'mvn clean install'
            }
        }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t simpleapi:0.0.1 .'
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker_hub_id', passwordVariable: 'password_pass', usernameVariable: 'user_name')]) {
                        sh 'docker login -u batuxyilmaz -p ${password_pass}'
                    }
                    sh 'docker push batuxyilmaz/simpleapi:0.0.1'
                }
            }
        }

      
        }
    }
}
