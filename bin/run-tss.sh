. ./setenv.sh

cd $PROJECT
echo Project directory is $PROJECT

`$PROJECT/bin/runjade.sh -conf etc/runtime-conf.properties`
