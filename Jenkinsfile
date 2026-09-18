
pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Maven Build and Test') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t student-management:1.0 .'
            }
        }

        stage('Deploy Container') {
            steps {
                sh '''
                    docker rm -f student-management-container || true
                    docker run -d \
                        --name student-management-container \
                        -p 8080:8080 \
                        student-management:1.0
                '''
            }
        }

    }

    post {
        success {
            echo 'CI/CD Pipeline completed successfully!'
        }

        failure {
            echo 'CI/CD Pipeline failed!'
        }
    }
}