package com.airlync.bigdata.hbase;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.util.Bytes;
public class HbaseHelper {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Configuration conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "192.168.0.36");
		conf.set("hbase.zookeeper.property.clientPort","2181");
		HBaseAdmin admin = new HBaseAdmin(conf);
		HTableDescriptor  desc = new HTableDescriptor(TableName.valueOf("blog"));
		desc.addFamily(new HColumnDescriptor("article"));
		desc.addFamily(new HColumnDescriptor("author"));
		admin.createTable(desc);
		admin.close();		
	}

}
