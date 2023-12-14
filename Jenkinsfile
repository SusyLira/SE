pipeline {
    agent any
    environment {
        CODEQL_HOME = tool 'CodeQL'
        CODEQL_JAVA_LIB_PATH = "${CODEQL_HOME}/java/libs"
        CODEQL_DATABASE_PATH = "/var/lib/jenkins/workspace/codeql/"  
    }

    stages {
        
        stage('Build CodeQL Database') {
            steps {
                script {
                    sh """
                        codeql database create \
                        --language=java \
                        --command "${CODEQL_HOME}/java/tools/autobuild.sh" \
                        --source-root ./var/lib/jenkins/workspace/ \
                        --source-root /var/lib/jenkins/workspace/ \
                        ${CODEQL_DATABASE_PATH}
                    """
                }
            }
        }
        stage('Run CodeQL Analysis') {
            steps {
                script {
                    sh "codeql query run --database=${CODEQL_DATABASE_PATH} /var/lib/jenkins/workspace/codeql/query.ql"
                }
            }
        }
    }
}
    post {
        failure {
            echo 'CodeQL analysis failed!'
            // Additional failure handling if needed
        }
        success {
            echo 'CodeQL analysis succeeded!'
            // Additional success handling if needed
        }
    }
}
