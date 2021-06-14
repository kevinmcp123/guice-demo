package com.github.kevinmcp123.guicedemo;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DefaultCommunicator implements Communicator {

	private CommunicationMode defaultCommsMode;

	@Inject
	Logger logger;
	@Inject
	@Named("SMSComms")
	CommunicationMode smsCommsMode;
	@Inject
	@Named("EmailComms")
	CommunicationMode emailCommsMode;
	@Inject
	@Named("IMComms")
	CommunicationMode imCommsMode;

	protected DefaultCommunicator( CommunicationMode defaultComms ) {
		this.defaultCommsMode = defaultComms;
	}

	public boolean sendMessage( String message ) {
		if ( Objects.nonNull( defaultCommsMode ) ) {
			return defaultCommsMode.sendMessage( message );
		}

		logger.log( Level.WARNING, "Message not sent, no default logger has been set" );
		return false;
	}

	public boolean sendMessage( String message, CommunicationModel model ) {
		switch ( model ) {
		case SMS:
			return smsCommsMode.sendMessage( message );
		case EMAIL:
			return emailCommsMode.sendMessage( message );
		case IM:
			return imCommsMode.sendMessage( message );
		default:
			logger.log( Level.SEVERE, "Not supported: " + model );
			return false;
		}
	}
}