package com.boneacsu.research.pdf.testapachepdfbox;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "doc")
public class DocumentationConfiguration {
    private String searchFolderPath;
    private int tableOfContentPageNo;

    public String getSearchFolderPath() {
        return searchFolderPath;
    }

    public void setSearchFolderPath(String searchFolderPath) {
        this.searchFolderPath = searchFolderPath;
    }

    public int getTableOfContentPageNo() {
        return tableOfContentPageNo;
    }

    public void setTableOfContentPageNo(int tableOfContentPageNo) {
        this.tableOfContentPageNo = tableOfContentPageNo;
    }
}
