package client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import domain.Product;
import webservices.ProductsManager;


import java.net.URL;

public class WSConsumer {

	public static void main(String[] args) throws  Exception{

		URL wsdlUrl = new URL("http://localhost:2020/webservices/ProductsManager");
		QName serviceName = new QName("http://webservices/","ProductsManagerImplService");
		Service serviceClient = Service.create(wsdlUrl,serviceName);
		ProductsManager  portProxy = serviceClient.getPort(ProductsManager.class);
		Product product = new Product(1l,"p1",111d);
		portProxy.addProduct(product);
		System.out.println(portProxy.getProductPrice(1l));

	}
}
