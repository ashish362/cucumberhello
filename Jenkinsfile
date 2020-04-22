pipeline {
  environment {
    registry = "ashish362/docker-demo"
    registryCredential = 'dockerhub'
    dockerImage = ''
  }
  agent any
     tools {
      // Install the Maven version configured as "M3" and add it to the path.
      jdk "java"
      gradle "gradle"
      org.jenkinsci.plugins.docker.commons.tools.DockerTool "docker"
   }
  stages {
    stage("Build the project") {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew build'
            }
        }
	
 
  stage('Docker Image Build') {
    steps{
      script {
        dockerImage = docker.build registry + ":cucumberhello"
      }
    }
  }

 

  stage('Push Image to DockerHub'){
    steps{
      script {
        docker.withRegistry( '', registryCredential ) {
          dockerImage.push()
        }
      }
    }
  }

 

  stage('Remove Unused docker image') {
    steps{
      sh "docker rmi $registry:cucumberhello"
    }
  }    
}
}