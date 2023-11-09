pipeline {
    agent { docker { image 'gradle:latest' } }
    stages {
        stage('build') {
            steps {
                sh 'gradle --version'
            }
        }
    }
}