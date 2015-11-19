package com.osndroid.cttms.data;

import java.io.OutputStream;
import java.util.Collection;

/**
 * 大数据量导出
 * 
 * @author lisen
 * 
 */
public interface ExportBigData {
	/**
	 * 导出sql查询出的数据,输出为压缩后的格式
	 * 
	 * @param os
	 *            输出流
	 * @param maxRow
	 *            每个excel的最大行数
	 * @param sql
	 *            查询语句
	 * @param sqlParams
	 *            查询参数
	 */
	public void exportToZip(final OutputStream os, final int maxRow,
			final String sql, final Object... sqlParams);

	/**
	 * 导出sql查询出的数据,输出为压缩后的格式
	 * 
	 * @param titles
	 *            标题
	 * @param os
	 *            输出流
	 * @param maxRow
	 *            每个excel的最大行数
	 * @param sql
	 *            查询语句
	 * @param sqlParams
	 *            查询参数
	 */
	public void exportToZip(final Collection<String> titles,
			final OutputStream os, final int maxRow, final String sql,
			final Object... sqlParams);

	public void exportToZip(final String[] titles, final OutputStream os,
			final int maxRow, final String sql, final Object... sqlParams);

	public void exportToZip(final String[] titles, final OutputStream os,
			final String sql, final Object... sqlParams);

	public void exportToZip(final Collection<String> titles,
			final OutputStream os, final String sql, final Object... sqlParams);

	public void exportToZip(final OutputStream os, final String sql,
			final Object... sqlParams);
}
