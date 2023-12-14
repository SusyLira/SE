pipeline {
    agent any

    environment {
        CODEQL_HOME = tool 'CodeQL'
        CODEQL_DATABASE_PATH = "/var/lib/jenkins/workspace/codeql/empty"
    }

    stages {
        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Build CodeQL Database') {
            steps {
                script {
                    // Create CodeQL database
                    sh """
                        ${CODEQL_HOME}/codeql database create \
                            --language=java \
                            --command "${CODEQL_HOME}/java/tools/autobuild.sh" \
                            --source-root /var/lib/jenkins/workspace/ \
                            --overwrite \
                            ${CODEQL_DATABASE_PATH}
                    """
                }
            }
        }

        stage('Run CodeQL Analysis') {
            steps {
                script {
                    // Run CodeQL analysis (replace 'query.ql' with your actual query file)
                    sh """
                        ${CODEQL_HOME}/codeql query run \
                            --database=${CODEQL_DATABASE_PATH} \
                            /var/lib/jenkins/workspace/codeql/query.ql
                    """
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
