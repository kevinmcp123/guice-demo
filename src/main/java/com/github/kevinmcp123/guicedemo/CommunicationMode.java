package com.github.kevinmcp123.guicedemo;

public interface CommunicationMode {

	CommunicationModel getMode();

	boolean sendMessage( String message );

}