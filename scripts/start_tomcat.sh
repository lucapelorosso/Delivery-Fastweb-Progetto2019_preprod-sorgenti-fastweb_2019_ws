#!/bin/bash
path_base='/opt/tomcat/webapps'

echo -e "\nStart apache ..."
sudo rm -rf $path_base/work/*
sudo chown tomcat:tomcat -R $path_base
sudo systemctl start tomcat
sudo systemctl restart awslogsd
echo -e "\ncompleted\n"