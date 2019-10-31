
package com.example.georef.generales;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Provincia {

	@SerializedName("c")
	@Expose
	private String c;
	@SerializedName("cc")
	@Expose
	private String cc;
	@SerializedName("n")
	@Expose
	private String n;
	@SerializedName("tp")
	@Expose
	private String tp;
	@SerializedName("ll")
	@Expose
	private String ll;
	@SerializedName("l")
	@Expose
	private String l;
	@SerializedName("rf")
	@Expose
	private String rf;
	@SerializedName("chp")
	@Expose
	private String chp;
	@SerializedName("chd")
	@Expose
	private List<String> chd = null;
	@SerializedName("cs")
	@Expose
	private List<String> cs = null;
	@SerializedName("cd")
	@Expose
	private Object cd;

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public String getTp() {
		return tp;
	}

	public void setTp(String tp) {
		this.tp = tp;
	}

	public String getLl() {
		return ll;
	}

	public void setLl(String ll) {
		this.ll = ll;
	}

	public String getL() {
		return l;
	}

	public void setL(String l) {
		this.l = l;
	}

	public String getRf() {
		return rf;
	}

	public void setRf(String rf) {
		this.rf = rf;
	}

	public String getChp() {
		return chp;
	}

	public void setChp(String chp) {
		this.chp = chp;
	}

	public List<String> getChd() {
		return chd;
	}

	public void setChd(List<String> chd) {
		this.chd = chd;
	}

	public List<String> getCs() {
		return cs;
	}

	public void setCs(List<String> cs) {
		this.cs = cs;
	}

	public Object getCd() {
		return cd;
	}

	public void setCd(Object cd) {
		this.cd = cd;
	}

	@Override
	public String toString() {
		return "Provincia [c=" + c + ", cc=" + cc + ", n=" + n + ", tp=" + tp + ", ll=" + ll + ", l=" + l + ", rf=" + rf
				+ ", chp=" + chp + ", chd=" + chd + ", cs=" + cs + ", cd=" + cd + "]";
	}

}
