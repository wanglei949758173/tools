/*      
 * 模块编号  
 * 功能描述 
 * 文件名 App.java  
 * 作者 王磊 
 * 编写日期 2019年3月6日    
 */
package mybatis.gen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class App {
	public static void main(String[] args) {
		List<String> warnings = new ArrayList<>();
		try {
			String configFilePath =
					System.getProperty("user.dir")
							.concat("/src/main/resources/generatorConfig.xml");
			System.out.println("加载配置文件===" + configFilePath);
			boolean overwrite = true;
			File configFile = new File(configFilePath);
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator =
					new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (String warning : warnings) {
			System.out.println(warning);
		}
		System.out.println("生成完成");
	}

}
