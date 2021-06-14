package com.github.kevinmcp123.guicedemo;

import java.util.logging.Logger;

import com.google.inject.Inject;

class IMCommunicationMode implements CommunicationMode {

	@Inject
	private Logger logger;

	@Override
	public CommunicationModel getMode() {
		return CommunicationModel.IM;
	}

	@Override
	@MessageSentLoggable
	public boolean sendMessage( String Message ) {
		logger.info( this.getMode() + ": message sent" );
		return true;
	}

}