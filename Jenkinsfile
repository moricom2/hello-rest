node {
	def dockerID = "moricom"
	def imgName = "moricom/hello-rest:latest"
	def appName = "hello-rest"
	def gitURL = "https://github.com/moricom2/hello-rest.git"
	stage('1. Source Code Pull'){
		git branch:'master', url:gitURL
	}
	stage('2. Source Code Package'){
		sh 'mvn clean package -DskipTests=true'
	}
	stage('3. Source Code JunitTest'){
		sh 'mvn surefire-report:report'
	}            
	stage('4. Container Image Build'){
		sh 'docker build -t ' + imgName + ' .'
	}  	
	stage('5. Container Image Push'){
		sh 'docker login -u ' + dockerID + ' --password-stdin < ~/docker-pass'
		sh 'docker push ' + imgName
	}  	
	stage('6. Container Running'){
		def containerID = sh (script: 'docker ps -aq -f name=' + appName, returnStdout: true)
		if (containerID != '') {
			sh 'docker rm -f ' + containerID
		}
		sh 'docker run -d -p 80:80 --rm --name ' + appName + ' ' + imgName
	}
}
