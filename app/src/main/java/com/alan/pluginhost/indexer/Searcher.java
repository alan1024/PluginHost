package com.alan.pluginhost.indexer;

import java.util.LinkedList;
import java.util.logging.Logger;


public class Searcher {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private String indexField;
    private String docDirectory;

    /**
     * @param indexField
     */
    public Searcher(String docDirectory, String indexField) {
        this.docDirectory = docDirectory;
        this.indexField = indexField;
    }

    public LinkedList<Hit> search(String queryString, boolean classify, int topDocs) {
        LinkedList<Hit> hits = new LinkedList<Hit>();
//		try {
//			File path = new File(indexField);
//			ContactsContract.Directory directory = FSDirectory.open(path);
//			IndexReader reader = IndexReader.open(directory);
//			IndexSearcher seacher = new IndexSearcher(reader);
//			QueryParser query = new QueryParser(Version.LUCENE_35, "content",
//					new IKAnalyzer());
//			DownloadManager.Query q = query.parse(queryString);
//			TopDocs td = seacher.search(q, topDocs);
//			ScoreDoc[] sds = td.scoreDocs;
//			for (ScoreDoc sd : sds) {
//				Hit hit = new Hit();
//				Document d = seacher.doc(sd.doc);
//				hit.setFileName(d.get("filename"));
//				hit.setStartOffset(Long.valueOf(d.get("startOffset")));
//				PagePOJO pojo = JsonReader.read(new File(docDirectory
//						+ File.separator + hit.getFileName()),
//						hit.getStartOffset());
//				if (pojo == null) {
//					hit = null;
//					pojo = null;
//					continue;
//				}
//				hit.setPagePOJO(pojo);
//				if (classify) {
//					hit.setClazz(BayesClassifier.getInstance().classify(
//							hit.getPagePOJO().getContent()));// 写入类别
//				}
//				hits.add(hit);
//			}
//			seacher.close();
//		} catch (IOException e) {
//			logger.error(e.getMessage());
//		} catch (ParseException e) {
//			logger.error(e.getMessage());
//		}
        return hits;
    }

}
