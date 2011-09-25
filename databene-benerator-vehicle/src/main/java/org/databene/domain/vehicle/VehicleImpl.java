package org.databene.domain.vehicle;

public class VehicleImpl implements Vehicle {

	@RegistrationNumber
	private String registration;

	@VehicleModel
	private VehicleModel model;

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(final String registration) {
		this.registration = registration;
	}

	public VehicleModel getModel() {
		return model;
	}

	public void setModel(final VehicleModel model) {
		this.model = model;
	}
}
