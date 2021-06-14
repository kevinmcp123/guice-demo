package com.github.kevinmcp123.guicedemo;

public enum CommunicationModel {

	EMAIL( "Email" ),
	SMS( "SMS" ),
	IM( "IM" ),
	PHONE( "Phone" );

	final String name;

	CommunicationModel( String name ) {
		this.name = name;
	}
}