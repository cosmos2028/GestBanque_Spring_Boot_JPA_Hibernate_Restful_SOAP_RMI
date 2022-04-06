package org.glsid;

import org.glsid.serviceRMI.BanqueRmiRemote;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class MyConfig 
{
	/*
	 * ENCORE DES PBS SUR SOAP
	 * 
	 * utiliser le JDK 1.8 pour l'utilisation des packages de
	 * jax WS car les version de java au dessus de 1.8 ,les 
	 * packages ont été supprimé
	 
	  @Bean
	    public SimpleJaxWsServiceExporter jaxWsExporter () {
	           
	        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
	         
	        exporter.setBaseAddress("http://localhost:8800/");
	         
	        return exporter;
	    }
	    */
	  @Bean
	  public RmiServiceExporter  getRmiService(ApplicationContext ctx)
	  {
		  RmiServiceExporter exportedRmi = new RmiServiceExporter();
		  //recupere mon objet instancie par spring qui s'appelle myRmiService
		  exportedRmi.setService(ctx.getBean("myRmiService"));
		  exportedRmi.setServiceName("BK");
		  exportedRmi.setRegistryPort(1099);
		  exportedRmi.setServiceInterface(BanqueRmiRemote.class);
		  return exportedRmi;
		  
	  }

}
