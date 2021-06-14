package com.github.kevinmcp123.guicedemo;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceDemoApplication {

	public static void main( String[] args ) {
		Injector injector = Guice.createInjector( new BasicModule() );
		DefaultCommunicator comms = injector.getInstance( DefaultCommunicator.class );

		comms.sendMessage( "Hello world", CommunicationModel.IM );
		comms.sendMessage( "Hello world", CommunicationModel.EMAIL );
		comms.sendMessage( "Hello world", CommunicationModel.SMS );
	}

}
