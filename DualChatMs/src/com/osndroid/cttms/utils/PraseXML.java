package com.osndroid.cttms.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import com.alibaba.druid.util.StringUtils;

/**
 * dom4j解析
 * @author OsnDroid
 *
 */
public class PraseXML {

	/**
	 * 查询某个节点
	 * @param param
	 * @param list
	 * @return
	 */
	public static String getParamer(String param,List<Map<String, String>> list)
	{
		String msgType = "";
		for (Map<String, String> map : list) {
			for (String str : map.keySet()) {
				if (str.equals(param)) {
					msgType = map.get(param);
					break;
				}
			}
		}
		return msgType;
	}
	
	/**
	 * 遍历所有节点
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public static List<Map<String, String>> iterateWholeXML(String xml) throws Exception {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		if(StringUtils.isEmpty(xml)) return list;
	    Document document = DocumentHelper.parseText(xml);
	    Element root = document.getRootElement();
		recursiveNode(root, list);
		return list;
	}
	
	/**
	 * 递归查找各节点
	 * @param root 父节点
	 * @param list
	 */
	private static void recursiveNode(Element root,List<Map<String, String>> list) {
			for (@SuppressWarnings("unchecked")
			Iterator<Element> iter = root.elementIterator(); iter.hasNext();) {
				HashMap<String, String> map = new HashMap<String, String>();
				Element element = (Element) iter.next();
				if (element == null)
					continue;
				for (@SuppressWarnings("rawtypes")
				Iterator attrs = element.attributeIterator(); attrs.hasNext();) {
					Attribute attr = (Attribute) attrs.next();
					if (attr == null)
						continue;
					String attrName = attr.getName();
					String attrValue = attr.getValue();
					map.put(attrName, attrValue);
				}
				// 如果有PCDATA，则直接提出
				if (element.isTextOnly()) {
					String innerName = element.getName();
					String innerValue = element.getText();
					map.put(innerName, innerValue);
					list.add(map);
				} else {
					list.add(map);
					// 递归调用
					recursiveNode(element, list);
				}
			}
		}
	
}
