package com.lowagie.text.pdf;

import java.io.ByteArrayOutputStream;

import org.junit.Before;
import org.junit.Test;

public class AcroFieldsTest {
    
	@Before
	public void createOpututDir() {
		PdfTestBase.createOutputDir();
	}
    @Test
    public void testSetFields() throws Exception {
        singleTest(PdfTestBase.RESOURCES_DIR +"register.xfdf");
    }

    @Test
    public void testListInSetFields() throws Exception {
        singleTest(PdfTestBase.RESOURCES_DIR +"list_register.xfdf");
    }
    
    private void singleTest(String xfdfFileName) throws Exception {
        // merging the FDF file
        PdfReader pdfreader = new PdfReader(PdfTestBase.RESOURCES_DIR +"SimpleRegistrationForm.pdf");
        PdfStamper stamp = new PdfStamper(pdfreader, new ByteArrayOutputStream());
        XfdfReader fdfreader = new XfdfReader(xfdfFileName);
        AcroFields form = stamp.getAcroFields();
        form.setFields(fdfreader);
        stamp.close();
    }
}
