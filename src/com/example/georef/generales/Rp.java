
package com.example.georef.generales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rp {

	@SerializedName("cc")
	@Expose
	private int cc;
	@SerializedName("pc")
	@Expose
	private int pc;
	@SerializedName("v")
	@Expose
	private int v;
	@SerializedName("tot")
	@Expose
	private int tot;
	@SerializedName("per")
	@Expose
	private String per;
	@SerializedName("pp")
	@Expose
	private int pp;
	@SerializedName("dw")
	@Expose
	private int dw;

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public String getPer() {
		return per;
	}

	public void setPer(String per) {
		this.per = per;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public int getDw() {
		return dw;
	}

	public void setDw(int dw) {
		this.dw = dw;
	}

	public Double getPorc () {
		return Double.parseDouble(getPer());
	}

	@Override
	public String toString() {
		return "Rp [cc=" + cc + ", pc=" + pc + ", v=" + v + ", tot=" + tot + ", per=" + per + ", pp=" + pp + ", dw="
				+ dw + "]";
	}

}
