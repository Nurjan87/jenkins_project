node{
    stage("Update jenkins"){
        properties
        sh "echo Parameter added"
    }
    stage("Install git"){
        sh "ssh ex2-user@${Environment} sudo yum install git  python-pip -y"
    }
    stage("Pull Repo"){
         sh "ssh ec2-user@${Environment} git clone https://github.com/miguelgrinberg/flask-examples.git"
    }
    stage("Install Requirements"){
       // sh "virtualenv /tmp/venv"
       // sh ". /tmp/venv/bin/activate"
       sh "echo Hello"
    }
    stage("Pip Install"){
        sh "ssh ec2-user@${Environment} sudo pip install -r  ~/flask-examples/requirements.txt"
    }
    stage("Run App"){
        sh "python ~/flask-examples/01-hello-world/hello.py"
    }
}