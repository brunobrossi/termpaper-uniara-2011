package com.tcc;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


public class ServicoEnvio {

	private static final String METHOD_NAME = "SendLocation";
	private static final String NAMESPACE = "http://tempuri.org/";
	private static final String URL = "http://10.0.2.2:80/WsCelular.asmx";
	private static final String SOAP_ACTION =  NAMESPACE + METHOD_NAME;

	public ServicoEnvio(double latitude, double longitude, String usuario) {
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		request.addProperty("Lat", String.valueOf(latitude));
		request.addProperty("Long", String.valueOf(longitude));
		request.addProperty("Username", usuario.toLowerCase());

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		try {
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION, envelope);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

}
