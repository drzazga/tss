# Agent-based Travel Support System
# Runtime configuration

export PROJECT=/home/dogrizz/sa/tss-1.0-all

# --- configure the following directories ---

export PYTHONDIR=/usr/lib64/python2.6/
export JADEDIR=/home/dogrizz/sa/jade/
export JENADIR=/home/dogrizz/sa/Jena-2.4
export JASTORDIR=/home/dogrizz/sa/jastor
export JDBCDIR=/usr/share/jdbc-postgresql/lib/
export SWTDIR=/usr/share/swt-3.5/lib

# -------------------------------------------

export CLASSPATH=.
for f in $JADEDIR/lib/*.jar
do
	CLASSPATH="$CLASSPATH:$f"
done
for f in $JENADIR/lib/*.jar
do
	CLASSPATH="$CLASSPATH:$f"
done
for f in $JASTORDIR/*.jar
do
	CLASSPATH="$CLASSPATH:$f"
done
for f in $JDBCDIR/*.jar
do
	CLASSPATH="$CLASSPATH:$f"
done
for f in $SWTDIR/*.jar
do
	CLASSPATH="$CLASSPATH:$f"
done
for f in $PROJECT/lib/*.jar
do
	CLASSPATH="$CLASSPATH:$f"
done
export CLASSPATH="$CLASSPATH"
echo "env set"
