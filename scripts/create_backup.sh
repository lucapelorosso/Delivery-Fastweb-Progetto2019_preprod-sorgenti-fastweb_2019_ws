#!/bin/bash
path_base='/opt/tomcat'
now=$(date +"%Y%m%d-%H%M")

alias cp="cp"
unalias cp

sudo mkdir /opt/tomcat
#sudo cp -R $path_base/webapps/configuration/wsdl/ $path_base/webapps/configuration/wsdl_$now
#sudo rm -R $path_base/webapps/configuration/wsdl/
#sudo mkdir $path_base/webapps/configuration/wsdl

#per tutti i file war
if [ -f "$path_base/webapps/FW19WhiteList.war" ]; then
	echo -e "\nFW19WhiteList perform backup"	
	cp -rf $path_base/webapps/FW19WhiteList.war $path_base/webapps/FW19WhiteList.war_$now
fi

echo -e "\ncompleted\n"