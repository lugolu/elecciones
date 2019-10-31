
package com.example.georef.generales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Partido {

	@SerializedName("pc")
	@Expose
	private int pc;
	@SerializedName("pn")
	@Expose
	private String pn;
	@SerializedName("pa")
	@Expose
	private String pa;
	@SerializedName("pi")
	@Expose
	private String pi;
	@SerializedName("rbg")
	@Expose
	private String rbg;

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public String getPn() {
		return pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public String getPa() {
		return pa;
	}

	public void setPa(String pa) {
		this.pa = pa;
	}

	public String getPi() {
		return pi;
	}

	public void setPi(String pi) {
		this.pi = pi;
	}

	public String getRbg() {
		return rbg;
	}

	public void setRbg(String rbg) {
		this.rbg = rbg;
	}

	@Override
	public String toString() {
		return "Partido [pc=" + pc + ", pn=" + pn + ", pa=" + pa + ", pi=" + pi + ", rbg=" + rbg + "]";
	}

}
