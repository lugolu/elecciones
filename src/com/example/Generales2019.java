
package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.example.georef.generales.General;
import com.example.georef.generales.Partido;
import com.example.georef.generales.Provincia;
import com.example.georef.generales.R;
import com.example.georef.generales.St;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Generales2019 {

	public static void main (String[] args) {
		Gson gson = new GsonBuilder().serializeNulls().create();

		double porcentaje = 0;

		try {
			String str = "provincia|seccion|circuito|local|mesa|partido/motivo|porcentaje\n";
			write(str, false);

			String dir = "https://www.resultados2019.gob.ar/assets/data/parties.json";
			String responsePartidos = response (dir);

			Type listTypePartido = new TypeToken<List<Partido>>(){ }.getType();
			Type listTypeProvincia = new TypeToken<List<Provincia>>(){ }.getType();

			List<Partido> partidos = gson.fromJson(responsePartidos, listTypePartido);
			Map<Integer, String> map = new HashMap<Integer, String>();

			for (Partido p : partidos) {
				System.out.println(p.getPc() + "\t" + p.getPn());
				map.put(p.getPc(), p.getPn());
			}

			dir = "https://www.resultados2019.gob.ar/assets/data/regions.json";
			String responseProvincias = response (dir);

			List<Provincia> provincias = new LinkedList<Provincia>();
			List<Provincia> tmp = gson.fromJson(responseProvincias, listTypeProvincia);
			List<Provincia> locales = null;
			List<Provincia> mesas = null;
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

			for (Provincia provincia : provincias) {
				System.out.println(provincia.getN());
				try {
					//					if ("10".equals(provincia.getCc())
					//							|| "16".equals(provincia.getCc())
					//							|| "24".equals(provincia.getCc())
					//							|| "09".equals(provincia.getCc())
					//							|| "11".equals(provincia.getCc())
					//							|| "03".equals(provincia.getCc())
					//							|| "20".equals(provincia.getCc())
					//							|| "17".equals(provincia.getCc())
					//							|| "14".equals(provincia.getCc())
					//							|| "21".equals(provincia.getCc())
					//							|| "22".equals(provincia.getCc())
					//							|| "04".equals(provincia.getCc())
					//							|| "13".equals(provincia.getCc())
					//							|| "18".equals(provincia.getCc())
					//							|| "19".equals(provincia.getCc())
					//							|| "05".equals(provincia.getCc())
					//							|| "15".equals(provincia.getCc())
					//							|| "06".equals(provincia.getCc())
					//							|| "08".equals(provincia.getCc())
					//							|| "01".equals(provincia.getCc())
					//							|| "23".equals(provincia.getCc())
					//							|| "07".equals(provincia.getCc())
					//							|| "02".equals(provincia.getCc())
					//							|| "12".equals(provincia.getCc())
					//							) {
					//						continue;
					//					}

					if (provincia.getCc().length() < 4) {
						for (String s : provincia.getChd()) {
							try {
								seccion = mapProvincias.get(s);

								if (seccion.getChd() != null) {
									for (String c : seccion.getChd()) {

										try {
											circuito = mapProvincias.get(c);

											dir = "https://www.resultados2019.gob.ar/assets/data/" + circuito.getChp();
											String responseLocales = response (dir);
											locales = gson.fromJson(responseLocales, listTypeProvincia);

											for (Provincia l : locales) {

												try {
													dir = "https://www.resultados2019.gob.ar/assets/data/" + l.getChp();
													String responseMesas = response (dir);
													mesas = gson.fromJson(responseMesas, listTypeProvincia);

													for (Provincia m : mesas) {
														try {
															dir = "https://www.resultados2019.gob.ar/assets/data/totalized_results/" + m.getRf();
															String responseResultados = response (dir);
															General res = gson.fromJson(responseResultados.toString(), General.class);


															for (St st : res.getSt()) {
																porcentaje = Double.parseDouble(st.getPPer());
															}

															if (porcentaje < 100D) {
																print(provincia.getN(), seccion.getN(), circuito.getN(), l.getN(), m.getN(), "INCIDENCIA", porcentaje);
															}
															else {
																for (R r : res.getRs()) {
																	if (r.getCc() == 845) {
																		if ((r.getPc() == 4 || r.getPc() == 66) && (r.getPorc() > 75D || r.getPorc() < 20D)) {
																			print(provincia.getN(), seccion.getN(), circuito.getN(), l.getN(), m.getN(), map.get(r.getPc()), r.getPorc());
																		}
																	}
																}
															}
														} catch (IOException ex) {
															print(provincia.getN(), seccion.getN(), circuito.getN(), l.getN(), m.getN(), ex.getMessage(), 0D);
														}
													}
												} catch (Exception ex) {
													print(provincia.getN(), seccion.getN(), circuito.getN(), l.getN(), "", ex.getMessage(), 0D);
												}
											}
										} catch (Exception ex) {
											print(provincia.getN(), seccion.getN(), circuito.getN(), "", "", ex.getMessage(), 0D);
										}
									}
								}
							} catch (Exception ex) {
								print(provincia.getN(), seccion.getN(), "", "", "", ex.getMessage(), 0D);
							}
							System.out.println(instances);
						}
					}
				} catch (Exception ex) {
					print(provincia.getN(), "", "", "", "", ex.getMessage(), 0D);
				}
				System.out.println(instances);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void print(String provincia, String seccion, String circuito, String local, String mesa, String partido, double porcentaje) {
		String s = provincia + "|" + seccion + "|" + circuito + "|" + local + "|" + mesa + "|" + partido + "|" + porcentaje;
		write(s + "\n", true);
	}

	private static long instances;
	private static String response(String dir) throws IOException, InterruptedException {
		instances++;

		if ((instances % 50) == 0) {
			System.out.print(".");
		}

		for (int i=0; i<100; i++) {
			try {
				URL url = new URL(dir);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();

				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				StringBuffer response = new StringBuffer();

				String inputLine = null;

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

				if (i > 0) {
					System.out.println();
				}

				return response.toString();
			} catch (Exception e) {
				if (e.getMessage().contains("403 for URL")) {
					throw new IOException("SIN RESULTADOS");
				}
				System.out.print(":");
				Thread.sleep(1000);
			}
		}

		System.out.println(dir);
		throw new IOException("TIMEOUT");
	}

	private static void write (String s, boolean append) {
		File logFile = new File("incidencias.txt");

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, append)))
		{
			bw.write(s);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
