pipeline {
  agent any
  options { timestamps() }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Java: Test (Docker Maven)') {
      steps {
        dir('java') {
          script {
            docker.image('maven:3.9.9-eclipse-temurin-17').inside {
              sh 'mvn -B clean test'
            }
          }
        }
      }
      post {
        always {
          junit 'java/target/surefire-reports/*.xml'
        }
      }
    }

    stage('Python: Test (Docker)') {
      steps {
        dir('python') {
          script {
            docker.image('python:3.12-slim').inside {
              sh 'python -m pip install --upgrade pip'
              sh 'pip install pytest'
              sh 'pytest -q --junitxml=pytest-results.xml'
            }
          }
        }
      }
      post {
        always {
          junit 'python/pytest-results.xml'
        }
      }
    }
  }

  post {
    success { echo 'Pipeline finished: SUCCESS' }
    failure { echo 'Pipeline finished: FAILURE' }
    always  { echo 'Pipeline complete.' }
  }
}
