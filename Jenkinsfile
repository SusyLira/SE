pipeline {
  agent any

  tools {
    codeql 'CodeQL'
  }

  stages {
    stage('Checkout') {
      steps {
        script {
          checkout([$class: 'GitSCM', branches: [[name: 'SusyLira-patch-1']], userRemoteConfigs: [[url: 'https://github.com/SusyLira/SE.git']]])
        }
      }
    }

    stage('Initialize CodeQL Database') {
      steps {
        script {
          sh 'codeql database create --language=java /var/lib/jenkins/workspace/codeql/empty'
        }
      }
    }

    stage('Run CodeQL Analysis') {
      steps {
        script {
         sh 'codeql query run --database=my-database security-extended --format=sarif-latest > codeql-results.sarif'
        }
      }
    }
  }
}
    
