package com.osndroid.cttms.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @author OsnDroid
 *
 */
public class HttpUtil {
	/**
	 *http post请求
	 */
	public static final String REQ_POST = "POST";
	/**
	 *http get请求
	 */
	public static final String REQ_GET = "GET";
	
	public static String doHttpReq(String url, String params, String reqMethod) {
		URL u = null;
		HttpURLConnection con = null;
		StringBuffer sb = new StringBuffer();
		sb.append(params);
		try {
			u = new URL(url);
			con = (HttpURLConnection) u.openConnection();
			con.setRequestMethod(reqMethod);
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			if (reqMethod.equals("POST")) {
				OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
				osw.write(sb.toString());
				osw.flush();
				osw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.disconnect();
			}

		}
		StringBuffer buffer = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					con.getInputStream(), "UTF-8"));
			String temp;
			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
				buffer.append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return buffer.toString();
	}
	
	public static void main(String[] args) {
		StringBuilder params = new StringBuilder();
		params.append("p=");
		params.append("323");
		params.append("&it=200");
		params.append("&content=注册增加积分");
		params.append("&area=");
		params.append("343");
		String s = doHttpReq("http://222.221.16.199:8080/yn_wll/AWF.do", params.toString(), REQ_POST);
				System.out.println(s);
	}

}
