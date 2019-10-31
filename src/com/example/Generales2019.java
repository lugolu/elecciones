
package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.example.georef.generales.Partido;
import com.example.georef.generales.Provincia;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Generales2019 {

	public static void main (String[] args) {
		Gson gson = new GsonBuilder().serializeNulls().create();

		double porcentaje = 0;

		try {
			String dir = "https://www.resultados2019.gob.ar/assets/data/parties.json";
			String responsePartidos = response (dir);

			Type listTypePartido = new TypeToken<List<Partido>>(){ }.getType();
			Type listTypeProvincia = new TypeToken<List<Provincia>>(){ }.getType();

			List<Partido> partidos = gson.fromJson(responsePartidos, listTypePartido);
			Map<Integer, String> map = new HashMap<Integer, String>();

			for (Partido p : partidos) {
				map.put(p.getPc(), p.getPn());
			}

			dir = "https://www.resultados2019.gob.ar/assets/data/regions.json";
			String responseProvincias = response (dir);

			List<Provincia> provincias = new LinkedList<Provincia>();
			List<Provincia> tmp = gson.fromJson(responseProvincias, listTypeProvincia);
			List<Provincia> locales = null;
			List<Provincia> mesas = null;
			//			System.out.println(res);
			Map<String, Provincia> mapProvincias = new HashMap<String, Provincia>();
			for (Provincia p : tmp) {
				mapProvincias.put(p.getC(), p);
				if (p.getCc().length() < 4) {
					System.out.println(p);
					provincias.add(p);
				}
			}

			Provincia seccion = null;
			Provincia circuito = null;

			boolean printProvincia;
			boolean printSeccion;
			boolean printCircuito;
			boolean printLocal;

			for (Provincia provincia : provincias) {
				printProvincia = false;
				/*
				1		Jujuy
				1596	Rio Negro
				1597	Tierra del Fuego
				2		Formosa
				2419	La Pampa
				2420	Catamarca
				3		Santa Cruz
				3204	Salta
				3989	Misiones
				3990	Santa Fe
				3991	Santiago del Estero
				4		Cordoba
				4791	Mendoza
				4792	San Juan
				4793	San Luis
				5		Corrientes
				5586	Neuquen
				5587	Chaco
				5588	Entre Rios
				5589	Ciudad Autónoma de Buenos Aires
				5590	Tucuman
				5591	Chubut
				6		Buenos Aires
				814		La Rioja
				 */
				try {
					if (provincia.getCc().length() < 4) {
						for (String s : provincia.getChd()) {
							printSeccion = false;
							//							System.out.println(s);

							try {
								seccion = mapProvincias.get(s);

								if (seccion.getChd() != null) {
									for (String c : seccion.getChd()) {
										printCircuito = false;

										try {
											circuito = mapProvincias.get(c);

											dir = "https://www.resultados2019.gob.ar/assets/data/" + circuito.getChp();
											String responseLocales = response (dir);
											locales = gson.fromJson(responseLocales, listTypeProvincia);

											//											for (Provincia l : locales) {
											//												printLocal = false;
											//
											//												try {
											//													dir = "https://www.resultados2019.gob.ar/assets/data/" + l.getChp();
											//													String responseMesas = response (dir);
											//													mesas = gson.fromJson(responseMesas, listTypeProvincia);
											//
											//													for (Provincia m : mesas) {
											//														try {
											//															dir = "https://www.resultados2019.gob.ar/assets/data/totalized_results/" + m.getRf();
											//															String responseResultados = response (dir);
											//															General res = gson.fromJson(responseResultados.toString(), General.class);
											//
											//															for (St st : res.getSt()) {
											//																porcentaje = Double.parseDouble(st.getPPer());
											//															}
											//
											//															if (porcentaje < 100D) {
											//																print(printProvincia, printSeccion, printCircuito, printLocal, provincia, seccion, circuito, l, "\t\t\t\tmesa: " + l.getN() + " " + m.getN() + " < 100 (" + porcentaje + ") " + dir);
											//																printProvincia = true;
											//																printSeccion = true;
											//																printCircuito = true;
											//																printLocal = true;
											//															}
											//														} catch (IOException ex) {
											//															print(printProvincia, printSeccion, printCircuito, printLocal, provincia, seccion, circuito, l, "\t\t\t\tmesa: " + l.getN() + " " + m.getN() + " " + dir);
											//															printProvincia = true;
											//															printSeccion = true;
											//															printCircuito = true;
											//															printLocal = true;
											//														}
											//													}
											//												} catch (Exception e) {
											//													e.printStackTrace();
											//													System.err.println("."+l+".");
											//												}
											//												//												System.out.println(instances);
											//											}
										} catch (Exception e) {
											e.printStackTrace();
											System.err.println(provincia.getN() + " " + seccion.getN() + "."+circuito+".");
										}
										//										System.out.println(instances);
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
								System.err.println(provincia.getN() + " " + "."+seccion+".");
							}
							System.out.println(provincia.getN() + " " + seccion.getN() + " " + instances);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(provincia);
				}
				System.out.println(provincia.getN() + " " + instances);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void print(boolean printProvincia, boolean printSeccion, boolean printCircuito, boolean printLocal,
			Provincia p, Provincia seccion, Provincia circuito, Provincia local, String string) {
		if (!printProvincia) {
			System.out.println(p.getN());
		}
		if (!printSeccion) {
			System.out.println("\t" + seccion.getN());
		}
		if (!printCircuito) {
			System.out.println("\t\t" + circuito.getN());
		}
		if (!printLocal) {
			System.out.println("\t\t\t" + local.getN());
		}

		System.err.println(string);
	}

	private static long instances;
	private static String response(String dir) throws IOException {
		instances++;

		URL url = new URL(dir);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuffer response = new StringBuffer();

		String inputLine = null;

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}

		//		System.out.println(response.length());

		return response.toString();
	}

	private static String lpad (int number, int pos) {
		if (number < 10) {
			return "0" + number;
		} else {
			return "" + number;
		}
	}

}
