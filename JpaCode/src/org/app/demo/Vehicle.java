package org.app.demo;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
@Entity
@NamedQueries({
	@NamedQuery(name="UpdateVehicleColorBasedOnNumOfWheels",query="update Vehicle set vehCol=:vk where NoOfWheels between :ns and :mn"),
	@NamedQuery(name="DeleteRecordBasedOnVehnumber", query = "delete from Vehicle where vehNum like 'AP%'"),
	@NamedQuery(name="SelectAll",query="from Vehicle v1")})
   
public class Vehicle implements Serializable {
	@Id
	private String vehNum;
	private int NoOfWheels;
	private String vehCol;
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Vehicle [vehNum=" + vehNum + ", NoOfWheels=" + NoOfWheels + ", vehCol=" + vehCol + "]";
	}
	public Vehicle() {
		super();
	}   
	public String getVehNum() {
		return this.vehNum;
	}

	public void setVehNum(String vehNum) {
		this.vehNum = vehNum;
	}   
	public int getNoOfWheels() {
		return this.NoOfWheels;
	}

	public void setNoOfWheels(int NoOfWheels) {
		this.NoOfWheels = NoOfWheels;
	}   
	public String getVehCol() {
		return this.vehCol;
	}

	public void setVehCol(String vehCol) {
		this.vehCol = vehCol;
	}
   
}
