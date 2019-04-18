package com.boneacsu.research.pdf.testapachepdfbox;

import com.boneacsu.research.pdf.testapachepdfbox.extractors.IPDFTextExtractor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApachePdfBoxApplicationTests {

	@Autowired
	@Qualifier("tika")
	IPDFTextExtractor tika;

	@Autowired
	@Qualifier("box")
	IPDFTextExtractor box;

	@Autowired
	DocumentationConfiguration configuration;

	@Test
	public void contextLoads() throws IOException {
		Assert.assertNotNull(tika);
		Assert.assertNotNull(box);

		Assert.assertEquals(IPDFTextExtractor.TIKA, tika.getLibraryName());
		Assert.assertEquals(IPDFTextExtractor.BOX, box.getLibraryName());

		//assume is dir
		File dir = new File(configuration.getSearchFolderPath());
		File[] directoryListing = dir.listFiles();

		if (directoryListing != null) {
			for (File pdfFile : directoryListing) {
				Assert.assertEquals(box.getListOfContents(pdfFile), tika.getListOfContents(pdfFile));
			}
		}
	}

}
