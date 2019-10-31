
package com.example.georef.generales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ct {

	@SerializedName("cc")
	@Expose
	private int cc;
	@SerializedName("cn")
	@Expose
	private String cn;
	@SerializedName("cv")
	@Expose
	private String cv;

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	@Override
	public String toString() {
		return "Ct [cc=" + cc + ", cn=" + cn + ", cv=" + cv + "]";
	}

}
