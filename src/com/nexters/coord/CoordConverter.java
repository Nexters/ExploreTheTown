package com.nexters.coord;


public class CoordConverter {

	// "Initialize the TMS Global Mercator pyramid"
		static int c = 4962000;
		static int tileSize = 256;
		static double originShift = 2 * Math.PI * c / 2.0;

		/**
		 * Converts given lat/lng in WGS84 Datum to XY in Spherical Mercator
		 * EPSG:900913
		 * 
		 * @param lat
		 * @param lng
		 * @return
		 */
		
		public static PointF wgs2m(double lng, double lat) {
		double mx = lng * originShift / 180.0;
		double my = Math.log(Math.tan((90 + lat) * Math.PI / 360.0))
				/ (Math.PI / 180.0);
		my = my * originShift / 180.0;
		return new PointF(mx, my);
	}
	public static PointF m2wgs(double mx, double my) {
		//shift
		PointF point = wgs2m(127, 38);
		mx = point.x - 200000 + mx;
		my = point.y - 500000 + my;
		
		double lng = mx * 180.0 / originShift;
		double lat = Math.atan(Math.pow(Math.E, my * Math.PI / originShift))
				/ Math.PI * 360.0 - 90;
		lat -= 0.001;
		lng += 0.003;
		return new PointF(lat, lng);
	}
}
