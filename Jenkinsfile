pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Build CodeQL Database') {
            steps {
                script {
                    def codeqlCommand = "${tool 'CodeQL'}/codeql"

                    sh """
                        ${codeqlCommand} database create \
                        --language=java \
                        --command "${codeqlCommand} java autobuild" \
                        --source-root /var/lib/jenkins/workspace/ \
                        --output /var/lib/jenkins/workspace/codeql/ \
                        --overwrite
                    """
                }
            }
        }

        stage('Run CodeQL Analysis') {
            steps {
                script {
                    def codeqlCommand = "${tool 'CodeQL'}/codeql"

                    sh """
                        ${codeqlCommand} query run \
                        --database=/var/lib/jenkins/workspace/codeql/ \
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
