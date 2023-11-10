pipeline {
    agent { docker { image 'gradle:latest' } }
    stages {
        stage('build') {
            steps {
                sh '/home/sergey/.jenkins/workspace/Games-service_pipeline/server/cart-service gradle build'
            }
        }
    }
}