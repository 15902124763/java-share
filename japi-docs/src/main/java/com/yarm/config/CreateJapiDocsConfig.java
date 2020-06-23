package com.yarm.config;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import io.github.yedaxia.apidocs.plugin.markdown.MarkdownDocPlugin;

public class CreateJapiDocsConfig {
    public static void main(String[] args) {
        DocsConfig config = new DocsConfig();
        // 项目根目录
        config.setProjectPath("D:\\develop\\code\\java\\my_default\\java-share-base\\japi-docs");
        // 项目名称
        config.setProjectName("Springboot JapiDocs Demo");
        // 声明该API的版本
        config.setApiVersion("V1.0");
        // 生成API 文档所在目录
        config.setDocsPath("D:\\document\\japi_docs_demo");
        // 配置自动生成
        config.setAutoGenerate(Boolean.TRUE);
        // 执行生成文档
//        Docs.buildHtmlDocs(config);
        config.addPlugin(new MarkdownDocPlugin());
        Docs.buildHtmlDocs(config);
    }
}
