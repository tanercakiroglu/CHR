package com.chrental.conf;

import org.glassfish.jersey.server.ResourceConfig;

public class Rc extends ResourceConfig {

	public Rc(){
		packages("com.chrental.service");
		//register(MoxyJsonFeature.class);
	}
}
