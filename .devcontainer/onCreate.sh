#! /bin/bash

### Maven Bash Completion ###
curl -sSL --connect-timeout 10 --max-time 15 https://raw.github.com/juven/maven-bash-completion/master/bash_completion.bash >> ~/.bashrc || echo "No se pudo descargar bash_completion"
######