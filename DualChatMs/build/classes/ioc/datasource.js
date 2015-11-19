/*
 * 本配置文件声明了整个应用的数据库连接部分。
 */
var ioc = {
	/*
	 * 数据库连接池，采用 Apache 的 BasiceDataSource，具体的配置信息，请视自己本地数据库 情况进行修改
	 */
	dataSource : {
		type : "com.alibaba.druid.pool.DruidDataSource",
		events : {
			create : "init",
			depose : 'close'
		},
		fields : {
//			url : "jdbc:sqlserver://202.102.55.150:1433;DatabaseName=WH_DB",
//			username : "hlkj_wh",
//			password : "HLEaI#ji@!2K9#8I",
			driverClassName:"com.mysql.jdbc.Driver",
			url:"jdbc:mysql://127.0.0.1:3306/pms?useUnicode=true&characterEncoding=utf-8",
			username:"root",
			password:"123321",
			testWhileIdle : true,
			validationQuery : "select 1",
			maxActive : 100
		}
	},

	/*
	 * 这个配置很好理解， args 表示这个对象构造函数的参数。显然，下面的注入方式将调用 new NutDao(dataSource)
	 */
	dao : {
		type : "org.nutz.dao.impl.NutDao",
		args : [ {
			refer : "dataSource"
		} ]
	}
// ..............................................................End Ioc
};