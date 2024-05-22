package common;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class SendReportNew {
    public static void main(String[] args) {
        // 创建一个TestNG对象
        TestNG testNG = new TestNG();

        // 创建一个测试套件
        XmlSuite suite = new XmlSuite();
        suite.setName("ExampleSuite");

        // 创建一个测试
        XmlTest test = new XmlTest(suite);
        test.setName("ExampleTest");

        // 添加需要运行的测试类
        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass("C:\\Users\\Yi Sun\\IdeaProjects\\test_automation\\src\\test\\java\\login")); // 替换为你的测试类路径
        test.setClasses(classes);

        // 设置测试结果的E-mail属性
        List<String> to = new ArrayList<>();
        to.add("ysun@ecogaragedoors.com.au"); // 接收报告的邮件地址
        String[] ccList = {"ysun@ecogaragedoors.com.au"}; // 可选的抄送地址
        String[] bccList = {"ysun@ecogaragedoors.com.au"}; // 可选的密送地址

        // 发送报告到指定的邮箱
        test.setXmlPackages("com.yourpackage"); // 替换为你的测试类所在的包路径
        test.addIncludedGroup("your-group"); // 如果你有特定的测试组
        test.setEmailable(true);
        test.setOutputDirectory("test-output"); // 报告将要保存的目录
        test.setEmail(to);
        test.setCclist(ccList);
        test.setBcclist(bccList);

        // 添加套件到TestNG
        suite.addTest(test);
        testNG.setXmlSuites(List.of(suite));

        // 运行测试
        testNG.run();

        // 发送报告邮件
        testNG.generateReports(suite.getOutputDirectory(), null);
    }
}
