. ./setenv.sh
export SERVER="$PROJECT/templates/"
export RUN_RACCOON="$PYTHONDIR/site-packages/rx4rdf-0.6.0-py2.6.egg/rx/raccoon.py"
export CONF="$PROJECT/etc/raccoon-config.py"

echo $SERVER
cd $SERVER
`$RUN_RACCOON -a $CONF`
