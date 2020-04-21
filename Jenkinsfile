pipeline {
  environment {
    registry = "ashish362/docker-demo"
    registryCredential = 'dockerhub'
    dockerImage = ''
  }
  agent any
  stages {
    
 
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