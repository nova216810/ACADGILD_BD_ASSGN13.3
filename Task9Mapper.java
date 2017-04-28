package mapreduce.demo.task9;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 

public class Task9Mapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	Text outKey = new Text();
	IntWritable outValue = new IntWritable(1);
	
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] words = value.toString().split(" ");
		for (String word : words) {
			outKey.set(word);
			context.write(outKey, outValue);
		}
	}
}
