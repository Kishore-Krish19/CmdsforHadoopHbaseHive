#!/bin/bash

# HBase installation

# Check for hadoop version
echo "Checking Hadoop version"
hadoop version

# This link is for 2.5.12
echo "Downloading HBase tar file"
wget https://dlcdn.apache.org/hbase/2.5.12/hbase-2.5.12-bin.tar.gz

echo "Extracting and installing hbase"
tar -xzvf hbase-2.5.12-bin.tar.gz

echo "Move hbase to /usr/local/hbase"
sudo mv hbase-2.5.12 /usr/local/hbase

# nano ~/.bashrc
echo "Setting HBase environmental variables..."
# Set HBase Variables
echo 'export HBASE_HOME=/usr/local/hbase' >> ~/.bashrc
echo 'export PATH=$PATH:$HBASE_HOME/bin' >> ~/.bashrc

source ~/.bashrc
echo "HBase environment variables set."

# nano $HBASE_HOME/conf/hbase-env.sh

echo "Configure hbase-env.sh..."

echo 'export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64' >> $HBASE_HOME/conf/hbase-env.sh
echo 'export HBASE_MANAGES_ZK=true' >> $HBASE_HOME/conf/hbase-env.sh

echo "Configure hbase-site.xml"
# nano $HBASE_HOME/conf/hbase-site.xml
cat <<EOL > $HBASE_HOME/conf/hbase-site.xml
<configuration>
    <property>
        <name>hbase.cluster.distributed</name>
        <value>true</value>
    </property>
    <property>
        <name>hbase.rootdir</name>
        <value>hdfs://localhost:9000/hbase</value>
    </property>
</configuration>
EOL

echo "Starting Hadoop..."
start-all.sh
echo "Starting HBase..."
start-hbase.sh
jps

