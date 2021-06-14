package com.github.kevinmcp123.guicedemo;

import java.util.logging.Logger;

import com.google.inject.Inject;

public class Communication {

	@Inject
	private Logger logger;

	@Inject
	private DefaultCommunicator communicator;

	public Communication( Boolean keepRecords ) {
		if ( keepRecords ) {
			System.out.println( "keeping records" );
		}
	}

	public boolean sendMessage( String message ) {
		return communicator.sendMessage( message );
	}

	public DefaultCommunicator getCommunicator() {
		return this.communicator;
	}

}