pipeline {
    agent { docker { image 'gradle:latest' } }
    stages {
        stage('build') {
            steps {
                echo 'change directory'
                sh 'cd /home/sergey/.jenkins/workspace/Games-service_pipeline/server/cart-service'
                echo 'directory changed'
                sh 'gradle build'
            }
        }
    }
}