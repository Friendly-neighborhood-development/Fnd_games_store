pipeline {
    agent { docker { image 'gradle:latest' } }
    stages {
        stage('build') {
            steps {
                sh 'gradle --version'
                sh '/home/sergey/work/spring/Fnd_games_store/cart-service gradle build'
            }
        }
    }
}