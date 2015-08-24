package org.nlpcn.commons.lang.dic;

import java.io.BufferedReader;
import java.util.HashMap;

import org.nlpcn.commons.lang.tire.domain.Forest;
import org.nlpcn.commons.lang.tire.library.Library;

/**
 * Created by ansj on 4/1/14.
 */
public class DicManager {

	private static final HashMap<String, Forest> forestMap = new HashMap<>();

	/**
	 * 构建一个tire书辞典
	 *
	 * @param dicName
	 * @param dicName
	 * @return
	 * @throws Exception
	 */
	public synchronized static Forest makeForest(String dicName, BufferedReader br) throws Exception {
		Forest forest = null;
		if ((forest = forestMap.get(dicName)) != null) {
			return forest;
		}
		forest = Library.makeForest(br);

		if (dicName != null) {
			forestMap.put(dicName, forest);
		}

		return forest;
	}

	/**
	 * 从内存中移除
	 *
	 * @param dicName
	 * @return
	 */
	public static Forest remove(String dicName) {
		return forestMap.remove(dicName);
	}

	/**
	 * 获得一本辞典
	 *
	 * @param dicName
	 * @return
	 */
	public static Forest getForest(String dicName) {
		return forestMap.get(dicName);
	}

//	private static Forest initRev(String dicName, InputStream is) {
//		BufferedReader reader = null;
//		try {
//			reader = IOUtil.getReader(is, IOUtil.UTF8);
//			Forest forest = new Forest();
//			String temp = null;
//			String[] strs = null;
//			while ((temp = reader.readLine()) != null) {
//				strs = temp.trim().split("\t");
//				if (strs.length != 2) {
//					throw new RuntimeException("error arg by init " + dicName + "\t" + strs.length);
//				}
//				Library.insertWord(forest, new Value(strs[1], strs[0]));
//			}
//			return forest;
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (reader != null) {
//				try {
//					reader.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return null;
//	}
//
//	private static Forest init(String dicName, InputStream is) {
//		return init(dicName, new BufferedReader(new InputStreamReader(is)));
//	}
//
//	private static Forest init(String dicName, BufferedReader br) {
//		try {
//			return makeForest(dicName, br);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			if (br != null) {
//				try {
//					br.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}
}
