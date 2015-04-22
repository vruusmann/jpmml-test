package org.jpmml.test;

import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.transform.stream.StreamResult;

import org.dmg.pmml.DataDictionary;
import org.dmg.pmml.Header;
import org.dmg.pmml.PMML;
import org.jpmml.model.JAXBUtil;

public class Main {

	static
	public void main(String... args) throws Exception {
		PMML pmml = new PMML("4.2", new Header(), new DataDictionary());

		OutputStream os = new FileOutputStream(args[0]);

		try {
			JAXBUtil.marshalPMML(pmml, new StreamResult(os));
		} finally {
			os.close();
		}
	}
}