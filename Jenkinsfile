pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        script {
          checkout($class: 'GitSCM', branches: [[name: 'SusyLira-patch-1']], userRemoteConfigs: [[url: 'https://github.com/SusyLira/SE.git']]])
        }
      }
    }

    stage('Initialize CodeQL Database') {
      steps {
        script {
          sh 'codeql database create --language=java . --name=my-database'
        }
      }
    }

    stage('Run CodeQL Analysis') {
      steps {
        script {
          
