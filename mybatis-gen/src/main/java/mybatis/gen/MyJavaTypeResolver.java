/*      
 * 模块编号  
 * 功能描述 
 * 文件名 MyJavaTypeResolver.java  
 * 作者 王磊 
 * 编写日期 2019年3月6日    
 */
package mybatis.gen;

import java.sql.Types;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 * 自定义类型转换器
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class MyJavaTypeResolver extends JavaTypeResolverDefaultImpl {
	public MyJavaTypeResolver() {
		super();
		
		// 将tinyint类型默认转换为Ineger
		super.typeMap.put(Types.TINYINT,
				new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TINYINT",
						new FullyQualifiedJavaType(Integer.class.getName())));
	}
}
