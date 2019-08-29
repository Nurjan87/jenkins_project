node{
    stage("Update jenkins"){
        properties([parameters([string(defaultValue: '54.183.196.208', description: 'this is for dev', name: 'ENVIR', trim: true)])])
        sh "echo Parameter added"
    }
    stage("Install git"){
        sh "ssh ex2-user@${ENVIR} sudo yum install git  python-pip -y"
    }
    stage("Pull Repo"){
         sh "ssh ec2-user@${ENVIR} git clone https://github.com/miguelgrinberg/flask-examples.git"
    }
    stage("Remove repo"){
         sh "ssh ex2-user@${ENVIR} sudo rm -rf /home/ec2-user/flask-examples"   
    }
    stage("Install Requirements"){
       // sh "virtualenv /tmp/venv"
       // sh ". /tmp/venv/bin/activate"
       sh "echo Hello"
    }
    stage("Pip Install"){
        sh "ssh ec2-user@${ENVIR} sudo pip install -r  ~/flask-examples/requirements.txt"
    }
    stage("Run App"){
        sh "python ~/flask-examples/01-hello-world/hello.py"
    }
}