package com.alan.pluginhost.main;

public class MainClass {
    private static final String rootPath = "hdfs://gs-pc:9000/home/test/";
    private static String dst = rootPath + "qq.txt";//首页的链接暂存地
    private static int depth = 3;//深度
    private static int topN = 80;//每页抓取的最大链接数
    private static String outputPath = rootPath + "output";//最终结果的输出路径
    private static String jobName = "DistributeCrawler";//Job的名称

    /**
     * @author gaoshen
     * Mapper类
     */
//	public static class CrawlMapper extends
//			Mapper<LongWritable, Text, NullWritable, Text> {
//		public void map(LongWritable key, Text value, Context context)
//				throws IOException, InterruptedException {
//			String r = "";
//			Crawler c = new Crawler(key.toString(),value.toString(), topN,depth);// 以Input文件的行偏移量作为crawler的id
//			for (String s : c.start()) {
//				r += s + "\r";// 向context中写入Json
//			}
//			if (!r.equals("")) {
//				context.write(NullWritable.get(), new Text(r));
//			}
//		}
//	}
    public static void main(String[] args) throws Exception {
//		Configuration conf = new Configuration();
//		FileSystem fs = FileSystem.get(conf);
//		if (fs.exists(new Path(outputPath))) {//如果输出路径存在的话，删除他。
//			fs.delete(new Path(outputPath), true);
//		}
//		ExternalJARAdder adder = new ExternalJARAdder(fs, conf);
//		adder.add(rootPath+"libs/gson-2.2.4.jar");
//		Job job = new Job(conf, jobName);
//		job.setJarByClass(MainClass.class);
//		job.setMapperClass(CrawlMapper.class);
//		job.setOutputKeyClass(NullWritable.class);
//		job.setOutputValueClass(Text.class);
//		FileInputFormat.addInputPath(job, new Path(dst));
//		FileOutputFormat.setOutputPath(job, new Path(outputPath));
//		System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
