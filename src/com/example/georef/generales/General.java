
package com.example.georef.generales;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class General {

	@SerializedName("rc")
	@Expose
	private int rc;
	@SerializedName("rs")
	@Expose
	private List<R> rs = null;
	@SerializedName("rp")
	@Expose
	private List<Rp> rp = null;
	@SerializedName("ct")
	@Expose
	private List<Ct> ct = null;
	@SerializedName("st")
	@Expose
	private List<St> st = null;

	public int getRc() {
		return rc;
	}

	public void setRc(int rc) {
		this.rc = rc;
	}

	public List<R> getRs() {
		return rs;
	}

	public void setRs(List<R> rs) {
		this.rs = rs;
	}

	public List<Rp> getRp() {
		return rp;
	}

	public void setRp(List<Rp> rp) {
		this.rp = rp;
	}

	public List<Ct> getCt() {
		return ct;
	}

	public void setCt(List<Ct> ct) {
		this.ct = ct;
	}

	public List<St> getSt() {
		return st;
	}

	public void setSt(List<St> st) {
		this.st = st;
	}

	@Override
	public String toString() {
		return "General [rc=" + rc + ", rs=" + rs + ", rp=" + rp + ", ct=" + ct + ", st=" + st + "]";
	}

}
